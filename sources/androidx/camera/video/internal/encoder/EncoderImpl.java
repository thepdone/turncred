package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Range;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.internal.BufferProvider;
import androidx.camera.video.internal.DebugUtils;
import androidx.camera.video.internal.compat.quirk.AudioEncoderIgnoresInputTimestampQuirk;
import androidx.camera.video.internal.compat.quirk.CameraUseInconsistentTimebaseQuirk;
import androidx.camera.video.internal.compat.quirk.CodecStuckOnFlushQuirk;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.EncoderNotUsePersistentInputSurfaceQuirk;
import androidx.camera.video.internal.compat.quirk.PrematureEndOfStreamVideoQuirk;
import androidx.camera.video.internal.compat.quirk.SignalEosOutputBufferNotComeQuirk;
import androidx.camera.video.internal.compat.quirk.StopCodecAfterSurfaceRemovalCrashMediaServerQuirk;
import androidx.camera.video.internal.compat.quirk.VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk;
import androidx.camera.video.internal.encoder.Encoder;
import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.camera.video.internal.utils.CodecUtil;
import androidx.camera.video.internal.workaround.VideoTimebaseConverter;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class EncoderImpl implements Encoder {
    private static final boolean DEBUG = false;
    private static final long NO_LIMIT_LONG = Long.MAX_VALUE;
    private static final Range<Long> NO_RANGE = Range.create(Long.MAX_VALUE, Long.MAX_VALUE);
    private static final long SIGNAL_EOS_TIMEOUT_MS = 1000;
    private static final long STOP_TIMEOUT_MS = 1000;
    final Executor mEncoderExecutor;
    private final EncoderInfo mEncoderInfo;
    final Encoder.EncoderInput mEncoderInput;
    final Timebase mInputTimebase;
    final boolean mIsVideoEncoder;
    final MediaCodec mMediaCodec;
    private final MediaFormat mMediaFormat;
    private final CallbackToFutureAdapter.Completer<Void> mReleasedCompleter;
    private final ListenableFuture<Void> mReleasedFuture;
    private Future<?> mSignalEosTimeoutFuture;
    InternalState mState;
    final String mTag;
    final Object mLock = new Object();
    final Queue<Integer> mFreeInputBufferIndexQueue = new ArrayDeque();
    private final Queue<CallbackToFutureAdapter.Completer<InputBuffer>> mAcquisitionQueue = new ArrayDeque();
    private final Set<InputBuffer> mInputBufferSet = new HashSet();
    final Set<EncodedDataImpl> mEncodedDataSet = new HashSet();
    final Deque<Range<Long>> mActivePauseResumeTimeRanges = new ArrayDeque();
    final TimeProvider mTimeProvider = new SystemTimeProvider();
    EncoderCallback mEncoderCallback = EncoderCallback.EMPTY;
    Executor mEncoderCallbackExecutor = CameraXExecutors.directExecutor();
    Range<Long> mStartStopTimeRangeUs = NO_RANGE;
    long mTotalPausedDurationUs = 0;
    boolean mPendingCodecStop = false;
    Long mLastDataStopTimestamp = null;
    Future<?> mStopTimeoutFuture = null;
    private MediaCodecCallback mMediaCodecCallback = null;
    private boolean mIsFlushedAfterEndOfStream = false;
    private boolean mSourceStoppedSignalled = false;
    boolean mMediaCodecEosSignalled = false;

    enum InternalState {
        CONFIGURED,
        STARTED,
        PAUSED,
        STOPPING,
        PENDING_START,
        PENDING_START_PAUSED,
        PENDING_RELEASE,
        ERROR,
        RELEASED
    }

    public EncoderImpl(Executor executor, EncoderConfig encoderConfig) throws InvalidConfigException {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(encoderConfig);
        MediaCodec mediaCodecCreateCodec = CodecUtil.createCodec(encoderConfig);
        this.mMediaCodec = mediaCodecCreateCodec;
        MediaCodecInfo codecInfo = mediaCodecCreateCodec.getCodecInfo();
        this.mEncoderExecutor = CameraXExecutors.newSequentialExecutor(executor);
        MediaFormat mediaFormat = encoderConfig.toMediaFormat();
        this.mMediaFormat = mediaFormat;
        Timebase inputTimebase = encoderConfig.getInputTimebase();
        this.mInputTimebase = inputTimebase;
        if (encoderConfig instanceof AudioEncoderConfig) {
            this.mTag = "AudioEncoder";
            this.mIsVideoEncoder = false;
            this.mEncoderInput = new ByteBufferInput();
            this.mEncoderInfo = new AudioEncoderInfoImpl(codecInfo, encoderConfig.getMimeType());
        } else if (encoderConfig instanceof VideoEncoderConfig) {
            this.mTag = "VideoEncoder";
            this.mIsVideoEncoder = true;
            this.mEncoderInput = new SurfaceInput();
            VideoEncoderInfoImpl videoEncoderInfoImpl = new VideoEncoderInfoImpl(codecInfo, encoderConfig.getMimeType());
            clampVideoBitrateIfNotSupported(videoEncoderInfoImpl, mediaFormat);
            this.mEncoderInfo = videoEncoderInfoImpl;
        } else {
            throw new InvalidConfigException("Unknown encoder config type");
        }
        Logger.d(this.mTag, "mInputTimebase = " + inputTimebase);
        Logger.d(this.mTag, "mMediaFormat = " + mediaFormat);
        try {
            reset();
            final AtomicReference atomicReference = new AtomicReference();
            this.mReleasedFuture = Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$$ExternalSyntheticLambda8
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return EncoderImpl.lambda$new$0(atomicReference, completer);
                }
            }));
            this.mReleasedCompleter = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference.get());
            setState(InternalState.CONFIGURED);
        } catch (MediaCodec.CodecException e) {
            throw new InvalidConfigException(e);
        }
    }

    static /* synthetic */ Object lambda$new$0(AtomicReference atomicReference, CallbackToFutureAdapter.Completer completer) throws Exception {
        atomicReference.set(completer);
        return "mReleasedFuture";
    }

    private void clampVideoBitrateIfNotSupported(VideoEncoderInfo videoEncoderInfo, MediaFormat mediaFormat) {
        Preconditions.checkState(this.mIsVideoEncoder);
        if (mediaFormat.containsKey("bitrate")) {
            int integer = mediaFormat.getInteger("bitrate");
            int iIntValue = ((Integer) videoEncoderInfo.getSupportedBitrateRange().clamp(Integer.valueOf(integer))).intValue();
            if (integer != iIntValue) {
                mediaFormat.setInteger("bitrate", iIntValue);
                Logger.d(this.mTag, "updated bitrate from " + integer + " to " + iIntValue);
            }
        }
    }

    private void reset() {
        this.mStartStopTimeRangeUs = NO_RANGE;
        this.mTotalPausedDurationUs = 0L;
        this.mActivePauseResumeTimeRanges.clear();
        this.mFreeInputBufferIndexQueue.clear();
        Iterator<CallbackToFutureAdapter.Completer<InputBuffer>> it = this.mAcquisitionQueue.iterator();
        while (it.hasNext()) {
            it.next().setCancelled();
        }
        this.mAcquisitionQueue.clear();
        this.mMediaCodec.reset();
        this.mIsFlushedAfterEndOfStream = false;
        this.mSourceStoppedSignalled = false;
        this.mMediaCodecEosSignalled = false;
        this.mPendingCodecStop = false;
        Future<?> future = this.mStopTimeoutFuture;
        if (future != null) {
            future.cancel(true);
            this.mStopTimeoutFuture = null;
        }
        Future<?> future2 = this.mSignalEosTimeoutFuture;
        if (future2 != null) {
            future2.cancel(false);
            this.mSignalEosTimeoutFuture = null;
        }
        MediaCodecCallback mediaCodecCallback = this.mMediaCodecCallback;
        if (mediaCodecCallback != null) {
            mediaCodecCallback.stop();
        }
        MediaCodecCallback mediaCodecCallback2 = new MediaCodecCallback();
        this.mMediaCodecCallback = mediaCodecCallback2;
        this.mMediaCodec.setCallback(mediaCodecCallback2);
        this.mMediaCodec.configure(this.mMediaFormat, (Surface) null, (MediaCrypto) null, 1);
        Encoder.EncoderInput encoderInput = this.mEncoderInput;
        if (encoderInput instanceof SurfaceInput) {
            ((SurfaceInput) encoderInput).resetSurface();
        }
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public Encoder.EncoderInput getInput() {
        return this.mEncoderInput;
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public EncoderInfo getEncoderInfo() {
        return this.mEncoderInfo;
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public int getConfiguredBitrate() {
        if (this.mMediaFormat.containsKey("bitrate")) {
            return this.mMediaFormat.getInteger("bitrate");
        }
        return 0;
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void start() {
        final long jGeneratePresentationTimeUs = generatePresentationTimeUs();
        this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m291x86ab6b23(jGeneratePresentationTimeUs);
            }
        });
    }

    /* renamed from: lambda$start$1$androidx-camera-video-internal-encoder-EncoderImpl, reason: not valid java name */
    /* synthetic */ void m291x86ab6b23(long j) {
        switch (this.mState) {
            case CONFIGURED:
                this.mLastDataStopTimestamp = null;
                Logger.d(this.mTag, "Start on " + DebugUtils.readableUs(j));
                try {
                    if (this.mIsFlushedAfterEndOfStream) {
                        reset();
                    }
                    this.mStartStopTimeRangeUs = Range.create(Long.valueOf(j), Long.MAX_VALUE);
                    this.mMediaCodec.start();
                    Encoder.EncoderInput encoderInput = this.mEncoderInput;
                    if (encoderInput instanceof ByteBufferInput) {
                        ((ByteBufferInput) encoderInput).setActive(true);
                    }
                    setState(InternalState.STARTED);
                    return;
                } catch (MediaCodec.CodecException e) {
                    handleEncodeError(e);
                    return;
                }
            case STARTED:
            case PENDING_START:
            case ERROR:
                return;
            case PAUSED:
                this.mLastDataStopTimestamp = null;
                Range<Long> rangeRemoveLast = this.mActivePauseResumeTimeRanges.removeLast();
                Preconditions.checkState(rangeRemoveLast != null && ((Long) rangeRemoveLast.getUpper()).longValue() == Long.MAX_VALUE, "There should be a \"pause\" before \"resume\"");
                long jLongValue = ((Long) rangeRemoveLast.getLower()).longValue();
                this.mActivePauseResumeTimeRanges.addLast(Range.create(Long.valueOf(jLongValue), Long.valueOf(j)));
                Logger.d(this.mTag, "Resume on " + DebugUtils.readableUs(j) + "\nPaused duration = " + DebugUtils.readableUs(j - jLongValue));
                if ((this.mIsVideoEncoder || DeviceQuirks.get(AudioEncoderIgnoresInputTimestampQuirk.class) == null) && (!this.mIsVideoEncoder || DeviceQuirks.get(VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk.class) == null)) {
                    setMediaCodecPaused(false);
                    Encoder.EncoderInput encoderInput2 = this.mEncoderInput;
                    if (encoderInput2 instanceof ByteBufferInput) {
                        ((ByteBufferInput) encoderInput2).setActive(true);
                    }
                }
                if (this.mIsVideoEncoder) {
                    requestKeyFrameToMediaCodec();
                }
                setState(InternalState.STARTED);
                return;
            case STOPPING:
            case PENDING_START_PAUSED:
                setState(InternalState.PENDING_START);
                return;
            case PENDING_RELEASE:
            case RELEASED:
                throw new IllegalStateException("Encoder is released");
            default:
                throw new IllegalStateException("Unknown state: " + this.mState);
        }
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void stop() {
        stop(-1L);
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void stop(final long j) {
        final long jGeneratePresentationTimeUs = generatePresentationTimeUs();
        this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m294lambda$stop$4$androidxcameravideointernalencoderEncoderImpl(j, jGeneratePresentationTimeUs);
            }
        });
    }

    /* renamed from: lambda$stop$4$androidx-camera-video-internal-encoder-EncoderImpl, reason: not valid java name */
    /* synthetic */ void m294lambda$stop$4$androidxcameravideointernalencoderEncoderImpl(long j, long j2) {
        switch (this.mState) {
            case CONFIGURED:
            case STOPPING:
            case ERROR:
                return;
            case STARTED:
            case PAUSED:
                InternalState internalState = this.mState;
                setState(InternalState.STOPPING);
                long jLongValue = ((Long) this.mStartStopTimeRangeUs.getLower()).longValue();
                if (jLongValue == Long.MAX_VALUE) {
                    throw new AssertionError("There should be a \"start\" before \"stop\"");
                }
                if (j == -1) {
                    j = j2;
                } else if (j < jLongValue) {
                    Logger.w(this.mTag, "The expected stop time is less than the start time. Use current time as stop time.");
                    j = j2;
                }
                if (j < jLongValue) {
                    throw new AssertionError("The start time should be before the stop time.");
                }
                this.mStartStopTimeRangeUs = Range.create(Long.valueOf(jLongValue), Long.valueOf(j));
                Logger.d(this.mTag, "Stop on " + DebugUtils.readableUs(j));
                if (internalState == InternalState.PAUSED && this.mLastDataStopTimestamp != null) {
                    signalCodecStop();
                    return;
                } else {
                    this.mPendingCodecStop = true;
                    this.mStopTimeoutFuture = CameraXExecutors.mainThreadExecutor().schedule(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$$ExternalSyntheticLambda17
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m293lambda$stop$3$androidxcameravideointernalencoderEncoderImpl();
                        }
                    }, 1000L, TimeUnit.MILLISECONDS);
                    return;
                }
            case PENDING_START:
            case PENDING_START_PAUSED:
                setState(InternalState.CONFIGURED);
                return;
            case PENDING_RELEASE:
            case RELEASED:
                throw new IllegalStateException("Encoder is released");
            default:
                throw new IllegalStateException("Unknown state: " + this.mState);
        }
    }

    /* renamed from: lambda$stop$3$androidx-camera-video-internal-encoder-EncoderImpl, reason: not valid java name */
    /* synthetic */ void m293lambda$stop$3$androidxcameravideointernalencoderEncoderImpl() {
        this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m292lambda$stop$2$androidxcameravideointernalencoderEncoderImpl();
            }
        });
    }

    /* renamed from: lambda$stop$2$androidx-camera-video-internal-encoder-EncoderImpl, reason: not valid java name */
    /* synthetic */ void m292lambda$stop$2$androidxcameravideointernalencoderEncoderImpl() {
        if (this.mPendingCodecStop) {
            Logger.w(this.mTag, "The data didn't reach the expected timestamp before timeout, stop the codec.");
            this.mLastDataStopTimestamp = null;
            signalCodecStop();
            this.mPendingCodecStop = false;
        }
    }

    void signalCodecStop() {
        Logger.d(this.mTag, "signalCodecStop");
        Encoder.EncoderInput encoderInput = this.mEncoderInput;
        if (encoderInput instanceof ByteBufferInput) {
            ((ByteBufferInput) encoderInput).setActive(false);
            ArrayList arrayList = new ArrayList();
            Iterator<InputBuffer> it = this.mInputBufferSet.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getTerminationFuture());
            }
            Futures.successfulAsList(arrayList).addListener(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.signalEndOfInputStream();
                }
            }, this.mEncoderExecutor);
            return;
        }
        if (encoderInput instanceof SurfaceInput) {
            try {
                addSignalEosTimeoutIfNeeded();
                this.mMediaCodec.signalEndOfInputStream();
                this.mMediaCodecEosSignalled = true;
            } catch (MediaCodec.CodecException e) {
                handleEncodeError(e);
            }
        }
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void pause() {
        final long jGeneratePresentationTimeUs = generatePresentationTimeUs();
        this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m287x8740478b(jGeneratePresentationTimeUs);
            }
        });
    }

    /* renamed from: lambda$pause$5$androidx-camera-video-internal-encoder-EncoderImpl, reason: not valid java name */
    /* synthetic */ void m287x8740478b(long j) {
        switch (this.mState) {
            case CONFIGURED:
            case PAUSED:
            case STOPPING:
            case PENDING_START_PAUSED:
            case ERROR:
                return;
            case STARTED:
                Logger.d(this.mTag, "Pause on " + DebugUtils.readableUs(j));
                this.mActivePauseResumeTimeRanges.addLast(Range.create(Long.valueOf(j), Long.MAX_VALUE));
                setState(InternalState.PAUSED);
                return;
            case PENDING_START:
                setState(InternalState.PENDING_START_PAUSED);
                return;
            case PENDING_RELEASE:
            case RELEASED:
                throw new IllegalStateException("Encoder is released");
            default:
                throw new IllegalStateException("Unknown state: " + this.mState);
        }
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void release() {
        this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m288x9ff0bd39();
            }
        });
    }

    /* renamed from: lambda$release$6$androidx-camera-video-internal-encoder-EncoderImpl, reason: not valid java name */
    /* synthetic */ void m288x9ff0bd39() {
        switch (this.mState) {
            case CONFIGURED:
            case STARTED:
            case PAUSED:
            case ERROR:
                releaseInternal();
                return;
            case STOPPING:
            case PENDING_START:
            case PENDING_START_PAUSED:
                setState(InternalState.PENDING_RELEASE);
                return;
            case PENDING_RELEASE:
            case RELEASED:
                return;
            default:
                throw new IllegalStateException("Unknown state: " + this.mState);
        }
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public ListenableFuture<Void> getReleasedFuture() {
        return this.mReleasedFuture;
    }

    public void signalSourceStopped() {
        this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m290xeb6ad495();
            }
        });
    }

    /* renamed from: lambda$signalSourceStopped$7$androidx-camera-video-internal-encoder-EncoderImpl, reason: not valid java name */
    /* synthetic */ void m290xeb6ad495() {
        this.mSourceStoppedSignalled = true;
        if (this.mIsFlushedAfterEndOfStream) {
            this.mMediaCodec.stop();
            reset();
        }
    }

    private void releaseInternal() {
        if (this.mIsFlushedAfterEndOfStream) {
            this.mMediaCodec.stop();
            this.mIsFlushedAfterEndOfStream = false;
        }
        this.mMediaCodec.release();
        Encoder.EncoderInput encoderInput = this.mEncoderInput;
        if (encoderInput instanceof SurfaceInput) {
            ((SurfaceInput) encoderInput).releaseSurface();
        }
        setState(InternalState.RELEASED);
        this.mReleasedCompleter.set(null);
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void setEncoderCallback(EncoderCallback encoderCallback, Executor executor) {
        synchronized (this.mLock) {
            this.mEncoderCallback = encoderCallback;
            this.mEncoderCallbackExecutor = executor;
        }
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void requestKeyFrame() {
        this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m289x8e3d44c1();
            }
        });
    }

    /* renamed from: lambda$requestKeyFrame$8$androidx-camera-video-internal-encoder-EncoderImpl, reason: not valid java name */
    /* synthetic */ void m289x8e3d44c1() {
        int iOrdinal = this.mState.ordinal();
        if (iOrdinal == 1) {
            requestKeyFrameToMediaCodec();
        } else if (iOrdinal == 6 || iOrdinal == 8) {
            throw new IllegalStateException("Encoder is released");
        }
    }

    private void setState(InternalState internalState) {
        if (this.mState == internalState) {
            return;
        }
        Logger.d(this.mTag, "Transitioning encoder internal state: " + this.mState + " --> " + internalState);
        this.mState = internalState;
    }

    void setMediaCodecPaused(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("drop-input-frames", z ? 1 : 0);
        this.mMediaCodec.setParameters(bundle);
    }

    void requestKeyFrameToMediaCodec() {
        Bundle bundle = new Bundle();
        bundle.putInt("request-sync", 0);
        this.mMediaCodec.setParameters(bundle);
    }

    private void addSignalEosTimeoutIfNeeded() {
        if (DeviceQuirks.get(SignalEosOutputBufferNotComeQuirk.class) != null) {
            final MediaCodecCallback mediaCodecCallback = this.mMediaCodecCallback;
            final Executor executor = this.mEncoderExecutor;
            Future<?> future = this.mSignalEosTimeoutFuture;
            if (future != null) {
                future.cancel(false);
            }
            this.mSignalEosTimeoutFuture = CameraXExecutors.mainThreadExecutor().schedule(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    EncoderImpl.lambda$addSignalEosTimeoutIfNeeded$9(executor, mediaCodecCallback);
                }
            }, 1000L, TimeUnit.MILLISECONDS);
        }
    }

    static /* synthetic */ void lambda$addSignalEosTimeoutIfNeeded$9(Executor executor, final MediaCodecCallback mediaCodecCallback) {
        Objects.requireNonNull(mediaCodecCallback);
        executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                mediaCodecCallback.reachEndData();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signalEndOfInputStream() {
        Futures.addCallback(acquireInputBuffer(), new FutureCallback<InputBuffer>() { // from class: androidx.camera.video.internal.encoder.EncoderImpl.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(InputBuffer inputBuffer) {
                inputBuffer.setPresentationTimeUs(EncoderImpl.this.generatePresentationTimeUs());
                inputBuffer.setEndOfStream(true);
                inputBuffer.submit();
                Futures.addCallback(inputBuffer.getTerminationFuture(), new FutureCallback<Void>() { // from class: androidx.camera.video.internal.encoder.EncoderImpl.1.1
                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onSuccess(Void r1) {
                    }

                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onFailure(Throwable th) {
                        if (th instanceof MediaCodec.CodecException) {
                            EncoderImpl.this.handleEncodeError((MediaCodec.CodecException) th);
                        } else {
                            EncoderImpl.this.handleEncodeError(0, th.getMessage(), th);
                        }
                    }
                }, EncoderImpl.this.mEncoderExecutor);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                EncoderImpl.this.handleEncodeError(0, "Unable to acquire InputBuffer.", th);
            }
        }, this.mEncoderExecutor);
    }

    void handleEncodeError(MediaCodec.CodecException codecException) {
        handleEncodeError(1, codecException.getMessage(), codecException);
    }

    void handleEncodeError(final int i, final String str, final Throwable th) {
        switch (this.mState) {
            case CONFIGURED:
                m285x818f89bf(i, str, th);
                reset();
                break;
            case STARTED:
            case PAUSED:
            case STOPPING:
            case PENDING_START:
            case PENDING_START_PAUSED:
            case PENDING_RELEASE:
                setState(InternalState.ERROR);
                stopMediaCodec(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$$ExternalSyntheticLambda15
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m285x818f89bf(i, str, th);
                    }
                });
                break;
            case ERROR:
                Logger.w(this.mTag, "Get more than one error: " + str + "(" + i + ")", th);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: notifyError, reason: merged with bridge method [inline-methods] */
    public void m285x818f89bf(final int i, final String str, final Throwable th) {
        final EncoderCallback encoderCallback;
        Executor executor;
        synchronized (this.mLock) {
            encoderCallback = this.mEncoderCallback;
            executor = this.mEncoderCallbackExecutor;
        }
        try {
            executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    encoderCallback.onEncodeError(new EncodeException(i, str, th));
                }
            });
        } catch (RejectedExecutionException e) {
            Logger.e(this.mTag, "Unable to post to the supplied executor.", e);
        }
    }

    void stopMediaCodec(final Runnable runnable) {
        Logger.d(this.mTag, "stopMediaCodec");
        final ArrayList arrayList = new ArrayList();
        Iterator<EncodedDataImpl> it = this.mEncodedDataSet.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getClosedFuture());
        }
        Iterator<InputBuffer> it2 = this.mInputBufferSet.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().getTerminationFuture());
        }
        if (!arrayList.isEmpty()) {
            Logger.d(this.mTag, "Waiting for resources to return. encoded data = " + this.mEncodedDataSet.size() + ", input buffers = " + this.mInputBufferSet.size());
        }
        Futures.successfulAsList(arrayList).addListener(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m295xe1c76381(arrayList, runnable);
            }
        }, this.mEncoderExecutor);
    }

    /* renamed from: lambda$stopMediaCodec$12$androidx-camera-video-internal-encoder-EncoderImpl, reason: not valid java name */
    /* synthetic */ void m295xe1c76381(List list, Runnable runnable) {
        if (this.mState != InternalState.ERROR) {
            if (!list.isEmpty()) {
                Logger.d(this.mTag, "encoded data and input buffers are returned");
            }
            if ((this.mEncoderInput instanceof SurfaceInput) && !this.mSourceStoppedSignalled && !hasStopCodecAfterSurfaceRemovalCrashMediaServerQuirk()) {
                this.mMediaCodec.flush();
                this.mIsFlushedAfterEndOfStream = true;
            } else {
                this.mMediaCodec.stop();
            }
        }
        if (runnable != null) {
            runnable.run();
        }
        handleStopped();
    }

    void handleStopped() {
        if (this.mState == InternalState.PENDING_RELEASE) {
            releaseInternal();
            return;
        }
        InternalState internalState = this.mState;
        if (!this.mIsFlushedAfterEndOfStream) {
            reset();
        }
        setState(InternalState.CONFIGURED);
        if (internalState == InternalState.PENDING_START || internalState == InternalState.PENDING_START_PAUSED) {
            start();
            if (internalState == InternalState.PENDING_START_PAUSED) {
                pause();
            }
        }
    }

    void updateTotalPausedDuration(long j) {
        while (!this.mActivePauseResumeTimeRanges.isEmpty()) {
            Range<Long> first = this.mActivePauseResumeTimeRanges.getFirst();
            if (j <= ((Long) first.getUpper()).longValue()) {
                return;
            }
            this.mActivePauseResumeTimeRanges.removeFirst();
            this.mTotalPausedDurationUs += ((Long) first.getUpper()).longValue() - ((Long) first.getLower()).longValue();
            Logger.d(this.mTag, "Total paused duration = " + DebugUtils.readableUs(this.mTotalPausedDurationUs));
        }
    }

    long getAdjustedTimeUs(MediaCodec.BufferInfo bufferInfo) {
        if (this.mTotalPausedDurationUs > 0) {
            return bufferInfo.presentationTimeUs - this.mTotalPausedDurationUs;
        }
        return bufferInfo.presentationTimeUs;
    }

    boolean isInPauseRange(long j) {
        for (Range<Long> range : this.mActivePauseResumeTimeRanges) {
            if (range.contains((Range<Long>) Long.valueOf(j))) {
                return true;
            }
            if (j < ((Long) range.getLower()).longValue()) {
                break;
            }
        }
        return false;
    }

    ListenableFuture<InputBuffer> acquireInputBuffer() throws MediaCodec.CryptoException {
        switch (this.mState) {
            case CONFIGURED:
                return Futures.immediateFailedFuture(new IllegalStateException("Encoder is not started yet."));
            case STARTED:
            case PAUSED:
            case STOPPING:
            case PENDING_START:
            case PENDING_START_PAUSED:
            case PENDING_RELEASE:
                final AtomicReference atomicReference = new AtomicReference();
                ListenableFuture<InputBuffer> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$$ExternalSyntheticLambda5
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                        return EncoderImpl.lambda$acquireInputBuffer$13(atomicReference, completer);
                    }
                });
                final CallbackToFutureAdapter.Completer<InputBuffer> completer = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference.get());
                this.mAcquisitionQueue.offer(completer);
                completer.addCancellationListener(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m284x9b64b77f(completer);
                    }
                }, this.mEncoderExecutor);
                matchAcquisitionsAndFreeBufferIndexes();
                return future;
            case ERROR:
                return Futures.immediateFailedFuture(new IllegalStateException("Encoder is in error state."));
            case RELEASED:
                return Futures.immediateFailedFuture(new IllegalStateException("Encoder is released."));
            default:
                throw new IllegalStateException("Unknown state: " + this.mState);
        }
    }

    static /* synthetic */ Object lambda$acquireInputBuffer$13(AtomicReference atomicReference, CallbackToFutureAdapter.Completer completer) throws Exception {
        atomicReference.set(completer);
        return "acquireInputBuffer";
    }

    /* renamed from: lambda$acquireInputBuffer$14$androidx-camera-video-internal-encoder-EncoderImpl, reason: not valid java name */
    /* synthetic */ void m284x9b64b77f(CallbackToFutureAdapter.Completer completer) {
        this.mAcquisitionQueue.remove(completer);
    }

    void matchAcquisitionsAndFreeBufferIndexes() throws MediaCodec.CryptoException {
        while (!this.mAcquisitionQueue.isEmpty() && !this.mFreeInputBufferIndexQueue.isEmpty()) {
            CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) Objects.requireNonNull(this.mAcquisitionQueue.poll());
            try {
                final InputBufferImpl inputBufferImpl = new InputBufferImpl(this.mMediaCodec, ((Integer) Objects.requireNonNull(this.mFreeInputBufferIndexQueue.poll())).intValue());
                if (completer.set(inputBufferImpl)) {
                    this.mInputBufferSet.add(inputBufferImpl);
                    inputBufferImpl.getTerminationFuture().addListener(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$$ExternalSyntheticLambda7
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m286x59a2f58(inputBufferImpl);
                        }
                    }, this.mEncoderExecutor);
                } else {
                    inputBufferImpl.cancel();
                }
            } catch (MediaCodec.CodecException e) {
                handleEncodeError(e);
                return;
            }
        }
    }

    /* renamed from: lambda$matchAcquisitionsAndFreeBufferIndexes$15$androidx-camera-video-internal-encoder-EncoderImpl, reason: not valid java name */
    /* synthetic */ void m286x59a2f58(InputBufferImpl inputBufferImpl) {
        this.mInputBufferSet.remove(inputBufferImpl);
    }

    long generatePresentationTimeUs() {
        return this.mTimeProvider.uptimeUs();
    }

    static boolean isKeyFrame(MediaCodec.BufferInfo bufferInfo) {
        return (bufferInfo.flags & 1) != 0;
    }

    static boolean hasEndOfStreamFlag(MediaCodec.BufferInfo bufferInfo) {
        return (bufferInfo.flags & 4) != 0;
    }

    private boolean hasStopCodecAfterSurfaceRemovalCrashMediaServerQuirk() {
        return DeviceQuirks.get(StopCodecAfterSurfaceRemovalCrashMediaServerQuirk.class) != null;
    }

    class MediaCodecCallback extends MediaCodec.Callback {
        private boolean mIsFirstVideoOutput;
        private boolean mReachStopTimeAsEos;
        private final VideoTimebaseConverter mVideoTimestampConverter;
        private boolean mHasSendStartCallback = false;
        private boolean mHasFirstData = false;
        private boolean mHasEndData = false;
        private long mLastPresentationTimeUs = 0;
        private long mLastSentAdjustedTimeUs = 0;
        private boolean mIsOutputBufferInPauseState = false;
        private boolean mIsKeyFrameRequired = false;
        private boolean mStopped = false;

        static /* synthetic */ MediaFormat lambda$onOutputFormatChanged$5(MediaFormat mediaFormat) {
            return mediaFormat;
        }

        MediaCodecCallback() {
            this.mReachStopTimeAsEos = true;
            this.mIsFirstVideoOutput = EncoderImpl.this.mIsVideoEncoder;
            if (EncoderImpl.this.mIsVideoEncoder) {
                this.mVideoTimestampConverter = new VideoTimebaseConverter(EncoderImpl.this.mTimeProvider, EncoderImpl.this.mInputTimebase, (CameraUseInconsistentTimebaseQuirk) DeviceQuirks.get(CameraUseInconsistentTimebaseQuirk.class));
            } else {
                this.mVideoTimestampConverter = null;
            }
            CodecStuckOnFlushQuirk codecStuckOnFlushQuirk = (CodecStuckOnFlushQuirk) DeviceQuirks.get(CodecStuckOnFlushQuirk.class);
            if (codecStuckOnFlushQuirk == null || !codecStuckOnFlushQuirk.isProblematicMimeType(EncoderImpl.this.mMediaFormat.getString("mime"))) {
                return;
            }
            this.mReachStopTimeAsEos = false;
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(MediaCodec mediaCodec, final int i) {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$MediaCodecCallback$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws MediaCodec.CryptoException {
                    this.f$0.m305xa20c30ed(i);
                }
            });
        }

        /* renamed from: lambda$onInputBufferAvailable$0$androidx-camera-video-internal-encoder-EncoderImpl$MediaCodecCallback, reason: not valid java name */
        /* synthetic */ void m305xa20c30ed(int i) throws MediaCodec.CryptoException {
            if (this.mStopped) {
                Logger.w(EncoderImpl.this.mTag, "Receives input frame after codec is reset.");
                return;
            }
            switch (EncoderImpl.this.mState) {
                case CONFIGURED:
                case ERROR:
                case RELEASED:
                    return;
                case STARTED:
                case PAUSED:
                case STOPPING:
                case PENDING_START:
                case PENDING_START_PAUSED:
                case PENDING_RELEASE:
                    EncoderImpl.this.mFreeInputBufferIndexQueue.offer(Integer.valueOf(i));
                    EncoderImpl.this.matchAcquisitionsAndFreeBufferIndexes();
                    return;
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.mState);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(final MediaCodec mediaCodec, final int i, final MediaCodec.BufferInfo bufferInfo) {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$MediaCodecCallback$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m306xbb0c589f(bufferInfo, mediaCodec, i);
                }
            });
        }

        /* renamed from: lambda$onOutputBufferAvailable$1$androidx-camera-video-internal-encoder-EncoderImpl$MediaCodecCallback, reason: not valid java name */
        /* synthetic */ void m306xbb0c589f(MediaCodec.BufferInfo bufferInfo, MediaCodec mediaCodec, int i) {
            final EncoderCallback encoderCallback;
            Executor executor;
            if (this.mStopped) {
                Logger.w(EncoderImpl.this.mTag, "Receives frame after codec is reset.");
                return;
            }
            switch (EncoderImpl.this.mState) {
                case CONFIGURED:
                case ERROR:
                case RELEASED:
                    return;
                case STARTED:
                case PAUSED:
                case STOPPING:
                case PENDING_START:
                case PENDING_START_PAUSED:
                case PENDING_RELEASE:
                    synchronized (EncoderImpl.this.mLock) {
                        encoderCallback = EncoderImpl.this.mEncoderCallback;
                        executor = EncoderImpl.this.mEncoderCallbackExecutor;
                    }
                    if (!this.mHasSendStartCallback) {
                        this.mHasSendStartCallback = true;
                        try {
                            Objects.requireNonNull(encoderCallback);
                            executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$MediaCodecCallback$$ExternalSyntheticLambda4
                                @Override // java.lang.Runnable
                                public final void run() {
                                    encoderCallback.onEncodeStart();
                                }
                            });
                        } catch (RejectedExecutionException e) {
                            Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e);
                        }
                    }
                    if (checkBufferInfo(bufferInfo)) {
                        if (!this.mHasFirstData) {
                            this.mHasFirstData = true;
                            Logger.d(EncoderImpl.this.mTag, "data timestampUs = " + bufferInfo.presentationTimeUs + ", data timebase = " + EncoderImpl.this.mInputTimebase + ", current system uptimeMs = " + SystemClock.uptimeMillis() + ", current system realtimeMs = " + SystemClock.elapsedRealtime());
                        }
                        MediaCodec.BufferInfo bufferInfoResolveOutputBufferInfo = resolveOutputBufferInfo(bufferInfo);
                        this.mLastSentAdjustedTimeUs = bufferInfoResolveOutputBufferInfo.presentationTimeUs;
                        try {
                            sendEncodedData(new EncodedDataImpl(mediaCodec, i, bufferInfoResolveOutputBufferInfo), encoderCallback, executor);
                        } catch (MediaCodec.CodecException e2) {
                            EncoderImpl.this.handleEncodeError(e2);
                            return;
                        }
                    } else {
                        try {
                            EncoderImpl.this.mMediaCodec.releaseOutputBuffer(i, false);
                        } catch (MediaCodec.CodecException e3) {
                            EncoderImpl.this.handleEncodeError(e3);
                            return;
                        }
                    }
                    if (!this.mHasEndData && isEndOfStream(bufferInfo)) {
                        reachEndData();
                    }
                    if (this.mIsFirstVideoOutput) {
                        this.mIsFirstVideoOutput = false;
                        return;
                    }
                    return;
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.mState);
            }
        }

        void reachEndData() {
            final EncoderCallback encoderCallback;
            final Executor executor;
            if (this.mHasEndData) {
                return;
            }
            this.mHasEndData = true;
            if (EncoderImpl.this.mSignalEosTimeoutFuture != null) {
                EncoderImpl.this.mSignalEosTimeoutFuture.cancel(false);
                EncoderImpl.this.mSignalEosTimeoutFuture = null;
            }
            synchronized (EncoderImpl.this.mLock) {
                encoderCallback = EncoderImpl.this.mEncoderCallback;
                executor = EncoderImpl.this.mEncoderCallbackExecutor;
            }
            EncoderImpl.this.stopMediaCodec(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$MediaCodecCallback$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m308x24be0c23(executor, encoderCallback);
                }
            });
        }

        /* renamed from: lambda$reachEndData$2$androidx-camera-video-internal-encoder-EncoderImpl$MediaCodecCallback, reason: not valid java name */
        /* synthetic */ void m308x24be0c23(Executor executor, final EncoderCallback encoderCallback) {
            if (EncoderImpl.this.mState == InternalState.ERROR) {
                return;
            }
            try {
                Objects.requireNonNull(encoderCallback);
                executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$MediaCodecCallback$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        encoderCallback.onEncodeStop();
                    }
                });
            } catch (RejectedExecutionException e) {
                Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e);
            }
        }

        private MediaCodec.BufferInfo resolveOutputBufferInfo(MediaCodec.BufferInfo bufferInfo) {
            long adjustedTimeUs = EncoderImpl.this.getAdjustedTimeUs(bufferInfo);
            if (bufferInfo.presentationTimeUs == adjustedTimeUs) {
                return bufferInfo;
            }
            Preconditions.checkState(adjustedTimeUs > this.mLastSentAdjustedTimeUs);
            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
            bufferInfo2.set(bufferInfo.offset, bufferInfo.size, adjustedTimeUs, bufferInfo.flags);
            return bufferInfo2;
        }

        private void sendEncodedData(final EncodedDataImpl encodedDataImpl, final EncoderCallback encoderCallback, Executor executor) {
            EncoderImpl.this.mEncodedDataSet.add(encodedDataImpl);
            Futures.addCallback(encodedDataImpl.getClosedFuture(), new FutureCallback<Void>() { // from class: androidx.camera.video.internal.encoder.EncoderImpl.MediaCodecCallback.1
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(Void r2) {
                    EncoderImpl.this.mEncodedDataSet.remove(encodedDataImpl);
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable th) {
                    EncoderImpl.this.mEncodedDataSet.remove(encodedDataImpl);
                    if (th instanceof MediaCodec.CodecException) {
                        EncoderImpl.this.handleEncodeError((MediaCodec.CodecException) th);
                    } else {
                        EncoderImpl.this.handleEncodeError(0, th.getMessage(), th);
                    }
                }
            }, EncoderImpl.this.mEncoderExecutor);
            try {
                executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$MediaCodecCallback$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        encoderCallback.onEncodedData(encodedDataImpl);
                    }
                });
            } catch (RejectedExecutionException e) {
                Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e);
                encodedDataImpl.close();
            }
        }

        private boolean checkBufferInfo(MediaCodec.BufferInfo bufferInfo) {
            if (this.mHasEndData) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by already reach end of stream.");
                return false;
            }
            if (bufferInfo.size <= 0) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by invalid buffer size.");
                return false;
            }
            if ((bufferInfo.flags & 2) != 0) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by codec config.");
                return false;
            }
            VideoTimebaseConverter videoTimebaseConverter = this.mVideoTimestampConverter;
            if (videoTimebaseConverter != null) {
                bufferInfo.presentationTimeUs = videoTimebaseConverter.convertToUptimeUs(bufferInfo.presentationTimeUs);
            }
            if (bufferInfo.presentationTimeUs <= this.mLastPresentationTimeUs) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by out of order buffer from MediaCodec.");
                return false;
            }
            this.mLastPresentationTimeUs = bufferInfo.presentationTimeUs;
            if (!EncoderImpl.this.mStartStopTimeRangeUs.contains((Range<Long>) Long.valueOf(bufferInfo.presentationTimeUs))) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by not in start-stop range.");
                if (EncoderImpl.this.mPendingCodecStop && bufferInfo.presentationTimeUs >= ((Long) EncoderImpl.this.mStartStopTimeRangeUs.getUpper()).longValue()) {
                    if (EncoderImpl.this.mStopTimeoutFuture != null) {
                        EncoderImpl.this.mStopTimeoutFuture.cancel(true);
                    }
                    EncoderImpl.this.mLastDataStopTimestamp = Long.valueOf(bufferInfo.presentationTimeUs);
                    EncoderImpl.this.signalCodecStop();
                    EncoderImpl.this.mPendingCodecStop = false;
                }
                return false;
            }
            if (updatePauseRangeStateAndCheckIfBufferPaused(bufferInfo)) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by pause.");
                return false;
            }
            if (EncoderImpl.this.getAdjustedTimeUs(bufferInfo) <= this.mLastSentAdjustedTimeUs) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by adjusted time is less than the last sent time.");
                if (EncoderImpl.this.mIsVideoEncoder && EncoderImpl.isKeyFrame(bufferInfo)) {
                    this.mIsKeyFrameRequired = true;
                }
                return false;
            }
            if (!this.mHasFirstData && !this.mIsKeyFrameRequired && EncoderImpl.this.mIsVideoEncoder) {
                this.mIsKeyFrameRequired = true;
            }
            if (this.mIsKeyFrameRequired) {
                if (!EncoderImpl.isKeyFrame(bufferInfo)) {
                    Logger.d(EncoderImpl.this.mTag, "Drop buffer by not a key frame.");
                    EncoderImpl.this.requestKeyFrameToMediaCodec();
                    return false;
                }
                this.mIsKeyFrameRequired = false;
            }
            return true;
        }

        private boolean isEndOfStream(MediaCodec.BufferInfo bufferInfo) {
            return (EncoderImpl.hasEndOfStreamFlag(bufferInfo) && !shouldSkipPrematureEos()) || (this.mReachStopTimeAsEos && isEosSignalledAndStopTimeReached(bufferInfo));
        }

        private boolean shouldSkipPrematureEos() {
            return this.mIsFirstVideoOutput && DeviceQuirks.get(PrematureEndOfStreamVideoQuirk.class) != null;
        }

        private boolean isEosSignalledAndStopTimeReached(MediaCodec.BufferInfo bufferInfo) {
            return EncoderImpl.this.mMediaCodecEosSignalled && bufferInfo.presentationTimeUs > ((Long) EncoderImpl.this.mStartStopTimeRangeUs.getUpper()).longValue();
        }

        private boolean updatePauseRangeStateAndCheckIfBufferPaused(MediaCodec.BufferInfo bufferInfo) {
            Executor executor;
            final EncoderCallback encoderCallback;
            EncoderImpl.this.updateTotalPausedDuration(bufferInfo.presentationTimeUs);
            boolean zIsInPauseRange = EncoderImpl.this.isInPauseRange(bufferInfo.presentationTimeUs);
            boolean z = this.mIsOutputBufferInPauseState;
            if (!z && zIsInPauseRange) {
                Logger.d(EncoderImpl.this.mTag, "Switch to pause state");
                this.mIsOutputBufferInPauseState = true;
                synchronized (EncoderImpl.this.mLock) {
                    executor = EncoderImpl.this.mEncoderCallbackExecutor;
                    encoderCallback = EncoderImpl.this.mEncoderCallback;
                }
                Objects.requireNonNull(encoderCallback);
                executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$MediaCodecCallback$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        encoderCallback.onEncodePaused();
                    }
                });
                if (EncoderImpl.this.mState == InternalState.PAUSED && ((EncoderImpl.this.mIsVideoEncoder || DeviceQuirks.get(AudioEncoderIgnoresInputTimestampQuirk.class) == null) && (!EncoderImpl.this.mIsVideoEncoder || DeviceQuirks.get(VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk.class) == null))) {
                    if (EncoderImpl.this.mEncoderInput instanceof ByteBufferInput) {
                        ((ByteBufferInput) EncoderImpl.this.mEncoderInput).setActive(false);
                    }
                    EncoderImpl.this.setMediaCodecPaused(true);
                }
                EncoderImpl.this.mLastDataStopTimestamp = Long.valueOf(bufferInfo.presentationTimeUs);
                if (EncoderImpl.this.mPendingCodecStop) {
                    if (EncoderImpl.this.mStopTimeoutFuture != null) {
                        EncoderImpl.this.mStopTimeoutFuture.cancel(true);
                    }
                    EncoderImpl.this.signalCodecStop();
                    EncoderImpl.this.mPendingCodecStop = false;
                }
            } else if (z && !zIsInPauseRange) {
                Logger.d(EncoderImpl.this.mTag, "Switch to resume state");
                this.mIsOutputBufferInPauseState = false;
                if (EncoderImpl.this.mIsVideoEncoder && !EncoderImpl.isKeyFrame(bufferInfo)) {
                    this.mIsKeyFrameRequired = true;
                }
            }
            return this.mIsOutputBufferInPauseState;
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(MediaCodec mediaCodec, final MediaCodec.CodecException codecException) {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$MediaCodecCallback$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m304x7242b142(codecException);
                }
            });
        }

        /* renamed from: lambda$onError$4$androidx-camera-video-internal-encoder-EncoderImpl$MediaCodecCallback, reason: not valid java name */
        /* synthetic */ void m304x7242b142(MediaCodec.CodecException codecException) {
            switch (EncoderImpl.this.mState) {
                case CONFIGURED:
                case ERROR:
                case RELEASED:
                    return;
                case STARTED:
                case PAUSED:
                case STOPPING:
                case PENDING_START:
                case PENDING_START_PAUSED:
                case PENDING_RELEASE:
                    EncoderImpl.this.handleEncodeError(codecException);
                    return;
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.mState);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(MediaCodec mediaCodec, final MediaFormat mediaFormat) {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$MediaCodecCallback$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m307xd741dd39(mediaFormat);
                }
            });
        }

        /* renamed from: lambda$onOutputFormatChanged$7$androidx-camera-video-internal-encoder-EncoderImpl$MediaCodecCallback, reason: not valid java name */
        /* synthetic */ void m307xd741dd39(final MediaFormat mediaFormat) {
            final EncoderCallback encoderCallback;
            Executor executor;
            if (this.mStopped) {
                Logger.w(EncoderImpl.this.mTag, "Receives onOutputFormatChanged after codec is reset.");
                return;
            }
            switch (EncoderImpl.this.mState) {
                case CONFIGURED:
                case ERROR:
                case RELEASED:
                    return;
                case STARTED:
                case PAUSED:
                case STOPPING:
                case PENDING_START:
                case PENDING_START_PAUSED:
                case PENDING_RELEASE:
                    synchronized (EncoderImpl.this.mLock) {
                        encoderCallback = EncoderImpl.this.mEncoderCallback;
                        executor = EncoderImpl.this.mEncoderCallbackExecutor;
                    }
                    try {
                        executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$MediaCodecCallback$$ExternalSyntheticLambda8
                            @Override // java.lang.Runnable
                            public final void run() {
                                encoderCallback.onOutputConfigUpdate(new OutputConfig() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$MediaCodecCallback$$ExternalSyntheticLambda7
                                    @Override // androidx.camera.video.internal.encoder.OutputConfig
                                    public final MediaFormat getMediaFormat() {
                                        return EncoderImpl.MediaCodecCallback.lambda$onOutputFormatChanged$5(mediaFormat);
                                    }
                                });
                            }
                        });
                        return;
                    } catch (RejectedExecutionException e) {
                        Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e);
                        return;
                    }
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.mState);
            }
        }

        void stop() {
            this.mStopped = true;
        }
    }

    class SurfaceInput implements Encoder.SurfaceInput {
        private final Object mLock = new Object();
        private final Set<Surface> mObsoleteSurfaces = new HashSet();
        private Surface mSurface;
        private Executor mSurfaceUpdateExecutor;
        private Encoder.SurfaceInput.OnSurfaceUpdateListener mSurfaceUpdateListener;

        SurfaceInput() {
        }

        @Override // androidx.camera.video.internal.encoder.Encoder.SurfaceInput
        public void setOnSurfaceUpdateListener(Executor executor, Encoder.SurfaceInput.OnSurfaceUpdateListener onSurfaceUpdateListener) {
            Surface surface;
            synchronized (this.mLock) {
                this.mSurfaceUpdateListener = (Encoder.SurfaceInput.OnSurfaceUpdateListener) Preconditions.checkNotNull(onSurfaceUpdateListener);
                this.mSurfaceUpdateExecutor = (Executor) Preconditions.checkNotNull(executor);
                surface = this.mSurface;
            }
            if (surface != null) {
                notifySurfaceUpdate(executor, onSurfaceUpdateListener, surface);
            }
        }

        void resetSurface() {
            Surface surfaceCreateInputSurface;
            Encoder.SurfaceInput.OnSurfaceUpdateListener onSurfaceUpdateListener;
            Executor executor;
            EncoderNotUsePersistentInputSurfaceQuirk encoderNotUsePersistentInputSurfaceQuirk = (EncoderNotUsePersistentInputSurfaceQuirk) DeviceQuirks.get(EncoderNotUsePersistentInputSurfaceQuirk.class);
            synchronized (this.mLock) {
                if (encoderNotUsePersistentInputSurfaceQuirk == null) {
                    if (this.mSurface == null) {
                        surfaceCreateInputSurface = Api23Impl.createPersistentInputSurface();
                        this.mSurface = surfaceCreateInputSurface;
                    } else {
                        surfaceCreateInputSurface = null;
                    }
                    Api23Impl.setInputSurface(EncoderImpl.this.mMediaCodec, this.mSurface);
                } else {
                    Surface surface = this.mSurface;
                    if (surface != null) {
                        this.mObsoleteSurfaces.add(surface);
                    }
                    surfaceCreateInputSurface = EncoderImpl.this.mMediaCodec.createInputSurface();
                    this.mSurface = surfaceCreateInputSurface;
                }
                onSurfaceUpdateListener = this.mSurfaceUpdateListener;
                executor = this.mSurfaceUpdateExecutor;
            }
            if (surfaceCreateInputSurface == null || onSurfaceUpdateListener == null || executor == null) {
                return;
            }
            notifySurfaceUpdate(executor, onSurfaceUpdateListener, surfaceCreateInputSurface);
        }

        void releaseSurface() {
            Surface surface;
            HashSet hashSet;
            synchronized (this.mLock) {
                surface = this.mSurface;
                this.mSurface = null;
                hashSet = new HashSet(this.mObsoleteSurfaces);
                this.mObsoleteSurfaces.clear();
            }
            if (surface != null) {
                surface.release();
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((Surface) it.next()).release();
            }
        }

        private void notifySurfaceUpdate(Executor executor, final Encoder.SurfaceInput.OnSurfaceUpdateListener onSurfaceUpdateListener, final Surface surface) {
            try {
                executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$SurfaceInput$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        onSurfaceUpdateListener.onSurfaceUpdate(surface);
                    }
                });
            } catch (RejectedExecutionException e) {
                Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e);
            }
        }
    }

    class ByteBufferInput implements Encoder.ByteBufferInput {
        private final Map<Observable.Observer<? super BufferProvider.State>, Executor> mStateObservers = new LinkedHashMap();
        private BufferProvider.State mBufferProviderState = BufferProvider.State.INACTIVE;
        private final List<ListenableFuture<InputBuffer>> mAcquisitionList = new ArrayList();

        ByteBufferInput() {
        }

        @Override // androidx.camera.core.impl.Observable
        public ListenableFuture<BufferProvider.State> fetchData() {
            return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$ByteBufferInput$$ExternalSyntheticLambda1
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return this.f$0.m302xdbdcf33f(completer);
                }
            });
        }

        /* renamed from: lambda$fetchData$0$androidx-camera-video-internal-encoder-EncoderImpl$ByteBufferInput, reason: not valid java name */
        /* synthetic */ void m301x3f6ef6e0(CallbackToFutureAdapter.Completer completer) {
            completer.set(this.mBufferProviderState);
        }

        /* renamed from: lambda$fetchData$1$androidx-camera-video-internal-encoder-EncoderImpl$ByteBufferInput, reason: not valid java name */
        /* synthetic */ Object m302xdbdcf33f(final CallbackToFutureAdapter.Completer completer) throws Exception {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$ByteBufferInput$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m301x3f6ef6e0(completer);
                }
            });
            return "fetchData";
        }

        @Override // androidx.camera.video.internal.BufferProvider
        public ListenableFuture<InputBuffer> acquireBuffer() {
            return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$ByteBufferInput$$ExternalSyntheticLambda2
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return this.f$0.m299xc1b33249(completer);
                }
            });
        }

        /* renamed from: lambda$acquireBuffer$5$androidx-camera-video-internal-encoder-EncoderImpl$ByteBufferInput, reason: not valid java name */
        /* synthetic */ Object m299xc1b33249(final CallbackToFutureAdapter.Completer completer) throws Exception {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$ByteBufferInput$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() throws MediaCodec.CryptoException {
                    this.f$0.m298x254535ea(completer);
                }
            });
            return "acquireBuffer";
        }

        /* renamed from: lambda$acquireBuffer$4$androidx-camera-video-internal-encoder-EncoderImpl$ByteBufferInput, reason: not valid java name */
        /* synthetic */ void m298x254535ea(CallbackToFutureAdapter.Completer completer) throws MediaCodec.CryptoException {
            if (this.mBufferProviderState == BufferProvider.State.ACTIVE) {
                final ListenableFuture<InputBuffer> listenableFutureAcquireInputBuffer = EncoderImpl.this.acquireInputBuffer();
                Futures.propagate(listenableFutureAcquireInputBuffer, completer);
                completer.addCancellationListener(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$ByteBufferInput$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m296xec693d2c(listenableFutureAcquireInputBuffer);
                    }
                }, CameraXExecutors.directExecutor());
                this.mAcquisitionList.add(listenableFutureAcquireInputBuffer);
                listenableFutureAcquireInputBuffer.addListener(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$ByteBufferInput$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m297x88d7398b(listenableFutureAcquireInputBuffer);
                    }
                }, EncoderImpl.this.mEncoderExecutor);
                return;
            }
            if (this.mBufferProviderState == BufferProvider.State.INACTIVE) {
                completer.setException(new IllegalStateException("BufferProvider is not active."));
            } else {
                completer.setException(new IllegalStateException("Unknown state: " + this.mBufferProviderState));
            }
        }

        /* renamed from: lambda$acquireBuffer$3$androidx-camera-video-internal-encoder-EncoderImpl$ByteBufferInput, reason: not valid java name */
        /* synthetic */ void m297x88d7398b(ListenableFuture listenableFuture) {
            this.mAcquisitionList.remove(listenableFuture);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: cancelInputBuffer, reason: merged with bridge method [inline-methods] */
        public void m296xec693d2c(ListenableFuture<InputBuffer> listenableFuture) {
            if (listenableFuture.cancel(true)) {
                return;
            }
            Preconditions.checkState(listenableFuture.isDone());
            try {
                listenableFuture.get().cancel();
            } catch (InterruptedException | CancellationException | ExecutionException e) {
                Logger.w(EncoderImpl.this.mTag, "Unable to cancel the input buffer: " + e);
            }
        }

        @Override // androidx.camera.core.impl.Observable
        public void addObserver(final Executor executor, final Observable.Observer<? super BufferProvider.State> observer) {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$ByteBufferInput$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m300x11117d06(observer, executor);
                }
            });
        }

        /* renamed from: lambda$addObserver$7$androidx-camera-video-internal-encoder-EncoderImpl$ByteBufferInput, reason: not valid java name */
        /* synthetic */ void m300x11117d06(final Observable.Observer observer, Executor executor) {
            this.mStateObservers.put((Observable.Observer) Preconditions.checkNotNull(observer), (Executor) Preconditions.checkNotNull(executor));
            final BufferProvider.State state = this.mBufferProviderState;
            executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$ByteBufferInput$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    observer.onNewData(state);
                }
            });
        }

        @Override // androidx.camera.core.impl.Observable
        public void removeObserver(final Observable.Observer<? super BufferProvider.State> observer) {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$ByteBufferInput$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m303x87db4ec8(observer);
                }
            });
        }

        /* renamed from: lambda$removeObserver$8$androidx-camera-video-internal-encoder-EncoderImpl$ByteBufferInput, reason: not valid java name */
        /* synthetic */ void m303x87db4ec8(Observable.Observer observer) {
            this.mStateObservers.remove(Preconditions.checkNotNull(observer));
        }

        void setActive(boolean z) {
            final BufferProvider.State state = z ? BufferProvider.State.ACTIVE : BufferProvider.State.INACTIVE;
            if (this.mBufferProviderState == state) {
                return;
            }
            this.mBufferProviderState = state;
            if (state == BufferProvider.State.INACTIVE) {
                Iterator<ListenableFuture<InputBuffer>> it = this.mAcquisitionList.iterator();
                while (it.hasNext()) {
                    it.next().cancel(true);
                }
                this.mAcquisitionList.clear();
            }
            for (final Map.Entry<Observable.Observer<? super BufferProvider.State>, Executor> entry : this.mStateObservers.entrySet()) {
                try {
                    entry.getValue().execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.EncoderImpl$ByteBufferInput$$ExternalSyntheticLambda7
                        @Override // java.lang.Runnable
                        public final void run() {
                            ((Observable.Observer) entry.getKey()).onNewData(state);
                        }
                    });
                } catch (RejectedExecutionException e) {
                    Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e);
                }
            }
        }
    }

    private static class Api23Impl {
        private Api23Impl() {
        }

        static Surface createPersistentInputSurface() {
            return MediaCodec.createPersistentInputSurface();
        }

        static void setInputSurface(MediaCodec mediaCodec, Surface surface) {
            mediaCodec.setInputSurface(surface);
        }
    }
}

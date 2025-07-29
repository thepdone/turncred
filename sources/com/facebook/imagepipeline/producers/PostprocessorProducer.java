package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessorRunner;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* loaded from: classes4.dex */
public class PostprocessorProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String NAME = "PostprocessorProducer";
    static final String POSTPROCESSOR = "Postprocessor";
    private final PlatformBitmapFactory mBitmapFactory;
    private final Executor mExecutor;
    private final Producer<CloseableReference<CloseableImage>> mInputProducer;

    public PostprocessorProducer(Producer<CloseableReference<CloseableImage>> producer, PlatformBitmapFactory platformBitmapFactory, Executor executor) {
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mBitmapFactory = platformBitmapFactory;
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        Consumer<CloseableReference<CloseableImage>> singleUsePostprocessorConsumer;
        ProducerListener2 producerListener = producerContext.getProducerListener();
        Postprocessor postprocessor = producerContext.getImageRequest().getPostprocessor();
        Preconditions.checkNotNull(postprocessor);
        PostprocessorConsumer postprocessorConsumer = new PostprocessorConsumer(consumer, producerListener, postprocessor, producerContext);
        if (postprocessor instanceof RepeatedPostprocessor) {
            singleUsePostprocessorConsumer = new RepeatedPostprocessorConsumer(postprocessorConsumer, (RepeatedPostprocessor) postprocessor, producerContext);
        } else {
            singleUsePostprocessorConsumer = new SingleUsePostprocessorConsumer(postprocessorConsumer);
        }
        this.mInputProducer.produceResults(singleUsePostprocessorConsumer, producerContext);
    }

    private class PostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        private boolean mIsClosed;
        private boolean mIsDirty;
        private boolean mIsPostProcessingRunning;
        private final ProducerListener2 mListener;
        private final Postprocessor mPostprocessor;
        private final ProducerContext mProducerContext;

        @Nullable
        private CloseableReference<CloseableImage> mSourceImageRef;
        private int mStatus;

        public PostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> consumer, ProducerListener2 producerListener2, Postprocessor postprocessor, ProducerContext producerContext) {
            super(consumer);
            this.mSourceImageRef = null;
            this.mStatus = 0;
            this.mIsDirty = false;
            this.mIsPostProcessingRunning = false;
            this.mListener = producerListener2;
            this.mPostprocessor = postprocessor;
            this.mProducerContext = producerContext;
            producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.1
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    PostprocessorConsumer.this.maybeNotifyOnCancellation();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@Nullable CloseableReference<CloseableImage> closeableReference, int i) {
            if (!CloseableReference.isValid(closeableReference)) {
                if (isLast(i)) {
                    maybeNotifyOnNewResult(null, i);
                    return;
                }
                return;
            }
            updateSourceImageRef(closeableReference, i);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onFailureImpl(Throwable th) {
            maybeNotifyOnFailure(th);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onCancellationImpl() {
            maybeNotifyOnCancellation();
        }

        private void updateSourceImageRef(@Nullable CloseableReference<CloseableImage> closeableReference, int i) {
            synchronized (this) {
                if (this.mIsClosed) {
                    return;
                }
                CloseableReference<CloseableImage> closeableReference2 = this.mSourceImageRef;
                this.mSourceImageRef = CloseableReference.cloneOrNull(closeableReference);
                this.mStatus = i;
                this.mIsDirty = true;
                boolean runningIfDirtyAndNotRunning = setRunningIfDirtyAndNotRunning();
                CloseableReference.closeSafely(closeableReference2);
                if (runningIfDirtyAndNotRunning) {
                    submitPostprocessing();
                }
            }
        }

        private void submitPostprocessing() {
            PostprocessorProducer.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.2
                @Override // java.lang.Runnable
                public void run() {
                    CloseableReference closeableReference;
                    int i;
                    synchronized (PostprocessorConsumer.this) {
                        closeableReference = PostprocessorConsumer.this.mSourceImageRef;
                        i = PostprocessorConsumer.this.mStatus;
                        PostprocessorConsumer.this.mSourceImageRef = null;
                        PostprocessorConsumer.this.mIsDirty = false;
                    }
                    if (CloseableReference.isValid(closeableReference)) {
                        try {
                            PostprocessorConsumer.this.doPostprocessing(closeableReference, i);
                        } finally {
                            CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                        }
                    }
                    PostprocessorConsumer.this.clearRunningAndStartIfDirty();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRunningAndStartIfDirty() {
            boolean runningIfDirtyAndNotRunning;
            synchronized (this) {
                this.mIsPostProcessingRunning = false;
                runningIfDirtyAndNotRunning = setRunningIfDirtyAndNotRunning();
            }
            if (runningIfDirtyAndNotRunning) {
                submitPostprocessing();
            }
        }

        private synchronized boolean setRunningIfDirtyAndNotRunning() {
            if (this.mIsClosed || !this.mIsDirty || this.mIsPostProcessingRunning || !CloseableReference.isValid(this.mSourceImageRef)) {
                return false;
            }
            this.mIsPostProcessingRunning = true;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doPostprocessing(CloseableReference<CloseableImage> closeableReference, int i) {
            Preconditions.checkArgument(Boolean.valueOf(CloseableReference.isValid(closeableReference)));
            if (!shouldPostprocess(closeableReference.get())) {
                maybeNotifyOnNewResult(closeableReference, i);
                return;
            }
            this.mListener.onProducerStart(this.mProducerContext, PostprocessorProducer.NAME);
            try {
                try {
                    CloseableReference<CloseableImage> closeableReferencePostprocessInternal = postprocessInternal(closeableReference.get());
                    ProducerListener2 producerListener2 = this.mListener;
                    ProducerContext producerContext = this.mProducerContext;
                    producerListener2.onProducerFinishWithSuccess(producerContext, PostprocessorProducer.NAME, getExtraMap(producerListener2, producerContext, this.mPostprocessor));
                    maybeNotifyOnNewResult(closeableReferencePostprocessInternal, i);
                    CloseableReference.closeSafely(closeableReferencePostprocessInternal);
                } catch (Exception e) {
                    ProducerListener2 producerListener22 = this.mListener;
                    ProducerContext producerContext2 = this.mProducerContext;
                    producerListener22.onProducerFinishWithFailure(producerContext2, PostprocessorProducer.NAME, e, getExtraMap(producerListener22, producerContext2, this.mPostprocessor));
                    maybeNotifyOnFailure(e);
                    CloseableReference.closeSafely((CloseableReference<?>) null);
                }
            } catch (Throwable th) {
                CloseableReference.closeSafely((CloseableReference<?>) null);
                throw th;
            }
        }

        @Nullable
        private Map<String, String> getExtraMap(ProducerListener2 producerListener2, ProducerContext producerContext, Postprocessor postprocessor) {
            if (producerListener2.requiresExtraMap(producerContext, PostprocessorProducer.NAME)) {
                return ImmutableMap.of(PostprocessorProducer.POSTPROCESSOR, postprocessor.getName());
            }
            return null;
        }

        private boolean shouldPostprocess(CloseableImage closeableImage) {
            return closeableImage instanceof CloseableStaticBitmap;
        }

        private CloseableReference<CloseableImage> postprocessInternal(CloseableImage closeableImage) {
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
            CloseableReference<Bitmap> closeableReferenceProcess = this.mPostprocessor.process(closeableStaticBitmap.getUnderlyingBitmap(), PostprocessorProducer.this.mBitmapFactory);
            try {
                CloseableStaticBitmap closeableStaticBitmapOf = CloseableStaticBitmap.of(closeableReferenceProcess, closeableImage.getQualityInfo(), closeableStaticBitmap.getRotationAngle(), closeableStaticBitmap.getExifOrientation());
                closeableStaticBitmapOf.putExtras(closeableStaticBitmap.getExtras());
                return CloseableReference.of(closeableStaticBitmapOf);
            } finally {
                CloseableReference.closeSafely(closeableReferenceProcess);
            }
        }

        private void maybeNotifyOnNewResult(@Nullable CloseableReference<CloseableImage> closeableReference, int i) {
            boolean zIsLast = isLast(i);
            if ((zIsLast || isClosed()) && !(zIsLast && close())) {
                return;
            }
            getConsumer().onNewResult(closeableReference, i);
        }

        private void maybeNotifyOnFailure(Throwable th) {
            if (close()) {
                getConsumer().onFailure(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void maybeNotifyOnCancellation() {
            if (close()) {
                getConsumer().onCancellation();
            }
        }

        private synchronized boolean isClosed() {
            return this.mIsClosed;
        }

        private boolean close() {
            synchronized (this) {
                if (this.mIsClosed) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.mSourceImageRef;
                this.mSourceImageRef = null;
                this.mIsClosed = true;
                CloseableReference.closeSafely(closeableReference);
                return true;
            }
        }
    }

    class SingleUsePostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        private SingleUsePostprocessorConsumer(PostprocessorConsumer postprocessorConsumer) {
            super(postprocessorConsumer);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@Nullable CloseableReference<CloseableImage> closeableReference, int i) {
            if (isNotLast(i)) {
                return;
            }
            getConsumer().onNewResult(closeableReference, i);
        }
    }

    class RepeatedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> implements RepeatedPostprocessorRunner {
        private boolean mIsClosed;

        @Nullable
        private CloseableReference<CloseableImage> mSourceImageRef;

        private RepeatedPostprocessorConsumer(PostprocessorConsumer postprocessorConsumer, RepeatedPostprocessor repeatedPostprocessor, ProducerContext producerContext) {
            super(postprocessorConsumer);
            this.mIsClosed = false;
            this.mSourceImageRef = null;
            repeatedPostprocessor.setCallback(this);
            producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.RepeatedPostprocessorConsumer.1
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    if (RepeatedPostprocessorConsumer.this.close()) {
                        RepeatedPostprocessorConsumer.this.getConsumer().onCancellation();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            if (isNotLast(i)) {
                return;
            }
            setSourceImageRef(closeableReference);
            updateInternal();
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onFailureImpl(Throwable th) {
            if (close()) {
                getConsumer().onFailure(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onCancellationImpl() {
            if (close()) {
                getConsumer().onCancellation();
            }
        }

        @Override // com.facebook.imagepipeline.request.RepeatedPostprocessorRunner
        public synchronized void update() {
            updateInternal();
        }

        private void updateInternal() {
            synchronized (this) {
                if (this.mIsClosed) {
                    return;
                }
                CloseableReference<CloseableImage> closeableReferenceCloneOrNull = CloseableReference.cloneOrNull(this.mSourceImageRef);
                try {
                    getConsumer().onNewResult(closeableReferenceCloneOrNull, 0);
                } finally {
                    CloseableReference.closeSafely(closeableReferenceCloneOrNull);
                }
            }
        }

        private void setSourceImageRef(CloseableReference<CloseableImage> closeableReference) {
            synchronized (this) {
                if (this.mIsClosed) {
                    return;
                }
                CloseableReference<CloseableImage> closeableReference2 = this.mSourceImageRef;
                this.mSourceImageRef = CloseableReference.cloneOrNull(closeableReference);
                CloseableReference.closeSafely(closeableReference2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean close() {
            synchronized (this) {
                if (this.mIsClosed) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.mSourceImageRef;
                this.mSourceImageRef = null;
                this.mIsClosed = true;
                CloseableReference.closeSafely(closeableReference);
                return true;
            }
        }
    }
}

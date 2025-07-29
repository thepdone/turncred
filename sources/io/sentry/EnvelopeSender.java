package io.sentry;

import io.sentry.cache.EnvelopeCache;
import io.sentry.hints.Flushable;
import io.sentry.hints.Retryable;
import io.sentry.util.HintUtils;
import io.sentry.util.Objects;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class EnvelopeSender extends DirectoryProcessor implements IEnvelopeSender {
    private final IHub hub;
    private final ILogger logger;
    private final ISerializer serializer;

    @Override // io.sentry.DirectoryProcessor
    public /* bridge */ /* synthetic */ void processDirectory(File file) {
        super.processDirectory(file);
    }

    public EnvelopeSender(IHub iHub, ISerializer iSerializer, ILogger iLogger, long j, int i) {
        super(iHub, iLogger, j, i);
        this.hub = (IHub) Objects.requireNonNull(iHub, "Hub is required.");
        this.serializer = (ISerializer) Objects.requireNonNull(iSerializer, "Serializer is required.");
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "Logger is required.");
    }

    @Override // io.sentry.DirectoryProcessor
    protected void processFile(final File file, Hint hint) {
        Class<Retryable> cls;
        ILogger iLogger;
        HintUtils.SentryConsumer sentryConsumer;
        BufferedInputStream bufferedInputStream;
        if (!file.isFile()) {
            this.logger.log(SentryLevel.DEBUG, "'%s' is not a file.", file.getAbsolutePath());
            return;
        }
        if (!isRelevantFileName(file.getName())) {
            this.logger.log(SentryLevel.DEBUG, "File '%s' doesn't match extension expected.", file.getAbsolutePath());
            return;
        }
        try {
            if (!file.getParentFile().canWrite()) {
                this.logger.log(SentryLevel.WARNING, "File '%s' cannot be deleted so it will not be processed.", file.getAbsolutePath());
                return;
            }
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                this.logger.log(SentryLevel.ERROR, e, "File '%s' cannot be found.", file.getAbsolutePath());
                cls = Retryable.class;
                iLogger = this.logger;
                sentryConsumer = new HintUtils.SentryConsumer() { // from class: io.sentry.EnvelopeSender$$ExternalSyntheticLambda1
                    @Override // io.sentry.util.HintUtils.SentryConsumer
                    public final void accept(Object obj) {
                        this.f$0.m5827lambda$processFile$2$iosentryEnvelopeSender(file, (Retryable) obj);
                    }
                };
                HintUtils.runIfHasTypeLogIfNot(hint, cls, iLogger, sentryConsumer);
            } catch (IOException e2) {
                this.logger.log(SentryLevel.ERROR, e2, "I/O on file '%s' failed.", file.getAbsolutePath());
                cls = Retryable.class;
                iLogger = this.logger;
                sentryConsumer = new HintUtils.SentryConsumer() { // from class: io.sentry.EnvelopeSender$$ExternalSyntheticLambda1
                    @Override // io.sentry.util.HintUtils.SentryConsumer
                    public final void accept(Object obj) {
                        this.f$0.m5827lambda$processFile$2$iosentryEnvelopeSender(file, (Retryable) obj);
                    }
                };
                HintUtils.runIfHasTypeLogIfNot(hint, cls, iLogger, sentryConsumer);
            } catch (Throwable th) {
                this.logger.log(SentryLevel.ERROR, th, "Failed to capture cached envelope %s", file.getAbsolutePath());
                HintUtils.runIfHasTypeLogIfNot(hint, Retryable.class, this.logger, new HintUtils.SentryConsumer() { // from class: io.sentry.EnvelopeSender$$ExternalSyntheticLambda2
                    @Override // io.sentry.util.HintUtils.SentryConsumer
                    public final void accept(Object obj) {
                        this.f$0.m5826lambda$processFile$1$iosentryEnvelopeSender(th, file, (Retryable) obj);
                    }
                });
                cls = Retryable.class;
                iLogger = this.logger;
                sentryConsumer = new HintUtils.SentryConsumer() { // from class: io.sentry.EnvelopeSender$$ExternalSyntheticLambda1
                    @Override // io.sentry.util.HintUtils.SentryConsumer
                    public final void accept(Object obj) {
                        this.f$0.m5827lambda$processFile$2$iosentryEnvelopeSender(file, (Retryable) obj);
                    }
                };
                HintUtils.runIfHasTypeLogIfNot(hint, cls, iLogger, sentryConsumer);
            }
            try {
                SentryEnvelope sentryEnvelopeDeserializeEnvelope = this.serializer.deserializeEnvelope(bufferedInputStream);
                if (sentryEnvelopeDeserializeEnvelope == null) {
                    this.logger.log(SentryLevel.ERROR, "Failed to deserialize cached envelope %s", file.getAbsolutePath());
                } else {
                    this.hub.captureEnvelope(sentryEnvelopeDeserializeEnvelope, hint);
                }
                HintUtils.runIfHasTypeLogIfNot(hint, Flushable.class, this.logger, new HintUtils.SentryConsumer() { // from class: io.sentry.EnvelopeSender$$ExternalSyntheticLambda0
                    @Override // io.sentry.util.HintUtils.SentryConsumer
                    public final void accept(Object obj) {
                        this.f$0.m5825lambda$processFile$0$iosentryEnvelopeSender((Flushable) obj);
                    }
                });
                bufferedInputStream.close();
                cls = Retryable.class;
                iLogger = this.logger;
                sentryConsumer = new HintUtils.SentryConsumer() { // from class: io.sentry.EnvelopeSender$$ExternalSyntheticLambda1
                    @Override // io.sentry.util.HintUtils.SentryConsumer
                    public final void accept(Object obj) {
                        this.f$0.m5827lambda$processFile$2$iosentryEnvelopeSender(file, (Retryable) obj);
                    }
                };
                HintUtils.runIfHasTypeLogIfNot(hint, cls, iLogger, sentryConsumer);
            } catch (Throwable th2) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (Throwable th4) {
            HintUtils.runIfHasTypeLogIfNot(hint, Retryable.class, this.logger, new HintUtils.SentryConsumer() { // from class: io.sentry.EnvelopeSender$$ExternalSyntheticLambda1
                @Override // io.sentry.util.HintUtils.SentryConsumer
                public final void accept(Object obj) {
                    this.f$0.m5827lambda$processFile$2$iosentryEnvelopeSender(file, (Retryable) obj);
                }
            });
            throw th4;
        }
    }

    /* renamed from: lambda$processFile$0$io-sentry-EnvelopeSender, reason: not valid java name */
    /* synthetic */ void m5825lambda$processFile$0$iosentryEnvelopeSender(Flushable flushable) {
        if (flushable.waitFlush()) {
            return;
        }
        this.logger.log(SentryLevel.WARNING, "Timed out waiting for envelope submission.", new Object[0]);
    }

    /* renamed from: lambda$processFile$1$io-sentry-EnvelopeSender, reason: not valid java name */
    /* synthetic */ void m5826lambda$processFile$1$iosentryEnvelopeSender(Throwable th, File file, Retryable retryable) {
        retryable.setRetry(false);
        this.logger.log(SentryLevel.INFO, th, "File '%s' won't retry.", file.getAbsolutePath());
    }

    /* renamed from: lambda$processFile$2$io-sentry-EnvelopeSender, reason: not valid java name */
    /* synthetic */ void m5827lambda$processFile$2$iosentryEnvelopeSender(File file, Retryable retryable) {
        if (!retryable.isRetry()) {
            safeDelete(file, "after trying to capture it");
            this.logger.log(SentryLevel.DEBUG, "Deleted file %s.", file.getAbsolutePath());
        } else {
            this.logger.log(SentryLevel.INFO, "File not deleted since retry was marked. %s.", file.getAbsolutePath());
        }
    }

    @Override // io.sentry.DirectoryProcessor
    protected boolean isRelevantFileName(String str) {
        return str.endsWith(EnvelopeCache.SUFFIX_ENVELOPE_FILE);
    }

    @Override // io.sentry.IEnvelopeSender
    public void processEnvelopeFile(String str, Hint hint) {
        Objects.requireNonNull(str, "Path is required.");
        processFile(new File(str), hint);
    }

    private void safeDelete(File file, String str) {
        try {
            if (file.delete()) {
                return;
            }
            this.logger.log(SentryLevel.ERROR, "Failed to delete '%s' %s", file.getAbsolutePath(), str);
        } catch (Throwable th) {
            this.logger.log(SentryLevel.ERROR, th, "Failed to delete '%s' %s", file.getAbsolutePath(), str);
        }
    }
}

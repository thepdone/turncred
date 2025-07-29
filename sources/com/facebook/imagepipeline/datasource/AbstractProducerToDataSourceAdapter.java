package com.facebook.imagepipeline.datasource;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.internal.Preconditions;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.producers.BaseConsumer;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.request.HasImageRequest;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbstractProducerToDataSourceAdapter.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B%\b\u0004\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0002J\u001e\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0002J'\u0010\"\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00018\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014¢\u0006\u0002\u0010&R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006'"}, d2 = {"Lcom/facebook/imagepipeline/datasource/AbstractProducerToDataSourceAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/facebook/datasource/AbstractDataSource;", "Lcom/facebook/imagepipeline/request/HasImageRequest;", "producer", "Lcom/facebook/imagepipeline/producers/Producer;", "settableProducerContext", "Lcom/facebook/imagepipeline/producers/SettableProducerContext;", "requestListener", "Lcom/facebook/imagepipeline/listener/RequestListener2;", "(Lcom/facebook/imagepipeline/producers/Producer;Lcom/facebook/imagepipeline/producers/SettableProducerContext;Lcom/facebook/imagepipeline/listener/RequestListener2;)V", "imageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "getImageRequest", "()Lcom/facebook/imagepipeline/request/ImageRequest;", "getRequestListener", "()Lcom/facebook/imagepipeline/listener/RequestListener2;", "getSettableProducerContext", "()Lcom/facebook/imagepipeline/producers/SettableProducerContext;", "close", "", "createConsumer", "Lcom/facebook/imagepipeline/producers/Consumer;", "getExtras", "", "", "", "producerContext", "Lcom/facebook/imagepipeline/producers/ProducerContext;", "onCancellationImpl", "", "onFailureImpl", "throwable", "", "onNewResultImpl", "result", "status", "", "(Ljava/lang/Object;ILcom/facebook/imagepipeline/producers/ProducerContext;)V", "imagepipeline_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class AbstractProducerToDataSourceAdapter<T> extends AbstractDataSource<T> implements HasImageRequest {
    private final RequestListener2 requestListener;
    private final SettableProducerContext settableProducerContext;

    public final SettableProducerContext getSettableProducerContext() {
        return this.settableProducerContext;
    }

    public final RequestListener2 getRequestListener() {
        return this.requestListener;
    }

    protected AbstractProducerToDataSourceAdapter(Producer<T> producer, SettableProducerContext settableProducerContext, RequestListener2 requestListener) {
        Intrinsics.checkNotNullParameter(producer, "producer");
        Intrinsics.checkNotNullParameter(settableProducerContext, "settableProducerContext");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        this.settableProducerContext = settableProducerContext;
        this.requestListener = requestListener;
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            setExtras(settableProducerContext.getExtras());
            FrescoSystrace frescoSystrace2 = FrescoSystrace.INSTANCE;
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()->onRequestStart");
                try {
                    requestListener.onRequestStart(settableProducerContext);
                    Unit unit = Unit.INSTANCE;
                } finally {
                }
            } else {
                requestListener.onRequestStart(settableProducerContext);
            }
            FrescoSystrace frescoSystrace3 = FrescoSystrace.INSTANCE;
            if (!FrescoSystrace.isTracing()) {
                producer.produceResults(createConsumer(), settableProducerContext);
                return;
            }
            FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()->produceResult");
            try {
                producer.produceResults(createConsumer(), settableProducerContext);
                Unit unit2 = Unit.INSTANCE;
                return;
            } finally {
            }
        }
        FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()");
        try {
            setExtras(settableProducerContext.getExtras());
            FrescoSystrace frescoSystrace4 = FrescoSystrace.INSTANCE;
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()->onRequestStart");
                requestListener.onRequestStart(settableProducerContext);
                Unit unit3 = Unit.INSTANCE;
                FrescoSystrace.endSection();
            } else {
                requestListener.onRequestStart(settableProducerContext);
            }
            FrescoSystrace frescoSystrace5 = FrescoSystrace.INSTANCE;
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()->produceResult");
                producer.produceResults(createConsumer(), settableProducerContext);
                Unit unit4 = Unit.INSTANCE;
                FrescoSystrace.endSection();
            } else {
                producer.produceResults(createConsumer(), settableProducerContext);
            }
            Unit unit5 = Unit.INSTANCE;
        } catch (Throwable th) {
            throw th;
        } finally {
        }
    }

    private final Consumer<T> createConsumer() {
        return new BaseConsumer<T>(this) { // from class: com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter.createConsumer.1
            final /* synthetic */ AbstractProducerToDataSourceAdapter<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            protected void onNewResultImpl(T newResult, int status) {
                AbstractProducerToDataSourceAdapter<T> abstractProducerToDataSourceAdapter = this.this$0;
                abstractProducerToDataSourceAdapter.onNewResultImpl(newResult, status, abstractProducerToDataSourceAdapter.getSettableProducerContext());
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            protected void onFailureImpl(Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                this.this$0.onFailureImpl(throwable);
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            protected void onCancellationImpl() {
                this.this$0.onCancellationImpl();
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            protected void onProgressUpdateImpl(float progress) {
                this.this$0.setProgress(progress);
            }
        };
    }

    protected void onNewResultImpl(T result, int status, ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        boolean zIsLast = BaseConsumer.isLast(status);
        if (super.setResult(result, zIsLast, getExtras(producerContext)) && zIsLast) {
            this.requestListener.onRequestSuccess(this.settableProducerContext);
        }
    }

    protected final Map<String, Object> getExtras(ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        return producerContext.getExtras();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFailureImpl(Throwable throwable) {
        if (super.setFailure(throwable, getExtras(this.settableProducerContext))) {
            this.requestListener.onRequestFailure(this.settableProducerContext, throwable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void onCancellationImpl() {
        Preconditions.checkState(isClosed());
    }

    @Override // com.facebook.imagepipeline.request.HasImageRequest
    public ImageRequest getImageRequest() {
        return this.settableProducerContext.getImageRequest();
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public boolean close() {
        if (!super.close()) {
            return false;
        }
        if (super.isFinished()) {
            return true;
        }
        this.requestListener.onRequestCancellation(this.settableProducerContext);
        this.settableProducerContext.cancel();
        return true;
    }
}

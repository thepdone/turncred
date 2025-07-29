package com.facebook.imagepipeline.datasource;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProducerToDataSourceAdapter.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \n*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\nB%\b\u0002\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/facebook/imagepipeline/datasource/ProducerToDataSourceAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/facebook/imagepipeline/datasource/AbstractProducerToDataSourceAdapter;", "producer", "Lcom/facebook/imagepipeline/producers/Producer;", "settableProducerContext", "Lcom/facebook/imagepipeline/producers/SettableProducerContext;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/facebook/imagepipeline/listener/RequestListener2;", "(Lcom/facebook/imagepipeline/producers/Producer;Lcom/facebook/imagepipeline/producers/SettableProducerContext;Lcom/facebook/imagepipeline/listener/RequestListener2;)V", "Companion", "imagepipeline_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ProducerToDataSourceAdapter<T> extends AbstractProducerToDataSourceAdapter<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ ProducerToDataSourceAdapter(Producer producer, SettableProducerContext settableProducerContext, RequestListener2 requestListener2, DefaultConstructorMarker defaultConstructorMarker) {
        this(producer, settableProducerContext, requestListener2);
    }

    @JvmStatic
    public static final <T> DataSource<T> create(Producer<T> producer, SettableProducerContext settableProducerContext, RequestListener2 requestListener2) {
        return INSTANCE.create(producer, settableProducerContext, requestListener2);
    }

    /* compiled from: ProducerToDataSourceAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/facebook/imagepipeline/datasource/ProducerToDataSourceAdapter$Companion;", "", "()V", "create", "Lcom/facebook/datasource/DataSource;", ExifInterface.GPS_DIRECTION_TRUE, "producer", "Lcom/facebook/imagepipeline/producers/Producer;", "settableProducerContext", "Lcom/facebook/imagepipeline/producers/SettableProducerContext;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/facebook/imagepipeline/listener/RequestListener2;", "imagepipeline_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final <T> DataSource<T> create(Producer<T> producer, SettableProducerContext settableProducerContext, RequestListener2 listener) {
            Intrinsics.checkNotNullParameter(producer, "producer");
            Intrinsics.checkNotNullParameter(settableProducerContext, "settableProducerContext");
            Intrinsics.checkNotNullParameter(listener, "listener");
            return new ProducerToDataSourceAdapter(producer, settableProducerContext, listener, null);
        }
    }

    private ProducerToDataSourceAdapter(Producer<T> producer, SettableProducerContext settableProducerContext, RequestListener2 requestListener2) {
        super(producer, settableProducerContext, requestListener2);
    }
}

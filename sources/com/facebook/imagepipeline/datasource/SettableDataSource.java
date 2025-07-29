package com.facebook.imagepipeline.datasource;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettableDataSource.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0007\u0018\u0000 \u0012*\u0004\b\u0000\u0010\u00012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00030\u0002:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0014J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J\u0016\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0013"}, d2 = {"Lcom/facebook/imagepipeline/datasource/SettableDataSource;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/facebook/datasource/AbstractDataSource;", "Lcom/facebook/common/references/CloseableReference;", "()V", "closeResult", "", "result", "getResult", "set", "", "valueRef", "setException", "throwable", "", "setProgress", "progress", "", "Companion", "imagepipeline_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SettableDataSource<T> extends AbstractDataSource<CloseableReference<T>> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ SettableDataSource(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final <V> SettableDataSource<V> create() {
        return INSTANCE.create();
    }

    private SettableDataSource() {
    }

    public final boolean set(CloseableReference<T> valueRef) {
        return super.setResult(CloseableReference.cloneOrNull(valueRef), true, null);
    }

    public final boolean setException(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        return super.setFailure(throwable);
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public boolean setProgress(float progress) {
        return super.setProgress(progress);
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public CloseableReference<T> getResult() {
        return CloseableReference.cloneOrNull((CloseableReference) super.getResult());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.datasource.AbstractDataSource
    public void closeResult(CloseableReference<T> result) {
        CloseableReference.closeSafely((CloseableReference<?>) result);
    }

    /* compiled from: SettableDataSource.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/facebook/imagepipeline/datasource/SettableDataSource$Companion;", "", "()V", "create", "Lcom/facebook/imagepipeline/datasource/SettableDataSource;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "imagepipeline_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final <V> SettableDataSource<V> create() {
            return new SettableDataSource<>(null);
        }
    }
}

package com.mrousavy.camera.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraError.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/mrousavy/camera/core/CameraError;", "", "domain", "", "id", "message", "cause", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "code", "getCode", "()Ljava/lang/String;", "getDomain", "getId", "getMessage", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class CameraError extends Throwable {
    private final String domain;
    private final String id;
    private final String message;

    public /* synthetic */ CameraError(String str, String str2, String str3, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : th);
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getId() {
        return this.id;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraError(String domain, String id, String message, Throwable th) {
        super("[" + domain + "/" + id + "] " + message, th);
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(message, "message");
        this.domain = domain;
        this.id = id;
        this.message = message;
    }

    public final String getCode() {
        return this.domain + "/" + this.id;
    }
}

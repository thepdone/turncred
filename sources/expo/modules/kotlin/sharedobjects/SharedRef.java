package expo.modules.kotlin.sharedobjects;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.RuntimeContext;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharedRef.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0017\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lexpo/modules/kotlin/sharedobjects/SharedRef;", "RefType", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "ref", "appContext", "Lexpo/modules/kotlin/AppContext;", "(Ljava/lang/Object;Lexpo/modules/kotlin/AppContext;)V", "runtimeContext", "Lexpo/modules/kotlin/RuntimeContext;", "(Ljava/lang/Object;Lexpo/modules/kotlin/RuntimeContext;)V", "nativeRefType", "", "getNativeRefType", "()Ljava/lang/String;", "getRef", "()Ljava/lang/Object;", "Ljava/lang/Object;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class SharedRef<RefType> extends SharedObject {
    public static final int $stable = 0;
    private final String nativeRefType;
    private final RefType ref;

    public /* synthetic */ SharedRef(Object obj, RuntimeContext runtimeContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? null : runtimeContext);
    }

    public final RefType getRef() {
        return this.ref;
    }

    public SharedRef(RefType reftype, RuntimeContext runtimeContext) {
        super(runtimeContext);
        this.ref = reftype;
        this.nativeRefType = "unknown";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedRef(RefType reftype, AppContext appContext) {
        this(reftype, appContext.getHostingRuntimeContext());
        Intrinsics.checkNotNullParameter(appContext, "appContext");
    }

    public String getNativeRefType() {
        return this.nativeRefType;
    }
}

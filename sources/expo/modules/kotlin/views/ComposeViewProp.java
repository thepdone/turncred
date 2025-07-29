package expo.modules.kotlin.views;

import android.view.View;
import androidx.compose.runtime.MutableState;
import com.facebook.react.bridge.Dynamic;
import expo.modules.core.logging.Logger;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.PropSetException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.types.AnyType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty1;

/* compiled from: ComposeViewProp.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007¢\u0006\u0002\u0010\bJ\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lexpo/modules/kotlin/views/ComposeViewProp;", "Lexpo/modules/kotlin/views/AnyViewProp;", "name", "", "anyType", "Lexpo/modules/kotlin/types/AnyType;", "property", "Lkotlin/reflect/KProperty1;", "(Ljava/lang/String;Lexpo/modules/kotlin/types/AnyType;Lkotlin/reflect/KProperty1;)V", "isNullable", "", "()Z", "getProperty", "()Lkotlin/reflect/KProperty1;", "set", "", "prop", "Lcom/facebook/react/bridge/Dynamic;", "onView", "Landroid/view/View;", "appContext", "Lexpo/modules/kotlin/AppContext;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposeViewProp extends AnyViewProp {
    public static final int $stable = 8;
    private final boolean isNullable;
    private final KProperty1<?, ?> property;

    public final KProperty1<?, ?> getProperty() {
        return this.property;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposeViewProp(String name, AnyType anyType, KProperty1<?, ?> property) {
        super(name, anyType);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(anyType, "anyType");
        Intrinsics.checkNotNullParameter(property, "property");
        this.property = property;
        this.isNullable = anyType.getKType().getIsMarkedNullable();
    }

    @Override // expo.modules.kotlin.views.AnyViewProp
    public void set(Dynamic prop, View onView, AppContext appContext) throws PropSetException {
        UnexpectedException unexpectedException;
        Intrinsics.checkNotNullParameter(prop, "prop");
        Intrinsics.checkNotNullParameter(onView, "onView");
        try {
            ComposeProps props = ((ExpoComposeView) onView).getProps();
            if (props == null) {
                return;
            }
            Object objCall = this.property.getGetter().call(props);
            if (objCall instanceof MutableState) {
                ((MutableState) objCall).setValue(getType().convert(prop, appContext));
            } else {
                Logger.warn$default(CoreLoggerKt.getLogger(), "⚠️ Property " + getName() + " is not a MutableState in " + onView.getClass(), null, 2, null);
            }
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th) {
            if (th instanceof CodedException) {
                unexpectedException = (CodedException) th;
            } else if (th instanceof expo.modules.core.errors.CodedException) {
                String code = ((expo.modules.core.errors.CodedException) th).getCode();
                Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                unexpectedException = new CodedException(code, th.getMessage(), th.getCause());
            } else {
                unexpectedException = new UnexpectedException(th);
            }
            throw new PropSetException(getName(), Reflection.getOrCreateKotlinClass(onView.getClass()), unexpectedException);
        }
    }

    @Override // expo.modules.kotlin.views.AnyViewProp
    /* renamed from: isNullable, reason: from getter */
    public boolean getIsNullable() {
        return this.isNullable;
    }
}

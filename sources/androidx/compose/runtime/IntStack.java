package androidx.compose.runtime;

import com.facebook.hermes.intl.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.rrweb.RRWebVideoEvent;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Stack.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/runtime/IntStack;", "", "()V", RRWebVideoEvent.JsonKeys.SIZE, "", "getSize", "()I", "slots", "", "tos", "clear", "", "indexOf", "value", "isEmpty", "", "isNotEmpty", "peek", FirebaseAnalytics.Param.INDEX, "peek2", "peekOr", Constants.COLLATION_DEFAULT, "pop", "push", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IntStack {
    public static final int $stable = 8;
    private int[] slots = new int[10];
    private int tos;

    /* renamed from: getSize, reason: from getter */
    public final int getTos() {
        return this.tos;
    }

    public final void push(int value) {
        int i = this.tos;
        int[] iArr = this.slots;
        if (i >= iArr.length) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.slots = iArrCopyOf;
        }
        int[] iArr2 = this.slots;
        int i2 = this.tos;
        this.tos = i2 + 1;
        iArr2[i2] = value;
    }

    public final int pop() {
        int[] iArr = this.slots;
        int i = this.tos - 1;
        this.tos = i;
        return iArr[i];
    }

    public final int peekOr(int i) {
        return this.tos > 0 ? peek() : i;
    }

    public final int peek() {
        return this.slots[this.tos - 1];
    }

    public final int peek2() {
        return this.slots[this.tos - 2];
    }

    public final int peek(int index) {
        return this.slots[index];
    }

    public final boolean isEmpty() {
        return this.tos == 0;
    }

    public final boolean isNotEmpty() {
        return this.tos != 0;
    }

    public final void clear() {
        this.tos = 0;
    }

    public final int indexOf(int value) {
        int i = this.tos;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.slots[i2] == value) {
                return i2;
            }
        }
        return -1;
    }
}

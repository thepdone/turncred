package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: LifecycleEffect.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0007¢\u0006\u0002\u0010\u000b\u001a0\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a:\u0010\f\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0015\u001aD\u0010\f\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0017\u001aN\u0010\f\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0019\u001aH\u0010\f\u001a\u00020\u00042\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u001b\"\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u001c\u001a6\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u000f2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0003¢\u0006\u0002\u0010\u001f\u001a0\u0010 \u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a:\u0010 \u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0015\u001aD\u0010 \u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0017\u001aN\u0010 \u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0019\u001aH\u0010 \u001a\u00020\u00042\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u001b\"\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u001c\u001a6\u0010#\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020!2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0002\b\u0011H\u0003¢\u0006\u0002\u0010$\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006%²\u0006\u0010\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u008a\u0084\u0002"}, d2 = {"LifecycleResumeEffectNoParamError", "", "LifecycleStartEffectNoParamError", "LifecycleEventEffect", "", NotificationCompat.CATEGORY_EVENT, "Landroidx/lifecycle/Lifecycle$Event;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onEvent", "Lkotlin/Function0;", "(Landroidx/lifecycle/Lifecycle$Event;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "LifecycleResumeEffect", "effects", "Lkotlin/Function1;", "Landroidx/lifecycle/compose/LifecycleResumePauseEffectScope;", "Landroidx/lifecycle/compose/LifecyclePauseOrDisposeEffectResult;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "key1", "", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "keys", "", "([Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LifecycleResumeEffectImpl", "scope", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/compose/LifecycleResumePauseEffectScope;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "LifecycleStartEffect", "Landroidx/lifecycle/compose/LifecycleStartStopEffectScope;", "Landroidx/lifecycle/compose/LifecycleStopOrDisposeEffectResult;", "LifecycleStartEffectImpl", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/compose/LifecycleStartStopEffectScope;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "lifecycle-runtime-compose_release", "currentOnEvent"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LifecycleEffectKt {
    private static final String LifecycleResumeEffectNoParamError = "LifecycleResumeEffect must provide one or more 'key' parameters that define the identity of the LifecycleResumeEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";
    private static final String LifecycleStartEffectNoParamError = "LifecycleStartEffect must provide one or more 'key' parameters that define the identity of the LifecycleStartEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";

    /* JADX WARN: Removed duplicated region for block: B:53:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void LifecycleEventEffect(final androidx.lifecycle.Lifecycle.Event r7, androidx.lifecycle.LifecycleOwner r8, final kotlin.jvm.functions.Function0<kotlin.Unit> r9, androidx.compose.runtime.Composer r10, final int r11, final int r12) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleEventEffect(androidx.lifecycle.Lifecycle$Event, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void LifecycleStartEffect(final java.lang.Object r7, androidx.lifecycle.LifecycleOwner r8, final kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleStartStopEffectScope, ? extends androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult> r9, androidx.compose.runtime.Composer r10, final int r11, final int r12) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect(java.lang.Object, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void LifecycleStartEffect(final java.lang.Object r8, final java.lang.Object r9, androidx.lifecycle.LifecycleOwner r10, final kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleStartStopEffectScope, ? extends androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult> r11, androidx.compose.runtime.Composer r12, final int r13, final int r14) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect(java.lang.Object, java.lang.Object, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void LifecycleStartEffect(final java.lang.Object r11, final java.lang.Object r12, final java.lang.Object r13, androidx.lifecycle.LifecycleOwner r14, final kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleStartStopEffectScope, ? extends androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult> r15, androidx.compose.runtime.Composer r16, final int r17, final int r18) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect(java.lang.Object, java.lang.Object, java.lang.Object, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00dd A[LOOP:1: B:55:0x00db->B:56:0x00dd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void LifecycleStartEffect(final java.lang.Object[] r7, androidx.lifecycle.LifecycleOwner r8, final kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleStartStopEffectScope, ? extends androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult> r9, androidx.compose.runtime.Composer r10, final int r11, final int r12) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect(java.lang.Object[], androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = LifecycleStartEffectNoParamError)
    public static final void LifecycleStartEffect(final LifecycleOwner lifecycleOwner, final Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-50807951);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LifecycleStartEffect)P(1)348@16079L7:LifecycleEffect.kt#2vxrgp");
        int i3 = i & 1;
        if (i3 == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffect.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i4) {
                        LifecycleEffectKt.LifecycleStartEffect(lifecycleOwner, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        composerStartRestartGroup.startDefaults();
        if (i3 != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
            composerStartRestartGroup.skipToGroupEnd();
            if ((i2 & 1) != 0) {
                i &= -15;
            }
        } else if ((i2 & 1) != 0) {
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            i &= -15;
        }
        composerStartRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-50807951, i, -1, "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:350)");
        }
        throw new IllegalStateException(LifecycleStartEffectNoParamError.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LifecycleStartEffectImpl(final LifecycleOwner lifecycleOwner, final LifecycleStartStopEffectScope lifecycleStartStopEffectScope, final Function1<? super LifecycleStartStopEffectScope, ? extends LifecycleStopOrDisposeEffectResult> function1, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(228371534);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LifecycleStartEffectImpl)P(1,2)358@16483L661,358@16443L701:LifecycleEffect.kt#2vxrgp");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(lifecycleOwner) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(lifecycleStartStopEffectScope) ? 32 : 16;
        }
        if ((i & BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(228371534, i2, -1, "androidx.lifecycle.compose.LifecycleStartEffectImpl (LifecycleEffect.kt:357)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1076218333, "CC(remember):LifecycleEffect.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(lifecycleStartStopEffectScope) | ((i2 & 896) == 256) | composerStartRestartGroup.changedInstance(lifecycleOwner);
            LifecycleEffectKt$LifecycleStartEffectImpl$1$1 lifecycleEffectKt$LifecycleStartEffectImpl$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || lifecycleEffectKt$LifecycleStartEffectImpl$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                lifecycleEffectKt$LifecycleStartEffectImpl$1$1RememberedValue = new LifecycleEffectKt$LifecycleStartEffectImpl$1$1(lifecycleOwner, lifecycleStartStopEffectScope, function1);
                composerStartRestartGroup.updateRememberedValue(lifecycleEffectKt$LifecycleStartEffectImpl$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(lifecycleOwner, lifecycleStartStopEffectScope, (Function1) lifecycleEffectKt$LifecycleStartEffectImpl$1$1RememberedValue, composerStartRestartGroup, i2 & WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleStartEffectImpl.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    LifecycleEffectKt.LifecycleStartEffectImpl(lifecycleOwner, lifecycleStartStopEffectScope, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void LifecycleResumeEffect(final java.lang.Object r7, androidx.lifecycle.LifecycleOwner r8, final kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleResumePauseEffectScope, ? extends androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult> r9, androidx.compose.runtime.Composer r10, final int r11, final int r12) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect(java.lang.Object, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void LifecycleResumeEffect(final java.lang.Object r8, final java.lang.Object r9, androidx.lifecycle.LifecycleOwner r10, final kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleResumePauseEffectScope, ? extends androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult> r11, androidx.compose.runtime.Composer r12, final int r13, final int r14) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect(java.lang.Object, java.lang.Object, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void LifecycleResumeEffect(final java.lang.Object r11, final java.lang.Object r12, final java.lang.Object r13, androidx.lifecycle.LifecycleOwner r14, final kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleResumePauseEffectScope, ? extends androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult> r15, androidx.compose.runtime.Composer r16, final int r17, final int r18) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect(java.lang.Object, java.lang.Object, java.lang.Object, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00dd A[LOOP:1: B:55:0x00db->B:56:0x00dd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void LifecycleResumeEffect(final java.lang.Object[] r7, androidx.lifecycle.LifecycleOwner r8, final kotlin.jvm.functions.Function1<? super androidx.lifecycle.compose.LifecycleResumePauseEffectScope, ? extends androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult> r9, androidx.compose.runtime.Composer r10, final int r11, final int r12) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect(java.lang.Object[], androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = LifecycleResumeEffectNoParamError)
    public static final void LifecycleResumeEffect(final LifecycleOwner lifecycleOwner, final Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> function1, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-747476210);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LifecycleResumeEffect)P(1)680@31558L7:LifecycleEffect.kt#2vxrgp");
        int i3 = i & 1;
        if (i3 == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffect.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i4) {
                        LifecycleEffectKt.LifecycleResumeEffect(lifecycleOwner, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        composerStartRestartGroup.startDefaults();
        if (i3 != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
            composerStartRestartGroup.skipToGroupEnd();
            if ((i2 & 1) != 0) {
                i &= -15;
            }
        } else if ((i2 & 1) != 0) {
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            i &= -15;
        }
        composerStartRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-747476210, i, -1, "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:682)");
        }
        throw new IllegalStateException(LifecycleResumeEffectNoParamError.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LifecycleResumeEffectImpl(final LifecycleOwner lifecycleOwner, final LifecycleResumePauseEffectScope lifecycleResumePauseEffectScope, final Function1<? super LifecycleResumePauseEffectScope, ? extends LifecyclePauseOrDisposeEffectResult> function1, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(912823238);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LifecycleResumeEffectImpl)P(1,2)690@31972L670,690@31932L710:LifecycleEffect.kt#2vxrgp");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(lifecycleOwner) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(lifecycleResumePauseEffectScope) ? 32 : 16;
        }
        if ((i & BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(912823238, i2, -1, "androidx.lifecycle.compose.LifecycleResumeEffectImpl (LifecycleEffect.kt:689)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 657407937, "CC(remember):LifecycleEffect.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(lifecycleResumePauseEffectScope) | ((i2 & 896) == 256) | composerStartRestartGroup.changedInstance(lifecycleOwner);
            LifecycleEffectKt$LifecycleResumeEffectImpl$1$1 lifecycleEffectKt$LifecycleResumeEffectImpl$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || lifecycleEffectKt$LifecycleResumeEffectImpl$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                lifecycleEffectKt$LifecycleResumeEffectImpl$1$1RememberedValue = new LifecycleEffectKt$LifecycleResumeEffectImpl$1$1(lifecycleOwner, lifecycleResumePauseEffectScope, function1);
                composerStartRestartGroup.updateRememberedValue(lifecycleEffectKt$LifecycleResumeEffectImpl$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(lifecycleOwner, lifecycleResumePauseEffectScope, (Function1) lifecycleEffectKt$LifecycleResumeEffectImpl$1$1RememberedValue, composerStartRestartGroup, i2 & WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.lifecycle.compose.LifecycleEffectKt.LifecycleResumeEffectImpl.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    LifecycleEffectKt.LifecycleResumeEffectImpl(lifecycleOwner, lifecycleResumePauseEffectScope, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> LifecycleEventEffect$lambda$0(State<? extends Function0<Unit>> state) {
        return state.getValue();
    }
}

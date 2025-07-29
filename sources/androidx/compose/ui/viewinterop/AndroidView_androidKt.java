package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.react.uimanager.ViewProps;
import com.nimbusds.jose.jwk.gen.OctetSequenceKeyGenerator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidView.android.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ay\u0010\u0007\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u00012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010\u0010\u001aK\u0010\u0007\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010\u0011\u001a1\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u0001H\u0003¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\b0\u0017\"\b\b\u0000\u0010\b*\u00020\u0002*\u00020\u0014H\u0002\u001a^\u0010\u0018\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00140\u00192\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002ø\u0001\u0000¢\u0006\u0004\b&\u0010'\"\"\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"NoOpUpdate", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "getNoOpUpdate", "()Lkotlin/jvm/functions/Function1;", "AndroidView", ExifInterface.GPS_DIRECTION_TRUE, "factory", "Landroid/content/Context;", "modifier", "Landroidx/compose/ui/Modifier;", "onReset", "onRelease", "update", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "createAndroidViewNodeFactory", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "requireViewFactoryHolder", "Landroidx/compose/ui/viewinterop/ViewFactoryHolder;", "updateViewHolderParams", "Landroidx/compose/runtime/Updater;", "compositeKeyHash", "", "density", "Landroidx/compose/ui/unit/Density;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", ViewProps.LAYOUT_DIRECTION, "Landroidx/compose/ui/unit/LayoutDirection;", "compositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "updateViewHolderParams-6NefGtU", "(Landroidx/compose/runtime/Composer;Landroidx/compose/ui/Modifier;ILandroidx/compose/ui/unit/Density;Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/runtime/CompositionLocalMap;)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AndroidView_androidKt {
    private static final Function1<View, Unit> NoOpUpdate = new Function1<View, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$NoOpUpdate$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.INSTANCE;
        }
    };

    public static final <T extends View> void AndroidView(final Function1<? super Context, ? extends T> function1, Modifier modifier, Function1<? super T, Unit> function12, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1783766393);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AndroidView)108@5537L130:AndroidView.android.kt#z33iqn");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
        } else if ((i & BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function12) ? 256 : 128;
        }
        if ((i3 & 147) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i5 != 0) {
                function12 = NoOpUpdate;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1783766393, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:107)");
            }
            AndroidView(function1, modifier, null, NoOpUpdate, function12, composerStartRestartGroup, (i3 & 14) | 3072 | (i3 & OctetSequenceKeyGenerator.MIN_KEY_SIZE_BITS) | ((i3 << 6) & 57344), 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        final Function1<? super T, Unit> function13 = function12;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView.1
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

                public final void invoke(Composer composer2, int i6) {
                    AndroidView_androidKt.AndroidView(function1, modifier2, function13, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T extends android.view.View> void AndroidView(final kotlin.jvm.functions.Function1<? super android.content.Context, ? extends T> r21, androidx.compose.ui.Modifier r22, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r23, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r24, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 523
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final <T extends View> Function0<LayoutNode> createAndroidViewNodeFactory(final Function1<? super Context, ? extends T> function1, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2030558801, "C(createAndroidViewNodeFactory)267@14499L23,268@14554L7,269@14588L28,270@14668L7,271@14706L7,273@14726L297:AndroidView.android.kt#z33iqn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2030558801, i, -1, "androidx.compose.ui.viewinterop.createAndroidViewNodeFactory (AndroidView.android.kt:266)");
        }
        final int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Context context = (Context) objConsume;
        final CompositionContext compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composer, 0);
        ProvidableCompositionLocal<SaveableStateRegistry> localSaveableStateRegistry = SaveableStateRegistryKt.getLocalSaveableStateRegistry();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localSaveableStateRegistry);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) objConsume2;
        ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume3 = composer.consume(localView);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final View view = (View) objConsume3;
        ComposerKt.sourceInformationMarkerStart(composer, -1137327224, "CC(remember):AndroidView.android.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(context) | ((((i & 14) ^ 6) > 4 && composer.changed(function1)) || (i & 6) == 4) | composer.changedInstance(compositionContextRememberCompositionContext) | composer.changedInstance(saveableStateRegistry) | composer.changed(currentCompositeKeyHash) | composer.changedInstance(view);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function0) new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$createAndroidViewNodeFactory$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final LayoutNode invoke() {
                    Context context2 = context;
                    Function1<Context, T> function12 = function1;
                    CompositionContext compositionContext = compositionContextRememberCompositionContext;
                    SaveableStateRegistry saveableStateRegistry2 = saveableStateRegistry;
                    int i2 = currentCompositeKeyHash;
                    KeyEvent.Callback callback = view;
                    Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type androidx.compose.ui.node.Owner");
                    return new ViewFactoryHolder(context2, function12, compositionContext, saveableStateRegistry2, i2, (Owner) callback).getLayoutNode();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function0<LayoutNode> function0 = (Function0) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return function0;
    }

    /* renamed from: updateViewHolderParams-6NefGtU, reason: not valid java name */
    private static final <T extends View> void m4986updateViewHolderParams6NefGtU(Composer composer, Modifier modifier, int i, Density density, LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner, LayoutDirection layoutDirection, CompositionLocalMap compositionLocalMap) {
        Updater.m1776setimpl(composer, compositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m1776setimpl(composer, modifier, new Function2<LayoutNode, Modifier, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Modifier modifier2) {
                invoke2(layoutNode, modifier2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutNode layoutNode, Modifier modifier2) {
                AndroidView_androidKt.requireViewFactoryHolder(layoutNode).setModifier(modifier2);
            }
        });
        Updater.m1776setimpl(composer, density, new Function2<LayoutNode, Density, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Density density2) {
                invoke2(layoutNode, density2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutNode layoutNode, Density density2) {
                AndroidView_androidKt.requireViewFactoryHolder(layoutNode).setDensity(density2);
            }
        });
        Updater.m1776setimpl(composer, lifecycleOwner, new Function2<LayoutNode, LifecycleOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LifecycleOwner lifecycleOwner2) {
                invoke2(layoutNode, lifecycleOwner2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutNode layoutNode, LifecycleOwner lifecycleOwner2) {
                AndroidView_androidKt.requireViewFactoryHolder(layoutNode).setLifecycleOwner(lifecycleOwner2);
            }
        });
        Updater.m1776setimpl(composer, savedStateRegistryOwner, new Function2<LayoutNode, SavedStateRegistryOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, SavedStateRegistryOwner savedStateRegistryOwner2) {
                invoke2(layoutNode, savedStateRegistryOwner2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutNode layoutNode, SavedStateRegistryOwner savedStateRegistryOwner2) {
                AndroidView_androidKt.requireViewFactoryHolder(layoutNode).setSavedStateRegistryOwner(savedStateRegistryOwner2);
            }
        });
        Updater.m1776setimpl(composer, layoutDirection, new Function2<LayoutNode, LayoutDirection, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$5

            /* compiled from: AndroidView.android.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LayoutDirection.values().length];
                    try {
                        iArr[LayoutDirection.Ltr.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[LayoutDirection.Rtl.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LayoutDirection layoutDirection2) {
                invoke2(layoutNode, layoutDirection2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutNode layoutNode, LayoutDirection layoutDirection2) {
                ViewFactoryHolder viewFactoryHolderRequireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
                int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection2.ordinal()];
                int i3 = 1;
                if (i2 == 1) {
                    i3 = 0;
                } else if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                viewFactoryHolderRequireViewFactoryHolder.setLayoutDirection(i3);
            }
        });
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(i))) {
            composer.updateRememberedValue(Integer.valueOf(i));
            composer.apply(Integer.valueOf(i), setCompositeKeyHash);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends View> ViewFactoryHolder<T> requireViewFactoryHolder(LayoutNode layoutNode) {
        AndroidViewHolder interopViewFactoryHolder = layoutNode.getInteropViewFactoryHolder();
        if (interopViewFactoryHolder != null) {
            return (ViewFactoryHolder) interopViewFactoryHolder;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    }

    public static final Function1<View, Unit> getNoOpUpdate() {
        return NoOpUpdate;
    }
}

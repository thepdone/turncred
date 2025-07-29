package io.sentry.android.replay.viewhierarchy;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SentryReplayOptions;
import io.sentry.android.replay.SentryReplayModifiers;
import io.sentry.android.replay.util.ComposeTextLayout;
import io.sentry.android.replay.util.NodesKt;
import io.sentry.android.replay.util.TextAttributes;
import io.sentry.android.replay.util.ViewsKt;
import io.sentry.android.replay.viewhierarchy.ViewHierarchyNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ComposeViewHierarchyNode.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u0014\u0010\u0013\u001a\u00020\u0014*\u00020\b2\u0006\u0010\u0015\u001a\u00020\rH\u0002J\u001c\u0010\u0016\u001a\u00020\r*\u00020\b2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J$\u0010\u0017\u001a\u00020\u0018*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lio/sentry/android/replay/viewhierarchy/ComposeViewHierarchyNode;", "", "()V", "_rootCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "fromComposeNode", "Lio/sentry/android/replay/viewhierarchy/ViewHierarchyNode;", "node", "Landroidx/compose/ui/node/LayoutNode;", "parent", "distance", "", "isComposeRoot", "", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lio/sentry/SentryOptions;", "fromView", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "getProxyClassName", "", "isImage", "shouldMask", "traverse", "", "parentNode", "sentry-android-replay_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposeViewHierarchyNode {
    public static final ComposeViewHierarchyNode INSTANCE = new ComposeViewHierarchyNode();
    private static LayoutCoordinates _rootCoordinates;

    private ComposeViewHierarchyNode() {
    }

    private final String getProxyClassName(LayoutNode layoutNode, boolean z) {
        SemanticsConfiguration collapsedSemantics$ui_release;
        if (z) {
            return SentryReplayOptions.IMAGE_VIEW_CLASS_NAME;
        }
        SemanticsConfiguration collapsedSemantics$ui_release2 = layoutNode.getCollapsedSemantics$ui_release();
        return ((collapsedSemantics$ui_release2 == null || !collapsedSemantics$ui_release2.contains(SemanticsProperties.INSTANCE.getText())) && ((collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release()) == null || !collapsedSemantics$ui_release.contains(SemanticsActions.INSTANCE.getSetText()))) ? AndroidComposeViewAccessibilityDelegateCompat.ClassName : "android.widget.TextView";
    }

    private final boolean shouldMask(LayoutNode layoutNode, boolean z, SentryOptions sentryOptions) {
        SemanticsConfiguration collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release();
        String str = collapsedSemantics$ui_release != null ? (String) SemanticsConfigurationKt.getOrNull(collapsedSemantics$ui_release, SentryReplayModifiers.INSTANCE.getSentryPrivacy()) : null;
        if (Intrinsics.areEqual(str, "unmask")) {
            return false;
        }
        if (Intrinsics.areEqual(str, "mask")) {
            return true;
        }
        String proxyClassName = getProxyClassName(layoutNode, z);
        if (sentryOptions.getExperimental().getSessionReplay().getUnmaskViewClasses().contains(proxyClassName)) {
            return false;
        }
        return sentryOptions.getExperimental().getSessionReplay().getMaskViewClasses().contains(proxyClassName);
    }

    private final ViewHierarchyNode fromComposeNode(LayoutNode node, ViewHierarchyNode parent, int distance, boolean isComposeRoot, SentryOptions options) {
        TextLayoutInput layoutInput;
        TextStyle style;
        AccessibilityAction accessibilityAction;
        Function1 function1;
        if (!node.isPlaced() || !node.isAttached()) {
            return null;
        }
        if (isComposeRoot) {
            _rootCoordinates = LayoutCoordinatesKt.findRootCoordinates(node.getCoordinates());
        }
        SemanticsConfiguration collapsedSemantics$ui_release = node.getCollapsedSemantics$ui_release();
        Rect rectBoundsInWindow = NodesKt.boundsInWindow(node.getCoordinates(), _rootCoordinates);
        boolean z = !node.getOuterCoordinator$ui_release().isTransparent() && (collapsedSemantics$ui_release == null || !collapsedSemantics$ui_release.contains(SemanticsProperties.INSTANCE.getInvisibleToUser())) && rectBoundsInWindow.height() > 0 && rectBoundsInWindow.width() > 0;
        boolean z2 = collapsedSemantics$ui_release != null && collapsedSemantics$ui_release.contains(SemanticsActions.INSTANCE.getSetText());
        if ((collapsedSemantics$ui_release != null && collapsedSemantics$ui_release.contains(SemanticsProperties.INSTANCE.getText())) || z2) {
            boolean z3 = z && shouldMask(node, false, options);
            if (parent != null) {
                parent.setImportantForCaptureToAncestors(true);
            }
            ArrayList arrayList = new ArrayList();
            if (collapsedSemantics$ui_release != null && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(collapsedSemantics$ui_release, SemanticsActions.INSTANCE.getGetTextLayoutResult())) != null && (function1 = (Function1) accessibilityAction.getAction()) != null) {
            }
            TextAttributes textAttributesFindTextAttributes = NodesKt.findTextAttributes(node);
            Color colorM5902component1QN2ZGVo = textAttributesFindTextAttributes.getColor();
            boolean zComponent2 = textAttributesFindTextAttributes.getHasFillModifier();
            TextLayoutResult textLayoutResult = (TextLayoutResult) CollectionsKt.firstOrNull((List) arrayList);
            Color colorM2266boximpl = (textLayoutResult == null || (layoutInput = textLayoutResult.getLayoutInput()) == null || (style = layoutInput.getStyle()) == null) ? null : Color.m2266boximpl(style.m4252getColor0d7_KjU());
            if (colorM2266boximpl == null || colorM2266boximpl.m2286unboximpl() != Color.INSTANCE.m2312getUnspecified0d7_KjU()) {
                colorM5902component1QN2ZGVo = colorM2266boximpl;
            }
            return new ViewHierarchyNode.TextViewHierarchyNode((arrayList.isEmpty() || z2) ? null : new ComposeTextLayout((TextLayoutResult) CollectionsKt.first((List) arrayList), zComponent2), colorM5902component1QN2ZGVo != null ? Integer.valueOf(ViewsKt.toOpaque(ColorKt.m2330toArgb8_81llA(colorM5902component1QN2ZGVo.m2286unboximpl()))) : null, 0, 0, rectBoundsInWindow.left, rectBoundsInWindow.top, node.getWidth(), node.getHeight(), parent != null ? parent.getElevation() : 0.0f, distance, parent, z3, true, z, rectBoundsInWindow, 12, null);
        }
        Painter painterFindPainter = NodesKt.findPainter(node);
        if (painterFindPainter != null) {
            boolean z4 = z && shouldMask(node, true, options);
            if (parent != null) {
                parent.setImportantForCaptureToAncestors(true);
            }
            return new ViewHierarchyNode.ImageViewHierarchyNode(rectBoundsInWindow.left, rectBoundsInWindow.top, node.getWidth(), node.getHeight(), parent != null ? parent.getElevation() : 0.0f, distance, parent, z4 && NodesKt.isMaskable(painterFindPainter), true, z, rectBoundsInWindow);
        }
        return new ViewHierarchyNode.GenericViewHierarchyNode(rectBoundsInWindow.left, rectBoundsInWindow.top, node.getWidth(), node.getHeight(), parent != null ? parent.getElevation() : 0.0f, distance, parent, z && shouldMask(node, false, options), false, z, rectBoundsInWindow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean fromView(View view, ViewHierarchyNode parent, SentryOptions options) {
        LayoutNode root;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(options, "options");
        String name = view.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "view::class.java.name");
        if (!StringsKt.contains$default((CharSequence) name, (CharSequence) "AndroidComposeView", false, 2, (Object) null) || parent == null) {
            return false;
        }
        try {
            Owner owner = view instanceof Owner ? (Owner) view : null;
            if (owner != null && (root = owner.getRoot()) != null) {
                traverse(root, parent, true, options);
                return true;
            }
            return false;
        } catch (Throwable th) {
            options.getLogger().log(SentryLevel.ERROR, th, "Error traversing Compose tree. Most likely you're using an unsupported version of\nandroidx.compose.ui:ui. The minimum supported version is 1.5.0. If it's a newer\nversion, please open a github issue with the version you're using, so we can add\nsupport for it.", new Object[0]);
            return false;
        }
    }

    private final void traverse(LayoutNode layoutNode, ViewHierarchyNode viewHierarchyNode, boolean z, SentryOptions sentryOptions) {
        List<LayoutNode> children$ui_release = layoutNode.getChildren$ui_release();
        if (children$ui_release.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(children$ui_release.size());
        int size = children$ui_release.size();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = children$ui_release.get(i);
            ViewHierarchyNode viewHierarchyNodeFromComposeNode = fromComposeNode(layoutNode2, viewHierarchyNode, i, z, sentryOptions);
            if (viewHierarchyNodeFromComposeNode != null) {
                arrayList.add(viewHierarchyNodeFromComposeNode);
                traverse(layoutNode2, viewHierarchyNodeFromComposeNode, false, sentryOptions);
            }
        }
        viewHierarchyNode.setChildren(arrayList);
    }
}

package com.reactnativepagerview;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.reactnativepagerview.event.PageScrollEvent;
import com.reactnativepagerview.event.PageScrollStateChangedEvent;
import com.reactnativepagerview.event.PageSelectedEvent;
import io.sentry.protocol.Device;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PagerViewViewManager.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J \u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00160\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J$\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0018\u0010 \u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\nH\u0016J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0019\u0010#\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\fH\u0087\u0002J\u0018\u0010%\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\fH\u0007J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0015H\u0007J\u0018\u0010'\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0015H\u0007J\u0018\u0010(\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0015H\u0007J\u0018\u0010)\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\fH\u0007J\u0018\u0010+\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0019H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/reactnativepagerview/PagerViewViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/reactnativepagerview/NestedScrollableHost;", "()V", "eventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "addView", "", "host", "child", "Landroid/view/View;", FirebaseAnalytics.Param.INDEX, "", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getChildAt", "parent", "getChildCount", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "needsCustomLayoutForChildren", "", "receiveCommand", "root", "commandId", "args", "Lcom/facebook/react/bridge/ReadableArray;", "removeAllViews", "removeView", ViewHierarchyConstants.VIEW_KEY, "removeViewAt", "set", "value", "setInitialPage", "setLayoutDirection", "setOrientation", "setOverScrollMode", "setPageMargin", ViewProps.MARGIN, "setScrollEnabled", "Companion", "react-native-pager-view_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PagerViewViewManager extends ViewGroupManager<NestedScrollableHost> {
    private static final String COMMAND_SET_PAGE = "setPage";
    private static final String COMMAND_SET_PAGE_WITHOUT_ANIMATION = "setPageWithoutAnimation";
    private static final String COMMAND_SET_SCROLL_ENABLED = "setScrollEnabledImperatively";
    private EventDispatcher eventDispatcher;

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return PagerViewViewManagerImpl.NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public NestedScrollableHost createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        ThemedReactContext themedReactContext = reactContext;
        final NestedScrollableHost nestedScrollableHost = new NestedScrollableHost(themedReactContext);
        nestedScrollableHost.setId(View.generateViewId());
        nestedScrollableHost.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        nestedScrollableHost.setSaveEnabled(false);
        final ViewPager2 viewPager2 = new ViewPager2(themedReactContext);
        viewPager2.setAdapter(new ViewPagerAdapter());
        viewPager2.setSaveEnabled(false);
        NativeModule nativeModule = reactContext.getNativeModule((Class<NativeModule>) UIManagerModule.class);
        Intrinsics.checkNotNull(nativeModule);
        EventDispatcher eventDispatcher = ((UIManagerModule) nativeModule).getEventDispatcher();
        Intrinsics.checkNotNullExpressionValue(eventDispatcher, "<get-eventDispatcher>(...)");
        this.eventDispatcher = eventDispatcher;
        viewPager2.post(new Runnable() { // from class: com.reactnativepagerview.PagerViewViewManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PagerViewViewManager.createViewInstance$lambda$0(viewPager2, this, nestedScrollableHost);
            }
        });
        nestedScrollableHost.addView(viewPager2);
        return nestedScrollableHost;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createViewInstance$lambda$0(ViewPager2 vp, final PagerViewViewManager this$0, final NestedScrollableHost host) {
        Intrinsics.checkNotNullParameter(vp, "$vp");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(host, "$host");
        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.reactnativepagerview.PagerViewViewManager$createViewInstance$1$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                EventDispatcher eventDispatcher = this.this$0.eventDispatcher;
                if (eventDispatcher == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("eventDispatcher");
                    eventDispatcher = null;
                }
                eventDispatcher.dispatchEvent(new PageScrollEvent(host.getId(), position, positionOffset));
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                EventDispatcher eventDispatcher = this.this$0.eventDispatcher;
                if (eventDispatcher == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("eventDispatcher");
                    eventDispatcher = null;
                }
                eventDispatcher.dispatchEvent(new PageSelectedEvent(host.getId(), position));
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int state) {
                String str;
                super.onPageScrollStateChanged(state);
                if (state == 0) {
                    str = "idle";
                } else if (state == 1) {
                    str = "dragging";
                } else if (state == 2) {
                    str = "settling";
                } else {
                    throw new IllegalStateException("Unsupported pageScrollState");
                }
                EventDispatcher eventDispatcher = this.this$0.eventDispatcher;
                if (eventDispatcher == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("eventDispatcher");
                    eventDispatcher = null;
                }
                eventDispatcher.dispatchEvent(new PageScrollStateChangedEvent(host.getId(), str));
            }
        });
        EventDispatcher eventDispatcher = this$0.eventDispatcher;
        if (eventDispatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventDispatcher");
            eventDispatcher = null;
        }
        eventDispatcher.dispatchEvent(new PageSelectedEvent(host.getId(), vp.getCurrentItem()));
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(NestedScrollableHost host, View child, int index) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(child, "child");
        PagerViewViewManagerImpl.INSTANCE.addView(host, child, index);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(NestedScrollableHost parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return PagerViewViewManagerImpl.INSTANCE.getChildCount(parent);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(NestedScrollableHost parent, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return PagerViewViewManagerImpl.INSTANCE.getChildAt(parent, index);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeView(NestedScrollableHost parent, View view) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(view, "view");
        PagerViewViewManagerImpl.INSTANCE.removeView(parent, view);
    }

    @Override // com.facebook.react.uimanager.IViewGroupManager
    public void removeAllViews(NestedScrollableHost parent) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(parent, "parent");
        PagerViewViewManagerImpl.INSTANCE.removeAllViews(parent);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(NestedScrollableHost parent, int index) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(parent, "parent");
        PagerViewViewManagerImpl.INSTANCE.removeViewAt(parent, index);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewManagerWithChildren
    public boolean needsCustomLayoutForChildren() {
        return PagerViewViewManagerImpl.INSTANCE.needsCustomLayoutForChildren();
    }

    @ReactProp(defaultBoolean = true, name = "scrollEnabled")
    public final void setScrollEnabled(NestedScrollableHost host, boolean value) {
        Intrinsics.checkNotNullParameter(host, "host");
        PagerViewViewManagerImpl.INSTANCE.setScrollEnabled(host, value);
    }

    @ReactProp(defaultInt = 0, name = "initialPage")
    public final void setInitialPage(NestedScrollableHost host, int value) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(host, "host");
        PagerViewViewManagerImpl.INSTANCE.setInitialPage(host, value);
    }

    @ReactProp(name = Device.JsonKeys.ORIENTATION)
    public final void setOrientation(NestedScrollableHost host, String value) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(value, "value");
        PagerViewViewManagerImpl.INSTANCE.setOrientation(host, value);
    }

    @ReactProp(defaultInt = -1, name = "offscreenPageLimit")
    public final void set(NestedScrollableHost host, int value) {
        Intrinsics.checkNotNullParameter(host, "host");
        PagerViewViewManagerImpl.INSTANCE.setOffscreenPageLimit(host, value);
    }

    @ReactProp(name = "overScrollMode")
    public final void setOverScrollMode(NestedScrollableHost host, String value) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(value, "value");
        PagerViewViewManagerImpl.INSTANCE.setOverScrollMode(host, value);
    }

    @ReactProp(name = ViewProps.LAYOUT_DIRECTION)
    public final void setLayoutDirection(NestedScrollableHost host, String value) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(value, "value");
        PagerViewViewManagerImpl.INSTANCE.setLayoutDirection(host, value);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Map<String, String>> getExportedCustomDirectEventTypeConstants() {
        Map<String, Map<String, String>> mapOf = MapBuilder.of(PageScrollEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPageScroll"), PageScrollStateChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPageScrollStateChanged"), PageSelectedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPageSelected"));
        Intrinsics.checkNotNullExpressionValue(mapOf, "of(...)");
        return mapOf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
    
        if (r7.equals(com.reactnativepagerview.PagerViewViewManager.COMMAND_SET_PAGE) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:
    
        if (r7.equals(com.reactnativepagerview.PagerViewViewManager.COMMAND_SET_PAGE_WITHOUT_ANIMATION) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0061, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNull(r8);
        r8 = r8.getInt(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:
    
        if (r0 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
    
        if (r0.intValue() <= 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
    
        if (r8 < 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0076, code lost:
    
        if (r8 >= r0.intValue()) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0078, code lost:
    
        com.reactnativepagerview.PagerViewViewManagerImpl.INSTANCE.setCurrentItem(r6, r8, kotlin.jvm.internal.Intrinsics.areEqual(r7, com.reactnativepagerview.PagerViewViewManager.COMMAND_SET_PAGE));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0081, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
        return;
     */
    @Override // com.facebook.react.uimanager.ViewManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void receiveCommand(com.reactnativepagerview.NestedScrollableHost r6, java.lang.String r7, com.facebook.react.bridge.ReadableArray r8) throws java.lang.ClassNotFoundException {
        /*
            r5 = this;
            java.lang.String r0 = "root"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = r6
            android.view.View r0 = (android.view.View) r0
            super.receiveCommand(r0, r7, r8)
            com.reactnativepagerview.PagerViewViewManagerImpl r0 = com.reactnativepagerview.PagerViewViewManagerImpl.INSTANCE
            androidx.viewpager2.widget.ViewPager2 r6 = r0.getViewPager(r6)
            com.facebook.infer.annotation.Assertions.assertNotNull(r6)
            com.facebook.infer.annotation.Assertions.assertNotNull(r8)
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r6.getAdapter()
            if (r0 == 0) goto L26
            int r0 = r0.getItemCount()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L27
        L26:
            r0 = 0
        L27:
            if (r7 == 0) goto L82
            int r1 = r7.hashCode()
            r2 = -445763635(0xffffffffe56e2fcd, float:-7.030031E22)
            r3 = 0
            java.lang.String r4 = "setPage"
            if (r1 == r2) goto L59
            r2 = 1747675147(0x682b680b, float:3.2377757E24)
            if (r1 == r2) goto L46
            r2 = 1984860689(0x764e9211, float:1.0474372E33)
            if (r1 != r2) goto L82
            boolean r1 = r7.equals(r4)
            if (r1 == 0) goto L82
            goto L61
        L46:
            java.lang.String r0 = "setScrollEnabledImperatively"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L82
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            boolean r7 = r8.getBoolean(r3)
            r6.setUserInputEnabled(r7)
            goto L81
        L59:
            java.lang.String r1 = "setPageWithoutAnimation"
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L82
        L61:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            int r8 = r8.getInt(r3)
            if (r0 == 0) goto L81
            int r1 = r0.intValue()
            if (r1 <= 0) goto L81
            if (r8 < 0) goto L81
            int r0 = r0.intValue()
            if (r8 >= r0) goto L81
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r4)
            com.reactnativepagerview.PagerViewViewManagerImpl r0 = com.reactnativepagerview.PagerViewViewManagerImpl.INSTANCE
            r0.setCurrentItem(r6, r8, r7)
        L81:
            return
        L82:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            kotlin.jvm.internal.StringCompanionObject r8 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Class r8 = r5.getClass()
            java.lang.String r8 = r8.getSimpleName()
            java.lang.Object[] r7 = new java.lang.Object[]{r7, r8}
            r8 = 2
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r8)
            java.lang.String r8 = "Unsupported command %d received by %s."
            java.lang.String r7 = java.lang.String.format(r8, r7)
            java.lang.String r8 = "format(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativepagerview.PagerViewViewManager.receiveCommand(com.reactnativepagerview.NestedScrollableHost, java.lang.String, com.facebook.react.bridge.ReadableArray):void");
    }

    @ReactProp(defaultInt = 0, name = "pageMargin")
    public final void setPageMargin(NestedScrollableHost host, int margin) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(host, "host");
        PagerViewViewManagerImpl.INSTANCE.setPageMargin(host, margin);
    }
}

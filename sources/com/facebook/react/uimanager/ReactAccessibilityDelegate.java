package com.facebook.react.uimanager;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.TextView;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.facebook.react.R;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.util.ReactFindViewUtil;
import com.google.firebase.messaging.Constants;
import io.sentry.SentryReplayOptions;
import io.sentry.protocol.MetricSummary;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class ReactAccessibilityDelegate extends ExploreByTouchHelper {
    private static final int SEND_EVENT = 1;
    private static final String STATE_CHECKED = "checked";
    private static final String STATE_DISABLED = "disabled";
    private static final String STATE_SELECTED = "selected";
    private static final String TAG = "ReactAccessibilityDelegate";
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    public static final String TOP_ACCESSIBILITY_ACTION_EVENT = "topAccessibilityAction";
    private static final String delimiter = ", ";
    private static final int delimiterLength = delimiter.length();
    public static final HashMap<String, Integer> sActionIdMap;
    private static int sCounter = 1056964608;
    private final HashMap<Integer, String> mAccessibilityActionsMap;
    View mAccessibilityLabelledBy;
    private final AccessibilityLinks mAccessibilityLinks;
    private Handler mHandler;
    private final View mView;

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
        return false;
    }

    static {
        HashMap<String, Integer> map = new HashMap<>();
        sActionIdMap = map;
        map.put("activate", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK.getId()));
        map.put("longpress", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_LONG_CLICK.getId()));
        map.put("increment", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId()));
        map.put("decrement", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId()));
        map.put("expand", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND.getId()));
        map.put("collapse", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE.getId()));
    }

    private void scheduleAccessibilityEventSender(View view) {
        if (this.mHandler.hasMessages(1, view)) {
            this.mHandler.removeMessages(1, view);
        }
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, view), 200L);
    }

    public enum Role {
        ALERT,
        ALERTDIALOG,
        APPLICATION,
        ARTICLE,
        BANNER,
        BUTTON,
        CELL,
        CHECKBOX,
        COLUMNHEADER,
        COMBOBOX,
        COMPLEMENTARY,
        CONTENTINFO,
        DEFINITION,
        DIALOG,
        DIRECTORY,
        DOCUMENT,
        FEED,
        FIGURE,
        FORM,
        GRID,
        GROUP,
        HEADING,
        IMG,
        LINK,
        LIST,
        LISTITEM,
        LOG,
        MAIN,
        MARQUEE,
        MATH,
        MENU,
        MENUBAR,
        MENUITEM,
        METER,
        NAVIGATION,
        NONE,
        NOTE,
        OPTION,
        PRESENTATION,
        PROGRESSBAR,
        RADIO,
        RADIOGROUP,
        REGION,
        ROW,
        ROWGROUP,
        ROWHEADER,
        SCROLLBAR,
        SEARCHBOX,
        SEPARATOR,
        SLIDER,
        SPINBUTTON,
        STATUS,
        SUMMARY,
        SWITCH,
        TAB,
        TABLE,
        TABLIST,
        TABPANEL,
        TERM,
        TIMER,
        TOOLBAR,
        TOOLTIP,
        TREE,
        TREEGRID,
        TREEITEM;

        public static Role fromValue(String str) {
            for (Role role : values()) {
                if (role.name().equalsIgnoreCase(str)) {
                    return role;
                }
            }
            return null;
        }
    }

    public enum AccessibilityRole {
        NONE,
        BUTTON,
        DROPDOWNLIST,
        TOGGLEBUTTON,
        LINK,
        SEARCH,
        IMAGE,
        IMAGEBUTTON,
        KEYBOARDKEY,
        TEXT,
        ADJUSTABLE,
        SUMMARY,
        HEADER,
        ALERT,
        CHECKBOX,
        COMBOBOX,
        MENU,
        MENUBAR,
        MENUITEM,
        PROGRESSBAR,
        RADIO,
        RADIOGROUP,
        SCROLLBAR,
        SPINBUTTON,
        SWITCH,
        TAB,
        TABLIST,
        TIMER,
        LIST,
        GRID,
        PAGER,
        SCROLLVIEW,
        HORIZONTALSCROLLVIEW,
        VIEWGROUP,
        WEBVIEW,
        DRAWERLAYOUT,
        SLIDINGDRAWER,
        ICONMENU,
        TOOLBAR;

        public static String getValue(AccessibilityRole accessibilityRole) {
            switch (AnonymousClass3.$SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[accessibilityRole.ordinal()]) {
                case 1:
                    return "android.widget.Button";
                case 2:
                    return "android.widget.Spinner";
                case 3:
                    return "android.widget.ToggleButton";
                case 4:
                    return AndroidComposeViewAccessibilityDelegateCompat.TextFieldClassName;
                case 5:
                    return SentryReplayOptions.IMAGE_VIEW_CLASS_NAME;
                case 6:
                    return "android.widget.ImageButton";
                case 7:
                    return "android.inputmethodservice.Keyboard$Key";
                case 8:
                    return "android.widget.TextView";
                case 9:
                    return "android.widget.SeekBar";
                case 10:
                    return "android.widget.CheckBox";
                case 11:
                    return "android.widget.RadioButton";
                case 12:
                    return "android.widget.SpinButton";
                case 13:
                    return "android.widget.Switch";
                case 14:
                    return "android.widget.AbsListView";
                case 15:
                    return "android.widget.GridView";
                case 16:
                    return "android.widget.ScrollView";
                case 17:
                    return "android.widget.HorizontalScrollView";
                case 18:
                    return "androidx.viewpager.widget.ViewPager";
                case 19:
                    return "androidx.drawerlayout.widget.DrawerLayout";
                case 20:
                    return "android.widget.SlidingDrawer";
                case 21:
                    return "com.android.internal.view.menu.IconMenuView";
                case 22:
                    return "android.view.ViewGroup";
                case 23:
                    return SentryReplayOptions.WEB_VIEW_CLASS_NAME;
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                    return AndroidComposeViewAccessibilityDelegateCompat.ClassName;
                default:
                    throw new IllegalArgumentException("Invalid accessibility role value: " + accessibilityRole);
            }
        }

        public static AccessibilityRole fromValue(String str) {
            if (str == null) {
                return NONE;
            }
            for (AccessibilityRole accessibilityRole : values()) {
                if (accessibilityRole.name().equalsIgnoreCase(str)) {
                    return accessibilityRole;
                }
            }
            throw new IllegalArgumentException("Invalid accessibility role value: " + str);
        }

        public static AccessibilityRole fromRole(Role role) {
            switch (AnonymousClass3.$SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[role.ordinal()]) {
                case 1:
                    return ALERT;
                case 2:
                    return BUTTON;
                case 3:
                    return CHECKBOX;
                case 4:
                    return COMBOBOX;
                case 5:
                    return GRID;
                case 6:
                    return HEADER;
                case 7:
                    return IMAGE;
                case 8:
                    return LINK;
                case 9:
                    return LIST;
                case 10:
                    return MENU;
                case 11:
                    return MENUBAR;
                case 12:
                    return MENUITEM;
                case 13:
                    return NONE;
                case 14:
                    return PROGRESSBAR;
                case 15:
                    return RADIO;
                case 16:
                    return RADIOGROUP;
                case 17:
                    return SCROLLBAR;
                case 18:
                    return SEARCH;
                case 19:
                    return ADJUSTABLE;
                case 20:
                    return SPINBUTTON;
                case 21:
                    return SUMMARY;
                case 22:
                    return SWITCH;
                case 23:
                    return TAB;
                case 24:
                    return TABLIST;
                case 25:
                    return TIMER;
                case 26:
                    return TOOLBAR;
                default:
                    return null;
            }
        }

        public static AccessibilityRole fromViewTag(View view) {
            Role role = (Role) view.getTag(R.id.role);
            if (role != null) {
                return fromRole(role);
            }
            return (AccessibilityRole) view.getTag(R.id.accessibility_role);
        }
    }

    /* renamed from: com.facebook.react.uimanager.ReactAccessibilityDelegate$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole;
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role;

        static {
            int[] iArr = new int[Role.values().length];
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role = iArr;
            try {
                iArr[Role.ALERT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.BUTTON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.CHECKBOX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.COMBOBOX.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.GRID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.HEADING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.IMG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.LINK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.LIST.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.MENU.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.MENUBAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.MENUITEM.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.NONE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.PROGRESSBAR.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.RADIO.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.RADIOGROUP.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.SCROLLBAR.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.SEARCHBOX.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.SLIDER.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.SPINBUTTON.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.SUMMARY.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.SWITCH.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.TAB.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.TABLIST.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.TIMER.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$Role[Role.TOOLBAR.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            int[] iArr2 = new int[AccessibilityRole.values().length];
            $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole = iArr2;
            try {
                iArr2[AccessibilityRole.BUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.DROPDOWNLIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.TOGGLEBUTTON.ordinal()] = 3;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.SEARCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.IMAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.IMAGEBUTTON.ordinal()] = 6;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.KEYBOARDKEY.ordinal()] = 7;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.TEXT.ordinal()] = 8;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.ADJUSTABLE.ordinal()] = 9;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.CHECKBOX.ordinal()] = 10;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.RADIO.ordinal()] = 11;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.SPINBUTTON.ordinal()] = 12;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.SWITCH.ordinal()] = 13;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.LIST.ordinal()] = 14;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.GRID.ordinal()] = 15;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.SCROLLVIEW.ordinal()] = 16;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.HORIZONTALSCROLLVIEW.ordinal()] = 17;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.PAGER.ordinal()] = 18;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.DRAWERLAYOUT.ordinal()] = 19;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.SLIDINGDRAWER.ordinal()] = 20;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.ICONMENU.ordinal()] = 21;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.VIEWGROUP.ordinal()] = 22;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.WEBVIEW.ordinal()] = 23;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.NONE.ordinal()] = 24;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.LINK.ordinal()] = 25;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.SUMMARY.ordinal()] = 26;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.HEADER.ordinal()] = 27;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.ALERT.ordinal()] = 28;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.COMBOBOX.ordinal()] = 29;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.MENU.ordinal()] = 30;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.MENUBAR.ordinal()] = 31;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.MENUITEM.ordinal()] = 32;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.PROGRESSBAR.ordinal()] = 33;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.RADIOGROUP.ordinal()] = 34;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.SCROLLBAR.ordinal()] = 35;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.TAB.ordinal()] = 36;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.TABLIST.ordinal()] = 37;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.TIMER.ordinal()] = 38;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$ReactAccessibilityDelegate$AccessibilityRole[AccessibilityRole.TOOLBAR.ordinal()] = 39;
            } catch (NoSuchFieldError unused65) {
            }
        }
    }

    public ReactAccessibilityDelegate(View view, boolean z, int i) {
        super(view);
        this.mView = view;
        this.mAccessibilityActionsMap = new HashMap<>();
        this.mHandler = new Handler() { // from class: com.facebook.react.uimanager.ReactAccessibilityDelegate.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ((View) message.obj).sendAccessibilityEvent(4);
            }
        };
        view.setFocusable(z);
        ViewCompat.setImportantForAccessibility(view, i);
        this.mAccessibilityLinks = (AccessibilityLinks) view.getTag(R.id.accessibility_links);
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper, androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        if (view.getTag(R.id.accessibility_state_expanded) != null) {
            accessibilityNodeInfoCompat.addAction(((Boolean) view.getTag(R.id.accessibility_state_expanded)).booleanValue() ? 524288 : 262144);
        }
        AccessibilityRole accessibilityRoleFromViewTag = AccessibilityRole.fromViewTag(view);
        String str = (String) view.getTag(R.id.accessibility_hint);
        if (accessibilityRoleFromViewTag != null) {
            setRole(accessibilityNodeInfoCompat, accessibilityRoleFromViewTag, view.getContext());
        }
        if (str != null) {
            accessibilityNodeInfoCompat.setTooltipText(str);
        }
        Object tag = view.getTag(R.id.labelled_by);
        if (tag != null) {
            View viewFindView = ReactFindViewUtil.findView(view.getRootView(), (String) tag);
            this.mAccessibilityLabelledBy = viewFindView;
            if (viewFindView != null) {
                accessibilityNodeInfoCompat.setLabeledBy(viewFindView);
            }
        }
        ReadableMap readableMap = (ReadableMap) view.getTag(R.id.accessibility_state);
        if (readableMap != null) {
            setState(accessibilityNodeInfoCompat, readableMap, view.getContext());
        }
        ReadableArray readableArray = (ReadableArray) view.getTag(R.id.accessibility_actions);
        ReadableMap readableMap2 = (ReadableMap) view.getTag(R.id.accessibility_collection_item);
        if (readableMap2 != null) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(readableMap2.getInt("rowIndex"), readableMap2.getInt("rowSpan"), readableMap2.getInt("columnIndex"), readableMap2.getInt("columnSpan"), readableMap2.getBoolean("heading")));
        }
        boolean z = true;
        if (readableArray != null) {
            for (int i = 0; i < readableArray.size(); i++) {
                ReadableMap map = readableArray.getMap(i);
                if (!map.hasKey("name")) {
                    throw new IllegalArgumentException("Unknown accessibility action.");
                }
                int iIntValue = sCounter;
                String string = map.hasKey(Constants.ScionAnalytics.PARAM_LABEL) ? map.getString(Constants.ScionAnalytics.PARAM_LABEL) : null;
                HashMap<String, Integer> map2 = sActionIdMap;
                if (map2.containsKey(map.getString("name"))) {
                    iIntValue = map2.get(map.getString("name")).intValue();
                } else {
                    sCounter++;
                }
                this.mAccessibilityActionsMap.put(Integer.valueOf(iIntValue), map.getString("name"));
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(iIntValue, string));
            }
        }
        ReadableMap readableMap3 = (ReadableMap) view.getTag(R.id.accessibility_value);
        if (readableMap3 != null && readableMap3.hasKey(MetricSummary.JsonKeys.MIN) && readableMap3.hasKey("now") && readableMap3.hasKey(MetricSummary.JsonKeys.MAX)) {
            Dynamic dynamic = readableMap3.getDynamic(MetricSummary.JsonKeys.MIN);
            Dynamic dynamic2 = readableMap3.getDynamic("now");
            Dynamic dynamic3 = readableMap3.getDynamic(MetricSummary.JsonKeys.MAX);
            if (dynamic != null && dynamic.getType() == ReadableType.Number && dynamic2 != null && dynamic2.getType() == ReadableType.Number && dynamic3 != null && dynamic3.getType() == ReadableType.Number) {
                int iAsInt = dynamic.asInt();
                int iAsInt2 = dynamic2.asInt();
                int iAsInt3 = dynamic3.asInt();
                if (iAsInt3 > iAsInt && iAsInt2 >= iAsInt && iAsInt3 >= iAsInt2) {
                    accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(0, iAsInt, iAsInt3, iAsInt2));
                }
            }
        }
        String str2 = (String) view.getTag(R.id.react_test_id);
        if (str2 != null) {
            accessibilityNodeInfoCompat.setViewIdResourceName(str2);
        }
        boolean z2 = TextUtils.isEmpty(accessibilityNodeInfoCompat.getContentDescription()) && TextUtils.isEmpty(accessibilityNodeInfoCompat.getText());
        if (readableArray == null && readableMap == null && tag == null && accessibilityRoleFromViewTag == null) {
            z = false;
        }
        if (z2 && z) {
            accessibilityNodeInfoCompat.setContentDescription(getTalkbackDescription(view, accessibilityNodeInfoCompat));
        }
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper, androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        ReadableMap readableMap = (ReadableMap) view.getTag(R.id.accessibility_value);
        if (readableMap != null && readableMap.hasKey(MetricSummary.JsonKeys.MIN) && readableMap.hasKey("now") && readableMap.hasKey(MetricSummary.JsonKeys.MAX)) {
            Dynamic dynamic = readableMap.getDynamic(MetricSummary.JsonKeys.MIN);
            Dynamic dynamic2 = readableMap.getDynamic("now");
            Dynamic dynamic3 = readableMap.getDynamic(MetricSummary.JsonKeys.MAX);
            if (dynamic == null || dynamic.getType() != ReadableType.Number || dynamic2 == null || dynamic2.getType() != ReadableType.Number || dynamic3 == null || dynamic3.getType() != ReadableType.Number) {
                return;
            }
            int iAsInt = dynamic.asInt();
            int iAsInt2 = dynamic2.asInt();
            int iAsInt3 = dynamic3.asInt();
            if (iAsInt3 <= iAsInt || iAsInt2 < iAsInt || iAsInt3 < iAsInt2) {
                return;
            }
            accessibilityEvent.setItemCount(iAsInt3 - iAsInt);
            accessibilityEvent.setCurrentItemIndex(iAsInt2);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (i == 524288) {
            view.setTag(R.id.accessibility_state_expanded, false);
        }
        if (i == 262144) {
            view.setTag(R.id.accessibility_state_expanded, true);
        }
        if (this.mAccessibilityActionsMap.containsKey(Integer.valueOf(i))) {
            final WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("actionName", this.mAccessibilityActionsMap.get(Integer.valueOf(i)));
            ReactContext reactContext = (ReactContext) view.getContext();
            if (reactContext.hasActiveReactInstance()) {
                int id = view.getId();
                int surfaceId = UIManagerHelper.getSurfaceId(reactContext);
                UIManager uIManager = UIManagerHelper.getUIManager(reactContext, ViewUtil.getUIManagerType(id));
                if (uIManager != null) {
                    uIManager.getEventDispatcher().dispatchEvent(new Event(surfaceId, id) { // from class: com.facebook.react.uimanager.ReactAccessibilityDelegate.2
                        @Override // com.facebook.react.uimanager.events.Event
                        public String getEventName() {
                            return ReactAccessibilityDelegate.TOP_ACCESSIBILITY_ACTION_EVENT;
                        }

                        @Override // com.facebook.react.uimanager.events.Event
                        /* renamed from: getEventData */
                        protected WritableMap getData() {
                            return writableMapCreateMap;
                        }
                    });
                }
            } else {
                ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Cannot get RCTEventEmitter, no CatalystInstance"));
            }
            AccessibilityRole accessibilityRole = (AccessibilityRole) view.getTag(R.id.accessibility_role);
            ReadableMap readableMap = (ReadableMap) view.getTag(R.id.accessibility_value);
            if (accessibilityRole != AccessibilityRole.ADJUSTABLE || (i != AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId() && i != AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId())) {
                return true;
            }
            if (readableMap != null && !readableMap.hasKey("text")) {
                scheduleAccessibilityEventSender(view);
            }
            return super.performAccessibilityAction(view, i, bundle);
        }
        return super.performAccessibilityAction(view, i, bundle);
    }

    private static void setState(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ReadableMap readableMap, Context context) {
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            Dynamic dynamic = readableMap.getDynamic(strNextKey);
            if (strNextKey.equals(STATE_SELECTED) && dynamic.getType() == ReadableType.Boolean) {
                accessibilityNodeInfoCompat.setSelected(dynamic.asBoolean());
            } else if (strNextKey.equals(STATE_DISABLED) && dynamic.getType() == ReadableType.Boolean) {
                accessibilityNodeInfoCompat.setEnabled(!dynamic.asBoolean());
            } else if (strNextKey.equals(STATE_CHECKED) && dynamic.getType() == ReadableType.Boolean) {
                boolean zAsBoolean = dynamic.asBoolean();
                accessibilityNodeInfoCompat.setCheckable(true);
                accessibilityNodeInfoCompat.setChecked(zAsBoolean);
            }
        }
    }

    public static void setRole(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityRole accessibilityRole, Context context) {
        if (accessibilityRole == null) {
            accessibilityRole = AccessibilityRole.NONE;
        }
        accessibilityNodeInfoCompat.setClassName(AccessibilityRole.getValue(accessibilityRole));
        if (accessibilityRole.equals(AccessibilityRole.LINK)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(R.string.link_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.IMAGE)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(R.string.image_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.IMAGEBUTTON)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(R.string.imagebutton_description));
            accessibilityNodeInfoCompat.setClickable(true);
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.BUTTON)) {
            accessibilityNodeInfoCompat.setClickable(true);
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.TOGGLEBUTTON)) {
            accessibilityNodeInfoCompat.setClickable(true);
            accessibilityNodeInfoCompat.setCheckable(true);
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.SUMMARY)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(R.string.summary_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.HEADER)) {
            accessibilityNodeInfoCompat.setHeading(true);
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.ALERT)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(R.string.alert_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.COMBOBOX)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(R.string.combobox_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.MENU)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(R.string.menu_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.MENUBAR)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(R.string.menubar_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.MENUITEM)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(R.string.menuitem_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.PROGRESSBAR)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(R.string.progressbar_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.RADIOGROUP)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(R.string.radiogroup_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.SCROLLBAR)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(R.string.scrollbar_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.SPINBUTTON)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(R.string.spinbutton_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.TAB)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(R.string.rn_tab_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.TABLIST)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(R.string.tablist_description));
        } else if (accessibilityRole.equals(AccessibilityRole.TIMER)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(R.string.timer_description));
        } else if (accessibilityRole.equals(AccessibilityRole.TOOLBAR)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(R.string.toolbar_description));
        }
    }

    public static void setDelegate(View view, boolean z, int i) {
        if (ViewCompat.hasAccessibilityDelegate(view)) {
            return;
        }
        if (view.getTag(R.id.accessibility_role) == null && view.getTag(R.id.accessibility_state) == null && view.getTag(R.id.accessibility_actions) == null && view.getTag(R.id.react_test_id) == null && view.getTag(R.id.accessibility_collection_item) == null && view.getTag(R.id.accessibility_links) == null && view.getTag(R.id.role) == null) {
            return;
        }
        ViewCompat.setAccessibilityDelegate(view, new ReactAccessibilityDelegate(view, z, i));
    }

    public static void resetDelegate(View view, boolean z, int i) {
        ViewCompat.setAccessibilityDelegate(view, new ReactAccessibilityDelegate(view, z, i));
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected int getVirtualViewAt(float f, float f2) {
        Layout layout;
        AccessibilityLinks accessibilityLinks = this.mAccessibilityLinks;
        if (accessibilityLinks == null || accessibilityLinks.size() == 0) {
            return Integer.MIN_VALUE;
        }
        View view = this.mView;
        if (!(view instanceof TextView)) {
            return Integer.MIN_VALUE;
        }
        TextView textView = (TextView) view;
        if (!(textView.getText() instanceof Spanned) || (layout = textView.getLayout()) == null) {
            return Integer.MIN_VALUE;
        }
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((int) ((f2 - textView.getTotalPaddingTop()) + textView.getScrollY())), (f - textView.getTotalPaddingLeft()) + textView.getScrollX());
        ClickableSpan clickableSpan = (ClickableSpan) getFirstSpan(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
        if (clickableSpan == null) {
            return Integer.MIN_VALUE;
        }
        Spanned spanned = (Spanned) textView.getText();
        AccessibilityLinks.AccessibleLink linkBySpanPos = this.mAccessibilityLinks.getLinkBySpanPos(spanned.getSpanStart(clickableSpan), spanned.getSpanEnd(clickableSpan));
        if (linkBySpanPos != null) {
            return linkBySpanPos.id;
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected void getVisibleVirtualViews(List<Integer> list) {
        if (this.mAccessibilityLinks == null) {
            return;
        }
        for (int i = 0; i < this.mAccessibilityLinks.size(); i++) {
            list.add(Integer.valueOf(i));
        }
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AccessibilityLinks accessibilityLinks = this.mAccessibilityLinks;
        if (accessibilityLinks == null) {
            accessibilityNodeInfoCompat.setContentDescription("");
            accessibilityNodeInfoCompat.setBoundsInParent(new Rect(0, 0, 1, 1));
            return;
        }
        AccessibilityLinks.AccessibleLink linkById = accessibilityLinks.getLinkById(i);
        if (linkById == null) {
            accessibilityNodeInfoCompat.setContentDescription("");
            accessibilityNodeInfoCompat.setBoundsInParent(new Rect(0, 0, 1, 1));
            return;
        }
        Rect boundsInParent = getBoundsInParent(linkById);
        if (boundsInParent == null) {
            accessibilityNodeInfoCompat.setContentDescription("");
            accessibilityNodeInfoCompat.setBoundsInParent(new Rect(0, 0, 1, 1));
            return;
        }
        accessibilityNodeInfoCompat.setContentDescription(linkById.description);
        accessibilityNodeInfoCompat.addAction(16);
        accessibilityNodeInfoCompat.setBoundsInParent(boundsInParent);
        accessibilityNodeInfoCompat.setRoleDescription(this.mView.getResources().getString(R.string.link_description));
        accessibilityNodeInfoCompat.setClassName(AccessibilityRole.getValue(AccessibilityRole.BUTTON));
    }

    private Rect getBoundsInParent(AccessibilityLinks.AccessibleLink accessibleLink) {
        View view = this.mView;
        if (!(view instanceof TextView)) {
            return new Rect(0, 0, this.mView.getWidth(), this.mView.getHeight());
        }
        TextView textView = (TextView) view;
        Layout layout = textView.getLayout();
        if (layout == null) {
            return new Rect(0, 0, textView.getWidth(), textView.getHeight());
        }
        double d = accessibleLink.start;
        double d2 = accessibleLink.end;
        int i = (int) d;
        int lineForOffset = layout.getLineForOffset(i);
        if (d > layout.getLineEnd(lineForOffset)) {
            return null;
        }
        Rect rect = new Rect();
        double primaryHorizontal = layout.getPrimaryHorizontal(i);
        new Paint().setTextSize(((AbsoluteSizeSpan) getFirstSpan(accessibleLink.start, accessibleLink.end, AbsoluteSizeSpan.class)) != null ? r7.getSize() : textView.getTextSize());
        int iCeil = (int) Math.ceil(r4.measureText(accessibleLink.description));
        boolean z = lineForOffset != layout.getLineForOffset((int) d2);
        layout.getLineBounds(lineForOffset, rect);
        int scrollY = textView.getScrollY() + textView.getTotalPaddingTop();
        rect.top += scrollY;
        rect.bottom += scrollY;
        rect.left = (int) (rect.left + ((primaryHorizontal + textView.getTotalPaddingLeft()) - textView.getScrollX()));
        if (z) {
            return new Rect(rect.left, rect.top, rect.right, rect.bottom);
        }
        return new Rect(rect.left, rect.top, rect.left + iCeil, rect.bottom);
    }

    protected <T> T getFirstSpan(int i, int i2, Class<T> cls) {
        View view = this.mView;
        if (!(view instanceof TextView) || !(((TextView) view).getText() instanceof Spanned)) {
            return null;
        }
        Object[] spans = ((Spanned) ((TextView) this.mView).getText()).getSpans(i, i2, cls);
        if (spans.length > 0) {
            return (T) spans[0];
        }
        return null;
    }

    public static class AccessibilityLinks {
        private final List<AccessibleLink> mLinks;

        public AccessibilityLinks(ClickableSpan[] clickableSpanArr, Spannable spannable) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < clickableSpanArr.length; i++) {
                ClickableSpan clickableSpan = clickableSpanArr[i];
                int spanStart = spannable.getSpanStart(clickableSpan);
                int spanEnd = spannable.getSpanEnd(clickableSpan);
                if (spanStart != spanEnd && spanStart >= 0 && spanEnd >= 0 && spanStart <= spannable.length() && spanEnd <= spannable.length()) {
                    AccessibleLink accessibleLink = new AccessibleLink();
                    accessibleLink.description = spannable.subSequence(spanStart, spanEnd).toString();
                    accessibleLink.start = spanStart;
                    accessibleLink.end = spanEnd;
                    accessibleLink.id = (clickableSpanArr.length - 1) - i;
                    arrayList.add(accessibleLink);
                }
            }
            this.mLinks = arrayList;
        }

        public AccessibleLink getLinkById(int i) {
            for (AccessibleLink accessibleLink : this.mLinks) {
                if (accessibleLink.id == i) {
                    return accessibleLink;
                }
            }
            return null;
        }

        public AccessibleLink getLinkBySpanPos(int i, int i2) {
            for (AccessibleLink accessibleLink : this.mLinks) {
                if (accessibleLink.start == i && accessibleLink.end == i2) {
                    return accessibleLink;
                }
            }
            return null;
        }

        public int size() {
            return this.mLinks.size();
        }

        private static class AccessibleLink {
            public String description;
            public int end;
            public int id;
            public int start;

            private AccessibleLink() {
            }
        }
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper, androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.mAccessibilityLinks != null) {
            return super.getAccessibilityNodeProvider(view);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean hasNonActionableSpeakingDescendants(androidx.core.view.accessibility.AccessibilityNodeInfoCompat r5, android.view.View r6) {
        /*
            r0 = 0
            if (r5 == 0) goto L50
            if (r6 == 0) goto L50
            boolean r5 = r6 instanceof android.view.ViewGroup
            if (r5 != 0) goto La
            goto L50
        La:
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            int r5 = r6.getChildCount()
            r1 = r0
        L11:
            if (r1 >= r5) goto L50
            android.view.View r2 = r6.getChildAt(r1)
            if (r2 != 0) goto L1a
            goto L46
        L1a:
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat r3 = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.obtain()
            androidx.core.view.ViewCompat.onInitializeAccessibilityNodeInfo(r2, r3)     // Catch: java.lang.Throwable -> L49
            boolean r4 = r3.isVisibleToUser()     // Catch: java.lang.Throwable -> L49
            if (r4 != 0) goto L2d
            if (r3 == 0) goto L46
        L29:
            r3.recycle()
            goto L46
        L2d:
            boolean r4 = isAccessibilityFocusable(r3, r2)     // Catch: java.lang.Throwable -> L49
            if (r4 == 0) goto L36
            if (r3 == 0) goto L46
            goto L29
        L36:
            boolean r2 = isSpeakingNode(r3, r2)     // Catch: java.lang.Throwable -> L49
            if (r2 == 0) goto L43
            if (r3 == 0) goto L41
            r3.recycle()
        L41:
            r5 = 1
            return r5
        L43:
            if (r3 == 0) goto L46
            goto L29
        L46:
            int r1 = r1 + 1
            goto L11
        L49:
            r5 = move-exception
            if (r3 == 0) goto L4f
            r3.recycle()
        L4f:
            throw r5
        L50:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.ReactAccessibilityDelegate.hasNonActionableSpeakingDescendants(androidx.core.view.accessibility.AccessibilityNodeInfoCompat, android.view.View):boolean");
    }

    public static boolean hasValidRangeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AccessibilityNodeInfoCompat.RangeInfoCompat rangeInfo;
        if (accessibilityNodeInfoCompat == null || (rangeInfo = accessibilityNodeInfoCompat.getRangeInfo()) == null) {
            return false;
        }
        float max = rangeInfo.getMax();
        float min = rangeInfo.getMin();
        float current = rangeInfo.getCurrent();
        return max - min > 0.0f && current >= min && current <= max;
    }

    private static boolean hasStateDescription(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return accessibilityNodeInfoCompat != null && (!TextUtils.isEmpty(accessibilityNodeInfoCompat.getStateDescription()) || accessibilityNodeInfoCompat.isCheckable() || hasValidRangeInfo(accessibilityNodeInfoCompat));
    }

    public static boolean isSpeakingNode(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
        int importantForAccessibility;
        if (accessibilityNodeInfoCompat == null || view == null || (importantForAccessibility = ViewCompat.getImportantForAccessibility(view)) == 4) {
            return false;
        }
        if (importantForAccessibility != 2 || accessibilityNodeInfoCompat.getChildCount() > 0) {
            return hasText(accessibilityNodeInfoCompat) || hasStateDescription(accessibilityNodeInfoCompat) || accessibilityNodeInfoCompat.isCheckable() || hasNonActionableSpeakingDescendants(accessibilityNodeInfoCompat, view);
        }
        return false;
    }

    public static boolean hasText(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return (accessibilityNodeInfoCompat == null || accessibilityNodeInfoCompat.getCollectionInfo() != null || (TextUtils.isEmpty(accessibilityNodeInfoCompat.getText()) && TextUtils.isEmpty(accessibilityNodeInfoCompat.getContentDescription()) && TextUtils.isEmpty(accessibilityNodeInfoCompat.getHintText()))) ? false : true;
    }

    public static boolean isAccessibilityFocusable(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
        if (accessibilityNodeInfoCompat == null || view == null || !accessibilityNodeInfoCompat.isVisibleToUser()) {
            return false;
        }
        return accessibilityNodeInfoCompat.isScreenReaderFocusable() || isActionableForAccessibility(accessibilityNodeInfoCompat);
    }

    public static boolean isActionableForAccessibility(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (accessibilityNodeInfoCompat == null) {
            return false;
        }
        if (accessibilityNodeInfoCompat.isClickable() || accessibilityNodeInfoCompat.isLongClickable() || accessibilityNodeInfoCompat.isFocusable()) {
            return true;
        }
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = accessibilityNodeInfoCompat.getActionList();
        return actionList.contains(16) || actionList.contains(32) || actionList.contains(1);
    }

    public static AccessibilityNodeInfoCompat createNodeInfoFromView(View view) {
        if (view == null) {
            return null;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatObtain = AccessibilityNodeInfoCompat.obtain();
        try {
            ViewCompat.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompatObtain);
            return accessibilityNodeInfoCompatObtain;
        } catch (NullPointerException unused) {
            if (accessibilityNodeInfoCompatObtain != null) {
                accessibilityNodeInfoCompatObtain.recycle();
            }
            return null;
        }
    }

    public static CharSequence getTalkbackDescription(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatCreateNodeInfoFromView = accessibilityNodeInfoCompat == null ? createNodeInfoFromView(view) : AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
        if (accessibilityNodeInfoCompatCreateNodeInfoFromView == null) {
            return null;
        }
        try {
            CharSequence contentDescription = accessibilityNodeInfoCompatCreateNodeInfoFromView.getContentDescription();
            CharSequence text = accessibilityNodeInfoCompatCreateNodeInfoFromView.getText();
            boolean zIsEmpty = TextUtils.isEmpty(text);
            boolean z = view instanceof EditText;
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(contentDescription) && (!z || zIsEmpty)) {
                sb.append(contentDescription);
                return sb;
            }
            if (!zIsEmpty) {
                sb.append(text);
                return sb;
            }
            if (!(view instanceof ViewGroup)) {
                return null;
            }
            StringBuilder sb2 = new StringBuilder();
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                AccessibilityNodeInfoCompat accessibilityNodeInfoCompatObtain = AccessibilityNodeInfoCompat.obtain();
                ViewCompat.onInitializeAccessibilityNodeInfo(childAt, accessibilityNodeInfoCompatObtain);
                if (isSpeakingNode(accessibilityNodeInfoCompatObtain, childAt) && !isAccessibilityFocusable(accessibilityNodeInfoCompatObtain, childAt)) {
                    CharSequence talkbackDescription = getTalkbackDescription(childAt, null);
                    if (!TextUtils.isEmpty(talkbackDescription)) {
                        sb2.append(((Object) talkbackDescription) + delimiter);
                    }
                }
                accessibilityNodeInfoCompatObtain.recycle();
            }
            return removeFinalDelimiter(sb2);
        } finally {
            accessibilityNodeInfoCompatCreateNodeInfoFromView.recycle();
        }
    }

    private static String removeFinalDelimiter(StringBuilder sb) {
        int length = sb.length();
        if (length > 0) {
            sb.delete(length - delimiterLength, length);
        }
        return sb.toString();
    }
}

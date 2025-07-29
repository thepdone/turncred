package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.facebook.react.R;

/* loaded from: classes4.dex */
public class PointerEventHelper {
    public static final String CLICK = "topClick";
    public static final String POINTER_CANCEL = "topPointerCancel";
    public static final String POINTER_DOWN = "topPointerDown";
    public static final String POINTER_ENTER = "topPointerEnter";
    public static final String POINTER_LEAVE = "topPointerLeave";
    public static final String POINTER_MOVE = "topPointerMove";
    public static final String POINTER_OUT = "topPointerOut";
    public static final String POINTER_OVER = "topPointerOver";
    public static final String POINTER_TYPE_MOUSE = "mouse";
    public static final String POINTER_TYPE_PEN = "pen";
    public static final String POINTER_TYPE_TOUCH = "touch";
    public static final String POINTER_TYPE_UNKNOWN = "";
    public static final String POINTER_UP = "topPointerUp";
    private static final int X_FLAG_SUPPORTS_HOVER = 16777216;

    public enum EVENT {
        CANCEL,
        CANCEL_CAPTURE,
        CLICK,
        CLICK_CAPTURE,
        DOWN,
        DOWN_CAPTURE,
        ENTER,
        ENTER_CAPTURE,
        LEAVE,
        LEAVE_CAPTURE,
        MOVE,
        MOVE_CAPTURE,
        UP,
        UP_CAPTURE,
        OUT,
        OUT_CAPTURE,
        OVER,
        OVER_CAPTURE
    }

    public static int getButtons(String str, String str2, int i) {
        if (isExitEvent(str)) {
            return 0;
        }
        if ("touch".equals(str2)) {
            return 1;
        }
        return i;
    }

    public static int getButtonChange(String str, int i, int i2) {
        int i3 = 0;
        if ("touch".equals(str)) {
            return 0;
        }
        int i4 = i2 ^ i;
        if (i4 == 0) {
            return -1;
        }
        if (i4 != 1) {
            i3 = 2;
            if (i4 != 2) {
                if (i4 == 4) {
                    return 1;
                }
                if (i4 != 8) {
                    return i4 != 16 ? -1 : 4;
                }
                return 3;
            }
        }
        return i3;
    }

    public static String getW3CPointerType(int i) {
        if (i == 1) {
            return "touch";
        }
        if (i == 2) {
            return POINTER_TYPE_PEN;
        }
        if (i == 3) {
            return POINTER_TYPE_MOUSE;
        }
        return "";
    }

    /* renamed from: com.facebook.react.uimanager.events.PointerEventHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$uimanager$events$PointerEventHelper$EVENT;

        static {
            int[] iArr = new int[EVENT.values().length];
            $SwitchMap$com$facebook$react$uimanager$events$PointerEventHelper$EVENT = iArr;
            try {
                iArr[EVENT.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$events$PointerEventHelper$EVENT[EVENT.DOWN_CAPTURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$events$PointerEventHelper$EVENT[EVENT.UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$events$PointerEventHelper$EVENT[EVENT.UP_CAPTURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$events$PointerEventHelper$EVENT[EVENT.CANCEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$events$PointerEventHelper$EVENT[EVENT.CANCEL_CAPTURE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$events$PointerEventHelper$EVENT[EVENT.CLICK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$events$PointerEventHelper$EVENT[EVENT.CLICK_CAPTURE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static boolean isListening(View view, EVENT event) {
        if (view == null) {
            return true;
        }
        switch (AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$events$PointerEventHelper$EVENT[event.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                Integer num = (Integer) view.getTag(R.id.pointer_events);
                return (num == null || (num.intValue() & (1 << event.ordinal())) == 0) ? false : true;
        }
    }

    public static int getEventCategory(String str) {
        if (str == null) {
            return 2;
        }
        str.hashCode();
        switch (str) {
        }
        return 2;
    }

    public static boolean supportsHover(MotionEvent motionEvent) {
        if ((motionEvent.getFlags() & 16777216) != 0) {
            return true;
        }
        return motionEvent.isFromSource(8194);
    }

    public static boolean isExitEvent(String str) {
        str.hashCode();
        switch (str) {
            case "topPointerLeave":
            case "topPointerUp":
            case "topPointerOut":
                return true;
            default:
                return false;
        }
    }

    public static double getPressure(int i, String str) {
        if (isExitEvent(str) || i == 0) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        return 0.5d;
    }

    public static boolean isBubblingEvent(String str) {
        str.hashCode();
        switch (str) {
            case "topPointerDown":
            case "topPointerMove":
            case "topPointerOver":
            case "topPointerUp":
            case "topPointerCancel":
            case "topPointerOut":
                return true;
            default:
                return false;
        }
    }
}

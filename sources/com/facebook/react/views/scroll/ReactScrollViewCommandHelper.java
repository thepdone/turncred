package com.facebook.react.views.scroll;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import java.util.Map;

/* loaded from: classes3.dex */
public class ReactScrollViewCommandHelper {
    public static final int COMMAND_FLASH_SCROLL_INDICATORS = 3;
    public static final int COMMAND_SCROLL_TO = 1;
    public static final int COMMAND_SCROLL_TO_END = 2;

    public interface ScrollCommandHandler<T> {
        void flashScrollIndicators(T t);

        void scrollTo(T t, ScrollToCommandData scrollToCommandData);

        void scrollToEnd(T t, ScrollToEndCommandData scrollToEndCommandData);
    }

    public static class ScrollToCommandData {
        public final boolean mAnimated;
        public final int mDestX;
        public final int mDestY;

        ScrollToCommandData(int i, int i2, boolean z) {
            this.mDestX = i;
            this.mDestY = i2;
            this.mAnimated = z;
        }
    }

    public static class ScrollToEndCommandData {
        public final boolean mAnimated;

        ScrollToEndCommandData(boolean z) {
            this.mAnimated = z;
        }
    }

    public static Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("scrollTo", 1, "scrollToEnd", 2, "flashScrollIndicators", 3);
    }

    public static <T> void receiveCommand(ScrollCommandHandler<T> scrollCommandHandler, T t, int i, ReadableArray readableArray) {
        Assertions.assertNotNull(scrollCommandHandler);
        Assertions.assertNotNull(t);
        if (i == 1) {
            scrollTo(scrollCommandHandler, t, (ReadableArray) Assertions.assertNotNull(readableArray));
        } else if (i == 2) {
            scrollToEnd(scrollCommandHandler, t, (ReadableArray) Assertions.assertNotNull(readableArray));
        } else {
            if (i == 3) {
                scrollCommandHandler.flashScrollIndicators(t);
                return;
            }
            throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", Integer.valueOf(i), scrollCommandHandler.getClass().getSimpleName()));
        }
    }

    public static <T> void receiveCommand(ScrollCommandHandler<T> scrollCommandHandler, T t, String str, ReadableArray readableArray) {
        Assertions.assertNotNull(scrollCommandHandler);
        Assertions.assertNotNull(t);
        str.hashCode();
        switch (str) {
            case "scrollTo":
                scrollTo(scrollCommandHandler, t, (ReadableArray) Assertions.assertNotNull(readableArray));
                return;
            case "flashScrollIndicators":
                scrollCommandHandler.flashScrollIndicators(t);
                return;
            case "scrollToEnd":
                scrollToEnd(scrollCommandHandler, t, (ReadableArray) Assertions.assertNotNull(readableArray));
                return;
            default:
                throw new IllegalArgumentException(String.format("Unsupported command %s received by %s.", str, scrollCommandHandler.getClass().getSimpleName()));
        }
    }

    private static <T> void scrollTo(ScrollCommandHandler<T> scrollCommandHandler, T t, ReadableArray readableArray) {
        scrollCommandHandler.scrollTo(t, new ScrollToCommandData(Math.round(PixelUtil.toPixelFromDIP(readableArray.getDouble(0))), Math.round(PixelUtil.toPixelFromDIP(readableArray.getDouble(1))), readableArray.getBoolean(2)));
    }

    private static <T> void scrollToEnd(ScrollCommandHandler<T> scrollCommandHandler, T t, ReadableArray readableArray) {
        scrollCommandHandler.scrollToEnd(t, new ScrollToEndCommandData(readableArray.getBoolean(0)));
    }
}

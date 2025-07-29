package expo.modules.image;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.TouchesHelper;
import expo.modules.image.enums.ContentFit;
import expo.modules.image.enums.Priority;
import expo.modules.image.events.GlideRequestListener;
import expo.modules.image.events.OkHttpProgressListener;
import expo.modules.image.okhttp.GlideUrlWrapper;
import expo.modules.image.records.CachePolicy;
import expo.modules.image.records.ContentPosition;
import expo.modules.image.records.DecodeFormat;
import expo.modules.image.records.ImageErrorEvent;
import expo.modules.image.records.ImageLoadEvent;
import expo.modules.image.records.ImageProgressEvent;
import expo.modules.image.records.ImageTransition;
import expo.modules.image.records.Source;
import expo.modules.image.svg.SVGPictureDrawable;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ExpoView;
import io.sentry.protocol.SentryThread;
import java.lang.ref.WeakReference;
import java.util.List;
import jp.wasabeef.glide.transformations.BlurTransformation;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: ExpoImageViewWrapper.kt */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 ®\u00012\u00020\u0001:\u0002®\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010\u0091\u0001\u001a\u00020\u000e2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010#2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010O2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010OH\u0002J\b\u00105\u001a\u00020TH\u0002J.\u0010\u0095\u0001\u001a\u00020T2\u0007\u0010\u0096\u0001\u001a\u00020\u00152\u0007\u0010\u0097\u0001\u001a\u00020I2\b\u0010\u0098\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u000eH\u0002J\u0012\u0010\u009b\u0001\u001a\u00020T2\u0007\u0010\u0096\u0001\u001a\u00020\u0015H\u0002J\u0013\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u0007\u0010\u0097\u0001\u001a\u00020IH\u0002J\n\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0002J\u0019\u0010'\u001a\u0004\u0018\u00010#2\r\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020#0lH\u0002J%\u0010 \u0001\u001a\u00020\u000e2\u0007\u0010\u0097\u0001\u001a\u00020I2\b\u0010\u0098\u0001\u001a\u00030\u0099\u00012\t\b\u0002\u0010\u009a\u0001\u001a\u00020\u000eJ-\u0010¡\u0001\u001a\u00020T2\u0007\u0010¢\u0001\u001a\u00020(2\u0007\u0010£\u0001\u001a\u00020(2\u0007\u0010¤\u0001\u001a\u00020(2\u0007\u0010¥\u0001\u001a\u00020(H\u0014J\u0007\u0010¦\u0001\u001a\u00020TJ\u001a\u0010§\u0001\u001a\u00020T2\t\b\u0002\u0010¨\u0001\u001a\u00020\u000eH\u0000¢\u0006\u0003\b©\u0001J\u0010\u0010ª\u0001\u001a\u00020T2\u0007\u0010«\u0001\u001a\u00020\u000eJ\u001b\u0010¬\u0001\u001a\u00020T2\b\u0010\u0096\u0001\u001a\u00030\u00ad\u00012\u0006\u0010\u0007\u001a\u00020\u000eH\u0002R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R\u001a\u0010\u001f\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u0016\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010&\u001a\u0004\u0018\u00010#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%R*\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u0007\u001a\u0004\u0018\u00010(@@X\u0080\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010/\u001a\u000200X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R$\u00107\u001a\u0002062\u0006\u0010\u0007\u001a\u000206@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010=\u001a\u00020<2\u0006\u0010\u0007\u001a\u00020<@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010C\u001a\u00020B2\u0006\u0010\u0007\u001a\u00020B@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010K\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0011\"\u0004\bM\u0010\u0013R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010R\u001a\b\u0012\u0004\u0012\u00020T0S8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bU\u0010VR!\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0S8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010X\u001a\u0004\b[\u0010VR!\u0010]\u001a\b\u0012\u0004\u0012\u00020^0S8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b`\u0010X\u001a\u0004\b_\u0010VR!\u0010a\u001a\b\u0012\u0004\u0012\u00020T0S8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bc\u0010X\u001a\u0004\bb\u0010VR!\u0010d\u001a\b\u0012\u0004\u0012\u00020e0S8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bg\u0010X\u001a\u0004\bf\u0010VR$\u0010h\u001a\u0002062\u0006\u0010\u0007\u001a\u000206@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u00109\"\u0004\bj\u0010;R \u0010k\u001a\b\u0012\u0004\u0012\u00020#0lX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001a\u0010q\u001a\u00020rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u000e\u0010w\u001a\u00020xX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010y\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\u000b\"\u0004\b{\u0010\rR\u0017\u0010|\u001a\u00020}X\u0080\u0004¢\u0006\u000b\n\u0003\b\u0080\u0001\u001a\u0004\b~\u0010\u007fR\u000f\u0010\u0081\u0001\u001a\u00020IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0082\u0001\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0083\u0001\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020#0lX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010n\"\u0005\b\u0086\u0001\u0010pR-\u0010\u0087\u0001\u001a\u0004\u0018\u00010(2\b\u0010\u0007\u001a\u0004\u0018\u00010(@@X\u0080\u000e¢\u0006\u0012\n\u0002\u0010.\u001a\u0005\b\u0088\u0001\u0010+\"\u0005\b\u0089\u0001\u0010-R\u000f\u0010\u008a\u0001\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001¨\u0006¯\u0001"}, d2 = {"Lexpo/modules/image/ExpoImageViewWrapper;", "Lexpo/modules/kotlin/views/ExpoView;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "value", "", ViewProps.ACCESSIBILITY_LABEL, "getAccessibilityLabel$expo_image_release", "()Ljava/lang/String;", "setAccessibilityLabel$expo_image_release", "(Ljava/lang/String;)V", "", "accessible", "getAccessible$expo_image_release", "()Z", "setAccessible$expo_image_release", "(Z)V", "activeView", "Lexpo/modules/image/ExpoImageView;", "getActiveView", "()Lexpo/modules/image/ExpoImageView;", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "allowDownscaling", "getAllowDownscaling$expo_image_release", "setAllowDownscaling$expo_image_release", "autoplay", "getAutoplay$expo_image_release", "setAutoplay$expo_image_release", "bestPlaceholder", "Lexpo/modules/image/records/Source;", "getBestPlaceholder", "()Lexpo/modules/image/records/Source;", "bestSource", "getBestSource", "", "blurRadius", "getBlurRadius$expo_image_release", "()Ljava/lang/Integer;", "setBlurRadius$expo_image_release", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "cachePolicy", "Lexpo/modules/image/records/CachePolicy;", "getCachePolicy$expo_image_release", "()Lexpo/modules/image/records/CachePolicy;", "setCachePolicy$expo_image_release", "(Lexpo/modules/image/records/CachePolicy;)V", "clearViewBeforeChangingSource", "Lexpo/modules/image/enums/ContentFit;", "contentFit", "getContentFit$expo_image_release", "()Lexpo/modules/image/enums/ContentFit;", "setContentFit$expo_image_release", "(Lexpo/modules/image/enums/ContentFit;)V", "Lexpo/modules/image/records/ContentPosition;", "contentPosition", "getContentPosition$expo_image_release", "()Lexpo/modules/image/records/ContentPosition;", "setContentPosition$expo_image_release", "(Lexpo/modules/image/records/ContentPosition;)V", "Lexpo/modules/image/records/DecodeFormat;", "decodeFormat", "getDecodeFormat$expo_image_release", "()Lexpo/modules/image/records/DecodeFormat;", "setDecodeFormat$expo_image_release", "(Lexpo/modules/image/records/DecodeFormat;)V", "firstTarget", "Lexpo/modules/image/ImageViewWrapperTarget;", "firstView", "isFocusableProp", "isFocusableProp$expo_image_release", "setFocusableProp$expo_image_release", "loadedSource", "Lexpo/modules/image/GlideModelProvider;", "mainHandler", "Landroid/os/Handler;", "onDisplay", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "", "getOnDisplay$expo_image_release", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onDisplay$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "onError", "Lexpo/modules/image/records/ImageErrorEvent;", "getOnError$expo_image_release", "onError$delegate", "onLoad", "Lexpo/modules/image/records/ImageLoadEvent;", "getOnLoad$expo_image_release", "onLoad$delegate", "onLoadStart", "getOnLoadStart$expo_image_release", "onLoadStart$delegate", "onProgress", "Lexpo/modules/image/records/ImageProgressEvent;", "getOnProgress$expo_image_release", "onProgress$delegate", "placeholderContentFit", "getPlaceholderContentFit$expo_image_release", "setPlaceholderContentFit$expo_image_release", "placeholders", "", "getPlaceholders$expo_image_release", "()Ljava/util/List;", "setPlaceholders$expo_image_release", "(Ljava/util/List;)V", SentryThread.JsonKeys.PRIORITY, "Lexpo/modules/image/enums/Priority;", "getPriority$expo_image_release", "()Lexpo/modules/image/enums/Priority;", "setPriority$expo_image_release", "(Lexpo/modules/image/enums/Priority;)V", "progressListener", "Lexpo/modules/image/events/OkHttpProgressListener;", "recyclingKey", "getRecyclingKey", "setRecyclingKey", "requestManager", "Lcom/bumptech/glide/RequestManager;", "getRequestManager$expo_image_release", "()Lcom/bumptech/glide/RequestManager;", "requestManager$1", "secondTarget", "secondView", "shouldRerender", "sources", "getSources$expo_image_release", "setSources$expo_image_release", "tintColor", "getTintColor$expo_image_release", "setTintColor$expo_image_release", "transformationMatrixChanged", "transition", "Lexpo/modules/image/records/ImageTransition;", "getTransition$expo_image_release", "()Lexpo/modules/image/records/ImageTransition;", "setTransition$expo_image_release", "(Lexpo/modules/image/records/ImageTransition;)V", "cleanIfNeeded", "newBestSource", "newBestSourceModel", "newBestPlaceholderModel", "configureView", ViewHierarchyConstants.VIEW_KEY, TouchesHelper.TARGET_KEY, "resource", "Landroid/graphics/drawable/Drawable;", "isPlaceholder", "copyProps", "createDownsampleStrategy", "Lcom/bumptech/glide/load/resource/bitmap/DownsampleStrategy;", "createPropOptions", "Lcom/bumptech/glide/request/RequestOptions;", "onResourceReady", "onSizeChanged", "w", "h", "oldw", "oldh", "onViewDestroys", "rerenderIfNeeded", "shouldRerenderBecauseOfResize", "rerenderIfNeeded$expo_image_release", "setIsAnimating", "setAnimating", "setIsScreenReaderFocusable", "Landroid/view/View;", "Companion", "expo-image_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExpoImageViewWrapper extends ExpoView {
    private static RequestManager requestManager;
    private String accessibilityLabel;
    private boolean accessible;
    private boolean allowDownscaling;
    private boolean autoplay;
    private Integer blurRadius;
    private CachePolicy cachePolicy;
    private boolean clearViewBeforeChangingSource;
    private ContentFit contentFit;
    private ContentPosition contentPosition;
    private DecodeFormat decodeFormat;
    private ImageViewWrapperTarget firstTarget;
    private final ExpoImageView firstView;
    private boolean isFocusableProp;
    private GlideModelProvider loadedSource;
    private final Handler mainHandler;

    /* renamed from: onDisplay$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onDisplay;

    /* renamed from: onError$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onError;

    /* renamed from: onLoad$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onLoad;

    /* renamed from: onLoadStart$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onLoadStart;

    /* renamed from: onProgress$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onProgress;
    private ContentFit placeholderContentFit;
    private List<? extends Source> placeholders;
    private Priority priority;
    private final OkHttpProgressListener progressListener;
    private String recyclingKey;

    /* renamed from: requestManager$1, reason: from kotlin metadata */
    private final RequestManager requestManager;
    private ImageViewWrapperTarget secondTarget;
    private final ExpoImageView secondView;
    private boolean shouldRerender;
    private List<? extends Source> sources;
    private Integer tintColor;
    private boolean transformationMatrixChanged;
    private ImageTransition transition;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ExpoImageViewWrapper.class, "onLoadStart", "getOnLoadStart$expo_image_release()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoImageViewWrapper.class, "onProgress", "getOnProgress$expo_image_release()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoImageViewWrapper.class, "onError", "getOnError$expo_image_release()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoImageViewWrapper.class, "onLoad", "getOnLoad$expo_image_release()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoImageViewWrapper.class, "onDisplay", "getOnDisplay$expo_image_release()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0))};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static WeakReference<AppContext> appContextRef = new WeakReference<>(null);
    private static WeakReference<Activity> activityRef = new WeakReference<>(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoImageViewWrapper(Context context, AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.requestManager = INSTANCE.getOrCreateRequestManager(appContext, getActivity());
        this.progressListener = new OkHttpProgressListener(new WeakReference(this));
        ExpoImageView expoImageView = new ExpoImageView(getActivity());
        this.firstView = expoImageView;
        ExpoImageView expoImageView2 = new ExpoImageView(getActivity());
        this.secondView = expoImageView2;
        this.mainHandler = new Handler(context.getMainLooper());
        this.firstTarget = new ImageViewWrapperTarget(new WeakReference(this));
        this.secondTarget = new ImageViewWrapperTarget(new WeakReference(this));
        ExpoImageViewWrapper expoImageViewWrapper = this;
        this.onLoadStart = new ViewEventDelegate(expoImageViewWrapper, null);
        this.onProgress = new ViewEventDelegate(expoImageViewWrapper, null);
        this.onError = new ViewEventDelegate(expoImageViewWrapper, null);
        this.onLoad = new ViewEventDelegate(expoImageViewWrapper, null);
        this.onDisplay = new ViewEventDelegate(expoImageViewWrapper, null);
        this.sources = CollectionsKt.emptyList();
        this.placeholders = CollectionsKt.emptyList();
        this.contentFit = ContentFit.Cover;
        this.placeholderContentFit = ContentFit.ScaleDown;
        this.contentPosition = ContentPosition.INSTANCE.getCenter();
        this.allowDownscaling = true;
        this.decodeFormat = DecodeFormat.ARGB_8888;
        this.autoplay = true;
        this.priority = Priority.NORMAL;
        this.cachePolicy = CachePolicy.DISK;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        setLayoutParams(layoutParams);
        expoImageView.setVisibility(0);
        expoImageView2.setVisibility(0);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.addView(expoImageView, layoutParams);
        frameLayout.addView(expoImageView2, layoutParams);
        addView(frameLayout, layoutParams);
    }

    private final Activity getActivity() {
        return getAppContext().getThrowingActivity();
    }

    /* renamed from: getRequestManager$expo_image_release, reason: from getter */
    public final RequestManager getRequestManager() {
        return this.requestManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ExpoImageView getActiveView() {
        if (this.secondView.getDrawable() != null) {
            return this.secondView;
        }
        return this.firstView;
    }

    public final ViewEventCallback<Unit> getOnLoadStart$expo_image_release() {
        return this.onLoadStart.getValue(this, $$delegatedProperties[0]);
    }

    public final ViewEventCallback<ImageProgressEvent> getOnProgress$expo_image_release() {
        return this.onProgress.getValue(this, $$delegatedProperties[1]);
    }

    public final ViewEventCallback<ImageErrorEvent> getOnError$expo_image_release() {
        return this.onError.getValue(this, $$delegatedProperties[2]);
    }

    public final ViewEventCallback<ImageLoadEvent> getOnLoad$expo_image_release() {
        return this.onLoad.getValue(this, $$delegatedProperties[3]);
    }

    public final ViewEventCallback<Unit> getOnDisplay$expo_image_release() {
        return this.onDisplay.getValue(this, $$delegatedProperties[4]);
    }

    public final List<Source> getSources$expo_image_release() {
        return this.sources;
    }

    public final void setSources$expo_image_release(List<? extends Source> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.sources = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Source getBestSource() {
        return getBestSource(this.sources);
    }

    public final List<Source> getPlaceholders$expo_image_release() {
        return this.placeholders;
    }

    public final void setPlaceholders$expo_image_release(List<? extends Source> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.placeholders = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Source getBestPlaceholder() {
        return getBestSource(this.placeholders);
    }

    /* renamed from: getBlurRadius$expo_image_release, reason: from getter */
    public final Integer getBlurRadius() {
        return this.blurRadius;
    }

    public final void setBlurRadius$expo_image_release(Integer num) {
        if (!Intrinsics.areEqual(this.blurRadius, num)) {
            this.shouldRerender = true;
        }
        this.blurRadius = num;
    }

    /* renamed from: getTransition$expo_image_release, reason: from getter */
    public final ImageTransition getTransition() {
        return this.transition;
    }

    public final void setTransition$expo_image_release(ImageTransition imageTransition) {
        this.transition = imageTransition;
    }

    /* renamed from: getContentFit$expo_image_release, reason: from getter */
    public final ContentFit getContentFit() {
        return this.contentFit;
    }

    public final void setContentFit$expo_image_release(ContentFit value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.contentFit = value;
        getActiveView().setContentFit$expo_image_release(value);
        this.transformationMatrixChanged = true;
    }

    /* renamed from: getPlaceholderContentFit$expo_image_release, reason: from getter */
    public final ContentFit getPlaceholderContentFit() {
        return this.placeholderContentFit;
    }

    public final void setPlaceholderContentFit$expo_image_release(ContentFit value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.placeholderContentFit = value;
        getActiveView().setPlaceholderContentFit$expo_image_release(value);
        this.transformationMatrixChanged = true;
    }

    /* renamed from: getContentPosition$expo_image_release, reason: from getter */
    public final ContentPosition getContentPosition() {
        return this.contentPosition;
    }

    public final void setContentPosition$expo_image_release(ContentPosition value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.contentPosition = value;
        getActiveView().setContentPosition$expo_image_release(value);
        this.transformationMatrixChanged = true;
    }

    /* renamed from: getTintColor$expo_image_release, reason: from getter */
    public final Integer getTintColor() {
        return this.tintColor;
    }

    public final void setTintColor$expo_image_release(Integer num) {
        this.tintColor = num;
        if (getActiveView().getDrawable() instanceof SVGPictureDrawable) {
            this.shouldRerender = true;
        } else {
            getActiveView().setTintColor$expo_image_release(num);
        }
    }

    /* renamed from: isFocusableProp$expo_image_release, reason: from getter */
    public final boolean getIsFocusableProp() {
        return this.isFocusableProp;
    }

    public final void setFocusableProp$expo_image_release(boolean z) {
        this.isFocusableProp = z;
        getActiveView().setFocusable(z);
    }

    /* renamed from: getAccessible$expo_image_release, reason: from getter */
    public final boolean getAccessible() {
        return this.accessible;
    }

    public final void setAccessible$expo_image_release(boolean z) {
        this.accessible = z;
        setIsScreenReaderFocusable(getActiveView(), z);
    }

    /* renamed from: getAccessibilityLabel$expo_image_release, reason: from getter */
    public final String getAccessibilityLabel() {
        return this.accessibilityLabel;
    }

    public final void setAccessibilityLabel$expo_image_release(String str) {
        this.accessibilityLabel = str;
        getActiveView().setContentDescription(this.accessibilityLabel);
    }

    public final String getRecyclingKey() {
        return this.recyclingKey;
    }

    public final void setRecyclingKey(String str) {
        String str2 = this.recyclingKey;
        this.clearViewBeforeChangingSource = (str2 == null || str == null || Intrinsics.areEqual(str, str2)) ? false : true;
        this.recyclingKey = str;
    }

    /* renamed from: getAllowDownscaling$expo_image_release, reason: from getter */
    public final boolean getAllowDownscaling() {
        return this.allowDownscaling;
    }

    public final void setAllowDownscaling$expo_image_release(boolean z) {
        this.allowDownscaling = z;
        this.shouldRerender = true;
    }

    /* renamed from: getDecodeFormat$expo_image_release, reason: from getter */
    public final DecodeFormat getDecodeFormat() {
        return this.decodeFormat;
    }

    public final void setDecodeFormat$expo_image_release(DecodeFormat value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.decodeFormat = value;
        this.shouldRerender = true;
    }

    /* renamed from: getAutoplay$expo_image_release, reason: from getter */
    public final boolean getAutoplay() {
        return this.autoplay;
    }

    public final void setAutoplay$expo_image_release(boolean z) {
        this.autoplay = z;
    }

    /* renamed from: getPriority$expo_image_release, reason: from getter */
    public final Priority getPriority() {
        return this.priority;
    }

    public final void setPriority$expo_image_release(Priority priority) {
        Intrinsics.checkNotNullParameter(priority, "<set-?>");
        this.priority = priority;
    }

    /* renamed from: getCachePolicy$expo_image_release, reason: from getter */
    public final CachePolicy getCachePolicy() {
        return this.cachePolicy;
    }

    public final void setCachePolicy$expo_image_release(CachePolicy cachePolicy) {
        Intrinsics.checkNotNullParameter(cachePolicy, "<set-?>");
        this.cachePolicy = cachePolicy;
    }

    public final void setIsAnimating(boolean setAnimating) {
        Object drawable = getActiveView().getDrawable();
        if (drawable instanceof Animatable) {
            if (setAnimating) {
                ((Animatable) drawable).start();
            } else {
                ((Animatable) drawable).stop();
            }
        }
    }

    private final void copyProps(ExpoImageView view) {
        view.setContentFit$expo_image_release(this.contentFit);
        view.setContentPosition$expo_image_release(this.contentPosition);
        view.setTintColor$expo_image_release(this.tintColor);
        view.setFocusable(this.isFocusableProp);
        view.setContentDescription(this.accessibilityLabel);
        setIsScreenReaderFocusable(view, this.accessible);
    }

    private final void setIsScreenReaderFocusable(View view, final boolean value) {
        if (Build.VERSION.SDK_INT >= 28) {
            view.setScreenReaderFocusable(value);
        } else {
            ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() { // from class: expo.modules.image.ExpoImageViewWrapper.setIsScreenReaderFocusable.1
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                    Intrinsics.checkNotNullParameter(host, "host");
                    Intrinsics.checkNotNullParameter(info, "info");
                    info.setScreenReaderFocusable(value);
                    super.onInitializeAccessibilityNodeInfo(host, info);
                }
            });
        }
    }

    public static /* synthetic */ boolean onResourceReady$default(ExpoImageViewWrapper expoImageViewWrapper, ImageViewWrapperTarget imageViewWrapperTarget, Drawable drawable, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return expoImageViewWrapper.onResourceReady(imageViewWrapperTarget, drawable, z);
    }

    public final boolean onResourceReady(final ImageViewWrapperTarget target, final Drawable resource, final boolean isPlaceholder) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(resource, "resource");
        return this.mainHandler.postAtFrontOfQueue(new Runnable() { // from class: expo.modules.image.ExpoImageViewWrapper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ExpoImageViewWrapper.onResourceReady$lambda$5(this.f$0, isPlaceholder, target, resource);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onResourceReady$lambda$5(final ExpoImageViewWrapper this$0, boolean z, final ImageViewWrapperTarget target, Drawable resource) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(target, "$target");
        Intrinsics.checkNotNullParameter(resource, "$resource");
        androidx.tracing.Trace.beginSection("[" + Trace.INSTANCE.getTag() + "] onResourceReady");
        try {
            ImageTransition transition = this$0.getTransition();
            long duration = transition != null ? transition.getDuration() : 0;
            if (!z || !target.getHasSource()) {
                Pair pair = this$0.firstView.getDrawable() == null ? TuplesKt.to(this$0.firstView, this$0.secondView) : TuplesKt.to(this$0.secondView, this$0.firstView);
                ExpoImageView expoImageView = (ExpoImageView) pair.component1();
                final ExpoImageView expoImageView2 = (ExpoImageView) pair.component2();
                final Function0<ImageViewWrapperTarget> function0 = new Function0<ImageViewWrapperTarget>() { // from class: expo.modules.image.ExpoImageViewWrapper$onResourceReady$1$1$clearPreviousView$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ImageViewWrapperTarget invoke() {
                        ImageViewWrapperTarget imageViewWrapperTargetRecycleView = expoImageView2.recycleView();
                        if (imageViewWrapperTargetRecycleView == null) {
                            return null;
                        }
                        ImageViewWrapperTarget imageViewWrapperTarget = target;
                        ExpoImageViewWrapper expoImageViewWrapper = this$0;
                        if (Intrinsics.areEqual(imageViewWrapperTargetRecycleView, imageViewWrapperTarget)) {
                            return imageViewWrapperTargetRecycleView;
                        }
                        imageViewWrapperTargetRecycleView.clear(expoImageViewWrapper.getRequestManager());
                        return imageViewWrapperTargetRecycleView;
                    }
                };
                this$0.configureView(expoImageView, target, resource, z);
                if (target.getHasSource()) {
                    this$0.getOnDisplay$expo_image_release().invoke(Unit.INSTANCE);
                }
                if (duration <= 0) {
                    function0.invoke();
                    expoImageView.setAlpha(1.0f);
                    expoImageView.bringToFront();
                } else {
                    expoImageView.bringToFront();
                    expoImageView2.setAlpha(1.0f);
                    expoImageView.setAlpha(0.0f);
                    ViewPropertyAnimator viewPropertyAnimatorAnimate = expoImageView2.animate();
                    viewPropertyAnimatorAnimate.setDuration(duration);
                    viewPropertyAnimatorAnimate.alpha(0.0f);
                    viewPropertyAnimatorAnimate.withEndAction(new Runnable() { // from class: expo.modules.image.ExpoImageViewWrapper$onResourceReady$1$1$1$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            function0.invoke();
                        }
                    });
                    ViewPropertyAnimator viewPropertyAnimatorAnimate2 = expoImageView.animate();
                    viewPropertyAnimatorAnimate2.setDuration(duration);
                    viewPropertyAnimatorAnimate2.alpha(1.0f);
                }
            } else {
                if ((this$0.firstView.getDrawable() == null || this$0.firstView.getIsPlaceholder()) && this$0.secondView.getDrawable() == null) {
                    ImageViewWrapperTarget imageViewWrapperTargetRecycleView = this$0.firstView.recycleView();
                    if (imageViewWrapperTargetRecycleView != null && !Intrinsics.areEqual(imageViewWrapperTargetRecycleView, target)) {
                        imageViewWrapperTargetRecycleView.clear(this$0.getRequestManager());
                    }
                    this$0.configureView(this$0.firstView, target, resource, z);
                    if (duration > 0) {
                        this$0.firstView.bringToFront();
                        this$0.firstView.setAlpha(0.0f);
                        this$0.secondView.setVisibility(8);
                        ViewPropertyAnimator viewPropertyAnimatorAnimate3 = this$0.firstView.animate();
                        viewPropertyAnimatorAnimate3.setDuration(duration);
                        viewPropertyAnimatorAnimate3.alpha(1.0f);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            if ((resource instanceof Animatable) && !z && !this$0.getAutoplay()) {
                ((Animatable) resource).stop();
            }
            Unit unit2 = Unit.INSTANCE;
        } finally {
            androidx.tracing.Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void configureView(ExpoImageView view, ImageViewWrapperTarget target, Drawable resource, boolean isPlaceholder) {
        view.setImageDrawable(resource);
        view.setPlaceholder(isPlaceholder);
        ContentFit placeholderContentFit = target.getPlaceholderContentFit();
        if (placeholderContentFit == null) {
            placeholderContentFit = ContentFit.ScaleDown;
        }
        view.setPlaceholderContentFit$expo_image_release(placeholderContentFit);
        copyProps(view);
        view.setVisibility(0);
        view.setCurrentTarget(target);
        view.layout(0, 0, getWidth(), getHeight());
        view.applyTransformationMatrix();
        target.setUsed(true);
        if (resource instanceof Animatable) {
            ((Animatable) resource).start();
        }
    }

    private final Source getBestSource(List<? extends Source> sources) {
        Source source = null;
        if (sources.isEmpty()) {
            return null;
        }
        if (sources.size() == 1) {
            return (Source) CollectionsKt.first((List) sources);
        }
        int width = getWidth() * getHeight();
        if (width == 0) {
            return null;
        }
        double d = Double.MAX_VALUE;
        for (Source source2 : sources) {
            double dAbs = Math.abs(1 - (source2.getPixelCount() / width));
            if (dAbs < d) {
                source = source2;
                d = dAbs;
            }
        }
        return source;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rerenderIfNeeded$expo_image_release((!this.allowDownscaling || this.contentFit == ContentFit.Fill || this.contentFit == ContentFit.None) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RequestOptions createPropOptions() {
        RequestOptions requestOptionsPriority = new RequestOptions().priority(this.priority.toGlidePriority$expo_image_release());
        Intrinsics.checkNotNullExpressionValue(requestOptionsPriority, "priority(...)");
        RequestOptions requestOptions = requestOptionsPriority;
        if ((this.cachePolicy == CachePolicy.MEMORY_AND_DISK || this.cachePolicy == CachePolicy.MEMORY) ? false : true) {
            RequestOptions requestOptionsSkipMemoryCache = requestOptions.skipMemoryCache(true);
            Intrinsics.checkNotNullExpressionValue(requestOptionsSkipMemoryCache, "skipMemoryCache(...)");
            requestOptions = requestOptionsSkipMemoryCache;
        }
        if (this.cachePolicy == CachePolicy.NONE || this.cachePolicy == CachePolicy.MEMORY) {
            RequestOptions requestOptionsDiskCacheStrategy = requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE);
            Intrinsics.checkNotNullExpressionValue(requestOptionsDiskCacheStrategy, "diskCacheStrategy(...)");
            requestOptions = requestOptionsDiskCacheStrategy;
        }
        Integer num = this.blurRadius;
        if (num == null) {
            return requestOptions;
        }
        RequestOptions requestOptionsTransform = requestOptions.transform(new BlurTransformation(Math.min(num.intValue(), 25), 4));
        Intrinsics.checkNotNullExpressionValue(requestOptionsTransform, "transform(...)");
        return requestOptionsTransform;
    }

    public final void onViewDestroys() {
        this.firstView.setImageDrawable(null);
        this.secondView.setImageDrawable(null);
        this.requestManager.clear(this.firstTarget);
        this.requestManager.clear(this.secondTarget);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean cleanIfNeeded(Source newBestSource, GlideModelProvider newBestSourceModel, GlideModelProvider newBestPlaceholderModel) {
        if (getWidth() != 0 && getHeight() != 0 && ((newBestSource != null && newBestSourceModel != null) || newBestPlaceholderModel != null)) {
            return false;
        }
        this.firstView.recycleView();
        this.secondView.recycleView();
        this.requestManager.clear(this.firstTarget);
        this.requestManager.clear(this.secondTarget);
        this.shouldRerender = false;
        this.loadedSource = null;
        this.transformationMatrixChanged = false;
        this.clearViewBeforeChangingSource = false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DownsampleStrategy createDownsampleStrategy(ImageViewWrapperTarget target) {
        if (!this.allowDownscaling) {
            DownsampleStrategy downsampleStrategy = DownsampleStrategy.NONE;
            Intrinsics.checkNotNull(downsampleStrategy);
            return downsampleStrategy;
        }
        if (this.contentFit != ContentFit.Fill && this.contentFit != ContentFit.None) {
            return new ContentFitDownsampleStrategy(target, this.contentFit);
        }
        return new SafeDownsampleStrategy(this.decodeFormat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearViewBeforeChangingSource() {
        ExpoImageView expoImageView;
        if (this.clearViewBeforeChangingSource) {
            if (this.firstView.getDrawable() != null) {
                expoImageView = this.firstView;
            } else {
                expoImageView = this.secondView;
            }
            ImageViewWrapperTarget imageViewWrapperTargetRecycleView = expoImageView.recycleView();
            if (imageViewWrapperTargetRecycleView != null) {
                imageViewWrapperTargetRecycleView.clear(this.requestManager);
            }
        }
    }

    public static /* synthetic */ void rerenderIfNeeded$expo_image_release$default(ExpoImageViewWrapper expoImageViewWrapper, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        expoImageViewWrapper.rerenderIfNeeded$expo_image_release(z);
    }

    public final void rerenderIfNeeded$expo_image_release(boolean shouldRerenderBecauseOfResize) {
        GlideModelProvider glideModelProviderCreateGlideModelProvider;
        GlideModelProvider glideModelProviderCreateGlideModelProvider2;
        RequestOptions requestOptionsCreateGlideOptions;
        ContentFit placeholderContentFit;
        androidx.tracing.Trace.beginSection("[" + Trace.INSTANCE.getTag() + "] " + ("rerenderIfNeeded(shouldRerenderBecauseOfResize=" + shouldRerenderBecauseOfResize + ")"));
        try {
            Source bestSource = getBestSource();
            Source bestPlaceholder = getBestPlaceholder();
            if (bestSource != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                glideModelProviderCreateGlideModelProvider = bestSource.createGlideModelProvider(context);
            } else {
                glideModelProviderCreateGlideModelProvider = null;
            }
            if (bestPlaceholder != null) {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                glideModelProviderCreateGlideModelProvider2 = bestPlaceholder.createGlideModelProvider(context2);
            } else {
                glideModelProviderCreateGlideModelProvider2 = null;
            }
            if (!cleanIfNeeded(bestSource, glideModelProviderCreateGlideModelProvider, glideModelProviderCreateGlideModelProvider2)) {
                if (!Intrinsics.areEqual(glideModelProviderCreateGlideModelProvider, this.loadedSource) || this.shouldRerender || ((glideModelProviderCreateGlideModelProvider == null && glideModelProviderCreateGlideModelProvider2 != null) || shouldRerenderBecauseOfResize)) {
                    clearViewBeforeChangingSource();
                    this.shouldRerender = false;
                    this.loadedSource = glideModelProviderCreateGlideModelProvider;
                    if (bestSource != null) {
                        Context context3 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                        requestOptionsCreateGlideOptions = bestSource.createGlideOptions(context3);
                    } else {
                        requestOptionsCreateGlideOptions = null;
                    }
                    RequestOptions requestOptionsCreatePropOptions = createPropOptions();
                    Object glideModel = glideModelProviderCreateGlideModelProvider != null ? glideModelProviderCreateGlideModelProvider.getGlideModel() : null;
                    if (glideModel instanceof GlideUrlWrapper) {
                        ((GlideUrlWrapper) glideModel).setProgressListener(this.progressListener);
                    }
                    getOnLoadStart$expo_image_release().invoke(Unit.INSTANCE);
                    ImageViewWrapperTarget imageViewWrapperTarget = this.secondTarget.getIsUsed() ? this.firstTarget : this.secondTarget;
                    imageViewWrapperTarget.setHasSource(glideModelProviderCreateGlideModelProvider != null);
                    DownsampleStrategy downsampleStrategyCreateDownsampleStrategy = createDownsampleStrategy(imageViewWrapperTarget);
                    RequestBuilder<Drawable> requestBuilderLoad = getRequestManager().asDrawable().load(glideModel);
                    Intrinsics.checkNotNullExpressionValue(requestBuilderLoad, "load(...)");
                    if (bestPlaceholder != null && glideModelProviderCreateGlideModelProvider2 != null) {
                        if (!bestPlaceholder.usesPlaceholderContentFit()) {
                            placeholderContentFit = getContentFit();
                        } else {
                            placeholderContentFit = getPlaceholderContentFit();
                        }
                        imageViewWrapperTarget.setPlaceholderContentFit(placeholderContentFit);
                        RequestBuilder<Drawable> requestBuilderLoad2 = getRequestManager().load(glideModelProviderCreateGlideModelProvider2.getGlideModel());
                        Context context4 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                        requestBuilderLoad = requestBuilderLoad.thumbnail(requestBuilderLoad2.apply((BaseRequestOptions<?>) bestPlaceholder.createGlideOptions(context4)));
                        Intrinsics.checkNotNullExpressionValue(requestBuilderLoad, "thumbnail(...)");
                    }
                    RequestBuilder requestBuilderApply = requestBuilderLoad.downsample(downsampleStrategyCreateDownsampleStrategy).addListener(new GlideRequestListener(new WeakReference(this))).encodeQuality(100).format(getDecodeFormat().toGlideFormat()).apply((BaseRequestOptions<?>) requestOptionsCreatePropOptions);
                    Intrinsics.checkNotNullExpressionValue(requestBuilderApply, "apply(...)");
                    RequestBuilder requestBuilderApply2 = GlideExtensionsKt.apply(requestBuilderApply, requestOptionsCreateGlideOptions);
                    Integer tintColor = getTintColor();
                    if (tintColor != null) {
                        requestBuilderApply2 = requestBuilderApply2.apply((BaseRequestOptions<?>) new RequestOptions().set(CustomOptions.INSTANCE.getTintColor(), Integer.valueOf(tintColor.intValue())));
                        Intrinsics.checkNotNullExpressionValue(requestBuilderApply2, "apply(...)");
                    }
                    int nextCookieValue = Trace.INSTANCE.getNextCookieValue();
                    androidx.tracing.Trace.beginAsyncSection("[" + Trace.INSTANCE.getTag() + "] " + Trace.INSTANCE.getLoadNewImageBlock(), nextCookieValue);
                    imageViewWrapperTarget.setCookie(nextCookieValue);
                    requestBuilderApply2.into((RequestBuilder) imageViewWrapperTarget);
                    this.transformationMatrixChanged = false;
                    this.clearViewBeforeChangingSource = false;
                } else {
                    if (this.transformationMatrixChanged) {
                        getActiveView().applyTransformationMatrix();
                    }
                    this.transformationMatrixChanged = false;
                    this.clearViewBeforeChangingSource = false;
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            androidx.tracing.Trace.endSection();
        }
    }

    /* compiled from: ExpoImageViewWrapper.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lexpo/modules/image/ExpoImageViewWrapper$Companion;", "", "()V", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "appContextRef", "Lexpo/modules/kotlin/AppContext;", "requestManager", "Lcom/bumptech/glide/RequestManager;", "createNewRequestManager", "activity", "getOrCreateRequestManager", "appContext", "expo-image_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RequestManager getOrCreateRequestManager(AppContext appContext, Activity activity) {
            Intrinsics.checkNotNullParameter(appContext, "appContext");
            Intrinsics.checkNotNullParameter(activity, "activity");
            synchronized (ExpoImageViewWrapper.INSTANCE) {
                RequestManager requestManager = ExpoImageViewWrapper.requestManager;
                if (requestManager != null) {
                    if (Intrinsics.areEqual(ExpoImageViewWrapper.appContextRef.get(), appContext) && Intrinsics.areEqual(ExpoImageViewWrapper.activityRef.get(), activity)) {
                        return requestManager;
                    }
                    RequestManager requestManagerCreateNewRequestManager = ExpoImageViewWrapper.INSTANCE.createNewRequestManager(activity);
                    Companion companion = ExpoImageViewWrapper.INSTANCE;
                    ExpoImageViewWrapper.requestManager = requestManagerCreateNewRequestManager;
                    Companion companion2 = ExpoImageViewWrapper.INSTANCE;
                    ExpoImageViewWrapper.appContextRef = new WeakReference(appContext);
                    Companion companion3 = ExpoImageViewWrapper.INSTANCE;
                    ExpoImageViewWrapper.activityRef = new WeakReference(activity);
                    return requestManagerCreateNewRequestManager;
                }
                RequestManager requestManagerCreateNewRequestManager2 = ExpoImageViewWrapper.INSTANCE.createNewRequestManager(activity);
                Companion companion4 = ExpoImageViewWrapper.INSTANCE;
                ExpoImageViewWrapper.requestManager = requestManagerCreateNewRequestManager2;
                Companion companion5 = ExpoImageViewWrapper.INSTANCE;
                ExpoImageViewWrapper.appContextRef = new WeakReference(appContext);
                Companion companion6 = ExpoImageViewWrapper.INSTANCE;
                ExpoImageViewWrapper.activityRef = new WeakReference(activity);
                return requestManagerCreateNewRequestManager2;
            }
        }

        private final RequestManager createNewRequestManager(Activity activity) {
            RequestManager requestManagerWith = Glide.with(activity);
            Intrinsics.checkNotNullExpressionValue(requestManagerWith, "with(...)");
            return requestManagerWith;
        }
    }
}

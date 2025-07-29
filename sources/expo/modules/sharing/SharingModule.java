package expo.modules.sharing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.core.content.FileProvider;
import androidx.tracing.Trace;
import com.facebook.share.internal.ShareConstants;
import expo.modules.core.errors.InvalidArgumentException;
import expo.modules.interfaces.filesystem.FilePermissionModuleInterface;
import expo.modules.interfaces.filesystem.Permission;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.EventListenerWithSenderAndPayload;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.OnActivityResultPayload;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import java.io.File;
import java.net.URLConnection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: SharingModule.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lexpo/modules/sharing/SharingModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "pendingPromise", "Lexpo/modules/kotlin/Promise;", "createSharingIntent", "Landroid/content/Intent;", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "mimeType", "", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "getLocalFileFoUrl", "Ljava/io/File;", "url", "isAllowedToRead", "", "Companion", "expo-sharing_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SharingModule extends Module {
    private static final int REQUEST_CODE = 8524;
    private Promise pendingPromise;

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() throws Exceptions.ReactContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        SharingModule sharingModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (sharingModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(sharingModule);
            moduleDefinitionBuilder.Name("ExpoSharing");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[2];
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.sharing.SharingModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(String.class);
                    }
                }));
            }
            anyTypeArr[0] = anyType;
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(SharingOptions.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(SharingOptions.class), false, new Function0<KType>() { // from class: expo.modules.sharing.SharingModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(SharingOptions.class);
                    }
                }));
            }
            anyTypeArr[1] = anyType2;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("shareAsync", anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sharing.SharingModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$3
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws SharingInvalidArgsException, SharingInProgressException, SharingFailedException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    SharingOptions sharingOptions = (SharingOptions) objArr[1];
                    String str = (String) obj;
                    if (this.this$0.pendingPromise == null) {
                        try {
                            File localFileFoUrl = this.this$0.getLocalFileFoUrl(str);
                            Uri uriForFile = FileProvider.getUriForFile(this.this$0.getContext(), this.this$0.getContext().getApplicationInfo().packageName + ".SharingFileProvider", localFileFoUrl);
                            String mimeType = sharingOptions.getMimeType();
                            if (mimeType == null) {
                                mimeType = URLConnection.guessContentTypeFromName(localFileFoUrl.getName());
                            }
                            if (mimeType == null) {
                                mimeType = "*/*";
                            }
                            SharingModule sharingModule2 = this.this$0;
                            Intrinsics.checkNotNull(uriForFile);
                            Intent intentCreateChooser = Intent.createChooser(sharingModule2.createSharingIntent(uriForFile, mimeType), sharingOptions.getDialogTitle());
                            List<ResolveInfo> listQueryIntentActivities = this.this$0.getContext().getPackageManager().queryIntentActivities(intentCreateChooser, 65536);
                            Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
                            Iterator<T> it = listQueryIntentActivities.iterator();
                            while (it.hasNext()) {
                                this.this$0.getContext().grantUriPermission(((ResolveInfo) it.next()).activityInfo.packageName, uriForFile, 1);
                            }
                            this.this$0.pendingPromise = promise;
                            this.this$0.getAppContext().getThrowingActivity().startActivityForResult(intentCreateChooser, 8524);
                            return;
                        } catch (InvalidArgumentException e) {
                            throw new SharingInvalidArgsException(e.getMessage(), e);
                        } catch (Exception e2) {
                            throw new SharingFailedException("Failed to share the file: " + e2.getMessage(), e2);
                        }
                    }
                    throw new SharingInProgressException();
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws SharingInvalidArgsException, SharingInProgressException, SharingFailedException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder2.getAsyncFunctions().put("shareAsync", asyncFunctionWithPromiseComponent);
            moduleDefinitionBuilder.getEventListeners().put(EventName.ON_ACTIVITY_RESULT, new EventListenerWithSenderAndPayload(EventName.ON_ACTIVITY_RESULT, new Function2<Activity, OnActivityResultPayload, Unit>() { // from class: expo.modules.sharing.SharingModule$definition$lambda$3$$inlined$OnActivityResult$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Activity activity, OnActivityResultPayload onActivityResultPayload) {
                    invoke2(activity, onActivityResultPayload);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Activity sender, OnActivityResultPayload payload) {
                    Intrinsics.checkNotNullParameter(sender, "sender");
                    Intrinsics.checkNotNullParameter(payload, "payload");
                    if (payload.getRequestCode() != 8524 || this.this$0.pendingPromise == null) {
                        return;
                    }
                    Promise promise = this.this$0.pendingPromise;
                    if (promise != null) {
                        promise.resolve((Object) null);
                    }
                    this.this$0.pendingPromise = null;
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getLocalFileFoUrl(String url) throws InvalidArgumentException {
        if (url == null) {
            throw new InvalidArgumentException("URL to share cannot be null.");
        }
        Uri uri = Uri.parse(url);
        if (!Intrinsics.areEqual("file", uri.getScheme())) {
            throw new InvalidArgumentException("Only local file URLs are supported (expected scheme to be 'file', got '" + uri.getScheme() + "'.");
        }
        String path = uri.getPath();
        if (path == null) {
            throw new InvalidArgumentException("Path component of the URL to share cannot be null.");
        }
        if (!isAllowedToRead(path)) {
            throw new InvalidArgumentException("Not allowed to read file under given URL.");
        }
        return new File(path);
    }

    private final boolean isAllowedToRead(String url) {
        EnumSet<Permission> pathPermissions;
        FilePermissionModuleInterface filePermission = getAppContext().getFilePermission();
        if (filePermission == null || (pathPermissions = filePermission.getPathPermissions(getContext(), url)) == null) {
            return false;
        }
        return pathPermissions.contains(Permission.READ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent createSharingIntent(Uri uri, String mimeType) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setTypeAndNormalize(mimeType);
        intent.addFlags(1);
        return intent;
    }
}

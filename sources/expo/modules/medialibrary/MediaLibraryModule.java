package expo.modules.medialibrary;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentSender;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.Log;
import androidx.tracing.Trace;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.share.internal.ShareConstants;
import expo.modules.core.errors.ModuleDestroyedException;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventListenerWithSenderAndPayload;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.OnActivityResultPayload;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.medialibrary.MediaLibraryModule;
import expo.modules.medialibrary.MediaLibraryUtils;
import expo.modules.medialibrary.albums.AlbumUtilsKt;
import expo.modules.medialibrary.albums.migration.MigrateAlbum;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: MediaLibraryModule.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 72\u00020\u0001:\u0003678B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\b\u0010!\u001a\u00020\"H\u0016J)\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010&\u001a\u00020\u00132\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0003¢\u0006\u0002\u0010(J)\u0010)\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010*\u001a\u00020\u00132\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0003¢\u0006\u0002\u0010(J\b\u0010+\u001a\u00020\u0013H\u0002J\b\u0010,\u001a\u00020\u0013H\u0002J\u0016\u0010-\u001a\u00020 2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001e\u0010/\u001a\u00020 2\f\u00100\u001a\b\u0012\u0004\u0012\u00020%0\u00042\u0006\u00101\u001a\u00020\u000bH\u0002J!\u00102\u001a\u00020 2\b\b\u0002\u00103\u001a\u00020\u00132\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0082\bJ!\u00104\u001a\u0002052\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0004\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0082\bR!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0018\u00010\u0011R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0012\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0018\u00010\u0011R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lexpo/modules/medialibrary/MediaLibraryModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "allowedPermissionsList", "", "Lexpo/modules/medialibrary/GranularPermission;", "getAllowedPermissionsList", "()Ljava/util/List;", "allowedPermissionsList$delegate", "Lkotlin/Lazy;", "awaitingAction", "Lexpo/modules/medialibrary/MediaLibraryModule$Action;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "imagesObserver", "Lexpo/modules/medialibrary/MediaLibraryModule$MediaStoreContentObserver;", "isExpoGo", "", "()Z", "isExpoGo$delegate", "isMissingPermissions", "isMissingWritePermission", "moduleCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "videosObserver", "actionIfUserGrantedPermission", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "block", "Lkotlin/Function0;", "", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "getGranularPermissions", "", "", "shouldIncludeGranular", "granularPermissions", "(ZLjava/util/List;)[Ljava/lang/String;", "getManifestPermissions", "writeOnly", "hasReadPermissions", "hasWritePermissions", "maybeThrowIfExpoGo", "permissions", "runActionWithPermissions", "assetsId", "action", "throwUnlessPermissionsGranted", "isWrite", "withModuleScope", "Lkotlinx/coroutines/Job;", "Action", "Companion", "MediaStoreContentObserver", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MediaLibraryModule extends Module {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "MediaLibraryModule";
    private static final int WRITE_REQUEST_CODE = 7463;
    private Action awaitingAction;
    private MediaStoreContentObserver imagesObserver;
    private MediaStoreContentObserver videosObserver;
    private final CoroutineScope moduleCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());

    /* renamed from: isExpoGo$delegate, reason: from kotlin metadata */
    private final Lazy isExpoGo = LazyKt.lazy(new Function0<Boolean>() { // from class: expo.modules.medialibrary.MediaLibraryModule.isExpoGo.2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(Boolean.parseBoolean(MediaLibraryModule.this.getContext().getResources().getString(R.string.is_expo_go)));
        }
    });

    /* renamed from: allowedPermissionsList$delegate, reason: from kotlin metadata */
    private final Lazy allowedPermissionsList = LazyKt.lazy(new Function0<List<? extends GranularPermission>>() { // from class: expo.modules.medialibrary.MediaLibraryModule$allowedPermissionsList$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends GranularPermission> invoke() {
            return this.this$0.isExpoGo() ? CollectionsKt.listOf(GranularPermission.AUDIO) : CollectionsKt.listOf((Object[]) new GranularPermission[]{GranularPermission.AUDIO, GranularPermission.PHOTO, GranularPermission.VIDEO});
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaLibraryModule.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bâ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lexpo/modules/medialibrary/MediaLibraryModule$Action;", "", "runWithPermissions", "", "permissionsWereGranted", "", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    interface Action {
        void runWithPermissions(boolean permissionsWereGranted);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() throws Exceptions.ReactContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isExpoGo() {
        return ((Boolean) this.isExpoGo.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<GranularPermission> getAllowedPermissionsList() {
        return (List) this.allowedPermissionsList.getValue();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        MediaLibraryModule mediaLibraryModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (mediaLibraryModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(mediaLibraryModule);
            moduleDefinitionBuilder.Name("ExpoMediaLibrary");
            moduleDefinitionBuilder.Constants(new Function0<Map<String, ? extends Object>>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$1$1
                @Override // kotlin.jvm.functions.Function0
                public final Map<String, ? extends Object> invoke() {
                    return MapsKt.mapOf(TuplesKt.to("MediaType", MediaType.INSTANCE.getConstants()), TuplesKt.to("SortBy", SortBy.INSTANCE.getConstants()), TuplesKt.to("CHANGE_LISTENER_NAME", MediaLibraryConstantsKt.LIBRARY_DID_CHANGE_EVENT));
                }
            });
            moduleDefinitionBuilder.Events(MediaLibraryConstantsKt.LIBRARY_DID_CHANGE_EVENT);
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[2];
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Boolean.TYPE);
                    }
                }));
            }
            anyTypeArr[0] = anyType;
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), true));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), true, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(GranularPermission.class)));
                    }
                }));
            }
            anyTypeArr[1] = anyType2;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("requestPermissionsAsync", anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$3
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws PermissionsException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    List allowedPermissionsList = (List) objArr[1];
                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                    if (allowedPermissionsList == null) {
                        allowedPermissionsList = this.this$0.getAllowedPermissionsList();
                    }
                    this.this$0.maybeThrowIfExpoGo(allowedPermissionsList);
                    Permissions permissions = this.this$0.getAppContext().getPermissions();
                    MediaLibraryPermissionPromiseWrapper mediaLibraryPermissionPromiseWrapper = new MediaLibraryPermissionPromiseWrapper(allowedPermissionsList, promise, new WeakReference(this.this$0.getContext()));
                    String[] manifestPermissions = this.this$0.getManifestPermissions(zBooleanValue, allowedPermissionsList);
                    Permissions.askForPermissionsWithPermissionsManager(permissions, mediaLibraryPermissionPromiseWrapper, (String[]) Arrays.copyOf(manifestPermissions, manifestPermissions.length));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws PermissionsException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder2.getAsyncFunctions().put("requestPermissionsAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr2 = new AnyType[2];
            AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType3 == null) {
                anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Boolean.TYPE);
                    }
                }));
            }
            anyTypeArr2[0] = anyType3;
            AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), true));
            if (anyType4 == null) {
                anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), true, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(GranularPermission.class)));
                    }
                }));
            }
            anyTypeArr2[1] = anyType4;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("getPermissionsAsync", anyTypeArr2, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$6
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws PermissionsException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    List allowedPermissionsList = (List) objArr[1];
                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                    if (allowedPermissionsList == null) {
                        allowedPermissionsList = this.this$0.getAllowedPermissionsList();
                    }
                    this.this$0.maybeThrowIfExpoGo(allowedPermissionsList);
                    Permissions permissions = this.this$0.getAppContext().getPermissions();
                    MediaLibraryPermissionPromiseWrapper mediaLibraryPermissionPromiseWrapper = new MediaLibraryPermissionPromiseWrapper(allowedPermissionsList, promise, new WeakReference(this.this$0.getContext()));
                    String[] manifestPermissions = this.this$0.getManifestPermissions(zBooleanValue, allowedPermissionsList);
                    Permissions.getPermissionsWithPermissionsManager(permissions, mediaLibraryPermissionPromiseWrapper, (String[]) Arrays.copyOf(manifestPermissions, manifestPermissions.length));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws PermissionsException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder3.getAsyncFunctions().put("getPermissionsAsync", asyncFunctionWithPromiseComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[1];
            AnyType anyType5 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType5 == null) {
                anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$7
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr3[0] = anyType5;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("saveToLibraryAsync", anyTypeArr3, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$8
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws PermissionsException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) objArr[0];
                    if (!this.this$0.isMissingWritePermission()) {
                        BuildersKt__Builders_commonKt.launch$default(this.this$0.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$lambda$40$lambda$4$lambda$3$$inlined$withModuleScope$1(promise, null, this.this$0, str, promise), 3, null);
                        return;
                    }
                    throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws PermissionsException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder4.getAsyncFunctions().put("saveToLibraryAsync", asyncFunctionWithPromiseComponent3);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr4 = new AnyType[1];
            AnyType anyType6 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType6 == null) {
                anyType6 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$9
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr4[0] = anyType6;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent4 = new AsyncFunctionWithPromiseComponent("createAssetAsync", anyTypeArr4, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$10
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws PermissionsException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) objArr[0];
                    if (!this.this$0.isMissingWritePermission()) {
                        BuildersKt__Builders_commonKt.launch$default(this.this$0.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$lambda$40$lambda$7$lambda$6$$inlined$withModuleScope$1(promise, null, this.this$0, str, promise), 3, null);
                        return;
                    }
                    throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws PermissionsException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder5.getAsyncFunctions().put("createAssetAsync", asyncFunctionWithPromiseComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr5 = new AnyType[3];
            AnyType anyType7 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), false));
            if (anyType7 == null) {
                anyType7 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$11
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                    }
                }));
            }
            anyTypeArr5[0] = anyType7;
            AnyType anyType8 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType8 == null) {
                anyType8 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$12
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr5[1] = anyType8;
            AnyType anyType9 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType9 == null) {
                anyType9 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$13
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Boolean.TYPE);
                    }
                }));
            }
            anyTypeArr5[2] = anyType9;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent5 = new AsyncFunctionWithPromiseComponent("addAssetsToAlbumAsync", anyTypeArr5, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$14
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) throws IntentSender.SendIntentException, PermissionsException, Exceptions.ReactContextLost {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    final boolean zBooleanValue = ((Boolean) objArr[2]).booleanValue();
                    final String str = (String) obj2;
                    final List listEmptyList = (List) obj;
                    if (this.this$0.isMissingWritePermission()) {
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                    }
                    MediaLibraryModule mediaLibraryModule2 = this.this$0;
                    final MediaLibraryModule mediaLibraryModule3 = this.this$0;
                    MediaLibraryModule.Action actionActionIfUserGrantedPermission = mediaLibraryModule2.actionIfUserGrantedPermission(promise, new Function0<Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$1$6$1$action$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            MediaLibraryModule mediaLibraryModule4 = mediaLibraryModule3;
                            Promise promise2 = promise;
                            BuildersKt__Builders_commonKt.launch$default(mediaLibraryModule4.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$1$6$1$action$1$invoke$$inlined$withModuleScope$1(promise2, null, mediaLibraryModule4, listEmptyList, str, zBooleanValue, promise2), 3, null);
                        }
                    });
                    MediaLibraryModule mediaLibraryModule4 = this.this$0;
                    if (zBooleanValue) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    mediaLibraryModule4.runActionWithPermissions(listEmptyList, actionActionIfUserGrantedPermission);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws IntentSender.SendIntentException, PermissionsException, Exceptions.ReactContextLost {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder6.getAsyncFunctions().put("addAssetsToAlbumAsync", asyncFunctionWithPromiseComponent5);
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr6 = new AnyType[2];
            AnyType anyType10 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), false));
            if (anyType10 == null) {
                anyType10 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$15
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                    }
                }));
            }
            anyTypeArr6[0] = anyType10;
            AnyType anyType11 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType11 == null) {
                anyType11 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$16
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr6[1] = anyType11;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent6 = new AsyncFunctionWithPromiseComponent("removeAssetsFromAlbumAsync", anyTypeArr6, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$17
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) throws IntentSender.SendIntentException, PermissionsException, Exceptions.ReactContextLost {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    final String str = (String) objArr[1];
                    final List list = (List) obj;
                    if (this.this$0.isMissingWritePermission()) {
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                    }
                    MediaLibraryModule mediaLibraryModule2 = this.this$0;
                    final MediaLibraryModule mediaLibraryModule3 = this.this$0;
                    this.this$0.runActionWithPermissions(list, mediaLibraryModule2.actionIfUserGrantedPermission(promise, new Function0<Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$1$7$1$action$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            MediaLibraryModule mediaLibraryModule4 = mediaLibraryModule3;
                            Promise promise2 = promise;
                            BuildersKt__Builders_commonKt.launch$default(mediaLibraryModule4.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$1$7$1$action$1$invoke$$inlined$withModuleScope$1(promise2, null, mediaLibraryModule4, list, str, promise2), 3, null);
                        }
                    }));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws IntentSender.SendIntentException, PermissionsException, Exceptions.ReactContextLost {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder7.getAsyncFunctions().put("removeAssetsFromAlbumAsync", asyncFunctionWithPromiseComponent6);
            ModuleDefinitionBuilder moduleDefinitionBuilder8 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr7 = new AnyType[1];
            AnyType anyType12 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), false));
            if (anyType12 == null) {
                anyType12 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$18
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                    }
                }));
            }
            anyTypeArr7[0] = anyType12;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent7 = new AsyncFunctionWithPromiseComponent("deleteAssetsAsync", anyTypeArr7, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$19
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) throws IntentSender.SendIntentException, PermissionsException, Exceptions.ReactContextLost {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    final List list = (List) objArr[0];
                    if (this.this$0.isMissingWritePermission()) {
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                    }
                    MediaLibraryModule mediaLibraryModule2 = this.this$0;
                    final MediaLibraryModule mediaLibraryModule3 = this.this$0;
                    this.this$0.runActionWithPermissions(list, mediaLibraryModule2.actionIfUserGrantedPermission(promise, new Function0<Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$1$8$1$action$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            MediaLibraryModule mediaLibraryModule4 = mediaLibraryModule3;
                            Promise promise2 = promise;
                            BuildersKt__Builders_commonKt.launch$default(mediaLibraryModule4.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$1$8$1$action$1$invoke$$inlined$withModuleScope$1(promise2, null, mediaLibraryModule4, list, promise2), 3, null);
                        }
                    }));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws IntentSender.SendIntentException, PermissionsException, Exceptions.ReactContextLost {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder8.getAsyncFunctions().put("deleteAssetsAsync", asyncFunctionWithPromiseComponent7);
            ModuleDefinitionBuilder moduleDefinitionBuilder9 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr8 = new AnyType[2];
            AnyType anyType13 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType13 == null) {
                anyType13 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$20
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr8[0] = anyType13;
            AnyType anyType14 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Map.class), true));
            if (anyType14 == null) {
                anyType14 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Map.class), true, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$21
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class)));
                    }
                }));
            }
            anyTypeArr8[1] = anyType14;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent8 = new AsyncFunctionWithPromiseComponent("getAssetInfoAsync", anyTypeArr8, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$22
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws PermissionsException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    String str = (String) obj;
                    if (!this.this$0.isMissingPermissions()) {
                        BuildersKt__Builders_commonKt.launch$default(this.this$0.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$lambda$40$lambda$16$lambda$15$$inlined$withModuleScope$1(promise, null, this.this$0, str, promise), 3, null);
                        return;
                    }
                    throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS_MESSAGE);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws PermissionsException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder9.getAsyncFunctions().put("getAssetInfoAsync", asyncFunctionWithPromiseComponent8);
            ModuleDefinitionBuilder moduleDefinitionBuilder10 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr9 = new AnyType[1];
            AnyType anyType15 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Map.class), true));
            if (anyType15 == null) {
                anyType15 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Map.class), true, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$23
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class)));
                    }
                }));
            }
            anyTypeArr9[0] = anyType15;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent9 = new AsyncFunctionWithPromiseComponent("getAlbumsAsync", anyTypeArr9, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$24
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws PermissionsException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    if (!this.this$0.isMissingPermissions()) {
                        BuildersKt__Builders_commonKt.launch$default(this.this$0.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$lambda$40$lambda$19$lambda$18$$inlined$withModuleScope$1(promise, null, this.this$0, promise), 3, null);
                        return;
                    }
                    throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS_MESSAGE);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws PermissionsException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder10.getAsyncFunctions().put("getAlbumsAsync", asyncFunctionWithPromiseComponent9);
            ModuleDefinitionBuilder moduleDefinitionBuilder11 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr10 = new AnyType[1];
            AnyType anyType16 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType16 == null) {
                anyType16 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$25
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr10[0] = anyType16;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent10 = new AsyncFunctionWithPromiseComponent("getAlbumAsync", anyTypeArr10, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$26
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws PermissionsException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) objArr[0];
                    if (!this.this$0.isMissingPermissions()) {
                        BuildersKt__Builders_commonKt.launch$default(this.this$0.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$lambda$40$lambda$22$lambda$21$$inlined$withModuleScope$1(promise, null, this.this$0, str, promise), 3, null);
                        return;
                    }
                    throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS_MESSAGE);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws PermissionsException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder11.getAsyncFunctions().put("getAlbumAsync", asyncFunctionWithPromiseComponent10);
            ModuleDefinitionBuilder moduleDefinitionBuilder12 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr11 = new AnyType[3];
            AnyType anyType17 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType17 == null) {
                anyType17 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$27
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr11[0] = anyType17;
            AnyType anyType18 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType18 == null) {
                anyType18 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$28
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr11[1] = anyType18;
            AnyType anyType19 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType19 == null) {
                anyType19 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$29
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Boolean.TYPE);
                    }
                }));
            }
            anyTypeArr11[2] = anyType19;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent11 = new AsyncFunctionWithPromiseComponent("createAlbumAsync", anyTypeArr11, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$30
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) throws IntentSender.SendIntentException, PermissionsException, Exceptions.ReactContextLost {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    final boolean zBooleanValue = ((Boolean) objArr[2]).booleanValue();
                    final String str = (String) obj2;
                    final String str2 = (String) obj;
                    if (this.this$0.isMissingWritePermission()) {
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                    }
                    MediaLibraryModule mediaLibraryModule2 = this.this$0;
                    final MediaLibraryModule mediaLibraryModule3 = this.this$0;
                    this.this$0.runActionWithPermissions(zBooleanValue ? CollectionsKt.emptyList() : CollectionsKt.listOf(str), mediaLibraryModule2.actionIfUserGrantedPermission(promise, new Function0<Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$1$12$1$action$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            MediaLibraryModule mediaLibraryModule4 = mediaLibraryModule3;
                            Promise promise2 = promise;
                            BuildersKt__Builders_commonKt.launch$default(mediaLibraryModule4.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$1$12$1$action$1$invoke$$inlined$withModuleScope$1(promise2, null, mediaLibraryModule4, str2, str, zBooleanValue, promise2), 3, null);
                        }
                    }));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws IntentSender.SendIntentException, PermissionsException, Exceptions.ReactContextLost {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder12.getAsyncFunctions().put("createAlbumAsync", asyncFunctionWithPromiseComponent11);
            ModuleDefinitionBuilder moduleDefinitionBuilder13 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr12 = new AnyType[1];
            AnyType anyType20 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), false));
            if (anyType20 == null) {
                anyType20 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$31
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                    }
                }));
            }
            anyTypeArr12[0] = anyType20;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent12 = new AsyncFunctionWithPromiseComponent("deleteAlbumsAsync", anyTypeArr12, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$32
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) throws IntentSender.SendIntentException, PermissionsException, Exceptions.ReactContextLost {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    final List list = (List) objArr[0];
                    if (this.this$0.isMissingWritePermission()) {
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                    }
                    MediaLibraryModule mediaLibraryModule2 = this.this$0;
                    final MediaLibraryModule mediaLibraryModule3 = this.this$0;
                    MediaLibraryModule.Action actionActionIfUserGrantedPermission = mediaLibraryModule2.actionIfUserGrantedPermission(promise, new Function0<Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$1$13$1$action$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            MediaLibraryModule mediaLibraryModule4 = mediaLibraryModule3;
                            Promise promise2 = promise;
                            BuildersKt__Builders_commonKt.launch$default(mediaLibraryModule4.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$1$13$1$action$1$invoke$$inlined$withModuleScope$1(promise2, null, mediaLibraryModule4, list, promise2), 3, null);
                        }
                    });
                    Context context = this.this$0.getContext();
                    String[] strArr = (String[]) list.toArray(new String[0]);
                    this.this$0.runActionWithPermissions(AlbumUtilsKt.getAssetsInAlbums(context, (String[]) Arrays.copyOf(strArr, strArr.length)), actionActionIfUserGrantedPermission);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws IntentSender.SendIntentException, PermissionsException, Exceptions.ReactContextLost {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder13.getAsyncFunctions().put("deleteAlbumsAsync", asyncFunctionWithPromiseComponent12);
            ModuleDefinitionBuilder moduleDefinitionBuilder14 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr13 = new AnyType[1];
            AnyType anyType21 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(AssetsOptions.class), false));
            if (anyType21 == null) {
                anyType21 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(AssetsOptions.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$33
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(AssetsOptions.class);
                    }
                }));
            }
            anyTypeArr13[0] = anyType21;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent13 = new AsyncFunctionWithPromiseComponent("getAssetsAsync", anyTypeArr13, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$34
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws PermissionsException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    AssetsOptions assetsOptions = (AssetsOptions) objArr[0];
                    if (!this.this$0.isMissingPermissions()) {
                        BuildersKt__Builders_commonKt.launch$default(this.this$0.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$lambda$40$lambda$29$lambda$28$$inlined$withModuleScope$1(promise, null, this.this$0, assetsOptions, promise), 3, null);
                        return;
                    }
                    throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS_MESSAGE);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws PermissionsException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder14.getAsyncFunctions().put("getAssetsAsync", asyncFunctionWithPromiseComponent13);
            ModuleDefinitionBuilder moduleDefinitionBuilder15 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr14 = new AnyType[1];
            AnyType anyType22 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType22 == null) {
                anyType22 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$35
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr14[0] = anyType22;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent14 = new AsyncFunctionWithPromiseComponent("migrateAlbumIfNeededAsync", anyTypeArr14, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$36
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) throws AlbumPathException, EmptyAlbumException, IntentSender.SendIntentException, Exceptions.ReactContextLost {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) objArr[0];
                    if (Build.VERSION.SDK_INT < 30) {
                        return;
                    }
                    List<String> assetsInAlbums = AlbumUtilsKt.getAssetsInAlbums(this.this$0.getContext(), str);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : assetsInAlbums) {
                        if (((String) obj).length() > 0) {
                            arrayList.add(obj);
                        }
                    }
                    String[] strArr = (String[]) arrayList.toArray(new String[0]);
                    if (strArr.length == 0) {
                        return;
                    }
                    MediaLibraryUtils mediaLibraryUtils = MediaLibraryUtils.INSTANCE;
                    Context context = this.this$0.getContext();
                    SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                    spreadBuilder.add(null);
                    spreadBuilder.addSpread(strArr);
                    final List<MediaLibraryUtils.AssetFile> assetsById = mediaLibraryUtils.getAssetsById(context, (String[]) spreadBuilder.toArray(new String[spreadBuilder.size()]));
                    List<MediaLibraryUtils.AssetFile> list = assetsById;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Object obj2 : list) {
                        File parentFile = ((MediaLibraryUtils.AssetFile) obj2).getParentFile();
                        Object obj3 = linkedHashMap.get(parentFile);
                        if (obj3 == null) {
                            obj3 = (List) new ArrayList();
                            linkedHashMap.put(parentFile, obj3);
                        }
                        ((List) obj3).add(obj2);
                    }
                    if (linkedHashMap.size() != 1) {
                        throw new EmptyAlbumException();
                    }
                    final File parentFile2 = assetsById.get(0).getParentFile();
                    if (parentFile2 == null) {
                        throw new AlbumPathException();
                    }
                    Intrinsics.checkNotNull(parentFile2);
                    if (parentFile2.canWrite()) {
                        return;
                    }
                    MediaLibraryModule mediaLibraryModule2 = this.this$0;
                    final MediaLibraryModule mediaLibraryModule3 = this.this$0;
                    MediaLibraryModule.Action actionActionIfUserGrantedPermission = mediaLibraryModule2.actionIfUserGrantedPermission(promise, new Function0<Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$1$15$action$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* compiled from: MediaLibraryModule.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "expo.modules.medialibrary.MediaLibraryModule$definition$1$15$action$1$1", f = "MediaLibraryModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: expo.modules.medialibrary.MediaLibraryModule$definition$1$15$action$1$1, reason: invalid class name */
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ File $albumDir;
                            final /* synthetic */ List<MediaLibraryUtils.AssetFile> $assets;
                            final /* synthetic */ Promise $promise;
                            int label;
                            final /* synthetic */ MediaLibraryModule this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(MediaLibraryModule mediaLibraryModule, List<MediaLibraryUtils.AssetFile> list, File file, Promise promise, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.this$0 = mediaLibraryModule;
                                this.$assets = list;
                                this.$albumDir = file;
                                this.$promise = promise;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.this$0, this.$assets, this.$albumDir, this.$promise, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) throws AlbumException, Exceptions.ReactContextLost {
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                if (this.label == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    Context context = this.this$0.getContext();
                                    List<MediaLibraryUtils.AssetFile> list = this.$assets;
                                    String name = this.$albumDir.getName();
                                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                                    new MigrateAlbum(context, list, name, this.$promise).execute();
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            BuildersKt__Builders_commonKt.launch$default(mediaLibraryModule3.moduleCoroutineScope, null, null, new AnonymousClass1(mediaLibraryModule3, assetsById, parentFile2, promise, null), 3, null);
                        }
                    });
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(((MediaLibraryUtils.AssetFile) it.next()).getAssetId());
                    }
                    this.this$0.runActionWithPermissions(arrayList2, actionActionIfUserGrantedPermission);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws AlbumPathException, EmptyAlbumException, IntentSender.SendIntentException, Exceptions.ReactContextLost {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder15.getAsyncFunctions().put("migrateAlbumIfNeededAsync", asyncFunctionWithPromiseComponent14);
            ModuleDefinitionBuilder moduleDefinitionBuilder16 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr15 = new AnyType[1];
            AnyType anyType23 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType23 == null) {
                anyType23 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$37
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr15[0] = anyType23;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent15 = new AsyncFunctionWithPromiseComponent("albumNeedsMigrationAsync", anyTypeArr15, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$AsyncFunctionWithPromise$38
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws PermissionsException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) objArr[0];
                    if (this.this$0.isMissingPermissions()) {
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS_MESSAGE);
                    }
                    if (Build.VERSION.SDK_INT >= 30) {
                        BuildersKt__Builders_commonKt.launch$default(this.this$0.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$1$16$1$1(this.this$0, str, promise, null), 3, null);
                    }
                    promise.resolve(false);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws PermissionsException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder16.getAsyncFunctions().put("albumNeedsMigrationAsync", asyncFunctionWithPromiseComponent15);
            moduleDefinitionBuilder.OnStartObserving(new Function0<Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$1$17
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (this.this$0.imagesObserver != null) {
                        return;
                    }
                    Handler handler = new Handler(Looper.getMainLooper());
                    ContentResolver contentResolver = this.this$0.getContext().getContentResolver();
                    MediaLibraryModule mediaLibraryModule2 = this.this$0;
                    MediaLibraryModule.MediaStoreContentObserver mediaStoreContentObserver = new MediaLibraryModule.MediaStoreContentObserver(this.this$0, handler, 1);
                    contentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, mediaStoreContentObserver);
                    mediaLibraryModule2.imagesObserver = mediaStoreContentObserver;
                    MediaLibraryModule mediaLibraryModule3 = this.this$0;
                    MediaLibraryModule.MediaStoreContentObserver mediaStoreContentObserver2 = new MediaLibraryModule.MediaStoreContentObserver(this.this$0, handler, 3);
                    contentResolver.registerContentObserver(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, true, mediaStoreContentObserver2);
                    mediaLibraryModule3.videosObserver = mediaStoreContentObserver2;
                }
            });
            moduleDefinitionBuilder.OnStopObserving(new Function0<Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$1$18
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ContentResolver contentResolver = this.this$0.getContext().getContentResolver();
                    MediaLibraryModule.MediaStoreContentObserver mediaStoreContentObserver = this.this$0.imagesObserver;
                    if (mediaStoreContentObserver != null) {
                        MediaLibraryModule mediaLibraryModule2 = this.this$0;
                        contentResolver.unregisterContentObserver(mediaStoreContentObserver);
                        mediaLibraryModule2.imagesObserver = null;
                    }
                    MediaLibraryModule.MediaStoreContentObserver mediaStoreContentObserver2 = this.this$0.videosObserver;
                    if (mediaStoreContentObserver2 != null) {
                        MediaLibraryModule mediaLibraryModule3 = this.this$0;
                        contentResolver.unregisterContentObserver(mediaStoreContentObserver2);
                        mediaLibraryModule3.videosObserver = null;
                    }
                }
            });
            moduleDefinitionBuilder.getEventListeners().put(EventName.ON_ACTIVITY_RESULT, new EventListenerWithSenderAndPayload(EventName.ON_ACTIVITY_RESULT, new Function2<Activity, OnActivityResultPayload, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$OnActivityResult$1
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
                    MediaLibraryModule.Action action = this.this$0.awaitingAction;
                    if (action != null) {
                        if (payload.getRequestCode() != 7463) {
                            action = null;
                        }
                        if (action != null) {
                            action.runWithPermissions(payload.getResultCode() == -1);
                            this.this$0.awaitingAction = null;
                        }
                    }
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$40$$inlined$OnDestroy$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    try {
                        CoroutineScopeKt.cancel(this.this$0.moduleCoroutineScope, new ModuleDestroyedException(null, 1, null));
                    } catch (IllegalStateException unused) {
                        Log.e(MediaLibraryModule.TAG, "The scope does not have a job in it");
                    }
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* compiled from: MediaLibraryModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.MediaLibraryModule$withModuleScope$1", f = "MediaLibraryModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: expo.modules.medialibrary.MediaLibraryModule$withModuleScope$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $block;
        final /* synthetic */ Promise $promise;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0<Unit> function0, Promise promise, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$block = function0;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$block, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                this.$block.invoke();
            } catch (ModuleDestroyedException e) {
                Promise promise = this.$promise;
                String tAG$expo_media_library_release = MediaLibraryModule.INSTANCE.getTAG$expo_media_library_release();
                Intrinsics.checkNotNullExpressionValue(tAG$expo_media_library_release, "<get-TAG>(...)");
                promise.reject(tAG$expo_media_library_release, "MediaLibrary module destroyed", e);
            } catch (CodedException e2) {
                this.$promise.reject(e2);
            }
            return Unit.INSTANCE;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            try {
                this.$block.invoke();
            } catch (ModuleDestroyedException e) {
                Promise promise = this.$promise;
                String tAG$expo_media_library_release = MediaLibraryModule.INSTANCE.getTAG$expo_media_library_release();
                Intrinsics.checkNotNullExpressionValue(tAG$expo_media_library_release, "<get-TAG>(...)");
                promise.reject(tAG$expo_media_library_release, "MediaLibrary module destroyed", e);
            } catch (CodedException e2) {
                this.$promise.reject(e2);
            }
            return Unit.INSTANCE;
        }
    }

    private final Job withModuleScope(Promise promise, Function0<Unit> block) {
        return BuildersKt__Builders_commonKt.launch$default(this.moduleCoroutineScope, null, null, new AnonymousClass1(block, promise, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMissingPermissions() {
        return hasReadPermissions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMissingWritePermission() {
        return hasWritePermissions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String[] getManifestPermissions(boolean writeOnly, List<? extends GranularPermission> granularPermissions) {
        boolean z;
        boolean z2 = Build.VERSION.SDK_INT >= 29 && MediaLibraryUtils.INSTANCE.hasManifestPermission(getContext(), "android.permission.ACCESS_MEDIA_LOCATION") && !(Build.VERSION.SDK_INT >= 33 && granularPermissions.size() == 1 && granularPermissions.contains(GranularPermission.AUDIO));
        boolean z3 = Build.VERSION.SDK_INT < 33 && MediaLibraryUtils.INSTANCE.hasManifestPermission(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
        if (Build.VERSION.SDK_INT < 33) {
            z = false;
            break;
        }
        List<? extends GranularPermission> list = granularPermissions;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!MediaLibraryUtils.INSTANCE.hasManifestPermission(getContext(), ((GranularPermission) it.next()).toManifestPermission())) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        boolean z4 = z && !writeOnly;
        SpreadBuilder spreadBuilder = new SpreadBuilder(4);
        spreadBuilder.add(z3 ? "android.permission.WRITE_EXTERNAL_STORAGE" : null);
        spreadBuilder.add((writeOnly || z) ? null : "android.permission.READ_EXTERNAL_STORAGE");
        spreadBuilder.add(z2 ? "android.permission.ACCESS_MEDIA_LOCATION" : null);
        spreadBuilder.addSpread(getGranularPermissions(z4, granularPermissions));
        return (String[]) CollectionsKt.listOfNotNull(spreadBuilder.toArray(new String[spreadBuilder.size()])).toArray(new String[0]);
    }

    private final String[] getGranularPermissions(boolean shouldIncludeGranular, List<? extends GranularPermission> granularPermissions) {
        if (!shouldIncludeGranular) {
            return new String[0];
        }
        String[] strArr = new String[3];
        strArr[0] = granularPermissions.contains(GranularPermission.PHOTO) ? "android.permission.READ_MEDIA_IMAGES" : null;
        strArr[1] = granularPermissions.contains(GranularPermission.VIDEO) ? "android.permission.READ_MEDIA_VIDEO" : null;
        strArr[2] = granularPermissions.contains(GranularPermission.AUDIO) ? "android.permission.READ_MEDIA_AUDIO" : null;
        return (String[]) CollectionsKt.listOfNotNull((Object[]) strArr).toArray(new String[0]);
    }

    private final void throwUnlessPermissionsGranted(boolean isWrite, Function0<Unit> block) throws PermissionsException {
        if (isWrite ? isMissingWritePermission() : isMissingPermissions()) {
            throw new PermissionsException(isWrite ? MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE : MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS_MESSAGE);
        }
        block.invoke();
    }

    static /* synthetic */ void throwUnlessPermissionsGranted$default(MediaLibraryModule mediaLibraryModule, boolean z, Function0 function0, int i, Object obj) throws PermissionsException {
        if ((i & 1) != 0) {
            z = true;
        }
        if (z ? mediaLibraryModule.isMissingWritePermission() : mediaLibraryModule.isMissingPermissions()) {
            throw new PermissionsException(z ? MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE : MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS_MESSAGE);
        }
        function0.invoke();
    }

    private final boolean hasReadPermissions() {
        if (Build.VERSION.SDK_INT >= 33) {
            List<GranularPermission> allowedPermissionsList = getAllowedPermissionsList();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(allowedPermissionsList, 10));
            Iterator<T> it = allowedPermissionsList.iterator();
            while (it.hasNext()) {
                arrayList.add(((GranularPermission) it.next()).toManifestPermission());
            }
            List mutableList = CollectionsKt.toMutableList((Collection) arrayList);
            if (Build.VERSION.SDK_INT >= 34) {
                mutableList.add("android.permission.READ_MEDIA_VISUAL_USER_SELECTED");
            }
            List<String> list = mutableList;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (String str : list) {
                Permissions permissions = getAppContext().getPermissions();
                arrayList2.add(Boolean.valueOf(permissions != null ? permissions.hasGrantedPermissions(str) : false));
            }
            ArrayList arrayList3 = arrayList2;
            if ((arrayList3 instanceof Collection) && arrayList3.isEmpty()) {
                return true;
            }
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                if (((Boolean) it2.next()).booleanValue()) {
                }
            }
            return true;
        }
        String[] strArr = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        Permissions permissions2 = getAppContext().getPermissions();
        if (permissions2 != null) {
            return true ^ permissions2.hasGrantedPermissions((String[]) Arrays.copyOf(strArr, 2));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void maybeThrowIfExpoGo(List<? extends GranularPermission> permissions) throws PermissionsException {
        if (isExpoGo()) {
            if (permissions.contains(GranularPermission.PHOTO) || permissions.contains(GranularPermission.VIDEO)) {
                throw new PermissionsException("Due to changes in Androids permission requirements, Expo Go can no longer provide full access to the media library. To test the full functionality of this module, you can create a development build");
            }
        }
    }

    private final boolean hasWritePermissions() {
        Permissions permissions;
        if (Build.VERSION.SDK_INT < 33 && (permissions = getAppContext().getPermissions()) != null) {
            return !permissions.hasGrantedPermissions("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runActionWithPermissions(List<String> assetsId, Action action) throws IntentSender.SendIntentException, Exceptions.ReactContextLost {
        if (Build.VERSION.SDK_INT >= 30) {
            List<Uri> assetsUris = MediaLibraryUtils.INSTANCE.getAssetsUris(getContext(), assetsId);
            ArrayList arrayList = new ArrayList();
            for (Object obj : assetsUris) {
                if (getContext().checkUriPermission((Uri) obj, Binder.getCallingPid(), Binder.getCallingUid(), 2) != 0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (!arrayList2.isEmpty()) {
                PendingIntent pendingIntentCreateWriteRequest = MediaStore.createWriteRequest(getContext().getContentResolver(), arrayList2);
                Intrinsics.checkNotNullExpressionValue(pendingIntentCreateWriteRequest, "createWriteRequest(...)");
                try {
                    this.awaitingAction = action;
                    getAppContext().getThrowingActivity().startIntentSenderForResult(pendingIntentCreateWriteRequest.getIntentSender(), WRITE_REQUEST_CODE, null, 0, 0, 0);
                    return;
                } catch (IntentSender.SendIntentException e) {
                    this.awaitingAction = null;
                    throw e;
                }
            }
        }
        action.runWithPermissions(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Action actionIfUserGrantedPermission(final Promise promise, final Function0<Unit> block) {
        return new Action() { // from class: expo.modules.medialibrary.MediaLibraryModule$$ExternalSyntheticLambda0
            @Override // expo.modules.medialibrary.MediaLibraryModule.Action
            public final void runWithPermissions(boolean z) {
                MediaLibraryModule.actionIfUserGrantedPermission$lambda$52(promise, block, z);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void actionIfUserGrantedPermission$lambda$52(Promise promise, Function0 block, boolean z) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(block, "$block");
        if (!z) {
            promise.reject(new PermissionsException(MediaLibraryConstantsKt.ERROR_USER_DID_NOT_GRANT_WRITE_PERMISSIONS_MESSAGE));
        } else {
            block.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaLibraryModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lexpo/modules/medialibrary/MediaLibraryModule$MediaStoreContentObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "mMediaType", "", "(Lexpo/modules/medialibrary/MediaLibraryModule;Landroid/os/Handler;I)V", "mAssetsTotalCount", "getAssetsTotalCount", "mediaType", "onChange", "", "selfChange", "", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    final class MediaStoreContentObserver extends ContentObserver {
        private int mAssetsTotalCount;
        private final int mMediaType;
        final /* synthetic */ MediaLibraryModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaStoreContentObserver(MediaLibraryModule mediaLibraryModule, Handler handler, int i) {
            super(handler);
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.this$0 = mediaLibraryModule;
            this.mMediaType = i;
            this.mAssetsTotalCount = getAssetsTotalCount(i);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            onChange(selfChange, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            int assetsTotalCount = getAssetsTotalCount(this.mMediaType);
            if (this.mAssetsTotalCount != assetsTotalCount) {
                this.mAssetsTotalCount = assetsTotalCount;
                this.this$0.sendEvent(MediaLibraryConstantsKt.LIBRARY_DID_CHANGE_EVENT, new Bundle());
            }
        }

        private final int getAssetsTotalCount(int mediaType) {
            Cursor cursorQuery = this.this$0.getContext().getContentResolver().query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), new String[0], "media_type == " + mediaType, null, null);
            try {
                Cursor cursor = cursorQuery;
                int count = cursor != null ? cursor.getCount() : 0;
                CloseableKt.closeFinally(cursorQuery, null);
                return count;
            } finally {
            }
        }
    }

    /* compiled from: MediaLibraryModule.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lexpo/modules/medialibrary/MediaLibraryModule$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG$expo_media_library_release", "()Ljava/lang/String;", "WRITE_REQUEST_CODE", "", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG$expo_media_library_release() {
            return MediaLibraryModule.TAG;
        }
    }
}

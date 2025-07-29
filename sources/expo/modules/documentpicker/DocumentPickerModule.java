package expo.modules.documentpicker;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.tracing.Trace;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import expo.modules.core.utilities.FileUtilities;
import expo.modules.kotlin.Promise;
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

/* compiled from: DocumentPickerModule.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lexpo/modules/documentpicker/DocumentPickerModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "copyToCacheDirectory", "", "pendingPromise", "Lexpo/modules/kotlin/Promise;", "copyDocumentToCacheDirectory", "", "documentUri", "Landroid/net/Uri;", "name", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "handleMultipleSelection", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "handleSingleSelection", "readDocumentDetails", "Lexpo/modules/documentpicker/DocumentInfo;", ShareConstants.MEDIA_URI, "expo-document-picker_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DocumentPickerModule extends Module {
    private boolean copyToCacheDirectory = true;
    private Promise pendingPromise;

    private final Context getContext() throws Exceptions.ReactContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        DocumentPickerModule documentPickerModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (documentPickerModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(documentPickerModule);
            moduleDefinitionBuilder.Name("ExpoDocumentPicker");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[1];
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DocumentPickerOptions.class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DocumentPickerOptions.class), false, new Function0<KType>() { // from class: expo.modules.documentpicker.DocumentPickerModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(DocumentPickerOptions.class);
                    }
                }));
            }
            anyTypeArr[0] = anyType;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("getDocumentAsync", anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.documentpicker.DocumentPickerModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$2
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws PickingInProgressException {
                    String str;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    DocumentPickerOptions documentPickerOptions = (DocumentPickerOptions) objArr[0];
                    if (this.this$0.pendingPromise == null) {
                        this.this$0.pendingPromise = promise;
                        this.this$0.copyToCacheDirectory = documentPickerOptions.getCopyToCacheDirectory();
                        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                        intent.addCategory("android.intent.category.OPENABLE");
                        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", documentPickerOptions.getMultiple());
                        if (documentPickerOptions.getType().size() > 1) {
                            intent.putExtra("android.intent.extra.MIME_TYPES", (String[]) documentPickerOptions.getType().toArray(new String[0]));
                            str = "*/*";
                        } else {
                            str = documentPickerOptions.getType().get(0);
                        }
                        intent.setType(str);
                        this.this$0.getAppContext().getThrowingActivity().startActivityForResult(intent, 4137);
                        return;
                    }
                    throw new PickingInProgressException();
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws PickingInProgressException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder2.getAsyncFunctions().put("getDocumentAsync", asyncFunctionWithPromiseComponent);
            moduleDefinitionBuilder.getEventListeners().put(EventName.ON_ACTIVITY_RESULT, new EventListenerWithSenderAndPayload(EventName.ON_ACTIVITY_RESULT, new Function2<Activity, OnActivityResultPayload, Unit>() { // from class: expo.modules.documentpicker.DocumentPickerModule$definition$lambda$3$$inlined$OnActivityResult$1
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
                    ClipData clipData;
                    Intrinsics.checkNotNullParameter(sender, "sender");
                    Intrinsics.checkNotNullParameter(payload, "payload");
                    int requestCode = payload.getRequestCode();
                    int resultCode = payload.getResultCode();
                    Intent data = payload.getData();
                    if (requestCode != 4137 || this.this$0.pendingPromise == null) {
                        return;
                    }
                    Promise promise = this.this$0.pendingPromise;
                    Intrinsics.checkNotNull(promise);
                    if (resultCode == -1) {
                        if (data != null) {
                            try {
                                clipData = data.getClipData();
                            } catch (CodedException e) {
                                promise.resolve(e);
                            }
                        } else {
                            clipData = null;
                        }
                        if (clipData != null) {
                            this.this$0.handleMultipleSelection(data);
                        } else {
                            this.this$0.handleSingleSelection(data);
                        }
                    } else {
                        promise.resolve(new DocumentPickerResult(true, null, 2, null));
                    }
                    this.this$0.pendingPromise = null;
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    private final String copyDocumentToCacheDirectory(Uri documentUri, String name) throws FileNotFoundException {
        File file = new File(FileUtilities.generateOutputPath(getContext().getCacheDir(), "DocumentPicker", FilenameUtils.getExtension(name)));
        try {
            FileOutputStream fileOutputStreamOpenInputStream = getContext().getContentResolver().openInputStream(documentUri);
            try {
                InputStream inputStream = fileOutputStreamOpenInputStream;
                fileOutputStreamOpenInputStream = new FileOutputStream(file);
                try {
                    IOUtils.copy(inputStream, fileOutputStreamOpenInputStream);
                    CloseableKt.closeFinally(fileOutputStreamOpenInputStream, null);
                    CloseableKt.closeFinally(fileOutputStreamOpenInputStream, null);
                    return Uri.fromFile(file).toString();
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSingleSelection(Intent intent) throws FailedToReadDocumentException {
        Uri data;
        Unit unit = null;
        if (intent != null && (data = intent.getData()) != null) {
            DocumentPickerResult documentPickerResult = new DocumentPickerResult(false, CollectionsKt.listOf(readDocumentDetails(data)), 1, null);
            Promise promise = this.pendingPromise;
            if (promise != null) {
                promise.resolve(documentPickerResult);
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            throw new FailedToReadDocumentException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleMultipleSelection(Intent intent) throws FailedToReadDocumentException {
        ClipData clipData;
        ClipData.Item itemAt;
        ClipData clipData2;
        int itemCount = (intent == null || (clipData2 = intent.getClipData()) == null) ? 0 : clipData2.getItemCount();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            Uri uri = null;
            if (i >= itemCount) {
                Promise promise = this.pendingPromise;
                if (promise != null) {
                    promise.resolve(new DocumentPickerResult(false, arrayList, 1, null));
                    return;
                }
                return;
            }
            if (intent != null && (clipData = intent.getClipData()) != null && (itemAt = clipData.getItemAt(i)) != null) {
                uri = itemAt.getUri();
            }
            if (uri == null) {
                throw new FailedToReadDocumentException();
            }
            arrayList.add(readDocumentDetails(uri));
            i++;
        }
    }

    private final DocumentInfo readDocumentDetails(Uri uri) throws FailedToCopyToCacheException, FailedToReadDocumentException {
        String strCopyDocumentToCacheDirectory;
        DocumentDetails documentDetailsCopy$default = new DocumentDetailsReader(getContext()).read(uri);
        if (this.copyToCacheDirectory && documentDetailsCopy$default != null && ((strCopyDocumentToCacheDirectory = copyDocumentToCacheDirectory(uri, documentDetailsCopy$default.getName())) == null || (documentDetailsCopy$default = DocumentDetails.copy$default(documentDetailsCopy$default, null, strCopyDocumentToCacheDirectory, null, null, 13, null)) == null)) {
            throw new FailedToCopyToCacheException();
        }
        if (documentDetailsCopy$default != null) {
            return new DocumentInfo(documentDetailsCopy$default.getUri(), documentDetailsCopy$default.getName(), documentDetailsCopy$default.getMimeType(), documentDetailsCopy$default.getSize());
        }
        throw new FailedToReadDocumentException();
    }
}

package com.canhub.cropper;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.canhub.cropper.CropImage;
import com.canhub.cropper.CropImageIntentChooser;
import com.canhub.cropper.CropImageView;
import com.canhub.cropper.databinding.CropImageActivityBinding;
import com.canhub.cropper.utils.GetUriForFileKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CropImageActivity.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 C2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002CDB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0016J*\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0018\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\u0012\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020,H\u0016J\u0012\u0010-\u001a\u00020\u00142\b\u0010.\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020!H\u0014J(\u00101\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\n2\u000e\u0010\u0018\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001aH\u0016J\b\u00102\u001a\u00020\u0014H\u0016J\b\u00103\u001a\u00020\u0014H\u0016J\b\u00104\u001a\u00020\u0014H\u0002J\u0010\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u001cH\u0016J\u0010\u0010:\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0016J*\u0010;\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0018\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010<\u001a\u00020\u0014H\u0016J\u001c\u0010=\u001a\u00020\u00142\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u00140>H\u0016J\b\u0010?\u001a\u00020\u0014H\u0002J \u0010@\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%2\u0006\u0010A\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020\u001cH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\n0\n0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/canhub/cropper/CropImageActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/canhub/cropper/CropImageView$OnSetImageUriCompleteListener;", "Lcom/canhub/cropper/CropImageView$OnCropImageCompleteListener;", "()V", "binding", "Lcom/canhub/cropper/databinding/CropImageActivityBinding;", "cropImageOptions", "Lcom/canhub/cropper/CropImageOptions;", "cropImageUri", "Landroid/net/Uri;", "cropImageView", "Lcom/canhub/cropper/CropImageView;", "latestTmpUri", "pickImageGallery", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "takePicture", "cropImage", "", "getResultIntent", "Landroid/content/Intent;", ShareConstants.MEDIA_URI, "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "sampleSize", "", "getTmpFileUri", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onCropImageComplete", ViewHierarchyConstants.VIEW_KEY, "result", "Lcom/canhub/cropper/CropImageView$CropResult;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPickImageResult", "resultUri", "onSaveInstanceState", "outState", "onSetImageUriComplete", "onStart", "onStop", "openCamera", "openSource", "source", "Lcom/canhub/cropper/CropImageActivity$Source;", "rotateImage", "degrees", "setCropImageView", "setResult", "setResultCancel", "showImageSourceDialog", "Lkotlin/Function1;", "showIntentChooser", "updateMenuItemIconColor", "itemId", ViewProps.COLOR, "Companion", "Source", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public class CropImageActivity extends AppCompatActivity implements CropImageView.OnSetImageUriCompleteListener, CropImageView.OnCropImageCompleteListener {

    @Deprecated
    public static final String BUNDLE_KEY_TMP_URI = "bundle_key_tmp_uri";
    private static final Companion Companion = new Companion(null);
    private CropImageActivityBinding binding;
    private CropImageOptions cropImageOptions;
    private Uri cropImageUri;
    private CropImageView cropImageView;
    private Uri latestTmpUri;
    private final ActivityResultLauncher<String> pickImageGallery;
    private final ActivityResultLauncher<Uri> takePicture;

    /* compiled from: CropImageActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/canhub/cropper/CropImageActivity$Source;", "", "(Ljava/lang/String;I)V", "CAMERA", "GALLERY", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum Source {
        CAMERA,
        GALLERY
    }

    /* compiled from: CropImageActivity.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Source.values().length];
            iArr[Source.CAMERA.ordinal()] = 1;
            iArr[Source.GALLERY.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CropImageActivity() {
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: com.canhub.cropper.CropImageActivity$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                CropImageActivity.m5061pickImageGallery$lambda0(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…mageResult(uri)\n        }");
        this.pickImageGallery = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Uri> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.TakePicture(), new ActivityResultCallback() { // from class: com.canhub.cropper.CropImageActivity$$ExternalSyntheticLambda1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                CropImageActivity.m5063takePicture$lambda1(this.f$0, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResul…ckImageResult(null)\n    }");
        this.takePicture = activityResultLauncherRegisterForActivityResult2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: pickImageGallery$lambda-0, reason: not valid java name */
    public static final void m5061pickImageGallery$lambda0(CropImageActivity this$0, Uri uri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onPickImageResult(uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: takePicture$lambda-1, reason: not valid java name */
    public static final void m5063takePicture$lambda1(CropImageActivity this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.onPickImageResult(it.booleanValue() ? this$0.latestTmpUri : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00b3  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r4) throws android.content.res.Resources.NotFoundException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.canhub.cropper.CropImageActivity.onCreate(android.os.Bundle):void");
    }

    /* compiled from: CropImageActivity.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.canhub.cropper.CropImageActivity$onCreate$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Source, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, CropImageActivity.class, "openSource", "openSource(Lcom/canhub/cropper/CropImageActivity$Source;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Source source) throws IOException {
            invoke2(source);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Source p0) throws IOException {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((CropImageActivity) this.receiver).openSource(p0);
        }
    }

    private final void showIntentChooser() {
        CropImageIntentChooser cropImageIntentChooser = new CropImageIntentChooser(this, new CropImageIntentChooser.ResultCallback() { // from class: com.canhub.cropper.CropImageActivity$showIntentChooser$ciIntentChooser$1
            @Override // com.canhub.cropper.CropImageIntentChooser.ResultCallback
            public void onSuccess(Uri uri) {
                this.this$0.onPickImageResult(uri);
            }

            @Override // com.canhub.cropper.CropImageIntentChooser.ResultCallback
            public void onCancelled() {
                this.this$0.setResultCancel();
            }
        });
        CropImageOptions cropImageOptions = this.cropImageOptions;
        if (cropImageOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions = null;
        }
        String str = cropImageOptions.intentChooserTitle;
        if (str != null) {
            if (StringsKt.isBlank(str)) {
                str = null;
            }
            if (str != null) {
                cropImageIntentChooser.setIntentChooserTitle(str);
            }
        }
        List<String> list = cropImageOptions.intentChooserPriorityList;
        if (list != null) {
            if (list.isEmpty()) {
                list = null;
            }
            if (list != null) {
                cropImageIntentChooser.setupPriorityAppsList(list);
            }
        }
        cropImageIntentChooser.showChooserIntent(cropImageOptions.imageSourceIncludeCamera, cropImageOptions.imageSourceIncludeGallery, cropImageOptions.imageSourceIncludeCamera ? getTmpFileUri() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openSource(Source source) throws IOException {
        int i = WhenMappings.$EnumSwitchMapping$0[source.ordinal()];
        if (i == 1) {
            openCamera();
        } else {
            if (i != 2) {
                return;
            }
            this.pickImageGallery.launch("image/*");
        }
    }

    private final void openCamera() throws IOException {
        Uri tmpFileUri = getTmpFileUri();
        this.latestTmpUri = tmpFileUri;
        this.takePicture.launch(tmpFileUri);
    }

    private final Uri getTmpFileUri() throws IOException {
        File tmpFile = File.createTempFile("tmp_image_file", ".png", getCacheDir());
        tmpFile.createNewFile();
        tmpFile.deleteOnExit();
        Intrinsics.checkNotNullExpressionValue(tmpFile, "tmpFile");
        return GetUriForFileKt.getUriForFile(this, tmpFile);
    }

    public void showImageSourceDialog(final Function1<? super Source, Unit> openSource) {
        Intrinsics.checkNotNullParameter(openSource, "openSource");
        new AlertDialog.Builder(this).setCancelable(false).setTitle(R.string.pick_image_chooser_title).setItems(new String[]{getString(R.string.pick_image_camera), getString(R.string.pick_image_gallery)}, new DialogInterface.OnClickListener() { // from class: com.canhub.cropper.CropImageActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CropImageActivity.m5062showImageSourceDialog$lambda10(openSource, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showImageSourceDialog$lambda-10, reason: not valid java name */
    public static final void m5062showImageSourceDialog$lambda10(Function1 openSource, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(openSource, "$openSource");
        openSource.invoke(i == 0 ? Source.CAMERA : Source.GALLERY);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        CropImageView cropImageView = this.cropImageView;
        if (cropImageView != null) {
            cropImageView.setOnSetImageUriCompleteListener(this);
        }
        CropImageView cropImageView2 = this.cropImageView;
        if (cropImageView2 != null) {
            cropImageView2.setOnCropImageCompleteListener(this);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        CropImageView cropImageView = this.cropImageView;
        if (cropImageView != null) {
            cropImageView.setOnSetImageUriCompleteListener(null);
        }
        CropImageView cropImageView2 = this.cropImageView;
        if (cropImageView2 != null) {
            cropImageView2.setOnCropImageCompleteListener(null);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString(BUNDLE_KEY_TMP_URI, String.valueOf(this.latestTmpUri));
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c1  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onCreateOptionsMenu(android.view.Menu r9) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.canhub.cropper.CropImageActivity.onCreateOptionsMenu(android.view.Menu):boolean");
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId == R.id.crop_image_menu_crop) {
            cropImage();
            return true;
        }
        CropImageOptions cropImageOptions = null;
        if (itemId == R.id.ic_rotate_left_24) {
            CropImageOptions cropImageOptions2 = this.cropImageOptions;
            if (cropImageOptions2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            } else {
                cropImageOptions = cropImageOptions2;
            }
            rotateImage(-cropImageOptions.rotationDegrees);
            return true;
        }
        if (itemId == R.id.ic_rotate_right_24) {
            CropImageOptions cropImageOptions3 = this.cropImageOptions;
            if (cropImageOptions3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            } else {
                cropImageOptions = cropImageOptions3;
            }
            rotateImage(cropImageOptions.rotationDegrees);
            return true;
        }
        if (itemId == R.id.ic_flip_24_horizontally) {
            CropImageView cropImageView = this.cropImageView;
            if (cropImageView == null) {
                return true;
            }
            cropImageView.flipImageHorizontally();
            return true;
        }
        if (itemId != R.id.ic_flip_24_vertically) {
            if (itemId == 16908332) {
                setResultCancel();
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
        CropImageView cropImageView2 = this.cropImageView;
        if (cropImageView2 == null) {
            return true;
        }
        cropImageView2.flipImageVertically();
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        setResultCancel();
    }

    protected void onPickImageResult(Uri resultUri) {
        if (resultUri == null) {
            setResultCancel();
            return;
        }
        this.cropImageUri = resultUri;
        CropImageView cropImageView = this.cropImageView;
        if (cropImageView != null) {
            cropImageView.setImageUriAsync(resultUri);
        }
    }

    @Override // com.canhub.cropper.CropImageView.OnSetImageUriCompleteListener
    public void onSetImageUriComplete(CropImageView view, Uri uri, Exception error) {
        CropImageView cropImageView;
        CropImageView cropImageView2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(uri, "uri");
        CropImageOptions cropImageOptions = null;
        if (error == null) {
            CropImageOptions cropImageOptions2 = this.cropImageOptions;
            if (cropImageOptions2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions2 = null;
            }
            if (cropImageOptions2.initialCropWindowRectangle != null && (cropImageView2 = this.cropImageView) != null) {
                CropImageOptions cropImageOptions3 = this.cropImageOptions;
                if (cropImageOptions3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                    cropImageOptions3 = null;
                }
                cropImageView2.setCropRect(cropImageOptions3.initialCropWindowRectangle);
            }
            CropImageOptions cropImageOptions4 = this.cropImageOptions;
            if (cropImageOptions4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions4 = null;
            }
            if (cropImageOptions4.initialRotation > 0 && (cropImageView = this.cropImageView) != null) {
                CropImageOptions cropImageOptions5 = this.cropImageOptions;
                if (cropImageOptions5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                    cropImageOptions5 = null;
                }
                cropImageView.setRotatedDegrees(cropImageOptions5.initialRotation);
            }
            CropImageOptions cropImageOptions6 = this.cropImageOptions;
            if (cropImageOptions6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            } else {
                cropImageOptions = cropImageOptions6;
            }
            if (cropImageOptions.skipEditing) {
                cropImage();
                return;
            }
            return;
        }
        setResult(null, error, 1);
    }

    @Override // com.canhub.cropper.CropImageView.OnCropImageCompleteListener
    public void onCropImageComplete(CropImageView view, CropImageView.CropResult result) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(result, "result");
        setResult(result.getUriContent(), result.getError(), result.getSampleSize());
    }

    public void cropImage() {
        CropImageOptions cropImageOptions = this.cropImageOptions;
        CropImageOptions cropImageOptions2 = null;
        if (cropImageOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions = null;
        }
        if (cropImageOptions.noOutputImage) {
            setResult(null, null, 1);
            return;
        }
        CropImageView cropImageView = this.cropImageView;
        if (cropImageView != null) {
            CropImageOptions cropImageOptions3 = this.cropImageOptions;
            if (cropImageOptions3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions3 = null;
            }
            Bitmap.CompressFormat compressFormat = cropImageOptions3.outputCompressFormat;
            CropImageOptions cropImageOptions4 = this.cropImageOptions;
            if (cropImageOptions4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions4 = null;
            }
            int i = cropImageOptions4.outputCompressQuality;
            CropImageOptions cropImageOptions5 = this.cropImageOptions;
            if (cropImageOptions5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions5 = null;
            }
            int i2 = cropImageOptions5.outputRequestWidth;
            CropImageOptions cropImageOptions6 = this.cropImageOptions;
            if (cropImageOptions6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions6 = null;
            }
            int i3 = cropImageOptions6.outputRequestHeight;
            CropImageOptions cropImageOptions7 = this.cropImageOptions;
            if (cropImageOptions7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions7 = null;
            }
            CropImageView.RequestSizeOptions requestSizeOptions = cropImageOptions7.outputRequestSizeOptions;
            CropImageOptions cropImageOptions8 = this.cropImageOptions;
            if (cropImageOptions8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            } else {
                cropImageOptions2 = cropImageOptions8;
            }
            cropImageView.croppedImageAsync(compressFormat, i, i2, i3, requestSizeOptions, cropImageOptions2.customOutputUri);
        }
    }

    public void setCropImageView(CropImageView cropImageView) {
        Intrinsics.checkNotNullParameter(cropImageView, "cropImageView");
        this.cropImageView = cropImageView;
    }

    public void rotateImage(int degrees) {
        CropImageView cropImageView = this.cropImageView;
        if (cropImageView != null) {
            cropImageView.rotateImage(degrees);
        }
    }

    public void setResult(Uri uri, Exception error, int sampleSize) {
        setResult(error != null ? 204 : -1, getResultIntent(uri, error, sampleSize));
        finish();
    }

    public void setResultCancel() {
        setResult(0);
        finish();
    }

    public Intent getResultIntent(Uri uri, Exception error, int sampleSize) {
        CropImageView cropImageView = this.cropImageView;
        Uri imageUri = cropImageView != null ? cropImageView.getImageUri() : null;
        CropImageView cropImageView2 = this.cropImageView;
        float[] cropPoints = cropImageView2 != null ? cropImageView2.getCropPoints() : null;
        CropImageView cropImageView3 = this.cropImageView;
        Rect cropRect = cropImageView3 != null ? cropImageView3.getCropRect() : null;
        CropImageView cropImageView4 = this.cropImageView;
        int mDegreesRotated = cropImageView4 != null ? cropImageView4.getMDegreesRotated() : 0;
        CropImageView cropImageView5 = this.cropImageView;
        CropImage.ActivityResult activityResult = new CropImage.ActivityResult(imageUri, uri, error, cropPoints, cropRect, mDegreesRotated, cropImageView5 != null ? cropImageView5.getWholeImageRect() : null, sampleSize);
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        intent.putExtra(CropImage.CROP_IMAGE_EXTRA_RESULT, activityResult);
        return intent;
    }

    public void updateMenuItemIconColor(Menu menu, int itemId, int color) {
        Drawable icon;
        Intrinsics.checkNotNullParameter(menu, "menu");
        MenuItem menuItemFindItem = menu.findItem(itemId);
        if (menuItemFindItem == null || (icon = menuItemFindItem.getIcon()) == null) {
            return;
        }
        try {
            icon.mutate();
            icon.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(color, BlendModeCompat.SRC_ATOP));
            menuItemFindItem.setIcon(icon);
        } catch (Exception e) {
            Log.w("AIC", "Failed to update menu item color", e);
        }
    }

    /* compiled from: CropImageActivity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/canhub/cropper/CropImageActivity$Companion;", "", "()V", "BUNDLE_KEY_TMP_URI", "", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

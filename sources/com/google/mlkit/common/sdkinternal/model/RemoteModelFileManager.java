package com.google.mlkit.common.sdkinternal.model;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzmu;
import com.google.android.gms.internal.mlkit_common.zzna;
import com.google.android.gms.internal.mlkit_common.zzsk;
import com.google.android.gms.internal.mlkit_common.zzss;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.internal.model.ModelUtils;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.google.mlkit.common.sdkinternal.model.ModelValidator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: com.google.mlkit:common@@18.11.0 */
/* loaded from: classes3.dex */
public class RemoteModelFileManager {
    private static final GmsLogger zza = new GmsLogger("RemoteModelFileManager", "");
    private final MlKitContext zzb;
    private final String zzc;
    private final ModelType zzd;
    private final ModelValidator zze;
    private final RemoteModelFileMover zzf;
    private final SharedPrefManager zzg;
    private final ModelFileHelper zzh;

    public RemoteModelFileManager(MlKitContext mlKitContext, RemoteModel remoteModel, ModelValidator modelValidator, ModelFileHelper modelFileHelper, RemoteModelFileMover remoteModelFileMover) {
        this.zzb = mlKitContext;
        ModelType modelType = remoteModel.getModelType();
        this.zzd = modelType;
        this.zzc = modelType == ModelType.TRANSLATE ? remoteModel.getModelNameForBackend() : remoteModel.getUniqueModelNameForPersist();
        this.zze = modelValidator;
        this.zzg = SharedPrefManager.getInstance(mlKitContext);
        this.zzh = modelFileHelper;
        this.zzf = remoteModelFileMover;
    }

    public File getModelDirUnsafe(boolean z) {
        return this.zzh.getModelDirUnsafe(this.zzc, this.zzd, z);
    }

    public synchronized File moveModelToPrivateFolder(ParcelFileDescriptor parcelFileDescriptor, String str, RemoteModel remoteModel) throws MlKitException {
        File file;
        MlKitException mlKitException;
        ModelValidator modelValidator;
        file = new File(this.zzh.zza(this.zzc, this.zzd), "to_be_validated_model.tmp");
        ModelValidator.ValidationResult validationResultValidateModel = null;
        try {
            ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i = autoCloseInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                    fileOutputStream.getFD().sync();
                    fileOutputStream.close();
                    autoCloseInputStream.close();
                    boolean zZza = ModelUtils.zza(file, str);
                    if (zZza && (modelValidator = this.zze) != null) {
                        validationResultValidateModel = modelValidator.validateModel(file, remoteModel);
                        if (validationResultValidateModel.getErrorCode().equals(ModelValidator.ValidationResult.ErrorCode.TFLITE_VERSION_INCOMPATIBLE)) {
                            String appVersion = CommonUtils.getAppVersion(this.zzb.getApplicationContext());
                            this.zzg.setIncompatibleModelInfo(remoteModel, str, appVersion);
                            String strValueOf = String.valueOf(str);
                            GmsLogger gmsLogger = zza;
                            gmsLogger.d("RemoteModelFileManager", "Model is not compatible. Model hash: ".concat(strValueOf));
                            gmsLogger.d("RemoteModelFileManager", "The current app version is: ".concat(String.valueOf(appVersion)));
                        }
                    }
                    if (zZza && (validationResultValidateModel == null || validationResultValidateModel.isValid())) {
                    }
                    if (zZza) {
                        mlKitException = new MlKitException("Model is not compatible with TFLite run time", 100);
                    } else {
                        zza.d("RemoteModelFileManager", "Hash does not match with expected: ".concat(String.valueOf(str)));
                        zzss.zzb("common").zzf(zzsk.zzg(), remoteModel, zzmu.MODEL_HASH_MISMATCH, true, this.zzd, zzna.SUCCEEDED);
                        mlKitException = new MlKitException("Hash does not match with expected", 102);
                    }
                    if (file.delete()) {
                        throw mlKitException;
                    }
                    zza.d("RemoteModelFileManager", "Failed to delete the temp file: ".concat(String.valueOf(file.getAbsolutePath())));
                    throw mlKitException;
                } finally {
                }
            } catch (Throwable th) {
                try {
                    autoCloseInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            zza.e("RemoteModelFileManager", "Failed to copy downloaded model file to private folder: ".concat(e.toString()));
            return null;
        }
        return this.zzf.moveAllFilesFromPrivateTempToPrivateDestination(file);
    }

    public final synchronized File zza(File file) throws MlKitException {
        File file2 = new File(String.valueOf(this.zzh.getModelDir(this.zzc, this.zzd).getAbsolutePath()).concat("/0"));
        if (file2.exists()) {
            return file;
        }
        return file.renameTo(file2) ? file2 : file;
    }

    public final synchronized String zzb() throws MlKitException {
        return this.zzh.zzb(this.zzc, this.zzd);
    }

    public final synchronized void zzc(File file) {
        File[] fileArrListFiles;
        File modelDirUnsafe = getModelDirUnsafe(false);
        if (modelDirUnsafe.exists() && (fileArrListFiles = modelDirUnsafe.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.equals(file)) {
                    this.zzh.deleteRecursively(file);
                    return;
                }
            }
        }
    }

    public final synchronized boolean zzd(File file) throws MlKitException {
        File modelDir = this.zzh.getModelDir(this.zzc, this.zzd);
        if (!modelDir.exists()) {
            return false;
        }
        File[] fileArrListFiles = modelDir.listFiles();
        boolean z = true;
        if (fileArrListFiles == null) {
            return true;
        }
        for (File file2 : fileArrListFiles) {
            if (!file2.equals(file) && !this.zzh.deleteRecursively(file2)) {
                z = false;
            }
        }
        return z;
    }
}

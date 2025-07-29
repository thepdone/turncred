package com.google.mlkit.common.internal.model;

import android.content.Context;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzu;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: com.google.mlkit:common@@18.11.0 */
/* loaded from: classes3.dex */
public class ModelUtils {
    private static final GmsLogger zza = new GmsLogger("ModelUtils", "");

    /* compiled from: com.google.mlkit:common@@18.11.0 */
    public static abstract class AutoMLManifest {
        public abstract String getLabelsFile();

        public abstract String getModelFile();

        public abstract String getModelType();
    }

    /* compiled from: com.google.mlkit:common@@18.11.0 */
    public static abstract class ModelLoggingInfo {
        static ModelLoggingInfo zza(long j, String str, boolean z) {
            return new AutoValue_ModelUtils_ModelLoggingInfo(j, zzu.zzb(str), z);
        }

        public abstract String getHash();

        public abstract long getSize();

        public abstract boolean isManifestModel();
    }

    private ModelUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo getModelLoggingInfo(android.content.Context r11, com.google.mlkit.common.model.LocalModel r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.internal.model.ModelUtils.getModelLoggingInfo(android.content.Context, com.google.mlkit.common.model.LocalModel):com.google.mlkit.common.internal.model.ModelUtils$ModelLoggingInfo");
    }

    public static String getSHA256(File file) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                String strZzc = zzc(fileInputStream);
                fileInputStream.close();
                return strZzc;
            } finally {
            }
        } catch (IOException e) {
            zza.e("ModelUtils", "Failed to create FileInputStream for model: ".concat(e.toString()));
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
    
        if (new java.io.File(r6).exists() == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest parseManifestFile(java.lang.String r6, boolean r7, android.content.Context r8) throws java.io.IOException {
        /*
            java.lang.String r0 = "Json string from the manifest file: "
            java.lang.String r1 = java.lang.String.valueOf(r6)
            com.google.android.gms.common.internal.GmsLogger r2 = com.google.mlkit.common.internal.model.ModelUtils.zza
            java.lang.String r3 = "Manifest file path: "
            java.lang.String r1 = r3.concat(r1)
            java.lang.String r3 = "ModelUtils"
            r2.d(r3, r1)
            r1 = 0
            if (r7 == 0) goto L24
            android.content.res.AssetManager r4 = r8.getAssets()     // Catch: java.io.IOException -> L2f
            java.io.InputStream r4 = r4.open(r6)     // Catch: java.io.IOException -> L2f
            if (r4 == 0) goto L37
            r4.close()     // Catch: java.io.IOException -> L2f
            goto L37
        L24:
            java.io.File r4 = new java.io.File
            r4.<init>(r6)
            boolean r4 = r4.exists()
            if (r4 != 0) goto L37
        L2f:
            com.google.android.gms.common.internal.GmsLogger r6 = com.google.mlkit.common.internal.model.ModelUtils.zza
            java.lang.String r7 = "Manifest file does not exist."
            r6.e(r3, r7)
            return r1
        L37:
            boolean r4 = r6.isEmpty()     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
            r5 = 0
            if (r4 == 0) goto L41
            byte[] r6 = new byte[r5]     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
            goto L66
        L41:
            if (r7 == 0) goto L4c
            android.content.res.AssetManager r7 = r8.getAssets()     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
            java.io.InputStream r6 = r7.open(r6)     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
            goto L57
        L4c:
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
            java.io.File r8 = new java.io.File     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
            r8.<init>(r6)     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
            r7.<init>(r8)     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
            r6 = r7
        L57:
            int r7 = r6.available()     // Catch: java.lang.Throwable -> L91
            byte[] r8 = new byte[r7]     // Catch: java.lang.Throwable -> L91
            r6.read(r8, r5, r7)     // Catch: java.lang.Throwable -> L91
            if (r6 == 0) goto L65
            r6.close()     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
        L65:
            r6 = r8
        L66:
            java.lang.String r7 = new java.lang.String     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
            java.lang.String r8 = "UTF-8"
            r7.<init>(r6, r8)     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
            java.lang.String r6 = r0.concat(r7)     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
            r2.d(r3, r6)     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
            r6.<init>(r7)     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
            java.lang.String r7 = "modelType"
            java.lang.String r7 = r6.getString(r7)     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
            java.lang.String r8 = "modelFile"
            java.lang.String r8 = r6.getString(r8)     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
            java.lang.String r0 = "labelsFile"
            java.lang.String r6 = r6.getString(r0)     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
            com.google.mlkit.common.internal.model.AutoValue_ModelUtils_AutoMLManifest r0 = new com.google.mlkit.common.internal.model.AutoValue_ModelUtils_AutoMLManifest     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
            r0.<init>(r7, r8, r6)     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
            return r0
        L91:
            r7 = move-exception
            if (r6 == 0) goto L9c
            r6.close()     // Catch: java.lang.Throwable -> L98
            goto L9c
        L98:
            r6 = move-exception
            r7.addSuppressed(r6)     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
        L9c:
            throw r7     // Catch: java.io.IOException -> L9d org.json.JSONException -> L9f
        L9d:
            r6 = move-exception
            goto La0
        L9f:
            r6 = move-exception
        La0:
            com.google.android.gms.common.internal.GmsLogger r7 = com.google.mlkit.common.internal.model.ModelUtils.zza
            java.lang.String r8 = "Error parsing the manifest file."
            r7.e(r3, r8, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.internal.model.ModelUtils.parseManifestFile(java.lang.String, boolean, android.content.Context):com.google.mlkit.common.internal.model.ModelUtils$AutoMLManifest");
    }

    public static boolean zza(File file, String str) throws IOException {
        String sha256 = getSHA256(file);
        zza.d("ModelUtils", "Calculated hash value is: ".concat(String.valueOf(sha256)));
        return str.equals(sha256);
    }

    private static String zzb(Context context, String str, boolean z) throws IOException {
        AutoMLManifest manifestFile = parseManifestFile(str, z, context);
        if (manifestFile != null) {
            return new File(new File(str).getParent(), manifestFile.getModelFile()).toString();
        }
        zza.e("ModelUtils", "Failed to parse manifest file.");
        return null;
    }

    private static String zzc(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
        int i;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            byte[] bArr = new byte[1048576];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i2);
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (IOException unused) {
            zza.e("ModelUtils", "Failed to read model file");
            return null;
        } catch (NoSuchAlgorithmException unused2) {
            zza.e("ModelUtils", "Do not have SHA-256 algorithm");
            return null;
        }
    }
}

package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import com.facebook.soloader.ExtractFromZipSoSource;
import com.facebook.soloader.UnpackingSoSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class BackupSoSource extends UnpackingSoSource implements RecoverableSoSource {
    private static final byte APK_SO_SOURCE_SIGNATURE_VERSION = 3;
    private static final byte LIBS_DIR_DOESNT_EXIST = 1;
    private static final byte LIBS_DIR_SNAPSHOT = 2;
    private static final String TAG = "BackupSoSource";
    private static final String ZIP_SEARCH_PATTERN = "^lib/([^/]+)/([^/]+\\.so)$";
    protected boolean mInitialized;
    private final ArrayList<ExtractFromZipSoSource> mZipSources;

    public BackupSoSource(Context context, String str, boolean z) {
        super(context, str, z);
        ArrayList<ExtractFromZipSoSource> arrayList = new ArrayList<>();
        this.mZipSources = arrayList;
        this.mInitialized = false;
        arrayList.add(new ExtractFromZipSoSource(context, str, new File(context.getApplicationInfo().sourceDir), ZIP_SEARCH_PATTERN));
        addBackupsFromSplitApks(context, str);
    }

    public BackupSoSource(Context context, String str) {
        this(context, str, true);
    }

    private void addBackupsFromSplitApks(Context context, String str) {
        if (context.getApplicationInfo().splitSourceDirs == null) {
            return;
        }
        try {
            for (String str2 : context.getApplicationInfo().splitSourceDirs) {
                ExtractFromZipSoSource extractFromZipSoSource = new ExtractFromZipSoSource(context, str, new File(str2), ZIP_SEARCH_PATTERN);
                if (extractFromZipSoSource.hasZippedLibs()) {
                    LogUtil.w(TAG, "adding backup source from split: " + extractFromZipSoSource.toString());
                    this.mZipSources.add(extractFromZipSoSource);
                }
            }
        } catch (IOException e) {
            LogUtil.w(TAG, "failed to read split apks", e);
        }
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public String getName() {
        return TAG;
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    protected UnpackingSoSource.Unpacker makeUnpacker() throws IOException {
        return new ApkUnpacker();
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        if (this.mInitialized) {
            return super.loadLibrary(str, i, threadPolicy);
        }
        return 0;
    }

    @Override // com.facebook.soloader.UnpackingSoSource, com.facebook.soloader.SoSource
    public void prepare(int i) throws IOException {
        if ((i & 8) != 0) {
            return;
        }
        super.prepare(i);
        this.mInitialized = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003e, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
    
        com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoLoader.TAG, "Found " + r9 + " in " + getName());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean peekAndPrepareSoSource(java.lang.String r9, int r10) throws java.io.IOException {
        /*
            r8 = this;
            com.facebook.soloader.UnpackingSoSource$Unpacker r0 = r8.makeUnpacker()
            com.facebook.soloader.UnpackingSoSource$Dso[] r1 = r0.getDsos()     // Catch: java.lang.Throwable -> L66
            int r2 = r1.length     // Catch: java.lang.Throwable -> L66
            r3 = 0
            r4 = r3
        Lb:
            java.lang.String r5 = "SoLoader"
            r6 = 1
            if (r4 >= r2) goto L43
            r7 = r1[r4]     // Catch: java.lang.Throwable -> L66
            java.lang.String r7 = r7.name     // Catch: java.lang.Throwable -> L66
            boolean r7 = r7.equals(r9)     // Catch: java.lang.Throwable -> L66
            if (r7 == 0) goto L40
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L66
            r1.<init>()     // Catch: java.lang.Throwable -> L66
            java.lang.String r2 = "Found "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L66
            java.lang.StringBuilder r9 = r1.append(r9)     // Catch: java.lang.Throwable -> L66
            java.lang.String r1 = " in "
            java.lang.StringBuilder r9 = r9.append(r1)     // Catch: java.lang.Throwable -> L66
            java.lang.String r1 = r8.getName()     // Catch: java.lang.Throwable -> L66
            java.lang.StringBuilder r9 = r9.append(r1)     // Catch: java.lang.Throwable -> L66
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L66
            com.facebook.soloader.LogUtil.e(r5, r9)     // Catch: java.lang.Throwable -> L66
            r9 = r6
            goto L44
        L40:
            int r4 = r4 + 1
            goto Lb
        L43:
            r9 = r3
        L44:
            if (r0 == 0) goto L49
            r0.close()
        L49:
            if (r9 != 0) goto L4c
            return r3
        L4c:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "Preparing "
            r9.<init>(r0)
            java.lang.String r0 = r8.getName()
            java.lang.StringBuilder r9 = r9.append(r0)
            java.lang.String r9 = r9.toString()
            com.facebook.soloader.LogUtil.e(r5, r9)
            r8.prepare(r10)
            return r6
        L66:
            r9 = move-exception
            if (r0 == 0) goto L71
            r0.close()     // Catch: java.lang.Throwable -> L6d
            goto L71
        L6d:
            r10 = move-exception
            r9.addSuppressed(r10)
        L71:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.BackupSoSource.peekAndPrepareSoSource(java.lang.String, int):boolean");
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    public UnpackingSoSource.Dso[] getDsosBaseApk() throws IOException {
        UnpackingSoSource.Unpacker unpackerMakeUnpacker = this.mZipSources.get(0).makeUnpacker();
        try {
            UnpackingSoSource.Dso[] dsos = unpackerMakeUnpacker.getDsos();
            if (unpackerMakeUnpacker != null) {
                unpackerMakeUnpacker.close();
            }
            return dsos;
        } catch (Throwable th) {
            if (unpackerMakeUnpacker != null) {
                try {
                    unpackerMakeUnpacker.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    protected class ApkUnpacker extends UnpackingSoSource.Unpacker {
        protected ApkUnpacker() {
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public UnpackingSoSource.Dso[] getDsos() throws IOException {
            ArrayList arrayList = new ArrayList();
            Iterator it = BackupSoSource.this.mZipSources.iterator();
            while (it.hasNext()) {
                UnpackingSoSource.Unpacker unpackerMakeUnpacker = ((ExtractFromZipSoSource) it.next()).makeUnpacker();
                try {
                    arrayList.addAll(Arrays.asList(unpackerMakeUnpacker.getDsos()));
                    if (unpackerMakeUnpacker != null) {
                        unpackerMakeUnpacker.close();
                    }
                } catch (Throwable th) {
                    if (unpackerMakeUnpacker != null) {
                        try {
                            unpackerMakeUnpacker.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            return (UnpackingSoSource.Dso[]) arrayList.toArray(new UnpackingSoSource.Dso[arrayList.size()]);
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public void unpack(File file) throws IOException {
            Iterator it = BackupSoSource.this.mZipSources.iterator();
            while (it.hasNext()) {
                ExtractFromZipSoSource.ZipUnpacker zipUnpacker = (ExtractFromZipSoSource.ZipUnpacker) ((ExtractFromZipSoSource) it.next()).makeUnpacker();
                try {
                    zipUnpacker.unpack(file);
                    if (zipUnpacker != null) {
                        zipUnpacker.close();
                    }
                } catch (Throwable th) {
                    if (zipUnpacker != null) {
                        try {
                            zipUnpacker.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        }
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    protected byte[] getDepsBlock() throws IOException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeByte((byte) 3);
            parcelObtain.writeInt(SysUtil.getAppVersionCode(this.mContext));
            parcelObtain.writeInt(this.mZipSources.size());
            Iterator<ExtractFromZipSoSource> it = this.mZipSources.iterator();
            while (it.hasNext()) {
                parcelObtain.writeByteArray(it.next().getDepsBlock());
            }
            String str = this.mContext.getApplicationInfo().sourceDir;
            if (str == null) {
                parcelObtain.writeByte((byte) 1);
                return parcelObtain.marshall();
            }
            File canonicalFile = new File(str).getCanonicalFile();
            if (!canonicalFile.exists()) {
                parcelObtain.writeByte((byte) 1);
                return parcelObtain.marshall();
            }
            parcelObtain.writeByte((byte) 2);
            parcelObtain.writeString(canonicalFile.getPath());
            parcelObtain.writeLong(canonicalFile.lastModified());
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // com.facebook.soloader.RecoverableSoSource
    public SoSource recover(Context context) {
        BackupSoSource backupSoSource = new BackupSoSource(context, this.soDirectory.getName());
        try {
            backupSoSource.prepare(0);
            return backupSoSource;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public String toString() {
        String name;
        try {
            name = String.valueOf(this.soDirectory.getCanonicalPath());
        } catch (IOException unused) {
            name = this.soDirectory.getName();
        }
        return getName() + "[root = " + name + " flags = " + this.flags + " apks = " + this.mZipSources.toString() + "]";
    }
}

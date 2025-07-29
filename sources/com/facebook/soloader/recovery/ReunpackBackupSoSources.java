package com.facebook.soloader.recovery;

import com.facebook.soloader.BackupSoSource;
import com.facebook.soloader.LogUtil;
import com.facebook.soloader.SoLoader;
import com.facebook.soloader.SoLoaderDSONotFoundError;
import com.facebook.soloader.SoLoaderULError;
import com.facebook.soloader.SoSource;
import java.io.IOException;

/* loaded from: classes3.dex */
public class ReunpackBackupSoSources implements RecoveryStrategy {
    private int mRecoveryFlags;

    public ReunpackBackupSoSources() {
        this(0);
    }

    public ReunpackBackupSoSources(int i) {
        this.mRecoveryFlags = i;
    }

    @Override // com.facebook.soloader.recovery.RecoveryStrategy
    public boolean recover(UnsatisfiedLinkError unsatisfiedLinkError, SoSource[] soSourceArr) {
        if (!(unsatisfiedLinkError instanceof SoLoaderULError)) {
            return false;
        }
        SoLoaderULError soLoaderULError = (SoLoaderULError) unsatisfiedLinkError;
        String soName = soLoaderULError.getSoName();
        String message = soLoaderULError.getMessage();
        if (soName == null) {
            LogUtil.e(SoLoader.TAG, "No so name provided in ULE, cannot recover");
            return false;
        }
        if (soLoaderULError instanceof SoLoaderDSONotFoundError) {
            if ((this.mRecoveryFlags & 1) == 0) {
                return false;
            }
            logRecovery(soLoaderULError, soName);
            return recoverDSONotFoundError(soSourceArr, soName, 0);
        }
        if (message == null || !(message.contains("/app/") || message.contains("/mnt/"))) {
            return false;
        }
        logRecovery(soLoaderULError, soName);
        return lazyPrepareBackupSoSource(soSourceArr, soName);
    }

    private boolean recoverDSONotFoundError(SoSource[] soSourceArr, String str, int i) {
        try {
            for (SoSource soSource : soSourceArr) {
                if ((soSource instanceof BackupSoSource) && ((BackupSoSource) soSource).peekAndPrepareSoSource(str, i)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            LogUtil.e(SoLoader.TAG, "Failed to run recovery for backup so source due to: " + e);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0030, code lost:
    
        if (r2 >= r8) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        r0 = r7[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0036, code lost:
    
        if ((r0 instanceof com.facebook.soloader.DirectorySoSource) != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
    
        if ((r0 instanceof com.facebook.soloader.BackupSoSource) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
    
        ((com.facebook.soloader.DirectorySoSource) r0).setExplicitDependencyResolution();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoLoader.TAG, "Encountered an exception while reunpacking BackupSoSource " + r4.getName() + " for library " + r8 + ": ", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
    
        r4 = (com.facebook.soloader.BackupSoSource) r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
    
        com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoLoader.TAG, "Preparing BackupSoSource for the first time " + r4.getName());
        r4.prepare(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002f, code lost:
    
        r8 = r7.length;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean lazyPrepareBackupSoSource(com.facebook.soloader.SoSource[] r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = "SoLoader"
            int r1 = r7.length
            r2 = 0
            r3 = r2
        L5:
            if (r3 >= r1) goto L6f
            r4 = r7[r3]
            boolean r5 = r4 instanceof com.facebook.soloader.BackupSoSource
            if (r5 != 0) goto L10
            int r3 = r3 + 1
            goto L5
        L10:
            com.facebook.soloader.BackupSoSource r4 = (com.facebook.soloader.BackupSoSource) r4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L48
            r1.<init>()     // Catch: java.lang.Exception -> L48
            java.lang.String r3 = "Preparing BackupSoSource for the first time "
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Exception -> L48
            java.lang.String r3 = r4.getName()     // Catch: java.lang.Exception -> L48
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Exception -> L48
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L48
            com.facebook.soloader.LogUtil.e(r0, r1)     // Catch: java.lang.Exception -> L48
            r4.prepare(r2)     // Catch: java.lang.Exception -> L48
            int r8 = r7.length
        L30:
            if (r2 >= r8) goto L46
            r0 = r7[r2]
            boolean r1 = r0 instanceof com.facebook.soloader.DirectorySoSource
            if (r1 != 0) goto L39
            goto L43
        L39:
            boolean r1 = r0 instanceof com.facebook.soloader.BackupSoSource
            if (r1 == 0) goto L3e
            goto L43
        L3e:
            com.facebook.soloader.DirectorySoSource r0 = (com.facebook.soloader.DirectorySoSource) r0
            r0.setExplicitDependencyResolution()
        L43:
            int r2 = r2 + 1
            goto L30
        L46:
            r7 = 1
            return r7
        L48:
            r7 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Encountered an exception while reunpacking BackupSoSource "
            r1.<init>(r3)
            java.lang.String r3 = r4.getName()
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r3 = " for library "
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.StringBuilder r8 = r1.append(r8)
            java.lang.String r1 = ": "
            java.lang.StringBuilder r8 = r8.append(r1)
            java.lang.String r8 = r8.toString()
            com.facebook.soloader.LogUtil.e(r0, r8, r7)
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.recovery.ReunpackBackupSoSources.lazyPrepareBackupSoSource(com.facebook.soloader.SoSource[], java.lang.String):boolean");
    }

    private void logRecovery(Error error, String str) {
        LogUtil.e(SoLoader.TAG, "Reunpacking BackupSoSources due to " + error + ", retrying for specific library " + str);
    }
}

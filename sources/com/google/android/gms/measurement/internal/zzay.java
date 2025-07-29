package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzay {
    private static Set<String> zza(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
        try {
            Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
            return hashSet;
        } finally {
            cursorRawQuery.close();
        }
    }

    static void zza(zzgo zzgoVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws IllegalStateException, SQLException {
        if (zzgoVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        if (!zza(zzgoVar, sQLiteDatabase, str)) {
            sQLiteDatabase.execSQL(str2);
        }
        try {
            if (zzgoVar == null) {
                throw new IllegalArgumentException("Monitor must not be null");
            }
            Set<String> setZza = zza(sQLiteDatabase, str);
            for (String str4 : str3.split(",")) {
                if (!setZza.remove(str4)) {
                    throw new SQLiteException("Table " + str + " is missing required column: " + str4);
                }
            }
            if (strArr != null) {
                for (int i = 0; i < strArr.length; i += 2) {
                    if (!setZza.remove(strArr[i])) {
                        sQLiteDatabase.execSQL(strArr[i + 1]);
                    }
                }
            }
            if (setZza.isEmpty()) {
                return;
            }
            zzgoVar.zzr().zza("Table has extra columns. table, columns", str, TextUtils.join(", ", setZza));
        } catch (SQLiteException e) {
            zzgoVar.zzg().zza("Failed to verify columns on table that was just created", str);
            throw e;
        }
    }

    static void zza(zzgo zzgoVar, SQLiteDatabase sQLiteDatabase) throws IllegalStateException {
        if (zzgoVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(com.google.android.gms.internal.measurement.zzcf.zza().zza(sQLiteDatabase.getPath()));
        if (!file.setReadable(false, false)) {
            zzgoVar.zzr().zza("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzgoVar.zzr().zza("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzgoVar.zzr().zza("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        zzgoVar.zzr().zza("Failed to turn on database write permission for owner");
    }

    private static boolean zza(zzgo zzgoVar, SQLiteDatabase sQLiteDatabase, String str) {
        if (zzgoVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                boolean zMoveToFirst = cursorQuery.moveToFirst();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return zMoveToFirst;
            } catch (SQLiteException e) {
                zzgoVar.zzr().zza("Error querying for table", str, e);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }
}

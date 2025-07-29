package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public abstract class zzcj extends SQLiteOpenHelper {
    public zzcj(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(context, str, null, 1, zzco.zza);
    }

    private zzcj(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, zzco zzcoVar) {
        super(context, (str == null || zzcf.zza().zzb(str, zzcoVar, zzcl.SQLITE_OPEN_HELPER_TYPE).equals("")) ? null : str, (SQLiteDatabase.CursorFactory) null, 1);
    }
}

package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzjj;
import io.sentry.protocol.App;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.io.IOUtils;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzar extends zzot {
    private final zzaz zzm;
    private final zzoh zzn;
    private static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    static final String[] zza = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;"};
    private static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzd = {App.JsonKeys.APP_VERSION, "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;"};
    private static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzj = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private static final String[] zzk = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    private static final String[] zzl = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    private final int zzr(String str) throws IllegalStateException {
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        try {
            int iZzb = zze().zzb(str, zzbn.zzv);
            if (iZzb <= 0) {
                return 0;
            }
            return f_().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(iZzb)});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting over the limit queued batches. appId", zzgo.zza(str), e);
            return 0;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzot
    protected final boolean zzc() {
        return false;
    }

    public final int zza(String str, String str2) throws IllegalStateException {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzv();
        zzam();
        try {
            return f_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting conditional property", zzgo.zza(str), zzi().zzc(str2), e);
            return 0;
        }
    }

    public final long zza(String str) throws IllegalStateException {
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        try {
            return f_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zze().zzb(str, zzbn.zzp))))});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting over the limit events. appId", zzgo.zza(str), e);
            return 0L;
        }
    }

    public final long c_() {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = f_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursorRawQuery.moveToFirst()) {
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return -1L;
                }
                long j = cursorRawQuery.getLong(0);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error querying raw events", e);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final long zza(zzgf.zzk zzkVar) throws IllegalStateException, IOException {
        zzv();
        zzam();
        Preconditions.checkNotNull(zzkVar);
        Preconditions.checkNotEmpty(zzkVar.zzab());
        byte[] bArrZzce = zzkVar.zzce();
        long jZza = h_().zza(bArrZzce);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzkVar.zzab());
        contentValues.put("metadata_fingerprint", Long.valueOf(jZza));
        contentValues.put("metadata", bArrZzce);
        try {
            f_().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return jZza;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing raw event metadata. appId", zzgo.zza(zzkVar.zzab()), e);
            throw e;
        }
    }

    public final long zza(String str, zzgf.zzj zzjVar, String str2, Map<String, String> map, zzlu zzluVar, Long l) throws IllegalStateException {
        int iDelete;
        zzv();
        zzam();
        Preconditions.checkNotNull(zzjVar);
        Preconditions.checkNotEmpty(str);
        if (!zze().zza(zzbn.zzch)) {
            return -1L;
        }
        zzv();
        zzam();
        if (zzab()) {
            long jZza = zzo().zzb.zza();
            long jElapsedRealtime = zzb().elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jZza) > zzai.zzo()) {
                zzo().zzb.zza(jElapsedRealtime);
                zzv();
                zzam();
                if (zzab() && (iDelete = f_().delete("upload_queue", zzap(), new String[0])) > 0) {
                    zzj().zzq().zza("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", Integer.valueOf(iDelete));
                }
                if (zze().zza(zzbn.zzcj)) {
                    zzr(str);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(entry.getKey() + "=" + entry.getValue());
        }
        byte[] bArrZzce = zzjVar.zzce();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("measurement_batch", bArrZzce);
        contentValues.put("upload_uri", str2);
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        if (size > 0) {
            sb.append((CharSequence) arrayList.get(0));
            int i = 1;
            while (i < size) {
                sb.append((CharSequence) IOUtils.LINE_SEPARATOR_WINDOWS);
                Object obj = arrayList.get(i);
                i++;
                sb.append((CharSequence) obj);
            }
        }
        contentValues.put("upload_headers", sb.toString());
        contentValues.put("upload_type", Integer.valueOf(zzluVar.zza()));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzb().currentTimeMillis()));
        contentValues.put("retry_count", (Integer) 0);
        if (l != null) {
            contentValues.put("associated_row_id", l);
        }
        try {
            long jInsert = f_().insert("upload_queue", null, contentValues);
            if (jInsert == -1) {
                zzj().zzg().zza("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", str);
            }
            return jInsert;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing MeasurementBatch to upload_queue. appId", str, e);
            return -1L;
        }
    }

    protected final long zzb(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzv();
        zzam();
        SQLiteDatabase sQLiteDatabaseF_ = f_();
        sQLiteDatabaseF_.beginTransaction();
        long j = 0;
        try {
            try {
                long jZza = zza("select " + str2 + " from app2 where app_id=?", new String[]{str}, -1L);
                if (jZza == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (sQLiteDatabaseF_.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        zzj().zzg().zza("Failed to insert column (got -1). appId", zzgo.zza(str), str2);
                        return -1L;
                    }
                    jZza = 0;
                }
                try {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", str);
                    contentValues2.put(str2, Long.valueOf(1 + jZza));
                    if (sQLiteDatabaseF_.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                        zzj().zzg().zza("Failed to update column (got 0). appId", zzgo.zza(str), str2);
                        return -1L;
                    }
                    sQLiteDatabaseF_.setTransactionSuccessful();
                    return jZza;
                } catch (SQLiteException e) {
                    e = e;
                    j = jZza;
                    zzj().zzg().zza("Error inserting column. appId", zzgo.zza(str), str2, e);
                    sQLiteDatabaseF_.endTransaction();
                    return j;
                }
            } finally {
                sQLiteDatabaseF_.endTransaction();
            }
        } catch (SQLiteException e2) {
            e = e2;
        }
    }

    public final long d_() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    public final long e_() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    public final long zzb(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = f_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    long j = cursorRawQuery.getLong(0);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zza(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = f_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    return cursorRawQuery.getLong(0);
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    final SQLiteDatabase f_() {
        zzv();
        try {
            return this.zzm.getWritableDatabase();
        } catch (SQLiteException e) {
            zzj().zzr().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0089: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:32:0x0089 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle zzc(java.lang.String r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r5.zzv()
            r5.zzam()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.f_()     // Catch: java.lang.Throwable -> L71 android.database.sqlite.SQLiteException -> L73
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L71 android.database.sqlite.SQLiteException -> L73
            r4 = 0
            r3[r4] = r6     // Catch: java.lang.Throwable -> L71 android.database.sqlite.SQLiteException -> L73
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L71 android.database.sqlite.SQLiteException -> L73
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            if (r2 != 0) goto L30
            com.google.android.gms.measurement.internal.zzgo r6 = r5.zzj()     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.measurement.internal.zzgq r6 = r6.zzq()     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            java.lang.String r2 = "Default event parameters not found"
            r6.zza(r2)     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            if (r1 == 0) goto L2f
            r1.close()
        L2f:
            return r0
        L30:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.internal.measurement.zzgf$zzf$zza r3 = com.google.android.gms.internal.measurement.zzgf.zzf.zze()     // Catch: java.io.IOException -> L57 android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.internal.measurement.zzlp r2 = com.google.android.gms.measurement.internal.zzpj.zza(r3, r2)     // Catch: java.io.IOException -> L57 android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.internal.measurement.zzgf$zzf$zza r2 = (com.google.android.gms.internal.measurement.zzgf.zzf.zza) r2     // Catch: java.io.IOException -> L57 android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.internal.measurement.zzlm r2 = r2.zzaj()     // Catch: java.io.IOException -> L57 android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.internal.measurement.zzkg r2 = (com.google.android.gms.internal.measurement.zzkg) r2     // Catch: java.io.IOException -> L57 android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.internal.measurement.zzgf$zzf r2 = (com.google.android.gms.internal.measurement.zzgf.zzf) r2     // Catch: java.io.IOException -> L57 android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            r5.h_()     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            java.util.List r6 = r2.zzh()     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            android.os.Bundle r6 = com.google.android.gms.measurement.internal.zzpj.zza(r6)     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            if (r1 == 0) goto L56
            r1.close()
        L56:
            return r6
        L57:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzgo r3 = r5.zzj()     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzgo.zza(r6)     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            r3.zza(r4, r6, r2)     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            if (r1 == 0) goto L6e
            r1.close()
        L6e:
            return r0
        L6f:
            r6 = move-exception
            goto L75
        L71:
            r6 = move-exception
            goto L8a
        L73:
            r6 = move-exception
            r1 = r0
        L75:
            com.google.android.gms.measurement.internal.zzgo r2 = r5.zzj()     // Catch: java.lang.Throwable -> L88
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()     // Catch: java.lang.Throwable -> L88
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zza(r3, r6)     // Catch: java.lang.Throwable -> L88
            if (r1 == 0) goto L87
            r1.close()
        L87:
            return r0
        L88:
            r6 = move-exception
            r0 = r1
        L8a:
            if (r0 == 0) goto L8f
            r0.close()
        L8f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zzc(java.lang.String):android.os.Bundle");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0091: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:32:0x0091 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzgf.zzf, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) throws java.lang.Throwable {
        /*
            r7 = this;
            r7.zzv()
            r7.zzam()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.f_()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r6 = 1
            r3[r6] = r5     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r2 != 0) goto L37
            com.google.android.gms.measurement.internal.zzgo r8 = r7.zzj()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.measurement.internal.zzgq r8 = r8.zzq()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            java.lang.String r9 = "Main event not found"
            r8.zza(r9)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r1 == 0) goto L36
            r1.close()
        L36:
            return r0
        L37:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            long r3 = r1.getLong(r6)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzgf$zzf$zza r4 = com.google.android.gms.internal.measurement.zzgf.zzf.zze()     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzlp r2 = com.google.android.gms.measurement.internal.zzpj.zza(r4, r2)     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzgf$zzf$zza r2 = (com.google.android.gms.internal.measurement.zzgf.zzf.zza) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzlm r2 = r2.zzaj()     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzkg r2 = (com.google.android.gms.internal.measurement.zzkg) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzgf$zzf r2 = (com.google.android.gms.internal.measurement.zzgf.zzf) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r1 == 0) goto L5e
            r1.close()
        L5e:
            return r8
        L5f:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzgo r3 = r7.zzj()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgo.zza(r8)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            r3.zza(r4, r8, r9, r2)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r1 == 0) goto L76
            r1.close()
        L76:
            return r0
        L77:
            r8 = move-exception
            goto L7d
        L79:
            r8 = move-exception
            goto L92
        L7b:
            r8 = move-exception
            r1 = r0
        L7d:
            com.google.android.gms.measurement.internal.zzgo r9 = r7.zzj()     // Catch: java.lang.Throwable -> L90
            com.google.android.gms.measurement.internal.zzgq r9 = r9.zzg()     // Catch: java.lang.Throwable -> L90
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch: java.lang.Throwable -> L90
            if (r1 == 0) goto L8f
            r1.close()
        L8f:
            return r0
        L90:
            r8 = move-exception
            r0 = r1
        L92:
            if (r0 == 0) goto L97
            r0.close()
        L97:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x03db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzh zzd(java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 991
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zzd(java.lang.String):com.google.android.gms.measurement.internal.zzh");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0159  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzag zzc(java.lang.String r33, java.lang.String r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzag");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzat zze(java.lang.String r13) {
        /*
            r12 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            r12.zzv()
            r12.zzam()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r12.f_()     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            java.lang.String r2 = "apps"
            r3 = 3
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            java.lang.String r4 = "remote_config"
            r9 = 0
            r3[r9] = r4     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            java.lang.String r4 = "config_last_modified_time"
            r10 = 1
            r3[r10] = r4     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            java.lang.String r4 = "e_tag"
            r11 = 2
            r3[r11] = r4     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            java.lang.String r4 = "app_id=?"
            java.lang.String[] r5 = new java.lang.String[r10]     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            r5[r9] = r13     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            r7 = 0
            r8 = 0
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8e
            if (r2 != 0) goto L3b
            if (r1 == 0) goto L3a
            r1.close()
        L3a:
            return r0
        L3b:
            byte[] r2 = r1.getBlob(r9)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8e
            java.lang.String r3 = r1.getString(r10)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8e
            java.lang.String r4 = r1.getString(r11)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8e
            boolean r5 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8e
            if (r5 == 0) goto L5e
            com.google.android.gms.measurement.internal.zzgo r5 = r12.zzj()     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8e
            com.google.android.gms.measurement.internal.zzgq r5 = r5.zzg()     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8e
            java.lang.String r6 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzgo.zza(r13)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8e
            r5.zza(r6, r7)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8e
        L5e:
            if (r2 != 0) goto L66
            if (r1 == 0) goto L65
            r1.close()
        L65:
            return r0
        L66:
            com.google.android.gms.measurement.internal.zzat r5 = new com.google.android.gms.measurement.internal.zzat     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8e
            r5.<init>(r2, r3, r4)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8e
            if (r1 == 0) goto L70
            r1.close()
        L70:
            return r5
        L71:
            r2 = move-exception
            goto L77
        L73:
            r13 = move-exception
            goto L90
        L75:
            r2 = move-exception
            r1 = r0
        L77:
            com.google.android.gms.measurement.internal.zzgo r3 = r12.zzj()     // Catch: java.lang.Throwable -> L8e
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch: java.lang.Throwable -> L8e
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzgo.zza(r13)     // Catch: java.lang.Throwable -> L8e
            r3.zza(r4, r13, r2)     // Catch: java.lang.Throwable -> L8e
            if (r1 == 0) goto L8d
            r1.close()
        L8d:
            return r0
        L8e:
            r13 = move-exception
            r0 = r1
        L90:
            if (r0 == 0) goto L95
            r0.close()
        L95:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zze(java.lang.String):com.google.android.gms.measurement.internal.zzat");
    }

    public final zzas zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        return zza(j, str, 1L, false, false, z3, false, z5, z6, z7);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0165  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzas zza(long r23, java.lang.String r25, long r26, boolean r28, boolean r29, boolean r30, boolean r31, boolean r32, boolean r33, boolean r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zza(long, java.lang.String, long, boolean, boolean, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.measurement.internal.zzas");
    }

    public final zzbd zzf(String str) {
        Preconditions.checkNotNull(str);
        zzv();
        zzam();
        return zzbd.zza(zza("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final zzbh zzd(String str, String str2) {
        return zzc("events", str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.android.gms.measurement.internal.zzbh zzc(java.lang.String r28, java.lang.String r29, java.lang.String r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zzc(java.lang.String, java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzbh");
    }

    public final zzjj zzg(String str) {
        Preconditions.checkNotNull(str);
        zzv();
        zzam();
        return zzjj.zzb(zza("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final zzjj zzh(String str) {
        Preconditions.checkNotNull(str);
        zzv();
        zzam();
        zzjj zzjjVar = (zzjj) zza("select consent_state, consent_source from consent_settings where app_id=? limit 1;", new String[]{str}, new zzaw() { // from class: com.google.android.gms.measurement.internal.zzaq
            @Override // com.google.android.gms.measurement.internal.zzaw
            public final Object zza(Cursor cursor) {
                return zzjj.zza(cursor.getString(0), cursor.getInt(1));
            }
        });
        return zzjjVar == null ? zzjj.zza : zzjjVar;
    }

    private final zzpi zza(String str, long j, byte[] bArr, String str2, String str3, int i, int i2, long j2, long j3) throws IllegalStateException {
        zzlu zzluVar;
        if (TextUtils.isEmpty(str2)) {
            zzj().zzc().zza("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            zzgf.zzj.zzb zzbVar = (zzgf.zzj.zzb) zzpj.zza(zzgf.zzj.zzb(), bArr);
            zzlu[] zzluVarArrValues = zzlu.values();
            int length = zzluVarArrValues.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    zzluVar = zzluVarArrValues[i3];
                    if (zzluVar.zza() == i) {
                        break;
                    }
                    i3++;
                } else {
                    zzluVar = zzlu.UNKNOWN;
                    break;
                }
            }
            if (zzluVar != zzlu.GOOGLE_SIGNAL && zzluVar != zzlu.GOOGLE_SIGNAL_PENDING && i2 > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<zzgf.zzk> it = zzbVar.zzd().iterator();
                while (it.hasNext()) {
                    zzgf.zzk.zza zzaVarZzch = it.next().zzch();
                    zzgf.zzk.zza zzaVar = zzaVarZzch;
                    zzgf.zzk.zza zzaVar2 = zzaVarZzch;
                    zzaVar2.zzi(i2);
                    arrayList.add((zzgf.zzk) ((com.google.android.gms.internal.measurement.zzkg) zzaVar2.zzaj()));
                }
                zzbVar.zzb();
                zzbVar.zza(arrayList);
            }
            HashMap map = new HashMap();
            if (str3 != null) {
                String[] strArrSplit = str3.split(IOUtils.LINE_SEPARATOR_WINDOWS);
                int length2 = strArrSplit.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length2) {
                        break;
                    }
                    String str4 = strArrSplit[i4];
                    if (str4.isEmpty()) {
                        break;
                    }
                    String[] strArrSplit2 = str4.split("=", 2);
                    if (strArrSplit2.length != 2) {
                        zzj().zzg().zza("Invalid upload header: ", str4);
                        break;
                    }
                    map.put(strArrSplit2[0], strArrSplit2[1]);
                    i4++;
                }
            }
            return new zzph().zzc(j).zza((zzgf.zzj) ((com.google.android.gms.internal.measurement.zzkg) zzbVar.zzaj())).zza(str2).zza(map).zza(zzluVar).zzb(j2).zza(j3).zza();
        } catch (IOException e) {
            zzj().zzg().zza("Failed to queued MeasurementBatch from upload_queue. appId", str, e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzpi zzi(java.lang.String r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zzi(java.lang.String):com.google.android.gms.measurement.internal.zzpi");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzpi zza(long r33) throws java.lang.Throwable {
        /*
            r32 = this;
            com.google.android.gms.measurement.internal.zzai r0 = r32.zze()
            com.google.android.gms.measurement.internal.zzfx<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzbn.zzcj
            boolean r0 = r0.zza(r1)
            r1 = 0
            if (r0 != 0) goto Le
            return r1
        Le:
            r32.zzv()
            r32.zzam()
            android.database.sqlite.SQLiteDatabase r2 = r32.f_()     // Catch: java.lang.Throwable -> Lb2 android.database.sqlite.SQLiteException -> Lb4
            java.lang.String r3 = "upload_queue"
            r0 = 9
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> Lb2 android.database.sqlite.SQLiteException -> Lb4
            java.lang.String r0 = "rowId"
            r5 = 0
            r4[r5] = r0     // Catch: java.lang.Throwable -> Lb2 android.database.sqlite.SQLiteException -> Lb4
            java.lang.String r0 = "app_id"
            r11 = 1
            r4[r11] = r0     // Catch: java.lang.Throwable -> Lb2 android.database.sqlite.SQLiteException -> Lb4
            java.lang.String r0 = "measurement_batch"
            r12 = 2
            r4[r12] = r0     // Catch: java.lang.Throwable -> Lb2 android.database.sqlite.SQLiteException -> Lb4
            java.lang.String r0 = "upload_uri"
            r13 = 3
            r4[r13] = r0     // Catch: java.lang.Throwable -> Lb2 android.database.sqlite.SQLiteException -> Lb4
            java.lang.String r0 = "upload_headers"
            r14 = 4
            r4[r14] = r0     // Catch: java.lang.Throwable -> Lb2 android.database.sqlite.SQLiteException -> Lb4
            java.lang.String r0 = "upload_type"
            r15 = 5
            r4[r15] = r0     // Catch: java.lang.Throwable -> Lb2 android.database.sqlite.SQLiteException -> Lb4
            java.lang.String r0 = "retry_count"
            r10 = 6
            r4[r10] = r0     // Catch: java.lang.Throwable -> Lb2 android.database.sqlite.SQLiteException -> Lb4
            java.lang.String r0 = "creation_timestamp"
            r9 = 7
            r4[r9] = r0     // Catch: java.lang.Throwable -> Lb2 android.database.sqlite.SQLiteException -> Lb4
            java.lang.String r0 = "associated_row_id"
            r8 = 8
            r4[r8] = r0     // Catch: java.lang.Throwable -> Lb2 android.database.sqlite.SQLiteException -> Lb4
            java.lang.String r0 = "rowId=?"
            java.lang.String[] r6 = new java.lang.String[r11]     // Catch: java.lang.Throwable -> Lb2 android.database.sqlite.SQLiteException -> Lb4
            java.lang.String r7 = java.lang.String.valueOf(r33)     // Catch: java.lang.Throwable -> Lb2 android.database.sqlite.SQLiteException -> Lb4
            r6[r5] = r7     // Catch: java.lang.Throwable -> Lb2 android.database.sqlite.SQLiteException -> Lb4
            java.lang.String r16 = "1"
            r7 = 0
            r17 = 0
            r18 = 0
            r5 = r0
            r0 = r8
            r8 = r17
            r0 = r9
            r9 = r18
            r0 = r10
            r10 = r16
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> Lb2 android.database.sqlite.SQLiteException -> Lb4
            boolean r3 = r2.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> Lb0 java.lang.Throwable -> Lcd
            if (r3 != 0) goto L77
            if (r2 == 0) goto L76
            r2.close()
        L76:
            return r1
        L77:
            java.lang.String r3 = r2.getString(r11)     // Catch: android.database.sqlite.SQLiteException -> Lb0 java.lang.Throwable -> Lcd
            java.lang.Object r3 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch: android.database.sqlite.SQLiteException -> Lb0 java.lang.Throwable -> Lcd
            r20 = r3
            java.lang.String r20 = (java.lang.String) r20     // Catch: android.database.sqlite.SQLiteException -> Lb0 java.lang.Throwable -> Lcd
            byte[] r23 = r2.getBlob(r12)     // Catch: android.database.sqlite.SQLiteException -> Lb0 java.lang.Throwable -> Lcd
            java.lang.String r24 = r2.getString(r13)     // Catch: android.database.sqlite.SQLiteException -> Lb0 java.lang.Throwable -> Lcd
            java.lang.String r25 = r2.getString(r14)     // Catch: android.database.sqlite.SQLiteException -> Lb0 java.lang.Throwable -> Lcd
            int r26 = r2.getInt(r15)     // Catch: android.database.sqlite.SQLiteException -> Lb0 java.lang.Throwable -> Lcd
            int r27 = r2.getInt(r0)     // Catch: android.database.sqlite.SQLiteException -> Lb0 java.lang.Throwable -> Lcd
            r0 = 7
            long r28 = r2.getLong(r0)     // Catch: android.database.sqlite.SQLiteException -> Lb0 java.lang.Throwable -> Lcd
            r0 = 8
            long r30 = r2.getLong(r0)     // Catch: android.database.sqlite.SQLiteException -> Lb0 java.lang.Throwable -> Lcd
            r19 = r32
            r21 = r33
            com.google.android.gms.measurement.internal.zzpi r0 = r19.zza(r20, r21, r23, r24, r25, r26, r27, r28, r30)     // Catch: android.database.sqlite.SQLiteException -> Lb0 java.lang.Throwable -> Lcd
            if (r2 == 0) goto Laf
            r2.close()
        Laf:
            return r0
        Lb0:
            r0 = move-exception
            goto Lb6
        Lb2:
            r0 = move-exception
            goto Lcf
        Lb4:
            r0 = move-exception
            r2 = r1
        Lb6:
            com.google.android.gms.measurement.internal.zzgo r3 = r32.zzj()     // Catch: java.lang.Throwable -> Lcd
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch: java.lang.Throwable -> Lcd
            java.lang.String r4 = "Error to querying MeasurementBatch from upload_queue. rowId"
            java.lang.Long r5 = java.lang.Long.valueOf(r33)     // Catch: java.lang.Throwable -> Lcd
            r3.zza(r4, r5, r0)     // Catch: java.lang.Throwable -> Lcd
            if (r2 == 0) goto Lcc
            r2.close()
        Lcc:
            return r1
        Lcd:
            r0 = move-exception
            r1 = r2
        Lcf:
            if (r1 == 0) goto Ld4
            r1.close()
        Ld4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zza(long):com.google.android.gms.measurement.internal.zzpi");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzpo zze(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzv()
            r18.zzam()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.f_()     // Catch: java.lang.Throwable -> L8b android.database.sqlite.SQLiteException -> L8f
            java.lang.String r11 = "user_attributes"
            r0 = 3
            java.lang.String[] r12 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L8b android.database.sqlite.SQLiteException -> L8f
            java.lang.String r0 = "set_timestamp"
            r1 = 0
            r12[r1] = r0     // Catch: java.lang.Throwable -> L8b android.database.sqlite.SQLiteException -> L8f
            java.lang.String r0 = "value"
            r2 = 1
            r12[r2] = r0     // Catch: java.lang.Throwable -> L8b android.database.sqlite.SQLiteException -> L8f
            java.lang.String r0 = "origin"
            r3 = 2
            r12[r3] = r0     // Catch: java.lang.Throwable -> L8b android.database.sqlite.SQLiteException -> L8f
            java.lang.String r13 = "app_id=? and name=?"
            java.lang.String[] r14 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L8b android.database.sqlite.SQLiteException -> L8f
            r14[r1] = r19     // Catch: java.lang.Throwable -> L8b android.database.sqlite.SQLiteException -> L8f
            r14[r2] = r8     // Catch: java.lang.Throwable -> L8b android.database.sqlite.SQLiteException -> L8f
            r16 = 0
            r17 = 0
            r15 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L8b android.database.sqlite.SQLiteException -> L8f
            boolean r0 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L87
            if (r0 != 0) goto L44
            if (r10 == 0) goto L43
            r10.close()
        L43:
            return r9
        L44:
            long r5 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L87
            r11 = r18
            java.lang.Object r7 = r11.zza(r10, r2)     // Catch: android.database.sqlite.SQLiteException -> L81 java.lang.Throwable -> Lb2
            if (r7 != 0) goto L56
            if (r10 == 0) goto L55
            r10.close()
        L55:
            return r9
        L56:
            java.lang.String r3 = r10.getString(r3)     // Catch: android.database.sqlite.SQLiteException -> L81 java.lang.Throwable -> Lb2
            com.google.android.gms.measurement.internal.zzpo r0 = new com.google.android.gms.measurement.internal.zzpo     // Catch: android.database.sqlite.SQLiteException -> L81 java.lang.Throwable -> Lb2
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch: android.database.sqlite.SQLiteException -> L81 java.lang.Throwable -> Lb2
            boolean r1 = r10.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L81 java.lang.Throwable -> Lb2
            if (r1 == 0) goto L7b
            com.google.android.gms.measurement.internal.zzgo r1 = r18.zzj()     // Catch: android.database.sqlite.SQLiteException -> L81 java.lang.Throwable -> Lb2
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzg()     // Catch: android.database.sqlite.SQLiteException -> L81 java.lang.Throwable -> Lb2
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgo.zza(r19)     // Catch: android.database.sqlite.SQLiteException -> L81 java.lang.Throwable -> Lb2
            r1.zza(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L81 java.lang.Throwable -> Lb2
        L7b:
            if (r10 == 0) goto L80
            r10.close()
        L80:
            return r0
        L81:
            r0 = move-exception
            goto L93
        L83:
            r0 = move-exception
            r11 = r18
            goto Lb3
        L87:
            r0 = move-exception
            r11 = r18
            goto L93
        L8b:
            r0 = move-exception
            r11 = r18
            goto Lb4
        L8f:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L93:
            com.google.android.gms.measurement.internal.zzgo r1 = r18.zzj()     // Catch: java.lang.Throwable -> Lb2
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzg()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgo.zza(r19)     // Catch: java.lang.Throwable -> Lb2
            com.google.android.gms.measurement.internal.zzgl r4 = r18.zzi()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r4 = r4.zzc(r8)     // Catch: java.lang.Throwable -> Lb2
            r1.zza(r2, r3, r4, r0)     // Catch: java.lang.Throwable -> Lb2
            if (r10 == 0) goto Lb1
            r10.close()
        Lb1:
            return r9
        Lb2:
            r0 = move-exception
        Lb3:
            r9 = r10
        Lb4:
            if (r9 == 0) goto Lb9
            r9.close()
        Lb9:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zze(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzpo");
    }

    private final zzgf.zzk zzb(String str, long j) throws Throwable {
        zzgf.zzk zzkVar;
        Cursor cursorQuery;
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                cursorQuery = f_().query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str, Long.toString(j)}, null, null, "rowid", ExifInterface.GPS_MEASUREMENT_2D);
                try {
                    try {
                    } catch (SQLiteException e) {
                        e = e;
                        cursor2 = cursorQuery;
                        zzkVar = null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                e = e2;
                zzkVar = null;
            }
            if (!cursorQuery.moveToFirst()) {
                zzj().zzg().zza("Raw event metadata record is missing. appId", zzgo.zza(str));
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            }
            try {
                zzgf.zzk zzkVar2 = (zzgf.zzk) ((com.google.android.gms.internal.measurement.zzkg) ((zzgf.zzk.zza) zzpj.zza(zzgf.zzk.zzx(), cursorQuery.getBlob(0))).zzaj());
                try {
                    boolean zMoveToNext = cursorQuery.moveToNext();
                    Cursor cursor3 = zMoveToNext;
                    if (zMoveToNext) {
                        zzgq zzgqVarZzr = zzj().zzr();
                        zzgqVarZzr.zza("Get multiple raw event metadata records, expected one. appId", zzgo.zza(str));
                        cursor3 = zzgqVarZzr;
                    }
                    cursorQuery.close();
                    cursor = cursor3;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                        cursor = cursor3;
                    }
                } catch (SQLiteException e3) {
                    cursor2 = cursorQuery;
                    zzkVar = zzkVar2;
                    e = e3;
                    zzj().zzg().zza("Data loss. Error selecting raw event. appId", zzgo.zza(str), e);
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    zzkVar2 = zzkVar;
                    cursor = cursor2;
                    return zzkVar2;
                }
                return zzkVar2;
            } catch (IOException e4) {
                zzj().zzg().zza("Data loss. Failed to merge raw event metadata. appId", zzgo.zza(str), e4);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final Object zza(Cursor cursor, int i) throws IllegalStateException {
        int type = cursor.getType(i);
        if (type == 0) {
            zzj().zzg().zza("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type == 4) {
            zzj().zzg().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
        zzj().zzg().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0049  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final <T> T zza(java.lang.String r3, java.lang.String[] r4, com.google.android.gms.measurement.internal.zzaw<T> r5) throws java.lang.Throwable {
        /*
            r2 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r2.f_()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L30
            android.database.Cursor r3 = r1.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L30
            boolean r4 = r3.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L2c java.lang.Throwable -> L45
            if (r4 != 0) goto L22
            com.google.android.gms.measurement.internal.zzgo r4 = r2.zzj()     // Catch: android.database.sqlite.SQLiteException -> L2c java.lang.Throwable -> L45
            com.google.android.gms.measurement.internal.zzgq r4 = r4.zzq()     // Catch: android.database.sqlite.SQLiteException -> L2c java.lang.Throwable -> L45
            java.lang.String r5 = "No data found"
            r4.zza(r5)     // Catch: android.database.sqlite.SQLiteException -> L2c java.lang.Throwable -> L45
            if (r3 == 0) goto L21
            r3.close()
        L21:
            return r0
        L22:
            java.lang.Object r4 = r5.zza(r3)     // Catch: android.database.sqlite.SQLiteException -> L2c java.lang.Throwable -> L45
            if (r3 == 0) goto L2b
            r3.close()
        L2b:
            return r4
        L2c:
            r4 = move-exception
            goto L32
        L2e:
            r4 = move-exception
            goto L47
        L30:
            r4 = move-exception
            r3 = r0
        L32:
            com.google.android.gms.measurement.internal.zzgo r5 = r2.zzj()     // Catch: java.lang.Throwable -> L45
            com.google.android.gms.measurement.internal.zzgq r5 = r5.zzg()     // Catch: java.lang.Throwable -> L45
            java.lang.String r1 = "Error querying database."
            r5.zza(r1, r4)     // Catch: java.lang.Throwable -> L45
            if (r3 == 0) goto L44
            r3.close()
        L44:
            return r0
        L45:
            r4 = move-exception
            r0 = r3
        L47:
            if (r0 == 0) goto L4c
            r0.close()
        L4c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zza(java.lang.String, java.lang.String[], com.google.android.gms.measurement.internal.zzaw):java.lang.Object");
    }

    private final String zzap() {
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        return "(" + String.format(Locale.US, "(upload_type = %d AND ABS(creation_timestamp - %d) > %d)", Integer.valueOf(zzlu.GOOGLE_SIGNAL.zza()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzbn.zzan.zza(null).longValue())) + " OR " + String.format(Locale.US, "(upload_type != %d AND ABS(creation_timestamp - %d) > %d)", Integer.valueOf(zzlu.GOOGLE_SIGNAL.zza()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzai.zzm())) + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zzb(long r5) throws java.lang.Throwable {
        /*
            r4 = this;
            r4.zzv()
            r4.zzam()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.f_()     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            r6 = 0
            r3[r6] = r5     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            boolean r1 = r5.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            if (r1 != 0) goto L34
            com.google.android.gms.measurement.internal.zzgo r6 = r4.zzj()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            com.google.android.gms.measurement.internal.zzgq r6 = r6.zzq()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zza(r1)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            if (r5 == 0) goto L33
            r5.close()
        L33:
            return r0
        L34:
            java.lang.String r6 = r5.getString(r6)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            if (r5 == 0) goto L3d
            r5.close()
        L3d:
            return r6
        L3e:
            r6 = move-exception
            goto L44
        L40:
            r6 = move-exception
            goto L59
        L42:
            r6 = move-exception
            r5 = r0
        L44:
            com.google.android.gms.measurement.internal.zzgo r1 = r4.zzj()     // Catch: java.lang.Throwable -> L57
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzg()     // Catch: java.lang.Throwable -> L57
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch: java.lang.Throwable -> L57
            if (r5 == 0) goto L56
            r5.close()
        L56:
            return r0
        L57:
            r6 = move-exception
            r0 = r5
        L59:
            if (r0 == 0) goto L5e
            r0.close()
        L5e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zzb(long):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String g_() throws java.lang.Throwable {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.f_()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L24 android.database.sqlite.SQLiteException -> L29
            boolean r2 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L22 java.lang.Throwable -> L3e
            if (r2 == 0) goto L1c
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L22 java.lang.Throwable -> L3e
            if (r0 == 0) goto L1b
            r0.close()
        L1b:
            return r1
        L1c:
            if (r0 == 0) goto L21
            r0.close()
        L21:
            return r1
        L22:
            r2 = move-exception
            goto L2b
        L24:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3f
        L29:
            r2 = move-exception
            r0 = r1
        L2b:
            com.google.android.gms.measurement.internal.zzgo r3 = r6.zzj()     // Catch: java.lang.Throwable -> L3e
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zza(r4, r2)     // Catch: java.lang.Throwable -> L3e
            if (r0 == 0) goto L3d
            r0.close()
        L3d:
            return r1
        L3e:
            r1 = move-exception
        L3f:
            if (r0 == 0) goto L44
            r0.close()
        L44:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.g_():java.lang.String");
    }

    private final String zza(String str, String[] strArr, String str2) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = f_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    return cursorRawQuery.getString(0);
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return str2;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    private static String zzb(List<Integer> list) {
        if (list.isEmpty()) {
            return "";
        }
        return String.format(" AND (upload_type IN (%s))", TextUtils.join(", ", list));
    }

    public final List<Pair<zzgf.zzk, Long>> zza(String str, int i, int i2) {
        byte[] bArrZzc;
        long jZzc;
        long jZzc2;
        zzv();
        zzam();
        int i3 = 1;
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = f_().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
                if (!cursorQuery.moveToFirst()) {
                    List<Pair<zzgf.zzk, Long>> listEmptyList = Collections.emptyList();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return listEmptyList;
                }
                ArrayList arrayList = new ArrayList();
                int length = 0;
                while (true) {
                    long j = cursorQuery.getLong(0);
                    try {
                        bArrZzc = h_().zzc(cursorQuery.getBlob(i3));
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to unzip queued bundle. appId", zzgo.zza(str), e);
                    }
                    if (!arrayList.isEmpty() && bArrZzc.length + length > i2) {
                        break;
                    }
                    try {
                        zzgf.zzk.zza zzaVar = (zzgf.zzk.zza) zzpj.zza(zzgf.zzk.zzx(), bArrZzc);
                        if (!arrayList.isEmpty()) {
                            zzgf.zzk zzkVar = (zzgf.zzk) ((Pair) arrayList.get(0)).first;
                            zzgf.zzk zzkVar2 = (zzgf.zzk) ((com.google.android.gms.internal.measurement.zzkg) zzaVar.zzaj());
                            if (!zzkVar.zzag().equals(zzkVar2.zzag()) || !zzkVar.zzaf().equals(zzkVar2.zzaf()) || zzkVar.zzaw() != zzkVar2.zzaw() || !zzkVar.zzah().equals(zzkVar2.zzah())) {
                                break;
                            }
                            Iterator<zzgf.zzp> it = zzkVar.zzau().iterator();
                            while (true) {
                                jZzc = -1;
                                if (!it.hasNext()) {
                                    jZzc2 = -1;
                                    break;
                                }
                                zzgf.zzp next = it.next();
                                if ("_npa".equals(next.zzg())) {
                                    jZzc2 = next.zzc();
                                    break;
                                }
                            }
                            Iterator<zzgf.zzp> it2 = zzkVar2.zzau().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                zzgf.zzp next2 = it2.next();
                                if ("_npa".equals(next2.zzg())) {
                                    jZzc = next2.zzc();
                                    break;
                                }
                            }
                            if (jZzc2 != jZzc) {
                                break;
                            }
                        }
                        if (!cursorQuery.isNull(2)) {
                            zzaVar.zzi(cursorQuery.getInt(2));
                        }
                        length += bArrZzc.length;
                        arrayList.add(Pair.create((zzgf.zzk) ((com.google.android.gms.internal.measurement.zzkg) zzaVar.zzaj()), Long.valueOf(j)));
                    } catch (IOException e2) {
                        zzj().zzg().zza("Failed to merge queued bundle. appId", zzgo.zza(str), e2);
                    }
                    if (!cursorQuery.moveToNext() || length > i2) {
                        break;
                    }
                    i3 = 1;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayList;
            } catch (SQLiteException e3) {
                zzj().zzg().zza("Error querying bundles. appId", zzgo.zza(str), e3);
                List<Pair<zzgf.zzk, Long>> listEmptyList2 = Collections.emptyList();
                if (0 != 0) {
                    cursor.close();
                }
                return listEmptyList2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List<zzag> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3 + ProxyConfig.MATCH_ALL_SCHEMES);
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x008c, code lost:
    
        zzj().zzg().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0177  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzag> zza(java.lang.String r40, java.lang.String[] r41) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zza(java.lang.String, java.lang.String[]):java.util.List");
    }

    public final List<zzog> zzj(String str) {
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = f_().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str}, null, null, "rowid", null);
                if (!cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return arrayList;
                }
                do {
                    String string = cursorQuery.getString(0);
                    if (string == null) {
                        string = "";
                    }
                    arrayList.add(new zzog(string, cursorQuery.getLong(1), cursorQuery.getInt(2)));
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayList;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error querying trigger uris. appId", zzgo.zza(str), e);
                List<zzog> listEmptyList = Collections.emptyList();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return listEmptyList;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzpi> zza(java.lang.String r25, com.google.android.gms.measurement.internal.zzop r26, int r27) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zza(java.lang.String, com.google.android.gms.measurement.internal.zzop, int):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzpo> zzk(java.lang.String r23) throws java.lang.Throwable {
        /*
            r22 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r23)
            r22.zzv()
            r22.zzam()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r22.f_()     // Catch: java.lang.Throwable -> L8d android.database.sqlite.SQLiteException -> L91
            java.lang.String r3 = "user_attributes"
            r4 = 4
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L8d android.database.sqlite.SQLiteException -> L91
            java.lang.String r5 = "name"
            r11 = 0
            r4[r11] = r5     // Catch: java.lang.Throwable -> L8d android.database.sqlite.SQLiteException -> L91
            java.lang.String r5 = "origin"
            r12 = 1
            r4[r12] = r5     // Catch: java.lang.Throwable -> L8d android.database.sqlite.SQLiteException -> L91
            java.lang.String r5 = "set_timestamp"
            r13 = 2
            r4[r13] = r5     // Catch: java.lang.Throwable -> L8d android.database.sqlite.SQLiteException -> L91
            java.lang.String r5 = "value"
            r14 = 3
            r4[r14] = r5     // Catch: java.lang.Throwable -> L8d android.database.sqlite.SQLiteException -> L91
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[r12]     // Catch: java.lang.Throwable -> L8d android.database.sqlite.SQLiteException -> L91
            r6[r11] = r23     // Catch: java.lang.Throwable -> L8d android.database.sqlite.SQLiteException -> L91
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "1000"
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L8d android.database.sqlite.SQLiteException -> L91
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L8d android.database.sqlite.SQLiteException -> L91
            if (r2 != 0) goto L48
            if (r1 == 0) goto L47
            r1.close()
        L47:
            return r0
        L48:
            java.lang.String r18 = r1.getString(r11)     // Catch: java.lang.Throwable -> L8d android.database.sqlite.SQLiteException -> L91
            java.lang.String r2 = r1.getString(r12)     // Catch: java.lang.Throwable -> L8d android.database.sqlite.SQLiteException -> L91
            if (r2 != 0) goto L54
            java.lang.String r2 = ""
        L54:
            r17 = r2
            long r19 = r1.getLong(r13)     // Catch: java.lang.Throwable -> L8d android.database.sqlite.SQLiteException -> L91
            r2 = r22
            java.lang.Object r21 = r2.zza(r1, r14)     // Catch: android.database.sqlite.SQLiteException -> L8b java.lang.Throwable -> Laf
            if (r21 != 0) goto L74
            com.google.android.gms.measurement.internal.zzgo r3 = r22.zzj()     // Catch: android.database.sqlite.SQLiteException -> L8b java.lang.Throwable -> Laf
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch: android.database.sqlite.SQLiteException -> L8b java.lang.Throwable -> Laf
            java.lang.String r4 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgo.zza(r23)     // Catch: android.database.sqlite.SQLiteException -> L8b java.lang.Throwable -> Laf
            r3.zza(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> L8b java.lang.Throwable -> Laf
            goto L7f
        L74:
            com.google.android.gms.measurement.internal.zzpo r3 = new com.google.android.gms.measurement.internal.zzpo     // Catch: android.database.sqlite.SQLiteException -> L8b java.lang.Throwable -> Laf
            r15 = r3
            r16 = r23
            r15.<init>(r16, r17, r18, r19, r21)     // Catch: android.database.sqlite.SQLiteException -> L8b java.lang.Throwable -> Laf
            r0.add(r3)     // Catch: android.database.sqlite.SQLiteException -> L8b java.lang.Throwable -> Laf
        L7f:
            boolean r3 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L8b java.lang.Throwable -> Laf
            if (r3 != 0) goto L48
            if (r1 == 0) goto L8a
            r1.close()
        L8a:
            return r0
        L8b:
            r0 = move-exception
            goto L94
        L8d:
            r0 = move-exception
            r2 = r22
            goto Lb0
        L91:
            r0 = move-exception
            r2 = r22
        L94:
            com.google.android.gms.measurement.internal.zzgo r3 = r22.zzj()     // Catch: java.lang.Throwable -> Laf
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch: java.lang.Throwable -> Laf
            java.lang.String r4 = "Error querying user properties. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgo.zza(r23)     // Catch: java.lang.Throwable -> Laf
            r3.zza(r4, r5, r0)     // Catch: java.lang.Throwable -> Laf
            java.util.List r0 = java.util.Collections.emptyList()     // Catch: java.lang.Throwable -> Laf
            if (r1 == 0) goto Lae
            r1.close()
        Lae:
            return r0
        Laf:
            r0 = move-exception
        Lb0:
            if (r1 == 0) goto Lb5
            r1.close()
        Lb5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zzk(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a5, code lost:
    
        zzj().zzg().zza("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzpo> zzb(java.lang.String r23, java.lang.String r24, java.lang.String r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zzb(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    final Map<Integer, zzgf.zzm> zzl(String str) {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = f_().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, zzgf.zzm> mapEmptyMap = Collections.emptyMap();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return mapEmptyMap;
                }
                ArrayMap arrayMap = new ArrayMap();
                do {
                    int i = cursorQuery.getInt(0);
                    try {
                        arrayMap.put(Integer.valueOf(i), (zzgf.zzm) ((com.google.android.gms.internal.measurement.zzkg) ((zzgf.zzm.zza) zzpj.zza(zzgf.zzm.zze(), cursorQuery.getBlob(1))).zzaj()));
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter results. appId, audienceId, error", zzgo.zza(str), Integer.valueOf(i), e);
                    }
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filter results. appId", zzgo.zza(str), e2);
                Map<Integer, zzgf.zzm> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    final Map<Integer, List<zzfw.zzb>> zzm(String str) {
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = f_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<zzfw.zzb>> mapEmptyMap = Collections.emptyMap();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return mapEmptyMap;
                }
                do {
                    try {
                        zzfw.zzb zzbVar = (zzfw.zzb) ((com.google.android.gms.internal.measurement.zzkg) ((zzfw.zzb.zza) zzpj.zza(zzfw.zzb.zzc(), cursorQuery.getBlob(1))).zzaj());
                        if (zzbVar.zzk()) {
                            int i = cursorQuery.getInt(0);
                            List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayMap.put(Integer.valueOf(i), arrayList);
                            }
                            arrayList.add(zzbVar);
                        }
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter. appId", zzgo.zza(str), e);
                    }
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filters. appId", zzgo.zza(str), e2);
                Map<Integer, List<zzfw.zzb>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    final Map<Integer, List<zzfw.zzb>> zzf(String str, String str2) {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = f_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<zzfw.zzb>> mapEmptyMap = Collections.emptyMap();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return mapEmptyMap;
                }
                do {
                    try {
                        zzfw.zzb zzbVar = (zzfw.zzb) ((com.google.android.gms.internal.measurement.zzkg) ((zzfw.zzb.zza) zzpj.zza(zzfw.zzb.zzc(), cursorQuery.getBlob(1))).zzaj());
                        int i = cursorQuery.getInt(0);
                        List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), arrayList);
                        }
                        arrayList.add(zzbVar);
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter. appId", zzgo.zza(str), e);
                    }
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filters. appId", zzgo.zza(str), e2);
                Map<Integer, List<zzfw.zzb>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    final Map<Integer, List<zzfw.zze>> zzg(String str, String str2) {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = f_().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<zzfw.zze>> mapEmptyMap = Collections.emptyMap();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return mapEmptyMap;
                }
                do {
                    try {
                        zzfw.zze zzeVar = (zzfw.zze) ((com.google.android.gms.internal.measurement.zzkg) ((zzfw.zze.zza) zzpj.zza(zzfw.zze.zzc(), cursorQuery.getBlob(1))).zzaj());
                        int i = cursorQuery.getInt(0);
                        List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), arrayList);
                        }
                        arrayList.add(zzeVar);
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter", zzgo.zza(str), e);
                    }
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filters. appId", zzgo.zza(str), e2);
                Map<Integer, List<zzfw.zze>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    final Map<Integer, List<Integer>> zzn(String str) {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = f_().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
                if (!cursorRawQuery.moveToFirst()) {
                    Map<Integer, List<Integer>> mapEmptyMap = Collections.emptyMap();
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return mapEmptyMap;
                }
                do {
                    int i = cursorRawQuery.getInt(0);
                    List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        arrayMap.put(Integer.valueOf(i), arrayList);
                    }
                    arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                } while (cursorRawQuery.moveToNext());
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return arrayMap;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error querying scoped filters. appId", zzgo.zza(str), e);
                Map<Integer, List<Integer>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    zzar(zzou zzouVar) {
        super(zzouVar);
        this.zzn = new zzoh(zzb());
        this.zzm = new zzaz(this, zza(), "google_app_measurement.db");
    }

    public final void zza(String str, Long l, String str2, Bundle bundle) {
        zzax zzaxVar;
        zzgf.zzk zzkVarZzb;
        String str3 = str;
        Preconditions.checkNotNull(bundle);
        zzv();
        zzam();
        if (zze().zza(zzbn.zzcz) && l != null) {
            zzaxVar = new zzax(this, str3, l.longValue());
        } else {
            zzaxVar = new zzax(this, str3);
        }
        zzax zzaxVar2 = zzaxVar;
        List<zzav> listZza = zzaxVar2.zza();
        while (!listZza.isEmpty()) {
            for (zzav zzavVar : listZza) {
                if (!TextUtils.isEmpty(str2) && (zzkVarZzb = zzb(str3, zzavVar.zzb)) != null) {
                    Iterator<zzgf.zzp> it = zzkVarZzb.zzau().iterator();
                    while (it.hasNext()) {
                        if (it.next().zzg().equals(str2)) {
                            break;
                        }
                    }
                }
                zzpj zzpjVarH_ = h_();
                zzgf.zzf zzfVar = zzavVar.zzd;
                Bundle bundle2 = new Bundle();
                for (zzgf.zzh zzhVar : zzfVar.zzh()) {
                    if (zzhVar.zzj()) {
                        bundle2.putDouble(zzhVar.zzg(), zzhVar.zza());
                    } else if (zzhVar.zzk()) {
                        bundle2.putFloat(zzhVar.zzg(), zzhVar.zzb());
                    } else if (zzhVar.zzl()) {
                        bundle2.putLong(zzhVar.zzg(), zzhVar.zzd());
                    } else if (zzhVar.zzn()) {
                        bundle2.putString(zzhVar.zzg(), zzhVar.zzh());
                    } else if (!zzhVar.zzi().isEmpty()) {
                        bundle2.putParcelableArray(zzhVar.zzg(), zzpj.zzb(zzhVar.zzi()));
                    } else {
                        zzpjVarH_.zzj().zzg().zza("Unexpected parameter type for parameter", zzhVar);
                    }
                }
                String string = bundle2.getString("_o");
                bundle2.remove("_o");
                String strZzg = zzfVar.zzg();
                if (string == null) {
                    string = "";
                }
                zzgs zzgsVar = new zzgs(strZzg, string, bundle2, zzfVar.zzd());
                zzs().zza(zzgsVar.zzc, bundle);
                zza(zzavVar.zza, new zzbe(this.zzu, zzgsVar.zzb, str, zzavVar.zzd.zzg(), zzavVar.zzd.zzd(), zzavVar.zzd.zzc(), zzgsVar.zzc), zzavVar.zzb, zzavVar.zzc);
                str3 = str;
            }
            listZza = zzaxVar2.zza();
            str3 = str;
        }
    }

    public final void zzq() {
        zzam();
        f_().beginTransaction();
    }

    private final void zzj(String str, String str2) throws IllegalStateException {
        Preconditions.checkNotEmpty(str2);
        zzv();
        zzam();
        try {
            f_().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting snapshot. appId", zzgo.zza(str2), e);
        }
    }

    public final void zzo(String str) throws IllegalStateException {
        zzbh zzbhVarZzd;
        zzj("events_snapshot", str);
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = f_().query("events", (String[]) Collections.singletonList("name").toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                        return;
                    }
                    return;
                }
                do {
                    String string = cursorQuery.getString(0);
                    if (string != null && (zzbhVarZzd = zzd(str, string)) != null) {
                        zza("events_snapshot", zzbhVarZzd);
                    }
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error creating snapshot. appId", zzgo.zza(str), e);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public final void zza(Long l) throws IllegalStateException {
        zzv();
        zzam();
        Preconditions.checkNotNull(l);
        if (zze().zza(zzbn.zzch)) {
            try {
                if (f_().delete("upload_queue", "rowid=?", new String[]{String.valueOf(l)}) != 1) {
                    zzj().zzr().zza("Deleted fewer rows from upload_queue than expected");
                }
            } catch (SQLiteException e) {
                zzj().zzg().zza("Failed to delete a MeasurementBatch in a upload_queue table", e);
                throw e;
            }
        }
    }

    public final void zzr() {
        zzam();
        f_().endTransaction();
    }

    final void zza(List<Long> list) throws IllegalStateException, SQLException {
        zzv();
        zzam();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzab()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (zzb("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                zzj().zzr().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                f_().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error incrementing retry count. error", e);
            }
        }
    }

    final void zzb(Long l) throws IllegalStateException, SQLException {
        zzv();
        zzam();
        Preconditions.checkNotNull(l);
        if (zze().zza(zzbn.zzch) && zzab()) {
            if (zzb("SELECT COUNT(1) FROM upload_queue WHERE rowid = " + l + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                zzj().zzr().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                f_().execSQL("UPDATE upload_queue SET retry_count = retry_count + 1 WHERE rowid = " + l + " AND retry_count < 2147483647");
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error incrementing retry count. error", e);
            }
        }
    }

    final void zzw() {
        int iDelete;
        zzv();
        zzam();
        if (zzab()) {
            long jZza = zzo().zza.zza();
            long jElapsedRealtime = zzb().elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jZza) > zzai.zzo()) {
                zzo().zza.zza(jElapsedRealtime);
                zzv();
                zzam();
                if (!zzab() || (iDelete = f_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzb().currentTimeMillis()), String.valueOf(zzai.zzm())})) <= 0) {
                    return;
                }
                zzj().zzq().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
            }
        }
    }

    public final void zzh(String str, String str2) throws IllegalStateException {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzv();
        zzam();
        try {
            f_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting user property. appId", zzgo.zza(str), zzi().zzc(str2), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzp(java.lang.String r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zzp(java.lang.String):void");
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (obj instanceof Double) {
                contentValues.put(str, (Double) obj);
                return;
            }
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x020f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01e3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void zza(java.lang.String r18, java.util.List<com.google.android.gms.internal.measurement.zzfw.zza> r19) {
        /*
            Method dump skipped, instructions count: 587
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zza(java.lang.String, java.util.List):void");
    }

    public final void zzx() {
        zzam();
        f_().setTransactionSuccessful();
    }

    public final void zza(zzh zzhVar, boolean z, boolean z2) {
        Preconditions.checkNotNull(zzhVar);
        zzv();
        zzam();
        String strZzac = zzhVar.zzac();
        Preconditions.checkNotNull(strZzac);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", strZzac);
        if (z) {
            contentValues.put("app_instance_id", (String) null);
        } else if (this.zzg.zzb(strZzac).zza(zzjj.zza.ANALYTICS_STORAGE)) {
            contentValues.put("app_instance_id", zzhVar.zzad());
        }
        contentValues.put("gmp_app_id", zzhVar.zzah());
        if (this.zzg.zzb(strZzac).zza(zzjj.zza.AD_STORAGE)) {
            contentValues.put("resettable_device_id_hash", zzhVar.zzaj());
        }
        contentValues.put("last_bundle_index", Long.valueOf(zzhVar.zzt()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzhVar.zzu()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzhVar.zzs()));
        contentValues.put(App.JsonKeys.APP_VERSION, zzhVar.zzaf());
        contentValues.put("app_store", zzhVar.zzae());
        contentValues.put("gmp_version", Long.valueOf(zzhVar.zzq()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzhVar.zzn()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzhVar.zzar()));
        contentValues.put("day", Long.valueOf(zzhVar.zzm()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzhVar.zzk()));
        contentValues.put("daily_events_count", Long.valueOf(zzhVar.zzj()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzhVar.zzh()));
        contentValues.put("config_fetched_time", Long.valueOf(zzhVar.zzg()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzhVar.zzp()));
        contentValues.put("app_version_int", Long.valueOf(zzhVar.zze()));
        contentValues.put("firebase_instance_id", zzhVar.zzag());
        contentValues.put("daily_error_events_count", Long.valueOf(zzhVar.zzi()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzhVar.zzl()));
        contentValues.put("health_monitor_sample", zzhVar.zzai());
        contentValues.put("android_id", (Long) 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzhVar.zzaq()));
        contentValues.put("admob_app_id", zzhVar.zzaa());
        contentValues.put("dynamite_version", Long.valueOf(zzhVar.zzo()));
        if (this.zzg.zzb(strZzac).zza(zzjj.zza.ANALYTICS_STORAGE)) {
            contentValues.put("session_stitching_token", zzhVar.zzal());
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(zzhVar.zzat()));
        contentValues.put("target_os_version", Long.valueOf(zzhVar.zzw()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(zzhVar.zzv()));
        if (com.google.android.gms.internal.measurement.zzoy.zza() && zze().zze(strZzac, zzbn.zzcp)) {
            contentValues.put("ad_services_version", Integer.valueOf(zzhVar.zza()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(zzhVar.zzf()));
        }
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(zzhVar.zzau()));
        contentValues.put("npa_metadata_value", zzhVar.zzx());
        contentValues.put("bundle_delivery_index", Long.valueOf(zzhVar.zzr()));
        contentValues.put("sgtm_preview_key", zzhVar.zzam());
        contentValues.put("dma_consent_state", Integer.valueOf(zzhVar.zzd()));
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(zzhVar.zzc()));
        contentValues.put("serialized_npa_metadata", zzhVar.zzak());
        if (zze().zze(strZzac, zzbn.zzcj)) {
            contentValues.put("client_upload_eligibility", Integer.valueOf(zzhVar.zzb()));
        }
        List<String> listZzan = zzhVar.zzan();
        if (listZzan != null) {
            if (listZzan.isEmpty()) {
                zzj().zzr().zza("Safelisted events should not be an empty list. appId", strZzac);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", listZzan));
            }
        }
        if (com.google.android.gms.internal.measurement.zzog.zza() && zze().zza(zzbn.zzce) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        contentValues.put("unmatched_pfo", zzhVar.zzy());
        contentValues.put("unmatched_uwa", zzhVar.zzz());
        contentValues.put("ad_campaign_info", zzhVar.zzav());
        try {
            SQLiteDatabase sQLiteDatabaseF_ = f_();
            if (sQLiteDatabaseF_.update("apps", contentValues, "app_id = ?", new String[]{strZzac}) == 0 && sQLiteDatabaseF_.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update app (got -1). appId", zzgo.zza(strZzac));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing app. appId", zzgo.zza(strZzac), e);
        }
    }

    public final void zza(String str, zzbd zzbdVar) throws IllegalStateException {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzbdVar);
        zzv();
        zzam();
        if (zzh(str) == zzjj.zza) {
            zzb(str, zzjj.zza);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", zzbdVar.zzf());
        zza("consent_settings", "app_id", contentValues);
    }

    public final void zza(zzbh zzbhVar) throws IllegalStateException {
        zza("events", zzbhVar);
    }

    private final void zza(String str, zzbh zzbhVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzbhVar);
        zzv();
        zzam();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbhVar.zza);
        contentValues.put("name", zzbhVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzbhVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzbhVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzbhVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzbhVar.zzg));
        contentValues.put("last_bundled_day", zzbhVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzbhVar.zzi);
        contentValues.put("last_sampling_rate", zzbhVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzbhVar.zze));
        contentValues.put("last_exempt_from_sampling", (zzbhVar.zzk == null || !zzbhVar.zzk.booleanValue()) ? null : 1L);
        try {
            if (f_().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update event aggregates (got -1). appId", zzgo.zza(zzbhVar.zza));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing event aggregates. appId", zzgo.zza(zzbhVar.zza), e);
        }
    }

    private final void zza(String str, String str2, ContentValues contentValues) throws IllegalStateException {
        try {
            SQLiteDatabase sQLiteDatabaseF_ = f_();
            if (contentValues.getAsString(str2) == null) {
                zzj().zzm().zza("Value of the primary key is not set.", zzgo.zza(str2));
            } else if (sQLiteDatabaseF_.update(str, contentValues, str2 + " = ?", new String[]{r1}) == 0 && sQLiteDatabaseF_.insertWithOnConflict(str, null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update table (got -1). key", zzgo.zza(str), zzgo.zza(str2));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing into table. key", zzgo.zza(str), zzgo.zza(str2), e);
        }
    }

    public final void zza(String str, zzjj zzjjVar) throws IllegalStateException {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjjVar);
        zzv();
        zzam();
        zzb(str, zzh(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", zzjjVar.zzf());
        zza("consent_settings", "app_id", contentValues);
    }

    public final void zzb(String str, zzjj zzjjVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjjVar);
        zzv();
        zzam();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzjjVar.zzf());
        contentValues.put("consent_source", Integer.valueOf(zzjjVar.zza()));
        zza("consent_settings", "app_id", contentValues);
    }

    private final boolean zzb(String str, List<Integer> list) throws IllegalStateException {
        Preconditions.checkNotEmpty(str);
        zzam();
        zzv();
        SQLiteDatabase sQLiteDatabaseF_ = f_();
        try {
            long jZzb = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int iMax = Math.max(0, Math.min(2000, zze().zzb(str, zzbn.zzap)));
            if (jZzb <= iMax) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            return sQLiteDatabaseF_.delete("audience_filter_values", new StringBuilder("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ").append(new StringBuilder("(").append(TextUtils.join(",", arrayList)).append(")").toString()).append(" order by rowid desc limit -1 offset ?)").toString(), new String[]{str, Integer.toString(iMax)}) > 0;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Database error querying filters. appId", zzgo.zza(str), e);
            return false;
        }
    }

    public final boolean zzq(String str) {
        if (!zze().zza(zzbn.zzch)) {
            return false;
        }
        if (!zze().zza(zzbn.zzcj)) {
            return zzb(new StringBuilder("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=? AND NOT ").append(zzap()).toString(), new String[]{str}) != 0;
        }
        zzlu[] zzluVarArr = {zzlu.GOOGLE_SIGNAL};
        ArrayList arrayList = new ArrayList(1);
        for (int i = 0; i <= 0; i++) {
            arrayList.add(Integer.valueOf(zzluVarArr[0].zza()));
        }
        return zzb(new StringBuilder("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?").append(zzb(arrayList)).append(" AND NOT ").append(zzap()).toString(), new String[]{str}) != 0;
    }

    public final boolean zzi(String str, String str2) {
        return zzb("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0;
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzz() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    public final boolean zzaa() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final boolean zza(zzgf.zzk zzkVar, boolean z) throws IllegalStateException {
        zzv();
        zzam();
        Preconditions.checkNotNull(zzkVar);
        Preconditions.checkNotEmpty(zzkVar.zzab());
        Preconditions.checkState(zzkVar.zzbm());
        zzw();
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        if (zzkVar.zzn() < jCurrentTimeMillis - zzai.zzm() || zzkVar.zzn() > zzai.zzm() + jCurrentTimeMillis) {
            zzj().zzr().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzgo.zza(zzkVar.zzab()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzkVar.zzn()));
        }
        try {
            byte[] bArrZzb = h_().zzb(zzkVar.zzce());
            zzj().zzq().zza("Saving bundle, size", Integer.valueOf(bArrZzb.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzkVar.zzab());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzkVar.zzn()));
            contentValues.put("data", bArrZzb);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzkVar.zzbt()) {
                contentValues.put("retry_count", Integer.valueOf(zzkVar.zzg()));
            }
            try {
                if (f_().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzj().zzg().zza("Failed to insert bundle (got -1). appId", zzgo.zza(zzkVar.zzab()));
                return false;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error storing bundle. appId", zzgo.zza(zzkVar.zzab()), e);
                return false;
            }
        } catch (IOException e2) {
            zzj().zzg().zza("Data loss. Failed to serialize bundle. appId", zzgo.zza(zzkVar.zzab()), e2);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzfw.zzb zzbVar) throws IllegalStateException {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbVar);
        if (zzbVar.zzf().isEmpty()) {
            zzj().zzr().zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzgo.zza(str), Integer.valueOf(i), String.valueOf(zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null));
            return false;
        }
        byte[] bArrZzce = zzbVar.zzce();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null);
        contentValues.put("event_name", zzbVar.zzf());
        contentValues.put("session_scoped", zzbVar.zzm() ? Boolean.valueOf(zzbVar.zzj()) : null);
        contentValues.put("data", bArrZzce);
        try {
            if (f_().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert event filter (got -1). appId", zzgo.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing event filter. appId", zzgo.zza(str), e);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzfw.zze zzeVar) throws IllegalStateException {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeVar);
        if (zzeVar.zze().isEmpty()) {
            zzj().zzr().zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzgo.zza(str), Integer.valueOf(i), String.valueOf(zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null));
            return false;
        }
        byte[] bArrZzce = zzeVar.zzce();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null);
        contentValues.put("property_name", zzeVar.zze());
        contentValues.put("session_scoped", zzeVar.zzj() ? Boolean.valueOf(zzeVar.zzh()) : null);
        contentValues.put("data", bArrZzce);
        try {
            if (f_().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert property filter (got -1). appId", zzgo.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing property filter. appId", zzgo.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzbe zzbeVar, long j, boolean z) throws IllegalStateException {
        zzv();
        zzam();
        Preconditions.checkNotNull(zzbeVar);
        Preconditions.checkNotEmpty(zzbeVar.zza);
        byte[] bArrZzce = h_().zza(zzbeVar).zzce();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbeVar.zza);
        contentValues.put("name", zzbeVar.zzb);
        contentValues.put("timestamp", Long.valueOf(zzbeVar.zzd));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", bArrZzce);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (f_().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert raw event (got -1). appId", zzgo.zza(zzbeVar.zza));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing raw event. appId", zzgo.zza(zzbeVar.zza), e);
            return false;
        }
    }

    public final boolean zza(String str, zzog zzogVar) throws IllegalStateException {
        zzv();
        zzam();
        Preconditions.checkNotNull(zzogVar);
        Preconditions.checkNotEmpty(str);
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        if (zzogVar.zzb < jCurrentTimeMillis - zzbn.zzbp.zza(null).longValue() || zzogVar.zzb > zzbn.zzbp.zza(null).longValue() + jCurrentTimeMillis) {
            zzj().zzr().zza("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzgo.zza(str), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzogVar.zzb));
        }
        zzj().zzq().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzogVar.zza);
        contentValues.put("source", Integer.valueOf(zzogVar.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(zzogVar.zzb));
        try {
            if (f_().insert("trigger_uris", null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert trigger URI (got -1). appId", zzgo.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing trigger URI. appId", zzgo.zza(str), e);
            return false;
        }
    }

    protected final boolean zzab() {
        return zza().getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean zza(String str, Long l, long j, zzgf.zzf zzfVar) throws IllegalStateException {
        zzv();
        zzam();
        Preconditions.checkNotNull(zzfVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] bArrZzce = zzfVar.zzce();
        zzj().zzq().zza("Saving complex main event, appId, data size", zzi().zza(str), Integer.valueOf(bArrZzce.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", bArrZzce);
        try {
            if (f_().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert complex main event (got -1). appId", zzgo.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing complex main event. appId", zzgo.zza(str), e);
            return false;
        }
    }

    final boolean zza(String str, long j) throws IllegalStateException {
        if (!zze().zza(zzbn.zzcz) && zzb().currentTimeMillis() > 15000 + j) {
            return false;
        }
        try {
            if (zza("select count(*) from raw_events where app_id=? and timestamp >= ? and name not like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j)}, 0L) > 0) {
                return false;
            }
            return zza("select count(*) from raw_events where app_id=? and timestamp >= ? and name like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j)}, 0L) > 0;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error checking backfill conditions", e);
            return false;
        }
    }

    public final boolean zza(zzag zzagVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzagVar);
        zzv();
        zzam();
        String str = zzagVar.zza;
        Preconditions.checkNotNull(str);
        if (zze(str, zzagVar.zzc.zza) == null && zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzagVar.zzb);
        contentValues.put("name", zzagVar.zzc.zza);
        zza(contentValues, "value", Preconditions.checkNotNull(zzagVar.zzc.zza()));
        contentValues.put("active", Boolean.valueOf(zzagVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzagVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzagVar.zzh));
        zzs();
        contentValues.put("timed_out_event", zzpn.zza((Parcelable) zzagVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzagVar.zzd));
        zzs();
        contentValues.put("triggered_event", zzpn.zza((Parcelable) zzagVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzagVar.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzagVar.zzj));
        zzs();
        contentValues.put("expired_event", zzpn.zza((Parcelable) zzagVar.zzk));
        try {
            if (f_().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update conditional user property (got -1)", zzgo.zza(str));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing conditional user property", zzgo.zza(str), e);
        }
        return true;
    }

    final boolean zza(String str, Bundle bundle) {
        zzv();
        zzam();
        byte[] bArrZzce = h_().zza(new zzbe(this.zzu, "", str, "dep", 0L, 0L, bundle)).zzce();
        zzj().zzq().zza("Saving default event parameters, appId, data size", zzi().zza(str), Integer.valueOf(bArrZzce.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", bArrZzce);
        try {
            if (f_().insertWithOnConflict("default_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert default event parameters (got -1). appId", zzgo.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing default event parameters. appId", zzgo.zza(str), e);
            return false;
        }
    }

    private final boolean zza(long j, zzbe zzbeVar, long j2, boolean z) throws IllegalStateException {
        zzv();
        zzam();
        Preconditions.checkNotNull(zzbeVar);
        Preconditions.checkNotEmpty(zzbeVar.zza);
        byte[] bArrZzce = h_().zza(zzbeVar).zzce();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbeVar.zza);
        contentValues.put("name", zzbeVar.zzb);
        contentValues.put("timestamp", Long.valueOf(zzbeVar.zzd));
        contentValues.put("metadata_fingerprint", Long.valueOf(j2));
        contentValues.put("data", bArrZzce);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            long jUpdate = f_().update("raw_events", contentValues, "rowid = ?", new String[]{String.valueOf(j)});
            if (jUpdate == 1) {
                return true;
            }
            zzj().zzg().zza("Failed to update raw event. appId, updatedRows", zzgo.zza(zzbeVar.zza), Long.valueOf(jUpdate));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error updating raw event. appId", zzgo.zza(zzbeVar.zza), e);
            return false;
        }
    }

    public final boolean zza(zzpo zzpoVar) {
        Preconditions.checkNotNull(zzpoVar);
        zzv();
        zzam();
        if (zze(zzpoVar.zza, zzpoVar.zzc) == null) {
            if (zzpn.zzg(zzpoVar.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzpoVar.zza}) >= zze().zza(zzpoVar.zza, zzbn.zzaq, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(zzpoVar.zzc) && zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzpoVar.zza, zzpoVar.zzb}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzpoVar.zza);
        contentValues.put("origin", zzpoVar.zzb);
        contentValues.put("name", zzpoVar.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzpoVar.zzd));
        zza(contentValues, "value", zzpoVar.zze);
        try {
            if (f_().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update user property (got -1). appId", zzgo.zza(zzpoVar.zza));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing user property. appId", zzgo.zza(zzpoVar.zza), e);
        }
        return true;
    }
}

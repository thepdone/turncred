package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [FieldDescriptorT] */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zzmi<FieldDescriptorT> extends zzmj<FieldDescriptorT, Object> {
    zzmi() {
        super();
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final void zza() {
        if (!zze()) {
            for (int i = 0; i < zzb(); i++) {
                Map.Entry<FieldDescriptorT, Object> entryZza = zza(i);
                if (((zzjy) entryZza.getKey()).zze()) {
                    entryZza.setValue(Collections.unmodifiableList((List) entryZza.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorT, Object> entry : zzc()) {
                if (((zzjy) entry.getKey()).zze()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}

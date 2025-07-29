package com.google.android.gms.internal.measurement;

import androidx.camera.video.AudioStats;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzab extends zzal {
    @Override // com.google.android.gms.internal.measurement.zzal
    public final zzaq zza(zzh zzhVar, List<zzaq> list) {
        return new zzai(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
    }

    zzab(zzy zzyVar, String str) {
        super(str);
    }
}

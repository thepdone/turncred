package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzcz extends zzda {
    @Override // com.google.android.gms.internal.measurement.zzda
    public final URLConnection zza(URL url, String str) throws IOException {
        return url.openConnection();
    }

    private zzcz() {
    }
}

package com.google.firebase.analytics;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzed;

/* compiled from: com.google.android.gms:play-services-measurement-api@@22.2.0 */
/* loaded from: classes3.dex */
public class GoogleAnalyticsServerPreviewActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zzed.zza(this).zza(getIntent());
        finish();
    }
}

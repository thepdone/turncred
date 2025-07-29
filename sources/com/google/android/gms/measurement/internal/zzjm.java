package com.google.android.gms.measurement.internal;

import expo.modules.interfaces.permissions.PermissionsResponse;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public enum zzjm {
    UNINITIALIZED("uninitialized"),
    POLICY("eu_consent_policy"),
    DENIED("denied"),
    GRANTED(PermissionsResponse.GRANTED_KEY);

    private final String zzf;

    @Override // java.lang.Enum
    public final String toString() {
        return this.zzf;
    }

    zzjm(String str) {
        this.zzf = str;
    }
}

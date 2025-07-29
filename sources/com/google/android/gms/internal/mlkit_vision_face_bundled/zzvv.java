package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.io.IOException;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public class zzvv extends IOException {
    private zzws zza;

    public zzvv(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.zza = null;
    }

    static zzvu zza() {
        return new zzvu("Protocol message tag had invalid wire type.");
    }

    static zzvv zzb() {
        return new zzvv("Protocol message contained an invalid tag (zero).");
    }

    static zzvv zzc() {
        return new zzvv("Protocol message had invalid UTF-8.");
    }

    static zzvv zzd() {
        return new zzvv("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzvv zze() {
        return new zzvv("Failed to parse the message.");
    }

    static zzvv zzg() {
        return new zzvv("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final zzvv zzf(zzws zzwsVar) {
        this.zza = zzwsVar;
        return this;
    }

    public zzvv(String str) {
        super(str);
        this.zza = null;
    }
}

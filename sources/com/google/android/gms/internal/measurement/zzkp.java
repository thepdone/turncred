package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
public class zzkp extends IOException {
    static zzko zza() {
        return new zzko("Protocol message tag had invalid wire type.");
    }

    static zzkp zzb() {
        return new zzkp("Protocol message end-group tag did not match expected tag.");
    }

    static zzkp zzc() {
        return new zzkp("Protocol message contained an invalid tag (zero).");
    }

    static zzkp zzd() {
        return new zzkp("Protocol message had invalid UTF-8.");
    }

    static zzkp zze() {
        return new zzkp("CodedInputStream encountered a malformed varint.");
    }

    static zzkp zzf() {
        return new zzkp("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzkp zzg() {
        return new zzkp("Failed to parse the message.");
    }

    static zzkp zzh() {
        return new zzkp("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    static zzkp zzi() {
        return new zzkp("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public zzkp(String str) {
        super(str);
    }
}

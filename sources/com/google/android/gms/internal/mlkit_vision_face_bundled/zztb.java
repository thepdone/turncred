package com.google.android.gms.internal.mlkit_vision_face_bundled;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zztb implements zzsm {
    private Provider zza;
    private final Provider zzb;
    private final zzso zzc;

    public zztb(Context context, zzso zzsoVar) {
        this.zzc = zzsoVar;
        CCTDestination cCTDestination = CCTDestination.INSTANCE;
        TransportRuntime.initialize(context);
        final TransportFactory transportFactoryNewFactory = TransportRuntime.getInstance().newFactory(cCTDestination);
        if (cCTDestination.getSupportedEncodings().contains(Encoding.of("json"))) {
            this.zza = new Lazy(new Provider() { // from class: com.google.android.gms.internal.mlkit_vision_face_bundled.zzsy
                @Override // com.google.firebase.inject.Provider
                public final Object get() {
                    return transportFactoryNewFactory.getTransport("FIREBASE_ML_SDK", byte[].class, Encoding.of("json"), new Transformer() { // from class: com.google.android.gms.internal.mlkit_vision_face_bundled.zzta
                        @Override // com.google.android.datatransport.Transformer
                        public final Object apply(Object obj) {
                            return (byte[]) obj;
                        }
                    });
                }
            });
        }
        this.zzb = new Lazy(new Provider() { // from class: com.google.android.gms.internal.mlkit_vision_face_bundled.zzsz
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return transportFactoryNewFactory.getTransport("FIREBASE_ML_SDK", byte[].class, Encoding.of("proto"), new Transformer() { // from class: com.google.android.gms.internal.mlkit_vision_face_bundled.zzsx
                    @Override // com.google.android.datatransport.Transformer
                    public final Object apply(Object obj) {
                        return (byte[]) obj;
                    }
                });
            }
        });
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzsm
    public final void zza(zzsl zzslVar) {
        if (this.zzc.zza() != 0) {
            ((Transport) this.zzb.get()).send(zzb(this.zzc, zzslVar));
            return;
        }
        Provider provider = this.zza;
        if (provider != null) {
            ((Transport) provider.get()).send(zzb(this.zzc, zzslVar));
        }
    }

    static Event zzb(zzso zzsoVar, zzsl zzslVar) {
        int iZza = zzsoVar.zza();
        return zzslVar.zza() != 0 ? Event.ofData(zzslVar.zze(iZza, false)) : Event.ofTelemetry(zzslVar.zze(iZza, false));
    }
}

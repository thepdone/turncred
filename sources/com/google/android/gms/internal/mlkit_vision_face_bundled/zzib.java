package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import io.sentry.protocol.Device;
import java.io.IOException;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzib implements ObjectEncoder {
    static final zzib zza = new zzib();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;
    private static final FieldDescriptor zzi;
    private static final FieldDescriptor zzj;
    private static final FieldDescriptor zzk;
    private static final FieldDescriptor zzl;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("status");
        zzbx zzbxVar = new zzbx();
        zzbxVar.zza(1);
        zzb = builder.withProperty(zzbxVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        zzbx zzbxVar2 = new zzbx();
        zzbxVar2.zza(2);
        zzc = builder2.withProperty(zzbxVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("model");
        zzbx zzbxVar3 = new zzbx();
        zzbxVar3.zza(3);
        zzd = builder3.withProperty(zzbxVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder(Device.JsonKeys.LANGUAGE);
        zzbx zzbxVar4 = new zzbx();
        zzbxVar4.zza(4);
        zze = builder4.withProperty(zzbxVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("segmentationRequest");
        zzbx zzbxVar5 = new zzbx();
        zzbxVar5.zza(5);
        zzf = builder5.withProperty(zzbxVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("segmentationResult");
        zzbx zzbxVar6 = new zzbx();
        zzbxVar6.zza(6);
        zzg = builder6.withProperty(zzbxVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("aggregatedSegmentations");
        zzbx zzbxVar7 = new zzbx();
        zzbxVar7.zza(7);
        zzh = builder7.withProperty(zzbxVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("durationMs");
        zzbx zzbxVar8 = new zzbx();
        zzbxVar8.zza(8);
        zzi = builder8.withProperty(zzbxVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("nativeSegmentationException");
        zzbx zzbxVar9 = new zzbx();
        zzbxVar9.zza(9);
        zzj = builder9.withProperty(zzbxVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("downloadErrorCodes");
        zzbx zzbxVar10 = new zzbx();
        zzbxVar10.zza(10);
        zzk = builder10.withProperty(zzbxVar10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("domain");
        zzbx zzbxVar11 = new zzbx();
        zzbxVar11.zza(11);
        zzl = builder11.withProperty(zzbxVar11.zzb()).build();
    }

    private zzib() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}

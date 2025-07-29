package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzkk implements ObjectEncoder {
    static final zzkk zza = new zzkk();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("inferenceCommonLogEvent");
        zzbx zzbxVar = new zzbx();
        zzbxVar.zza(1);
        zzb = builder.withProperty(zzbxVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("imageInfo");
        zzbx zzbxVar2 = new zzbx();
        zzbxVar2.zza(2);
        zzc = builder2.withProperty(zzbxVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("subjectSegmenterOptions");
        zzbx zzbxVar3 = new zzbx();
        zzbxVar3.zza(3);
        zzd = builder3.withProperty(zzbxVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("subjectInfos");
        zzbx zzbxVar4 = new zzbx();
        zzbxVar4.zza(4);
        zze = builder4.withProperty(zzbxVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("qualityScores");
        zzbx zzbxVar5 = new zzbx();
        zzbxVar5.zza(5);
        zzf = builder5.withProperty(zzbxVar5.zzb()).build();
    }

    private zzkk() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}

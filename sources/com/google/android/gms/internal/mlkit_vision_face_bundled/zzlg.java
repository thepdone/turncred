package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzlg implements ObjectEncoder {
    static final zzlg zza = new zzlg();
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
    private static final FieldDescriptor zzm;
    private static final FieldDescriptor zzn;
    private static final FieldDescriptor zzo;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("appId");
        zzbx zzbxVar = new zzbx();
        zzbxVar.zza(1);
        zzb = builder.withProperty(zzbxVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("appVersion");
        zzbx zzbxVar2 = new zzbx();
        zzbxVar2.zza(2);
        zzc = builder2.withProperty(zzbxVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("firebaseProjectId");
        zzbx zzbxVar3 = new zzbx();
        zzbxVar3.zza(3);
        zzd = builder3.withProperty(zzbxVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("mlSdkVersion");
        zzbx zzbxVar4 = new zzbx();
        zzbxVar4.zza(4);
        zze = builder4.withProperty(zzbxVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("tfliteSchemaVersion");
        zzbx zzbxVar5 = new zzbx();
        zzbxVar5.zza(5);
        zzf = builder5.withProperty(zzbxVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("gcmSenderId");
        zzbx zzbxVar6 = new zzbx();
        zzbxVar6.zza(6);
        zzg = builder6.withProperty(zzbxVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("apiKey");
        zzbx zzbxVar7 = new zzbx();
        zzbxVar7.zza(7);
        zzh = builder7.withProperty(zzbxVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("languages");
        zzbx zzbxVar8 = new zzbx();
        zzbxVar8.zza(8);
        zzi = builder8.withProperty(zzbxVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("mlSdkInstanceId");
        zzbx zzbxVar9 = new zzbx();
        zzbxVar9.zza(9);
        zzj = builder9.withProperty(zzbxVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isClearcutClient");
        zzbx zzbxVar10 = new zzbx();
        zzbxVar10.zza(10);
        zzk = builder10.withProperty(zzbxVar10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("isStandaloneMlkit");
        zzbx zzbxVar11 = new zzbx();
        zzbxVar11.zza(11);
        zzl = builder11.withProperty(zzbxVar11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("isJsonLogging");
        zzbx zzbxVar12 = new zzbx();
        zzbxVar12.zza(12);
        zzm = builder12.withProperty(zzbxVar12.zzb()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("buildLevel");
        zzbx zzbxVar13 = new zzbx();
        zzbxVar13.zza(13);
        zzn = builder13.withProperty(zzbxVar13.zzb()).build();
        FieldDescriptor.Builder builder14 = FieldDescriptor.builder("optionalModuleVersion");
        zzbx zzbxVar14 = new zzbx();
        zzbxVar14.zza(14);
        zzo = builder14.withProperty(zzbxVar14.zzb()).build();
    }

    private zzlg() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzrn zzrnVar = (zzrn) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzrnVar.zzg());
        objectEncoderContext2.add(zzc, zzrnVar.zzh());
        objectEncoderContext2.add(zzd, (Object) null);
        objectEncoderContext2.add(zze, zzrnVar.zzj());
        objectEncoderContext2.add(zzf, zzrnVar.zzk());
        objectEncoderContext2.add(zzg, (Object) null);
        objectEncoderContext2.add(zzh, (Object) null);
        objectEncoderContext2.add(zzi, zzrnVar.zza());
        objectEncoderContext2.add(zzj, zzrnVar.zzi());
        objectEncoderContext2.add(zzk, zzrnVar.zzb());
        objectEncoderContext2.add(zzl, zzrnVar.zzd());
        objectEncoderContext2.add(zzm, zzrnVar.zzc());
        objectEncoderContext2.add(zzn, zzrnVar.zze());
        objectEncoderContext2.add(zzo, zzrnVar.zzf());
    }
}

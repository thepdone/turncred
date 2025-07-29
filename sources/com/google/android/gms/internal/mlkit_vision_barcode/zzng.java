package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.1 */
/* loaded from: classes3.dex */
final class zzng implements ObjectEncoder {
    static final zzng zza = new zzng();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("inferenceCommonLogEvent");
        zzfa zzfaVar = new zzfa();
        zzfaVar.zza(1);
        builder.withProperty(zzfaVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("imageInfo");
        zzfa zzfaVar2 = new zzfa();
        zzfaVar2.zza(2);
        builder2.withProperty(zzfaVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("detectorOptions");
        zzfa zzfaVar3 = new zzfa();
        zzfaVar3.zza(3);
        builder3.withProperty(zzfaVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("loadDurationMs");
        zzfa zzfaVar4 = new zzfa();
        zzfaVar4.zza(4);
        builder4.withProperty(zzfaVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("sessionDurationMs");
        zzfa zzfaVar5 = new zzfa();
        zzfaVar5.zza(5);
        builder5.withProperty(zzfaVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("sessionTotalInferenceDurationMs");
        zzfa zzfaVar6 = new zzfa();
        zzfaVar6.zza(6);
        builder6.withProperty(zzfaVar6.zzb()).build();
    }

    private zzng() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}

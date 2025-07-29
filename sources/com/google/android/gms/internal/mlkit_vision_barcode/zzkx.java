package com.google.android.gms.internal.mlkit_vision_barcode;

import com.facebook.share.internal.ShareConstants;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.microsoft.codepush.react.CodePushConstants;
import io.sentry.rrweb.RRWebVideoEvent;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.1 */
/* loaded from: classes3.dex */
final class zzkx implements ObjectEncoder {
    static final zzkx zza = new zzkx();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("name");
        zzfa zzfaVar = new zzfa();
        zzfaVar.zza(1);
        builder.withProperty(zzfaVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("version");
        zzfa zzfaVar2 = new zzfa();
        zzfaVar2.zza(2);
        builder2.withProperty(zzfaVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("source");
        zzfa zzfaVar3 = new zzfa();
        zzfaVar3.zza(3);
        builder3.withProperty(zzfaVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder(ShareConstants.MEDIA_URI);
        zzfa zzfaVar4 = new zzfa();
        zzfaVar4.zza(4);
        builder4.withProperty(zzfaVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder(CodePushConstants.PENDING_UPDATE_HASH_KEY);
        zzfa zzfaVar5 = new zzfa();
        zzfaVar5.zza(5);
        builder5.withProperty(zzfaVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("modelType");
        zzfa zzfaVar6 = new zzfa();
        zzfaVar6.zza(6);
        builder6.withProperty(zzfaVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder(RRWebVideoEvent.JsonKeys.SIZE);
        zzfa zzfaVar7 = new zzfa();
        zzfaVar7.zza(7);
        builder7.withProperty(zzfaVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("hasLabelMap");
        zzfa zzfaVar8 = new zzfa();
        zzfaVar8.zza(8);
        builder8.withProperty(zzfaVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("isManifestModel");
        zzfa zzfaVar9 = new zzfa();
        zzfaVar9.zza(9);
        builder9.withProperty(zzfaVar9.zzb()).build();
    }

    private zzkx() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}

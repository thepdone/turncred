package com.google.android.gms.internal.measurement;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
public class zzng {
    public static final zzng zza;
    public static final zzng zzb;
    public static final zzng zzc;
    public static final zzng zzd;
    public static final zzng zze;
    public static final zzng zzf;
    public static final zzng zzg;
    public static final zzng zzh;
    public static final zzng zzi;
    public static final zzng zzj;
    public static final zzng zzk;
    public static final zzng zzl;
    public static final zzng zzm;
    public static final zzng zzn;
    public static final zzng zzo;
    public static final zzng zzp;
    public static final zzng zzq;
    public static final zzng zzr;
    private static final /* synthetic */ zzng[] zzs;
    private final zznj zzt;
    private final int zzu;

    public final int zza() {
        return this.zzu;
    }

    public final zznj zzb() {
        return this.zzt;
    }

    static {
        zzng zzngVar = new zzng("DOUBLE", 0, zznj.DOUBLE, 1);
        zza = zzngVar;
        zzng zzngVar2 = new zzng("FLOAT", 1, zznj.FLOAT, 5);
        zzb = zzngVar2;
        zzng zzngVar3 = new zzng("INT64", 2, zznj.LONG, 0);
        zzc = zzngVar3;
        zzng zzngVar4 = new zzng("UINT64", 3, zznj.LONG, 0);
        zzd = zzngVar4;
        zzng zzngVar5 = new zzng("INT32", 4, zznj.INT, 0);
        zze = zzngVar5;
        zzng zzngVar6 = new zzng("FIXED64", 5, zznj.LONG, 1);
        zzf = zzngVar6;
        zzng zzngVar7 = new zzng("FIXED32", 6, zznj.INT, 5);
        zzg = zzngVar7;
        zzng zzngVar8 = new zzng("BOOL", 7, zznj.BOOLEAN, 0);
        zzh = zzngVar8;
        int i = 2;
        zznm zznmVar = null;
        zznf zznfVar = new zznf("STRING", zznj.STRING);
        zzi = zznfVar;
        zzni zzniVar = new zzni("GROUP", zznj.MESSAGE);
        zzj = zzniVar;
        zznh zznhVar = new zznh("MESSAGE", zznj.MESSAGE);
        zzk = zznhVar;
        zznk zznkVar = new zznk("BYTES", zznj.BYTE_STRING);
        zzl = zznkVar;
        zzng zzngVar9 = new zzng("UINT32", 12, zznj.INT, 0);
        zzm = zzngVar9;
        zzng zzngVar10 = new zzng("ENUM", 13, zznj.ENUM, 0);
        zzn = zzngVar10;
        zzng zzngVar11 = new zzng("SFIXED32", 14, zznj.INT, 5);
        zzo = zzngVar11;
        zzng zzngVar12 = new zzng("SFIXED64", 15, zznj.LONG, 1);
        zzp = zzngVar12;
        zzng zzngVar13 = new zzng("SINT32", 16, zznj.INT, 0);
        zzq = zzngVar13;
        zzng zzngVar14 = new zzng("SINT64", 17, zznj.LONG, 0);
        zzr = zzngVar14;
        zzs = new zzng[]{zzngVar, zzngVar2, zzngVar3, zzngVar4, zzngVar5, zzngVar6, zzngVar7, zzngVar8, zznfVar, zzniVar, zznhVar, zznkVar, zzngVar9, zzngVar10, zzngVar11, zzngVar12, zzngVar13, zzngVar14};
    }

    private zzng(String str, int i, zznj zznjVar, int i2) {
        this.zzt = zznjVar;
        this.zzu = i2;
    }

    public static zzng[] values() {
        return (zzng[]) zzs.clone();
    }
}

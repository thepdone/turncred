package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.soloader.Elf64;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
public abstract class zzdo extends zzbx implements zzdl {
    public static zzdl asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        if (iInterfaceQueryLocalInterface instanceof zzdl) {
            return (zzdl) iInterfaceQueryLocalInterface;
        }
        return new zzdn(iBinder);
    }

    public zzdo() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbx
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzdq zzdsVar;
        zzdq zzdqVar;
        zzdq zzdsVar2 = null;
        zzdr zzdtVar = null;
        zzdq zzdsVar3 = null;
        zzdq zzdsVar4 = null;
        zzdq zzdsVar5 = null;
        zzdq zzdsVar6 = null;
        zzdw zzdyVar = null;
        zzdw zzdyVar2 = null;
        zzdw zzdyVar3 = null;
        zzdq zzdsVar7 = null;
        zzdq zzdsVar8 = null;
        zzdq zzdsVar9 = null;
        zzdq zzdsVar10 = null;
        zzdq zzdsVar11 = null;
        zzdq zzdsVar12 = null;
        zzdx zzeaVar = null;
        zzdq zzdsVar13 = null;
        zzdq zzdsVar14 = null;
        zzdq zzdsVar15 = null;
        zzdq zzdsVar16 = null;
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzdz zzdzVar = (zzdz) zzbw.zza(parcel, zzdz.CREATOR);
                long j = parcel.readLong();
                zzbw.zzb(parcel);
                initialize(iObjectWrapperAsInterface, zzdzVar, j);
                break;
            case 2:
                String string = parcel.readString();
                String string2 = parcel.readString();
                Bundle bundle = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                boolean zZzc = zzbw.zzc(parcel);
                boolean zZzc2 = zzbw.zzc(parcel);
                long j2 = parcel.readLong();
                zzbw.zzb(parcel);
                logEvent(string, string2, bundle, zZzc, zZzc2, j2);
                break;
            case 3:
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                Bundle bundle2 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzdqVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface instanceof zzdq) {
                        zzdsVar = (zzdq) iInterfaceQueryLocalInterface;
                    } else {
                        zzdsVar = new zzds(strongBinder);
                    }
                    zzdqVar = zzdsVar;
                }
                long j3 = parcel.readLong();
                zzbw.zzb(parcel);
                logEventAndBundle(string3, string4, bundle2, zzdqVar, j3);
                break;
            case 4:
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                boolean zZzc3 = zzbw.zzc(parcel);
                long j4 = parcel.readLong();
                zzbw.zzb(parcel);
                setUserProperty(string5, string6, iObjectWrapperAsInterface2, zZzc3, j4);
                break;
            case 5:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                boolean zZzc4 = zzbw.zzc(parcel);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface2 instanceof zzdq) {
                        zzdsVar2 = (zzdq) iInterfaceQueryLocalInterface2;
                    } else {
                        zzdsVar2 = new zzds(strongBinder2);
                    }
                }
                zzbw.zzb(parcel);
                getUserProperties(string7, string8, zZzc4, zzdsVar2);
                break;
            case 6:
                String string9 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface3 instanceof zzdq) {
                        zzdsVar16 = (zzdq) iInterfaceQueryLocalInterface3;
                    } else {
                        zzdsVar16 = new zzds(strongBinder3);
                    }
                }
                zzbw.zzb(parcel);
                getMaxUserProperties(string9, zzdsVar16);
                break;
            case 7:
                String string10 = parcel.readString();
                long j5 = parcel.readLong();
                zzbw.zzb(parcel);
                setUserId(string10, j5);
                break;
            case 8:
                Bundle bundle3 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                long j6 = parcel.readLong();
                zzbw.zzb(parcel);
                setConditionalUserProperty(bundle3, j6);
                break;
            case 9:
                String string11 = parcel.readString();
                String string12 = parcel.readString();
                Bundle bundle4 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                zzbw.zzb(parcel);
                clearConditionalUserProperty(string11, string12, bundle4);
                break;
            case 10:
                String string13 = parcel.readString();
                String string14 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface4 instanceof zzdq) {
                        zzdsVar15 = (zzdq) iInterfaceQueryLocalInterface4;
                    } else {
                        zzdsVar15 = new zzds(strongBinder4);
                    }
                }
                zzbw.zzb(parcel);
                getConditionalUserProperties(string13, string14, zzdsVar15);
                break;
            case 11:
                boolean zZzc5 = zzbw.zzc(parcel);
                long j7 = parcel.readLong();
                zzbw.zzb(parcel);
                setMeasurementEnabled(zZzc5, j7);
                break;
            case 12:
                long j8 = parcel.readLong();
                zzbw.zzb(parcel);
                resetAnalyticsData(j8);
                break;
            case 13:
                long j9 = parcel.readLong();
                zzbw.zzb(parcel);
                setMinimumSessionDuration(j9);
                break;
            case 14:
                long j10 = parcel.readLong();
                zzbw.zzb(parcel);
                setSessionTimeoutDuration(j10);
                break;
            case 15:
                IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                long j11 = parcel.readLong();
                zzbw.zzb(parcel);
                setCurrentScreen(iObjectWrapperAsInterface3, string15, string16, j11);
                break;
            case 16:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface5 instanceof zzdq) {
                        zzdsVar14 = (zzdq) iInterfaceQueryLocalInterface5;
                    } else {
                        zzdsVar14 = new zzds(strongBinder5);
                    }
                }
                zzbw.zzb(parcel);
                getCurrentScreenName(zzdsVar14);
                break;
            case 17:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface6 instanceof zzdq) {
                        zzdsVar13 = (zzdq) iInterfaceQueryLocalInterface6;
                    } else {
                        zzdsVar13 = new zzds(strongBinder6);
                    }
                }
                zzbw.zzb(parcel);
                getCurrentScreenClass(zzdsVar13);
                break;
            case 18:
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    if (iInterfaceQueryLocalInterface7 instanceof zzdx) {
                        zzeaVar = (zzdx) iInterfaceQueryLocalInterface7;
                    } else {
                        zzeaVar = new zzea(strongBinder7);
                    }
                }
                zzbw.zzb(parcel);
                setInstanceIdProvider(zzeaVar);
                break;
            case 19:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface8 instanceof zzdq) {
                        zzdsVar12 = (zzdq) iInterfaceQueryLocalInterface8;
                    } else {
                        zzdsVar12 = new zzds(strongBinder8);
                    }
                }
                zzbw.zzb(parcel);
                getCachedAppInstanceId(zzdsVar12);
                break;
            case 20:
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface9 instanceof zzdq) {
                        zzdsVar11 = (zzdq) iInterfaceQueryLocalInterface9;
                    } else {
                        zzdsVar11 = new zzds(strongBinder9);
                    }
                }
                zzbw.zzb(parcel);
                getAppInstanceId(zzdsVar11);
                break;
            case 21:
                IBinder strongBinder10 = parcel.readStrongBinder();
                if (strongBinder10 != null) {
                    IInterface iInterfaceQueryLocalInterface10 = strongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface10 instanceof zzdq) {
                        zzdsVar10 = (zzdq) iInterfaceQueryLocalInterface10;
                    } else {
                        zzdsVar10 = new zzds(strongBinder10);
                    }
                }
                zzbw.zzb(parcel);
                getGmpAppId(zzdsVar10);
                break;
            case 22:
                IBinder strongBinder11 = parcel.readStrongBinder();
                if (strongBinder11 != null) {
                    IInterface iInterfaceQueryLocalInterface11 = strongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface11 instanceof zzdq) {
                        zzdsVar9 = (zzdq) iInterfaceQueryLocalInterface11;
                    } else {
                        zzdsVar9 = new zzds(strongBinder11);
                    }
                }
                zzbw.zzb(parcel);
                generateEventId(zzdsVar9);
                break;
            case 23:
                String string17 = parcel.readString();
                long j12 = parcel.readLong();
                zzbw.zzb(parcel);
                beginAdUnitExposure(string17, j12);
                break;
            case 24:
                String string18 = parcel.readString();
                long j13 = parcel.readLong();
                zzbw.zzb(parcel);
                endAdUnitExposure(string18, j13);
                break;
            case 25:
                IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long j14 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityStarted(iObjectWrapperAsInterface4, j14);
                break;
            case 26:
                IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long j15 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityStopped(iObjectWrapperAsInterface5, j15);
                break;
            case 27:
                IObjectWrapper iObjectWrapperAsInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                Bundle bundle5 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                long j16 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityCreated(iObjectWrapperAsInterface6, bundle5, j16);
                break;
            case 28:
                IObjectWrapper iObjectWrapperAsInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long j17 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityDestroyed(iObjectWrapperAsInterface7, j17);
                break;
            case 29:
                IObjectWrapper iObjectWrapperAsInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long j18 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityPaused(iObjectWrapperAsInterface8, j18);
                break;
            case 30:
                IObjectWrapper iObjectWrapperAsInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long j19 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityResumed(iObjectWrapperAsInterface9, j19);
                break;
            case 31:
                IObjectWrapper iObjectWrapperAsInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder strongBinder12 = parcel.readStrongBinder();
                if (strongBinder12 != null) {
                    IInterface iInterfaceQueryLocalInterface12 = strongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface12 instanceof zzdq) {
                        zzdsVar8 = (zzdq) iInterfaceQueryLocalInterface12;
                    } else {
                        zzdsVar8 = new zzds(strongBinder12);
                    }
                }
                long j20 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivitySaveInstanceState(iObjectWrapperAsInterface10, zzdsVar8, j20);
                break;
            case 32:
                Bundle bundle6 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                IBinder strongBinder13 = parcel.readStrongBinder();
                if (strongBinder13 != null) {
                    IInterface iInterfaceQueryLocalInterface13 = strongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface13 instanceof zzdq) {
                        zzdsVar7 = (zzdq) iInterfaceQueryLocalInterface13;
                    } else {
                        zzdsVar7 = new zzds(strongBinder13);
                    }
                }
                long j21 = parcel.readLong();
                zzbw.zzb(parcel);
                performAction(bundle6, zzdsVar7, j21);
                break;
            case 33:
                int i3 = parcel.readInt();
                String string19 = parcel.readString();
                IObjectWrapper iObjectWrapperAsInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface13 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbw.zzb(parcel);
                logHealthData(i3, string19, iObjectWrapperAsInterface11, iObjectWrapperAsInterface12, iObjectWrapperAsInterface13);
                break;
            case 34:
                IBinder strongBinder14 = parcel.readStrongBinder();
                if (strongBinder14 != null) {
                    IInterface iInterfaceQueryLocalInterface14 = strongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (iInterfaceQueryLocalInterface14 instanceof zzdw) {
                        zzdyVar3 = (zzdw) iInterfaceQueryLocalInterface14;
                    } else {
                        zzdyVar3 = new zzdy(strongBinder14);
                    }
                }
                zzbw.zzb(parcel);
                setEventInterceptor(zzdyVar3);
                break;
            case 35:
                IBinder strongBinder15 = parcel.readStrongBinder();
                if (strongBinder15 != null) {
                    IInterface iInterfaceQueryLocalInterface15 = strongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (iInterfaceQueryLocalInterface15 instanceof zzdw) {
                        zzdyVar2 = (zzdw) iInterfaceQueryLocalInterface15;
                    } else {
                        zzdyVar2 = new zzdy(strongBinder15);
                    }
                }
                zzbw.zzb(parcel);
                registerOnMeasurementEventListener(zzdyVar2);
                break;
            case 36:
                IBinder strongBinder16 = parcel.readStrongBinder();
                if (strongBinder16 != null) {
                    IInterface iInterfaceQueryLocalInterface16 = strongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (iInterfaceQueryLocalInterface16 instanceof zzdw) {
                        zzdyVar = (zzdw) iInterfaceQueryLocalInterface16;
                    } else {
                        zzdyVar = new zzdy(strongBinder16);
                    }
                }
                zzbw.zzb(parcel);
                unregisterOnMeasurementEventListener(zzdyVar);
                break;
            case 37:
                HashMap mapZza = zzbw.zza(parcel);
                zzbw.zzb(parcel);
                initForTests(mapZza);
                break;
            case 38:
                IBinder strongBinder17 = parcel.readStrongBinder();
                if (strongBinder17 != null) {
                    IInterface iInterfaceQueryLocalInterface17 = strongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface17 instanceof zzdq) {
                        zzdsVar6 = (zzdq) iInterfaceQueryLocalInterface17;
                    } else {
                        zzdsVar6 = new zzds(strongBinder17);
                    }
                }
                int i4 = parcel.readInt();
                zzbw.zzb(parcel);
                getTestFlag(zzdsVar6, i4);
                break;
            case 39:
                boolean zZzc6 = zzbw.zzc(parcel);
                zzbw.zzb(parcel);
                setDataCollectionEnabled(zZzc6);
                break;
            case 40:
                IBinder strongBinder18 = parcel.readStrongBinder();
                if (strongBinder18 != null) {
                    IInterface iInterfaceQueryLocalInterface18 = strongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface18 instanceof zzdq) {
                        zzdsVar5 = (zzdq) iInterfaceQueryLocalInterface18;
                    } else {
                        zzdsVar5 = new zzds(strongBinder18);
                    }
                }
                zzbw.zzb(parcel);
                isDataCollectionEnabled(zzdsVar5);
                break;
            case 41:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
            default:
                return false;
            case 42:
                Bundle bundle7 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                zzbw.zzb(parcel);
                setDefaultEventParameters(bundle7);
                break;
            case 43:
                long j22 = parcel.readLong();
                zzbw.zzb(parcel);
                clearMeasurementEnabled(j22);
                break;
            case 44:
                Bundle bundle8 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                long j23 = parcel.readLong();
                zzbw.zzb(parcel);
                setConsent(bundle8, j23);
                break;
            case 45:
                Bundle bundle9 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                long j24 = parcel.readLong();
                zzbw.zzb(parcel);
                setConsentThirdParty(bundle9, j24);
                break;
            case 46:
                IBinder strongBinder19 = parcel.readStrongBinder();
                if (strongBinder19 != null) {
                    IInterface iInterfaceQueryLocalInterface19 = strongBinder19.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface19 instanceof zzdq) {
                        zzdsVar4 = (zzdq) iInterfaceQueryLocalInterface19;
                    } else {
                        zzdsVar4 = new zzds(strongBinder19);
                    }
                }
                zzbw.zzb(parcel);
                getSessionId(zzdsVar4);
                break;
            case 48:
                Intent intent = (Intent) zzbw.zza(parcel, Intent.CREATOR);
                zzbw.zzb(parcel);
                setSgtmDebugInfo(intent);
                break;
            case 50:
                zzeb zzebVar = (zzeb) zzbw.zza(parcel, zzeb.CREATOR);
                String string20 = parcel.readString();
                String string21 = parcel.readString();
                long j25 = parcel.readLong();
                zzbw.zzb(parcel);
                setCurrentScreenByScionActivityInfo(zzebVar, string20, string21, j25);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                zzeb zzebVar2 = (zzeb) zzbw.zza(parcel, zzeb.CREATOR);
                long j26 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityStartedByScionActivityInfo(zzebVar2, j26);
                break;
            case Elf64.Ehdr.E_EHSIZE /* 52 */:
                zzeb zzebVar3 = (zzeb) zzbw.zza(parcel, zzeb.CREATOR);
                long j27 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityStoppedByScionActivityInfo(zzebVar3, j27);
                break;
            case 53:
                zzeb zzebVar4 = (zzeb) zzbw.zza(parcel, zzeb.CREATOR);
                Bundle bundle10 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                long j28 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityCreatedByScionActivityInfo(zzebVar4, bundle10, j28);
                break;
            case Elf64.Ehdr.E_PHENTSIZE /* 54 */:
                zzeb zzebVar5 = (zzeb) zzbw.zza(parcel, zzeb.CREATOR);
                long j29 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityDestroyedByScionActivityInfo(zzebVar5, j29);
                break;
            case 55:
                zzeb zzebVar6 = (zzeb) zzbw.zza(parcel, zzeb.CREATOR);
                long j30 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityPausedByScionActivityInfo(zzebVar6, j30);
                break;
            case 56:
                zzeb zzebVar7 = (zzeb) zzbw.zza(parcel, zzeb.CREATOR);
                long j31 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityResumedByScionActivityInfo(zzebVar7, j31);
                break;
            case 57:
                zzeb zzebVar8 = (zzeb) zzbw.zza(parcel, zzeb.CREATOR);
                IBinder strongBinder20 = parcel.readStrongBinder();
                if (strongBinder20 != null) {
                    IInterface iInterfaceQueryLocalInterface20 = strongBinder20.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (iInterfaceQueryLocalInterface20 instanceof zzdq) {
                        zzdsVar3 = (zzdq) iInterfaceQueryLocalInterface20;
                    } else {
                        zzdsVar3 = new zzds(strongBinder20);
                    }
                }
                long j32 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivitySaveInstanceStateByScionActivityInfo(zzebVar8, zzdsVar3, j32);
                break;
            case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                IBinder strongBinder21 = parcel.readStrongBinder();
                if (strongBinder21 != null) {
                    IInterface iInterfaceQueryLocalInterface21 = strongBinder21.queryLocalInterface("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
                    if (iInterfaceQueryLocalInterface21 instanceof zzdr) {
                        zzdtVar = (zzdr) iInterfaceQueryLocalInterface21;
                    } else {
                        zzdtVar = new zzdt(strongBinder21);
                    }
                }
                zzbw.zzb(parcel);
                retrieveAndUploadBatches(zzdtVar);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}

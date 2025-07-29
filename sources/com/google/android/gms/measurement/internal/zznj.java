package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zznj implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzme zza;
    private volatile boolean zzb;
    private volatile zzgn zzc;

    protected zznj(zzme zzmeVar) {
        this.zza = zzmeVar;
    }

    public final void zza(Intent intent) {
        this.zza.zzv();
        Context contextZza = this.zza.zza();
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.zzb) {
                this.zza.zzj().zzq().zza("Connection attempt already in progress");
                return;
            }
            this.zza.zzj().zzq().zza("Using local app measurement service");
            this.zzb = true;
            connectionTracker.bindService(contextZza, intent, this.zza.zza, 129);
        }
    }

    public final void zza() {
        this.zza.zzv();
        Context contextZza = this.zza.zza();
        synchronized (this) {
            if (this.zzb) {
                this.zza.zzj().zzq().zza("Connection attempt already in progress");
                return;
            }
            if (this.zzc != null && (this.zzc.isConnecting() || this.zzc.isConnected())) {
                this.zza.zzj().zzq().zza("Already awaiting connection attempt");
                return;
            }
            this.zzc = new zzgn(contextZza, Looper.getMainLooper(), this, this);
            this.zza.zzj().zzq().zza("Connecting to remote service");
            this.zzb = true;
            Preconditions.checkNotNull(this.zzc);
            this.zzc.checkAvailabilityAndConnect();
        }
    }

    public final void zzb() {
        if (this.zzc != null && (this.zzc.isConnected() || this.zzc.isConnecting())) {
            this.zzc.disconnect();
        }
        this.zzc = null;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                Preconditions.checkNotNull(this.zzc);
                this.zza.zzl().zzb(new zznk(this, this.zzc.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zzc = null;
                this.zzb = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) throws IllegalStateException {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzgo zzgoVarZzm = this.zza.zzu.zzm();
        if (zzgoVarZzm != null) {
            zzgoVarZzm.zzr().zza("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzb = false;
            this.zzc = null;
        }
        this.zza.zzl().zzb(new zznm(this));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) throws IllegalStateException {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.zza.zzj().zzc().zza("Service connection suspended");
        this.zza.zzl().zzb(new zznn(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzfz zzgbVar;
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.zzb = false;
                this.zza.zzj().zzg().zza("Service connected with null binder");
                return;
            }
            zzfz zzfzVar = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    if (iBinder != null) {
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                        if (iInterfaceQueryLocalInterface instanceof zzfz) {
                            zzgbVar = (zzfz) iInterfaceQueryLocalInterface;
                        } else {
                            zzgbVar = new zzgb(iBinder);
                        }
                        zzfzVar = zzgbVar;
                    }
                    this.zza.zzj().zzq().zza("Bound to IMeasurementService interface");
                } else {
                    this.zza.zzj().zzg().zza("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.zza.zzj().zzg().zza("Service connect failed to get IMeasurementService");
            }
            if (zzfzVar == null) {
                this.zzb = false;
                try {
                    ConnectionTracker.getInstance().unbindService(this.zza.zza(), this.zza.zza);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.zza.zzl().zzb(new zzni(this, zzfzVar));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) throws IllegalStateException {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.zza.zzj().zzc().zza("Service disconnected");
        this.zza.zzl().zzb(new zznl(this, componentName));
    }
}

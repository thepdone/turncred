package com.mrousavy.camera.core;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MetadataProvider.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0007J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J$\u0010\u001a\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/mrousavy/camera/core/MetadataProvider;", "Landroid/location/LocationListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "hasLocationPermission", "", "getHasLocationPermission", "()Z", "<set-?>", "Landroid/location/Location;", FirebaseAnalytics.Param.LOCATION, "getLocation", "()Landroid/location/Location;", "locationManager", "Landroid/location/LocationManager;", "enableLocationUpdates", "", "enable", "onLocationChanged", "onProviderDisabled", "provider", "", "onProviderEnabled", "onStatusChanged", "status", "", "extras", "Landroid/os/Bundle;", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MetadataProvider implements LocationListener {
    private static final String TAG = "MetadataProvider";
    private static final float UPDATE_DISTANCE_M = 5.0f;
    private static final long UPDATE_INTERVAL_MS = 5000;
    private final Context context;
    private Location location;
    private final LocationManager locationManager;

    public MetadataProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Object systemService = context.getSystemService(FirebaseAnalytics.Param.LOCATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        this.locationManager = (LocationManager) systemService;
    }

    public final Context getContext() {
        return this.context;
    }

    private final boolean getHasLocationPermission() {
        return ContextCompat.checkSelfPermission(this.context, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(this.context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    public final Location getLocation() {
        return this.location;
    }

    public final void enableLocationUpdates(boolean enable) throws LocationPermissionError {
        if (!enable) {
            Log.i(TAG, "Stopping location updates...");
            this.locationManager.removeUpdates(this);
        } else {
            if (getHasLocationPermission()) {
                Log.i(TAG, "Start updating location...");
                MetadataProvider metadataProvider = this;
                this.locationManager.requestLocationUpdates("gps", 5000L, UPDATE_DISTANCE_M, metadataProvider);
                Location lastKnownLocation = this.locationManager.getLastKnownLocation("gps");
                this.location = lastKnownLocation;
                if (lastKnownLocation == null) {
                    this.locationManager.requestSingleUpdate("gps", metadataProvider, (Looper) null);
                    return;
                }
                return;
            }
            throw new LocationPermissionError();
        }
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        Log.i(TAG, "Location updated: " + location.getLatitude() + ", " + location.getLongitude());
        this.location = location;
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Log.i(TAG, "Location Provider " + provider + " has been disabled.");
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Log.i(TAG, "Location Provider " + provider + " has been enabled.");
    }

    @Override // android.location.LocationListener
    @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "", imports = {""}))
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.i(TAG, "Location Provider " + provider + " status changed: " + status);
    }
}

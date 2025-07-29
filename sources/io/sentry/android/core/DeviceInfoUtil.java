package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import io.sentry.DateUtils;
import io.sentry.IConnectionStatusProvider;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.ContextUtils;
import io.sentry.android.core.internal.util.CpuInfoUtils;
import io.sentry.android.core.internal.util.DeviceOrientations;
import io.sentry.android.core.internal.util.RootChecker;
import io.sentry.protocol.Device;
import io.sentry.protocol.OperatingSystem;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes5.dex */
public final class DeviceInfoUtil {
    private static volatile DeviceInfoUtil instance;
    private final BuildInfoProvider buildInfoProvider;
    private final Context context;
    private final Boolean isEmulator;
    private final SentryAndroidOptions options;
    private final OperatingSystem os;
    private final ContextUtils.SideLoadedInfo sideLoadedInfo;
    private final Long totalMem;

    public DeviceInfoUtil(Context context, SentryAndroidOptions sentryAndroidOptions) {
        this.context = context;
        this.options = sentryAndroidOptions;
        BuildInfoProvider buildInfoProvider = new BuildInfoProvider(sentryAndroidOptions.getLogger());
        this.buildInfoProvider = buildInfoProvider;
        CpuInfoUtils.getInstance().readMaxFrequencies();
        this.os = retrieveOperatingSystemInformation();
        this.isEmulator = buildInfoProvider.isEmulator();
        this.sideLoadedInfo = ContextUtils.retrieveSideLoadedInfo(context, sentryAndroidOptions.getLogger(), buildInfoProvider);
        ActivityManager.MemoryInfo memInfo = ContextUtils.getMemInfo(context, sentryAndroidOptions.getLogger());
        if (memInfo != null) {
            this.totalMem = Long.valueOf(memInfo.totalMem);
        } else {
            this.totalMem = null;
        }
    }

    public static DeviceInfoUtil getInstance(Context context, SentryAndroidOptions sentryAndroidOptions) {
        if (instance == null) {
            synchronized (DeviceInfoUtil.class) {
                if (instance == null) {
                    instance = new DeviceInfoUtil(ContextUtils.getApplicationContext(context), sentryAndroidOptions);
                }
            }
        }
        return instance;
    }

    public static void resetInstance() {
        instance = null;
    }

    public Device collectDeviceInformation(boolean z, boolean z2) {
        Device device = new Device();
        if (this.options.isSendDefaultPii()) {
            device.setName(ContextUtils.getDeviceName(this.context));
        }
        device.setManufacturer(Build.MANUFACTURER);
        device.setBrand(Build.BRAND);
        device.setFamily(ContextUtils.getFamily(this.options.getLogger()));
        device.setModel(Build.MODEL);
        device.setModelId(Build.ID);
        device.setArchs(ContextUtils.getArchitectures(this.buildInfoProvider));
        device.setOrientation(getOrientation());
        Boolean bool = this.isEmulator;
        if (bool != null) {
            device.setSimulator(bool);
        }
        DisplayMetrics displayMetrics = ContextUtils.getDisplayMetrics(this.context, this.options.getLogger());
        if (displayMetrics != null) {
            device.setScreenWidthPixels(Integer.valueOf(displayMetrics.widthPixels));
            device.setScreenHeightPixels(Integer.valueOf(displayMetrics.heightPixels));
            device.setScreenDensity(Float.valueOf(displayMetrics.density));
            device.setScreenDpi(Integer.valueOf(displayMetrics.densityDpi));
        }
        device.setBootTime(getBootTime());
        device.setTimezone(getTimeZone());
        if (device.getId() == null) {
            device.setId(getDeviceId());
        }
        Locale locale = Locale.getDefault();
        if (device.getLanguage() == null) {
            device.setLanguage(locale.getLanguage());
        }
        if (device.getLocale() == null) {
            device.setLocale(locale.toString());
        }
        List<Integer> maxFrequencies = CpuInfoUtils.getInstance().readMaxFrequencies();
        if (!maxFrequencies.isEmpty()) {
            device.setProcessorFrequency(Double.valueOf(((Integer) Collections.max(maxFrequencies)).doubleValue()));
            device.setProcessorCount(Integer.valueOf(maxFrequencies.size()));
        }
        device.setMemorySize(this.totalMem);
        if (z && this.options.isCollectAdditionalContext()) {
            setDeviceIO(device, z2);
        }
        return device;
    }

    public OperatingSystem getOperatingSystem() {
        return this.os;
    }

    protected OperatingSystem retrieveOperatingSystemInformation() throws IOException {
        OperatingSystem operatingSystem = new OperatingSystem();
        operatingSystem.setName("Android");
        operatingSystem.setVersion(Build.VERSION.RELEASE);
        operatingSystem.setBuild(Build.DISPLAY);
        String kernelVersion = ContextUtils.getKernelVersion(this.options.getLogger());
        if (kernelVersion != null) {
            operatingSystem.setKernelVersion(kernelVersion);
        }
        if (this.options.isEnableRootCheck()) {
            operatingSystem.setRooted(Boolean.valueOf(new RootChecker(this.context, this.buildInfoProvider, this.options.getLogger()).isDeviceRooted()));
        }
        return operatingSystem;
    }

    public ContextUtils.SideLoadedInfo getSideLoadedInfo() {
        return this.sideLoadedInfo;
    }

    private void setDeviceIO(Device device, boolean z) {
        Boolean bool;
        Intent batteryIntent = getBatteryIntent();
        if (batteryIntent != null) {
            device.setBatteryLevel(getBatteryLevel(batteryIntent, this.options));
            device.setCharging(isCharging(batteryIntent, this.options));
            device.setBatteryTemperature(getBatteryTemperature(batteryIntent));
        }
        int i = AnonymousClass1.$SwitchMap$io$sentry$IConnectionStatusProvider$ConnectionStatus[this.options.getConnectionStatusProvider().getConnectionStatus().ordinal()];
        if (i == 1) {
            bool = false;
        } else {
            bool = i != 2 ? null : true;
        }
        device.setOnline(bool);
        ActivityManager.MemoryInfo memInfo = ContextUtils.getMemInfo(this.context, this.options.getLogger());
        if (memInfo != null && z) {
            device.setFreeMemory(Long.valueOf(memInfo.availMem));
            device.setLowMemory(Boolean.valueOf(memInfo.lowMemory));
        }
        File externalFilesDir = this.context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            StatFs statFs = new StatFs(externalFilesDir.getPath());
            device.setStorageSize(getTotalInternalStorage(statFs));
            device.setFreeStorage(getUnusedInternalStorage(statFs));
        }
        StatFs externalStorageStat = getExternalStorageStat(externalFilesDir);
        if (externalStorageStat != null) {
            device.setExternalStorageSize(getTotalExternalStorage(externalStorageStat));
            device.setExternalFreeStorage(getUnusedExternalStorage(externalStorageStat));
        }
        if (device.getConnectionType() == null) {
            device.setConnectionType(this.options.getConnectionStatusProvider().getConnectionType());
        }
    }

    /* renamed from: io.sentry.android.core.DeviceInfoUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$sentry$IConnectionStatusProvider$ConnectionStatus;

        static {
            int[] iArr = new int[IConnectionStatusProvider.ConnectionStatus.values().length];
            $SwitchMap$io$sentry$IConnectionStatusProvider$ConnectionStatus = iArr;
            try {
                iArr[IConnectionStatusProvider.ConnectionStatus.DISCONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$sentry$IConnectionStatusProvider$ConnectionStatus[IConnectionStatusProvider.ConnectionStatus.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private TimeZone getTimeZone() {
        if (this.buildInfoProvider.getSdkInfoVersion() >= 24) {
            LocaleList locales = this.context.getResources().getConfiguration().getLocales();
            if (!locales.isEmpty()) {
                return Calendar.getInstance(locales.get(0)).getTimeZone();
            }
        }
        return Calendar.getInstance().getTimeZone();
    }

    private Date getBootTime() {
        try {
            return DateUtils.getDateTime(System.currentTimeMillis() - SystemClock.elapsedRealtime());
        } catch (IllegalArgumentException e) {
            this.options.getLogger().log(SentryLevel.ERROR, e, "Error getting the device's boot time.", new Object[0]);
            return null;
        }
    }

    private Intent getBatteryIntent() {
        return ContextUtils.registerReceiver(this.context, this.buildInfoProvider, (BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public static Float getBatteryLevel(Intent intent, SentryOptions sentryOptions) {
        try {
            int intExtra = intent.getIntExtra("level", -1);
            int intExtra2 = intent.getIntExtra("scale", -1);
            if (intExtra != -1 && intExtra2 != -1) {
                return Float.valueOf((intExtra / intExtra2) * 100.0f);
            }
            return null;
        } catch (Throwable th) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "Error getting device battery level.", th);
            return null;
        }
    }

    public static Boolean isCharging(Intent intent, SentryOptions sentryOptions) {
        try {
            int intExtra = intent.getIntExtra("plugged", -1);
            boolean z = true;
            if (intExtra != 1 && intExtra != 2) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Throwable th) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "Error getting device charging state.", th);
            return null;
        }
    }

    private Float getBatteryTemperature(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("temperature", -1);
            if (intExtra != -1) {
                return Float.valueOf(intExtra / 10.0f);
            }
            return null;
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error getting battery temperature.", th);
            return null;
        }
    }

    private Device.DeviceOrientation getOrientation() {
        Device.DeviceOrientation orientation;
        Throwable th;
        try {
            orientation = DeviceOrientations.getOrientation(this.context.getResources().getConfiguration().orientation);
            if (orientation == null) {
                try {
                    this.options.getLogger().log(SentryLevel.INFO, "No device orientation available (ORIENTATION_SQUARE|ORIENTATION_UNDEFINED)", new Object[0]);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    this.options.getLogger().log(SentryLevel.ERROR, "Error getting device orientation.", th);
                    return orientation;
                }
            }
        } catch (Throwable th3) {
            orientation = null;
            th = th3;
        }
        return orientation;
    }

    private Long getTotalInternalStorage(StatFs statFs) {
        try {
            return Long.valueOf(statFs.getBlockCountLong() * statFs.getBlockSizeLong());
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error getting total internal storage amount.", th);
            return null;
        }
    }

    private Long getUnusedInternalStorage(StatFs statFs) {
        try {
            return Long.valueOf(statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong());
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error getting unused internal storage amount.", th);
            return null;
        }
    }

    private StatFs getExternalStorageStat(File file) {
        if (!isExternalStorageMounted()) {
            File externalStorageDep = getExternalStorageDep(file);
            if (externalStorageDep != null) {
                return new StatFs(externalStorageDep.getPath());
            }
            this.options.getLogger().log(SentryLevel.INFO, "Not possible to read external files directory", new Object[0]);
            return null;
        }
        this.options.getLogger().log(SentryLevel.INFO, "External storage is not mounted or emulated.", new Object[0]);
        return null;
    }

    private File getExternalStorageDep(File file) {
        File[] externalFilesDirs = this.context.getExternalFilesDirs(null);
        if (externalFilesDirs != null) {
            String absolutePath = file != null ? file.getAbsolutePath() : null;
            for (File file2 : externalFilesDirs) {
                if (file2 != null && (absolutePath == null || absolutePath.isEmpty() || !file2.getAbsolutePath().contains(absolutePath))) {
                    return file2;
                }
            }
        } else {
            this.options.getLogger().log(SentryLevel.INFO, "Not possible to read getExternalFilesDirs", new Object[0]);
        }
        return null;
    }

    private Long getTotalExternalStorage(StatFs statFs) {
        try {
            return Long.valueOf(statFs.getBlockCountLong() * statFs.getBlockSizeLong());
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error getting total external storage amount.", th);
            return null;
        }
    }

    private boolean isExternalStorageMounted() {
        String externalStorageState = Environment.getExternalStorageState();
        return ("mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState)) && !Environment.isExternalStorageEmulated();
    }

    private Long getUnusedExternalStorage(StatFs statFs) {
        try {
            return Long.valueOf(statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong());
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error getting unused external storage amount.", th);
            return null;
        }
    }

    private String getDeviceId() {
        try {
            return Installation.id(this.context);
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error getting installationId.", th);
            return null;
        }
    }
}

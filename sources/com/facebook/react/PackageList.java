package com.facebook.react;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import cl.json.RNSharePackage;
import com.facebook.react.shell.MainPackageConfig;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.reactnative.androidsdk.FBSDKPackage;
import com.horcrux.svg.SvgPackage;
import com.learnium.RNDeviceInfo.RNDeviceInfo;
import com.microsoft.codepush.react.CodePush;
import com.mrousavy.camera.react.CameraPackage;
import com.reactnativecommunity.asyncstorage.AsyncStoragePackage;
import com.reactnativecommunity.webview.RNCWebViewPackage;
import com.reactnativepagerview.PagerViewPackage;
import com.shopify.reactnative.flash_list.ReactNativeFlashListPackage;
import com.shopify.reactnative.skia.RNSkiaPackage;
import com.streem.selectcontact.SelectContactPackage;
import com.swmansion.gesturehandler.RNGestureHandlerPackage;
import com.swmansion.reanimated.ReanimatedPackage;
import com.swmansion.rnscreens.RNScreensPackage;
import com.th3rdwave.safeareacontext.SafeAreaContextPackage;
import com.visioncamerafacedetector.VisionCameraFaceDetectorPluginPackage;
import com.worklets.WorkletsPackage;
import expo.modules.ExpoModulesPackage;
import io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsPackage;
import io.invertase.firebase.app.ReactNativeFirebaseAppPackage;
import io.sentry.react.RNSentryPackage;
import java.util.ArrayList;
import java.util.Arrays;
import org.linusu.RNGetRandomValuesPackage;

/* loaded from: classes4.dex */
public class PackageList {
    private Application application;
    private MainPackageConfig mConfig;
    private ReactNativeHost reactNativeHost;

    public PackageList(ReactNativeHost reactNativeHost) {
        this(reactNativeHost, (MainPackageConfig) null);
    }

    public PackageList(Application application) {
        this(application, (MainPackageConfig) null);
    }

    public PackageList(ReactNativeHost reactNativeHost, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = reactNativeHost;
        this.mConfig = mainPackageConfig;
    }

    public PackageList(Application application, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = null;
        this.application = application;
        this.mConfig = mainPackageConfig;
    }

    private ReactNativeHost getReactNativeHost() {
        return this.reactNativeHost;
    }

    private Resources getResources() {
        return getApplication().getResources();
    }

    private Application getApplication() {
        ReactNativeHost reactNativeHost = this.reactNativeHost;
        return reactNativeHost == null ? this.application : reactNativeHost.getApplication();
    }

    private Context getApplicationContext() {
        return getApplication().getApplicationContext();
    }

    public ArrayList<ReactPackage> getPackages() {
        return new ArrayList<>(Arrays.asList(new MainReactPackage(this.mConfig), new AsyncStoragePackage(), new ReactNativeFirebaseAnalyticsPackage(), new ReactNativeFirebaseAppPackage(), new RNSentryPackage(), new ReactNativeFlashListPackage(), new RNSkiaPackage(), new ExpoModulesPackage(), new CodePush(getResources().getString(com.newbee.turncred.R.string.CodePushDeploymentKey), getApplicationContext(), false), new RNDeviceInfo(), new FBSDKPackage(), new RNGestureHandlerPackage(), new RNGetRandomValuesPackage(), new PagerViewPackage(), new ReanimatedPackage(), new SafeAreaContextPackage(), new RNScreensPackage(), new SelectContactPackage(), new RNSharePackage(), new SvgPackage(), new CameraPackage(), new VisionCameraFaceDetectorPluginPackage(), new RNCWebViewPackage(), new WorkletsPackage()));
    }
}

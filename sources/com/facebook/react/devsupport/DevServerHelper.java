package com.facebook.react.devsupport;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.Settings;
import androidx.browser.trusted.sharing.ShareTarget;
import com.facebook.common.logging.FLog;
import com.facebook.hermes.intl.Constants;
import com.facebook.infer.annotation.Assertions;
import com.facebook.internal.ServerProtocol;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.devsupport.BundleDownloader;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.packagerconnection.FileIoHandler;
import com.facebook.react.packagerconnection.JSPackagerClient;
import com.facebook.react.packagerconnection.NotificationOnlyHandler;
import com.facebook.react.packagerconnection.PackagerConnectionSettings;
import com.facebook.react.packagerconnection.ReconnectingWebSocket;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.packagerconnection.RequestOnlyHandler;
import com.facebook.react.packagerconnection.Responder;
import com.facebook.react.util.RNLog;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Okio;
import okio.Sink;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes4.dex */
public class DevServerHelper {
    private static final String DEBUGGER_MSG_DISABLE = "{ \"id\":1,\"method\":\"Debugger.disable\" }";
    private static final int HTTP_CONNECT_TIMEOUT_MS = 5000;
    public static final String RELOAD_APP_EXTRA_JS_PROXY = "jsproxy";
    private final Context mApplicationContext;
    private final BundleDownloader mBundleDownloader;
    private final OkHttpClient mClient;
    private IInspectorPackagerConnection mInspectorPackagerConnection;
    private final String mPackageName;
    private JSPackagerClient mPackagerClient;
    private final PackagerConnectionSettings mPackagerConnectionSettings;
    private final PackagerStatusCheck mPackagerStatusCheck;
    private final DeveloperSettings mSettings;

    public interface PackagerCommandListener {
        Map<String, RequestHandler> customCommandHandlers();

        void onCaptureHeapCommand(Responder responder);

        void onPackagerConnected();

        void onPackagerDevMenuCommand();

        void onPackagerDisconnected();

        void onPackagerReloadCommand();
    }

    private enum BundleType {
        BUNDLE("bundle"),
        MAP("map");

        private final String mTypeID;

        BundleType(String str) {
            this.mTypeID = str;
        }

        public String typeID() {
            return this.mTypeID;
        }
    }

    public DevServerHelper(DeveloperSettings developerSettings, Context context, PackagerConnectionSettings packagerConnectionSettings) {
        this.mSettings = developerSettings;
        this.mPackagerConnectionSettings = packagerConnectionSettings;
        OkHttpClient okHttpClientBuild = new OkHttpClient.Builder().connectTimeout(5000L, TimeUnit.MILLISECONDS).readTimeout(0L, TimeUnit.MILLISECONDS).writeTimeout(0L, TimeUnit.MILLISECONDS).build();
        this.mClient = okHttpClientBuild;
        this.mBundleDownloader = new BundleDownloader(okHttpClientBuild);
        this.mPackagerStatusCheck = new PackagerStatusCheck(okHttpClientBuild);
        this.mApplicationContext = context;
        this.mPackageName = context.getPackageName();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.facebook.react.devsupport.DevServerHelper$1] */
    public void openPackagerConnection(final String str, final PackagerCommandListener packagerCommandListener) {
        if (this.mPackagerClient != null) {
            FLog.w("ReactNative", "Packager connection already open, nooping.");
        } else {
            new AsyncTask<Void, Void, Void>() { // from class: com.facebook.react.devsupport.DevServerHelper.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public Void doInBackground(Void... voidArr) {
                    HashMap map = new HashMap();
                    map.put("reload", new NotificationOnlyHandler() { // from class: com.facebook.react.devsupport.DevServerHelper.1.1
                        @Override // com.facebook.react.packagerconnection.NotificationOnlyHandler, com.facebook.react.packagerconnection.RequestHandler
                        public void onNotification(Object obj) {
                            packagerCommandListener.onPackagerReloadCommand();
                        }
                    });
                    map.put("devMenu", new NotificationOnlyHandler() { // from class: com.facebook.react.devsupport.DevServerHelper.1.2
                        @Override // com.facebook.react.packagerconnection.NotificationOnlyHandler, com.facebook.react.packagerconnection.RequestHandler
                        public void onNotification(Object obj) {
                            packagerCommandListener.onPackagerDevMenuCommand();
                        }
                    });
                    map.put("captureHeap", new RequestOnlyHandler() { // from class: com.facebook.react.devsupport.DevServerHelper.1.3
                        @Override // com.facebook.react.packagerconnection.RequestOnlyHandler, com.facebook.react.packagerconnection.RequestHandler
                        public void onRequest(Object obj, Responder responder) {
                            packagerCommandListener.onCaptureHeapCommand(responder);
                        }
                    });
                    Map<String, RequestHandler> mapCustomCommandHandlers = packagerCommandListener.customCommandHandlers();
                    if (mapCustomCommandHandlers != null) {
                        map.putAll(mapCustomCommandHandlers);
                    }
                    map.putAll(new FileIoHandler().handlers());
                    ReconnectingWebSocket.ConnectionCallback connectionCallback = new ReconnectingWebSocket.ConnectionCallback() { // from class: com.facebook.react.devsupport.DevServerHelper.1.4
                        @Override // com.facebook.react.packagerconnection.ReconnectingWebSocket.ConnectionCallback
                        public void onConnected() {
                            packagerCommandListener.onPackagerConnected();
                        }

                        @Override // com.facebook.react.packagerconnection.ReconnectingWebSocket.ConnectionCallback
                        public void onDisconnected() {
                            packagerCommandListener.onPackagerDisconnected();
                        }
                    };
                    DevServerHelper.this.mPackagerClient = new JSPackagerClient(str, DevServerHelper.this.mPackagerConnectionSettings, map, connectionCallback);
                    DevServerHelper.this.mPackagerClient.init();
                    return null;
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.react.devsupport.DevServerHelper$2] */
    public void closePackagerConnection() {
        new AsyncTask<Void, Void, Void>() { // from class: com.facebook.react.devsupport.DevServerHelper.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                if (DevServerHelper.this.mPackagerClient != null) {
                    DevServerHelper.this.mPackagerClient.close();
                    DevServerHelper.this.mPackagerClient = null;
                }
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.facebook.react.devsupport.DevServerHelper$3] */
    public void openInspectorConnection() {
        if (this.mInspectorPackagerConnection != null) {
            FLog.w("ReactNative", "Inspector connection already open, nooping.");
        } else {
            new AsyncTask<Void, Void, Void>() { // from class: com.facebook.react.devsupport.DevServerHelper.3
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public Void doInBackground(Void... voidArr) {
                    if (InspectorFlags.getFuseboxEnabled()) {
                        DevServerHelper.this.mInspectorPackagerConnection = new CxxInspectorPackagerConnection(DevServerHelper.this.getInspectorDeviceUrl(), DevServerHelper.this.mPackageName);
                    } else {
                        DevServerHelper.this.mInspectorPackagerConnection = new InspectorPackagerConnection(DevServerHelper.this.getInspectorDeviceUrl(), DevServerHelper.this.mPackageName);
                    }
                    DevServerHelper.this.mInspectorPackagerConnection.connect();
                    return null;
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public void disableDebugger() {
        IInspectorPackagerConnection iInspectorPackagerConnection = this.mInspectorPackagerConnection;
        if (iInspectorPackagerConnection != null) {
            iInspectorPackagerConnection.sendEventToAllConnections(DEBUGGER_MSG_DISABLE);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.react.devsupport.DevServerHelper$4] */
    public void closeInspectorConnection() {
        new AsyncTask<Void, Void, Void>() { // from class: com.facebook.react.devsupport.DevServerHelper.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                if (DevServerHelper.this.mInspectorPackagerConnection != null) {
                    DevServerHelper.this.mInspectorPackagerConnection.closeQuietly();
                    DevServerHelper.this.mInspectorPackagerConnection = null;
                }
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public String getWebsocketProxyURL() {
        return String.format(Locale.US, "ws://%s/debugger-proxy?role=client", this.mPackagerConnectionSettings.getDebugServerHost());
    }

    private static String getSHA256(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            messageDigest.reset();
            try {
                byte[] bArrDigest = messageDigest.digest(str.getBytes("UTF-8"));
                return String.format("%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x", Byte.valueOf(bArrDigest[0]), Byte.valueOf(bArrDigest[1]), Byte.valueOf(bArrDigest[2]), Byte.valueOf(bArrDigest[3]), Byte.valueOf(bArrDigest[4]), Byte.valueOf(bArrDigest[5]), Byte.valueOf(bArrDigest[6]), Byte.valueOf(bArrDigest[7]), Byte.valueOf(bArrDigest[8]), Byte.valueOf(bArrDigest[9]), Byte.valueOf(bArrDigest[10]), Byte.valueOf(bArrDigest[11]), Byte.valueOf(bArrDigest[12]), Byte.valueOf(bArrDigest[13]), Byte.valueOf(bArrDigest[14]), Byte.valueOf(bArrDigest[15]), Byte.valueOf(bArrDigest[16]), Byte.valueOf(bArrDigest[17]), Byte.valueOf(bArrDigest[18]), Byte.valueOf(bArrDigest[19]));
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError("This environment doesn't support UTF-8 encoding", e);
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError("Could not get standard SHA-256 algorithm", e2);
        }
    }

    private String getInspectorDeviceId() {
        return getSHA256(String.format(Locale.US, "android-%s-%s-%s", this.mPackageName, Settings.Secure.getString(this.mApplicationContext.getContentResolver(), "android_id"), InspectorFlags.getFuseboxEnabled() ? "fusebox" : "legacy"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getInspectorDeviceUrl() {
        return String.format(Locale.US, "http://%s/inspector/device?name=%s&app=%s&device=%s", this.mPackagerConnectionSettings.getDebugServerHost(), Uri.encode(AndroidInfoHelpers.getFriendlyDeviceName()), Uri.encode(this.mPackageName), Uri.encode(getInspectorDeviceId()));
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, BundleDownloader.BundleInfo bundleInfo) {
        this.mBundleDownloader.downloadBundleFromURL(devBundleDownloadListener, file, str, bundleInfo);
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, BundleDownloader.BundleInfo bundleInfo, Request.Builder builder) {
        this.mBundleDownloader.downloadBundleFromURL(devBundleDownloadListener, file, str, bundleInfo, builder);
    }

    private String getHostForJSProxy() {
        String str = (String) Assertions.assertNotNull(this.mPackagerConnectionSettings.getDebugServerHost());
        int iLastIndexOf = str.lastIndexOf(58);
        if (iLastIndexOf <= -1) {
            return AndroidInfoHelpers.DEVICE_LOCALHOST;
        }
        return AndroidInfoHelpers.DEVICE_LOCALHOST + str.substring(iLastIndexOf);
    }

    private boolean getDevMode() {
        return this.mSettings.isJSDevModeEnabled();
    }

    private boolean getJSMinifyMode() {
        return this.mSettings.isJSMinifyEnabled();
    }

    private String createBundleURL(String str, BundleType bundleType, String str2) {
        return createBundleURL(str, bundleType, str2, false, true);
    }

    private String createSplitBundleURL(String str, String str2) {
        return createBundleURL(str, BundleType.BUNDLE, str2, true, false);
    }

    private String createBundleURL(String str, BundleType bundleType, String str2, boolean z, boolean z2) {
        boolean devMode = getDevMode();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.mPackagerConnectionSettings.getAdditionalOptionsForPackager().entrySet()) {
            if (entry.getValue().length() != 0) {
                sb.append("&" + entry.getKey() + "=" + Uri.encode(entry.getValue()));
            }
        }
        return String.format(Locale.US, "http://%s/%s.%s?platform=android&dev=%s&lazy=%s&minify=%s&app=%s&modulesOnly=%s&runModule=%s", str2, str, bundleType.typeID(), Boolean.valueOf(devMode), Boolean.valueOf(devMode), Boolean.valueOf(getJSMinifyMode()), this.mPackageName, z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : Constants.CASEFIRST_FALSE, z2 ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : Constants.CASEFIRST_FALSE) + (InspectorFlags.getFuseboxEnabled() ? "&excludeSource=true&sourcePaths=url-server" : "") + sb.toString();
    }

    private String createBundleURL(String str, BundleType bundleType) {
        return createBundleURL(str, bundleType, this.mPackagerConnectionSettings.getDebugServerHost());
    }

    private static String createResourceURL(String str, String str2) {
        return String.format(Locale.US, "http://%s/%s", str, str2);
    }

    public String getDevServerBundleURL(String str) {
        return createBundleURL(str, BundleType.BUNDLE, this.mPackagerConnectionSettings.getDebugServerHost());
    }

    public String getDevServerSplitBundleURL(String str) {
        return createSplitBundleURL(str, this.mPackagerConnectionSettings.getDebugServerHost());
    }

    public void isPackagerRunning(PackagerStatusCallback packagerStatusCallback) {
        String debugServerHost = this.mPackagerConnectionSettings.getDebugServerHost();
        if (debugServerHost == null) {
            FLog.w("ReactNative", "No packager host configured.");
            packagerStatusCallback.onPackagerStatusFetched(false);
        } else {
            this.mPackagerStatusCheck.run(debugServerHost, packagerStatusCallback);
        }
    }

    private String createLaunchJSDevtoolsCommandUrl() {
        return String.format(Locale.US, "http://%s/launch-js-devtools", this.mPackagerConnectionSettings.getDebugServerHost());
    }

    public void launchJSDevtools() {
        this.mClient.newCall(new Request.Builder().url(createLaunchJSDevtoolsCommandUrl()).build()).enqueue(new Callback() { // from class: com.facebook.react.devsupport.DevServerHelper.5
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
            }
        });
    }

    public String getSourceMapUrl(String str) {
        return createBundleURL(str, BundleType.MAP);
    }

    public String getSourceUrl(String str) {
        return createBundleURL(str, BundleType.BUNDLE);
    }

    public String getJSBundleURLForRemoteDebugging(String str) {
        return createBundleURL(str, BundleType.BUNDLE, getHostForJSProxy());
    }

    public File downloadBundleResourceFromUrlSync(String str, File file) {
        try {
            Response responseExecute = this.mClient.newCall(new Request.Builder().url(createResourceURL(this.mPackagerConnectionSettings.getDebugServerHost(), str)).build()).execute();
            try {
                if (!responseExecute.isSuccessful()) {
                    if (responseExecute != null) {
                        responseExecute.close();
                    }
                    return null;
                }
                Sink sink = Okio.sink(file);
                try {
                    Okio.buffer(responseExecute.body().getSource()).readAll(sink);
                    if (sink != null) {
                        sink.close();
                    }
                    if (responseExecute != null) {
                        responseExecute.close();
                    }
                    return file;
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
            FLog.e("ReactNative", "Failed to fetch resource synchronously - resourcePath: \"%s\", outputFile: \"%s\"", str, file.getAbsolutePath(), e);
            return null;
        }
    }

    public void openDebugger(final ReactContext reactContext, final String str) {
        this.mClient.newCall(new Request.Builder().url(String.format(Locale.US, "http://%s/open-debugger?appId=%s&device=%s", this.mPackagerConnectionSettings.getDebugServerHost(), Uri.encode(this.mPackageName), Uri.encode(getInspectorDeviceId()))).method(ShareTarget.METHOD_POST, RequestBody.create((MediaType) null, "")).build()).enqueue(new Callback() { // from class: com.facebook.react.devsupport.DevServerHelper.6
            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                RNLog.w(reactContext, str);
            }
        });
    }
}

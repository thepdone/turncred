package com.facebook.react.devsupport;

import com.facebook.cache.disk.DefaultDiskStorage;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.DebugServerException;
import com.facebook.react.devsupport.MultipartStreamReader;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.google.common.net.HttpHeaders;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class BundleDownloader {
    private static final int FILES_CHANGED_COUNT_NOT_BUILT_BY_BUNDLER = -2;
    private static final String TAG = "BundleDownloader";
    private final OkHttpClient mClient;
    private Call mDownloadBundleFromURLCall;

    public static class BundleInfo {
        private int mFilesChangedCount;
        private String mUrl;

        public static BundleInfo fromJSONString(String str) {
            if (str == null) {
                return null;
            }
            BundleInfo bundleInfo = new BundleInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                bundleInfo.mUrl = jSONObject.getString("url");
                bundleInfo.mFilesChangedCount = jSONObject.getInt("filesChangedCount");
                return bundleInfo;
            } catch (JSONException e) {
                FLog.e(BundleDownloader.TAG, "Invalid bundle info: ", e);
                return null;
            }
        }

        public String toJSONString() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", this.mUrl);
                jSONObject.put("filesChangedCount", this.mFilesChangedCount);
                return jSONObject.toString();
            } catch (JSONException e) {
                FLog.e(BundleDownloader.TAG, "Can't serialize bundle info: ", e);
                return null;
            }
        }

        public String getUrl() {
            String str = this.mUrl;
            return str != null ? str : "unknown";
        }

        public int getFilesChangedCount() {
            return this.mFilesChangedCount;
        }
    }

    public BundleDownloader(OkHttpClient okHttpClient) {
        this.mClient = okHttpClient;
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, BundleInfo bundleInfo) {
        downloadBundleFromURL(devBundleDownloadListener, file, str, bundleInfo, new Request.Builder());
    }

    public void downloadBundleFromURL(final DevBundleDownloadListener devBundleDownloadListener, final File file, String str, final BundleInfo bundleInfo, Request.Builder builder) {
        Call call = (Call) Assertions.assertNotNull(this.mClient.newCall(builder.url(str).addHeader(HttpHeaders.ACCEPT, "multipart/mixed").build()));
        this.mDownloadBundleFromURLCall = call;
        call.enqueue(new Callback() { // from class: com.facebook.react.devsupport.BundleDownloader.1
            @Override // okhttp3.Callback
            public void onFailure(Call call2, IOException iOException) {
                if (BundleDownloader.this.mDownloadBundleFromURLCall == null || BundleDownloader.this.mDownloadBundleFromURLCall.getCanceled()) {
                    BundleDownloader.this.mDownloadBundleFromURLCall = null;
                    return;
                }
                BundleDownloader.this.mDownloadBundleFromURLCall = null;
                String url = call2.request().url().getUrl();
                devBundleDownloadListener.onFailure(DebugServerException.makeGeneric(url, "Could not connect to development server.", "URL: " + url, iOException));
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call2, Response response) throws IOException {
                try {
                    if (BundleDownloader.this.mDownloadBundleFromURLCall != null && !BundleDownloader.this.mDownloadBundleFromURLCall.getCanceled()) {
                        BundleDownloader.this.mDownloadBundleFromURLCall = null;
                        String url = response.request().url().getUrl();
                        Matcher matcher = Pattern.compile("multipart/mixed;.*boundary=\"([^\"]+)\"").matcher(response.header("content-type"));
                        if (matcher.find()) {
                            BundleDownloader.this.processMultipartResponse(url, response, matcher.group(1), file, bundleInfo, devBundleDownloadListener);
                        } else {
                            ResponseBody responseBodyBody = response.body();
                            try {
                                BundleDownloader.this.processBundleResult(url, response.code(), response.headers(), response.body().getBodySource(), file, bundleInfo, devBundleDownloadListener);
                                if (responseBodyBody != null) {
                                    responseBodyBody.close();
                                }
                            } finally {
                            }
                        }
                        if (response != null) {
                            response.close();
                            return;
                        }
                        return;
                    }
                    BundleDownloader.this.mDownloadBundleFromURLCall = null;
                    if (response != null) {
                        response.close();
                    }
                } catch (Throwable th) {
                    if (response != null) {
                        try {
                            response.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processMultipartResponse(final String str, final Response response, String str2, final File file, final BundleInfo bundleInfo, final DevBundleDownloadListener devBundleDownloadListener) throws IOException {
        if (new MultipartStreamReader(response.body().getBodySource(), str2).readAllParts(new MultipartStreamReader.ChunkListener() { // from class: com.facebook.react.devsupport.BundleDownloader.2
            @Override // com.facebook.react.devsupport.MultipartStreamReader.ChunkListener
            public void onChunkComplete(Map<String, String> map, Buffer buffer, boolean z) throws NumberFormatException, IOException {
                if (z) {
                    int iCode = response.code();
                    if (map.containsKey("X-Http-Status")) {
                        iCode = Integer.parseInt(map.get("X-Http-Status"));
                    }
                    BundleDownloader.this.processBundleResult(str, iCode, Headers.of(map), buffer, file, bundleInfo, devBundleDownloadListener);
                    return;
                }
                if (map.containsKey(HttpHeaders.CONTENT_TYPE) && map.get(HttpHeaders.CONTENT_TYPE).equals("application/json")) {
                    try {
                        JSONObject jSONObject = new JSONObject(buffer.readUtf8());
                        devBundleDownloadListener.onProgress(jSONObject.has("status") ? jSONObject.getString("status") : "Bundling", jSONObject.has("done") ? Integer.valueOf(jSONObject.getInt("done")) : null, jSONObject.has("total") ? Integer.valueOf(jSONObject.getInt("total")) : null);
                    } catch (JSONException e) {
                        FLog.e("ReactNative", "Error parsing progress JSON. " + e.toString());
                    }
                }
            }

            @Override // com.facebook.react.devsupport.MultipartStreamReader.ChunkListener
            public void onChunkProgress(Map<String, String> map, long j, long j2) {
                if ("application/javascript".equals(map.get(HttpHeaders.CONTENT_TYPE))) {
                    devBundleDownloadListener.onProgress("Downloading", Integer.valueOf((int) (j / 1024)), Integer.valueOf((int) (j2 / 1024)));
                }
            }
        })) {
            return;
        }
        devBundleDownloadListener.onFailure(new DebugServerException("Error while reading multipart response.\n\nResponse code: " + response.code() + "\n\nURL: " + str.toString() + "\n\n"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processBundleResult(String str, int i, Headers headers, BufferedSource bufferedSource, File file, BundleInfo bundleInfo, DevBundleDownloadListener devBundleDownloadListener) throws IOException {
        if (i != 200) {
            String utf8 = bufferedSource.readUtf8();
            DebugServerException debugServerException = DebugServerException.parse(str, utf8);
            if (debugServerException != null) {
                devBundleDownloadListener.onFailure(debugServerException);
                return;
            }
            StringBuilder sb = new StringBuilder("The development server returned response error code: ");
            sb.append(i).append("\n\nURL: ").append(str).append("\n\nBody:\n").append(utf8);
            devBundleDownloadListener.onFailure(new DebugServerException(sb.toString()));
            return;
        }
        if (bundleInfo != null) {
            populateBundleInfo(str, headers, bundleInfo);
        }
        File file2 = new File(file.getPath() + DefaultDiskStorage.FileType.TEMP);
        if (storePlainJSInFile(bufferedSource, file2) && !file2.renameTo(file)) {
            throw new IOException("Couldn't rename " + file2 + " to " + file);
        }
        devBundleDownloadListener.onSuccess();
    }

    private static boolean storePlainJSInFile(BufferedSource bufferedSource, File file) throws Throwable {
        Sink sink;
        try {
            sink = Okio.sink(file);
            try {
                bufferedSource.readAll(sink);
                if (sink == null) {
                    return true;
                }
                sink.close();
                return true;
            } catch (Throwable th) {
                th = th;
                if (sink != null) {
                    sink.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            sink = null;
        }
    }

    private static void populateBundleInfo(String str, Headers headers, BundleInfo bundleInfo) {
        bundleInfo.mUrl = str;
        String str2 = headers.get("X-Metro-Files-Changed-Count");
        if (str2 != null) {
            try {
                bundleInfo.mFilesChangedCount = Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                bundleInfo.mFilesChangedCount = -2;
            }
        }
    }
}

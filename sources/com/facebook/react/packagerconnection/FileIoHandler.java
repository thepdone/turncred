package com.facebook.react.packagerconnection;

import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import com.facebook.common.logging.FLog;
import com.nimbusds.jose.jwk.JWKParameterNames;
import io.sentry.rrweb.RRWebVideoEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class FileIoHandler implements Runnable {
    private static final long FILE_TTL = 30000;
    private static final String TAG = "JSPackagerClient";
    private final Map<String, RequestHandler> mRequestHandlers;
    private int mNextHandle = 1;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Map<Integer, TtlFileInputStream> mOpenFiles = new HashMap();

    private static class TtlFileInputStream {
        private final FileInputStream mStream;
        private long mTtl = System.currentTimeMillis() + 30000;

        public TtlFileInputStream(String str) throws FileNotFoundException {
            this.mStream = new FileInputStream(str);
        }

        private void extendTtl() {
            this.mTtl = System.currentTimeMillis() + 30000;
        }

        public boolean expiredTtl() {
            return System.currentTimeMillis() >= this.mTtl;
        }

        public String read(int i) throws IOException {
            extendTtl();
            byte[] bArr = new byte[i];
            return Base64.encodeToString(bArr, 0, this.mStream.read(bArr), 0);
        }

        public void close() throws IOException {
            this.mStream.close();
        }
    }

    public FileIoHandler() {
        HashMap map = new HashMap();
        this.mRequestHandlers = map;
        map.put("fopen", new RequestOnlyHandler() { // from class: com.facebook.react.packagerconnection.FileIoHandler.1
            @Override // com.facebook.react.packagerconnection.RequestOnlyHandler, com.facebook.react.packagerconnection.RequestHandler
            public void onRequest(Object obj, Responder responder) {
                JSONObject jSONObject;
                synchronized (FileIoHandler.this.mOpenFiles) {
                    try {
                        jSONObject = (JSONObject) obj;
                    } catch (Exception e) {
                        responder.error(e.toString());
                    }
                    if (jSONObject == null) {
                        throw new Exception("params must be an object { mode: string, filename: string }");
                    }
                    String strOptString = jSONObject.optString("mode");
                    if (strOptString == null) {
                        throw new Exception("missing params.mode");
                    }
                    String strOptString2 = jSONObject.optString("filename");
                    if (strOptString2 == null) {
                        throw new Exception("missing params.filename");
                    }
                    if (!strOptString.equals(JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR)) {
                        throw new IllegalArgumentException("unsupported mode: " + strOptString);
                    }
                    responder.respond(Integer.valueOf(FileIoHandler.this.addOpenFile(strOptString2)));
                }
            }
        });
        map.put("fclose", new RequestOnlyHandler() { // from class: com.facebook.react.packagerconnection.FileIoHandler.2
            @Override // com.facebook.react.packagerconnection.RequestOnlyHandler, com.facebook.react.packagerconnection.RequestHandler
            public void onRequest(Object obj, Responder responder) {
                synchronized (FileIoHandler.this.mOpenFiles) {
                    try {
                    } catch (Exception e) {
                        responder.error(e.toString());
                    }
                    if (!(obj instanceof Number)) {
                        throw new Exception("params must be a file handle");
                    }
                    TtlFileInputStream ttlFileInputStream = (TtlFileInputStream) FileIoHandler.this.mOpenFiles.get(obj);
                    if (ttlFileInputStream == null) {
                        throw new Exception("invalid file handle, it might have timed out");
                    }
                    FileIoHandler.this.mOpenFiles.remove(obj);
                    ttlFileInputStream.close();
                    responder.respond("");
                }
            }
        });
        map.put("fread", new RequestOnlyHandler() { // from class: com.facebook.react.packagerconnection.FileIoHandler.3
            @Override // com.facebook.react.packagerconnection.RequestOnlyHandler, com.facebook.react.packagerconnection.RequestHandler
            public void onRequest(Object obj, Responder responder) {
                JSONObject jSONObject;
                synchronized (FileIoHandler.this.mOpenFiles) {
                    try {
                        jSONObject = (JSONObject) obj;
                    } catch (Exception e) {
                        responder.error(e.toString());
                    }
                    if (jSONObject == null) {
                        throw new Exception("params must be an object { file: handle, size: number }");
                    }
                    int iOptInt = jSONObject.optInt("file");
                    if (iOptInt == 0) {
                        throw new Exception("invalid or missing file handle");
                    }
                    int iOptInt2 = jSONObject.optInt(RRWebVideoEvent.JsonKeys.SIZE);
                    if (iOptInt2 == 0) {
                        throw new Exception("invalid or missing read size");
                    }
                    TtlFileInputStream ttlFileInputStream = (TtlFileInputStream) FileIoHandler.this.mOpenFiles.get(Integer.valueOf(iOptInt));
                    if (ttlFileInputStream == null) {
                        throw new Exception("invalid file handle, it might have timed out");
                    }
                    responder.respond(ttlFileInputStream.read(iOptInt2));
                }
            }
        });
    }

    public Map<String, RequestHandler> handlers() {
        return this.mRequestHandlers;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int addOpenFile(String str) throws FileNotFoundException {
        int i = this.mNextHandle;
        this.mNextHandle = i + 1;
        this.mOpenFiles.put(Integer.valueOf(i), new TtlFileInputStream(str));
        if (this.mOpenFiles.size() == 1) {
            this.mHandler.postDelayed(this, 30000L);
        }
        return i;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.mOpenFiles) {
            Iterator<TtlFileInputStream> it = this.mOpenFiles.values().iterator();
            while (it.hasNext()) {
                TtlFileInputStream next = it.next();
                if (next.expiredTtl()) {
                    it.remove();
                    try {
                        next.close();
                    } catch (IOException e) {
                        FLog.e(TAG, "closing expired file failed: " + e.toString());
                    }
                }
            }
            if (!this.mOpenFiles.isEmpty()) {
                this.mHandler.postDelayed(this, 30000L);
            }
        }
    }
}

package com.facebook.react.modules.network;

import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import androidx.browser.trusted.sharing.ShareTarget;
import com.facebook.common.logging.FLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.zip.GZIPOutputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* loaded from: classes4.dex */
class RequestBodyUtil {
    private static final String CONTENT_ENCODING_GZIP = "gzip";
    private static final String NAME = "RequestBodyUtil";
    private static final String TEMP_FILE_SUFFIX = "temp";

    RequestBodyUtil() {
    }

    public static boolean isGzipEncoding(String str) {
        return CONTENT_ENCODING_GZIP.equalsIgnoreCase(str);
    }

    public static InputStream getFileInputStream(Context context, String str) {
        try {
            Uri uri = Uri.parse(str);
            if (uri.getScheme().startsWith("http")) {
                return getDownloadFileInputStream(context, uri);
            }
            if (str.startsWith("data:")) {
                return new ByteArrayInputStream(Base64.decode(str.split(",")[1], 0));
            }
            return context.getContentResolver().openInputStream(uri);
        } catch (Exception e) {
            FLog.e("ReactNative", "Could not retrieve file for contentUri " + str, e);
            return null;
        }
    }

    private static InputStream getDownloadFileInputStream(Context context, Uri uri) throws IOException {
        File fileCreateTempFile = File.createTempFile(NAME, TEMP_FILE_SUFFIX, context.getApplicationContext().getCacheDir());
        fileCreateTempFile.deleteOnExit();
        URL url = new URL(uri.toString());
        FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
        try {
            InputStream inputStreamOpenStream = url.openStream();
            try {
                ReadableByteChannel readableByteChannelNewChannel = Channels.newChannel(inputStreamOpenStream);
                try {
                    fileOutputStream.getChannel().transferFrom(readableByteChannelNewChannel, 0L, Long.MAX_VALUE);
                    FileInputStream fileInputStream = new FileInputStream(fileCreateTempFile);
                    if (readableByteChannelNewChannel != null) {
                        readableByteChannelNewChannel.close();
                    }
                    if (inputStreamOpenStream != null) {
                        inputStreamOpenStream.close();
                    }
                    fileOutputStream.close();
                    return fileInputStream;
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static RequestBody createGzip(MediaType mediaType, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes());
            gZIPOutputStream.close();
            return RequestBody.create(mediaType, byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void closeQuietly(Source source) {
        try {
            source.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static RequestBody create(final MediaType mediaType, final InputStream inputStream) {
        return new RequestBody() { // from class: com.facebook.react.modules.network.RequestBodyUtil.1
            @Override // okhttp3.RequestBody
            /* renamed from: contentType */
            public MediaType get$contentType() {
                return mediaType;
            }

            @Override // okhttp3.RequestBody
            public long contentLength() {
                try {
                    return inputStream.available();
                } catch (IOException unused) {
                    return 0L;
                }
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                Source source = null;
                try {
                    source = Okio.source(inputStream);
                    bufferedSink.writeAll(source);
                } finally {
                    RequestBodyUtil.closeQuietly(source);
                }
            }
        };
    }

    public static ProgressRequestBody createProgressRequest(RequestBody requestBody, ProgressListener progressListener) {
        return new ProgressRequestBody(requestBody, progressListener);
    }

    public static RequestBody getEmptyBody(String str) {
        if (str.equals(ShareTarget.METHOD_POST) || str.equals("PUT") || str.equals("PATCH")) {
            return RequestBody.create((MediaType) null, ByteString.EMPTY);
        }
        return null;
    }
}

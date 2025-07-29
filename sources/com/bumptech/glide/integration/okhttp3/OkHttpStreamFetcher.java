package com.bumptech.glide.integration.okhttp3;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes4.dex */
public class OkHttpStreamFetcher implements DataFetcher<InputStream>, Callback {
    private static final String TAG = "OkHttpFetcher";
    private volatile Call call;
    private DataFetcher.DataCallback<? super InputStream> callback;
    private final Call.Factory client;
    private ResponseBody responseBody;
    private InputStream stream;
    private final GlideUrl url;

    public OkHttpStreamFetcher(Call.Factory factory, GlideUrl glideUrl) {
        this.client = factory;
        this.url = glideUrl;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(Priority priority, DataFetcher.DataCallback<? super InputStream> dataCallback) {
        Request.Builder builderUrl = new Request.Builder().url(this.url.toStringUrl());
        for (Map.Entry<String, String> entry : this.url.getHeaders().entrySet()) {
            builderUrl.addHeader(entry.getKey(), entry.getValue());
        }
        Request requestBuild = builderUrl.build();
        this.callback = dataCallback;
        this.call = this.client.newCall(requestBuild);
        this.call.enqueue(this);
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "OkHttp failed to obtain result", iOException);
        }
        this.callback.onLoadFailed(iOException);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        this.responseBody = response.body();
        if (response.isSuccessful()) {
            InputStream inputStreamObtain = ContentLengthInputStream.obtain(this.responseBody.byteStream(), ((ResponseBody) Preconditions.checkNotNull(this.responseBody)).getContentLength());
            this.stream = inputStreamObtain;
            this.callback.onDataReady(inputStreamObtain);
            return;
        }
        this.callback.onLoadFailed(new HttpException(response.message(), response.code()));
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() throws IOException {
        try {
            InputStream inputStream = this.stream;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
        ResponseBody responseBody = this.responseBody;
        if (responseBody != null) {
            responseBody.close();
        }
        this.callback = null;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        Call call = this.call;
        if (call != null) {
            call.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }
}

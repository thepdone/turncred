package com.shopify.reactnative.skia;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.TextureView;
import com.facebook.react.views.view.ReactViewGroup;

/* loaded from: classes5.dex */
public abstract class SkiaBaseView extends ReactViewGroup implements TextureView.SurfaceTextureListener {
    private boolean isDropped;
    private TextureView mTexture;
    private String tag;

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    protected abstract void registerView(int i);

    protected abstract void setDebugMode(boolean z);

    protected abstract void setMode(String str);

    protected abstract void surfaceAvailable(Object obj, int i, int i2);

    protected abstract void surfaceDestroyed();

    protected abstract void surfaceSizeChanged(int i, int i2);

    protected abstract void unregisterView();

    public SkiaBaseView(Context context) {
        super(context);
        this.tag = "SkiaView";
        this.isDropped = false;
        TextureView textureView = new TextureView(context);
        this.mTexture = textureView;
        textureView.setSurfaceTextureListener(this);
        this.mTexture.setOpaque(false);
        addView(this.mTexture);
    }

    private void createSurfaceTexture() {
        Log.i(this.tag, "Create SurfaceTexture");
        SurfaceTexture surfaceTexture = new SurfaceTexture(false);
        this.mTexture.setSurfaceTexture(surfaceTexture);
        onSurfaceTextureAvailable(surfaceTexture, getMeasuredWidth(), getMeasuredHeight());
    }

    void dropInstance() {
        this.isDropped = true;
        unregisterView();
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getMeasuredWidth() == 0) {
            createSurfaceTexture();
        }
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Log.i(this.tag, "onLayout " + getMeasuredWidth() + "/" + getMeasuredHeight());
        super.onLayout(z, i, i2, i3, i4);
        this.mTexture.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Log.i(this.tag, "onSurfaceTextureAvailable " + i + "/" + i2);
        surfaceAvailable(surfaceTexture, i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.isDropped) {
            return;
        }
        Log.i(this.tag, "onSurfaceTextureSizeChanged " + i + "/" + i2);
        surfaceSizeChanged(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Log.i(this.tag, "onSurfaceTextureDestroyed");
        surfaceDestroyed();
        if (this.isDropped) {
            return false;
        }
        createSurfaceTexture();
        return false;
    }
}

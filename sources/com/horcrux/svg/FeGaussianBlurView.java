package com.horcrux.svg;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.facebook.react.bridge.ReactContext;
import com.horcrux.svg.FilterProperties;
import java.util.HashMap;

/* loaded from: classes5.dex */
class FeGaussianBlurView extends FilterPrimitiveView {
    FilterProperties.EdgeMode mEdgeMode;
    String mIn1;
    float mStdDeviationX;
    float mStdDeviationY;

    public FeGaussianBlurView(ReactContext reactContext) {
        super(reactContext);
    }

    public void setIn1(String str) {
        this.mIn1 = str;
        invalidate();
    }

    public void setStdDeviationX(float f) {
        this.mStdDeviationX = f;
        invalidate();
    }

    public void setStdDeviationY(float f) {
        this.mStdDeviationY = f;
        invalidate();
    }

    public void setEdgeMode(String str) {
        this.mEdgeMode = FilterProperties.EdgeMode.getEnum(str);
        invalidate();
    }

    @Override // com.horcrux.svg.FilterPrimitiveView
    public Bitmap applyFilter(HashMap<String, Bitmap> map, Bitmap bitmap) {
        return blur(getContext(), getSource(map, bitmap, this.mIn1));
    }

    private Bitmap blur(Context context, Bitmap bitmap) {
        float fMax = Math.max(this.mStdDeviationX, this.mStdDeviationY) * 2.0f;
        if (fMax <= 0.0f) {
            return bitmap;
        }
        float fMin = Math.min(fMax, 25.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap);
        RenderScript renderScriptCreate = RenderScript.create(context);
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap);
        Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
        scriptIntrinsicBlurCreate.setRadius(fMin);
        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
        scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
        allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
        allocationCreateFromBitmap.destroy();
        allocationCreateFromBitmap2.destroy();
        renderScriptCreate.destroy();
        return Bitmap.createScaledBitmap(bitmapCreateBitmap, bitmap.getWidth(), bitmap.getHeight(), false);
    }
}

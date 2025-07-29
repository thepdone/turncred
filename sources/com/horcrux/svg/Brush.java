package com.horcrux.svg;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.camera.video.AudioStats;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableArray;
import com.horcrux.svg.SVGLength;

/* loaded from: classes5.dex */
class Brush {
    private ReadableArray mColors;
    private Matrix mMatrix;
    private PatternView mPattern;
    private final SVGLength[] mPoints;
    private final BrushType mType;
    private boolean mUseContentObjectBoundingBoxUnits;
    private final boolean mUseObjectBoundingBox;
    private Rect mUserSpaceBoundingBox;

    enum BrushType {
        LINEAR_GRADIENT,
        RADIAL_GRADIENT,
        PATTERN
    }

    enum BrushUnits {
        OBJECT_BOUNDING_BOX,
        USER_SPACE_ON_USE
    }

    Brush(BrushType brushType, SVGLength[] sVGLengthArr, BrushUnits brushUnits) {
        this.mType = brushType;
        this.mPoints = sVGLengthArr;
        this.mUseObjectBoundingBox = brushUnits == BrushUnits.OBJECT_BOUNDING_BOX;
    }

    void setContentUnits(BrushUnits brushUnits) {
        this.mUseContentObjectBoundingBoxUnits = brushUnits == BrushUnits.OBJECT_BOUNDING_BOX;
    }

    void setPattern(PatternView patternView) {
        this.mPattern = patternView;
    }

    private static void parseGradientStops(ReadableArray readableArray, int i, float[] fArr, int[] iArr, float f) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 2;
            fArr[i2] = (float) readableArray.getDouble(i3);
            iArr[i2] = (readableArray.getInt(i3 + 1) & ViewCompat.MEASURED_SIZE_MASK) | (Math.round((r1 >>> 24) * f) << 24);
        }
    }

    void setUserSpaceBoundingBox(Rect rect) {
        this.mUserSpaceBoundingBox = rect;
    }

    void setGradientColors(ReadableArray readableArray) {
        this.mColors = readableArray;
    }

    void setGradientTransform(Matrix matrix) {
        this.mMatrix = matrix;
    }

    private RectF getPaintRect(RectF rectF) {
        float f;
        float f2;
        if (!this.mUseObjectBoundingBox) {
            rectF = new RectF(this.mUserSpaceBoundingBox);
        }
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        if (this.mUseObjectBoundingBox) {
            f = rectF.left;
            f2 = rectF.top;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        return new RectF(f, f2, fWidth + f, fHeight + f2);
    }

    private double getVal(SVGLength sVGLength, double d, float f, float f2) {
        return PropHelper.fromRelative(sVGLength, d, AudioStats.AUDIO_AMPLITUDE_NONE, (this.mUseObjectBoundingBox && sVGLength.unit == SVGLength.UnitType.NUMBER) ? d : f, f2);
    }

    void setupPaint(Paint paint, RectF rectF, float f, float f2) {
        int[] iArr;
        float[] fArr;
        int[] iArr2;
        float[] fArr2;
        double d;
        RectF paintRect = getPaintRect(rectF);
        float fWidth = paintRect.width();
        float fHeight = paintRect.height();
        float f3 = paintRect.left;
        float f4 = paintRect.top;
        float textSize = paint.getTextSize();
        if (this.mType == BrushType.PATTERN) {
            double d2 = fWidth;
            double val = getVal(this.mPoints[0], d2, f, textSize);
            double d3 = fHeight;
            double val2 = getVal(this.mPoints[1], d3, f, textSize);
            double val3 = getVal(this.mPoints[2], d2, f, textSize);
            double val4 = getVal(this.mPoints[3], d3, f, textSize);
            if (val3 <= 1.0d || val4 <= 1.0d) {
                return;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) val3, (int) val4, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            RectF viewBox = this.mPattern.getViewBox();
            if (viewBox != null && viewBox.width() > 0.0f && viewBox.height() > 0.0f) {
                canvas.concat(ViewBox.getTransform(viewBox, new RectF((float) val, (float) val2, (float) val3, (float) val4), this.mPattern.mAlign, this.mPattern.mMeetOrSlice));
            }
            if (this.mUseContentObjectBoundingBoxUnits) {
                canvas.scale(fWidth / f, fHeight / f);
            }
            this.mPattern.draw(canvas, new Paint(), f2);
            Matrix matrix = new Matrix();
            Matrix matrix2 = this.mMatrix;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            BitmapShader bitmapShader = new BitmapShader(bitmapCreateBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            bitmapShader.setLocalMatrix(matrix);
            paint.setShader(bitmapShader);
            return;
        }
        int size = this.mColors.size();
        if (size == 0) {
            FLog.w("ReactNative", "Gradient contains no stops");
            return;
        }
        int i = size / 2;
        int[] iArr3 = new int[i];
        float[] fArr3 = new float[i];
        parseGradientStops(this.mColors, i, fArr3, iArr3, f2);
        if (i == 1) {
            int[] iArr4 = {iArr3[0], iArr3[0]};
            float[] fArr4 = {fArr3[0], fArr3[0]};
            FLog.w("ReactNative", "Gradient contains only one stop");
            iArr = iArr4;
            fArr = fArr4;
        } else {
            iArr = iArr3;
            fArr = fArr3;
        }
        if (this.mType == BrushType.LINEAR_GRADIENT) {
            double d4 = fWidth;
            double d5 = f3;
            double val5 = getVal(this.mPoints[0], d4, f, textSize) + d5;
            double d6 = fHeight;
            double d7 = f4;
            Shader linearGradient = new LinearGradient((float) val5, (float) (getVal(this.mPoints[1], d6, f, textSize) + d7), (float) (getVal(this.mPoints[2], d4, f, textSize) + d5), (float) (getVal(this.mPoints[3], d6, f, textSize) + d7), iArr, fArr, Shader.TileMode.CLAMP);
            if (this.mMatrix != null) {
                Matrix matrix3 = new Matrix();
                matrix3.preConcat(this.mMatrix);
                linearGradient.setLocalMatrix(matrix3);
            }
            paint.setShader(linearGradient);
            return;
        }
        int[] iArr5 = iArr;
        float[] fArr5 = fArr;
        if (this.mType == BrushType.RADIAL_GRADIENT) {
            double d8 = fWidth;
            double val6 = getVal(this.mPoints[2], d8, f, textSize);
            double d9 = fHeight;
            double val7 = getVal(this.mPoints[3], d9, f, textSize);
            if (val6 <= AudioStats.AUDIO_AMPLITUDE_NONE || val7 <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                float[] fArr6 = {fArr5[0], fArr5[fArr5.length - 1]};
                iArr2 = new int[]{iArr5[iArr5.length - 1], iArr5[iArr5.length - 1]};
                fArr2 = fArr6;
                val7 = d9;
                d = d8;
            } else {
                iArr2 = iArr5;
                fArr2 = fArr5;
                d = val6;
            }
            double d10 = val7 / d;
            Shader radialGradient = new RadialGradient((float) (getVal(this.mPoints[4], d8, f, textSize) + f3), (float) (getVal(this.mPoints[5], d9 / d10, f, textSize) + (f4 / d10)), (float) d, iArr2, fArr2, Shader.TileMode.CLAMP);
            Matrix matrix4 = new Matrix();
            matrix4.preScale(1.0f, (float) d10);
            Matrix matrix5 = this.mMatrix;
            if (matrix5 != null) {
                matrix4.preConcat(matrix5);
            }
            radialGradient.setLocalMatrix(matrix4);
            paint.setShader(radialGradient);
        }
    }
}

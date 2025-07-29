package com.facebook.react.uimanager;

import androidx.camera.video.AudioStats;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.infer.annotation.Assertions;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MatrixMathHelper.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0017\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001:B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0004J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J(\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0007J\b\u0010\u0019\u001a\u00020\bH\u0007J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H\u0007J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\bH\u0007J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0007J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004H\u0002J \u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\bH\u0007J \u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010,\u001a\u00020\bH\u0007J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\bH\u0007J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0004H\u0007J\u0010\u00100\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0007J(\u00101\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0004H\u0007J\u0018\u00104\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\bH\u0007J\u0018\u00105\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\bH\u0007J\u0010\u00106\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\bH\u0007J\u0018\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/facebook/react/uimanager/MatrixMathHelper;", "", "()V", "EPSILON", "", "applyPerspective", "", "m", "", "perspective", "applyRotateX", "radians", "applyRotateY", "applyRotateZ", "applyScaleX", "factor", "applyScaleY", "applyScaleZ", "applySkewX", "applySkewY", "applyTranslate2D", "x", "y", "applyTranslate3D", "z", "createIdentityMatrix", "decomposeMatrix", Snapshot.TRANSFORM_MATRIX, "ctx", "Lcom/facebook/react/uimanager/MatrixMathHelper$MatrixDecompositionContext;", "degreesToRadians", "degrees", "determinant", "matrix", "inverse", "isZero", "", "d", "multiplyInto", "out", "a", "b", "multiplyVectorByMatrix", "v", "result", "resetIdentityMatrix", "roundTo3Places", JWKParameterNames.RSA_MODULUS, "transpose", "v3Combine", "aScale", "bScale", "v3Cross", "v3Dot", "v3Length", "v3Normalize", "vector", "norm", "MatrixDecompositionContext", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MatrixMathHelper {
    private static final double EPSILON = 1.0E-5d;
    public static final MatrixMathHelper INSTANCE = new MatrixMathHelper();

    @JvmStatic
    public static final double degreesToRadians(double degrees) {
        return (degrees * 3.141592653589793d) / RotationOptions.ROTATE_180;
    }

    private MatrixMathHelper() {
    }

    private final boolean isZero(double d) {
        return !Double.isNaN(d) && Math.abs(d) < 1.0E-5d;
    }

    @JvmStatic
    public static final void multiplyInto(double[] out, double[] a2, double[] b) {
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        double d = a2[0];
        double d2 = a2[1];
        double d3 = a2[2];
        double d4 = a2[3];
        double d5 = a2[4];
        double d6 = a2[5];
        double d7 = a2[6];
        double d8 = a2[7];
        double d9 = a2[8];
        double d10 = a2[9];
        double d11 = a2[10];
        double d12 = a2[11];
        double d13 = a2[12];
        double d14 = a2[13];
        double d15 = a2[14];
        double d16 = a2[15];
        double d17 = b[0];
        double d18 = b[1];
        double d19 = b[2];
        double d20 = b[3];
        out[0] = (d17 * d) + (d18 * d5) + (d19 * d9) + (d20 * d13);
        out[1] = (d17 * d2) + (d18 * d6) + (d19 * d10) + (d20 * d14);
        out[2] = (d17 * d3) + (d18 * d7) + (d19 * d11) + (d20 * d15);
        out[3] = (d17 * d4) + (d18 * d8) + (d19 * d12) + (d20 * d16);
        double d21 = b[4];
        double d22 = b[5];
        double d23 = b[6];
        double d24 = b[7];
        out[4] = (d21 * d) + (d22 * d5) + (d23 * d9) + (d24 * d13);
        out[5] = (d21 * d2) + (d22 * d6) + (d23 * d10) + (d24 * d14);
        out[6] = (d21 * d3) + (d22 * d7) + (d23 * d11) + (d24 * d15);
        out[7] = (d21 * d4) + (d22 * d8) + (d23 * d12) + (d24 * d16);
        double d25 = b[8];
        double d26 = b[9];
        double d27 = b[10];
        double d28 = b[11];
        out[8] = (d25 * d) + (d26 * d5) + (d27 * d9) + (d28 * d13);
        out[9] = (d25 * d2) + (d26 * d6) + (d27 * d10) + (d28 * d14);
        out[10] = (d25 * d3) + (d26 * d7) + (d27 * d11) + (d28 * d15);
        out[11] = (d25 * d4) + (d26 * d8) + (d27 * d12) + (d28 * d16);
        double d29 = b[12];
        double d30 = b[13];
        double d31 = b[14];
        double d32 = b[15];
        out[12] = (d * d29) + (d5 * d30) + (d9 * d31) + (d13 * d32);
        out[13] = (d2 * d29) + (d6 * d30) + (d10 * d31) + (d14 * d32);
        out[14] = (d3 * d29) + (d7 * d30) + (d11 * d31) + (d15 * d32);
        out[15] = (d29 * d4) + (d30 * d8) + (d31 * d12) + (d32 * d16);
    }

    @JvmStatic
    public static final void decomposeMatrix(double[] transformMatrix, MatrixDecompositionContext ctx) {
        Intrinsics.checkNotNullParameter(transformMatrix, "transformMatrix");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Assertions.assertCondition(transformMatrix.length == 16);
        double[] dArr = ctx.perspective;
        double[] dArr2 = ctx.scale;
        double[] dArr3 = ctx.skew;
        double[] dArr4 = ctx.translation;
        double[] dArr5 = ctx.rotationDegrees;
        if (INSTANCE.isZero(transformMatrix[15])) {
            return;
        }
        double[][] dArr6 = new double[4][];
        for (int i = 0; i < 4; i++) {
            dArr6[i] = new double[4];
        }
        double[] dArr7 = new double[16];
        for (int i2 = 0; i2 < 4; i2++) {
            for (int i3 = 0; i3 < 4; i3++) {
                int i4 = (i2 * 4) + i3;
                double d = transformMatrix[i4] / transformMatrix[15];
                dArr6[i2][i3] = d;
                if (i3 == 3) {
                    d = AudioStats.AUDIO_AMPLITUDE_NONE;
                }
                dArr7[i4] = d;
            }
        }
        dArr7[15] = 1.0d;
        MatrixMathHelper matrixMathHelper = INSTANCE;
        if (matrixMathHelper.isZero(determinant(dArr7))) {
            return;
        }
        if (!matrixMathHelper.isZero(dArr6[0][3]) || !matrixMathHelper.isZero(dArr6[1][3]) || !matrixMathHelper.isZero(dArr6[2][3])) {
            multiplyVectorByMatrix(new double[]{dArr6[0][3], dArr6[1][3], dArr6[2][3], dArr6[3][3]}, transpose(inverse(dArr7)), dArr);
        } else {
            dArr[2] = 0.0d;
            dArr[1] = 0.0d;
            dArr[0] = 0.0d;
            dArr[3] = 1.0d;
        }
        for (int i5 = 0; i5 < 3; i5++) {
            dArr4[i5] = dArr6[3][i5];
        }
        double[][] dArr8 = new double[3][];
        for (int i6 = 0; i6 < 3; i6++) {
            dArr8[i6] = new double[3];
        }
        for (int i7 = 0; i7 < 3; i7++) {
            double[] dArr9 = dArr8[i7];
            double[] dArr10 = dArr6[i7];
            dArr9[0] = dArr10[0];
            dArr9[1] = dArr10[1];
            dArr9[2] = dArr10[2];
        }
        double dV3Length = v3Length(dArr8[0]);
        dArr2[0] = dV3Length;
        double[] dArrV3Normalize = v3Normalize(dArr8[0], dV3Length);
        dArr8[0] = dArrV3Normalize;
        double dV3Dot = v3Dot(dArrV3Normalize, dArr8[1]);
        dArr3[0] = dV3Dot;
        double[] dArrV3Combine = v3Combine(dArr8[1], dArr8[0], 1.0d, -dV3Dot);
        dArr8[1] = dArrV3Combine;
        double dV3Length2 = v3Length(dArrV3Combine);
        dArr2[1] = dV3Length2;
        dArr8[1] = v3Normalize(dArr8[1], dV3Length2);
        dArr3[0] = dArr3[0] / dArr2[1];
        double dV3Dot2 = v3Dot(dArr8[0], dArr8[2]);
        dArr3[1] = dV3Dot2;
        double[] dArrV3Combine2 = v3Combine(dArr8[2], dArr8[0], 1.0d, -dV3Dot2);
        dArr8[2] = dArrV3Combine2;
        double dV3Dot3 = v3Dot(dArr8[1], dArrV3Combine2);
        dArr3[2] = dV3Dot3;
        double[] dArrV3Combine3 = v3Combine(dArr8[2], dArr8[1], 1.0d, -dV3Dot3);
        dArr8[2] = dArrV3Combine3;
        double dV3Length3 = v3Length(dArrV3Combine3);
        dArr2[2] = dV3Length3;
        double[] dArrV3Normalize2 = v3Normalize(dArr8[2], dV3Length3);
        dArr8[2] = dArrV3Normalize2;
        double d2 = dArr3[1];
        double d3 = dArr2[2];
        dArr3[1] = d2 / d3;
        dArr3[2] = dArr3[2] / d3;
        if (v3Dot(dArr8[0], v3Cross(dArr8[1], dArrV3Normalize2)) < AudioStats.AUDIO_AMPLITUDE_NONE) {
            for (int i8 = 0; i8 < 3; i8++) {
                dArr2[i8] = dArr2[i8] * (-1.0d);
                double[] dArr11 = dArr8[i8];
                dArr11[0] = dArr11[0] * (-1.0d);
                dArr11[1] = dArr11[1] * (-1.0d);
                dArr11[2] = dArr11[2] * (-1.0d);
            }
        }
        double[] dArr12 = dArr8[2];
        dArr5[0] = roundTo3Places((-Math.atan2(dArr12[1], dArr12[2])) * 57.29577951308232d);
        double[] dArr13 = dArr8[2];
        double d4 = -dArr13[0];
        double d5 = dArr13[1];
        double d6 = dArr13[2];
        dArr5[1] = roundTo3Places((-Math.atan2(d4, Math.sqrt((d5 * d5) + (d6 * d6)))) * 57.29577951308232d);
        dArr5[2] = roundTo3Places((-Math.atan2(dArr8[1][0], dArr8[0][0])) * 57.29577951308232d);
    }

    @JvmStatic
    public static final double determinant(double[] matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        double d = matrix[0];
        double d2 = matrix[1];
        double d3 = matrix[2];
        double d4 = matrix[3];
        double d5 = matrix[4];
        double d6 = matrix[5];
        double d7 = matrix[6];
        double d8 = matrix[7];
        double d9 = matrix[8];
        double d10 = matrix[9];
        double d11 = matrix[10];
        double d12 = matrix[11];
        double d13 = matrix[12];
        double d14 = matrix[13];
        double d15 = matrix[14];
        double d16 = matrix[15];
        double d17 = d4 * d7;
        double d18 = d3 * d8;
        double d19 = d4 * d6;
        double d20 = d2 * d8;
        double d21 = d3 * d6;
        double d22 = d2 * d7;
        double d23 = d4 * d5;
        double d24 = d8 * d;
        double d25 = d3 * d5;
        double d26 = d7 * d;
        double d27 = d2 * d5;
        double d28 = d * d6;
        return ((((((((((((((((((((((((d17 * d10) * d13) - ((d18 * d10) * d13)) - ((d19 * d11) * d13)) + ((d20 * d11) * d13)) + ((d21 * d12) * d13)) - ((d22 * d12) * d13)) - ((d17 * d9) * d14)) + ((d18 * d9) * d14)) + ((d23 * d11) * d14)) - ((d24 * d11) * d14)) - ((d25 * d12) * d14)) + ((d26 * d12) * d14)) + ((d19 * d9) * d15)) - ((d20 * d9) * d15)) - ((d23 * d10) * d15)) + ((d24 * d10) * d15)) + ((d27 * d12) * d15)) - ((d12 * d28) * d15)) - ((d21 * d9) * d16)) + ((d22 * d9) * d16)) + ((d25 * d10) * d16)) - ((d26 * d10) * d16)) - ((d27 * d11) * d16)) + (d28 * d11 * d16);
    }

    @JvmStatic
    public static final double[] inverse(double[] matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        MatrixMathHelper matrixMathHelper = INSTANCE;
        double dDeterminant = determinant(matrix);
        if (matrixMathHelper.isZero(dDeterminant)) {
            return matrix;
        }
        double d = matrix[0];
        double d2 = matrix[1];
        double d3 = matrix[2];
        double d4 = matrix[3];
        double d5 = matrix[4];
        double d6 = matrix[5];
        double d7 = matrix[6];
        double d8 = matrix[7];
        double d9 = matrix[8];
        double d10 = matrix[9];
        double d11 = matrix[10];
        double d12 = matrix[11];
        double d13 = matrix[12];
        double d14 = matrix[13];
        double d15 = matrix[14];
        double d16 = matrix[15];
        double d17 = d7 * d12;
        double d18 = d8 * d11;
        double d19 = d8 * d10;
        double d20 = d6 * d12;
        double d21 = d7 * d10;
        double d22 = d6 * d11;
        double d23 = d4 * d11;
        double d24 = d3 * d12;
        double d25 = d4 * d10;
        double d26 = d2 * d12;
        double d27 = d3 * d10;
        double d28 = d2 * d11;
        double d29 = d3 * d8;
        double d30 = d4 * d7;
        double d31 = d4 * d6;
        double d32 = d2 * d8;
        double d33 = d3 * d6;
        double d34 = d2 * d7;
        double d35 = (d18 * d13) - (d17 * d13);
        double d36 = d8 * d9;
        double d37 = d5 * d12;
        double d38 = d7 * d9;
        double d39 = d5 * d11;
        double d40 = (d24 * d13) - (d23 * d13);
        double d41 = d4 * d9;
        double d42 = d * d12;
        double d43 = d3 * d9;
        double d44 = d * d11;
        double d45 = d4 * d5;
        double d46 = d8 * d;
        double d47 = d3 * d5;
        double d48 = d7 * d;
        double d49 = (((d20 * d13) - (d19 * d13)) + (d36 * d14)) - (d37 * d14);
        double d50 = d6 * d9;
        double d51 = d5 * d10;
        double d52 = (((d25 * d13) - (d26 * d13)) - (d41 * d14)) + (d42 * d14);
        double d53 = d2 * d9;
        double d54 = d * d10;
        double d55 = d2 * d5;
        double d56 = d * d6;
        return new double[]{((((((d17 * d14) - (d18 * d14)) + (d19 * d15)) - (d20 * d15)) - (d21 * d16)) + (d22 * d16)) / dDeterminant, ((((((d23 * d14) - (d24 * d14)) - (d25 * d15)) + (d26 * d15)) + (d27 * d16)) - (d28 * d16)) / dDeterminant, ((((((d29 * d14) - (d30 * d14)) + (d31 * d15)) - (d32 * d15)) - (d33 * d16)) + (d34 * d16)) / dDeterminant, ((((((d30 * d10) - (d29 * d10)) - (d31 * d11)) + (d32 * d11)) + (d33 * d12)) - (d34 * d12)) / dDeterminant, ((((d35 - (d36 * d15)) + (d37 * d15)) + (d38 * d16)) - (d39 * d16)) / dDeterminant, ((((d40 + (d41 * d15)) - (d42 * d15)) - (d43 * d16)) + (d44 * d16)) / dDeterminant, ((((((d30 * d13) - (d29 * d13)) - (d45 * d15)) + (d46 * d15)) + (d47 * d16)) - (d48 * d16)) / dDeterminant, ((((((d29 * d9) - (d30 * d9)) + (d45 * d11)) - (d46 * d11)) - (d47 * d12)) + (d48 * d12)) / dDeterminant, ((d49 - (d50 * d16)) + (d51 * d16)) / dDeterminant, ((d52 + (d53 * d16)) - (d54 * d16)) / dDeterminant, ((((((d32 * d13) - (d31 * d13)) + (d45 * d14)) - (d46 * d14)) - (d55 * d16)) + (d16 * d56)) / dDeterminant, ((((((d31 * d9) - (d32 * d9)) - (d45 * d10)) + (d46 * d10)) + (d55 * d12)) - (d12 * d56)) / dDeterminant, ((((((d21 * d13) - (d22 * d13)) - (d38 * d14)) + (d39 * d14)) + (d50 * d15)) - (d51 * d15)) / dDeterminant, ((((((d28 * d13) - (d27 * d13)) + (d43 * d14)) - (d44 * d14)) - (d53 * d15)) + (d54 * d15)) / dDeterminant, ((((((d33 * d13) - (d13 * d34)) - (d47 * d14)) + (d14 * d48)) + (d55 * d15)) - (d15 * d56)) / dDeterminant, ((((((d34 * d9) - (d33 * d9)) + (d47 * d10)) - (d48 * d10)) - (d55 * d11)) + (d56 * d11)) / dDeterminant};
    }

    @JvmStatic
    public static final double[] transpose(double[] m) {
        Intrinsics.checkNotNullParameter(m, "m");
        return new double[]{m[0], m[4], m[8], m[12], m[1], m[5], m[9], m[13], m[2], m[6], m[10], m[14], m[3], m[7], m[11], m[15]};
    }

    @JvmStatic
    public static final void multiplyVectorByMatrix(double[] v, double[] m, double[] result) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(m, "m");
        Intrinsics.checkNotNullParameter(result, "result");
        double d = v[0];
        double d2 = v[1];
        double d3 = v[2];
        double d4 = v[3];
        result[0] = (m[0] * d) + (m[4] * d2) + (m[8] * d3) + (m[12] * d4);
        result[1] = (m[1] * d) + (m[5] * d2) + (m[9] * d3) + (m[13] * d4);
        result[2] = (m[2] * d) + (m[6] * d2) + (m[10] * d3) + (m[14] * d4);
        result[3] = (d * m[3]) + (d2 * m[7]) + (d3 * m[11]) + (d4 * m[15]);
    }

    @JvmStatic
    public static final double v3Length(double[] a2) {
        Intrinsics.checkNotNullParameter(a2, "a");
        double d = a2[0];
        double d2 = a2[1];
        double d3 = (d * d) + (d2 * d2);
        double d4 = a2[2];
        return Math.sqrt(d3 + (d4 * d4));
    }

    @JvmStatic
    public static final double[] v3Normalize(double[] vector, double norm) {
        Intrinsics.checkNotNullParameter(vector, "vector");
        double d = 1;
        if (INSTANCE.isZero(norm)) {
            norm = v3Length(vector);
        }
        double d2 = d / norm;
        return new double[]{vector[0] * d2, vector[1] * d2, vector[2] * d2};
    }

    @JvmStatic
    public static final double v3Dot(double[] a2, double[] b) {
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        return (a2[0] * b[0]) + (a2[1] * b[1]) + (a2[2] * b[2]);
    }

    @JvmStatic
    public static final double[] v3Combine(double[] a2, double[] b, double aScale, double bScale) {
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        return new double[]{(a2[0] * aScale) + (b[0] * bScale), (a2[1] * aScale) + (b[1] * bScale), (aScale * a2[2]) + (bScale * b[2])};
    }

    @JvmStatic
    public static final double[] v3Cross(double[] a2, double[] b) {
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        double d = a2[1];
        double d2 = b[2];
        double d3 = a2[2];
        double d4 = b[1];
        double d5 = b[0];
        double d6 = a2[0];
        return new double[]{(d * d2) - (d3 * d4), (d3 * d5) - (d2 * d6), (d6 * d4) - (d * d5)};
    }

    @JvmStatic
    public static final double roundTo3Places(double n) {
        return Math.round(n * 1000.0d) * 0.001d;
    }

    @JvmStatic
    public static final double[] createIdentityMatrix() {
        double[] dArr = new double[16];
        resetIdentityMatrix(dArr);
        return dArr;
    }

    @JvmStatic
    public static final void resetIdentityMatrix(double[] matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        matrix[14] = 0.0d;
        matrix[13] = 0.0d;
        matrix[12] = 0.0d;
        matrix[11] = 0.0d;
        matrix[9] = 0.0d;
        matrix[8] = 0.0d;
        matrix[7] = 0.0d;
        matrix[6] = 0.0d;
        matrix[4] = 0.0d;
        matrix[3] = 0.0d;
        matrix[2] = 0.0d;
        matrix[1] = 0.0d;
        matrix[15] = 1.0d;
        matrix[10] = 1.0d;
        matrix[5] = 1.0d;
        matrix[0] = 1.0d;
    }

    @JvmStatic
    public static final void applyPerspective(double[] m, double perspective) {
        Intrinsics.checkNotNullParameter(m, "m");
        m[11] = (-1) / perspective;
    }

    @JvmStatic
    public static final void applyScaleX(double[] m, double factor) {
        Intrinsics.checkNotNullParameter(m, "m");
        m[0] = factor;
    }

    @JvmStatic
    public static final void applyScaleY(double[] m, double factor) {
        Intrinsics.checkNotNullParameter(m, "m");
        m[5] = factor;
    }

    public final void applyScaleZ(double[] m, double factor) {
        Intrinsics.checkNotNullParameter(m, "m");
        m[10] = factor;
    }

    @JvmStatic
    public static final void applyTranslate2D(double[] m, double x, double y) {
        Intrinsics.checkNotNullParameter(m, "m");
        m[12] = x;
        m[13] = y;
    }

    @JvmStatic
    public static final void applyTranslate3D(double[] m, double x, double y, double z) {
        Intrinsics.checkNotNullParameter(m, "m");
        m[12] = x;
        m[13] = y;
        m[14] = z;
    }

    @JvmStatic
    public static final void applySkewX(double[] m, double radians) {
        Intrinsics.checkNotNullParameter(m, "m");
        m[4] = Math.tan(radians);
    }

    @JvmStatic
    public static final void applySkewY(double[] m, double radians) {
        Intrinsics.checkNotNullParameter(m, "m");
        m[1] = Math.tan(radians);
    }

    @JvmStatic
    public static final void applyRotateX(double[] m, double radians) {
        Intrinsics.checkNotNullParameter(m, "m");
        m[5] = Math.cos(radians);
        m[6] = Math.sin(radians);
        m[9] = -Math.sin(radians);
        m[10] = Math.cos(radians);
    }

    @JvmStatic
    public static final void applyRotateY(double[] m, double radians) {
        Intrinsics.checkNotNullParameter(m, "m");
        m[0] = Math.cos(radians);
        m[2] = -Math.sin(radians);
        m[8] = Math.sin(radians);
        m[10] = Math.cos(radians);
    }

    @JvmStatic
    public static final void applyRotateZ(double[] m, double radians) {
        Intrinsics.checkNotNullParameter(m, "m");
        m[0] = Math.cos(radians);
        m[1] = Math.sin(radians);
        m[4] = -Math.sin(radians);
        m[5] = Math.cos(radians);
    }

    /* compiled from: MatrixMathHelper.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/react/uimanager/MatrixMathHelper$MatrixDecompositionContext;", "", "()V", "perspective", "", "rotationDegrees", "scale", "skew", "translation", "reset", "", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static class MatrixDecompositionContext {
        private static final Companion Companion = new Companion(null);
        public double[] perspective = new double[4];
        public double[] scale = new double[3];
        public double[] skew = new double[3];
        public double[] translation = new double[3];
        public double[] rotationDegrees = new double[3];

        public final void reset() {
            Companion companion = Companion;
            companion.resetArray(this.perspective);
            companion.resetArray(this.scale);
            companion.resetArray(this.skew);
            companion.resetArray(this.translation);
            companion.resetArray(this.rotationDegrees);
        }

        /* compiled from: MatrixMathHelper.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0013\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/uimanager/MatrixMathHelper$MatrixDecompositionContext$Companion;", "", "()V", "resetArray", "", "arr", "", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void resetArray(double[] arr) {
                int length = arr.length;
                for (int i = 0; i < length; i++) {
                    arr[i] = 0.0d;
                }
            }
        }
    }
}

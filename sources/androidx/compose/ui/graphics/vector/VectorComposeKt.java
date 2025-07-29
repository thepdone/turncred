package androidx.compose.ui.graphics.vector;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* compiled from: VectorCompose.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a¦\u0001\u0010\u0014\u001a\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"Group", "", "name", "", ViewProps.ROTATION, "", "pivotX", "pivotY", ViewProps.SCALE_X, ViewProps.SCALE_Y, "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "(Ljava/lang/String;FFFFFFFLjava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Path", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "Path-9cdaXJ4", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLandroidx/compose/runtime/Composer;III)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VectorComposeKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Group(java.lang.String r21, float r22, float r23, float r24, float r25, float r26, float r27, float r28, java.util.List<? extends androidx.compose.ui.graphics.vector.PathNode> r29, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 656
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorComposeKt.Group(java.lang.String, float, float, float, float, float, float, float, java.util.List, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:216:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0122  */
    /* renamed from: Path-9cdaXJ4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m2981Path9cdaXJ4(final java.util.List<? extends androidx.compose.ui.graphics.vector.PathNode> r30, int r31, java.lang.String r32, androidx.compose.ui.graphics.Brush r33, float r34, androidx.compose.ui.graphics.Brush r35, float r36, float r37, int r38, int r39, float r40, float r41, float r42, float r43, androidx.compose.runtime.Composer r44, final int r45, final int r46, final int r47) {
        /*
            Method dump skipped, instructions count: 840
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorComposeKt.m2981Path9cdaXJ4(java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, androidx.compose.runtime.Composer, int, int, int):void");
    }
}

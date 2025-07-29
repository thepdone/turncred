package androidx.compose.ui.unit.fontscaling;

import com.nimbusds.jose.jwk.JWKParameterNames;
import kotlin.Metadata;

/* compiled from: FontScaleConverter.android.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/unit/fontscaling/FontScaleConverter;", "", "convertDpToSp", "", JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, "convertSpToDp", "sp", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface FontScaleConverter {
    float convertDpToSp(float dp);

    float convertSpToDp(float sp);
}

package com.google.zxing.client.result;

import androidx.camera.video.AudioStats;
import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public final class GeoResultParser extends ResultParser {
    private static final Pattern GEO_URL_PATTERN = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);

    @Override // com.google.zxing.client.result.ResultParser
    public GeoParsedResult parse(Result result) throws NumberFormatException {
        Matcher matcher = GEO_URL_PATTERN.matcher(getMassagedText(result));
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(4);
        try {
            double d = Double.parseDouble(matcher.group(1));
            if (d <= 90.0d && d >= -90.0d) {
                double d2 = Double.parseDouble(matcher.group(2));
                if (d2 <= 180.0d && d2 >= -180.0d) {
                    String strGroup2 = matcher.group(3);
                    double d3 = AudioStats.AUDIO_AMPLITUDE_NONE;
                    if (strGroup2 != null) {
                        double d4 = Double.parseDouble(matcher.group(3));
                        if (d4 < AudioStats.AUDIO_AMPLITUDE_NONE) {
                            return null;
                        }
                        d3 = d4;
                    }
                    return new GeoParsedResult(d, d2, d3, strGroup);
                }
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }
}

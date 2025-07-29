package io.sentry;

import java.util.List;

/* loaded from: classes5.dex */
public final class BaggageHeader {
    public static final String BAGGAGE_HEADER = "baggage";
    private final String value;

    public static BaggageHeader fromBaggageAndOutgoingHeader(Baggage baggage, List<String> list) {
        String headerString = baggage.toHeaderString(Baggage.fromHeader(list, true, baggage.logger).getThirdPartyHeader());
        if (headerString.isEmpty()) {
            return null;
        }
        return new BaggageHeader(headerString);
    }

    public BaggageHeader(String str) {
        this.value = str;
    }

    public String getName() {
        return BAGGAGE_HEADER;
    }

    public String getValue() {
        return this.value;
    }
}

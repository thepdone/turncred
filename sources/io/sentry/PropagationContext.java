package io.sentry;

import com.facebook.hermes.intl.Constants;
import io.sentry.exception.InvalidSentryTraceHeaderException;
import io.sentry.protocol.SentryId;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes5.dex */
public final class PropagationContext {
    private Baggage baggage;
    private SpanId parentSpanId;
    private Boolean sampled;
    private SpanId spanId;
    private SentryId traceId;

    public static PropagationContext fromHeaders(ILogger iLogger, String str, String str2) {
        return fromHeaders(iLogger, str, (List<String>) Arrays.asList(str2));
    }

    public static PropagationContext fromHeaders(ILogger iLogger, String str, List<String> list) {
        if (str == null) {
            return new PropagationContext();
        }
        try {
            return fromHeaders(new SentryTraceHeader(str), Baggage.fromHeader(list, iLogger), (SpanId) null);
        } catch (InvalidSentryTraceHeaderException e) {
            iLogger.log(SentryLevel.DEBUG, e, "Failed to parse Sentry trace header: %s", e.getMessage());
            return new PropagationContext();
        }
    }

    public static PropagationContext fromHeaders(SentryTraceHeader sentryTraceHeader, Baggage baggage, SpanId spanId) {
        if (spanId == null) {
            spanId = new SpanId();
        }
        return new PropagationContext(sentryTraceHeader.getTraceId(), spanId, sentryTraceHeader.getSpanId(), baggage, sentryTraceHeader.isSampled());
    }

    public PropagationContext() {
        this(new SentryId(), new SpanId(), null, null, null);
    }

    public PropagationContext(PropagationContext propagationContext) {
        this(propagationContext.getTraceId(), propagationContext.getSpanId(), propagationContext.getParentSpanId(), cloneBaggage(propagationContext.getBaggage()), propagationContext.isSampled());
    }

    private static Baggage cloneBaggage(Baggage baggage) {
        if (baggage != null) {
            return new Baggage(baggage);
        }
        return null;
    }

    public PropagationContext(SentryId sentryId, SpanId spanId, SpanId spanId2, Baggage baggage, Boolean bool) {
        this.traceId = sentryId;
        this.spanId = spanId;
        this.parentSpanId = spanId2;
        this.baggage = baggage;
        this.sampled = bool;
    }

    public SentryId getTraceId() {
        return this.traceId;
    }

    public void setTraceId(SentryId sentryId) {
        this.traceId = sentryId;
    }

    public SpanId getSpanId() {
        return this.spanId;
    }

    public void setSpanId(SpanId spanId) {
        this.spanId = spanId;
    }

    public SpanId getParentSpanId() {
        return this.parentSpanId;
    }

    public void setParentSpanId(SpanId spanId) {
        this.parentSpanId = spanId;
    }

    public Baggage getBaggage() {
        return this.baggage;
    }

    public void setBaggage(Baggage baggage) {
        this.baggage = baggage;
    }

    public Boolean isSampled() {
        return this.sampled;
    }

    public void setSampled(Boolean bool) {
        this.sampled = bool;
    }

    public TraceContext traceContext() {
        Baggage baggage = this.baggage;
        if (baggage != null) {
            return baggage.toTraceContext();
        }
        return null;
    }

    public SpanContext toSpanContext() {
        SpanContext spanContext = new SpanContext(this.traceId, this.spanId, Constants.COLLATION_DEFAULT, null, null);
        spanContext.setOrigin("auto");
        return spanContext;
    }
}

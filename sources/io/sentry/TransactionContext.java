package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.util.Objects;

/* loaded from: classes5.dex */
public final class TransactionContext extends SpanContext {
    private static final String DEFAULT_NAME = "<unlabeled transaction>";
    private static final TransactionNameSource DEFAULT_NAME_SOURCE = TransactionNameSource.CUSTOM;
    private static final String DEFAULT_OPERATION = "default";
    private Baggage baggage;
    private Instrumenter instrumenter;
    private boolean isForNextAppStart;
    private String name;
    private TracesSamplingDecision parentSamplingDecision;
    private TransactionNameSource transactionNameSource;

    @Deprecated
    public static TransactionContext fromSentryTrace(String str, String str2, SentryTraceHeader sentryTraceHeader) {
        Boolean boolIsSampled = sentryTraceHeader.isSampled();
        TransactionContext transactionContext = new TransactionContext(sentryTraceHeader.getTraceId(), new SpanId(), sentryTraceHeader.getSpanId(), boolIsSampled == null ? null : new TracesSamplingDecision(boolIsSampled), null);
        transactionContext.setName(str);
        transactionContext.setTransactionNameSource(TransactionNameSource.CUSTOM);
        transactionContext.setOperation(str2);
        return transactionContext;
    }

    public static TransactionContext fromPropagationContext(PropagationContext propagationContext) throws NumberFormatException {
        TracesSamplingDecision tracesSamplingDecision;
        Boolean boolIsSampled = propagationContext.isSampled();
        TracesSamplingDecision tracesSamplingDecision2 = boolIsSampled == null ? null : new TracesSamplingDecision(boolIsSampled);
        Baggage baggage = propagationContext.getBaggage();
        if (baggage != null) {
            baggage.freeze();
            Double sampleRateDouble = baggage.getSampleRateDouble();
            Boolean boolValueOf = Boolean.valueOf(boolIsSampled != null ? boolIsSampled.booleanValue() : false);
            if (sampleRateDouble != null) {
                tracesSamplingDecision = new TracesSamplingDecision(boolValueOf, sampleRateDouble);
            } else {
                tracesSamplingDecision2 = new TracesSamplingDecision(boolValueOf);
                tracesSamplingDecision = tracesSamplingDecision2;
            }
        } else {
            tracesSamplingDecision = tracesSamplingDecision2;
        }
        return new TransactionContext(propagationContext.getTraceId(), propagationContext.getSpanId(), propagationContext.getParentSpanId(), tracesSamplingDecision, baggage);
    }

    public TransactionContext(String str, String str2) {
        this(str, str2, (TracesSamplingDecision) null);
    }

    public TransactionContext(String str, TransactionNameSource transactionNameSource, String str2) {
        this(str, transactionNameSource, str2, null);
    }

    public TransactionContext(String str, String str2, TracesSamplingDecision tracesSamplingDecision) {
        this(str, TransactionNameSource.CUSTOM, str2, tracesSamplingDecision);
    }

    public TransactionContext(String str, TransactionNameSource transactionNameSource, String str2, TracesSamplingDecision tracesSamplingDecision) {
        super(str2);
        this.instrumenter = Instrumenter.SENTRY;
        this.isForNextAppStart = false;
        this.name = (String) Objects.requireNonNull(str, "name is required");
        this.transactionNameSource = transactionNameSource;
        setSamplingDecision(tracesSamplingDecision);
    }

    public TransactionContext(SentryId sentryId, SpanId spanId, SpanId spanId2, TracesSamplingDecision tracesSamplingDecision, Baggage baggage) {
        super(sentryId, spanId, "default", spanId2, null);
        this.instrumenter = Instrumenter.SENTRY;
        this.isForNextAppStart = false;
        this.name = DEFAULT_NAME;
        this.parentSamplingDecision = tracesSamplingDecision;
        this.transactionNameSource = DEFAULT_NAME_SOURCE;
        this.baggage = baggage;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getParentSampled() {
        TracesSamplingDecision tracesSamplingDecision = this.parentSamplingDecision;
        if (tracesSamplingDecision == null) {
            return null;
        }
        return tracesSamplingDecision.getSampled();
    }

    public TracesSamplingDecision getParentSamplingDecision() {
        return this.parentSamplingDecision;
    }

    public Baggage getBaggage() {
        return this.baggage;
    }

    public void setParentSampled(Boolean bool) {
        if (bool == null) {
            this.parentSamplingDecision = null;
        } else {
            this.parentSamplingDecision = new TracesSamplingDecision(bool);
        }
    }

    public void setParentSampled(Boolean bool, Boolean bool2) {
        if (bool == null) {
            this.parentSamplingDecision = null;
        } else if (bool2 == null) {
            this.parentSamplingDecision = new TracesSamplingDecision(bool);
        } else {
            this.parentSamplingDecision = new TracesSamplingDecision(bool, null, bool2, null);
        }
    }

    public TransactionNameSource getTransactionNameSource() {
        return this.transactionNameSource;
    }

    public Instrumenter getInstrumenter() {
        return this.instrumenter;
    }

    public void setInstrumenter(Instrumenter instrumenter) {
        this.instrumenter = instrumenter;
    }

    public void setName(String str) {
        this.name = (String) Objects.requireNonNull(str, "name is required");
    }

    public void setTransactionNameSource(TransactionNameSource transactionNameSource) {
        this.transactionNameSource = transactionNameSource;
    }

    public void setForNextAppStart(boolean z) {
        this.isForNextAppStart = z;
    }

    public boolean isForNextAppStart() {
        return this.isForNextAppStart;
    }
}

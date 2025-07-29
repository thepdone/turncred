package io.sentry.protocol;

import androidx.camera.video.AudioStats;
import io.sentry.DateUtils;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryBaseEvent;
import io.sentry.SentryTracer;
import io.sentry.Span;
import io.sentry.SpanContext;
import io.sentry.SpanStatus;
import io.sentry.TracesSamplingDecision;
import io.sentry.metrics.LocalMetricsAggregator;
import io.sentry.protocol.MeasurementValue;
import io.sentry.protocol.MetricSummary;
import io.sentry.protocol.SentrySpan;
import io.sentry.protocol.TransactionInfo;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public final class SentryTransaction extends SentryBaseEvent implements JsonUnknown, JsonSerializable {
    private final Map<String, MeasurementValue> measurements;
    private Map<String, List<MetricSummary>> metricSummaries;
    private final List<SentrySpan> spans;
    private Double startTimestamp;
    private Double timestamp;
    private String transaction;
    private TransactionInfo transactionInfo;
    private final String type;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String MEASUREMENTS = "measurements";
        public static final String METRICS_SUMMARY = "_metrics_summary";
        public static final String SPANS = "spans";
        public static final String START_TIMESTAMP = "start_timestamp";
        public static final String TIMESTAMP = "timestamp";
        public static final String TRANSACTION = "transaction";
        public static final String TRANSACTION_INFO = "transaction_info";
        public static final String TYPE = "type";
    }

    public SentryTransaction(SentryTracer sentryTracer) {
        super(sentryTracer.getEventId());
        this.spans = new ArrayList();
        this.type = "transaction";
        this.measurements = new HashMap();
        Objects.requireNonNull(sentryTracer, "sentryTracer is required");
        this.startTimestamp = Double.valueOf(DateUtils.nanosToSeconds(sentryTracer.getStartDate().nanoTimestamp()));
        this.timestamp = Double.valueOf(DateUtils.nanosToSeconds(sentryTracer.getStartDate().laterDateNanosTimestampByDiff(sentryTracer.getFinishDate())));
        this.transaction = sentryTracer.getName();
        for (Span span : sentryTracer.getChildren()) {
            if (Boolean.TRUE.equals(span.isSampled())) {
                this.spans.add(new SentrySpan(span));
            }
        }
        Contexts contexts = getContexts();
        contexts.putAll(sentryTracer.getContexts());
        SpanContext spanContext = sentryTracer.getSpanContext();
        contexts.setTrace(new SpanContext(spanContext.getTraceId(), spanContext.getSpanId(), spanContext.getParentSpanId(), spanContext.getOperation(), spanContext.getDescription(), spanContext.getSamplingDecision(), spanContext.getStatus(), spanContext.getOrigin()));
        for (Map.Entry<String, String> entry : spanContext.getTags().entrySet()) {
            setTag(entry.getKey(), entry.getValue());
        }
        Map<String, Object> data = sentryTracer.getData();
        if (data != null) {
            for (Map.Entry<String, Object> entry2 : data.entrySet()) {
                setExtra(entry2.getKey(), entry2.getValue());
            }
        }
        this.transactionInfo = new TransactionInfo(sentryTracer.getTransactionNameSource().apiName());
        LocalMetricsAggregator localMetricsAggregator = sentryTracer.getLocalMetricsAggregator();
        if (localMetricsAggregator != null) {
            this.metricSummaries = localMetricsAggregator.getSummaries();
        } else {
            this.metricSummaries = null;
        }
    }

    public SentryTransaction(String str, Double d, Double d2, List<SentrySpan> list, Map<String, MeasurementValue> map, Map<String, List<MetricSummary>> map2, TransactionInfo transactionInfo) {
        ArrayList arrayList = new ArrayList();
        this.spans = arrayList;
        this.type = "transaction";
        HashMap map3 = new HashMap();
        this.measurements = map3;
        this.transaction = str;
        this.startTimestamp = d;
        this.timestamp = d2;
        arrayList.addAll(list);
        map3.putAll(map);
        Iterator<SentrySpan> it = list.iterator();
        while (it.hasNext()) {
            this.measurements.putAll(it.next().getMeasurements());
        }
        this.transactionInfo = transactionInfo;
        this.metricSummaries = map2;
    }

    public List<SentrySpan> getSpans() {
        return this.spans;
    }

    public boolean isFinished() {
        return this.timestamp != null;
    }

    public String getTransaction() {
        return this.transaction;
    }

    public Double getStartTimestamp() {
        return this.startTimestamp;
    }

    public Double getTimestamp() {
        return this.timestamp;
    }

    public String getType() {
        return "transaction";
    }

    public SpanStatus getStatus() {
        SpanContext trace = getContexts().getTrace();
        if (trace != null) {
            return trace.getStatus();
        }
        return null;
    }

    public boolean isSampled() {
        TracesSamplingDecision samplingDecision = getSamplingDecision();
        if (samplingDecision == null) {
            return false;
        }
        return samplingDecision.getSampled().booleanValue();
    }

    public TracesSamplingDecision getSamplingDecision() {
        SpanContext trace = getContexts().getTrace();
        if (trace == null) {
            return null;
        }
        return trace.getSamplingDecision();
    }

    public Map<String, MeasurementValue> getMeasurements() {
        return this.measurements;
    }

    public Map<String, List<MetricSummary>> getMetricSummaries() {
        return this.metricSummaries;
    }

    public void setMetricSummaries(Map<String, List<MetricSummary>> map) {
        this.metricSummaries = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.transaction != null) {
            objectWriter.name("transaction").value(this.transaction);
        }
        objectWriter.name("start_timestamp").value(iLogger, doubleToBigDecimal(this.startTimestamp));
        if (this.timestamp != null) {
            objectWriter.name("timestamp").value(iLogger, doubleToBigDecimal(this.timestamp));
        }
        if (!this.spans.isEmpty()) {
            objectWriter.name(JsonKeys.SPANS).value(iLogger, this.spans);
        }
        objectWriter.name("type").value("transaction");
        if (!this.measurements.isEmpty()) {
            objectWriter.name("measurements").value(iLogger, this.measurements);
        }
        Map<String, List<MetricSummary>> map = this.metricSummaries;
        if (map != null && !map.isEmpty()) {
            objectWriter.name("_metrics_summary").value(iLogger, this.metricSummaries);
        }
        objectWriter.name(JsonKeys.TRANSACTION_INFO).value(iLogger, this.transactionInfo);
        new SentryBaseEvent.Serializer().serialize(this, objectWriter, iLogger);
        Map<String, Object> map2 = this.unknown;
        if (map2 != null) {
            for (String str : map2.keySet()) {
                Object obj = this.unknown.get(str);
                objectWriter.name(str);
                objectWriter.value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    private BigDecimal doubleToBigDecimal(Double d) {
        return BigDecimal.valueOf(d.doubleValue()).setScale(6, RoundingMode.DOWN);
    }

    @Override // io.sentry.JsonUnknown
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Override // io.sentry.JsonUnknown
    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer<SentryTransaction> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.JsonDeserializer
        public SentryTransaction deserialize(ObjectReader objectReader, ILogger iLogger) throws Exception {
            String strNextName;
            objectReader.beginObject();
            SentryTransaction sentryTransaction = new SentryTransaction("", Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE), null, new ArrayList(), new HashMap(), null, new TransactionInfo(TransactionNameSource.CUSTOM.apiName()));
            SentryBaseEvent.Deserializer deserializer = new SentryBaseEvent.Deserializer();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strNextName = objectReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "start_timestamp":
                        try {
                            Double dNextDoubleOrNull = objectReader.nextDoubleOrNull();
                            if (dNextDoubleOrNull == null) {
                                break;
                            } else {
                                sentryTransaction.startTimestamp = dNextDoubleOrNull;
                                break;
                            }
                        } catch (NumberFormatException unused) {
                            Date dateNextDateOrNull = objectReader.nextDateOrNull(iLogger);
                            if (dateNextDateOrNull == null) {
                                break;
                            } else {
                                sentryTransaction.startTimestamp = Double.valueOf(DateUtils.dateToSeconds(dateNextDateOrNull));
                                break;
                            }
                        }
                    case "_metrics_summary":
                        sentryTransaction.metricSummaries = objectReader.nextMapOfListOrNull(iLogger, new MetricSummary.Deserializer());
                        break;
                    case "measurements":
                        Map mapNextMapOrNull = objectReader.nextMapOrNull(iLogger, new MeasurementValue.Deserializer());
                        if (mapNextMapOrNull == null) {
                            break;
                        } else {
                            sentryTransaction.measurements.putAll(mapNextMapOrNull);
                            break;
                        }
                    case "type":
                        objectReader.nextString();
                        break;
                    case "timestamp":
                        try {
                            Double dNextDoubleOrNull2 = objectReader.nextDoubleOrNull();
                            if (dNextDoubleOrNull2 == null) {
                                break;
                            } else {
                                sentryTransaction.timestamp = dNextDoubleOrNull2;
                                break;
                            }
                        } catch (NumberFormatException unused2) {
                            Date dateNextDateOrNull2 = objectReader.nextDateOrNull(iLogger);
                            if (dateNextDateOrNull2 == null) {
                                break;
                            } else {
                                sentryTransaction.timestamp = Double.valueOf(DateUtils.dateToSeconds(dateNextDateOrNull2));
                                break;
                            }
                        }
                    case "spans":
                        List listNextListOrNull = objectReader.nextListOrNull(iLogger, new SentrySpan.Deserializer());
                        if (listNextListOrNull == null) {
                            break;
                        } else {
                            sentryTransaction.spans.addAll(listNextListOrNull);
                            break;
                        }
                    case "transaction_info":
                        sentryTransaction.transactionInfo = new TransactionInfo.Deserializer().deserialize(objectReader, iLogger);
                        break;
                    case "transaction":
                        sentryTransaction.transaction = objectReader.nextStringOrNull();
                        break;
                    default:
                        if (!deserializer.deserializeValue(sentryTransaction, strNextName, objectReader, iLogger)) {
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap();
                            }
                            objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                            break;
                        } else {
                            break;
                        }
                }
            }
            sentryTransaction.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return sentryTransaction;
        }
    }
}

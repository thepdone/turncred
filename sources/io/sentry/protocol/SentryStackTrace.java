package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.protocol.SentryStackFrame;
import io.sentry.util.CollectionUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public final class SentryStackTrace implements JsonUnknown, JsonSerializable {
    private List<SentryStackFrame> frames;
    private Map<String, String> registers;
    private Boolean snapshot;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String FRAMES = "frames";
        public static final String REGISTERS = "registers";
        public static final String SNAPSHOT = "snapshot";
    }

    public SentryStackTrace() {
    }

    public SentryStackTrace(List<SentryStackFrame> list) {
        this.frames = list;
    }

    public List<SentryStackFrame> getFrames() {
        return this.frames;
    }

    public void setFrames(List<SentryStackFrame> list) {
        this.frames = list;
    }

    public Map<String, String> getRegisters() {
        return this.registers;
    }

    public void setRegisters(Map<String, String> map) {
        this.registers = map;
    }

    public Boolean getSnapshot() {
        return this.snapshot;
    }

    public void setSnapshot(Boolean bool) {
        this.snapshot = bool;
    }

    @Override // io.sentry.JsonUnknown
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Override // io.sentry.JsonUnknown
    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.frames != null) {
            objectWriter.name(JsonKeys.FRAMES).value(iLogger, this.frames);
        }
        if (this.registers != null) {
            objectWriter.name(JsonKeys.REGISTERS).value(iLogger, this.registers);
        }
        if (this.snapshot != null) {
            objectWriter.name(JsonKeys.SNAPSHOT).value(this.snapshot);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.unknown.get(str);
                objectWriter.name(str);
                objectWriter.value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<SentryStackTrace> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.JsonDeserializer
        public SentryStackTrace deserialize(ObjectReader objectReader, ILogger iLogger) throws Exception {
            String strNextName;
            SentryStackTrace sentryStackTrace = new SentryStackTrace();
            objectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strNextName = objectReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "frames":
                        sentryStackTrace.frames = objectReader.nextListOrNull(iLogger, new SentryStackFrame.Deserializer());
                        break;
                    case "registers":
                        sentryStackTrace.registers = CollectionUtils.newConcurrentHashMap((Map) objectReader.nextObjectOrNull());
                        break;
                    case "snapshot":
                        sentryStackTrace.snapshot = objectReader.nextBooleanOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            sentryStackTrace.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return sentryStackTrace;
        }
    }
}

package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.CollectionUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public final class Message implements JsonUnknown, JsonSerializable {
    private String formatted;
    private String message;
    private List<String> params;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String FORMATTED = "formatted";
        public static final String MESSAGE = "message";
        public static final String PARAMS = "params";
    }

    public String getFormatted() {
        return this.formatted;
    }

    public void setFormatted(String str) {
        this.formatted = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public List<String> getParams() {
        return this.params;
    }

    public void setParams(List<String> list) {
        this.params = CollectionUtils.newArrayList(list);
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.formatted != null) {
            objectWriter.name(JsonKeys.FORMATTED).value(this.formatted);
        }
        if (this.message != null) {
            objectWriter.name("message").value(this.message);
        }
        List<String> list = this.params;
        if (list != null && !list.isEmpty()) {
            objectWriter.name("params").value(iLogger, this.params);
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

    @Override // io.sentry.JsonUnknown
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Override // io.sentry.JsonUnknown
    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer<Message> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.JsonDeserializer
        public Message deserialize(ObjectReader objectReader, ILogger iLogger) throws Exception {
            String strNextName;
            objectReader.beginObject();
            Message message = new Message();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strNextName = objectReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "params":
                        List list = (List) objectReader.nextObjectOrNull();
                        if (list == null) {
                            break;
                        } else {
                            message.params = list;
                            break;
                        }
                    case "message":
                        message.message = objectReader.nextStringOrNull();
                        break;
                    case "formatted":
                        message.formatted = objectReader.nextStringOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            message.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return message;
        }
    }
}

package io.sentry;

import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public final class SentryLockReason implements JsonUnknown, JsonSerializable {
    public static final int ANY = 15;
    public static final int BLOCKED = 8;
    public static final int LOCKED = 1;
    public static final int SLEEPING = 4;
    public static final int WAITING = 2;
    private String address;
    private String className;
    private String packageName;
    private Long threadId;
    private int type;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String ADDRESS = "address";
        public static final String CLASS_NAME = "class_name";
        public static final String PACKAGE_NAME = "package_name";
        public static final String THREAD_ID = "thread_id";
        public static final String TYPE = "type";
    }

    public SentryLockReason() {
    }

    public SentryLockReason(SentryLockReason sentryLockReason) {
        this.type = sentryLockReason.type;
        this.address = sentryLockReason.address;
        this.packageName = sentryLockReason.packageName;
        this.className = sentryLockReason.className;
        this.threadId = sentryLockReason.threadId;
        this.unknown = CollectionUtils.newConcurrentHashMap(sentryLockReason.unknown);
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public Long getThreadId() {
        return this.threadId;
    }

    public void setThreadId(Long l) {
        this.threadId = l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.address, ((SentryLockReason) obj).address);
    }

    public int hashCode() {
        return Objects.hash(this.address);
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
        objectWriter.name("type").value(this.type);
        if (this.address != null) {
            objectWriter.name("address").value(this.address);
        }
        if (this.packageName != null) {
            objectWriter.name(JsonKeys.PACKAGE_NAME).value(this.packageName);
        }
        if (this.className != null) {
            objectWriter.name(JsonKeys.CLASS_NAME).value(this.className);
        }
        if (this.threadId != null) {
            objectWriter.name("thread_id").value(this.threadId);
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

    public static final class Deserializer implements JsonDeserializer<SentryLockReason> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.JsonDeserializer
        public SentryLockReason deserialize(ObjectReader objectReader, ILogger iLogger) throws Exception {
            String strNextName;
            SentryLockReason sentryLockReason = new SentryLockReason();
            objectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strNextName = objectReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "package_name":
                        sentryLockReason.packageName = objectReader.nextStringOrNull();
                        break;
                    case "thread_id":
                        sentryLockReason.threadId = objectReader.nextLongOrNull();
                        break;
                    case "address":
                        sentryLockReason.address = objectReader.nextStringOrNull();
                        break;
                    case "class_name":
                        sentryLockReason.className = objectReader.nextStringOrNull();
                        break;
                    case "type":
                        sentryLockReason.type = objectReader.nextInt();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            sentryLockReason.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return sentryLockReason;
        }
    }
}

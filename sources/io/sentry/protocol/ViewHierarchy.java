package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.protocol.ViewHierarchyNode;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class ViewHierarchy implements JsonUnknown, JsonSerializable {
    private final String renderingSystem;
    private Map<String, Object> unknown;
    private final List<ViewHierarchyNode> windows;

    public static final class JsonKeys {
        public static final String RENDERING_SYSTEM = "rendering_system";
        public static final String WINDOWS = "windows";
    }

    public ViewHierarchy(String str, List<ViewHierarchyNode> list) {
        this.renderingSystem = str;
        this.windows = list;
    }

    public String getRenderingSystem() {
        return this.renderingSystem;
    }

    public List<ViewHierarchyNode> getWindows() {
        return this.windows;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.renderingSystem != null) {
            objectWriter.name("rendering_system").value(this.renderingSystem);
        }
        if (this.windows != null) {
            objectWriter.name(JsonKeys.WINDOWS).value(iLogger, this.windows);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
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

    public static final class Deserializer implements JsonDeserializer<ViewHierarchy> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.JsonDeserializer
        public ViewHierarchy deserialize(ObjectReader objectReader, ILogger iLogger) throws Exception {
            objectReader.beginObject();
            String strNextStringOrNull = null;
            List listNextListOrNull = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.hashCode();
                if (strNextName.equals("rendering_system")) {
                    strNextStringOrNull = objectReader.nextStringOrNull();
                } else if (strNextName.equals(JsonKeys.WINDOWS)) {
                    listNextListOrNull = objectReader.nextListOrNull(iLogger, new ViewHierarchyNode.Deserializer());
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            objectReader.endObject();
            ViewHierarchy viewHierarchy = new ViewHierarchy(strNextStringOrNull, listNextListOrNull);
            viewHierarchy.setUnknown(map);
            return viewHierarchy;
        }
    }
}

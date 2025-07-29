package com.nimbusds.jose.shaded.gson;

import com.nimbusds.jose.shaded.gson.internal.Streams;
import com.nimbusds.jose.shaded.gson.stream.JsonReader;
import com.nimbusds.jose.shaded.gson.stream.JsonToken;
import com.nimbusds.jose.shaded.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* loaded from: classes5.dex */
public final class JsonParser {
    @Deprecated
    public JsonParser() {
    }

    public static JsonElement parseString(String str) throws JsonSyntaxException {
        return parseReader(new StringReader(str));
    }

    public static JsonElement parseReader(Reader reader) throws JsonIOException, JsonSyntaxException {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            JsonElement reader2 = parseReader(jsonReader);
            if (!reader2.isJsonNull() && jsonReader.peek() != JsonToken.END_DOCUMENT) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
            return reader2;
        } catch (MalformedJsonException e) {
            throw new JsonSyntaxException(e);
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        } catch (NumberFormatException e3) {
            throw new JsonSyntaxException(e3);
        }
    }

    public static JsonElement parseReader(JsonReader jsonReader) throws JsonIOException, JsonSyntaxException {
        boolean zIsLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            try {
                return Streams.parse(jsonReader);
            } catch (OutOfMemoryError e) {
                throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e);
            } catch (StackOverflowError e2) {
                throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e2);
            }
        } finally {
            jsonReader.setLenient(zIsLenient);
        }
    }

    @Deprecated
    public JsonElement parse(String str) throws JsonSyntaxException {
        return parseString(str);
    }

    @Deprecated
    public JsonElement parse(Reader reader) throws JsonIOException, JsonSyntaxException {
        return parseReader(reader);
    }

    @Deprecated
    public JsonElement parse(JsonReader jsonReader) throws JsonIOException, JsonSyntaxException {
        return parseReader(jsonReader);
    }
}

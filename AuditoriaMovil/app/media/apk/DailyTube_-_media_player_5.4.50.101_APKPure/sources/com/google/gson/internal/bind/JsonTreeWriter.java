package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class JsonTreeWriter extends JsonWriter {

    /* renamed from: d0  reason: collision with root package name */
    public static final Writer f6229d0 = new Writer() { // from class: com.google.gson.internal.bind.JsonTreeWriter.1
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i5) {
            throw new AssertionError();
        }
    };

    /* renamed from: fh  reason: collision with root package name */
    public static final JsonPrimitive f6230fh = new JsonPrimitive("closed");

    /* renamed from: c  reason: collision with root package name */
    public JsonElement f6231c;

    /* renamed from: f3  reason: collision with root package name */
    public final List<JsonElement> f6232f3;

    /* renamed from: n  reason: collision with root package name */
    public String f6233n;

    public JsonTreeWriter() {
        super(f6229d0);
        this.f6232f3 = new ArrayList();
        this.f6231c = JsonNull.INSTANCE;
    }

    public final void b(JsonElement jsonElement) {
        if (this.f6233n != null) {
            if (!jsonElement.isJsonNull() || getSerializeNulls()) {
                ((JsonObject) ud()).add(this.f6233n, jsonElement);
            }
            this.f6233n = null;
        } else if (this.f6232f3.isEmpty()) {
            this.f6231c = jsonElement;
        } else {
            JsonElement ud2 = ud();
            if (ud2 instanceof JsonArray) {
                ((JsonArray) ud2).add(jsonElement);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginArray() throws IOException {
        JsonArray jsonArray = new JsonArray();
        b(jsonArray);
        this.f6232f3.add(jsonArray);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginObject() throws IOException {
        JsonObject jsonObject = new JsonObject();
        b(jsonObject);
        this.f6232f3.add(jsonObject);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f6232f3.isEmpty()) {
            this.f6232f3.add(f6230fh);
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endArray() throws IOException {
        if (!this.f6232f3.isEmpty() && this.f6233n == null) {
            if (ud() instanceof JsonArray) {
                List<JsonElement> list = this.f6232f3;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endObject() throws IOException {
        if (!this.f6232f3.isEmpty() && this.f6233n == null) {
            if (ud() instanceof JsonObject) {
                List<JsonElement> list = this.f6232f3;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public void flush() throws IOException {
    }

    public JsonElement get() {
        if (this.f6232f3.isEmpty()) {
            return this.f6231c;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f6232f3);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter name(String str) throws IOException {
        if (!this.f6232f3.isEmpty() && this.f6233n == null) {
            if (ud() instanceof JsonObject) {
                this.f6233n = str;
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter nullValue() throws IOException {
        b(JsonNull.INSTANCE);
        return this;
    }

    public final JsonElement ud() {
        List<JsonElement> list = this.f6232f3;
        return list.get(list.size() - 1);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        b(new JsonPrimitive(str));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(boolean z2) throws IOException {
        b(new JsonPrimitive(Boolean.valueOf(z2)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        b(new JsonPrimitive(bool));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(double d2) throws IOException {
        if (!isLenient() && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d2);
        }
        b(new JsonPrimitive(Double.valueOf(d2)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(long j2) throws IOException {
        b(new JsonPrimitive(Long.valueOf(j2)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        b(new JsonPrimitive(number));
        return this;
    }
}

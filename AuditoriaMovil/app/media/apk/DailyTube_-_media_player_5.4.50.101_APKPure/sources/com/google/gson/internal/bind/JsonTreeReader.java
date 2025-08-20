package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public final class JsonTreeReader extends JsonReader {

    /* renamed from: j5  reason: collision with root package name */
    public static final Reader f6223j5 = new Reader() { // from class: com.google.gson.internal.bind.JsonTreeReader.1
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i5) throws IOException {
            throw new AssertionError();
        }
    };

    /* renamed from: qn  reason: collision with root package name */
    public static final Object f6224qn = new Object();

    /* renamed from: b  reason: collision with root package name */
    public int[] f6225b;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f6226d;

    /* renamed from: ej  reason: collision with root package name */
    public int f6227ej;

    /* renamed from: x  reason: collision with root package name */
    public String[] f6228x;

    public JsonTreeReader(JsonElement jsonElement) {
        super(f6223j5);
        this.f6226d = new Object[32];
        this.f6228x = new String[32];
        this.f6225b = new int[32];
        yc(jsonElement);
    }

    private String co() {
        return " at path " + getPath();
    }

    public final Object ap() {
        Object[] objArr = this.f6226d;
        int i = this.f6227ej - 1;
        this.f6227ej = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginArray() throws IOException {
        ct(JsonToken.BEGIN_ARRAY);
        yc(((JsonArray) o4()).iterator());
        this.f6225b[this.f6227ej - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginObject() throws IOException {
        ct(JsonToken.BEGIN_OBJECT);
        yc(((JsonObject) o4()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f6226d = new Object[]{f6224qn};
        this.f6227ej = 1;
    }

    public final void ct(JsonToken jsonToken) throws IOException {
        if (peek() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek() + co());
    }

    @Override // com.google.gson.stream.JsonReader
    public void endArray() throws IOException {
        ct(JsonToken.END_ARRAY);
        ap();
        ap();
        int i = this.f6227ej;
        if (i > 0) {
            int[] iArr = this.f6225b;
            int i5 = i - 1;
            iArr[i5] = iArr[i5] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void endObject() throws IOException {
        ct(JsonToken.END_OBJECT);
        ap();
        ap();
        int i = this.f6227ej;
        if (i > 0) {
            int[] iArr = this.f6225b;
            int i5 = i - 1;
            iArr[i5] = iArr[i5] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = 0;
        while (i < this.f6227ej) {
            Object[] objArr = this.f6226d;
            Object obj = objArr[i];
            if (obj instanceof JsonArray) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.f6225b[i]);
                    sb.append(']');
                }
            } else if (obj instanceof JsonObject) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('.');
                    String str = this.f6228x[i];
                    if (str != null) {
                        sb.append(str);
                    }
                }
            }
            i++;
        }
        return sb.toString();
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean hasNext() throws IOException {
        JsonToken peek = peek();
        if (peek != JsonToken.END_OBJECT && peek != JsonToken.END_ARRAY) {
            return true;
        }
        return false;
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean nextBoolean() throws IOException {
        ct(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) ap()).getAsBoolean();
        int i = this.f6227ej;
        if (i > 0) {
            int[] iArr = this.f6225b;
            int i5 = i - 1;
            iArr[i5] = iArr[i5] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.JsonReader
    public double nextDouble() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + co());
        }
        double asDouble = ((JsonPrimitive) o4()).getAsDouble();
        if (!isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        ap();
        int i = this.f6227ej;
        if (i > 0) {
            int[] iArr = this.f6225b;
            int i5 = i - 1;
            iArr[i5] = iArr[i5] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.JsonReader
    public int nextInt() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + co());
        }
        int asInt = ((JsonPrimitive) o4()).getAsInt();
        ap();
        int i = this.f6227ej;
        if (i > 0) {
            int[] iArr = this.f6225b;
            int i5 = i - 1;
            iArr[i5] = iArr[i5] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.JsonReader
    public long nextLong() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + co());
        }
        long asLong = ((JsonPrimitive) o4()).getAsLong();
        ap();
        int i = this.f6227ej;
        if (i > 0) {
            int[] iArr = this.f6225b;
            int i5 = i - 1;
            iArr[i5] = iArr[i5] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextName() throws IOException {
        ct(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) o4()).next();
        String str = (String) entry.getKey();
        this.f6228x[this.f6227ej - 1] = str;
        yc(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.JsonReader
    public void nextNull() throws IOException {
        ct(JsonToken.NULL);
        ap();
        int i = this.f6227ej;
        if (i > 0) {
            int[] iArr = this.f6225b;
            int i5 = i - 1;
            iArr[i5] = iArr[i5] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextString() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.STRING;
        if (peek != jsonToken && peek != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + co());
        }
        String asString = ((JsonPrimitive) ap()).getAsString();
        int i = this.f6227ej;
        if (i > 0) {
            int[] iArr = this.f6225b;
            int i5 = i - 1;
            iArr[i5] = iArr[i5] + 1;
        }
        return asString;
    }

    public final Object o4() {
        return this.f6226d[this.f6227ej - 1];
    }

    @Override // com.google.gson.stream.JsonReader
    public JsonToken peek() throws IOException {
        if (this.f6227ej == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object o42 = o4();
        if (o42 instanceof Iterator) {
            boolean z2 = this.f6226d[this.f6227ej - 2] instanceof JsonObject;
            Iterator it = (Iterator) o42;
            if (it.hasNext()) {
                if (z2) {
                    return JsonToken.NAME;
                }
                yc(it.next());
                return peek();
            } else if (z2) {
                return JsonToken.END_OBJECT;
            } else {
                return JsonToken.END_ARRAY;
            }
        } else if (o42 instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (o42 instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (o42 instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) o42;
                if (jsonPrimitive.isString()) {
                    return JsonToken.STRING;
                }
                if (jsonPrimitive.isBoolean()) {
                    return JsonToken.BOOLEAN;
                }
                if (jsonPrimitive.isNumber()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (o42 instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (o42 == f6224qn) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    public void promoteNameToValue() throws IOException {
        ct(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) o4()).next();
        yc(entry.getValue());
        yc(new JsonPrimitive((String) entry.getKey()));
    }

    @Override // com.google.gson.stream.JsonReader
    public void skipValue() throws IOException {
        if (peek() == JsonToken.NAME) {
            nextName();
            this.f6228x[this.f6227ej - 2] = "null";
        } else {
            ap();
            int i = this.f6227ej;
            if (i > 0) {
                this.f6228x[i - 1] = "null";
            }
        }
        int i5 = this.f6227ej;
        if (i5 > 0) {
            int[] iArr = this.f6225b;
            int i6 = i5 - 1;
            iArr[i6] = iArr[i6] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String toString() {
        return JsonTreeReader.class.getSimpleName();
    }

    public final void yc(Object obj) {
        int i = this.f6227ej;
        Object[] objArr = this.f6226d;
        if (i == objArr.length) {
            int i5 = i * 2;
            this.f6226d = Arrays.copyOf(objArr, i5);
            this.f6225b = Arrays.copyOf(this.f6225b, i5);
            this.f6228x = (String[]) Arrays.copyOf(this.f6228x, i5);
        }
        Object[] objArr2 = this.f6226d;
        int i6 = this.f6227ej;
        this.f6227ej = i6 + 1;
        objArr2[i6] = obj;
    }
}

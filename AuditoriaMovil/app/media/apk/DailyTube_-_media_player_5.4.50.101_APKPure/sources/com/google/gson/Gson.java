package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
/* loaded from: classes.dex */
public final class Gson {

    /* renamed from: x4  reason: collision with root package name */
    public static final TypeToken<?> f6150x4 = TypeToken.get(Object.class);

    /* renamed from: a  reason: collision with root package name */
    public final Excluder f6151a;

    /* renamed from: c5  reason: collision with root package name */
    public final boolean f6152c5;

    /* renamed from: co  reason: collision with root package name */
    public final LongSerializationPolicy f6153co;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f6154f;

    /* renamed from: fb  reason: collision with root package name */
    public final FieldNamingStrategy f6155fb;

    /* renamed from: gv  reason: collision with root package name */
    public final JsonAdapterAnnotationTypeAdapterFactory f6156gv;

    /* renamed from: i9  reason: collision with root package name */
    public final boolean f6157i9;

    /* renamed from: mt  reason: collision with root package name */
    public final int f6158mt;

    /* renamed from: n3  reason: collision with root package name */
    public final Map<TypeToken<?>, TypeAdapter<?>> f6159n3;

    /* renamed from: p  reason: collision with root package name */
    public final int f6160p;

    /* renamed from: r  reason: collision with root package name */
    public final List<TypeAdapterFactory> f6161r;

    /* renamed from: s  reason: collision with root package name */
    public final Map<Type, InstanceCreator<?>> f6162s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f6163t;

    /* renamed from: tl  reason: collision with root package name */
    public final boolean f6164tl;

    /* renamed from: v  reason: collision with root package name */
    public final List<TypeAdapterFactory> f6165v;

    /* renamed from: w  reason: collision with root package name */
    public final String f6166w;

    /* renamed from: wz  reason: collision with root package name */
    public final boolean f6167wz;

    /* renamed from: xc  reason: collision with root package name */
    public final boolean f6168xc;
    public final ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> y;

    /* renamed from: z  reason: collision with root package name */
    public final List<TypeAdapterFactory> f6169z;

    /* renamed from: zn  reason: collision with root package name */
    public final ConstructorConstructor f6170zn;

    /* loaded from: classes.dex */
    public static class FutureTypeAdapter<T> extends TypeAdapter<T> {
        public TypeAdapter<T> y;

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            TypeAdapter<T> typeAdapter = this.y;
            if (typeAdapter != null) {
                return typeAdapter.read(jsonReader);
            }
            throw new IllegalStateException();
        }

        public void setDelegate(TypeAdapter<T> typeAdapter) {
            if (this.y == null) {
                this.y = typeAdapter;
                return;
            }
            throw new AssertionError();
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t2) throws IOException {
            TypeAdapter<T> typeAdapter = this.y;
            if (typeAdapter != null) {
                typeAdapter.write(jsonWriter, t2);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public Gson() {
        this(Excluder.DEFAULT, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    public static TypeAdapter<Number> fb(LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == LongSerializationPolicy.DEFAULT) {
            return TypeAdapters.LONG;
        }
        return new TypeAdapter<Number>() { // from class: com.google.gson.Gson.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return Long.valueOf(jsonReader.nextLong());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.value(number.toString());
                }
            }
        };
    }

    public static void gv(double d2) {
        if (!Double.isNaN(d2) && !Double.isInfinite(d2)) {
            return;
        }
        throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    }

    public static TypeAdapter<AtomicLong> n3(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLong>() { // from class: com.google.gson.Gson.4
            @Override // com.google.gson.TypeAdapter
            public AtomicLong read(JsonReader jsonReader) throws IOException {
                return new AtomicLong(((Number) TypeAdapter.this.read(jsonReader)).longValue());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, AtomicLong atomicLong) throws IOException {
                TypeAdapter.this.write(jsonWriter, Long.valueOf(atomicLong.get()));
            }
        }.nullSafe();
    }

    public static void y(Object obj, JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e2) {
                throw new JsonSyntaxException(e2);
            } catch (IOException e3) {
                throw new JsonIOException(e3);
            }
        }
    }

    public static TypeAdapter<AtomicLongArray> zn(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLongArray>() { // from class: com.google.gson.Gson.5
            @Override // com.google.gson.TypeAdapter
            public AtomicLongArray read(JsonReader jsonReader) throws IOException {
                ArrayList arrayList = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(Long.valueOf(((Number) TypeAdapter.this.read(jsonReader)).longValue()));
                }
                jsonReader.endArray();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) throws IOException {
                jsonWriter.beginArray();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    TypeAdapter.this.write(jsonWriter, Long.valueOf(atomicLongArray.get(i)));
                }
                jsonWriter.endArray();
            }
        }.nullSafe();
    }

    public final TypeAdapter<Number> a(boolean z2) {
        if (z2) {
            return TypeAdapters.FLOAT;
        }
        return new TypeAdapter<Number>() { // from class: com.google.gson.Gson.2
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Number read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return Float.valueOf((float) jsonReader.nextDouble());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                    return;
                }
                Gson.gv(number.floatValue());
                jsonWriter.value(number);
            }
        };
    }

    public Excluder excluder() {
        return this.f6151a;
    }

    public FieldNamingStrategy fieldNamingStrategy() {
        return this.f6155fb;
    }

    public <T> T fromJson(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) Primitives.wrap(cls).cast(fromJson(str, (Type) cls));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> TypeAdapter<T> getAdapter(TypeToken<T> typeToken) {
        boolean z2;
        TypeAdapter<T> typeAdapter = (TypeAdapter<T>) this.f6159n3.get(typeToken == null ? f6150x4 : typeToken);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        Map<TypeToken<?>, FutureTypeAdapter<?>> map = this.y.get();
        if (map == null) {
            map = new HashMap<>();
            this.y.set(map);
            z2 = true;
        } else {
            z2 = false;
        }
        FutureTypeAdapter<?> futureTypeAdapter = map.get(typeToken);
        if (futureTypeAdapter != null) {
            return futureTypeAdapter;
        }
        try {
            FutureTypeAdapter<?> futureTypeAdapter2 = new FutureTypeAdapter<>();
            map.put(typeToken, futureTypeAdapter2);
            for (TypeAdapterFactory typeAdapterFactory : this.f6165v) {
                TypeAdapter typeAdapter2 = (TypeAdapter<T>) typeAdapterFactory.create(this, typeToken);
                if (typeAdapter2 != null) {
                    futureTypeAdapter2.setDelegate(typeAdapter2);
                    this.f6159n3.put(typeToken, typeAdapter2);
                    return typeAdapter2;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.6) cannot handle " + typeToken);
        } finally {
            map.remove(typeToken);
            if (z2) {
                this.y.remove();
            }
        }
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory typeAdapterFactory, TypeToken<T> typeToken) {
        if (!this.f6165v.contains(typeAdapterFactory)) {
            typeAdapterFactory = this.f6156gv;
        }
        boolean z2 = false;
        for (TypeAdapterFactory typeAdapterFactory2 : this.f6165v) {
            if (!z2) {
                if (typeAdapterFactory2 == typeAdapterFactory) {
                    z2 = true;
                }
            } else {
                TypeAdapter<T> create = typeAdapterFactory2.create(this, typeToken);
                if (create != null) {
                    return create;
                }
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    public boolean htmlSafe() {
        return this.f6163t;
    }

    public GsonBuilder newBuilder() {
        return new GsonBuilder(this);
    }

    public JsonReader newJsonReader(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(this.f6167wz);
        return jsonReader;
    }

    public JsonWriter newJsonWriter(Writer writer) throws IOException {
        if (this.f6154f) {
            writer.write(")]}'\n");
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.f6164tl) {
            jsonWriter.setIndent("  ");
        }
        jsonWriter.setSerializeNulls(this.f6152c5);
        return jsonWriter;
    }

    public boolean serializeNulls() {
        return this.f6152c5;
    }

    public String toJson(Object obj) {
        if (obj == null) {
            return toJson((JsonElement) JsonNull.INSTANCE);
        }
        return toJson(obj, obj.getClass());
    }

    public JsonElement toJsonTree(Object obj) {
        if (obj == null) {
            return JsonNull.INSTANCE;
        }
        return toJsonTree(obj, obj.getClass());
    }

    public String toString() {
        return "{serializeNulls:" + this.f6152c5 + ",factories:" + this.f6165v + ",instanceCreators:" + this.f6170zn + "}";
    }

    public final TypeAdapter<Number> v(boolean z2) {
        if (z2) {
            return TypeAdapters.DOUBLE;
        }
        return new TypeAdapter<Number>() { // from class: com.google.gson.Gson.1
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Number read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return Double.valueOf(jsonReader.nextDouble());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                    return;
                }
                Gson.gv(number.doubleValue());
                jsonWriter.value(number);
            }
        };
    }

    public <T> T fromJson(String str, Type type) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return (T) fromJson(new StringReader(str), type);
    }

    public String toJson(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        toJson(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public JsonElement toJsonTree(Object obj, Type type) {
        JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
        toJson(obj, type, jsonTreeWriter);
        return jsonTreeWriter.get();
    }

    public <T> T fromJson(Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        JsonReader newJsonReader = newJsonReader(reader);
        Object fromJson = fromJson(newJsonReader, cls);
        y(fromJson, newJsonReader);
        return (T) Primitives.wrap(cls).cast(fromJson);
    }

    public Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map<Type, InstanceCreator<?>> map, boolean z2, boolean z3, boolean z4, boolean z5, boolean z7, boolean z8, boolean z9, LongSerializationPolicy longSerializationPolicy, String str, int i, int i5, List<TypeAdapterFactory> list, List<TypeAdapterFactory> list2, List<TypeAdapterFactory> list3) {
        this.y = new ThreadLocal<>();
        this.f6159n3 = new ConcurrentHashMap();
        this.f6151a = excluder;
        this.f6155fb = fieldNamingStrategy;
        this.f6162s = map;
        ConstructorConstructor constructorConstructor = new ConstructorConstructor(map);
        this.f6170zn = constructorConstructor;
        this.f6152c5 = z2;
        this.f6157i9 = z3;
        this.f6154f = z4;
        this.f6163t = z5;
        this.f6164tl = z7;
        this.f6167wz = z8;
        this.f6168xc = z9;
        this.f6153co = longSerializationPolicy;
        this.f6166w = str;
        this.f6160p = i;
        this.f6158mt = i5;
        this.f6169z = list;
        this.f6161r = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        arrayList.add(ObjectTypeAdapter.FACTORY);
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.STRING_FACTORY);
        arrayList.add(TypeAdapters.INTEGER_FACTORY);
        arrayList.add(TypeAdapters.BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.BYTE_FACTORY);
        arrayList.add(TypeAdapters.SHORT_FACTORY);
        TypeAdapter<Number> fb2 = fb(longSerializationPolicy);
        arrayList.add(TypeAdapters.newFactory(Long.TYPE, Long.class, fb2));
        arrayList.add(TypeAdapters.newFactory(Double.TYPE, Double.class, v(z9)));
        arrayList.add(TypeAdapters.newFactory(Float.TYPE, Float.class, a(z9)));
        arrayList.add(TypeAdapters.NUMBER_FACTORY);
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        arrayList.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.newFactory(AtomicLong.class, n3(fb2)));
        arrayList.add(TypeAdapters.newFactory(AtomicLongArray.class, zn(fb2)));
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        arrayList.add(TypeAdapters.CHARACTER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUILDER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUFFER_FACTORY);
        arrayList.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
        arrayList.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
        arrayList.add(TypeAdapters.URL_FACTORY);
        arrayList.add(TypeAdapters.URI_FACTORY);
        arrayList.add(TypeAdapters.UUID_FACTORY);
        arrayList.add(TypeAdapters.CURRENCY_FACTORY);
        arrayList.add(TypeAdapters.LOCALE_FACTORY);
        arrayList.add(TypeAdapters.INET_ADDRESS_FACTORY);
        arrayList.add(TypeAdapters.BIT_SET_FACTORY);
        arrayList.add(DateTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.CALENDAR_FACTORY);
        arrayList.add(TimeTypeAdapter.FACTORY);
        arrayList.add(SqlDateTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.TIMESTAMP_FACTORY);
        arrayList.add(ArrayTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.CLASS_FACTORY);
        arrayList.add(new CollectionTypeAdapterFactory(constructorConstructor));
        arrayList.add(new MapTypeAdapterFactory(constructorConstructor, z3));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(constructorConstructor);
        this.f6156gv = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.ENUM_FACTORY);
        arrayList.add(new ReflectiveTypeAdapterFactory(constructorConstructor, fieldNamingStrategy, excluder, jsonAdapterAnnotationTypeAdapterFactory));
        this.f6165v = Collections.unmodifiableList(arrayList);
    }

    public void toJson(Object obj, Appendable appendable) throws JsonIOException {
        if (obj != null) {
            toJson(obj, obj.getClass(), appendable);
        } else {
            toJson((JsonElement) JsonNull.INSTANCE, appendable);
        }
    }

    public void toJson(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            toJson(obj, type, newJsonWriter(Streams.writerForAppendable(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public <T> T fromJson(Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        JsonReader newJsonReader = newJsonReader(reader);
        T t2 = (T) fromJson(newJsonReader, type);
        y(t2, newJsonReader);
        return t2;
    }

    public void toJson(Object obj, Type type, JsonWriter jsonWriter) throws JsonIOException {
        TypeAdapter adapter = getAdapter(TypeToken.get(type));
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.f6163t);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.f6152c5);
        try {
            try {
                adapter.write(jsonWriter, obj);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e3.getMessage());
                assertionError.initCause(e3);
                throw assertionError;
            }
        } finally {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public <T> T fromJson(JsonReader jsonReader, Type type) throws JsonIOException, JsonSyntaxException {
        boolean isLenient = jsonReader.isLenient();
        boolean z2 = true;
        jsonReader.setLenient(true);
        try {
            try {
                try {
                    jsonReader.peek();
                    z2 = false;
                    return getAdapter(TypeToken.get(type)).read(jsonReader);
                } catch (EOFException e2) {
                    if (z2) {
                        jsonReader.setLenient(isLenient);
                        return null;
                    }
                    throw new JsonSyntaxException(e2);
                } catch (IllegalStateException e3) {
                    throw new JsonSyntaxException(e3);
                }
            } catch (IOException e5) {
                throw new JsonSyntaxException(e5);
            } catch (AssertionError e6) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e6.getMessage());
                assertionError.initCause(e6);
                throw assertionError;
            }
        } finally {
            jsonReader.setLenient(isLenient);
        }
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> cls) {
        return getAdapter(TypeToken.get((Class) cls));
    }

    public <T> T fromJson(JsonElement jsonElement, Class<T> cls) throws JsonSyntaxException {
        return (T) Primitives.wrap(cls).cast(fromJson(jsonElement, (Type) cls));
    }

    public <T> T fromJson(JsonElement jsonElement, Type type) throws JsonSyntaxException {
        if (jsonElement == null) {
            return null;
        }
        return (T) fromJson(new JsonTreeReader(jsonElement), type);
    }

    public String toJson(JsonElement jsonElement) {
        StringWriter stringWriter = new StringWriter();
        toJson(jsonElement, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public void toJson(JsonElement jsonElement, Appendable appendable) throws JsonIOException {
        try {
            toJson(jsonElement, newJsonWriter(Streams.writerForAppendable(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public void toJson(JsonElement jsonElement, JsonWriter jsonWriter) throws JsonIOException {
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.f6163t);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.f6152c5);
        try {
            try {
                Streams.write(jsonElement, jsonWriter);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e3.getMessage());
                assertionError.initCause(e3);
                throw assertionError;
            }
        } finally {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }
}

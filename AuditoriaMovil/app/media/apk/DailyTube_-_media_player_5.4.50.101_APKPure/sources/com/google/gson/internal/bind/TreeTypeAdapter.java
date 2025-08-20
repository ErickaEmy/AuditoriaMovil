package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {

    /* renamed from: a  reason: collision with root package name */
    public final TreeTypeAdapter<T>.GsonContextImpl f6252a = new GsonContextImpl();

    /* renamed from: fb  reason: collision with root package name */
    public TypeAdapter<T> f6253fb;

    /* renamed from: gv  reason: collision with root package name */
    public final TypeToken<T> f6254gv;

    /* renamed from: n3  reason: collision with root package name */
    public final JsonDeserializer<T> f6255n3;

    /* renamed from: v  reason: collision with root package name */
    public final TypeAdapterFactory f6256v;
    public final JsonSerializer<T> y;

    /* renamed from: zn  reason: collision with root package name */
    public final Gson f6257zn;

    /* loaded from: classes.dex */
    public final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext {
        public GsonContextImpl() {
        }

        @Override // com.google.gson.JsonDeserializationContext
        public <R> R deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
            return (R) TreeTypeAdapter.this.f6257zn.fromJson(jsonElement, type);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj) {
            return TreeTypeAdapter.this.f6257zn.toJsonTree(obj);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj, Type type) {
            return TreeTypeAdapter.this.f6257zn.toJsonTree(obj, type);
        }
    }

    /* loaded from: classes.dex */
    public static final class SingleTypeFactory implements TypeAdapterFactory {

        /* renamed from: f  reason: collision with root package name */
        public final JsonDeserializer<?> f6258f;

        /* renamed from: fb  reason: collision with root package name */
        public final Class<?> f6259fb;

        /* renamed from: s  reason: collision with root package name */
        public final JsonSerializer<?> f6260s;

        /* renamed from: v  reason: collision with root package name */
        public final boolean f6261v;
        public final TypeToken<?> y;

        public SingleTypeFactory(Object obj, TypeToken<?> typeToken, boolean z2, Class<?> cls) {
            JsonSerializer<?> jsonSerializer;
            boolean z3;
            if (obj instanceof JsonSerializer) {
                jsonSerializer = (JsonSerializer) obj;
            } else {
                jsonSerializer = null;
            }
            this.f6260s = jsonSerializer;
            JsonDeserializer<?> jsonDeserializer = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            this.f6258f = jsonDeserializer;
            if (jsonSerializer == null && jsonDeserializer == null) {
                z3 = false;
            } else {
                z3 = true;
            }
            C$Gson$Preconditions.checkArgument(z3);
            this.y = typeToken;
            this.f6261v = z2;
            this.f6259fb = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            boolean isAssignableFrom;
            TypeToken<?> typeToken2 = this.y;
            if (typeToken2 != null) {
                if (!typeToken2.equals(typeToken) && (!this.f6261v || this.y.getType() != typeToken.getRawType())) {
                    isAssignableFrom = false;
                } else {
                    isAssignableFrom = true;
                }
            } else {
                isAssignableFrom = this.f6259fb.isAssignableFrom(typeToken.getRawType());
            }
            if (isAssignableFrom) {
                return new TreeTypeAdapter(this.f6260s, this.f6258f, gson, typeToken, this);
            }
            return null;
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory typeAdapterFactory) {
        this.y = jsonSerializer;
        this.f6255n3 = jsonDeserializer;
        this.f6257zn = gson;
        this.f6254gv = typeToken;
        this.f6256v = typeAdapterFactory;
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> typeToken, Object obj) {
        return new SingleTypeFactory(obj, typeToken, false, null);
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> typeToken, Object obj) {
        boolean z2;
        if (typeToken.getType() == typeToken.getRawType()) {
            z2 = true;
        } else {
            z2 = false;
        }
        return new SingleTypeFactory(obj, typeToken, z2, null);
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    private TypeAdapter<T> y() {
        TypeAdapter<T> typeAdapter = this.f6253fb;
        if (typeAdapter == null) {
            TypeAdapter<T> delegateAdapter = this.f6257zn.getDelegateAdapter(this.f6256v, this.f6254gv);
            this.f6253fb = delegateAdapter;
            return delegateAdapter;
        }
        return typeAdapter;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader jsonReader) throws IOException {
        if (this.f6255n3 == null) {
            return y().read(jsonReader);
        }
        JsonElement parse = Streams.parse(jsonReader);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.f6255n3.deserialize(parse, this.f6254gv.getType(), this.f6252a);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t2) throws IOException {
        JsonSerializer<T> jsonSerializer = this.y;
        if (jsonSerializer == null) {
            y().write(jsonWriter, t2);
        } else if (t2 == null) {
            jsonWriter.nullValue();
        } else {
            Streams.write(jsonSerializer.serialize(t2, this.f6254gv.getType(), this.f6252a), jsonWriter);
        }
    }
}

package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: f  reason: collision with root package name */
    public final ReflectionAccessor f6238f = ReflectionAccessor.getInstance();

    /* renamed from: fb  reason: collision with root package name */
    public final Excluder f6239fb;

    /* renamed from: s  reason: collision with root package name */
    public final JsonAdapterAnnotationTypeAdapterFactory f6240s;

    /* renamed from: v  reason: collision with root package name */
    public final FieldNamingStrategy f6241v;
    public final ConstructorConstructor y;

    /* loaded from: classes.dex */
    public static final class Adapter<T> extends TypeAdapter<T> {

        /* renamed from: n3  reason: collision with root package name */
        public final Map<String, BoundField> f6249n3;
        public final ObjectConstructor<T> y;

        public Adapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            this.y = objectConstructor;
            this.f6249n3 = map;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T construct = this.y.construct();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = this.f6249n3.get(jsonReader.nextName());
                    if (boundField != null && boundField.f6251zn) {
                        boundField.y(jsonReader, construct);
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return construct;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (IllegalStateException e3) {
                throw new JsonSyntaxException(e3);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t2) throws IOException {
            if (t2 == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (BoundField boundField : this.f6249n3.values()) {
                    if (boundField.writeField(t2)) {
                        jsonWriter.name(boundField.y);
                        boundField.n3(jsonWriter, t2);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class BoundField {

        /* renamed from: n3  reason: collision with root package name */
        public final boolean f6250n3;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final boolean f6251zn;

        public BoundField(String str, boolean z2, boolean z3) {
            this.y = str;
            this.f6250n3 = z2;
            this.f6251zn = z3;
        }

        public abstract void n3(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;

        public abstract boolean writeField(Object obj) throws IOException, IllegalAccessException;

        public abstract void y(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.y = constructorConstructor;
        this.f6241v = fieldNamingStrategy;
        this.f6239fb = excluder;
        this.f6240s = jsonAdapterAnnotationTypeAdapterFactory;
    }

    public static boolean n3(Field field, boolean z2, Excluder excluder) {
        if (!excluder.excludeClass(field.getType(), z2) && !excluder.excludeField(field, z2)) {
            return true;
        }
        return false;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        return new Adapter(this.y.get(typeToken), zn(gson, typeToken, rawType));
    }

    public boolean excludeField(Field field, boolean z2) {
        return n3(field, z2, this.f6239fb);
    }

    public final List<String> gv(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.f6241v.translateName(field));
        }
        String value = serializedName.value();
        String[] alternate = serializedName.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public final BoundField y(final Gson gson, final Field field, String str, final TypeToken<?> typeToken, boolean z2, boolean z3) {
        TypeAdapter<?> typeAdapter;
        final boolean z4;
        final boolean isPrimitive = Primitives.isPrimitive(typeToken.getRawType());
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        if (jsonAdapter != null) {
            typeAdapter = this.f6240s.y(this.y, gson, typeToken, jsonAdapter);
        } else {
            typeAdapter = null;
        }
        if (typeAdapter != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (typeAdapter == null) {
            typeAdapter = gson.getAdapter(typeToken);
        }
        final TypeAdapter<?> typeAdapter2 = typeAdapter;
        return new BoundField(str, z2, z3) { // from class: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public void n3(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
                TypeAdapter typeAdapterRuntimeTypeWrapper;
                Object obj2 = field.get(obj);
                if (z4) {
                    typeAdapterRuntimeTypeWrapper = typeAdapter2;
                } else {
                    typeAdapterRuntimeTypeWrapper = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, typeToken.getType());
                }
                typeAdapterRuntimeTypeWrapper.write(jsonWriter, obj2);
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public boolean writeField(Object obj) throws IOException, IllegalAccessException {
                if (!this.f6250n3 || field.get(obj) == obj) {
                    return false;
                }
                return true;
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public void y(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
                Object read = typeAdapter2.read(jsonReader);
                if (read != null || !isPrimitive) {
                    field.set(obj, read);
                }
            }
        };
    }

    public final Map<String, BoundField> zn(Gson gson, TypeToken<?> typeToken, Class<?> cls) {
        BoundField boundField;
        boolean z2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = typeToken.getType();
        TypeToken<?> typeToken2 = typeToken;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z3 = false;
            int i = 0;
            while (i < length) {
                Field field = declaredFields[i];
                boolean excludeField = excludeField(field, true);
                boolean excludeField2 = excludeField(field, z3);
                if (excludeField || excludeField2) {
                    this.f6238f.makeAccessible(field);
                    Type resolve = C$Gson$Types.resolve(typeToken2.getType(), cls2, field.getGenericType());
                    List<String> gv2 = gv(field);
                    int size = gv2.size();
                    BoundField boundField2 = null;
                    int i5 = 0;
                    while (i5 < size) {
                        String str = gv2.get(i5);
                        if (i5 != 0) {
                            z2 = false;
                        } else {
                            z2 = excludeField;
                        }
                        int i6 = i5;
                        BoundField boundField3 = boundField2;
                        int i8 = size;
                        List<String> list = gv2;
                        Field field2 = field;
                        BoundField boundField4 = (BoundField) linkedHashMap.put(str, y(gson, field, str, TypeToken.get(resolve), z2, excludeField2));
                        if (boundField3 == null) {
                            boundField2 = boundField4;
                        } else {
                            boundField2 = boundField3;
                        }
                        i5 = i6 + 1;
                        excludeField = z2;
                        gv2 = list;
                        size = i8;
                        field = field2;
                    }
                    if (boundField2 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + boundField.y);
                    }
                }
                i++;
                z3 = false;
            }
            typeToken2 = TypeToken.get(C$Gson$Types.resolve(typeToken2.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = typeToken2.getRawType();
        }
        return linkedHashMap;
    }
}

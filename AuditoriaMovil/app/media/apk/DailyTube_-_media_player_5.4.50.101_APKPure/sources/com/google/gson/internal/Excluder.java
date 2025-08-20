package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = new Excluder();

    /* renamed from: s  reason: collision with root package name */
    public boolean f6198s;
    public double y = -1.0d;

    /* renamed from: v  reason: collision with root package name */
    public int f6200v = 136;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f6197fb = true;

    /* renamed from: f  reason: collision with root package name */
    public List<ExclusionStrategy> f6196f = Collections.emptyList();

    /* renamed from: t  reason: collision with root package name */
    public List<ExclusionStrategy> f6199t = Collections.emptyList();

    public final boolean a(Class<?> cls) {
        if (!Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass())) {
            return true;
        }
        return false;
    }

    public final boolean c5(Since since) {
        if (since != null && since.value() > this.y) {
            return false;
        }
        return true;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        final boolean z2;
        final boolean z3;
        Class<? super T> rawType = typeToken.getRawType();
        boolean zn2 = zn(rawType);
        if (!zn2 && !gv(rawType, true)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!zn2 && !gv(rawType, false)) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z2 && !z3) {
            return null;
        }
        return new TypeAdapter<T>() { // from class: com.google.gson.internal.Excluder.1
            public TypeAdapter<T> y;

            @Override // com.google.gson.TypeAdapter
            public T read(JsonReader jsonReader) throws IOException {
                if (z3) {
                    jsonReader.skipValue();
                    return null;
                }
                return y().read(jsonReader);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, T t2) throws IOException {
                if (z2) {
                    jsonWriter.nullValue();
                } else {
                    y().write(jsonWriter, t2);
                }
            }

            public final TypeAdapter<T> y() {
                TypeAdapter<T> typeAdapter = this.y;
                if (typeAdapter == null) {
                    TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
                    this.y = delegateAdapter;
                    return delegateAdapter;
                }
                return typeAdapter;
            }
        };
    }

    public Excluder disableInnerClassSerialization() {
        Excluder clone = clone();
        clone.f6197fb = false;
        return clone;
    }

    public boolean excludeClass(Class<?> cls, boolean z2) {
        if (!zn(cls) && !gv(cls, z2)) {
            return false;
        }
        return true;
    }

    public boolean excludeField(Field field, boolean z2) {
        List<ExclusionStrategy> list;
        Expose expose;
        if ((this.f6200v & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.y != -1.0d && !f((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f6198s && ((expose = (Expose) field.getAnnotation(Expose.class)) == null || (!z2 ? !expose.deserialize() : !expose.serialize()))) {
            return true;
        }
        if ((!this.f6197fb && fb(field.getType())) || a(field.getType())) {
            return true;
        }
        if (z2) {
            list = this.f6196f;
        } else {
            list = this.f6199t;
        }
        if (!list.isEmpty()) {
            FieldAttributes fieldAttributes = new FieldAttributes(field);
            for (ExclusionStrategy exclusionStrategy : list) {
                if (exclusionStrategy.shouldSkipField(fieldAttributes)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder clone = clone();
        clone.f6198s = true;
        return clone;
    }

    public final boolean f(Since since, Until until) {
        if (c5(since) && i9(until)) {
            return true;
        }
        return false;
    }

    public final boolean fb(Class<?> cls) {
        if (cls.isMemberClass() && !s(cls)) {
            return true;
        }
        return false;
    }

    public final boolean gv(Class<?> cls, boolean z2) {
        List<ExclusionStrategy> list;
        if (z2) {
            list = this.f6196f;
        } else {
            list = this.f6199t;
        }
        for (ExclusionStrategy exclusionStrategy : list) {
            if (exclusionStrategy.shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    public final boolean i9(Until until) {
        if (until != null && until.value() <= this.y) {
            return false;
        }
        return true;
    }

    /* renamed from: n3 */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final boolean s(Class<?> cls) {
        if ((cls.getModifiers() & 8) != 0) {
            return true;
        }
        return false;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z2, boolean z3) {
        Excluder clone = clone();
        if (z2) {
            ArrayList arrayList = new ArrayList(this.f6196f);
            clone.f6196f = arrayList;
            arrayList.add(exclusionStrategy);
        }
        if (z3) {
            ArrayList arrayList2 = new ArrayList(this.f6199t);
            clone.f6199t = arrayList2;
            arrayList2.add(exclusionStrategy);
        }
        return clone;
    }

    public Excluder withModifiers(int... iArr) {
        Excluder clone = clone();
        clone.f6200v = 0;
        for (int i : iArr) {
            clone.f6200v = i | clone.f6200v;
        }
        return clone;
    }

    public Excluder withVersion(double d2) {
        Excluder clone = clone();
        clone.y = d2;
        return clone;
    }

    public final boolean zn(Class<?> cls) {
        if (this.y != -1.0d && !f((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if ((!this.f6197fb && fb(cls)) || a(cls)) {
            return true;
        }
        return false;
    }
}

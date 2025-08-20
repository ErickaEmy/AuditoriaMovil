package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class GsonBuilder {

    /* renamed from: a  reason: collision with root package name */
    public final List<TypeAdapterFactory> f6171a;

    /* renamed from: c5  reason: collision with root package name */
    public int f6172c5;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6173f;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f6174fb;

    /* renamed from: gv  reason: collision with root package name */
    public final Map<Type, InstanceCreator<?>> f6175gv;

    /* renamed from: i9  reason: collision with root package name */
    public int f6176i9;

    /* renamed from: n3  reason: collision with root package name */
    public LongSerializationPolicy f6177n3;

    /* renamed from: s  reason: collision with root package name */
    public String f6178s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f6179t;

    /* renamed from: tl  reason: collision with root package name */
    public boolean f6180tl;

    /* renamed from: v  reason: collision with root package name */
    public final List<TypeAdapterFactory> f6181v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f6182w;

    /* renamed from: wz  reason: collision with root package name */
    public boolean f6183wz;

    /* renamed from: xc  reason: collision with root package name */
    public boolean f6184xc;
    public Excluder y;

    /* renamed from: zn  reason: collision with root package name */
    public FieldNamingStrategy f6185zn;

    public GsonBuilder() {
        this.y = Excluder.DEFAULT;
        this.f6177n3 = LongSerializationPolicy.DEFAULT;
        this.f6185zn = FieldNamingPolicy.IDENTITY;
        this.f6175gv = new HashMap();
        this.f6181v = new ArrayList();
        this.f6171a = new ArrayList();
        this.f6174fb = false;
        this.f6172c5 = 2;
        this.f6176i9 = 2;
        this.f6173f = false;
        this.f6179t = false;
        this.f6180tl = true;
        this.f6183wz = false;
        this.f6184xc = false;
        this.f6182w = false;
    }

    public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        this.y = this.y.withExclusionStrategy(exclusionStrategy, false, true);
        return this;
    }

    public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        this.y = this.y.withExclusionStrategy(exclusionStrategy, true, false);
        return this;
    }

    public Gson create() {
        List<TypeAdapterFactory> arrayList = new ArrayList<>(this.f6181v.size() + this.f6171a.size() + 3);
        arrayList.addAll(this.f6181v);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f6171a);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        y(this.f6178s, this.f6172c5, this.f6176i9, arrayList);
        return new Gson(this.y, this.f6185zn, this.f6175gv, this.f6174fb, this.f6173f, this.f6184xc, this.f6180tl, this.f6183wz, this.f6182w, this.f6179t, this.f6177n3, this.f6178s, this.f6172c5, this.f6176i9, this.f6181v, this.f6171a, arrayList);
    }

    public GsonBuilder disableHtmlEscaping() {
        this.f6180tl = false;
        return this;
    }

    public GsonBuilder disableInnerClassSerialization() {
        this.y = this.y.disableInnerClassSerialization();
        return this;
    }

    public GsonBuilder enableComplexMapKeySerialization() {
        this.f6173f = true;
        return this;
    }

    public GsonBuilder excludeFieldsWithModifiers(int... iArr) {
        this.y = this.y.withModifiers(iArr);
        return this;
    }

    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.y = this.y.excludeFieldsWithoutExposeAnnotation();
        return this;
    }

    public GsonBuilder generateNonExecutableJson() {
        this.f6184xc = true;
        return this;
    }

    public GsonBuilder registerTypeAdapter(Type type, Object obj) {
        boolean z2;
        boolean z3 = obj instanceof JsonSerializer;
        if (!z3 && !(obj instanceof JsonDeserializer) && !(obj instanceof InstanceCreator) && !(obj instanceof TypeAdapter)) {
            z2 = false;
        } else {
            z2 = true;
        }
        C$Gson$Preconditions.checkArgument(z2);
        if (obj instanceof InstanceCreator) {
            this.f6175gv.put(type, (InstanceCreator) obj);
        }
        if (z3 || (obj instanceof JsonDeserializer)) {
            this.f6181v.add(TreeTypeAdapter.newFactoryWithMatchRawType(TypeToken.get(type), obj));
        }
        if (obj instanceof TypeAdapter) {
            this.f6181v.add(TypeAdapters.newFactory(TypeToken.get(type), (TypeAdapter) obj));
        }
        return this;
    }

    public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory typeAdapterFactory) {
        this.f6181v.add(typeAdapterFactory);
        return this;
    }

    public GsonBuilder registerTypeHierarchyAdapter(Class<?> cls, Object obj) {
        boolean z2;
        boolean z3 = obj instanceof JsonSerializer;
        if (!z3 && !(obj instanceof JsonDeserializer) && !(obj instanceof TypeAdapter)) {
            z2 = false;
        } else {
            z2 = true;
        }
        C$Gson$Preconditions.checkArgument(z2);
        if ((obj instanceof JsonDeserializer) || z3) {
            this.f6171a.add(TreeTypeAdapter.newTypeHierarchyFactory(cls, obj));
        }
        if (obj instanceof TypeAdapter) {
            this.f6181v.add(TypeAdapters.newTypeHierarchyFactory(cls, (TypeAdapter) obj));
        }
        return this;
    }

    public GsonBuilder serializeNulls() {
        this.f6174fb = true;
        return this;
    }

    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.f6179t = true;
        return this;
    }

    public GsonBuilder setDateFormat(String str) {
        this.f6178s = str;
        return this;
    }

    public GsonBuilder setExclusionStrategies(ExclusionStrategy... exclusionStrategyArr) {
        for (ExclusionStrategy exclusionStrategy : exclusionStrategyArr) {
            this.y = this.y.withExclusionStrategy(exclusionStrategy, true, true);
        }
        return this;
    }

    public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy fieldNamingPolicy) {
        this.f6185zn = fieldNamingPolicy;
        return this;
    }

    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy fieldNamingStrategy) {
        this.f6185zn = fieldNamingStrategy;
        return this;
    }

    public GsonBuilder setLenient() {
        this.f6182w = true;
        return this;
    }

    public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy longSerializationPolicy) {
        this.f6177n3 = longSerializationPolicy;
        return this;
    }

    public GsonBuilder setPrettyPrinting() {
        this.f6183wz = true;
        return this;
    }

    public GsonBuilder setVersion(double d2) {
        this.y = this.y.withVersion(d2);
        return this;
    }

    public final void y(String str, int i, int i5, List<TypeAdapterFactory> list) {
        TypeAdapter typeAdapter;
        TypeAdapter typeAdapter2;
        TypeAdapter typeAdapter3;
        if (str != null && !"".equals(str.trim())) {
            typeAdapter = new DefaultDateTypeAdapter(Date.class, str);
            typeAdapter2 = new DefaultDateTypeAdapter(Timestamp.class, str);
            typeAdapter3 = new DefaultDateTypeAdapter(java.sql.Date.class, str);
        } else if (i != 2 && i5 != 2) {
            TypeAdapter defaultDateTypeAdapter = new DefaultDateTypeAdapter(Date.class, i, i5);
            TypeAdapter defaultDateTypeAdapter2 = new DefaultDateTypeAdapter(Timestamp.class, i, i5);
            TypeAdapter defaultDateTypeAdapter3 = new DefaultDateTypeAdapter(java.sql.Date.class, i, i5);
            typeAdapter = defaultDateTypeAdapter;
            typeAdapter2 = defaultDateTypeAdapter2;
            typeAdapter3 = defaultDateTypeAdapter3;
        } else {
            return;
        }
        list.add(TypeAdapters.newFactory(Date.class, typeAdapter));
        list.add(TypeAdapters.newFactory(Timestamp.class, typeAdapter2));
        list.add(TypeAdapters.newFactory(java.sql.Date.class, typeAdapter3));
    }

    public GsonBuilder setDateFormat(int i) {
        this.f6172c5 = i;
        this.f6178s = null;
        return this;
    }

    public GsonBuilder setDateFormat(int i, int i5) {
        this.f6172c5 = i;
        this.f6176i9 = i5;
        this.f6178s = null;
        return this;
    }

    public GsonBuilder(Gson gson) {
        this.y = Excluder.DEFAULT;
        this.f6177n3 = LongSerializationPolicy.DEFAULT;
        this.f6185zn = FieldNamingPolicy.IDENTITY;
        HashMap hashMap = new HashMap();
        this.f6175gv = hashMap;
        ArrayList arrayList = new ArrayList();
        this.f6181v = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f6171a = arrayList2;
        this.f6174fb = false;
        this.f6172c5 = 2;
        this.f6176i9 = 2;
        this.f6173f = false;
        this.f6179t = false;
        this.f6180tl = true;
        this.f6183wz = false;
        this.f6184xc = false;
        this.f6182w = false;
        this.y = gson.f6151a;
        this.f6185zn = gson.f6155fb;
        hashMap.putAll(gson.f6162s);
        this.f6174fb = gson.f6152c5;
        this.f6173f = gson.f6157i9;
        this.f6184xc = gson.f6154f;
        this.f6180tl = gson.f6163t;
        this.f6183wz = gson.f6164tl;
        this.f6182w = gson.f6167wz;
        this.f6179t = gson.f6168xc;
        this.f6177n3 = gson.f6153co;
        this.f6178s = gson.f6166w;
        this.f6172c5 = gson.f6160p;
        this.f6176i9 = gson.f6158mt;
        arrayList.addAll(gson.f6169z);
        arrayList2.addAll(gson.f6161r);
    }
}

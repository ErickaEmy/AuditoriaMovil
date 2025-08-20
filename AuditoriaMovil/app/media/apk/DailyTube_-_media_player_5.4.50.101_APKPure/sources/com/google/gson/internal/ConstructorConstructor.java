package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
/* loaded from: classes.dex */
public final class ConstructorConstructor {

    /* renamed from: n3  reason: collision with root package name */
    public final ReflectionAccessor f6186n3 = ReflectionAccessor.getInstance();
    public final Map<Type, InstanceCreator<?>> y;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map) {
        this.y = map;
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken) {
        final Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        final InstanceCreator<?> instanceCreator = this.y.get(type);
        if (instanceCreator != null) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.1
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) instanceCreator.createInstance(type);
                }
            };
        }
        final InstanceCreator<?> instanceCreator2 = this.y.get(rawType);
        if (instanceCreator2 != null) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.2
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) instanceCreator2.createInstance(type);
                }
            };
        }
        ObjectConstructor<T> y = y(rawType);
        if (y != null) {
            return y;
        }
        ObjectConstructor<T> n32 = n3(type, rawType);
        if (n32 != null) {
            return n32;
        }
        return zn(type, rawType);
    }

    public final <T> ObjectConstructor<T> n3(final Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.4
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new TreeSet();
                    }
                };
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.5
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        Type type2 = type;
                        if (type2 instanceof ParameterizedType) {
                            Type type3 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                            if (type3 instanceof Class) {
                                return (T) EnumSet.noneOf((Class) type3);
                            }
                            throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                        }
                        throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                    }
                };
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.6
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new LinkedHashSet();
                    }
                };
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.7
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new ArrayDeque();
                    }
                };
            }
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.8
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new ArrayList();
                }
            };
        } else if (Map.class.isAssignableFrom(cls)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.9
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new ConcurrentSkipListMap();
                    }
                };
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.10
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new ConcurrentHashMap();
                    }
                };
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.11
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new TreeMap();
                    }
                };
            }
            if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.12
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new LinkedHashMap();
                    }
                };
            }
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.13
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new LinkedTreeMap();
                }
            };
        } else {
            return null;
        }
    }

    public String toString() {
        return this.y.toString();
    }

    public final <T> ObjectConstructor<T> y(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(null);
            if (!declaredConstructor.isAccessible()) {
                this.f6186n3.makeAccessible(declaredConstructor);
            }
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.3
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    try {
                        return (T) declaredConstructor.newInstance(null);
                    } catch (IllegalAccessException e2) {
                        throw new AssertionError(e2);
                    } catch (InstantiationException e3) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e3);
                    } catch (InvocationTargetException e5) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e5.getTargetException());
                    }
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final <T> ObjectConstructor<T> zn(final Type type, final Class<? super T> cls) {
        return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.14
            public final UnsafeAllocator y = UnsafeAllocator.create();

            @Override // com.google.gson.internal.ObjectConstructor
            public T construct() {
                try {
                    return (T) this.y.newInstance(cls);
                } catch (Exception e2) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e2);
                }
            }
        };
    }
}

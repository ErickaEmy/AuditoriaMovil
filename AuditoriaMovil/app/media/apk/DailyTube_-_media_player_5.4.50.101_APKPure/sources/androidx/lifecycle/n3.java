package androidx.lifecycle;

import androidx.annotation.Nullable;
import androidx.lifecycle.v;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import y5.co;
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: zn  reason: collision with root package name */
    public static n3 f2638zn = new n3();
    public final Map<Class<?>, y> y = new HashMap();

    /* renamed from: n3  reason: collision with root package name */
    public final Map<Class<?>, Boolean> f2639n3 = new HashMap();

    /* renamed from: androidx.lifecycle.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0020n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final Method f2640n3;
        public final int y;

        public C0020n3(int i, Method method) {
            this.y = i;
            this.f2640n3 = method;
            method.setAccessible(true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0020n3)) {
                return false;
            }
            C0020n3 c0020n3 = (C0020n3) obj;
            if (this.y == c0020n3.y && this.f2640n3.getName().equals(c0020n3.f2640n3.getName())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.y * 31) + this.f2640n3.getName().hashCode();
        }

        public void y(co coVar, v.n3 n3Var, Object obj) {
            try {
                int i = this.y;
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            this.f2640n3.invoke(obj, coVar, n3Var);
                            return;
                        }
                        return;
                    }
                    this.f2640n3.invoke(obj, coVar);
                    return;
                }
                this.f2640n3.invoke(obj, null);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to call observer method", e3.getCause());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class y {

        /* renamed from: n3  reason: collision with root package name */
        public final Map<C0020n3, v.n3> f2641n3;
        public final Map<v.n3, List<C0020n3>> y = new HashMap();

        public y(Map<C0020n3, v.n3> map) {
            this.f2641n3 = map;
            for (Map.Entry<C0020n3, v.n3> entry : map.entrySet()) {
                v.n3 value = entry.getValue();
                List<C0020n3> list = this.y.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.y.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        public static void n3(List<C0020n3> list, co coVar, v.n3 n3Var, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).y(coVar, n3Var, obj);
                }
            }
        }

        public void y(co coVar, v.n3 n3Var, Object obj) {
            n3(this.y.get(n3Var), coVar, n3Var, obj);
            n3(this.y.get(v.n3.ON_ANY), coVar, n3Var, obj);
        }
    }

    public boolean gv(Class<?> cls) {
        Boolean bool = this.f2639n3.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] n32 = n3(cls);
        for (Method method : n32) {
            if (((c5) method.getAnnotation(c5.class)) != null) {
                y(cls, n32);
                return true;
            }
        }
        this.f2639n3.put(cls, Boolean.FALSE);
        return false;
    }

    public final Method[] n3(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }

    public final void v(Map<C0020n3, v.n3> map, C0020n3 c0020n3, v.n3 n3Var, Class<?> cls) {
        v.n3 n3Var2 = map.get(c0020n3);
        if (n3Var2 != null && n3Var != n3Var2) {
            Method method = c0020n3.f2640n3;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + n3Var2 + ", new value " + n3Var);
        } else if (n3Var2 == null) {
            map.put(c0020n3, n3Var);
        }
    }

    public final y y(Class<?> cls, @Nullable Method[] methodArr) {
        int i;
        y zn2;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (zn2 = zn(superclass)) != null) {
            hashMap.putAll(zn2.f2641n3);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<C0020n3, v.n3> entry : zn(cls2).f2641n3.entrySet()) {
                v(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = n3(cls);
        }
        boolean z2 = false;
        for (Method method : methodArr) {
            c5 c5Var = (c5) method.getAnnotation(c5.class);
            if (c5Var != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length > 0) {
                    if (parameterTypes[0].isAssignableFrom(co.class)) {
                        i = 1;
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                } else {
                    i = 0;
                }
                v.n3 value = c5Var.value();
                if (parameterTypes.length > 1) {
                    if (parameterTypes[1].isAssignableFrom(v.n3.class)) {
                        if (value == v.n3.ON_ANY) {
                            i = 2;
                        } else {
                            throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                        }
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                }
                if (parameterTypes.length <= 2) {
                    v(hashMap, new C0020n3(i, method), value, cls);
                    z2 = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        y yVar = new y(hashMap);
        this.y.put(cls, yVar);
        this.f2639n3.put(cls, Boolean.valueOf(z2));
        return yVar;
    }

    public y zn(Class<?> cls) {
        y yVar = this.y.get(cls);
        if (yVar != null) {
            return yVar;
        }
        return y(cls, null);
    }
}

package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import y5.mt;
/* loaded from: classes.dex */
public class s {
    public static Map<Class<?>, Integer> y = new HashMap();

    /* renamed from: n3  reason: collision with root package name */
    public static Map<Class<?>, List<Constructor<? extends zn>>> f2642n3 = new HashMap();

    @NonNull
    public static a a(Object obj) {
        boolean z2 = obj instanceof a;
        boolean z3 = obj instanceof y5.t;
        if (z2 && z3) {
            return new FullLifecycleObserverAdapter((y5.t) obj, (a) obj);
        }
        if (z3) {
            return new FullLifecycleObserverAdapter((y5.t) obj, null);
        }
        if (z2) {
            return (a) obj;
        }
        Class<?> cls = obj.getClass();
        if (gv(cls) == 2) {
            List<Constructor<? extends zn>> list = f2642n3.get(cls);
            if (list.size() == 1) {
                return new SingleGeneratedAdapterObserver(y(list.get(0), obj));
            }
            zn[] znVarArr = new zn[list.size()];
            for (int i = 0; i < list.size(); i++) {
                znVarArr[i] = y(list.get(i), obj);
            }
            return new CompositeGeneratedAdaptersObserver(znVarArr);
        }
        return new ReflectiveGenericLifecycleObserver(obj);
    }

    public static int fb(Class<?> cls) {
        ArrayList arrayList;
        Class<?>[] interfaces;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends zn> n32 = n3(cls);
        if (n32 != null) {
            f2642n3.put(cls, Collections.singletonList(n32));
            return 2;
        } else if (n3.f2638zn.gv(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            if (v(superclass)) {
                if (gv(superclass) == 1) {
                    return 1;
                }
                arrayList = new ArrayList(f2642n3.get(superclass));
            } else {
                arrayList = null;
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (v(cls2)) {
                    if (gv(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(f2642n3.get(cls2));
                }
            }
            if (arrayList == null) {
                return 1;
            }
            f2642n3.put(cls, arrayList);
            return 2;
        }
    }

    public static int gv(Class<?> cls) {
        Integer num = y.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int fb2 = fb(cls);
        y.put(cls, Integer.valueOf(fb2));
        return fb2;
    }

    @Nullable
    public static Constructor<? extends zn> n3(Class<?> cls) {
        String str;
        try {
            Package r1 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            if (r1 != null) {
                str = r1.getName();
            } else {
                str = "";
            }
            if (!str.isEmpty()) {
                canonicalName = canonicalName.substring(str.length() + 1);
            }
            String zn2 = zn(canonicalName);
            if (!str.isEmpty()) {
                zn2 = str + "." + zn2;
            }
            Constructor declaredConstructor = Class.forName(zn2).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static boolean v(Class<?> cls) {
        if (cls != null && mt.class.isAssignableFrom(cls)) {
            return true;
        }
        return false;
    }

    public static zn y(Constructor<? extends zn> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    public static String zn(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }
}

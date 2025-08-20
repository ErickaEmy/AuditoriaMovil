package j0;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class j {
    public static Object a(Class cls, String str, Class cls2, Class cls3, Object obj) {
        try {
            return cls2.cast(c5(cls, "isDexOptNeeded", cls3).invoke(null, obj));
        } catch (Exception e2) {
            throw new oz(String.format("Failed to invoke static method %s on type %s", "isDexOptNeeded", cls), e2);
        }
    }

    public static Method c5(Class cls, String str, Class... clsArr) {
        for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                Method declaredMethod = cls2.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new oz(String.format("Could not find a method named %s with parameters %s in type %s", str, Arrays.asList(clsArr), cls));
    }

    public static Object fb(Class cls, String str, Class cls2, Class cls3, Object obj, Class cls4, Object obj2) {
        try {
            return cls2.cast(c5(cls, "optimizedPathFor", cls3, cls4).invoke(null, obj, obj2));
        } catch (Exception e2) {
            throw new oz(String.format("Failed to invoke static method %s on type %s", "optimizedPathFor", cls), e2);
        }
    }

    public static Object gv(Object obj, String str, Class cls, Class cls2, Object obj2) {
        try {
            return cls.cast(c5(obj.getClass(), str, cls2).invoke(obj, obj2));
        } catch (Exception e2) {
            throw new oz(String.format("Failed to invoke method %s on an object of type %s", str, obj.getClass()), e2);
        }
    }

    public static o n3(Object obj, String str, Class cls) {
        return new o(obj, s(obj, str), cls);
    }

    public static Field s(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new oz(String.format("Failed to find a field named %s on an object of instance %s", str, obj.getClass().getName()));
    }

    public static Object v(Object obj, String str, Class cls, Class cls2, Object obj2, Class cls3, Object obj3, Class cls4, Object obj4) {
        try {
            return cls.cast(c5(obj.getClass(), str, cls2, cls3, cls4).invoke(obj, obj2, obj3, obj4));
        } catch (Exception e2) {
            throw new oz(String.format("Failed to invoke method %s on an object of type %s", str, obj.getClass()), e2);
        }
    }

    public static qn y(Object obj, String str, Class cls) {
        return new qn(obj, s(obj, str), cls);
    }

    public static Object zn(Class cls) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor.newInstance(null);
        } catch (Exception e2) {
            throw new oz(String.format("Failed to invoke default constructor on class %s", cls.getName()), e2);
        }
    }
}

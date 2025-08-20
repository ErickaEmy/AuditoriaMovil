package com.uv.v7;

import android.content.Context;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class ReflectUtils {
    public static final void dumpObject(Object obj, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Field[] declaredFields;
        try {
            Class<?> cls = obj.getClass();
            do {
                printWriter.println("c=" + cls.getName());
                for (Field field : cls.getDeclaredFields()) {
                    boolean isAccessible = field.isAccessible();
                    if (!isAccessible) {
                        field.setAccessible(true);
                    }
                    Object obj2 = field.get(obj);
                    printWriter.print(field.getName());
                    printWriter.print("=");
                    if (obj2 != null) {
                        printWriter.println(obj2.toString());
                    } else {
                        printWriter.println("null");
                    }
                    if (!isAccessible) {
                        field.setAccessible(isAccessible);
                    }
                }
                cls = cls.getSuperclass();
                if (cls == null || cls.equals(Object.class)) {
                    return;
                }
            } while (!cls.equals(Context.class));
        } catch (Throwable unused) {
        }
    }

    public static List<Field> getAllFieldsList(Class<?> cls) {
        boolean z2;
        if (cls != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Validate.isTrue(z2, "The class must not be null", new Object[0]);
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            for (Field field : cls.getDeclaredFields()) {
                arrayList.add(field);
            }
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    public static Class<?> getClass(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    public static Field getField(Object obj, String str) {
        return getField(obj.getClass(), str);
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        boolean z2;
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                Method declaredMethod = cls2.getDeclaredMethod(str, clsArr);
                setAccessible(declaredMethod, true);
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        Method method = null;
        for (Class<?> cls3 : cls.getInterfaces()) {
            try {
                Method method2 = cls3.getMethod(str, clsArr);
                if (method == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Validate.isTrue(z2, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", str, cls);
                method = method2;
            } catch (NoSuchMethodException unused2) {
            }
        }
        return method;
    }

    public static <T> T invokeConstructor(Class<T> cls, Class[] clsArr, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<T> constructor = cls.getConstructor(clsArr);
        if (constructor != null) {
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        }
        return null;
    }

    public static Object invokeMethod(Object obj, String str, Class<?>[] clsArr, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return getMethod(obj.getClass(), str, clsArr).invoke(obj, objArr);
    }

    public static Object invokeStaticMethod(Class cls, String str) throws InvocationTargetException, IllegalAccessException {
        return getMethod(cls, str, new Class[0]).invoke(null, null);
    }

    public static Object readField(Object obj, String str) throws IllegalAccessException, NoSuchFieldException {
        return readField(obj.getClass(), obj, str);
    }

    public static Object readStaticField(Class<?> cls, String str) throws NoSuchFieldException, IllegalAccessException {
        return readField(cls, null, str);
    }

    public static void removeFieldFinalModifier(Field field) {
        boolean z2;
        if (field != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Validate.isTrue(z2, "The field must not be null", new Object[0]);
        try {
            if (Modifier.isFinal(field.getModifiers())) {
                Field declaredField = Field.class.getDeclaredField("modifiers");
                boolean isAccessible = declaredField.isAccessible();
                if (!isAccessible) {
                    declaredField.setAccessible(true);
                }
                declaredField.setInt(field, field.getModifiers() & (-17));
                if (!isAccessible) {
                    declaredField.setAccessible(false);
                }
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
    }

    public static void setAccessible(AccessibleObject accessibleObject, boolean z2) {
        if (accessibleObject.isAccessible() != z2) {
            accessibleObject.setAccessible(z2);
        }
    }

    public static void writeField(Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalAccessException {
        writeField(obj.getClass(), obj, str, obj2);
    }

    public static Field getField(Class<?> cls, String str) {
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                setAccessible(declaredField, true);
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = null;
        for (Class<?> cls3 : cls.getInterfaces()) {
            try {
                Field field2 = cls3.getField(str);
                Validate.isTrue(field == null, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", str, cls);
                field = field2;
            } catch (NoSuchFieldException unused2) {
            }
        }
        return field;
    }

    public static Object readField(Class<?> cls, Object obj, String str) throws IllegalAccessException, NoSuchFieldException {
        return readField(getField(cls, str), obj);
    }

    public static void writeField(Class<?> cls, Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalAccessException {
        writeField(getField(cls, str), obj, obj2);
    }

    public static Object invokeMethod(ClassLoader classLoader, String str, String str2, Object obj, Class<?>[] clsArr, Object... objArr) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> cls;
        Method method;
        if (obj == null || (cls = Class.forName(str, false, classLoader)) == null || (method = cls.getMethod(str2, clsArr)) == null) {
            return null;
        }
        method.setAccessible(true);
        return method.invoke(obj, objArr);
    }

    public static Object readField(Field field, Object obj) throws IllegalAccessException {
        return field.get(obj);
    }

    public static void writeField(Field field, Object obj, Object obj2) throws IllegalAccessException {
        field.set(obj, obj2);
    }
}

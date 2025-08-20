package com.google.gson.internal.reflect;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
final class UnsafeReflectionAccessor extends ReflectionAccessor {

    /* renamed from: gv  reason: collision with root package name */
    public static Class f6274gv;

    /* renamed from: n3  reason: collision with root package name */
    public final Object f6275n3 = n3();

    /* renamed from: zn  reason: collision with root package name */
    public final Field f6276zn = y();

    public static Object n3() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f6274gv = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Field y() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    @Override // com.google.gson.internal.reflect.ReflectionAccessor
    public void makeAccessible(AccessibleObject accessibleObject) {
        if (!zn(accessibleObject)) {
            try {
                accessibleObject.setAccessible(true);
            } catch (SecurityException e2) {
                throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e2);
            }
        }
    }

    public boolean zn(AccessibleObject accessibleObject) {
        if (this.f6275n3 != null && this.f6276zn != null) {
            try {
                Long l2 = (Long) f6274gv.getMethod("objectFieldOffset", Field.class).invoke(this.f6275n3, this.f6276zn);
                l2.longValue();
                f6274gv.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f6275n3, accessibleObject, l2, Boolean.TRUE);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}

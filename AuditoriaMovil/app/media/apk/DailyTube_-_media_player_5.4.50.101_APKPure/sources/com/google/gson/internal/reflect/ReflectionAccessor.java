package com.google.gson.internal.reflect;

import com.google.gson.internal.JavaVersion;
import java.lang.reflect.AccessibleObject;
/* loaded from: classes.dex */
public abstract class ReflectionAccessor {
    public static final ReflectionAccessor y;

    static {
        ReflectionAccessor unsafeReflectionAccessor;
        if (JavaVersion.getMajorJavaVersion() < 9) {
            unsafeReflectionAccessor = new PreJava9ReflectionAccessor();
        } else {
            unsafeReflectionAccessor = new UnsafeReflectionAccessor();
        }
        y = unsafeReflectionAccessor;
    }

    public static ReflectionAccessor getInstance() {
        return y;
    }

    public abstract void makeAccessible(AccessibleObject accessibleObject);
}

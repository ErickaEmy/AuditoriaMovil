package com.google.common.base;
/* loaded from: classes.dex */
public abstract class Preconditions {
    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkState(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static Object checkNotNull(Object obj) {
        obj.getClass();
        return obj;
    }
}

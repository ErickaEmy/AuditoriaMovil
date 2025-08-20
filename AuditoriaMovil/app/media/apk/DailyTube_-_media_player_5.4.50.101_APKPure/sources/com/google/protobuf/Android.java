package com.google.protobuf;
/* loaded from: classes.dex */
final class Android {

    /* renamed from: n3  reason: collision with root package name */
    public static final Class<?> f6302n3 = y("libcore.io.Memory");
    public static boolean y;

    /* renamed from: zn  reason: collision with root package name */
    public static final boolean f6303zn;

    static {
        boolean z2;
        if (!y && y("org.robolectric.Robolectric") != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        f6303zn = z2;
    }

    public static Class<?> n3() {
        return f6302n3;
    }

    public static <T> Class<T> y(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean zn() {
        if (!y && (f6302n3 == null || f6303zn)) {
            return false;
        }
        return true;
    }
}

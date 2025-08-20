package com.google.protobuf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ExtensionRegistryFactory {
    public static final Class<?> y = zn();

    public static ExtensionRegistryLite create() {
        ExtensionRegistryLite y2 = y("newInstance");
        if (y2 == null) {
            return new ExtensionRegistryLite();
        }
        return y2;
    }

    public static ExtensionRegistryLite createEmpty() {
        ExtensionRegistryLite y2 = y("getEmptyRegistry");
        if (y2 == null) {
            return ExtensionRegistryLite.f6396v;
        }
        return y2;
    }

    public static boolean n3(ExtensionRegistryLite extensionRegistryLite) {
        Class<?> cls = y;
        if (cls != null && cls.isAssignableFrom(extensionRegistryLite.getClass())) {
            return true;
        }
        return false;
    }

    public static final ExtensionRegistryLite y(String str) {
        Class<?> cls = y;
        if (cls == null) {
            return null;
        }
        try {
            return (ExtensionRegistryLite) cls.getDeclaredMethod(str, null).invoke(null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Class<?> zn() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}

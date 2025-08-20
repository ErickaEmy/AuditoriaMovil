package com.google.protobuf;
@CheckReturnValue
/* loaded from: classes.dex */
final class ExtensionSchemas {
    public static final ExtensionSchema<?> y = new ExtensionSchemaLite();

    /* renamed from: n3  reason: collision with root package name */
    public static final ExtensionSchema<?> f6399n3 = zn();

    public static ExtensionSchema<?> n3() {
        return y;
    }

    public static ExtensionSchema<?> y() {
        ExtensionSchema<?> extensionSchema = f6399n3;
        if (extensionSchema != null) {
            return extensionSchema;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static ExtensionSchema<?> zn() {
        try {
            return (ExtensionSchema) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}

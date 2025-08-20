package com.google.protobuf;
@CheckReturnValue
/* loaded from: classes.dex */
final class NewInstanceSchemas {
    public static final NewInstanceSchema y = zn();

    /* renamed from: n3  reason: collision with root package name */
    public static final NewInstanceSchema f6497n3 = new NewInstanceSchemaLite();

    public static NewInstanceSchema n3() {
        return f6497n3;
    }

    public static NewInstanceSchema y() {
        return y;
    }

    public static NewInstanceSchema zn() {
        try {
            return (NewInstanceSchema) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}

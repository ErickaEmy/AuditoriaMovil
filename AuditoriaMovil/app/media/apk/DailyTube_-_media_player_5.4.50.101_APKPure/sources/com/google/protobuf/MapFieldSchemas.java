package com.google.protobuf;
@CheckReturnValue
/* loaded from: classes.dex */
final class MapFieldSchemas {
    public static final MapFieldSchema y = zn();

    /* renamed from: n3  reason: collision with root package name */
    public static final MapFieldSchema f6475n3 = new MapFieldSchemaLite();

    public static MapFieldSchema n3() {
        return f6475n3;
    }

    public static MapFieldSchema y() {
        return y;
    }

    public static MapFieldSchema zn() {
        try {
            return (MapFieldSchema) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}

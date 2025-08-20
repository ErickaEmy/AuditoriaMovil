package com.google.protobuf;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes.dex */
public final class Protobuf {

    /* renamed from: zn  reason: collision with root package name */
    public static final Protobuf f6500zn = new Protobuf();

    /* renamed from: n3  reason: collision with root package name */
    public final ConcurrentMap<Class<?>, Schema<?>> f6501n3 = new ConcurrentHashMap();
    public final SchemaFactory y = new ManifestSchemaFactory();

    public static Protobuf getInstance() {
        return f6500zn;
    }

    public <T> void makeImmutable(T t2) {
        schemaFor((Protobuf) t2).makeImmutable(t2);
    }

    public <T> void mergeFrom(T t2, Reader reader) throws IOException {
        mergeFrom(t2, reader, ExtensionRegistryLite.getEmptyRegistry());
    }

    public Schema<?> registerSchema(Class<?> cls, Schema<?> schema) {
        Internal.n3(cls, "messageType");
        Internal.n3(schema, "schema");
        return this.f6501n3.putIfAbsent(cls, schema);
    }

    @CanIgnoreReturnValue
    public Schema<?> registerSchemaOverride(Class<?> cls, Schema<?> schema) {
        Internal.n3(cls, "messageType");
        Internal.n3(schema, "schema");
        return this.f6501n3.put(cls, schema);
    }

    public <T> Schema<T> schemaFor(Class<T> cls) {
        Internal.n3(cls, "messageType");
        Schema<T> schema = (Schema<T>) this.f6501n3.get(cls);
        if (schema == null) {
            Schema<T> createSchema = this.y.createSchema(cls);
            Schema<T> schema2 = (Schema<T>) registerSchema(cls, createSchema);
            return schema2 != null ? schema2 : createSchema;
        }
        return schema;
    }

    public <T> void writeTo(T t2, Writer writer) throws IOException {
        schemaFor((Protobuf) t2).writeTo(t2, writer);
    }

    public <T> void mergeFrom(T t2, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        schemaFor((Protobuf) t2).mergeFrom(t2, reader, extensionRegistryLite);
    }

    public <T> Schema<T> schemaFor(T t2) {
        return schemaFor((Class) t2.getClass());
    }
}

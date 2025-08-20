package com.google.protobuf;

import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet.FieldDescriptorLite;
import java.io.IOException;
import java.util.Map;
@CheckReturnValue
/* loaded from: classes.dex */
abstract class ExtensionSchema<T extends FieldSet.FieldDescriptorLite<T>> {
    public abstract void a(Object obj);

    public abstract void c5(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet) throws IOException;

    public abstract <UT, UB> UB fb(Object obj, Reader reader, Object obj2, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) throws IOException;

    public abstract FieldSet<T> gv(Object obj);

    public abstract void i9(Writer writer, Map.Entry<?, ?> entry) throws IOException;

    public abstract Object n3(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i);

    public abstract void s(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet) throws IOException;

    public abstract boolean v(MessageLite messageLite);

    public abstract int y(Map.Entry<?, ?> entry);

    public abstract FieldSet<T> zn(Object obj);
}

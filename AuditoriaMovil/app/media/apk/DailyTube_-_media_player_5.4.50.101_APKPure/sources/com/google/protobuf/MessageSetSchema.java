package com.google.protobuf;

import com.google.protobuf.FieldSet;
import com.google.protobuf.LazyField;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
@CheckReturnValue
/* loaded from: classes.dex */
final class MessageSetSchema<T> implements Schema<T> {

    /* renamed from: gv  reason: collision with root package name */
    public final ExtensionSchema<?> f6494gv;

    /* renamed from: n3  reason: collision with root package name */
    public final UnknownFieldSchema<?, ?> f6495n3;
    public final MessageLite y;

    /* renamed from: zn  reason: collision with root package name */
    public final boolean f6496zn;

    public MessageSetSchema(UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MessageLite messageLite) {
        this.f6495n3 = unknownFieldSchema;
        this.f6496zn = extensionSchema.v(messageLite);
        this.f6494gv = extensionSchema;
        this.y = messageLite;
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void n3(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T t2, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        UB a2 = unknownFieldSchema.a(t2);
        FieldSet<ET> gv2 = extensionSchema.gv(t2);
        do {
            try {
                if (reader.getFieldNumber() == Integer.MAX_VALUE) {
                    return;
                }
            } finally {
                unknownFieldSchema.xc(t2, a2);
            }
        } while (gv(reader, extensionRegistryLite, extensionSchema, gv2, unknownFieldSchema, a2));
    }

    private <UT, UB> int y(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t2) {
        return unknownFieldSchema.c5(unknownFieldSchema.fb(t2));
    }

    public static <T> MessageSetSchema<T> zn(UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MessageLite messageLite) {
        return new MessageSetSchema<>(unknownFieldSchema, extensionSchema, messageLite);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T t2, T t3) {
        if (!this.f6495n3.fb(t2).equals(this.f6495n3.fb(t3))) {
            return false;
        }
        if (this.f6496zn) {
            return this.f6494gv.zn(t2).equals(this.f6494gv.zn(t3));
        }
        return true;
    }

    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T t2) {
        int y = y(this.f6495n3, t2);
        if (this.f6496zn) {
            return y + this.f6494gv.zn(t2).getMessageSetSerializedSize();
        }
        return y;
    }

    public final <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean gv(Reader reader, ExtensionRegistryLite extensionRegistryLite, ExtensionSchema<ET> extensionSchema, FieldSet<ET> fieldSet, UnknownFieldSchema<UT, UB> unknownFieldSchema, UB ub) throws IOException {
        int tag = reader.getTag();
        if (tag != WireFormat.y) {
            if (WireFormat.getTagWireType(tag) == 2) {
                Object n32 = extensionSchema.n3(extensionRegistryLite, this.y, WireFormat.getTagFieldNumber(tag));
                if (n32 != null) {
                    extensionSchema.s(reader, n32, extensionRegistryLite, fieldSet);
                    return true;
                }
                return unknownFieldSchema.tl(ub, reader);
            }
            return reader.skipField();
        }
        Object obj = null;
        ByteString byteString = null;
        int i = 0;
        while (reader.getFieldNumber() != Integer.MAX_VALUE) {
            int tag2 = reader.getTag();
            if (tag2 == WireFormat.f6572zn) {
                i = reader.readUInt32();
                obj = extensionSchema.n3(extensionRegistryLite, this.y, i);
            } else if (tag2 == WireFormat.f6570gv) {
                if (obj != null) {
                    extensionSchema.s(reader, obj, extensionRegistryLite, fieldSet);
                } else {
                    byteString = reader.readBytes();
                }
            } else if (!reader.skipField()) {
                break;
            }
        }
        if (reader.getTag() == WireFormat.f6571n3) {
            if (byteString != null) {
                if (obj != null) {
                    extensionSchema.c5(byteString, obj, extensionRegistryLite, fieldSet);
                } else {
                    unknownFieldSchema.gv(ub, i, byteString);
                }
            }
            return true;
        }
        throw InvalidProtocolBufferException.gv();
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T t2) {
        int hashCode = this.f6495n3.fb(t2).hashCode();
        if (this.f6496zn) {
            return (hashCode * 53) + this.f6494gv.zn(t2).hashCode();
        }
        return hashCode;
    }

    @Override // com.google.protobuf.Schema
    public final boolean isInitialized(T t2) {
        return this.f6494gv.zn(t2).isInitialized();
    }

    @Override // com.google.protobuf.Schema
    public void makeImmutable(T t2) {
        this.f6495n3.i9(t2);
        this.f6494gv.a(t2);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t2, T t3) {
        SchemaUtil.z6(this.f6495n3, t2, t3);
        if (this.f6496zn) {
            SchemaUtil.ta(this.f6494gv, t2, t3);
        }
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        MessageLite messageLite = this.y;
        if (messageLite instanceof GeneratedMessageLite) {
            return (T) ((GeneratedMessageLite) messageLite).newMutableInstance();
        }
        return (T) messageLite.newBuilderForType().buildPartial();
    }

    public final <UT, UB> void v(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t2, Writer writer) throws IOException {
        unknownFieldSchema.co(unknownFieldSchema.fb(t2), writer);
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T t2, Writer writer) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.f6494gv.zn(t2).iterator();
        while (it.hasNext()) {
            Map.Entry<?, Object> next = it.next();
            FieldSet.FieldDescriptorLite fieldDescriptorLite = (FieldSet.FieldDescriptorLite) next.getKey();
            if (fieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !fieldDescriptorLite.isRepeated() && !fieldDescriptorLite.isPacked()) {
                if (next instanceof LazyField.LazyEntry) {
                    writer.writeMessageSetItem(fieldDescriptorLite.getNumber(), ((LazyField.LazyEntry) next).getField().toByteString());
                } else {
                    writer.writeMessageSetItem(fieldDescriptorLite.getNumber(), next.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        v(this.f6495n3, t2, writer);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00cb A[EDGE_INSN: B:57:0x00cb->B:34:0x00cb ?: BREAK  , SYNTHETIC] */
    @Override // com.google.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mergeFrom(T r11, byte[] r12, int r13, int r14, com.google.protobuf.ArrayDecoders.Registers r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.google.protobuf.GeneratedMessageLite r0 = (com.google.protobuf.GeneratedMessageLite) r0
            com.google.protobuf.UnknownFieldSetLite r1 = r0.unknownFields
            com.google.protobuf.UnknownFieldSetLite r2 = com.google.protobuf.UnknownFieldSetLite.getDefaultInstance()
            if (r1 != r2) goto L11
            com.google.protobuf.UnknownFieldSetLite r1 = com.google.protobuf.UnknownFieldSetLite.f()
            r0.unknownFields = r1
        L11:
            com.google.protobuf.GeneratedMessageLite$ExtendableMessage r11 = (com.google.protobuf.GeneratedMessageLite.ExtendableMessage) r11
            com.google.protobuf.FieldSet r11 = r11.ensureExtensionsAreMutable()
            r0 = 0
            r2 = r0
        L19:
            if (r13 >= r14) goto Ld7
            int r4 = com.google.protobuf.ArrayDecoders.ud(r12, r13, r15)
            int r13 = r15.int1
            int r3 = com.google.protobuf.WireFormat.y
            r5 = 2
            if (r13 == r3) goto L6b
            int r3 = com.google.protobuf.WireFormat.getTagWireType(r13)
            if (r3 != r5) goto L66
            com.google.protobuf.ExtensionSchema<?> r2 = r10.f6494gv
            com.google.protobuf.ExtensionRegistryLite r3 = r15.extensionRegistry
            com.google.protobuf.MessageLite r5 = r10.y
            int r6 = com.google.protobuf.WireFormat.getTagFieldNumber(r13)
            java.lang.Object r2 = r2.n3(r3, r5, r6)
            r8 = r2
            com.google.protobuf.GeneratedMessageLite$GeneratedExtension r8 = (com.google.protobuf.GeneratedMessageLite.GeneratedExtension) r8
            if (r8 == 0) goto L5c
            com.google.protobuf.Protobuf r13 = com.google.protobuf.Protobuf.getInstance()
            com.google.protobuf.MessageLite r2 = r8.getMessageDefaultInstance()
            java.lang.Class r2 = r2.getClass()
            com.google.protobuf.Schema r13 = r13.schemaFor(r2)
            int r13 = com.google.protobuf.ArrayDecoders.w(r13, r12, r4, r14, r15)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r2 = r8.f6444gv
            java.lang.Object r3 = r15.object1
            r11.setField(r2, r3)
        L5a:
            r2 = r8
            goto L19
        L5c:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.protobuf.ArrayDecoders.z6(r2, r3, r4, r5, r6, r7)
            goto L5a
        L66:
            int r13 = com.google.protobuf.ArrayDecoders.hw(r13, r12, r4, r14, r15)
            goto L19
        L6b:
            r13 = 0
            r3 = r0
        L6d:
            if (r4 >= r14) goto Lcb
            int r4 = com.google.protobuf.ArrayDecoders.ud(r12, r4, r15)
            int r6 = r15.int1
            int r7 = com.google.protobuf.WireFormat.getTagFieldNumber(r6)
            int r8 = com.google.protobuf.WireFormat.getTagWireType(r6)
            if (r7 == r5) goto Lac
            r9 = 3
            if (r7 == r9) goto L83
            goto Lc1
        L83:
            if (r2 == 0) goto La1
            com.google.protobuf.Protobuf r6 = com.google.protobuf.Protobuf.getInstance()
            com.google.protobuf.MessageLite r7 = r2.getMessageDefaultInstance()
            java.lang.Class r7 = r7.getClass()
            com.google.protobuf.Schema r6 = r6.schemaFor(r7)
            int r4 = com.google.protobuf.ArrayDecoders.w(r6, r12, r4, r14, r15)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r6 = r2.f6444gv
            java.lang.Object r7 = r15.object1
            r11.setField(r6, r7)
            goto L6d
        La1:
            if (r8 != r5) goto Lc1
            int r4 = com.google.protobuf.ArrayDecoders.n3(r12, r4, r15)
            java.lang.Object r3 = r15.object1
            com.google.protobuf.ByteString r3 = (com.google.protobuf.ByteString) r3
            goto L6d
        Lac:
            if (r8 != 0) goto Lc1
            int r4 = com.google.protobuf.ArrayDecoders.ud(r12, r4, r15)
            int r13 = r15.int1
            com.google.protobuf.ExtensionSchema<?> r2 = r10.f6494gv
            com.google.protobuf.ExtensionRegistryLite r6 = r15.extensionRegistry
            com.google.protobuf.MessageLite r7 = r10.y
            java.lang.Object r2 = r2.n3(r6, r7, r13)
            com.google.protobuf.GeneratedMessageLite$GeneratedExtension r2 = (com.google.protobuf.GeneratedMessageLite.GeneratedExtension) r2
            goto L6d
        Lc1:
            int r7 = com.google.protobuf.WireFormat.f6571n3
            if (r6 != r7) goto Lc6
            goto Lcb
        Lc6:
            int r4 = com.google.protobuf.ArrayDecoders.hw(r6, r12, r4, r14, r15)
            goto L6d
        Lcb:
            if (r3 == 0) goto Ld4
            int r13 = com.google.protobuf.WireFormat.y(r13, r5)
            r1.wz(r13, r3)
        Ld4:
            r13 = r4
            goto L19
        Ld7:
            if (r13 != r14) goto Lda
            return
        Lda:
            com.google.protobuf.InvalidProtocolBufferException r11 = com.google.protobuf.InvalidProtocolBufferException.mt()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSetSchema.mergeFrom(java.lang.Object, byte[], int, int, com.google.protobuf.ArrayDecoders$Registers):void");
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t2, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        n3(this.f6495n3, this.f6494gv, t2, reader, extensionRegistryLite);
    }
}

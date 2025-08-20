package com.google.protobuf;

import java.io.IOException;
@CheckReturnValue
/* loaded from: classes.dex */
class UnknownFieldSetLiteSchema extends UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> {
    @Override // com.google.protobuf.UnknownFieldSchema
    /* renamed from: a8 */
    public void z(UnknownFieldSetLite unknownFieldSetLite, Writer writer) throws IOException {
        unknownFieldSetLite.writeTo(writer);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* renamed from: c */
    public UnknownFieldSetLite a(Object obj) {
        UnknownFieldSetLite fb2 = fb(obj);
        if (fb2 == UnknownFieldSetLite.getDefaultInstance()) {
            UnknownFieldSetLite f4 = UnknownFieldSetLite.f();
            w(obj, f4);
            return f4;
        }
        return fb2;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* renamed from: d */
    public void xc(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        w(obj, unknownFieldSetLite);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* renamed from: d0 */
    public UnknownFieldSetLite fb(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* renamed from: ej */
    public UnknownFieldSetLite mt(UnknownFieldSetLite unknownFieldSetLite) {
        unknownFieldSetLite.makeImmutable();
        return unknownFieldSetLite;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* renamed from: f3 */
    public void gv(UnknownFieldSetLite unknownFieldSetLite, int i, ByteString byteString) {
        unknownFieldSetLite.wz(WireFormat.y(i, 2), byteString);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* renamed from: fh */
    public int s(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.getSerializedSize();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* renamed from: i4 */
    public void zn(UnknownFieldSetLite unknownFieldSetLite, int i, UnknownFieldSetLite unknownFieldSetLite2) {
        unknownFieldSetLite.wz(WireFormat.y(i, 3), unknownFieldSetLite2);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public void i9(Object obj) {
        fb(obj).makeImmutable();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* renamed from: mg */
    public UnknownFieldSetLite f(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        if (UnknownFieldSetLite.getDefaultInstance().equals(unknownFieldSetLite2)) {
            return unknownFieldSetLite;
        }
        if (UnknownFieldSetLite.getDefaultInstance().equals(unknownFieldSetLite)) {
            return UnknownFieldSetLite.i9(unknownFieldSetLite, unknownFieldSetLite2);
        }
        return unknownFieldSetLite.fb(unknownFieldSetLite2);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* renamed from: n */
    public void v(UnknownFieldSetLite unknownFieldSetLite, int i, long j2) {
        unknownFieldSetLite.wz(WireFormat.y(i, 0), Long.valueOf(j2));
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public boolean p(Reader reader) {
        return false;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* renamed from: r */
    public void y(UnknownFieldSetLite unknownFieldSetLite, int i, int i5) {
        unknownFieldSetLite.wz(WireFormat.y(i, 5), Integer.valueOf(i5));
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* renamed from: rz */
    public int c5(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.getSerializedSizeAsMessageSet();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* renamed from: ta */
    public UnknownFieldSetLite wz() {
        return UnknownFieldSetLite.f();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* renamed from: ud */
    public void co(UnknownFieldSetLite unknownFieldSetLite, Writer writer) throws IOException {
        unknownFieldSetLite.w(writer);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* renamed from: x4 */
    public void n3(UnknownFieldSetLite unknownFieldSetLite, int i, long j2) {
        unknownFieldSetLite.wz(WireFormat.y(i, 1), Long.valueOf(j2));
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* renamed from: z6 */
    public void w(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        ((GeneratedMessageLite) obj).unknownFields = unknownFieldSetLite;
    }
}

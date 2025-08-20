package com.google.protobuf;

import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes.dex */
public abstract class UnknownFieldSchema<T, B> {
    public abstract B a(Object obj);

    public abstract int c5(T t2);

    public abstract void co(T t2, Writer writer) throws IOException;

    public abstract T f(T t2, T t3);

    public abstract T fb(Object obj);

    public abstract void gv(B b2, int i, ByteString byteString);

    public abstract void i9(Object obj);

    public abstract T mt(B b2);

    public abstract void n3(B b2, int i, long j2);

    public abstract boolean p(Reader reader);

    public abstract int s(T t2);

    public final void t(B b2, Reader reader) throws IOException {
        while (reader.getFieldNumber() != Integer.MAX_VALUE && tl(b2, reader)) {
        }
    }

    public final boolean tl(B b2, Reader reader) throws IOException {
        int tag = reader.getTag();
        int tagFieldNumber = WireFormat.getTagFieldNumber(tag);
        int tagWireType = WireFormat.getTagWireType(tag);
        if (tagWireType != 0) {
            if (tagWireType != 1) {
                if (tagWireType != 2) {
                    if (tagWireType != 3) {
                        if (tagWireType != 4) {
                            if (tagWireType == 5) {
                                y(b2, tagFieldNumber, reader.readFixed32());
                                return true;
                            }
                            throw InvalidProtocolBufferException.i9();
                        }
                        return false;
                    }
                    B wz2 = wz();
                    int y = WireFormat.y(tagFieldNumber, 4);
                    t(wz2, reader);
                    if (y == reader.getTag()) {
                        zn(b2, tagFieldNumber, mt(wz2));
                        return true;
                    }
                    throw InvalidProtocolBufferException.gv();
                }
                gv(b2, tagFieldNumber, reader.readBytes());
                return true;
            }
            n3(b2, tagFieldNumber, reader.readFixed64());
            return true;
        }
        v(b2, tagFieldNumber, reader.readInt64());
        return true;
    }

    public abstract void v(B b2, int i, long j2);

    public abstract void w(Object obj, T t2);

    public abstract B wz();

    public abstract void xc(Object obj, B b2);

    public abstract void y(B b2, int i, int i5);

    public abstract void z(T t2, Writer writer) throws IOException;

    public abstract void zn(B b2, int i, T t2);
}

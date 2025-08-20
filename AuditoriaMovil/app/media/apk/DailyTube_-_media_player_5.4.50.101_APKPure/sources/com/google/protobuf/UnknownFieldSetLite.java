package com.google.protobuf;

import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class UnknownFieldSetLite {

    /* renamed from: a  reason: collision with root package name */
    public static final UnknownFieldSetLite f6540a = new UnknownFieldSetLite(0, new int[0], new Object[0], false);

    /* renamed from: gv  reason: collision with root package name */
    public int f6541gv;

    /* renamed from: n3  reason: collision with root package name */
    public int[] f6542n3;

    /* renamed from: v  reason: collision with root package name */
    public boolean f6543v;
    public int y;

    /* renamed from: zn  reason: collision with root package name */
    public Object[] f6544zn;

    public UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    public static UnknownFieldSetLite f() {
        return new UnknownFieldSetLite();
    }

    public static UnknownFieldSetLite getDefaultInstance() {
        return f6540a;
    }

    public static int gv(Object[] objArr, int i) {
        int i5 = 17;
        for (int i6 = 0; i6 < i; i6++) {
            i5 = (i5 * 31) + objArr[i6].hashCode();
        }
        return i5;
    }

    public static UnknownFieldSetLite i9(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        int i = unknownFieldSetLite.y + unknownFieldSetLite2.y;
        int[] copyOf = Arrays.copyOf(unknownFieldSetLite.f6542n3, i);
        System.arraycopy(unknownFieldSetLite2.f6542n3, 0, copyOf, unknownFieldSetLite.y, unknownFieldSetLite2.y);
        Object[] copyOf2 = Arrays.copyOf(unknownFieldSetLite.f6544zn, i);
        System.arraycopy(unknownFieldSetLite2.f6544zn, 0, copyOf2, unknownFieldSetLite.y, unknownFieldSetLite2.y);
        return new UnknownFieldSetLite(i, copyOf, copyOf2, true);
    }

    public static void p(int i, Object obj, Writer writer) throws IOException {
        int tagFieldNumber = WireFormat.getTagFieldNumber(i);
        int tagWireType = WireFormat.getTagWireType(i);
        if (tagWireType != 0) {
            if (tagWireType != 1) {
                if (tagWireType != 2) {
                    if (tagWireType != 3) {
                        if (tagWireType == 5) {
                            writer.writeFixed32(tagFieldNumber, ((Integer) obj).intValue());
                            return;
                        }
                        throw new RuntimeException(InvalidProtocolBufferException.i9());
                    } else if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
                        writer.writeStartGroup(tagFieldNumber);
                        ((UnknownFieldSetLite) obj).writeTo(writer);
                        writer.writeEndGroup(tagFieldNumber);
                        return;
                    } else {
                        writer.writeEndGroup(tagFieldNumber);
                        ((UnknownFieldSetLite) obj).writeTo(writer);
                        writer.writeStartGroup(tagFieldNumber);
                        return;
                    }
                }
                writer.writeBytes(tagFieldNumber, (ByteString) obj);
                return;
            }
            writer.writeFixed64(tagFieldNumber, ((Long) obj).longValue());
            return;
        }
        writer.writeInt64(tagFieldNumber, ((Long) obj).longValue());
    }

    public static boolean t(Object[] objArr, Object[] objArr2, int i) {
        for (int i5 = 0; i5 < i; i5++) {
            if (!objArr[i5].equals(objArr2[i5])) {
                return false;
            }
        }
        return true;
    }

    public static boolean xc(int[] iArr, int[] iArr2, int i) {
        for (int i5 = 0; i5 < i; i5++) {
            if (iArr[i5] != iArr2[i5]) {
                return false;
            }
        }
        return true;
    }

    public static int zn(int[] iArr, int i) {
        int i5 = 17;
        for (int i6 = 0; i6 < i; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        return i5;
    }

    public final UnknownFieldSetLite a(CodedInputStream codedInputStream) throws IOException {
        int readTag;
        do {
            readTag = codedInputStream.readTag();
            if (readTag == 0) {
                break;
            }
        } while (v(readTag, codedInputStream));
        return this;
    }

    public UnknownFieldSetLite c5(int i, int i5) {
        y();
        if (i != 0) {
            wz(WireFormat.y(i, 0), Long.valueOf(i5));
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnknownFieldSetLite)) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        int i = this.y;
        if (i == unknownFieldSetLite.y && xc(this.f6542n3, unknownFieldSetLite.f6542n3, i) && t(this.f6544zn, unknownFieldSetLite.f6544zn, this.y)) {
            return true;
        }
        return false;
    }

    @CanIgnoreReturnValue
    public UnknownFieldSetLite fb(UnknownFieldSetLite unknownFieldSetLite) {
        if (unknownFieldSetLite.equals(getDefaultInstance())) {
            return this;
        }
        y();
        int i = this.y + unknownFieldSetLite.y;
        n3(i);
        System.arraycopy(unknownFieldSetLite.f6542n3, 0, this.f6542n3, this.y, unknownFieldSetLite.y);
        System.arraycopy(unknownFieldSetLite.f6544zn, 0, this.f6544zn, this.y, unknownFieldSetLite.y);
        this.y = i;
        return this;
    }

    public int getSerializedSize() {
        int computeUInt64Size;
        int i = this.f6541gv;
        if (i != -1) {
            return i;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.y; i6++) {
            int i8 = this.f6542n3[i6];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i8);
            int tagWireType = WireFormat.getTagWireType(i8);
            if (tagWireType != 0) {
                if (tagWireType != 1) {
                    if (tagWireType != 2) {
                        if (tagWireType != 3) {
                            if (tagWireType == 5) {
                                computeUInt64Size = CodedOutputStream.computeFixed32Size(tagFieldNumber, ((Integer) this.f6544zn[i6]).intValue());
                            } else {
                                throw new IllegalStateException(InvalidProtocolBufferException.i9());
                            }
                        } else {
                            computeUInt64Size = (CodedOutputStream.computeTagSize(tagFieldNumber) * 2) + ((UnknownFieldSetLite) this.f6544zn[i6]).getSerializedSize();
                        }
                    } else {
                        computeUInt64Size = CodedOutputStream.computeBytesSize(tagFieldNumber, (ByteString) this.f6544zn[i6]);
                    }
                } else {
                    computeUInt64Size = CodedOutputStream.computeFixed64Size(tagFieldNumber, ((Long) this.f6544zn[i6]).longValue());
                }
            } else {
                computeUInt64Size = CodedOutputStream.computeUInt64Size(tagFieldNumber, ((Long) this.f6544zn[i6]).longValue());
            }
            i5 += computeUInt64Size;
        }
        this.f6541gv = i5;
        return i5;
    }

    public int getSerializedSizeAsMessageSet() {
        int i = this.f6541gv;
        if (i != -1) {
            return i;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.y; i6++) {
            i5 += CodedOutputStream.computeRawMessageSetExtensionSize(WireFormat.getTagFieldNumber(this.f6542n3[i6]), (ByteString) this.f6544zn[i6]);
        }
        this.f6541gv = i5;
        return i5;
    }

    public int hashCode() {
        int i = this.y;
        return ((((527 + i) * 31) + zn(this.f6542n3, i)) * 31) + gv(this.f6544zn, this.y);
    }

    public void makeImmutable() {
        if (this.f6543v) {
            this.f6543v = false;
        }
    }

    public final void n3(int i) {
        int[] iArr = this.f6542n3;
        if (i > iArr.length) {
            int i5 = this.y;
            int i6 = i5 + (i5 / 2);
            if (i6 >= i) {
                i = i6;
            }
            if (i < 8) {
                i = 8;
            }
            this.f6542n3 = Arrays.copyOf(iArr, i);
            this.f6544zn = Arrays.copyOf(this.f6544zn, i);
        }
    }

    public UnknownFieldSetLite s(int i, ByteString byteString) {
        y();
        if (i != 0) {
            wz(WireFormat.y(i, 2), byteString);
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    public final void tl(StringBuilder sb, int i) {
        for (int i5 = 0; i5 < this.y; i5++) {
            MessageLiteToString.gv(sb, i, String.valueOf(WireFormat.getTagFieldNumber(this.f6542n3[i5])), this.f6544zn[i5]);
        }
    }

    public boolean v(int i, CodedInputStream codedInputStream) throws IOException {
        y();
        int tagFieldNumber = WireFormat.getTagFieldNumber(i);
        int tagWireType = WireFormat.getTagWireType(i);
        if (tagWireType != 0) {
            if (tagWireType != 1) {
                if (tagWireType != 2) {
                    if (tagWireType != 3) {
                        if (tagWireType != 4) {
                            if (tagWireType == 5) {
                                wz(i, Integer.valueOf(codedInputStream.readFixed32()));
                                return true;
                            }
                            throw InvalidProtocolBufferException.i9();
                        }
                        return false;
                    }
                    UnknownFieldSetLite unknownFieldSetLite = new UnknownFieldSetLite();
                    unknownFieldSetLite.a(codedInputStream);
                    codedInputStream.checkLastTagWas(WireFormat.y(tagFieldNumber, 4));
                    wz(i, unknownFieldSetLite);
                    return true;
                }
                wz(i, codedInputStream.readBytes());
                return true;
            }
            wz(i, Long.valueOf(codedInputStream.readFixed64()));
            return true;
        }
        wz(i, Long.valueOf(codedInputStream.readInt64()));
        return true;
    }

    public void w(Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            for (int i = this.y - 1; i >= 0; i--) {
                writer.writeMessageSetItem(WireFormat.getTagFieldNumber(this.f6542n3[i]), this.f6544zn[i]);
            }
            return;
        }
        for (int i5 = 0; i5 < this.y; i5++) {
            writer.writeMessageSetItem(WireFormat.getTagFieldNumber(this.f6542n3[i5]), this.f6544zn[i5]);
        }
    }

    public void writeAsMessageSetTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.y; i++) {
            codedOutputStream.writeRawMessageSetExtension(WireFormat.getTagFieldNumber(this.f6542n3[i]), (ByteString) this.f6544zn[i]);
        }
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.y; i++) {
            int i5 = this.f6542n3[i];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i5);
            int tagWireType = WireFormat.getTagWireType(i5);
            if (tagWireType == 0) {
                codedOutputStream.writeUInt64(tagFieldNumber, ((Long) this.f6544zn[i]).longValue());
            } else if (tagWireType == 1) {
                codedOutputStream.writeFixed64(tagFieldNumber, ((Long) this.f6544zn[i]).longValue());
            } else if (tagWireType == 2) {
                codedOutputStream.writeBytes(tagFieldNumber, (ByteString) this.f6544zn[i]);
            } else if (tagWireType == 3) {
                codedOutputStream.writeTag(tagFieldNumber, 3);
                ((UnknownFieldSetLite) this.f6544zn[i]).writeTo(codedOutputStream);
                codedOutputStream.writeTag(tagFieldNumber, 4);
            } else if (tagWireType == 5) {
                codedOutputStream.writeFixed32(tagFieldNumber, ((Integer) this.f6544zn[i]).intValue());
            } else {
                throw InvalidProtocolBufferException.i9();
            }
        }
    }

    public void wz(int i, Object obj) {
        y();
        n3(this.y + 1);
        int[] iArr = this.f6542n3;
        int i5 = this.y;
        iArr[i5] = i;
        this.f6544zn[i5] = obj;
        this.y = i5 + 1;
    }

    public void y() {
        if (this.f6543v) {
            return;
        }
        throw new UnsupportedOperationException();
    }

    public UnknownFieldSetLite(int i, int[] iArr, Object[] objArr, boolean z2) {
        this.f6541gv = -1;
        this.y = i;
        this.f6542n3 = iArr;
        this.f6544zn = objArr;
        this.f6543v = z2;
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.y == 0) {
            return;
        }
        if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
            for (int i = 0; i < this.y; i++) {
                p(this.f6542n3[i], this.f6544zn[i], writer);
            }
            return;
        }
        for (int i5 = this.y - 1; i5 >= 0; i5--) {
            p(this.f6542n3[i5], this.f6544zn[i5], writer);
        }
    }
}

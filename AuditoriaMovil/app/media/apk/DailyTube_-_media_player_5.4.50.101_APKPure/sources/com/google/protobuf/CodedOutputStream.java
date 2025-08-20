package com.google.protobuf;

import androidx.core.app.NotificationCompat;
import com.google.protobuf.Utf8;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public abstract class CodedOutputStream extends ByteOutput {
    @Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;

    /* renamed from: n3  reason: collision with root package name */
    public boolean f6369n3;
    public CodedOutputStreamWriter y;

    /* renamed from: zn  reason: collision with root package name */
    public static final Logger f6368zn = Logger.getLogger(CodedOutputStream.class.getName());

    /* renamed from: gv  reason: collision with root package name */
    public static final boolean f6367gv = UnsafeUtil.a8();

    /* loaded from: classes.dex */
    public static abstract class AbstractBufferedEncoder extends CodedOutputStream {

        /* renamed from: a  reason: collision with root package name */
        public final int f6370a;

        /* renamed from: fb  reason: collision with root package name */
        public int f6371fb;

        /* renamed from: s  reason: collision with root package name */
        public int f6372s;

        /* renamed from: v  reason: collision with root package name */
        public final byte[] f6373v;

        public AbstractBufferedEncoder(int i) {
            super();
            if (i >= 0) {
                byte[] bArr = new byte[Math.max(i, 20)];
                this.f6373v = bArr;
                this.f6370a = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        public final void co(int i, int i5) {
            z(WireFormat.y(i, i5));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.f6372s;
        }

        public final void mt(int i) {
            if (i >= 0) {
                z(i);
            } else {
                r(i);
            }
        }

        public final void p(long j2) {
            byte[] bArr = this.f6373v;
            int i = this.f6371fb;
            int i5 = i + 1;
            this.f6371fb = i5;
            bArr[i] = (byte) (j2 & 255);
            int i6 = i + 2;
            this.f6371fb = i6;
            bArr[i5] = (byte) ((j2 >> 8) & 255);
            int i8 = i + 3;
            this.f6371fb = i8;
            bArr[i6] = (byte) ((j2 >> 16) & 255);
            int i10 = i + 4;
            this.f6371fb = i10;
            bArr[i8] = (byte) (255 & (j2 >> 24));
            int i11 = i + 5;
            this.f6371fb = i11;
            bArr[i10] = (byte) (((int) (j2 >> 32)) & 255);
            int i12 = i + 6;
            this.f6371fb = i12;
            bArr[i11] = (byte) (((int) (j2 >> 40)) & 255);
            int i13 = i + 7;
            this.f6371fb = i13;
            bArr[i12] = (byte) (((int) (j2 >> 48)) & 255);
            this.f6371fb = i + 8;
            bArr[i13] = (byte) (((int) (j2 >> 56)) & 255);
            this.f6372s += 8;
        }

        public final void r(long j2) {
            if (CodedOutputStream.f6367gv) {
                long j4 = this.f6371fb;
                while ((j2 & (-128)) != 0) {
                    byte[] bArr = this.f6373v;
                    int i = this.f6371fb;
                    this.f6371fb = i + 1;
                    UnsafeUtil.qn(bArr, i, (byte) ((((int) j2) & 127) | NotificationCompat.FLAG_HIGH_PRIORITY));
                    j2 >>>= 7;
                }
                byte[] bArr2 = this.f6373v;
                int i5 = this.f6371fb;
                this.f6371fb = i5 + 1;
                UnsafeUtil.qn(bArr2, i5, (byte) j2);
                this.f6372s += (int) (this.f6371fb - j4);
                return;
            }
            while ((j2 & (-128)) != 0) {
                byte[] bArr3 = this.f6373v;
                int i6 = this.f6371fb;
                this.f6371fb = i6 + 1;
                bArr3[i6] = (byte) ((((int) j2) & 127) | NotificationCompat.FLAG_HIGH_PRIORITY);
                this.f6372s++;
                j2 >>>= 7;
            }
            byte[] bArr4 = this.f6373v;
            int i8 = this.f6371fb;
            this.f6371fb = i8 + 1;
            bArr4[i8] = (byte) j2;
            this.f6372s++;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int spaceLeft() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        public final void w(int i) {
            byte[] bArr = this.f6373v;
            int i5 = this.f6371fb;
            int i6 = i5 + 1;
            this.f6371fb = i6;
            bArr[i5] = (byte) (i & 255);
            int i8 = i5 + 2;
            this.f6371fb = i8;
            bArr[i6] = (byte) ((i >> 8) & 255);
            int i10 = i5 + 3;
            this.f6371fb = i10;
            bArr[i8] = (byte) ((i >> 16) & 255);
            this.f6371fb = i5 + 4;
            bArr[i10] = (byte) ((i >> 24) & 255);
            this.f6372s += 4;
        }

        public final void xc(byte b2) {
            byte[] bArr = this.f6373v;
            int i = this.f6371fb;
            this.f6371fb = i + 1;
            bArr[i] = b2;
            this.f6372s++;
        }

        public final void z(int i) {
            if (CodedOutputStream.f6367gv) {
                long j2 = this.f6371fb;
                while ((i & (-128)) != 0) {
                    byte[] bArr = this.f6373v;
                    int i5 = this.f6371fb;
                    this.f6371fb = i5 + 1;
                    UnsafeUtil.qn(bArr, i5, (byte) ((i & 127) | NotificationCompat.FLAG_HIGH_PRIORITY));
                    i >>>= 7;
                }
                byte[] bArr2 = this.f6373v;
                int i6 = this.f6371fb;
                this.f6371fb = i6 + 1;
                UnsafeUtil.qn(bArr2, i6, (byte) i);
                this.f6372s += (int) (this.f6371fb - j2);
                return;
            }
            while ((i & (-128)) != 0) {
                byte[] bArr3 = this.f6373v;
                int i8 = this.f6371fb;
                this.f6371fb = i8 + 1;
                bArr3[i8] = (byte) ((i & 127) | NotificationCompat.FLAG_HIGH_PRIORITY);
                this.f6372s++;
                i >>>= 7;
            }
            byte[] bArr4 = this.f6373v;
            int i10 = this.f6371fb;
            this.f6371fb = i10 + 1;
            bArr4[i10] = (byte) i;
            this.f6372s++;
        }
    }

    /* loaded from: classes.dex */
    public static class ArrayEncoder extends CodedOutputStream {

        /* renamed from: a  reason: collision with root package name */
        public final int f6374a;

        /* renamed from: fb  reason: collision with root package name */
        public final int f6375fb;

        /* renamed from: s  reason: collision with root package name */
        public int f6376s;

        /* renamed from: v  reason: collision with root package name */
        public final byte[] f6377v;

        public ArrayEncoder(byte[] bArr, int i, int i5) {
            super();
            if (bArr != null) {
                int i6 = i + i5;
                if ((i | i5 | (bArr.length - i6)) >= 0) {
                    this.f6377v = bArr;
                    this.f6374a = i;
                    this.f6376s = i;
                    this.f6375fb = i6;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i5)));
            }
            throw new NullPointerException("buffer");
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.f6376s - this.f6374a;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int spaceLeft() {
            return this.f6375fb - this.f6376s;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(byte b2) throws IOException {
            try {
                byte[] bArr = this.f6377v;
                int i = this.f6376s;
                this.f6376s = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f6376s), Integer.valueOf(this.f6375fb), 1), e2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBool(int i, boolean z2) throws IOException {
            writeTag(i, 0);
            write(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int i, byte[] bArr) throws IOException {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArrayNoTag(byte[] bArr, int i, int i5) throws IOException {
            writeUInt32NoTag(i5);
            write(bArr, i, i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteBuffer(int i, ByteBuffer byteBuffer) throws IOException {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytes(int i, ByteString byteString) throws IOException {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.k(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32(int i, int i5) throws IOException {
            writeTag(i, 5);
            writeFixed32NoTag(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int i) throws IOException {
            try {
                byte[] bArr = this.f6377v;
                int i5 = this.f6376s;
                int i6 = i5 + 1;
                this.f6376s = i6;
                bArr[i5] = (byte) (i & 255);
                int i8 = i5 + 2;
                this.f6376s = i8;
                bArr[i6] = (byte) ((i >> 8) & 255);
                int i10 = i5 + 3;
                this.f6376s = i10;
                bArr[i8] = (byte) ((i >> 16) & 255);
                this.f6376s = i5 + 4;
                bArr[i10] = (byte) ((i >> 24) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f6376s), Integer.valueOf(this.f6375fb), 1), e2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64(int i, long j2) throws IOException {
            writeTag(i, 1);
            writeFixed64NoTag(j2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long j2) throws IOException {
            try {
                byte[] bArr = this.f6377v;
                int i = this.f6376s;
                int i5 = i + 1;
                this.f6376s = i5;
                bArr[i] = (byte) (((int) j2) & 255);
                int i6 = i + 2;
                this.f6376s = i6;
                bArr[i5] = (byte) (((int) (j2 >> 8)) & 255);
                int i8 = i + 3;
                this.f6376s = i8;
                bArr[i6] = (byte) (((int) (j2 >> 16)) & 255);
                int i10 = i + 4;
                this.f6376s = i10;
                bArr[i8] = (byte) (((int) (j2 >> 24)) & 255);
                int i11 = i + 5;
                this.f6376s = i11;
                bArr[i10] = (byte) (((int) (j2 >> 32)) & 255);
                int i12 = i + 6;
                this.f6376s = i12;
                bArr[i11] = (byte) (((int) (j2 >> 40)) & 255);
                int i13 = i + 7;
                this.f6376s = i13;
                bArr[i12] = (byte) (((int) (j2 >> 48)) & 255);
                this.f6376s = i + 8;
                bArr[i13] = (byte) (((int) (j2 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f6376s), Integer.valueOf(this.f6375fb), 1), e2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32(int i, int i5) throws IOException {
            writeTag(i, 0);
            writeInt32NoTag(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int i) throws IOException {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag(i);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(byte[] bArr, int i, int i5) throws IOException {
            write(bArr, i, i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessage(int i, MessageLite messageLite) throws IOException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageSetExtension(int i, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.y(duplicate);
            write(duplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawMessageSetExtension(int i, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeString(int i, String str) throws IOException {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeStringNoTag(String str) throws IOException {
            int i = this.f6376s;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i5 = i + computeUInt32SizeNoTag2;
                    this.f6376s = i5;
                    int c52 = Utf8.c5(str, this.f6377v, i5, spaceLeft());
                    this.f6376s = i;
                    writeUInt32NoTag((c52 - i) - computeUInt32SizeNoTag2);
                    this.f6376s = c52;
                } else {
                    writeUInt32NoTag(Utf8.f(str));
                    this.f6376s = Utf8.c5(str, this.f6377v, this.f6376s, spaceLeft());
                }
            } catch (Utf8.UnpairedSurrogateException e2) {
                this.f6376s = i;
                s(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeTag(int i, int i5) throws IOException {
            writeUInt32NoTag(WireFormat.y(i, i5));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32(int i, int i5) throws IOException {
            writeTag(i, 0);
            writeUInt32NoTag(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int i) throws IOException {
            while ((i & (-128)) != 0) {
                try {
                    byte[] bArr = this.f6377v;
                    int i5 = this.f6376s;
                    this.f6376s = i5 + 1;
                    bArr[i5] = (byte) ((i & 127) | NotificationCompat.FLAG_HIGH_PRIORITY);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f6376s), Integer.valueOf(this.f6375fb), 1), e2);
                }
            }
            byte[] bArr2 = this.f6377v;
            int i6 = this.f6376s;
            this.f6376s = i6 + 1;
            bArr2[i6] = (byte) i;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64(int i, long j2) throws IOException {
            writeTag(i, 0);
            writeUInt64NoTag(j2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long j2) throws IOException {
            if (CodedOutputStream.f6367gv && spaceLeft() >= 10) {
                while ((j2 & (-128)) != 0) {
                    byte[] bArr = this.f6377v;
                    int i = this.f6376s;
                    this.f6376s = i + 1;
                    UnsafeUtil.qn(bArr, i, (byte) ((((int) j2) & 127) | NotificationCompat.FLAG_HIGH_PRIORITY));
                    j2 >>>= 7;
                }
                byte[] bArr2 = this.f6377v;
                int i5 = this.f6376s;
                this.f6376s = 1 + i5;
                UnsafeUtil.qn(bArr2, i5, (byte) j2);
                return;
            }
            while ((j2 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f6377v;
                    int i6 = this.f6376s;
                    this.f6376s = i6 + 1;
                    bArr3[i6] = (byte) ((((int) j2) & 127) | NotificationCompat.FLAG_HIGH_PRIORITY);
                    j2 >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f6376s), Integer.valueOf(this.f6375fb), 1), e2);
                }
            }
            byte[] bArr4 = this.f6377v;
            int i8 = this.f6376s;
            this.f6376s = i8 + 1;
            bArr4[i8] = (byte) j2;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void wz(int i, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i, 2);
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.y);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int i, byte[] bArr, int i5, int i6) throws IOException {
            writeTag(i, 2);
            writeByteArrayNoTag(bArr, i5, i6);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(byte[] bArr, int i, int i5) throws IOException {
            try {
                System.arraycopy(bArr, i, this.f6377v, this.f6376s, i5);
                this.f6376s += i5;
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f6376s), Integer.valueOf(this.f6375fb), Integer.valueOf(i5)), e2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.f6377v, this.f6376s, remaining);
                this.f6376s += remaining;
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f6376s), Integer.valueOf(this.f6375fb), Integer.valueOf(remaining)), e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class HeapNioEncoder extends ArrayEncoder {

        /* renamed from: c5  reason: collision with root package name */
        public final ByteBuffer f6378c5;

        /* renamed from: i9  reason: collision with root package name */
        public int f6379i9;

        public HeapNioEncoder(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.f6378c5 = byteBuffer;
            this.f6379i9 = byteBuffer.position();
        }

        @Override // com.google.protobuf.CodedOutputStream.ArrayEncoder, com.google.protobuf.CodedOutputStream
        public void flush() {
            Java8Compatibility.gv(this.f6378c5, this.f6379i9 + getTotalBytesWritten());
        }
    }

    /* loaded from: classes.dex */
    public static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        public OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        public OutOfSpaceException(String str) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str);
        }

        public OutOfSpaceException(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        public OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    /* loaded from: classes.dex */
    public static final class OutputStreamEncoder extends AbstractBufferedEncoder {

        /* renamed from: c5  reason: collision with root package name */
        public final OutputStream f6380c5;

        public OutputStreamEncoder(OutputStream outputStream, int i) {
            super(i);
            if (outputStream != null) {
                this.f6380c5 = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        private void i4(int i) throws IOException {
            if (this.f6370a - this.f6371fb < i) {
                x4();
            }
        }

        private void x4() throws IOException {
            this.f6380c5.write(this.f6373v, 0, this.f6371fb);
            this.f6371fb = 0;
        }

        public void f3(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.y);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() throws IOException {
            if (this.f6371fb > 0) {
                x4();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b2) throws IOException {
            if (this.f6371fb == this.f6370a) {
                x4();
            }
            xc(b2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i, boolean z2) throws IOException {
            i4(11);
            co(i, 0);
            xc(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr) throws IOException {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i, int i5) throws IOException {
            writeUInt32NoTag(i5);
            write(bArr, i, i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i, ByteBuffer byteBuffer) throws IOException {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i, ByteString byteString) throws IOException {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.k(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i, int i5) throws IOException {
            i4(14);
            co(i, 5);
            w(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i) throws IOException {
            i4(4);
            w(i);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i, long j2) throws IOException {
            i4(18);
            co(i, 1);
            p(j2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j2) throws IOException {
            i4(8);
            p(j2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i, int i5) throws IOException {
            i4(20);
            co(i, 0);
            mt(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i) throws IOException {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag(i);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i, int i5) throws IOException {
            write(bArr, i, i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite) throws IOException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.y(duplicate);
            write(duplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i, String str) throws IOException {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            int f4;
            try {
                int length = str.length() * 3;
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
                int i = computeUInt32SizeNoTag + length;
                int i5 = this.f6370a;
                if (i > i5) {
                    byte[] bArr = new byte[length];
                    int c52 = Utf8.c5(str, bArr, 0, length);
                    writeUInt32NoTag(c52);
                    writeLazy(bArr, 0, c52);
                    return;
                }
                if (i > i5 - this.f6371fb) {
                    x4();
                }
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                int i6 = this.f6371fb;
                try {
                    if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                        int i8 = i6 + computeUInt32SizeNoTag2;
                        this.f6371fb = i8;
                        int c53 = Utf8.c5(str, this.f6373v, i8, this.f6370a - i8);
                        this.f6371fb = i6;
                        f4 = (c53 - i6) - computeUInt32SizeNoTag2;
                        z(f4);
                        this.f6371fb = c53;
                    } else {
                        f4 = Utf8.f(str);
                        z(f4);
                        this.f6371fb = Utf8.c5(str, this.f6373v, this.f6371fb, f4);
                    }
                    this.f6372s += f4;
                } catch (Utf8.UnpairedSurrogateException e2) {
                    this.f6372s -= this.f6371fb - i6;
                    this.f6371fb = i6;
                    throw e2;
                } catch (ArrayIndexOutOfBoundsException e3) {
                    throw new OutOfSpaceException(e3);
                }
            } catch (Utf8.UnpairedSurrogateException e5) {
                s(str, e5);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i, int i5) throws IOException {
            writeUInt32NoTag(WireFormat.y(i, i5));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i, int i5) throws IOException {
            i4(20);
            co(i, 0);
            z(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i) throws IOException {
            i4(5);
            z(i);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i, long j2) throws IOException {
            i4(20);
            co(i, 0);
            r(j2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j2) throws IOException {
            i4(10);
            r(j2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void wz(int i, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i, 2);
            f3(messageLite, schema);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr, int i5, int i6) throws IOException {
            writeTag(i, 2);
            writeByteArrayNoTag(bArr, i5, i6);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i, int i5) throws IOException {
            int i6 = this.f6370a;
            int i8 = this.f6371fb;
            if (i6 - i8 >= i5) {
                System.arraycopy(bArr, i, this.f6373v, i8, i5);
                this.f6371fb += i5;
                this.f6372s += i5;
                return;
            }
            int i10 = i6 - i8;
            System.arraycopy(bArr, i, this.f6373v, i8, i10);
            int i11 = i + i10;
            int i12 = i5 - i10;
            this.f6371fb = this.f6370a;
            this.f6372s += i10;
            x4();
            if (i12 <= this.f6370a) {
                System.arraycopy(bArr, i11, this.f6373v, 0, i12);
                this.f6371fb = i12;
            } else {
                this.f6380c5.write(bArr, i11, i12);
            }
            this.f6372s += i12;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            int i = this.f6370a;
            int i5 = this.f6371fb;
            if (i - i5 >= remaining) {
                byteBuffer.get(this.f6373v, i5, remaining);
                this.f6371fb += remaining;
                this.f6372s += remaining;
                return;
            }
            int i6 = i - i5;
            byteBuffer.get(this.f6373v, i5, i6);
            int i8 = remaining - i6;
            this.f6371fb = this.f6370a;
            this.f6372s += i6;
            x4();
            while (true) {
                int i10 = this.f6370a;
                if (i8 > i10) {
                    byteBuffer.get(this.f6373v, 0, i10);
                    this.f6380c5.write(this.f6373v, 0, this.f6370a);
                    int i11 = this.f6370a;
                    i8 -= i11;
                    this.f6372s += i11;
                } else {
                    byteBuffer.get(this.f6373v, 0, i8);
                    this.f6371fb = i8;
                    this.f6372s += i8;
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class SafeDirectNioEncoder extends CodedOutputStream {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f6381a;

        /* renamed from: fb  reason: collision with root package name */
        public final int f6382fb;

        /* renamed from: v  reason: collision with root package name */
        public final ByteBuffer f6383v;

        public SafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.f6383v = byteBuffer;
            this.f6381a = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f6382fb = byteBuffer.position();
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
            Java8Compatibility.gv(this.f6383v, this.f6381a.position());
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return this.f6381a.position() - this.f6382fb;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int spaceLeft() {
            return this.f6381a.remaining();
        }

        public void w(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.y);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b2) throws IOException {
            try {
                this.f6381a.put(b2);
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException(e2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i, boolean z2) throws IOException {
            writeTag(i, 0);
            write(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr) throws IOException {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i, int i5) throws IOException {
            writeUInt32NoTag(i5);
            write(bArr, i, i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i, ByteBuffer byteBuffer) throws IOException {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i, ByteString byteString) throws IOException {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.k(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i, int i5) throws IOException {
            writeTag(i, 5);
            writeFixed32NoTag(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i) throws IOException {
            try {
                this.f6381a.putInt(i);
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException(e2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i, long j2) throws IOException {
            writeTag(i, 1);
            writeFixed64NoTag(j2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j2) throws IOException {
            try {
                this.f6381a.putLong(j2);
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException(e2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i, int i5) throws IOException {
            writeTag(i, 0);
            writeInt32NoTag(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i) throws IOException {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag(i);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i, int i5) throws IOException {
            write(bArr, i, i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite) throws IOException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.y(duplicate);
            write(duplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i, String str) throws IOException {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            int position = this.f6381a.position();
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int position2 = this.f6381a.position() + computeUInt32SizeNoTag2;
                    Java8Compatibility.gv(this.f6381a, position2);
                    xc(str);
                    int position3 = this.f6381a.position();
                    Java8Compatibility.gv(this.f6381a, position);
                    writeUInt32NoTag(position3 - position2);
                    Java8Compatibility.gv(this.f6381a, position3);
                } else {
                    writeUInt32NoTag(Utf8.f(str));
                    xc(str);
                }
            } catch (Utf8.UnpairedSurrogateException e2) {
                Java8Compatibility.gv(this.f6381a, position);
                s(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i, int i5) throws IOException {
            writeUInt32NoTag(WireFormat.y(i, i5));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i, int i5) throws IOException {
            writeTag(i, 0);
            writeUInt32NoTag(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i) throws IOException {
            while ((i & (-128)) != 0) {
                try {
                    this.f6381a.put((byte) ((i & 127) | NotificationCompat.FLAG_HIGH_PRIORITY));
                    i >>>= 7;
                } catch (BufferOverflowException e2) {
                    throw new OutOfSpaceException(e2);
                }
            }
            this.f6381a.put((byte) i);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i, long j2) throws IOException {
            writeTag(i, 0);
            writeUInt64NoTag(j2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j2) throws IOException {
            while (((-128) & j2) != 0) {
                try {
                    this.f6381a.put((byte) ((((int) j2) & 127) | NotificationCompat.FLAG_HIGH_PRIORITY));
                    j2 >>>= 7;
                } catch (BufferOverflowException e2) {
                    throw new OutOfSpaceException(e2);
                }
            }
            this.f6381a.put((byte) j2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void wz(int i, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i, 2);
            w(messageLite, schema);
        }

        public final void xc(String str) throws IOException {
            try {
                Utf8.i9(str, this.f6381a);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(e2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr, int i5, int i6) throws IOException {
            writeTag(i, 2);
            writeByteArrayNoTag(bArr, i5, i6);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i, int i5) throws IOException {
            try {
                this.f6381a.put(bArr, i, i5);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(e2);
            } catch (BufferOverflowException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            try {
                this.f6381a.put(byteBuffer);
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException(e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class UnsafeDirectNioEncoder extends CodedOutputStream {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f6384a;

        /* renamed from: c5  reason: collision with root package name */
        public final long f6385c5;

        /* renamed from: f  reason: collision with root package name */
        public long f6386f;

        /* renamed from: fb  reason: collision with root package name */
        public final long f6387fb;

        /* renamed from: i9  reason: collision with root package name */
        public final long f6388i9;

        /* renamed from: s  reason: collision with root package name */
        public final long f6389s;

        /* renamed from: v  reason: collision with root package name */
        public final ByteBuffer f6390v;

        public UnsafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.f6390v = byteBuffer;
            this.f6384a = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long f4 = UnsafeUtil.f(byteBuffer);
            this.f6387fb = f4;
            long position = byteBuffer.position() + f4;
            this.f6389s = position;
            long limit = f4 + byteBuffer.limit();
            this.f6385c5 = limit;
            this.f6388i9 = limit - 10;
            this.f6386f = position;
        }

        public static boolean w() {
            return UnsafeUtil.x();
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
            Java8Compatibility.gv(this.f6390v, xc(this.f6386f));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return (int) (this.f6386f - this.f6389s);
        }

        public void mt(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.y);
        }

        public final void p(long j2) {
            Java8Compatibility.gv(this.f6384a, xc(j2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int spaceLeft() {
            return (int) (this.f6385c5 - this.f6386f);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b2) throws IOException {
            long j2 = this.f6386f;
            if (j2 < this.f6385c5) {
                this.f6386f = 1 + j2;
                UnsafeUtil.j5(j2, b2);
                return;
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f6386f), Long.valueOf(this.f6385c5), 1));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i, boolean z2) throws IOException {
            writeTag(i, 0);
            write(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr) throws IOException {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i, int i5) throws IOException {
            writeUInt32NoTag(i5);
            write(bArr, i, i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i, ByteBuffer byteBuffer) throws IOException {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i, ByteString byteString) throws IOException {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.k(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i, int i5) throws IOException {
            writeTag(i, 5);
            writeFixed32NoTag(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i) throws IOException {
            this.f6384a.putInt(xc(this.f6386f), i);
            this.f6386f += 4;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i, long j2) throws IOException {
            writeTag(i, 1);
            writeFixed64NoTag(j2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j2) throws IOException {
            this.f6384a.putLong(xc(this.f6386f), j2);
            this.f6386f += 8;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i, int i5) throws IOException {
            writeTag(i, 0);
            writeInt32NoTag(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i) throws IOException {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag(i);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i, int i5) throws IOException {
            write(bArr, i, i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite) throws IOException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.y(duplicate);
            write(duplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i, String str) throws IOException {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            long j2 = this.f6386f;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int xc2 = xc(this.f6386f) + computeUInt32SizeNoTag2;
                    Java8Compatibility.gv(this.f6384a, xc2);
                    Utf8.i9(str, this.f6384a);
                    int position = this.f6384a.position() - xc2;
                    writeUInt32NoTag(position);
                    this.f6386f += position;
                } else {
                    int f4 = Utf8.f(str);
                    writeUInt32NoTag(f4);
                    p(this.f6386f);
                    Utf8.i9(str, this.f6384a);
                    this.f6386f += f4;
                }
            } catch (Utf8.UnpairedSurrogateException e2) {
                this.f6386f = j2;
                p(j2);
                s(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new OutOfSpaceException(e3);
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(e5);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i, int i5) throws IOException {
            writeUInt32NoTag(WireFormat.y(i, i5));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i, int i5) throws IOException {
            writeTag(i, 0);
            writeUInt32NoTag(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i) throws IOException {
            if (this.f6386f <= this.f6388i9) {
                while ((i & (-128)) != 0) {
                    long j2 = this.f6386f;
                    this.f6386f = j2 + 1;
                    UnsafeUtil.j5(j2, (byte) ((i & 127) | NotificationCompat.FLAG_HIGH_PRIORITY));
                    i >>>= 7;
                }
                long j4 = this.f6386f;
                this.f6386f = 1 + j4;
                UnsafeUtil.j5(j4, (byte) i);
                return;
            }
            while (true) {
                long j6 = this.f6386f;
                if (j6 < this.f6385c5) {
                    if ((i & (-128)) == 0) {
                        this.f6386f = 1 + j6;
                        UnsafeUtil.j5(j6, (byte) i);
                        return;
                    }
                    this.f6386f = j6 + 1;
                    UnsafeUtil.j5(j6, (byte) ((i & 127) | NotificationCompat.FLAG_HIGH_PRIORITY));
                    i >>>= 7;
                } else {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f6386f), Long.valueOf(this.f6385c5), 1));
                }
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i, long j2) throws IOException {
            writeTag(i, 0);
            writeUInt64NoTag(j2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j2) throws IOException {
            if (this.f6386f <= this.f6388i9) {
                while ((j2 & (-128)) != 0) {
                    long j4 = this.f6386f;
                    this.f6386f = j4 + 1;
                    UnsafeUtil.j5(j4, (byte) ((((int) j2) & 127) | NotificationCompat.FLAG_HIGH_PRIORITY));
                    j2 >>>= 7;
                }
                long j6 = this.f6386f;
                this.f6386f = 1 + j6;
                UnsafeUtil.j5(j6, (byte) j2);
                return;
            }
            while (true) {
                long j7 = this.f6386f;
                if (j7 < this.f6385c5) {
                    if ((j2 & (-128)) == 0) {
                        this.f6386f = 1 + j7;
                        UnsafeUtil.j5(j7, (byte) j2);
                        return;
                    }
                    this.f6386f = j7 + 1;
                    UnsafeUtil.j5(j7, (byte) ((((int) j2) & 127) | NotificationCompat.FLAG_HIGH_PRIORITY));
                    j2 >>>= 7;
                } else {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f6386f), Long.valueOf(this.f6385c5), 1));
                }
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void wz(int i, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i, 2);
            mt(messageLite, schema);
        }

        public final int xc(long j2) {
            return (int) (j2 - this.f6387fb);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr, int i5, int i6) throws IOException {
            writeTag(i, 2);
            writeByteArrayNoTag(bArr, i5, i6);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i, int i5) throws IOException {
            if (bArr != null && i >= 0 && i5 >= 0 && bArr.length - i5 >= i) {
                long j2 = i5;
                long j4 = this.f6386f;
                if (this.f6385c5 - j2 >= j4) {
                    UnsafeUtil.p(bArr, i, j4, j2);
                    this.f6386f += j2;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f6386f), Long.valueOf(this.f6385c5), Integer.valueOf(i5)));
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            try {
                int remaining = byteBuffer.remaining();
                p(this.f6386f);
                this.f6384a.put(byteBuffer);
                this.f6386f += remaining;
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException(e2);
            }
        }
    }

    public static int a(MessageLite messageLite, Schema schema) {
        return gv(((AbstractMessageLite) messageLite).getSerializedSize(schema));
    }

    public static int computeBoolSize(int i, boolean z2) {
        return computeTagSize(i) + computeBoolSizeNoTag(z2);
    }

    public static int computeBoolSizeNoTag(boolean z2) {
        return 1;
    }

    public static int computeByteArraySize(int i, byte[] bArr) {
        return computeTagSize(i) + computeByteArraySizeNoTag(bArr);
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return gv(bArr.length);
    }

    public static int computeByteBufferSize(int i, ByteBuffer byteBuffer) {
        return computeTagSize(i) + computeByteBufferSizeNoTag(byteBuffer);
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer byteBuffer) {
        return gv(byteBuffer.capacity());
    }

    public static int computeBytesSize(int i, ByteString byteString) {
        return computeTagSize(i) + computeBytesSizeNoTag(byteString);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return gv(byteString.size());
    }

    public static int computeDoubleSize(int i, double d2) {
        return computeTagSize(i) + computeDoubleSizeNoTag(d2);
    }

    public static int computeDoubleSizeNoTag(double d2) {
        return 8;
    }

    public static int computeEnumSize(int i, int i5) {
        return computeTagSize(i) + computeEnumSizeNoTag(i5);
    }

    public static int computeEnumSizeNoTag(int i) {
        return computeInt32SizeNoTag(i);
    }

    public static int computeFixed32Size(int i, int i5) {
        return computeTagSize(i) + computeFixed32SizeNoTag(i5);
    }

    public static int computeFixed32SizeNoTag(int i) {
        return 4;
    }

    public static int computeFixed64Size(int i, long j2) {
        return computeTagSize(i) + computeFixed64SizeNoTag(j2);
    }

    public static int computeFixed64SizeNoTag(long j2) {
        return 8;
    }

    public static int computeFloatSize(int i, float f4) {
        return computeTagSize(i) + computeFloatSizeNoTag(f4);
    }

    public static int computeFloatSizeNoTag(float f4) {
        return 4;
    }

    @Deprecated
    public static int computeGroupSize(int i, MessageLite messageLite) {
        return (computeTagSize(i) * 2) + messageLite.getSerializedSize();
    }

    @InlineMe(replacement = "value.getSerializedSize()")
    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int computeInt32Size(int i, int i5) {
        return computeTagSize(i) + computeInt32SizeNoTag(i5);
    }

    public static int computeInt32SizeNoTag(int i) {
        if (i >= 0) {
            return computeUInt32SizeNoTag(i);
        }
        return 10;
    }

    public static int computeInt64Size(int i, long j2) {
        return computeTagSize(i) + computeInt64SizeNoTag(j2);
    }

    public static int computeInt64SizeNoTag(long j2) {
        return computeUInt64SizeNoTag(j2);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int i, LazyFieldLite lazyFieldLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i) + computeLazyFieldSize(3, lazyFieldLite);
    }

    public static int computeLazyFieldSize(int i, LazyFieldLite lazyFieldLite) {
        return computeTagSize(i) + computeLazyFieldSizeNoTag(lazyFieldLite);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        return gv(lazyFieldLite.getSerializedSize());
    }

    public static int computeMessageSetExtensionSize(int i, MessageLite messageLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i) + computeMessageSize(3, messageLite);
    }

    public static int computeMessageSize(int i, MessageLite messageLite) {
        return computeTagSize(i) + computeMessageSizeNoTag(messageLite);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        return gv(messageLite.getSerializedSize());
    }

    public static int computeRawMessageSetExtensionSize(int i, ByteString byteString) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i) + computeBytesSize(3, byteString);
    }

    @InlineMe(imports = {"com.google.protobuf.CodedOutputStream"}, replacement = "CodedOutputStream.computeUInt32SizeNoTag(value)")
    @Deprecated
    public static int computeRawVarint32Size(int i) {
        return computeUInt32SizeNoTag(i);
    }

    @InlineMe(imports = {"com.google.protobuf.CodedOutputStream"}, replacement = "CodedOutputStream.computeUInt64SizeNoTag(value)")
    @Deprecated
    public static int computeRawVarint64Size(long j2) {
        return computeUInt64SizeNoTag(j2);
    }

    public static int computeSFixed32Size(int i, int i5) {
        return computeTagSize(i) + computeSFixed32SizeNoTag(i5);
    }

    public static int computeSFixed32SizeNoTag(int i) {
        return 4;
    }

    public static int computeSFixed64Size(int i, long j2) {
        return computeTagSize(i) + computeSFixed64SizeNoTag(j2);
    }

    public static int computeSFixed64SizeNoTag(long j2) {
        return 8;
    }

    public static int computeSInt32Size(int i, int i5) {
        return computeTagSize(i) + computeSInt32SizeNoTag(i5);
    }

    public static int computeSInt32SizeNoTag(int i) {
        return computeUInt32SizeNoTag(encodeZigZag32(i));
    }

    public static int computeSInt64Size(int i, long j2) {
        return computeTagSize(i) + computeSInt64SizeNoTag(j2);
    }

    public static int computeSInt64SizeNoTag(long j2) {
        return computeUInt64SizeNoTag(encodeZigZag64(j2));
    }

    public static int computeStringSize(int i, String str) {
        return computeTagSize(i) + computeStringSizeNoTag(str);
    }

    public static int computeStringSizeNoTag(String str) {
        int length;
        try {
            length = Utf8.f(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(Internal.f6450n3).length;
        }
        return gv(length);
    }

    public static int computeTagSize(int i) {
        return computeUInt32SizeNoTag(WireFormat.y(i, 0));
    }

    public static int computeUInt32Size(int i, int i5) {
        return computeTagSize(i) + computeUInt32SizeNoTag(i5);
    }

    public static int computeUInt32SizeNoTag(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int computeUInt64Size(int i, long j2) {
        return computeTagSize(i) + computeUInt64SizeNoTag(j2);
    }

    public static int computeUInt64SizeNoTag(long j2) {
        int i;
        if (((-128) & j2) == 0) {
            return 1;
        }
        if (j2 < 0) {
            return 10;
        }
        if (((-34359738368L) & j2) != 0) {
            j2 >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j2) != 0) {
            i += 2;
            j2 >>>= 14;
        }
        return (j2 & (-16384)) != 0 ? i + 1 : i;
    }

    public static int encodeZigZag32(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static long encodeZigZag64(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    public static CodedOutputStream f(ByteBuffer byteBuffer) {
        return new UnsafeDirectNioEncoder(byteBuffer);
    }

    public static int fb(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int gv(int i) {
        return computeUInt32SizeNoTag(i) + i;
    }

    public static CodedOutputStream i9(ByteBuffer byteBuffer) {
        return new SafeDirectNioEncoder(byteBuffer);
    }

    @Deprecated
    public static int n3(int i, MessageLite messageLite, Schema schema) {
        return (computeTagSize(i) * 2) + zn(messageLite, schema);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream) {
        return newInstance(outputStream, 4096);
    }

    public static int v(int i, MessageLite messageLite, Schema schema) {
        return computeTagSize(i) + a(messageLite, schema);
    }

    @Deprecated
    public static int zn(MessageLite messageLite, Schema schema) {
        return ((AbstractMessageLite) messageLite).getSerializedSize(schema);
    }

    public boolean c5() {
        return this.f6369n3;
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() == 0) {
            return;
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public abstract void flush() throws IOException;

    public abstract int getTotalBytesWritten();

    public final void s(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        f6368zn.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.f6450n3);
        try {
            writeUInt32NoTag(bytes.length);
            writeLazy(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e2) {
            throw new OutOfSpaceException(e2);
        }
    }

    public abstract int spaceLeft();

    @Deprecated
    public final void t(int i, MessageLite messageLite, Schema schema) throws IOException {
        writeTag(i, 3);
        tl(messageLite, schema);
        writeTag(i, 4);
    }

    @Deprecated
    public final void tl(MessageLite messageLite, Schema schema) throws IOException {
        schema.writeTo(messageLite, this.y);
    }

    public void useDeterministicSerialization() {
        this.f6369n3 = true;
    }

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte b2) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(ByteBuffer byteBuffer) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte[] bArr, int i, int i5) throws IOException;

    public abstract void writeBool(int i, boolean z2) throws IOException;

    public final void writeBoolNoTag(boolean z2) throws IOException {
        write(z2 ? (byte) 1 : (byte) 0);
    }

    public abstract void writeByteArray(int i, byte[] bArr) throws IOException;

    public abstract void writeByteArray(int i, byte[] bArr, int i5, int i6) throws IOException;

    public final void writeByteArrayNoTag(byte[] bArr) throws IOException {
        writeByteArrayNoTag(bArr, 0, bArr.length);
    }

    public abstract void writeByteArrayNoTag(byte[] bArr, int i, int i5) throws IOException;

    public abstract void writeByteBuffer(int i, ByteBuffer byteBuffer) throws IOException;

    public abstract void writeBytes(int i, ByteString byteString) throws IOException;

    public abstract void writeBytesNoTag(ByteString byteString) throws IOException;

    public final void writeDouble(int i, double d2) throws IOException {
        writeFixed64(i, Double.doubleToRawLongBits(d2));
    }

    public final void writeDoubleNoTag(double d2) throws IOException {
        writeFixed64NoTag(Double.doubleToRawLongBits(d2));
    }

    public final void writeEnum(int i, int i5) throws IOException {
        writeInt32(i, i5);
    }

    public final void writeEnumNoTag(int i) throws IOException {
        writeInt32NoTag(i);
    }

    public abstract void writeFixed32(int i, int i5) throws IOException;

    public abstract void writeFixed32NoTag(int i) throws IOException;

    public abstract void writeFixed64(int i, long j2) throws IOException;

    public abstract void writeFixed64NoTag(long j2) throws IOException;

    public final void writeFloat(int i, float f4) throws IOException {
        writeFixed32(i, Float.floatToRawIntBits(f4));
    }

    public final void writeFloatNoTag(float f4) throws IOException {
        writeFixed32NoTag(Float.floatToRawIntBits(f4));
    }

    @Deprecated
    public final void writeGroup(int i, MessageLite messageLite) throws IOException {
        writeTag(i, 3);
        writeGroupNoTag(messageLite);
        writeTag(i, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite) throws IOException {
        messageLite.writeTo(this);
    }

    public abstract void writeInt32(int i, int i5) throws IOException;

    public abstract void writeInt32NoTag(int i) throws IOException;

    public final void writeInt64(int i, long j2) throws IOException {
        writeUInt64(i, j2);
    }

    public final void writeInt64NoTag(long j2) throws IOException {
        writeUInt64NoTag(j2);
    }

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(ByteBuffer byteBuffer) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(byte[] bArr, int i, int i5) throws IOException;

    public abstract void writeMessage(int i, MessageLite messageLite) throws IOException;

    public abstract void writeMessageNoTag(MessageLite messageLite) throws IOException;

    public abstract void writeMessageSetExtension(int i, MessageLite messageLite) throws IOException;

    public final void writeRawByte(byte b2) throws IOException {
        write(b2);
    }

    public abstract void writeRawBytes(ByteBuffer byteBuffer) throws IOException;

    public final void writeRawBytes(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @InlineMe(replacement = "this.writeFixed32NoTag(value)")
    @Deprecated
    public final void writeRawLittleEndian32(int i) throws IOException {
        writeFixed32NoTag(i);
    }

    @InlineMe(replacement = "this.writeFixed64NoTag(value)")
    @Deprecated
    public final void writeRawLittleEndian64(long j2) throws IOException {
        writeFixed64NoTag(j2);
    }

    public abstract void writeRawMessageSetExtension(int i, ByteString byteString) throws IOException;

    @InlineMe(replacement = "this.writeUInt32NoTag(value)")
    @Deprecated
    public final void writeRawVarint32(int i) throws IOException {
        writeUInt32NoTag(i);
    }

    @InlineMe(replacement = "this.writeUInt64NoTag(value)")
    @Deprecated
    public final void writeRawVarint64(long j2) throws IOException {
        writeUInt64NoTag(j2);
    }

    public final void writeSFixed32(int i, int i5) throws IOException {
        writeFixed32(i, i5);
    }

    public final void writeSFixed32NoTag(int i) throws IOException {
        writeFixed32NoTag(i);
    }

    public final void writeSFixed64(int i, long j2) throws IOException {
        writeFixed64(i, j2);
    }

    public final void writeSFixed64NoTag(long j2) throws IOException {
        writeFixed64NoTag(j2);
    }

    public final void writeSInt32(int i, int i5) throws IOException {
        writeUInt32(i, encodeZigZag32(i5));
    }

    public final void writeSInt32NoTag(int i) throws IOException {
        writeUInt32NoTag(encodeZigZag32(i));
    }

    public final void writeSInt64(int i, long j2) throws IOException {
        writeUInt64(i, encodeZigZag64(j2));
    }

    public final void writeSInt64NoTag(long j2) throws IOException {
        writeUInt64NoTag(encodeZigZag64(j2));
    }

    public abstract void writeString(int i, String str) throws IOException;

    public abstract void writeStringNoTag(String str) throws IOException;

    public abstract void writeTag(int i, int i5) throws IOException;

    public abstract void writeUInt32(int i, int i5) throws IOException;

    public abstract void writeUInt32NoTag(int i) throws IOException;

    public abstract void writeUInt64(int i, long j2) throws IOException;

    public abstract void writeUInt64NoTag(long j2) throws IOException;

    public abstract void wz(int i, MessageLite messageLite, Schema schema) throws IOException;

    public CodedOutputStream() {
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i) {
        return new OutputStreamEncoder(outputStream, i);
    }

    public final void writeRawByte(int i) throws IOException {
        write((byte) i);
    }

    public final void writeRawBytes(byte[] bArr, int i, int i5) throws IOException {
        write(bArr, i, i5);
    }

    public static CodedOutputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public final void writeRawBytes(ByteString byteString) throws IOException {
        byteString.k(this);
    }

    public static CodedOutputStream newInstance(byte[] bArr, int i, int i5) {
        return new ArrayEncoder(bArr, i, i5);
    }

    public static CodedOutputStream newInstance(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new HeapNioEncoder(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            if (UnsafeDirectNioEncoder.w()) {
                return f(byteBuffer);
            }
            return i9(byteBuffer);
        }
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    @Deprecated
    public static CodedOutputStream newInstance(ByteBuffer byteBuffer, int i) {
        return newInstance(byteBuffer);
    }
}

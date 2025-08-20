package com.google.protobuf;

import androidx.core.app.NotificationCompat;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class CodedInputStream {

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f6316a = 100;

    /* renamed from: gv  reason: collision with root package name */
    public CodedInputStreamReader f6317gv;

    /* renamed from: n3  reason: collision with root package name */
    public int f6318n3;

    /* renamed from: v  reason: collision with root package name */
    public boolean f6319v;
    public int y;

    /* renamed from: zn  reason: collision with root package name */
    public int f6320zn;

    /* loaded from: classes.dex */
    public static final class ArrayDecoder extends CodedInputStream {

        /* renamed from: c5  reason: collision with root package name */
        public int f6321c5;

        /* renamed from: f  reason: collision with root package name */
        public int f6322f;

        /* renamed from: fb  reason: collision with root package name */
        public final byte[] f6323fb;

        /* renamed from: i9  reason: collision with root package name */
        public int f6324i9;

        /* renamed from: s  reason: collision with root package name */
        public final boolean f6325s;

        /* renamed from: t  reason: collision with root package name */
        public int f6326t;

        /* renamed from: tl  reason: collision with root package name */
        public int f6327tl;

        /* renamed from: wz  reason: collision with root package name */
        public boolean f6328wz;

        /* renamed from: xc  reason: collision with root package name */
        public int f6329xc;

        public final void a() {
            int i = this.f6321c5 + this.f6324i9;
            this.f6321c5 = i;
            int i5 = i - this.f6326t;
            int i6 = this.f6329xc;
            if (i5 > i6) {
                int i8 = i5 - i6;
                this.f6324i9 = i8;
                this.f6321c5 = i - i8;
                return;
            }
            this.f6324i9 = 0;
        }

        public final void c5() throws IOException {
            for (int i = 0; i < 10; i++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.t();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int i) throws InvalidProtocolBufferException {
            if (this.f6327tl == i) {
                return;
            }
            throw InvalidProtocolBufferException.gv();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean z2) {
            this.f6328wz = z2;
        }

        public final void fb() throws IOException {
            if (this.f6321c5 - this.f6322f >= 10) {
                s();
            } else {
                c5();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i = this.f6329xc;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - getTotalBytesRead();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.f6327tl;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.f6322f - this.f6326t;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            if (this.f6322f == this.f6321c5) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int i) {
            this.f6329xc = i;
            a();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int i) throws InvalidProtocolBufferException {
            if (i >= 0) {
                int totalBytesRead = i + getTotalBytesRead();
                if (totalBytesRead >= 0) {
                    int i5 = this.f6329xc;
                    if (totalBytesRead <= i5) {
                        this.f6329xc = totalBytesRead;
                        a();
                        return i5;
                    }
                    throw InvalidProtocolBufferException.ta();
                }
                throw InvalidProtocolBufferException.mt();
            }
            throw InvalidProtocolBufferException.p();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            if (readRawVarint64() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            ByteBuffer wrap;
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i = this.f6321c5;
                int i5 = this.f6322f;
                if (readRawVarint32 <= i - i5) {
                    if (!this.f6325s && this.f6328wz) {
                        wrap = ByteBuffer.wrap(this.f6323fb, i5, readRawVarint32).slice();
                    } else {
                        wrap = ByteBuffer.wrap(Arrays.copyOfRange(this.f6323fb, i5, i5 + readRawVarint32));
                    }
                    this.f6322f += readRawVarint32;
                    return wrap;
                }
            }
            if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.p();
            }
            throw InvalidProtocolBufferException.ta();
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            ByteString copyFrom;
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i = this.f6321c5;
                int i5 = this.f6322f;
                if (readRawVarint32 <= i - i5) {
                    if (this.f6325s && this.f6328wz) {
                        copyFrom = ByteString.j(this.f6323fb, i5, readRawVarint32);
                    } else {
                        copyFrom = ByteString.copyFrom(this.f6323fb, i5, readRawVarint32);
                    }
                    this.f6322f += readRawVarint32;
                    return copyFrom;
                }
            }
            if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            }
            return ByteString.o(readRawBytes(readRawVarint32));
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.y++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.y(i, 4));
            this.y--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.y++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.y--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.ta();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            int i = this.f6322f;
            if (i != this.f6321c5) {
                byte[] bArr = this.f6323fb;
                this.f6322f = i + 1;
                return bArr[i];
            }
            throw InvalidProtocolBufferException.ta();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int i) throws IOException {
            if (i > 0) {
                int i5 = this.f6321c5;
                int i6 = this.f6322f;
                if (i <= i5 - i6) {
                    int i8 = i + i6;
                    this.f6322f = i8;
                    return Arrays.copyOfRange(this.f6323fb, i6, i8);
                }
            }
            if (i <= 0) {
                if (i == 0) {
                    return Internal.EMPTY_BYTE_ARRAY;
                }
                throw InvalidProtocolBufferException.p();
            }
            throw InvalidProtocolBufferException.ta();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            int i = this.f6322f;
            if (this.f6321c5 - i >= 4) {
                byte[] bArr = this.f6323fb;
                this.f6322f = i + 4;
                return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
            }
            throw InvalidProtocolBufferException.ta();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            int i = this.f6322f;
            if (this.f6321c5 - i >= 8) {
                byte[] bArr = this.f6323fb;
                this.f6322f = i + 8;
                return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
            }
            throw InvalidProtocolBufferException.ta();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawVarint32() throws IOException {
            int i;
            int i5 = this.f6322f;
            int i6 = this.f6321c5;
            if (i6 != i5) {
                byte[] bArr = this.f6323fb;
                int i8 = i5 + 1;
                byte b2 = bArr[i5];
                if (b2 >= 0) {
                    this.f6322f = i8;
                    return b2;
                } else if (i6 - i8 >= 9) {
                    int i10 = i5 + 2;
                    int i11 = (bArr[i8] << 7) ^ b2;
                    if (i11 < 0) {
                        i = i11 ^ (-128);
                    } else {
                        int i12 = i5 + 3;
                        int i13 = (bArr[i10] << 14) ^ i11;
                        if (i13 >= 0) {
                            i = i13 ^ 16256;
                        } else {
                            int i14 = i5 + 4;
                            int i15 = i13 ^ (bArr[i12] << 21);
                            if (i15 < 0) {
                                i = (-2080896) ^ i15;
                            } else {
                                i12 = i5 + 5;
                                byte b3 = bArr[i14];
                                int i16 = (i15 ^ (b3 << 28)) ^ 266354560;
                                if (b3 < 0) {
                                    i14 = i5 + 6;
                                    if (bArr[i12] < 0) {
                                        i12 = i5 + 7;
                                        if (bArr[i14] < 0) {
                                            i14 = i5 + 8;
                                            if (bArr[i12] < 0) {
                                                i12 = i5 + 9;
                                                if (bArr[i14] < 0) {
                                                    int i17 = i5 + 10;
                                                    if (bArr[i12] >= 0) {
                                                        i10 = i17;
                                                        i = i16;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i = i16;
                                }
                                i = i16;
                            }
                            i10 = i14;
                        }
                        i10 = i12;
                    }
                    this.f6322f = i10;
                    return i;
                }
            }
            return (int) v();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            long j2;
            long j4;
            long j6;
            int i = this.f6322f;
            int i5 = this.f6321c5;
            if (i5 != i) {
                byte[] bArr = this.f6323fb;
                int i6 = i + 1;
                byte b2 = bArr[i];
                if (b2 >= 0) {
                    this.f6322f = i6;
                    return b2;
                } else if (i5 - i6 >= 9) {
                    int i8 = i + 2;
                    int i10 = (bArr[i6] << 7) ^ b2;
                    if (i10 < 0) {
                        j2 = i10 ^ (-128);
                    } else {
                        int i11 = i + 3;
                        int i12 = (bArr[i8] << 14) ^ i10;
                        if (i12 >= 0) {
                            j2 = i12 ^ 16256;
                            i8 = i11;
                        } else {
                            int i13 = i + 4;
                            int i14 = i12 ^ (bArr[i11] << 21);
                            if (i14 < 0) {
                                i8 = i13;
                                j2 = (-2080896) ^ i14;
                            } else {
                                long j7 = i14;
                                i8 = i + 5;
                                long j8 = j7 ^ (bArr[i13] << 28);
                                if (j8 >= 0) {
                                    j6 = 266354560;
                                } else {
                                    int i15 = i + 6;
                                    long j9 = j8 ^ (bArr[i8] << 35);
                                    if (j9 < 0) {
                                        j4 = -34093383808L;
                                    } else {
                                        i8 = i + 7;
                                        j8 = j9 ^ (bArr[i15] << 42);
                                        if (j8 >= 0) {
                                            j6 = 4363953127296L;
                                        } else {
                                            i15 = i + 8;
                                            j9 = j8 ^ (bArr[i8] << 49);
                                            if (j9 < 0) {
                                                j4 = -558586000294016L;
                                            } else {
                                                i8 = i + 9;
                                                long j10 = (j9 ^ (bArr[i15] << 56)) ^ 71499008037633920L;
                                                if (j10 < 0) {
                                                    int i16 = i + 10;
                                                    if (bArr[i8] >= 0) {
                                                        i8 = i16;
                                                    }
                                                }
                                                j2 = j10;
                                            }
                                        }
                                    }
                                    j2 = j9 ^ j4;
                                    i8 = i15;
                                }
                                j2 = j8 ^ j6;
                            }
                        }
                    }
                    this.f6322f = i8;
                    return j2;
                }
            }
            return v();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i = this.f6321c5;
                int i5 = this.f6322f;
                if (readRawVarint32 <= i - i5) {
                    String str = new String(this.f6323fb, i5, readRawVarint32, Internal.f6450n3);
                    this.f6322f += readRawVarint32;
                    return str;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.p();
            }
            throw InvalidProtocolBufferException.ta();
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i = this.f6321c5;
                int i5 = this.f6322f;
                if (readRawVarint32 <= i - i5) {
                    String s2 = Utf8.s(this.f6323fb, i5, readRawVarint32);
                    this.f6322f += readRawVarint32;
                    return s2;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 <= 0) {
                throw InvalidProtocolBufferException.p();
            }
            throw InvalidProtocolBufferException.ta();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.f6327tl = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.f6327tl = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.f6327tl;
            }
            throw InvalidProtocolBufferException.v();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i, MessageLite.Builder builder) throws IOException {
            readGroup(i, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.f6326t = this.f6322f;
        }

        public final void s() throws IOException {
            for (int i = 0; i < 10; i++) {
                byte[] bArr = this.f6323fb;
                int i5 = this.f6322f;
                this.f6322f = i5 + 1;
                if (bArr[i5] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.t();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                fb();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.y(WireFormat.getTagFieldNumber(i), 4));
                return true;
            } else if (tagWireType != 4) {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.i9();
            } else {
                return false;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag));
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int i) throws IOException {
            if (i >= 0) {
                int i5 = this.f6321c5;
                int i6 = this.f6322f;
                if (i <= i5 - i6) {
                    this.f6322f = i6 + i;
                    return;
                }
            }
            if (i < 0) {
                throw InvalidProtocolBufferException.p();
            }
            throw InvalidProtocolBufferException.ta();
        }

        public long v() throws IOException {
            long j2 = 0;
            for (int i = 0; i < 64; i += 7) {
                byte readRawByte = readRawByte();
                j2 |= (readRawByte & Byte.MAX_VALUE) << i;
                if ((readRawByte & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.t();
        }

        public ArrayDecoder(byte[] bArr, int i, int i5, boolean z2) {
            super();
            this.f6329xc = Integer.MAX_VALUE;
            this.f6323fb = bArr;
            this.f6321c5 = i5 + i;
            this.f6322f = i;
            this.f6326t = i;
            this.f6325s = z2;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream codedOutputStream) throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag, codedOutputStream));
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.y++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.y(i, 4));
            this.y--;
            return parsePartialFrom;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i);
                skipMessage(codedOutputStream);
                int y = WireFormat.y(WireFormat.getTagFieldNumber(i), 4);
                checkLastTagWas(y);
                codedOutputStream.writeUInt32NoTag(y);
                return true;
            } else if (tagWireType != 4) {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeUInt32NoTag(i);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.i9();
            } else {
                return false;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.y++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.y--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return parsePartialFrom;
            }
            throw InvalidProtocolBufferException.ta();
        }
    }

    /* loaded from: classes.dex */
    public static final class IterableDirectByteBufferDecoder extends CodedInputStream {

        /* renamed from: c5  reason: collision with root package name */
        public ByteBuffer f6330c5;

        /* renamed from: co  reason: collision with root package name */
        public long f6331co;

        /* renamed from: f  reason: collision with root package name */
        public boolean f6332f;

        /* renamed from: fb  reason: collision with root package name */
        public final Iterable<ByteBuffer> f6333fb;

        /* renamed from: i9  reason: collision with root package name */
        public final boolean f6334i9;

        /* renamed from: mt  reason: collision with root package name */
        public long f6335mt;

        /* renamed from: p  reason: collision with root package name */
        public int f6336p;

        /* renamed from: r  reason: collision with root package name */
        public long f6337r;

        /* renamed from: s  reason: collision with root package name */
        public final Iterator<ByteBuffer> f6338s;

        /* renamed from: t  reason: collision with root package name */
        public int f6339t;

        /* renamed from: tl  reason: collision with root package name */
        public int f6340tl;

        /* renamed from: w  reason: collision with root package name */
        public int f6341w;

        /* renamed from: wz  reason: collision with root package name */
        public int f6342wz;

        /* renamed from: xc  reason: collision with root package name */
        public int f6343xc;

        /* renamed from: z  reason: collision with root package name */
        public long f6344z;

        private void c5() {
            int i = this.f6339t + this.f6340tl;
            this.f6339t = i;
            int i5 = i - this.f6336p;
            int i6 = this.f6342wz;
            if (i5 > i6) {
                int i8 = i5 - i6;
                this.f6340tl = i8;
                this.f6339t = i - i8;
                return;
            }
            this.f6340tl = 0;
        }

        private void f() throws IOException {
            for (int i = 0; i < 10; i++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.t();
        }

        public final void a() throws InvalidProtocolBufferException {
            if (this.f6338s.hasNext()) {
                tl();
                return;
            }
            throw InvalidProtocolBufferException.ta();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int i) throws InvalidProtocolBufferException {
            if (this.f6343xc == i) {
                return;
            }
            throw InvalidProtocolBufferException.gv();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean z2) {
            this.f6332f = z2;
        }

        public final void fb(byte[] bArr, int i, int i5) throws IOException {
            if (i5 >= 0 && i5 <= i9()) {
                int i6 = i5;
                while (i6 > 0) {
                    if (v() == 0) {
                        a();
                    }
                    int min = Math.min(i6, (int) v());
                    long j2 = min;
                    UnsafeUtil.w(this.f6335mt, bArr, (i5 - i6) + i, j2);
                    i6 -= min;
                    this.f6335mt += j2;
                }
            } else if (i5 <= 0) {
                if (i5 == 0) {
                    return;
                }
                throw InvalidProtocolBufferException.p();
            } else {
                throw InvalidProtocolBufferException.ta();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i = this.f6342wz;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - getTotalBytesRead();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.f6343xc;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) (((this.f6341w - this.f6336p) + this.f6335mt) - this.f6331co);
        }

        public final int i9() {
            return (int) (((this.f6339t - this.f6341w) - this.f6335mt) + this.f6331co);
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            if ((this.f6341w + this.f6335mt) - this.f6331co == this.f6339t) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int i) {
            this.f6342wz = i;
            c5();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int i) throws InvalidProtocolBufferException {
            if (i >= 0) {
                int totalBytesRead = i + getTotalBytesRead();
                int i5 = this.f6342wz;
                if (totalBytesRead <= i5) {
                    this.f6342wz = totalBytesRead;
                    c5();
                    return i5;
                }
                throw InvalidProtocolBufferException.ta();
            }
            throw InvalidProtocolBufferException.p();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            if (readRawVarint64() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j2 = readRawVarint32;
                if (j2 <= v()) {
                    if (!this.f6334i9 && this.f6332f) {
                        long j4 = this.f6335mt + j2;
                        this.f6335mt = j4;
                        long j6 = this.f6344z;
                        return t((int) ((j4 - j6) - j2), (int) (j4 - j6));
                    }
                    byte[] bArr = new byte[readRawVarint32];
                    UnsafeUtil.w(this.f6335mt, bArr, 0L, j2);
                    this.f6335mt += j2;
                    return ByteBuffer.wrap(bArr);
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= i9()) {
                byte[] bArr2 = new byte[readRawVarint32];
                fb(bArr2, 0, readRawVarint32);
                return ByteBuffer.wrap(bArr2);
            } else if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.p();
                }
                throw InvalidProtocolBufferException.ta();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j2 = readRawVarint32;
                long j4 = this.f6337r;
                long j6 = this.f6335mt;
                if (j2 <= j4 - j6) {
                    if (this.f6334i9 && this.f6332f) {
                        int i = (int) (j6 - this.f6344z);
                        ByteString j52 = ByteString.j5(t(i, readRawVarint32 + i));
                        this.f6335mt += j2;
                        return j52;
                    }
                    byte[] bArr = new byte[readRawVarint32];
                    UnsafeUtil.w(j6, bArr, 0L, j2);
                    this.f6335mt += j2;
                    return ByteString.o(bArr);
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= i9()) {
                if (this.f6334i9 && this.f6332f) {
                    ArrayList arrayList = new ArrayList();
                    while (readRawVarint32 > 0) {
                        if (v() == 0) {
                            a();
                        }
                        int min = Math.min(readRawVarint32, (int) v());
                        int i5 = (int) (this.f6335mt - this.f6344z);
                        arrayList.add(ByteString.j5(t(i5, i5 + min)));
                        readRawVarint32 -= min;
                        this.f6335mt += min;
                    }
                    return ByteString.copyFrom(arrayList);
                }
                byte[] bArr2 = new byte[readRawVarint32];
                fb(bArr2, 0, readRawVarint32);
                return ByteString.o(bArr2);
            } else if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.p();
                }
                throw InvalidProtocolBufferException.ta();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.y++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.y(i, 4));
            this.y--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.y++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.y--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.ta();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            if (v() == 0) {
                a();
            }
            long j2 = this.f6335mt;
            this.f6335mt = 1 + j2;
            return UnsafeUtil.f3(j2);
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int i) throws IOException {
            if (i >= 0) {
                long j2 = i;
                if (j2 <= v()) {
                    byte[] bArr = new byte[i];
                    UnsafeUtil.w(this.f6335mt, bArr, 0L, j2);
                    this.f6335mt += j2;
                    return bArr;
                }
            }
            if (i >= 0 && i <= i9()) {
                byte[] bArr2 = new byte[i];
                fb(bArr2, 0, i);
                return bArr2;
            } else if (i <= 0) {
                if (i == 0) {
                    return Internal.EMPTY_BYTE_ARRAY;
                }
                throw InvalidProtocolBufferException.p();
            } else {
                throw InvalidProtocolBufferException.ta();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            if (v() >= 4) {
                long j2 = this.f6335mt;
                this.f6335mt = 4 + j2;
                return ((UnsafeUtil.f3(j2 + 3) & 255) << 24) | (UnsafeUtil.f3(j2) & 255) | ((UnsafeUtil.f3(1 + j2) & 255) << 8) | ((UnsafeUtil.f3(2 + j2) & 255) << 16);
            }
            return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24);
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            if (v() >= 8) {
                long j2 = this.f6335mt;
                this.f6335mt = 8 + j2;
                long f32 = (UnsafeUtil.f3(j2) & 255) | ((UnsafeUtil.f3(1 + j2) & 255) << 8);
                return ((UnsafeUtil.f3(j2 + 7) & 255) << 56) | ((UnsafeUtil.f3(2 + j2) & 255) << 16) | f32 | ((UnsafeUtil.f3(3 + j2) & 255) << 24) | ((UnsafeUtil.f3(4 + j2) & 255) << 32) | ((UnsafeUtil.f3(5 + j2) & 255) << 40) | ((UnsafeUtil.f3(6 + j2) & 255) << 48);
            }
            return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24) | ((readRawByte() & 255) << 32) | ((readRawByte() & 255) << 40) | ((readRawByte() & 255) << 48) | ((readRawByte() & 255) << 56);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawVarint32() throws IOException {
            int i;
            long j2 = this.f6335mt;
            if (this.f6337r != j2) {
                long j4 = j2 + 1;
                byte f32 = UnsafeUtil.f3(j2);
                if (f32 >= 0) {
                    this.f6335mt++;
                    return f32;
                } else if (this.f6337r - this.f6335mt >= 10) {
                    long j6 = 2 + j2;
                    int f33 = (UnsafeUtil.f3(j4) << 7) ^ f32;
                    if (f33 < 0) {
                        i = f33 ^ (-128);
                    } else {
                        long j7 = 3 + j2;
                        int f34 = (UnsafeUtil.f3(j6) << 14) ^ f33;
                        if (f34 >= 0) {
                            i = f34 ^ 16256;
                        } else {
                            long j8 = 4 + j2;
                            int f35 = f34 ^ (UnsafeUtil.f3(j7) << 21);
                            if (f35 < 0) {
                                i = (-2080896) ^ f35;
                            } else {
                                j7 = 5 + j2;
                                byte f36 = UnsafeUtil.f3(j8);
                                int i5 = (f35 ^ (f36 << 28)) ^ 266354560;
                                if (f36 < 0) {
                                    j8 = 6 + j2;
                                    if (UnsafeUtil.f3(j7) < 0) {
                                        j7 = 7 + j2;
                                        if (UnsafeUtil.f3(j8) < 0) {
                                            j8 = 8 + j2;
                                            if (UnsafeUtil.f3(j7) < 0) {
                                                j7 = 9 + j2;
                                                if (UnsafeUtil.f3(j8) < 0) {
                                                    long j9 = j2 + 10;
                                                    if (UnsafeUtil.f3(j7) >= 0) {
                                                        i = i5;
                                                        j6 = j9;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i = i5;
                                }
                                i = i5;
                            }
                            j6 = j8;
                        }
                        j6 = j7;
                    }
                    this.f6335mt = j6;
                    return i;
                }
            }
            return (int) s();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            long j2;
            long j4;
            long j6;
            long j7 = this.f6335mt;
            if (this.f6337r != j7) {
                long j8 = j7 + 1;
                byte f32 = UnsafeUtil.f3(j7);
                if (f32 >= 0) {
                    this.f6335mt++;
                    return f32;
                } else if (this.f6337r - this.f6335mt >= 10) {
                    long j9 = 2 + j7;
                    int f33 = (UnsafeUtil.f3(j8) << 7) ^ f32;
                    if (f33 < 0) {
                        j2 = f33 ^ (-128);
                    } else {
                        long j10 = 3 + j7;
                        int f34 = (UnsafeUtil.f3(j9) << 14) ^ f33;
                        if (f34 >= 0) {
                            j2 = f34 ^ 16256;
                            j9 = j10;
                        } else {
                            long j11 = 4 + j7;
                            int f35 = f34 ^ (UnsafeUtil.f3(j10) << 21);
                            if (f35 < 0) {
                                j2 = (-2080896) ^ f35;
                                j9 = j11;
                            } else {
                                long j12 = 5 + j7;
                                long f36 = (UnsafeUtil.f3(j11) << 28) ^ f35;
                                if (f36 >= 0) {
                                    j6 = 266354560;
                                } else {
                                    long j13 = 6 + j7;
                                    long f37 = f36 ^ (UnsafeUtil.f3(j12) << 35);
                                    if (f37 < 0) {
                                        j4 = -34093383808L;
                                    } else {
                                        j12 = 7 + j7;
                                        f36 = f37 ^ (UnsafeUtil.f3(j13) << 42);
                                        if (f36 >= 0) {
                                            j6 = 4363953127296L;
                                        } else {
                                            j13 = 8 + j7;
                                            f37 = f36 ^ (UnsafeUtil.f3(j12) << 49);
                                            if (f37 < 0) {
                                                j4 = -558586000294016L;
                                            } else {
                                                j12 = 9 + j7;
                                                long f38 = (f37 ^ (UnsafeUtil.f3(j13) << 56)) ^ 71499008037633920L;
                                                if (f38 < 0) {
                                                    long j14 = j7 + 10;
                                                    if (UnsafeUtil.f3(j12) >= 0) {
                                                        j2 = f38;
                                                        j9 = j14;
                                                    }
                                                } else {
                                                    j2 = f38;
                                                    j9 = j12;
                                                }
                                            }
                                        }
                                    }
                                    j2 = j4 ^ f37;
                                    j9 = j13;
                                }
                                j2 = j6 ^ f36;
                                j9 = j12;
                            }
                        }
                    }
                    this.f6335mt = j9;
                    return j2;
                }
            }
            return s();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j2 = readRawVarint32;
                long j4 = this.f6337r;
                long j6 = this.f6335mt;
                if (j2 <= j4 - j6) {
                    byte[] bArr = new byte[readRawVarint32];
                    UnsafeUtil.w(j6, bArr, 0L, j2);
                    String str = new String(bArr, Internal.f6450n3);
                    this.f6335mt += j2;
                    return str;
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= i9()) {
                byte[] bArr2 = new byte[readRawVarint32];
                fb(bArr2, 0, readRawVarint32);
                return new String(bArr2, Internal.f6450n3);
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.p();
                }
                throw InvalidProtocolBufferException.ta();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j2 = readRawVarint32;
                long j4 = this.f6337r;
                long j6 = this.f6335mt;
                if (j2 <= j4 - j6) {
                    String fb2 = Utf8.fb(this.f6330c5, (int) (j6 - this.f6331co), readRawVarint32);
                    this.f6335mt += j2;
                    return fb2;
                }
            }
            if (readRawVarint32 >= 0 && readRawVarint32 <= i9()) {
                byte[] bArr = new byte[readRawVarint32];
                fb(bArr, 0, readRawVarint32);
                return Utf8.s(bArr, 0, readRawVarint32);
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 <= 0) {
                    throw InvalidProtocolBufferException.p();
                }
                throw InvalidProtocolBufferException.ta();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.f6343xc = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.f6343xc = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.f6343xc;
            }
            throw InvalidProtocolBufferException.v();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i, MessageLite.Builder builder) throws IOException {
            readGroup(i, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.f6336p = (int) ((this.f6341w + this.f6335mt) - this.f6331co);
        }

        public long s() throws IOException {
            long j2 = 0;
            for (int i = 0; i < 64; i += 7) {
                byte readRawByte = readRawByte();
                j2 |= (readRawByte & Byte.MAX_VALUE) << i;
                if ((readRawByte & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.t();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                f();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.y(WireFormat.getTagFieldNumber(i), 4));
                return true;
            } else if (tagWireType != 4) {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.i9();
            } else {
                return false;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag));
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int i) throws IOException {
            if (i >= 0 && i <= ((this.f6339t - this.f6341w) - this.f6335mt) + this.f6331co) {
                while (i > 0) {
                    if (v() == 0) {
                        a();
                    }
                    int min = Math.min(i, (int) v());
                    i -= min;
                    this.f6335mt += min;
                }
            } else if (i < 0) {
                throw InvalidProtocolBufferException.p();
            } else {
                throw InvalidProtocolBufferException.ta();
            }
        }

        public final ByteBuffer t(int i, int i5) throws IOException {
            int position = this.f6330c5.position();
            int limit = this.f6330c5.limit();
            ByteBuffer byteBuffer = this.f6330c5;
            try {
                try {
                    byteBuffer.position(i);
                    byteBuffer.limit(i5);
                    return this.f6330c5.slice();
                } catch (IllegalArgumentException unused) {
                    throw InvalidProtocolBufferException.ta();
                }
            } finally {
                byteBuffer.position(position);
                byteBuffer.limit(limit);
            }
        }

        public final void tl() {
            ByteBuffer next = this.f6338s.next();
            this.f6330c5 = next;
            this.f6341w += (int) (this.f6335mt - this.f6331co);
            long position = next.position();
            this.f6335mt = position;
            this.f6331co = position;
            this.f6337r = this.f6330c5.limit();
            long f4 = UnsafeUtil.f(this.f6330c5);
            this.f6344z = f4;
            this.f6335mt += f4;
            this.f6331co += f4;
            this.f6337r += f4;
        }

        public final long v() {
            return this.f6337r - this.f6335mt;
        }

        public IterableDirectByteBufferDecoder(Iterable<ByteBuffer> iterable, int i, boolean z2) {
            super();
            this.f6342wz = Integer.MAX_VALUE;
            this.f6339t = i;
            this.f6333fb = iterable;
            this.f6338s = iterable.iterator();
            this.f6334i9 = z2;
            this.f6341w = 0;
            this.f6336p = 0;
            if (i == 0) {
                this.f6330c5 = Internal.EMPTY_BYTE_BUFFER;
                this.f6335mt = 0L;
                this.f6331co = 0L;
                this.f6337r = 0L;
                this.f6344z = 0L;
                return;
            }
            tl();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream codedOutputStream) throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag, codedOutputStream));
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.y++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.y(i, 4));
            this.y--;
            return parsePartialFrom;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i);
                skipMessage(codedOutputStream);
                int y = WireFormat.y(WireFormat.getTagFieldNumber(i), 4);
                checkLastTagWas(y);
                codedOutputStream.writeUInt32NoTag(y);
                return true;
            } else if (tagWireType != 4) {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeUInt32NoTag(i);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.i9();
            } else {
                return false;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.y++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.y--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return parsePartialFrom;
            }
            throw InvalidProtocolBufferException.ta();
        }
    }

    /* loaded from: classes.dex */
    public static final class StreamDecoder extends CodedInputStream {

        /* renamed from: c5  reason: collision with root package name */
        public int f6345c5;

        /* renamed from: f  reason: collision with root package name */
        public int f6346f;

        /* renamed from: fb  reason: collision with root package name */
        public final InputStream f6347fb;

        /* renamed from: i9  reason: collision with root package name */
        public int f6348i9;

        /* renamed from: s  reason: collision with root package name */
        public final byte[] f6349s;

        /* renamed from: t  reason: collision with root package name */
        public int f6350t;

        /* renamed from: tl  reason: collision with root package name */
        public int f6351tl;

        /* renamed from: wz  reason: collision with root package name */
        public int f6352wz;

        /* renamed from: xc  reason: collision with root package name */
        public RefillCallback f6353xc;

        private void co() throws IOException {
            for (int i = 0; i < 10; i++) {
                byte[] bArr = this.f6349s;
                int i5 = this.f6346f;
                this.f6346f = i5 + 1;
                if (bArr[i5] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.t();
        }

        public static int fb(InputStream inputStream) throws IOException {
            try {
                return inputStream.available();
            } catch (InvalidProtocolBufferException e2) {
                e2.r();
                throw e2;
            }
        }

        private void mt() throws IOException {
            if (this.f6345c5 - this.f6346f >= 10) {
                co();
            } else {
                z();
            }
        }

        public static int s(InputStream inputStream, byte[] bArr, int i, int i5) throws IOException {
            try {
                return inputStream.read(bArr, i, i5);
            } catch (InvalidProtocolBufferException e2) {
                e2.r();
                throw e2;
            }
        }

        public static long w(InputStream inputStream, long j2) throws IOException {
            try {
                return inputStream.skip(j2);
            } catch (InvalidProtocolBufferException e2) {
                e2.r();
                throw e2;
            }
        }

        private void wz() {
            int i = this.f6345c5 + this.f6348i9;
            this.f6345c5 = i;
            int i5 = this.f6351tl + i;
            int i6 = this.f6352wz;
            if (i5 > i6) {
                int i8 = i5 - i6;
                this.f6348i9 = i8;
                this.f6345c5 = i - i8;
                return;
            }
            this.f6348i9 = 0;
        }

        private void z() throws IOException {
            for (int i = 0; i < 10; i++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.t();
        }

        public final ByteString c5(int i) throws IOException {
            byte[] f4 = f(i);
            if (f4 != null) {
                return ByteString.copyFrom(f4);
            }
            int i5 = this.f6346f;
            int i6 = this.f6345c5;
            int i8 = i6 - i5;
            this.f6351tl += i6;
            this.f6346f = 0;
            this.f6345c5 = 0;
            List<byte[]> t2 = t(i - i8);
            byte[] bArr = new byte[i];
            System.arraycopy(this.f6349s, i5, bArr, 0, i8);
            for (byte[] bArr2 : t2) {
                System.arraycopy(bArr2, 0, bArr, i8, bArr2.length);
                i8 += bArr2.length;
            }
            return ByteString.o(bArr);
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int i) throws InvalidProtocolBufferException {
            if (this.f6350t == i) {
                return;
            }
            throw InvalidProtocolBufferException.gv();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean z2) {
        }

        public final byte[] f(int i) throws IOException {
            if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            if (i >= 0) {
                int i5 = this.f6351tl;
                int i6 = this.f6346f;
                int i8 = i5 + i6 + i;
                if (i8 - this.f6320zn <= 0) {
                    int i10 = this.f6352wz;
                    if (i8 <= i10) {
                        int i11 = this.f6345c5 - i6;
                        int i12 = i - i11;
                        if (i12 >= 4096 && i12 > fb(this.f6347fb)) {
                            return null;
                        }
                        byte[] bArr = new byte[i];
                        System.arraycopy(this.f6349s, this.f6346f, bArr, 0, i11);
                        this.f6351tl += this.f6345c5;
                        this.f6346f = 0;
                        this.f6345c5 = 0;
                        while (i11 < i) {
                            int s2 = s(this.f6347fb, bArr, i11, i - i11);
                            if (s2 != -1) {
                                this.f6351tl += s2;
                                i11 += s2;
                            } else {
                                throw InvalidProtocolBufferException.ta();
                            }
                        }
                        return bArr;
                    }
                    skipRawBytes((i10 - i5) - i6);
                    throw InvalidProtocolBufferException.ta();
                }
                throw InvalidProtocolBufferException.x4();
            }
            throw InvalidProtocolBufferException.p();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i = this.f6352wz;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - (this.f6351tl + this.f6346f);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.f6350t;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.f6351tl + this.f6346f;
        }

        public final byte[] i9(int i, boolean z2) throws IOException {
            byte[] f4 = f(i);
            if (f4 != null) {
                if (z2) {
                    return (byte[]) f4.clone();
                }
                return f4;
            }
            int i5 = this.f6346f;
            int i6 = this.f6345c5;
            int i8 = i6 - i5;
            this.f6351tl += i6;
            this.f6346f = 0;
            this.f6345c5 = 0;
            List<byte[]> t2 = t(i - i8);
            byte[] bArr = new byte[i];
            System.arraycopy(this.f6349s, i5, bArr, 0, i8);
            for (byte[] bArr2 : t2) {
                System.arraycopy(bArr2, 0, bArr, i8, bArr2.length);
                i8 += bArr2.length;
            }
            return bArr;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            if (this.f6346f == this.f6345c5 && !r(1)) {
                return true;
            }
            return false;
        }

        public final void p(int i) throws IOException {
            if (i >= 0) {
                int i5 = this.f6351tl;
                int i6 = this.f6346f;
                int i8 = i5 + i6 + i;
                int i10 = this.f6352wz;
                if (i8 <= i10) {
                    int i11 = 0;
                    if (this.f6353xc == null) {
                        this.f6351tl = i5 + i6;
                        this.f6345c5 = 0;
                        this.f6346f = 0;
                        i11 = this.f6345c5 - i6;
                        while (i11 < i) {
                            try {
                                long j2 = i - i11;
                                long w4 = w(this.f6347fb, j2);
                                int i12 = (w4 > 0L ? 1 : (w4 == 0L ? 0 : -1));
                                if (i12 >= 0 && w4 <= j2) {
                                    if (i12 == 0) {
                                        break;
                                    }
                                    i11 += (int) w4;
                                } else {
                                    throw new IllegalStateException(this.f6347fb.getClass() + "#skip returned invalid result: " + w4 + "\nThe InputStream implementation is buggy.");
                                }
                            } finally {
                                this.f6351tl += i11;
                                wz();
                            }
                        }
                    }
                    if (i11 < i) {
                        int i13 = this.f6345c5;
                        int i14 = i13 - this.f6346f;
                        this.f6346f = i13;
                        xc(1);
                        while (true) {
                            int i15 = i - i14;
                            int i16 = this.f6345c5;
                            if (i15 > i16) {
                                i14 += i16;
                                this.f6346f = i16;
                                xc(1);
                            } else {
                                this.f6346f = i15;
                                return;
                            }
                        }
                    }
                } else {
                    skipRawBytes((i10 - i5) - i6);
                    throw InvalidProtocolBufferException.ta();
                }
            } else {
                throw InvalidProtocolBufferException.p();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int i) {
            this.f6352wz = i;
            wz();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int i) throws InvalidProtocolBufferException {
            if (i >= 0) {
                int i5 = i + this.f6351tl + this.f6346f;
                int i6 = this.f6352wz;
                if (i5 <= i6) {
                    this.f6352wz = i5;
                    wz();
                    return i6;
                }
                throw InvalidProtocolBufferException.ta();
            }
            throw InvalidProtocolBufferException.p();
        }

        public final boolean r(int i) throws IOException {
            int i5 = this.f6346f;
            if (i5 + i > this.f6345c5) {
                int i6 = this.f6320zn;
                int i8 = this.f6351tl;
                if (i > (i6 - i8) - i5 || i8 + i5 + i > this.f6352wz) {
                    return false;
                }
                RefillCallback refillCallback = this.f6353xc;
                if (refillCallback != null) {
                    refillCallback.onRefill();
                }
                int i10 = this.f6346f;
                if (i10 > 0) {
                    int i11 = this.f6345c5;
                    if (i11 > i10) {
                        byte[] bArr = this.f6349s;
                        System.arraycopy(bArr, i10, bArr, 0, i11 - i10);
                    }
                    this.f6351tl += i10;
                    this.f6345c5 -= i10;
                    this.f6346f = 0;
                }
                InputStream inputStream = this.f6347fb;
                byte[] bArr2 = this.f6349s;
                int i12 = this.f6345c5;
                int s2 = s(inputStream, bArr2, i12, Math.min(bArr2.length - i12, (this.f6320zn - this.f6351tl) - i12));
                if (s2 != 0 && s2 >= -1 && s2 <= this.f6349s.length) {
                    if (s2 <= 0) {
                        return false;
                    }
                    this.f6345c5 += s2;
                    wz();
                    if (this.f6345c5 >= i) {
                        return true;
                    }
                    return r(i);
                }
                throw new IllegalStateException(this.f6347fb.getClass() + "#read(byte[]) returned invalid result: " + s2 + "\nThe InputStream implementation is buggy.");
            }
            throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            if (readRawVarint64() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            int readRawVarint32 = readRawVarint32();
            int i = this.f6345c5;
            int i5 = this.f6346f;
            if (readRawVarint32 <= i - i5 && readRawVarint32 > 0) {
                byte[] copyOfRange = Arrays.copyOfRange(this.f6349s, i5, i5 + readRawVarint32);
                this.f6346f += readRawVarint32;
                return copyOfRange;
            }
            return i9(readRawVarint32, false);
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            int i = this.f6345c5;
            int i5 = this.f6346f;
            if (readRawVarint32 <= i - i5 && readRawVarint32 > 0) {
                ByteBuffer wrap = ByteBuffer.wrap(Arrays.copyOfRange(this.f6349s, i5, i5 + readRawVarint32));
                this.f6346f += readRawVarint32;
                return wrap;
            } else if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            } else {
                return ByteBuffer.wrap(i9(readRawVarint32, true));
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            int i = this.f6345c5;
            int i5 = this.f6346f;
            if (readRawVarint32 <= i - i5 && readRawVarint32 > 0) {
                ByteString copyFrom = ByteString.copyFrom(this.f6349s, i5, readRawVarint32);
                this.f6346f += readRawVarint32;
                return copyFrom;
            } else if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            } else {
                return c5(readRawVarint32);
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.y++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.y(i, 4));
            this.y--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.y++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.y--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.ta();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            if (this.f6346f == this.f6345c5) {
                xc(1);
            }
            byte[] bArr = this.f6349s;
            int i = this.f6346f;
            this.f6346f = i + 1;
            return bArr[i];
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int i) throws IOException {
            int i5 = this.f6346f;
            if (i <= this.f6345c5 - i5 && i > 0) {
                int i6 = i + i5;
                this.f6346f = i6;
                return Arrays.copyOfRange(this.f6349s, i5, i6);
            }
            return i9(i, false);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            int i = this.f6346f;
            if (this.f6345c5 - i < 4) {
                xc(4);
                i = this.f6346f;
            }
            byte[] bArr = this.f6349s;
            this.f6346f = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            int i = this.f6346f;
            if (this.f6345c5 - i < 8) {
                xc(8);
                i = this.f6346f;
            }
            byte[] bArr = this.f6349s;
            this.f6346f = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawVarint32() throws IOException {
            int i;
            int i5 = this.f6346f;
            int i6 = this.f6345c5;
            if (i6 != i5) {
                byte[] bArr = this.f6349s;
                int i8 = i5 + 1;
                byte b2 = bArr[i5];
                if (b2 >= 0) {
                    this.f6346f = i8;
                    return b2;
                } else if (i6 - i8 >= 9) {
                    int i10 = i5 + 2;
                    int i11 = (bArr[i8] << 7) ^ b2;
                    if (i11 < 0) {
                        i = i11 ^ (-128);
                    } else {
                        int i12 = i5 + 3;
                        int i13 = (bArr[i10] << 14) ^ i11;
                        if (i13 >= 0) {
                            i = i13 ^ 16256;
                        } else {
                            int i14 = i5 + 4;
                            int i15 = i13 ^ (bArr[i12] << 21);
                            if (i15 < 0) {
                                i = (-2080896) ^ i15;
                            } else {
                                i12 = i5 + 5;
                                byte b3 = bArr[i14];
                                int i16 = (i15 ^ (b3 << 28)) ^ 266354560;
                                if (b3 < 0) {
                                    i14 = i5 + 6;
                                    if (bArr[i12] < 0) {
                                        i12 = i5 + 7;
                                        if (bArr[i14] < 0) {
                                            i14 = i5 + 8;
                                            if (bArr[i12] < 0) {
                                                i12 = i5 + 9;
                                                if (bArr[i14] < 0) {
                                                    int i17 = i5 + 10;
                                                    if (bArr[i12] >= 0) {
                                                        i10 = i17;
                                                        i = i16;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i = i16;
                                }
                                i = i16;
                            }
                            i10 = i14;
                        }
                        i10 = i12;
                    }
                    this.f6346f = i10;
                    return i;
                }
            }
            return (int) tl();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            long j2;
            long j4;
            long j6;
            int i = this.f6346f;
            int i5 = this.f6345c5;
            if (i5 != i) {
                byte[] bArr = this.f6349s;
                int i6 = i + 1;
                byte b2 = bArr[i];
                if (b2 >= 0) {
                    this.f6346f = i6;
                    return b2;
                } else if (i5 - i6 >= 9) {
                    int i8 = i + 2;
                    int i10 = (bArr[i6] << 7) ^ b2;
                    if (i10 < 0) {
                        j2 = i10 ^ (-128);
                    } else {
                        int i11 = i + 3;
                        int i12 = (bArr[i8] << 14) ^ i10;
                        if (i12 >= 0) {
                            j2 = i12 ^ 16256;
                            i8 = i11;
                        } else {
                            int i13 = i + 4;
                            int i14 = i12 ^ (bArr[i11] << 21);
                            if (i14 < 0) {
                                i8 = i13;
                                j2 = (-2080896) ^ i14;
                            } else {
                                long j7 = i14;
                                i8 = i + 5;
                                long j8 = j7 ^ (bArr[i13] << 28);
                                if (j8 >= 0) {
                                    j6 = 266354560;
                                } else {
                                    int i15 = i + 6;
                                    long j9 = j8 ^ (bArr[i8] << 35);
                                    if (j9 < 0) {
                                        j4 = -34093383808L;
                                    } else {
                                        i8 = i + 7;
                                        j8 = j9 ^ (bArr[i15] << 42);
                                        if (j8 >= 0) {
                                            j6 = 4363953127296L;
                                        } else {
                                            i15 = i + 8;
                                            j9 = j8 ^ (bArr[i8] << 49);
                                            if (j9 < 0) {
                                                j4 = -558586000294016L;
                                            } else {
                                                i8 = i + 9;
                                                long j10 = (j9 ^ (bArr[i15] << 56)) ^ 71499008037633920L;
                                                if (j10 < 0) {
                                                    int i16 = i + 10;
                                                    if (bArr[i8] >= 0) {
                                                        i8 = i16;
                                                    }
                                                }
                                                j2 = j10;
                                            }
                                        }
                                    }
                                    j2 = j9 ^ j4;
                                    i8 = i15;
                                }
                                j2 = j8 ^ j6;
                            }
                        }
                    }
                    this.f6346f = i8;
                    return j2;
                }
            }
            return tl();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i = this.f6345c5;
                int i5 = this.f6346f;
                if (readRawVarint32 <= i - i5) {
                    String str = new String(this.f6349s, i5, readRawVarint32, Internal.f6450n3);
                    this.f6346f += readRawVarint32;
                    return str;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 <= this.f6345c5) {
                xc(readRawVarint32);
                String str2 = new String(this.f6349s, this.f6346f, readRawVarint32, Internal.f6450n3);
                this.f6346f += readRawVarint32;
                return str2;
            }
            return new String(i9(readRawVarint32, false), Internal.f6450n3);
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            byte[] i92;
            int readRawVarint32 = readRawVarint32();
            int i = this.f6346f;
            int i5 = this.f6345c5;
            if (readRawVarint32 <= i5 - i && readRawVarint32 > 0) {
                i92 = this.f6349s;
                this.f6346f = i + readRawVarint32;
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                i = 0;
                if (readRawVarint32 <= i5) {
                    xc(readRawVarint32);
                    i92 = this.f6349s;
                    this.f6346f = readRawVarint32;
                } else {
                    i92 = i9(readRawVarint32, false);
                }
            }
            return Utf8.s(i92, i, readRawVarint32);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.f6350t = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.f6350t = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.f6350t;
            }
            throw InvalidProtocolBufferException.v();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i, MessageLite.Builder builder) throws IOException {
            readGroup(i, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.f6351tl = -this.f6346f;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                mt();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.y(WireFormat.getTagFieldNumber(i), 4));
                return true;
            } else if (tagWireType != 4) {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.i9();
            } else {
                return false;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag));
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int i) throws IOException {
            int i5 = this.f6345c5;
            int i6 = this.f6346f;
            if (i <= i5 - i6 && i >= 0) {
                this.f6346f = i6 + i;
            } else {
                p(i);
            }
        }

        public final List<byte[]> t(int i) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i > 0) {
                int min = Math.min(i, 4096);
                byte[] bArr = new byte[min];
                int i5 = 0;
                while (i5 < min) {
                    int read = this.f6347fb.read(bArr, i5, min - i5);
                    if (read != -1) {
                        this.f6351tl += read;
                        i5 += read;
                    } else {
                        throw InvalidProtocolBufferException.ta();
                    }
                }
                i -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public long tl() throws IOException {
            long j2 = 0;
            for (int i = 0; i < 64; i += 7) {
                byte readRawByte = readRawByte();
                j2 |= (readRawByte & Byte.MAX_VALUE) << i;
                if ((readRawByte & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.t();
        }

        public final void xc(int i) throws IOException {
            if (!r(i)) {
                if (i > (this.f6320zn - this.f6351tl) - this.f6346f) {
                    throw InvalidProtocolBufferException.x4();
                }
                throw InvalidProtocolBufferException.ta();
            }
        }

        public StreamDecoder(InputStream inputStream, int i) {
            super();
            this.f6352wz = Integer.MAX_VALUE;
            Internal.n3(inputStream, "input");
            this.f6347fb = inputStream;
            this.f6349s = new byte[i];
            this.f6345c5 = 0;
            this.f6346f = 0;
            this.f6351tl = 0;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream codedOutputStream) throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag, codedOutputStream));
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.y++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.y(i, 4));
            this.y--;
            return parsePartialFrom;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i);
                skipMessage(codedOutputStream);
                int y = WireFormat.y(WireFormat.getTagFieldNumber(i), 4);
                checkLastTagWas(y);
                codedOutputStream.writeUInt32NoTag(y);
                return true;
            } else if (tagWireType != 4) {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeUInt32NoTag(i);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.i9();
            } else {
                return false;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.y++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.y--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return parsePartialFrom;
            }
            throw InvalidProtocolBufferException.ta();
        }
    }

    /* loaded from: classes.dex */
    public static final class UnsafeDirectNioDecoder extends CodedInputStream {

        /* renamed from: c5  reason: collision with root package name */
        public final long f6354c5;

        /* renamed from: f  reason: collision with root package name */
        public long f6355f;

        /* renamed from: fb  reason: collision with root package name */
        public final ByteBuffer f6356fb;

        /* renamed from: i9  reason: collision with root package name */
        public long f6357i9;

        /* renamed from: s  reason: collision with root package name */
        public final boolean f6358s;

        /* renamed from: t  reason: collision with root package name */
        public long f6359t;

        /* renamed from: tl  reason: collision with root package name */
        public int f6360tl;

        /* renamed from: w  reason: collision with root package name */
        public int f6361w;

        /* renamed from: wz  reason: collision with root package name */
        public int f6362wz;

        /* renamed from: xc  reason: collision with root package name */
        public boolean f6363xc;

        public static boolean a() {
            return UnsafeUtil.x();
        }

        private int c5() {
            return (int) (this.f6357i9 - this.f6355f);
        }

        private void f() throws IOException {
            for (int i = 0; i < 10; i++) {
                long j2 = this.f6355f;
                this.f6355f = 1 + j2;
                if (UnsafeUtil.f3(j2) >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.t();
        }

        private void i9() throws IOException {
            if (c5() >= 10) {
                f();
            } else {
                t();
            }
        }

        private void s() {
            long j2 = this.f6357i9 + this.f6360tl;
            this.f6357i9 = j2;
            int i = (int) (j2 - this.f6359t);
            int i5 = this.f6361w;
            if (i > i5) {
                int i6 = i - i5;
                this.f6360tl = i6;
                this.f6357i9 = j2 - i6;
                return;
            }
            this.f6360tl = 0;
        }

        private void t() throws IOException {
            for (int i = 0; i < 10; i++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.t();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int i) throws InvalidProtocolBufferException {
            if (this.f6362wz == i) {
                return;
            }
            throw InvalidProtocolBufferException.gv();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean z2) {
            this.f6363xc = z2;
        }

        public long fb() throws IOException {
            long j2 = 0;
            for (int i = 0; i < 64; i += 7) {
                byte readRawByte = readRawByte();
                j2 |= (readRawByte & Byte.MAX_VALUE) << i;
                if ((readRawByte & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.t();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i = this.f6361w;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - getTotalBytesRead();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.f6362wz;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) (this.f6355f - this.f6359t);
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            if (this.f6355f == this.f6357i9) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int i) {
            this.f6361w = i;
            s();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int i) throws InvalidProtocolBufferException {
            if (i >= 0) {
                int totalBytesRead = i + getTotalBytesRead();
                int i5 = this.f6361w;
                if (totalBytesRead <= i5) {
                    this.f6361w = totalBytesRead;
                    s();
                    return i5;
                }
                throw InvalidProtocolBufferException.ta();
            }
            throw InvalidProtocolBufferException.p();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            if (readRawVarint64() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0 && readRawVarint32 <= c5()) {
                if (!this.f6358s && this.f6363xc) {
                    long j2 = this.f6355f;
                    long j4 = readRawVarint32;
                    ByteBuffer tl2 = tl(j2, j2 + j4);
                    this.f6355f += j4;
                    return tl2;
                }
                byte[] bArr = new byte[readRawVarint32];
                long j6 = readRawVarint32;
                UnsafeUtil.w(this.f6355f, bArr, 0L, j6);
                this.f6355f += j6;
                return ByteBuffer.wrap(bArr);
            } else if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.p();
                }
                throw InvalidProtocolBufferException.ta();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0 && readRawVarint32 <= c5()) {
                if (this.f6358s && this.f6363xc) {
                    long j2 = this.f6355f;
                    long j4 = readRawVarint32;
                    ByteBuffer tl2 = tl(j2, j2 + j4);
                    this.f6355f += j4;
                    return ByteString.j5(tl2);
                }
                byte[] bArr = new byte[readRawVarint32];
                long j6 = readRawVarint32;
                UnsafeUtil.w(this.f6355f, bArr, 0L, j6);
                this.f6355f += j6;
                return ByteString.o(bArr);
            } else if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.p();
                }
                throw InvalidProtocolBufferException.ta();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.y++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.y(i, 4));
            this.y--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.y++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.y--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.ta();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            long j2 = this.f6355f;
            if (j2 != this.f6357i9) {
                this.f6355f = 1 + j2;
                return UnsafeUtil.f3(j2);
            }
            throw InvalidProtocolBufferException.ta();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int i) throws IOException {
            if (i >= 0 && i <= c5()) {
                byte[] bArr = new byte[i];
                long j2 = this.f6355f;
                long j4 = i;
                tl(j2, j2 + j4).get(bArr);
                this.f6355f += j4;
                return bArr;
            } else if (i <= 0) {
                if (i == 0) {
                    return Internal.EMPTY_BYTE_ARRAY;
                }
                throw InvalidProtocolBufferException.p();
            } else {
                throw InvalidProtocolBufferException.ta();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            long j2 = this.f6355f;
            if (this.f6357i9 - j2 >= 4) {
                this.f6355f = 4 + j2;
                return ((UnsafeUtil.f3(j2 + 3) & 255) << 24) | (UnsafeUtil.f3(j2) & 255) | ((UnsafeUtil.f3(1 + j2) & 255) << 8) | ((UnsafeUtil.f3(2 + j2) & 255) << 16);
            }
            throw InvalidProtocolBufferException.ta();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            long j2 = this.f6355f;
            if (this.f6357i9 - j2 >= 8) {
                this.f6355f = 8 + j2;
                return ((UnsafeUtil.f3(j2 + 7) & 255) << 56) | (UnsafeUtil.f3(j2) & 255) | ((UnsafeUtil.f3(1 + j2) & 255) << 8) | ((UnsafeUtil.f3(2 + j2) & 255) << 16) | ((UnsafeUtil.f3(3 + j2) & 255) << 24) | ((UnsafeUtil.f3(4 + j2) & 255) << 32) | ((UnsafeUtil.f3(5 + j2) & 255) << 40) | ((UnsafeUtil.f3(6 + j2) & 255) << 48);
            }
            throw InvalidProtocolBufferException.ta();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x008c, code lost:
            if (com.google.protobuf.UnsafeUtil.f3(r3) < 0) goto L36;
         */
        @Override // com.google.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int readRawVarint32() throws java.io.IOException {
            /*
                r10 = this;
                long r0 = r10.f6355f
                long r2 = r10.f6357i9
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 != 0) goto La
                goto L8e
            La:
                r2 = 1
                long r2 = r2 + r0
                byte r4 = com.google.protobuf.UnsafeUtil.f3(r0)
                if (r4 < 0) goto L16
                r10.f6355f = r2
                return r4
            L16:
                long r5 = r10.f6357i9
                long r5 = r5 - r2
                r7 = 9
                int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r9 >= 0) goto L21
                goto L8e
            L21:
                r5 = 2
                long r5 = r5 + r0
                byte r2 = com.google.protobuf.UnsafeUtil.f3(r2)
                int r2 = r2 << 7
                r2 = r2 ^ r4
                if (r2 >= 0) goto L31
                r0 = r2 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L98
            L31:
                r3 = 3
                long r3 = r3 + r0
                byte r5 = com.google.protobuf.UnsafeUtil.f3(r5)
                int r5 = r5 << 14
                r2 = r2 ^ r5
                if (r2 < 0) goto L41
                r0 = r2 ^ 16256(0x3f80, float:2.278E-41)
            L3f:
                r5 = r3
                goto L98
            L41:
                r5 = 4
                long r5 = r5 + r0
                byte r3 = com.google.protobuf.UnsafeUtil.f3(r3)
                int r3 = r3 << 21
                r2 = r2 ^ r3
                if (r2 >= 0) goto L52
                r0 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L98
            L52:
                r3 = 5
                long r3 = r3 + r0
                byte r5 = com.google.protobuf.UnsafeUtil.f3(r5)
                int r6 = r5 << 28
                r2 = r2 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r2 = r2 ^ r6
                if (r5 >= 0) goto L96
                r5 = 6
                long r5 = r5 + r0
                byte r3 = com.google.protobuf.UnsafeUtil.f3(r3)
                if (r3 >= 0) goto L94
                r3 = 7
                long r3 = r3 + r0
                byte r5 = com.google.protobuf.UnsafeUtil.f3(r5)
                if (r5 >= 0) goto L96
                r5 = 8
                long r5 = r5 + r0
                byte r3 = com.google.protobuf.UnsafeUtil.f3(r3)
                if (r3 >= 0) goto L94
                long r3 = r0 + r7
                byte r5 = com.google.protobuf.UnsafeUtil.f3(r5)
                if (r5 >= 0) goto L96
                r5 = 10
                long r5 = r5 + r0
                byte r0 = com.google.protobuf.UnsafeUtil.f3(r3)
                if (r0 >= 0) goto L94
            L8e:
                long r0 = r10.fb()
                int r1 = (int) r0
                return r1
            L94:
                r0 = r2
                goto L98
            L96:
                r0 = r2
                goto L3f
            L98:
                r10.f6355f = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.UnsafeDirectNioDecoder.readRawVarint32():int");
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            long j2;
            long j4;
            long j6;
            int i;
            long j7 = this.f6355f;
            if (this.f6357i9 != j7) {
                long j8 = 1 + j7;
                byte f32 = UnsafeUtil.f3(j7);
                if (f32 >= 0) {
                    this.f6355f = j8;
                    return f32;
                } else if (this.f6357i9 - j8 >= 9) {
                    long j9 = 2 + j7;
                    int f33 = (UnsafeUtil.f3(j8) << 7) ^ f32;
                    if (f33 < 0) {
                        i = f33 ^ (-128);
                    } else {
                        long j10 = 3 + j7;
                        int f34 = f33 ^ (UnsafeUtil.f3(j9) << 14);
                        if (f34 >= 0) {
                            j2 = f34 ^ 16256;
                            j9 = j10;
                        } else {
                            j9 = 4 + j7;
                            int f35 = f34 ^ (UnsafeUtil.f3(j10) << 21);
                            if (f35 < 0) {
                                i = (-2080896) ^ f35;
                            } else {
                                long j11 = 5 + j7;
                                long f36 = f35 ^ (UnsafeUtil.f3(j9) << 28);
                                if (f36 >= 0) {
                                    j6 = 266354560;
                                } else {
                                    long j12 = 6 + j7;
                                    long f37 = f36 ^ (UnsafeUtil.f3(j11) << 35);
                                    if (f37 < 0) {
                                        j4 = -34093383808L;
                                    } else {
                                        j11 = 7 + j7;
                                        f36 = f37 ^ (UnsafeUtil.f3(j12) << 42);
                                        if (f36 >= 0) {
                                            j6 = 4363953127296L;
                                        } else {
                                            j12 = 8 + j7;
                                            f37 = f36 ^ (UnsafeUtil.f3(j11) << 49);
                                            if (f37 < 0) {
                                                j4 = -558586000294016L;
                                            } else {
                                                long j13 = j7 + 9;
                                                long f38 = (f37 ^ (UnsafeUtil.f3(j12) << 56)) ^ 71499008037633920L;
                                                if (f38 < 0) {
                                                    long j14 = j7 + 10;
                                                    if (UnsafeUtil.f3(j13) >= 0) {
                                                        j9 = j14;
                                                        j2 = f38;
                                                    }
                                                } else {
                                                    j2 = f38;
                                                    j9 = j13;
                                                }
                                            }
                                        }
                                    }
                                    j2 = j4 ^ f37;
                                    j9 = j12;
                                }
                                j2 = j6 ^ f36;
                                j9 = j11;
                            }
                        }
                        this.f6355f = j9;
                        return j2;
                    }
                    j2 = i;
                    this.f6355f = j9;
                    return j2;
                }
            }
            return fb();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0 && readRawVarint32 <= c5()) {
                byte[] bArr = new byte[readRawVarint32];
                long j2 = readRawVarint32;
                UnsafeUtil.w(this.f6355f, bArr, 0L, j2);
                String str = new String(bArr, Internal.f6450n3);
                this.f6355f += j2;
                return str;
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.p();
                }
                throw InvalidProtocolBufferException.ta();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0 && readRawVarint32 <= c5()) {
                String fb2 = Utf8.fb(this.f6356fb, v(this.f6355f), readRawVarint32);
                this.f6355f += readRawVarint32;
                return fb2;
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 <= 0) {
                    throw InvalidProtocolBufferException.p();
                }
                throw InvalidProtocolBufferException.ta();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.f6362wz = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.f6362wz = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.f6362wz;
            }
            throw InvalidProtocolBufferException.v();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i, MessageLite.Builder builder) throws IOException {
            readGroup(i, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.f6359t = this.f6355f;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                i9();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.y(WireFormat.getTagFieldNumber(i), 4));
                return true;
            } else if (tagWireType != 4) {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.i9();
            } else {
                return false;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag));
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int i) throws IOException {
            if (i >= 0 && i <= c5()) {
                this.f6355f += i;
            } else if (i < 0) {
                throw InvalidProtocolBufferException.p();
            } else {
                throw InvalidProtocolBufferException.ta();
            }
        }

        public final ByteBuffer tl(long j2, long j4) throws IOException {
            int position = this.f6356fb.position();
            int limit = this.f6356fb.limit();
            ByteBuffer byteBuffer = this.f6356fb;
            try {
                try {
                    byteBuffer.position(v(j2));
                    byteBuffer.limit(v(j4));
                    return this.f6356fb.slice();
                } catch (IllegalArgumentException e2) {
                    InvalidProtocolBufferException ta2 = InvalidProtocolBufferException.ta();
                    ta2.initCause(e2);
                    throw ta2;
                }
            } finally {
                byteBuffer.position(position);
                byteBuffer.limit(limit);
            }
        }

        public final int v(long j2) {
            return (int) (j2 - this.f6354c5);
        }

        public UnsafeDirectNioDecoder(ByteBuffer byteBuffer, boolean z2) {
            super();
            this.f6361w = Integer.MAX_VALUE;
            this.f6356fb = byteBuffer;
            long f4 = UnsafeUtil.f(byteBuffer);
            this.f6354c5 = f4;
            this.f6357i9 = byteBuffer.limit() + f4;
            long position = f4 + byteBuffer.position();
            this.f6355f = position;
            this.f6359t = position;
            this.f6358s = z2;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream codedOutputStream) throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag, codedOutputStream));
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.y++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.y(i, 4));
            this.y--;
            return parsePartialFrom;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i);
                skipMessage(codedOutputStream);
                int y = WireFormat.y(WireFormat.getTagFieldNumber(i), 4);
                checkLastTagWas(y);
                codedOutputStream.writeUInt32NoTag(y);
                return true;
            } else if (tagWireType != 4) {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeUInt32NoTag(i);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.i9();
            } else {
                return false;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.y++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.y--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return parsePartialFrom;
            }
            throw InvalidProtocolBufferException.ta();
        }
    }

    public static int decodeZigZag32(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long decodeZigZag64(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    public static CodedInputStream n3(ByteBuffer byteBuffer, boolean z2) {
        if (byteBuffer.hasArray()) {
            return zn(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z2);
        }
        if (byteBuffer.isDirect() && UnsafeDirectNioDecoder.a()) {
            return new UnsafeDirectNioDecoder(byteBuffer, z2);
        }
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.duplicate().get(bArr);
        return zn(bArr, 0, remaining, true);
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return newInstance(inputStream, 4096);
    }

    public static int readRawVarint32(int i, InputStream inputStream) throws IOException {
        if ((i & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
            return i;
        }
        int i5 = i & 127;
        int i6 = 7;
        while (i6 < 32) {
            int read = inputStream.read();
            if (read == -1) {
                throw InvalidProtocolBufferException.ta();
            }
            i5 |= (read & 127) << i6;
            if ((read & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
                return i5;
            }
            i6 += 7;
        }
        while (i6 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.ta();
            }
            if ((read2 & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
                return i5;
            }
            i6 += 7;
        }
        throw InvalidProtocolBufferException.t();
    }

    public static CodedInputStream y(Iterable<ByteBuffer> iterable, boolean z2) {
        boolean z3 = false;
        int i = 0;
        for (ByteBuffer byteBuffer : iterable) {
            i += byteBuffer.remaining();
            if (byteBuffer.hasArray()) {
                z3 |= true;
            } else if (byteBuffer.isDirect()) {
                z3 |= true;
            } else {
                z3 |= true;
            }
        }
        if (z3) {
            return new IterableDirectByteBufferDecoder(iterable, i, z2);
        }
        return newInstance(new IterableByteBufferInputStream(iterable));
    }

    public static CodedInputStream zn(byte[] bArr, int i, int i5, boolean z2) {
        ArrayDecoder arrayDecoder = new ArrayDecoder(bArr, i, i5, z2);
        try {
            arrayDecoder.pushLimit(i5);
            return arrayDecoder;
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public abstract void checkLastTagWas(int i) throws InvalidProtocolBufferException;

    public void checkRecursionLimit() throws InvalidProtocolBufferException {
        if (this.y < this.f6318n3) {
            return;
        }
        throw InvalidProtocolBufferException.co();
    }

    public abstract void enableAliasing(boolean z2);

    public abstract int getBytesUntilLimit();

    public abstract int getLastTag();

    public abstract int getTotalBytesRead();

    public final boolean gv() {
        return this.f6319v;
    }

    public abstract boolean isAtEnd() throws IOException;

    public abstract void popLimit(int i);

    public abstract int pushLimit(int i) throws InvalidProtocolBufferException;

    public abstract boolean readBool() throws IOException;

    public abstract byte[] readByteArray() throws IOException;

    public abstract ByteBuffer readByteBuffer() throws IOException;

    public abstract ByteString readBytes() throws IOException;

    public abstract double readDouble() throws IOException;

    public abstract int readEnum() throws IOException;

    public abstract int readFixed32() throws IOException;

    public abstract long readFixed64() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract int readInt32() throws IOException;

    public abstract long readInt64() throws IOException;

    public abstract <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract byte readRawByte() throws IOException;

    public abstract byte[] readRawBytes(int i) throws IOException;

    public abstract int readRawLittleEndian32() throws IOException;

    public abstract long readRawLittleEndian64() throws IOException;

    public abstract int readRawVarint32() throws IOException;

    public abstract long readRawVarint64() throws IOException;

    public abstract int readSFixed32() throws IOException;

    public abstract long readSFixed64() throws IOException;

    public abstract int readSInt32() throws IOException;

    public abstract long readSInt64() throws IOException;

    public abstract String readString() throws IOException;

    public abstract String readStringRequireUtf8() throws IOException;

    public abstract int readTag() throws IOException;

    public abstract int readUInt32() throws IOException;

    public abstract long readUInt64() throws IOException;

    @Deprecated
    public abstract void readUnknownGroup(int i, MessageLite.Builder builder) throws IOException;

    public abstract void resetSizeCounter();

    public final int setRecursionLimit(int i) {
        if (i >= 0) {
            int i5 = this.f6318n3;
            this.f6318n3 = i;
            return i5;
        }
        throw new IllegalArgumentException("Recursion limit cannot be negative: " + i);
    }

    public final int setSizeLimit(int i) {
        if (i >= 0) {
            int i5 = this.f6320zn;
            this.f6320zn = i;
            return i5;
        }
        throw new IllegalArgumentException("Size limit cannot be negative: " + i);
    }

    public abstract boolean skipField(int i) throws IOException;

    @Deprecated
    public abstract boolean skipField(int i, CodedOutputStream codedOutputStream) throws IOException;

    public abstract void skipMessage() throws IOException;

    public abstract void skipMessage(CodedOutputStream codedOutputStream) throws IOException;

    public abstract void skipRawBytes(int i) throws IOException;

    public CodedInputStream() {
        this.f6318n3 = f6316a;
        this.f6320zn = Integer.MAX_VALUE;
    }

    public static CodedInputStream newInstance(InputStream inputStream, int i) {
        if (i > 0) {
            if (inputStream == null) {
                return newInstance(Internal.EMPTY_BYTE_ARRAY);
            }
            return new StreamDecoder(inputStream, i);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static CodedInputStream newInstance(Iterable<ByteBuffer> iterable) {
        if (!UnsafeDirectNioDecoder.a()) {
            return newInstance(new IterableByteBufferInputStream(iterable));
        }
        return y(iterable, false);
    }

    public static CodedInputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedInputStream newInstance(byte[] bArr, int i, int i5) {
        return zn(bArr, i, i5, false);
    }

    public static CodedInputStream newInstance(ByteBuffer byteBuffer) {
        return n3(byteBuffer, false);
    }
}

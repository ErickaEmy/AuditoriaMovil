package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class RopeByteString extends ByteString {

    /* renamed from: fb  reason: collision with root package name */
    public static final int[] f6508fb = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private static final long serialVersionUID = 1;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    public static ByteString lc(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[size + size2];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return ByteString.o(bArr);
    }

    public static ByteString o4(ByteString byteString, ByteString byteString2) {
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() == 0) {
            return byteString2;
        }
        int size = byteString.size() + byteString2.size();
        if (size < 128) {
            return lc(byteString, byteString2);
        }
        if (byteString instanceof RopeByteString) {
            RopeByteString ropeByteString = (RopeByteString) byteString;
            if (ropeByteString.right.size() + byteString2.size() < 128) {
                return new RopeByteString(ropeByteString.left, lc(ropeByteString.right, byteString2));
            } else if (ropeByteString.left.p() > ropeByteString.right.p() && ropeByteString.p() > byteString2.p()) {
                return new RopeByteString(ropeByteString.left, new RopeByteString(ropeByteString.right, byteString2));
            }
        }
        if (size >= ra(Math.max(byteString.p(), byteString2.p()) + 1)) {
            return new RopeByteString(byteString, byteString2);
        }
        return Balancer.y(new Balancer((1) null), byteString, byteString2);
    }

    public static int ra(int i) {
        int[] iArr = f6508fb;
        if (i >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList arrayList = new ArrayList();
        PieceIterator pieceIterator = new PieceIterator(this, (1) null);
        while (pieceIterator.hasNext()) {
            arrayList.add(pieceIterator.next().asReadOnlyByteBuffer());
        }
        return arrayList;
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int i) {
        ByteString.v(i, this.totalLength);
        return internalByteAt(i);
    }

    @Override // com.google.protobuf.ByteString
    public boolean co() {
        if (this.totalLength >= ra(this.treeDepth)) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        this.left.copyTo(byteBuffer);
        this.right.copyTo(byteBuffer);
    }

    @Override // com.google.protobuf.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.totalLength != byteString.size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        int d2 = d();
        int d3 = byteString.d();
        if (d2 != 0 && d3 != 0 && d2 != d3) {
            return false;
        }
        return nf(byteString);
    }

    @Override // com.google.protobuf.ByteString
    public void i9(byte[] bArr, int i, int i5, int i6) {
        int i8 = i + i6;
        int i10 = this.leftLength;
        if (i8 <= i10) {
            this.left.i9(bArr, i, i5, i6);
        } else if (i >= i10) {
            this.right.i9(bArr, i - i10, i5, i6);
        } else {
            int i11 = i10 - i;
            this.left.i9(bArr, i, i5, i11);
            this.right.i9(bArr, 0, i5 + i11, i6 - i11);
        }
    }

    @Override // com.google.protobuf.ByteString
    public byte internalByteAt(int i) {
        int i5 = this.leftLength;
        if (i < i5) {
            return this.left.internalByteAt(i);
        }
        return this.right.internalByteAt(i - i5);
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        int ta2 = this.left.ta(0, 0, this.leftLength);
        ByteString byteString = this.right;
        if (byteString.ta(ta2, 0, byteString.size()) != 0) {
            return false;
        }
        return true;
    }

    @Override // com.google.protobuf.ByteString
    public void jz(ByteOutput byteOutput) throws IOException {
        this.right.jz(byteOutput);
        this.left.jz(byteOutput);
    }

    @Override // com.google.protobuf.ByteString
    public void k(ByteOutput byteOutput) throws IOException {
        this.left.k(byteOutput);
        this.right.k(byteOutput);
    }

    @Override // com.google.protobuf.ByteString
    public String k5(Charset charset) {
        return new String(toByteArray(), charset);
    }

    @Override // com.google.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.y(asReadOnlyByteBufferList(), true);
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        return new RopeInputStream(this);
    }

    public final boolean nf(ByteString byteString) {
        boolean u2;
        PieceIterator pieceIterator = new PieceIterator(this, (1) null);
        ByteString.LeafByteString leafByteString = (ByteString.LeafByteString) pieceIterator.next();
        PieceIterator pieceIterator2 = new PieceIterator(byteString, (1) null);
        ByteString.LeafByteString leafByteString2 = (ByteString.LeafByteString) pieceIterator2.next();
        int i = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int size = leafByteString.size() - i;
            int size2 = leafByteString2.size() - i5;
            int min = Math.min(size, size2);
            if (i == 0) {
                u2 = leafByteString.u(leafByteString2, i5, min);
            } else {
                u2 = leafByteString2.u(leafByteString, i, min);
            }
            if (!u2) {
                return false;
            }
            i6 += min;
            int i8 = this.totalLength;
            if (i6 >= i8) {
                if (i6 == i8) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == size) {
                i = 0;
                leafByteString = (ByteString.LeafByteString) pieceIterator.next();
            } else {
                i += min;
                leafByteString = leafByteString;
            }
            if (min == size2) {
                leafByteString2 = (ByteString.LeafByteString) pieceIterator2.next();
                i5 = 0;
            } else {
                i5 += min;
            }
        }
    }

    @Override // com.google.protobuf.ByteString
    public int p() {
        return this.treeDepth;
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int i, int i5) {
        int a2 = ByteString.a(i, i5, this.totalLength);
        if (a2 == 0) {
            return ByteString.EMPTY;
        }
        if (a2 == this.totalLength) {
            return this;
        }
        int i6 = this.leftLength;
        if (i5 <= i6) {
            return this.left.substring(i, i5);
        }
        if (i >= i6) {
            return this.right.substring(i - i6, i5 - i6);
        }
        return new RopeByteString(this.left.substring(i), this.right.substring(0, i5 - this.leftLength));
    }

    @Override // com.google.protobuf.ByteString
    public int ta(int i, int i5, int i6) {
        int i8 = i5 + i6;
        int i10 = this.leftLength;
        if (i8 <= i10) {
            return this.left.ta(i, i5, i6);
        }
        if (i5 >= i10) {
            return this.right.ta(i, i5 - i10, i6);
        }
        int i11 = i10 - i5;
        return this.right.ta(this.left.ta(i, i5, i11), 0, i6 - i11);
    }

    public Object writeReplace() {
        return ByteString.o(toByteArray());
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        this.left.writeTo(outputStream);
        this.right.writeTo(outputStream);
    }

    @Override // com.google.protobuf.ByteString
    public int x4(int i, int i5, int i6) {
        int i8 = i5 + i6;
        int i10 = this.leftLength;
        if (i8 <= i10) {
            return this.left.x4(i, i5, i6);
        }
        if (i5 >= i10) {
            return this.right.x4(i, i5 - i10, i6);
        }
        int i11 = i10 - i5;
        return this.right.x4(this.left.x4(i, i5, i11), 0, i6 - i11);
    }

    public RopeByteString(ByteString byteString, ByteString byteString2) {
        this.left = byteString;
        this.right = byteString2;
        int size = byteString.size();
        this.leftLength = size;
        this.totalLength = size + byteString2.size();
        this.treeDepth = Math.max(byteString.p(), byteString2.p()) + 1;
    }

    @Override // com.google.protobuf.ByteString, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<Byte> iterator2() {
        return new 1(this);
    }
}

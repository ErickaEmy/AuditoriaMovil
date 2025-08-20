package com.google.protobuf;

import androidx.core.app.NotificationCompat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
@CheckReturnValue
/* loaded from: classes.dex */
public abstract class ByteString implements Iterable<Byte>, Serializable {
    public static final ByteString EMPTY = new LiteralByteString(Internal.EMPTY_BYTE_ARRAY);
    private static final long serialVersionUID = 1;

    /* renamed from: v  reason: collision with root package name */
    public static final Comparator<ByteString> f6307v;
    public static final ByteArrayCopier y;
    private int hash;

    /* loaded from: classes.dex */
    public static abstract class AbstractByteIterator implements ByteIterator {
        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public final Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    /* loaded from: classes.dex */
    public static final class ArraysByteArrayCopier implements ByteArrayCopier {
        public ArraysByteArrayCopier() {
        }

        @Override // com.google.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] bArr, int i, int i5) {
            return Arrays.copyOfRange(bArr, i, i5 + i);
        }
    }

    /* loaded from: classes.dex */
    public static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        public BoundedByteString(byte[] bArr, int i, int i5) {
            super(bArr);
            ByteString.a(i, i + i5, bArr.length);
            this.bytesOffset = i;
            this.bytesLength = i5;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public byte byteAt(int i) {
            ByteString.v(i, size());
            return this.bytes[this.bytesOffset + i];
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString
        public int dm() {
            return this.bytesOffset;
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public void i9(byte[] bArr, int i, int i5, int i6) {
            System.arraycopy(this.bytes, dm() + i, bArr, i5, i6);
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public byte internalByteAt(int i) {
            return this.bytes[this.bytesOffset + i];
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public int size() {
            return this.bytesLength;
        }

        public Object writeReplace() {
            return ByteString.o(toByteArray());
        }
    }

    /* loaded from: classes.dex */
    public interface ByteArrayCopier {
        byte[] copyFrom(byte[] bArr, int i, int i5);
    }

    /* loaded from: classes.dex */
    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    /* loaded from: classes.dex */
    public static final class CodedBuilder {

        /* renamed from: n3  reason: collision with root package name */
        public final byte[] f6310n3;
        public final CodedOutputStream y;

        public ByteString build() {
            this.y.checkNoSpaceLeft();
            return new LiteralByteString(this.f6310n3);
        }

        public CodedOutputStream getCodedOutput() {
            return this.y;
        }

        public CodedBuilder(int i) {
            byte[] bArr = new byte[i];
            this.f6310n3 = bArr;
            this.y = CodedOutputStream.newInstance(bArr);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class LeafByteString extends ByteString {
        private static final long serialVersionUID = 1;

        @Override // com.google.protobuf.ByteString
        public final boolean co() {
            return true;
        }

        @Override // com.google.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator2();
        }

        @Override // com.google.protobuf.ByteString
        public void jz(ByteOutput byteOutput) throws IOException {
            k(byteOutput);
        }

        @Override // com.google.protobuf.ByteString
        public final int p() {
            return 0;
        }

        public abstract boolean u(ByteString byteString, int i, int i5);
    }

    /* loaded from: classes.dex */
    public static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        public LiteralByteString(byte[] bArr) {
            bArr.getClass();
            this.bytes = bArr;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, dm(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.protobuf.ByteString
        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // com.google.protobuf.ByteString
        public byte byteAt(int i) {
            return this.bytes[i];
        }

        @Override // com.google.protobuf.ByteString
        public final void copyTo(ByteBuffer byteBuffer) {
            byteBuffer.put(this.bytes, dm(), size());
        }

        public int dm() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (obj instanceof LiteralByteString) {
                LiteralByteString literalByteString = (LiteralByteString) obj;
                int d2 = d();
                int d3 = literalByteString.d();
                if (d2 != 0 && d3 != 0 && d2 != d3) {
                    return false;
                }
                return u(literalByteString, 0, size());
            }
            return obj.equals(this);
        }

        @Override // com.google.protobuf.ByteString
        public void i9(byte[] bArr, int i, int i5, int i6) {
            System.arraycopy(this.bytes, i, bArr, i5, i6);
        }

        @Override // com.google.protobuf.ByteString
        public byte internalByteAt(int i) {
            return this.bytes[i];
        }

        @Override // com.google.protobuf.ByteString
        public final boolean isValidUtf8() {
            int dm2 = dm();
            return Utf8.r(this.bytes, dm2, size() + dm2);
        }

        @Override // com.google.protobuf.ByteString
        public final void k(ByteOutput byteOutput) throws IOException {
            byteOutput.writeLazy(this.bytes, dm(), size());
        }

        @Override // com.google.protobuf.ByteString
        public final String k5(Charset charset) {
            return new String(this.bytes, dm(), size(), charset);
        }

        @Override // com.google.protobuf.ByteString
        public final CodedInputStream newCodedInput() {
            return CodedInputStream.zn(this.bytes, dm(), size(), true);
        }

        @Override // com.google.protobuf.ByteString
        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, dm(), size());
        }

        @Override // com.google.protobuf.ByteString
        public int size() {
            return this.bytes.length;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteString substring(int i, int i5) {
            int a2 = ByteString.a(i, i5, size());
            if (a2 == 0) {
                return ByteString.EMPTY;
            }
            return new BoundedByteString(this.bytes, dm() + i, a2);
        }

        @Override // com.google.protobuf.ByteString
        public final int ta(int i, int i5, int i6) {
            int dm2 = dm() + i5;
            return Utf8.i4(i, this.bytes, dm2, i6 + dm2);
        }

        @Override // com.google.protobuf.ByteString.LeafByteString
        public final boolean u(ByteString byteString, int i, int i5) {
            if (i5 <= byteString.size()) {
                int i6 = i + i5;
                if (i6 <= byteString.size()) {
                    if (byteString instanceof LiteralByteString) {
                        LiteralByteString literalByteString = (LiteralByteString) byteString;
                        byte[] bArr = this.bytes;
                        byte[] bArr2 = literalByteString.bytes;
                        int dm2 = dm() + i5;
                        int dm3 = dm();
                        int dm4 = literalByteString.dm() + i;
                        while (dm3 < dm2) {
                            if (bArr[dm3] != bArr2[dm4]) {
                                return false;
                            }
                            dm3++;
                            dm4++;
                        }
                        return true;
                    }
                    return byteString.substring(i, i6).equals(substring(0, i5));
                }
                throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i5 + ", " + byteString.size());
            }
            throw new IllegalArgumentException("Length too large: " + i5 + size());
        }

        @Override // com.google.protobuf.ByteString
        public final void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(toByteArray());
        }

        @Override // com.google.protobuf.ByteString
        public final int x4(int i, int i5, int i6) {
            return Internal.v(i, this.bytes, dm() + i5, i6);
        }
    }

    /* loaded from: classes.dex */
    public static final class SystemByteArrayCopier implements ByteArrayCopier {
        public SystemByteArrayCopier() {
        }

        @Override // com.google.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] bArr, int i, int i5) {
            byte[] bArr2 = new byte[i5];
            System.arraycopy(bArr, i, bArr2, 0, i5);
            return bArr2;
        }
    }

    static {
        ByteArrayCopier arraysByteArrayCopier;
        if (Android.zn()) {
            arraysByteArrayCopier = new SystemByteArrayCopier();
        } else {
            arraysByteArrayCopier = new ArraysByteArrayCopier();
        }
        y = arraysByteArrayCopier;
        f6307v = new Comparator<ByteString>() { // from class: com.google.protobuf.ByteString.2
            /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Iterator, com.google.protobuf.ByteString$ByteIterator] */
            /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Iterator, com.google.protobuf.ByteString$ByteIterator] */
            @Override // java.util.Comparator
            public int compare(ByteString byteString, ByteString byteString2) {
                ?? iterator2 = byteString.iterator2();
                ?? iterator22 = byteString2.iterator2();
                while (iterator2.hasNext() && iterator22.hasNext()) {
                    int compareTo = Integer.valueOf(ByteString.b(iterator2.nextByte())).compareTo(Integer.valueOf(ByteString.b(iterator22.nextByte())));
                    if (compareTo != 0) {
                        return compareTo;
                    }
                }
                return Integer.valueOf(byteString.size()).compareTo(Integer.valueOf(byteString2.size()));
            }
        };
    }

    @CanIgnoreReturnValue
    public static int a(int i, int i5, int i6) {
        int i8 = i5 - i;
        if ((i | i5 | i8 | (i6 - i5)) < 0) {
            if (i >= 0) {
                if (i5 < i) {
                    throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i5);
                }
                throw new IndexOutOfBoundsException("End index: " + i5 + " >= " + i6);
            }
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        return i8;
    }

    public static int b(byte b2) {
        return b2 & 255;
    }

    public static ByteString copyFrom(byte[] bArr, int i, int i5) {
        a(i, i + i5, bArr.length);
        return new LiteralByteString(y.copyFrom(bArr, i, i5));
    }

    public static ByteString copyFromUtf8(String str) {
        return new LiteralByteString(str.getBytes(Internal.f6450n3));
    }

    public static final ByteString empty() {
        return EMPTY;
    }

    public static ByteString fromHex(@CompileTimeConstant String str) {
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i5 = i * 2;
                bArr[i] = (byte) (t(str, i5 + 1) | (t(str, i5) << 4));
            }
            return new LiteralByteString(bArr);
        }
        throw new NumberFormatException("Invalid hexString " + str + " of length " + str.length() + " must be even.");
    }

    public static ByteString gv(Iterator<ByteString> it, int i) {
        if (i >= 1) {
            if (i == 1) {
                return it.next();
            }
            int i5 = i >>> 1;
            return gv(it, i5).concat(gv(it, i - i5));
        }
        throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i)));
    }

    public static ByteString j(byte[] bArr, int i, int i5) {
        return new BoundedByteString(bArr, i, i5);
    }

    public static ByteString j5(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return j(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
        }
        return new NioByteString(byteBuffer);
    }

    public static int mt(char c2) {
        if (c2 < '0' || c2 > '9') {
            if (c2 < 'A' || c2 > 'F') {
                if (c2 < 'a' || c2 > 'f') {
                    return -1;
                }
                return c2 - 'W';
            }
            return c2 - '7';
        }
        return c2 - '0';
    }

    public static Output newOutput(int i) {
        return new Output(i);
    }

    public static ByteString o(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    public static CodedBuilder r(int i) {
        return new CodedBuilder(i);
    }

    public static ByteString readFrom(InputStream inputStream) throws IOException {
        return readFrom(inputStream, 256, 8192);
    }

    public static int t(String str, int i) {
        int mt2 = mt(str.charAt(i));
        if (mt2 != -1) {
            return mt2;
        }
        throw new NumberFormatException("Invalid hexString " + str + " must only contain [0-9a-fA-F] but contained " + str.charAt(i) + " at index " + i);
    }

    public static ByteString ud(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i5 = 0;
        while (i5 < i) {
            int read = inputStream.read(bArr, i5, i - i5);
            if (read == -1) {
                break;
            }
            i5 += read;
        }
        if (i5 == 0) {
            return null;
        }
        return copyFrom(bArr, 0, i5);
    }

    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return f6307v;
    }

    public static void v(int i, int i5) {
        if (((i5 - (i + 1)) | i) < 0) {
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i5);
        }
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int i);

    public abstract boolean co();

    public final ByteString concat(ByteString byteString) {
        if (Integer.MAX_VALUE - size() >= byteString.size()) {
            return RopeByteString.o4(this, byteString);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + byteString.size());
    }

    public abstract void copyTo(ByteBuffer byteBuffer);

    public void copyTo(byte[] bArr, int i) {
        copyTo(bArr, 0, i, size());
    }

    public final int d() {
        return this.hash;
    }

    public final boolean endsWith(ByteString byteString) {
        if (size() >= byteString.size() && substring(size() - byteString.size()).equals(byteString)) {
            return true;
        }
        return false;
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.hash;
        if (i == 0) {
            int size = size();
            i = x4(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.hash = i;
        }
        return i;
    }

    public abstract void i9(byte[] bArr, int i, int i5, int i6);

    public abstract byte internalByteAt(int i);

    public final boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public abstract boolean isValidUtf8();

    public abstract void jz(ByteOutput byteOutput) throws IOException;

    public abstract void k(ByteOutput byteOutput) throws IOException;

    public abstract String k5(Charset charset);

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    public abstract int p();

    public abstract int size();

    public final boolean startsWith(ByteString byteString) {
        if (size() < byteString.size() || !substring(0, byteString.size()).equals(byteString)) {
            return false;
        }
        return true;
    }

    public final ByteString substring(int i) {
        return substring(i, size());
    }

    public abstract ByteString substring(int i, int i5);

    public abstract int ta(int i, int i5, int i6);

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        i9(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString(String str) throws UnsupportedEncodingException {
        try {
            return toString(Charset.forName(str));
        } catch (UnsupportedCharsetException e2) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(str);
            unsupportedEncodingException.initCause(e2);
            throw unsupportedEncodingException;
        }
    }

    public final String toStringUtf8() {
        return toString(Internal.f6450n3);
    }

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    public abstract int x4(int i, int i5, int i6);

    public final String yt() {
        if (size() <= 50) {
            return TextFormatEscaper.y(this);
        }
        return TextFormatEscaper.y(substring(0, 47)) + "...";
    }

    public static Output newOutput() {
        return new Output(NotificationCompat.FLAG_HIGH_PRIORITY);
    }

    public static ByteString readFrom(InputStream inputStream, int i) throws IOException {
        return readFrom(inputStream, i, i);
    }

    @Deprecated
    public final void copyTo(byte[] bArr, int i, int i5, int i6) {
        a(i, i + i6, size());
        a(i5, i5 + i6, bArr.length);
        if (i6 > 0) {
            i9(bArr, i, i5, i6);
        }
    }

    @Override // java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<Byte> iterator2() {
        return new AbstractByteIterator() { // from class: com.google.protobuf.ByteString.1

            /* renamed from: v  reason: collision with root package name */
            public final int f6309v;
            public int y;

            {
                this.f6309v = ByteString.this.size();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.y < this.f6309v) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.ByteString.ByteIterator
            public byte nextByte() {
                int i = this.y;
                if (i < this.f6309v) {
                    this.y = i + 1;
                    return ByteString.this.internalByteAt(i);
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static ByteString readFrom(InputStream inputStream, int i, int i5) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            ByteString ud2 = ud(inputStream, i);
            if (ud2 == null) {
                return copyFrom(arrayList);
            }
            arrayList.add(ud2);
            i = Math.min(i * 2, i5);
        }
    }

    /* loaded from: classes.dex */
    public static final class Output extends OutputStream {

        /* renamed from: t  reason: collision with root package name */
        public static final byte[] f6311t = new byte[0];

        /* renamed from: f  reason: collision with root package name */
        public int f6312f;

        /* renamed from: fb  reason: collision with root package name */
        public int f6313fb;

        /* renamed from: s  reason: collision with root package name */
        public byte[] f6314s;

        /* renamed from: v  reason: collision with root package name */
        public final ArrayList<ByteString> f6315v;
        public final int y;

        public Output(int i) {
            if (i >= 0) {
                this.y = i;
                this.f6315v = new ArrayList<>();
                this.f6314s = new byte[i];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        public synchronized void reset() {
            this.f6315v.clear();
            this.f6313fb = 0;
            this.f6312f = 0;
        }

        public synchronized int size() {
            return this.f6313fb + this.f6312f;
        }

        public synchronized ByteString toByteString() {
            v();
            return ByteString.copyFrom(this.f6315v);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
        }

        public final void v() {
            int i = this.f6312f;
            byte[] bArr = this.f6314s;
            if (i < bArr.length) {
                if (i > 0) {
                    this.f6315v.add(new LiteralByteString(Arrays.copyOf(bArr, i)));
                }
            } else {
                this.f6315v.add(new LiteralByteString(this.f6314s));
                this.f6314s = f6311t;
            }
            this.f6313fb += this.f6312f;
            this.f6312f = 0;
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i) {
            try {
                if (this.f6312f == this.f6314s.length) {
                    y(1);
                }
                byte[] bArr = this.f6314s;
                int i5 = this.f6312f;
                this.f6312f = i5 + 1;
                bArr[i5] = (byte) i;
            } catch (Throwable th) {
                throw th;
            }
        }

        public void writeTo(OutputStream outputStream) throws IOException {
            int i;
            ByteString[] byteStringArr;
            byte[] bArr;
            int i5;
            synchronized (this) {
                byteStringArr = (ByteString[]) this.f6315v.toArray(new ByteString[0]);
                bArr = this.f6314s;
                i5 = this.f6312f;
            }
            for (ByteString byteString : byteStringArr) {
                byteString.writeTo(outputStream);
            }
            outputStream.write(Arrays.copyOf(bArr, i5));
        }

        public final void y(int i) {
            this.f6315v.add(new LiteralByteString(this.f6314s));
            int length = this.f6313fb + this.f6314s.length;
            this.f6313fb = length;
            this.f6314s = new byte[Math.max(this.y, Math.max(i, length >>> 1))];
            this.f6312f = 0;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i, int i5) {
            try {
                byte[] bArr2 = this.f6314s;
                int length = bArr2.length;
                int i6 = this.f6312f;
                if (i5 <= length - i6) {
                    System.arraycopy(bArr, i, bArr2, i6, i5);
                    this.f6312f += i5;
                } else {
                    int length2 = bArr2.length - i6;
                    System.arraycopy(bArr, i, bArr2, i6, length2);
                    int i8 = i5 - length2;
                    y(i8);
                    System.arraycopy(bArr, i + length2, this.f6314s, 0, i8);
                    this.f6312f = i8;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer, int i) {
        a(0, i, byteBuffer.remaining());
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return new LiteralByteString(bArr);
    }

    public final String toString(Charset charset) {
        return size() == 0 ? "" : k5(charset);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), yt());
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer) {
        return copyFrom(byteBuffer, byteBuffer.remaining());
    }

    public static ByteString copyFrom(String str, String str2) throws UnsupportedEncodingException {
        return new LiteralByteString(str.getBytes(str2));
    }

    public static ByteString copyFrom(String str, Charset charset) {
        return new LiteralByteString(str.getBytes(charset));
    }

    public static ByteString copyFrom(Iterable<ByteString> iterable) {
        int size;
        if (!(iterable instanceof Collection)) {
            Iterator<ByteString> it = iterable.iterator();
            size = 0;
            while (it.hasNext()) {
                it.next();
                size++;
            }
        } else {
            size = ((Collection) iterable).size();
        }
        if (size == 0) {
            return EMPTY;
        }
        return gv(iterable.iterator(), size);
    }
}

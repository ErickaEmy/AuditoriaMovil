package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class NioByteString extends ByteString.LeafByteString {
    private final ByteBuffer buffer;

    public NioByteString(ByteBuffer byteBuffer) {
        Internal.n3(byteBuffer, "buffer");
        this.buffer = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    private Object writeReplace() {
        return ByteString.copyFrom(this.buffer.slice());
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int i) {
        try {
            return this.buffer.get(i);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new ArrayIndexOutOfBoundsException(e3.getMessage());
        }
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.buffer.slice());
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
        if (size() != byteString.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof NioByteString) {
            return this.buffer.equals(((NioByteString) obj).buffer);
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        return this.buffer.equals(byteString.asReadOnlyByteBuffer());
    }

    @Override // com.google.protobuf.ByteString
    public void i9(byte[] bArr, int i, int i5, int i6) {
        ByteBuffer slice = this.buffer.slice();
        Java8Compatibility.gv(slice, i);
        slice.get(bArr, i5, i6);
    }

    @Override // com.google.protobuf.ByteString
    public byte internalByteAt(int i) {
        return byteAt(i);
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        return Utf8.co(this.buffer);
    }

    @Override // com.google.protobuf.ByteString
    public void k(ByteOutput byteOutput) throws IOException {
        byteOutput.writeLazy(this.buffer.slice());
    }

    @Override // com.google.protobuf.ByteString
    public String k5(Charset charset) {
        byte[] byteArray;
        int length;
        int i;
        if (this.buffer.hasArray()) {
            byteArray = this.buffer.array();
            i = this.buffer.arrayOffset() + this.buffer.position();
            length = this.buffer.remaining();
        } else {
            byteArray = toByteArray();
            length = byteArray.length;
            i = 0;
        }
        return new String(byteArray, i, length, charset);
    }

    @Override // com.google.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.n3(this.buffer, true);
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        return new 1(this);
    }

    public final ByteBuffer o4(int i, int i5) {
        if (i >= this.buffer.position() && i5 <= this.buffer.limit() && i <= i5) {
            ByteBuffer slice = this.buffer.slice();
            Java8Compatibility.gv(slice, i - this.buffer.position());
            Java8Compatibility.n3(slice, i5 - this.buffer.position());
            return slice;
        }
        throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", Integer.valueOf(i), Integer.valueOf(i5)));
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.buffer.remaining();
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int i, int i5) {
        try {
            return new NioByteString(o4(i, i5));
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new ArrayIndexOutOfBoundsException(e3.getMessage());
        }
    }

    @Override // com.google.protobuf.ByteString
    public int ta(int i, int i5, int i6) {
        return Utf8.x4(i, this.buffer, i5, i6 + i5);
    }

    @Override // com.google.protobuf.ByteString.LeafByteString
    public boolean u(ByteString byteString, int i, int i5) {
        return substring(0, i5).equals(byteString.substring(i, i5 + i));
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(toByteArray());
    }

    @Override // com.google.protobuf.ByteString
    public int x4(int i, int i5, int i6) {
        for (int i8 = i5; i8 < i5 + i6; i8++) {
            i = (i * 31) + this.buffer.get(i8);
        }
        return i;
    }
}

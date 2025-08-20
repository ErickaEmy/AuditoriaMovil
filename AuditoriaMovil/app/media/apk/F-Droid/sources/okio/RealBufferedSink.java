package okio;

import ch.qos.logback.core.CoreConstants;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RealBufferedSink.kt */
/* loaded from: classes2.dex */
public final class RealBufferedSink implements BufferedSink {
    public final Buffer bufferField;
    public boolean closed;
    public final Sink sink;

    @Override // okio.BufferedSink
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.Sink
    public void write(Buffer source, long j) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.write(source, j);
        emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public BufferedSink write(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.write(byteString);
        return emitCompleteSegments();
    }

    public RealBufferedSink(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.sink = sink;
        this.bufferField = new Buffer();
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeUtf8(string);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.write(source);
        return emitCompleteSegments();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        int write = this.bufferField.write(source);
        emitCompleteSegments();
        return write;
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.write(source, i, i2);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j = 0;
        while (true) {
            long read = source.read(this.bufferField, 8192L);
            if (read == -1) {
                return j;
            }
            j += read;
            emitCompleteSegments();
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink writeByte(int i) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeByte(i);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShort(int i) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeShort(i);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public BufferedSink writeInt(int i) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeInt(i);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public BufferedSink writeHexadecimalUnsignedLong(long j) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeHexadecimalUnsignedLong(j);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public BufferedSink emitCompleteSegments() {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long completeSegmentByteCount = this.bufferField.completeSegmentByteCount();
        if (completeSegmentByteCount > 0) {
            this.sink.write(this.bufferField, completeSegmentByteCount);
        }
        return this;
    }

    @Override // okio.BufferedSink
    public BufferedSink emit() {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long size = this.bufferField.size();
        if (size > 0) {
            this.sink.write(this.bufferField, size);
        }
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.bufferField.size() > 0) {
            Sink sink = this.sink;
            Buffer buffer = this.bufferField;
            sink.write(buffer, buffer.size());
        }
        this.sink.flush();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        try {
            if (this.bufferField.size() > 0) {
                Sink sink = this.sink;
                Buffer buffer = this.bufferField;
                sink.write(buffer, buffer.size());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.sink.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "buffer(" + this.sink + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}

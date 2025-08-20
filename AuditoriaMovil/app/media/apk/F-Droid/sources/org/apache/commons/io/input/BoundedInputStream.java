package org.apache.commons.io.input;

import java.io.InputStream;
/* loaded from: classes2.dex */
public class BoundedInputStream extends InputStream {
    private final InputStream in;
    private final long max;
    private long pos = 0;
    private long mark = -1;
    private boolean propagateClose = true;

    public void setPropagateClose(boolean z) {
        this.propagateClose = z;
    }

    public BoundedInputStream(InputStream inputStream, long j) {
        this.max = j;
        this.in = inputStream;
    }

    @Override // java.io.InputStream
    public int read() {
        long j = this.max;
        if (j < 0 || this.pos < j) {
            int read = this.in.read();
            this.pos++;
            return read;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        long j = this.max;
        if (j < 0 || this.pos < j) {
            int read = this.in.read(bArr, i, (int) (j >= 0 ? Math.min(i2, j - this.pos) : i2));
            if (read == -1) {
                return -1;
            }
            this.pos += read;
            return read;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        long j2 = this.max;
        if (j2 >= 0) {
            j = Math.min(j, j2 - this.pos);
        }
        long skip = this.in.skip(j);
        this.pos += skip;
        return skip;
    }

    @Override // java.io.InputStream
    public int available() {
        long j = this.max;
        if (j < 0 || this.pos < j) {
            return this.in.available();
        }
        return 0;
    }

    public String toString() {
        return this.in.toString();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.propagateClose) {
            this.in.close();
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.in.reset();
        this.pos = this.mark;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.in.mark(i);
        this.mark = this.pos;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.in.markSupported();
    }
}

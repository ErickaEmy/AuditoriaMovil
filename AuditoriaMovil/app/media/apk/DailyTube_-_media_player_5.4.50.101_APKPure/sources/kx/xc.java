package kx;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public final class xc extends InputStream {

    /* renamed from: f  reason: collision with root package name */
    public boolean f10157f;

    /* renamed from: fb  reason: collision with root package name */
    public final byte[] f10158fb = new byte[1];

    /* renamed from: s  reason: collision with root package name */
    public boolean f10159s;

    /* renamed from: t  reason: collision with root package name */
    public long f10160t;

    /* renamed from: v  reason: collision with root package name */
    public final p f10161v;
    public final tl y;

    public xc(tl tlVar, p pVar) {
        this.y = tlVar;
        this.f10161v = pVar;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f10157f) {
            this.y.close();
            this.f10157f = true;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f10158fb) == -1) {
            return -1;
        }
        return this.f10158fb[0] & 255;
    }

    public void v() throws IOException {
        y();
    }

    public final void y() throws IOException {
        if (!this.f10159s) {
            this.y.y(this.f10161v);
            this.f10159s = true;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i5) throws IOException {
        v5.y.fb(!this.f10157f);
        y();
        int read = this.y.read(bArr, i, i5);
        if (read == -1) {
            return -1;
        }
        this.f10160t += read;
        return read;
    }
}

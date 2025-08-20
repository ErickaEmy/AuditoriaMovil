package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: assets/audience_network.dex */
public final class PF extends InputStream {
    public int A00;
    public long A01;
    public InterfaceC0667Gu A02;
    public final Uri A03;
    public final C1115Ym A04;
    public final InterfaceC0666Gt A05;
    public final String A06;

    public PF(C1115Ym c1115Ym, Uri uri, InterfaceC0666Gt interfaceC0666Gt) throws IOException {
        this.A04 = c1115Ym;
        this.A05 = interfaceC0666Gt;
        this.A03 = uri;
        this.A06 = R0.A08(c1115Ym, uri);
        A00(0);
    }

    private void A00(int i) throws IOException {
        InterfaceC0667Gu interfaceC0667Gu = this.A02;
        if (interfaceC0667Gu != null) {
            interfaceC0667Gu.close();
        }
        this.A02 = this.A05.A4X();
        this.A01 = (int) this.A02.ADl(new C0671Gy(this.A03, i, -1L, this.A06));
    }

    @Override // java.io.InputStream
    public final int available() {
        return ((int) this.A01) - this.A00;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.A02.close();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        byte[] b2 = new byte[1];
        return read(b2);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i5) throws IOException {
        int read = this.A02.read(bArr, i, i5);
        int read2 = this.A00;
        this.A00 = read2 + read;
        return read;
    }

    @Override // java.io.InputStream
    public final long skip(long j2) throws IOException {
        long j4 = this.A01;
        int i = this.A00;
        long skipped = j4 - i;
        if (skipped <= 0) {
            return 0L;
        }
        if (j2 > skipped) {
            j2 = skipped;
        }
        int i5 = (int) (i + j2);
        this.A00 = i5;
        A00(i5);
        return j2;
    }
}

package e4;

import java.io.IOException;
/* loaded from: classes.dex */
public class i4 implements tl {
    public final tl y;

    public i4(tl tlVar) {
        this.y = tlVar;
    }

    @Override // e4.tl
    public boolean co(int i, boolean z2) throws IOException {
        return this.y.co(i, z2);
    }

    @Override // e4.tl
    public boolean f(byte[] bArr, int i, int i5, boolean z2) throws IOException {
        return this.y.f(bArr, i, i5, z2);
    }

    @Override // e4.tl
    public long getLength() {
        return this.y.getLength();
    }

    @Override // e4.tl
    public long getPosition() {
        return this.y.getPosition();
    }

    @Override // e4.tl
    public void p(int i) throws IOException {
        this.y.p(i);
    }

    @Override // e4.tl, kx.c5
    public int read(byte[] bArr, int i, int i5) throws IOException {
        return this.y.read(bArr, i, i5);
    }

    @Override // e4.tl
    public void readFully(byte[] bArr, int i, int i5) throws IOException {
        this.y.readFully(bArr, i, i5);
    }

    @Override // e4.tl
    public void s() {
        this.y.s();
    }

    @Override // e4.tl
    public long t() {
        return this.y.t();
    }

    @Override // e4.tl
    public boolean v(byte[] bArr, int i, int i5, boolean z2) throws IOException {
        return this.y.v(bArr, i, i5, z2);
    }

    @Override // e4.tl
    public int w(byte[] bArr, int i, int i5) throws IOException {
        return this.y.w(bArr, i, i5);
    }

    @Override // e4.tl
    public void wz(int i) throws IOException {
        this.y.wz(i);
    }

    @Override // e4.tl
    public int xc(int i) throws IOException {
        return this.y.xc(i);
    }

    @Override // e4.tl
    public void z(byte[] bArr, int i, int i5) throws IOException {
        this.y.z(bArr, i, i5);
    }
}

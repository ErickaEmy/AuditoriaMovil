package e4;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import m1.kp;
import v5.j5;
/* loaded from: classes.dex */
public final class a implements tl {

    /* renamed from: a  reason: collision with root package name */
    public int f7450a;

    /* renamed from: fb  reason: collision with root package name */
    public int f7451fb;

    /* renamed from: gv  reason: collision with root package name */
    public long f7452gv;

    /* renamed from: n3  reason: collision with root package name */
    public final kx.c5 f7453n3;

    /* renamed from: v  reason: collision with root package name */
    public byte[] f7454v = new byte[65536];
    public final byte[] y = new byte[4096];

    /* renamed from: zn  reason: collision with root package name */
    public final long f7455zn;

    static {
        kp.y("goog.exo.extractor");
    }

    public a(kx.c5 c5Var, long j2, long j4) {
        this.f7453n3 = c5Var;
        this.f7452gv = j2;
        this.f7455zn = j4;
    }

    public final void a(int i) {
        if (i != -1) {
            this.f7452gv += i;
        }
    }

    public final void c5(int i) {
        int i5 = this.f7450a + i;
        byte[] bArr = this.f7454v;
        if (i5 > bArr.length) {
            this.f7454v = Arrays.copyOf(this.f7454v, j5.p(bArr.length * 2, 65536 + i5, i5 + 524288));
        }
    }

    @Override // e4.tl
    public boolean co(int i, boolean z2) throws IOException {
        c5(i);
        int i5 = this.f7451fb - this.f7450a;
        while (i5 < i) {
            i5 = r(this.f7454v, this.f7450a, i, i5, z2);
            if (i5 == -1) {
                return false;
            }
            this.f7451fb = this.f7450a + i5;
        }
        this.f7450a += i;
        return true;
    }

    @Override // e4.tl
    public boolean f(byte[] bArr, int i, int i5, boolean z2) throws IOException {
        int mt2 = mt(bArr, i, i5);
        while (mt2 < i5 && mt2 != -1) {
            mt2 = r(bArr, i, i5, mt2, z2);
        }
        a(mt2);
        if (mt2 != -1) {
            return true;
        }
        return false;
    }

    public final void f3(int i) {
        byte[] bArr;
        int i5 = this.f7451fb - i;
        this.f7451fb = i5;
        this.f7450a = 0;
        byte[] bArr2 = this.f7454v;
        if (i5 < bArr2.length - 524288) {
            bArr = new byte[65536 + i5];
        } else {
            bArr = bArr2;
        }
        System.arraycopy(bArr2, i, bArr, 0, i5);
        this.f7454v = bArr;
    }

    @Override // e4.tl
    public long getLength() {
        return this.f7455zn;
    }

    @Override // e4.tl
    public long getPosition() {
        return this.f7452gv;
    }

    public boolean i4(int i, boolean z2) throws IOException {
        int x42 = x4(i);
        while (x42 < i && x42 != -1) {
            x42 = r(this.y, -x42, Math.min(i, this.y.length + x42), x42, z2);
        }
        a(x42);
        if (x42 != -1) {
            return true;
        }
        return false;
    }

    public final int mt(byte[] bArr, int i, int i5) {
        int i6 = this.f7451fb;
        if (i6 == 0) {
            return 0;
        }
        int min = Math.min(i6, i5);
        System.arraycopy(this.f7454v, 0, bArr, i, min);
        f3(min);
        return min;
    }

    @Override // e4.tl
    public void p(int i) throws IOException {
        i4(i, false);
    }

    public final int r(byte[] bArr, int i, int i5, int i6, boolean z2) throws IOException {
        if (!Thread.interrupted()) {
            int read = this.f7453n3.read(bArr, i + i6, i5 - i6);
            if (read == -1) {
                if (i6 == 0 && z2) {
                    return -1;
                }
                throw new EOFException();
            }
            return i6 + read;
        }
        throw new InterruptedIOException();
    }

    @Override // e4.tl, kx.c5
    public int read(byte[] bArr, int i, int i5) throws IOException {
        int mt2 = mt(bArr, i, i5);
        if (mt2 == 0) {
            mt2 = r(bArr, i, i5, 0, true);
        }
        a(mt2);
        return mt2;
    }

    @Override // e4.tl
    public void readFully(byte[] bArr, int i, int i5) throws IOException {
        f(bArr, i, i5, false);
    }

    @Override // e4.tl
    public void s() {
        this.f7450a = 0;
    }

    @Override // e4.tl
    public long t() {
        return this.f7452gv + this.f7450a;
    }

    @Override // e4.tl
    public boolean v(byte[] bArr, int i, int i5, boolean z2) throws IOException {
        if (!co(i5, z2)) {
            return false;
        }
        System.arraycopy(this.f7454v, this.f7450a - i5, bArr, i, i5);
        return true;
    }

    @Override // e4.tl
    public int w(byte[] bArr, int i, int i5) throws IOException {
        int min;
        c5(i5);
        int i6 = this.f7451fb;
        int i8 = this.f7450a;
        int i10 = i6 - i8;
        if (i10 == 0) {
            min = r(this.f7454v, i8, i5, 0, true);
            if (min == -1) {
                return -1;
            }
            this.f7451fb += min;
        } else {
            min = Math.min(i5, i10);
        }
        System.arraycopy(this.f7454v, this.f7450a, bArr, i, min);
        this.f7450a += min;
        return min;
    }

    @Override // e4.tl
    public void wz(int i) throws IOException {
        co(i, false);
    }

    public final int x4(int i) {
        int min = Math.min(this.f7451fb, i);
        f3(min);
        return min;
    }

    @Override // e4.tl
    public int xc(int i) throws IOException {
        int x42 = x4(i);
        if (x42 == 0) {
            byte[] bArr = this.y;
            x42 = r(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        a(x42);
        return x42;
    }

    @Override // e4.tl
    public void z(byte[] bArr, int i, int i5) throws IOException {
        v(bArr, i, i5, false);
    }
}

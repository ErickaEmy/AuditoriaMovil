package ek;

import e4.fh;
import e4.rz;
import e4.ta;
import e4.tl;
import java.io.IOException;
import java.util.Arrays;
import v5.j5;
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    public int f7643a;

    /* renamed from: c5  reason: collision with root package name */
    public int f7644c5;

    /* renamed from: f  reason: collision with root package name */
    public long[] f7645f;

    /* renamed from: fb  reason: collision with root package name */
    public int f7646fb;

    /* renamed from: gv  reason: collision with root package name */
    public final long f7647gv;

    /* renamed from: i9  reason: collision with root package name */
    public int f7648i9;

    /* renamed from: n3  reason: collision with root package name */
    public final int f7649n3;

    /* renamed from: s  reason: collision with root package name */
    public int f7650s;

    /* renamed from: t  reason: collision with root package name */
    public int[] f7651t;

    /* renamed from: v  reason: collision with root package name */
    public final int f7652v;
    public final ta y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f7653zn;

    public v(int i, int i5, long j2, int i6, ta taVar) {
        int i8;
        int i10;
        boolean z2 = true;
        if (i5 != 1 && i5 != 2) {
            z2 = false;
        }
        v5.y.y(z2);
        this.f7647gv = j2;
        this.f7652v = i6;
        this.y = taVar;
        if (i5 == 2) {
            i8 = 1667497984;
        } else {
            i8 = 1651965952;
        }
        this.f7649n3 = gv(i, i8);
        if (i5 == 2) {
            i10 = gv(i, 1650720768);
        } else {
            i10 = -1;
        }
        this.f7653zn = i10;
        this.f7645f = new long[512];
        this.f7651t = new int[512];
    }

    public static int gv(int i, int i5) {
        return (((i % 10) + 48) << 8) | ((i / 10) + 48) | i5;
    }

    public long a() {
        return v(this.f7650s);
    }

    public fh.y c5(long j2) {
        int fb2 = (int) (j2 / fb());
        int s2 = j5.s(this.f7651t, fb2, true, true);
        if (this.f7651t[s2] == fb2) {
            return new fh.y(s(s2));
        }
        rz s3 = s(s2);
        int i = s2 + 1;
        if (i < this.f7645f.length) {
            return new fh.y(s3, s(i));
        }
        return new fh.y(s3);
    }

    public void f() {
        this.f7644c5++;
    }

    public long fb() {
        return v(1);
    }

    public boolean i9(int i) {
        if (this.f7649n3 != i && this.f7653zn != i) {
            return false;
        }
        return true;
    }

    public void n3(long j2) {
        if (this.f7648i9 == this.f7651t.length) {
            long[] jArr = this.f7645f;
            this.f7645f = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.f7651t;
            this.f7651t = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.f7645f;
        int i = this.f7648i9;
        jArr2[i] = j2;
        this.f7651t[i] = this.f7644c5;
        this.f7648i9 = i + 1;
    }

    public final rz s(int i) {
        return new rz(this.f7651t[i] * fb(), this.f7645f[i]);
    }

    public boolean t() {
        if (Arrays.binarySearch(this.f7651t, this.f7650s) >= 0) {
            return true;
        }
        return false;
    }

    public boolean tl(tl tlVar) throws IOException {
        int i = this.f7646fb;
        boolean z2 = false;
        int n32 = i - this.y.n3(tlVar, i, false);
        this.f7646fb = n32;
        if (n32 == 0) {
            z2 = true;
        }
        if (z2) {
            if (this.f7643a > 0) {
                ta taVar = this.y;
                long a2 = a();
                boolean t2 = t();
                taVar.gv(a2, t2 ? 1 : 0, this.f7643a, 0, null);
            }
            y();
        }
        return z2;
    }

    public final long v(int i) {
        return (this.f7647gv * i) / this.f7652v;
    }

    public void wz(int i) {
        this.f7643a = i;
        this.f7646fb = i;
    }

    public void xc(long j2) {
        if (this.f7648i9 == 0) {
            this.f7650s = 0;
            return;
        }
        this.f7650s = this.f7651t[j5.c5(this.f7645f, j2, true, true)];
    }

    public void y() {
        this.f7650s++;
    }

    public void zn() {
        this.f7645f = Arrays.copyOf(this.f7645f, this.f7648i9);
        this.f7651t = Arrays.copyOf(this.f7651t, this.f7648i9);
    }
}

package mv;

import androidx.annotation.Nullable;
import e4.fh;
import e4.rz;
import e4.tl;
import e4.xc;
import java.io.EOFException;
import java.io.IOException;
import v5.j5;
/* loaded from: classes.dex */
public final class y implements fb {

    /* renamed from: a  reason: collision with root package name */
    public long f11617a;

    /* renamed from: c5  reason: collision with root package name */
    public long f11618c5;

    /* renamed from: f  reason: collision with root package name */
    public long f11619f;

    /* renamed from: fb  reason: collision with root package name */
    public long f11620fb;

    /* renamed from: gv  reason: collision with root package name */
    public final c5 f11621gv;

    /* renamed from: i9  reason: collision with root package name */
    public long f11622i9;

    /* renamed from: n3  reason: collision with root package name */
    public final long f11623n3;

    /* renamed from: s  reason: collision with root package name */
    public long f11624s;

    /* renamed from: t  reason: collision with root package name */
    public long f11625t;

    /* renamed from: v  reason: collision with root package name */
    public int f11626v;
    public final a y;

    /* renamed from: zn  reason: collision with root package name */
    public final long f11627zn;

    /* loaded from: classes.dex */
    public final class n3 implements fh {
        public n3() {
        }

        @Override // e4.fh
        public long c5() {
            return y.this.f11621gv.n3(y.this.f11617a);
        }

        @Override // e4.fh
        public fh.y gv(long j2) {
            return new fh.y(new rz(j2, j5.mt((y.this.f11623n3 + ((y.this.f11621gv.zn(j2) * (y.this.f11627zn - y.this.f11623n3)) / y.this.f11617a)) - 30000, y.this.f11623n3, y.this.f11627zn - 1)));
        }

        @Override // e4.fh
        public boolean s() {
            return true;
        }
    }

    public y(c5 c5Var, long j2, long j4, long j6, long j7, boolean z2) {
        boolean z3;
        if (j2 >= 0 && j4 > j2) {
            z3 = true;
        } else {
            z3 = false;
        }
        v5.y.y(z3);
        this.f11621gv = c5Var;
        this.f11623n3 = j2;
        this.f11627zn = j4;
        if (j6 != j4 - j2 && !z2) {
            this.f11626v = 0;
        } else {
            this.f11617a = j7;
            this.f11626v = 4;
        }
        this.y = new a();
    }

    public final long c5(tl tlVar) throws IOException {
        long j2;
        if (this.f11618c5 == this.f11622i9) {
            return -1L;
        }
        long position = tlVar.getPosition();
        if (!this.y.gv(tlVar, this.f11622i9)) {
            long j4 = this.f11618c5;
            if (j4 != position) {
                return j4;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.y.y(tlVar, false);
        tlVar.s();
        long j6 = this.f11624s;
        a aVar = this.y;
        long j7 = aVar.f11579zn;
        long j8 = j6 - j7;
        int i = aVar.f11577s + aVar.f11571c5;
        if (0 <= j8 && j8 < 72000) {
            return -1L;
        }
        int i5 = (j8 > 0L ? 1 : (j8 == 0L ? 0 : -1));
        if (i5 < 0) {
            this.f11622i9 = position;
            this.f11625t = j7;
        } else {
            this.f11618c5 = tlVar.getPosition() + i;
            this.f11619f = this.y.f11579zn;
        }
        long j9 = this.f11622i9;
        long j10 = this.f11618c5;
        if (j9 - j10 < 100000) {
            this.f11622i9 = j10;
            return j10;
        }
        long j11 = i;
        if (i5 <= 0) {
            j2 = 2;
        } else {
            j2 = 1;
        }
        long j12 = j11 * j2;
        long j13 = this.f11622i9;
        long j14 = this.f11618c5;
        return j5.mt((tlVar.getPosition() - j12) + ((j8 * (j13 - j14)) / (this.f11625t - this.f11619f)), j14, j13 - 1);
    }

    public final void f(tl tlVar) throws IOException {
        while (true) {
            this.y.zn(tlVar);
            this.y.y(tlVar, false);
            a aVar = this.y;
            if (aVar.f11579zn > this.f11624s) {
                tlVar.s();
                return;
            }
            tlVar.p(aVar.f11577s + aVar.f11571c5);
            this.f11618c5 = tlVar.getPosition();
            this.f11619f = this.y.f11579zn;
        }
    }

    public long i9(tl tlVar) throws IOException {
        this.y.n3();
        if (this.y.zn(tlVar)) {
            this.y.y(tlVar, false);
            a aVar = this.y;
            tlVar.p(aVar.f11577s + aVar.f11571c5);
            long j2 = this.y.f11579zn;
            while (true) {
                a aVar2 = this.y;
                if ((aVar2.f11576n3 & 4) == 4 || !aVar2.zn(tlVar) || tlVar.getPosition() >= this.f11627zn || !this.y.y(tlVar, true)) {
                    break;
                }
                a aVar3 = this.y;
                if (!xc.v(tlVar, aVar3.f11577s + aVar3.f11571c5)) {
                    break;
                }
                j2 = this.y.f11579zn;
            }
            return j2;
        }
        throw new EOFException();
    }

    @Override // mv.fb
    public long n3(tl tlVar) throws IOException {
        int i = this.f11626v;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return -1L;
                        }
                        throw new IllegalStateException();
                    }
                } else {
                    long c52 = c5(tlVar);
                    if (c52 != -1) {
                        return c52;
                    }
                    this.f11626v = 3;
                }
                f(tlVar);
                this.f11626v = 4;
                return -(this.f11619f + 2);
            }
        } else {
            long position = tlVar.getPosition();
            this.f11620fb = position;
            this.f11626v = 1;
            long j2 = this.f11627zn - 65307;
            if (j2 > position) {
                return j2;
            }
        }
        this.f11617a = i9(tlVar);
        this.f11626v = 4;
        return this.f11620fb;
    }

    @Override // mv.fb
    @Nullable
    /* renamed from: s */
    public n3 y() {
        if (this.f11617a == 0) {
            return null;
        }
        return new n3();
    }

    @Override // mv.fb
    public void zn(long j2) {
        this.f11624s = j5.mt(j2, 0L, this.f11617a - 1);
        this.f11626v = 2;
        this.f11618c5 = this.f11623n3;
        this.f11622i9 = this.f11627zn;
        this.f11619f = 0L;
        this.f11625t = this.f11617a;
    }
}

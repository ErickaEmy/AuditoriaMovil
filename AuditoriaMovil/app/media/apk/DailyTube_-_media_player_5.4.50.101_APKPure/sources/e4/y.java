package e4;

import androidx.annotation.Nullable;
import e4.fh;
import java.io.IOException;
import v5.j5;
/* loaded from: classes.dex */
public abstract class y {

    /* renamed from: gv  reason: collision with root package name */
    public final int f7535gv;

    /* renamed from: n3  reason: collision with root package name */
    public final a f7536n3;
    public final C0089y y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public zn f7537zn;

    /* loaded from: classes.dex */
    public interface a {
        void n3();

        v y(tl tlVar, long j2) throws IOException;
    }

    /* loaded from: classes.dex */
    public interface gv {
        long timeUsToTargetTime(long j2);
    }

    /* loaded from: classes.dex */
    public static final class v {

        /* renamed from: gv  reason: collision with root package name */
        public static final v f7538gv = new v(-3, -9223372036854775807L, -1);

        /* renamed from: n3  reason: collision with root package name */
        public final long f7539n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final long f7540zn;

        public v(int i, long j2, long j4) {
            this.y = i;
            this.f7539n3 = j2;
            this.f7540zn = j4;
        }

        public static v a(long j2, long j4) {
            return new v(-2, j2, j4);
        }

        public static v gv(long j2, long j4) {
            return new v(-1, j2, j4);
        }

        public static v v(long j2) {
            return new v(0, -9223372036854775807L, j2);
        }
    }

    /* renamed from: e4.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0089y implements fh {

        /* renamed from: a  reason: collision with root package name */
        public final long f7541a;

        /* renamed from: fb  reason: collision with root package name */
        public final long f7542fb;

        /* renamed from: gv  reason: collision with root package name */
        public final long f7543gv;

        /* renamed from: n3  reason: collision with root package name */
        public final long f7544n3;

        /* renamed from: v  reason: collision with root package name */
        public final long f7545v;
        public final gv y;

        /* renamed from: zn  reason: collision with root package name */
        public final long f7546zn;

        public C0089y(gv gvVar, long j2, long j4, long j6, long j7, long j8, long j9) {
            this.y = gvVar;
            this.f7544n3 = j2;
            this.f7546zn = j4;
            this.f7543gv = j6;
            this.f7545v = j7;
            this.f7541a = j8;
            this.f7542fb = j9;
        }

        @Override // e4.fh
        public long c5() {
            return this.f7544n3;
        }

        public long f(long j2) {
            return this.y.timeUsToTargetTime(j2);
        }

        @Override // e4.fh
        public fh.y gv(long j2) {
            return new fh.y(new rz(j2, zn.s(this.y.timeUsToTargetTime(j2), this.f7546zn, this.f7543gv, this.f7545v, this.f7541a, this.f7542fb)));
        }

        @Override // e4.fh
        public boolean s() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class zn {

        /* renamed from: a  reason: collision with root package name */
        public long f7547a;

        /* renamed from: fb  reason: collision with root package name */
        public long f7548fb;

        /* renamed from: gv  reason: collision with root package name */
        public long f7549gv;

        /* renamed from: n3  reason: collision with root package name */
        public final long f7550n3;

        /* renamed from: s  reason: collision with root package name */
        public long f7551s;

        /* renamed from: v  reason: collision with root package name */
        public long f7552v;
        public final long y;

        /* renamed from: zn  reason: collision with root package name */
        public final long f7553zn;

        public zn(long j2, long j4, long j6, long j7, long j8, long j9, long j10) {
            this.y = j2;
            this.f7550n3 = j4;
            this.f7549gv = j6;
            this.f7552v = j7;
            this.f7547a = j8;
            this.f7548fb = j9;
            this.f7553zn = j10;
            this.f7551s = s(j4, j6, j7, j8, j9, j10);
        }

        public static long s(long j2, long j4, long j6, long j7, long j8, long j9) {
            if (j7 + 1 < j8 && j4 + 1 < j6) {
                long j10 = ((float) (j2 - j4)) * (((float) (j8 - j7)) / ((float) (j6 - j4)));
                return j5.mt(((j10 + j7) - j9) - (j10 / 20), j7, j8 - 1);
            }
            return j7;
        }

        public final long c5() {
            return this.f7548fb;
        }

        public final long f() {
            return this.f7551s;
        }

        public final long i9() {
            return this.f7547a;
        }

        public final long t() {
            return this.y;
        }

        public final long tl() {
            return this.f7550n3;
        }

        public final void w(long j2, long j4) {
            this.f7549gv = j2;
            this.f7547a = j4;
            wz();
        }

        public final void wz() {
            this.f7551s = s(this.f7550n3, this.f7549gv, this.f7552v, this.f7547a, this.f7548fb, this.f7553zn);
        }

        public final void xc(long j2, long j4) {
            this.f7552v = j2;
            this.f7548fb = j4;
            wz();
        }
    }

    public y(gv gvVar, a aVar, long j2, long j4, long j6, long j7, long j8, long j9, int i) {
        this.f7536n3 = aVar;
        this.f7535gv = i;
        this.y = new C0089y(gvVar, j2, j4, j6, j7, j8, j9);
    }

    public final boolean c5(tl tlVar, long j2) throws IOException {
        long position = j2 - tlVar.getPosition();
        if (position >= 0 && position <= 262144) {
            tlVar.p((int) position);
            return true;
        }
        return false;
    }

    public final int fb(tl tlVar, long j2, d0 d0Var) {
        if (j2 == tlVar.getPosition()) {
            return 0;
        }
        d0Var.y = j2;
        return 1;
    }

    public final boolean gv() {
        if (this.f7537zn != null) {
            return true;
        }
        return false;
    }

    public final fh n3() {
        return this.y;
    }

    public final void s(long j2) {
        zn znVar = this.f7537zn;
        if (znVar != null && znVar.t() == j2) {
            return;
        }
        this.f7537zn = y(j2);
    }

    public final void v(boolean z2, long j2) {
        this.f7537zn = null;
        this.f7536n3.n3();
        a(z2, j2);
    }

    public zn y(long j2) {
        return new zn(j2, this.y.f(j2), this.y.f7546zn, this.y.f7543gv, this.y.f7545v, this.y.f7541a, this.y.f7542fb);
    }

    public int zn(tl tlVar, d0 d0Var) throws IOException {
        while (true) {
            zn znVar = (zn) v5.y.c5(this.f7537zn);
            long i92 = znVar.i9();
            long c52 = znVar.c5();
            long f4 = znVar.f();
            if (c52 - i92 <= this.f7535gv) {
                v(false, i92);
                return fb(tlVar, i92, d0Var);
            } else if (!c5(tlVar, f4)) {
                return fb(tlVar, f4, d0Var);
            } else {
                tlVar.s();
                v y = this.f7536n3.y(tlVar, znVar.tl());
                int i = y.y;
                if (i != -3) {
                    if (i == -2) {
                        znVar.w(y.f7539n3, y.f7540zn);
                    } else if (i == -1) {
                        znVar.xc(y.f7539n3, y.f7540zn);
                    } else if (i == 0) {
                        c5(tlVar, y.f7540zn);
                        v(true, y.f7540zn);
                        return fb(tlVar, y.f7540zn, d0Var);
                    } else {
                        throw new IllegalStateException("Invalid case");
                    }
                } else {
                    v(false, f4);
                    return fb(tlVar, f4, d0Var);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 implements gv {
        @Override // e4.y.gv
        public long timeUsToTargetTime(long j2) {
            return j2;
        }
    }

    public void a(boolean z2, long j2) {
    }
}

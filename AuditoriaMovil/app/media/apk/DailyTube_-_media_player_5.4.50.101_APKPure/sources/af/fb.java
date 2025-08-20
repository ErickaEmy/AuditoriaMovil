package af;

import af.b;
import af.mg;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.v;
import java.io.IOException;
import java.util.HashMap;
import m1.hy;
/* loaded from: classes.dex */
public abstract class fb<T> extends af.y {
    @Nullable

    /* renamed from: co  reason: collision with root package name */
    public Handler f230co;

    /* renamed from: p  reason: collision with root package name */
    public final HashMap<T, n3<T>> f231p = new HashMap<>();
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    public kx.o f232z;

    /* loaded from: classes.dex */
    public static final class n3<T> {

        /* renamed from: n3  reason: collision with root package name */
        public final mg.zn f233n3;
        public final mg y;

        /* renamed from: zn  reason: collision with root package name */
        public final fb<T>.y f234zn;

        public n3(mg mgVar, mg.zn znVar, fb<T>.y yVar) {
            this.y = mgVar;
            this.f233n3 = znVar;
            this.f234zn = yVar;
        }
    }

    /* loaded from: classes.dex */
    public final class y implements b, com.google.android.exoplayer2.drm.v {

        /* renamed from: fb  reason: collision with root package name */
        public v.y f235fb;

        /* renamed from: v  reason: collision with root package name */
        public b.y f237v;
        public final T y;

        public y(T t2) {
            this.f237v = fb.this.o4(null);
            this.f235fb = fb.this.dm(null);
            this.y = t2;
        }

        @Override // af.b
        public void b(int i, @Nullable mg.n3 n3Var, c cVar) {
            if (c(i, n3Var)) {
                this.f237v.i9(z6(cVar));
            }
        }

        public final boolean c(int i, @Nullable mg.n3 n3Var) {
            mg.n3 n3Var2;
            if (n3Var != null) {
                n3Var2 = fb.this.rb(this.y, n3Var);
                if (n3Var2 == null) {
                    return false;
                }
            } else {
                n3Var2 = null;
            }
            int m2 = fb.this.m(this.y, i);
            b.y yVar = this.f237v;
            if (yVar.y != m2 || !v5.j5.zn(yVar.f114n3, n3Var2)) {
                this.f237v = fb.this.ct(m2, n3Var2, 0L);
            }
            v.y yVar2 = this.f235fb;
            if (yVar2.y != m2 || !v5.j5.zn(yVar2.f4167n3, n3Var2)) {
                this.f235fb = fb.this.xg(m2, n3Var2);
                return true;
            }
            return true;
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void d(int i, @Nullable mg.n3 n3Var, int i5) {
            if (c(i, n3Var)) {
                this.f235fb.f(i5);
            }
        }

        @Override // af.b
        public void fb(int i, @Nullable mg.n3 n3Var, i4 i4Var, c cVar) {
            if (c(i, n3Var)) {
                this.f237v.co(i4Var, z6(cVar));
            }
        }

        @Override // af.b
        public void fh(int i, @Nullable mg.n3 n3Var, i4 i4Var, c cVar) {
            if (c(i, n3Var)) {
                this.f237v.fh(i4Var, z6(cVar));
            }
        }

        @Override // af.b
        public void j5(int i, @Nullable mg.n3 n3Var, i4 i4Var, c cVar, IOException iOException, boolean z2) {
            if (c(i, n3Var)) {
                this.f237v.n(i4Var, z6(cVar), iOException, z2);
            }
        }

        @Override // af.b
        public void mg(int i, @Nullable mg.n3 n3Var, i4 i4Var, c cVar) {
            if (c(i, n3Var)) {
                this.f237v.x4(i4Var, z6(cVar));
            }
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void mt(int i, @Nullable mg.n3 n3Var) {
            if (c(i, n3Var)) {
                this.f235fb.s();
            }
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void n(int i, @Nullable mg.n3 n3Var, Exception exc) {
            if (c(i, n3Var)) {
                this.f235fb.t(exc);
            }
        }

        @Override // af.b
        public void p(int i, @Nullable mg.n3 n3Var, c cVar) {
            if (c(i, n3Var)) {
                this.f237v.ta(z6(cVar));
            }
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void ta(int i, @Nullable mg.n3 n3Var) {
            if (c(i, n3Var)) {
                this.f235fb.i9();
            }
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void w(int i, @Nullable mg.n3 n3Var) {
            if (c(i, n3Var)) {
                this.f235fb.tl();
            }
        }

        @Override // com.google.android.exoplayer2.drm.v
        public /* synthetic */ void y(int i, mg.n3 n3Var) {
            f8.f.y(this, i, n3Var);
        }

        public final c z6(c cVar) {
            long g32 = fb.this.g3(this.y, cVar.f117a);
            long g33 = fb.this.g3(this.y, cVar.f118fb);
            if (g32 == cVar.f117a && g33 == cVar.f118fb) {
                return cVar;
            }
            return new c(cVar.y, cVar.f120n3, cVar.f122zn, cVar.f119gv, cVar.f121v, g32, g33);
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void zn(int i, @Nullable mg.n3 n3Var) {
            if (c(i, n3Var)) {
                this.f235fb.c5();
            }
        }
    }

    @Override // af.y
    public void ap() {
        for (n3<T> n3Var : this.f231p.values()) {
            n3Var.y.hw(n3Var.f233n3);
            n3Var.y.jz(n3Var.f234zn);
            n3Var.y.j(n3Var.f234zn);
        }
        this.f231p.clear();
    }

    public final void bk(final T t2, mg mgVar) {
        v5.y.y(!this.f231p.containsKey(t2));
        mg.zn znVar = new mg.zn() { // from class: af.a
            @Override // af.mg.zn
            public final void y(mg mgVar2, hy hyVar) {
                fb.this.g(t2, mgVar2, hyVar);
            }
        };
        y yVar = new y(t2);
        this.f231p.put(t2, new n3<>(mgVar, znVar, yVar));
        mgVar.y5((Handler) v5.y.v(this.f230co), yVar);
        mgVar.o((Handler) v5.y.v(this.f230co), yVar);
        mgVar.mt(znVar, this.f232z, nf());
        if (!ra()) {
            mgVar.vl(znVar);
        }
    }

    @Override // af.y
    public void e(@Nullable kx.o oVar) {
        this.f232z = oVar;
        this.f230co = v5.j5.i4();
    }

    @Override // af.y
    public void eb() {
        for (n3<T> n3Var : this.f231p.values()) {
            n3Var.y.vl(n3Var.f233n3);
        }
    }

    public final void kp(T t2) {
        n3 n3Var = (n3) v5.y.v(this.f231p.get(t2));
        n3Var.y.z6(n3Var.f233n3);
    }

    @Override // af.y
    public void lc() {
        for (n3<T> n3Var : this.f231p.values()) {
            n3Var.y.z6(n3Var.f233n3);
        }
    }

    /* renamed from: u0 */
    public abstract void g(T t2, mg mgVar, hy hyVar);

    @Override // af.mg
    public void ut() throws IOException {
        for (n3<T> n3Var : this.f231p.values()) {
            n3Var.y.ut();
        }
    }

    public final void y4(T t2) {
        n3 n3Var = (n3) v5.y.v(this.f231p.remove(t2));
        n3Var.y.hw(n3Var.f233n3);
        n3Var.y.jz(n3Var.f234zn);
        n3Var.y.j(n3Var.f234zn);
    }

    public final void yc(T t2) {
        n3 n3Var = (n3) v5.y.v(this.f231p.get(t2));
        n3Var.y.vl(n3Var.f233n3);
    }

    public long g3(T t2, long j2) {
        return j2;
    }

    public int m(T t2, int i) {
        return i;
    }

    @Nullable
    public mg.n3 rb(T t2, mg.n3 n3Var) {
        return n3Var;
    }
}

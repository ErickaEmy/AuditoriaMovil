package af;

import af.b;
import af.mg;
import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import m1.m;
/* loaded from: classes.dex */
public interface b {

    /* loaded from: classes.dex */
    public static class y {

        /* renamed from: gv  reason: collision with root package name */
        public final long f113gv;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public final mg.n3 f114n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final CopyOnWriteArrayList<C0002y> f115zn;

        /* renamed from: af.b$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0002y {

            /* renamed from: n3  reason: collision with root package name */
            public b f116n3;
            public Handler y;

            public C0002y(Handler handler, b bVar) {
                this.y = handler;
                this.f116n3 = bVar;
            }
        }

        public y() {
            this(new CopyOnWriteArrayList(), 0, null, 0L);
        }

        public void c(i4 i4Var, int i) {
            d0(i4Var, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void c5(int i, @Nullable m mVar, int i5, @Nullable Object obj, long j2) {
            i9(new c(1, i, mVar, i5, obj, s(j2), -9223372036854775807L));
        }

        public void co(final i4 i4Var, final c cVar) {
            Iterator<C0002y> it = this.f115zn.iterator();
            while (it.hasNext()) {
                C0002y next = it.next();
                final b bVar = next.f116n3;
                v5.j5.oa(next.y, new Runnable() { // from class: af.ej
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.y.this.t(bVar, i4Var, cVar);
                    }
                });
            }
        }

        @CheckResult
        public y d(int i, @Nullable mg.n3 n3Var, long j2) {
            return new y(this.f115zn, i, n3Var, j2);
        }

        public void d0(i4 i4Var, int i, int i5, @Nullable m mVar, int i6, @Nullable Object obj, long j2, long j4) {
            fh(i4Var, new c(i, i5, mVar, i6, obj, s(j2), s(j4)));
        }

        public final /* synthetic */ void f(b bVar, c cVar) {
            bVar.b(this.y, this.f114n3, cVar);
        }

        public void f3(i4 i4Var, int i, IOException iOException, boolean z2) {
            i4(i4Var, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, z2);
        }

        public void fb(Handler handler, b bVar) {
            v5.y.v(handler);
            v5.y.v(bVar);
            this.f115zn.add(new C0002y(handler, bVar));
        }

        public void fh(final i4 i4Var, final c cVar) {
            Iterator<C0002y> it = this.f115zn.iterator();
            while (it.hasNext()) {
                C0002y next = it.next();
                final b bVar = next.f116n3;
                v5.j5.oa(next.y, new Runnable() { // from class: af.ud
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.y.this.xc(bVar, i4Var, cVar);
                    }
                });
            }
        }

        public void i4(i4 i4Var, int i, int i5, @Nullable m mVar, int i6, @Nullable Object obj, long j2, long j4, IOException iOException, boolean z2) {
            n(i4Var, new c(i, i5, mVar, i6, obj, s(j2), s(j4)), iOException, z2);
        }

        public void i9(final c cVar) {
            Iterator<C0002y> it = this.f115zn.iterator();
            while (it.hasNext()) {
                C0002y next = it.next();
                final b bVar = next.f116n3;
                v5.j5.oa(next.y, new Runnable() { // from class: af.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.y.this.f(bVar, cVar);
                    }
                });
            }
        }

        public void mg(int i, long j2, long j4) {
            ta(new c(1, i, null, 3, null, s(j2), s(j4)));
        }

        public void mt(i4 i4Var, int i, int i5, @Nullable m mVar, int i6, @Nullable Object obj, long j2, long j4) {
            co(i4Var, new c(i, i5, mVar, i6, obj, s(j2), s(j4)));
        }

        public void n(final i4 i4Var, final c cVar, final IOException iOException, final boolean z2) {
            Iterator<C0002y> it = this.f115zn.iterator();
            while (it.hasNext()) {
                C0002y next = it.next();
                final b bVar = next.f116n3;
                v5.j5.oa(next.y, new Runnable() { // from class: af.z6
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.y.this.wz(bVar, i4Var, cVar, iOException, z2);
                    }
                });
            }
        }

        public void p(i4 i4Var, int i) {
            mt(i4Var, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void r(i4 i4Var, int i, int i5, @Nullable m mVar, int i6, @Nullable Object obj, long j2, long j4) {
            x4(i4Var, new c(i, i5, mVar, i6, obj, s(j2), s(j4)));
        }

        public void rz(b bVar) {
            Iterator<C0002y> it = this.f115zn.iterator();
            while (it.hasNext()) {
                C0002y next = it.next();
                if (next.f116n3 == bVar) {
                    this.f115zn.remove(next);
                }
            }
        }

        public final long s(long j2) {
            long gf = v5.j5.gf(j2);
            if (gf == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f113gv + gf;
        }

        public final /* synthetic */ void t(b bVar, i4 i4Var, c cVar) {
            bVar.fb(this.y, this.f114n3, i4Var, cVar);
        }

        public void ta(final c cVar) {
            final mg.n3 n3Var = (mg.n3) v5.y.v(this.f114n3);
            Iterator<C0002y> it = this.f115zn.iterator();
            while (it.hasNext()) {
                C0002y next = it.next();
                final b bVar = next.f116n3;
                v5.j5.oa(next.y, new Runnable() { // from class: af.a8
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.y.this.w(bVar, n3Var, cVar);
                    }
                });
            }
        }

        public final /* synthetic */ void tl(b bVar, i4 i4Var, c cVar) {
            bVar.mg(this.y, this.f114n3, i4Var, cVar);
        }

        public final /* synthetic */ void w(b bVar, mg.n3 n3Var, c cVar) {
            bVar.p(this.y, n3Var, cVar);
        }

        public final /* synthetic */ void wz(b bVar, i4 i4Var, c cVar, IOException iOException, boolean z2) {
            bVar.j5(this.y, this.f114n3, i4Var, cVar, iOException, z2);
        }

        public void x4(final i4 i4Var, final c cVar) {
            Iterator<C0002y> it = this.f115zn.iterator();
            while (it.hasNext()) {
                C0002y next = it.next();
                final b bVar = next.f116n3;
                v5.j5.oa(next.y, new Runnable() { // from class: af.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.y.this.tl(bVar, i4Var, cVar);
                    }
                });
            }
        }

        public final /* synthetic */ void xc(b bVar, i4 i4Var, c cVar) {
            bVar.fh(this.y, this.f114n3, i4Var, cVar);
        }

        public void z(i4 i4Var, int i) {
            r(i4Var, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public y(CopyOnWriteArrayList<C0002y> copyOnWriteArrayList, int i, @Nullable mg.n3 n3Var, long j2) {
            this.f115zn = copyOnWriteArrayList;
            this.y = i;
            this.f114n3 = n3Var;
            this.f113gv = j2;
        }
    }

    void b(int i, @Nullable mg.n3 n3Var, c cVar);

    void fb(int i, @Nullable mg.n3 n3Var, i4 i4Var, c cVar);

    void fh(int i, @Nullable mg.n3 n3Var, i4 i4Var, c cVar);

    void j5(int i, @Nullable mg.n3 n3Var, i4 i4Var, c cVar, IOException iOException, boolean z2);

    void mg(int i, @Nullable mg.n3 n3Var, i4 i4Var, c cVar);

    void p(int i, mg.n3 n3Var, c cVar);
}

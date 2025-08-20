package wn;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import m1.m;
import v5.j5;
import wn.n;
/* loaded from: classes.dex */
public interface n {

    /* loaded from: classes.dex */
    public static final class y {
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public final n f14590n3;
        @Nullable
        public final Handler y;

        public y(@Nullable Handler handler, @Nullable n nVar) {
            Handler handler2;
            if (nVar != null) {
                handler2 = (Handler) v5.y.v(handler);
            } else {
                handler2 = null;
            }
            this.y = handler2;
            this.f14590n3 = nVar;
        }

        public final /* synthetic */ void c(d0 d0Var) {
            ((n) j5.i9(this.f14590n3)).onVideoSizeChanged(d0Var);
        }

        public final /* synthetic */ void co(a9.v vVar) {
            vVar.zn();
            ((n) j5.i9(this.f14590n3)).tl(vVar);
        }

        public void d0(final Object obj) {
            if (this.y != null) {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                this.y.post(new Runnable() { // from class: wn.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.y.this.i4(obj, elapsedRealtime);
                    }
                });
            }
        }

        public void f(final String str, final long j2, final long j4) {
            Handler handler = this.y;
            if (handler != null) {
                handler.post(new Runnable() { // from class: wn.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.y.this.p(str, j2, j4);
                    }
                });
            }
        }

        public final /* synthetic */ void f3(long j2, int i) {
            ((n) j5.i9(this.f14590n3)).f3(j2, i);
        }

        public void fh(final long j2, final int i) {
            Handler handler = this.y;
            if (handler != null) {
                handler.post(new Runnable() { // from class: wn.f3
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.y.this.f3(j2, i);
                    }
                });
            }
        }

        public final /* synthetic */ void i4(Object obj, long j2) {
            ((n) j5.i9(this.f14590n3)).z(obj, j2);
        }

        public void mg(final d0 d0Var) {
            Handler handler = this.y;
            if (handler != null) {
                handler.post(new Runnable() { // from class: wn.xc
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.y.this.c(d0Var);
                    }
                });
            }
        }

        public final /* synthetic */ void mt(String str) {
            ((n) j5.i9(this.f14590n3)).n3(str);
        }

        public final /* synthetic */ void n(Exception exc) {
            ((n) j5.i9(this.f14590n3)).xc(exc);
        }

        public final /* synthetic */ void p(String str, long j2, long j4) {
            ((n) j5.i9(this.f14590n3)).v(str, j2, j4);
        }

        public final /* synthetic */ void r(a9.v vVar) {
            ((n) j5.i9(this.f14590n3)).a(vVar);
        }

        public void rz(final Exception exc) {
            Handler handler = this.y;
            if (handler != null) {
                handler.post(new Runnable() { // from class: wn.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.y.this.n(exc);
                    }
                });
            }
        }

        public void t(final String str) {
            Handler handler = this.y;
            if (handler != null) {
                handler.post(new Runnable() { // from class: wn.mt
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.y.this.mt(str);
                    }
                });
            }
        }

        public void tl(final a9.v vVar) {
            vVar.zn();
            Handler handler = this.y;
            if (handler != null) {
                handler.post(new Runnable() { // from class: wn.co
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.y.this.co(vVar);
                    }
                });
            }
        }

        public void w(final m mVar, @Nullable final a9.c5 c5Var) {
            Handler handler = this.y;
            if (handler != null) {
                handler.post(new Runnable() { // from class: wn.i4
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.y.this.x4(mVar, c5Var);
                    }
                });
            }
        }

        public void wz(final int i, final long j2) {
            Handler handler = this.y;
            if (handler != null) {
                handler.post(new Runnable() { // from class: wn.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.y.this.z(i, j2);
                    }
                });
            }
        }

        public final /* synthetic */ void x4(m mVar, a9.c5 c5Var) {
            ((n) j5.i9(this.f14590n3)).y(mVar);
            ((n) j5.i9(this.f14590n3)).r(mVar, c5Var);
        }

        public void xc(final a9.v vVar) {
            Handler handler = this.y;
            if (handler != null) {
                handler.post(new Runnable() { // from class: wn.x4
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.y.this.r(vVar);
                    }
                });
            }
        }

        public final /* synthetic */ void z(int i, long j2) {
            ((n) j5.i9(this.f14590n3)).co(i, j2);
        }
    }

    void a(a9.v vVar);

    void co(int i, long j2);

    void f3(long j2, int i);

    void n3(String str);

    void onVideoSizeChanged(d0 d0Var);

    void r(m mVar, @Nullable a9.c5 c5Var);

    void tl(a9.v vVar);

    void v(String str, long j2, long j4);

    void xc(Exception exc);

    @Deprecated
    void y(m mVar);

    void z(Object obj, long j2);
}

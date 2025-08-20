package d9;

import android.os.Handler;
import androidx.annotation.Nullable;
import d9.z;
import m1.m;
import v5.j5;
/* loaded from: classes.dex */
public interface z {

    /* loaded from: classes.dex */
    public static final class y {
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public final z f7243n3;
        @Nullable
        public final Handler y;

        public y(@Nullable Handler handler, @Nullable z zVar) {
            Handler handler2;
            if (zVar != null) {
                handler2 = (Handler) v5.y.v(handler);
            } else {
                handler2 = null;
            }
            this.y = handler2;
            this.f7243n3 = zVar;
        }

        public final /* synthetic */ void c(boolean z2) {
            ((z) j5.i9(this.f7243n3)).onSkipSilenceEnabledChanged(z2);
        }

        public final /* synthetic */ void co(Exception exc) {
            ((z) j5.i9(this.f7243n3)).gv(exc);
        }

        public final /* synthetic */ void d0(int i, long j2, long j4) {
            ((z) j5.i9(this.f7243n3)).i4(i, j2, j4);
        }

        public void f(final Exception exc) {
            Handler handler = this.y;
            if (handler != null) {
                handler.post(new Runnable() { // from class: d9.wz
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.y.this.mt(exc);
                    }
                });
            }
        }

        public final /* synthetic */ void f3(m mVar, a9.c5 c5Var) {
            ((z) j5.i9(this.f7243n3)).n(mVar);
            ((z) j5.i9(this.f7243n3)).wz(mVar, c5Var);
        }

        public void fh(final long j2) {
            Handler handler = this.y;
            if (handler != null) {
                handler.post(new Runnable() { // from class: d9.xc
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.y.this.n(j2);
                    }
                });
            }
        }

        public final /* synthetic */ void i4(a9.v vVar) {
            ((z) j5.i9(this.f7243n3)).f(vVar);
        }

        public void mg(final int i, final long j2, final long j4) {
            Handler handler = this.y;
            if (handler != null) {
                handler.post(new Runnable() { // from class: d9.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.y.this.d0(i, j2, j4);
                    }
                });
            }
        }

        public final /* synthetic */ void mt(Exception exc) {
            ((z) j5.i9(this.f7243n3)).x4(exc);
        }

        public final /* synthetic */ void n(long j2) {
            ((z) j5.i9(this.f7243n3)).t(j2);
        }

        public void p(final m mVar, @Nullable final a9.c5 c5Var) {
            Handler handler = this.y;
            if (handler != null) {
                handler.post(new Runnable() { // from class: d9.mt
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.y.this.f3(mVar, c5Var);
                    }
                });
            }
        }

        public final /* synthetic */ void r(String str) {
            ((z) j5.i9(this.f7243n3)).s(str);
        }

        public void rz(final boolean z2) {
            Handler handler = this.y;
            if (handler != null) {
                handler.post(new Runnable() { // from class: d9.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.y.this.c(z2);
                    }
                });
            }
        }

        public void t(final Exception exc) {
            Handler handler = this.y;
            if (handler != null) {
                handler.post(new Runnable() { // from class: d9.co
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.y.this.co(exc);
                    }
                });
            }
        }

        public void tl(final String str, final long j2, final long j4) {
            Handler handler = this.y;
            if (handler != null) {
                handler.post(new Runnable() { // from class: d9.tl
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.y.this.z(str, j2, j4);
                    }
                });
            }
        }

        public void w(final a9.v vVar) {
            Handler handler = this.y;
            if (handler != null) {
                handler.post(new Runnable() { // from class: d9.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.y.this.i4(vVar);
                    }
                });
            }
        }

        public void wz(final String str) {
            Handler handler = this.y;
            if (handler != null) {
                handler.post(new Runnable() { // from class: d9.i9
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.y.this.r(str);
                    }
                });
            }
        }

        public final /* synthetic */ void x4(a9.v vVar) {
            vVar.zn();
            ((z) j5.i9(this.f7243n3)).i9(vVar);
        }

        public void xc(final a9.v vVar) {
            vVar.zn();
            Handler handler = this.y;
            if (handler != null) {
                handler.post(new Runnable() { // from class: d9.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.y.this.x4(vVar);
                    }
                });
            }
        }

        public final /* synthetic */ void z(String str, long j2, long j4) {
            ((z) j5.i9(this.f7243n3)).c5(str, j2, j4);
        }
    }

    void c5(String str, long j2, long j4);

    void f(a9.v vVar);

    void gv(Exception exc);

    void i4(int i, long j2, long j4);

    void i9(a9.v vVar);

    @Deprecated
    void n(m mVar);

    void onSkipSilenceEnabledChanged(boolean z2);

    void s(String str);

    void t(long j2);

    void wz(m mVar, @Nullable a9.c5 c5Var);

    void x4(Exception exc);
}

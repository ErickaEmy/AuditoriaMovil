package com.google.android.exoplayer2.drm;

import af.mg;
import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.v;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import v5.j5;
/* loaded from: classes.dex */
public interface v {

    /* loaded from: classes.dex */
    public static class y {
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public final mg.n3 f4167n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final CopyOnWriteArrayList<C0045y> f4168zn;

        /* renamed from: com.google.android.exoplayer2.drm.v$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0045y {

            /* renamed from: n3  reason: collision with root package name */
            public v f4169n3;
            public Handler y;

            public C0045y(Handler handler, v vVar) {
                this.y = handler;
                this.f4169n3 = vVar;
            }
        }

        public y() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        public void c5() {
            Iterator<C0045y> it = this.f4168zn.iterator();
            while (it.hasNext()) {
                C0045y next = it.next();
                final v vVar = next.f4169n3;
                j5.oa(next.y, new Runnable() { // from class: f8.xc
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.y.this.xc(vVar);
                    }
                });
            }
        }

        public final /* synthetic */ void co(v vVar) {
            vVar.w(this.y, this.f4167n3);
        }

        public void f(final int i) {
            Iterator<C0045y> it = this.f4168zn.iterator();
            while (it.hasNext()) {
                C0045y next = it.next();
                final v vVar = next.f4169n3;
                j5.oa(next.y, new Runnable() { // from class: f8.wz
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.y.this.p(vVar, i);
                    }
                });
            }
        }

        public void fb(Handler handler, v vVar) {
            v5.y.v(handler);
            v5.y.v(vVar);
            this.f4168zn.add(new C0045y(handler, vVar));
        }

        public void i9() {
            Iterator<C0045y> it = this.f4168zn.iterator();
            while (it.hasNext()) {
                C0045y next = it.next();
                final v vVar = next.f4169n3;
                j5.oa(next.y, new Runnable() { // from class: f8.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.y.this.w(vVar);
                    }
                });
            }
        }

        public final /* synthetic */ void mt(v vVar, Exception exc) {
            vVar.n(this.y, this.f4167n3, exc);
        }

        public final /* synthetic */ void p(v vVar, int i) {
            vVar.y(this.y, this.f4167n3);
            vVar.d(this.y, this.f4167n3, i);
        }

        @CheckResult
        public y r(int i, @Nullable mg.n3 n3Var) {
            return new y(this.f4168zn, i, n3Var);
        }

        public void s() {
            Iterator<C0045y> it = this.f4168zn.iterator();
            while (it.hasNext()) {
                C0045y next = it.next();
                final v vVar = next.f4169n3;
                j5.oa(next.y, new Runnable() { // from class: f8.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.y.this.wz(vVar);
                    }
                });
            }
        }

        public void t(final Exception exc) {
            Iterator<C0045y> it = this.f4168zn.iterator();
            while (it.hasNext()) {
                C0045y next = it.next();
                final v vVar = next.f4169n3;
                j5.oa(next.y, new Runnable() { // from class: f8.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.y.this.mt(vVar, exc);
                    }
                });
            }
        }

        public void tl() {
            Iterator<C0045y> it = this.f4168zn.iterator();
            while (it.hasNext()) {
                C0045y next = it.next();
                final v vVar = next.f4169n3;
                j5.oa(next.y, new Runnable() { // from class: f8.tl
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.y.this.co(vVar);
                    }
                });
            }
        }

        public final /* synthetic */ void w(v vVar) {
            vVar.ta(this.y, this.f4167n3);
        }

        public final /* synthetic */ void wz(v vVar) {
            vVar.mt(this.y, this.f4167n3);
        }

        public final /* synthetic */ void xc(v vVar) {
            vVar.zn(this.y, this.f4167n3);
        }

        public void z(v vVar) {
            Iterator<C0045y> it = this.f4168zn.iterator();
            while (it.hasNext()) {
                C0045y next = it.next();
                if (next.f4169n3 == vVar) {
                    this.f4168zn.remove(next);
                }
            }
        }

        public y(CopyOnWriteArrayList<C0045y> copyOnWriteArrayList, int i, @Nullable mg.n3 n3Var) {
            this.f4168zn = copyOnWriteArrayList;
            this.y = i;
            this.f4167n3 = n3Var;
        }
    }

    void d(int i, @Nullable mg.n3 n3Var, int i5);

    void mt(int i, @Nullable mg.n3 n3Var);

    void n(int i, @Nullable mg.n3 n3Var, Exception exc);

    void ta(int i, @Nullable mg.n3 n3Var);

    void w(int i, @Nullable mg.n3 n3Var);

    @Deprecated
    void y(int i, @Nullable mg.n3 n3Var);

    void zn(int i, @Nullable mg.n3 n3Var);
}

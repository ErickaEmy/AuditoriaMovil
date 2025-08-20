package f7;

import android.os.SystemClock;
import android.view.Choreographer;
import java.util.ArrayList;
import z.s;
/* loaded from: classes.dex */
public class y {

    /* renamed from: fb  reason: collision with root package name */
    public static final ThreadLocal<y> f7896fb = new ThreadLocal<>();

    /* renamed from: gv  reason: collision with root package name */
    public zn f7898gv;
    public final s<n3, Long> y = new s<>();

    /* renamed from: n3  reason: collision with root package name */
    public final ArrayList<n3> f7899n3 = new ArrayList<>();

    /* renamed from: zn  reason: collision with root package name */
    public final C0099y f7901zn = new C0099y();

    /* renamed from: v  reason: collision with root package name */
    public long f7900v = 0;

    /* renamed from: a  reason: collision with root package name */
    public boolean f7897a = false;

    /* loaded from: classes.dex */
    public static class gv extends zn {

        /* renamed from: n3  reason: collision with root package name */
        public final Choreographer f7902n3;

        /* renamed from: zn  reason: collision with root package name */
        public final Choreographer.FrameCallback f7903zn;

        /* renamed from: f7.y$gv$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class Choreographer$FrameCallbackC0098y implements Choreographer.FrameCallback {
            public Choreographer$FrameCallbackC0098y() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j2) {
                gv.this.y.y();
            }
        }

        public gv(C0099y c0099y) {
            super(c0099y);
            this.f7902n3 = Choreographer.getInstance();
            this.f7903zn = new Choreographer$FrameCallbackC0098y();
        }

        @Override // f7.y.zn
        public void y() {
            this.f7902n3.postFrameCallback(this.f7903zn);
        }
    }

    /* loaded from: classes.dex */
    public interface n3 {
        boolean y(long j2);
    }

    /* renamed from: f7.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0099y {
        public C0099y() {
        }

        public void y() {
            y.this.f7900v = SystemClock.uptimeMillis();
            y yVar = y.this;
            yVar.zn(yVar.f7900v);
            if (y.this.f7899n3.size() > 0) {
                y.this.v().y();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zn {
        public final C0099y y;

        public zn(C0099y c0099y) {
            this.y = c0099y;
        }

        public abstract void y();
    }

    public static y gv() {
        ThreadLocal<y> threadLocal = f7896fb;
        if (threadLocal.get() == null) {
            threadLocal.set(new y());
        }
        return threadLocal.get();
    }

    public final boolean a(n3 n3Var, long j2) {
        Long l2 = this.y.get(n3Var);
        if (l2 == null) {
            return true;
        }
        if (l2.longValue() < j2) {
            this.y.remove(n3Var);
            return true;
        }
        return false;
    }

    public void fb(n3 n3Var) {
        this.y.remove(n3Var);
        int indexOf = this.f7899n3.indexOf(n3Var);
        if (indexOf >= 0) {
            this.f7899n3.set(indexOf, null);
            this.f7897a = true;
        }
    }

    public final void n3() {
        if (this.f7897a) {
            for (int size = this.f7899n3.size() - 1; size >= 0; size--) {
                if (this.f7899n3.get(size) == null) {
                    this.f7899n3.remove(size);
                }
            }
            this.f7897a = false;
        }
    }

    public zn v() {
        if (this.f7898gv == null) {
            this.f7898gv = new gv(this.f7901zn);
        }
        return this.f7898gv;
    }

    public void y(n3 n3Var, long j2) {
        if (this.f7899n3.size() == 0) {
            v().y();
        }
        if (!this.f7899n3.contains(n3Var)) {
            this.f7899n3.add(n3Var);
        }
        if (j2 > 0) {
            this.y.put(n3Var, Long.valueOf(SystemClock.uptimeMillis() + j2));
        }
    }

    public void zn(long j2) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i = 0; i < this.f7899n3.size(); i++) {
            n3 n3Var = this.f7899n3.get(i);
            if (n3Var != null && a(n3Var, uptimeMillis)) {
                n3Var.y(j2);
            }
        }
        n3();
    }
}

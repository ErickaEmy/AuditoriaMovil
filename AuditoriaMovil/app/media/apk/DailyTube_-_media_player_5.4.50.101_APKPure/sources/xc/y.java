package xc;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class y extends zn {
    @NonNull

    /* renamed from: gv  reason: collision with root package name */
    public static final Executor f14938gv = new ExecutorC0248y();
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    public static final Executor f14939v = new n3();

    /* renamed from: zn  reason: collision with root package name */
    public static volatile y f14940zn;
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public zn f14941n3;
    @NonNull
    public zn y;

    /* loaded from: classes.dex */
    public static class n3 implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            y.a().y(runnable);
        }
    }

    /* renamed from: xc.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class ExecutorC0248y implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            y.a().gv(runnable);
        }
    }

    public y() {
        xc.n3 n3Var = new xc.n3();
        this.f14941n3 = n3Var;
        this.y = n3Var;
    }

    @NonNull
    public static y a() {
        if (f14940zn != null) {
            return f14940zn;
        }
        synchronized (y.class) {
            try {
                if (f14940zn == null) {
                    f14940zn = new y();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f14940zn;
    }

    @NonNull
    public static Executor v() {
        return f14939v;
    }

    @Override // xc.zn
    public void gv(Runnable runnable) {
        this.y.gv(runnable);
    }

    @Override // xc.zn
    public void y(Runnable runnable) {
        this.y.y(runnable);
    }

    @Override // xc.zn
    public boolean zn() {
        return this.y.zn();
    }
}

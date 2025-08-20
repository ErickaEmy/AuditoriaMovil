package yk;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public class b<T> {

    /* renamed from: v  reason: collision with root package name */
    public static Executor f15344v = Executors.newCachedThreadPool();
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public volatile a8<T> f15345gv;

    /* renamed from: n3  reason: collision with root package name */
    public final Set<d<Throwable>> f15346n3;
    public final Set<d<T>> y;

    /* renamed from: zn  reason: collision with root package name */
    public final Handler f15347zn;

    /* loaded from: classes.dex */
    public class y extends FutureTask<a8<T>> {
        public y(Callable<a8<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (!isCancelled()) {
                try {
                    b.this.f(get());
                } catch (InterruptedException | ExecutionException e2) {
                    b.this.f(new a8(e2));
                }
            }
        }
    }

    public b(Callable<a8<T>> callable) {
        this(callable, false);
    }

    public final synchronized void a(Throwable th) {
        ArrayList<d> arrayList = new ArrayList(this.f15346n3);
        if (arrayList.isEmpty()) {
            br.gv.gv("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        for (d dVar : arrayList) {
            dVar.onResult(th);
        }
    }

    public synchronized b<T> c5(d<Throwable> dVar) {
        this.f15346n3.remove(dVar);
        return this;
    }

    public final void f(@Nullable a8<T> a8Var) {
        if (this.f15345gv == null) {
            this.f15345gv = a8Var;
            fb();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public final void fb() {
        this.f15347zn.post(new Runnable() { // from class: yk.x
            @Override // java.lang.Runnable
            public final void run() {
                b.this.v();
            }
        });
    }

    public synchronized b<T> gv(d<T> dVar) {
        try {
            a8<T> a8Var = this.f15345gv;
            if (a8Var != null && a8Var.n3() != null) {
                dVar.onResult(a8Var.n3());
            }
            this.y.add(dVar);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized b<T> i9(d<T> dVar) {
        this.y.remove(dVar);
        return this;
    }

    public final synchronized void s(T t2) {
        for (d dVar : new ArrayList(this.y)) {
            dVar.onResult(t2);
        }
    }

    public final /* synthetic */ void v() {
        a8<T> a8Var = this.f15345gv;
        if (a8Var == null) {
            return;
        }
        if (a8Var.n3() != null) {
            s(a8Var.n3());
        } else {
            a(a8Var.y());
        }
    }

    public synchronized b<T> zn(d<Throwable> dVar) {
        try {
            a8<T> a8Var = this.f15345gv;
            if (a8Var != null && a8Var.y() != null) {
                dVar.onResult(a8Var.y());
            }
            this.f15346n3.add(dVar);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public b(Callable<a8<T>> callable, boolean z2) {
        this.y = new LinkedHashSet(1);
        this.f15346n3 = new LinkedHashSet(1);
        this.f15347zn = new Handler(Looper.getMainLooper());
        this.f15345gv = null;
        if (z2) {
            try {
                f(callable.call());
                return;
            } catch (Throwable th) {
                f(new a8<>(th));
                return;
            }
        }
        f15344v.execute(new y(callable));
    }
}

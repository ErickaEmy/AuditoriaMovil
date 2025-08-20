package y5;

import android.annotation.SuppressLint;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
/* loaded from: classes.dex */
public final class s {

    /* renamed from: n3  reason: collision with root package name */
    public boolean f15299n3;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f15300zn;
    public boolean y = true;

    /* renamed from: gv  reason: collision with root package name */
    public final Queue<Runnable> f15298gv = new ArrayDeque();

    /* loaded from: classes.dex */
    public static final class y implements Runnable {

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ Runnable f15301fb;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ CoroutineContext f15302v;

        public y(CoroutineContext coroutineContext, Runnable runnable) {
            this.f15302v = coroutineContext;
            this.f15301fb = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            s.this.v(this.f15301fb);
        }
    }

    public final void a() {
        this.f15299n3 = true;
        gv();
    }

    public final void fb() {
        this.y = true;
    }

    public final void gv() {
        if (this.f15300zn) {
            return;
        }
        try {
            this.f15300zn = true;
            while (!this.f15298gv.isEmpty() && n3()) {
                Runnable poll = this.f15298gv.poll();
                if (poll != null) {
                    poll.run();
                }
            }
        } finally {
            this.f15300zn = false;
        }
    }

    public final boolean n3() {
        if (!this.f15299n3 && this.y) {
            return false;
        }
        return true;
    }

    public final void s() {
        if (!this.y) {
            return;
        }
        if (!this.f15299n3) {
            this.y = false;
            gv();
            return;
        }
        throw new IllegalStateException("Cannot resume a finished dispatcher");
    }

    public final void v(Runnable runnable) {
        if (this.f15298gv.offer(runnable)) {
            gv();
            return;
        }
        throw new IllegalStateException("cannot enqueue any more runnables");
    }

    @SuppressLint({"WrongThread"})
    public final void zn(CoroutineContext context, Runnable runnable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        if (!immediate.isDispatchNeeded(context) && !n3()) {
            v(runnable);
        } else {
            immediate.mo109dispatch(context, new y(context, runnable));
        }
    }
}

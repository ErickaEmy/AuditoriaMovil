package cs;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class fb implements Executor {

    /* renamed from: s  reason: collision with root package name */
    public volatile Runnable f6862s;

    /* renamed from: v  reason: collision with root package name */
    public final Executor f6863v;
    public final ArrayDeque<y> y = new ArrayDeque<>();

    /* renamed from: fb  reason: collision with root package name */
    public final Object f6861fb = new Object();

    /* loaded from: classes.dex */
    public static class y implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final Runnable f6864v;
        public final fb y;

        public y(@NonNull fb fbVar, @NonNull Runnable runnable) {
            this.y = fbVar;
            this.f6864v = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f6864v.run();
            } finally {
                this.y.n3();
            }
        }
    }

    public fb(@NonNull Executor executor) {
        this.f6863v = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        synchronized (this.f6861fb) {
            try {
                this.y.add(new y(this, runnable));
                if (this.f6862s == null) {
                    n3();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void n3() {
        synchronized (this.f6861fb) {
            try {
                y poll = this.y.poll();
                this.f6862s = poll;
                if (poll != null) {
                    this.f6863v.execute(this.f6862s);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean y() {
        boolean z2;
        synchronized (this.f6861fb) {
            z2 = !this.y.isEmpty();
        }
        return z2;
    }
}

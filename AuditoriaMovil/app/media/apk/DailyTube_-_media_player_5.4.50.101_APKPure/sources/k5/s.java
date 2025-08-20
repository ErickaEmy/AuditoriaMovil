package k5;

import android.os.Handler;
import android.os.Process;
import androidx.annotation.NonNull;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public class s {

    /* loaded from: classes.dex */
    public static class n3<T> implements Runnable {
        @NonNull

        /* renamed from: fb  reason: collision with root package name */
        public Handler f9586fb;
        @NonNull

        /* renamed from: v  reason: collision with root package name */
        public vl.y<T> f9587v;
        @NonNull
        public Callable<T> y;

        /* loaded from: classes.dex */
        public class y implements Runnable {

            /* renamed from: v  reason: collision with root package name */
            public final /* synthetic */ Object f9589v;
            public final /* synthetic */ vl.y y;

            public y(vl.y yVar, Object obj) {
                this.y = yVar;
                this.f9589v = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                this.y.accept(this.f9589v);
            }
        }

        public n3(@NonNull Handler handler, @NonNull Callable<T> callable, @NonNull vl.y<T> yVar) {
            this.y = callable;
            this.f9587v = yVar;
            this.f9586fb = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            T t2;
            try {
                t2 = this.y.call();
            } catch (Exception unused) {
                t2 = null;
            }
            this.f9586fb.post(new y(this.f9587v, t2));
        }
    }

    /* loaded from: classes.dex */
    public static class y implements ThreadFactory {

        /* renamed from: v  reason: collision with root package name */
        public int f9590v;
        public String y;

        /* renamed from: k5.s$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0130y extends Thread {
            public final int y;

            public C0130y(Runnable runnable, String str, int i) {
                super(runnable, str);
                this.y = i;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.y);
                super.run();
            }
        }

        public y(@NonNull String str, int i) {
            this.y = str;
            this.f9590v = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0130y(runnable, this.y, this.f9590v);
        }
    }

    public static <T> void n3(@NonNull Executor executor, @NonNull Callable<T> callable, @NonNull vl.y<T> yVar) {
        executor.execute(new n3(k5.n3.y(), callable, yVar));
    }

    public static ThreadPoolExecutor y(@NonNull String str, int i, int i5) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i5, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new y(str, i));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static <T> T zn(@NonNull ExecutorService executorService, @NonNull Callable<T> callable, int i) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            throw e2;
        } catch (ExecutionException e3) {
            throw new RuntimeException(e3);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}

package xc;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class n3 extends zn {
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public volatile Handler f14936zn;
    public final Object y = new Object();

    /* renamed from: n3  reason: collision with root package name */
    public final ExecutorService f14935n3 = Executors.newFixedThreadPool(4, new y());

    /* loaded from: classes.dex */
    public class y implements ThreadFactory {
        public final AtomicInteger y = new AtomicInteger(0);

        public y() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.y.getAndIncrement())));
            return thread;
        }
    }

    public static Handler v(@NonNull Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler.createAsync(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }

    @Override // xc.zn
    public void gv(Runnable runnable) {
        if (this.f14936zn == null) {
            synchronized (this.y) {
                try {
                    if (this.f14936zn == null) {
                        this.f14936zn = v(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        this.f14936zn.post(runnable);
    }

    @Override // xc.zn
    public void y(Runnable runnable) {
        this.f14935n3.execute(runnable);
    }

    @Override // xc.zn
    public boolean zn() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }
}

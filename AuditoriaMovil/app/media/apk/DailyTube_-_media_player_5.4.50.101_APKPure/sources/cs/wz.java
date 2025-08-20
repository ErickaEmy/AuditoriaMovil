package cs;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class wz {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6882a = l.f.a("WorkTimer");

    /* renamed from: gv  reason: collision with root package name */
    public final Map<String, n3> f6883gv;

    /* renamed from: n3  reason: collision with root package name */
    public final ScheduledExecutorService f6884n3;

    /* renamed from: v  reason: collision with root package name */
    public final Object f6885v;
    public final ThreadFactory y;

    /* renamed from: zn  reason: collision with root package name */
    public final Map<String, zn> f6886zn;

    /* loaded from: classes.dex */
    public interface n3 {
        void y(@NonNull String str);
    }

    /* loaded from: classes.dex */
    public class y implements ThreadFactory {
        public int y;

        public y() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("WorkManager-WorkTimer-thread-" + this.y);
            this.y = this.y + 1;
            return newThread;
        }
    }

    /* loaded from: classes.dex */
    public static class zn implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final String f6888v;
        public final wz y;

        public zn(@NonNull wz wzVar, @NonNull String str) {
            this.y = wzVar;
            this.f6888v = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.y.f6885v) {
                try {
                    if (this.y.f6886zn.remove(this.f6888v) != null) {
                        n3 remove = this.y.f6883gv.remove(this.f6888v);
                        if (remove != null) {
                            remove.y(this.f6888v);
                        }
                    } else {
                        l.f.zn().y("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.f6888v), new Throwable[0]);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public wz() {
        y yVar = new y();
        this.y = yVar;
        this.f6886zn = new HashMap();
        this.f6883gv = new HashMap();
        this.f6885v = new Object();
        this.f6884n3 = Executors.newSingleThreadScheduledExecutor(yVar);
    }

    public void n3(@NonNull String str, long j2, @NonNull n3 n3Var) {
        synchronized (this.f6885v) {
            l.f.zn().y(f6882a, String.format("Starting timer for %s", str), new Throwable[0]);
            zn(str);
            zn znVar = new zn(this, str);
            this.f6886zn.put(str, znVar);
            this.f6883gv.put(str, n3Var);
            this.f6884n3.schedule(znVar, j2, TimeUnit.MILLISECONDS);
        }
    }

    public void y() {
        if (!this.f6884n3.isShutdown()) {
            this.f6884n3.shutdownNow();
        }
    }

    public void zn(@NonNull String str) {
        synchronized (this.f6885v) {
            try {
                if (this.f6886zn.remove(str) != null) {
                    l.f.zn().y(f6882a, String.format("Stopping timer for %s", str), new Throwable[0]);
                    this.f6883gv.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

package oc1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class v {

    /* renamed from: c5  reason: collision with root package name */
    public static final Logger f12247c5;

    /* renamed from: i9  reason: collision with root package name */
    public static final n3 f12248i9 = new n3(null);

    /* renamed from: s  reason: collision with root package name */
    public static final v f12249s = new v(new zn(lc1.n3.b(lc1.n3.f10302c5 + " TaskRunner", true)));

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f12250a;

    /* renamed from: fb  reason: collision with root package name */
    public final y f12251fb;

    /* renamed from: gv  reason: collision with root package name */
    public final List<oc1.gv> f12252gv;

    /* renamed from: n3  reason: collision with root package name */
    public boolean f12253n3;

    /* renamed from: v  reason: collision with root package name */
    public final List<oc1.gv> f12254v;
    public int y;

    /* renamed from: zn  reason: collision with root package name */
    public long f12255zn;

    /* loaded from: classes.dex */
    public static final class gv implements Runnable {
        public gv() {
        }

        @Override // java.lang.Runnable
        public void run() {
            oc1.y gv2;
            long j2;
            while (true) {
                synchronized (v.this) {
                    gv2 = v.this.gv();
                }
                if (gv2 != null) {
                    oc1.gv gv3 = gv2.gv();
                    Intrinsics.checkNotNull(gv3);
                    boolean isLoggable = v.f12248i9.y().isLoggable(Level.FINE);
                    if (isLoggable) {
                        j2 = gv3.s().fb().nanoTime();
                        oc1.n3.zn(gv2, gv3, "starting");
                    } else {
                        j2 = -1;
                    }
                    try {
                        v.this.i9(gv2);
                        Unit unit = Unit.INSTANCE;
                        if (isLoggable) {
                            oc1.n3.zn(gv2, gv3, "finished run in " + oc1.n3.n3(gv3.s().fb().nanoTime() - j2));
                        }
                    } catch (Throwable th) {
                        if (isLoggable) {
                            oc1.n3.zn(gv2, gv3, "failed a run in " + oc1.n3.n3(gv3.s().fb().nanoTime() - j2));
                        }
                        throw th;
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 {
        public n3() {
        }

        public final Logger y() {
            return v.f12247c5;
        }

        public /* synthetic */ n3(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public interface y {
        void execute(Runnable runnable);

        void n3(v vVar);

        long nanoTime();

        void y(v vVar, long j2);
    }

    /* loaded from: classes.dex */
    public static final class zn implements y {
        public final ThreadPoolExecutor y;

        public zn(ThreadFactory threadFactory) {
            Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
            this.y = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // oc1.v.y
        public void execute(Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.y.execute(runnable);
        }

        @Override // oc1.v.y
        public void n3(v taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            taskRunner.notify();
        }

        @Override // oc1.v.y
        public long nanoTime() {
            return System.nanoTime();
        }

        @Override // oc1.v.y
        public void y(v taskRunner, long j2) throws InterruptedException {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            long j4 = j2 / 1000000;
            long j6 = j2 - (1000000 * j4);
            if (j4 > 0 || j2 > 0) {
                taskRunner.wait(j4, (int) j6);
            }
        }
    }

    static {
        Logger logger = Logger.getLogger(v.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger, "Logger.getLogger(TaskRunner::class.java.name)");
        f12247c5 = logger;
    }

    public v(y backend) {
        Intrinsics.checkNotNullParameter(backend, "backend");
        this.f12251fb = backend;
        this.y = 10000;
        this.f12252gv = new ArrayList();
        this.f12254v = new ArrayList();
        this.f12250a = new gv();
    }

    public final void a() {
        for (int size = this.f12252gv.size() - 1; size >= 0; size--) {
            this.f12252gv.get(size).n3();
        }
        for (int size2 = this.f12254v.size() - 1; size2 >= 0; size2--) {
            oc1.gv gvVar = this.f12254v.get(size2);
            gvVar.n3();
            if (gvVar.v().isEmpty()) {
                this.f12254v.remove(size2);
            }
        }
    }

    public final oc1.gv c5() {
        int i;
        synchronized (this) {
            i = this.y;
            this.y = i + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('Q');
        sb.append(i);
        return new oc1.gv(this, sb.toString());
    }

    public final y fb() {
        return this.f12251fb;
    }

    public final oc1.y gv() {
        boolean z2;
        if (lc1.n3.f10306s && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        while (!this.f12254v.isEmpty()) {
            long nanoTime = this.f12251fb.nanoTime();
            Iterator<oc1.gv> it = this.f12254v.iterator();
            long j2 = Long.MAX_VALUE;
            oc1.y yVar = null;
            while (true) {
                if (it.hasNext()) {
                    oc1.y yVar2 = it.next().v().get(0);
                    long max = Math.max(0L, yVar2.zn() - nanoTime);
                    if (max > 0) {
                        j2 = Math.min(max, j2);
                    } else if (yVar != null) {
                        z2 = true;
                        break;
                    } else {
                        yVar = yVar2;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            if (yVar != null) {
                v(yVar);
                if (z2 || (!this.f12253n3 && !this.f12254v.isEmpty())) {
                    this.f12251fb.execute(this.f12250a);
                }
                return yVar;
            } else if (this.f12253n3) {
                if (j2 < this.f12255zn - nanoTime) {
                    this.f12251fb.n3(this);
                }
                return null;
            } else {
                this.f12253n3 = true;
                this.f12255zn = nanoTime + j2;
                try {
                    try {
                        this.f12251fb.y(this, j2);
                    } catch (InterruptedException unused) {
                        a();
                    }
                } finally {
                    this.f12253n3 = false;
                }
            }
        }
        return null;
    }

    public final void i9(oc1.y yVar) {
        if (lc1.n3.f10306s && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        Thread currentThread2 = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread2, "currentThread");
        String name = currentThread2.getName();
        currentThread2.setName(yVar.n3());
        try {
            long a2 = yVar.a();
            synchronized (this) {
                zn(yVar, a2);
                Unit unit = Unit.INSTANCE;
            }
            currentThread2.setName(name);
        } catch (Throwable th) {
            synchronized (this) {
                zn(yVar, -1L);
                Unit unit2 = Unit.INSTANCE;
                currentThread2.setName(name);
                throw th;
            }
        }
    }

    public final void s(oc1.gv taskQueue) {
        Intrinsics.checkNotNullParameter(taskQueue, "taskQueue");
        if (lc1.n3.f10306s && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        if (taskQueue.zn() == null) {
            if (!taskQueue.v().isEmpty()) {
                lc1.n3.y(this.f12254v, taskQueue);
            } else {
                this.f12254v.remove(taskQueue);
            }
        }
        if (this.f12253n3) {
            this.f12251fb.n3(this);
        } else {
            this.f12251fb.execute(this.f12250a);
        }
    }

    public final void v(oc1.y yVar) {
        if (lc1.n3.f10306s && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        yVar.fb(-1L);
        oc1.gv gv2 = yVar.gv();
        Intrinsics.checkNotNull(gv2);
        gv2.v().remove(yVar);
        this.f12254v.remove(gv2);
        gv2.t(yVar);
        this.f12252gv.add(gv2);
    }

    public final void zn(oc1.y yVar, long j2) {
        boolean z2;
        if (lc1.n3.f10306s && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        oc1.gv gv2 = yVar.gv();
        Intrinsics.checkNotNull(gv2);
        if (gv2.zn() == yVar) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            boolean gv3 = gv2.gv();
            gv2.tl(false);
            gv2.t(null);
            this.f12252gv.remove(gv2);
            if (j2 != -1 && !gv3 && !gv2.fb()) {
                gv2.f(yVar, j2, true);
            }
            if (!gv2.v().isEmpty()) {
                this.f12254v.add(gv2);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.");
    }
}

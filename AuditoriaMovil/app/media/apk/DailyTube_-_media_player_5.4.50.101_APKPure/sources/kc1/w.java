package kc1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import pc1.v;
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayDeque<v.y> f9941a;

    /* renamed from: fb  reason: collision with root package name */
    public final ArrayDeque<pc1.v> f9942fb;

    /* renamed from: gv  reason: collision with root package name */
    public ExecutorService f9943gv;

    /* renamed from: n3  reason: collision with root package name */
    public int f9944n3;

    /* renamed from: v  reason: collision with root package name */
    public final ArrayDeque<v.y> f9945v;
    public int y;

    /* renamed from: zn  reason: collision with root package name */
    public Runnable f9946zn;

    public w() {
        this.y = 64;
        this.f9944n3 = 5;
        this.f9945v = new ArrayDeque<>();
        this.f9941a = new ArrayDeque<>();
        this.f9942fb = new ArrayDeque<>();
    }

    public final void a(v.y call) {
        Intrinsics.checkNotNullParameter(call, "call");
        call.zn().decrementAndGet();
        v(this.f9941a, call);
    }

    public final synchronized int c5() {
        return this.f9941a.size() + this.f9942fb.size();
    }

    public final void fb(pc1.v call) {
        Intrinsics.checkNotNullParameter(call, "call");
        v(this.f9942fb, call);
    }

    public final v.y gv(String str) {
        Iterator<v.y> it = this.f9941a.iterator();
        while (it.hasNext()) {
            v.y next = it.next();
            if (Intrinsics.areEqual(next.gv(), str)) {
                return next;
            }
        }
        Iterator<v.y> it2 = this.f9945v.iterator();
        while (it2.hasNext()) {
            v.y next2 = it2.next();
            if (Intrinsics.areEqual(next2.gv(), str)) {
                return next2;
            }
        }
        return null;
    }

    public final void i9(int i) {
        boolean z2 = true;
        if (i < 1) {
            z2 = false;
        }
        if (z2) {
            synchronized (this) {
                this.y = i;
                Unit unit = Unit.INSTANCE;
            }
            s();
            return;
        }
        throw new IllegalArgumentException(("max < 1: " + i).toString());
    }

    public final synchronized void n3(pc1.v call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.f9942fb.add(call);
    }

    public final boolean s() {
        int i;
        boolean z2;
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
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator<v.y> it = this.f9945v.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "readyAsyncCalls.iterator()");
                while (it.hasNext()) {
                    v.y asyncCall = it.next();
                    if (this.f9941a.size() >= this.y) {
                        break;
                    } else if (asyncCall.zn().get() < this.f9944n3) {
                        it.remove();
                        asyncCall.zn().incrementAndGet();
                        Intrinsics.checkNotNullExpressionValue(asyncCall, "asyncCall");
                        arrayList.add(asyncCall);
                        this.f9941a.add(asyncCall);
                    }
                }
                if (c5() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((v.y) arrayList.get(i)).y(zn());
        }
        return z2;
    }

    public final <T> void v(Deque<T> deque, T t2) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t2)) {
                runnable = this.f9946zn;
                Unit unit = Unit.INSTANCE;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!s() && runnable != null) {
            runnable.run();
        }
    }

    public final void y(v.y call) {
        v.y gv2;
        Intrinsics.checkNotNullParameter(call, "call");
        synchronized (this) {
            try {
                this.f9945v.add(call);
                if (!call.n3().xc() && (gv2 = gv(call.gv())) != null) {
                    call.v(gv2);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        s();
    }

    public final synchronized ExecutorService zn() {
        ExecutorService executorService;
        try {
            if (this.f9943gv == null) {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                SynchronousQueue synchronousQueue = new SynchronousQueue();
                this.f9943gv = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, lc1.n3.b(lc1.n3.f10302c5 + " Dispatcher", false));
            }
            executorService = this.f9943gv;
            Intrinsics.checkNotNull(executorService);
        } catch (Throwable th) {
            throw th;
        }
        return executorService;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w(ExecutorService executorService) {
        this();
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        this.f9943gv = executorService;
    }
}

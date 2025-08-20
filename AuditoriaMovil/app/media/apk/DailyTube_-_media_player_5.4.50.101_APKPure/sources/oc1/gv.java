package oc1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class gv {

    /* renamed from: a  reason: collision with root package name */
    public final String f12242a;

    /* renamed from: gv  reason: collision with root package name */
    public boolean f12243gv;

    /* renamed from: n3  reason: collision with root package name */
    public y f12244n3;

    /* renamed from: v  reason: collision with root package name */
    public final v f12245v;
    public boolean y;

    /* renamed from: zn  reason: collision with root package name */
    public final List<y> f12246zn;

    public gv(v taskRunner, String name) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f12245v = taskRunner;
        this.f12242a = name;
        this.f12246zn = new ArrayList();
    }

    public static /* synthetic */ void i9(gv gvVar, y yVar, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = 0;
        }
        gvVar.c5(yVar, j2);
    }

    public final String a() {
        return this.f12242a;
    }

    public final void c5(y task, long j2) {
        Intrinsics.checkNotNullParameter(task, "task");
        synchronized (this.f12245v) {
            if (this.y) {
                if (task.y()) {
                    if (v.f12248i9.y().isLoggable(Level.FINE)) {
                        n3.y(task, this, "schedule canceled (queue is shutdown)");
                    }
                    return;
                }
                if (v.f12248i9.y().isLoggable(Level.FINE)) {
                    n3.y(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
            if (f(task, j2, false)) {
                this.f12245v.s(this);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean f(y task, long j2, boolean z2) {
        String str;
        Intrinsics.checkNotNullParameter(task, "task");
        task.v(this);
        long nanoTime = this.f12245v.fb().nanoTime();
        long j4 = nanoTime + j2;
        int indexOf = this.f12246zn.indexOf(task);
        if (indexOf != -1) {
            if (task.zn() <= j4) {
                if (v.f12248i9.y().isLoggable(Level.FINE)) {
                    n3.y(task, this, "already scheduled");
                }
                return false;
            }
            this.f12246zn.remove(indexOf);
        }
        task.fb(j4);
        if (v.f12248i9.y().isLoggable(Level.FINE)) {
            if (z2) {
                str = "run again after " + n3.n3(j4 - nanoTime);
            } else {
                str = "scheduled after " + n3.n3(j4 - nanoTime);
            }
            n3.y(task, this, str);
        }
        Iterator<y> it = this.f12246zn.iterator();
        int i = 0;
        while (true) {
            if (it.hasNext()) {
                if (it.next().zn() - nanoTime > j2) {
                    break;
                }
                i++;
            } else {
                i = -1;
                break;
            }
        }
        if (i == -1) {
            i = this.f12246zn.size();
        }
        this.f12246zn.add(i, task);
        if (i != 0) {
            return false;
        }
        return true;
    }

    public final boolean fb() {
        return this.y;
    }

    public final boolean gv() {
        return this.f12243gv;
    }

    public final boolean n3() {
        y yVar = this.f12244n3;
        if (yVar != null) {
            Intrinsics.checkNotNull(yVar);
            if (yVar.y()) {
                this.f12243gv = true;
            }
        }
        boolean z2 = false;
        for (int size = this.f12246zn.size() - 1; size >= 0; size--) {
            if (this.f12246zn.get(size).y()) {
                y yVar2 = this.f12246zn.get(size);
                if (v.f12248i9.y().isLoggable(Level.FINE)) {
                    n3.y(yVar2, this, "canceled");
                }
                this.f12246zn.remove(size);
                z2 = true;
            }
        }
        return z2;
    }

    public final v s() {
        return this.f12245v;
    }

    public final void t(y yVar) {
        this.f12244n3 = yVar;
    }

    public final void tl(boolean z2) {
        this.f12243gv = z2;
    }

    public String toString() {
        return this.f12242a;
    }

    public final List<y> v() {
        return this.f12246zn;
    }

    public final void wz() {
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
        synchronized (this.f12245v) {
            try {
                this.y = true;
                if (n3()) {
                    this.f12245v.s(this);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void y() {
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
        synchronized (this.f12245v) {
            try {
                if (n3()) {
                    this.f12245v.s(this);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final y zn() {
        return this.f12244n3;
    }
}

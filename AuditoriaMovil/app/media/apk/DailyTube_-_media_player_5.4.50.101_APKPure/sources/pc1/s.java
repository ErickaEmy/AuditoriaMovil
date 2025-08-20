package pc1;

import java.lang.ref.Reference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kc1.ta;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pc1.v;
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static final y f12556a = new y(null);

    /* renamed from: gv  reason: collision with root package name */
    public final ConcurrentLinkedQueue<a> f12557gv;

    /* renamed from: n3  reason: collision with root package name */
    public final oc1.gv f12558n3;

    /* renamed from: v  reason: collision with root package name */
    public final int f12559v;
    public final long y;

    /* renamed from: zn  reason: collision with root package name */
    public final n3 f12560zn;

    /* loaded from: classes.dex */
    public static final class n3 extends oc1.y {
        public n3(String str) {
            super(str, false, 2, null);
        }

        @Override // oc1.y
        public long a() {
            return s.this.n3(System.nanoTime());
        }
    }

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public s(oc1.v taskRunner, int i, long j2, TimeUnit timeUnit) {
        boolean z2;
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        this.f12559v = i;
        this.y = timeUnit.toNanos(j2);
        this.f12558n3 = taskRunner.c5();
        this.f12560zn = new n3(lc1.n3.f10302c5 + " ConnectionPool");
        this.f12557gv = new ConcurrentLinkedQueue<>();
        if (j2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return;
        }
        throw new IllegalArgumentException(("keepAliveDuration <= 0: " + j2).toString());
    }

    public final int gv(a aVar, long j2) {
        if (lc1.n3.f10306s && !Thread.holdsLock(aVar)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(aVar);
            throw new AssertionError(sb.toString());
        }
        List<Reference<v>> p2 = aVar.p();
        int i = 0;
        while (i < p2.size()) {
            Reference<v> reference = p2.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                uc1.s.f14065zn.fb().tl("A connection to " + aVar.n3().y().t() + " was leaked. Did you forget to close a response body?", ((v.n3) reference).y());
                p2.remove(i);
                aVar.mg(true);
                if (p2.isEmpty()) {
                    aVar.rz(j2 - this.y);
                    return 0;
                }
            }
        }
        return p2.size();
    }

    public final long n3(long j2) {
        Iterator<a> it = this.f12557gv.iterator();
        int i = 0;
        long j4 = Long.MIN_VALUE;
        a aVar = null;
        int i5 = 0;
        while (it.hasNext()) {
            a connection = it.next();
            Intrinsics.checkNotNullExpressionValue(connection, "connection");
            synchronized (connection) {
                try {
                    if (gv(connection, j2) > 0) {
                        i5++;
                    } else {
                        i++;
                        long mt2 = j2 - connection.mt();
                        if (mt2 > j4) {
                            Unit unit = Unit.INSTANCE;
                            aVar = connection;
                            j4 = mt2;
                        } else {
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        long j6 = this.y;
        if (j4 < j6 && i <= this.f12559v) {
            if (i > 0) {
                return j6 - j4;
            }
            if (i5 > 0) {
                return j6;
            }
            return -1L;
        }
        Intrinsics.checkNotNull(aVar);
        synchronized (aVar) {
            if (!aVar.p().isEmpty()) {
                return 0L;
            }
            if (aVar.mt() + j4 != j2) {
                return 0L;
            }
            aVar.mg(true);
            this.f12557gv.remove(aVar);
            lc1.n3.f(aVar.ta());
            if (this.f12557gv.isEmpty()) {
                this.f12558n3.y();
            }
            return 0L;
        }
    }

    public final void v(a connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (lc1.n3.f10306s && !Thread.holdsLock(connection)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(connection);
            throw new AssertionError(sb.toString());
        }
        this.f12557gv.add(connection);
        oc1.gv.i9(this.f12558n3, this.f12560zn, 0L, 2, null);
    }

    public final boolean y(kc1.y address, v call, List<ta> list, boolean z2) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(call, "call");
        Iterator<a> it = this.f12557gv.iterator();
        while (it.hasNext()) {
            a connection = it.next();
            Intrinsics.checkNotNullExpressionValue(connection, "connection");
            synchronized (connection) {
                if (z2) {
                    try {
                        if (!connection.f3()) {
                            Unit unit = Unit.INSTANCE;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (connection.x4(address, list)) {
                    call.gv(connection);
                    return true;
                }
                Unit unit2 = Unit.INSTANCE;
            }
        }
        return false;
    }

    public final boolean zn(a connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (lc1.n3.f10306s && !Thread.holdsLock(connection)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(connection);
            throw new AssertionError(sb.toString());
        } else if (!connection.co() && this.f12559v != 0) {
            oc1.gv.i9(this.f12558n3, this.f12560zn, 0L, 2, null);
            return false;
        } else {
            connection.mg(true);
            this.f12557gv.remove(connection);
            if (this.f12557gv.isEmpty()) {
                this.f12558n3.y();
            }
            return true;
        }
    }
}

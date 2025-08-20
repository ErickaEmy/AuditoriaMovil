package sc1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import kc1.z;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zc1.d;
import zc1.rz;
import zc1.ta;
/* loaded from: classes.dex */
public final class c5 {

    /* renamed from: xc  reason: collision with root package name */
    public static final y f13749xc = new y(null);

    /* renamed from: a  reason: collision with root package name */
    public boolean f13750a;

    /* renamed from: c5  reason: collision with root package name */
    public final gv f13751c5;

    /* renamed from: f  reason: collision with root package name */
    public sc1.n3 f13752f;

    /* renamed from: fb  reason: collision with root package name */
    public final zn f13753fb;

    /* renamed from: gv  reason: collision with root package name */
    public long f13754gv;

    /* renamed from: i9  reason: collision with root package name */
    public final gv f13755i9;

    /* renamed from: n3  reason: collision with root package name */
    public long f13756n3;

    /* renamed from: s  reason: collision with root package name */
    public final n3 f13757s;

    /* renamed from: t  reason: collision with root package name */
    public IOException f13758t;

    /* renamed from: tl  reason: collision with root package name */
    public final int f13759tl;

    /* renamed from: v  reason: collision with root package name */
    public final ArrayDeque<z> f13760v;

    /* renamed from: wz  reason: collision with root package name */
    public final a f13761wz;
    public long y;

    /* renamed from: zn  reason: collision with root package name */
    public long f13762zn;

    /* loaded from: classes.dex */
    public final class gv extends zc1.zn {
        public gv() {
        }

        public final void mg() throws IOException {
            if (!f3()) {
                return;
            }
            throw n(null);
        }

        public IOException n(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void rz() {
            c5.this.a(sc1.n3.CANCEL);
            c5.this.fb().j3();
        }
    }

    /* loaded from: classes.dex */
    public final class n3 implements rz {

        /* renamed from: fb  reason: collision with root package name */
        public boolean f13765fb;

        /* renamed from: s  reason: collision with root package name */
        public boolean f13766s;

        /* renamed from: v  reason: collision with root package name */
        public z f13767v;
        public final zc1.v y = new zc1.v();

        public n3(boolean z2) {
            this.f13766s = z2;
        }

        public void close() throws IOException {
            boolean z2;
            boolean z3;
            c5 c5Var = c5.this;
            if (lc1.n3.f10306s && Thread.holdsLock(c5Var)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(c5Var);
                throw new AssertionError(sb.toString());
            }
            synchronized (c5.this) {
                if (this.f13765fb) {
                    return;
                }
                if (c5.this.s() == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Unit unit = Unit.INSTANCE;
                if (!c5.this.xc().f13766s) {
                    if (this.y.m() > 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (this.f13767v != null) {
                        while (this.y.m() > 0) {
                            y(false);
                        }
                        a fb2 = c5.this.fb();
                        int i92 = c5.this.i9();
                        z zVar = this.f13767v;
                        Intrinsics.checkNotNull(zVar);
                        fb2.br(i92, z2, lc1.n3.k5(zVar));
                    } else if (z3) {
                        while (this.y.m() > 0) {
                            y(true);
                        }
                    } else if (z2) {
                        c5.this.fb().fc(c5.this.i9(), true, null, 0L);
                    }
                }
                synchronized (c5.this) {
                    this.f13765fb = true;
                    Unit unit2 = Unit.INSTANCE;
                }
                c5.this.fb().flush();
                c5.this.n3();
            }
        }

        public void flush() throws IOException {
            c5 c5Var = c5.this;
            if (lc1.n3.f10306s && Thread.holdsLock(c5Var)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(c5Var);
                throw new AssertionError(sb.toString());
            }
            synchronized (c5.this) {
                c5.this.zn();
                Unit unit = Unit.INSTANCE;
            }
            while (this.y.m() > 0) {
                y(false);
                c5.this.fb().flush();
            }
        }

        public final boolean s() {
            return this.f13766s;
        }

        public d timeout() {
            return c5.this.co();
        }

        public final boolean v() {
            return this.f13765fb;
        }

        public void write(zc1.v source, long j2) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            c5 c5Var = c5.this;
            if (lc1.n3.f10306s && Thread.holdsLock(c5Var)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(c5Var);
                throw new AssertionError(sb.toString());
            }
            this.y.write(source, j2);
            while (this.y.m() >= 16384) {
                y(false);
            }
        }

        public final void y(boolean z2) throws IOException {
            long min;
            boolean z3;
            synchronized (c5.this) {
                try {
                    c5.this.co().i4();
                    while (c5.this.mt() >= c5.this.p() && !this.f13766s && !this.f13765fb && c5.this.s() == null) {
                        c5.this.mg();
                    }
                    c5.this.co().mg();
                    c5.this.zn();
                    min = Math.min(c5.this.p() - c5.this.mt(), this.y.m());
                    c5 c5Var = c5.this;
                    c5Var.fh(c5Var.mt() + min);
                    if (z2 && min == this.y.m()) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            c5.this.co().i4();
            try {
                c5.this.fb().fc(c5.this.i9(), z3, this.y, min);
            } finally {
                c5.this.co().mg();
            }
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

    /* loaded from: classes.dex */
    public final class zn implements ta {

        /* renamed from: f  reason: collision with root package name */
        public final long f13768f;

        /* renamed from: fb  reason: collision with root package name */
        public z f13769fb;

        /* renamed from: s  reason: collision with root package name */
        public boolean f13770s;

        /* renamed from: t  reason: collision with root package name */
        public boolean f13771t;
        public final zc1.v y = new zc1.v();

        /* renamed from: v  reason: collision with root package name */
        public final zc1.v f13772v = new zc1.v();

        public zn(long j2, boolean z2) {
            this.f13768f = j2;
            this.f13771t = z2;
        }

        public void close() throws IOException {
            long m2;
            synchronized (c5.this) {
                this.f13770s = true;
                m2 = this.f13772v.m();
                this.f13772v.s();
                c5 c5Var = c5.this;
                if (c5Var != null) {
                    c5Var.notifyAll();
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                }
            }
            if (m2 > 0) {
                co(m2);
            }
            c5.this.n3();
        }

        public final void co(long j2) {
            c5 c5Var = c5.this;
            if (lc1.n3.f10306s && Thread.holdsLock(c5Var)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(c5Var);
                throw new AssertionError(sb.toString());
            }
            c5.this.fb().bv(j2);
        }

        public final void mt(z zVar) {
            this.f13769fb = zVar;
        }

        public final void p(boolean z2) {
            this.f13771t = z2;
        }

        public long read(zc1.v sink, long j2) throws IOException {
            boolean z2;
            IOException iOException;
            long j4;
            boolean z3;
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (j2 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                do {
                    synchronized (c5.this) {
                        c5.this.tl().i4();
                        if (c5.this.s() != null) {
                            iOException = c5.this.c5();
                            if (iOException == null) {
                                sc1.n3 s2 = c5.this.s();
                                Intrinsics.checkNotNull(s2);
                                iOException = new wz(s2);
                            }
                        } else {
                            iOException = null;
                        }
                        if (!this.f13770s) {
                            if (this.f13772v.m() > 0) {
                                zc1.v vVar = this.f13772v;
                                j4 = vVar.read(sink, Math.min(j2, vVar.m()));
                                c5 c5Var = c5.this;
                                c5Var.d0(c5Var.t() + j4);
                                long t2 = c5.this.t() - c5.this.f();
                                if (iOException == null && t2 >= c5.this.fb().ad().zn() / 2) {
                                    c5.this.fb().n7(c5.this.i9(), t2);
                                    c5 c5Var2 = c5.this;
                                    c5Var2.c(c5Var2.t());
                                }
                            } else if (!this.f13771t && iOException == null) {
                                c5.this.mg();
                                j4 = -1;
                                z3 = true;
                                c5.this.tl().mg();
                                Unit unit = Unit.INSTANCE;
                            } else {
                                j4 = -1;
                            }
                            z3 = false;
                            c5.this.tl().mg();
                            Unit unit2 = Unit.INSTANCE;
                        } else {
                            throw new IOException("stream closed");
                        }
                    }
                } while (z3);
                if (j4 != -1) {
                    co(j4);
                    return j4;
                } else if (iOException == null) {
                    return -1L;
                } else {
                    Intrinsics.checkNotNull(iOException);
                    throw iOException;
                }
            }
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }

        public final void s(zc1.fb source, long j2) throws IOException {
            boolean z2;
            boolean z3;
            boolean z4;
            long j4;
            Intrinsics.checkNotNullParameter(source, "source");
            c5 c5Var = c5.this;
            if (lc1.n3.f10306s && Thread.holdsLock(c5Var)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(c5Var);
                throw new AssertionError(sb.toString());
            }
            while (j2 > 0) {
                synchronized (c5.this) {
                    z2 = this.f13771t;
                    z3 = false;
                    if (this.f13772v.m() + j2 > this.f13768f) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    Unit unit = Unit.INSTANCE;
                }
                if (z4) {
                    source.skip(j2);
                    c5.this.a(sc1.n3.FLOW_CONTROL_ERROR);
                    return;
                } else if (z2) {
                    source.skip(j2);
                    return;
                } else {
                    long read = source.read(this.y, j2);
                    if (read != -1) {
                        j2 -= read;
                        synchronized (c5.this) {
                            try {
                                if (this.f13770s) {
                                    j4 = this.y.m();
                                    this.y.s();
                                } else {
                                    if (this.f13772v.m() == 0) {
                                        z3 = true;
                                    }
                                    this.f13772v.a(this.y);
                                    if (z3) {
                                        c5 c5Var2 = c5.this;
                                        if (c5Var2 != null) {
                                            c5Var2.notifyAll();
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                                        }
                                    }
                                    j4 = 0;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (j4 > 0) {
                            co(j4);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        public d timeout() {
            return c5.this.tl();
        }

        public final boolean v() {
            return this.f13771t;
        }

        public final boolean y() {
            return this.f13770s;
        }
    }

    public c5(int i, a connection, boolean z2, boolean z3, z zVar) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.f13759tl = i;
        this.f13761wz = connection;
        this.f13754gv = connection.cy().zn();
        ArrayDeque<z> arrayDeque = new ArrayDeque<>();
        this.f13760v = arrayDeque;
        this.f13753fb = new zn(connection.ad().zn(), z3);
        this.f13757s = new n3(z2);
        this.f13751c5 = new gv();
        this.f13755i9 = new gv();
        if (zVar != null) {
            if (!z()) {
                arrayDeque.add(zVar);
                return;
            }
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        } else if (z()) {
        } else {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    public final void a(sc1.n3 errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (!v(errorCode, null)) {
            return;
        }
        this.f13761wz.mh(this.f13759tl, errorCode);
    }

    public final void c(long j2) {
        this.f13756n3 = j2;
    }

    public final IOException c5() {
        return this.f13758t;
    }

    public final gv co() {
        return this.f13755i9;
    }

    public final void d0(long j2) {
        this.y = j2;
    }

    public final long f() {
        return this.f13756n3;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0056 A[Catch: all -> 0x004b, TryCatch #0 {all -> 0x004b, blocks: (B:10:0x003d, B:14:0x0045, B:19:0x0056, B:20:0x005b, B:17:0x004d), top: B:27:0x003d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f3(kc1.z r3, boolean r4) {
        /*
            r2 = this;
            java.lang.String r0 = "headers"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            boolean r0 = lc1.n3.f10306s
            if (r0 == 0) goto L3c
            boolean r0 = java.lang.Thread.holdsLock(r2)
            if (r0 != 0) goto L10
            goto L3c
        L10:
            java.lang.AssertionError r3 = new java.lang.AssertionError
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Thread "
            r4.append(r0)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.String r1 = "Thread.currentThread()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r0 = r0.getName()
            r4.append(r0)
            java.lang.String r0 = " MUST NOT hold lock on "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L3c:
            monitor-enter(r2)
            boolean r0 = r2.f13750a     // Catch: java.lang.Throwable -> L4b
            r1 = 1
            if (r0 == 0) goto L4d
            if (r4 != 0) goto L45
            goto L4d
        L45:
            sc1.c5$zn r0 = r2.f13753fb     // Catch: java.lang.Throwable -> L4b
            r0.mt(r3)     // Catch: java.lang.Throwable -> L4b
            goto L54
        L4b:
            r3 = move-exception
            goto L6f
        L4d:
            r2.f13750a = r1     // Catch: java.lang.Throwable -> L4b
            java.util.ArrayDeque<kc1.z> r0 = r2.f13760v     // Catch: java.lang.Throwable -> L4b
            r0.add(r3)     // Catch: java.lang.Throwable -> L4b
        L54:
            if (r4 == 0) goto L5b
            sc1.c5$zn r3 = r2.f13753fb     // Catch: java.lang.Throwable -> L4b
            r3.p(r1)     // Catch: java.lang.Throwable -> L4b
        L5b:
            boolean r3 = r2.r()     // Catch: java.lang.Throwable -> L4b
            r2.notifyAll()     // Catch: java.lang.Throwable -> L4b
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L4b
            monitor-exit(r2)
            if (r3 != 0) goto L6e
            sc1.a r3 = r2.f13761wz
            int r4 = r2.f13759tl
            r3.vn(r4)
        L6e:
            return
        L6f:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: sc1.c5.f3(kc1.z, boolean):void");
    }

    public final a fb() {
        return this.f13761wz;
    }

    public final void fh(long j2) {
        this.f13762zn = j2;
    }

    public final void gv(sc1.n3 rstStatusCode, IOException iOException) throws IOException {
        Intrinsics.checkNotNullParameter(rstStatusCode, "rstStatusCode");
        if (!v(rstStatusCode, iOException)) {
            return;
        }
        this.f13761wz.im(this.f13759tl, rstStatusCode);
    }

    public final void i4(zc1.fb source, int i) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
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
        this.f13753fb.s(source, i);
    }

    public final int i9() {
        return this.f13759tl;
    }

    public final void mg() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final long mt() {
        return this.f13762zn;
    }

    public final synchronized void n(sc1.n3 errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (this.f13752f == null) {
            this.f13752f = errorCode;
            notifyAll();
        }
    }

    public final void n3() throws IOException {
        boolean z2;
        boolean r2;
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
        synchronized (this) {
            try {
                if (this.f13753fb.v() || !this.f13753fb.y() || (!this.f13757s.s() && !this.f13757s.v())) {
                    z2 = false;
                    r2 = r();
                    Unit unit = Unit.INSTANCE;
                }
                z2 = true;
                r2 = r();
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            gv(sc1.n3.CANCEL, null);
        } else if (!r2) {
            this.f13761wz.vn(this.f13759tl);
        }
    }

    public final long p() {
        return this.f13754gv;
    }

    public final synchronized boolean r() {
        try {
            if (this.f13752f != null) {
                return false;
            }
            if (!this.f13753fb.v()) {
                if (this.f13753fb.y()) {
                }
                return true;
            }
            if (this.f13757s.s() || this.f13757s.v()) {
                if (this.f13750a) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized z rz() throws IOException {
        z removeFirst;
        this.f13751c5.i4();
        while (this.f13760v.isEmpty() && this.f13752f == null) {
            mg();
        }
        this.f13751c5.mg();
        if (!this.f13760v.isEmpty()) {
            removeFirst = this.f13760v.removeFirst();
            Intrinsics.checkNotNullExpressionValue(removeFirst, "headersQueue.removeFirst()");
        } else {
            IOException iOException = this.f13758t;
            if (iOException == null) {
                sc1.n3 n3Var = this.f13752f;
                Intrinsics.checkNotNull(n3Var);
                throw new wz(n3Var);
            }
            throw iOException;
        }
        return removeFirst;
    }

    public final synchronized sc1.n3 s() {
        return this.f13752f;
    }

    public final long t() {
        return this.y;
    }

    public final d ta() {
        return this.f13755i9;
    }

    public final gv tl() {
        return this.f13751c5;
    }

    public final boolean v(sc1.n3 n3Var, IOException iOException) {
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
        synchronized (this) {
            if (this.f13752f != null) {
                return false;
            }
            if (this.f13753fb.v() && this.f13757s.s()) {
                return false;
            }
            this.f13752f = n3Var;
            this.f13758t = iOException;
            notifyAll();
            Unit unit = Unit.INSTANCE;
            this.f13761wz.vn(this.f13759tl);
            return true;
        }
    }

    public final zn w() {
        return this.f13753fb;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0013 A[Catch: all -> 0x000e, TRY_LEAVE, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0005, B:13:0x0013, B:17:0x0019, B:18:0x0020), top: B:21:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0019 A[Catch: all -> 0x000e, TRY_ENTER, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0005, B:13:0x0013, B:17:0x0019, B:18:0x0020), top: B:21:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final zc1.rz wz() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f13750a     // Catch: java.lang.Throwable -> Le
            if (r0 != 0) goto L10
            boolean r0 = r2.z()     // Catch: java.lang.Throwable -> Le
            if (r0 == 0) goto Lc
            goto L10
        Lc:
            r0 = 0
            goto L11
        Le:
            r0 = move-exception
            goto L21
        L10:
            r0 = 1
        L11:
            if (r0 == 0) goto L19
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Le
            monitor-exit(r2)
            sc1.c5$n3 r0 = r2.f13757s
            return r0
        L19:
            java.lang.String r0 = "reply before requesting the sink"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Le
            r1.<init>(r0)     // Catch: java.lang.Throwable -> Le
            throw r1     // Catch: java.lang.Throwable -> Le
        L21:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sc1.c5.wz():zc1.rz");
    }

    public final d x4() {
        return this.f13751c5;
    }

    public final n3 xc() {
        return this.f13757s;
    }

    public final void y(long j2) {
        this.f13754gv += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    public final boolean z() {
        boolean z2;
        if ((this.f13759tl & 1) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f13761wz.ap() == z2) {
            return true;
        }
        return false;
    }

    public final void zn() throws IOException {
        if (!this.f13757s.v()) {
            if (!this.f13757s.s()) {
                if (this.f13752f != null) {
                    IOException iOException = this.f13758t;
                    if (iOException == null) {
                        sc1.n3 n3Var = this.f13752f;
                        Intrinsics.checkNotNull(n3Var);
                        throw new wz(n3Var);
                    }
                    throw iOException;
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }
}

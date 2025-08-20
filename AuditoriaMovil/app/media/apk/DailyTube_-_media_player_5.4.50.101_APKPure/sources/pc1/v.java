package pc1;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kc1.d0;
import kc1.n;
import kc1.p;
import kc1.r;
import kc1.rz;
import kc1.w;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class v implements kc1.v {

    /* renamed from: c  reason: collision with root package name */
    public volatile pc1.zn f12562c;

    /* renamed from: co  reason: collision with root package name */
    public pc1.zn f12563co;

    /* renamed from: d  reason: collision with root package name */
    public final d0 f12564d;

    /* renamed from: d0  reason: collision with root package name */
    public volatile a f12565d0;

    /* renamed from: ej  reason: collision with root package name */
    public final boolean f12566ej;

    /* renamed from: f  reason: collision with root package name */
    public Object f12567f;

    /* renamed from: f3  reason: collision with root package name */
    public boolean f12568f3;

    /* renamed from: fb  reason: collision with root package name */
    public final zn f12569fb;

    /* renamed from: fh  reason: collision with root package name */
    public final n f12570fh;

    /* renamed from: n  reason: collision with root package name */
    public volatile boolean f12571n;

    /* renamed from: p  reason: collision with root package name */
    public boolean f12572p;

    /* renamed from: r  reason: collision with root package name */
    public boolean f12573r;

    /* renamed from: s  reason: collision with root package name */
    public final AtomicBoolean f12574s;

    /* renamed from: t  reason: collision with root package name */
    public gv f12575t;

    /* renamed from: v  reason: collision with root package name */
    public final p f12576v;

    /* renamed from: w  reason: collision with root package name */
    public a f12577w;
    public final s y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f12578z;

    /* loaded from: classes.dex */
    public static final class n3 extends WeakReference<v> {
        public final Object y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n3(v referent, Object obj) {
            super(referent);
            Intrinsics.checkNotNullParameter(referent, "referent");
            this.y = obj;
        }

        public final Object y() {
            return this.y;
        }
    }

    /* loaded from: classes.dex */
    public final class y implements Runnable {

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ v f12579fb;

        /* renamed from: v  reason: collision with root package name */
        public final kc1.a f12580v;
        public volatile AtomicInteger y;

        public y(v vVar, kc1.a responseCallback) {
            Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
            this.f12579fb = vVar;
            this.f12580v = responseCallback;
            this.y = new AtomicInteger(0);
        }

        public final String gv() {
            return this.f12579fb.p().t().f();
        }

        public final v n3() {
            return this.f12579fb;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            boolean z2;
            IOException e2;
            w w4;
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "currentThread");
            String name = currentThread.getName();
            currentThread.setName("OkHttp " + this.f12579fb.i4());
            try {
                this.f12579fb.f12569fb.i4();
                try {
                    z2 = true;
                } catch (IOException e3) {
                    e2 = e3;
                    z2 = false;
                } catch (Throwable th2) {
                    th = th2;
                    z2 = false;
                }
                try {
                    this.f12580v.onResponse(this.f12579fb, this.f12579fb.mt());
                    w4 = this.f12579fb.t().w();
                } catch (IOException e5) {
                    e2 = e5;
                    if (z2) {
                        uc1.s.f14065zn.fb().f("Callback failure for " + this.f12579fb.rz(), 4, e2);
                    } else {
                        this.f12580v.onFailure(this.f12579fb, e2);
                    }
                    w4 = this.f12579fb.t().w();
                    w4.a(this);
                } catch (Throwable th3) {
                    th = th3;
                    this.f12579fb.cancel();
                    if (!z2) {
                        IOException iOException = new IOException("canceled due to " + th);
                        ExceptionsKt.addSuppressed(iOException, th);
                        this.f12580v.onFailure(this.f12579fb, iOException);
                    }
                    throw th;
                }
                w4.a(this);
            } finally {
                currentThread.setName(name);
            }
        }

        public final void v(y other) {
            Intrinsics.checkNotNullParameter(other, "other");
            this.y = other.y;
        }

        public final void y(ExecutorService executorService) {
            Intrinsics.checkNotNullParameter(executorService, "executorService");
            w w4 = this.f12579fb.t().w();
            if (lc1.n3.f10306s && Thread.holdsLock(w4)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(w4);
                throw new AssertionError(sb.toString());
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e2) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e2);
                    this.f12579fb.x4(interruptedIOException);
                    this.f12580v.onFailure(this.f12579fb, interruptedIOException);
                    this.f12579fb.t().w().a(this);
                }
            } catch (Throwable th) {
                this.f12579fb.t().w().a(this);
                throw th;
            }
        }

        public final AtomicInteger zn() {
            return this.y;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn extends zc1.zn {
        public zn() {
        }

        public void rz() {
            v.this.cancel();
        }
    }

    public v(n client, d0 originalRequest, boolean z2) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        this.f12570fh = client;
        this.f12564d = originalRequest;
        this.f12566ej = z2;
        this.y = client.tl().y();
        this.f12576v = client.mt().y(this);
        zn znVar = new zn();
        znVar.s(client.c5(), TimeUnit.MILLISECONDS);
        Unit unit = Unit.INSTANCE;
        this.f12569fb = znVar;
        this.f12574s = new AtomicBoolean();
        this.f12568f3 = true;
    }

    public final <E extends IOException> E a(E e2) {
        Socket f32;
        boolean z2;
        boolean z3 = lc1.n3.f10306s;
        if (z3 && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        a aVar = this.f12577w;
        if (aVar != null) {
            if (z3 && Thread.holdsLock(aVar)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Thread ");
                Thread currentThread2 = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread2, "Thread.currentThread()");
                sb2.append(currentThread2.getName());
                sb2.append(" MUST NOT hold lock on ");
                sb2.append(aVar);
                throw new AssertionError(sb2.toString());
            }
            synchronized (aVar) {
                f32 = f3();
            }
            if (this.f12577w == null) {
                if (f32 != null) {
                    lc1.n3.f(f32);
                }
                this.f12576v.t(this, aVar);
            } else {
                if (f32 == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    throw new IllegalStateException("Check failed.");
                }
            }
        }
        E e3 = (E) fh(e2);
        if (e2 != null) {
            p pVar = this.f12576v;
            Intrinsics.checkNotNull(e3);
            pVar.v(this, e3);
        } else {
            this.f12576v.gv(this);
        }
        return e3;
    }

    public final void c(a aVar) {
        this.f12565d0 = aVar;
    }

    public final kc1.y c5(r rVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        kc1.fb fbVar;
        if (rVar.t()) {
            sSLSocketFactory = this.f12570fh.a8();
            hostnameVerifier = this.f12570fh.i4();
            fbVar = this.f12570fh.f();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            fbVar = null;
        }
        return new kc1.y(rVar.f(), rVar.mt(), this.f12570fh.p(), this.f12570fh.ud(), sSLSocketFactory, hostnameVerifier, fbVar, this.f12570fh.ta(), this.f12570fh.mg(), this.f12570fh.rz(), this.f12570fh.wz(), this.f12570fh.d());
    }

    @Override // kc1.v
    public void cancel() {
        if (this.f12571n) {
            return;
        }
        this.f12571n = true;
        pc1.zn znVar = this.f12562c;
        if (znVar != null) {
            znVar.n3();
        }
        a aVar = this.f12565d0;
        if (aVar != null) {
            aVar.fb();
        }
        this.f12576v.fb(this);
    }

    public final pc1.zn co(qc1.fb chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        synchronized (this) {
            if (this.f12568f3) {
                if (!this.f12573r) {
                    if (!this.f12578z) {
                        Unit unit = Unit.INSTANCE;
                    } else {
                        throw new IllegalStateException("Check failed.");
                    }
                } else {
                    throw new IllegalStateException("Check failed.");
                }
            } else {
                throw new IllegalStateException("released");
            }
        }
        gv gvVar = this.f12575t;
        Intrinsics.checkNotNull(gvVar);
        pc1.zn znVar = new pc1.zn(this, this.f12576v, gvVar, gvVar.y(this.f12570fh, chain));
        this.f12563co = znVar;
        this.f12562c = znVar;
        synchronized (this) {
            this.f12578z = true;
            this.f12573r = true;
        }
        if (!this.f12571n) {
            return znVar;
        }
        throw new IOException("Canceled");
    }

    @Override // kc1.v
    public void cy(kc1.a responseCallback) {
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        if (this.f12574s.compareAndSet(false, true)) {
            fb();
            this.f12570fh.w().y(new y(this, responseCallback));
            return;
        }
        throw new IllegalStateException("Already Executed");
    }

    public final void d0() {
        if (!this.f12572p) {
            this.f12572p = true;
            this.f12569fb.f3();
            return;
        }
        throw new IllegalStateException("Check failed.");
    }

    @Override // kc1.v
    public rz execute() {
        if (this.f12574s.compareAndSet(false, true)) {
            this.f12569fb.i4();
            fb();
            try {
                this.f12570fh.w().n3(this);
                return mt();
            } finally {
                this.f12570fh.w().fb(this);
            }
        }
        throw new IllegalStateException("Already Executed");
    }

    public final void f(boolean z2) {
        pc1.zn znVar;
        synchronized (this) {
            if (this.f12568f3) {
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("released");
            }
        }
        if (z2 && (znVar = this.f12562c) != null) {
            znVar.gv();
        }
        this.f12563co = null;
    }

    public final Socket f3() {
        a aVar = this.f12577w;
        Intrinsics.checkNotNull(aVar);
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
        Iterator<Reference<v>> it = p2.iterator();
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().get(), this)) {
                    break;
                }
                i++;
            } else {
                i = -1;
                break;
            }
        }
        if (i != -1) {
            z2 = true;
        }
        if (z2) {
            p2.remove(i);
            this.f12577w = null;
            if (p2.isEmpty()) {
                aVar.rz(System.nanoTime());
                if (this.y.zn(aVar)) {
                    return aVar.ta();
                }
            }
            return null;
        }
        throw new IllegalStateException("Check failed.");
    }

    public final void fb() {
        this.f12567f = uc1.s.f14065zn.fb().c5("response.body().close()");
        this.f12576v.a(this);
    }

    public final <E extends IOException> E fh(E e2) {
        if (this.f12572p) {
            return e2;
        }
        if (!this.f12569fb.f3()) {
            return e2;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (e2 != null) {
            interruptedIOException.initCause(e2);
        }
        return interruptedIOException;
    }

    public final void gv(a connection) {
        boolean z2;
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
        if (this.f12577w == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.f12577w = connection;
            connection.p().add(new n3(this, this.f12567f));
            return;
        }
        throw new IllegalStateException("Check failed.");
    }

    public final String i4() {
        return this.f12564d.t().z();
    }

    public final void i9(d0 request, boolean z2) {
        boolean z3;
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.f12563co == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            synchronized (this) {
                if (!this.f12573r) {
                    if (!this.f12578z) {
                        Unit unit = Unit.INSTANCE;
                    } else {
                        throw new IllegalStateException("Check failed.");
                    }
                } else {
                    throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
                }
            }
            if (z2) {
                this.f12575t = new gv(this.y, c5(request.t()), this, this.f12576v);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kc1.rz mt() throws java.io.IOException {
        /*
            r10 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            kc1.n r0 = r10.f12570fh
            java.util.List r0 = r0.f3()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            kotlin.collections.CollectionsKt.addAll(r2, r0)
            qc1.i9 r0 = new qc1.i9
            kc1.n r1 = r10.f12570fh
            r0.<init>(r1)
            r2.add(r0)
            qc1.y r0 = new qc1.y
            kc1.n r1 = r10.f12570fh
            kc1.wz r1 = r1.xc()
            r0.<init>(r1)
            r2.add(r0)
            nc1.y r0 = new nc1.y
            kc1.n r1 = r10.f12570fh
            kc1.zn r1 = r1.s()
            r0.<init>(r1)
            r2.add(r0)
            pc1.y r0 = pc1.y.y
            r2.add(r0)
            boolean r0 = r10.f12566ej
            if (r0 != 0) goto L4a
            kc1.n r0 = r10.f12570fh
            java.util.List r0 = r0.c()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            kotlin.collections.CollectionsKt.addAll(r2, r0)
        L4a:
            qc1.n3 r0 = new qc1.n3
            boolean r1 = r10.f12566ej
            r0.<init>(r1)
            r2.add(r0)
            qc1.fb r9 = new qc1.fb
            kc1.d0 r5 = r10.f12564d
            kc1.n r0 = r10.f12570fh
            int r6 = r0.t()
            kc1.n r0 = r10.f12570fh
            int r7 = r0.z6()
            kc1.n r0 = r10.f12570fh
            int r8 = r0.b()
            r3 = 0
            r4 = 0
            r0 = r9
            r1 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            r1 = 0
            kc1.d0 r2 = r10.f12564d     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L90
            kc1.rz r2 = r9.n3(r2)     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L90
            boolean r3 = r10.v()     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L90
            if (r3 != 0) goto L83
            r10.x4(r0)
            return r2
        L83:
            lc1.n3.i9(r2)     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L90
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L90
            java.lang.String r3 = "Canceled"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L90
            throw r2     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L90
        L8e:
            r2 = move-exception
            goto La5
        L90:
            r1 = move-exception
            r2 = 1
            java.io.IOException r1 = r10.x4(r1)     // Catch: java.lang.Throwable -> La0
            if (r1 != 0) goto La4
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> La0
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Throwable"
            r1.<init>(r3)     // Catch: java.lang.Throwable -> La0
            throw r1     // Catch: java.lang.Throwable -> La0
        La0:
            r1 = move-exception
            r2 = r1
            r1 = 1
            goto La5
        La4:
            throw r1     // Catch: java.lang.Throwable -> La0
        La5:
            if (r1 != 0) goto Laa
            r10.x4(r0)
        Laa:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: pc1.v.mt():kc1.rz");
    }

    public final boolean n() {
        gv gvVar = this.f12575t;
        Intrinsics.checkNotNull(gvVar);
        return gvVar.v();
    }

    public final d0 p() {
        return this.f12564d;
    }

    public final String rz() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (v()) {
            str = "canceled ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.f12566ej) {
            str2 = "web socket";
        } else {
            str2 = "call";
        }
        sb.append(str2);
        sb.append(" to ");
        sb.append(i4());
        return sb.toString();
    }

    /* renamed from: s */
    public v clone() {
        return new v(this.f12570fh, this.f12564d, this.f12566ej);
    }

    public final n t() {
        return this.f12570fh;
    }

    public final a tl() {
        return this.f12577w;
    }

    @Override // kc1.v
    public boolean v() {
        return this.f12571n;
    }

    public final pc1.zn w() {
        return this.f12563co;
    }

    public final p wz() {
        return this.f12576v;
    }

    public final IOException x4(IOException iOException) {
        boolean z2;
        synchronized (this) {
            try {
                z2 = false;
                if (this.f12568f3) {
                    this.f12568f3 = false;
                    if (!this.f12578z && !this.f12573r) {
                        z2 = true;
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            return a(iOException);
        }
        return iOException;
    }

    public final boolean xc() {
        return this.f12566ej;
    }

    @Override // kc1.v
    public d0 y() {
        return this.f12564d;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0021 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:8:0x0012, B:17:0x0021, B:19:0x0025, B:20:0x0027, B:22:0x002c, B:27:0x0035, B:29:0x0039, B:34:0x0042, B:14:0x001b), top: B:46:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0025 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:8:0x0012, B:17:0x0021, B:19:0x0025, B:20:0x0027, B:22:0x002c, B:27:0x0035, B:29:0x0039, B:34:0x0042, B:14:0x001b), top: B:46:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <E extends java.io.IOException> E z(pc1.zn r2, boolean r3, boolean r4, E r5) {
        /*
            r1 = this;
            java.lang.String r0 = "exchange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            pc1.zn r0 = r1.f12562c
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r0)
            if (r2 != 0) goto Le
            return r5
        Le:
            monitor-enter(r1)
            r2 = 0
            if (r3 == 0) goto L19
            boolean r0 = r1.f12578z     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L1f
            goto L19
        L17:
            r2 = move-exception
            goto L59
        L19:
            if (r4 == 0) goto L41
            boolean r0 = r1.f12573r     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto L41
        L1f:
            if (r3 == 0) goto L23
            r1.f12578z = r2     // Catch: java.lang.Throwable -> L17
        L23:
            if (r4 == 0) goto L27
            r1.f12573r = r2     // Catch: java.lang.Throwable -> L17
        L27:
            boolean r3 = r1.f12578z     // Catch: java.lang.Throwable -> L17
            r4 = 1
            if (r3 != 0) goto L32
            boolean r0 = r1.f12573r     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L32
            r0 = 1
            goto L33
        L32:
            r0 = 0
        L33:
            if (r3 != 0) goto L3e
            boolean r3 = r1.f12573r     // Catch: java.lang.Throwable -> L17
            if (r3 != 0) goto L3e
            boolean r3 = r1.f12568f3     // Catch: java.lang.Throwable -> L17
            if (r3 != 0) goto L3e
            r2 = 1
        L3e:
            r3 = r2
            r2 = r0
            goto L42
        L41:
            r3 = 0
        L42:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L17
            monitor-exit(r1)
            if (r2 == 0) goto L51
            r2 = 0
            r1.f12562c = r2
            pc1.a r2 = r1.f12577w
            if (r2 == 0) goto L51
            r2.r()
        L51:
            if (r3 == 0) goto L58
            java.io.IOException r2 = r1.a(r5)
            return r2
        L58:
            return r5
        L59:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: pc1.v.z(pc1.zn, boolean, boolean, java.io.IOException):java.io.IOException");
    }
}

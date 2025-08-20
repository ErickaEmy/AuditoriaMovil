package pc1;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kc1.c;
import kc1.co;
import kc1.d0;
import kc1.n;
import kc1.p;
import kc1.r;
import kc1.rz;
import kc1.t;
import kc1.ta;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import sc1.a;
import sc1.tl;
import sc1.wz;
/* loaded from: classes.dex */
public final class a extends a.gv implements kc1.i9 {

    /* renamed from: z  reason: collision with root package name */
    public static final y f12517z = new y(null);

    /* renamed from: a  reason: collision with root package name */
    public c f12518a;

    /* renamed from: c5  reason: collision with root package name */
    public zc1.a f12519c5;

    /* renamed from: co  reason: collision with root package name */
    public final ta f12520co;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12521f;

    /* renamed from: fb  reason: collision with root package name */
    public sc1.a f12522fb;

    /* renamed from: gv  reason: collision with root package name */
    public Socket f12523gv;

    /* renamed from: i9  reason: collision with root package name */
    public boolean f12524i9;

    /* renamed from: mt  reason: collision with root package name */
    public final s f12525mt;

    /* renamed from: p  reason: collision with root package name */
    public long f12526p;

    /* renamed from: s  reason: collision with root package name */
    public zc1.fb f12527s;

    /* renamed from: t  reason: collision with root package name */
    public int f12528t;

    /* renamed from: tl  reason: collision with root package name */
    public int f12529tl;

    /* renamed from: v  reason: collision with root package name */
    public co f12530v;

    /* renamed from: w  reason: collision with root package name */
    public final List<Reference<v>> f12531w;

    /* renamed from: wz  reason: collision with root package name */
    public int f12532wz;

    /* renamed from: xc  reason: collision with root package name */
    public int f12533xc;

    /* renamed from: zn  reason: collision with root package name */
    public Socket f12534zn;

    /* loaded from: classes.dex */
    public static final class n3 extends Lambda implements Function0<List<? extends Certificate>> {
        final /* synthetic */ kc1.y $address;
        final /* synthetic */ kc1.fb $certificatePinner;
        final /* synthetic */ co $unverifiedHandshake;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n3(kc1.fb fbVar, co coVar, kc1.y yVar) {
            super(0);
            this.$certificatePinner = fbVar;
            this.$unverifiedHandshake = coVar;
            this.$address = yVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends Certificate> invoke() {
            xc1.zn gv2 = this.$certificatePinner.gv();
            Intrinsics.checkNotNull(gv2);
            return gv2.y(this.$unverifiedHandshake.v(), this.$address.t().f());
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
    public static final class zn extends Lambda implements Function0<List<? extends X509Certificate>> {
        public zn() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends X509Certificate> invoke() {
            co coVar = a.this.f12530v;
            Intrinsics.checkNotNull(coVar);
            List<Certificate> v2 = coVar.v();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(v2, 10));
            for (Certificate certificate : v2) {
                if (certificate == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    public a(s connectionPool, ta route) {
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(route, "route");
        this.f12525mt = connectionPool;
        this.f12520co = route;
        this.f12533xc = 1;
        this.f12531w = new ArrayList();
        this.f12526p = Long.MAX_VALUE;
    }

    public final synchronized void c() {
        this.f12521f = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a2 A[Catch: IOException -> 0x00bd, TRY_LEAVE, TryCatch #2 {IOException -> 0x00bd, blocks: (B:21:0x009a, B:23:0x00a2), top: B:71:0x009a }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x014e A[EDGE_INSN: B:73:0x014e->B:62:0x014e ?: BREAK  ] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c5(int r17, int r18, int r19, int r20, boolean r21, kc1.v r22, kc1.p r23) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pc1.a.c5(int, int, int, int, boolean, kc1.v, kc1.p):void");
    }

    public final boolean co() {
        return this.f12524i9;
    }

    public final void d(int i) throws IOException {
        Socket socket = this.f12523gv;
        Intrinsics.checkNotNull(socket);
        zc1.fb fbVar = this.f12527s;
        Intrinsics.checkNotNull(fbVar);
        zc1.a aVar = this.f12519c5;
        Intrinsics.checkNotNull(aVar);
        socket.setSoTimeout(0);
        sc1.a y2 = new a.n3(true, oc1.v.f12249s).tl(socket, this.f12520co.y().t().f(), fbVar, aVar).f(this).t(i).y();
        this.f12522fb = y2;
        this.f12533xc = sc1.a.f13645en.y().gv();
        sc1.a.gf(y2, false, null, 3, null);
    }

    public final synchronized void d0() {
        this.f12524i9 = true;
    }

    public final synchronized void ej(v call, IOException iOException) {
        try {
            Intrinsics.checkNotNullParameter(call, "call");
            if (iOException instanceof wz) {
                if (((wz) iOException).errorCode == sc1.n3.REFUSED_STREAM) {
                    int i = this.f12532wz + 1;
                    this.f12532wz = i;
                    if (i > 1) {
                        this.f12524i9 = true;
                        this.f12528t++;
                    }
                } else if (((wz) iOException).errorCode != sc1.n3.CANCEL || !call.v()) {
                    this.f12524i9 = true;
                    this.f12528t++;
                }
            } else if (!f3() || (iOException instanceof sc1.y)) {
                this.f12524i9 = true;
                if (this.f12529tl == 0) {
                    if (iOException != null) {
                        i9(call.t(), this.f12520co, iOException);
                    }
                    this.f12528t++;
                }
            }
        } finally {
        }
    }

    public final void f(int i, int i5, kc1.v vVar, p pVar) throws IOException {
        Socket socket;
        int i6;
        Proxy n32 = this.f12520co.n3();
        kc1.y y2 = this.f12520co.y();
        Proxy.Type type = n32.type();
        if (type == null || ((i6 = fb.y[type.ordinal()]) != 1 && i6 != 2)) {
            socket = new Socket(n32);
        } else {
            socket = y2.i9().createSocket();
            Intrinsics.checkNotNull(socket);
        }
        this.f12534zn = socket;
        pVar.i9(vVar, this.f12520co.gv(), n32);
        socket.setSoTimeout(i5);
        try {
            uc1.s.f14065zn.fb().a(socket, this.f12520co.gv(), i);
            try {
                this.f12527s = zc1.p.gv(zc1.p.tl(socket));
                this.f12519c5 = zc1.p.zn(zc1.p.c5(socket));
            } catch (NullPointerException e2) {
                if (!Intrinsics.areEqual(e2.getMessage(), "throw with null exception")) {
                    return;
                }
                throw new IOException(e2);
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f12520co.gv());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    public final boolean f3() {
        if (this.f12522fb != null) {
            return true;
        }
        return false;
    }

    public final void fb() {
        Socket socket = this.f12534zn;
        if (socket != null) {
            lc1.n3.f(socket);
        }
    }

    public final boolean fh(List<ta> list) {
        List<ta> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        for (ta taVar : list2) {
            Proxy.Type type = taVar.n3().type();
            Proxy.Type type2 = Proxy.Type.DIRECT;
            if (type == type2 && this.f12520co.n3().type() == type2 && Intrinsics.areEqual(this.f12520co.gv(), taVar.gv())) {
                return true;
            }
        }
        return false;
    }

    @Override // sc1.a.gv
    public synchronized void gv(sc1.a connection, tl settings) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.f12533xc = settings.gv();
    }

    public final boolean i4(boolean z2) {
        long j2;
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
        long nanoTime = System.nanoTime();
        Socket socket = this.f12534zn;
        Intrinsics.checkNotNull(socket);
        Socket socket2 = this.f12523gv;
        Intrinsics.checkNotNull(socket2);
        zc1.fb fbVar = this.f12527s;
        Intrinsics.checkNotNull(fbVar);
        if (!socket.isClosed() && !socket2.isClosed() && !socket2.isInputShutdown() && !socket2.isOutputShutdown()) {
            sc1.a aVar = this.f12522fb;
            if (aVar != null) {
                return aVar.w2(nanoTime);
            }
            synchronized (this) {
                j2 = nanoTime - this.f12526p;
            }
            if (j2 >= 10000000000L && z2) {
                return lc1.n3.mg(socket2, fbVar);
            }
            return true;
        }
        return false;
    }

    public final void i9(n client, ta failedRoute, IOException failure) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(failedRoute, "failedRoute");
        Intrinsics.checkNotNullParameter(failure, "failure");
        if (failedRoute.n3().type() != Proxy.Type.DIRECT) {
            kc1.y y2 = failedRoute.y();
            y2.c5().connectFailed(y2.t().i4(), failedRoute.n3().address(), failure);
        }
        client.x4().n3(failedRoute);
    }

    public final void mg(boolean z2) {
        this.f12524i9 = z2;
    }

    public final long mt() {
        return this.f12526p;
    }

    public final qc1.gv n(n client, qc1.fb chain) throws SocketException {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Socket socket = this.f12523gv;
        Intrinsics.checkNotNull(socket);
        zc1.fb fbVar = this.f12527s;
        Intrinsics.checkNotNull(fbVar);
        zc1.a aVar = this.f12519c5;
        Intrinsics.checkNotNull(aVar);
        sc1.a aVar2 = this.f12522fb;
        if (aVar2 != null) {
            return new sc1.fb(client, this, chain, aVar2);
        }
        socket.setSoTimeout(chain.t());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        fbVar.timeout().s(chain.c5(), timeUnit);
        aVar.timeout().s(chain.f(), timeUnit);
        return new rc1.n3(client, this, fbVar, aVar);
    }

    @Override // kc1.i9
    public ta n3() {
        return this.f12520co;
    }

    public final List<Reference<v>> p() {
        return this.f12531w;
    }

    public final synchronized void r() {
        this.f12529tl++;
    }

    public final void rz(long j2) {
        this.f12526p = j2;
    }

    public final boolean s(r rVar, co coVar) {
        List<Certificate> v2 = coVar.v();
        if (v2.isEmpty()) {
            return false;
        }
        xc1.gv gvVar = xc1.gv.y;
        String f4 = rVar.f();
        Certificate certificate = v2.get(0);
        if (certificate != null) {
            if (!gvVar.v(f4, (X509Certificate) certificate)) {
                return false;
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
    }

    public final void t(pc1.n3 n3Var) throws IOException {
        c cVar;
        kc1.y y2 = this.f12520co.y();
        SSLSocketFactory f4 = y2.f();
        SSLSocket sSLSocket = null;
        String str = null;
        try {
            Intrinsics.checkNotNull(f4);
            Socket createSocket = f4.createSocket(this.f12534zn, y2.t().f(), y2.t().mt(), true);
            if (createSocket != null) {
                SSLSocket sSLSocket2 = (SSLSocket) createSocket;
                try {
                    t y7 = n3Var.y(sSLSocket2);
                    if (y7.s()) {
                        uc1.s.f14065zn.fb().v(sSLSocket2, y2.t().f(), y2.a());
                    }
                    sSLSocket2.startHandshake();
                    SSLSession sslSocketSession = sSLSocket2.getSession();
                    co.y yVar = co.f9720v;
                    Intrinsics.checkNotNullExpressionValue(sslSocketSession, "sslSocketSession");
                    co y8 = yVar.y(sslSocketSession);
                    HostnameVerifier v2 = y2.v();
                    Intrinsics.checkNotNull(v2);
                    if (!v2.verify(y2.t().f(), sslSocketSession)) {
                        List<Certificate> v3 = y8.v();
                        if (!v3.isEmpty()) {
                            Certificate certificate = v3.get(0);
                            if (certificate == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                            }
                            X509Certificate x509Certificate = (X509Certificate) certificate;
                            StringBuilder sb = new StringBuilder();
                            sb.append("\n              |Hostname ");
                            sb.append(y2.t().f());
                            sb.append(" not verified:\n              |    certificate: ");
                            sb.append(kc1.fb.f9756gv.y(x509Certificate));
                            sb.append("\n              |    DN: ");
                            Principal subjectDN = x509Certificate.getSubjectDN();
                            Intrinsics.checkNotNullExpressionValue(subjectDN, "cert.subjectDN");
                            sb.append(subjectDN.getName());
                            sb.append("\n              |    subjectAltNames: ");
                            sb.append(xc1.gv.y.y(x509Certificate));
                            sb.append("\n              ");
                            throw new SSLPeerUnverifiedException(StringsKt.trimMargin$default(sb.toString(), null, 1, null));
                        }
                        throw new SSLPeerUnverifiedException("Hostname " + y2.t().f() + " not verified (no certificates)");
                    }
                    kc1.fb y9 = y2.y();
                    Intrinsics.checkNotNull(y9);
                    this.f12530v = new co(y8.fb(), y8.y(), y8.zn(), new n3(y9, y8, y2));
                    y9.n3(y2.t().f(), new zn());
                    if (y7.s()) {
                        str = uc1.s.f14065zn.fb().s(sSLSocket2);
                    }
                    this.f12523gv = sSLSocket2;
                    this.f12527s = zc1.p.gv(zc1.p.tl(sSLSocket2));
                    this.f12519c5 = zc1.p.zn(zc1.p.c5(sSLSocket2));
                    if (str != null) {
                        cVar = c.f9603p.y(str);
                    } else {
                        cVar = c.HTTP_1_1;
                    }
                    this.f12518a = cVar;
                    uc1.s.f14065zn.fb().n3(sSLSocket2);
                    return;
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        uc1.s.f14065zn.fb().n3(sSLSocket);
                    }
                    if (sSLSocket != null) {
                        lc1.n3.f(sSLSocket);
                    }
                    throw th;
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public Socket ta() {
        Socket socket = this.f12523gv;
        Intrinsics.checkNotNull(socket);
        return socket;
    }

    public final void tl(int i, int i5, int i6, kc1.v vVar, p pVar) throws IOException {
        d0 xc2 = xc();
        r t2 = xc2.t();
        for (int i8 = 0; i8 < 21; i8++) {
            f(i, i5, vVar, pVar);
            xc2 = wz(i5, i6, xc2, t2);
            if (xc2 != null) {
                Socket socket = this.f12534zn;
                if (socket != null) {
                    lc1.n3.f(socket);
                }
                this.f12534zn = null;
                this.f12519c5 = null;
                this.f12527s = null;
                pVar.s(vVar, this.f12520co.gv(), this.f12520co.n3(), null);
            } else {
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f12520co.y().t().f());
        sb.append(':');
        sb.append(this.f12520co.y().t().mt());
        sb.append(',');
        sb.append(" proxy=");
        sb.append(this.f12520co.n3());
        sb.append(" hostAddress=");
        sb.append(this.f12520co.gv());
        sb.append(" cipherSuite=");
        co coVar = this.f12530v;
        sb.append((coVar == null || (r1 = coVar.y()) == null) ? "none" : "none");
        sb.append(" protocol=");
        sb.append(this.f12518a);
        sb.append('}');
        return sb.toString();
    }

    @Override // sc1.a.gv
    public void v(sc1.c5 stream) throws IOException {
        Intrinsics.checkNotNullParameter(stream, "stream");
        stream.gv(sc1.n3.REFUSED_STREAM, null);
    }

    public final void w(pc1.n3 n3Var, int i, kc1.v vVar, p pVar) throws IOException {
        if (this.f12520co.y().f() == null) {
            List<c> a2 = this.f12520co.y().a();
            c cVar = c.H2_PRIOR_KNOWLEDGE;
            if (a2.contains(cVar)) {
                this.f12523gv = this.f12534zn;
                this.f12518a = cVar;
                d(i);
                return;
            }
            this.f12523gv = this.f12534zn;
            this.f12518a = c.HTTP_1_1;
            return;
        }
        pVar.rz(vVar);
        t(n3Var);
        pVar.fh(vVar, this.f12530v);
        if (this.f12518a == c.HTTP_2) {
            d(i);
        }
    }

    public final d0 wz(int i, int i5, d0 d0Var, r rVar) throws IOException {
        String str = "CONNECT " + lc1.n3.vl(rVar, true) + " HTTP/1.1";
        while (true) {
            zc1.fb fbVar = this.f12527s;
            Intrinsics.checkNotNull(fbVar);
            zc1.a aVar = this.f12519c5;
            Intrinsics.checkNotNull(aVar);
            rc1.n3 n3Var = new rc1.n3(null, this, fbVar, aVar);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            fbVar.timeout().s(i, timeUnit);
            aVar.timeout().s(i5, timeUnit);
            n3Var.d0(d0Var.a(), str);
            n3Var.y();
            rz.y v2 = n3Var.v(false);
            Intrinsics.checkNotNull(v2);
            rz zn2 = v2.co(d0Var).zn();
            n3Var.c(zn2);
            int mt2 = zn2.mt();
            if (mt2 != 200) {
                if (mt2 == 407) {
                    d0 y2 = this.f12520co.y().s().y(this.f12520co, zn2);
                    if (y2 != null) {
                        if (StringsKt.equals("close", rz.d(zn2, "Connection", null, 2, null), true)) {
                            return y2;
                        }
                        d0Var = y2;
                    } else {
                        throw new IOException("Failed to authenticate with proxy");
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + zn2.mt());
                }
            } else if (fbVar.zn().nf() && aVar.zn().nf()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    public final boolean x4(kc1.y address, List<ta> list) {
        Intrinsics.checkNotNullParameter(address, "address");
        if (lc1.n3.f10306s && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        } else if (this.f12531w.size() >= this.f12533xc || this.f12524i9 || !this.f12520co.y().gv(address)) {
            return false;
        } else {
            if (Intrinsics.areEqual(address.t().f(), n3().y().t().f())) {
                return true;
            }
            if (this.f12522fb == null || list == null || !fh(list) || address.v() != xc1.gv.y || !z6(address.t())) {
                return false;
            }
            try {
                kc1.fb y2 = address.y();
                Intrinsics.checkNotNull(y2);
                String f4 = address.t().f();
                co zn2 = zn();
                Intrinsics.checkNotNull(zn2);
                y2.y(f4, zn2.v());
                return true;
            } catch (SSLPeerUnverifiedException unused) {
                return false;
            }
        }
    }

    public final d0 xc() throws IOException {
        d0 n32 = new d0.y().p(this.f12520co.y().t()).c5("CONNECT", null).fb("Host", lc1.n3.vl(this.f12520co.y().t(), true)).fb("Proxy-Connection", "Keep-Alive").fb("User-Agent", "okhttp/4.9.3").n3();
        d0 y2 = this.f12520co.y().s().y(this.f12520co, new rz.y().co(n32).w(c.HTTP_1_1).fb(407).tl("Preemptive Authenticate").n3(lc1.n3.f10308zn).z(-1L).p(-1L).i9("Proxy-Authenticate", "OkHttp-Preemptive").zn());
        if (y2 != null) {
            return y2;
        }
        return n32;
    }

    @Override // kc1.i9
    public c y() {
        c cVar = this.f12518a;
        Intrinsics.checkNotNull(cVar);
        return cVar;
    }

    public final int z() {
        return this.f12528t;
    }

    public final boolean z6(r rVar) {
        co coVar;
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
        r t2 = this.f12520co.y().t();
        if (rVar.mt() != t2.mt()) {
            return false;
        }
        if (Intrinsics.areEqual(rVar.f(), t2.f())) {
            return true;
        }
        if (this.f12521f || (coVar = this.f12530v) == null) {
            return false;
        }
        Intrinsics.checkNotNull(coVar);
        if (!s(rVar, coVar)) {
            return false;
        }
        return true;
    }

    @Override // kc1.i9
    public co zn() {
        return this.f12530v;
    }
}

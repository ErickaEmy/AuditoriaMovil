package kc1;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kc1.p;
import kc1.v;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dns;
import uc1.s;
import xc1.zn;
/* loaded from: classes.dex */
public class n implements Cloneable, v.y {

    /* renamed from: b  reason: collision with root package name */
    public final List<c> f9807b;

    /* renamed from: c  reason: collision with root package name */
    public final ProxySelector f9808c;

    /* renamed from: co  reason: collision with root package name */
    public final boolean f9809co;

    /* renamed from: d  reason: collision with root package name */
    public final SSLSocketFactory f9810d;

    /* renamed from: d0  reason: collision with root package name */
    public final kc1.n3 f9811d0;

    /* renamed from: ej  reason: collision with root package name */
    public final X509TrustManager f9812ej;

    /* renamed from: en  reason: collision with root package name */
    public final pc1.c5 f9813en;

    /* renamed from: f  reason: collision with root package name */
    public final p.zn f9814f;

    /* renamed from: f3  reason: collision with root package name */
    public final Dns f9815f3;

    /* renamed from: f7  reason: collision with root package name */
    public final long f9816f7;

    /* renamed from: fb  reason: collision with root package name */
    public final List<x4> f9817fb;

    /* renamed from: fh  reason: collision with root package name */
    public final SocketFactory f9818fh;

    /* renamed from: j  reason: collision with root package name */
    public final int f9819j;

    /* renamed from: j5  reason: collision with root package name */
    public final HostnameVerifier f9820j5;

    /* renamed from: k  reason: collision with root package name */
    public final int f9821k;

    /* renamed from: n  reason: collision with root package name */
    public final Proxy f9822n;

    /* renamed from: o  reason: collision with root package name */
    public final xc1.zn f9823o;

    /* renamed from: oz  reason: collision with root package name */
    public final int f9824oz;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f9825p;

    /* renamed from: q9  reason: collision with root package name */
    public final int f9826q9;

    /* renamed from: qn  reason: collision with root package name */
    public final fb f9827qn;

    /* renamed from: r  reason: collision with root package name */
    public final zn f9828r;

    /* renamed from: s  reason: collision with root package name */
    public final List<x4> f9829s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f9830t;

    /* renamed from: ut  reason: collision with root package name */
    public final int f9831ut;

    /* renamed from: v  reason: collision with root package name */
    public final f f9832v;

    /* renamed from: w  reason: collision with root package name */
    public final kc1.n3 f9833w;

    /* renamed from: x  reason: collision with root package name */
    public final List<t> f9834x;
    public final w y;

    /* renamed from: z  reason: collision with root package name */
    public final wz f9835z;

    /* renamed from: y5  reason: collision with root package name */
    public static final n3 f9806y5 = new n3(null);

    /* renamed from: jz  reason: collision with root package name */
    public static final List<c> f9804jz = lc1.n3.z(c.HTTP_2, c.HTTP_1_1);

    /* renamed from: u  reason: collision with root package name */
    public static final List<t> f9805u = lc1.n3.z(t.f9918s, t.f9917i9);

    /* loaded from: classes.dex */
    public static final class n3 {
        public n3() {
        }

        public final List<c> n3() {
            return n.f9804jz;
        }

        public final List<t> y() {
            return n.f9805u;
        }

        public /* synthetic */ n3(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public n(y builder) {
        ProxySelector x2;
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.y = builder.f3();
        this.f9832v = builder.r();
        this.f9817fb = lc1.n3.j5(builder.mg());
        this.f9829s = lc1.n3.j5(builder.d());
        this.f9814f = builder.c();
        this.f9830t = builder.k5();
        this.f9833w = builder.xc();
        this.f9825p = builder.d0();
        this.f9809co = builder.fh();
        this.f9835z = builder.i4();
        this.f9828r = builder.w();
        this.f9815f3 = builder.n();
        this.f9822n = builder.ud();
        if (builder.ud() != null) {
            x2 = wc1.y.y;
        } else {
            x2 = builder.x();
            x2 = x2 == null ? ProxySelector.getDefault() : x2;
            if (x2 == null) {
                x2 = wc1.y.y;
            }
        }
        this.f9808c = x2;
        this.f9811d0 = builder.a8();
        this.f9818fh = builder.vl();
        List<t> x42 = builder.x4();
        this.f9834x = x42;
        this.f9807b = builder.ej();
        this.f9820j5 = builder.rz();
        this.f9819j = builder.p();
        this.f9824oz = builder.z();
        this.f9831ut = builder.b();
        this.f9826q9 = builder.j5();
        this.f9821k = builder.z6();
        this.f9816f7 = builder.ta();
        pc1.c5 yt2 = builder.yt();
        this.f9813en = yt2 == null ? new pc1.c5() : yt2;
        List<t> list = x42;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (t tVar : list) {
                if (tVar.a()) {
                    if (builder.hw() != null) {
                        this.f9810d = builder.hw();
                        xc1.zn mt2 = builder.mt();
                        Intrinsics.checkNotNull(mt2);
                        this.f9823o = mt2;
                        X509TrustManager qn2 = builder.qn();
                        Intrinsics.checkNotNull(qn2);
                        this.f9812ej = qn2;
                        fb co2 = builder.co();
                        Intrinsics.checkNotNull(mt2);
                        this.f9827qn = co2.v(mt2);
                    } else {
                        s.y yVar = uc1.s.f14065zn;
                        X509TrustManager w4 = yVar.fb().w();
                        this.f9812ej = w4;
                        uc1.s fb2 = yVar.fb();
                        Intrinsics.checkNotNull(w4);
                        this.f9810d = fb2.xc(w4);
                        zn.y yVar2 = xc1.zn.y;
                        Intrinsics.checkNotNull(w4);
                        xc1.zn y2 = yVar2.y(w4);
                        this.f9823o = y2;
                        fb co3 = builder.co();
                        Intrinsics.checkNotNull(y2);
                        this.f9827qn = co3.v(y2);
                    }
                    x();
                }
            }
        }
        this.f9810d = null;
        this.f9823o = null;
        this.f9812ej = null;
        this.f9827qn = fb.f9757zn;
        x();
    }

    public final SSLSocketFactory a8() {
        SSLSocketFactory sSLSocketFactory = this.f9810d;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    public final int b() {
        return this.f9826q9;
    }

    public final List<x4> c() {
        return this.f9829s;
    }

    public final int c5() {
        return this.f9819j;
    }

    public Object clone() {
        return super.clone();
    }

    public final boolean co() {
        return this.f9825p;
    }

    public final ProxySelector d() {
        return this.f9808c;
    }

    public y d0() {
        return new y(this);
    }

    public final boolean ej() {
        return this.f9830t;
    }

    public final fb f() {
        return this.f9827qn;
    }

    public final List<x4> f3() {
        return this.f9817fb;
    }

    public final kc1.n3 fb() {
        return this.f9833w;
    }

    public final int fh() {
        return this.f9821k;
    }

    public final HostnameVerifier i4() {
        return this.f9820j5;
    }

    public final xc1.zn i9() {
        return this.f9823o;
    }

    public final X509TrustManager k5() {
        return this.f9812ej;
    }

    public final Proxy mg() {
        return this.f9822n;
    }

    public final p.zn mt() {
        return this.f9814f;
    }

    public final long n() {
        return this.f9816f7;
    }

    @Override // kc1.v.y
    public v n3(d0 request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return new pc1.v(this, request, false);
    }

    public final Dns p() {
        return this.f9815f3;
    }

    public final List<c> rz() {
        return this.f9807b;
    }

    public final zn s() {
        return this.f9828r;
    }

    public final int t() {
        return this.f9824oz;
    }

    public final kc1.n3 ta() {
        return this.f9811d0;
    }

    public final f tl() {
        return this.f9832v;
    }

    public final SocketFactory ud() {
        return this.f9818fh;
    }

    public final w w() {
        return this.y;
    }

    public final List<t> wz() {
        return this.f9834x;
    }

    public final void x() {
        boolean z2;
        boolean z3;
        List<x4> list = this.f9817fb;
        if (list != null) {
            if (!list.contains(null)) {
                List<x4> list2 = this.f9829s;
                if (list2 != null) {
                    if (!list2.contains(null)) {
                        List<t> list3 = this.f9834x;
                        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                            for (t tVar : list3) {
                                if (tVar.a()) {
                                    if (this.f9810d != null) {
                                        if (this.f9823o != null) {
                                            if (this.f9812ej == null) {
                                                throw new IllegalStateException("x509TrustManager == null");
                                            }
                                            return;
                                        }
                                        throw new IllegalStateException("certificateChainCleaner == null");
                                    }
                                    throw new IllegalStateException("sslSocketFactory == null");
                                }
                            }
                        }
                        boolean z4 = false;
                        if (this.f9810d == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            if (this.f9823o == null) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                if (this.f9812ej == null) {
                                    z4 = true;
                                }
                                if (z4) {
                                    if (Intrinsics.areEqual(this.f9827qn, fb.f9757zn)) {
                                        return;
                                    }
                                    throw new IllegalStateException("Check failed.");
                                }
                                throw new IllegalStateException("Check failed.");
                            }
                            throw new IllegalStateException("Check failed.");
                        }
                        throw new IllegalStateException("Check failed.");
                    }
                    throw new IllegalStateException(("Null network interceptor: " + this.f9829s).toString());
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
            }
            throw new IllegalStateException(("Null interceptor: " + this.f9817fb).toString());
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
    }

    public final pc1.c5 x4() {
        return this.f9813en;
    }

    public final wz xc() {
        return this.f9835z;
    }

    public final boolean z() {
        return this.f9809co;
    }

    public final int z6() {
        return this.f9831ut;
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: a  reason: collision with root package name */
        public boolean f9836a;

        /* renamed from: c  reason: collision with root package name */
        public int f9837c;

        /* renamed from: c5  reason: collision with root package name */
        public boolean f9838c5;

        /* renamed from: co  reason: collision with root package name */
        public List<t> f9839co;

        /* renamed from: d0  reason: collision with root package name */
        public int f9840d0;

        /* renamed from: f  reason: collision with root package name */
        public zn f9841f;

        /* renamed from: f3  reason: collision with root package name */
        public int f9842f3;

        /* renamed from: fb  reason: collision with root package name */
        public kc1.n3 f9843fb;

        /* renamed from: fh  reason: collision with root package name */
        public int f9844fh;

        /* renamed from: gv  reason: collision with root package name */
        public final List<x4> f9845gv;

        /* renamed from: i4  reason: collision with root package name */
        public xc1.zn f9846i4;

        /* renamed from: i9  reason: collision with root package name */
        public wz f9847i9;

        /* renamed from: mg  reason: collision with root package name */
        public pc1.c5 f9848mg;

        /* renamed from: mt  reason: collision with root package name */
        public X509TrustManager f9849mt;

        /* renamed from: n  reason: collision with root package name */
        public int f9850n;

        /* renamed from: n3  reason: collision with root package name */
        public f f9851n3;

        /* renamed from: p  reason: collision with root package name */
        public SSLSocketFactory f9852p;

        /* renamed from: r  reason: collision with root package name */
        public HostnameVerifier f9853r;

        /* renamed from: rz  reason: collision with root package name */
        public long f9854rz;

        /* renamed from: s  reason: collision with root package name */
        public boolean f9855s;

        /* renamed from: t  reason: collision with root package name */
        public Dns f9856t;

        /* renamed from: tl  reason: collision with root package name */
        public Proxy f9857tl;

        /* renamed from: v  reason: collision with root package name */
        public p.zn f9858v;

        /* renamed from: w  reason: collision with root package name */
        public SocketFactory f9859w;

        /* renamed from: wz  reason: collision with root package name */
        public ProxySelector f9860wz;

        /* renamed from: x4  reason: collision with root package name */
        public fb f9861x4;

        /* renamed from: xc  reason: collision with root package name */
        public kc1.n3 f9862xc;
        public w y;

        /* renamed from: z  reason: collision with root package name */
        public List<? extends c> f9863z;

        /* renamed from: zn  reason: collision with root package name */
        public final List<x4> f9864zn;

        public y() {
            this.y = new w();
            this.f9851n3 = new f();
            this.f9864zn = new ArrayList();
            this.f9845gv = new ArrayList();
            this.f9858v = lc1.n3.v(p.y);
            this.f9836a = true;
            kc1.n3 n3Var = kc1.n3.y;
            this.f9843fb = n3Var;
            this.f9855s = true;
            this.f9838c5 = true;
            this.f9847i9 = wz.y;
            this.f9856t = Dns.SYSTEM;
            this.f9862xc = n3Var;
            SocketFactory socketFactory = SocketFactory.getDefault();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "SocketFactory.getDefault()");
            this.f9859w = socketFactory;
            n3 n3Var2 = n.f9806y5;
            this.f9839co = n3Var2.y();
            this.f9863z = n3Var2.n3();
            this.f9853r = xc1.gv.y;
            this.f9861x4 = fb.f9757zn;
            this.f9850n = 10000;
            this.f9837c = 10000;
            this.f9840d0 = 10000;
            this.f9854rz = 1024L;
        }

        public final y a(long j2, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.f9850n = lc1.n3.s("timeout", j2, unit);
            return this;
        }

        public final kc1.n3 a8() {
            return this.f9862xc;
        }

        public final int b() {
            return this.f9837c;
        }

        public final p.zn c() {
            return this.f9858v;
        }

        public final y c5(wz cookieJar) {
            Intrinsics.checkNotNullParameter(cookieJar, "cookieJar");
            this.f9847i9 = cookieJar;
            return this;
        }

        public final fb co() {
            return this.f9861x4;
        }

        public final List<x4> d() {
            return this.f9845gv;
        }

        public final boolean d0() {
            return this.f9855s;
        }

        public final List<c> ej() {
            return this.f9863z;
        }

        public final y en(SSLSocketFactory sslSocketFactory) {
            Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
            if (!Intrinsics.areEqual(sslSocketFactory, this.f9852p)) {
                this.f9848mg = null;
            }
            this.f9852p = sslSocketFactory;
            s.y yVar = uc1.s.f14065zn;
            X509TrustManager p2 = yVar.fb().p(sslSocketFactory);
            if (p2 != null) {
                this.f9849mt = p2;
                uc1.s fb2 = yVar.fb();
                X509TrustManager x509TrustManager = this.f9849mt;
                Intrinsics.checkNotNull(x509TrustManager);
                this.f9846i4 = fb2.zn(x509TrustManager);
                return this;
            }
            throw new IllegalStateException("Unable to extract the trust manager on " + yVar.fb() + ", sslSocketFactory is " + sslSocketFactory.getClass());
        }

        public final y f(Dns dns) {
            Intrinsics.checkNotNullParameter(dns, "dns");
            if (!Intrinsics.areEqual(dns, this.f9856t)) {
                this.f9848mg = null;
            }
            this.f9856t = dns;
            return this;
        }

        public final w f3() {
            return this.y;
        }

        public final y f7(boolean z2) {
            this.f9836a = z2;
            return this;
        }

        public final y fb(f connectionPool) {
            Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
            this.f9851n3 = connectionPool;
            return this;
        }

        public final boolean fh() {
            return this.f9838c5;
        }

        public final y gv(zn znVar) {
            this.f9841f = znVar;
            return this;
        }

        public final SSLSocketFactory hw() {
            return this.f9852p;
        }

        public final wz i4() {
            return this.f9847i9;
        }

        public final y i9(w dispatcher) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            this.y = dispatcher;
            return this;
        }

        public final List<x4> j() {
            return this.f9864zn;
        }

        public final int j5() {
            return this.f9840d0;
        }

        public final y jz(SSLSocketFactory sslSocketFactory, X509TrustManager trustManager) {
            Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            if (!Intrinsics.areEqual(sslSocketFactory, this.f9852p) || !Intrinsics.areEqual(trustManager, this.f9849mt)) {
                this.f9848mg = null;
            }
            this.f9852p = sslSocketFactory;
            this.f9846i4 = xc1.zn.y.y(trustManager);
            this.f9849mt = trustManager;
            return this;
        }

        public final y k(long j2, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.f9837c = lc1.n3.s("timeout", j2, unit);
            return this;
        }

        public final boolean k5() {
            return this.f9836a;
        }

        public final List<x4> mg() {
            return this.f9864zn;
        }

        public final xc1.zn mt() {
            return this.f9846i4;
        }

        public final Dns n() {
            return this.f9856t;
        }

        public final y n3(x4 interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            this.f9845gv.add(interceptor);
            return this;
        }

        public final y o(HostnameVerifier hostnameVerifier) {
            Intrinsics.checkNotNullParameter(hostnameVerifier, "hostnameVerifier");
            if (!Intrinsics.areEqual(hostnameVerifier, this.f9853r)) {
                this.f9848mg = null;
            }
            this.f9853r = hostnameVerifier;
            return this;
        }

        public final List<x4> oz() {
            return this.f9845gv;
        }

        public final int p() {
            return this.f9842f3;
        }

        public final y q9(ProxySelector proxySelector) {
            Intrinsics.checkNotNullParameter(proxySelector, "proxySelector");
            if (!Intrinsics.areEqual(proxySelector, this.f9860wz)) {
                this.f9848mg = null;
            }
            this.f9860wz = proxySelector;
            return this;
        }

        public final X509TrustManager qn() {
            return this.f9849mt;
        }

        public final f r() {
            return this.f9851n3;
        }

        public final HostnameVerifier rz() {
            return this.f9853r;
        }

        public final y s(List<t> connectionSpecs) {
            Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
            if (!Intrinsics.areEqual(connectionSpecs, this.f9839co)) {
                this.f9848mg = null;
            }
            this.f9839co = lc1.n3.j5(connectionSpecs);
            return this;
        }

        public final y t(p.zn eventListenerFactory) {
            Intrinsics.checkNotNullParameter(eventListenerFactory, "eventListenerFactory");
            this.f9858v = eventListenerFactory;
            return this;
        }

        public final long ta() {
            return this.f9854rz;
        }

        public final y tl(boolean z2) {
            this.f9855s = z2;
            return this;
        }

        public final y u(long j2, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.f9840d0 = lc1.n3.s("timeout", j2, unit);
            return this;
        }

        public final Proxy ud() {
            return this.f9857tl;
        }

        public final y ut(Proxy proxy) {
            if (!Intrinsics.areEqual(proxy, this.f9857tl)) {
                this.f9848mg = null;
            }
            this.f9857tl = proxy;
            return this;
        }

        public final y v(long j2, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.f9842f3 = lc1.n3.s("timeout", j2, unit);
            return this;
        }

        public final SocketFactory vl() {
            return this.f9859w;
        }

        public final zn w() {
            return this.f9841f;
        }

        public final y wz(boolean z2) {
            this.f9838c5 = z2;
            return this;
        }

        public final ProxySelector x() {
            return this.f9860wz;
        }

        public final List<t> x4() {
            return this.f9839co;
        }

        public final kc1.n3 xc() {
            return this.f9843fb;
        }

        public final y y(x4 interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            this.f9864zn.add(interceptor);
            return this;
        }

        public final pc1.c5 yt() {
            return this.f9848mg;
        }

        public final int z() {
            return this.f9850n;
        }

        public final int z6() {
            return this.f9844fh;
        }

        public final n zn() {
            return new n(this);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public y(n okHttpClient) {
            this();
            Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
            this.y = okHttpClient.w();
            this.f9851n3 = okHttpClient.tl();
            CollectionsKt.addAll(this.f9864zn, okHttpClient.f3());
            CollectionsKt.addAll(this.f9845gv, okHttpClient.c());
            this.f9858v = okHttpClient.mt();
            this.f9836a = okHttpClient.ej();
            this.f9843fb = okHttpClient.fb();
            this.f9855s = okHttpClient.co();
            this.f9838c5 = okHttpClient.z();
            this.f9847i9 = okHttpClient.xc();
            this.f9841f = okHttpClient.s();
            this.f9856t = okHttpClient.p();
            this.f9857tl = okHttpClient.mg();
            this.f9860wz = okHttpClient.d();
            this.f9862xc = okHttpClient.ta();
            this.f9859w = okHttpClient.ud();
            this.f9852p = okHttpClient.f9810d;
            this.f9849mt = okHttpClient.k5();
            this.f9839co = okHttpClient.wz();
            this.f9863z = okHttpClient.rz();
            this.f9853r = okHttpClient.i4();
            this.f9861x4 = okHttpClient.f();
            this.f9846i4 = okHttpClient.i9();
            this.f9842f3 = okHttpClient.c5();
            this.f9850n = okHttpClient.t();
            this.f9837c = okHttpClient.z6();
            this.f9840d0 = okHttpClient.b();
            this.f9844fh = okHttpClient.fh();
            this.f9854rz = okHttpClient.n();
            this.f9848mg = okHttpClient.x4();
        }
    }

    public n() {
        this(new y());
    }
}

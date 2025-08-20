package kc1;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kc1.z;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class rz implements Closeable {

    /* renamed from: c  reason: collision with root package name */
    public final pc1.zn f9887c;

    /* renamed from: co  reason: collision with root package name */
    public final rz f9888co;

    /* renamed from: f  reason: collision with root package name */
    public final int f9889f;

    /* renamed from: f3  reason: collision with root package name */
    public final long f9890f3;

    /* renamed from: fb  reason: collision with root package name */
    public final c f9891fb;

    /* renamed from: n  reason: collision with root package name */
    public final long f9892n;

    /* renamed from: p  reason: collision with root package name */
    public final mg f9893p;

    /* renamed from: r  reason: collision with root package name */
    public final rz f9894r;

    /* renamed from: s  reason: collision with root package name */
    public final String f9895s;

    /* renamed from: t  reason: collision with root package name */
    public final co f9896t;

    /* renamed from: v  reason: collision with root package name */
    public final d0 f9897v;

    /* renamed from: w  reason: collision with root package name */
    public final z f9898w;
    public gv y;

    /* renamed from: z  reason: collision with root package name */
    public final rz f9899z;

    public rz(d0 request, c protocol, String message, int i, co coVar, z headers, mg mgVar, rz rzVar, rz rzVar2, rz rzVar3, long j2, long j4, pc1.zn znVar) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.f9897v = request;
        this.f9891fb = protocol;
        this.f9895s = message;
        this.f9889f = i;
        this.f9896t = coVar;
        this.f9898w = headers;
        this.f9893p = mgVar;
        this.f9888co = rzVar;
        this.f9899z = rzVar2;
        this.f9894r = rzVar3;
        this.f9890f3 = j2;
        this.f9892n = j4;
        this.f9887c = znVar;
    }

    public static /* synthetic */ String d(rz rzVar, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return rzVar.ta(str, str2);
    }

    public final long ap() {
        return this.f9890f3;
    }

    public final z b() {
        return this.f9898w;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        mg mgVar = this.f9893p;
        if (mgVar != null) {
            mgVar.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public final pc1.zn co() {
        return this.f9887c;
    }

    public final long ct() {
        return this.f9892n;
    }

    public final c dm() {
        return this.f9891fb;
    }

    public final boolean isSuccessful() {
        int i = this.f9889f;
        if (200 <= i && 299 >= i) {
            return true;
        }
        return false;
    }

    public final mg j(long j2) throws IOException {
        mg mgVar = this.f9893p;
        Intrinsics.checkNotNull(mgVar);
        zc1.fb peek = mgVar.source().peek();
        zc1.fb vVar = new zc1.v();
        peek.gv(j2);
        vVar.qj(peek, Math.min(j2, peek.zn().m()));
        return mg.Companion.a(vVar, this.f9893p.contentType(), vVar.m());
    }

    public final y j5() {
        return new y(this);
    }

    public final rz jz() {
        return this.f9894r;
    }

    public final String k5() {
        return this.f9895s;
    }

    public final int mt() {
        return this.f9889f;
    }

    public final d0 o4() {
        return this.f9897v;
    }

    public final List<s> p() {
        String str;
        z zVar = this.f9898w;
        int i = this.f9889f;
        if (i != 401) {
            if (i != 407) {
                return CollectionsKt.emptyList();
            }
            str = "Proxy-Authenticate";
        } else {
            str = "WWW-Authenticate";
        }
        return qc1.v.n3(zVar, str);
    }

    public final co r() {
        return this.f9896t;
    }

    public final rz s() {
        return this.f9899z;
    }

    public final String ta(String name, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        String y2 = this.f9898w.y(name);
        if (y2 != null) {
            return y2;
        }
        return str;
    }

    public String toString() {
        return "Response{protocol=" + this.f9891fb + ", code=" + this.f9889f + ", message=" + this.f9895s + ", url=" + this.f9897v.t() + '}';
    }

    public final List<String> ud(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f9898w.i9(name);
    }

    public final gv v() {
        gv gvVar = this.y;
        if (gvVar == null) {
            gv n32 = gv.f9766w.n3(this.f9898w);
            this.y = n32;
            return n32;
        }
        return gvVar;
    }

    public final String x4(String str) {
        return d(this, str, null, 2, null);
    }

    public final mg y() {
        return this.f9893p;
    }

    public final rz yt() {
        return this.f9888co;
    }

    /* loaded from: classes.dex */
    public static class y {

        /* renamed from: a  reason: collision with root package name */
        public z.y f9900a;

        /* renamed from: c5  reason: collision with root package name */
        public rz f9901c5;

        /* renamed from: f  reason: collision with root package name */
        public long f9902f;

        /* renamed from: fb  reason: collision with root package name */
        public mg f9903fb;

        /* renamed from: gv  reason: collision with root package name */
        public String f9904gv;

        /* renamed from: i9  reason: collision with root package name */
        public rz f9905i9;

        /* renamed from: n3  reason: collision with root package name */
        public c f9906n3;

        /* renamed from: s  reason: collision with root package name */
        public rz f9907s;

        /* renamed from: t  reason: collision with root package name */
        public long f9908t;

        /* renamed from: tl  reason: collision with root package name */
        public pc1.zn f9909tl;

        /* renamed from: v  reason: collision with root package name */
        public co f9910v;
        public d0 y;

        /* renamed from: zn  reason: collision with root package name */
        public int f9911zn;

        public y() {
            this.f9911zn = -1;
            this.f9900a = new z.y();
        }

        public final void a(String str, rz rzVar) {
            boolean z2;
            boolean z3;
            boolean z4;
            if (rzVar != null) {
                boolean z5 = false;
                if (rzVar.y() == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    if (rzVar.yt() == null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        if (rzVar.s() == null) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            if (rzVar.jz() == null) {
                                z5 = true;
                            }
                            if (!z5) {
                                throw new IllegalArgumentException((str + ".priorResponse != null").toString());
                            }
                            return;
                        }
                        throw new IllegalArgumentException((str + ".cacheResponse != null").toString());
                    }
                    throw new IllegalArgumentException((str + ".networkResponse != null").toString());
                }
                throw new IllegalArgumentException((str + ".body != null").toString());
            }
        }

        public y c5(co coVar) {
            this.f9910v = coVar;
            return this;
        }

        public y co(d0 request) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.y = request;
            return this;
        }

        public y f(z headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.f9900a = headers.v();
            return this;
        }

        public y fb(int i) {
            this.f9911zn = i;
            return this;
        }

        public y gv(rz rzVar) {
            a("cacheResponse", rzVar);
            this.f9901c5 = rzVar;
            return this;
        }

        public y i9(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.f9900a.i9(name, value);
            return this;
        }

        public y mt(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.f9900a.c5(name);
            return this;
        }

        public y n3(mg mgVar) {
            this.f9903fb = mgVar;
            return this;
        }

        public y p(long j2) {
            this.f9908t = j2;
            return this;
        }

        public final int s() {
            return this.f9911zn;
        }

        public final void t(pc1.zn deferredTrailers) {
            Intrinsics.checkNotNullParameter(deferredTrailers, "deferredTrailers");
            this.f9909tl = deferredTrailers;
        }

        public y tl(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.f9904gv = message;
            return this;
        }

        public final void v(rz rzVar) {
            boolean z2;
            if (rzVar != null) {
                if (rzVar.y() == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    throw new IllegalArgumentException("priorResponse.body != null");
                }
            }
        }

        public y w(c protocol) {
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            this.f9906n3 = protocol;
            return this;
        }

        public y wz(rz rzVar) {
            a("networkResponse", rzVar);
            this.f9907s = rzVar;
            return this;
        }

        public y xc(rz rzVar) {
            v(rzVar);
            this.f9905i9 = rzVar;
            return this;
        }

        public y y(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.f9900a.y(name, value);
            return this;
        }

        public y z(long j2) {
            this.f9902f = j2;
            return this;
        }

        public rz zn() {
            boolean z2;
            int i = this.f9911zn;
            if (i >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                d0 d0Var = this.y;
                if (d0Var != null) {
                    c cVar = this.f9906n3;
                    if (cVar != null) {
                        String str = this.f9904gv;
                        if (str != null) {
                            return new rz(d0Var, cVar, str, i, this.f9910v, this.f9900a.a(), this.f9903fb, this.f9907s, this.f9901c5, this.f9905i9, this.f9902f, this.f9908t, this.f9909tl);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("protocol == null");
                }
                throw new IllegalStateException("request == null");
            }
            throw new IllegalStateException(("code < 0: " + this.f9911zn).toString());
        }

        public y(rz response) {
            Intrinsics.checkNotNullParameter(response, "response");
            this.f9911zn = -1;
            this.y = response.o4();
            this.f9906n3 = response.dm();
            this.f9911zn = response.mt();
            this.f9904gv = response.k5();
            this.f9910v = response.r();
            this.f9900a = response.b().v();
            this.f9903fb = response.y();
            this.f9907s = response.yt();
            this.f9901c5 = response.s();
            this.f9905i9 = response.jz();
            this.f9902f = response.ap();
            this.f9908t = response.ct();
            this.f9909tl = response.co();
        }
    }
}

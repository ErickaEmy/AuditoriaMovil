package qc1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kc1.d0;
import kc1.fh;
import kc1.mg;
import kc1.n;
import kc1.r;
import kc1.rz;
import kc1.ta;
import kc1.x4;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
/* loaded from: classes.dex */
public final class i9 implements x4 {

    /* renamed from: n3  reason: collision with root package name */
    public static final y f12800n3 = new y(null);
    public final n y;

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public i9(n client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.y = client;
    }

    public final int a(rz rzVar, int i) {
        String d2 = rz.d(rzVar, "Retry-After", null, 2, null);
        if (d2 != null) {
            if (new Regex("\\d+").matches(d2)) {
                Integer valueOf = Integer.valueOf(d2);
                Intrinsics.checkNotNullExpressionValue(valueOf, "Integer.valueOf(header)");
                return valueOf.intValue();
            }
            return Integer.MAX_VALUE;
        }
        return i;
    }

    public final boolean gv(IOException iOException, pc1.v vVar, d0 d0Var, boolean z2) {
        if (!this.y.ej()) {
            return false;
        }
        if ((z2 && v(iOException, d0Var)) || !zn(iOException, z2) || !vVar.n()) {
            return false;
        }
        return true;
    }

    @Override // kc1.x4
    public rz intercept(x4.y chain) throws IOException {
        pc1.zn w4;
        d0 n32;
        Intrinsics.checkNotNullParameter(chain, "chain");
        fb fbVar = (fb) chain;
        d0 i92 = fbVar.i9();
        pc1.v a2 = fbVar.a();
        List emptyList = CollectionsKt.emptyList();
        rz rzVar = null;
        boolean z2 = true;
        int i = 0;
        while (true) {
            a2.i9(i92, z2);
            try {
                if (!a2.v()) {
                    try {
                        rz n33 = fbVar.n3(i92);
                        if (rzVar != null) {
                            n33 = n33.j5().xc(rzVar.j5().n3(null).zn()).zn();
                        }
                        rzVar = n33;
                        w4 = a2.w();
                        n32 = n3(rzVar, w4);
                    } catch (IOException e2) {
                        if (gv(e2, a2, i92, !(e2 instanceof sc1.y))) {
                            emptyList = CollectionsKt.plus(emptyList, e2);
                            a2.f(true);
                            z2 = false;
                        } else {
                            throw lc1.n3.q9(e2, emptyList);
                        }
                    } catch (pc1.i9 e3) {
                        if (gv(e3.v(), a2, i92, false)) {
                            emptyList = CollectionsKt.plus(emptyList, e3.gv());
                            a2.f(true);
                            z2 = false;
                        } else {
                            throw lc1.n3.q9(e3.gv(), emptyList);
                        }
                    }
                    if (n32 == null) {
                        if (w4 != null && w4.t()) {
                            a2.d0();
                        }
                        a2.f(false);
                        return rzVar;
                    }
                    fh y2 = n32.y();
                    if (y2 != null && y2.isOneShot()) {
                        a2.f(false);
                        return rzVar;
                    }
                    mg y7 = rzVar.y();
                    if (y7 != null) {
                        lc1.n3.i9(y7);
                    }
                    i++;
                    if (i <= 20) {
                        a2.f(true);
                        i92 = n32;
                        z2 = true;
                    } else {
                        throw new ProtocolException("Too many follow-up requests: " + i);
                    }
                } else {
                    throw new IOException("Canceled");
                }
            } catch (Throwable th) {
                a2.f(true);
                throw th;
            }
        }
    }

    public final d0 n3(rz rzVar, pc1.zn znVar) throws IOException {
        ta taVar;
        pc1.a s2;
        if (znVar != null && (s2 = znVar.s()) != null) {
            taVar = s2.n3();
        } else {
            taVar = null;
        }
        int mt2 = rzVar.mt();
        String s3 = rzVar.o4().s();
        if (mt2 != 307 && mt2 != 308) {
            if (mt2 != 401) {
                if (mt2 != 421) {
                    if (mt2 != 503) {
                        if (mt2 != 407) {
                            if (mt2 != 408) {
                                switch (mt2) {
                                    case 300:
                                    case 301:
                                    case 302:
                                    case 303:
                                        break;
                                    default:
                                        return null;
                                }
                            } else if (!this.y.ej()) {
                                return null;
                            } else {
                                fh y2 = rzVar.o4().y();
                                if (y2 != null && y2.isOneShot()) {
                                    return null;
                                }
                                rz jz2 = rzVar.jz();
                                if ((jz2 != null && jz2.mt() == 408) || a(rzVar, 0) > 0) {
                                    return null;
                                }
                                return rzVar.o4();
                            }
                        } else {
                            Intrinsics.checkNotNull(taVar);
                            if (taVar.n3().type() == Proxy.Type.HTTP) {
                                return this.y.ta().y(taVar, rzVar);
                            }
                            throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                        }
                    } else {
                        rz jz3 = rzVar.jz();
                        if ((jz3 != null && jz3.mt() == 503) || a(rzVar, Integer.MAX_VALUE) != 0) {
                            return null;
                        }
                        return rzVar.o4();
                    }
                } else {
                    fh y7 = rzVar.o4().y();
                    if ((y7 != null && y7.isOneShot()) || znVar == null || !znVar.f()) {
                        return null;
                    }
                    znVar.s().c();
                    return rzVar.o4();
                }
            } else {
                return this.y.fb().y(taVar, rzVar);
            }
        }
        return y(rzVar, s3);
    }

    public final boolean v(IOException iOException, d0 d0Var) {
        fh y2 = d0Var.y();
        if ((y2 != null && y2.isOneShot()) || (iOException instanceof FileNotFoundException)) {
            return true;
        }
        return false;
    }

    public final d0 y(rz rzVar, String str) {
        String d2;
        r r2;
        boolean z2;
        fh fhVar = null;
        if (!this.y.co() || (d2 = rz.d(rzVar, "Location", null, 2, null)) == null || (r2 = rzVar.o4().t().r(d2)) == null) {
            return null;
        }
        if (!Intrinsics.areEqual(r2.x4(), rzVar.o4().t().x4()) && !this.y.z()) {
            return null;
        }
        d0.y c52 = rzVar.o4().c5();
        if (a.n3(str)) {
            int mt2 = rzVar.mt();
            a aVar = a.y;
            if (!aVar.gv(str) && mt2 != 308 && mt2 != 307) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (aVar.zn(str) && mt2 != 308 && mt2 != 307) {
                c52.c5("GET", null);
            } else {
                if (z2) {
                    fhVar = rzVar.o4().y();
                }
                c52.c5(str, fhVar);
            }
            if (!z2) {
                c52.tl("Transfer-Encoding");
                c52.tl("Content-Length");
                c52.tl("Content-Type");
            }
        }
        if (!lc1.n3.fb(rzVar.o4().t(), r2)) {
            c52.tl("Authorization");
        }
        return c52.p(r2).n3();
    }

    public final boolean zn(IOException iOException, boolean z2) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || z2) {
                return false;
            }
            return true;
        } else if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        } else {
            return true;
        }
    }
}

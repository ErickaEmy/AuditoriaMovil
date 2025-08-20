package uc1;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kc1.c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vc1.c5;
import vc1.f;
import vc1.i9;
import vc1.t;
/* loaded from: classes.dex */
public final class n3 extends s {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f14059a;

    /* renamed from: fb  reason: collision with root package name */
    public static final y f14060fb = new y(null);

    /* renamed from: gv  reason: collision with root package name */
    public final List<f> f14061gv;

    /* renamed from: v  reason: collision with root package name */
    public final vc1.s f14062v;

    /* renamed from: uc1.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0227n3 implements xc1.v {

        /* renamed from: n3  reason: collision with root package name */
        public final Method f14063n3;
        public final X509TrustManager y;

        public C0227n3(X509TrustManager trustManager, Method findByIssuerAndSignatureMethod) {
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            Intrinsics.checkNotNullParameter(findByIssuerAndSignatureMethod, "findByIssuerAndSignatureMethod");
            this.y = trustManager;
            this.f14063n3 = findByIssuerAndSignatureMethod;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof C0227n3) {
                    C0227n3 c0227n3 = (C0227n3) obj;
                    if (!Intrinsics.areEqual(this.y, c0227n3.y) || !Intrinsics.areEqual(this.f14063n3, c0227n3.f14063n3)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i;
            X509TrustManager x509TrustManager = this.y;
            int i5 = 0;
            if (x509TrustManager != null) {
                i = x509TrustManager.hashCode();
            } else {
                i = 0;
            }
            int i6 = i * 31;
            Method method = this.f14063n3;
            if (method != null) {
                i5 = method.hashCode();
            }
            return i6 + i5;
        }

        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.y + ", findByIssuerAndSignatureMethod=" + this.f14063n3 + ")";
        }

        @Override // xc1.v
        public X509Certificate y(X509Certificate cert) {
            Intrinsics.checkNotNullParameter(cert, "cert");
            try {
                Object invoke = this.f14063n3.invoke(this.y, cert);
                if (invoke != null) {
                    return ((TrustAnchor) invoke).getTrustedCert();
                }
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.TrustAnchor");
            } catch (IllegalAccessException e2) {
                throw new AssertionError("unable to get issues and signature", e2);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public final boolean n3() {
            return n3.f14059a;
        }

        public final s y() {
            if (n3()) {
                return new n3();
            }
            return null;
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        boolean z2 = false;
        if (s.f14065zn.s() && Build.VERSION.SDK_INT < 30) {
            z2 = true;
        }
        f14059a = z2;
    }

    public n3() {
        f[] fVarArr = {t.y.n3(t.f14445i9, null, 1, null), new i9(vc1.a.f14431fb.gv()), new i9(c5.f14436n3.y()), new i9(vc1.fb.f14437n3.y())};
        ArrayList arrayList = new ArrayList();
        for (Object obj : CollectionsKt.listOfNotNull((Object[]) fVarArr)) {
            if (((f) obj).zn()) {
                arrayList.add(obj);
            }
        }
        this.f14061gv = arrayList;
        this.f14062v = vc1.s.f14442gv.y();
    }

    @Override // uc1.s
    public void a(Socket socket, InetSocketAddress address, int i) throws IOException {
        Intrinsics.checkNotNullParameter(socket, "socket");
        Intrinsics.checkNotNullParameter(address, "address");
        try {
            socket.connect(address, i);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT == 26) {
                throw new IOException("Exception in connect", e2);
            }
            throw e2;
        }
    }

    @Override // uc1.s
    public Object c5(String closer) {
        Intrinsics.checkNotNullParameter(closer, "closer");
        return this.f14062v.y(closer);
    }

    @Override // uc1.s
    public xc1.v gv(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        try {
            Method method = trustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            Intrinsics.checkNotNullExpressionValue(method, "method");
            method.setAccessible(true);
            return new C0227n3(trustManager, method);
        } catch (NoSuchMethodException unused) {
            return super.gv(trustManager);
        }
    }

    @Override // uc1.s
    public boolean i9(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
        }
        if (i >= 23) {
            NetworkSecurityPolicy networkSecurityPolicy = NetworkSecurityPolicy.getInstance();
            Intrinsics.checkNotNullExpressionValue(networkSecurityPolicy, "NetworkSecurityPolicy.getInstance()");
            return networkSecurityPolicy.isCleartextTrafficPermitted();
        }
        return true;
    }

    @Override // uc1.s
    public X509TrustManager p(SSLSocketFactory sslSocketFactory) {
        Object obj;
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        Iterator<T> it = this.f14061gv.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((f) obj).v(sslSocketFactory)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        f fVar = (f) obj;
        if (fVar == null) {
            return null;
        }
        return fVar.gv(sslSocketFactory);
    }

    @Override // uc1.s
    public String s(SSLSocket sslSocket) {
        Object obj;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Iterator<T> it = this.f14061gv.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((f) obj).y(sslSocket)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        f fVar = (f) obj;
        if (fVar == null) {
            return null;
        }
        return fVar.n3(sslSocket);
    }

    @Override // uc1.s
    public void tl(String message, Object obj) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (!this.f14062v.n3(obj)) {
            s.t(this, message, 5, null, 4, null);
        }
    }

    @Override // uc1.s
    public void v(SSLSocket sslSocket, String str, List<c> protocols) {
        Object obj;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        Iterator<T> it = this.f14061gv.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((f) obj).y(sslSocket)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        f fVar = (f) obj;
        if (fVar != null) {
            fVar.a(sslSocket, str, protocols);
        }
    }

    @Override // uc1.s
    public xc1.zn zn(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        vc1.n3 y2 = vc1.n3.f14439gv.y(trustManager);
        if (y2 == null) {
            return super.zn(trustManager);
        }
        return y2;
    }
}

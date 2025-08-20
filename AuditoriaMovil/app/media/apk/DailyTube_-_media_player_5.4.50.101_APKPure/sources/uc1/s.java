package uc1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kc1.c;
import kc1.n;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public class s {

    /* renamed from: n3  reason: collision with root package name */
    public static final Logger f14064n3;
    public static volatile s y;

    /* renamed from: zn  reason: collision with root package name */
    public static final y f14065zn;

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public final s a() {
            if (s()) {
                return gv();
            }
            return v();
        }

        public final boolean c5() {
            Provider provider = Security.getProviders()[0];
            Intrinsics.checkNotNullExpressionValue(provider, "Security.getProviders()[0]");
            return Intrinsics.areEqual("BC", provider.getName());
        }

        public final boolean f() {
            Provider provider = Security.getProviders()[0];
            Intrinsics.checkNotNullExpressionValue(provider, "Security.getProviders()[0]");
            return Intrinsics.areEqual("OpenJSSE", provider.getName());
        }

        public final s fb() {
            return s.y;
        }

        public final s gv() {
            vc1.zn.f14449zn.n3();
            s y = uc1.y.f14074a.y();
            if (y == null) {
                s y2 = n3.f14060fb.y();
                Intrinsics.checkNotNull(y2);
                return y2;
            }
            return y;
        }

        public final boolean i9() {
            Provider provider = Security.getProviders()[0];
            Intrinsics.checkNotNullExpressionValue(provider, "Security.getProviders()[0]");
            return Intrinsics.areEqual("Conscrypt", provider.getName());
        }

        public final List<String> n3(List<? extends c> protocols) {
            Intrinsics.checkNotNullParameter(protocols, "protocols");
            ArrayList<c> arrayList = new ArrayList();
            for (Object obj : protocols) {
                if (((c) obj) != c.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            for (c cVar : arrayList) {
                arrayList2.add(cVar.toString());
            }
            return arrayList2;
        }

        public final boolean s() {
            return Intrinsics.areEqual("Dalvik", System.getProperty("java.vm.name"));
        }

        public final s v() {
            fb y;
            zn y2;
            gv n32;
            if (i9() && (n32 = gv.f14056a.n3()) != null) {
                return n32;
            }
            if (c5() && (y2 = zn.f14077a.y()) != null) {
                return y2;
            }
            if (f() && (y = fb.f14053a.y()) != null) {
                return y;
            }
            a y7 = a.f14052v.y();
            if (y7 != null) {
                return y7;
            }
            s y8 = v.f14066c5.y();
            if (y8 != null) {
                return y8;
            }
            return new s();
        }

        public final byte[] zn(List<? extends c> protocols) {
            Intrinsics.checkNotNullParameter(protocols, "protocols");
            zc1.v vVar = new zc1.v();
            for (String str : n3(protocols)) {
                vVar.w2(str.length());
                vVar.ne(str);
            }
            return vVar.eb();
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        y yVar = new y(null);
        f14065zn = yVar;
        y = yVar.a();
        f14064n3 = Logger.getLogger(n.class.getName());
    }

    public static /* synthetic */ void t(s sVar, String str, int i, Throwable th, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 2) != 0) {
                i = 4;
            }
            if ((i5 & 4) != 0) {
                th = null;
            }
            sVar.f(str, i, th);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
    }

    public void a(Socket socket, InetSocketAddress address, int i) throws IOException {
        Intrinsics.checkNotNullParameter(socket, "socket");
        Intrinsics.checkNotNullParameter(address, "address");
        socket.connect(address, i);
    }

    public Object c5(String closer) {
        Intrinsics.checkNotNullParameter(closer, "closer");
        if (f14064n3.isLoggable(Level.FINE)) {
            return new Throwable(closer);
        }
        return null;
    }

    public void f(String message, int i, Throwable th) {
        Level level;
        Intrinsics.checkNotNullParameter(message, "message");
        if (i == 5) {
            level = Level.WARNING;
        } else {
            level = Level.INFO;
        }
        f14064n3.log(level, message, th);
    }

    public final String fb() {
        return "OkHttp";
    }

    public xc1.v gv(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        X509Certificate[] acceptedIssuers = trustManager.getAcceptedIssuers();
        Intrinsics.checkNotNullExpressionValue(acceptedIssuers, "trustManager.acceptedIssuers");
        return new xc1.n3((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public boolean i9(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        return true;
    }

    public void n3(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
    }

    public X509TrustManager p(SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        try {
            Class<?> sslContextClass = Class.forName("sun.security.ssl.SSLContextImpl");
            Intrinsics.checkNotNullExpressionValue(sslContextClass, "sslContextClass");
            Object ej2 = lc1.n3.ej(sslSocketFactory, sslContextClass, "context");
            if (ej2 == null) {
                return null;
            }
            return (X509TrustManager) lc1.n3.ej(ej2, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (RuntimeException e2) {
            if (Intrinsics.areEqual(e2.getClass().getName(), "java.lang.reflect.InaccessibleObjectException")) {
                return null;
            }
            throw e2;
        }
    }

    public String s(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return null;
    }

    public void tl(String message, Object obj) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (obj == null) {
            message = message + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        f(message, 5, (Throwable) obj);
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public void v(SSLSocket sslSocket, String str, List<c> protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
    }

    public X509TrustManager w() {
        TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        factory.init((KeyStore) null);
        Intrinsics.checkNotNullExpressionValue(factory, "factory");
        TrustManager[] trustManagers = factory.getTrustManagers();
        Intrinsics.checkNotNull(trustManagers);
        boolean z2 = true;
        if ((trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) ? false : false) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager != null) {
                return (X509TrustManager) trustManager;
            }
            throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected default trust managers: ");
        String arrays = Arrays.toString(trustManagers);
        Intrinsics.checkNotNullExpressionValue(arrays, "java.util.Arrays.toString(this)");
        sb.append(arrays);
        throw new IllegalStateException(sb.toString().toString());
    }

    public SSLContext wz() {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        Intrinsics.checkNotNullExpressionValue(sSLContext, "SSLContext.getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory xc(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        try {
            SSLContext wz2 = wz();
            wz2.init(null, new TrustManager[]{trustManager}, null);
            SSLSocketFactory socketFactory = wz2.getSocketFactory();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e2) {
            throw new AssertionError("No System TLS: " + e2, e2);
        }
    }

    public xc1.zn zn(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        return new xc1.y(gv(trustManager));
    }
}

package uc1;

import java.security.KeyStore;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kc1.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;
/* loaded from: classes.dex */
public final class gv extends s {

    /* renamed from: a  reason: collision with root package name */
    public static final y f14056a;

    /* renamed from: v  reason: collision with root package name */
    public static final boolean f14057v;

    /* renamed from: gv  reason: collision with root package name */
    public final Provider f14058gv;

    /* loaded from: classes.dex */
    public static final class n3 implements ConscryptHostnameVerifier {
        public static final n3 y = new n3();
    }

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public final gv n3() {
            if (!zn()) {
                return null;
            }
            return new gv(null);
        }

        public final boolean y(int i, int i5, int i6) {
            Conscrypt.Version version = Conscrypt.version();
            if (version.major() != i) {
                if (version.major() <= i) {
                    return false;
                }
                return true;
            } else if (version.minor() != i5) {
                if (version.minor() <= i5) {
                    return false;
                }
                return true;
            } else if (version.patch() < i6) {
                return false;
            } else {
                return true;
            }
        }

        public final boolean zn() {
            return gv.f14057v;
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        y yVar = new y(null);
        f14056a = yVar;
        boolean z2 = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, yVar.getClass().getClassLoader());
            if (Conscrypt.isAvailable()) {
                if (yVar.y(2, 1, 0)) {
                    z2 = true;
                }
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        f14057v = z2;
    }

    public gv() {
        Provider newProvider = Conscrypt.newProvider();
        Intrinsics.checkNotNullExpressionValue(newProvider, "Conscrypt.newProvider()");
        this.f14058gv = newProvider;
    }

    @Override // uc1.s
    public X509TrustManager p(SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        return null;
    }

    @Override // uc1.s
    public String s(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        if (Conscrypt.isConscrypt(sslSocket)) {
            return Conscrypt.getApplicationProtocol(sslSocket);
        }
        return super.s(sslSocket);
    }

    @Override // uc1.s
    public void v(SSLSocket sslSocket, String str, List<c> protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        if (Conscrypt.isConscrypt(sslSocket)) {
            Conscrypt.setUseSessionTickets(sslSocket, true);
            Object[] array = s.f14065zn.n3(protocols).toArray(new String[0]);
            if (array != null) {
                Conscrypt.setApplicationProtocols(sslSocket, (String[]) array);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        super.v(sslSocket, str, protocols);
    }

    @Override // uc1.s
    public X509TrustManager w() {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        Intrinsics.checkNotNullExpressionValue(trustManagerFactory, "TrustManagerFactory.getI…(null as KeyStore?)\n    }");
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        Intrinsics.checkNotNull(trustManagers);
        boolean z2 = true;
        if ((trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) ? false : false) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager != null) {
                X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
                Conscrypt.setHostnameVerifier(x509TrustManager, n3.y);
                return x509TrustManager;
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

    @Override // uc1.s
    public SSLContext wz() {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f14058gv);
        Intrinsics.checkNotNullExpressionValue(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // uc1.s
    public SSLSocketFactory xc(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        SSLContext wz2 = wz();
        wz2.init(null, new TrustManager[]{trustManager}, null);
        SSLSocketFactory socketFactory = wz2.getSocketFactory();
        Intrinsics.checkNotNullExpressionValue(socketFactory, "newSSLContext().apply {\n…null)\n    }.socketFactory");
        return socketFactory;
    }

    public /* synthetic */ gv(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

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
import org.openjsse.net.ssl.OpenJSSE;
/* loaded from: classes.dex */
public final class fb extends s {

    /* renamed from: a  reason: collision with root package name */
    public static final y f14053a;

    /* renamed from: v  reason: collision with root package name */
    public static final boolean f14054v;

    /* renamed from: gv  reason: collision with root package name */
    public final Provider f14055gv;

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public final boolean n3() {
            return fb.f14054v;
        }

        public final fb y() {
            if (!n3()) {
                return null;
            }
            return new fb(null);
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        y yVar = new y(null);
        f14053a = yVar;
        boolean z2 = false;
        try {
            Class.forName("org.openjsse.net.ssl.OpenJSSE", false, yVar.getClass().getClassLoader());
            z2 = true;
        } catch (ClassNotFoundException unused) {
        }
        f14054v = z2;
    }

    public fb() {
        this.f14055gv = new OpenJSSE();
    }

    @Override // uc1.s
    public X509TrustManager p(SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with OpenJSSE");
    }

    @Override // uc1.s
    public String s(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return super.s(sslSocket);
    }

    @Override // uc1.s
    public void v(SSLSocket sslSocket, String str, List<c> protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        super.v(sslSocket, str, protocols);
    }

    @Override // uc1.s
    public X509TrustManager w() {
        TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.f14055gv);
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

    @Override // uc1.s
    public SSLContext wz() {
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.3", this.f14055gv);
        Intrinsics.checkNotNullExpressionValue(sSLContext, "SSLContext.getInstance(\"TLSv1.3\", provider)");
        return sSLContext;
    }

    public /* synthetic */ fb(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

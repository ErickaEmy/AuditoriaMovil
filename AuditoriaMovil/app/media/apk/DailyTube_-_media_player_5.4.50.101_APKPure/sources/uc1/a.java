package uc1;

import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kc1.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public class a extends s {

    /* renamed from: gv  reason: collision with root package name */
    public static final boolean f14051gv;

    /* renamed from: v  reason: collision with root package name */
    public static final y f14052v = new y(null);

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public final boolean n3() {
            return a.f14051gv;
        }

        public final a y() {
            if (n3()) {
                return new a();
            }
            return null;
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
        if (r0.intValue() >= 9) goto L8;
     */
    static {
        /*
            uc1.a$y r0 = new uc1.a$y
            r1 = 0
            r0.<init>(r1)
            uc1.a.f14052v = r0
            java.lang.String r0 = "java.specification.version"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            if (r0 == 0) goto L15
            java.lang.Integer r0 = kotlin.text.StringsKt.toIntOrNull(r0)
            goto L16
        L15:
            r0 = r1
        L16:
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L24
            int r0 = r0.intValue()
            r1 = 9
            if (r0 < r1) goto L2c
        L22:
            r2 = 1
            goto L2c
        L24:
            java.lang.Class<javax.net.ssl.SSLSocket> r0 = javax.net.ssl.SSLSocket.class
            java.lang.String r4 = "getApplicationProtocol"
            r0.getMethod(r4, r1)     // Catch: java.lang.NoSuchMethodException -> L2c
            goto L22
        L2c:
            uc1.a.f14051gv = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: uc1.a.<clinit>():void");
    }

    @Override // uc1.s
    public X509TrustManager p(SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }

    @Override // uc1.s
    public String s(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        try {
            String applicationProtocol = sslSocket.getApplicationProtocol();
            if (applicationProtocol == null) {
                return null;
            }
            if (applicationProtocol.hashCode() == 0) {
                if (applicationProtocol.equals("")) {
                    return null;
                }
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    @Override // uc1.s
    public void v(SSLSocket sslSocket, String str, List<c> protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        SSLParameters sslParameters = sslSocket.getSSLParameters();
        List<String> n32 = s.f14065zn.n3(protocols);
        Intrinsics.checkNotNullExpressionValue(sslParameters, "sslParameters");
        Object[] array = n32.toArray(new String[0]);
        if (array != null) {
            sslParameters.setApplicationProtocols((String[]) array);
            sslSocket.setSSLParameters(sslParameters);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}

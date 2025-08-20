package vc1;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import android.os.Build;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kc1.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vc1.f;
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public final class y implements f {
    public static final C0238y y = new C0238y(null);

    /* renamed from: vc1.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0238y {
        public C0238y() {
        }

        public final boolean n3() {
            if (uc1.s.f14065zn.s() && Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return false;
        }

        public final f y() {
            if (n3()) {
                return new y();
            }
            return null;
        }

        public /* synthetic */ C0238y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // vc1.f
    @SuppressLint({"NewApi"})
    public void a(SSLSocket sslSocket, String str, List<? extends c> protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sslSocket, true);
            SSLParameters sslParameters = sslSocket.getSSLParameters();
            Intrinsics.checkNotNullExpressionValue(sslParameters, "sslParameters");
            Object[] array = uc1.s.f14065zn.n3(protocols).toArray(new String[0]);
            if (array != null) {
                sslParameters.setApplicationProtocols((String[]) array);
                sslSocket.setSSLParameters(sslParameters);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (IllegalArgumentException e2) {
            throw new IOException("Android internal error", e2);
        }
    }

    @Override // vc1.f
    public X509TrustManager gv(SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        return f.y.n3(this, sslSocketFactory);
    }

    @Override // vc1.f
    @SuppressLint({"NewApi"})
    public String n3(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        String applicationProtocol = sslSocket.getApplicationProtocol();
        if (applicationProtocol == null || (applicationProtocol.hashCode() == 0 && applicationProtocol.equals(""))) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // vc1.f
    public boolean v(SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        return f.y.y(this, sslSocketFactory);
    }

    @Override // vc1.f
    public boolean y(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return SSLSockets.isSupportedSocket(sslSocket);
    }

    @Override // vc1.f
    public boolean zn() {
        return y.n3();
    }
}

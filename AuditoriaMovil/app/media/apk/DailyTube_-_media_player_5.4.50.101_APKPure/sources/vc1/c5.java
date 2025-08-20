package vc1;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kc1.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.Conscrypt;
import vc1.f;
import vc1.i9;
/* loaded from: classes.dex */
public final class c5 implements f {

    /* renamed from: n3  reason: collision with root package name */
    public static final n3 f14436n3 = new n3(null);
    public static final i9.y y = new y();

    /* loaded from: classes.dex */
    public static final class n3 {
        public n3() {
        }

        public final i9.y y() {
            return c5.y;
        }

        public /* synthetic */ n3(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class y implements i9.y {
        @Override // vc1.i9.y
        public f n3(SSLSocket sslSocket) {
            Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
            return new c5();
        }

        @Override // vc1.i9.y
        public boolean y(SSLSocket sslSocket) {
            Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
            if (uc1.gv.f14056a.zn() && Conscrypt.isConscrypt(sslSocket)) {
                return true;
            }
            return false;
        }
    }

    @Override // vc1.f
    public void a(SSLSocket sslSocket, String str, List<? extends c> protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        if (y(sslSocket)) {
            Conscrypt.setUseSessionTickets(sslSocket, true);
            Object[] array = uc1.s.f14065zn.n3(protocols).toArray(new String[0]);
            if (array != null) {
                Conscrypt.setApplicationProtocols(sslSocket, (String[]) array);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    @Override // vc1.f
    public X509TrustManager gv(SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        return f.y.n3(this, sslSocketFactory);
    }

    @Override // vc1.f
    public String n3(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        if (y(sslSocket)) {
            return Conscrypt.getApplicationProtocol(sslSocket);
        }
        return null;
    }

    @Override // vc1.f
    public boolean v(SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        return f.y.y(this, sslSocketFactory);
    }

    @Override // vc1.f
    public boolean y(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return Conscrypt.isConscrypt(sslSocket);
    }

    @Override // vc1.f
    public boolean zn() {
        return uc1.gv.f14056a.zn();
    }
}

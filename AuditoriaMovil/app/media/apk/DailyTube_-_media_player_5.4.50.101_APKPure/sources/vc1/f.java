package vc1;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kc1.c;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public interface f {

    /* loaded from: classes.dex */
    public static final class y {
        public static X509TrustManager n3(f fVar, SSLSocketFactory sslSocketFactory) {
            Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
            return null;
        }

        public static boolean y(f fVar, SSLSocketFactory sslSocketFactory) {
            Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
            return false;
        }
    }

    void a(SSLSocket sSLSocket, String str, List<? extends c> list);

    X509TrustManager gv(SSLSocketFactory sSLSocketFactory);

    String n3(SSLSocket sSLSocket);

    boolean v(SSLSocketFactory sSLSocketFactory);

    boolean y(SSLSocket sSLSocket);

    boolean zn();
}

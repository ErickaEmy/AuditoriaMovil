package vc1;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kc1.c;
import kotlin.jvm.internal.Intrinsics;
import vc1.f;
/* loaded from: classes.dex */
public final class i9 implements f {

    /* renamed from: n3  reason: collision with root package name */
    public final y f14438n3;
    public f y;

    /* loaded from: classes.dex */
    public interface y {
        f n3(SSLSocket sSLSocket);

        boolean y(SSLSocket sSLSocket);
    }

    public i9(y socketAdapterFactory) {
        Intrinsics.checkNotNullParameter(socketAdapterFactory, "socketAdapterFactory");
        this.f14438n3 = socketAdapterFactory;
    }

    @Override // vc1.f
    public void a(SSLSocket sslSocket, String str, List<? extends c> protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        f fb2 = fb(sslSocket);
        if (fb2 != null) {
            fb2.a(sslSocket, str, protocols);
        }
    }

    public final synchronized f fb(SSLSocket sSLSocket) {
        try {
            if (this.y == null && this.f14438n3.y(sSLSocket)) {
                this.y = this.f14438n3.n3(sSLSocket);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.y;
    }

    @Override // vc1.f
    public X509TrustManager gv(SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        return f.y.n3(this, sslSocketFactory);
    }

    @Override // vc1.f
    public String n3(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        f fb2 = fb(sslSocket);
        if (fb2 != null) {
            return fb2.n3(sslSocket);
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
        return this.f14438n3.y(sslSocket);
    }

    @Override // vc1.f
    public boolean zn() {
        return true;
    }
}

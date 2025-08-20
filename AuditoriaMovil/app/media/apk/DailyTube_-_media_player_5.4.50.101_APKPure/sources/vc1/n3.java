package vc1;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class n3 extends xc1.zn {

    /* renamed from: gv  reason: collision with root package name */
    public static final y f14439gv = new y(null);

    /* renamed from: n3  reason: collision with root package name */
    public final X509TrustManager f14440n3;

    /* renamed from: zn  reason: collision with root package name */
    public final X509TrustManagerExtensions f14441zn;

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public final n3 y(X509TrustManager trustManager) {
            X509TrustManagerExtensions x509TrustManagerExtensions;
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            try {
                x509TrustManagerExtensions = new X509TrustManagerExtensions(trustManager);
            } catch (IllegalArgumentException unused) {
                x509TrustManagerExtensions = null;
            }
            if (x509TrustManagerExtensions == null) {
                return null;
            }
            return new n3(trustManager, x509TrustManagerExtensions);
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public n3(X509TrustManager trustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        Intrinsics.checkNotNullParameter(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.f14440n3 = trustManager;
        this.f14441zn = x509TrustManagerExtensions;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof n3) && ((n3) obj).f14440n3 == this.f14440n3) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return System.identityHashCode(this.f14440n3);
    }

    @Override // xc1.zn
    public List<Certificate> y(List<? extends Certificate> chain, String hostname) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Object[] array = chain.toArray(new X509Certificate[0]);
        if (array != null) {
            try {
                List<X509Certificate> checkServerTrusted = this.f14441zn.checkServerTrusted((X509Certificate[]) array, "RSA", hostname);
                Intrinsics.checkNotNullExpressionValue(checkServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
                return checkServerTrusted;
            } catch (CertificateException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}

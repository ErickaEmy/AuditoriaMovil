package vc1;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class t extends a {

    /* renamed from: i9  reason: collision with root package name */
    public static final y f14445i9 = new y(null);

    /* renamed from: c5  reason: collision with root package name */
    public final Class<?> f14446c5;

    /* renamed from: s  reason: collision with root package name */
    public final Class<? super SSLSocketFactory> f14447s;

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public static /* synthetic */ f n3(y yVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return yVar.y(str);
        }

        public final f y(String packageName) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            try {
                Class<?> cls = Class.forName(packageName + ".OpenSSLSocketImpl");
                Class<?> cls2 = Class.forName(packageName + ".OpenSSLSocketFactoryImpl");
                Class<?> paramsClass = Class.forName(packageName + ".SSLParametersImpl");
                Intrinsics.checkNotNullExpressionValue(paramsClass, "paramsClass");
                return new t(cls, cls2, paramsClass);
            } catch (Exception e2) {
                uc1.s.f14065zn.fb().f("unable to load android socket classes", 5, e2);
                return null;
            }
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(Class<? super SSLSocket> sslSocketClass, Class<? super SSLSocketFactory> sslSocketFactoryClass, Class<?> paramClass) {
        super(sslSocketClass);
        Intrinsics.checkNotNullParameter(sslSocketClass, "sslSocketClass");
        Intrinsics.checkNotNullParameter(sslSocketFactoryClass, "sslSocketFactoryClass");
        Intrinsics.checkNotNullParameter(paramClass, "paramClass");
        this.f14447s = sslSocketFactoryClass;
        this.f14446c5 = paramClass;
    }

    @Override // vc1.a, vc1.f
    public X509TrustManager gv(SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        Object ej2 = lc1.n3.ej(sslSocketFactory, this.f14446c5, "sslParameters");
        Intrinsics.checkNotNull(ej2);
        X509TrustManager x509TrustManager = (X509TrustManager) lc1.n3.ej(ej2, X509TrustManager.class, "x509TrustManager");
        if (x509TrustManager == null) {
            return (X509TrustManager) lc1.n3.ej(ej2, X509TrustManager.class, "trustManager");
        }
        return x509TrustManager;
    }

    @Override // vc1.a, vc1.f
    public boolean v(SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        return this.f14447s.isInstance(sslSocketFactory);
    }
}

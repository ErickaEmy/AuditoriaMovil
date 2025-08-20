package uc1;

import android.annotation.SuppressLint;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kc1.c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vc1.c5;
import vc1.f;
import vc1.i9;
/* loaded from: classes.dex */
public final class y extends s {

    /* renamed from: a  reason: collision with root package name */
    public static final C0228y f14074a = new C0228y(null);

    /* renamed from: v  reason: collision with root package name */
    public static final boolean f14075v;

    /* renamed from: gv  reason: collision with root package name */
    public final List<f> f14076gv;

    /* renamed from: uc1.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0228y {
        public C0228y() {
        }

        public final boolean n3() {
            return y.f14075v;
        }

        public final s y() {
            if (n3()) {
                return new y();
            }
            return null;
        }

        public /* synthetic */ C0228y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        boolean z2;
        if (s.f14065zn.s() && Build.VERSION.SDK_INT >= 29) {
            z2 = true;
        } else {
            z2 = false;
        }
        f14075v = z2;
    }

    public y() {
        f[] fVarArr = {vc1.y.y.y(), new i9(vc1.a.f14431fb.gv()), new i9(c5.f14436n3.y()), new i9(vc1.fb.f14437n3.y())};
        ArrayList arrayList = new ArrayList();
        for (Object obj : CollectionsKt.listOfNotNull((Object[]) fVarArr)) {
            if (((f) obj).zn()) {
                arrayList.add(obj);
            }
        }
        this.f14076gv = arrayList;
    }

    @Override // uc1.s
    @SuppressLint({"NewApi"})
    public boolean i9(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }

    @Override // uc1.s
    public X509TrustManager p(SSLSocketFactory sslSocketFactory) {
        Object obj;
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        Iterator<T> it = this.f14076gv.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((f) obj).v(sslSocketFactory)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        f fVar = (f) obj;
        if (fVar == null) {
            return null;
        }
        return fVar.gv(sslSocketFactory);
    }

    @Override // uc1.s
    public String s(SSLSocket sslSocket) {
        Object obj;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Iterator<T> it = this.f14076gv.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((f) obj).y(sslSocket)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        f fVar = (f) obj;
        if (fVar == null) {
            return null;
        }
        return fVar.n3(sslSocket);
    }

    @Override // uc1.s
    public void v(SSLSocket sslSocket, String str, List<? extends c> protocols) {
        Object obj;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        Iterator<T> it = this.f14076gv.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((f) obj).y(sslSocket)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        f fVar = (f) obj;
        if (fVar != null) {
            fVar.a(sslSocket, str, protocols);
        }
    }

    @Override // uc1.s
    public xc1.zn zn(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        vc1.n3 y = vc1.n3.f14439gv.y(trustManager);
        if (y == null) {
            return super.zn(trustManager);
        }
        return y;
    }
}

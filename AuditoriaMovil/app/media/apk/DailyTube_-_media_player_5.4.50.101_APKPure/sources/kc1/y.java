package kc1;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kc1.r;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dns;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    public final SSLSocketFactory f9948a;

    /* renamed from: c5  reason: collision with root package name */
    public final n3 f9949c5;

    /* renamed from: f  reason: collision with root package name */
    public final ProxySelector f9950f;

    /* renamed from: fb  reason: collision with root package name */
    public final HostnameVerifier f9951fb;

    /* renamed from: gv  reason: collision with root package name */
    public final Dns f9952gv;

    /* renamed from: i9  reason: collision with root package name */
    public final Proxy f9953i9;

    /* renamed from: n3  reason: collision with root package name */
    public final List<c> f9954n3;

    /* renamed from: s  reason: collision with root package name */
    public final fb f9955s;

    /* renamed from: v  reason: collision with root package name */
    public final SocketFactory f9956v;
    public final r y;

    /* renamed from: zn  reason: collision with root package name */
    public final List<t> f9957zn;

    public y(String uriHost, int i, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, fb fbVar, n3 proxyAuthenticator, Proxy proxy, List<? extends c> protocols, List<t> connectionSpecs, ProxySelector proxySelector) {
        String str;
        Intrinsics.checkNotNullParameter(uriHost, "uriHost");
        Intrinsics.checkNotNullParameter(dns, "dns");
        Intrinsics.checkNotNullParameter(socketFactory, "socketFactory");
        Intrinsics.checkNotNullParameter(proxyAuthenticator, "proxyAuthenticator");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        Intrinsics.checkNotNullParameter(proxySelector, "proxySelector");
        this.f9952gv = dns;
        this.f9956v = socketFactory;
        this.f9948a = sSLSocketFactory;
        this.f9951fb = hostnameVerifier;
        this.f9955s = fbVar;
        this.f9949c5 = proxyAuthenticator;
        this.f9953i9 = proxy;
        this.f9950f = proxySelector;
        r.y yVar = new r.y();
        if (sSLSocketFactory != null) {
            str = "https";
        } else {
            str = "http";
        }
        this.y = yVar.r(str).i9(uriHost).w(i).gv();
        this.f9954n3 = lc1.n3.j5(protocols);
        this.f9957zn = lc1.n3.j5(connectionSpecs);
    }

    public final List<c> a() {
        return this.f9954n3;
    }

    public final ProxySelector c5() {
        return this.f9950f;
    }

    public boolean equals(Object obj) {
        if (obj instanceof y) {
            y yVar = (y) obj;
            if (Intrinsics.areEqual(this.y, yVar.y) && gv(yVar)) {
                return true;
            }
        }
        return false;
    }

    public final SSLSocketFactory f() {
        return this.f9948a;
    }

    public final Proxy fb() {
        return this.f9953i9;
    }

    public final boolean gv(y that) {
        Intrinsics.checkNotNullParameter(that, "that");
        if (Intrinsics.areEqual(this.f9952gv, that.f9952gv) && Intrinsics.areEqual(this.f9949c5, that.f9949c5) && Intrinsics.areEqual(this.f9954n3, that.f9954n3) && Intrinsics.areEqual(this.f9957zn, that.f9957zn) && Intrinsics.areEqual(this.f9950f, that.f9950f) && Intrinsics.areEqual(this.f9953i9, that.f9953i9) && Intrinsics.areEqual(this.f9948a, that.f9948a) && Intrinsics.areEqual(this.f9951fb, that.f9951fb) && Intrinsics.areEqual(this.f9955s, that.f9955s) && this.y.mt() == that.y.mt()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.y.hashCode()) * 31) + this.f9952gv.hashCode()) * 31) + this.f9949c5.hashCode()) * 31) + this.f9954n3.hashCode()) * 31) + this.f9957zn.hashCode()) * 31) + this.f9950f.hashCode()) * 31) + Objects.hashCode(this.f9953i9)) * 31) + Objects.hashCode(this.f9948a)) * 31) + Objects.hashCode(this.f9951fb)) * 31) + Objects.hashCode(this.f9955s);
    }

    public final SocketFactory i9() {
        return this.f9956v;
    }

    public final List<t> n3() {
        return this.f9957zn;
    }

    public final n3 s() {
        return this.f9949c5;
    }

    public final r t() {
        return this.y;
    }

    public String toString() {
        StringBuilder sb;
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.y.f());
        sb2.append(':');
        sb2.append(this.y.mt());
        sb2.append(", ");
        if (this.f9953i9 != null) {
            sb = new StringBuilder();
            sb.append("proxy=");
            obj = this.f9953i9;
        } else {
            sb = new StringBuilder();
            sb.append("proxySelector=");
            obj = this.f9950f;
        }
        sb.append(obj);
        sb2.append(sb.toString());
        sb2.append("}");
        return sb2.toString();
    }

    public final HostnameVerifier v() {
        return this.f9951fb;
    }

    public final fb y() {
        return this.f9955s;
    }

    public final Dns zn() {
        return this.f9952gv;
    }
}

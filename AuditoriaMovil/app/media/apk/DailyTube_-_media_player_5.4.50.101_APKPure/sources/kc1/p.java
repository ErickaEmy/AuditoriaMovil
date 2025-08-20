package kc1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: n3  reason: collision with root package name */
    public static final n3 f9867n3 = new n3(null);
    public static final p y = new y();

    /* loaded from: classes.dex */
    public static final class n3 {
        public n3() {
        }

        public /* synthetic */ n3(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class y extends p {
    }

    /* loaded from: classes.dex */
    public interface zn {
        p y(v vVar);
    }

    public void a(v call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void c(v call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void c5(v call, InetSocketAddress inetSocketAddress, Proxy proxy, c cVar, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
    }

    public void co(v call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
    }

    public void d0(v call, rz response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
    }

    public void f(v call, i9 connection) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
    }

    public void f3(v call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
    }

    public void fb(v call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void fh(v call, co coVar) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void gv(v call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void i4(v call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void i9(v call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
    }

    public void mt(v call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void n(v call, rz response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
    }

    public void n3(v call, rz response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
    }

    public void p(v call, long j2) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void r(v call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void rz(v call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void s(v call, InetSocketAddress inetSocketAddress, Proxy proxy, c cVar) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
    }

    public void t(v call, i9 connection) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
    }

    public void tl(v call, String domainName, List<InetAddress> inetAddressList) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(domainName, "domainName");
        Intrinsics.checkNotNullParameter(inetAddressList, "inetAddressList");
    }

    public void v(v call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
    }

    public void w(v call, r url) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public void wz(v call, String domainName) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(domainName, "domainName");
    }

    public void x4(v call, long j2) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void xc(v call, r url, List<Proxy> proxies) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(proxies, "proxies");
    }

    public void y(v call, rz cachedResponse) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(cachedResponse, "cachedResponse");
    }

    public void z(v call, d0 request) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(request, "request");
    }

    public void zn(v call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }
}

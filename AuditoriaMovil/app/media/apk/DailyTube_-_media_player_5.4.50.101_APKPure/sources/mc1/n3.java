package mc1;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
import kc1.d0;
import kc1.r;
import kc1.rz;
import kc1.s;
import kc1.ta;
import kc1.xc;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Dns;
/* loaded from: classes.dex */
public final class n3 implements kc1.n3 {

    /* renamed from: gv  reason: collision with root package name */
    public final Dns f11471gv;

    public n3(Dns defaultDns) {
        Intrinsics.checkNotNullParameter(defaultDns, "defaultDns");
        this.f11471gv = defaultDns;
    }

    public final InetAddress n3(Proxy proxy, r rVar, Dns dns) throws IOException {
        Proxy.Type type = proxy.type();
        if (type == null || y.y[type.ordinal()] != 1) {
            SocketAddress address = proxy.address();
            if (address != null) {
                InetAddress address2 = ((InetSocketAddress) address).getAddress();
                Intrinsics.checkNotNullExpressionValue(address2, "(address() as InetSocketAddress).address");
                return address2;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
        }
        return (InetAddress) CollectionsKt.first((List<? extends Object>) dns.lookup(rVar.f()));
    }

    @Override // kc1.n3
    public d0 y(ta taVar, rz response) throws IOException {
        boolean z2;
        Proxy proxy;
        Dns dns;
        PasswordAuthentication requestPasswordAuthentication;
        String str;
        kc1.y y;
        Intrinsics.checkNotNullParameter(response, "response");
        List<s> p2 = response.p();
        d0 o42 = response.o4();
        r t2 = o42.t();
        if (response.mt() == 407) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (taVar == null || (proxy = taVar.n3()) == null) {
            proxy = Proxy.NO_PROXY;
        }
        for (s sVar : p2) {
            if (StringsKt.equals("Basic", sVar.zn(), true)) {
                if (taVar == null || (y = taVar.y()) == null || (dns = y.zn()) == null) {
                    dns = this.f11471gv;
                }
                if (z2) {
                    SocketAddress address = proxy.address();
                    if (address != null) {
                        InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                        String hostName = inetSocketAddress.getHostName();
                        Intrinsics.checkNotNullExpressionValue(proxy, "proxy");
                        requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName, n3(proxy, t2, dns), inetSocketAddress.getPort(), t2.x4(), sVar.n3(), sVar.zn(), t2.f3(), Authenticator.RequestorType.PROXY);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
                    }
                } else {
                    String f4 = t2.f();
                    Intrinsics.checkNotNullExpressionValue(proxy, "proxy");
                    requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(f4, n3(proxy, t2, dns), t2.mt(), t2.x4(), sVar.n3(), sVar.zn(), t2.f3(), Authenticator.RequestorType.SERVER);
                }
                if (requestPasswordAuthentication != null) {
                    if (z2) {
                        str = "Proxy-Authorization";
                    } else {
                        str = "Authorization";
                    }
                    String userName = requestPasswordAuthentication.getUserName();
                    Intrinsics.checkNotNullExpressionValue(userName, "auth.userName");
                    char[] password = requestPasswordAuthentication.getPassword();
                    Intrinsics.checkNotNullExpressionValue(password, "auth.password");
                    return o42.c5().fb(str, xc.y(userName, new String(password), sVar.y())).n3();
                }
            }
        }
        return null;
    }

    public /* synthetic */ n3(Dns dns, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dns.SYSTEM : dns);
    }
}

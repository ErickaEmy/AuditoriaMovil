package pc1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kc1.p;
import kc1.r;
import kc1.ta;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: c5  reason: collision with root package name */
    public static final y f12535c5 = new y(null);

    /* renamed from: a  reason: collision with root package name */
    public final c5 f12536a;

    /* renamed from: fb  reason: collision with root package name */
    public final kc1.v f12537fb;

    /* renamed from: gv  reason: collision with root package name */
    public final List<ta> f12538gv;

    /* renamed from: n3  reason: collision with root package name */
    public int f12539n3;

    /* renamed from: s  reason: collision with root package name */
    public final p f12540s;

    /* renamed from: v  reason: collision with root package name */
    public final kc1.y f12541v;
    public List<? extends Proxy> y;

    /* renamed from: zn  reason: collision with root package name */
    public List<? extends InetSocketAddress> f12542zn;

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final List<ta> f12543n3;
        public int y;

        public n3(List<ta> routes) {
            Intrinsics.checkNotNullParameter(routes, "routes");
            this.f12543n3 = routes;
        }

        public final boolean n3() {
            if (this.y < this.f12543n3.size()) {
                return true;
            }
            return false;
        }

        public final List<ta> y() {
            return this.f12543n3;
        }

        public final ta zn() {
            if (n3()) {
                List<ta> list = this.f12543n3;
                int i = this.y;
                this.y = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public final String y(InetSocketAddress socketHost) {
            Intrinsics.checkNotNullParameter(socketHost, "$this$socketHost");
            InetAddress address = socketHost.getAddress();
            if (address != null) {
                String hostAddress = address.getHostAddress();
                Intrinsics.checkNotNullExpressionValue(hostAddress, "address.hostAddress");
                return hostAddress;
            }
            String hostName = socketHost.getHostName();
            Intrinsics.checkNotNullExpressionValue(hostName, "hostName");
            return hostName;
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class zn extends Lambda implements Function0<List<? extends Proxy>> {
        final /* synthetic */ Proxy $proxy;
        final /* synthetic */ r $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public zn(Proxy proxy, r rVar) {
            super(0);
            this.$proxy = proxy;
            this.$url = rVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends Proxy> invoke() {
            Proxy proxy = this.$proxy;
            if (proxy != null) {
                return CollectionsKt.listOf(proxy);
            }
            URI i42 = this.$url.i4();
            if (i42.getHost() == null) {
                return lc1.n3.z(Proxy.NO_PROXY);
            }
            List<Proxy> select = f.this.f12541v.c5().select(i42);
            List<Proxy> list = select;
            return (list == null || list.isEmpty()) ? lc1.n3.z(Proxy.NO_PROXY) : lc1.n3.j5(select);
        }
    }

    public f(kc1.y address, c5 routeDatabase, kc1.v call, p eventListener) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(routeDatabase, "routeDatabase");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.f12541v = address;
        this.f12536a = routeDatabase;
        this.f12537fb = call;
        this.f12540s = eventListener;
        this.y = CollectionsKt.emptyList();
        this.f12542zn = CollectionsKt.emptyList();
        this.f12538gv = new ArrayList();
        fb(address.t(), address.fb());
    }

    public final void a(Proxy proxy) throws IOException {
        String f4;
        int mt2;
        ArrayList arrayList = new ArrayList();
        this.f12542zn = arrayList;
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                f4 = f12535c5.y(inetSocketAddress);
                mt2 = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + address.getClass()).toString());
            }
        } else {
            f4 = this.f12541v.t().f();
            mt2 = this.f12541v.t().mt();
        }
        if (1 <= mt2 && 65535 >= mt2) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                arrayList.add(InetSocketAddress.createUnresolved(f4, mt2));
                return;
            }
            this.f12540s.wz(this.f12537fb, f4);
            List<InetAddress> lookup = this.f12541v.zn().lookup(f4);
            if (!lookup.isEmpty()) {
                this.f12540s.tl(this.f12537fb, f4, lookup);
                for (InetAddress inetAddress : lookup) {
                    arrayList.add(new InetSocketAddress(inetAddress, mt2));
                }
                return;
            }
            throw new UnknownHostException(this.f12541v.zn() + " returned no addresses for " + f4);
        }
        throw new SocketException("No route to " + f4 + ':' + mt2 + "; port is out of range");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void fb(r rVar, Proxy proxy) {
        zn znVar = new zn(proxy, rVar);
        this.f12540s.w(this.f12537fb, rVar);
        List<? extends Proxy> invoke = znVar.invoke();
        this.y = invoke;
        this.f12539n3 = 0;
        this.f12540s.xc(this.f12537fb, rVar, invoke);
    }

    public final n3 gv() throws IOException {
        if (n3()) {
            ArrayList arrayList = new ArrayList();
            while (zn()) {
                Proxy v2 = v();
                for (InetSocketAddress inetSocketAddress : this.f12542zn) {
                    ta taVar = new ta(this.f12541v, v2, inetSocketAddress);
                    if (this.f12536a.zn(taVar)) {
                        this.f12538gv.add(taVar);
                    } else {
                        arrayList.add(taVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                CollectionsKt.addAll(arrayList, this.f12538gv);
                this.f12538gv.clear();
            }
            return new n3(arrayList);
        }
        throw new NoSuchElementException();
    }

    public final boolean n3() {
        if (!zn() && this.f12538gv.isEmpty()) {
            return false;
        }
        return true;
    }

    public final Proxy v() throws IOException {
        if (zn()) {
            List<? extends Proxy> list = this.y;
            int i = this.f12539n3;
            this.f12539n3 = i + 1;
            Proxy proxy = list.get(i);
            a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f12541v.t().f() + "; exhausted proxy configurations: " + this.y);
    }

    public final boolean zn() {
        if (this.f12539n3 < this.y.size()) {
            return true;
        }
        return false;
    }
}

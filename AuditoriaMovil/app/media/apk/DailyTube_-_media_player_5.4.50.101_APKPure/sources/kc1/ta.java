package kc1;

import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class ta {

    /* renamed from: n3  reason: collision with root package name */
    public final Proxy f9926n3;
    public final y y;

    /* renamed from: zn  reason: collision with root package name */
    public final InetSocketAddress f9927zn;

    public ta(y address, Proxy proxy, InetSocketAddress socketAddress) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(socketAddress, "socketAddress");
        this.y = address;
        this.f9926n3 = proxy;
        this.f9927zn = socketAddress;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ta) {
            ta taVar = (ta) obj;
            if (Intrinsics.areEqual(taVar.y, this.y) && Intrinsics.areEqual(taVar.f9926n3, this.f9926n3) && Intrinsics.areEqual(taVar.f9927zn, this.f9927zn)) {
                return true;
            }
        }
        return false;
    }

    public final InetSocketAddress gv() {
        return this.f9927zn;
    }

    public int hashCode() {
        return ((((527 + this.y.hashCode()) * 31) + this.f9926n3.hashCode()) * 31) + this.f9927zn.hashCode();
    }

    public final Proxy n3() {
        return this.f9926n3;
    }

    public String toString() {
        return "Route{" + this.f9927zn + '}';
    }

    public final y y() {
        return this.y;
    }

    public final boolean zn() {
        if (this.y.f() != null && this.f9926n3.type() == Proxy.Type.HTTP) {
            return true;
        }
        return false;
    }
}

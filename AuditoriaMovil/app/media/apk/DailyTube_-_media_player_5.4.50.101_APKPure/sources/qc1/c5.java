package qc1;

import java.net.Proxy;
import kc1.d0;
import kc1.r;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class c5 {
    public static final c5 y = new c5();

    public final boolean n3(d0 d0Var, Proxy.Type type) {
        if (!d0Var.fb() && type == Proxy.Type.HTTP) {
            return true;
        }
        return false;
    }

    public final String y(d0 request, Proxy.Type proxyType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(proxyType, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(request.s());
        sb.append(' ');
        c5 c5Var = y;
        if (c5Var.n3(request, proxyType)) {
            sb.append(request.t());
        } else {
            sb.append(c5Var.zn(request.t()));
        }
        sb.append(" HTTP/1.1");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String zn(r url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String v2 = url.v();
        String fb2 = url.fb();
        if (fb2 != null) {
            return v2 + '?' + fb2;
        }
        return v2;
    }
}

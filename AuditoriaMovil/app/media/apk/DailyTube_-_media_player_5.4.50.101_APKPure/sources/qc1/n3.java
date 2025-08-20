package qc1;

import java.io.IOException;
import java.net.ProtocolException;
import kc1.d0;
import kc1.fh;
import kc1.mg;
import kc1.rz;
import kc1.x4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zc1.p;
/* loaded from: classes.dex */
public final class n3 implements x4 {
    public final boolean y;

    public n3(boolean z2) {
        this.y = z2;
    }

    @Override // kc1.x4
    public rz intercept(x4.y chain) throws IOException {
        rz.y yVar;
        boolean z2;
        rz zn2;
        long j2;
        Intrinsics.checkNotNullParameter(chain, "chain");
        fb fbVar = (fb) chain;
        pc1.zn s2 = fbVar.s();
        Intrinsics.checkNotNull(s2);
        d0 i92 = fbVar.i9();
        fh y = i92.y();
        long currentTimeMillis = System.currentTimeMillis();
        s2.z(i92);
        Long l2 = null;
        if (a.n3(i92.s()) && y != null) {
            if (StringsKt.equals("100-continue", i92.gv("Expect"), true)) {
                s2.a();
                yVar = s2.w(true);
                s2.mt();
                z2 = false;
            } else {
                yVar = null;
                z2 = true;
            }
            if (yVar == null) {
                if (y.isDuplex()) {
                    s2.a();
                    y.writeTo(p.zn(s2.zn(i92, true)));
                } else {
                    zc1.a zn3 = p.zn(s2.zn(i92, false));
                    y.writeTo(zn3);
                    zn3.close();
                }
            } else {
                s2.wz();
                if (!s2.s().f3()) {
                    s2.tl();
                }
            }
        } else {
            s2.wz();
            yVar = null;
            z2 = true;
        }
        if (y == null || !y.isDuplex()) {
            s2.v();
        }
        if (yVar == null) {
            yVar = s2.w(false);
            Intrinsics.checkNotNull(yVar);
            if (z2) {
                s2.mt();
                z2 = false;
            }
        }
        rz zn4 = yVar.co(i92).c5(s2.s().zn()).z(currentTimeMillis).p(System.currentTimeMillis()).zn();
        int mt2 = zn4.mt();
        if (mt2 == 100) {
            rz.y w4 = s2.w(false);
            Intrinsics.checkNotNull(w4);
            if (z2) {
                s2.mt();
            }
            zn4 = w4.co(i92).c5(s2.s().zn()).z(currentTimeMillis).p(System.currentTimeMillis()).zn();
            mt2 = zn4.mt();
        }
        s2.p(zn4);
        if (this.y && mt2 == 101) {
            zn2 = zn4.j5().n3(lc1.n3.f10308zn).zn();
        } else {
            zn2 = zn4.j5().n3(s2.xc(zn4)).zn();
        }
        if (StringsKt.equals("close", zn2.o4().gv("Connection"), true) || StringsKt.equals("close", rz.d(zn2, "Connection", null, 2, null), true)) {
            s2.tl();
        }
        if (mt2 == 204 || mt2 == 205) {
            mg y2 = zn2.y();
            if (y2 != null) {
                j2 = y2.contentLength();
            } else {
                j2 = -1;
            }
            if (j2 > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("HTTP ");
                sb.append(mt2);
                sb.append(" had non-zero Content-Length: ");
                mg y7 = zn2.y();
                if (y7 != null) {
                    l2 = Long.valueOf(y7.contentLength());
                }
                sb.append(l2);
                throw new ProtocolException(sb.toString());
            }
        }
        return zn2;
    }
}

package zr;

import androidx.annotation.Nullable;
import dq.tl;
import e4.t;
import java.io.IOException;
import kx.p;
import m1.m;
/* loaded from: classes.dex */
public final class c5 {
    public static p7.fb a(int i, m mVar) {
        t fbVar;
        String str = mVar.f10962r;
        if (str != null && (str.startsWith("video/webm") || str.startsWith("audio/webm"))) {
            fbVar = new sc.v();
        } else {
            fbVar = new ha.fb();
        }
        return new p7.v(fbVar, i, mVar);
    }

    public static String fb(tl tlVar, dq.t tVar) {
        String f4 = tlVar.f();
        if (f4 == null) {
            return tVar.n3(tlVar.f7388zn.get(0).y).toString();
        }
        return f4;
    }

    public static void gv(kx.tl tlVar, tl tlVar2, int i, p7.fb fbVar, dq.t tVar) throws IOException {
        new p7.tl(tlVar, y(tlVar2, tlVar2.f7388zn.get(i).y, tVar, 0), tlVar2.f7385n3, 0, null, fbVar).load();
    }

    @Nullable
    public static e4.gv n3(kx.tl tlVar, int i, tl tlVar2) throws IOException {
        return zn(tlVar, i, tlVar2, 0);
    }

    public static void v(p7.fb fbVar, kx.tl tlVar, tl tlVar2, int i, boolean z2) throws IOException {
        dq.t tVar = (dq.t) v5.y.v(tlVar2.wz());
        if (z2) {
            dq.t tl2 = tlVar2.tl();
            if (tl2 == null) {
                return;
            }
            dq.t y = tVar.y(tl2, tlVar2.f7388zn.get(i).y);
            if (y == null) {
                gv(tlVar, tlVar2, i, fbVar, tVar);
                tVar = tl2;
            } else {
                tVar = y;
            }
        }
        gv(tlVar, tlVar2, i, fbVar, tVar);
    }

    public static p y(tl tlVar, String str, dq.t tVar, int i) {
        return new p.n3().c5(tVar.n3(str)).s(tVar.y).fb(tVar.f7380n3).a(fb(tlVar, tVar)).n3(i).y();
    }

    @Nullable
    public static e4.gv zn(kx.tl tlVar, int i, tl tlVar2, int i5) throws IOException {
        if (tlVar2.wz() == null) {
            return null;
        }
        p7.fb a2 = a(i, tlVar2.f7385n3);
        try {
            v(a2, tlVar, tlVar2, i5, true);
            a2.release();
            return a2.zn();
        } catch (Throwable th) {
            a2.release();
            throw th;
        }
    }
}

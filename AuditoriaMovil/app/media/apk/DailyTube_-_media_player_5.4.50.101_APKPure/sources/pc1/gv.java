package pc1;

import java.io.IOException;
import kc1.n;
import kc1.p;
import kc1.r;
import kc1.ta;
import kotlin.jvm.internal.Intrinsics;
import pc1.f;
import sc1.wz;
/* loaded from: classes.dex */
public final class gv {

    /* renamed from: a  reason: collision with root package name */
    public ta f12544a;

    /* renamed from: c5  reason: collision with root package name */
    public final v f12545c5;

    /* renamed from: fb  reason: collision with root package name */
    public final s f12546fb;

    /* renamed from: gv  reason: collision with root package name */
    public int f12547gv;

    /* renamed from: i9  reason: collision with root package name */
    public final p f12548i9;

    /* renamed from: n3  reason: collision with root package name */
    public f f12549n3;

    /* renamed from: s  reason: collision with root package name */
    public final kc1.y f12550s;

    /* renamed from: v  reason: collision with root package name */
    public int f12551v;
    public f.n3 y;

    /* renamed from: zn  reason: collision with root package name */
    public int f12552zn;

    public gv(s connectionPool, kc1.y address, v call, p eventListener) {
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.f12546fb = connectionPool;
        this.f12550s = address;
        this.f12545c5 = call;
        this.f12548i9 = eventListener;
    }

    public final ta a() {
        a tl2;
        if (this.f12552zn > 1 || this.f12547gv > 1 || this.f12551v > 0 || (tl2 = this.f12545c5.tl()) == null) {
            return null;
        }
        synchronized (tl2) {
            if (tl2.z() != 0) {
                return null;
            }
            if (!lc1.n3.fb(tl2.n3().y().t(), this.f12550s.t())) {
                return null;
            }
            return tl2.n3();
        }
    }

    public final boolean fb(r url) {
        Intrinsics.checkNotNullParameter(url, "url");
        r t2 = this.f12550s.t();
        if (url.mt() == t2.mt() && Intrinsics.areEqual(url.f(), t2.f())) {
            return true;
        }
        return false;
    }

    public final kc1.y gv() {
        return this.f12550s;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final pc1.a n3(int r15, int r16, int r17, int r18, boolean r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pc1.gv.n3(int, int, int, int, boolean):pc1.a");
    }

    public final void s(IOException e2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        this.f12544a = null;
        if ((e2 instanceof wz) && ((wz) e2).errorCode == sc1.n3.REFUSED_STREAM) {
            this.f12552zn++;
        } else if (e2 instanceof sc1.y) {
            this.f12547gv++;
        } else {
            this.f12551v++;
        }
    }

    public final boolean v() {
        f fVar;
        if (this.f12552zn == 0 && this.f12547gv == 0 && this.f12551v == 0) {
            return false;
        }
        if (this.f12544a != null) {
            return true;
        }
        ta a2 = a();
        if (a2 != null) {
            this.f12544a = a2;
            return true;
        }
        f.n3 n3Var = this.y;
        if ((n3Var != null && n3Var.n3()) || (fVar = this.f12549n3) == null) {
            return true;
        }
        return fVar.n3();
    }

    public final qc1.gv y(n client, qc1.fb chain) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(chain, "chain");
        try {
            return zn(chain.fb(), chain.c5(), chain.f(), client.fh(), client.ej(), !Intrinsics.areEqual(chain.i9().s(), "GET")).n(client, chain);
        } catch (IOException e2) {
            s(e2);
            throw new i9(e2);
        } catch (i9 e3) {
            s(e3.v());
            throw e3;
        }
    }

    public final a zn(int i, int i5, int i6, int i8, boolean z2, boolean z3) throws IOException {
        boolean z4;
        while (true) {
            a n32 = n3(i, i5, i6, i8, z2);
            if (n32.i4(z3)) {
                return n32;
            }
            n32.d0();
            if (this.f12544a == null) {
                f.n3 n3Var = this.y;
                boolean z5 = true;
                if (n3Var != null) {
                    z4 = n3Var.n3();
                } else {
                    z4 = true;
                }
                if (z4) {
                    continue;
                } else {
                    f fVar = this.f12549n3;
                    if (fVar != null) {
                        z5 = fVar.n3();
                    }
                    if (!z5) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
    }
}

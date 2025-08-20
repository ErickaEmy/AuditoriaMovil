package qc1;

import java.io.IOException;
import java.util.List;
import kc1.d0;
import kc1.rz;
import kc1.x4;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class fb implements x4.y {

    /* renamed from: a */
    public final d0 f12792a;

    /* renamed from: c5 */
    public final int f12793c5;

    /* renamed from: fb */
    public final int f12794fb;

    /* renamed from: gv */
    public final int f12795gv;

    /* renamed from: n3 */
    public final pc1.v f12796n3;

    /* renamed from: s */
    public final int f12797s;

    /* renamed from: v */
    public final pc1.zn f12798v;
    public int y;

    /* renamed from: zn */
    public final List<x4> f12799zn;

    /* JADX WARN: Multi-variable type inference failed */
    public fb(pc1.v call, List<? extends x4> interceptors, int i, pc1.zn znVar, d0 request, int i5, int i6, int i8) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Intrinsics.checkNotNullParameter(request, "request");
        this.f12796n3 = call;
        this.f12799zn = interceptors;
        this.f12795gv = i;
        this.f12798v = znVar;
        this.f12792a = request;
        this.f12794fb = i5;
        this.f12797s = i6;
        this.f12793c5 = i8;
    }

    public static /* synthetic */ fb v(fb fbVar, int i, pc1.zn znVar, d0 d0Var, int i5, int i6, int i8, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i = fbVar.f12795gv;
        }
        if ((i10 & 2) != 0) {
            znVar = fbVar.f12798v;
        }
        pc1.zn znVar2 = znVar;
        if ((i10 & 4) != 0) {
            d0Var = fbVar.f12792a;
        }
        d0 d0Var2 = d0Var;
        if ((i10 & 8) != 0) {
            i5 = fbVar.f12794fb;
        }
        int i11 = i5;
        if ((i10 & 16) != 0) {
            i6 = fbVar.f12797s;
        }
        int i12 = i6;
        if ((i10 & 32) != 0) {
            i8 = fbVar.f12793c5;
        }
        return fbVar.gv(i, znVar2, d0Var2, i11, i12, i8);
    }

    public final pc1.v a() {
        return this.f12796n3;
    }

    public final int c5() {
        return this.f12797s;
    }

    @Override // kc1.x4.y
    public kc1.v call() {
        return this.f12796n3;
    }

    public final int f() {
        return this.f12793c5;
    }

    public final int fb() {
        return this.f12794fb;
    }

    public final fb gv(int i, pc1.zn znVar, d0 request, int i5, int i6, int i8) {
        Intrinsics.checkNotNullParameter(request, "request");
        return new fb(this.f12796n3, this.f12799zn, i, znVar, request, i5, i6, i8);
    }

    public final d0 i9() {
        return this.f12792a;
    }

    @Override // kc1.x4.y
    public rz n3(d0 request) throws IOException {
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.checkNotNullParameter(request, "request");
        boolean z5 = false;
        if (this.f12795gv < this.f12799zn.size()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.y++;
            pc1.zn znVar = this.f12798v;
            if (znVar != null) {
                if (znVar.i9().fb(request.t())) {
                    if (this.y == 1) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z4) {
                        throw new IllegalStateException(("network interceptor " + this.f12799zn.get(this.f12795gv - 1) + " must call proceed() exactly once").toString());
                    }
                } else {
                    throw new IllegalStateException(("network interceptor " + this.f12799zn.get(this.f12795gv - 1) + " must retain the same host and port").toString());
                }
            }
            fb v2 = v(this, this.f12795gv + 1, null, request, 0, 0, 0, 58, null);
            x4 x4Var = this.f12799zn.get(this.f12795gv);
            rz intercept = x4Var.intercept(v2);
            if (intercept != null) {
                if (this.f12798v != null) {
                    if (this.f12795gv + 1 < this.f12799zn.size() && v2.y != 1) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (!z3) {
                        throw new IllegalStateException(("network interceptor " + x4Var + " must call proceed() exactly once").toString());
                    }
                }
                if (intercept.y() != null) {
                    z5 = true;
                }
                if (z5) {
                    return intercept;
                }
                throw new IllegalStateException(("interceptor " + x4Var + " returned a response with no body").toString());
            }
            throw new NullPointerException("interceptor " + x4Var + " returned null");
        }
        throw new IllegalStateException("Check failed.");
    }

    public final pc1.zn s() {
        return this.f12798v;
    }

    public int t() {
        return this.f12797s;
    }

    @Override // kc1.x4.y
    public d0 y() {
        return this.f12792a;
    }

    @Override // kc1.x4.y
    public kc1.i9 zn() {
        pc1.zn znVar = this.f12798v;
        if (znVar != null) {
            return znVar.s();
        }
        return null;
    }
}

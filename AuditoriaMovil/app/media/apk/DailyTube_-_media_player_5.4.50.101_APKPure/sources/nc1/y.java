package nc1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kc1.c;
import kc1.d0;
import kc1.mg;
import kc1.p;
import kc1.rz;
import kc1.x4;
import kc1.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nc1.zn;
import qc1.s;
import zc1.a;
import zc1.d;
import zc1.fb;
import zc1.ta;
/* loaded from: classes.dex */
public final class y implements x4 {

    /* renamed from: n3  reason: collision with root package name */
    public static final C0165y f11898n3 = new C0165y(null);
    public final kc1.zn y;

    /* loaded from: classes.dex */
    public static final class n3 implements ta {

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ nc1.n3 f11899fb;

        /* renamed from: s  reason: collision with root package name */
        public final /* synthetic */ a f11900s;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ fb f11901v;
        public boolean y;

        public n3(fb fbVar, nc1.n3 n3Var, a aVar) {
            this.f11901v = fbVar;
            this.f11899fb = n3Var;
            this.f11900s = aVar;
        }

        public void close() throws IOException {
            if (!this.y && !lc1.n3.w(this, 100, TimeUnit.MILLISECONDS)) {
                this.y = true;
                this.f11899fb.y();
            }
            this.f11901v.close();
        }

        public long read(zc1.v sink, long j2) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            try {
                long read = this.f11901v.read(sink, j2);
                if (read == -1) {
                    if (!this.y) {
                        this.y = true;
                        this.f11900s.close();
                    }
                    return -1L;
                }
                sink.x4(this.f11900s.zn(), sink.m() - read, read);
                this.f11900s.i4();
                return read;
            } catch (IOException e2) {
                if (!this.y) {
                    this.y = true;
                    this.f11899fb.y();
                }
                throw e2;
            }
        }

        public d timeout() {
            return this.f11901v.timeout();
        }
    }

    /* renamed from: nc1.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0165y {
        public C0165y() {
        }

        public final rz a(rz rzVar) {
            mg mgVar;
            if (rzVar != null) {
                mgVar = rzVar.y();
            } else {
                mgVar = null;
            }
            if (mgVar != null) {
                return rzVar.j5().n3(null).zn();
            }
            return rzVar;
        }

        public final boolean gv(String str) {
            if (StringsKt.equals("Content-Length", str, true) || StringsKt.equals("Content-Encoding", str, true) || StringsKt.equals("Content-Type", str, true)) {
                return true;
            }
            return false;
        }

        public final boolean v(String str) {
            if (!StringsKt.equals("Connection", str, true) && !StringsKt.equals("Keep-Alive", str, true) && !StringsKt.equals("Proxy-Authenticate", str, true) && !StringsKt.equals("Proxy-Authorization", str, true) && !StringsKt.equals("TE", str, true) && !StringsKt.equals("Trailers", str, true) && !StringsKt.equals("Transfer-Encoding", str, true) && !StringsKt.equals("Upgrade", str, true)) {
                return true;
            }
            return false;
        }

        public final z zn(z zVar, z zVar2) {
            z.y yVar = new z.y();
            int size = zVar.size();
            for (int i = 0; i < size; i++) {
                String zn2 = zVar.zn(i);
                String c52 = zVar.c5(i);
                if ((!StringsKt.equals("Warning", zn2, true) || !StringsKt.startsWith$default(c52, "1", false, 2, (Object) null)) && (gv(zn2) || !v(zn2) || zVar2.y(zn2) == null)) {
                    yVar.gv(zn2, c52);
                }
            }
            int size2 = zVar2.size();
            for (int i5 = 0; i5 < size2; i5++) {
                String zn3 = zVar2.zn(i5);
                if (!gv(zn3) && v(zn3)) {
                    yVar.gv(zn3, zVar2.c5(i5));
                }
            }
            return yVar.a();
        }

        public /* synthetic */ C0165y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public y(kc1.zn znVar) {
        this.y = znVar;
    }

    @Override // kc1.x4
    public rz intercept(x4.y chain) throws IOException {
        rz rzVar;
        p pVar;
        mg y;
        mg y2;
        Intrinsics.checkNotNullParameter(chain, "chain");
        kc1.v call = chain.call();
        kc1.zn znVar = this.y;
        pc1.v vVar = null;
        if (znVar != null) {
            rzVar = znVar.v(chain.y());
        } else {
            rzVar = null;
        }
        zn n32 = new zn.n3(System.currentTimeMillis(), chain.y(), rzVar).n3();
        d0 n33 = n32.n3();
        rz y7 = n32.y();
        kc1.zn znVar2 = this.y;
        if (znVar2 != null) {
            znVar2.d(n32);
        }
        if (call instanceof pc1.v) {
            vVar = call;
        }
        pc1.v vVar2 = vVar;
        if (vVar2 == null || (pVar = vVar2.wz()) == null) {
            pVar = p.y;
        }
        if (rzVar != null && y7 == null && (y2 = rzVar.y()) != null) {
            lc1.n3.i9(y2);
        }
        if (n33 == null && y7 == null) {
            rz zn2 = new rz.y().co(chain.y()).w(c.HTTP_1_1).fb(504).tl("Unsatisfiable Request (only-if-cached)").n3(lc1.n3.f10308zn).z(-1L).p(System.currentTimeMillis()).zn();
            pVar.d0(call, zn2);
            return zn2;
        } else if (n33 == null) {
            Intrinsics.checkNotNull(y7);
            rz zn3 = y7.j5().gv(f11898n3.a(y7)).zn();
            pVar.n3(call, zn3);
            return zn3;
        } else {
            if (y7 != null) {
                pVar.y(call, y7);
            } else if (this.y != null) {
                pVar.zn(call);
            }
            try {
                rz n34 = chain.n3(n33);
                if (n34 == null && rzVar != null && y != null) {
                }
                if (y7 != null) {
                    if (n34 != null && n34.mt() == 304) {
                        rz.y j52 = y7.j5();
                        C0165y c0165y = f11898n3;
                        rz zn4 = j52.f(c0165y.zn(y7.b(), n34.b())).z(n34.ap()).p(n34.ct()).gv(c0165y.a(y7)).wz(c0165y.a(n34)).zn();
                        mg y8 = n34.y();
                        Intrinsics.checkNotNull(y8);
                        y8.close();
                        kc1.zn znVar3 = this.y;
                        Intrinsics.checkNotNull(znVar3);
                        znVar3.ta();
                        this.y.ud(y7, zn4);
                        pVar.n3(call, zn4);
                        return zn4;
                    }
                    mg y9 = y7.y();
                    if (y9 != null) {
                        lc1.n3.i9(y9);
                    }
                }
                Intrinsics.checkNotNull(n34);
                rz.y j53 = n34.j5();
                C0165y c0165y2 = f11898n3;
                rz zn5 = j53.gv(c0165y2.a(y7)).wz(c0165y2.a(n34)).zn();
                if (this.y != null) {
                    if (qc1.v.zn(zn5) && zn.f11902zn.y(zn5, n33)) {
                        rz y10 = y(this.y.mt(zn5), zn5);
                        if (y7 != null) {
                            pVar.zn(call);
                        }
                        return y10;
                    } else if (qc1.a.y.y(n33.s())) {
                        try {
                            this.y.co(n33);
                        } catch (IOException unused) {
                        }
                    }
                }
                return zn5;
            } finally {
                if (rzVar != null && (y = rzVar.y()) != null) {
                    lc1.n3.i9(y);
                }
            }
        }
    }

    public final rz y(nc1.n3 n3Var, rz rzVar) throws IOException {
        if (n3Var == null) {
            return rzVar;
        }
        zc1.rz n32 = n3Var.n3();
        mg y = rzVar.y();
        Intrinsics.checkNotNull(y);
        n3 n3Var2 = new n3(y.source(), n3Var, zc1.p.zn(n32));
        return rzVar.j5().n3(new s(rz.d(rzVar, "Content-Type", null, 2, null), rzVar.y().contentLength(), zc1.p.gv(n3Var2))).zn();
    }
}

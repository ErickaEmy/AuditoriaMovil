package mv;

import androidx.annotation.Nullable;
import e4.ej;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import m1.m;
import m1.ne;
import mv.c5;
import v5.rz;
import z0.x4;
/* loaded from: classes.dex */
public final class i9 extends c5 {
    @Nullable

    /* renamed from: mt  reason: collision with root package name */
    public ej.n3 f11596mt;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public ej.gv f11597p;

    /* renamed from: w  reason: collision with root package name */
    public boolean f11598w;
    @Nullable

    /* renamed from: wz  reason: collision with root package name */
    public y f11599wz;

    /* renamed from: xc  reason: collision with root package name */
    public int f11600xc;

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: gv  reason: collision with root package name */
        public final ej.zn[] f11601gv;

        /* renamed from: n3  reason: collision with root package name */
        public final ej.n3 f11602n3;

        /* renamed from: v  reason: collision with root package name */
        public final int f11603v;
        public final ej.gv y;

        /* renamed from: zn  reason: collision with root package name */
        public final byte[] f11604zn;

        public y(ej.gv gvVar, ej.n3 n3Var, byte[] bArr, ej.zn[] znVarArr, int i) {
            this.y = gvVar;
            this.f11602n3 = n3Var;
            this.f11604zn = bArr;
            this.f11601gv = znVarArr;
            this.f11603v = i;
        }
    }

    public static boolean mt(rz rzVar) {
        try {
            return ej.tl(1, rzVar, true);
        } catch (ne unused) {
            return false;
        }
    }

    public static int w(byte b2, int i, int i5) {
        return (b2 >> i5) & (255 >>> (8 - i));
    }

    public static void wz(rz rzVar, long j2) {
        if (rzVar.n3() < rzVar.fb() + 4) {
            rzVar.qn(Arrays.copyOf(rzVar.v(), rzVar.fb() + 4));
        } else {
            rzVar.j(rzVar.fb() + 4);
        }
        byte[] v2 = rzVar.v();
        v2[rzVar.fb() - 4] = (byte) (j2 & 255);
        v2[rzVar.fb() - 3] = (byte) ((j2 >>> 8) & 255);
        v2[rzVar.fb() - 2] = (byte) ((j2 >>> 16) & 255);
        v2[rzVar.fb() - 1] = (byte) ((j2 >>> 24) & 255);
    }

    public static int xc(byte b2, y yVar) {
        if (!yVar.f11601gv[w(b2, yVar.f11603v, 1)].y) {
            return yVar.y.f7485fb;
        }
        return yVar.y.f7489s;
    }

    @Override // mv.c5
    public long a(rz rzVar) {
        int i = 0;
        if ((rzVar.v()[0] & 1) == 1) {
            return -1L;
        }
        int xc2 = xc(rzVar.v()[0], (y) v5.y.c5(this.f11599wz));
        if (this.f11598w) {
            i = (this.f11600xc + xc2) / 4;
        }
        long j2 = i;
        wz(rzVar, j2);
        this.f11598w = true;
        this.f11600xc = xc2;
        return j2;
    }

    @Override // mv.c5
    public boolean c5(rz rzVar, long j2, c5.n3 n3Var) throws IOException {
        if (this.f11599wz != null) {
            v5.y.v(n3Var.y);
            return false;
        }
        y p2 = p(rzVar);
        this.f11599wz = p2;
        if (p2 == null) {
            return true;
        }
        ej.gv gvVar = p2.y;
        ArrayList arrayList = new ArrayList();
        arrayList.add(gvVar.f7487i9);
        arrayList.add(p2.f11604zn);
        n3Var.y = new m.n3().o4("audio/vorbis").ud(gvVar.f7490v).u(gvVar.f7486gv).a8(gvVar.f7488n3).rs(gvVar.f7491zn).ut(arrayList).en(ej.zn(x4.ud(p2.f11602n3.f7492n3))).z6();
        return true;
    }

    @Nullable
    public y p(rz rzVar) throws IOException {
        ej.gv gvVar = this.f11597p;
        if (gvVar == null) {
            this.f11597p = ej.f(rzVar);
            return null;
        }
        ej.n3 n3Var = this.f11596mt;
        if (n3Var == null) {
            this.f11596mt = ej.c5(rzVar);
            return null;
        }
        byte[] bArr = new byte[rzVar.fb()];
        System.arraycopy(rzVar.v(), 0, bArr, 0, rzVar.fb());
        ej.zn[] t2 = ej.t(rzVar, gvVar.f7488n3);
        return new y(gvVar, n3Var, bArr, t2, ej.y(t2.length - 1));
    }

    @Override // mv.c5
    public void t(boolean z2) {
        super.t(z2);
        if (z2) {
            this.f11599wz = null;
            this.f11597p = null;
            this.f11596mt = null;
        }
        this.f11600xc = 0;
        this.f11598w = false;
    }

    @Override // mv.c5
    public void v(long j2) {
        boolean z2;
        super.v(j2);
        int i = 0;
        if (j2 != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f11598w = z2;
        ej.gv gvVar = this.f11597p;
        if (gvVar != null) {
            i = gvVar.f7485fb;
        }
        this.f11600xc = i;
    }
}

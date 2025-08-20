package af;

import af.d0;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import m1.g;
import m1.m;
import m1.vc;
/* loaded from: classes.dex */
public final class k5 implements d0, d0.y {

    /* renamed from: co  reason: collision with root package name */
    public jz f314co;

    /* renamed from: fb  reason: collision with root package name */
    public final c5 f316fb;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public d0.y f319t;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public lc f321w;
    public final d0[] y;

    /* renamed from: s  reason: collision with root package name */
    public final ArrayList<d0> f318s = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<rs, rs> f315f = new HashMap<>();

    /* renamed from: v  reason: collision with root package name */
    public final IdentityHashMap<en, Integer> f320v = new IdentityHashMap<>();

    /* renamed from: p  reason: collision with root package name */
    public d0[] f317p = new d0[0];

    /* loaded from: classes.dex */
    public static final class n3 implements d0, d0.y {

        /* renamed from: fb  reason: collision with root package name */
        public d0.y f322fb;

        /* renamed from: v  reason: collision with root package name */
        public final long f323v;
        public final d0 y;

        public n3(d0 d0Var, long j2) {
            this.y = d0Var;
            this.f323v = j2;
        }

        @Override // af.d0
        public long c5(long j2) {
            return this.y.c5(j2 - this.f323v) + this.f323v;
        }

        @Override // af.d0
        public void co(d0.y yVar, long j2) {
            this.f322fb = yVar;
            this.y.co(this, j2 - this.f323v);
        }

        @Override // af.d0
        public long f(zo.co[] coVarArr, boolean[] zArr, en[] enVarArr, boolean[] zArr2, long j2) {
            en[] enVarArr2 = new en[enVarArr.length];
            int i = 0;
            while (true) {
                en enVar = null;
                if (i >= enVarArr.length) {
                    break;
                }
                zn znVar = (zn) enVarArr[i];
                if (znVar != null) {
                    enVar = znVar.y();
                }
                enVarArr2[i] = enVar;
                i++;
            }
            long f4 = this.y.f(coVarArr, zArr, enVarArr2, zArr2, j2 - this.f323v);
            for (int i5 = 0; i5 < enVarArr.length; i5++) {
                en enVar2 = enVarArr2[i5];
                if (enVar2 == null) {
                    enVarArr[i5] = null;
                } else {
                    en enVar3 = enVarArr[i5];
                    if (enVar3 == null || ((zn) enVar3).y() != enVar2) {
                        enVarArr[i5] = new zn(enVar2, this.f323v);
                    }
                }
            }
            return f4 + this.f323v;
        }

        @Override // af.d0, af.jz
        public long fb() {
            long fb2 = this.y.fb();
            if (fb2 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.f323v + fb2;
        }

        @Override // af.d0
        public long gv(long j2, vc vcVar) {
            return this.y.gv(j2 - this.f323v, vcVar) + this.f323v;
        }

        @Override // af.d0
        public long i9() {
            long i92 = this.y.i9();
            if (i92 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f323v + i92;
        }

        @Override // af.d0
        public void mt(long j2, boolean z2) {
            this.y.mt(j2 - this.f323v, z2);
        }

        @Override // af.d0.y
        public void n3(d0 d0Var) {
            ((d0.y) v5.y.v(this.f322fb)).n3(this);
        }

        @Override // af.d0
        public lc p() {
            return this.y.p();
        }

        @Override // af.d0, af.jz
        public void s(long j2) {
            this.y.s(j2 - this.f323v);
        }

        @Override // af.d0, af.jz
        public boolean v(long j2) {
            return this.y.v(j2 - this.f323v);
        }

        @Override // af.d0
        public void wz() throws IOException {
            this.y.wz();
        }

        @Override // af.jz.y
        /* renamed from: xc */
        public void t(d0 d0Var) {
            ((d0.y) v5.y.v(this.f322fb)).t(this);
        }

        @Override // af.d0, af.jz
        public boolean y() {
            return this.y.y();
        }

        @Override // af.d0, af.jz
        public long zn() {
            long zn2 = this.y.zn();
            if (zn2 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.f323v + zn2;
        }
    }

    /* loaded from: classes.dex */
    public static final class y implements zo.co {

        /* renamed from: n3  reason: collision with root package name */
        public final rs f324n3;
        public final zo.co y;

        public y(zo.co coVar, rs rsVar) {
            this.y = coVar;
            this.f324n3 = rsVar;
        }

        @Override // zo.x4
        public m a(int i) {
            return this.y.a(i);
        }

        @Override // zo.co
        public boolean c5(long j2, p7.a aVar, List<? extends p7.wz> list) {
            return this.y.c5(j2, aVar, list);
        }

        @Override // zo.co
        public m co() {
            return this.y.co();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof y)) {
                return false;
            }
            y yVar = (y) obj;
            if (this.y.equals(yVar.y) && this.f324n3.equals(yVar.f324n3)) {
                return true;
            }
            return false;
        }

        @Override // zo.co
        @Nullable
        public Object f() {
            return this.y.f();
        }

        @Override // zo.co
        public void fb() {
            this.y.fb();
        }

        @Override // zo.co
        public boolean gv(int i, long j2) {
            return this.y.gv(i, j2);
        }

        public int hashCode() {
            return ((527 + this.f324n3.hashCode()) * 31) + this.y.hashCode();
        }

        @Override // zo.co
        public void i9(float f4) {
            this.y.i9(f4);
        }

        @Override // zo.x4
        public int length() {
            return this.y.length();
        }

        @Override // zo.co
        public int mt() {
            return this.y.mt();
        }

        @Override // zo.co
        public void n3(long j2, long j4, long j6, List<? extends p7.wz> list, p7.xc[] xcVarArr) {
            this.y.n3(j2, j4, j6, list, xcVarArr);
        }

        @Override // zo.co
        public int p(long j2, List<? extends p7.wz> list) {
            return this.y.p(j2, list);
        }

        @Override // zo.co
        public void r() {
            this.y.r();
        }

        @Override // zo.x4
        public int s(int i) {
            return this.y.s(i);
        }

        @Override // zo.co
        public void t() {
            this.y.t();
        }

        @Override // zo.x4
        public int tl(int i) {
            return this.y.tl(i);
        }

        @Override // zo.co
        public boolean v(int i, long j2) {
            return this.y.v(i, j2);
        }

        @Override // zo.co
        public void w(boolean z2) {
            this.y.w(z2);
        }

        @Override // zo.x4
        public int wz(m mVar) {
            return this.y.wz(mVar);
        }

        @Override // zo.x4
        public rs xc() {
            return this.f324n3;
        }

        @Override // zo.co
        public void y() {
            this.y.y();
        }

        @Override // zo.co
        public int z() {
            return this.y.z();
        }

        @Override // zo.co
        public int zn() {
            return this.y.zn();
        }
    }

    /* loaded from: classes.dex */
    public static final class zn implements en {

        /* renamed from: v  reason: collision with root package name */
        public final long f325v;
        public final en y;

        public zn(en enVar, long j2) {
            this.y = enVar;
            this.f325v = j2;
        }

        @Override // af.en
        public int a(g gVar, a9.fb fbVar, int i) {
            int a2 = this.y.a(gVar, fbVar, i);
            if (a2 == -4) {
                fbVar.f55f = Math.max(0L, fbVar.f55f + this.f325v);
            }
            return a2;
        }

        @Override // af.en
        public boolean isReady() {
            return this.y.isReady();
        }

        @Override // af.en
        public void n3() throws IOException {
            this.y.n3();
        }

        @Override // af.en
        public int t(long j2) {
            return this.y.t(j2 - this.f325v);
        }

        public en y() {
            return this.y;
        }
    }

    public k5(c5 c5Var, long[] jArr, d0... d0VarArr) {
        this.f316fb = c5Var;
        this.y = d0VarArr;
        this.f314co = c5Var.y(new jz[0]);
        for (int i = 0; i < d0VarArr.length; i++) {
            long j2 = jArr[i];
            if (j2 != 0) {
                this.y[i] = new n3(d0VarArr[i], j2);
            }
        }
    }

    public d0 a(int i) {
        d0 d0Var = this.y[i];
        if (d0Var instanceof n3) {
            return ((n3) d0Var).y;
        }
        return d0Var;
    }

    @Override // af.d0
    public long c5(long j2) {
        long c52 = this.f317p[0].c5(j2);
        int i = 1;
        while (true) {
            d0[] d0VarArr = this.f317p;
            if (i < d0VarArr.length) {
                if (d0VarArr[i].c5(c52) == c52) {
                    i++;
                } else {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else {
                return c52;
            }
        }
    }

    @Override // af.d0
    public void co(d0.y yVar, long j2) {
        this.f319t = yVar;
        Collections.addAll(this.f318s, this.y);
        for (d0 d0Var : this.y) {
            d0Var.co(this, j2);
        }
    }

    @Override // af.d0
    public long f(zo.co[] coVarArr, boolean[] zArr, en[] enVarArr, boolean[] zArr2, long j2) {
        zo.co coVar;
        zo.co coVar2;
        int intValue;
        int[] iArr = new int[coVarArr.length];
        int[] iArr2 = new int[coVarArr.length];
        int i = 0;
        while (true) {
            coVar = null;
            Integer num = null;
            if (i >= coVarArr.length) {
                break;
            }
            en enVar = enVarArr[i];
            if (enVar != null) {
                num = this.f320v.get(enVar);
            }
            if (num == null) {
                intValue = -1;
            } else {
                intValue = num.intValue();
            }
            iArr[i] = intValue;
            zo.co coVar3 = coVarArr[i];
            if (coVar3 != null) {
                String str = coVar3.xc().f381v;
                iArr2[i] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr2[i] = -1;
            }
            i++;
        }
        this.f320v.clear();
        int length = coVarArr.length;
        en[] enVarArr2 = new en[length];
        en[] enVarArr3 = new en[coVarArr.length];
        zo.co[] coVarArr2 = new zo.co[coVarArr.length];
        ArrayList arrayList = new ArrayList(this.y.length);
        long j4 = j2;
        int i5 = 0;
        while (i5 < this.y.length) {
            for (int i6 = 0; i6 < coVarArr.length; i6++) {
                if (iArr[i6] == i5) {
                    coVar2 = enVarArr[i6];
                } else {
                    coVar2 = coVar;
                }
                enVarArr3[i6] = coVar2;
                if (iArr2[i6] == i5) {
                    zo.co coVar4 = (zo.co) v5.y.v(coVarArr[i6]);
                    coVarArr2[i6] = new y(coVar4, (rs) v5.y.v(this.f315f.get(coVar4.xc())));
                } else {
                    coVarArr2[i6] = coVar;
                }
            }
            int i8 = i5;
            ArrayList arrayList2 = arrayList;
            zo.co[] coVarArr3 = coVarArr2;
            long f4 = this.y[i5].f(coVarArr2, zArr, enVarArr3, zArr2, j4);
            if (i8 == 0) {
                j4 = f4;
            } else if (f4 != j4) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z2 = false;
            for (int i10 = 0; i10 < coVarArr.length; i10++) {
                boolean z3 = true;
                if (iArr2[i10] == i8) {
                    enVarArr2[i10] = enVarArr3[i10];
                    this.f320v.put((en) v5.y.v(enVarArr3[i10]), Integer.valueOf(i8));
                    z2 = true;
                } else if (iArr[i10] == i8) {
                    if (enVarArr3[i10] != null) {
                        z3 = false;
                    }
                    v5.y.fb(z3);
                }
            }
            if (z2) {
                arrayList2.add(this.y[i8]);
            }
            i5 = i8 + 1;
            arrayList = arrayList2;
            coVarArr2 = coVarArr3;
            coVar = null;
        }
        System.arraycopy(enVarArr2, 0, enVarArr, 0, length);
        d0[] d0VarArr = (d0[]) arrayList.toArray(new d0[0]);
        this.f317p = d0VarArr;
        this.f314co = this.f316fb.y(d0VarArr);
        return j4;
    }

    @Override // af.d0, af.jz
    public long fb() {
        return this.f314co.fb();
    }

    @Override // af.d0
    public long gv(long j2, vc vcVar) {
        d0 d0Var;
        d0[] d0VarArr = this.f317p;
        if (d0VarArr.length > 0) {
            d0Var = d0VarArr[0];
        } else {
            d0Var = this.y[0];
        }
        return d0Var.gv(j2, vcVar);
    }

    @Override // af.d0
    public long i9() {
        d0[] d0VarArr;
        d0[] d0VarArr2;
        long j2 = -9223372036854775807L;
        for (d0 d0Var : this.f317p) {
            long i92 = d0Var.i9();
            if (i92 != -9223372036854775807L) {
                if (j2 == -9223372036854775807L) {
                    for (d0 d0Var2 : this.f317p) {
                        if (d0Var2 == d0Var) {
                            break;
                        } else if (d0Var2.c5(i92) != i92) {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j2 = i92;
                } else if (i92 != j2) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (j2 != -9223372036854775807L && d0Var.c5(j2) != j2) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j2;
    }

    @Override // af.d0
    public void mt(long j2, boolean z2) {
        for (d0 d0Var : this.f317p) {
            d0Var.mt(j2, z2);
        }
    }

    @Override // af.d0.y
    public void n3(d0 d0Var) {
        this.f318s.remove(d0Var);
        if (!this.f318s.isEmpty()) {
            return;
        }
        int i = 0;
        for (d0 d0Var2 : this.y) {
            i += d0Var2.p().y;
        }
        rs[] rsVarArr = new rs[i];
        int i5 = 0;
        int i6 = 0;
        while (true) {
            d0[] d0VarArr = this.y;
            if (i5 < d0VarArr.length) {
                lc p2 = d0VarArr[i5].p();
                int i8 = p2.y;
                int i10 = 0;
                while (i10 < i8) {
                    rs n32 = p2.n3(i10);
                    rs n33 = n32.n3(i5 + ":" + n32.f381v);
                    this.f315f.put(n33, n32);
                    rsVarArr[i6] = n33;
                    i10++;
                    i6++;
                }
                i5++;
            } else {
                this.f321w = new lc(rsVarArr);
                ((d0.y) v5.y.v(this.f319t)).n3(this);
                return;
            }
        }
    }

    @Override // af.d0
    public lc p() {
        return (lc) v5.y.v(this.f321w);
    }

    @Override // af.d0, af.jz
    public void s(long j2) {
        this.f314co.s(j2);
    }

    @Override // af.d0, af.jz
    public boolean v(long j2) {
        if (!this.f318s.isEmpty()) {
            int size = this.f318s.size();
            for (int i = 0; i < size; i++) {
                this.f318s.get(i).v(j2);
            }
            return false;
        }
        return this.f314co.v(j2);
    }

    @Override // af.d0
    public void wz() throws IOException {
        for (d0 d0Var : this.y) {
            d0Var.wz();
        }
    }

    @Override // af.jz.y
    /* renamed from: xc */
    public void t(d0 d0Var) {
        ((d0.y) v5.y.v(this.f319t)).t(this);
    }

    @Override // af.d0, af.jz
    public boolean y() {
        return this.f314co.y();
    }

    @Override // af.d0, af.jz
    public long zn() {
        return this.f314co.zn();
    }
}

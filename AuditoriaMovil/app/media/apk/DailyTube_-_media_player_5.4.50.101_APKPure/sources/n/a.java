package n;

import androidx.core.app.NotificationCompat;
import c.n3;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import n.v;
/* loaded from: classes.dex */
public class a extends t {

    /* renamed from: gq  reason: collision with root package name */
    public int f11631gq;

    /* renamed from: l  reason: collision with root package name */
    public int f11636l;

    /* renamed from: qj  reason: collision with root package name */
    public int f11644qj;

    /* renamed from: vp  reason: collision with root package name */
    public int f11648vp;

    /* renamed from: xb  reason: collision with root package name */
    public c.n3 f11654xb = new c.n3(this);

    /* renamed from: wf  reason: collision with root package name */
    public c.v f11651wf = new c.v(this);

    /* renamed from: ad  reason: collision with root package name */
    public n3.InterfaceC0040n3 f11628ad = null;

    /* renamed from: cy  reason: collision with root package name */
    public boolean f11630cy = false;

    /* renamed from: qk  reason: collision with root package name */
    public f3.gv f11645qk = new f3.gv();

    /* renamed from: oa  reason: collision with root package name */
    public int f11641oa = 0;

    /* renamed from: w9  reason: collision with root package name */
    public int f11650w9 = 0;

    /* renamed from: w2  reason: collision with root package name */
    public zn[] f11649w2 = new zn[4];

    /* renamed from: x5  reason: collision with root package name */
    public zn[] f11653x5 = new zn[4];

    /* renamed from: q5  reason: collision with root package name */
    public boolean f11643q5 = false;

    /* renamed from: mp  reason: collision with root package name */
    public boolean f11638mp = false;

    /* renamed from: le  reason: collision with root package name */
    public boolean f11637le = false;

    /* renamed from: cs  reason: collision with root package name */
    public int f11629cs = 0;

    /* renamed from: ro  reason: collision with root package name */
    public int f11646ro = 0;

    /* renamed from: ix  reason: collision with root package name */
    public int f11634ix = 257;

    /* renamed from: yk  reason: collision with root package name */
    public boolean f11655yk = false;

    /* renamed from: i2  reason: collision with root package name */
    public boolean f11632i2 = false;

    /* renamed from: i3  reason: collision with root package name */
    public boolean f11633i3 = false;

    /* renamed from: vn  reason: collision with root package name */
    public int f11647vn = 0;

    /* renamed from: j3  reason: collision with root package name */
    public WeakReference<gv> f11635j3 = null;

    /* renamed from: ne  reason: collision with root package name */
    public WeakReference<gv> f11640ne = null;

    /* renamed from: q  reason: collision with root package name */
    public WeakReference<gv> f11642q = null;

    /* renamed from: wm  reason: collision with root package name */
    public WeakReference<gv> f11652wm = null;

    /* renamed from: nd  reason: collision with root package name */
    public n3.y f11639nd = new n3.y();

    public static boolean i(v vVar, n3.InterfaceC0040n3 interfaceC0040n3, n3.y yVar, int i) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i5;
        int i6;
        if (interfaceC0040n3 == null) {
            return false;
        }
        yVar.y = vVar.n();
        yVar.f3921n3 = vVar.vl();
        yVar.f3924zn = vVar.qn();
        yVar.f3919gv = vVar.x4();
        yVar.f3917c5 = false;
        yVar.f3920i9 = i;
        v.n3 n3Var = yVar.y;
        v.n3 n3Var2 = v.n3.MATCH_CONSTRAINT;
        if (n3Var == n3Var2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (yVar.f3921n3 == n3Var2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2 && vVar.f11732q9 > 0.0f) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 && vVar.f11732q9 > 0.0f) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z2 && vVar.ut(0) && vVar.f11751w == 0 && !z4) {
            yVar.y = v.n3.WRAP_CONTENT;
            if (z3 && vVar.f11729p == 0) {
                yVar.y = v.n3.FIXED;
            }
            z2 = false;
        }
        if (z3 && vVar.ut(1) && vVar.f11729p == 0 && !z5) {
            yVar.f3921n3 = v.n3.WRAP_CONTENT;
            if (z2 && vVar.f11751w == 0) {
                yVar.f3921n3 = v.n3.FIXED;
            }
            z3 = false;
        }
        if (vVar.dm()) {
            yVar.y = v.n3.FIXED;
            z2 = false;
        }
        if (vVar.ct()) {
            yVar.f3921n3 = v.n3.FIXED;
            z3 = false;
        }
        if (z4) {
            if (vVar.f11722mt[0] == 4) {
                yVar.y = v.n3.FIXED;
            } else if (!z3) {
                v.n3 n3Var3 = yVar.f3921n3;
                v.n3 n3Var4 = v.n3.FIXED;
                if (n3Var3 == n3Var4) {
                    i6 = yVar.f3919gv;
                } else {
                    yVar.y = v.n3.WRAP_CONTENT;
                    interfaceC0040n3.n3(vVar, yVar);
                    i6 = yVar.f3916a;
                }
                yVar.y = n3Var4;
                int i8 = vVar.f11716k;
                if (i8 != 0 && i8 != -1) {
                    yVar.f3924zn = (int) (vVar.z() / i6);
                } else {
                    yVar.f3924zn = (int) (vVar.z() * i6);
                }
            }
        }
        if (z5) {
            if (vVar.f11722mt[1] == 4) {
                yVar.f3921n3 = v.n3.FIXED;
            } else if (!z2) {
                v.n3 n3Var5 = yVar.y;
                v.n3 n3Var6 = v.n3.FIXED;
                if (n3Var5 == n3Var6) {
                    i5 = yVar.f3924zn;
                } else {
                    yVar.f3921n3 = v.n3.WRAP_CONTENT;
                    interfaceC0040n3.n3(vVar, yVar);
                    i5 = yVar.f3923v;
                }
                yVar.f3921n3 = n3Var6;
                int i10 = vVar.f11716k;
                if (i10 != 0 && i10 != -1) {
                    yVar.f3919gv = (int) (i5 * vVar.z());
                } else {
                    yVar.f3919gv = (int) (i5 / vVar.z());
                }
            }
        }
        interfaceC0040n3.n3(vVar, yVar);
        vVar.cs(yVar.f3923v);
        vVar.g(yVar.f3916a);
        vVar.m(yVar.f3922s);
        vVar.nf(yVar.f3918fb);
        yVar.f3920i9 = n3.y.f3913f;
        return yVar.f3917c5;
    }

    public final void br(gv gvVar, f3.c5 c5Var) {
        this.f11645qk.s(c5Var, this.f11645qk.p(gvVar), 0, 5);
    }

    public void bv(gv gvVar) {
        WeakReference<gv> weakReference = this.f11652wm;
        if (weakReference == null || weakReference.get() == null || gvVar.gv() > this.f11652wm.get().gv()) {
            this.f11652wm = new WeakReference<>(gvVar);
        }
    }

    public boolean c8(boolean z2) {
        return this.f11651wf.a(z2);
    }

    public void cx(int i) {
        this.f11634ix = i;
        f3.gv.f7795mt = rv(512);
    }

    public final void dp() {
        this.f11641oa = 0;
        this.f11650w9 = 0;
    }

    public void fc(gv gvVar) {
        WeakReference<gv> weakReference = this.f11640ne;
        if (weakReference == null || weakReference.get() == null || gvVar.gv() > this.f11640ne.get().gv()) {
            this.f11640ne = new WeakReference<>(gvVar);
        }
    }

    public final void gf(v vVar) {
        int i = this.f11641oa + 1;
        zn[] znVarArr = this.f11653x5;
        if (i >= znVarArr.length) {
            this.f11653x5 = (zn[]) Arrays.copyOf(znVarArr, znVarArr.length * 2);
        }
        this.f11653x5[this.f11641oa] = new zn(vVar, 0, gn());
        this.f11641oa++;
    }

    public boolean gn() {
        return this.f11630cy;
    }

    public boolean h(boolean z2) {
        return this.f11651wf.fb(z2);
    }

    public void hk() {
        this.f11651wf.i9();
    }

    public void hr(n3.InterfaceC0040n3 interfaceC0040n3) {
        this.f11628ad = interfaceC0040n3;
        this.f11651wf.wz(interfaceC0040n3);
    }

    public void hy(f3.gv gvVar, boolean[] zArr) {
        zArr[2] = false;
        boolean rv = rv(64);
        i3(gvVar, rv);
        int size = this.f11684o0.size();
        for (int i = 0; i < size; i++) {
            this.f11684o0.get(i).i3(gvVar, rv);
        }
    }

    @Override // n.v
    public void i2(boolean z2, boolean z3) {
        super.i2(z2, z3);
        int size = this.f11684o0.size();
        for (int i = 0; i < size; i++) {
            this.f11684o0.get(i).i2(z2, z3);
        }
    }

    public boolean ia(boolean z2, int i) {
        return this.f11651wf.s(z2, i);
    }

    public boolean ic() {
        return this.f11633i3;
    }

    public final void im(v vVar) {
        int i = this.f11650w9 + 1;
        zn[] znVarArr = this.f11649w2;
        if (i >= znVarArr.length) {
            this.f11649w2 = (zn[]) Arrays.copyOf(znVarArr, znVarArr.length * 2);
        }
        this.f11649w2[this.f11650w9] = new zn(vVar, 1, gn());
        this.f11650w9++;
    }

    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [boolean] */
    @Override // n.t
    public void j3() {
        int i;
        int i5;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        ?? r6;
        boolean z7;
        v.n3 n3Var;
        this.f11704f7 = 0;
        this.f11701en = 0;
        this.f11632i2 = false;
        this.f11633i3 = false;
        int size = this.f11684o0.size();
        int max = Math.max(0, qn());
        int max2 = Math.max(0, x4());
        v.n3[] n3VarArr = this.f11726o;
        v.n3 n3Var2 = n3VarArr[1];
        v.n3 n3Var3 = n3VarArr[0];
        if (i9.n3(this.f11634ix, 1)) {
            c.s.s(this, r6());
            for (int i6 = 0; i6 < size; i6++) {
                v vVar = this.f11684o0.get(i6);
                if (vVar.xg() && !(vVar instanceof fb) && !(vVar instanceof y) && !(vVar instanceof f) && !vVar.y5()) {
                    v.n3 co2 = vVar.co(0);
                    v.n3 co3 = vVar.co(1);
                    v.n3 n3Var4 = v.n3.MATCH_CONSTRAINT;
                    if (co2 != n3Var4 || vVar.f11751w == 1 || co3 != n3Var4 || vVar.f11729p == 1) {
                        i(vVar, this.f11628ad, new n3.y(), n3.y.f3913f);
                    }
                }
            }
        }
        if (size > 2 && ((n3Var3 == (n3Var = v.n3.WRAP_CONTENT) || n3Var2 == n3Var) && i9.n3(this.f11634ix, 1024) && c.c5.zn(this, r6()))) {
            if (n3Var3 == n3Var) {
                if (max < qn() && max > 0) {
                    cs(max);
                    this.f11632i2 = true;
                } else {
                    max = qn();
                }
            }
            if (n3Var2 == n3Var) {
                if (max2 < x4() && max2 > 0) {
                    g(max2);
                    this.f11633i3 = true;
                } else {
                    max2 = x4();
                }
            }
            i = max2;
            i5 = max;
            z2 = true;
        } else {
            i = max2;
            i5 = max;
            z2 = false;
        }
        if (!rv(64) && !rv(NotificationCompat.FLAG_HIGH_PRIORITY)) {
            z3 = false;
        } else {
            z3 = true;
        }
        f3.gv gvVar = this.f11645qk;
        gvVar.f7808s = false;
        gvVar.f7801c5 = false;
        if (this.f11634ix != 0 && z3) {
            gvVar.f7801c5 = true;
        }
        ArrayList<v> arrayList = this.f11684o0;
        v.n3 n2 = n();
        v.n3 n3Var5 = v.n3.WRAP_CONTENT;
        if (n2 != n3Var5 && vl() != n3Var5) {
            z4 = false;
        } else {
            z4 = true;
        }
        dp();
        for (int i8 = 0; i8 < size; i8++) {
            v vVar2 = this.f11684o0.get(i8);
            if (vVar2 instanceof t) {
                ((t) vVar2).j3();
            }
        }
        boolean rv = rv(64);
        boolean z8 = z2;
        int i10 = 0;
        boolean z9 = true;
        while (z9) {
            int i11 = i10 + 1;
            try {
                this.f11645qk.mg();
                dp();
                f(this.f11645qk);
                for (int i12 = 0; i12 < size; i12++) {
                    this.f11684o0.get(i12).f(this.f11645qk);
                }
                z9 = nd(this.f11645qk);
                WeakReference<gv> weakReference = this.f11635j3;
                if (weakReference != null && weakReference.get() != null) {
                    uo(this.f11635j3.get(), this.f11645qk.p(this.f11747ud));
                    this.f11635j3 = null;
                }
                WeakReference<gv> weakReference2 = this.f11642q;
                if (weakReference2 != null && weakReference2.get() != null) {
                    br(this.f11642q.get(), this.f11645qk.p(this.f11753x));
                    this.f11642q = null;
                }
                WeakReference<gv> weakReference3 = this.f11640ne;
                if (weakReference3 != null && weakReference3.get() != null) {
                    uo(this.f11640ne.get(), this.f11645qk.p(this.f11700ej));
                    this.f11640ne = null;
                }
                WeakReference<gv> weakReference4 = this.f11652wm;
                if (weakReference4 != null && weakReference4.get() != null) {
                    br(this.f11652wm.get(), this.f11645qk.p(this.f11687a8));
                    this.f11652wm = null;
                }
                if (z9) {
                    this.f11645qk.c();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                PrintStream printStream = System.out;
                printStream.println("EXCEPTION : " + e2);
            }
            if (z9) {
                hy(this.f11645qk, i9.y);
            } else {
                i3(this.f11645qk, rv);
                for (int i13 = 0; i13 < size; i13++) {
                    this.f11684o0.get(i13).i3(this.f11645qk, rv);
                }
            }
            if (z4 && i11 < 8 && i9.y[2]) {
                int i14 = 0;
                int i15 = 0;
                for (int i16 = 0; i16 < size; i16++) {
                    v vVar3 = this.f11684o0.get(i16);
                    i14 = Math.max(i14, vVar3.f11704f7 + vVar3.qn());
                    i15 = Math.max(i15, vVar3.f11701en + vVar3.x4());
                }
                int max3 = Math.max(this.f11694ct, i14);
                int max4 = Math.max(this.f11727o4, i15);
                v.n3 n3Var6 = v.n3.WRAP_CONTENT;
                if (n3Var3 == n3Var6 && qn() < max3) {
                    cs(max3);
                    this.f11726o[0] = n3Var6;
                    z5 = true;
                    z8 = true;
                } else {
                    z5 = false;
                }
                if (n3Var2 == n3Var6 && x4() < max4) {
                    g(max4);
                    this.f11726o[1] = n3Var6;
                    z5 = true;
                    z8 = true;
                }
            } else {
                z5 = false;
            }
            int max5 = Math.max(this.f11694ct, qn());
            if (max5 > qn()) {
                cs(max5);
                this.f11726o[0] = v.n3.FIXED;
                z5 = true;
                z8 = true;
            }
            int max6 = Math.max(this.f11727o4, x4());
            if (max6 > x4()) {
                g(max6);
                r6 = 1;
                this.f11726o[1] = v.n3.FIXED;
                z5 = true;
                z7 = true;
            } else {
                r6 = 1;
                z7 = z8;
            }
            if (!z7) {
                v.n3 n3Var7 = this.f11726o[0];
                v.n3 n3Var8 = v.n3.WRAP_CONTENT;
                if (n3Var7 == n3Var8 && i5 > 0 && qn() > i5) {
                    this.f11632i2 = r6;
                    this.f11726o[0] = v.n3.FIXED;
                    cs(i5);
                    z5 = true;
                    z7 = true;
                }
                if (this.f11726o[r6] == n3Var8 && i > 0 && x4() > i) {
                    this.f11633i3 = r6;
                    this.f11726o[r6] = v.n3.FIXED;
                    g(i);
                    z8 = true;
                    z9 = true;
                    i10 = i11;
                }
            }
            z9 = z5;
            z8 = z7;
            i10 = i11;
        }
        this.f11684o0 = arrayList;
        if (z8) {
            v.n3[] n3VarArr2 = this.f11726o;
            n3VarArr2[0] = n3Var3;
            n3VarArr2[1] = n3Var2;
        }
        lc(this.f11645qk.x4());
    }

    public int jr() {
        return this.f11634ix;
    }

    public void k3() {
        this.f11651wf.f();
    }

    public void mh(gv gvVar) {
        WeakReference<gv> weakReference = this.f11642q;
        if (weakReference == null || weakReference.get() == null || gvVar.gv() > this.f11642q.get().gv()) {
            this.f11642q = new WeakReference<>(gvVar);
        }
    }

    public void n7(gv gvVar) {
        WeakReference<gv> weakReference = this.f11635j3;
        if (weakReference == null || weakReference.get() == null || gvVar.gv() > this.f11635j3.get().gv()) {
            this.f11635j3 = new WeakReference<>(gvVar);
        }
    }

    public boolean nd(f3.gv gvVar) {
        int i;
        boolean rv = rv(64);
        fb(gvVar, rv);
        int size = this.f11684o0.size();
        boolean z2 = false;
        for (int i5 = 0; i5 < size; i5++) {
            v vVar = this.f11684o0.get(i5);
            vVar.cr(0, false);
            vVar.cr(1, false);
            if (vVar instanceof y) {
                z2 = true;
            }
        }
        if (z2) {
            for (int i6 = 0; i6 < size; i6++) {
                v vVar2 = this.f11684o0.get(i6);
                if (vVar2 instanceof y) {
                    ((y) vVar2).bv();
                }
            }
        }
        for (int i8 = 0; i8 < size; i8++) {
            v vVar3 = this.f11684o0.get(i8);
            if (vVar3.a()) {
                vVar3.fb(gvVar, rv);
            }
        }
        if (f3.gv.f7795mt) {
            HashSet<v> hashSet = new HashSet<>();
            for (int i10 = 0; i10 < size; i10++) {
                v vVar4 = this.f11684o0.get(i10);
                if (!vVar4.a()) {
                    hashSet.add(vVar4);
                }
            }
            if (n() == v.n3.WRAP_CONTENT) {
                i = 0;
            } else {
                i = 1;
            }
            v(this, gvVar, hashSet, i, false);
            Iterator<v> it = hashSet.iterator();
            while (it.hasNext()) {
                v next = it.next();
                i9.y(this, gvVar, next);
                next.fb(gvVar, rv);
            }
        } else {
            for (int i11 = 0; i11 < size; i11++) {
                v vVar5 = this.f11684o0.get(i11);
                if (vVar5 instanceof a) {
                    v.n3[] n3VarArr = vVar5.f11726o;
                    v.n3 n3Var = n3VarArr[0];
                    v.n3 n3Var2 = n3VarArr[1];
                    v.n3 n3Var3 = v.n3.WRAP_CONTENT;
                    if (n3Var == n3Var3) {
                        vVar5.tg(v.n3.FIXED);
                    }
                    if (n3Var2 == n3Var3) {
                        vVar5.x5(v.n3.FIXED);
                    }
                    vVar5.fb(gvVar, rv);
                    if (n3Var == n3Var3) {
                        vVar5.tg(n3Var);
                    }
                    if (n3Var2 == n3Var3) {
                        vVar5.x5(n3Var2);
                    }
                } else {
                    i9.y(this, gvVar, vVar5);
                    if (!vVar5.a()) {
                        vVar5.fb(gvVar, rv);
                    }
                }
            }
        }
        if (this.f11641oa > 0) {
            n3.n3(this, gvVar, null, 0);
        }
        if (this.f11650w9 > 0) {
            n3.n3(this, gvVar, null, 1);
        }
        return true;
    }

    public long p1(int i, int i5, int i6, int i8, int i10, int i11, int i12, int i13, int i14) {
        this.f11644qj = i13;
        this.f11636l = i14;
        return this.f11654xb.gv(this, i, i13, i14, i5, i6, i8, i10, i11, i12);
    }

    public n3.InterfaceC0040n3 r6() {
        return this.f11628ad;
    }

    @Override // n.t, n.v
    public void rs() {
        this.f11645qk.mg();
        this.f11644qj = 0;
        this.f11631gq = 0;
        this.f11636l = 0;
        this.f11648vp = 0;
        this.f11655yk = false;
        super.rs();
    }

    public boolean rv(int i) {
        if ((this.f11634ix & i) == i) {
            return true;
        }
        return false;
    }

    public final void uo(gv gvVar, f3.c5 c5Var) {
        this.f11645qk.s(this.f11645qk.p(gvVar), c5Var, 0, 5);
    }

    public boolean vc() {
        return this.f11632i2;
    }

    public void vh(boolean z2) {
        this.f11630cy = z2;
    }

    public void wm(v vVar, int i) {
        if (i == 0) {
            gf(vVar);
        } else if (i == 1) {
            im(vVar);
        }
    }

    public void xq() {
        this.f11654xb.v(this);
    }

    public f3.gv zq() {
        return this.f11645qk;
    }
}

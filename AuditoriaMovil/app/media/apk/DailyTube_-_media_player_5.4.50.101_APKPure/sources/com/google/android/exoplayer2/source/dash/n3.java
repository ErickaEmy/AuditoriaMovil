package com.google.android.exoplayer2.source.dash;

import af.b;
import af.d0;
import af.en;
import af.jz;
import af.lc;
import af.rs;
import af.z;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.a;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.source.dash.v;
import com.google.android.exoplayer2.source.dash.y;
import dq.fb;
import dq.i9;
import dq.s;
import dq.tl;
import fj.u0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kx.d;
import kx.mg;
import kx.o;
import m1.m;
import m1.vc;
import p7.c5;
import v5.j5;
import zo.co;
import zr.f;
/* loaded from: classes.dex */
public final class n3 implements d0, jz.y<c5<com.google.android.exoplayer2.source.dash.y>>, c5.n3<com.google.android.exoplayer2.source.dash.y> {

    /* renamed from: oz  reason: collision with root package name */
    public static final Pattern f4410oz = Pattern.compile("CC([1-4])=(.+)");

    /* renamed from: ut  reason: collision with root package name */
    public static final Pattern f4411ut = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");

    /* renamed from: co  reason: collision with root package name */
    public final kx.n3 f4414co;

    /* renamed from: d  reason: collision with root package name */
    public final u0 f4415d;

    /* renamed from: d0  reason: collision with root package name */
    public final b.y f4416d0;
    @Nullable

    /* renamed from: ej  reason: collision with root package name */
    public d0.y f4417ej;

    /* renamed from: f  reason: collision with root package name */
    public final mg f4418f;

    /* renamed from: f3  reason: collision with root package name */
    public final af.c5 f4419f3;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public final o f4420fb;

    /* renamed from: fh  reason: collision with root package name */
    public final v.y f4421fh;

    /* renamed from: j  reason: collision with root package name */
    public List<s> f4422j;

    /* renamed from: j5  reason: collision with root package name */
    public jz f4423j5;

    /* renamed from: n  reason: collision with root package name */
    public final v f4424n;

    /* renamed from: o  reason: collision with root package name */
    public int f4425o;

    /* renamed from: p  reason: collision with root package name */
    public final d f4426p;

    /* renamed from: qn  reason: collision with root package name */
    public dq.zn f4427qn;

    /* renamed from: r  reason: collision with root package name */
    public final y[] f4428r;

    /* renamed from: s  reason: collision with root package name */
    public final a f4429s;

    /* renamed from: t  reason: collision with root package name */
    public final zr.n3 f4430t;

    /* renamed from: v  reason: collision with root package name */
    public final y.InterfaceC0047y f4431v;

    /* renamed from: w  reason: collision with root package name */
    public final long f4432w;
    public final int y;

    /* renamed from: z  reason: collision with root package name */
    public final lc f4434z;

    /* renamed from: x  reason: collision with root package name */
    public c5<com.google.android.exoplayer2.source.dash.y>[] f4433x = ta(0);

    /* renamed from: b  reason: collision with root package name */
    public f[] f4412b = new f[0];

    /* renamed from: c  reason: collision with root package name */
    public final IdentityHashMap<c5<com.google.android.exoplayer2.source.dash.y>, v.zn> f4413c = new IdentityHashMap<>();

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: a  reason: collision with root package name */
        public final int f4435a;

        /* renamed from: fb  reason: collision with root package name */
        public final int f4436fb;

        /* renamed from: gv  reason: collision with root package name */
        public final int f4437gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f4438n3;

        /* renamed from: v  reason: collision with root package name */
        public final int f4439v;
        public final int[] y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f4440zn;

        public y(int i, int i5, int[] iArr, int i6, int i8, int i10, int i11) {
            this.f4438n3 = i;
            this.y = iArr;
            this.f4440zn = i5;
            this.f4439v = i6;
            this.f4435a = i8;
            this.f4436fb = i10;
            this.f4437gv = i11;
        }

        public static y gv(int i, int[] iArr, int i5, int i6, int i8) {
            return new y(i, 0, iArr, i5, i6, i8, -1);
        }

        public static y n3(int[] iArr, int i) {
            return new y(5, 1, iArr, i, -1, -1, -1);
        }

        public static y y(int[] iArr, int i) {
            return new y(3, 1, iArr, i, -1, -1, -1);
        }

        public static y zn(int i) {
            return new y(5, 2, new int[0], -1, -1, -1, i);
        }
    }

    public n3(int i, dq.zn znVar, zr.n3 n3Var, int i5, y.InterfaceC0047y interfaceC0047y, @Nullable o oVar, a aVar, v.y yVar, mg mgVar, b.y yVar2, long j2, d dVar, kx.n3 n3Var2, af.c5 c5Var, v.n3 n3Var3, u0 u0Var) {
        this.y = i;
        this.f4427qn = znVar;
        this.f4430t = n3Var;
        this.f4425o = i5;
        this.f4431v = interfaceC0047y;
        this.f4420fb = oVar;
        this.f4429s = aVar;
        this.f4421fh = yVar;
        this.f4418f = mgVar;
        this.f4416d0 = yVar2;
        this.f4432w = j2;
        this.f4426p = dVar;
        this.f4414co = n3Var2;
        this.f4419f3 = c5Var;
        this.f4415d = u0Var;
        this.f4424n = new v(znVar, n3Var3, n3Var2);
        this.f4423j5 = c5Var.y(this.f4433x);
        i9 gv2 = znVar.gv(i5);
        List<s> list = gv2.f7364gv;
        this.f4422j = list;
        Pair<lc, y[]> r2 = r(aVar, gv2.f7367zn, list);
        this.f4434z = (lc) r2.first;
        this.f4428r = (y[]) r2.second;
    }

    public static int[][] c(List<dq.y> list) {
        int i;
        fb x42;
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i5 = 0; i5 < size; i5++) {
            sparseIntArray.put(list.get(i5).y, i5);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i5));
            arrayList.add(arrayList2);
            sparseArray.put(i5, arrayList2);
        }
        for (int i6 = 0; i6 < size; i6++) {
            dq.y yVar = list.get(i6);
            fb f32 = f3(yVar.f7417v);
            if (f32 == null) {
                f32 = f3(yVar.f7414a);
            }
            if (f32 == null || (i = sparseIntArray.get(Integer.parseInt(f32.f7361n3), -1)) == -1) {
                i = i6;
            }
            if (i == i6 && (x42 = x4(yVar.f7414a)) != null) {
                for (String str : j5.ro(x42.f7361n3, ",")) {
                    int i8 = sparseIntArray.get(Integer.parseInt(str), -1);
                    if (i8 != -1) {
                        i = Math.min(i, i8);
                    }
                }
            }
            if (i != i6) {
                List list2 = (List) sparseArray.get(i6);
                List list3 = (List) sparseArray.get(i);
                list3.addAll(list2);
                sparseArray.put(i6, list3);
                arrayList.remove(list2);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2];
        for (int i10 = 0; i10 < size2; i10++) {
            int[] wz2 = d1.a.wz((Collection) arrayList.get(i10));
            iArr[i10] = wz2;
            Arrays.sort(wz2);
        }
        return iArr;
    }

    @Nullable
    public static fb f3(List<fb> list) {
        return i4(list, "http://dashif.org/guidelines/trickmode");
    }

    @Nullable
    public static fb i4(List<fb> list, String str) {
        for (int i = 0; i < list.size(); i++) {
            fb fbVar = list.get(i);
            if (str.equals(fbVar.y)) {
                return fbVar;
            }
        }
        return null;
    }

    public static int mg(int i, List<dq.y> list, int[][] iArr, boolean[] zArr, m[][] mVarArr) {
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            if (rz(list, iArr[i6])) {
                zArr[i6] = true;
                i5++;
            }
            m[] n2 = n(list, iArr[i6]);
            mVarArr[i6] = n2;
            if (n2.length != 0) {
                i5++;
            }
        }
        return i5;
    }

    public static m[] n(List<dq.y> list, int[] iArr) {
        for (int i : iArr) {
            dq.y yVar = list.get(i);
            List<fb> list2 = list.get(i).f7415gv;
            for (int i5 = 0; i5 < list2.size(); i5++) {
                fb fbVar = list2.get(i5);
                if ("urn:scte:dash:cc:cea-608:2015".equals(fbVar.y)) {
                    return z6(fbVar, f4410oz, new m.n3().o4("application/cea-608").oz(yVar.y + ":cea608").z6());
                } else if ("urn:scte:dash:cc:cea-708:2015".equals(fbVar.y)) {
                    return z6(fbVar, f4411ut, new m.n3().o4("application/cea-708").oz(yVar.y + ":cea708").z6());
                }
            }
        }
        return new m[0];
    }

    public static Pair<lc, y[]> r(a aVar, List<dq.y> list, List<s> list2) {
        int[][] c2 = c(list);
        int length = c2.length;
        boolean[] zArr = new boolean[length];
        m[][] mVarArr = new m[length];
        int mg2 = mg(length, list, c2, zArr, mVarArr) + length + list2.size();
        rs[] rsVarArr = new rs[mg2];
        y[] yVarArr = new y[mg2];
        xc(list2, rsVarArr, yVarArr, w(aVar, list, c2, length, zArr, mVarArr, rsVarArr, yVarArr));
        return Pair.create(new lc(rsVarArr), yVarArr);
    }

    public static boolean rz(List<dq.y> list, int[] iArr) {
        for (int i : iArr) {
            List<tl> list2 = list.get(i).f7418zn;
            for (int i5 = 0; i5 < list2.size(); i5++) {
                if (!list2.get(i5).f7387v.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static c5<com.google.android.exoplayer2.source.dash.y>[] ta(int i) {
        return new c5[i];
    }

    public static int w(a aVar, List<dq.y> list, int[][] iArr, int i, boolean[] zArr, m[][] mVarArr, rs[] rsVarArr, y[] yVarArr) {
        String str;
        int i5;
        int i6;
        int i8 = 0;
        int i10 = 0;
        while (i8 < i) {
            int[] iArr2 = iArr[i8];
            ArrayList arrayList = new ArrayList();
            for (int i11 : iArr2) {
                arrayList.addAll(list.get(i11).f7418zn);
            }
            int size = arrayList.size();
            m[] mVarArr2 = new m[size];
            for (int i12 = 0; i12 < size; i12++) {
                m mVar = ((tl) arrayList.get(i12)).f7385n3;
                mVarArr2[i12] = mVar.zn(aVar.n3(mVar));
            }
            dq.y yVar = list.get(iArr2[0]);
            int i13 = yVar.y;
            if (i13 != -1) {
                str = Integer.toString(i13);
            } else {
                str = "unset:" + i8;
            }
            int i14 = i10 + 1;
            if (zArr[i8]) {
                i5 = i10 + 2;
            } else {
                i5 = i14;
                i14 = -1;
            }
            if (mVarArr[i8].length != 0) {
                i6 = i5 + 1;
            } else {
                i6 = i5;
                i5 = -1;
            }
            rsVarArr[i10] = new rs(str, mVarArr2);
            yVarArr[i10] = y.gv(yVar.f7416n3, iArr2, i10, i14, i5);
            if (i14 != -1) {
                String str2 = str + ":emsg";
                rsVarArr[i14] = new rs(str2, new m.n3().oz(str2).o4("application/x-emsg").z6());
                yVarArr[i14] = y.n3(iArr2, i10);
            }
            if (i5 != -1) {
                rsVarArr[i5] = new rs(str + ":cc", mVarArr[i8]);
                yVarArr[i5] = y.y(iArr2, i10);
            }
            i8++;
            i10 = i6;
        }
        return i10;
    }

    @Nullable
    public static fb x4(List<fb> list) {
        return i4(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    public static void xc(List<s> list, rs[] rsVarArr, y[] yVarArr, int i) {
        int i5 = 0;
        while (i5 < list.size()) {
            s sVar = list.get(i5);
            m z62 = new m.n3().oz(sVar.y()).o4("application/x-emsg").z6();
            rsVarArr[i] = new rs(sVar.y() + ":" + i5, z62);
            yVarArr[i] = y.zn(i5);
            i5++;
            i++;
        }
    }

    public static m[] z6(fb fbVar, Pattern pattern, m mVar) {
        String str = fbVar.f7361n3;
        if (str == null) {
            return new m[]{mVar};
        }
        String[] ro2 = j5.ro(str, ";");
        m[] mVarArr = new m[ro2.length];
        for (int i = 0; i < ro2.length; i++) {
            Matcher matcher = pattern.matcher(ro2[i]);
            if (!matcher.matches()) {
                return new m[]{mVar};
            }
            int parseInt = Integer.parseInt(matcher.group(1));
            m.n3 n32 = mVar.n3();
            mVarArr[i] = n32.oz(mVar.y + ":" + parseInt).ej(parseInt).k(matcher.group(2)).z6();
        }
        return mVarArr;
    }

    @Override // p7.c5.n3
    public synchronized void a(c5<com.google.android.exoplayer2.source.dash.y> c5Var) {
        v.zn remove = this.f4413c.remove(c5Var);
        if (remove != null) {
            remove.wz();
        }
    }

    public final void a8(co[] coVarArr, en[] enVarArr, int[] iArr) {
        boolean z2;
        for (int i = 0; i < coVarArr.length; i++) {
            en enVar = enVarArr[i];
            if ((enVar instanceof z) || (enVar instanceof c5.y)) {
                int d02 = d0(i, iArr);
                if (d02 == -1) {
                    z2 = enVarArr[i] instanceof z;
                } else {
                    en enVar2 = enVarArr[i];
                    if ((enVar2 instanceof c5.y) && ((c5.y) enVar2).y == enVarArr[d02]) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
                if (!z2) {
                    en enVar3 = enVarArr[i];
                    if (enVar3 instanceof c5.y) {
                        ((c5.y) enVar3).zn();
                    }
                    enVarArr[i] = null;
                }
            }
        }
    }

    public void b(dq.zn znVar, int i) {
        f[] fVarArr;
        this.f4427qn = znVar;
        this.f4425o = i;
        this.f4424n.p(znVar);
        c5<com.google.android.exoplayer2.source.dash.y>[] c5VarArr = this.f4433x;
        if (c5VarArr != null) {
            for (c5<com.google.android.exoplayer2.source.dash.y> c5Var : c5VarArr) {
                c5Var.d0().zn(znVar, i);
            }
            this.f4417ej.t(this);
        }
        this.f4422j = znVar.gv(i).f7364gv;
        for (f fVar : this.f4412b) {
            Iterator<s> it = this.f4422j.iterator();
            while (true) {
                if (it.hasNext()) {
                    s next = it.next();
                    if (next.y().equals(fVar.y())) {
                        boolean z2 = true;
                        fVar.gv(next, (znVar.f7423gv && i == znVar.v() - 1) ? false : false);
                    }
                }
            }
        }
    }

    @Override // af.d0
    public long c5(long j2) {
        for (c5<com.google.android.exoplayer2.source.dash.y> c5Var : this.f4433x) {
            c5Var.j5(j2);
        }
        for (f fVar : this.f4412b) {
            fVar.zn(j2);
        }
        return j2;
    }

    @Override // af.d0
    public void co(d0.y yVar, long j2) {
        this.f4417ej = yVar;
        yVar.n3(this);
    }

    @Override // af.jz.y
    /* renamed from: d */
    public void t(c5<com.google.android.exoplayer2.source.dash.y> c5Var) {
        this.f4417ej.t(this);
    }

    public final int d0(int i, int[] iArr) {
        int i5 = iArr[i];
        if (i5 == -1) {
            return -1;
        }
        int i6 = this.f4428r[i5].f4439v;
        for (int i8 = 0; i8 < iArr.length; i8++) {
            int i10 = iArr[i8];
            if (i10 == i6 && this.f4428r[i10].f4440zn == 0) {
                return i8;
            }
        }
        return -1;
    }

    public void ej() {
        this.f4424n.xc();
        for (c5<com.google.android.exoplayer2.source.dash.y> c5Var : this.f4433x) {
            c5Var.vl(this);
        }
        this.f4417ej = null;
    }

    @Override // af.d0
    public long f(co[] coVarArr, boolean[] zArr, en[] enVarArr, boolean[] zArr2, long j2) {
        int[] fh2 = fh(coVarArr);
        ud(coVarArr, zArr, enVarArr);
        a8(coVarArr, enVarArr, fh2);
        x(coVarArr, enVarArr, zArr2, j2, fh2);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (en enVar : enVarArr) {
            if (enVar instanceof c5) {
                arrayList.add((c5) enVar);
            } else if (enVar instanceof f) {
                arrayList2.add((f) enVar);
            }
        }
        c5<com.google.android.exoplayer2.source.dash.y>[] ta2 = ta(arrayList.size());
        this.f4433x = ta2;
        arrayList.toArray(ta2);
        f[] fVarArr = new f[arrayList2.size()];
        this.f4412b = fVarArr;
        arrayList2.toArray(fVarArr);
        this.f4423j5 = this.f4419f3.y(this.f4433x);
        return j2;
    }

    @Override // af.d0, af.jz
    public long fb() {
        return this.f4423j5.fb();
    }

    public final int[] fh(co[] coVarArr) {
        int[] iArr = new int[coVarArr.length];
        for (int i = 0; i < coVarArr.length; i++) {
            co coVar = coVarArr[i];
            if (coVar != null) {
                iArr[i] = this.f4434z.zn(coVar.xc());
            } else {
                iArr[i] = -1;
            }
        }
        return iArr;
    }

    @Override // af.d0
    public long gv(long j2, vc vcVar) {
        c5<com.google.android.exoplayer2.source.dash.y>[] c5VarArr;
        for (c5<com.google.android.exoplayer2.source.dash.y> c5Var : this.f4433x) {
            if (c5Var.y == 2) {
                return c5Var.gv(j2, vcVar);
            }
        }
        return j2;
    }

    @Override // af.d0
    public long i9() {
        return -9223372036854775807L;
    }

    @Override // af.d0
    public void mt(long j2, boolean z2) {
        for (c5<com.google.android.exoplayer2.source.dash.y> c5Var : this.f4433x) {
            c5Var.mt(j2, z2);
        }
    }

    @Override // af.d0
    public lc p() {
        return this.f4434z;
    }

    @Override // af.d0, af.jz
    public void s(long j2) {
        this.f4423j5.s(j2);
    }

    public final void ud(co[] coVarArr, boolean[] zArr, en[] enVarArr) {
        for (int i = 0; i < coVarArr.length; i++) {
            if (coVarArr[i] == null || !zArr[i]) {
                en enVar = enVarArr[i];
                if (enVar instanceof c5) {
                    ((c5) enVar).vl(this);
                } else if (enVar instanceof c5.y) {
                    ((c5.y) enVar).zn();
                }
                enVarArr[i] = null;
            }
        }
    }

    @Override // af.d0, af.jz
    public boolean v(long j2) {
        return this.f4423j5.v(j2);
    }

    @Override // af.d0
    public void wz() throws IOException {
        this.f4426p.n3();
    }

    public final void x(co[] coVarArr, en[] enVarArr, boolean[] zArr, long j2, int[] iArr) {
        for (int i = 0; i < coVarArr.length; i++) {
            co coVar = coVarArr[i];
            if (coVar != null) {
                en enVar = enVarArr[i];
                if (enVar == null) {
                    zArr[i] = true;
                    y yVar = this.f4428r[iArr[i]];
                    int i5 = yVar.f4440zn;
                    if (i5 == 0) {
                        enVarArr[i] = z(yVar, coVar, j2);
                    } else if (i5 == 2) {
                        enVarArr[i] = new f(this.f4422j.get(yVar.f4437gv), coVar.xc().zn(0), this.f4427qn.f7423gv);
                    }
                } else if (enVar instanceof c5) {
                    ((com.google.android.exoplayer2.source.dash.y) ((c5) enVar).d0()).y(coVar);
                }
            }
        }
        for (int i6 = 0; i6 < coVarArr.length; i6++) {
            if (enVarArr[i6] == null && coVarArr[i6] != null) {
                y yVar2 = this.f4428r[iArr[i6]];
                if (yVar2.f4440zn == 1) {
                    int d02 = d0(i6, iArr);
                    if (d02 == -1) {
                        enVarArr[i6] = new z();
                    } else {
                        enVarArr[i6] = ((c5) enVarArr[d02]).qn(j2, yVar2.f4438n3);
                    }
                }
            }
        }
    }

    @Override // af.d0, af.jz
    public boolean y() {
        return this.f4423j5.y();
    }

    public final c5<com.google.android.exoplayer2.source.dash.y> z(y yVar, co coVar, long j2) {
        boolean z2;
        rs rsVar;
        int i;
        boolean z3;
        rs rsVar2;
        int i5;
        int i6 = yVar.f4435a;
        if (i6 != -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        v.zn znVar = null;
        if (z2) {
            rsVar = this.f4434z.n3(i6);
            i = 1;
        } else {
            rsVar = null;
            i = 0;
        }
        int i8 = yVar.f4436fb;
        if (i8 != -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            rsVar2 = this.f4434z.n3(i8);
            i += rsVar2.y;
        } else {
            rsVar2 = null;
        }
        m[] mVarArr = new m[i];
        int[] iArr = new int[i];
        if (z2) {
            mVarArr[0] = rsVar.zn(0);
            iArr[0] = 5;
            i5 = 1;
        } else {
            i5 = 0;
        }
        ArrayList arrayList = new ArrayList();
        if (z3) {
            for (int i10 = 0; i10 < rsVar2.y; i10++) {
                m zn2 = rsVar2.zn(i10);
                mVarArr[i5] = zn2;
                iArr[i5] = 3;
                arrayList.add(zn2);
                i5++;
            }
        }
        if (this.f4427qn.f7423gv && z2) {
            znVar = this.f4424n.f();
        }
        v.zn znVar2 = znVar;
        c5<com.google.android.exoplayer2.source.dash.y> c5Var = new c5<>(yVar.f4438n3, iArr, mVarArr, this.f4431v.y(this.f4426p, this.f4427qn, this.f4430t, this.f4425o, yVar.y, coVar, yVar.f4438n3, this.f4432w, z2, arrayList, znVar2, this.f4420fb, this.f4415d), this, this.f4414co, j2, this.f4429s, this.f4421fh, this.f4418f, this.f4416d0);
        synchronized (this) {
            this.f4413c.put(c5Var, znVar2);
        }
        return c5Var;
    }

    @Override // af.d0, af.jz
    public long zn() {
        return this.f4423j5.zn();
    }
}

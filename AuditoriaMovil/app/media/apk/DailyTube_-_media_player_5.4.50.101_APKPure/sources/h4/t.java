package h4;

import af.b;
import af.d0;
import af.en;
import af.jz;
import af.lc;
import af.rs;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.metadata.Metadata;
import fj.u0;
import h4.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import kx.mg;
import kx.o;
import lw.s;
import lw.t;
import m1.m;
import m1.vc;
import v5.j5;
import v5.n;
/* loaded from: classes.dex */
public final class t implements d0, t.n3 {

    /* renamed from: b  reason: collision with root package name */
    public lc f8678b;

    /* renamed from: c  reason: collision with root package name */
    public final int f8679c;

    /* renamed from: co  reason: collision with root package name */
    public final kx.n3 f8680co;

    /* renamed from: d0  reason: collision with root package name */
    public final boolean f8682d0;
    @Nullable

    /* renamed from: ej  reason: collision with root package name */
    public d0.y f8683ej;

    /* renamed from: f  reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.a f8684f;

    /* renamed from: f3  reason: collision with root package name */
    public final af.c5 f8685f3;

    /* renamed from: fb  reason: collision with root package name */
    public final fb f8686fb;

    /* renamed from: fh  reason: collision with root package name */
    public final u0 f8687fh;

    /* renamed from: j  reason: collision with root package name */
    public int f8688j;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f8690n;

    /* renamed from: oz  reason: collision with root package name */
    public jz f8692oz;

    /* renamed from: p  reason: collision with root package name */
    public final b.y f8693p;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public final o f8696s;

    /* renamed from: t  reason: collision with root package name */
    public final v.y f8697t;

    /* renamed from: v  reason: collision with root package name */
    public final lw.t f8698v;

    /* renamed from: w  reason: collision with root package name */
    public final mg f8699w;

    /* renamed from: x  reason: collision with root package name */
    public int f8700x;
    public final s y;

    /* renamed from: d  reason: collision with root package name */
    public final p.n3 f8681d = new n3();

    /* renamed from: z  reason: collision with root package name */
    public final IdentityHashMap<en, Integer> f8701z = new IdentityHashMap<>();

    /* renamed from: r  reason: collision with root package name */
    public final co f8695r = new co();

    /* renamed from: j5  reason: collision with root package name */
    public p[] f8689j5 = new p[0];

    /* renamed from: qn  reason: collision with root package name */
    public p[] f8694qn = new p[0];

    /* renamed from: o  reason: collision with root package name */
    public int[][] f8691o = new int[0];

    /* loaded from: classes.dex */
    public class n3 implements p.n3 {
        public n3() {
        }

        @Override // h4.p.n3
        public void onPrepared() {
            p[] pVarArr;
            if (t.t(t.this) <= 0) {
                int i = 0;
                for (p pVar : t.this.f8689j5) {
                    i += pVar.p().y;
                }
                rs[] rsVarArr = new rs[i];
                int i5 = 0;
                for (p pVar2 : t.this.f8689j5) {
                    int i6 = pVar2.p().y;
                    int i8 = 0;
                    while (i8 < i6) {
                        rsVarArr[i5] = pVar2.p().n3(i8);
                        i8++;
                        i5++;
                    }
                }
                t.this.f8678b = new lc(rsVarArr);
                t.this.f8683ej.n3(t.this);
            }
        }

        @Override // h4.p.n3
        public void tl(Uri uri) {
            t.this.f8698v.a(uri);
        }

        @Override // af.jz.y
        /* renamed from: y */
        public void t(p pVar) {
            t.this.f8683ej.t(t.this);
        }
    }

    public t(s sVar, lw.t tVar, fb fbVar, @Nullable o oVar, com.google.android.exoplayer2.drm.a aVar, v.y yVar, mg mgVar, b.y yVar2, kx.n3 n3Var, af.c5 c5Var, boolean z2, int i, boolean z3, u0 u0Var) {
        this.y = sVar;
        this.f8698v = tVar;
        this.f8686fb = fbVar;
        this.f8696s = oVar;
        this.f8684f = aVar;
        this.f8697t = yVar;
        this.f8699w = mgVar;
        this.f8693p = yVar2;
        this.f8680co = n3Var;
        this.f8685f3 = c5Var;
        this.f8690n = z2;
        this.f8679c = i;
        this.f8682d0 = z3;
        this.f8687fh = u0Var;
        this.f8692oz = c5Var.y(new jz[0]);
    }

    public static Map<String, DrmInitData> c(List<DrmInitData> list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i < arrayList.size()) {
            DrmInitData drmInitData = list.get(i);
            String str = drmInitData.f4114fb;
            i++;
            int i5 = i;
            while (i5 < arrayList.size()) {
                DrmInitData drmInitData2 = (DrmInitData) arrayList.get(i5);
                if (TextUtils.equals(drmInitData2.f4114fb, str)) {
                    drmInitData = drmInitData.a(drmInitData2);
                    arrayList.remove(i5);
                } else {
                    i5++;
                }
            }
            hashMap.put(str, drmInitData);
        }
        return hashMap;
    }

    public static m d0(m mVar) {
        String b2 = j5.b(mVar.f10942co, 2);
        return new m.n3().oz(mVar.y).q9(mVar.f10967v).k5(mVar.f10962r).o4(n.fb(b2)).x(b2).en(mVar.f10972z).ud(mVar.f10964t).u(mVar.f10968w).s8(mVar.f10943d).o(mVar.f10945ej).qn(mVar.f10969x).eb(mVar.f10963s).dm(mVar.f10947f).z6();
    }

    public static m n(m mVar, @Nullable m mVar2, boolean z2) {
        String b2;
        Metadata metadata;
        int i;
        String str;
        String str2;
        int i5;
        int i6;
        int i8;
        int i10 = -1;
        if (mVar2 != null) {
            b2 = mVar2.f10942co;
            metadata = mVar2.f10972z;
            i5 = mVar2.f10958oz;
            i = mVar2.f10963s;
            i6 = mVar2.f10947f;
            str = mVar2.f10950fb;
            str2 = mVar2.f10967v;
        } else {
            b2 = j5.b(mVar.f10942co, 1);
            metadata = mVar.f10972z;
            if (z2) {
                i5 = mVar.f10958oz;
                i = mVar.f10963s;
                i6 = mVar.f10947f;
                str = mVar.f10950fb;
                str2 = mVar.f10967v;
            } else {
                i = 0;
                str = null;
                str2 = null;
                i5 = -1;
                i6 = 0;
            }
        }
        String fb2 = n.fb(b2);
        if (z2) {
            i8 = mVar.f10964t;
        } else {
            i8 = -1;
        }
        if (z2) {
            i10 = mVar.f10968w;
        }
        return new m.n3().oz(mVar.y).q9(str2).k5(mVar.f10962r).o4(fb2).x(b2).en(metadata).ud(i8).u(i10).a8(i5).eb(i).dm(i6).k(str).z6();
    }

    public static /* synthetic */ int t(t tVar) {
        int i = tVar.f8700x - 1;
        tVar.f8700x = i;
        return i;
    }

    @Override // lw.t.n3
    public void a() {
        for (p pVar : this.f8689j5) {
            pVar.u();
        }
        this.f8683ej.t(this);
    }

    @Override // af.d0
    public long c5(long j2) {
        p[] pVarArr = this.f8694qn;
        if (pVarArr.length > 0) {
            boolean eb2 = pVarArr[0].eb(j2, false);
            int i = 1;
            while (true) {
                p[] pVarArr2 = this.f8694qn;
                if (i >= pVarArr2.length) {
                    break;
                }
                pVarArr2[i].eb(j2, eb2);
                i++;
            }
            if (eb2) {
                this.f8695r.n3();
            }
        }
        return j2;
    }

    @Override // af.d0
    public void co(d0.y yVar, long j2) {
        this.f8683ej = yVar;
        this.f8698v.y(this);
        i4(j2);
    }

    @Override // af.d0
    public long f(zo.co[] coVarArr, boolean[] zArr, en[] enVarArr, boolean[] zArr2, long j2) {
        boolean z2;
        en enVar;
        int intValue;
        en[] enVarArr2 = enVarArr;
        int[] iArr = new int[coVarArr.length];
        int[] iArr2 = new int[coVarArr.length];
        for (int i = 0; i < coVarArr.length; i++) {
            en enVar2 = enVarArr2[i];
            if (enVar2 == null) {
                intValue = -1;
            } else {
                intValue = this.f8701z.get(enVar2).intValue();
            }
            iArr[i] = intValue;
            iArr2[i] = -1;
            zo.co coVar = coVarArr[i];
            if (coVar != null) {
                rs xc2 = coVar.xc();
                int i5 = 0;
                while (true) {
                    p[] pVarArr = this.f8689j5;
                    if (i5 >= pVarArr.length) {
                        break;
                    } else if (pVarArr[i5].p().zn(xc2) != -1) {
                        iArr2[i] = i5;
                        break;
                    } else {
                        i5++;
                    }
                }
            }
        }
        this.f8701z.clear();
        int length = coVarArr.length;
        en[] enVarArr3 = new en[length];
        en[] enVarArr4 = new en[coVarArr.length];
        zo.co[] coVarArr2 = new zo.co[coVarArr.length];
        p[] pVarArr2 = new p[this.f8689j5.length];
        int i6 = 0;
        int i8 = 0;
        boolean z3 = false;
        while (i8 < this.f8689j5.length) {
            for (int i10 = 0; i10 < coVarArr.length; i10++) {
                zo.co coVar2 = null;
                if (iArr[i10] == i8) {
                    enVar = enVarArr2[i10];
                } else {
                    enVar = null;
                }
                enVarArr4[i10] = enVar;
                if (iArr2[i10] == i8) {
                    coVar2 = coVarArr[i10];
                }
                coVarArr2[i10] = coVar2;
            }
            p pVar = this.f8689j5[i8];
            int i11 = i6;
            int i12 = length;
            int i13 = i8;
            zo.co[] coVarArr3 = coVarArr2;
            p[] pVarArr3 = pVarArr2;
            boolean lc2 = pVar.lc(coVarArr2, zArr, enVarArr4, zArr2, j2, z3);
            int i14 = 0;
            boolean z4 = false;
            while (true) {
                z2 = true;
                if (i14 >= coVarArr.length) {
                    break;
                }
                en enVar3 = enVarArr4[i14];
                if (iArr2[i14] == i13) {
                    v5.y.v(enVar3);
                    enVarArr3[i14] = enVar3;
                    this.f8701z.put(enVar3, Integer.valueOf(i13));
                    z4 = true;
                } else if (iArr[i14] == i13) {
                    if (enVar3 != null) {
                        z2 = false;
                    }
                    v5.y.fb(z2);
                }
                i14++;
            }
            if (z4) {
                pVarArr3[i11] = pVar;
                i6 = i11 + 1;
                if (i11 == 0) {
                    pVar.e(true);
                    if (!lc2) {
                        p[] pVarArr4 = this.f8694qn;
                        if (pVarArr4.length != 0 && pVar == pVarArr4[0]) {
                        }
                    }
                    this.f8695r.n3();
                    z3 = true;
                } else {
                    if (i13 >= this.f8688j) {
                        z2 = false;
                    }
                    pVar.e(z2);
                }
            } else {
                i6 = i11;
            }
            i8 = i13 + 1;
            enVarArr2 = enVarArr;
            pVarArr2 = pVarArr3;
            length = i12;
            coVarArr2 = coVarArr3;
        }
        System.arraycopy(enVarArr3, 0, enVarArr2, 0, length);
        p[] pVarArr5 = (p[]) j5.qj(pVarArr2, i6);
        this.f8694qn = pVarArr5;
        this.f8692oz = this.f8685f3.y(pVarArr5);
        return j2;
    }

    public final p f3(String str, int i, Uri[] uriArr, m[] mVarArr, @Nullable m mVar, @Nullable List<m> list, Map<String, DrmInitData> map, long j2) {
        return new p(str, i, this.f8681d, new a(this.y, this.f8698v, uriArr, mVarArr, this.f8686fb, this.f8696s, this.f8695r, list, this.f8687fh), map, this.f8680co, j2, mVar, this.f8684f, this.f8697t, this.f8699w, this.f8693p, this.f8679c);
    }

    @Override // af.d0, af.jz
    public long fb() {
        return this.f8692oz.fb();
    }

    public void fh() {
        this.f8698v.i9(this);
        for (p pVar : this.f8689j5) {
            pVar.ct();
        }
        this.f8683ej = null;
    }

    @Override // af.d0
    public long gv(long j2, vc vcVar) {
        p[] pVarArr;
        for (p pVar : this.f8694qn) {
            if (pVar.j5()) {
                return pVar.gv(j2, vcVar);
            }
        }
        return j2;
    }

    public final void i4(long j2) {
        Map<String, DrmInitData> emptyMap;
        char c2 = 0;
        int i = 1;
        lw.s sVar = (lw.s) v5.y.v(this.f8698v.v());
        if (this.f8682d0) {
            emptyMap = c(sVar.f10493tl);
        } else {
            emptyMap = Collections.emptyMap();
        }
        Map<String, DrmInitData> map = emptyMap;
        boolean isEmpty = sVar.f10494v.isEmpty();
        List<s.y> list = sVar.f10488fb;
        List<s.y> list2 = sVar.f10491s;
        this.f8700x = 0;
        ArrayList arrayList = new ArrayList();
        List<int[]> arrayList2 = new ArrayList<>();
        if (!isEmpty) {
            x4(sVar, j2, arrayList, arrayList2, map);
        }
        r(j2, list, arrayList, arrayList2, map);
        this.f8688j = arrayList.size();
        int i5 = 0;
        while (i5 < list2.size()) {
            s.y yVar = list2.get(i5);
            String str = "subtitle:" + i5 + ":" + yVar.f10500gv;
            Uri[] uriArr = new Uri[i];
            uriArr[c2] = yVar.y;
            m[] mVarArr = new m[i];
            mVarArr[c2] = yVar.f10501n3;
            ArrayList arrayList3 = arrayList2;
            int i6 = i5;
            p f32 = f3(str, 3, uriArr, mVarArr, null, Collections.emptyList(), map, j2);
            arrayList3.add(new int[]{i6});
            arrayList.add(f32);
            f32.xg(new rs[]{new rs(str, yVar.f10501n3)}, 0, new int[0]);
            i5 = i6 + 1;
            arrayList2 = arrayList3;
            c2 = 0;
            i = 1;
        }
        this.f8689j5 = (p[]) arrayList.toArray(new p[0]);
        this.f8691o = (int[][]) arrayList2.toArray(new int[0]);
        this.f8700x = this.f8689j5.length;
        for (int i8 = 0; i8 < this.f8688j; i8++) {
            this.f8689j5[i8].e(true);
        }
        for (p pVar : this.f8689j5) {
            pVar.n();
        }
        this.f8694qn = this.f8689j5;
    }

    @Override // af.d0
    public long i9() {
        return -9223372036854775807L;
    }

    @Override // af.d0
    public void mt(long j2, boolean z2) {
        for (p pVar : this.f8694qn) {
            pVar.mt(j2, z2);
        }
    }

    @Override // lw.t.n3
    public boolean n3(Uri uri, mg.zn znVar, boolean z2) {
        boolean z3 = true;
        for (p pVar : this.f8689j5) {
            z3 &= pVar.jz(uri, znVar, z2);
        }
        this.f8683ej.t(this);
        return z3;
    }

    @Override // af.d0
    public lc p() {
        return (lc) v5.y.v(this.f8678b);
    }

    public final void r(long j2, List<s.y> list, List<p> list2, List<int[]> list3, Map<String, DrmInitData> map) {
        boolean z2;
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i).f10500gv;
            if (hashSet.add(str)) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z3 = true;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    if (j5.zn(str, list.get(i5).f10500gv)) {
                        s.y yVar = list.get(i5);
                        arrayList3.add(Integer.valueOf(i5));
                        arrayList.add(yVar.y);
                        arrayList2.add(yVar.f10501n3);
                        if (j5.x(yVar.f10501n3.f10942co, 1) == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z3 &= z2;
                    }
                }
                String str2 = "audio:" + str;
                p f32 = f3(str2, 1, (Uri[]) arrayList.toArray((Uri[]) j5.f(new Uri[0])), (m[]) arrayList2.toArray(new m[0]), null, Collections.emptyList(), map, j2);
                list3.add(d1.a.wz(arrayList3));
                list2.add(f32);
                if (this.f8690n && z3) {
                    f32.xg(new rs[]{new rs(str2, (m[]) arrayList2.toArray(new m[0]))}, 0, new int[0]);
                }
            }
        }
    }

    @Override // af.d0, af.jz
    public void s(long j2) {
        this.f8692oz.s(j2);
    }

    @Override // af.d0, af.jz
    public boolean v(long j2) {
        if (this.f8678b == null) {
            for (p pVar : this.f8689j5) {
                pVar.n();
            }
            return false;
        }
        return this.f8692oz.v(j2);
    }

    @Override // af.d0
    public void wz() throws IOException {
        for (p pVar : this.f8689j5) {
            pVar.wz();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x4(lw.s r21, long r22, java.util.List<h4.p> r24, java.util.List<int[]> r25, java.util.Map<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData> r26) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.t.x4(lw.s, long, java.util.List, java.util.List, java.util.Map):void");
    }

    @Override // af.d0, af.jz
    public boolean y() {
        return this.f8692oz.y();
    }

    @Override // af.d0, af.jz
    public long zn() {
        return this.f8692oz.zn();
    }
}

package h4;

import af.rs;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import fj.u0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kx.o;
import kx.p;
import lw.fb;
import m1.m;
import m1.vc;
import v5.j5;
import v5.vl;
import z0.d0;
import z0.x4;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final m[] f8554a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public final List<m> f8555c5;

    /* renamed from: co  reason: collision with root package name */
    public boolean f8556co;

    /* renamed from: f  reason: collision with root package name */
    public final u0 f8557f;

    /* renamed from: fb  reason: collision with root package name */
    public final lw.t f8558fb;

    /* renamed from: gv  reason: collision with root package name */
    public final co f8559gv;

    /* renamed from: n3  reason: collision with root package name */
    public final kx.tl f8562n3;

    /* renamed from: p  reason: collision with root package name */
    public zo.co f8563p;

    /* renamed from: s  reason: collision with root package name */
    public final rs f8564s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f8565t;

    /* renamed from: v  reason: collision with root package name */
    public final Uri[] f8567v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f8568w;
    @Nullable

    /* renamed from: wz  reason: collision with root package name */
    public IOException f8569wz;
    @Nullable

    /* renamed from: xc  reason: collision with root package name */
    public Uri f8570xc;
    public final s y;

    /* renamed from: zn  reason: collision with root package name */
    public final kx.tl f8571zn;

    /* renamed from: i9  reason: collision with root package name */
    public final h4.v f8560i9 = new h4.v(4);

    /* renamed from: tl  reason: collision with root package name */
    public byte[] f8566tl = j5.f14357a;

    /* renamed from: mt  reason: collision with root package name */
    public long f8561mt = -9223372036854775807L;

    /* loaded from: classes.dex */
    public static final class gv extends zo.zn {

        /* renamed from: s  reason: collision with root package name */
        public int f8572s;

        public gv(rs rsVar, int[] iArr) {
            super(rsVar, iArr);
            this.f8572s = wz(rsVar.zn(iArr[0]));
        }

        @Override // zo.co
        @Nullable
        public Object f() {
            return null;
        }

        @Override // zo.co
        public void n3(long j2, long j4, long j6, List<? extends p7.wz> list, p7.xc[] xcVarArr) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (!v(this.f8572s, elapsedRealtime)) {
                return;
            }
            for (int i = this.f15918n3 - 1; i >= 0; i--) {
                if (!v(i, elapsedRealtime)) {
                    this.f8572s = i;
                    return;
                }
            }
            throw new IllegalStateException();
        }

        @Override // zo.co
        public int z() {
            return 0;
        }

        @Override // zo.co
        public int zn() {
            return this.f8572s;
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public boolean f8573n3;
        @Nullable
        public p7.a y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public Uri f8574zn;

        public n3() {
            y();
        }

        public void y() {
            this.y = null;
            this.f8573n3 = false;
            this.f8574zn = null;
        }
    }

    /* loaded from: classes.dex */
    public static final class v {

        /* renamed from: gv  reason: collision with root package name */
        public final boolean f8575gv;

        /* renamed from: n3  reason: collision with root package name */
        public final long f8576n3;
        public final fb.v y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f8577zn;

        public v(fb.v vVar, long j2, int i) {
            boolean z2;
            this.y = vVar;
            this.f8576n3 = j2;
            this.f8577zn = i;
            if ((vVar instanceof fb.n3) && ((fb.n3) vVar).f10415n) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f8575gv = z2;
        }
    }

    /* loaded from: classes.dex */
    public static final class y extends p7.t {

        /* renamed from: t  reason: collision with root package name */
        public byte[] f8578t;

        public y(kx.tl tlVar, kx.p pVar, m mVar, int i, @Nullable Object obj, byte[] bArr) {
            super(tlVar, pVar, 3, mVar, i, obj, bArr);
        }

        @Override // p7.t
        public void a(byte[] bArr, int i) {
            this.f8578t = Arrays.copyOf(bArr, i);
        }

        @Nullable
        public byte[] c5() {
            return this.f8578t;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn extends p7.n3 {

        /* renamed from: a  reason: collision with root package name */
        public final long f8579a;

        /* renamed from: fb  reason: collision with root package name */
        public final String f8580fb;

        /* renamed from: v  reason: collision with root package name */
        public final List<fb.v> f8581v;

        public zn(String str, long j2, List<fb.v> list) {
            super(0L, list.size() - 1);
            this.f8580fb = str;
            this.f8579a = j2;
            this.f8581v = list;
        }

        @Override // p7.xc
        public long n3() {
            zn();
            fb.v vVar = this.f8581v.get((int) gv());
            return this.f8579a + vVar.f10417f + vVar.f10418fb;
        }

        @Override // p7.xc
        public long y() {
            zn();
            return this.f8579a + this.f8581v.get((int) gv()).f10417f;
        }
    }

    public a(s sVar, lw.t tVar, Uri[] uriArr, m[] mVarArr, fb fbVar, @Nullable o oVar, co coVar, @Nullable List<m> list, u0 u0Var) {
        this.y = sVar;
        this.f8558fb = tVar;
        this.f8567v = uriArr;
        this.f8554a = mVarArr;
        this.f8559gv = coVar;
        this.f8555c5 = list;
        this.f8557f = u0Var;
        kx.tl y2 = fbVar.y(1);
        this.f8562n3 = y2;
        if (oVar != null) {
            y2.i9(oVar);
        }
        this.f8571zn = fbVar.y(3);
        this.f8564s = new rs(mVarArr);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < uriArr.length; i++) {
            if ((mVarArr[i].f10947f & 16384) == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        this.f8563p = new gv(this.f8564s, d1.a.wz(arrayList));
    }

    public static List<fb.v> c5(lw.fb fbVar, long j2, int i) {
        int i5 = (int) (j2 - fbVar.f10392f);
        if (i5 >= 0 && fbVar.f10396mt.size() >= i5) {
            ArrayList arrayList = new ArrayList();
            int i6 = 0;
            if (i5 < fbVar.f10396mt.size()) {
                if (i != -1) {
                    fb.gv gvVar = fbVar.f10396mt.get(i5);
                    if (i == 0) {
                        arrayList.add(gvVar);
                    } else if (i < gvVar.f10413n.size()) {
                        List<fb.n3> list = gvVar.f10413n;
                        arrayList.addAll(list.subList(i, list.size()));
                    }
                    i5++;
                }
                List<fb.gv> list2 = fbVar.f10396mt;
                arrayList.addAll(list2.subList(i5, list2.size()));
                i = 0;
            }
            if (fbVar.f10404wz != -9223372036854775807L) {
                if (i != -1) {
                    i6 = i;
                }
                if (i6 < fbVar.f10391co.size()) {
                    List<fb.n3> list3 = fbVar.f10391co;
                    arrayList.addAll(list3.subList(i6, list3.size()));
                }
            }
            return Collections.unmodifiableList(arrayList);
        }
        return x4.j5();
    }

    @Nullable
    public static v fb(lw.fb fbVar, long j2, int i) {
        int i5 = (int) (j2 - fbVar.f10392f);
        if (i5 == fbVar.f10396mt.size()) {
            if (i == -1) {
                i = 0;
            }
            if (i >= fbVar.f10391co.size()) {
                return null;
            }
            return new v(fbVar.f10391co.get(i), j2, i);
        }
        fb.gv gvVar = fbVar.f10396mt.get(i5);
        if (i == -1) {
            return new v(gvVar, j2, -1);
        }
        if (i < gvVar.f10413n.size()) {
            return new v(gvVar.f10413n.get(i), j2, i);
        }
        int i6 = i5 + 1;
        if (i6 < fbVar.f10396mt.size()) {
            return new v(fbVar.f10396mt.get(i6), j2 + 1, -1);
        }
        if (fbVar.f10391co.isEmpty()) {
            return null;
        }
        return new v(fbVar.f10391co.get(0), j2 + 1, 0);
    }

    @Nullable
    public static Uri gv(lw.fb fbVar, @Nullable fb.v vVar) {
        String str;
        if (vVar != null && (str = vVar.f10424w) != null) {
            return vl.v(fbVar.y, str);
        }
        return null;
    }

    public final Pair<Long, Integer> a(@Nullable i9 i9Var, boolean z2, lw.fb fbVar, long j2, long j4) {
        boolean z3;
        List<fb.n3> list;
        long j6;
        long j7;
        int i = -1;
        if (i9Var != null && !z2) {
            if (i9Var.fb()) {
                if (i9Var.f8613xc == -1) {
                    j7 = i9Var.a();
                } else {
                    j7 = i9Var.f12511i9;
                }
                Long valueOf = Long.valueOf(j7);
                int i5 = i9Var.f8613xc;
                if (i5 != -1) {
                    i = i5 + 1;
                }
                return new Pair<>(valueOf, Integer.valueOf(i));
            }
            return new Pair<>(Long.valueOf(i9Var.f12511i9), Integer.valueOf(i9Var.f8613xc));
        }
        long j8 = fbVar.f10398r + j2;
        if (i9Var != null && !this.f8568w) {
            j4 = i9Var.f12443fb;
        }
        if (!fbVar.f10406xc && j4 >= j8) {
            return new Pair<>(Long.valueOf(fbVar.f10392f + fbVar.f10396mt.size()), -1);
        }
        long j9 = j4 - j2;
        List<fb.gv> list2 = fbVar.f10396mt;
        Long valueOf2 = Long.valueOf(j9);
        int i6 = 0;
        if (this.f8558fb.isLive() && i9Var != null) {
            z3 = false;
        } else {
            z3 = true;
        }
        int a2 = j5.a(list2, valueOf2, true, z3);
        long j10 = a2 + fbVar.f10392f;
        if (a2 >= 0) {
            fb.gv gvVar = fbVar.f10396mt.get(a2);
            if (j9 < gvVar.f10417f + gvVar.f10418fb) {
                list = gvVar.f10413n;
            } else {
                list = fbVar.f10391co;
            }
            while (true) {
                if (i6 >= list.size()) {
                    break;
                }
                fb.n3 n3Var = list.get(i6);
                if (j9 < n3Var.f10417f + n3Var.f10418fb) {
                    if (n3Var.f10414f3) {
                        if (list == fbVar.f10391co) {
                            j6 = 1;
                        } else {
                            j6 = 0;
                        }
                        j10 += j6;
                        i = i6;
                    }
                } else {
                    i6++;
                }
            }
        }
        return new Pair<>(Long.valueOf(j10), Integer.valueOf(i));
    }

    public final long co(long j2) {
        long j4 = this.f8561mt;
        if (j4 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j4 - j2;
    }

    public zo.co f() {
        return this.f8563p;
    }

    public final void i4(lw.fb fbVar) {
        long v2;
        if (fbVar.f10406xc) {
            v2 = -9223372036854775807L;
        } else {
            v2 = fbVar.v() - this.f8558fb.gv();
        }
        this.f8561mt = v2;
    }

    public rs i9() {
        return this.f8564s;
    }

    public void mt() {
        this.f8569wz = null;
    }

    public long n3(long j2, vc vcVar) {
        lw.fb fbVar;
        long j4;
        int zn2 = this.f8563p.zn();
        Uri[] uriArr = this.f8567v;
        if (zn2 < uriArr.length && zn2 != -1) {
            fbVar = this.f8558fb.f(uriArr[this.f8563p.mt()], true);
        } else {
            fbVar = null;
        }
        if (fbVar != null && !fbVar.f10396mt.isEmpty() && fbVar.f10388zn) {
            long gv2 = fbVar.f10399s - this.f8558fb.gv();
            long j6 = j2 - gv2;
            int a2 = j5.a(fbVar.f10396mt, Long.valueOf(j6), true, true);
            long j7 = fbVar.f10396mt.get(a2).f10417f;
            if (a2 != fbVar.f10396mt.size() - 1) {
                j4 = fbVar.f10396mt.get(a2 + 1).f10417f;
            } else {
                j4 = j7;
            }
            return vcVar.y(j6, j7, j4) + gv2;
        }
        return j2;
    }

    public boolean p(Uri uri, long j2) {
        int tl2;
        int i = 0;
        while (true) {
            Uri[] uriArr = this.f8567v;
            if (i < uriArr.length) {
                if (uriArr[i].equals(uri)) {
                    break;
                }
                i++;
            } else {
                i = -1;
                break;
            }
        }
        if (i == -1 || (tl2 = this.f8563p.tl(i)) == -1) {
            return true;
        }
        this.f8556co |= uri.equals(this.f8570xc);
        if (j2 != -9223372036854775807L && (!this.f8563p.gv(tl2, j2) || !this.f8558fb.s(uri, j2))) {
            return false;
        }
        return true;
    }

    public void r(zo.co coVar) {
        this.f8563p = coVar;
    }

    public int s(long j2, List<? extends p7.wz> list) {
        if (this.f8569wz == null && this.f8563p.length() >= 2) {
            return this.f8563p.p(j2, list);
        }
        return list.size();
    }

    @Nullable
    public final p7.a t(@Nullable Uri uri, int i) {
        if (uri == null) {
            return null;
        }
        byte[] zn2 = this.f8560i9.zn(uri);
        if (zn2 != null) {
            this.f8560i9.n3(uri, zn2);
            return null;
        }
        return new y(this.f8571zn, new p.n3().c5(uri).n3(1).y(), this.f8554a[i], this.f8563p.z(), this.f8563p.f(), this.f8566tl);
    }

    public boolean tl(p7.a aVar, long j2) {
        zo.co coVar = this.f8563p;
        return coVar.gv(coVar.tl(this.f8564s.gv(aVar.f12444gv)), j2);
    }

    public void v(long j2, long j4, List<i9> list, boolean z2, n3 n3Var) {
        lw.fb fbVar;
        long j6;
        Uri uri;
        int i;
        i9 i9Var = list.isEmpty() ? null : (i9) d0.v(list);
        int gv2 = i9Var == null ? -1 : this.f8564s.gv(i9Var.f12444gv);
        long j7 = j4 - j2;
        long co2 = co(j2);
        if (i9Var != null && !this.f8568w) {
            long zn2 = i9Var.zn();
            j7 = Math.max(0L, j7 - zn2);
            if (co2 != -9223372036854775807L) {
                co2 = Math.max(0L, co2 - zn2);
            }
        }
        this.f8563p.n3(j2, j7, co2, list, y(i9Var, j4));
        int mt2 = this.f8563p.mt();
        boolean z3 = gv2 != mt2;
        Uri uri2 = this.f8567v[mt2];
        if (!this.f8558fb.fb(uri2)) {
            n3Var.f8574zn = uri2;
            this.f8556co &= uri2.equals(this.f8570xc);
            this.f8570xc = uri2;
            return;
        }
        lw.fb f4 = this.f8558fb.f(uri2, true);
        v5.y.v(f4);
        this.f8568w = f4.f10388zn;
        i4(f4);
        long gv3 = f4.f10399s - this.f8558fb.gv();
        Pair<Long, Integer> a2 = a(i9Var, z3, f4, gv3, j4);
        long longValue = ((Long) a2.first).longValue();
        int intValue = ((Integer) a2.second).intValue();
        if (longValue >= f4.f10392f || i9Var == null || !z3) {
            fbVar = f4;
            j6 = gv3;
            uri = uri2;
            i = mt2;
        } else {
            Uri uri3 = this.f8567v[gv2];
            lw.fb f6 = this.f8558fb.f(uri3, true);
            v5.y.v(f6);
            j6 = f6.f10399s - this.f8558fb.gv();
            Pair<Long, Integer> a3 = a(i9Var, false, f6, j6, j4);
            longValue = ((Long) a3.first).longValue();
            intValue = ((Integer) a3.second).intValue();
            i = gv2;
            uri = uri3;
            fbVar = f6;
        }
        if (longValue < fbVar.f10392f) {
            this.f8569wz = new af.n3();
            return;
        }
        v fb2 = fb(fbVar, longValue, intValue);
        if (fb2 == null) {
            if (!fbVar.f10406xc) {
                n3Var.f8574zn = uri;
                this.f8556co &= uri.equals(this.f8570xc);
                this.f8570xc = uri;
                return;
            } else if (!z2 && !fbVar.f10396mt.isEmpty()) {
                fb2 = new v((fb.v) d0.v(fbVar.f10396mt), (fbVar.f10392f + fbVar.f10396mt.size()) - 1, -1);
            } else {
                n3Var.f8573n3 = true;
                return;
            }
        }
        this.f8556co = false;
        this.f8570xc = null;
        Uri gv4 = gv(fbVar, fb2.y.f10423v);
        p7.a t2 = t(gv4, i);
        n3Var.y = t2;
        if (t2 != null) {
            return;
        }
        Uri gv5 = gv(fbVar, fb2.y);
        p7.a t3 = t(gv5, i);
        n3Var.y = t3;
        if (t3 != null) {
            return;
        }
        boolean x42 = i9.x4(i9Var, uri, fbVar, fb2, j6);
        if (x42 && fb2.f8575gv) {
            return;
        }
        n3Var.y = i9.c5(this.y, this.f8562n3, this.f8554a[i], j6, fbVar, fb2, uri, this.f8555c5, this.f8563p.z(), this.f8563p.f(), this.f8565t, this.f8559gv, i9Var, this.f8560i9.y(gv5), this.f8560i9.y(gv4), x42, this.f8557f);
    }

    public void w(p7.a aVar) {
        if (aVar instanceof y) {
            y yVar = (y) aVar;
            this.f8566tl = yVar.fb();
            this.f8560i9.n3(yVar.f12445n3.y, (byte[]) v5.y.v(yVar.c5()));
        }
    }

    public void wz() throws IOException {
        IOException iOException = this.f8569wz;
        if (iOException == null) {
            Uri uri = this.f8570xc;
            if (uri != null && this.f8556co) {
                this.f8558fb.n3(uri);
                return;
            }
            return;
        }
        throw iOException;
    }

    public boolean x4(long j2, p7.a aVar, List<? extends p7.wz> list) {
        if (this.f8569wz != null) {
            return false;
        }
        return this.f8563p.c5(j2, aVar, list);
    }

    public boolean xc(Uri uri) {
        return j5.co(this.f8567v, uri);
    }

    public p7.xc[] y(@Nullable i9 i9Var, long j2) {
        int gv2;
        boolean z2;
        int i;
        if (i9Var == null) {
            gv2 = -1;
        } else {
            gv2 = this.f8564s.gv(i9Var.f12444gv);
        }
        int length = this.f8563p.length();
        p7.xc[] xcVarArr = new p7.xc[length];
        boolean z3 = false;
        int i5 = 0;
        while (i5 < length) {
            int s2 = this.f8563p.s(i5);
            Uri uri = this.f8567v[s2];
            if (!this.f8558fb.fb(uri)) {
                xcVarArr[i5] = p7.xc.y;
                i = i5;
            } else {
                lw.fb f4 = this.f8558fb.f(uri, z3);
                v5.y.v(f4);
                long gv3 = f4.f10399s - this.f8558fb.gv();
                if (s2 != gv2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                i = i5;
                Pair<Long, Integer> a2 = a(i9Var, z2, f4, gv3, j2);
                xcVarArr[i] = new zn(f4.y, gv3, c5(f4, ((Long) a2.first).longValue(), ((Integer) a2.second).intValue()));
            }
            i5 = i + 1;
            z3 = false;
        }
        return xcVarArr;
    }

    public void z(boolean z2) {
        this.f8565t = z2;
    }

    public int zn(i9 i9Var) {
        List<fb.n3> list;
        if (i9Var.f8613xc == -1) {
            return 1;
        }
        lw.fb fbVar = (lw.fb) v5.y.v(this.f8558fb.f(this.f8567v[this.f8564s.gv(i9Var.f12444gv)], false));
        int i = (int) (i9Var.f12511i9 - fbVar.f10392f);
        if (i < 0) {
            return 1;
        }
        if (i < fbVar.f10396mt.size()) {
            list = fbVar.f10396mt.get(i).f10413n;
        } else {
            list = fbVar.f10391co;
        }
        if (i9Var.f8613xc >= list.size()) {
            return 2;
        }
        fb.n3 n3Var = list.get(i9Var.f8613xc);
        if (n3Var.f10415n) {
            return 0;
        }
        if (j5.zn(Uri.parse(vl.gv(fbVar.y, n3Var.y)), i9Var.f12445n3.y)) {
            return 1;
        }
        return 2;
    }
}

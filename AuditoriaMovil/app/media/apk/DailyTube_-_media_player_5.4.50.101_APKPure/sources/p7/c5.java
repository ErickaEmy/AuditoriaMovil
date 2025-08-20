package p7;

import af.b;
import af.en;
import af.f7;
import af.i4;
import af.jz;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kx.mg;
import kx.ta;
import m1.g;
import m1.m;
import m1.vc;
import p7.i9;
import v5.j5;
/* loaded from: classes.dex */
public class c5<T extends i9> implements en, jz, ta.n3<a>, ta.a {

    /* renamed from: b  reason: collision with root package name */
    public long f12449b;

    /* renamed from: c  reason: collision with root package name */
    public final f7[] f12450c;

    /* renamed from: co  reason: collision with root package name */
    public final ta f12451co;

    /* renamed from: d  reason: collision with root package name */
    public m f12452d;

    /* renamed from: d0  reason: collision with root package name */
    public final zn f12453d0;
    @Nullable

    /* renamed from: ej  reason: collision with root package name */
    public n3<T> f12454ej;

    /* renamed from: f  reason: collision with root package name */
    public final T f12455f;

    /* renamed from: f3  reason: collision with root package name */
    public final List<p7.y> f12456f3;

    /* renamed from: fb  reason: collision with root package name */
    public final m[] f12457fb;
    @Nullable

    /* renamed from: fh  reason: collision with root package name */
    public a f12458fh;

    /* renamed from: j5  reason: collision with root package name */
    public int f12459j5;

    /* renamed from: n  reason: collision with root package name */
    public final f7 f12460n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f12461o;

    /* renamed from: p  reason: collision with root package name */
    public final mg f12462p;
    @Nullable

    /* renamed from: qn  reason: collision with root package name */
    public p7.y f12463qn;

    /* renamed from: r  reason: collision with root package name */
    public final ArrayList<p7.y> f12464r;

    /* renamed from: s  reason: collision with root package name */
    public final boolean[] f12465s;

    /* renamed from: t  reason: collision with root package name */
    public final jz.y<c5<T>> f12466t;

    /* renamed from: v  reason: collision with root package name */
    public final int[] f12467v;

    /* renamed from: w  reason: collision with root package name */
    public final b.y f12468w;

    /* renamed from: x  reason: collision with root package name */
    public long f12469x;
    public final int y;

    /* renamed from: z  reason: collision with root package name */
    public final s f12470z;

    /* loaded from: classes.dex */
    public interface n3<T extends i9> {
        void a(c5<T> c5Var);
    }

    public c5(int i, @Nullable int[] iArr, @Nullable m[] mVarArr, T t2, jz.y<c5<T>> yVar, kx.n3 n3Var, long j2, com.google.android.exoplayer2.drm.a aVar, v.y yVar2, mg mgVar, b.y yVar3) {
        this.y = i;
        int i5 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.f12467v = iArr;
        this.f12457fb = mVarArr == null ? new m[0] : mVarArr;
        this.f12455f = t2;
        this.f12466t = yVar;
        this.f12468w = yVar3;
        this.f12462p = mgVar;
        this.f12451co = new ta("ChunkSampleStream");
        this.f12470z = new s();
        ArrayList<p7.y> arrayList = new ArrayList<>();
        this.f12464r = arrayList;
        this.f12456f3 = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.f12450c = new f7[length];
        this.f12465s = new boolean[length];
        int i6 = length + 1;
        int[] iArr2 = new int[i6];
        f7[] f7VarArr = new f7[i6];
        f7 f4 = f7.f(n3Var, aVar, yVar2);
        this.f12460n = f4;
        iArr2[0] = i;
        f7VarArr[0] = f4;
        while (i5 < length) {
            f7 t3 = f7.t(n3Var);
            this.f12450c[i5] = t3;
            int i8 = i5 + 1;
            f7VarArr[i8] = t3;
            iArr2[i8] = this.f12467v[i5];
            i5 = i8;
        }
        this.f12453d0 = new zn(iArr2, f7VarArr);
        this.f12469x = j2;
        this.f12449b = j2;
    }

    @Override // af.en
    public int a(g gVar, a9.fb fbVar, int i) {
        if (d()) {
            return -3;
        }
        p7.y yVar = this.f12463qn;
        if (yVar != null && yVar.s(0) <= this.f12460n.rz()) {
            return -3;
        }
        z6();
        return this.f12460n.o(gVar, fbVar, i, this.f12461o);
    }

    @Override // kx.ta.n3
    /* renamed from: a8 */
    public void ud(a aVar, long j2, long j4, boolean z2) {
        this.f12458fh = null;
        this.f12463qn = null;
        i4 i4Var = new i4(aVar.y, aVar.f12445n3, aVar.v(), aVar.gv(), j2, j4, aVar.y());
        this.f12462p.zn(aVar.y);
        this.f12468w.mt(i4Var, aVar.f12448zn, this.y, aVar.f12444gv, aVar.f12447v, aVar.f12441a, aVar.f12443fb, aVar.f12446s);
        if (!z2) {
            if (d()) {
                hw();
            } else if (mg(aVar)) {
                c(this.f12464r.size() - 1);
                if (this.f12464r.isEmpty()) {
                    this.f12469x = this.f12449b;
                }
            }
            this.f12466t.t(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ef  */
    @Override // kx.ta.n3
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public kx.ta.zn oz(p7.a r31, long r32, long r34, java.io.IOException r36, int r37) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p7.c5.oz(p7.a, long, long, java.io.IOException, int):kx.ta$zn");
    }

    public final p7.y c(int i) {
        p7.y yVar = this.f12464r.get(i);
        ArrayList<p7.y> arrayList = this.f12464r;
        j5.w2(arrayList, i, arrayList.size());
        this.f12459j5 = Math.max(this.f12459j5, this.f12464r.size());
        int i5 = 0;
        this.f12460n.r(yVar.s(0));
        while (true) {
            f7[] f7VarArr = this.f12450c;
            if (i5 < f7VarArr.length) {
                f7 f7Var = f7VarArr[i5];
                i5++;
                f7Var.r(yVar.s(i5));
            } else {
                return yVar;
            }
        }
    }

    public boolean d() {
        if (this.f12469x != -9223372036854775807L) {
            return true;
        }
        return false;
    }

    public T d0() {
        return this.f12455f;
    }

    public final void ej(int i) {
        p7.y yVar = this.f12464r.get(i);
        m mVar = yVar.f12444gv;
        if (!mVar.equals(this.f12452d)) {
            this.f12468w.c5(this.y, mVar, yVar.f12447v, yVar.f12441a, yVar.f12443fb);
        }
        this.f12452d = mVar;
    }

    public final void f3(int i) {
        int min = Math.min(k5(i, 0), this.f12459j5);
        if (min > 0) {
            j5.w2(this.f12464r, 0, min);
            this.f12459j5 -= min;
        }
    }

    @Override // af.jz
    public long fb() {
        if (this.f12461o) {
            return Long.MIN_VALUE;
        }
        if (d()) {
            return this.f12469x;
        }
        long j2 = this.f12449b;
        p7.y fh2 = fh();
        if (!fh2.fb()) {
            if (this.f12464r.size() > 1) {
                ArrayList<p7.y> arrayList = this.f12464r;
                fh2 = arrayList.get(arrayList.size() - 2);
            } else {
                fh2 = null;
            }
        }
        if (fh2 != null) {
            j2 = Math.max(j2, fh2.f12446s);
        }
        return Math.max(j2, this.f12460n.c());
    }

    public final p7.y fh() {
        ArrayList<p7.y> arrayList = this.f12464r;
        return arrayList.get(arrayList.size() - 1);
    }

    public long gv(long j2, vc vcVar) {
        return this.f12455f.gv(j2, vcVar);
    }

    public final void hw() {
        this.f12460n.ut();
        for (f7 f7Var : this.f12450c) {
            f7Var.ut();
        }
    }

    @Override // af.en
    public boolean isReady() {
        if (!d() && this.f12460n.x(this.f12461o)) {
            return true;
        }
        return false;
    }

    public void j5(long j2) {
        p7.y yVar;
        boolean z2;
        boolean en2;
        this.f12449b = j2;
        if (d()) {
            this.f12469x = j2;
            return;
        }
        int i = 0;
        for (int i5 = 0; i5 < this.f12464r.size(); i5++) {
            yVar = this.f12464r.get(i5);
            int i6 = (yVar.f12443fb > j2 ? 1 : (yVar.f12443fb == j2 ? 0 : -1));
            if (i6 == 0 && yVar.f12512f == -9223372036854775807L) {
                break;
            } else if (i6 > 0) {
                break;
            }
        }
        yVar = null;
        if (yVar != null) {
            en2 = this.f12460n.f7(yVar.s(0));
        } else {
            f7 f7Var = this.f12460n;
            if (j2 < zn()) {
                z2 = true;
            } else {
                z2 = false;
            }
            en2 = f7Var.en(j2, z2);
        }
        if (en2) {
            this.f12459j5 = k5(this.f12460n.rz(), 0);
            f7[] f7VarArr = this.f12450c;
            int length = f7VarArr.length;
            while (i < length) {
                f7VarArr[i].en(j2, true);
                i++;
            }
            return;
        }
        this.f12469x = j2;
        this.f12461o = false;
        this.f12464r.clear();
        this.f12459j5 = 0;
        if (this.f12451co.i9()) {
            this.f12460n.mt();
            f7[] f7VarArr2 = this.f12450c;
            int length2 = f7VarArr2.length;
            while (i < length2) {
                f7VarArr2[i].mt();
                i++;
            }
            this.f12451co.a();
            return;
        }
        this.f12451co.fb();
        hw();
    }

    public final int k5(int i, int i5) {
        do {
            i5++;
            if (i5 >= this.f12464r.size()) {
                return this.f12464r.size() - 1;
            }
        } while (this.f12464r.get(i5).s(0) <= i);
        return i5 - 1;
    }

    public final boolean mg(a aVar) {
        return aVar instanceof p7.y;
    }

    public void mt(long j2, boolean z2) {
        if (d()) {
            return;
        }
        int f32 = this.f12460n.f3();
        this.f12460n.p(j2, z2, true);
        int f33 = this.f12460n.f3();
        if (f33 > f32) {
            long n2 = this.f12460n.n();
            int i = 0;
            while (true) {
                f7[] f7VarArr = this.f12450c;
                if (i >= f7VarArr.length) {
                    break;
                }
                f7VarArr[i].p(n2, z2, this.f12465s[i]);
                i++;
            }
        }
        f3(f33);
    }

    public final void n(int i) {
        v5.y.fb(!this.f12451co.i9());
        int size = this.f12464r.size();
        while (true) {
            if (i < size) {
                if (!rz(i)) {
                    break;
                }
                i++;
            } else {
                i = -1;
                break;
            }
        }
        if (i == -1) {
            return;
        }
        long j2 = fh().f12446s;
        p7.y c2 = c(i);
        if (this.f12464r.isEmpty()) {
            this.f12469x = this.f12449b;
        }
        this.f12461o = false;
        this.f12468w.mg(this.y, c2.f12443fb, j2);
    }

    @Override // af.en
    public void n3() throws IOException {
        this.f12451co.n3();
        this.f12460n.yt();
        if (!this.f12451co.i9()) {
            this.f12455f.n3();
        }
    }

    public c5<T>.y qn(long j2, int i) {
        for (int i5 = 0; i5 < this.f12450c.length; i5++) {
            if (this.f12467v[i5] == i) {
                v5.y.fb(!this.f12465s[i5]);
                this.f12465s[i5] = true;
                this.f12450c[i5].en(j2, true);
                return new y(this, this.f12450c[i5], i5);
            }
        }
        throw new IllegalStateException();
    }

    public final boolean rz(int i) {
        int rz2;
        p7.y yVar = this.f12464r.get(i);
        if (this.f12460n.rz() > yVar.s(0)) {
            return true;
        }
        int i5 = 0;
        do {
            f7[] f7VarArr = this.f12450c;
            if (i5 >= f7VarArr.length) {
                return false;
            }
            rz2 = f7VarArr[i5].rz();
            i5++;
        } while (rz2 <= yVar.s(i5));
        return true;
    }

    @Override // af.jz
    public void s(long j2) {
        if (!this.f12451co.c5() && !d()) {
            if (this.f12451co.i9()) {
                a aVar = (a) v5.y.v(this.f12458fh);
                if ((!mg(aVar) || !rz(this.f12464r.size() - 1)) && this.f12455f.s(j2, aVar, this.f12456f3)) {
                    this.f12451co.a();
                    if (mg(aVar)) {
                        this.f12463qn = (p7.y) aVar;
                        return;
                    }
                    return;
                }
                return;
            }
            int c52 = this.f12455f.c5(j2, this.f12456f3);
            if (c52 < this.f12464r.size()) {
                n(c52);
            }
        }
    }

    @Override // af.en
    public int t(long j2) {
        if (d()) {
            return 0;
        }
        int ta2 = this.f12460n.ta(j2, this.f12461o);
        p7.y yVar = this.f12463qn;
        if (yVar != null) {
            ta2 = Math.min(ta2, yVar.s(0) - this.f12460n.rz());
        }
        this.f12460n.dm(ta2);
        z6();
        return ta2;
    }

    @Override // kx.ta.a
    public void tl() {
        this.f12460n.j();
        for (f7 f7Var : this.f12450c) {
            f7Var.j();
        }
        this.f12455f.release();
        n3<T> n3Var = this.f12454ej;
        if (n3Var != null) {
            n3Var.a(this);
        }
    }

    @Override // af.jz
    public boolean v(long j2) {
        List<p7.y> list;
        long j4;
        if (this.f12461o || this.f12451co.i9() || this.f12451co.c5()) {
            return false;
        }
        boolean d2 = d();
        if (d2) {
            list = Collections.emptyList();
            j4 = this.f12469x;
        } else {
            list = this.f12456f3;
            j4 = fh().f12446s;
        }
        this.f12455f.i9(j2, j4, list, this.f12470z);
        s sVar = this.f12470z;
        boolean z2 = sVar.f12484n3;
        a aVar = sVar.y;
        sVar.y();
        if (z2) {
            this.f12469x = -9223372036854775807L;
            this.f12461o = true;
            return true;
        } else if (aVar == null) {
            return false;
        } else {
            this.f12458fh = aVar;
            if (mg(aVar)) {
                p7.y yVar = (p7.y) aVar;
                if (d2) {
                    long j6 = yVar.f12443fb;
                    long j7 = this.f12469x;
                    if (j6 != j7) {
                        this.f12460n.u(j7);
                        for (f7 f7Var : this.f12450c) {
                            f7Var.u(this.f12469x);
                        }
                    }
                    this.f12469x = -9223372036854775807L;
                }
                yVar.i9(this.f12453d0);
                this.f12464r.add(yVar);
            } else if (aVar instanceof tl) {
                ((tl) aVar).a(this.f12453d0);
            }
            this.f12468w.d0(new i4(aVar.y, aVar.f12445n3, this.f12451co.wz(aVar, this, this.f12462p.y(aVar.f12448zn))), aVar.f12448zn, this.y, aVar.f12444gv, aVar.f12447v, aVar.f12441a, aVar.f12443fb, aVar.f12446s);
            return true;
        }
    }

    public void vl(@Nullable n3<T> n3Var) {
        this.f12454ej = n3Var;
        this.f12460n.qn();
        for (f7 f7Var : this.f12450c) {
            f7Var.qn();
        }
        this.f12451co.tl(this);
    }

    @Override // kx.ta.n3
    /* renamed from: x */
    public void ta(a aVar, long j2, long j4) {
        this.f12458fh = null;
        this.f12455f.v(aVar);
        i4 i4Var = new i4(aVar.y, aVar.f12445n3, aVar.v(), aVar.gv(), j2, j4, aVar.y());
        this.f12462p.zn(aVar.y);
        this.f12468w.r(i4Var, aVar.f12448zn, this.y, aVar.f12444gv, aVar.f12447v, aVar.f12441a, aVar.f12443fb, aVar.f12446s);
        this.f12466t.t(this);
    }

    @Override // af.jz
    public boolean y() {
        return this.f12451co.i9();
    }

    public void yt() {
        vl(null);
    }

    public final void z6() {
        int k52 = k5(this.f12460n.rz(), this.f12459j5 - 1);
        while (true) {
            int i = this.f12459j5;
            if (i <= k52) {
                this.f12459j5 = i + 1;
                ej(i);
            } else {
                return;
            }
        }
    }

    @Override // af.jz
    public long zn() {
        if (d()) {
            return this.f12469x;
        }
        if (this.f12461o) {
            return Long.MIN_VALUE;
        }
        return fh().f12446s;
    }

    /* loaded from: classes.dex */
    public final class y implements en {

        /* renamed from: fb  reason: collision with root package name */
        public final int f12472fb;

        /* renamed from: s  reason: collision with root package name */
        public boolean f12473s;

        /* renamed from: v  reason: collision with root package name */
        public final f7 f12474v;
        public final c5<T> y;

        public y(c5<T> c5Var, f7 f7Var, int i) {
            this.y = c5Var;
            this.f12474v = f7Var;
            this.f12472fb = i;
        }

        private void y() {
            if (!this.f12473s) {
                c5.this.f12468w.c5(c5.this.f12467v[this.f12472fb], c5.this.f12457fb[this.f12472fb], 0, null, c5.this.f12449b);
                this.f12473s = true;
            }
        }

        @Override // af.en
        public int a(g gVar, a9.fb fbVar, int i) {
            if (c5.this.d()) {
                return -3;
            }
            if (c5.this.f12463qn != null && c5.this.f12463qn.s(this.f12472fb + 1) <= this.f12474v.rz()) {
                return -3;
            }
            y();
            return this.f12474v.o(gVar, fbVar, i, c5.this.f12461o);
        }

        @Override // af.en
        public boolean isReady() {
            if (!c5.this.d() && this.f12474v.x(c5.this.f12461o)) {
                return true;
            }
            return false;
        }

        @Override // af.en
        public int t(long j2) {
            if (c5.this.d()) {
                return 0;
            }
            int ta2 = this.f12474v.ta(j2, c5.this.f12461o);
            if (c5.this.f12463qn != null) {
                ta2 = Math.min(ta2, c5.this.f12463qn.s(this.f12472fb + 1) - this.f12474v.rz());
            }
            this.f12474v.dm(ta2);
            if (ta2 > 0) {
                y();
            }
            return ta2;
        }

        public void zn() {
            v5.y.fb(c5.this.f12465s[this.f12472fb]);
            c5.this.f12465s[this.f12472fb] = false;
        }

        @Override // af.en
        public void n3() {
        }
    }
}

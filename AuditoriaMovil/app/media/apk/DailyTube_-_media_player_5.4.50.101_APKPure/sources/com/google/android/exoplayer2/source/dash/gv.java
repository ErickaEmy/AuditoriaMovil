package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.dash.v;
import com.google.android.exoplayer2.source.dash.y;
import dq.t;
import fj.u0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kx.d;
import kx.d0;
import kx.mg;
import kx.o;
import kx.tl;
import m1.m;
import m1.vc;
import p7.a;
import p7.f;
import p7.fb;
import p7.w;
import p7.wz;
import p7.xc;
import v5.j5;
import zo.co;
import zr.c5;
import zr.i9;
import zr.s;
/* loaded from: classes.dex */
public class gv implements com.google.android.exoplayer2.source.dash.y {

    /* renamed from: a  reason: collision with root package name */
    public final long f4388a;

    /* renamed from: c5  reason: collision with root package name */
    public final n3[] f4389c5;

    /* renamed from: f  reason: collision with root package name */
    public dq.zn f4390f;

    /* renamed from: fb  reason: collision with root package name */
    public final int f4391fb;

    /* renamed from: gv  reason: collision with root package name */
    public final int f4392gv;

    /* renamed from: i9  reason: collision with root package name */
    public co f4393i9;

    /* renamed from: n3  reason: collision with root package name */
    public final zr.n3 f4394n3;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public final v.zn f4395s;

    /* renamed from: t  reason: collision with root package name */
    public int f4396t;
    @Nullable

    /* renamed from: tl  reason: collision with root package name */
    public IOException f4397tl;

    /* renamed from: v  reason: collision with root package name */
    public final tl f4398v;

    /* renamed from: wz  reason: collision with root package name */
    public boolean f4399wz;
    public final d y;

    /* renamed from: zn  reason: collision with root package name */
    public final int[] f4400zn;

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: a  reason: collision with root package name */
        public final long f4401a;
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public final s f4402gv;

        /* renamed from: n3  reason: collision with root package name */
        public final dq.tl f4403n3;

        /* renamed from: v  reason: collision with root package name */
        public final long f4404v;
        @Nullable
        public final fb y;

        /* renamed from: zn  reason: collision with root package name */
        public final dq.n3 f4405zn;

        public n3(long j2, dq.tl tlVar, dq.n3 n3Var, @Nullable fb fbVar, long j4, @Nullable s sVar) {
            this.f4404v = j2;
            this.f4403n3 = tlVar;
            this.f4405zn = n3Var;
            this.f4401a = j4;
            this.y = fbVar;
            this.f4402gv = sVar;
        }

        public long a() {
            return this.f4402gv.c5() + this.f4401a;
        }

        public long c5(long j2) {
            return f(j2) + this.f4402gv.y(j2 - this.f4401a, this.f4404v);
        }

        public long f(long j2) {
            return this.f4402gv.n3(j2 - this.f4401a);
        }

        public long fb(long j2) {
            return (v(j2) + this.f4402gv.i9(this.f4404v, j2)) - 1;
        }

        @CheckResult
        public n3 gv(dq.n3 n3Var) {
            return new n3(this.f4404v, this.f4403n3, n3Var, this.y, this.f4401a, this.f4402gv);
        }

        public long i9(long j2) {
            return this.f4402gv.a(j2, this.f4404v) + this.f4401a;
        }

        @CheckResult
        public n3 n3(long j2, dq.tl tlVar) throws af.n3 {
            long a2;
            s t2 = this.f4403n3.t();
            s t3 = tlVar.t();
            if (t2 == null) {
                return new n3(j2, tlVar, this.f4405zn, this.y, this.f4401a, t2);
            }
            if (!t2.s()) {
                return new n3(j2, tlVar, this.f4405zn, this.y, this.f4401a, t3);
            }
            long fb2 = t2.fb(j2);
            if (fb2 == 0) {
                return new n3(j2, tlVar, this.f4405zn, this.y, this.f4401a, t3);
            }
            long c52 = t2.c5();
            long n32 = t2.n3(c52);
            long j4 = fb2 + c52;
            long j6 = j4 - 1;
            long n33 = t2.n3(j6) + t2.y(j6, j2);
            long c53 = t3.c5();
            long n34 = t3.n3(c53);
            long j7 = this.f4401a;
            int i = (n33 > n34 ? 1 : (n33 == n34 ? 0 : -1));
            if (i != 0) {
                if (i >= 0) {
                    if (n34 < n32) {
                        a2 = j7 - (t3.a(n32, j2) - c52);
                        return new n3(j2, tlVar, this.f4405zn, this.y, a2, t3);
                    }
                    j4 = t2.a(n34, j2);
                } else {
                    throw new af.n3();
                }
            }
            a2 = j7 + (j4 - c53);
            return new n3(j2, tlVar, this.f4405zn, this.y, a2, t3);
        }

        public long s() {
            return this.f4402gv.fb(this.f4404v);
        }

        public t t(long j2) {
            return this.f4402gv.v(j2 - this.f4401a);
        }

        public boolean tl(long j2, long j4) {
            if (this.f4402gv.s() || j4 == -9223372036854775807L || c5(j2) <= j4) {
                return true;
            }
            return false;
        }

        public long v(long j2) {
            return this.f4402gv.zn(this.f4404v, j2) + this.f4401a;
        }

        @CheckResult
        public n3 zn(s sVar) {
            return new n3(this.f4404v, this.f4403n3, this.f4405zn, this.y, this.f4401a, sVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class y implements y.InterfaceC0047y {

        /* renamed from: n3  reason: collision with root package name */
        public final int f4406n3;
        public final tl.y y;

        /* renamed from: zn  reason: collision with root package name */
        public final fb.y f4407zn;

        public y(tl.y yVar) {
            this(yVar, 1);
        }

        @Override // com.google.android.exoplayer2.source.dash.y.InterfaceC0047y
        public com.google.android.exoplayer2.source.dash.y y(d dVar, dq.zn znVar, zr.n3 n3Var, int i, int[] iArr, co coVar, int i5, long j2, boolean z2, List<m> list, @Nullable v.zn znVar2, @Nullable o oVar, u0 u0Var) {
            tl y = this.y.y();
            if (oVar != null) {
                y.i9(oVar);
            }
            return new gv(this.f4407zn, dVar, znVar, n3Var, i, iArr, coVar, i5, y, j2, this.f4406n3, z2, list, znVar2, u0Var);
        }

        public y(tl.y yVar, int i) {
            this(p7.v.f12492z, yVar, i);
        }

        public y(fb.y yVar, tl.y yVar2, int i) {
            this.f4407zn = yVar;
            this.y = yVar2;
            this.f4406n3 = i;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn extends p7.n3 {

        /* renamed from: a  reason: collision with root package name */
        public final long f4408a;

        /* renamed from: v  reason: collision with root package name */
        public final n3 f4409v;

        public zn(n3 n3Var, long j2, long j4, long j6) {
            super(j2, j4);
            this.f4409v = n3Var;
            this.f4408a = j6;
        }

        @Override // p7.xc
        public long n3() {
            zn();
            return this.f4409v.c5(gv());
        }

        @Override // p7.xc
        public long y() {
            zn();
            return this.f4409v.f(gv());
        }
    }

    public gv(fb.y yVar, d dVar, dq.zn znVar, zr.n3 n3Var, int i, int[] iArr, co coVar, int i5, tl tlVar, long j2, int i6, boolean z2, List<m> list, @Nullable v.zn znVar2, u0 u0Var) {
        this.y = dVar;
        this.f4390f = znVar;
        this.f4394n3 = n3Var;
        this.f4400zn = iArr;
        this.f4393i9 = coVar;
        this.f4392gv = i5;
        this.f4398v = tlVar;
        this.f4396t = i;
        this.f4388a = j2;
        this.f4391fb = i6;
        this.f4395s = znVar2;
        long fb2 = znVar.fb(i);
        ArrayList<dq.tl> wz2 = wz();
        this.f4389c5 = new n3[coVar.length()];
        int i8 = 0;
        while (i8 < this.f4389c5.length) {
            dq.tl tlVar2 = wz2.get(coVar.s(i8));
            dq.n3 i92 = n3Var.i9(tlVar2.f7388zn);
            int i10 = i8;
            this.f4389c5[i10] = new n3(fb2, tlVar2, i92 == null ? tlVar2.f7388zn.get(0) : i92, yVar.y(i5, tlVar2.f7385n3, z2, list, znVar2, u0Var), 0L, tlVar2.t());
            i8 = i10 + 1;
        }
    }

    @Override // p7.i9
    public boolean a(a aVar, boolean z2, mg.zn znVar, mg mgVar) {
        mg.n3 n32;
        if (!z2) {
            return false;
        }
        v.zn znVar2 = this.f4395s;
        if (znVar2 != null && znVar2.i9(aVar)) {
            return true;
        }
        if (!this.f4390f.f7423gv && (aVar instanceof wz)) {
            IOException iOException = znVar.f10061zn;
            if ((iOException instanceof d0.v) && ((d0.v) iOException).responseCode == 404) {
                n3 n3Var = this.f4389c5[this.f4393i9.wz(aVar.f12444gv)];
                long s2 = n3Var.s();
                if (s2 != -1 && s2 != 0) {
                    if (((wz) aVar).a() > (n3Var.a() + s2) - 1) {
                        this.f4399wz = true;
                        return true;
                    }
                }
            }
        }
        n3 n3Var2 = this.f4389c5[this.f4393i9.wz(aVar.f12444gv)];
        dq.n3 i92 = this.f4394n3.i9(n3Var2.f4403n3.f7388zn);
        if (i92 != null && !n3Var2.f4405zn.equals(i92)) {
            return true;
        }
        mg.y f4 = f(this.f4393i9, n3Var2.f4403n3.f7388zn);
        if ((!f4.y(2) && !f4.y(1)) || (n32 = mgVar.n3(f4, znVar)) == null || !f4.y(n32.y)) {
            return false;
        }
        int i = n32.y;
        if (i == 2) {
            co coVar = this.f4393i9;
            return coVar.gv(coVar.wz(aVar.f12444gv), n32.f10055n3);
        } else if (i != 1) {
            return false;
        } else {
            this.f4394n3.v(n3Var2.f4405zn, n32.f10055n3);
            return true;
        }
    }

    @Override // p7.i9
    public int c5(long j2, List<? extends wz> list) {
        if (this.f4397tl == null && this.f4393i9.length() >= 2) {
            return this.f4393i9.p(j2, list);
        }
        return list.size();
    }

    public final mg.y f(co coVar, List<dq.n3> list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = coVar.length();
        int i = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (coVar.v(i5, elapsedRealtime)) {
                i++;
            }
        }
        int a2 = zr.n3.a(list);
        return new mg.y(a2, a2 - this.f4394n3.fb(list), length, i);
    }

    @Override // p7.i9
    public long gv(long j2, vc vcVar) {
        n3[] n3VarArr;
        long j4;
        for (n3 n3Var : this.f4389c5) {
            if (n3Var.f4402gv != null) {
                long s2 = n3Var.s();
                if (s2 != 0) {
                    long i92 = n3Var.i9(j2);
                    long f4 = n3Var.f(i92);
                    if (f4 < j2 && (s2 == -1 || i92 < (n3Var.a() + s2) - 1)) {
                        j4 = n3Var.f(i92 + 1);
                    } else {
                        j4 = f4;
                    }
                    return vcVar.y(j2, f4, j4);
                }
            }
        }
        return j2;
    }

    @Override // p7.i9
    public void i9(long j2, long j4, List<? extends wz> list, p7.s sVar) {
        wz wzVar;
        boolean z2;
        t tVar;
        t tVar2;
        int i;
        int i5;
        xc[] xcVarArr;
        long j6;
        long j7;
        if (this.f4397tl != null) {
            return;
        }
        long j8 = j4 - j2;
        long xb2 = j5.xb(this.f4390f.y) + j5.xb(this.f4390f.gv(this.f4396t).f7365n3) + j4;
        v.zn znVar = this.f4395s;
        if (znVar != null && znVar.s(xb2)) {
            return;
        }
        long xb3 = j5.xb(j5.y5(this.f4388a));
        long tl2 = tl(xb3);
        if (list.isEmpty()) {
            wzVar = null;
        } else {
            wzVar = list.get(list.size() - 1);
        }
        int length = this.f4393i9.length();
        xc[] xcVarArr2 = new xc[length];
        int i6 = 0;
        while (i6 < length) {
            n3 n3Var = this.f4389c5[i6];
            if (n3Var.f4402gv == null) {
                xcVarArr2[i6] = xc.y;
                i = i6;
                i5 = length;
                xcVarArr = xcVarArr2;
                j6 = j8;
                j7 = xb3;
            } else {
                long v2 = n3Var.v(xb3);
                long fb2 = n3Var.fb(xb3);
                i = i6;
                i5 = length;
                xcVarArr = xcVarArr2;
                j6 = j8;
                j7 = xb3;
                long xc2 = xc(n3Var, wzVar, j4, v2, fb2);
                if (xc2 < v2) {
                    xcVarArr[i] = xc.y;
                } else {
                    xcVarArr[i] = new zn(mt(i), xc2, fb2, tl2);
                }
            }
            i6 = i + 1;
            xb3 = j7;
            length = i5;
            xcVarArr2 = xcVarArr;
            j8 = j6;
        }
        long j9 = j8;
        long j10 = xb3;
        this.f4393i9.n3(j2, j9, t(j10, j2), list, xcVarArr2);
        n3 mt2 = mt(this.f4393i9.zn());
        fb fbVar = mt2.y;
        if (fbVar != null) {
            dq.tl tlVar = mt2.f4403n3;
            if (fbVar.gv() == null) {
                tVar = tlVar.wz();
            } else {
                tVar = null;
            }
            if (mt2.f4402gv == null) {
                tVar2 = tlVar.tl();
            } else {
                tVar2 = null;
            }
            if (tVar != null || tVar2 != null) {
                sVar.y = w(mt2, this.f4398v, this.f4393i9.co(), this.f4393i9.z(), this.f4393i9.f(), tVar, tVar2);
                return;
            }
        }
        long j11 = mt2.f4404v;
        long j12 = -9223372036854775807L;
        int i8 = (j11 > (-9223372036854775807L) ? 1 : (j11 == (-9223372036854775807L) ? 0 : -1));
        if (i8 != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (mt2.s() == 0) {
            sVar.f12484n3 = z2;
            return;
        }
        long v3 = mt2.v(j10);
        long fb3 = mt2.fb(j10);
        long xc3 = xc(mt2, wzVar, j4, v3, fb3);
        if (xc3 < v3) {
            this.f4397tl = new af.n3();
            return;
        }
        int i10 = (xc3 > fb3 ? 1 : (xc3 == fb3 ? 0 : -1));
        if (i10 <= 0 && (!this.f4399wz || i10 < 0)) {
            if (z2 && mt2.f(xc3) >= j11) {
                sVar.f12484n3 = true;
                return;
            }
            int min = (int) Math.min(this.f4391fb, (fb3 - xc3) + 1);
            if (i8 != 0) {
                while (min > 1 && mt2.f((min + xc3) - 1) >= j11) {
                    min--;
                }
            }
            int i11 = min;
            if (list.isEmpty()) {
                j12 = j4;
            }
            sVar.y = p(mt2, this.f4398v, this.f4392gv, this.f4393i9.co(), this.f4393i9.z(), this.f4393i9.f(), xc3, i11, j12, tl2);
            return;
        }
        sVar.f12484n3 = z2;
    }

    public final n3 mt(int i) {
        n3 n3Var = this.f4389c5[i];
        dq.n3 i92 = this.f4394n3.i9(n3Var.f4403n3.f7388zn);
        if (i92 != null && !i92.equals(n3Var.f4405zn)) {
            n3 gv2 = n3Var.gv(i92);
            this.f4389c5[i] = gv2;
            return gv2;
        }
        return n3Var;
    }

    @Override // p7.i9
    public void n3() throws IOException {
        IOException iOException = this.f4397tl;
        if (iOException == null) {
            this.y.n3();
            return;
        }
        throw iOException;
    }

    public a p(n3 n3Var, tl tlVar, int i, m mVar, int i5, Object obj, long j2, int i6, long j4, long j6) {
        long j7;
        dq.tl tlVar2 = n3Var.f4403n3;
        long f4 = n3Var.f(j2);
        t t2 = n3Var.t(j2);
        int i8 = 8;
        if (n3Var.y == null) {
            long c52 = n3Var.c5(j2);
            if (n3Var.tl(j2, j6)) {
                i8 = 0;
            }
            return new w(tlVar, c5.y(tlVar2, n3Var.f4405zn.y, t2, i8), mVar, i5, obj, f4, c52, j2, i, mVar);
        }
        int i10 = 1;
        int i11 = 1;
        while (i10 < i6) {
            t y2 = t2.y(n3Var.t(i10 + j2), n3Var.f4405zn.y);
            if (y2 == null) {
                break;
            }
            i11++;
            i10++;
            t2 = y2;
        }
        long j8 = (i11 + j2) - 1;
        long c53 = n3Var.c5(j8);
        long j9 = n3Var.f4404v;
        if (j9 != -9223372036854775807L && j9 <= c53) {
            j7 = j9;
        } else {
            j7 = -9223372036854775807L;
        }
        if (n3Var.tl(j8, j6)) {
            i8 = 0;
        }
        return new f(tlVar, c5.y(tlVar2, n3Var.f4405zn.y, t2, i8), mVar, i5, obj, f4, c53, j4, j7, j2, i11, -tlVar2.f7384gv, n3Var.y);
    }

    @Override // p7.i9
    public void release() {
        for (n3 n3Var : this.f4389c5) {
            fb fbVar = n3Var.y;
            if (fbVar != null) {
                fbVar.release();
            }
        }
    }

    @Override // p7.i9
    public boolean s(long j2, a aVar, List<? extends wz> list) {
        if (this.f4397tl != null) {
            return false;
        }
        return this.f4393i9.c5(j2, aVar, list);
    }

    public final long t(long j2, long j4) {
        if (this.f4390f.f7423gv && this.f4389c5[0].s() != 0) {
            return Math.max(0L, Math.min(tl(j2), this.f4389c5[0].c5(this.f4389c5[0].fb(j2))) - j4);
        }
        return -9223372036854775807L;
    }

    public final long tl(long j2) {
        dq.zn znVar = this.f4390f;
        long j4 = znVar.y;
        if (j4 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j2 - j5.xb(j4 + znVar.gv(this.f4396t).f7365n3);
    }

    @Override // p7.i9
    public void v(a aVar) {
        e4.gv zn2;
        if (aVar instanceof p7.tl) {
            int wz2 = this.f4393i9.wz(((p7.tl) aVar).f12444gv);
            n3 n3Var = this.f4389c5[wz2];
            if (n3Var.f4402gv == null && (zn2 = n3Var.y.zn()) != null) {
                this.f4389c5[wz2] = n3Var.zn(new i9(zn2, n3Var.f4403n3.f7384gv));
            }
        }
        v.zn znVar = this.f4395s;
        if (znVar != null) {
            znVar.c5(aVar);
        }
    }

    public a w(n3 n3Var, tl tlVar, m mVar, int i, @Nullable Object obj, @Nullable t tVar, @Nullable t tVar2) {
        t tVar3 = tVar;
        dq.tl tlVar2 = n3Var.f4403n3;
        if (tVar3 != null) {
            t y2 = tVar3.y(tVar2, n3Var.f4405zn.y);
            if (y2 != null) {
                tVar3 = y2;
            }
        } else {
            tVar3 = tVar2;
        }
        return new p7.tl(tlVar, c5.y(tlVar2, n3Var.f4405zn.y, tVar3, 0), mVar, i, obj, n3Var.y);
    }

    public final ArrayList<dq.tl> wz() {
        List<dq.y> list = this.f4390f.gv(this.f4396t).f7367zn;
        ArrayList<dq.tl> arrayList = new ArrayList<>();
        for (int i : this.f4400zn) {
            arrayList.addAll(list.get(i).f7418zn);
        }
        return arrayList;
    }

    public final long xc(n3 n3Var, @Nullable wz wzVar, long j2, long j4, long j6) {
        if (wzVar != null) {
            return wzVar.a();
        }
        return j5.mt(n3Var.i9(j2), j4, j6);
    }

    @Override // com.google.android.exoplayer2.source.dash.y
    public void y(co coVar) {
        this.f4393i9 = coVar;
    }

    @Override // com.google.android.exoplayer2.source.dash.y
    public void zn(dq.zn znVar, int i) {
        try {
            this.f4390f = znVar;
            this.f4396t = i;
            long fb2 = znVar.fb(i);
            ArrayList<dq.tl> wz2 = wz();
            for (int i5 = 0; i5 < this.f4389c5.length; i5++) {
                n3[] n3VarArr = this.f4389c5;
                n3VarArr[i5] = n3VarArr[i5].n3(fb2, wz2.get(this.f4393i9.s(i5)));
            }
        } catch (af.n3 e2) {
            this.f4397tl = e2;
        }
    }
}

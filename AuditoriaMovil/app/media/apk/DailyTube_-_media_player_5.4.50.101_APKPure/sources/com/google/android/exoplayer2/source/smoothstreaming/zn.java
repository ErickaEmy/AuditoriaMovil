package com.google.android.exoplayer2.source.smoothstreaming;

import af.b;
import af.d0;
import af.en;
import af.jz;
import af.lc;
import af.rs;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.a;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.source.smoothstreaming.n3;
import java.io.IOException;
import java.util.ArrayList;
import kx.d;
import kx.mg;
import kx.o;
import m1.m;
import m1.vc;
import p7.c5;
import q3.y;
import zo.co;
/* loaded from: classes.dex */
public final class zn implements d0, jz.y<c5<n3>> {

    /* renamed from: c  reason: collision with root package name */
    public jz f4697c;

    /* renamed from: co  reason: collision with root package name */
    public final lc f4698co;

    /* renamed from: f  reason: collision with root package name */
    public final v.y f4699f;

    /* renamed from: f3  reason: collision with root package name */
    public q3.y f4700f3;

    /* renamed from: fb  reason: collision with root package name */
    public final d f4701fb;

    /* renamed from: n  reason: collision with root package name */
    public c5<n3>[] f4702n;

    /* renamed from: p  reason: collision with root package name */
    public final kx.n3 f4703p;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    public d0.y f4704r;

    /* renamed from: s  reason: collision with root package name */
    public final a f4705s;

    /* renamed from: t  reason: collision with root package name */
    public final mg f4706t;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final o f4707v;

    /* renamed from: w  reason: collision with root package name */
    public final b.y f4708w;
    public final n3.y y;

    /* renamed from: z  reason: collision with root package name */
    public final af.c5 f4709z;

    public zn(q3.y yVar, n3.y yVar2, @Nullable o oVar, af.c5 c5Var, a aVar, v.y yVar3, mg mgVar, b.y yVar4, d dVar, kx.n3 n3Var) {
        this.f4700f3 = yVar;
        this.y = yVar2;
        this.f4707v = oVar;
        this.f4701fb = dVar;
        this.f4705s = aVar;
        this.f4699f = yVar3;
        this.f4706t = mgVar;
        this.f4708w = yVar4;
        this.f4703p = n3Var;
        this.f4709z = c5Var;
        this.f4698co = xc(yVar, aVar);
        c5<n3>[] w4 = w(0);
        this.f4702n = w4;
        this.f4697c = c5Var.y(w4);
    }

    private static c5<n3>[] w(int i) {
        return new c5[i];
    }

    public static lc xc(q3.y yVar, a aVar) {
        rs[] rsVarArr = new rs[yVar.f12731a.length];
        int i = 0;
        while (true) {
            y.n3[] n3VarArr = yVar.f12731a;
            if (i < n3VarArr.length) {
                m[] mVarArr = n3VarArr[i].f12743i9;
                m[] mVarArr2 = new m[mVarArr.length];
                for (int i5 = 0; i5 < mVarArr.length; i5++) {
                    m mVar = mVarArr[i5];
                    mVarArr2[i5] = mVar.zn(aVar.n3(mVar));
                }
                rsVarArr[i] = new rs(Integer.toString(i), mVarArr2);
                i++;
            } else {
                return new lc(rsVarArr);
            }
        }
    }

    public final c5<n3> a(co coVar, long j2) {
        int zn2 = this.f4698co.zn(coVar.xc());
        return new c5<>(this.f4700f3.f12731a[zn2].y, null, null, this.y.y(this.f4701fb, this.f4700f3, zn2, coVar, this.f4707v), this, this.f4703p, j2, this.f4705s, this.f4699f, this.f4706t, this.f4708w);
    }

    @Override // af.d0
    public long c5(long j2) {
        for (c5<n3> c5Var : this.f4702n) {
            c5Var.j5(j2);
        }
        return j2;
    }

    @Override // af.d0
    public void co(d0.y yVar, long j2) {
        this.f4704r = yVar;
        yVar.n3(this);
    }

    @Override // af.d0
    public long f(co[] coVarArr, boolean[] zArr, en[] enVarArr, boolean[] zArr2, long j2) {
        co coVar;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < coVarArr.length; i++) {
            en enVar = enVarArr[i];
            if (enVar != null) {
                c5 c5Var = (c5) enVar;
                if (coVarArr[i] != null && zArr[i]) {
                    ((n3) c5Var.d0()).y(coVarArr[i]);
                    arrayList.add(c5Var);
                } else {
                    c5Var.yt();
                    enVarArr[i] = null;
                }
            }
            if (enVarArr[i] == null && (coVar = coVarArr[i]) != null) {
                c5<n3> a2 = a(coVar, j2);
                arrayList.add(a2);
                enVarArr[i] = a2;
                zArr2[i] = true;
            }
        }
        c5<n3>[] w4 = w(arrayList.size());
        this.f4702n = w4;
        arrayList.toArray(w4);
        this.f4697c = this.f4709z.y(this.f4702n);
        return j2;
    }

    @Override // af.d0, af.jz
    public long fb() {
        return this.f4697c.fb();
    }

    @Override // af.d0
    public long gv(long j2, vc vcVar) {
        c5<n3>[] c5VarArr;
        for (c5<n3> c5Var : this.f4702n) {
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
        for (c5<n3> c5Var : this.f4702n) {
            c5Var.mt(j2, z2);
        }
    }

    @Override // af.d0
    public lc p() {
        return this.f4698co;
    }

    public void r() {
        for (c5<n3> c5Var : this.f4702n) {
            c5Var.yt();
        }
        this.f4704r = null;
    }

    @Override // af.d0, af.jz
    public void s(long j2) {
        this.f4697c.s(j2);
    }

    @Override // af.d0, af.jz
    public boolean v(long j2) {
        return this.f4697c.v(j2);
    }

    @Override // af.d0
    public void wz() throws IOException {
        this.f4701fb.n3();
    }

    public void x4(q3.y yVar) {
        this.f4700f3 = yVar;
        for (c5<n3> c5Var : this.f4702n) {
            c5Var.d0().fb(yVar);
        }
        this.f4704r.t(this);
    }

    @Override // af.d0, af.jz
    public boolean y() {
        return this.f4697c.y();
    }

    @Override // af.jz.y
    /* renamed from: z */
    public void t(c5<n3> c5Var) {
        this.f4704r.t(this);
    }

    @Override // af.d0, af.jz
    public long zn() {
        return this.f4697c.zn();
    }
}

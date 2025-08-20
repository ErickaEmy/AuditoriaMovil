package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.smoothstreaming.n3;
import ha.w;
import ha.xc;
import java.io.IOException;
import java.util.List;
import kx.d;
import kx.mg;
import kx.o;
import kx.p;
import kx.tl;
import m1.m;
import m1.vc;
import p7.a;
import p7.f;
import p7.fb;
import p7.s;
import p7.v;
import p7.wz;
import q3.y;
import zo.co;
import zo.d0;
/* loaded from: classes.dex */
public class y implements com.google.android.exoplayer2.source.smoothstreaming.n3 {

    /* renamed from: a  reason: collision with root package name */
    public q3.y f4688a;

    /* renamed from: fb  reason: collision with root package name */
    public int f4689fb;

    /* renamed from: gv  reason: collision with root package name */
    public final tl f4690gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f4691n3;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public IOException f4692s;

    /* renamed from: v  reason: collision with root package name */
    public co f4693v;
    public final d y;

    /* renamed from: zn  reason: collision with root package name */
    public final fb[] f4694zn;

    /* loaded from: classes.dex */
    public static final class n3 extends p7.n3 {

        /* renamed from: a  reason: collision with root package name */
        public final int f4695a;

        /* renamed from: v  reason: collision with root package name */
        public final y.n3 f4696v;

        public n3(y.n3 n3Var, int i, int i5) {
            super(i5, n3Var.f12740f - 1);
            this.f4696v = n3Var;
            this.f4695a = i;
        }

        @Override // p7.xc
        public long n3() {
            return y() + this.f4696v.zn((int) gv());
        }

        @Override // p7.xc
        public long y() {
            zn();
            return this.f4696v.v((int) gv());
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0053y implements n3.y {
        public final tl.y y;

        public C0053y(tl.y yVar) {
            this.y = yVar;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.n3.y
        public com.google.android.exoplayer2.source.smoothstreaming.n3 y(d dVar, q3.y yVar, int i, co coVar, @Nullable o oVar) {
            tl y = this.y.y();
            if (oVar != null) {
                y.i9(oVar);
            }
            return new y(dVar, yVar, i, coVar, y);
        }
    }

    public y(d dVar, q3.y yVar, int i, co coVar, tl tlVar) {
        w[] wVarArr;
        int i5;
        this.y = dVar;
        this.f4688a = yVar;
        this.f4691n3 = i;
        this.f4693v = coVar;
        this.f4690gv = tlVar;
        y.n3 n3Var = yVar.f12731a[i];
        this.f4694zn = new fb[coVar.length()];
        for (int i6 = 0; i6 < this.f4694zn.length; i6++) {
            int s2 = coVar.s(i6);
            m mVar = n3Var.f12743i9[s2];
            if (mVar.f10944d0 != null) {
                wVarArr = ((y.C0185y) v5.y.v(yVar.f12736v)).f12754zn;
            } else {
                wVarArr = null;
            }
            int i8 = n3Var.y;
            if (i8 == 2) {
                i5 = 4;
            } else {
                i5 = 0;
            }
            this.f4694zn[i6] = new v(new ha.fb(3, null, new xc(s2, i8, n3Var.f12752zn, -9223372036854775807L, yVar.f12732fb, mVar, 0, wVarArr, i5, null, null)), n3Var.y, mVar);
        }
    }

    public static wz f(m mVar, tl tlVar, Uri uri, int i, long j2, long j4, long j6, int i5, @Nullable Object obj, fb fbVar) {
        return new f(tlVar, new p(uri), mVar, i5, obj, j2, j4, j6, -9223372036854775807L, i, 1, j2, fbVar);
    }

    @Override // p7.i9
    public boolean a(a aVar, boolean z2, mg.zn znVar, mg mgVar) {
        mg.n3 n32 = mgVar.n3(d0.zn(this.f4693v), znVar);
        if (z2 && n32 != null && n32.y == 2) {
            co coVar = this.f4693v;
            if (coVar.gv(coVar.wz(aVar.f12444gv), n32.f10055n3)) {
                return true;
            }
        }
        return false;
    }

    @Override // p7.i9
    public int c5(long j2, List<? extends wz> list) {
        if (this.f4692s == null && this.f4693v.length() >= 2) {
            return this.f4693v.p(j2, list);
        }
        return list.size();
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.n3
    public void fb(q3.y yVar) {
        y.n3[] n3VarArr = this.f4688a.f12731a;
        int i = this.f4691n3;
        y.n3 n3Var = n3VarArr[i];
        int i5 = n3Var.f12740f;
        y.n3 n3Var2 = yVar.f12731a[i];
        if (i5 != 0 && n3Var2.f12740f != 0) {
            int i6 = i5 - 1;
            long v2 = n3Var.v(i6) + n3Var.zn(i6);
            long v3 = n3Var2.v(0);
            if (v2 <= v3) {
                this.f4689fb += i5;
            } else {
                this.f4689fb += n3Var.gv(v3);
            }
        } else {
            this.f4689fb += i5;
        }
        this.f4688a = yVar;
    }

    @Override // p7.i9
    public long gv(long j2, vc vcVar) {
        long j4;
        y.n3 n3Var = this.f4688a.f12731a[this.f4691n3];
        int gv2 = n3Var.gv(j2);
        long v2 = n3Var.v(gv2);
        if (v2 < j2 && gv2 < n3Var.f12740f - 1) {
            j4 = n3Var.v(gv2 + 1);
        } else {
            j4 = v2;
        }
        return vcVar.y(j2, v2, j4);
    }

    @Override // p7.i9
    public final void i9(long j2, long j4, List<? extends wz> list, s sVar) {
        int a2;
        long j6 = j4;
        if (this.f4692s != null) {
            return;
        }
        q3.y yVar = this.f4688a;
        y.n3 n3Var = yVar.f12731a[this.f4691n3];
        if (n3Var.f12740f == 0) {
            sVar.f12484n3 = !yVar.f12733gv;
            return;
        }
        if (list.isEmpty()) {
            a2 = n3Var.gv(j6);
        } else {
            a2 = (int) (list.get(list.size() - 1).a() - this.f4689fb);
            if (a2 < 0) {
                this.f4692s = new af.n3();
                return;
            }
        }
        if (a2 >= n3Var.f12740f) {
            sVar.f12484n3 = !this.f4688a.f12733gv;
            return;
        }
        long j7 = j6 - j2;
        long t2 = t(j2);
        int length = this.f4693v.length();
        p7.xc[] xcVarArr = new p7.xc[length];
        for (int i = 0; i < length; i++) {
            xcVarArr[i] = new n3(n3Var, this.f4693v.s(i), a2);
        }
        this.f4693v.n3(j2, j7, t2, list, xcVarArr);
        long v2 = n3Var.v(a2);
        long zn2 = v2 + n3Var.zn(a2);
        if (!list.isEmpty()) {
            j6 = -9223372036854775807L;
        }
        long j8 = j6;
        int i5 = a2 + this.f4689fb;
        int zn3 = this.f4693v.zn();
        fb fbVar = this.f4694zn[zn3];
        sVar.y = f(this.f4693v.co(), this.f4690gv, n3Var.y(this.f4693v.s(zn3), a2), i5, v2, zn2, j8, this.f4693v.z(), this.f4693v.f(), fbVar);
    }

    @Override // p7.i9
    public void n3() throws IOException {
        IOException iOException = this.f4692s;
        if (iOException == null) {
            this.y.n3();
            return;
        }
        throw iOException;
    }

    @Override // p7.i9
    public void release() {
        for (fb fbVar : this.f4694zn) {
            fbVar.release();
        }
    }

    @Override // p7.i9
    public boolean s(long j2, a aVar, List<? extends wz> list) {
        if (this.f4692s != null) {
            return false;
        }
        return this.f4693v.c5(j2, aVar, list);
    }

    public final long t(long j2) {
        q3.y yVar = this.f4688a;
        if (!yVar.f12733gv) {
            return -9223372036854775807L;
        }
        y.n3 n3Var = yVar.f12731a[this.f4691n3];
        int i = n3Var.f12740f - 1;
        return (n3Var.v(i) + n3Var.zn(i)) - j2;
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.n3
    public void y(co coVar) {
        this.f4693v = coVar;
    }

    @Override // p7.i9
    public void v(a aVar) {
    }
}

package p7;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import e4.d0;
import e4.fh;
import e4.mg;
import e4.ta;
import fj.u0;
import java.io.IOException;
import java.util.List;
import m1.m;
import p7.fb;
import v5.j5;
import v5.n;
import v5.rz;
/* loaded from: classes.dex */
public final class v implements e4.wz, fb {

    /* renamed from: co  reason: collision with root package name */
    public m[] f12493co;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12494f;

    /* renamed from: fb  reason: collision with root package name */
    public final m f12495fb;

    /* renamed from: p  reason: collision with root package name */
    public fh f12496p;

    /* renamed from: s  reason: collision with root package name */
    public final SparseArray<y> f12497s = new SparseArray<>();
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public fb.n3 f12498t;

    /* renamed from: v  reason: collision with root package name */
    public final int f12499v;

    /* renamed from: w  reason: collision with root package name */
    public long f12500w;
    public final e4.t y;

    /* renamed from: z  reason: collision with root package name */
    public static final fb.y f12492z = new fb.y() { // from class: p7.gv
        @Override // p7.fb.y
        public final fb y(int i, m mVar, boolean z2, List list, ta taVar, u0 u0Var) {
            fb fb2;
            fb2 = v.fb(i, mVar, z2, list, taVar, u0Var);
            return fb2;
        }
    };

    /* renamed from: r  reason: collision with root package name */
    public static final d0 f12491r = new d0();

    /* loaded from: classes.dex */
    public static final class y implements ta {

        /* renamed from: a  reason: collision with root package name */
        public ta f12501a;

        /* renamed from: fb  reason: collision with root package name */
        public long f12502fb;

        /* renamed from: gv  reason: collision with root package name */
        public final e4.f f12503gv = new e4.f();

        /* renamed from: n3  reason: collision with root package name */
        public final int f12504n3;

        /* renamed from: v  reason: collision with root package name */
        public m f12505v;
        public final int y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public final m f12506zn;

        public y(int i, int i5, @Nullable m mVar) {
            this.y = i;
            this.f12504n3 = i5;
            this.f12506zn = mVar;
        }

        @Override // e4.ta
        public void a(rz rzVar, int i, int i5) {
            ((ta) j5.i9(this.f12501a)).zn(rzVar, i);
        }

        public void fb(@Nullable fb.n3 n3Var, long j2) {
            if (n3Var == null) {
                this.f12501a = this.f12503gv;
                return;
            }
            this.f12502fb = j2;
            ta a2 = n3Var.a(this.y, this.f12504n3);
            this.f12501a = a2;
            m mVar = this.f12505v;
            if (mVar != null) {
                a2.v(mVar);
            }
        }

        @Override // e4.ta
        public void gv(long j2, int i, int i5, int i6, @Nullable ta.y yVar) {
            long j4 = this.f12502fb;
            if (j4 != -9223372036854775807L && j2 >= j4) {
                this.f12501a = this.f12503gv;
            }
            ((ta) j5.i9(this.f12501a)).gv(j2, i, i5, i6, yVar);
        }

        @Override // e4.ta
        public /* synthetic */ int n3(kx.c5 c5Var, int i, boolean z2) {
            return mg.y(this, c5Var, i, z2);
        }

        @Override // e4.ta
        public void v(m mVar) {
            m mVar2 = this.f12506zn;
            if (mVar2 != null) {
                mVar = mVar.f(mVar2);
            }
            this.f12505v = mVar;
            ((ta) j5.i9(this.f12501a)).v(this.f12505v);
        }

        @Override // e4.ta
        public int y(kx.c5 c5Var, int i, boolean z2, int i5) throws IOException {
            return ((ta) j5.i9(this.f12501a)).n3(c5Var, i, z2);
        }

        @Override // e4.ta
        public /* synthetic */ void zn(rz rzVar, int i) {
            mg.n3(this, rzVar, i);
        }
    }

    public v(e4.t tVar, int i, m mVar) {
        this.y = tVar;
        this.f12499v = i;
        this.f12495fb = mVar;
    }

    public static /* synthetic */ fb fb(int i, m mVar, boolean z2, List list, ta taVar, u0 u0Var) {
        int i5;
        e4.t fbVar;
        String str = mVar.f10962r;
        if (n.mt(str)) {
            return null;
        }
        if (n.p(str)) {
            fbVar = new sc.v(1);
        } else {
            if (z2) {
                i5 = 4;
            } else {
                i5 = 0;
            }
            fbVar = new ha.fb(i5, null, null, list, taVar);
        }
        return new v(fbVar, i, mVar);
    }

    @Override // e4.wz
    public ta a(int i, int i5) {
        boolean z2;
        m mVar;
        y yVar = this.f12497s.get(i);
        if (yVar == null) {
            if (this.f12493co == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.fb(z2);
            if (i5 == this.f12499v) {
                mVar = this.f12495fb;
            } else {
                mVar = null;
            }
            yVar = new y(i, i5, mVar);
            yVar.fb(this.f12498t, this.f12500w);
            this.f12497s.put(i, yVar);
        }
        return yVar;
    }

    @Override // p7.fb
    @Nullable
    public m[] gv() {
        return this.f12493co;
    }

    @Override // p7.fb
    public boolean n3(e4.tl tlVar) throws IOException {
        boolean z2;
        int v2 = this.y.v(tlVar, f12491r);
        if (v2 != 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        if (v2 != 0) {
            return false;
        }
        return true;
    }

    @Override // p7.fb
    public void release() {
        this.y.release();
    }

    @Override // e4.wz
    public void t(fh fhVar) {
        this.f12496p = fhVar;
    }

    @Override // e4.wz
    public void xc() {
        m[] mVarArr = new m[this.f12497s.size()];
        for (int i = 0; i < this.f12497s.size(); i++) {
            mVarArr[i] = (m) v5.y.c5(this.f12497s.valueAt(i).f12505v);
        }
        this.f12493co = mVarArr;
    }

    @Override // p7.fb
    public void y(@Nullable fb.n3 n3Var, long j2, long j4) {
        this.f12498t = n3Var;
        this.f12500w = j4;
        if (!this.f12494f) {
            this.y.zn(this);
            if (j2 != -9223372036854775807L) {
                this.y.y(0L, j2);
            }
            this.f12494f = true;
            return;
        }
        e4.t tVar = this.y;
        if (j2 == -9223372036854775807L) {
            j2 = 0;
        }
        tVar.y(0L, j2);
        for (int i = 0; i < this.f12497s.size(); i++) {
            this.f12497s.valueAt(i).fb(n3Var, j4);
        }
    }

    @Override // p7.fb
    @Nullable
    public e4.gv zn() {
        fh fhVar = this.f12496p;
        if (fhVar instanceof e4.gv) {
            return (e4.gv) fhVar;
        }
        return null;
    }
}

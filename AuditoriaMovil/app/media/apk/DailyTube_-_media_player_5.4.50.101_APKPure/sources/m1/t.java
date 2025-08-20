package m1;

import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class t implements v5.i4 {

    /* renamed from: f  reason: collision with root package name */
    public boolean f11245f = true;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public zq f11246fb;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public v5.i4 f11247s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f11248t;

    /* renamed from: v  reason: collision with root package name */
    public final y f11249v;
    public final v5.ud y;

    /* loaded from: classes.dex */
    public interface y {
        void onPlaybackParametersChanged(br brVar);
    }

    public t(y yVar, v5.v vVar) {
        this.f11249v = yVar;
        this.y = new v5.ud(vVar);
    }

    public final boolean a(boolean z2) {
        zq zqVar = this.f11246fb;
        if (zqVar != null && !zqVar.a() && (this.f11246fb.isReady() || (!z2 && !this.f11246fb.c5()))) {
            return false;
        }
        return true;
    }

    public long c5(boolean z2) {
        i9(z2);
        return w();
    }

    public void fb() {
        this.f11248t = true;
        this.y.n3();
    }

    public void gv(long j2) {
        this.y.y(j2);
    }

    public final void i9(boolean z2) {
        if (a(z2)) {
            this.f11245f = true;
            if (this.f11248t) {
                this.y.n3();
                return;
            }
            return;
        }
        v5.i4 i4Var = (v5.i4) v5.y.v(this.f11247s);
        long w4 = i4Var.w();
        if (this.f11245f) {
            if (w4 < this.y.w()) {
                this.y.gv();
                return;
            }
            this.f11245f = false;
            if (this.f11248t) {
                this.y.n3();
            }
        }
        this.y.y(w4);
        br v2 = i4Var.v();
        if (!v2.equals(this.y.v())) {
            this.y.zn(v2);
            this.f11249v.onPlaybackParametersChanged(v2);
        }
    }

    public void n3(zq zqVar) throws p {
        v5.i4 i4Var;
        v5.i4 i42 = zqVar.i4();
        if (i42 != null && i42 != (i4Var = this.f11247s)) {
            if (i4Var == null) {
                this.f11247s = i42;
                this.f11246fb = zqVar;
                i42.zn(this.y.v());
                return;
            }
            throw p.r(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
    }

    public void s() {
        this.f11248t = false;
        this.y.gv();
    }

    @Override // v5.i4
    public br v() {
        v5.i4 i4Var = this.f11247s;
        if (i4Var != null) {
            return i4Var.v();
        }
        return this.y.v();
    }

    @Override // v5.i4
    public long w() {
        if (this.f11245f) {
            return this.y.w();
        }
        return ((v5.i4) v5.y.v(this.f11247s)).w();
    }

    public void y(zq zqVar) {
        if (zqVar == this.f11246fb) {
            this.f11247s = null;
            this.f11246fb = null;
            this.f11245f = true;
        }
    }

    @Override // v5.i4
    public void zn(br brVar) {
        v5.i4 i4Var = this.f11247s;
        if (i4Var != null) {
            i4Var.zn(brVar);
            brVar = this.f11247s.v();
        }
        this.y.zn(brVar);
    }
}

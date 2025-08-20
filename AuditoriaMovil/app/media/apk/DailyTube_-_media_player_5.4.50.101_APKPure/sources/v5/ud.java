package v5;

import m1.br;
/* loaded from: classes.dex */
public final class ud implements i4 {

    /* renamed from: f  reason: collision with root package name */
    public br f14396f = br.f10581s;

    /* renamed from: fb  reason: collision with root package name */
    public long f14397fb;

    /* renamed from: s  reason: collision with root package name */
    public long f14398s;

    /* renamed from: v  reason: collision with root package name */
    public boolean f14399v;
    public final v y;

    public ud(v vVar) {
        this.y = vVar;
    }

    public void gv() {
        if (this.f14399v) {
            y(w());
            this.f14399v = false;
        }
    }

    public void n3() {
        if (!this.f14399v) {
            this.f14398s = this.y.elapsedRealtime();
            this.f14399v = true;
        }
    }

    @Override // v5.i4
    public br v() {
        return this.f14396f;
    }

    @Override // v5.i4
    public long w() {
        long n32;
        long j2 = this.f14397fb;
        if (this.f14399v) {
            long elapsedRealtime = this.y.elapsedRealtime() - this.f14398s;
            br brVar = this.f14396f;
            if (brVar.y == 1.0f) {
                n32 = j5.xb(elapsedRealtime);
            } else {
                n32 = brVar.n3(elapsedRealtime);
            }
            return j2 + n32;
        }
        return j2;
    }

    public void y(long j2) {
        this.f14397fb = j2;
        if (this.f14399v) {
            this.f14398s = this.y.elapsedRealtime();
        }
    }

    @Override // v5.i4
    public void zn(br brVar) {
        if (this.f14399v) {
            y(w());
        }
        this.f14396f = brVar;
    }
}

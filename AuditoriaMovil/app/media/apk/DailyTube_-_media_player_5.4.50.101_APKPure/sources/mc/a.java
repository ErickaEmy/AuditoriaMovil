package mc;

import mc.fb;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public fb.n3 f11406a;

    /* renamed from: gv  reason: collision with root package name */
    public fb.n3 f11407gv;

    /* renamed from: n3  reason: collision with root package name */
    public v f11408n3;

    /* renamed from: v  reason: collision with root package name */
    public String f11409v;
    public n3$mt y;

    /* renamed from: zn  reason: collision with root package name */
    public String f11410zn;

    public a() {
    }

    public boolean a() {
        if (this.f11406a != null) {
            return true;
        }
        return false;
    }

    public a fb(float f4, float f6, float f9, float f10) {
        this.f11406a = new fb.n3(f4, f6, f9, f10);
        return this;
    }

    public boolean gv() {
        if (this.f11409v != null) {
            return true;
        }
        return false;
    }

    public boolean n3() {
        if (this.f11408n3 != null) {
            return true;
        }
        return false;
    }

    public boolean v() {
        if (this.f11407gv != null) {
            return true;
        }
        return false;
    }

    public boolean y() {
        n3$mt n3_mt = this.y;
        if (n3_mt != null && n3_mt.a() > 0) {
            return true;
        }
        return false;
    }

    public boolean zn() {
        if (this.f11410zn != null) {
            return true;
        }
        return false;
    }

    public a(a aVar) {
        if (aVar == null) {
            return;
        }
        this.y = aVar.y;
        this.f11408n3 = aVar.f11408n3;
        this.f11407gv = aVar.f11407gv;
        this.f11409v = aVar.f11409v;
        this.f11406a = aVar.f11406a;
    }
}

package pv;

import android.graphics.Typeface;
/* loaded from: classes.dex */
public final class y extends a {

    /* renamed from: n3  reason: collision with root package name */
    public final InterfaceC0181y f12657n3;
    public final Typeface y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f12658zn;

    /* renamed from: pv.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0181y {
        void y(Typeface typeface);
    }

    public y(InterfaceC0181y interfaceC0181y, Typeface typeface) {
        this.y = typeface;
        this.f12657n3 = interfaceC0181y;
    }

    public final void gv(Typeface typeface) {
        if (!this.f12658zn) {
            this.f12657n3.y(typeface);
        }
    }

    @Override // pv.a
    public void n3(Typeface typeface, boolean z2) {
        gv(typeface);
    }

    @Override // pv.a
    public void y(int i) {
        gv(this.y);
    }

    public void zn() {
        this.f12658zn = true;
    }
}

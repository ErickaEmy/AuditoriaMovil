package u4;

import android.view.View;
import hw.i4;
/* loaded from: classes.dex */
public class gv {

    /* renamed from: a  reason: collision with root package name */
    public boolean f14030a = true;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f14031fb = true;

    /* renamed from: gv  reason: collision with root package name */
    public int f14032gv;

    /* renamed from: n3  reason: collision with root package name */
    public int f14033n3;

    /* renamed from: v  reason: collision with root package name */
    public int f14034v;
    public final View y;

    /* renamed from: zn  reason: collision with root package name */
    public int f14035zn;

    public gv(View view) {
        this.y = view;
    }

    public boolean gv(int i) {
        if (this.f14031fb && this.f14034v != i) {
            this.f14034v = i;
            y();
            return true;
        }
        return false;
    }

    public int n3() {
        return this.f14032gv;
    }

    public boolean v(int i) {
        if (this.f14030a && this.f14032gv != i) {
            this.f14032gv = i;
            y();
            return true;
        }
        return false;
    }

    public void y() {
        View view = this.y;
        i4.xg(view, this.f14032gv - (view.getTop() - this.f14033n3));
        View view2 = this.y;
        i4.y5(view2, this.f14034v - (view2.getLeft() - this.f14035zn));
    }

    public void zn() {
        this.f14033n3 = this.y.getTop();
        this.f14035zn = this.y.getLeft();
    }
}

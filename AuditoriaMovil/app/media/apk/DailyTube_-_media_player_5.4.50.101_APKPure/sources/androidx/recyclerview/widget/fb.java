package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class fb {

    /* renamed from: a  reason: collision with root package name */
    public int f3233a;

    /* renamed from: c5  reason: collision with root package name */
    public boolean f3234c5;

    /* renamed from: fb  reason: collision with root package name */
    public int f3235fb;

    /* renamed from: gv  reason: collision with root package name */
    public int f3236gv;

    /* renamed from: n3  reason: collision with root package name */
    public int f3237n3;

    /* renamed from: s  reason: collision with root package name */
    public boolean f3238s;

    /* renamed from: v  reason: collision with root package name */
    public int f3239v;
    public boolean y = true;

    /* renamed from: zn  reason: collision with root package name */
    public int f3240zn;

    public View n3(RecyclerView.i4 i4Var) {
        View xc2 = i4Var.xc(this.f3240zn);
        this.f3240zn += this.f3236gv;
        return xc2;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f3237n3 + ", mCurrentPosition=" + this.f3240zn + ", mItemDirection=" + this.f3236gv + ", mLayoutDirection=" + this.f3239v + ", mStartLine=" + this.f3233a + ", mEndLine=" + this.f3235fb + '}';
    }

    public boolean y(RecyclerView.fh fhVar) {
        int i = this.f3240zn;
        if (i >= 0 && i < fhVar.n3()) {
            return true;
        }
        return false;
    }
}

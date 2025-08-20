package q9;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
/* loaded from: classes.dex */
public class c5 {

    /* renamed from: a  reason: collision with root package name */
    public ViewStub.OnInflateListener f12781a;

    /* renamed from: gv  reason: collision with root package name */
    public ViewStub.OnInflateListener f12782gv;

    /* renamed from: n3  reason: collision with root package name */
    public ViewDataBinding f12783n3;

    /* renamed from: v  reason: collision with root package name */
    public ViewDataBinding f12784v;
    public ViewStub y;

    /* renamed from: zn  reason: collision with root package name */
    public View f12785zn;

    /* loaded from: classes.dex */
    public class y implements ViewStub.OnInflateListener {
        public y() {
        }

        @Override // android.view.ViewStub.OnInflateListener
        public void onInflate(ViewStub viewStub, View view) {
            c5.this.f12785zn = view;
            c5 c5Var = c5.this;
            c5Var.f12783n3 = gv.zn(c5Var.f12784v.f2394f3, view, viewStub.getLayoutResource());
            c5.this.y = null;
            if (c5.this.f12782gv != null) {
                c5.this.f12782gv.onInflate(viewStub, view);
                c5.this.f12782gv = null;
            }
            c5.this.f12784v.oa();
            c5.this.f12784v.tg();
        }
    }

    public c5(@NonNull ViewStub viewStub) {
        y yVar = new y();
        this.f12781a = yVar;
        this.y = viewStub;
        viewStub.setOnInflateListener(yVar);
    }

    @Nullable
    public ViewStub c5() {
        return this.y;
    }

    public void f(@NonNull ViewDataBinding viewDataBinding) {
        this.f12784v = viewDataBinding;
    }

    @Nullable
    public ViewDataBinding fb() {
        return this.f12783n3;
    }

    public boolean i9() {
        if (this.f12785zn != null) {
            return true;
        }
        return false;
    }

    public View s() {
        return this.f12785zn;
    }

    public void t(@Nullable ViewStub.OnInflateListener onInflateListener) {
        if (this.y != null) {
            this.f12782gv = onInflateListener;
        }
    }
}

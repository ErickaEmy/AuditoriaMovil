package w3;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: n3  reason: collision with root package name */
    public boolean f14531n3;
    @NonNull
    public final View y;

    /* renamed from: zn  reason: collision with root package name */
    public int f14532zn;

    public n3(y yVar) {
        this.y = (View) yVar;
    }

    public void a(int i) {
        this.f14532zn = i;
    }

    public void gv(@NonNull Bundle bundle) {
        this.f14531n3 = bundle.getBoolean("expanded", false);
        this.f14532zn = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f14531n3) {
            y();
        }
    }

    public int n3() {
        return this.f14532zn;
    }

    @NonNull
    public Bundle v() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f14531n3);
        bundle.putInt("expandedComponentIdHint", this.f14532zn);
        return bundle;
    }

    public final void y() {
        ViewParent parent = this.y.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).a(this.y);
        }
    }

    public boolean zn() {
        return this.f14531n3;
    }
}

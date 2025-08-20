package androidx.recyclerview.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public abstract class xc extends RecyclerView.tl {

    /* renamed from: fb  reason: collision with root package name */
    public boolean f3321fb = true;

    @Override // androidx.recyclerview.widget.RecyclerView.tl
    public boolean a(@NonNull RecyclerView.ta taVar) {
        if (this.f3321fb && !taVar.isInvalid()) {
            return false;
        }
        return true;
    }

    public final void a8(RecyclerView.ta taVar) {
        qn(taVar);
    }

    public final void b(RecyclerView.ta taVar) {
        j(taVar);
    }

    public final void d(RecyclerView.ta taVar) {
        yt(taVar);
    }

    public abstract boolean d0(RecyclerView.ta taVar);

    public final void ej(RecyclerView.ta taVar, boolean z2) {
        hw(taVar, z2);
    }

    public abstract boolean fh(RecyclerView.ta taVar, RecyclerView.ta taVar2, int i, int i5, int i6, int i8);

    @Override // androidx.recyclerview.widget.RecyclerView.tl
    public boolean gv(@NonNull RecyclerView.ta taVar, @NonNull RecyclerView.tl.zn znVar, @NonNull RecyclerView.tl.zn znVar2) {
        int i = znVar.y;
        int i5 = znVar2.y;
        if (i == i5 && znVar.f3141n3 == znVar2.f3141n3) {
            ud(taVar);
            return false;
        }
        return rz(taVar, i, znVar.f3141n3, i5, znVar2.f3141n3);
    }

    public void hw(RecyclerView.ta taVar, boolean z2) {
    }

    public void j(RecyclerView.ta taVar) {
    }

    public void j5(RecyclerView.ta taVar) {
    }

    public void k5(RecyclerView.ta taVar) {
    }

    public abstract boolean mg(RecyclerView.ta taVar);

    @Override // androidx.recyclerview.widget.RecyclerView.tl
    public boolean n3(@NonNull RecyclerView.ta taVar, @NonNull RecyclerView.ta taVar2, @NonNull RecyclerView.tl.zn znVar, @NonNull RecyclerView.tl.zn znVar2) {
        int i;
        int i5;
        int i6 = znVar.y;
        int i8 = znVar.f3141n3;
        if (taVar2.shouldIgnore()) {
            int i10 = znVar.y;
            i5 = znVar.f3141n3;
            i = i10;
        } else {
            i = znVar2.y;
            i5 = znVar2.f3141n3;
        }
        return fh(taVar, taVar2, i6, i8, i, i5);
    }

    public void o(RecyclerView.ta taVar) {
    }

    public void oz(boolean z2) {
        this.f3321fb = z2;
    }

    public void qn(RecyclerView.ta taVar) {
    }

    public abstract boolean rz(RecyclerView.ta taVar, int i, int i5, int i6, int i8);

    public final void ta(RecyclerView.ta taVar) {
        k5(taVar);
        s(taVar);
    }

    public final void ud(RecyclerView.ta taVar) {
        j5(taVar);
        s(taVar);
    }

    public void vl(RecyclerView.ta taVar, boolean z2) {
    }

    public final void x(RecyclerView.ta taVar) {
        o(taVar);
        s(taVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.tl
    public boolean y(@NonNull RecyclerView.ta taVar, @Nullable RecyclerView.tl.zn znVar, @NonNull RecyclerView.tl.zn znVar2) {
        int i;
        int i5;
        if (znVar != null && ((i = znVar.y) != (i5 = znVar2.y) || znVar.f3141n3 != znVar2.f3141n3)) {
            return rz(taVar, i, znVar.f3141n3, i5, znVar2.f3141n3);
        }
        return d0(taVar);
    }

    public void yt(RecyclerView.ta taVar) {
    }

    public final void z6(RecyclerView.ta taVar, boolean z2) {
        vl(taVar, z2);
        s(taVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.tl
    public boolean zn(@NonNull RecyclerView.ta taVar, @NonNull RecyclerView.tl.zn znVar, @Nullable RecyclerView.tl.zn znVar2) {
        int i;
        int i5;
        int i6 = znVar.y;
        int i8 = znVar.f3141n3;
        View view = taVar.itemView;
        if (znVar2 == null) {
            i = view.getLeft();
        } else {
            i = znVar2.y;
        }
        int i10 = i;
        if (znVar2 == null) {
            i5 = view.getTop();
        } else {
            i5 = znVar2.f3141n3;
        }
        int i11 = i5;
        if (!taVar.isRemoved() && (i6 != i10 || i8 != i11)) {
            view.layout(i10, i11, view.getWidth() + i10, view.getHeight() + i11);
            return rz(taVar, i6, i8, i10, i11);
        }
        return mg(taVar);
    }
}

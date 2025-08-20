package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public abstract class w extends RecyclerView.co {

    /* renamed from: n3  reason: collision with root package name */
    public Scroller f3317n3;
    public RecyclerView y;

    /* renamed from: zn  reason: collision with root package name */
    public final RecyclerView.r f3318zn = new y();

    /* loaded from: classes.dex */
    public class n3 extends s {
        public n3(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.s
        public float x4(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.s, androidx.recyclerview.widget.RecyclerView.d0
        public void xc(View view, RecyclerView.fh fhVar, RecyclerView.d0.y yVar) {
            w wVar = w.this;
            RecyclerView recyclerView = wVar.y;
            if (recyclerView == null) {
                return;
            }
            int[] zn2 = wVar.zn(recyclerView.getLayoutManager(), view);
            int i = zn2[0];
            int i5 = zn2[1];
            int i42 = i4(Math.max(Math.abs(i), Math.abs(i5)));
            if (i42 > 0) {
                yVar.gv(i, i5, i42, this.f3273i9);
            }
        }
    }

    /* loaded from: classes.dex */
    public class y extends RecyclerView.r {
        public boolean y;

        public y() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void n3(RecyclerView recyclerView, int i, int i5) {
            if (i != 0 || i5 != 0) {
                this.y = true;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void y(RecyclerView recyclerView, int i) {
            super.y(recyclerView, i);
            if (i == 0 && this.y) {
                this.y = false;
                w.this.f();
            }
        }
    }

    public final void a() {
        this.y.removeOnScrollListener(this.f3318zn);
        this.y.setOnFlingListener(null);
    }

    public final void c5() throws IllegalStateException {
        if (this.y.getOnFlingListener() == null) {
            this.y.addOnScrollListener(this.f3318zn);
            this.y.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    public void f() {
        RecyclerView.w layoutManager;
        View fb2;
        RecyclerView recyclerView = this.y;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (fb2 = fb(layoutManager)) == null) {
            return;
        }
        int[] zn2 = zn(layoutManager, fb2);
        int i = zn2[0];
        if (i != 0 || zn2[1] != 0) {
            this.y.smoothScrollBy(i, zn2[1]);
        }
    }

    @Nullable
    public abstract View fb(RecyclerView.w wVar);

    @Nullable
    public RecyclerView.d0 gv(@NonNull RecyclerView.w wVar) {
        return v(wVar);
    }

    public final boolean i9(@NonNull RecyclerView.w wVar, int i, int i5) {
        RecyclerView.d0 gv2;
        int s2;
        if (!(wVar instanceof RecyclerView.d0.n3) || (gv2 = gv(wVar)) == null || (s2 = s(wVar, i, i5)) == -1) {
            return false;
        }
        gv2.w(s2);
        wVar.vb(gv2);
        return true;
    }

    public void n3(@Nullable RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.y;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            a();
        }
        this.y = recyclerView;
        if (recyclerView != null) {
            c5();
            this.f3317n3 = new Scroller(this.y.getContext(), new DecelerateInterpolator());
            f();
        }
    }

    public abstract int s(RecyclerView.w wVar, int i, int i5);

    @Nullable
    @Deprecated
    public s v(@NonNull RecyclerView.w wVar) {
        if (!(wVar instanceof RecyclerView.d0.n3)) {
            return null;
        }
        return new n3(this.y.getContext());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.co
    public boolean y(int i, int i5) {
        RecyclerView.w layoutManager = this.y.getLayoutManager();
        if (layoutManager == null || this.y.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.y.getMinFlingVelocity();
        if ((Math.abs(i5) <= minFlingVelocity && Math.abs(i) <= minFlingVelocity) || !i9(layoutManager, i, i5)) {
            return false;
        }
        return true;
    }

    @Nullable
    public abstract int[] zn(@NonNull RecyclerView.w wVar, @NonNull View view);
}

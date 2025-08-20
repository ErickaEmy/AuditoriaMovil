package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import hw.i4;
import java.util.List;
@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.zn<View> {
    public int y;

    /* loaded from: classes.dex */
    public class y implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ w3.y f6127fb;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ int f6129v;
        public final /* synthetic */ View y;

        public y(View view, int i, w3.y yVar) {
            this.y = view;
            this.f6129v = i;
            this.f6127fb = yVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.y.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.y == this.f6129v) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                w3.y yVar = this.f6127fb;
                expandableBehavior.ej((View) yVar, this.y, yVar.y(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
    }

    public final boolean d(boolean z2) {
        if (z2) {
            int i = this.y;
            if (i != 0 && i != 2) {
                return false;
            }
            return true;
        } else if (this.y != 1) {
            return false;
        } else {
            return true;
        }
    }

    public abstract boolean ej(View view, View view2, boolean z2, boolean z3);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public boolean s(CoordinatorLayout coordinatorLayout, View view, View view2) {
        int i;
        w3.y yVar = (w3.y) view2;
        if (d(yVar.y())) {
            if (yVar.y()) {
                i = 1;
            } else {
                i = 2;
            }
            this.y = i;
            return ej((View) yVar, view, yVar.y(), true);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i) {
        w3.y z62;
        int i5;
        if (!i4.q9(view) && (z62 = z6(coordinatorLayout, view)) != null && d(z62.y())) {
            if (z62.y()) {
                i5 = 1;
            } else {
                i5 = 2;
            }
            this.y = i5;
            view.getViewTreeObserver().addOnPreDrawListener(new y(view, i5, z62));
            return false;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public abstract boolean v(CoordinatorLayout coordinatorLayout, View view, View view2);

    @Nullable
    public w3.y z6(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
        List<View> mt2 = coordinatorLayout.mt(view);
        int size = mt2.size();
        for (int i = 0; i < size; i++) {
            View view2 = mt2.get(i);
            if (v(coordinatorLayout, view, view2)) {
                return (w3.y) view2;
            }
        }
        return null;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

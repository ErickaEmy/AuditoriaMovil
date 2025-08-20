package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.zn<V> {
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public ViewPropertyAnimator f5397gv;

    /* renamed from: n3  reason: collision with root package name */
    public int f5398n3;
    public int y;

    /* renamed from: zn  reason: collision with root package name */
    public int f5399zn;

    /* loaded from: classes.dex */
    public class y extends AnimatorListenerAdapter {
        public y() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f5397gv = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.f5398n3 = 2;
    }

    public final void d(@NonNull V v2, int i, long j2, TimeInterpolator timeInterpolator) {
        this.f5397gv = v2.animate().translationY(i).setInterpolator(timeInterpolator).setDuration(j2).setListener(new y());
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public boolean d0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, @NonNull View view2, int i, int i5) {
        return i == 2;
    }

    public void ej(@NonNull V v2) {
        if (this.f5398n3 == 1) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f5397gv;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v2.clearAnimation();
        }
        this.f5398n3 = 1;
        d(v2, this.y + this.f5399zn, 175L, y6.y.f15327zn);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, int i) {
        this.y = v2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v2.getLayoutParams()).bottomMargin;
        return super.t(coordinatorLayout, v2, i);
    }

    public void ud(@NonNull V v2) {
        if (this.f5398n3 == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f5397gv;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v2.clearAnimation();
        }
        this.f5398n3 = 2;
        d(v2, 0, 225L, y6.y.f15324gv);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public void z(CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, int i, int i5, int i6, int i8, int i10, @NonNull int[] iArr) {
        if (i5 > 0) {
            ej(v2);
        } else if (i5 < 0) {
            ud(v2);
        }
    }

    public void z6(@NonNull V v2, int i) {
        this.f5399zn = i;
        if (this.f5398n3 == 1) {
            v2.setTranslationY(this.y + i);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5398n3 = 2;
    }
}

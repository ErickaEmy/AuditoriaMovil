package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
import y6.c5;
import y6.n3;
@Deprecated
/* loaded from: classes.dex */
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {

    /* renamed from: gv  reason: collision with root package name */
    public final c5 f6145gv;

    /* renamed from: zn  reason: collision with root package name */
    public final c5 f6146zn;

    /* loaded from: classes.dex */
    public class y extends AnimatorListenerAdapter {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ View f6147n3;
        public final /* synthetic */ boolean y;

        public y(boolean z2, View view) {
            this.y = z2;
            this.f6147n3 = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.y) {
                this.f6147n3.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.y) {
                this.f6147n3.setVisibility(0);
            }
        }
    }

    public FabTransformationScrimBehavior() {
        this.f6146zn = new c5(75L, 150L);
        this.f6145gv = new c5(0L, 150L);
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    public AnimatorSet a8(@NonNull View view, @NonNull View view2, boolean z2, boolean z3) {
        ArrayList arrayList = new ArrayList();
        x(view2, z2, z3, arrayList, new ArrayList());
        AnimatorSet animatorSet = new AnimatorSet();
        n3.y(animatorSet, arrayList);
        animatorSet.addListener(new y(z2, view2));
        return animatorSet;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public boolean mg(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
        return super.mg(coordinatorLayout, view, motionEvent);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public boolean v(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    public final void x(@NonNull View view, boolean z2, boolean z3, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        c5 c5Var;
        ObjectAnimator ofFloat;
        if (z2) {
            c5Var = this.f6146zn;
        } else {
            c5Var = this.f6145gv;
        }
        if (z2) {
            if (!z3) {
                view.setAlpha(0.0f);
            }
            ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f);
        }
        c5Var.y(ofFloat);
        list.add(ofFloat);
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6146zn = new c5(75L, 150L);
        this.f6145gv = new c5(0L, 150L);
    }
}

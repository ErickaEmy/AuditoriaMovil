package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public AnimatorSet f6130n3;

    /* loaded from: classes.dex */
    public class y extends AnimatorListenerAdapter {
        public y() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ExpandableTransformationBehavior.this.f6130n3 = null;
        }
    }

    public ExpandableTransformationBehavior() {
    }

    @NonNull
    public abstract AnimatorSet a8(View view, View view2, boolean z2, boolean z3);

    @Override // com.google.android.material.transformation.ExpandableBehavior
    public boolean ej(View view, View view2, boolean z2, boolean z3) {
        boolean z4;
        AnimatorSet animatorSet = this.f6130n3;
        if (animatorSet != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            animatorSet.cancel();
        }
        AnimatorSet a82 = a8(view, view2, z2, z4);
        this.f6130n3 = a82;
        a82.addListener(new y());
        this.f6130n3.start();
        if (!z3) {
            this.f6130n3.end();
        }
        return true;
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

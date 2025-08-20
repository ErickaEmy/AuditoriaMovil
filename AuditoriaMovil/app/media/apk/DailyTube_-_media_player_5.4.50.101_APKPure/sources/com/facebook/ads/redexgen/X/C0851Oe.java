package com.facebook.ads.redexgen.X;

import android.animation.ValueAnimator;
import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Oe  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0851Oe implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ TT A00;

    public C0851Oe(TT tt) {
        this.A00 = tt;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        View view2;
        view = this.A00.A0A;
        view.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        view2 = this.A00.A0A;
        view2.requestLayout();
    }
}

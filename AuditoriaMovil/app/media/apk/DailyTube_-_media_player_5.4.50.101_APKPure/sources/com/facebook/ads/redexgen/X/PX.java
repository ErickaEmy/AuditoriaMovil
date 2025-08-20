package com.facebook.ads.redexgen.X;

import android.animation.ValueAnimator;
/* loaded from: assets/audience_network.dex */
public class PX implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ C0974Sx A00;

    public PX(C0974Sx c0974Sx) {
        this.A00 = c0974Sx;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SA sa;
        SA sa2;
        sa = this.A00.A0Z;
        sa.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        sa2 = this.A00.A0Z;
        sa2.requestLayout();
    }
}

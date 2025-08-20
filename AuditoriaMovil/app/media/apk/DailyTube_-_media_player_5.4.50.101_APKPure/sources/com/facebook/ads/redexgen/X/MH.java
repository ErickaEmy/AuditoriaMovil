package com.facebook.ads.redexgen.X;

import android.view.animation.Animation;
/* loaded from: assets/audience_network.dex */
public class MH implements Animation.AnimationListener {
    public final /* synthetic */ View$OnClickListenerC0544Bi A00;

    public MH(View$OnClickListenerC0544Bi view$OnClickListenerC0544Bi) {
        this.A00 = view$OnClickListenerC0544Bi;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        ((UT) this.A00).A07.finish(16);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}

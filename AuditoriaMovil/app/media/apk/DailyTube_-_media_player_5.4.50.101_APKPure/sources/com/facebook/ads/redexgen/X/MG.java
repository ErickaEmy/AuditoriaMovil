package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.view.animation.Animation;
/* loaded from: assets/audience_network.dex */
public class MG implements Animation.AnimationListener {
    public final /* synthetic */ View$OnClickListenerC0544Bi A00;

    public MG(View$OnClickListenerC0544Bi view$OnClickListenerC0544Bi) {
        this.A00 = view$OnClickListenerC0544Bi;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        int i;
        Handler handler;
        Runnable runnable;
        int i5;
        this.A00.A06();
        i = this.A00.A04;
        if (i > 0) {
            handler = this.A00.A05;
            runnable = this.A00.A07;
            i5 = this.A00.A04;
            handler.postDelayed(runnable, i5);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}

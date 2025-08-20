package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.view.animation.Animation;
/* loaded from: assets/audience_network.dex */
public class MO implements Animation.AnimationListener {
    public final /* synthetic */ C5V A00;
    public final /* synthetic */ UL A01;
    public final /* synthetic */ UL A02;

    public MO(UL ul, UL ul2, C5V c5v) {
        this.A01 = ul;
        this.A02 = ul2;
        this.A00 = c5v;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.A01.A04 = false;
        AbstractC0783Lo.A0H(this.A02);
        new Handler().postDelayed(new UO(this), 200L);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}

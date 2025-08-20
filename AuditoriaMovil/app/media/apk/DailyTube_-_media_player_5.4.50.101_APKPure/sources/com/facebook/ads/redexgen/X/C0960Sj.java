package com.facebook.ads.redexgen.X;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
/* renamed from: com.facebook.ads.redexgen.X.Sj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0960Sj extends KT {
    public final /* synthetic */ InterfaceC0878Pf A00;
    public final /* synthetic */ C0879Pg A01;

    public C0960Sj(C0879Pg c0879Pg, InterfaceC0878Pf interfaceC0878Pf) {
        this.A01 = c0879Pg;
        this.A00 = interfaceC0878Pf;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setAnimationListener(new C0961Sk(this));
        this.A01.startAnimation(alphaAnimation);
    }
}

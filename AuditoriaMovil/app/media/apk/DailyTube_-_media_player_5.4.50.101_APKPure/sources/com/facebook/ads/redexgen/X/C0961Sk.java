package com.facebook.ads.redexgen.X;

import android.view.animation.Animation;
/* renamed from: com.facebook.ads.redexgen.X.Sk  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0961Sk extends animation.Animation$AnimationListenerC0782Ln {
    public final /* synthetic */ C0960Sj A00;

    public C0961Sk(C0960Sj c0960Sj) {
        this.A00 = c0960Sj;
    }

    @Override // com.facebook.ads.redexgen.X.animation.Animation$AnimationListenerC0782Ln, android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        AbstractC0783Lo.A0H(this.A00.A01);
        this.A00.A00.ABu();
    }
}

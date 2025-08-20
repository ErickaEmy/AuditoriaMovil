package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* renamed from: com.facebook.ads.redexgen.X.Of  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0852Of extends AnimatorListenerAdapter {
    public final /* synthetic */ TT A00;
    public final /* synthetic */ boolean A01;

    public C0852Of(TT tt, boolean z2) {
        this.A00 = tt;
        this.A01 = z2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        C0861Oo c0861Oo;
        KP kp2;
        KP kp3;
        U1 u1;
        U1 u12;
        super.onAnimationEnd(animator);
        c0861Oo = this.A00.A0M;
        c0861Oo.setTranslationY(0.0f);
        this.A00.A0U();
        if (!this.A01) {
            u1 = this.A00.A0J;
            if (u1 != null) {
                u12 = this.A00.A0J;
                u12.destroy();
            }
        }
        kp2 = this.A00.A0g;
        if (kp2 == null) {
            return;
        }
        kp3 = this.A00.A0g;
        kp3.setVisibility(this.A01 ? 8 : 0);
    }
}

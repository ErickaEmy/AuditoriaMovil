package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Qr  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0916Qr implements Animator.AnimatorListener {
    public final /* synthetic */ KA A00;

    public C0916Qr(KA ka) {
        this.A00 = ka;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.A00.A09(false);
        this.A00.A04();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        View view;
        this.A00.A01 = EnumC0907Qi.A05;
        view = this.A00.A05;
        AbstractC0783Lo.A0H(view);
        this.A00.A04();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}

package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.ValueAnimator;
/* renamed from: com.facebook.ads.redexgen.X.Qp  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0914Qp implements Animator.AnimatorListener {
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ KC A02;

    public C0914Qp(KC kc, int i, int i5) {
        this.A02 = kc;
        this.A01 = i;
        this.A00 = i5;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        this.A02.A07(this.A00, this.A01, false);
        valueAnimator = this.A02.A00;
        if (valueAnimator != null) {
            valueAnimator2 = this.A02.A00;
            valueAnimator2.removeAllListeners();
            this.A02.A00 = null;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i;
        EnumC0907Qi enumC0907Qi;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        KC kc = this.A02;
        int i5 = this.A01;
        i = kc.A04;
        if (i5 == i) {
            enumC0907Qi = EnumC0907Qi.A03;
        } else {
            enumC0907Qi = EnumC0907Qi.A05;
        }
        kc.A01 = enumC0907Qi;
        valueAnimator = this.A02.A00;
        if (valueAnimator != null) {
            valueAnimator2 = this.A02.A00;
            valueAnimator2.removeAllListeners();
            this.A02.A00 = null;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}

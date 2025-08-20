package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
/* renamed from: com.facebook.ads.redexgen.X.Qn  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0912Qn extends AnimatorListenerAdapter {
    public static String[] A01 = {"3J5cDVad4mW9vkElMc3OsUS7r8EZlE39", "h6bRkPy553bCAy1amrHUM8RqxgIOW2o8", "fpksqhdo9EiL3TJLaFmG7oCu1r9K", "lJjW0qitu5NILdXsS3BRz5RQsDn5loSa", "jrjPtqo2TtT08iP8QxuH9QitSJIqaNJp", "hUMcZshotDkSaD7wdQ9kJfmyHpwJvjMA", "tSCKCWomP5vbOsQQ1Yiozev7D3nD5ATQ", "aWL5kyBMd9kZhCXXBXyyL0Q3N4I1ZWNc"};
    public final /* synthetic */ KF A00;

    public C0912Qn(KF kf) {
        this.A00 = kf;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        boolean z2;
        View view;
        ViewPropertyAnimator viewPropertyAnimator;
        ViewPropertyAnimator viewPropertyAnimator2;
        View view2;
        z2 = this.A00.A04;
        if (z2) {
            view2 = this.A00.A03;
            String[] strArr = A01;
            if (strArr[7].charAt(14) != strArr[3].charAt(14)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[1] = "5h3ewWtRejeXOmvUGpWApkn5USeyTQr7";
            strArr2[6] = "VmmYRwr0EoTUCeedPY4atWiJqM07FMep";
            AbstractC0783Lo.A0H(view2);
        }
        view = this.A00.A03;
        view.setAlpha(0.0f);
        this.A00.A01 = EnumC0907Qi.A05;
        viewPropertyAnimator = this.A00.A00;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator2 = this.A00.A00;
            viewPropertyAnimator2.setListener(null);
            this.A00.A00 = null;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ViewPropertyAnimator viewPropertyAnimator;
        ViewPropertyAnimator viewPropertyAnimator2;
        this.A00.A01 = EnumC0907Qi.A03;
        viewPropertyAnimator = this.A00.A00;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator2 = this.A00.A00;
            viewPropertyAnimator2.setListener(null);
            this.A00.A00 = null;
        }
    }
}

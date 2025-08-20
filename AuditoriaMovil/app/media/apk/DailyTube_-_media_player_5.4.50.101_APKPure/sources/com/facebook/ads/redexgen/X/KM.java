package com.facebook.ads.redexgen.X;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.view.View;
/* loaded from: assets/audience_network.dex */
public final class KM implements InterfaceC0908Qj {
    public TransitionDrawable A00;
    public TransitionDrawable A01;
    public final int A03;
    public final Drawable A04;
    public final Drawable A05;
    public final View A07;
    public final Handler A06 = new Handler();
    public EnumC0907Qi A02 = EnumC0907Qi.A05;

    public KM(View view, int i, Drawable drawable, Drawable drawable2) {
        this.A03 = i;
        this.A07 = view;
        this.A05 = drawable;
        this.A04 = drawable2;
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawable, drawable2});
        this.A01 = transitionDrawable;
        transitionDrawable.setCrossFadeEnabled(true);
        TransitionDrawable transitionDrawable2 = new TransitionDrawable(new Drawable[]{drawable2, drawable});
        this.A00 = transitionDrawable2;
        transitionDrawable2.setCrossFadeEnabled(true);
        AbstractC0783Lo.A0S(view, this.A01);
    }

    private void A04(boolean z2) {
        this.A06.removeCallbacksAndMessages(null);
        if (z2) {
            this.A02 = EnumC0907Qi.A06;
            AbstractC0783Lo.A0S(this.A07, this.A00);
            this.A00.startTransition(this.A03);
            this.A06.postDelayed(new KN(this), this.A03);
            return;
        }
        AbstractC0783Lo.A0S(this.A07, this.A05);
        this.A02 = EnumC0907Qi.A05;
    }

    private void A05(boolean z2) {
        this.A06.removeCallbacksAndMessages(null);
        if (z2) {
            this.A02 = EnumC0907Qi.A04;
            AbstractC0783Lo.A0S(this.A07, this.A01);
            this.A01.startTransition(this.A03);
            this.A06.postDelayed(new KO(this), this.A03);
            return;
        }
        AbstractC0783Lo.A0S(this.A07, this.A04);
        this.A02 = EnumC0907Qi.A03;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0908Qj
    public final void A3Y(boolean z2, boolean z3) {
        if (z3) {
            A04(z2);
        } else {
            A05(z2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0908Qj
    public final EnumC0907Qi A82() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0908Qj
    public final void cancel() {
        EnumC0907Qi enumC0907Qi;
        this.A06.removeCallbacksAndMessages(null);
        this.A01.resetTransition();
        this.A00.resetTransition();
        if (this.A02 == EnumC0907Qi.A04) {
            enumC0907Qi = EnumC0907Qi.A05;
        } else {
            enumC0907Qi = EnumC0907Qi.A03;
        }
        this.A02 = enumC0907Qi;
    }
}

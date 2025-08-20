package com.facebook.ads.redexgen.X;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: assets/audience_network.dex */
public final class KI implements InterfaceC0908Qj {
    public int A00;
    public ValueAnimator A01;
    public EnumC0907Qi A02 = EnumC0907Qi.A05;
    public final int A03;
    public final int A04;
    public final View A05;

    public KI(View view, int i, int i5, int i6) {
        this.A05 = view;
        this.A03 = i;
        this.A00 = i5;
        this.A04 = i6;
    }

    private ValueAnimator A00(int i, int i5, View view) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i5);
        ofInt.setDuration(this.A03);
        ofInt.addUpdateListener(new C0911Qm(this, view));
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(boolean z2) {
        if (z2) {
            this.A02 = EnumC0907Qi.A06;
            ValueAnimator A00 = A00(this.A00, this.A04, this.A05);
            this.A01 = A00;
            A00.addListener(new C0910Ql(this));
            this.A01.start();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.A05.getLayoutParams();
        layoutParams.height = this.A04;
        this.A05.setLayoutParams(layoutParams);
        AbstractC0783Lo.A0H(this.A05);
        this.A02 = EnumC0907Qi.A05;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08(boolean z2) {
        AbstractC0783Lo.A0L(this.A05);
        if (z2) {
            this.A02 = EnumC0907Qi.A04;
            ValueAnimator A00 = A00(this.A04, this.A00, this.A05);
            this.A01 = A00;
            A00.addListener(new C0909Qk(this));
            this.A01.start();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.A05.getLayoutParams();
        layoutParams.height = this.A00;
        this.A05.setLayoutParams(layoutParams);
        this.A02 = EnumC0907Qi.A03;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0908Qj
    public final void A3Y(boolean z2, boolean z3) {
        if (z3) {
            A07(z2);
        } else {
            A08(z2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0908Qj
    public final EnumC0907Qi A82() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0908Qj
    public final void cancel() {
        ValueAnimator valueAnimator = this.A01;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}

package com.facebook.ads.redexgen.X;

import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: assets/audience_network.dex */
public final class KA implements InterfaceC0908Qj {
    public static String[] A06 = {"Zp1jBMTXyTngXAjRlLP1q6RZbaUI", "nHljDkT3i8Wirocu51jroGsoJHOhv1cR", "sP6X6aS", "KZL6M4", "KoOjzqZIxieUbLbPf8D", "B1jmqrSafv9jI6Lw73IRSYcL6IlnF6YH", "FLN3m70EKIfdw8", "ppmNyXlbfQKy53gkSU0tUatt7Y3PBdXb"};
    public ValueAnimator A00;
    public EnumC0907Qi A01 = EnumC0907Qi.A05;
    public final int A02;
    public final int A03;
    public final int A04;
    public final View A05;

    public KA(View view, int i, int i5, int i6) {
        this.A05 = view;
        this.A02 = i;
        this.A04 = i5;
        this.A03 = i6;
    }

    private ValueAnimator A00(View view, int i, int i5) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i5);
        ofInt.setDuration(this.A02);
        ofInt.addUpdateListener(new C0917Qs(this, view));
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        ValueAnimator valueAnimator = this.A00;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            if (A06[1].charAt(28) != 'v') {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[7] = "75AaLozsvbqC7RPKNa9MBDOQqsQ1eQ5U";
            strArr[5] = "oWQ9IgFva7oIaP1s8z2NxAvwjcynmKEe";
            this.A00 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08(boolean z2) {
        if (z2) {
            this.A01 = EnumC0907Qi.A06;
            ValueAnimator A00 = A00(this.A05, this.A03, this.A04);
            this.A00 = A00;
            A00.addListener(new C0916Qr(this));
            this.A00.start();
            return;
        }
        this.A05.setTranslationY(this.A04);
        AbstractC0783Lo.A0H(this.A05);
        this.A01 = EnumC0907Qi.A05;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09(boolean z2) {
        AbstractC0783Lo.A0L(this.A05);
        if (z2) {
            this.A01 = EnumC0907Qi.A04;
            ValueAnimator A00 = A00(this.A05, this.A04, this.A03);
            this.A00 = A00;
            A00.addListener(new C0915Qq(this));
            this.A00.start();
            return;
        }
        View view = this.A05;
        if (A06[1].charAt(28) != 'v') {
            throw new RuntimeException();
        }
        A06[4] = "CRQ3If4kF9c";
        view.setTranslationY(this.A03);
        this.A01 = EnumC0907Qi.A03;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0908Qj
    public final void A3Y(boolean z2, boolean z3) {
        if (z3) {
            A08(z2);
        } else {
            A09(z2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0908Qj
    public final EnumC0907Qi A82() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0908Qj
    public final void cancel() {
        ValueAnimator valueAnimator = this.A00;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}

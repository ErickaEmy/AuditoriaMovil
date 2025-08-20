package com.facebook.ads.redexgen.X;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.TextView;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class KC implements InterfaceC0908Qj {
    public static byte[] A06;
    public static String[] A07 = {"A7BI5", "gKWOMBrJHuMwvM90e1kQxbLVjOWHbC33", "UYN9ptwwhG6kseDSIUjMW4tKOOJXD2Z7", "Ja75eMPfNEu2gmMNMrA6", "IMMQ3U1D8CAOequczoeO", "aOtgKGua3vuGYyvCOzm8c8DJStBVo0w", "j", "V23k2coZlnHKKs"};
    public ValueAnimator A00;
    public EnumC0907Qi A01 = EnumC0907Qi.A05;
    public final int A02;
    public final int A03;
    public final int A04;
    public final View A05;

    public static String A04(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 98);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A06 = new byte[]{40, 25, 44, 40, -9, 35, 32, 35, 38};
    }

    static {
        A05();
    }

    public KC(View view, int i, int i5, int i6) {
        this.A02 = i;
        this.A05 = view;
        this.A04 = i5;
        this.A03 = i6;
    }

    private void A06(int i, int i5) {
        this.A01 = i == this.A04 ? EnumC0907Qi.A04 : EnumC0907Qi.A06;
        ObjectAnimator ofInt = ObjectAnimator.ofInt((TextView) this.A05, A04(0, 9, 82), i, i5);
        this.A00 = ofInt;
        ofInt.setEvaluator(new ArgbEvaluator());
        this.A00.setDuration(this.A02);
        this.A00.addListener(new C0914Qp(this, i, i5));
        this.A00.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(int i, int i5, boolean z2) {
        if (z2) {
            A06(i, i5);
            return;
        }
        View view = this.A05;
        if (A07[4].length() != 20) {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[7] = "Y4rCa4lywlEdVv";
        strArr[0] = "Hdg5N";
        ((TextView) view).setTextColor(i5);
        this.A01 = i5 == this.A03 ? EnumC0907Qi.A03 : EnumC0907Qi.A05;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0908Qj
    public final void A3Y(boolean z2, boolean z3) {
        int endColor = z3 ? this.A03 : this.A04;
        int startColor = z3 ? this.A04 : this.A03;
        A07(endColor, startColor, z2);
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

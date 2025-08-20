package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewPropertyAnimator;
/* loaded from: assets/audience_network.dex */
public final class KF implements InterfaceC0908Qj {
    public static String[] A05 = {"hBpWhHnhmL5X5T638nUqTTajkmWXq0Jo", "NpDFSQumXtRd9HWL09JYgYkJkV27cWXf", "AxBlHN1IgfTmgBmsQuewVQ8cZkGbRxm7", "auJ8KOWij5XUc2OVh7MwLzJgAA213fGo", "l76sAXRLIUx67IYksgmFi2YoLkAbbgnJ", "1g5g87wiu8KgxwL4MK6lukjj0pQl5xRt", "P6OmLQzTnVk1JPGEjhdY9fnbkCpMcnWe", "QfRSCgXdOTNJYzcBVbNAL0t7GjPIPusf"};
    public ViewPropertyAnimator A00;
    public EnumC0907Qi A01 = EnumC0907Qi.A05;
    public final int A02;
    public final View A03;
    public final boolean A04;

    public KF(View view, int i, boolean z2) {
        this.A02 = i;
        this.A03 = view;
        this.A04 = z2;
    }

    private void A04(boolean z2) {
        this.A01 = EnumC0907Qi.A04;
        if (this.A04) {
            AbstractC0783Lo.A0L(this.A03);
        }
        String[] strArr = A05;
        if (strArr[4].charAt(27) != strArr[2].charAt(27)) {
            throw new RuntimeException();
        }
        A05[0] = "iTCONHrR5nymrEIlx0VHUpGctJrwflIU";
        if (!z2) {
            this.A03.setAlpha(1.0f);
            this.A01 = EnumC0907Qi.A03;
            return;
        }
        this.A00 = this.A03.animate().alpha(1.0f).setDuration(this.A02).setListener(new C0912Qn(this));
    }

    private void A05(boolean z2) {
        this.A01 = EnumC0907Qi.A06;
        if (z2) {
            this.A00 = this.A03.animate().alpha(0.0f).setDuration(this.A02).setListener(new C0913Qo(this));
            return;
        }
        View view = this.A03;
        if (A05[3].charAt(11) != 'U') {
            throw new RuntimeException();
        }
        A05[1] = "Va1KnH22vapH99C3A8HUoUYkLtllReKa";
        view.setAlpha(0.0f);
        this.A01 = EnumC0907Qi.A05;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0908Qj
    public final void A3Y(boolean z2, boolean z3) {
        if (z3) {
            A05(z2);
        } else {
            A04(z2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0908Qj
    public final EnumC0907Qi A82() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0908Qj
    public final void cancel() {
        this.A03.clearAnimation();
        ViewPropertyAnimator viewPropertyAnimator = this.A00;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }
}

package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.9k  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C04959k {
    public int A00;
    public int A01;
    public C05069w A02;
    public boolean A03;

    public C04959k() {
    }

    public final void A03(int i) {
        this.A01 += i;
    }

    public final void A04(int i) {
        if (this.A03 && this.A00 != 4) {
            AbstractC0672Ha.A03(i == 4);
            return;
        }
        this.A03 = true;
        this.A00 = i;
    }

    public final void A05(C05069w c05069w) {
        this.A02 = c05069w;
        this.A01 = 0;
        this.A03 = false;
    }

    public final boolean A06(C05069w c05069w) {
        return c05069w != this.A02 || this.A01 > 0 || this.A03;
    }
}

package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.8P  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C8P extends O7 {
    public final /* synthetic */ LX A00;

    public C8P(LX lx) {
        this.A00 = lx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC04788s
    /* renamed from: A00 */
    public final void A03(O8 o8) {
        if (LX.A07(this.A00) && LX.A08(this.A00)) {
            LX.A0B(this.A00, false);
            if (LX.A0A(this.A00, EnumC0907Qi.A04) || LX.A09(this.A00)) {
                LX.A0C(this.A00, false);
                LX.A01(this.A00).postDelayed(new C0781Lm(this), LX.A00(this.A00));
            } else if (!LX.A0A(this.A00, EnumC0907Qi.A03)) {
            } else {
                LX.A04(this.A00);
                LX.A05(this.A00, true, true);
            }
        }
    }
}

package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class ZC extends KG {
    public final /* synthetic */ ZB A00;

    public ZC(ZB zb) {
        this.A00 = zb;
    }

    @Override // com.facebook.ads.redexgen.X.KG
    public final void A01() {
        C04055m c04055m;
        C04055m c04055m2;
        c04055m = this.A00.A01.A00;
        if (c04055m.A00() != null) {
            c04055m2 = this.A00.A01.A00;
            c04055m2.A00().onAdsLoaded();
        }
    }
}

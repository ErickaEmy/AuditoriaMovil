package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class ZD extends KG {
    public final /* synthetic */ ZA A00;
    public final /* synthetic */ C0722Jb A01;

    public ZD(ZA za, C0722Jb c0722Jb) {
        this.A00 = za;
        this.A01 = c0722Jb;
    }

    @Override // com.facebook.ads.redexgen.X.KG
    public final void A01() {
        C04055m c04055m;
        C04055m c04055m2;
        c04055m = this.A00.A00;
        if (c04055m.A00() != null) {
            c04055m2 = this.A00.A00;
            c04055m2.A00().onAdError(L1.A00(this.A01));
        }
    }
}

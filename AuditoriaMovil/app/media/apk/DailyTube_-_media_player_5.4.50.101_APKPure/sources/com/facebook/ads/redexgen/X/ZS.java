package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdListener;
/* loaded from: assets/audience_network.dex */
public class ZS extends KG {
    public final /* synthetic */ ZQ A00;

    public ZS(ZQ zq) {
        this.A00 = zq;
    }

    @Override // com.facebook.ads.redexgen.X.KG
    public final void A01() {
        C5P c5p;
        C5P c5p2;
        C5P c5p3;
        c5p = this.A00.A01;
        if (c5p.A06() != null) {
            c5p2 = this.A00.A01;
            AdListener A06 = c5p2.A06();
            c5p3 = this.A00.A01;
            A06.onAdClicked(c5p3.A07());
        }
    }
}

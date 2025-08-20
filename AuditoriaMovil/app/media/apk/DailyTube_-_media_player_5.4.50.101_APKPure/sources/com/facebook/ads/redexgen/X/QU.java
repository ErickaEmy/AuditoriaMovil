package com.facebook.ads.redexgen.X;

import java.util.Map;
/* loaded from: assets/audience_network.dex */
public class QU extends C2P {
    public final /* synthetic */ QS A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QU(QS qs, double d2, double d3, double d4, boolean z2) {
        super(d2, d3, d4, z2);
        this.A00 = qs;
    }

    @Override // com.facebook.ads.redexgen.X.C2P
    public final void A00(boolean z2, boolean z3, C2R c2r) {
        String str;
        Map A0I;
        if (z3) {
            QS qs = this.A00;
            str = qs.A0C;
            A0I = this.A00.A0I(QG.A03);
            qs.A0Q(str, A0I);
        }
    }
}

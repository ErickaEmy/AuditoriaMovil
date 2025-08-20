package com.facebook.ads.redexgen.X;

import android.os.Handler;
/* loaded from: assets/audience_network.dex */
public class SE extends KT {
    public final /* synthetic */ SA A00;

    public SE(SA sa) {
        this.A00 = sa;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        boolean z2;
        C04778r c04778r;
        Handler handler;
        int i;
        z2 = this.A00.A03;
        if (!z2) {
            c04778r = this.A00.A0B;
            final int currentPositionInMillis = this.A00.getCurrentPositionInMillis();
            c04778r.A02(new AbstractC0894Pv(currentPositionInMillis) { // from class: com.facebook.ads.redexgen.X.93
            });
            handler = this.A00.A07;
            i = this.A00.A00;
            handler.postDelayed(this, i);
        }
    }
}

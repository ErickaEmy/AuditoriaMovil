package com.facebook.ads.redexgen.X;

import java.io.IOException;
/* loaded from: assets/audience_network.dex */
public final class WS implements FB {
    public final int A00;
    public final /* synthetic */ CD A01;

    public WS(CD cd, int i) {
        this.A01 = cd;
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.X.FB
    public final boolean A9C() {
        return this.A01.A0S(this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.FB
    public final void AAM() throws IOException {
        this.A01.A0Q();
    }

    @Override // com.facebook.ads.redexgen.X.FB
    public final int AEK(C04999p c04999p, C1094Xr c1094Xr, boolean z2) {
        return this.A01.A0P(this.A00, c04999p, c1094Xr, z2);
    }

    @Override // com.facebook.ads.redexgen.X.FB
    public final int AGO(long j2) {
        return this.A01.A0O(this.A00, j2);
    }
}

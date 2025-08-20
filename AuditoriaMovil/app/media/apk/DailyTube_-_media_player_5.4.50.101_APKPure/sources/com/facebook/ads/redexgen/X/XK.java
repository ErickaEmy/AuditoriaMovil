package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class XK implements C1 {
    public final /* synthetic */ XJ A00;

    public XK(XJ xj) {
        this.A00 = xj;
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final long A6r() {
        AbstractC0573Co abstractC0573Co;
        long j2;
        abstractC0573Co = this.A00.A0B;
        j2 = this.A00.A07;
        return abstractC0573Co.A03(j2);
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final C0 A7t(long granule) {
        AbstractC0573Co abstractC0573Co;
        long j2;
        long A00;
        long j4;
        if (granule == 0) {
            j4 = this.A00.A09;
            return new C0(new C2(0L, j4));
        }
        abstractC0573Co = this.A00.A0B;
        long A04 = abstractC0573Co.A04(granule);
        XJ xj = this.A00;
        j2 = xj.A09;
        A00 = xj.A00(j2, A04, 30000L);
        return new C0(new C2(granule, A00));
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final boolean A9I() {
        return true;
    }
}

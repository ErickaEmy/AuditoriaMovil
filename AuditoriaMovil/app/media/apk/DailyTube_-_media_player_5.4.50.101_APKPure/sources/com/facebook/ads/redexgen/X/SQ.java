package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class SQ implements C5T {
    public final /* synthetic */ C5V A00;
    public final /* synthetic */ C9P A01;

    public SQ(C9P c9p, C5V c5v) {
        this.A01 = c9p;
        this.A00 = c5v;
    }

    @Override // com.facebook.ads.redexgen.X.C5T
    public final boolean A8u() {
        boolean A0Y;
        boolean A0Z;
        if (!this.A01.A0X()) {
            A0Y = this.A01.A0Y();
            if (A0Y) {
                return true;
            }
            A0Z = this.A01.A0Z();
            return A0Z;
        }
        this.A01.A0W(this.A00);
        return true;
    }
}

package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class UW implements C5T {
    public final /* synthetic */ UT A00;

    public UW(UT ut2) {
        this.A00 = ut2;
    }

    @Override // com.facebook.ads.redexgen.X.C5T
    public final boolean A8u() {
        if (this.A00.A0E.canGoBack()) {
            this.A00.A0E.goBack();
            return true;
        }
        return false;
    }
}

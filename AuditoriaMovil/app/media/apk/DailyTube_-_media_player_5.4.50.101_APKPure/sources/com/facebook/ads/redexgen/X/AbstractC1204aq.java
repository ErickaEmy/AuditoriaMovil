package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.aq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC1204aq implements C6U {
    public final boolean A00;

    public abstract void A00();

    public abstract void A01(boolean z2);

    public AbstractC1204aq(boolean z2) {
        this.A00 = z2;
    }

    @Override // com.facebook.ads.redexgen.X.C6U
    public final void AB2() {
        if (this.A00) {
            A00();
        } else {
            A01(false);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C6U
    public final void ABB() {
        A01(true);
    }
}

package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class UJ implements O0 {
    public final /* synthetic */ UD A00;

    public UJ(UD ud2) {
        this.A00 = ud2;
    }

    @Override // com.facebook.ads.redexgen.X.O0
    public final void AAh() {
        boolean A0V;
        A0V = this.A00.A0V();
        if (A0V) {
            this.A00.A0L();
            this.A00.A0W.setToolbarActionMessage("");
            this.A00.A0W.setToolbarActionMode(0);
        }
    }

    @Override // com.facebook.ads.redexgen.X.O0
    public final void ACB() {
        L9 l92;
        this.A00.A0C = false;
        l92 = this.A00.A0L;
        l92.A07();
    }

    @Override // com.facebook.ads.redexgen.X.O0
    public final void ACC() {
        L9 l92;
        this.A00.A0C = true;
        l92 = this.A00.A0L;
        l92.A06();
    }
}

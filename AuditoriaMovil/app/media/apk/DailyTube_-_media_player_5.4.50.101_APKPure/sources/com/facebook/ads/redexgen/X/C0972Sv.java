package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Sv  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0972Sv implements L8 {
    public final /* synthetic */ int A00;
    public final /* synthetic */ KT A01;
    public final /* synthetic */ AbstractC0969Ss A02;

    public C0972Sv(AbstractC0969Ss abstractC0969Ss, int i, KT kt) {
        this.A02 = abstractC0969Ss;
        this.A00 = i;
        this.A01 = kt;
    }

    @Override // com.facebook.ads.redexgen.X.L8
    public final void ABA() {
        this.A01.run();
    }

    @Override // com.facebook.ads.redexgen.X.L8
    public final void ACm(float f4) {
        this.A02.A07.setProgress(100.0f * (1.0f - (f4 / this.A00)));
    }
}

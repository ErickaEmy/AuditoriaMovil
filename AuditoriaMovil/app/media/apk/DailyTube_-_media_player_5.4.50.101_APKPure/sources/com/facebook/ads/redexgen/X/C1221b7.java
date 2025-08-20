package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.b7  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1221b7 implements InterfaceC0828Nh {
    public final /* synthetic */ int A00;
    public final /* synthetic */ AbstractC1220b6 A01;
    public final /* synthetic */ V2 A02;

    public C1221b7(AbstractC1220b6 abstractC1220b6, int i, V2 v2) {
        this.A01 = abstractC1220b6;
        this.A00 = i;
        this.A02 = v2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0828Nh
    public final void ABh(boolean z2) {
        RD rd;
        if (this.A00 == 0) {
            V2 v2 = this.A02;
            rd = this.A01.A04;
            v2.A1Z(rd);
        }
        this.A02.A1c(z2, true);
    }
}

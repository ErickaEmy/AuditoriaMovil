package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
/* renamed from: com.facebook.ads.redexgen.X.au  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1208au implements InterfaceC03071q {
    public final /* synthetic */ C02991i A00;

    public C1208au(C02991i c02991i) {
        this.A00 = c02991i;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03071q
    public final void ACZ(AdError adError) {
        InterfaceC02981h interfaceC02981h;
        interfaceC02981h = this.A00.A04;
        interfaceC02981h.AAe(AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03071q
    public final void ACa() {
        InterfaceC02981h interfaceC02981h;
        interfaceC02981h = this.A00.A04;
        interfaceC02981h.AAf();
    }
}

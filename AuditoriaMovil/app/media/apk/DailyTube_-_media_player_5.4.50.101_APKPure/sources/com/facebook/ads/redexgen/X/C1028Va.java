package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Va  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1028Va implements InterfaceC1303cd<C0710Io, C0715It> {
    public VX A00;

    public C1028Va(VX vx) {
        this.A00 = vx;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ca != com.instagram.common.viewpoint.core.ViewpointData<com.facebook.ads.internal.impressionsecondchannel.model.Impression, com.facebook.ads.internal.impressionsecondchannel.state.ImpressionState> */
    @Override // com.facebook.ads.redexgen.X.InterfaceC1303cd
    public final void A5c(C1300ca<C0710Io, C0715It> c1300ca, InterfaceC1290cP interfaceC1290cP) {
        switch (Im.A00[interfaceC1290cP.A8J(c1300ca).ordinal()]) {
            case 1:
            case 2:
                this.A00.A02(c1300ca, interfaceC1290cP);
                return;
            default:
                return;
        }
    }
}

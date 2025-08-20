package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.cY  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC1298cY {
    public InterfaceC1299cZ A00;

    public final void A00() {
        InterfaceC1299cZ interfaceC1299cZ = this.A00;
        if (interfaceC1299cZ != null) {
            interfaceC1299cZ.onStart();
        }
    }

    public final void A01() {
        InterfaceC1299cZ interfaceC1299cZ = this.A00;
        if (interfaceC1299cZ != null) {
            interfaceC1299cZ.onStop();
        }
    }

    public final void A02(InterfaceC1299cZ interfaceC1299cZ) {
        this.A00 = interfaceC1299cZ;
    }
}

package com.facebook.ads.redexgen.X;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: assets/audience_network.dex */
public class TA implements InterfaceC0828Nh {
    public final /* synthetic */ T8 A00;

    public TA(T8 t8) {
        this.A00 = t8;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0828Nh
    public final void ABh(boolean z2) {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.A00.A06;
        atomicBoolean.set(z2);
        this.A00.A07();
    }
}

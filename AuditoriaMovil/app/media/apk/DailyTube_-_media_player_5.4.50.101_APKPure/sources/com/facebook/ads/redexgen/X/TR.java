package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;
/* loaded from: assets/audience_network.dex */
public class TR implements InterfaceC0828Nh {
    public final WeakReference<B4> A00;

    public TR(B4 b4) {
        this.A00 = new WeakReference<>(b4);
    }

    public /* synthetic */ TR(B4 b4, BH bh) {
        this(b4);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0828Nh
    public final void ABh(boolean z2) {
        B4 cardLayout = this.A00.get();
        if (cardLayout != null) {
            cardLayout.A06 = z2;
            cardLayout.A04();
        }
    }
}

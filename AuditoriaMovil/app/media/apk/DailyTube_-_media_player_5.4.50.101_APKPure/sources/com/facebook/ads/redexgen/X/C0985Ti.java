package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;
/* renamed from: com.facebook.ads.redexgen.X.Ti  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0985Ti implements InterfaceC0828Nh {
    public final WeakReference<BK> A00;

    public C0985Ti(BK bk2) {
        this.A00 = new WeakReference<>(bk2);
    }

    public /* synthetic */ C0985Ti(BK bk2, BP bp2) {
        this(bk2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0828Nh
    public final void ABh(boolean z2) {
        BK cardLayout = this.A00.get();
        if (cardLayout != null) {
            cardLayout.A04 = z2;
            cardLayout.A04();
        }
    }
}

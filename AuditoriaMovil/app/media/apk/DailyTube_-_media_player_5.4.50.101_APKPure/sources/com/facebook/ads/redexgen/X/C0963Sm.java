package com.facebook.ads.redexgen.X;

import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.Sm  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0963Sm implements InterfaceC0828Nh {
    public final /* synthetic */ C9Y A00;

    public C0963Sm(C9Y c9y) {
        this.A00 = c9y;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0828Nh
    public final void ABh(boolean z2) {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.A00.A04;
        atomicBoolean.set(z2);
        this.A00.A05();
    }
}

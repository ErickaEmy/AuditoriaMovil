package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class J8 implements InterfaceC0945Ru {
    @Override // com.facebook.ads.redexgen.X.InterfaceC0945Ru
    public final long A4z() {
        return System.nanoTime();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0945Ru
    public final void AGQ(Object obj, long j2) throws InterruptedException {
        obj.wait(j2);
    }
}

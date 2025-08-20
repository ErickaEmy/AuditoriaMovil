package com.facebook.ads.redexgen.X;

import java.util.concurrent.CountDownLatch;
/* renamed from: com.facebook.ads.redexgen.X.bW  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1246bW extends KT {
    public final /* synthetic */ C02870w A00;

    public C1246bW(C02870w c02870w) {
        this.A00 = c02870w;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        C02860v c02860v;
        CountDownLatch countDownLatch;
        this.A00.A07();
        c02860v = this.A00.A02;
        c02860v.A06();
        countDownLatch = this.A00.A05;
        countDownLatch.countDown();
    }
}

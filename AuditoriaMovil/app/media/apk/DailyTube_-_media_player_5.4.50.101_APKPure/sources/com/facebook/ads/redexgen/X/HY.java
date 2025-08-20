package com.facebook.ads.redexgen.X;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: assets/audience_network.dex */
public class HY implements RL {
    public final /* synthetic */ C04376x A00;
    public final /* synthetic */ CountDownLatch A01;
    public final /* synthetic */ AtomicReference A02;
    public final /* synthetic */ AtomicReference A03;

    public HY(C04376x c04376x, AtomicReference atomicReference, AtomicReference atomicReference2, CountDownLatch countDownLatch) {
        this.A00 = c04376x;
        this.A03 = atomicReference;
        this.A02 = atomicReference2;
        this.A01 = countDownLatch;
    }

    @Override // com.facebook.ads.redexgen.X.RL
    public final void AB9(RJ rj) {
        C04376x.A06(rj.A69(), this.A03, this.A02);
        this.A01.countDown();
    }

    @Override // com.facebook.ads.redexgen.X.RL
    public final void ABS(Exception exc) {
        this.A02.set(exc);
        this.A01.countDown();
    }
}

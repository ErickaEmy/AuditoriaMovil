package com.facebook.ads.redexgen.X;

import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: assets/audience_network.dex */
public class VU extends KT {
    public final /* synthetic */ VT A00;

    public VU(VT vt) {
        this.A00 = vt;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        ThreadPoolExecutor threadPoolExecutor;
        ThreadPoolExecutor threadPoolExecutor2;
        Runnable runnable;
        this.A00.A0C = false;
        threadPoolExecutor = this.A00.A0B;
        if (threadPoolExecutor.getQueue().isEmpty()) {
            threadPoolExecutor2 = this.A00.A0B;
            runnable = this.A00.A0A;
            threadPoolExecutor2.execute(runnable);
        }
    }
}

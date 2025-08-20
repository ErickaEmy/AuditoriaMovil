package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Rq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC0941Rq implements Runnable {
    public final /* synthetic */ C0683Hl A00;

    public RunnableC0941Rq(C0683Hl c0683Hl) {
        this.A00 = c0683Hl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (KL.A02(this)) {
            return;
        }
        try {
            C0683Hl.A03(this.A00);
            throw null;
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Es  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC0616Es implements Runnable {
    public final /* synthetic */ F1 A00;
    public final /* synthetic */ F4 A01;

    public RunnableC0616Es(F1 f12, F4 f4) {
        this.A00 = f12;
        this.A01 = f4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.ACH(this.A00.A00, this.A00.A01);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

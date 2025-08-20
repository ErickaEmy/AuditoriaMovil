package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class EA implements Runnable {
    public final /* synthetic */ ED A00;

    public EA(ED ed) {
        this.A00 = ed;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A0F(5, 3);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

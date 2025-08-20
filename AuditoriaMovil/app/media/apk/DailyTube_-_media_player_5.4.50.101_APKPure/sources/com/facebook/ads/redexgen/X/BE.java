package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class BE extends Thread {
    public final /* synthetic */ AbstractC1092Xp A00;

    public BE(AbstractC1092Xp abstractC1092Xp) {
        this.A00 = abstractC1092Xp;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A0M();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class PZ implements Runnable {
    public final /* synthetic */ C0974Sx A00;

    public PZ(C0974Sx c0974Sx) {
        this.A00 = c0974Sx;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z2;
        if (KL.A02(this)) {
            return;
        }
        try {
            z2 = this.A00.A0K;
            if (!z2) {
                return;
            }
            this.A00.A0Q();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class EB implements Runnable {
    public final /* synthetic */ ED A00;
    public final /* synthetic */ Throwable A01;

    public EB(ED ed, Throwable th) {
        this.A00 = ed;
        this.A01 = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean A0G;
        boolean A0F;
        boolean A0F2;
        if (KL.A02(this)) {
            return;
        }
        try {
            ED ed = this.A00;
            Throwable th = this.A01;
            A0G = ed.A0G(1, th != null ? 4 : 2, th);
            if (A0G) {
                return;
            }
            A0F = this.A00.A0F(6, 3);
            if (A0F) {
                return;
            }
            A0F2 = this.A00.A0F(7, 0);
            if (!A0F2) {
                throw new IllegalStateException();
            }
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

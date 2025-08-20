package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Ei  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC0606Ei implements Runnable {
    public final /* synthetic */ CD A00;

    public RunnableC0606Ei(CD cd) {
        this.A00 = cd;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A09();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

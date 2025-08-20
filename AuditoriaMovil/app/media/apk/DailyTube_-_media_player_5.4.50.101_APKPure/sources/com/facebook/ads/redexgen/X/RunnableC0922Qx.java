package com.facebook.ads.redexgen.X;

import android.os.Handler;
/* renamed from: com.facebook.ads.redexgen.X.Qx  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC0922Qx implements Runnable {
    public final /* synthetic */ R0 A00;

    public RunnableC0922Qx(R0 r0) {
        this.A00 = r0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A09();
            handler = this.A00.A04;
            handler.removeCallbacks(this);
            handler2 = this.A00.A04;
            handler2.postDelayed(this, 250L);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

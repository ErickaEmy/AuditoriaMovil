package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class NZ implements Runnable {
    public final /* synthetic */ C0821Na A00;
    public final /* synthetic */ InterfaceC0822Nb A01;

    public NZ(C0821Na c0821Na, InterfaceC0822Nb interfaceC0822Nb) {
        this.A00 = c0821Na;
        this.A01 = interfaceC0822Nb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.AAn();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

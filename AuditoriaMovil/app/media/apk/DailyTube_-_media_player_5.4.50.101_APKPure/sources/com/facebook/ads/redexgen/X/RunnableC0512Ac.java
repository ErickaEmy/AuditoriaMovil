package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Ac  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC0512Ac implements Runnable {
    public final /* synthetic */ C0518Ai A00;
    public final /* synthetic */ BC A01;

    public RunnableC0512Ac(C0518Ai c0518Ai, BC bc) {
        this.A00 = c0518Ai;
        this.A01 = bc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC0519Aj interfaceC0519Aj;
        if (KL.A02(this)) {
            return;
        }
        try {
            interfaceC0519Aj = this.A00.A01;
            interfaceC0519Aj.AAq(this.A01);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

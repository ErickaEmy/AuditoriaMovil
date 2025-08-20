package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Ah  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC0517Ah implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ C0518Ai A01;

    public RunnableC0517Ah(C0518Ai c0518Ai, int i) {
        this.A01 = c0518Ai;
        this.A00 = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC0519Aj interfaceC0519Aj;
        if (KL.A02(this)) {
            return;
        }
        try {
            interfaceC0519Aj = this.A01.A01;
            interfaceC0519Aj.AAs(this.A00);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

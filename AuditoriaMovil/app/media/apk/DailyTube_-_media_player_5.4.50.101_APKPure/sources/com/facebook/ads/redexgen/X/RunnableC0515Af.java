package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Af  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC0515Af implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ long A02;
    public final /* synthetic */ C0518Ai A03;

    public RunnableC0515Af(C0518Ai c0518Ai, int i, long j2, long j4) {
        this.A03 = c0518Ai;
        this.A00 = i;
        this.A01 = j2;
        this.A02 = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC0519Aj interfaceC0519Aj;
        if (KL.A02(this)) {
            return;
        }
        try {
            interfaceC0519Aj = this.A03.A01;
            interfaceC0519Aj.AAt(this.A00, this.A01, this.A02);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

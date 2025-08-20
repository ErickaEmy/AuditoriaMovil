package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Ib  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC0699Ib implements Runnable {
    public final /* synthetic */ BC A00;
    public final /* synthetic */ C0700Ic A01;

    public RunnableC0699Ib(C0700Ic c0700Ic, BC bc) {
        this.A01 = c0700Ic;
        this.A00 = bc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC0701Id interfaceC0701Id;
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A00();
            interfaceC0701Id = this.A01.A01;
            interfaceC0701Id.ADV(this.A00);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

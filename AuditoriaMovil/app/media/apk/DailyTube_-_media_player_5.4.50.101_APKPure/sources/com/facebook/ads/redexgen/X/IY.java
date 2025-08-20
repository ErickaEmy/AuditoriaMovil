package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class IY implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ C0700Ic A02;

    public IY(C0700Ic c0700Ic, int i, long j2) {
        this.A02 = c0700Ic;
        this.A00 = i;
        this.A01 = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC0701Id interfaceC0701Id;
        if (KL.A02(this)) {
            return;
        }
        try {
            interfaceC0701Id = this.A02.A01;
            interfaceC0701Id.ABN(this.A00, this.A01);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

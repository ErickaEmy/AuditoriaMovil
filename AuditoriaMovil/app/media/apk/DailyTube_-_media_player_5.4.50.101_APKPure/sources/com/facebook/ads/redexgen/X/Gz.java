package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class Gz implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ long A02;
    public final /* synthetic */ W1 A03;

    public Gz(W1 w1, int i, long j2, long j4) {
        this.A03 = w1;
        this.A00 = i;
        this.A02 = j2;
        this.A01 = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC0661Go interfaceC0661Go;
        if (KL.A02(this)) {
            return;
        }
        try {
            interfaceC0661Go = this.A03.A07;
            interfaceC0661Go.AAw(this.A00, this.A02, this.A01);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

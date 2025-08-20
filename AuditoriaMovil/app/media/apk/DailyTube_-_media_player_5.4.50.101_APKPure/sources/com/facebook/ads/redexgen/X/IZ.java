package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class IZ implements Runnable {
    public final /* synthetic */ float A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ int A02;
    public final /* synthetic */ int A03;
    public final /* synthetic */ C0700Ic A04;

    public IZ(C0700Ic c0700Ic, int i, int i5, int i6, float f4) {
        this.A04 = c0700Ic;
        this.A03 = i;
        this.A01 = i5;
        this.A02 = i6;
        this.A00 = f4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC0701Id interfaceC0701Id;
        if (KL.A02(this)) {
            return;
        }
        try {
            interfaceC0701Id = this.A04.A01;
            interfaceC0701Id.ADf(this.A03, this.A01, this.A02, this.A00);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

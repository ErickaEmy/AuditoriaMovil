package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class IW implements Runnable {
    public final /* synthetic */ long A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ C0700Ic A02;
    public final /* synthetic */ String A03;

    public IW(C0700Ic c0700Ic, String str, long j2, long j4) {
        this.A02 = c0700Ic;
        this.A03 = str;
        this.A01 = j2;
        this.A00 = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC0701Id interfaceC0701Id;
        if (KL.A02(this)) {
            return;
        }
        try {
            interfaceC0701Id = this.A02.A01;
            interfaceC0701Id.ADU(this.A03, this.A01, this.A00);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

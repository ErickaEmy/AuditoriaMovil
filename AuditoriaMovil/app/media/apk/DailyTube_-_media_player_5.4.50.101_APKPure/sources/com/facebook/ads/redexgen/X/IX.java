package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
/* loaded from: assets/audience_network.dex */
public class IX implements Runnable {
    public final /* synthetic */ Format A00;
    public final /* synthetic */ C0700Ic A01;

    public IX(C0700Ic c0700Ic, Format format) {
        this.A01 = c0700Ic;
        this.A00 = format;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC0701Id interfaceC0701Id;
        if (KL.A02(this)) {
            return;
        }
        try {
            interfaceC0701Id = this.A01.A01;
            interfaceC0701Id.ADa(this.A00);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

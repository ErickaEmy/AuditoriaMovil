package com.facebook.ads.redexgen.X;

import android.view.Surface;
/* renamed from: com.facebook.ads.redexgen.X.Ia  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC0698Ia implements Runnable {
    public final /* synthetic */ Surface A00;
    public final /* synthetic */ C0700Ic A01;

    public RunnableC0698Ia(C0700Ic c0700Ic, Surface surface) {
        this.A01 = c0700Ic;
        this.A00 = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC0701Id interfaceC0701Id;
        if (KL.A02(this)) {
            return;
        }
        try {
            interfaceC0701Id = this.A01.A01;
            interfaceC0701Id.ACt(this.A00);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

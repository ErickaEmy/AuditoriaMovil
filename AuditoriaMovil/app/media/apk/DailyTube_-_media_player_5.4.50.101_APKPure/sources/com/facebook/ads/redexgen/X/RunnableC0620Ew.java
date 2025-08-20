package com.facebook.ads.redexgen.X;

import java.io.IOException;
/* renamed from: com.facebook.ads.redexgen.X.Ew  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC0620Ew implements Runnable {
    public final /* synthetic */ F1 A00;
    public final /* synthetic */ F2 A01;
    public final /* synthetic */ F3 A02;
    public final /* synthetic */ F4 A03;
    public final /* synthetic */ IOException A04;
    public final /* synthetic */ boolean A05;

    public RunnableC0620Ew(F1 f12, F4 f4, F2 f22, F3 f32, IOException iOException, boolean z2) {
        this.A00 = f12;
        this.A03 = f4;
        this.A01 = f22;
        this.A02 = f32;
        this.A04 = iOException;
        this.A05 = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A03.AC3(this.A00.A00, this.A00.A01, this.A01, this.A02, this.A04, this.A05);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

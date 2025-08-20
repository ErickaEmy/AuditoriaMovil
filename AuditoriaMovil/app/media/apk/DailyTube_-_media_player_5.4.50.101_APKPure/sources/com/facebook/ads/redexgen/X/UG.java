package com.facebook.ads.redexgen.X;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: assets/audience_network.dex */
public class UG implements MA {
    public final /* synthetic */ UD A00;

    public UG(UD ud2) {
        this.A00 = ud2;
    }

    @Override // com.facebook.ads.redexgen.X.MA
    public final void AB6() {
        boolean A0W;
        boolean z2;
        JA ja;
        MC mc2;
        InterfaceC0804Mj interfaceC0804Mj;
        AtomicBoolean atomicBoolean;
        boolean A0V;
        AtomicBoolean atomicBoolean2;
        O1 o1;
        A0W = this.A00.A0W();
        if (A0W) {
            atomicBoolean2 = this.A00.A0S;
            if (!atomicBoolean2.get()) {
                o1 = this.A00.A0Q;
                o1.A07(this.A00);
                return;
            }
        }
        z2 = this.A00.A0U;
        if (z2) {
            atomicBoolean = this.A00.A0S;
            if (!atomicBoolean.get()) {
                A0V = this.A00.A0V();
                if (A0V) {
                    this.A00.A0W.setToolbarActionMode(0);
                    this.A00.A0L();
                    return;
                }
            }
        }
        ja = this.A00.A0K;
        ja.A04(J9.A07, null);
        mc2 = this.A00.A0N;
        interfaceC0804Mj = this.A00.A0O;
        mc2.A43(interfaceC0804Mj.A6u());
    }
}

package com.facebook.ads.redexgen.X;

import java.io.IOException;
/* loaded from: assets/audience_network.dex */
public final class CF {
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public boolean A04;
    public final byte[] A05 = new byte[10];

    public final void A00() {
        this.A04 = false;
    }

    public final void A01(InterfaceC0555Bt interfaceC0555Bt, int i, int i5) throws IOException, InterruptedException {
        if (!this.A04) {
            interfaceC0555Bt.ADv(this.A05, 0, 10);
            interfaceC0555Bt.AFM();
            if (AQ.A06(this.A05) == -1) {
                return;
            }
            this.A04 = true;
            this.A02 = 0;
        }
        if (this.A02 == 0) {
            this.A00 = i;
            this.A01 = 0;
        }
        this.A01 += i5;
    }

    public final void A02(CE ce) {
        if (this.A04 && this.A02 > 0) {
            ce.A0W.AFS(this.A03, this.A00, this.A01, 0, ce.A0V);
            this.A02 = 0;
        }
    }

    public final void A03(CE ce, long j2) {
        if (!this.A04) {
            return;
        }
        int i = this.A02;
        int i5 = i + 1;
        this.A02 = i5;
        if (i == 0) {
            this.A03 = j2;
        }
        if (i5 < 16) {
            return;
        }
        ce.A0W.AFS(this.A03, this.A00, this.A01, 0, ce.A0V);
        this.A02 = 0;
    }
}

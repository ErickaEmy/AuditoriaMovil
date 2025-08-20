package com.facebook.ads.redexgen.X;

import java.io.IOException;
/* loaded from: assets/audience_network.dex */
public final class DE {
    public final int A00;
    public final long A01;

    public DE(int i, long j2) {
        this.A00 = i;
        this.A01 = j2;
    }

    public static DE A00(InterfaceC0555Bt interfaceC0555Bt, C0697Hz c0697Hz) throws IOException, InterruptedException {
        interfaceC0555Bt.ADv(c0697Hz.A00, 0, 8);
        c0697Hz.A0Y(0);
        int A08 = c0697Hz.A08();
        long size = c0697Hz.A0K();
        return new DE(A08, size);
    }
}

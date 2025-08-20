package com.facebook.ads.redexgen.X;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: assets/audience_network.dex */
public class VH implements InterfaceC0828Nh {
    public static String[] A01 = {"PnhhxO44eyGR", "6RYeLXmAClA1SiGKn201px", "WqNcg2MFF", "kFMGwY5yNNV", "mQRpAL1oxGJgw", "Eqf6jMIzeI3tCjJb", "9imsVe3tjkVzhTosgYrmf1lKW7QE2MSM", "NRYl8cTHkwcGHXULnCD2cakkWnkUWd4e"};
    public final /* synthetic */ VE A00;

    public VH(VE ve) {
        this.A00 = ve;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0828Nh
    public final void ABh(boolean z2) {
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        JK jk2;
        JK jk3;
        atomicBoolean = this.A00.A0D;
        atomicBoolean.set(z2);
        atomicBoolean2 = this.A00.A0E;
        if (atomicBoolean2.get()) {
            jk2 = this.A00.A02;
            if (jk2 != null) {
                VE ve = this.A00;
                String[] strArr = A01;
                if (strArr[5].length() == strArr[3].length()) {
                    throw new RuntimeException();
                }
                A01[2] = "moHDWw2Q1";
                jk3 = ve.A02;
                jk3.ACX(z2);
            }
        }
    }
}

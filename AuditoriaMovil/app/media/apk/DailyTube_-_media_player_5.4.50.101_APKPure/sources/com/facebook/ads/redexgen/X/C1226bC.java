package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.bC  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1226bC extends KT {
    public static byte[] A01;
    public final /* synthetic */ C1225bB A00;

    static {
        A02();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 95);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-20, -29, -8, -29, -11, -27, -12, -21, -14, -10, -68};
    }

    public C1226bC(C1225bB c1225bB) {
        this.A00 = c1225bB;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        C1116Yn c1116Yn;
        NY ny;
        C1227bD c1227bD;
        c1116Yn = this.A00.A02;
        c1116Yn.A0E().AH4();
        ny = this.A00.A04;
        StringBuilder append = new StringBuilder().append(A00(0, 11, 35));
        c1227bD = this.A00.A00;
        ny.loadUrl(append.append(c1227bD.A03()).toString());
    }
}

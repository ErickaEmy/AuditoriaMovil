package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class UH implements L8 {
    public static byte[] A01;
    public final /* synthetic */ UD A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 97);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{108, 120, 121, 98, 110, 97, 100, 110, 102};
    }

    public UH(UD ud2) {
        this.A00 = ud2;
    }

    @Override // com.facebook.ads.redexgen.X.L8
    public final void ABA() {
        boolean z2;
        boolean z3;
        z2 = this.A00.A0A;
        if (!z2) {
            z3 = this.A00.A09;
            if (!z3) {
                this.A00.A0U(false, A00(0, 9, 108));
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.L8
    public final void ACm(float f4) {
    }
}

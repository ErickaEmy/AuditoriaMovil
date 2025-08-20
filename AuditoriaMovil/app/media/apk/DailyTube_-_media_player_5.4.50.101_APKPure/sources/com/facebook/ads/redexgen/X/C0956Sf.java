package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Sf  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0956Sf extends KT {
    public static byte[] A01;
    public final /* synthetic */ C9Q A00;

    static {
        A02();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 126);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{100, 91, 86, 87, 93, 18, 69, 83, 65, 18, 92, 87, 68, 87, 64, 18, 66, 64, 87, 66, 83, 64, 87, 86};
    }

    public C0956Sf(C9Q c9q) {
        this.A00 = c9q;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        boolean z2;
        z2 = this.A00.A07;
        if (!z2) {
            this.A00.A0G(A00(0, 24, 76));
        }
    }
}

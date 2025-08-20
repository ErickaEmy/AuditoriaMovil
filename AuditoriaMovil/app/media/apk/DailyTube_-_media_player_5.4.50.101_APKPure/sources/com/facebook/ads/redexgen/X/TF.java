package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class TF extends KT {
    public static byte[] A02;
    public final /* synthetic */ P3 A00;
    public final /* synthetic */ AnonymousClass93 A01;

    static {
        A02();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 46);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{93, 106, 121, 121, 122, 109, 118, 113, 120, 63, 118, 113, 123, 122, 121, 118, 113, 118, 107, 122, 115, 102};
    }

    public TF(P3 p3, AnonymousClass93 anonymousClass93) {
        this.A00 = p3;
        this.A01 = anonymousClass93;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        SA sa;
        SA sa2;
        sa = this.A00.A0D;
        if (sa.getState() == RB.A02) {
            sa2 = this.A00.A0D;
            if (sa2.getCurrentPositionInMillis() == A00()) {
                this.A00.A0I(A00(0, 22, 49));
            }
        }
    }
}

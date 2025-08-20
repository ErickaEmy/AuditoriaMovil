package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Lc  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC0771Lc {
    A08(0),
    A07(0),
    A06(1),
    A03(2),
    A04(3),
    A05(4);
    
    public static byte[] A01;
    public final int A00;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 61);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-85, -83, -96, -89, -86, -93, -67, -112, -91, -36, -34, -47, -40, -37, -44, -18, -62, -42, -45, -43, -56, -49, -46, -53, -27, -70, -51, -26, -24, -37, -30, -27, -34, -8, -30, -25, -19, -34, -21, -25, -34, -19, -90, -89, -90, -99, -34, -41, -44, -41, -40, -32, -41};
    }

    static {
        A01();
    }

    EnumC0771Lc(int i) {
        this.A00 = i;
    }
}

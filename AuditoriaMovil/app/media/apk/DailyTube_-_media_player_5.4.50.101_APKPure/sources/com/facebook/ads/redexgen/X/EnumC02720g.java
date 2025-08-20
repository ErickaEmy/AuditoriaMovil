package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.0g  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC02720g {
    A08,
    A03,
    A04,
    A09,
    A02,
    A07,
    A06,
    A05;
    
    public static byte[] A00;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 101);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-27, -12, -12, 3, -9, -8, -13, -10, -23, -6, -8, 5, 5, 6, 11, 22, 6, 7, -4, 5, -7, -9, 4, 4, 5, 10, 21, 10, 8, -9, -7, 1, -60, -46, -49, -48, -48, -59, -60, 7, 26, 22, 7, 20, 16, 3, 14, 33, 4, 20, 17, 25, 21, 7, 20, 16, 8, 9, 5, 6, 5, -4, -56, -69, -70, -65, -56, -69, -71, -54, -43, -54, -59, -43, -73, -58, -58};
    }

    static {
        A01();
    }

    public static boolean A02(EnumC02720g enumC02720g) {
        return A03.equals(enumC02720g) || A04.equals(enumC02720g);
    }
}

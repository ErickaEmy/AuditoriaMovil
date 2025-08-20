package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public enum QM {
    A03,
    A04,
    A02;
    
    public static byte[] A00;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 116);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{10, 30, 31, 4, 20, 24, 31, 10, 25, 31, 14, 15, 66, 67, 88, 83, 95, 88, 77, 94, 88, 73, 72, 18, 20, 2, 21, 24, 20, 19, 6, 21, 19, 2, 3};
    }

    static {
        A01();
    }
}

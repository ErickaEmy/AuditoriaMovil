package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.cC  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC1280cC {
    A02,
    A05,
    A03,
    A04;
    
    public static byte[] A00;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 76);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{124, 113, 106, 124, 100, 110, 21, 25, 1, 26, 29, 116, Byte.MAX_VALUE, 108, Byte.MAX_VALUE, 104, 116, 111, 106, 111, 110, 118, 111};
    }

    static {
        A01();
    }
}

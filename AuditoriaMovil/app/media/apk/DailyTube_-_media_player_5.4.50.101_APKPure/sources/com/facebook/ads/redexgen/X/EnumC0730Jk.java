package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Jk  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC0730Jk {
    A02,
    A03;
    
    public static byte[] A00;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 77);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{18, 13, -95, -94, -95, -104};
    }

    static {
        A01();
    }
}

package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Rm  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC0937Rm {
    A02,
    A03;
    
    public static byte[] A00;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 40);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-124, -115, -118, -122, -113, -107, -96, -112, -104, -113, -122, -123, -112, -126, -113, -109, -126, -113, -100, -116, -108, -117, -126, -127};
    }

    static {
        A01();
    }
}

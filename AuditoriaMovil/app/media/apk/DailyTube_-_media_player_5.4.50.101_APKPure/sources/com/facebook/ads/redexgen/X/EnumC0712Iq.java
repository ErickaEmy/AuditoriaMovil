package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Iq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC0712Iq {
    A02,
    A03,
    A04;
    
    public static byte[] A00;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 14);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{98, 101, 92, 90, 92, 97, 84, 95, -49, -47, -66, -49, -63, -51, -47, -63, -54, -48, 122, 109, 105, 123, 101, 102, 109, 112, 109, 120, 125};
    }

    static {
        A01();
    }
}

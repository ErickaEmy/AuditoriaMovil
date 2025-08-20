package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Vs  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1046Vs extends H4 {
    public static byte[] A02;
    public final int A00;
    public final Map<String, List<String>> A01;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 27);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{48, 7, 17, 18, 13, 12, 17, 7, 66, 1, 13, 6, 7, 88, 66};
    }

    public C1046Vs(int i, Map<String, List<String>> map, C0671Gy c0671Gy) {
        super(A00(0, 15, 121) + i, c0671Gy, 1);
        this.A00 = i;
        this.A01 = map;
    }
}

package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class HC extends IOException {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 21);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{94, 68, -86, -61, -70, -51, -59, -70, -72, -55, -70, -71, 117};
    }

    public HC(Throwable th) {
        super(A00(2, 11, 64) + th.getClass().getSimpleName() + A00(0, 2, 15) + th.getMessage(), th);
    }
}

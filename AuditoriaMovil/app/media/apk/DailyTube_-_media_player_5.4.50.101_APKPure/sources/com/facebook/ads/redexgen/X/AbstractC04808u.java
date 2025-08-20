package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.8u  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC04808u {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 51);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-2, -15, -17, -5, -2, -16, -21, -16, -19, 0, -19, -18, -19, -1, -15};
    }

    public static C8w A00(C1115Ym c1115Ym) {
        try {
            return new YD(c1115Ym);
        } catch (IOException e2) {
            c1115Ym.A07().A9a(A02(0, 15, 89), C8A.A2K, new C8B(e2));
            return new YG();
        }
    }

    public static EN A01(C1115Ym c1115Ym) {
        return new EN(c1115Ym);
    }
}

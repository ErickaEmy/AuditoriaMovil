package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.2T  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C2T {
    public static C2S A00;
    public static byte[] A01;

    static {
        A02();
    }

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 45);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{58, 54, 52, 119, 63, 56, 58, 60, 59, 54, 54, 50, 119, 56, 61, 42, 119, 24, 29, 6, 11, 28, 9, 22, 11, 13, 16, 23, 30, 6, 26, 22, 23, 31, 16, 30};
    }

    public static C2S A00(C1115Ym c1115Ym) {
        if (A00 == null) {
            synchronized (C2S.class) {
                if (A00 == null) {
                    A00 = new C2S(new C1164aC(c1115Ym.getSharedPreferences(ProcessUtils.getProcessSpecificName(A01(0, 36, 116), c1115Ym), 0)));
                }
            }
        }
        return A00;
    }
}

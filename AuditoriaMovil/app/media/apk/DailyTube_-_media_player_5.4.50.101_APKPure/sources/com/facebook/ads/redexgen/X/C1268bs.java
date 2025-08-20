package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.bs  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1268bs {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 102);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{0, 4, 9, 1, -2, 3, -61, -1, 11, 2, -61, -5, 10, 3, -8, 9, -2, 4, 3, 8, -61};
    }

    public final String A02(GL gl) {
        String obj = gl.getClass().getGenericInterfaces()[0].toString();
        String A002 = A00(0, 21, 47);
        return obj.startsWith(A002) ? obj.substring(A002.length()) : obj;
    }

    public final String A03(AbstractC04316o abstractC04316o) {
        return A02(abstractC04316o);
    }
}

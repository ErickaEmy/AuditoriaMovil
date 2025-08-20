package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.0A  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C0A {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 64);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{71};
    }

    private String A01(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        int slashIndex = str.lastIndexOf(47);
        if (lastIndexOf != -1 && lastIndexOf > slashIndex) {
            int dotIndex = lastIndexOf + 2;
            int slashIndex2 = dotIndex + 4;
            int dotIndex2 = str.length();
            if (slashIndex2 > dotIndex2) {
                int slashIndex3 = lastIndexOf + 1;
                int dotIndex3 = str.length();
                return str.substring(slashIndex3, dotIndex3);
            }
        }
        return A00(0, 0, 13);
    }

    public final String A03(String str) {
        String A01 = A01(str);
        String name = C0I.A02(str);
        if (TextUtils.isEmpty(A01)) {
            return name;
        }
        StringBuilder append = new StringBuilder().append(name);
        String extension = A00(0, 1, 41);
        return append.append(extension).append(A01).toString();
    }
}

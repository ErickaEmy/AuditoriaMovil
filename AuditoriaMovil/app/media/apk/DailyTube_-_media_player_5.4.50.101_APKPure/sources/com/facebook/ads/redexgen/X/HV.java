package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public abstract class HV {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 99);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{64, 93, 74, 122, 73, 64, 75, 10, 23, 0, 48, 29, 10, 11, 6, 29};
    }

    public static long A00(HU hu2) {
        return hu2.A5p(A02(0, 7, 70), -1L);
    }

    public static Uri A01(HU hu2) {
        String A5r = hu2.A5r(A02(7, 9, 12), null);
        if (A5r == null) {
            return null;
        }
        return Uri.parse(A5r);
    }

    public static void A04(HW hw2) {
        hw2.A01(A02(7, 9, 12));
    }

    public static void A05(HW hw2, long j2) {
        hw2.A02(A02(0, 7, 70), j2);
    }

    public static void A06(HW hw2, Uri uri) {
        hw2.A03(A02(7, 9, 12), uri.toString());
    }
}

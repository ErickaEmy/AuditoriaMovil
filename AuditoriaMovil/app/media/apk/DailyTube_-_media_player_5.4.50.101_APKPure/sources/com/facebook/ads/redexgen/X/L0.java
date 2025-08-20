package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class L0 {
    public static boolean A00;
    public static boolean A01;
    public static byte[] A02;
    public static final Map<String, String> A03;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 25);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{-79, -83, 121, -80, 125, -80, 121, -36, -40, -92, -24, -21, -28, -28, -33, -28, -35, -43, -37, -88, -37, -15, -17, -14, -30};
    }

    static {
        A03();
        A01 = false;
        A00 = false;
        A03 = Collections.synchronizedMap(new HashMap());
    }

    public static synchronized String A01(String str) {
        synchronized (L0.class) {
            if (A04()) {
                return System.getProperty(A00(0, 7, 50) + str);
            }
            return null;
        }
    }

    public static Map<String, String> A02() {
        if (!A04()) {
            return Collections.emptyMap();
        }
        return A03;
    }

    public static synchronized boolean A04() {
        boolean z2;
        synchronized (L0.class) {
            if (!A00) {
                A01 = A00(21, 4, 100).equals(System.getProperty(A00(7, 14, 93)));
                A00 = true;
            }
            z2 = A01;
        }
        return z2;
    }

    public static synchronized boolean A05(String str) {
        boolean z2;
        synchronized (L0.class) {
            z2 = !TextUtils.isEmpty(A01(str));
        }
        return z2;
    }
}

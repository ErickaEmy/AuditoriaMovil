package com.facebook.ads.redexgen.X;

import android.content.Context;
import com.facebook.ads.internal.settings.AdInternalSettings;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public abstract class L4 {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 118);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-60, -52, 8, 13, 23, 20, 16, 5, 29, 9, 8, -60, 10, 19, 22, -60, 24, 9, 23, 24, -60, 5, 8, 23, -60, 19, 18, 16, 29, -51};
    }

    public static void A02(Context context, String str) {
        if (AdInternalSettings.isTestMode(context)) {
            String str2 = str + A00(0, 30, 46);
        }
    }
}

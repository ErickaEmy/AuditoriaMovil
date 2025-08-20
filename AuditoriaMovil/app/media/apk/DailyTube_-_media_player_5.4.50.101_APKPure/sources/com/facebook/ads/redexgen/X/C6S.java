package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.uv.v7.R;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.6S  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C6S {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 33);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{45, 59, 16, 42, 55, 59, 61, 46, 60, 43, 39, 37, 102, 46, 41, 43, 45, 42, 39, 39, 35, 102, 41, 44, 59, 102, 33, 38, 60, 45, 58, 38, 41, 36, 102, 42, 60, 45, 48, 60, 58, 41, 59};
    }

    public static SharedPreferences A00(C04447f c04447f) {
        return c04447f.getSharedPreferences(ProcessUtils.getProcessSpecificName(A01(9, 34, 105), c04447f), 0);
    }

    public final String A03(C04447f c04447f) {
        return A00(c04447f).getString(A01(0, 9, R.styleable.AppCompatTheme_textColorAlertDialogListItem), null);
    }

    public final void A04(C04447f c04447f, String str) {
        SharedPreferences btSP = A00(c04447f);
        btSP.edit().putString(A01(0, 9, R.styleable.AppCompatTheme_textColorAlertDialogListItem), str).apply();
    }
}

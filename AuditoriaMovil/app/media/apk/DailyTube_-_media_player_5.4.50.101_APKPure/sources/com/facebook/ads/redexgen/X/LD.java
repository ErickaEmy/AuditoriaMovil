package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public abstract class LD {
    public static byte[] A00;
    public static String[] A01 = {"r58", "tPr1p", "f5lIxAtAKiBQqbeb00DIw30sTyOB6Nip", "UA77sayfFIN4rDJ1yzqar5h", "qcYJgrhXwK3F7gc49b8OJRulLZ0tc", "aw", "BC", "ZwT7VrzK7C4B3AE5wUb8SA17JwCvGXhw"};
    public static final float A02;
    public static final DisplayMetrics A03;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A01[2].charAt(25) == 'h') {
                throw new RuntimeException();
            }
            A01[4] = "";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 125);
            i8++;
        }
    }

    public static void A02() {
        if (A01[0].length() == 18) {
            throw new RuntimeException();
        }
        A01[0] = "y1BiGtkR2PGy";
        A00 = new byte[]{75, 61, 66, 56, 67, 75};
    }

    static {
        A02();
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        A03 = displayMetrics;
        A02 = displayMetrics.density;
    }

    public static int A00(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(A01(0, 6, 87));
        if (windowManager == null) {
            return 13;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (A01[3].length() != 18) {
            A01[2] = "2bhCmdFfmb6UvowfNGVxOCNiLCVaOJfv";
            switch (defaultDisplay.getOrientation()) {
                case 0:
                    return 1;
                case 1:
                    if (A01[3].length() != 18) {
                        A01[0] = "BNF7ZQJYQPI9GTH2pfcSvMp6af8oi";
                        return 0;
                    }
                    A01[7] = "9xnRWvfnvAuFWSokCiPir6t5eweLHrnN";
                    return 0;
                case 2:
                    return 9;
                case 3:
                    return 8;
                default:
                    return 13;
            }
        }
        throw new RuntimeException();
    }
}

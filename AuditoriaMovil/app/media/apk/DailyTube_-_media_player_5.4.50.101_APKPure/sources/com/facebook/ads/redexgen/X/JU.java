package com.facebook.ads.redexgen.X;

import com.facebook.ads.VideoAutoplayBehavior;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public enum JU {
    A03,
    A05,
    A04;
    
    public static byte[] A00;
    public static String[] A01 = {"Gjwy6cOcQ9K2s9TECvKSb1UBI6p92tWs", "MkJKTqDYMAzsSL3ogCclj8aQMOEn3Zaf", "eTpSOjZOB", "ux", "6lFNHDDwy35cZQ5ctUwn46ZPa5FkYtAF", "2ZxEJa2ax0wS4G", "Utm", "f4eG1TG9uZ10lRPR3hza"};

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 116);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-57, -56, -55, -60, -40, -49, -41, -11, -20, -20, 22, 21};
    }

    static {
        A02();
    }

    public static VideoAutoplayBehavior A00(JU ju) {
        if (ju == null) {
            return VideoAutoplayBehavior.DEFAULT;
        }
        switch (JT.A00[ju.ordinal()]) {
            case 1:
                return VideoAutoplayBehavior.DEFAULT;
            case 2:
                VideoAutoplayBehavior videoAutoplayBehavior = VideoAutoplayBehavior.ON;
                String[] strArr = A01;
                if (strArr[0].charAt(5) == strArr[4].charAt(5)) {
                    A01[2] = "D4DDJWMfk";
                    return videoAutoplayBehavior;
                }
                String[] strArr2 = A01;
                strArr2[0] = "jNXTJSXFaHaCK7i5lqJo4GmnkgAhCocQ";
                strArr2[4] = "apiAoBnIaWOp8nG5E1dZaMbzfZqR1u59";
                return videoAutoplayBehavior;
            case 3:
                return VideoAutoplayBehavior.OFF;
            default:
                VideoAutoplayBehavior videoAutoplayBehavior2 = VideoAutoplayBehavior.DEFAULT;
                if (A01[1].charAt(9) != 'M') {
                    A01[5] = "KWBYg9gUO";
                    return videoAutoplayBehavior2;
                }
                throw new RuntimeException();
        }
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static JU[] valuesCustom() {
        JU[] valuesCustom = values();
        if (A01[1].charAt(9) != 'M') {
            String[] strArr = A01;
            strArr[6] = "qrA";
            strArr[3] = "mB";
            return (JU[]) valuesCustom.clone();
        }
        throw new RuntimeException();
    }
}

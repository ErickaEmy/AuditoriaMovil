package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdExperienceType;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.2G  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C2G {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 23);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-126, -123, Byte.MIN_VALUE, -122, -103, -111, -122, -109, -118, -122, -113, -124, -122, Byte.MIN_VALUE, -124, -112, -113, -121, -118, -120, Byte.MIN_VALUE, -118, -113, -107, -122, -109, -108, -107, -118, -107, -118, -126, -115, -39, -36, -41, -35, -16, -24, -35, -22, -31, -35, -26, -37, -35, -41, -37, -25, -26, -34, -31, -33, -41, -22, -35, -17, -39, -22, -36, -35, -36, -41, -31, -26, -20, -35, -22, -21, -20, -31, -20, -31, -39, -28};
    }

    public static AdExperienceType A00(String str) {
        if (str == null) {
            return null;
        }
        if (A01(0, 33, 10).equals(str)) {
            return AdExperienceType.AD_EXPERIENCE_TYPE_INTERSTITIAL;
        }
        if (A01(33, 42, 97).equals(str)) {
            return AdExperienceType.AD_EXPERIENCE_TYPE_REWARDED_INTERSTITIAL;
        }
        return AdExperienceType.AD_EXPERIENCE_TYPE_REWARDED;
    }

    public static String A02(AdExperienceType adExperienceType) {
        return adExperienceType.getAdExperienceType();
    }
}

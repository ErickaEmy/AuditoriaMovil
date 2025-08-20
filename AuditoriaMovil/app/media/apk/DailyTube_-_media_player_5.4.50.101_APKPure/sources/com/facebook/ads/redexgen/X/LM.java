package com.facebook.ads.redexgen.X;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public abstract class LM {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 126);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{38, 42, 40, 107, 35, 36, 38, 32, 39, 42, 42, 46, 107, 46, 36, 49, 36, 43, 36};
    }

    public static PackageInfo A00(C04447f c04447f) {
        return A01(c04447f, A02(0, 19, 59));
    }

    public static PackageInfo A01(C04447f c04447f, String str) {
        PackageManager packageManager;
        if (TextUtils.isEmpty(str) || (packageManager = c04447f.getPackageManager()) == null) {
            return null;
        }
        try {
            return packageManager.getPackageInfo(str, 1);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        } catch (RuntimeException unused2) {
            return null;
        }
    }

    public static boolean A04(C04447f c04447f, String str) {
        PackageInfo packageInfo = A01(c04447f, str);
        return packageInfo != null;
    }
}

package com.facebook.ads.redexgen.X;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class LE {
    public static byte[] A00;
    public static final String A01;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 89);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{108, 78, 65, 8, 91, 15, 75, 74, 91, 74, 93, 66, 70, 65, 74, 15, 70, 73, 15, 78, 95, 95, 15, 70, 92, 15, 122, 65, 70, 91, 86, 1, 24, 34, 113, 4, 63, 56, 37, 40, 113, 48, 33, 33, 107, 113, 118, 122, 120, 59, 115, 116, 118, 112, 119, 122, 122, 126, 59, 103, 112, 116, 118, 97, 59, 71, 112, 116, 118, 97, 84, 118, 97, 124, 99, 124, 97, 108, 4, 8, 10, 73, 18, 9, 14, 19, 30, 84, 3, 73, 23, 11, 6, 30, 2, 21, 73, 50, 9, 14, 19, 30, 55, 11, 6, 30, 2, 21, 38, 4, 19, 14, 17, 14, 19, 30};
    }

    static {
        A01();
        A01 = LE.class.getSimpleName();
    }

    public static boolean A02() {
        try {
            Class.forName(A00(46, 32, 76));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean A03() {
        try {
            Class.forName(A00(78, 38, 62));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean A04(int i, int i5) {
        return i >= 640 && i5 >= 640;
    }

    public static boolean A05(C04447f c04447f) {
        boolean z2 = false;
        try {
            PackageManager packageManager = c04447f.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            boolean isUnity = true;
            ActivityInfo[] activityInfoArr = packageManager.getPackageInfo(c04447f.getPackageName(), 1).activities;
            if (activityInfoArr != null) {
                int length = activityInfoArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    boolean activityDeclared = A00(78, 38, 62).equals(activityInfoArr[i].name);
                    if (!activityDeclared) {
                        i++;
                    } else {
                        z2 = true;
                        break;
                    }
                }
            }
            if (!z2) {
                boolean activityDeclared2 = A03();
                if (!activityDeclared2) {
                    isUnity = false;
                }
            }
            boolean activityDeclared3 = c04447f.A04().A8z();
            if (activityDeclared3) {
                String str = A00(32, 14, 8) + isUnity;
            }
            return isUnity;
        } catch (Throwable th) {
            if (c04447f.A04().A8z()) {
                Log.e(A01, A00(0, 32, 118), th);
            }
            return false;
        }
    }
}

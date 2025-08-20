package com.hjq.permissions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
@SuppressLint({"AnnotateVersionCheck"})
/* loaded from: classes.dex */
final class AndroidVersion {
    public static int getAndroidVersionCode() {
        return Build.VERSION.SDK_INT;
    }

    public static int getTargetSdkVersionCode(Context context) {
        return context.getApplicationInfo().targetSdkVersion;
    }

    public static boolean isAndroid10() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    public static boolean isAndroid11() {
        if (Build.VERSION.SDK_INT >= 30) {
            return true;
        }
        return false;
    }

    public static boolean isAndroid12() {
        if (Build.VERSION.SDK_INT >= 31) {
            return true;
        }
        return false;
    }

    public static boolean isAndroid13() {
        if (Build.VERSION.SDK_INT >= 33) {
            return true;
        }
        return false;
    }

    public static boolean isAndroid4() {
        return true;
    }

    public static boolean isAndroid4_2() {
        return true;
    }

    public static boolean isAndroid4_3() {
        return true;
    }

    public static boolean isAndroid5() {
        return true;
    }

    public static boolean isAndroid5_1() {
        if (Build.VERSION.SDK_INT >= 22) {
            return true;
        }
        return false;
    }

    public static boolean isAndroid6() {
        if (Build.VERSION.SDK_INT >= 23) {
            return true;
        }
        return false;
    }

    public static boolean isAndroid7() {
        if (Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    public static boolean isAndroid7_1() {
        if (Build.VERSION.SDK_INT >= 25) {
            return true;
        }
        return false;
    }

    public static boolean isAndroid8() {
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    public static boolean isAndroid9() {
        if (Build.VERSION.SDK_INT >= 28) {
            return true;
        }
        return false;
    }
}

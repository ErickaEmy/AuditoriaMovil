package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewParent;
import com.uv.v7.R;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.3i  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C03513i {
    public static byte[] A00;
    public static String[] A01 = {"Xrw23x", "7zPMnydgs3TxzLPidxoXPZBjc3W6JcCM", "VSpvz3ms1TmmGNHPZhiUX8aR3VKIqH3F", "EaUoYVziD6tZiyhi6MmXXr0L0WyyrmGO", "9W1llKphA1b", "WQVWtmgxG", "pfsLxZCw3", "djLiMbltlOZxr4Y20a1py0MoB6XUOCsc"};

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A01[4].length() == 2) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[1] = "srEyXaBrGYJEdyGE0emXwaTG9JSL50Tx";
            strArr[3] = "2nDKISaqZLGgZgCCbZWXnJ7EV4EzVcvR";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 63);
            i8++;
        }
    }

    public static void A01() {
        A00 = new byte[]{-65, -66, -98, -75, -61, -60, -75, -76, -106, -68, -71, -66, -73, -59, -60, -92, -69, -55, -54, -69, -70, -90, -56, -69, -100, -62, -65, -60, -67, 26, 25, -7, 16, 30, 31, 16, 15, -5, 29, 16, -2, 14, 29, 26, 23, 23, -26, -27, -59, -36, -22, -21, -36, -37, -54, -38, -23, -26, -29, -29, 28, 27, -5, 18, 32, 33, 18, 17, 0, 16, 31, 28, 25, 25, -18, 16, 16, 18, 29, 33, 18, 17, -50, -51, -78, -45, -64, -47, -45, -83, -60, -46, -45, -60, -61, -78, -62, -47, -50, -53, -53, 45, 44, 17, 50, 45, 46, 12, 35, 49, 50, 35, 34, 17, 33, 48, 45, 42, 42};
    }

    static {
        A01();
    }

    public void A03(ViewParent viewParent, View view) {
        if (0 != 0) {
            throw new NullPointerException(A00(101, 18, 127));
        }
    }

    public void A04(ViewParent viewParent, View view, int i, int i5, int i6, int i8) {
        if (0 != 0) {
            throw new NullPointerException(A00(46, 14, 56));
        }
    }

    public void A05(ViewParent viewParent, View view, int i, int i5, int[] iArr) {
        if (0 != 0) {
            throw new NullPointerException(A00(29, 17, 108));
        }
    }

    public void A06(ViewParent viewParent, View view, View view2, int i) {
        if (0 != 0) {
            throw new NullPointerException(A00(60, 22, R.styleable.AppCompatTheme_textColorAlertDialogListItem));
        }
    }

    public boolean A07(ViewParent viewParent, View view, float f4, float f6) {
        if (0 != 0) {
            throw new NullPointerException(A00(13, 16, 23));
        }
        String[] strArr = A01;
        if (strArr[1].charAt(19) != strArr[3].charAt(19)) {
            throw new RuntimeException();
        }
        A01[2] = "2JlvdJxfzc676EJF51BR6DiplsSASM3N";
        return false;
    }

    public boolean A08(ViewParent viewParent, View view, float f4, float f6, boolean z2) {
        if (0 != 0) {
            throw new NullPointerException(A00(0, 13, 17));
        }
        return false;
    }

    public boolean A09(ViewParent viewParent, View view, View view2, int i) {
        if (0 != 0) {
            throw new NullPointerException(A00(82, 19, 32));
        }
        return false;
    }
}

package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Build;
import com.uv.v7.R;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Ii  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0706Ii {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 118);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{123, 126, 116, 109, 69, 123, 116, 126, 104, 117, 115, 126, 69, 123, 118, 118, 117, 109, 69, 115, 123, 120, 69, 121, 117, 116, 110, Byte.MAX_VALUE, 98, 110, 69, 109, 104, 123, 106, 106, Byte.MAX_VALUE, 104, 69, 121, 104, Byte.MAX_VALUE, 123, 110, 115, 117, 116, 100, 97, 107, 114, 90, 100, 107, 97, 119, 106, 108, 97, 90, 96, 107, 100, 103, 105, 96, 90, 108, 107, 90, 100, 117, 117, 90, 103, 119, 106, 114, 118, 96, 119, 90, 99, 108, 105, 96, 90, 102, 109, 106, 106, 118, 96, 119, 119, 114, 120, 97, 73, 119, 120, 114, 100, 121, Byte.MAX_VALUE, 114, 73, 115, 120, 119, 116, 122, 115, 73, Byte.MAX_VALUE, 120, 73, 119, 102, 102, 73, 116, 100, 121, 97, 101, 115, 100, 73, 120, 119, 96, Byte.MAX_VALUE, 113, 119, 98, Byte.MAX_VALUE, 121, 120, 101, 96, 106, 115, 91, 101, 106, 96, 118, 107, 109, 96, 91, 109, 101, 102, 91, 109, 105, 116, 118, 107, 114, 97, 91, 102, 118, 107, 115, 119, 109, 106, 99, 91, 103, 101, 116, 101, 102, 109, 104, 109, 112, 109, 97, 119, 76, 73, 67, 90, 114, 72, 67, 76, 79, 65, 72, 114, 68, 76, 79};
    }

    public static boolean A02(Context context) {
        return C0705Ih.A0R(context).A2Z(A00(0, 47, 108), true);
    }

    public static boolean A03(Context context) {
        return C0705Ih.A0R(context).A2Z(A00(47, 47, R.styleable.AppCompatTheme_tooltipFrameBackground), false);
    }

    public static boolean A04(Context context) {
        return C0705Ih.A0R(context).A2Z(A00(139, 46, R.styleable.AppCompatTheme_tooltipForegroundColor), false);
    }

    public static boolean A05(Context context) {
        return Build.VERSION.SDK_INT >= 19 && C0705Ih.A0R(context).A2Z(A00(185, 15, 91), false);
    }

    public static boolean A06(Context context) {
        return C0705Ih.A0R(context).A2Z(A00(94, 45, 96), false);
    }
}

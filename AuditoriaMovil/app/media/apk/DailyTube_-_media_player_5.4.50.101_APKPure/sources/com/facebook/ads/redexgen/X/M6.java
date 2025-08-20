package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.app.KeyguardManager;
import android.util.Log;
import android.view.Window;
import com.uv.v7.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class M6 {
    public static byte[] A00;
    public static String[] A01 = {"75", "", "84T1cPcVhFaG3gZ5iFCuz5VGfvW435Ys", "hmgtvPST3LKdfFpjmmFZYvFoyIGtsiKE", "1o0hQSlG2MREJWQYXtVsar2Zo68mKpVL", "LjPyS32kIH6YipP2gsYrsbvo7R8K", "pRhgJcRZc8j2ATnbWVmWTgInp0JNCNsL", "EpPf5pm3Rz1UtI6LaI9QQC8GFK2ymH0S"};
    public static final String A02;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ R.styleable.AppCompatTheme_tooltipFrameBackground);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{75, 44, 126, 67, 88, 94, 75, 79, 82, 84, 85, 27, 82, 85, 27, 76, 82, 85, 95, 84, 76, 27, 82, 85, 93, 84, 27, 88, 83, 94, 88, 80, 28, 18, 14, 16, 2, 22, 5, 19, 119, 123, 110, 115, 104, 114, 106, 120, 10, 27, 25, 22, 26, 22, 7, 18, 22, 13, 90, 89};
    }

    static {
        A02();
        A02 = M6.class.getSimpleName();
    }

    public static Map<String, String> A01(C1116Yn c1116Yn) {
        Window window;
        HashMap hashMap = new HashMap();
        if (c1116Yn == null) {
            return hashMap;
        }
        try {
            hashMap.put(A00(40, 3, R.styleable.AppCompatTheme_textColorSearchUrl), String.valueOf(A04(c1116Yn)));
            Activity A0D = c1116Yn.A0D();
            if (A0D != null && (window = A0D.getWindow()) != null) {
                int i = window.getAttributes().flags;
                int flags = window.getAttributes().type;
                hashMap.put(A00(58, 2, 94), Integer.toString(flags));
                int type = 4194304 & i;
                String A002 = A00(1, 1, R.styleable.AppCompatTheme_textColorAlertDialogListItem);
                String A003 = A00(0, 1, 8);
                hashMap.put(A00(48, 5, 14), type > 0 ? A002 : A003);
                if (A01[1].length() == 23) {
                    throw new RuntimeException();
                }
                A01[7] = "fwmMHJhcrVWyeAGw8Re8ymmckApbJBDL";
                int type2 = 524288 & i;
                if (type2 <= 0) {
                    A002 = A003;
                }
                hashMap.put(A00(53, 5, 18), A002);
            }
        } catch (Exception e2) {
            Log.e(A02, A00(2, 30, 72), e2);
            AnonymousClass89 A07 = c1116Yn.A07();
            int type3 = C8A.A2T;
            A07.A9a(A00(43, 5, R.styleable.AppCompatTheme_tooltipForegroundColor), type3, new C8B(e2));
        }
        return hashMap;
    }

    public static boolean A03(C1116Yn c1116Yn) {
        return !C0784Lp.A04(A01(c1116Yn));
    }

    public static boolean A04(C1116Yn c1116Yn) {
        KeyguardManager keyguardManager = (KeyguardManager) c1116Yn.getSystemService(A00(32, 8, 4));
        return keyguardManager != null && keyguardManager.inKeyguardRestrictedInputMode();
    }
}

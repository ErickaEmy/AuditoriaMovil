package com.facebook.ads.redexgen.X;

import android.app.KeyguardManager;
import android.content.Context;
import java.util.Arrays;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Lp  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0784Lp {
    public static byte[] A00;
    public static String[] A01 = {"daXn", "1AEGGiZtK9izNwxj0gdNwiRX4yxGSLbl", "jWJWqJI6vm3EcSkucHo8Z2hc4QqQU5eN", "kJ80Vw1lOC47iRluFhEDeBzKcKjW1m8D", "UFa447OZZwRnjgAwYt6DClQrKKYck", "JtTOAq931RuxhQ9Tu1gEBrllAq", "KlezWCwDulS1StSn2NonTUsqgHFd0zlY", "hQC1wn7yR06U4qX9nCxzTugCr"};
    public static final String A02;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 14);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-67, -13, -19, 1, -17, -3, -23, -6, -20, -100, -104, -93, -94, -96, -93, -109, -91, -108, -110, -103, -107, -84, -101, -88, -84, -95};
    }

    static {
        A01();
        A02 = C0784Lp.class.getSimpleName();
    }

    public static boolean A02(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(A00(1, 8, 122));
        return keyguardManager != null && keyguardManager.inKeyguardRestrictedInputMode();
    }

    public static boolean A03(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return false;
        }
        String str = map.get(A00(16, 5, 32));
        String str2 = map.get(A00(21, 5, 39));
        String keyguardRestrictedInputMode = map.get(A00(9, 3, 35));
        if (str != null) {
            String[] strArr = A01;
            if (strArr[0].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            A01[7] = "KnKdjir99deazR25n";
            String flagDismissKeyguard = A00(0, 1, 126);
            if (str.equals(flagDismissKeyguard) && str2 != null && str2.equals(flagDismissKeyguard) && keyguardRestrictedInputMode != null && keyguardRestrictedInputMode.equals(A00(12, 4, 32))) {
                return true;
            }
        }
        return false;
    }

    public static boolean A04(Map<String, String> map) {
        String keyguardRestrictedInputMode;
        if (map == null || map.isEmpty()) {
            return false;
        }
        String str = map.get(A00(16, 5, 32));
        String str2 = map.get(A00(21, 5, 39));
        String flagDismissKeyguard = A00(0, 1, 126);
        return (str == null || !str.equals(flagDismissKeyguard)) && (str2 == null || !str2.equals(flagDismissKeyguard)) && (keyguardRestrictedInputMode = map.get(A00(9, 3, 35))) != null && keyguardRestrictedInputMode.equals(A00(12, 4, 32));
    }
}

package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Ld  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0772Ld {
    public static byte[] A00;
    public static String[] A01 = {"jOafuIGjbmGqGJCoIRCXQtou", "4aVS6XGMEh0UEp1LrL0", "WT7BdI1qWTWyKDUxoAWdDMpw07Ptfw8", "q0ourOn8MOENNWhqaGRKGcv5B4gp2pTE", "Hqz5MCTyQHD2ORxnmIkx6S6it7H3yU", "Fz45vwCH8U7UwOfOH", "", "zqPhk"};

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 90);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-47, -34, -44, -30, -33, -39, -44, -98, -32, -43, -30, -35, -39, -29, -29, -39, -33, -34, -98, -79, -77, -77, -75, -61, -61, -49, -66, -75, -60, -57, -65, -62, -69, -49, -61, -60, -79, -60, -75, 41, 53, 52, 52, 43, 41, 58, 47, 60, 47, 58, 63};
    }

    static {
        A02();
    }

    public static EnumC0771Lc A00(Context context) {
        int result = context.checkCallingOrSelfPermission(A01(0, 39, 22));
        if (result != 0) {
            return EnumC0771Lc.A08;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(A01(39, 12, 108))).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return EnumC0771Lc.A07;
        }
        int result2 = activeNetworkInfo.getType();
        if (result2 == 0) {
            int result3 = activeNetworkInfo.getSubtype();
            switch (result3) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return EnumC0771Lc.A03;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    EnumC0771Lc enumC0771Lc = EnumC0771Lc.A04;
                    String[] strArr = A01;
                    String str = strArr[7];
                    String str2 = strArr[1];
                    int length = str.length();
                    int result4 = str2.length();
                    if (length != result4) {
                        String[] strArr2 = A01;
                        strArr2[5] = "oOnk32K9Wq3P4PSiK";
                        strArr2[2] = "1DJY3gVRyF4DGenl9OyLPgUFJXOtxby";
                        return enumC0771Lc;
                    }
                    throw new RuntimeException();
                case 13:
                    return EnumC0771Lc.A05;
                default:
                    return EnumC0771Lc.A08;
            }
        }
        return EnumC0771Lc.A06;
    }
}

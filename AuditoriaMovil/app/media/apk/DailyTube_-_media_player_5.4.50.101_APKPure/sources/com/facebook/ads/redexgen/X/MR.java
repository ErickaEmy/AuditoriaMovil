package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.view.View;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public abstract class MR {
    public static byte[] A00;
    public static String[] A01 = {"Ja1bzDC4XO6MJovALms6", "IsGiV6tW8eEZvxsgDHoXbhWPQfEYRFJe", "F2wXUvOdg1ErZ5Wo6Cgjufn4T4zC8kyY", "0BOYk9mrV7ZAWg7WZWP8YYSS1bLPwSw8", "ohe2pYr3qvUc9pGZYOoHj0caDSEXBlEt", "i3VOTigCB6pNI1", "51BdPbZeK1jUSv1wKhHS", "aZfUmaE3Xil8RoSsFIMTsgdGf"};

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A01;
            if (strArr[1].charAt(18) != strArr[4].charAt(18)) {
                throw new RuntimeException();
            }
            A01[3] = "NODd4hgwoPsa2k2MnOsaUDtymSUydbAu";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 118);
            i8++;
        }
    }

    public static void A02() {
        A00 = new byte[]{61, 57, 58, 14, 31, 18, 30, 21, 24, 30, 53, 30, 15, 12, 20, 9, 16, 9, 46, 38, 35, 111, 59, 32, 111, 61, 42, 33, 43, 42, 61, 111, 1, 46, 59, 38, 57, 42, 111, 59, 42, 34, 63, 35, 46, 59, 42, 97, 111, 10, 34, 63, 59, 54, 111, 14, 33, 43, 61, 32, 38, 43, 111, 25, 38, 42, 56, 111, 56, 38, 35, 35, 111, 45, 42, 111, 61, 42, 59, 58, 61, 33, 42, 43, 97, 52, 59, 46, 51, 44, 63, 5, 46, 63, 55, 42, 54, 59, 46, 63};
    }

    static {
        A02();
    }

    public static View A00(C1116Yn c1116Yn, Throwable th) {
        A03(c1116Yn, th);
        return new View(c1116Yn);
    }

    public static void A03(C1116Yn c1116Yn, Throwable th) {
        c1116Yn.A07().A9a(A01(85, 15, 44), C8A.A1w, new C8B(th));
        Log.e(A01(0, 17, 13), A01(17, 68, 57), th);
    }
}

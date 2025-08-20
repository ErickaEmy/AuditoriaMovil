package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.api.NativeAdRatingApi;
import java.util.Arrays;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public final class JQ implements NativeAdRatingApi {
    public static byte[] A02;
    public static String[] A03 = {"toY9r3GQ2V7oewvjptOzxrS3bXTXc0RA", "sNtoNgmSnc6mPwk", "sqn4euFoJMrOy6w1WzpNZbp0V46mSpuW", "EIfja0hemr4BNawwCcQfaPCPd3YJxnrU", "sMAw2w80fDiQYhU2W3UNXvphSzhcHd9d", "R2iCm9V8pMi0V4JYCgbimpTTwdawvKsh", "0MIfAaRYFlqcluCsT0Dbw6pT1oX0sCn1", "WyAiIZ6R26Fzk5qwkokaejcEGkdnjEqF"};
    public final double A00;
    public final double A01;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A03;
            if (strArr[3].charAt(20) == strArr[0].charAt(20)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[6] = "2hoOF1EBiwOhqbt1DT56iNDNNWb8yQHz";
            strArr2[2] = "W6hI53UtRDHSRmbx8lgXTECIFUbvBxjr";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 92);
            i8++;
        }
    }

    public static void A02() {
        A02 = new byte[]{113, 97, 99, 110, 103, 100, 115, 126, 103, 119};
    }

    static {
        A02();
    }

    public JQ(double d2, double d3) {
        this.A01 = d2;
        this.A00 = d3;
    }

    public static JQ A00(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String A01 = A01(5, 5, 78);
        if (A03[1].length() == 15) {
            A03[5] = "RjFVMQXNPaplscouVMfMFZlHjMQAuEdy";
            double optDouble = jSONObject.optDouble(A01, 0.0d);
            double mValue = jSONObject.optDouble(A01(0, 5, 94), 0.0d);
            if (optDouble != 0.0d) {
                int i = (mValue > 0.0d ? 1 : (mValue == 0.0d ? 0 : -1));
                if (A03[5].charAt(0) == 'R') {
                    String[] strArr = A03;
                    strArr[6] = "dPMTjBEXFaKbbBBBm4MCfcS4F7X28Hbr";
                    strArr[2] = "0dli5ldtNE7riKXsyOdCpznATSfs344b";
                    if (i != 0) {
                        return new JQ(optDouble, mValue);
                    }
                }
            }
            return null;
        }
        throw new RuntimeException();
    }

    public final double getScale() {
        return this.A00;
    }

    public final double getValue() {
        return this.A01;
    }
}

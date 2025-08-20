package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public final class FT extends AbstractC1219b5 {
    public static byte[] A00 = null;
    public static String[] A01 = {"jMc", "F9KJU5nWCxEJfH1MtrJPQ98rlg2xhqhb", "7jNlYgKw34wypv3TsOCVRM97qni1IFkS", "W5gvHzH3tQhCbbf1Q7sr07NWbFeRHxz0", "QDsxhdyObZs2LD8uuSUlwesP8VUImdt4", "RqkZZA1TQwwc7Sj8gFRGBwQRvCLKOG1p", "3", "FXFS7BhAGvbRYPXLgdilxhgSLH2Ol13Z"};
    public static final long serialVersionUID = 5751287062553772012L;

    public static String A03(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A01[0].length() == 16) {
                throw new RuntimeException();
            }
            A01[0] = "basKOcZiobbMvO07tra14WeVIAzrAzDF";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 105);
            i8++;
        }
    }

    public static void A04() {
        A00 = new byte[]{5, -8, 11, 0, 13, -4};
    }

    static {
        A04();
    }

    public FT(List<C1G> list) {
        super(list);
    }

    public static FT A02(JSONObject jSONObject, C1116Yn c1116Yn) {
        FT ft2 = new FT(AbstractC1219b5.A08(jSONObject, c1116Yn, new C1215b1()));
        ft2.A16(jSONObject);
        ft2.A0b(A03(0, 6, 46));
        return ft2;
    }

    @Override // com.facebook.ads.redexgen.X.C1F
    public final int A0F() {
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.C1F
    public final int A0G() {
        return 0;
    }
}

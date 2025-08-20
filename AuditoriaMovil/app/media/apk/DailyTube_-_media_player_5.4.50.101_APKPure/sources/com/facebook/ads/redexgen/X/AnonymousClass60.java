package com.facebook.ads.redexgen.X;

import com.uv.v7.R;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.60  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class AnonymousClass60 {
    public static byte[] A05;
    public static String[] A06 = {"IwGe5", "A8hIbHDMwIY7UKVNAHeGtwBKmCoLBNcL", "H0VvdZkQPfl9GvywbKbTAVPvkC7BvFU0", "eeDLrDiwzyZn1GaqUg9DZO06uYqn8isf", "TZh0Sw2dsxVxMXdj340dFQnUzLECuqag", "hGyVADXG58acDgE3vIJwpiBKlvJlQGRP", "AZD8DY1XKqK1C1MVAOcMuffFLS19AWBn", "fc6abssWsZoyWpr8fCHyT3ixVlnX2HG2"};
    public final String A00;
    public final String A01;
    public final String A02;
    public final String A03;
    public final boolean A04;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A06[0].length() == 12) {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[1] = "eS8IZAPFQFjEXoH0I8GlghTr6fGbdCZa";
            strArr[4] = "ifP5S9CdlxshggXp37TrbEl199f16GUc";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 36);
            i8++;
        }
    }

    public static void A02() {
        A05 = new byte[]{-32, -21, -24, -32, -14, -49, -30, -34, -49, -40, -35, -45, -39, -40, -4, -3, 1, -10, -4, -5, -18, -7, 2, 0, 3, -13, 1, 6, -3, -14, -22, -25, -31};
        if (A06[3].charAt(4) != 'r') {
            throw new RuntimeException();
        }
        A06[0] = "hOpRzb1kYAh4f";
    }

    static {
        A02();
    }

    public AnonymousClass60(String str, String str2, String str3, boolean z2, String str4) {
        this.A03 = str;
        this.A02 = str2;
        this.A01 = str3;
        this.A04 = z2;
        this.A00 = str4;
    }

    public static AnonymousClass60 A00(JSONObject jSONObject) throws JSONException {
        return new AnonymousClass60(jSONObject.getString(A01(30, 3, 81)), jSONObject.getString(A01(26, 4, 105)), jSONObject.optString(A01(5, 9, 70)), jSONObject.getString(A01(14, 8, 105)).equals(A01(22, 4, R.styleable.AppCompatTheme_textAppearancePopupMenuHeader)), jSONObject.optString(A01(0, 5, 91)));
    }
}

package com.facebook.ads.redexgen.X;

import com.uv.v7.R;
import java.io.Serializable;
import java.util.Arrays;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.1G  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C1G implements Serializable {
    public static byte[] A0A = null;
    public static String[] A0B = {"R5DeYR6FKIddoQ1tNFb4QO1F3D7YHRG7", "hniB1BSXMiqlCD6U", "jhH7rQZzgqsha0FGspkq8z1DrJIjsBJk", "lw6F7y1SoSoTAEcdzLyYaN1xEC1Q2oWX", "ic1GHkKPsX6vyCRQCqNODZsBJ", "Aw8qdmnq9PbtDTR9ez9n3jUjtBry3vCr", "3as5zHbOptZ96SzIdP7nSqOic", "mvWErpvjRXL0vWcjCyiUNQO7TD5zouZh"};
    public static final long serialVersionUID = 85021702336014823L;
    public C1I A00;
    public C1J A01;
    public C1N A02;
    public C1Q A03;
    public C1R A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0A, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            byte b2 = (byte) ((copyOfRange[i8] ^ i6) ^ 58);
            String[] strArr = A0B;
            if (strArr[3].charAt(22) != strArr[0].charAt(22)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0B;
            strArr2[2] = "LXXQrjhAH5CnLq5fKQjRUnrA3R85ks8i";
            strArr2[7] = "Vzc9rcIkwZ9oA3QEo9fi0aCOPKhgVZjz";
            copyOfRange[i8] = b2;
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A0A = new byte[]{61, 0, 84, 3, 29, 24, 24, 84, 21, 1, 0, 27, 25, 21, 0, 29, 23, 21, 24, 24, 13, 84, 27, 4, 17, 26, 84, 29, 26, 84, 47, 7, 17, 23, 7, 41, 7, 116, 113, 74, 118, 103, 112, 116, 97, 124, 99, 112, 74, 97, 108, 101, 112, 117, 120, 115, 110, 15, 24, 25, 25, 2, 3, 50, 4, 14, 2, 3, 23, 21, 24, 24, 43, 0, 27, 43, 21, 23, 0, 29, 27, 26, 1, 3, 22, 7, 5, 13, 16, 27, 92, 93, 84, 89, 65, 103, 91, 84, 81, 91, 83, 103, 76, 93, 64, 76, 87, 86, 64, 71, 90, 93, 82, 71, 90, 92, 93, 108, 71, 90, 71, 95, 86, 56, 51, 57, 2, 62, 60, 47, 57, 2, 59, 50, 47, 62, 56, 2, 43, 52, 56, 42, 2, 41, 52, 48, 56, 74, 65, 75, 112, 76, 78, 93, 75, 112, 70, 66, 78, 72, 74, 92, 82, 86, 85, 80, 107, 87, 91, 89, 89, 85, 90, 80, 44, 46, 37, 46, 57, 34, 40, 20, 63, 46, 51, 63, 6, 11, 7, 9, 6, 26, 64, 68, 72, 78, 76, 60, 38, 10, 39, 48, 34, 52, 39, 49, 48, 49, 10, 52, 49, 31, 5, 41, 0, 31, 18, 19, 25, 41, 23, 3, 18, 31, 25, 41, 27, 3, 2, 19, 18, 73, 83, Byte.MAX_VALUE, 87, 65, 84, 67, 72, Byte.MAX_VALUE, 65, 78, 68, Byte.MAX_VALUE, 66, 82, 79, 87, 83, 69, 43, 56, 45, 48, 55, 62, 6, 58, 54, 44, 55, 45, 47, 60, 41, 52, 51, 58, 2, 43, 60, 49, 40, 56, 67, 85, 83, 95, 94, 84, 67, 111, 86, 95, 66, 111, 66, 85, 71, 81, 66, 84, 9, 18, 21, 13, 37, 31, 20, 30, 37, 25, 27, 8, 30, 43, 48, 55, 47, 7, 61, 32, 49, 44, 7, 44, 42, 57, 54, 43, 49, 44, 49, 55, 54, 48, 43, 44, 52, 28, 42, 45, 55, 49, 44, 28, 55, 49, 34, 45, 48, 42, 55, 42, 44, 45, 71, 95, 93, 68, 107, 85, 90, 80, 107, 88, 91, 71, 81, 107, 70, 81, 67, 85, 70, 80, 105, 113, 115, 106, 106, 123, 120, 118, Byte.MAX_VALUE, 69, 105, Byte.MAX_VALUE, 121, 117, 116, 126, 105, 70, 90, 86, 92, 84, 89, 106, 86, 90, 91, 65, 80, 77, 65, 52, 50, 37, 51, 46, 51, 43, 34, 76, 81, 76, 84, 93, 117, 110, 115, 107, 105, 112, 112, 97, 98, 108, 101, 95, 115, 101, 99, 111, 110, 100, 115, 39, 32, 62, 118, 105, 100, 101, 111, 95, 97, 117, 116, 111, 112, 108, 97, 121, 95, 101, 110, 97, 98, 108, 101, 100, 36, 59, 54, 55, 61, 13, 54, 39, 32, 51, 38, 59, 61, 60, 13, 33, 55, 49, 113, 110, 99, 98, 104, 88, 119, 117, 98, 107, 104, 102, 99, 88, 116, 110, 125, 98, 88, 101, 126, 115, 98, 116, 89, 70, 75, 74, 64, 112, 90, 93, 67, 80, 78, 67, 83, 79};
    }

    static {
        A03();
    }

    public static C1G A00(JSONObject jSONObject) {
        int optInt;
        C1G c1g = new C1G();
        c1g.A06(new C1M().A0H(jSONObject.optString(A01(405, 5, 2))).A0G(jSONObject.optString(A01(397, 8, 125))).A0B(jSONObject.optString(A01(53, 4, 45))).A0F(jSONObject.optString(A01(383, 14, 15))).A0E(jSONObject.optString(A01(262, 12, 103))).A0D(jSONObject.optString(A01(250, 12, 99))).A09(jSONObject.optString(A01(37, 16, 47))).A0A(jSONObject.optString(A01(82, 8, 88))).A0C(jSONObject.optString(A01(R.styleable.AppCompatTheme_textAppearancePopupMenuHeader, 17, 9))).A0I());
        c1g.A07(new C1Q(jSONObject.optString(A01(162, 12, 14)), jSONObject.optString(A01(68, 14, 78)), jSONObject.optJSONObject(A01(57, 11, 87)), jSONObject.optString(A02(jSONObject))));
        String A01 = A01(410, 19, 58);
        if (jSONObject.optInt(A01, -1) == -1) {
            if (A0B[1].length() == 16) {
                A0B[5] = "m0SNHJxvul7tSRvrfYkKg9k0pQQtrIDe";
                optInt = jSONObject.optInt(A01(366, 17, 32), -1);
            }
            throw new RuntimeException();
        }
        optInt = jSONObject.optInt(A01, -1);
        C1I A0I = new C1I().A0J(jSONObject.optString(A01(496, 9, 21))).A0H(jSONObject.optLong(A01(472, 24, 61), -1L)).A0D(optInt).A0C(jSONObject.optInt(A01(274, 18, 10), Integer.MAX_VALUE)).A0I(C02931c.A01(jSONObject));
        JSONObject optJSONObject = jSONObject.optJSONObject(A01(192, 5, 19));
        if (optJSONObject != null) {
            C1I A0G = A0I.A0K(optJSONObject.optString(A01(429, 3, 104))).A0G(optJSONObject.optInt(A01(505, 5, 29)));
            int unskippableSeconds = A0B[1].length();
            if (unskippableSeconds == 16) {
                A0B[5] = "WsiHjZ6Ab9OhwgLQk07kFOW3FmkdrPnz";
                A0G.A0F(optJSONObject.optInt(A01(186, 6, 84)));
            }
            throw new RuntimeException();
        }
        c1g.A04(A0I);
        c1g.A0C(jSONObject.optBoolean(A01(325, 21, 121)));
        c1g.A08(new C1R(LJ.A04(jSONObject.optJSONArray(A01(147, 15, 21))), jSONObject.optLong(A01(123, 24, 103), 0L)));
        c1g.A09(jSONObject.optBoolean(A01(231, 19, 26)));
        return c1g;
    }

    public static String A02(JSONObject jSONObject) {
        String A01 = A01(90, 16, 2);
        String A012 = A01(0, 37, 78);
        String optString = jSONObject.optString(A01, A012);
        if (optString.equals(A012)) {
            JSONObject optJSONObject = jSONObject.optJSONObject(A01(174, 12, R.styleable.AppCompatTheme_toolbarStyle));
            if (optJSONObject != null) {
                A012 = optJSONObject.optString(A01, A012);
            }
            return A012;
        }
        return optString;
    }

    private void A04(C1I c1i) {
        this.A00 = c1i;
    }

    private final void A05(C1J c1j) {
        this.A01 = c1j;
    }

    private final void A06(C1N c1n) {
        this.A02 = c1n;
    }

    private final void A07(C1Q c1q) {
        this.A03 = c1q;
    }

    private final void A08(C1R c1r) {
        this.A04 = c1r;
    }

    private final void A09(boolean z2) {
        this.A06 = z2;
    }

    private final void A0A(boolean z2) {
        this.A07 = z2;
    }

    private final void A0B(boolean z2) {
        this.A08 = z2;
    }

    private final void A0C(boolean z2) {
        this.A09 = z2;
    }

    public final C1J A0D() {
        return this.A01;
    }

    public final C1N A0E() {
        return this.A02;
    }

    public final C1Q A0F() {
        return this.A03;
    }

    public final C1R A0G() {
        return this.A04;
    }

    public final void A0H(JSONObject jSONObject) {
        A05(this.A00.A0O());
    }

    public final void A0I(JSONObject jSONObject) {
        this.A00.A0M(jSONObject.optBoolean(A01(432, 22, 58)));
        this.A00.A0L(jSONObject.optBoolean(A01(211, 20, 76), true));
        A05(this.A00.A0O());
        A0L(jSONObject.optBoolean(A01(197, 14, R.styleable.AppCompatTheme_textColorSearchUrl)));
        A0A(jSONObject.optBoolean(A01(292, 13, 64)));
        A0B(jSONObject.optBoolean(A01(305, 20, 98)));
    }

    public final void A0J(JSONObject jSONObject) {
        this.A00.A0L(jSONObject.optBoolean(A01(211, 20, 76), true));
        A05(this.A00.A0O());
    }

    public final void A0K(JSONObject jSONObject) {
        this.A00.A0E(jSONObject.optInt(A01(454, 18, 104)));
        this.A00.A0L(jSONObject.optBoolean(A01(211, 20, 76), true));
        this.A00.A0N(jSONObject.optBoolean(A01(346, 20, 14), false));
        A05(this.A00.A0O());
        A0A(jSONObject.optBoolean(A01(292, 13, 64)));
    }

    public final void A0L(boolean z2) {
        this.A05 = z2;
    }

    public final boolean A0M() {
        return this.A05;
    }

    public final boolean A0N() {
        return this.A06;
    }

    public final boolean A0O() {
        return this.A07;
    }

    public final boolean A0P() {
        return this.A09;
    }
}

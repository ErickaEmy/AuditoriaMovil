package com.facebook.ads.redexgen.X;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.b3  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1217b3 extends C1F implements Serializable {
    public static byte[] A0B = null;
    public static String[] A0C = {"Y1a5U13ty71QFnyeZB3YxisAAvg7l3fM", "vP", "roZ2Db2w31DgWTY1oGehTdyGNewX8eXS", "I2NTYMYLYsNyCs0logd6ULXXnbjyHCad", "3brQnbpmNBxYuH5lF741sBi9dGi0pOZr", "3fAMLw4w5Yud0wL2utfDbR4mKZlWQuB2", "wSrWvvXZ9ekOd4qM7VWdouqMZx6NVgDc", "r9"};
    public static final long serialVersionUID = 3751287062553772011L;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public final List<AbstractC1219b5> A0A;
    public final ArrayList<Integer> A09 = new ArrayList<>();
    public boolean A07 = false;
    public boolean A06 = false;
    public boolean A05 = false;
    public String A04 = A04(190, 2, 85);
    public final String A08 = UUID.randomUUID().toString();

    public static String A04(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0B, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A0C;
            if (strArr[1].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[0] = "ksKrUe0otL7CQDvNz8iG7T5OcxZuVq1Y";
            strArr2[4] = "xaZ8PqWmutKQFInRkVw3BesrM2XhV7TN";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 107);
            i8++;
        }
    }

    public static void A05() {
        A0B = new byte[]{-17, -14, 1, -7, -2, -9, -1, 4, -11, 6, -9, 8, -9, 3, 9, 70, 75, 68, 76, 81, 72, 71, 66, 68, 71, 86, 66, 70, 82, 88, 81, 87, 76, 81, 74, 82, 87, 78, 77, 72, 74, 77, 92, 72, 86, 74, 97, 72, 77, 94, 91, 74, 93, 82, 88, 87, 74, 79, 72, 80, 85, 76, 75, 70, 72, 75, 90, 70, 93, 72, 89, 80, 76, 85, 91, -40, -35, -42, -34, -29, -34, -29, -36, -44, -37, -28, -25, -40, -38, -44, -21, -34, -38, -20, -44, -23, -34, -30, -38, -24, 61, 70, 60, 55, 59, 57, 74, 60, 55, 57, 77, 76, 71, 55, 59, 68, 71, 75, 61, 55, 76, 65, 69, 61, -26, -39, -28, -29, -26, -24, -45, -38, -35, -26, -25, -24, -45, -39, -41, -28, -31, -45, -29, -30, -32, -19, -27, -40, -29, -30, -27, -25, -46, -39, -36, -27, -26, -25, -46, -36, -32, -29, -27, -40, -26, -26, -36, -30, -31, -46, -30, -31, -33, -20, 11, 8, 4, 1, 12, -9, -2, 7, 10, -5, -3, -9, 14, 1, -3, 15, 59, 61};
    }

    static {
        A05();
    }

    public C1217b3(List<AbstractC1219b5> list) {
        this.A0A = list;
    }

    public static C1217b3 A02(JSONObject jSONObject, C1116Yn c1116Yn) throws JSONException {
        return A03(jSONObject, c1116Yn, false);
    }

    public static C1217b3 A03(JSONObject jSONObject, C1116Yn c1116Yn, boolean z2) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray(A04(0, 3, 35));
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            if (z2) {
                arrayList.add(FU.A02(jSONArray.getJSONObject(i), c1116Yn));
            } else {
                arrayList.add(FS.A02(jSONArray.getJSONObject(i), c1116Yn));
            }
        }
        C1217b3 c1217b3 = new C1217b3(arrayList);
        JSONObject chainingParams = jSONObject.getJSONObject(A04(3, 12, 43));
        c1217b3.A04 = chainingParams.toString();
        c1217b3.A01 = chainingParams.optInt(A04(15, 17, 120), arrayList.size());
        c1217b3.A03 = chainingParams.optInt(A04(32, 24, 126), 0);
        c1217b3.A02 = chainingParams.optInt(A04(100, 24, 109), 0);
        c1217b3.A00 = chainingParams.optInt(A04(56, 19, 124), 2);
        c1217b3.A0d(chainingParams);
        c1217b3.A07 = chainingParams.optBoolean(A04(174, 16, 45), false);
        c1217b3.A06 = chainingParams.optBoolean(A04(146, 28, 8), false);
        c1217b3.A05 = chainingParams.optBoolean(A04(124, 22, 9), false);
        JSONArray optJSONArray = chainingParams.optJSONArray(A04(75, 25, 10));
        if (optJSONArray != null) {
            for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                c1217b3.A09.add(Integer.valueOf(optJSONArray.optInt(i5, 0)));
            }
        }
        return c1217b3;
    }

    @Override // com.facebook.ads.redexgen.X.C1F
    public final int A0F() {
        return 2;
    }

    @Override // com.facebook.ads.redexgen.X.C1F
    public final int A0G() {
        return this.A03 + this.A02;
    }

    public final int A0r() {
        return this.A00;
    }

    public final int A0s() {
        return this.A01;
    }

    public final int A0t() {
        return this.A02;
    }

    public final AbstractC1219b5 A0u() {
        if (!this.A0A.isEmpty()) {
            AbstractC1219b5 abstractC1219b5 = this.A0A.get(0);
            if (A0C[3].charAt(30) != 'a') {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[0] = "kalcuJUd13OWB3p352R0B2fkOk5TQQvY";
            strArr[4] = "xCP6b54EQCdUXuQWfLaOcoZzurPDdDGU";
            return abstractC1219b5;
        }
        return null;
    }

    public final AbstractC1219b5 A0v(int i) {
        return this.A0A.get(i);
    }

    public final String A0w() {
        return this.A08;
    }

    public final String A0x() {
        return this.A04;
    }

    public final String A0y() {
        AbstractC1219b5 firstAdDataBundle = A0u();
        if (firstAdDataBundle != null) {
            return firstAdDataBundle.A12();
        }
        return null;
    }

    public final ArrayList<Integer> A0z() {
        return this.A09;
    }

    public final void A10(int i) {
        this.A0A.remove(i);
        this.A01--;
    }

    public final boolean A11() {
        return this.A00 == 0;
    }

    public final boolean A12() {
        return this.A05;
    }

    public final boolean A13() {
        return this.A06;
    }

    public final boolean A14() {
        return this.A07;
    }
}

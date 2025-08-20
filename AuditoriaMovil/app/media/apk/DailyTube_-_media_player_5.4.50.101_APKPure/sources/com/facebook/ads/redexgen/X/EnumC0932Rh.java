package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum A03 uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* renamed from: com.facebook.ads.redexgen.X.Rh  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class EnumC0932Rh {
    public static byte[] A00;
    public static String[] A01 = {"nA8fLeyOwVmNwvq6aIqKxCaagHA5eYr", "8Z3ODqLNUnEAqB2P3Amw9Ur1PSsugik5", "YRmdf", "zIg3Ob9eurpeZ06C2uEHUxbrUPW1iO5", "DwODnBhAs5I9lGAPLwBjllp42Gjp41Mv", "6IL6kP5nz", "IHg6IZuYXxuMxytmBHiV", "YXmTZGEBqQ8NuPQvZDB03"};
    public static final /* synthetic */ EnumC0932Rh[] A02;
    public static final EnumC0932Rh A03;
    public static final EnumC0932Rh A04;
    public static final EnumC0932Rh A05;
    public static final EnumC0932Rh A06;
    public static final EnumC0932Rh A07;
    public static final EnumC0932Rh A08;

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 4);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-82, -33, -33, -50, -26, 110, -101, -101, -104, -111, -115, -102, -103, -60, -54, -73, -63, -70, Byte.MAX_VALUE, -92, -86, 101, 120, Byte.MIN_VALUE, 123, 121, -118, 123, -100, -102, -111, -106, -113, -99, -74, -77, -74, -73, -65, -74, 104, -68, -63, -72, -83, 104, -73, -82, 104, -78, -69, -73, -74, 104, -73, -86, -78, -83, -85, -68, 104, -77, -83, -63};
    }

    public abstract boolean A04(JSONArray jSONArray, int i);

    public abstract boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i);

    public abstract boolean A06(JSONObject jSONObject, String str);

    public abstract boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str);

    static {
        A03();
        final String A022 = A02(0, 5, 105);
        EnumC0932Rh enumC0932Rh = new EnumC0932Rh(A022, 0) { // from class: com.facebook.ads.redexgen.X.J6
            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A04(JSONArray jSONArray, int i) {
                return jSONArray.optJSONArray(i) != null;
            }

            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i) {
                return AbstractC0933Ri.A01(jSONArray.optJSONArray(i), jSONArray2.optJSONArray(i));
            }

            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A06(JSONObject jSONObject, String str) {
                return jSONObject.optJSONArray(str) != null;
            }

            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                return AbstractC0933Ri.A01(jSONObject.optJSONArray(str), jSONObject2.optJSONArray(str));
            }
        };
        A03 = enumC0932Rh;
        final String A023 = A02(5, 7, 40);
        EnumC0932Rh enumC0932Rh2 = new EnumC0932Rh(A023, 1) { // from class: com.facebook.ads.redexgen.X.In
            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A04(JSONArray jSONArray, int i) {
                return jSONArray.optBoolean(i, true) == jSONArray.optBoolean(i, false);
            }

            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i) {
                return jSONArray.optBoolean(i) == jSONArray2.optBoolean(i);
            }

            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A06(JSONObject jSONObject, String str) {
                return jSONObject.optBoolean(str, true) == jSONObject.optBoolean(str, false);
            }

            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                return jSONObject.optBoolean(str) == jSONObject2.optBoolean(str);
            }
        };
        A04 = enumC0932Rh2;
        final String A024 = A02(12, 6, 81);
        EnumC0932Rh enumC0932Rh3 = new EnumC0932Rh(A024, 2) { // from class: com.facebook.ads.redexgen.X.ID
            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A04(JSONArray jSONArray, int i) {
                return jSONArray.optInt(i, 0) == jSONArray.optInt(i, 1) && jSONArray.optDouble(i, 0.0d) == jSONArray.optDouble(i, 1.0d) && ((double) jSONArray.optInt(i, 0)) != jSONArray.optDouble(i, 0.0d);
            }

            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i) {
                return jSONArray.optDouble(i) == jSONArray2.optDouble(i);
            }

            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A06(JSONObject jSONObject, String str) {
                return jSONObject.optInt(str, 0) == jSONObject.optInt(str, 1) && jSONObject.optDouble(str, 0.0d) == jSONObject.optDouble(str, 1.0d) && ((double) jSONObject.optInt(str, 0)) != jSONObject.optDouble(str, 0.0d);
            }

            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                return jSONObject.optDouble(str) == jSONObject2.optDouble(str);
            }
        };
        A05 = enumC0932Rh3;
        final String A025 = A02(18, 3, 50);
        EnumC0932Rh enumC0932Rh4 = new EnumC0932Rh(A025, 3) { // from class: com.facebook.ads.redexgen.X.I5
            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A04(JSONArray jSONArray, int i) {
                return jSONArray.optInt(i, 0) == jSONArray.optInt(i, 1) && jSONArray.optDouble(i, 0.0d) == jSONArray.optDouble(i, 1.0d) && ((double) jSONArray.optInt(i, 0)) == jSONArray.optDouble(i, 0.0d);
            }

            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i) {
                return jSONArray.optInt(i) == jSONArray2.optInt(i);
            }

            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A06(JSONObject jSONObject, String str) {
                return jSONObject.optInt(str, 0) == jSONObject.optInt(str, 1) && jSONObject.optDouble(str, 0.0d) == jSONObject.optDouble(str, 1.0d) && ((double) jSONObject.optInt(str, 0)) == jSONObject.optDouble(str, 0.0d);
            }

            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                return jSONObject.optInt(str) == jSONObject2.optInt(str);
            }
        };
        A06 = enumC0932Rh4;
        final String A026 = A02(21, 6, 18);
        EnumC0932Rh enumC0932Rh5 = new EnumC0932Rh(A026, 4) { // from class: com.facebook.ads.redexgen.X.I4
            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A04(JSONArray jSONArray, int i) {
                return jSONArray.optJSONObject(i) != null;
            }

            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i) {
                return AbstractC0933Ri.A02(jSONArray.optJSONObject(i), jSONArray2.optJSONObject(i));
            }

            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A06(JSONObject jSONObject, String str) {
                return jSONObject.optJSONObject(str) != null;
            }

            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                return AbstractC0933Ri.A02(jSONObject.optJSONObject(str), jSONObject2.optJSONObject(str));
            }
        };
        A07 = enumC0932Rh5;
        final String A027 = A02(27, 6, 36);
        EnumC0932Rh enumC0932Rh6 = new EnumC0932Rh(A027, 5) { // from class: com.facebook.ads.redexgen.X.Hx
            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A04(JSONArray jSONArray, int i) {
                return jSONArray.optString(i) != null;
            }

            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i) {
                return jSONArray.optString(i).equals(jSONArray2.optString(i));
            }

            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A06(JSONObject jSONObject, String str) {
                return jSONObject.optString(str) != null;
            }

            @Override // com.facebook.ads.redexgen.X.EnumC0932Rh
            public final boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                return jSONObject.optString(str).equals(jSONObject2.optString(str));
            }
        };
        A08 = enumC0932Rh6;
        A02 = new EnumC0932Rh[]{enumC0932Rh, enumC0932Rh2, enumC0932Rh3, enumC0932Rh4, enumC0932Rh5, enumC0932Rh6};
    }

    public EnumC0932Rh(String str, int i) {
    }

    public static EnumC0932Rh A00(JSONArray jSONArray, int i) {
        EnumC0932Rh[] values;
        for (EnumC0932Rh type : values()) {
            if (A01[1].charAt(14) != '2') {
                throw new RuntimeException();
            }
            A01[4] = "PUsgFaltT51mxPXWqnHKjq6lqfkoVDea";
            if (type.A04(jSONArray, i)) {
                return type;
            }
        }
        throw new AssertionError(A02(33, 31, 68));
    }

    public static EnumC0932Rh A01(JSONObject jSONObject, String str) {
        EnumC0932Rh[] values;
        for (EnumC0932Rh enumC0932Rh : values()) {
            boolean A062 = enumC0932Rh.A06(jSONObject, str);
            if (A01[5].length() != 9) {
                throw new RuntimeException();
            }
            A01[6] = "GmRRmI3tzaTgoS0GQtjO0";
            if (A062) {
                return enumC0932Rh;
            }
        }
        throw new AssertionError(A02(33, 31, 68));
    }

    public static EnumC0932Rh valueOf(String str) {
        return (EnumC0932Rh) Enum.valueOf(EnumC0932Rh.class, str);
    }

    public static EnumC0932Rh[] values() {
        return (EnumC0932Rh[]) A02.clone();
    }
}

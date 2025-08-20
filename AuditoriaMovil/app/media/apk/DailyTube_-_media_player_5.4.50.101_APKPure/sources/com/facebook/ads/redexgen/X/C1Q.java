package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Arrays;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.1Q  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C1Q implements Serializable {
    public static byte[] A04 = null;
    public static final long serialVersionUID = -4041915335826065133L;
    public final String A00;
    public final String A01;
    public final String A02;
    public final String A03;

    static {
        A03();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 66);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{91, 64, 89, 89, 82, 85, 75};
    }

    public C1Q(String str, String str2, JSONObject jSONObject, String str3) {
        this.A03 = A01(str);
        this.A02 = A01(str2);
        this.A00 = A01(str3);
        this.A01 = A02(jSONObject);
    }

    public static String A01(String str) {
        if (A00(0, 4, 119).equalsIgnoreCase(str)) {
            return A00(0, 0, 68);
        }
        return str;
    }

    private String A02(JSONObject jSONObject) {
        String A00 = A00(0, 0, 68);
        if (jSONObject == null) {
            return A00;
        }
        return jSONObject.optString(A00(4, 3, 101), A00);
    }

    public final String A04() {
        return this.A02;
    }

    public final String A05() {
        return this.A03;
    }

    public final boolean A06() {
        return !TextUtils.isEmpty(this.A01);
    }
}

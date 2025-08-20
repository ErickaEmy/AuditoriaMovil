package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.api.NativeAdImageApi;
import java.util.Arrays;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public final class JP implements NativeAdImageApi {
    public static byte[] A03;
    public final int A00;
    public final int A01;
    public final String A02;

    static {
        A02();
    }

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 26);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{85, 88, 84, 90, 85, 73, 92, 91, 69, 12, 18, 31, 15, 19};
    }

    public JP(String str, int i, int i5) {
        this.A02 = str;
        this.A01 = i;
        this.A00 = i5;
    }

    public static JP A00(JSONObject jSONObject) {
        String optString;
        if (jSONObject == null || (optString = jSONObject.optString(A01(6, 3, 51))) == null) {
            return null;
        }
        return new JP(optString, jSONObject.optInt(A01(9, 5, 97), 0), jSONObject.optInt(A01(0, 6, 39), 0));
    }

    public final int getHeight() {
        return this.A00;
    }

    public final String getUrl() {
        return this.A02;
    }

    public final int getWidth() {
        return this.A01;
    }
}

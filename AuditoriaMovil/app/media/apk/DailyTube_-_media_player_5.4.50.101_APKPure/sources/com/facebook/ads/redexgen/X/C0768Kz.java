package com.facebook.ads.redexgen.X;

import com.facebook.ads.ExtraHints;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.RewardedVideoAd;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Kz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0768Kz {
    public static byte[] A00;

    static {
        A04();
    }

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 39);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{121, 123, 110, 111, -120, 119, 126, 118, -120, 106, 109, 124, -120, 119, 120, -120, 108, 113, 106, 114, 119, -71, -73, -55, -71, -73, -70, -69, -70, -75, -73, -70, -25, -6, -10, -12, -29, -31, -26, -29, -10, -29, -82, -81, -76, -70, -71, -58, -57, -58, -69, -64, -71, -63, -58, -67, -68, -73, -71, -68, -53, -8, -6};
    }

    public static int A00(C1116Yn c1116Yn, int i) {
        return KE.A00(c1116Yn).getInt(A01(0, 21, 2), i);
    }

    public static String A02(C1116Yn c1116Yn, String str) {
        int A002 = A00(c1116Yn, -1);
        if (A002 == -1) {
            return null;
        }
        try {
            return new ExtraHints.Builder().extraData(A03(str, A01(47, 14, 49), Integer.valueOf(A002))).build().getHints();
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String A03(String str, String str2, Object obj) throws JSONException {
        String A01 = A01(61, 2, 86);
        if (str != null) {
            JSONObject jSONObject = new JSONObject(str);
            String extraData = A01(42, 5, 31);
            JSONObject jSONObject2 = jSONObject.getJSONObject(extraData);
            String extraData2 = A01(32, 10, 91);
            A01 = jSONObject2.optString(extraData2, A01);
        }
        JSONObject jSONObject3 = new JSONObject(A01);
        jSONObject3.put(str2, obj);
        String extraData3 = jSONObject3.toString();
        return extraData3;
    }

    public static boolean A05(String str) throws JSONException {
        return str != null && new JSONObject(new JSONObject(str).getJSONObject(A01(42, 5, 31)).optString(A01(32, 10, 91), A01(61, 2, 86))).optBoolean(A01(21, 11, 47), false);
    }

    public final InterstitialAd A06(C1116Yn c1116Yn, String str, String str2) {
        if (c1116Yn == null) {
            return null;
        }
        try {
            InterstitialAd interstitialAd = new InterstitialAd(c1116Yn, str);
            interstitialAd.setExtraHints(new ExtraHints.Builder().extraData(A03(str2, A01(21, 11, 47), true)).build());
            return interstitialAd;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final RewardedVideoAd A07(C1116Yn c1116Yn, String str, String str2) {
        if (c1116Yn == null) {
            return null;
        }
        try {
            RewardedVideoAd rewardedVideoAd = new RewardedVideoAd(c1116Yn, str);
            rewardedVideoAd.setExtraHints(new ExtraHints.Builder().extraData(A03(str2, A01(21, 11, 47), true)).build());
            return rewardedVideoAd;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final void A08(C1116Yn c1116Yn, boolean z2) {
        int i = 0;
        String A01 = A01(0, 21, 2);
        if (!z2) {
            int lastNonChainedAds = KE.A00(c1116Yn).getInt(A01, 0);
            i = lastNonChainedAds + 1;
        }
        KE.A00(c1116Yn).edit().putInt(A01, i).apply();
    }

    public final boolean A09(C1116Yn c1116Yn, String str, int i) {
        if (i <= 0) {
            return false;
        }
        try {
            if (!A05(str)) {
                int lastNonChainedAds = A00(c1116Yn, i - 1);
                return lastNonChainedAds >= i + (-1);
            }
        } catch (JSONException unused) {
        }
        return false;
    }
}

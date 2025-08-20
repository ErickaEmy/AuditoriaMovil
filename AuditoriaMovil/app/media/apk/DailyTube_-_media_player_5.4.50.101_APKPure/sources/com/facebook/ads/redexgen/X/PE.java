package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.uv.v7.R;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public abstract class PE {
    public static byte[] A00;
    public static String[] A01 = {"CXRchRuqobcH0303RF", "0PvsG2xJSmQLgGTcWH9EYe7sEgRs7pRt", "Ep2muPcKb5OPprn584rkOKVS7ZwPor7u", "ESdTFl6hgzo0PrNou", "ifIc3126Iu24LMQAqXU9MKX3mrrg1qWL", "gYyPZy3RrUjZ7", "cRp6DEQTFSLuVCLvwOm8", "Iag0U1Rq9Q0ZydVPffrz8fjunI2ky4CH"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static WebResourceResponse A00(C1116Yn c1116Yn, WebResourceRequest webResourceRequest, Uri uri, String str, HashMap<String, String> hashMap) throws IOException {
        String A02 = A02(85, 5, 49);
        C1037Vj A0F = R0.A05(c1116Yn.A01()).A0F(c1116Yn);
        C04216c.A0H(c1116Yn, uri.toString());
        try {
            PF pf = new PF(c1116Yn.A01(), uri, A0F);
            int available = pf.available();
            if (available <= 0) {
                A05(c1116Yn, 1, new Pair[]{new Pair(A02(61, 9, 77), String.valueOf(available))});
                return null;
            }
            String A03 = A03(webResourceRequest.getRequestHeaders());
            if (A03 == null) {
                c1116Yn.A0E().A5O();
                A06(hashMap, available);
                return new WebResourceResponse(str, null, 200, A02(44, 2, 15), hashMap, pf);
            }
            try {
                PD A012 = A01(A03);
                boolean z2 = A012.A03;
                if (A01[7].charAt(0) != '8') {
                    String[] strArr = A01;
                    strArr[5] = "V65aPOMRpqA07";
                    strArr[6] = "uUbGIz9l3eQBVw2CYc6n";
                    if (!z2) {
                        Pair[] pairArr = new Pair[1];
                        pairArr[0] = new Pair(A02(94, 5, 44), A012.A02 != null ? A012.A02 : A02(90, 4, 76));
                        A05(c1116Yn, 0, pairArr);
                        return null;
                    }
                    int i = A012.A01;
                    int i5 = A012.A00 == -1 ? available - 1 : A012.A00;
                    A06(hashMap, available);
                    hashMap.put(A02(31, 13, 81), A02(75, 6, 17) + i + A02(1, 1, 52) + i5 + A02(2, 1, R.styleable.AppCompatTheme_textColorAlertDialogListItem) + available);
                    c1116Yn.A0E().A5O();
                    return new WebResourceResponse(str, null, 206, A02(46, 15, 36), hashMap, pf);
                }
                throw new RuntimeException();
            } catch (NumberFormatException e2) {
                A05(c1116Yn, 3, new Pair[]{new Pair(A02, e2.toString())});
                return null;
            }
        } catch (IOException e3) {
            A05(c1116Yn, 2, new Pair[]{new Pair(A02, e3.toString())});
            return null;
        }
    }

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 91);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{-119, -68, -8, -14, -50, -16, -16, -14, -3, 1, -70, -33, -18, -5, -12, -14, 0, -46, -2, -3, 3, -12, -3, 3, -68, -37, -12, -3, -10, 3, -9, -17, 27, 26, 32, 17, 26, 32, -39, -2, 13, 26, 19, 17, -71, -75, -49, -32, -15, -13, -24, -32, -21, -97, -62, -18, -19, -13, -28, -19, -13, 9, 30, 9, 17, 20, 9, 10, 20, 13, -7, 16, 11, -4, 10, -50, -27, -32, -47, -33, -116, 4, 16, 5, 6, -15, -2, -2, -5, -2, 21, 28, 19, 19, -7, -24, -11, -18, -20};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A05(C1116Yn c1116Yn, int i, Pair<String, String>[] pairArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A02(81, 4, 70), i);
            for (Pair<String, String> pair : pairArr) {
                jSONObject.put((String) pair.first, pair.second);
            }
        } catch (JSONException unused) {
        }
        c1116Yn.A0E().A5N(jSONObject.toString());
    }

    static {
        A04();
    }

    public static PD A01(String str) {
        if (str == null) {
            PD parseResult = new PD();
            parseResult.A03 = false;
            parseResult.A02 = null;
            return parseResult;
        }
        String[] split = str.split(A02(3, 1, 90));
        if (split.length >= 2) {
            if (A02(70, 5, 60).equals(split[0].toLowerCase(Locale.US).trim())) {
                if (split[1].trim().split(A02(0, 1, 2)).length != 1) {
                    PD pd = new PD();
                    pd.A03 = false;
                    pd.A02 = str;
                    return pd;
                }
                String[] ranges = split[1].trim().split(A02(1, 1, 52));
                PD pd2 = new PD();
                pd2.A03 = true;
                pd2.A02 = str;
                pd2.A01 = TextUtils.isEmpty(ranges[0]) ? 0 : Integer.parseInt(ranges[0]);
                if (ranges.length > 1) {
                    pd2.A00 = TextUtils.isEmpty(ranges[1]) ? -1 : Integer.parseInt(ranges[1]);
                } else {
                    pd2.A00 = -1;
                }
                return pd2;
            }
        }
        PD pd3 = new PD();
        pd3.A03 = false;
        pd3.A02 = str;
        return pd3;
    }

    public static String A03(Map<String, String> map) {
        for (String str : map.keySet()) {
            if (A02(94, 5, 44).equals(str.toLowerCase(Locale.US))) {
                return map.get(str);
            }
        }
        return null;
    }

    public static void A06(HashMap<String, String> hashMap, int i) {
        hashMap.put(A02(4, 13, 50), A02(70, 5, 60));
        hashMap.put(A02(17, 14, 52), String.valueOf(i));
    }
}

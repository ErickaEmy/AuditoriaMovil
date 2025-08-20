package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import com.uv.v7.R;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public abstract class PO {
    public static byte[] A00;
    public static String[] A01 = {"xPMOoUfbkmQ5kvnU3jbgLL47OcFEjU7z", "1dodMLotzUEJucQn2MWgY64F", "Ei0kY7ZOP", "czo3jP2JN", "", "hHdeWCinA2EaAz86iaUgwk6OrkZVXmHI", "CkfkaUvdCRi5J5AIUl6JSr62iIVQ3RiE", "AT3hLPm3hPYjZ73rxoY4ER"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static PN A00(C1116Yn c1116Yn, JSONObject jSONObject, C04216c c04216c, JA ja, C0871Oy c0871Oy, boolean z2) {
        boolean z3;
        String str;
        boolean z4 = z2;
        String A012 = A01(101, 3, R.styleable.AppCompatTheme_textAppearancePopupMenuHeader);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        String optString = jSONObject.optString(A01(51, 26, 80));
        arrayList3.add(optString);
        if (z4) {
            str = c04216c.A0R(optString);
            if (optString.equals(str)) {
                z4 = false;
                z3 = false;
            } else {
                z3 = z4;
            }
        } else {
            z3 = z4;
            str = optString;
        }
        ja.A04(J9.A0P, null);
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(A01(92, 4, 1));
            if (optJSONObject != null && optJSONObject.optString(A012) != null) {
                arrayList.add(optJSONObject.optString(A012));
                if (z3) {
                    optJSONObject.put(A012, c04216c.A0Q(optJSONObject.optString(A012)));
                }
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(A01(77, 15, 126));
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString2 = optJSONArray.optString(i);
                    arrayList.add(optString2);
                    if (z3) {
                        optJSONArray.put(i, c04216c.A0Q(optString2));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(A01(43, 8, 26));
            if (optJSONArray2 != null) {
                for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                    A03(arrayList, arrayList2, optJSONArray2.optJSONObject(i5), c04216c, z3);
                }
            } else {
                A03(arrayList, arrayList2, jSONObject, c04216c, z3);
            }
        } catch (JSONException unused) {
            c0871Oy.A04(C8A.A15, A01(0, 43, 79));
        }
        return new PN(jSONObject, str, arrayList, arrayList2, arrayList3, z4);
    }

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 79);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{69, 114, 114, 111, 114, 32, 116, 114, 97, 110, 115, 102, 111, 114, 109, 105, 110, 103, 32, 74, 83, 79, 78, 32, 105, 110, 32, 117, 112, 100, 97, 116, 101, 67, 97, 99, 104, 101, 100, 85, 114, 108, 115, 54, 52, 39, 58, 32, 38, 48, 57, 123, 102, 113, 126, 114, 118, 124, 64, 108, 123, 116, 64, 115, 126, 102, 122, 109, 64, 119, 107, 114, 115, 64, 106, 109, 115, 84, 95, 85, 110, 82, 80, 67, 85, 110, 88, 92, 80, 86, 84, 66, 39, 45, 33, 32, 2, 6, 10, 12, 14, 80, 87, 73, 107, 116, 121, 120, 114, 66, 104, 111, 113};
    }

    static {
        A02();
    }

    public static void A03(ArrayList<String> videoUrls, ArrayList<String> arrayList, JSONObject jSONObject, C04216c c04216c, boolean z2) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject(A01(96, 5, 36));
        if (optJSONObject != null) {
            String A012 = A01(101, 3, R.styleable.AppCompatTheme_textAppearancePopupMenuHeader);
            if (A01[1].length() == 1) {
                throw new RuntimeException();
            }
            A01[7] = "G1neCcMuoIIVUH8A2yIEObncf";
            if (optJSONObject.optString(A012) != null) {
                String optString = optJSONObject.optString(A012);
                videoUrls.add(optString);
                if (z2) {
                    optJSONObject.put(A012, c04216c.A0Q(optString));
                }
            }
        }
        String A013 = A01(104, 9, 82);
        if (!TextUtils.isEmpty(jSONObject.optString(A013))) {
            String optString2 = jSONObject.optString(A013);
            arrayList.add(optString2);
            if (z2) {
                jSONObject.put(A013, c04216c.A0R(optString2));
            }
        }
    }
}

package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public abstract class LJ {
    public static byte[] A00;
    public static String[] A01 = {"bCA0WV7g9cnA4ltB5qqjp12FxZMghyDz", "WzMdgVuSy86surt8IbRNO89xVpYcFvZR", "vBmFH1fuq9MEDYSajFcKFjMjxlndPyIT", "AjQwhKg0BmylW2zY2qnRPlrsdpwDD7xX", "WDfLMW4THrL4GDR7l8Ogbnx7jWIf1LVp", "J", "Un7ie3hNu6oSxsviCElGpaw70qJ7D3pr", "I6rRJYdApv2XGptUPw1U"};

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 85);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{-10, -3, -12, -12};
    }

    static {
        A05();
    }

    public static String A01(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e2) {
                    String[] strArr = A01;
                    if (strArr[0].charAt(5) != strArr[1].charAt(5)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A01;
                    strArr2[2] = "ndgFEZBTUbwthgxyC0k1ffQbXbGUnRaA";
                    strArr2[3] = "ZnYv6Dz0eIiuCYzsHLE25vrPVm9Ysg64";
                    e2.printStackTrace();
                }
            }
        }
        return jSONObject.toString();
    }

    public static String A02(JSONObject jSONObject, String str) {
        return A03(jSONObject, str, null);
    }

    public static String A03(JSONObject jSONObject, String str, String str2) {
        String optString = jSONObject.optString(str, str2);
        String value = A00(0, 4, 51);
        if (value.equals(optString)) {
            return null;
        }
        return optString;
    }

    public static List<String> A04(JSONArray jSONArray) {
        if (jSONArray == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                arrayList.add(optString);
            }
        }
        return arrayList;
    }
}

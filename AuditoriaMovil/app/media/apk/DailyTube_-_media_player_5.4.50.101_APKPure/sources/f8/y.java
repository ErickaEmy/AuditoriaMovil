package f8;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v5.j5;
/* loaded from: classes.dex */
public final class y {
    public static String gv(String str) {
        return str.replace('-', '+').replace('_', '/');
    }

    public static byte[] n3(byte[] bArr) {
        if (j5.y >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(j5.mg(bArr));
            StringBuilder sb = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (i != 0) {
                    sb.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                sb.append("{\"k\":\"");
                sb.append(gv(jSONObject2.getString("k")));
                sb.append("\",\"kid\":\"");
                sb.append(gv(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return j5.ap(sb.toString());
        } catch (JSONException e2) {
            v5.r.gv("ClearKeyUtil", "Failed to adjust response data: " + j5.mg(bArr), e2);
            return bArr;
        }
    }

    public static byte[] y(byte[] bArr) {
        if (j5.y >= 27) {
            return bArr;
        }
        return j5.ap(zn(j5.mg(bArr)));
    }

    public static String zn(String str) {
        return str.replace('+', '-').replace('/', '_');
    }
}

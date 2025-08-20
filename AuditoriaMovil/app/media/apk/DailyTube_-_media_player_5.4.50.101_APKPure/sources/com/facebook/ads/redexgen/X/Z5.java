package com.facebook.ads.redexgen.X;

import android.os.Handler;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public class Z5 extends KT {
    public static byte[] A01;
    public final /* synthetic */ AnonymousClass62 A00;

    static {
        A02();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 18);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{62, 44, 44, 58, 43, 44};
    }

    public Z5(AnonymousClass62 anonymousClass62) {
        this.A00 = anonymousClass62;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        Handler handler;
        JSONObject jSONObject;
        C04216c c04216c;
        String str;
        String str2;
        try {
            jSONObject = this.A00.A05;
            JSONArray jSONArray = jSONObject.getJSONArray(A00(0, 6, 77));
            for (int i = 0; i < jSONArray.length(); i++) {
                AnonymousClass60 assetData = AnonymousClass60.A00(jSONArray.getJSONObject(i));
                this.A00.A09(assetData.A04, assetData);
            }
            c04216c = this.A00.A02;
            Z7 z7 = new Z7(this);
            str = this.A00.A04;
            str2 = this.A00.A03;
            c04216c.A0W(z7, new C6V(str, str2));
        } catch (JSONException unused) {
            handler = this.A00.A00;
            handler.post(new Z6(this));
        }
    }
}

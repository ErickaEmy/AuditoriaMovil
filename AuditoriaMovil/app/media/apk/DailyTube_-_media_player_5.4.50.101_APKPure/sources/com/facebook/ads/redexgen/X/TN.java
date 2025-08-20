package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public class TN implements P2 {
    public static byte[] A01;
    public final /* synthetic */ B3 A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 23);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-49, -53, -64, -40};
    }

    public TN(B3 b3) {
        this.A00 = b3;
    }

    @Override // com.facebook.ads.redexgen.X.P2
    public final void ADY(String str, JSONObject jSONObject) {
        PB pb;
        C1116Yn c1116Yn;
        C1116Yn c1116Yn2;
        if (str.equals(A00(0, 4, 72))) {
            this.A00.AGY();
            c1116Yn = this.A00.A07;
            if (C0705Ih.A1W(c1116Yn)) {
                c1116Yn2 = this.A00.A07;
                c1116Yn2.A0A().ABG();
            }
        }
        pb = this.A00.A0F;
        pb.A0h(str, jSONObject);
    }
}

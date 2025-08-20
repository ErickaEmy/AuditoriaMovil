package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public final class FV extends AbstractC1219b5 {
    public static byte[] A00 = null;
    public static final long serialVersionUID = 5751287062553772012L;

    static {
        A04();
    }

    public static String A03(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 8);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{-123, -124, -111, -111, -120, -107};
    }

    public FV(List<C1G> list) {
        super(list);
    }

    public static FV A02(JSONObject jSONObject, C1116Yn c1116Yn) {
        FV fv = new FV(AbstractC1219b5.A08(jSONObject, c1116Yn, new C1218b4()));
        fv.A16(jSONObject);
        fv.A0b(A03(0, 6, 27));
        return fv;
    }

    @Override // com.facebook.ads.redexgen.X.C1F
    public final int A0F() {
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.C1F
    public final int A0G() {
        return 0;
    }
}

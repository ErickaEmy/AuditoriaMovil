package com.facebook.ads.redexgen.X;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public final class FU extends AbstractC1219b5 implements Serializable {
    public static byte[] A00 = null;
    public static final long serialVersionUID = 5751287062553772011L;

    static {
        A04();
    }

    public static String A03(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 98);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{72, 79, 85, 68, 83, 82, 85, 72, 85, 72, 64, 77};
    }

    public FU(List<C1G> list) {
        super(list);
    }

    public static FU A02(JSONObject jSONObject, C1116Yn c1116Yn) {
        FU fu = new FU(AbstractC1219b5.A08(jSONObject, c1116Yn, new C1216b2()));
        fu.A16(jSONObject);
        fu.A0b(A03(0, 12, 67));
        return fu;
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

package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import org.json.JSONException;
/* renamed from: com.facebook.ads.redexgen.X.Vb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1029Vb implements InterfaceC0936Rl {
    public static byte[] A02;
    public final /* synthetic */ C1115Ym A00;
    public final /* synthetic */ InterfaceC0934Rj A01;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 32);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-120, -121, -125, -106, -105, -108, -121, -127, -123, -111, -112, -120, -117, -119};
    }

    public C1029Vb(InterfaceC0934Rj interfaceC0934Rj, C1115Ym c1115Ym) {
        this.A01 = interfaceC0934Rj;
        this.A00 = c1115Ym;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0936Rl
    public final void A45() {
        try {
            C0705Ih.A0R(this.A00).A2Y(this.A01.A6h().optJSONObject(A00(0, 14, 2)));
        } catch (JSONException e2) {
            this.A00.A07().A3c(e2);
        }
    }
}

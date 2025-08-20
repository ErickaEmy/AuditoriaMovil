package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public class AZ extends AbstractC0860On {
    public static byte[] A01;
    public final /* synthetic */ P3 A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 93);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{28, 13, 25, 31, 9};
    }

    public AZ(P3 p3) {
        this.A00 = p3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC04788s
    /* renamed from: A02 */
    public final void A03(AnonymousClass98 anonymousClass98) {
        P2 p2;
        JSONObject A03;
        p2 = this.A00.A0B;
        A03 = this.A00.A03();
        p2.ADY(A00(0, 5, 49), A03);
    }
}

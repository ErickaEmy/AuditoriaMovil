package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.At  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0529At extends NX {
    public static byte[] A01;
    public final /* synthetic */ P3 A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 5);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{16, 18, 5, 16, 1, 18, 5, 4};
    }

    public C0529At(P3 p3) {
        this.A00 = p3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC04788s
    /* renamed from: A02 */
    public final void A03(C0834Nn c0834Nn) {
        P2 p2;
        JSONObject A03;
        this.A00.A03 = true;
        p2 = this.A00.A0B;
        A03 = this.A00.A03();
        p2.ADY(A00(0, 8, 101), A03);
    }
}

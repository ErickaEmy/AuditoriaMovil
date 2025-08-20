package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public class AW extends AbstractC0891Ps {
    public static byte[] A01;
    public final /* synthetic */ P3 A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 17);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-78, -65, -65, -68, -65};
    }

    public AW(P3 p3) {
        this.A00 = p3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC04788s
    /* renamed from: A02 */
    public final void A03(C0892Pt c0892Pt) {
        P2 p2;
        JSONObject A03;
        new Handler(Looper.getMainLooper()).post(new P1(this));
        p2 = this.A00.A0B;
        A03 = this.A00.A03();
        p2.ADY(A00(0, 5, 60), A03);
    }
}

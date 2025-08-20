package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.bV  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1245bV extends KT {
    public static byte[] A02;
    public final /* synthetic */ C02870w A00;
    public final /* synthetic */ JSONObject A01;

    static {
        A02();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 21);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{7, 19, 4, 16, 20, 4, 15, 2, 24, 62, 2, 0, 17, 17, 8, 15, 6};
    }

    public C1245bV(C02870w c02870w, JSONObject jSONObject) {
        this.A00 = c02870w;
        this.A01 = jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        C04447f c04447f;
        C04447f c04447f2;
        CountDownLatch countDownLatch;
        C02860v c02860v;
        C02860v c02860v2;
        CountDownLatch countDownLatch2;
        try {
            countDownLatch = this.A00.A05;
            countDownLatch.await();
            c02860v = this.A00.A02;
            synchronized (c02860v) {
                c02860v2 = this.A00.A02;
                c02860v2.A0B(this.A01);
                countDownLatch2 = this.A00.A06;
                countDownLatch2.countDown();
            }
        } catch (InterruptedException e2) {
            c04447f2 = this.A00.A03;
            c04447f2.A07().A9a(A00(0, 17, 116), C8A.A1B, new C8B(e2));
        } catch (JSONException e3) {
            this.A00.A0M();
            c04447f = this.A00.A03;
            c04447f.A07().A9a(A00(0, 17, 116), C8A.A1A, new C8B(e3));
        }
    }
}

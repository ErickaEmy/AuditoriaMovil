package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
/* renamed from: com.facebook.ads.redexgen.X.bT  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1243bT extends KT {
    public static byte[] A02;
    public static String[] A03 = {"oskFp91e5pmXbfqncEKHUOJlooKh56jY", "lReJ4EGI0ZfzcS4beAfFSCPJefxJWm51", "X9zy5AMUM8AKtatrcfePQZWL0uWUICrn", "wxwSRA3odXIdIsY7f5yZfv3v7", "O6Pxh8VVn00f1EJnP312TgPdEktEk3X8", "2QJh3yF6", "0YwPA87fpumxZ406JTpoKHsZ368w", "aJIZZEX98MAeULDgBorQq277OQTM9IaN"};
    public final /* synthetic */ C02870w A00;
    public final /* synthetic */ String A01;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 67);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        byte[] bArr = {29, 41, 28, 40, 44, 28, 37, 26, 48, 22, 26, 24, 39, 39, 32, 37, 30};
        String[] strArr = A03;
        if (strArr[2].charAt(10) != strArr[7].charAt(10)) {
            throw new RuntimeException();
        }
        A03[5] = "QkfkB";
        A02 = bArr;
    }

    static {
        A02();
    }

    public C1243bT(C02870w c02870w, String str) {
        this.A00 = c02870w;
        this.A01 = str;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        C04447f c04447f;
        C04447f c04447f2;
        CountDownLatch countDownLatch;
        boolean A0J;
        C02860v c02860v;
        C02860v c02860v2;
        C02860v c02860v3;
        String A00 = A00(0, 17, 116);
        try {
            countDownLatch = this.A00.A06;
            countDownLatch.await();
            A0J = this.A00.A0J(this.A01);
            if (A0J) {
                c02860v = this.A00.A02;
                ((C1T) c02860v.A05().get(this.A01)).A04((int) (System.currentTimeMillis() / 1000));
                c02860v2 = this.A00.A02;
                c02860v2.A07(this.A01);
                c02860v3 = this.A00.A02;
                c02860v3.A06();
                this.A00.A08();
            }
        } catch (InterruptedException e2) {
            c04447f2 = this.A00.A03;
            c04447f2.A07().A9a(A00, C8A.A1B, new C8B(e2));
        } catch (JSONException e3) {
            this.A00.A0M();
            c04447f = this.A00.A03;
            c04447f.A07().A9a(A00, C8A.A1A, new C8B(e3));
        }
    }
}

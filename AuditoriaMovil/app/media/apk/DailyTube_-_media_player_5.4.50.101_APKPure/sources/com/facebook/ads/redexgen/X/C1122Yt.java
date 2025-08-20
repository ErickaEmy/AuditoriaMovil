package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.Yt  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1122Yt extends KT {
    public static byte[] A02;
    public final /* synthetic */ C1121Ys A00;
    public final /* synthetic */ AtomicBoolean A01;

    static {
        A02();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 31);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{117, 87, 85, 94, 83, 22, 80, 87, 95, 90, 24, 77, 111, 109, 102, 107, 46, 125, 123, 109, 109, 107, 125, 125, 32};
    }

    public C1122Yt(C1121Ys c1121Ys, AtomicBoolean atomicBoolean) {
        this.A00 = c1121Ys;
        this.A01 = atomicBoolean;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        C04447f c04447f;
        long j2;
        C04447f c04447f2;
        long j4;
        if (this.A00.A00 != null) {
            if (this.A01.get()) {
                this.A00.A02.A0I(J9.A0H);
                c04447f2 = this.A00.A02.A04;
                C6V c6v = this.A00.A01;
                int i = C04246f.A00;
                String A00 = A00(11, 14, 17);
                j4 = this.A00.A02.A00;
                C04246f.A02(c04447f2, c6v, i, A00, j4);
                this.A00.A02.A0T();
                this.A00.A00.ABB();
                return;
            }
            this.A00.A02.A0I(J9.A0G);
            c04447f = this.A00.A02.A04;
            C6V c6v2 = this.A00.A01;
            int i5 = C04246f.A04;
            String A002 = A00(0, 11, 41);
            j2 = this.A00.A02.A00;
            C04246f.A02(c04447f, c6v2, i5, A002, j2);
            this.A00.A02.A0U();
            this.A00.A00.AB2();
        }
    }
}

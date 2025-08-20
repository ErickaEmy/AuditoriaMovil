package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Ws  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1069Ws implements D6 {
    public static byte[] A03;
    public C4 A00;
    public IB A01;
    public boolean A02;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 88);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{90, 75, 75, 87, 82, 88, 90, 79, 82, 84, 85, 20, 67, 22, 72, 88, 79, 94, 8, 14};
    }

    @Override // com.facebook.ads.redexgen.X.D6
    public final void A4R(C0697Hz c0697Hz) {
        if (!this.A02) {
            if (this.A01.A05() == -9223372036854775807L) {
                return;
            }
            this.A00.A5n(Format.A02(null, A00(0, 20, 99), this.A01.A05()));
            this.A02 = true;
        }
        int A04 = c0697Hz.A04();
        this.A00.AFR(c0697Hz, A04);
        this.A00.AFS(this.A01.A04(), 1, A04, 0, null);
    }

    @Override // com.facebook.ads.redexgen.X.D6
    public final void A8q(IB ib, InterfaceC0556Bu interfaceC0556Bu, DC dc) {
        this.A01 = ib;
        dc.A05();
        C4 AGi = interfaceC0556Bu.AGi(dc.A03(), 4);
        this.A00 = AGi;
        AGi.A5n(Format.A0B(dc.A04(), A00(0, 20, 99), null, -1, null));
    }
}

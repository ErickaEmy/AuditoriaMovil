package com.facebook.ads.redexgen.X;

import java.io.IOException;
/* loaded from: assets/audience_network.dex */
public class XI implements InterfaceC0570Cl, C1 {
    public static String[] A05 = {"RxrevBHwZunvWtoC5v6V", "BM7NoIYIDKALVkWYBFUm4mgKfD4surZT", "wT545zonAETVeqcNIpSLQKDSBA4psZtT", "O6YerNOVuBIV8g4cn8DH", "f7xxxnJira03VIlY2bxNtwSQeXyrwxct", "8kRv9b0m26r6Uh6XKMOB9WasCMU5o07v", "0W8GSaK37PxtOyOV4bIEUVoiYe2UqjRN", "TYUMHNguvpgJeUJ5Wme9D9z4"};
    public long A00 = -1;
    public long A01 = -1;
    public long[] A02;
    public long[] A03;
    public final /* synthetic */ XH A04;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.C1
    public final C0 A7t(long j2) {
        int A0B = IF.A0B(this.A02, this.A04.A04(j2), true, true);
        long A03 = this.A04.A03(this.A02[A0B]);
        C2 c2 = new C2(A03, this.A00 + this.A03[A0B]);
        if (A03 < j2) {
            long[] jArr = this.A02;
            if (A0B != jArr.length - 1) {
                return new C0(c2, new C2(this.A04.A03(jArr[A0B + 1]), this.A00 + this.A03[A0B + 1]));
            }
        }
        return new C0(c2);
    }

    public XI(XH xh) {
        this.A04 = xh;
    }

    public final void A00(long j2) {
        this.A00 = j2;
    }

    public final void A01(C0697Hz c0697Hz) {
        c0697Hz.A0Z(1);
        int length = c0697Hz.A0G();
        int i = length / 18;
        this.A02 = new long[i];
        this.A03 = new long[i];
        for (int i5 = 0; i5 < i; i5++) {
            this.A02[i5] = c0697Hz.A0L();
            this.A03[i5] = c0697Hz.A0L();
            c0697Hz.A0Z(2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0570Cl
    public final C1 A4m() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final long A6r() {
        C0684Hm c0684Hm;
        c0684Hm = this.A04.A01;
        return c0684Hm.A01();
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final boolean A9I() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0570Cl
    public final long AEI(InterfaceC0555Bt interfaceC0555Bt) throws IOException, InterruptedException {
        long j2 = this.A01;
        if (j2 >= 0) {
            long j4 = -(j2 + 2);
            this.A01 = -1L;
            if (A05[5].charAt(9) != '6') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[0] = "MeEp95NFLxRX8bxkfA2m";
            strArr[3] = "RwTpOb1Sie1PnKrI5U9E";
            return j4;
        }
        return -1L;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0570Cl
    public final long AGX(long j2) {
        long A04 = this.A04.A04(j2);
        long granule = this.A02[IF.A0B(this.A02, A04, true, true)];
        this.A01 = granule;
        return A04;
    }
}

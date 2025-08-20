package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class EE implements XV {
    public final int A00;
    public final int A01;
    public final long A02;
    public final long A03;
    public final long A04;

    public EE(long j2, long j4, By by) {
        this.A04 = j4;
        this.A01 = by.A02;
        this.A00 = by.A00;
        if (j2 == -1) {
            this.A02 = -1L;
            this.A03 = -9223372036854775807L;
            return;
        }
        this.A02 = j2 - j4;
        this.A03 = A88(j2);
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final long A6r() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final C0 A7t(long j2) {
        long j4 = this.A02;
        if (j4 == -1) {
            return new C0(new C2(0L, this.A04));
        }
        int i = this.A01;
        long A0E = IF.A0E((((this.A00 * j2) / 8000000) / i) * i, 0L, j4 - i);
        long j6 = this.A04 + A0E;
        long A88 = A88(j6);
        C2 seekPoint = new C2(A88, j6);
        if (A88 < j2) {
            long j7 = this.A02;
            int i5 = this.A01;
            if (A0E != j7 - i5) {
                long j8 = i5 + j6;
                return new C0(seekPoint, new C2(A88(j8), j8));
            }
        }
        return new C0(seekPoint);
    }

    @Override // com.facebook.ads.redexgen.X.XV
    public final long A88(long j2) {
        return ((Math.max(0L, j2 - this.A04) * 1000000) * 8) / this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final boolean A9I() {
        return this.A02 != -1;
    }
}

package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Ue  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1007Ue implements LU {
    public final LT A00;
    public final LU A01;

    public C1007Ue(LU lu, int i, int i5) {
        this.A01 = lu;
        this.A00 = new LT(i, i5);
    }

    @Override // com.facebook.ads.redexgen.X.LU
    public final void AE8(String str) {
        boolean A08;
        this.A00.A04(str);
        if (this.A00.A02() != null) {
            A08 = LW.A08(this.A00);
            if (A08) {
                this.A01.AE8(this.A00.A02());
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.LU
    public final void flush() {
        boolean A08;
        this.A00.A03();
        while (this.A00.A02() != null) {
            A08 = LW.A08(this.A00);
            if (A08) {
                this.A01.AE8(this.A00.A02());
            }
            this.A00.A03();
        }
    }
}

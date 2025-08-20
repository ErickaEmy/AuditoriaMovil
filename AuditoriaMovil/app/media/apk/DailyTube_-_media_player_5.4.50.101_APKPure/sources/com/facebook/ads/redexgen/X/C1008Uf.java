package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Uf  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1008Uf implements LU {
    public int A00;
    public final LU A01;

    public C1008Uf(LU lu, int i) {
        this.A01 = lu;
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.X.LU
    public final void AE8(String str) {
        if (this.A00 > 0) {
            this.A01.AE8(str);
            this.A00--;
        }
    }

    @Override // com.facebook.ads.redexgen.X.LU
    public final void flush() {
        this.A01.flush();
    }
}

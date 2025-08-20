package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Ui  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1011Ui implements LU {
    public int A00;
    public final LU A01;
    public final LU A02;

    public C1011Ui(LU lu, int i, LU lu2) {
        this.A01 = lu;
        this.A00 = i;
        this.A02 = lu2;
    }

    @Override // com.facebook.ads.redexgen.X.LU
    public final void AE8(String str) {
        if (this.A00 > 0) {
            this.A01.AE8(str);
            this.A01.flush();
            this.A00--;
            return;
        }
        this.A02.AE8(str);
    }

    @Override // com.facebook.ads.redexgen.X.LU
    public final void flush() {
        this.A02.flush();
    }
}

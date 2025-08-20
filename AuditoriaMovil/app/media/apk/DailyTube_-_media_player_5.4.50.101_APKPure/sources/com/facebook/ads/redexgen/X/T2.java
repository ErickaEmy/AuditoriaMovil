package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class T2 implements NS {
    public static byte[] A01;
    public final /* synthetic */ C0974Sx A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 6);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-36, -38, -52, -39, -58, -43, -56, -35, -48, -50, -56, -37, -48, -42, -43, -58, -48, -56, -55};
    }

    public T2(C0974Sx c0974Sx) {
        this.A00 = c0974Sx;
    }

    @Override // com.facebook.ads.redexgen.X.NS
    public final void ACT(String str) {
        NK nk;
        NK nk2;
        this.A00.A0Q = false;
        nk = this.A00.A0F;
        nk.setProgress(100);
        nk2 = this.A00.A0F;
        AbstractC0783Lo.A0N(nk2, 8);
    }

    @Override // com.facebook.ads.redexgen.X.NS
    public final void ACV(String str) {
        NK nk;
        NJ nj2;
        boolean z2;
        int i;
        this.A00.A0Q = true;
        nk = this.A00.A0F;
        AbstractC0783Lo.A0N(nk, 0);
        nj2 = this.A00.A0E;
        nj2.setUrl(str);
        z2 = this.A00.A0P;
        if (!z2) {
            i = this.A00.A02;
            if (i > 1) {
                this.A00.A0P = true;
                this.A00.A0j(A00(0, 19, 97));
            }
        }
        C0974Sx.A08(this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.NS
    public final void ACn(int i) {
        boolean z2;
        NK nk;
        z2 = this.A00.A0Q;
        if (z2) {
            nk = this.A00.A0F;
            nk.setProgress(i);
        }
    }

    @Override // com.facebook.ads.redexgen.X.NS
    public final void ACq(String str) {
        NJ nj2;
        nj2 = this.A00.A0E;
        nj2.setTitle(str);
    }

    @Override // com.facebook.ads.redexgen.X.NS
    public final void ACs() {
        ((PQ) this.A00).A09.AB0(14);
    }
}

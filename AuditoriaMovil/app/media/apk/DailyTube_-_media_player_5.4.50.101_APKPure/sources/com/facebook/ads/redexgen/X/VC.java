package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class VC extends AbstractC02810q {
    public static byte[] A01;
    public final /* synthetic */ V2 A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 109);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{23, 42, 61, 50, 63, 46, -23, 42, 45, 60, -23, 54, 42, 55, 42, 48, 46, 59, -23, 61, 49, 46, 50, 59, -23, 56, 64, 55, -23, 50, 54, 57, 59, 46, 60, 60, 50, 56, 55, 60, -9};
    }

    public VC(V2 v2) {
        this.A00 = v2;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC02810q
    public final void A0B(C1234bK c1234bK) {
        this.A00.A1T(c1234bK);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC02810q
    public final void A0C() {
        V1 v1;
        V1 v12;
        v1 = this.A00.A0G;
        if (v1 != null) {
            v12 = this.A00.A0G;
            v12.AAc();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC02810q
    public final void A0D() {
        throw new IllegalStateException(A00(0, 41, 92));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC02810q
    public final void A0F(InterfaceC02800p interfaceC02800p) {
        FO fo;
        FO fo2;
        fo = this.A00.A0A;
        if (fo != null) {
            fo2 = this.A00.A0A;
            fo2.A0J();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC02810q
    public final void A0G(C0722Jb c0722Jb) {
        long j2;
        V1 v1;
        V1 v12;
        C0S A0E = this.A00.A11().A0E();
        j2 = this.A00.A00;
        A0E.A2m(C0774Lf.A01(j2), c0722Jb.A03().getErrorCode(), c0722Jb.A04());
        v1 = this.A00.A0G;
        if (v1 != null) {
            v12 = this.A00.A0G;
            v12.ABR(c0722Jb);
        }
    }
}

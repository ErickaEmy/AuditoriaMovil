package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class D1 {
    public static String[] A0G = {"pHpyHP8S", "m7Dm6DzF3JrYgJb8r3aBvOiHYZnTgqFt", "HDu7bLu972VfHIygI4M5b4TuY4lqC4yg", "iivH24vaI3kkb3LFmloVx1IOyWVuKza4", "KZ0yf6ou6J0TqVPjqp3i5DSivFyU8bNM", "Pc4fHgH2fAOt1gCYCPntkv807xx", "lUKVzHZS", "o3UNUm1DzZwOBzkgZiuDkjMNM5U"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public C0692Hu A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public boolean A0F;

    public D1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A00(D1 d12) {
        if (this.A0F) {
            if (!d12.A0F || this.A03 != d12.A03 || this.A07 != d12.A07 || this.A0C != d12.A0C) {
                return true;
            }
            boolean z2 = this.A0B;
            String[] strArr = A0G;
            if (strArr[1].charAt(29) == strArr[4].charAt(29)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0G;
            strArr2[7] = "XDMSMjR4OOJ5qpPgon6YqbblugR";
            strArr2[5] = "5xZUmDJH2T0z2hm3Lt8QCiFJvrf";
            if (z2 && d12.A0B && this.A0A != d12.A0A) {
                return true;
            }
            int i = this.A05;
            int i5 = d12.A05;
            if (i != i5 && (i == 0 || i5 == 0)) {
                return true;
            }
            if (this.A09.A04 == 0 && d12.A09.A04 == 0 && (this.A06 != d12.A06 || this.A02 != d12.A02)) {
                return true;
            }
            if (this.A09.A04 == 1 && d12.A09.A04 == 1) {
                int i6 = this.A00;
                if (A0G[2].length() == 32) {
                    String[] strArr3 = A0G;
                    strArr3[7] = "XRlTxrvrNP0CnKRouPcFPiOcqOY";
                    strArr3[5] = "BA8SrIsjDMc450dTESwcliSODCW";
                    if (i6 != d12.A00) {
                        return true;
                    }
                } else if (i6 != d12.A00) {
                    return true;
                }
                if (this.A01 != d12.A01) {
                    return true;
                }
            }
            boolean z3 = this.A0E;
            boolean z4 = d12.A0E;
            if (z3 != z4) {
                return true;
            }
            if (z3 && z4 && this.A04 != d12.A04) {
                return true;
            }
        }
        return false;
    }

    public final void A02() {
        this.A0D = false;
        this.A0F = false;
    }

    public final void A03(int i) {
        this.A08 = i;
        this.A0D = true;
    }

    public final void A04(C0692Hu c0692Hu, int i, int i5, int i6, int i8, boolean z2, boolean z3, boolean z4, boolean z5, int i10, int i11, int i12, int i13, int i14) {
        this.A09 = c0692Hu;
        this.A05 = i;
        this.A08 = i5;
        this.A03 = i6;
        this.A07 = i8;
        this.A0C = z2;
        this.A0B = z3;
        this.A0A = z4;
        this.A0E = z5;
        this.A04 = i10;
        this.A06 = i11;
        this.A02 = i12;
        this.A00 = i13;
        this.A01 = i14;
        this.A0F = true;
        this.A0D = true;
    }

    public final boolean A05() {
        int i;
        return this.A0D && ((i = this.A08) == 7 || i == 2);
    }
}

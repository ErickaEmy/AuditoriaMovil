package com.facebook.ads.redexgen.X;

import android.text.Layout;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class GH {
    public static byte[] A0E;
    public static String[] A0F = {"EnH25CHWMSY6kl25xfmHDjH3RJCVhcCa", "c9QwS3HStmnCaTv4XqOiovcAW3vqBlCk", "yJ9YFZ76HfVljhtFvtfSYsYYLHoVkMB3", "y69MVLIQwTRqYQkH6ft3AFsQHNhuhuqd", "HDxitRoDWw9zLH1l", "uTT6gRFq1HF7aES4vampCOqVAKYvWyzU", "m9Eh3F3c5Q4haO7Pkkaf6ux3SCszBLsk", "9FJhR48G617i"};
    public float A00;
    public int A01;
    public int A03;
    public Layout.Alignment A08;
    public String A09;
    public String A0A;
    public boolean A0B;
    public boolean A0C;
    public final GH A0D;
    public int A06 = -1;
    public int A07 = -1;
    public int A02 = -1;
    public int A05 = -1;
    public int A04 = -1;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 41);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        byte[] bArr = {-32, -1, 1, 9, 5, 16, 13, 19, 12, 2, -66, 1, 13, 10, 13, 16, -66, 6, -1, 17, -66, 12, 13, 18, -66, 0, 3, 3, 12, -66, 2, 3, 4, 7, 12, 3, 2, -52, -120, -79, -80, -74, 98, -91, -79, -82, -79, -76, 98, -86, -93, -75, 98, -80, -79, -74, 98, -92, -89, -89, -80, 98, -90, -89, -88, -85, -80, -89, -90, 112};
        if (A0F[3].charAt(14) == 'v') {
            throw new RuntimeException();
        }
        A0F[7] = "ykTASi";
        A0E = bArr;
    }

    static {
        A02();
    }

    private GH A00(GH gh, boolean z2) {
        if (gh != null) {
            if (!this.A0C && gh.A0C) {
                A0B(gh.A03);
            }
            if (this.A02 == -1) {
                this.A02 = gh.A02;
            }
            if (this.A05 == -1) {
                this.A05 = gh.A05;
            }
            if (this.A09 == null) {
                this.A09 = gh.A09;
            }
            if (this.A06 == -1) {
                this.A06 = gh.A06;
            }
            if (this.A07 == -1) {
                this.A07 = gh.A07;
            }
            if (this.A08 == null) {
                this.A08 = gh.A08;
            }
            if (this.A04 == -1) {
                int i = gh.A04;
                String[] strArr = A0F;
                if (strArr[2].charAt(27) != strArr[0].charAt(27)) {
                    throw new RuntimeException();
                }
                A0F[1] = "7dqV6HxUrZiNBplekuLou9nhbRk7RVhU";
                this.A04 = i;
                this.A00 = gh.A00;
            }
            if (z2 && !this.A0B && gh.A0B) {
                A0A(gh.A01);
            }
        }
        return this;
    }

    public final float A03() {
        return this.A00;
    }

    public final int A04() {
        if (this.A0B) {
            int i = this.A01;
            if (A0F[4].length() != 32) {
                A0F[7] = "KTxuuxMEH1VJoR6Md1";
                return i;
            }
            throw new RuntimeException();
        }
        throw new IllegalStateException(A01(0, 38, 117));
    }

    public final int A05() {
        if (this.A0C) {
            return this.A03;
        }
        throw new IllegalStateException(A01(38, 32, 25));
    }

    public final int A06() {
        return this.A04;
    }

    public final int A07() {
        int i = this.A02;
        if (i == -1 && this.A05 == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.A05 == 1 ? 2 : 0);
    }

    public final Layout.Alignment A08() {
        return this.A08;
    }

    public final GH A09(float f4) {
        this.A00 = f4;
        return this;
    }

    public final GH A0A(int i) {
        this.A01 = i;
        this.A0B = true;
        return this;
    }

    public final GH A0B(int i) {
        AbstractC0672Ha.A04(this.A0D == null);
        String[] strArr = A0F;
        if (strArr[2].charAt(27) != strArr[0].charAt(27)) {
            throw new RuntimeException();
        }
        A0F[1] = "pCA0IZ9lubeHZB9SkjDL2kYLsCYdHLPR";
        this.A03 = i;
        this.A0C = true;
        return this;
    }

    public final GH A0C(int i) {
        this.A04 = i;
        return this;
    }

    public final GH A0D(Layout.Alignment alignment) {
        this.A08 = alignment;
        return this;
    }

    public final GH A0E(GH gh) {
        return A00(gh, true);
    }

    public final GH A0F(String str) {
        AbstractC0672Ha.A04(this.A0D == null);
        this.A09 = str;
        return this;
    }

    public final GH A0G(String str) {
        this.A0A = str;
        return this;
    }

    public final GH A0H(boolean z2) {
        AbstractC0672Ha.A04(this.A0D == null);
        this.A02 = z2 ? 1 : 0;
        return this;
    }

    public final GH A0I(boolean z2) {
        AbstractC0672Ha.A04(this.A0D == null);
        this.A05 = z2 ? 1 : 0;
        return this;
    }

    public final GH A0J(boolean z2) {
        AbstractC0672Ha.A04(this.A0D == null);
        this.A06 = z2 ? 1 : 0;
        return this;
    }

    public final GH A0K(boolean z2) {
        AbstractC0672Ha.A04(this.A0D == null);
        this.A07 = z2 ? 1 : 0;
        return this;
    }

    public final String A0L() {
        return this.A09;
    }

    public final String A0M() {
        return this.A0A;
    }

    public final boolean A0N() {
        return this.A0B;
    }

    public final boolean A0O() {
        return this.A0C;
    }

    public final boolean A0P() {
        return this.A06 == 1;
    }

    public final boolean A0Q() {
        return this.A07 == 1;
    }
}

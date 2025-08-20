package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.aE  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1166aE {
    public static byte[] A06;
    public static String[] A07 = {"SAMNpPFpITUhS5O2wArhouwTSBZGJm", "j9883o", "ez1Iu7S0g9Y3okmD0rAeLGMZx9C5J", "cx0ufmmqihH41YoN2BIvmgQC03N5OWKz", "xpotzx92kYS", "WaPg1x3uwEHiu", "28liF7Ug1fq7LT93Jkda", "DJaApxMs4P8Fw5vQM3hjBZIJlCayXT4o"};
    public boolean A00;
    public boolean A01;
    public boolean A02;
    public final C2P A03;
    public final C2R A04;
    public final C2R A05;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 7);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A06 = new byte[]{43, 39, 37, 56, 36, 45, 60, 45, 84, 95, 85, 84, 85, 21, 4, 22, 22, 0, 1, 100, 117, 99, 100, 67, 100, 113, 100, 99, 111, 112, 124, 110, 120, 123, 117, 124, 74, 109, 120, 109, 106};
    }

    static {
        A04();
    }

    public C1166aE(C2P c2p) {
        this.A01 = false;
        this.A02 = false;
        this.A00 = false;
        this.A03 = c2p;
        this.A04 = new C2R(c2p.A01);
        this.A05 = new C2R(c2p.A01);
    }

    public C1166aE(C2P c2p, Bundle bundle) {
        this.A01 = false;
        this.A02 = false;
        this.A00 = false;
        this.A03 = c2p;
        this.A04 = (C2R) LR.A00(bundle.getByteArray(A00(19, 9, 23)));
        this.A05 = (C2R) LR.A00(bundle.getByteArray(A00(28, 13, 30)));
        this.A01 = bundle.getBoolean(A00(8, 5, 54));
        this.A02 = bundle.getBoolean(A00(13, 6, 98));
        this.A00 = bundle.getBoolean(A00(0, 8, 79));
    }

    private void A01() {
        this.A00 = true;
        A02();
    }

    private void A02() {
        this.A01 = true;
        boolean z2 = this.A02;
        this.A03.A00(this.A00, z2, z2 ? this.A05 : this.A04);
    }

    private void A03() {
        this.A02 = true;
        A01();
    }

    public final Bundle A05() {
        Bundle bundle = new Bundle();
        bundle.putByteArray(A00(28, 13, 30), LR.A01(this.A05));
        bundle.putByteArray(A00(19, 9, 23), LR.A01(this.A04));
        bundle.putBoolean(A00(8, 5, 54), this.A01);
        bundle.putBoolean(A00(13, 6, 98), this.A02);
        bundle.putBoolean(A00(0, 8, 79), this.A00);
        return bundle;
    }

    public final void A06() {
        if (!this.A01) {
            this.A05.A03();
        }
    }

    public final void A07(double d2, double d3) {
        double A01;
        if (this.A01) {
            return;
        }
        C2R c2r = this.A04;
        if (A07[5].length() != 13) {
            throw new RuntimeException();
        }
        A07[4] = "MN6YiANN1x8";
        c2r.A04(d2, d3);
        this.A05.A04(d2, d3);
        if (this.A03.A03) {
            A01 = this.A05.A00().A03();
        } else {
            A01 = this.A05.A00().A01();
        }
        if (this.A03.A00 >= 0.0d && this.A04.A00().A04() > this.A03.A00 && A01 == 0.0d) {
            A01();
        } else if (A01 >= this.A03.A02) {
            A03();
        }
    }
}

package com.facebook.ads.redexgen.X;

import com.uv.v7.R;
/* renamed from: com.facebook.ads.redexgen.X.58  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class AnonymousClass58 {
    public static String[] A05 = {"IS69BmVCyt3r7rCL06vW", "i2lfi3JYyaWanuhNA9EoVixSZwQkBGPJ", "IP2snh2DbdtJP84nmUNUnat", "M7qM02aMAAjP0VsgCoHzcI67snq6Xoz6", "g2Y2aWNGMjfm3AzRUQfTQ", "z59QBS9AE5GFtdBn17xV89BNaNN5ntVX", "icRlwMXc031dCVyQa9g0z", "JdVLDxEugZkBcdzJI35N90WET0E7DRJI"};
    public int A00 = 0;
    public int A01;
    public int A02;
    public int A03;
    public int A04;

    private final int A00(int i, int i5) {
        if (i > i5) {
            return 1;
        }
        if (i == i5) {
            return 2;
        }
        return 4;
    }

    public final void A01() {
        this.A00 = 0;
    }

    public final void A02(int i) {
        this.A00 |= i;
    }

    public final void A03(int i, int i5, int i6, int i8) {
        this.A04 = i;
        this.A03 = i5;
        this.A02 = i6;
        this.A01 = i8;
    }

    public final boolean A04() {
        int i = this.A00;
        if ((i & 7) == 0 || (i & (A00(this.A02, this.A04) << 0)) != 0) {
            int i5 = this.A00;
            int i6 = i5 & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle;
            String[] strArr = A05;
            if (strArr[5].charAt(13) != strArr[7].charAt(13)) {
                throw new RuntimeException();
            }
            A05[0] = "xw0gZhFc6GA1WyK2bJob";
            if (i6 == 0 || (i5 & (A00(this.A02, this.A03) << 4)) != 0) {
                int i8 = this.A00;
                if ((i8 & 1792) == 0 || (i8 & (A00(this.A01, this.A04) << 8)) != 0) {
                    int i10 = this.A00;
                    return (i10 & 28672) == 0 || (i10 & (A00(this.A01, this.A03) << 12)) != 0;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}

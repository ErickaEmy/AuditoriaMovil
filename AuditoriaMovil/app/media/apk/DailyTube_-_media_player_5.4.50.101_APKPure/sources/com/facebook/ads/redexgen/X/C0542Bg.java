package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Bg  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0542Bg extends C1142Zo {
    public static String[] A08 = {"bHvO3zM", "7z8VpEP", "iw2Y0c", "LME8njBPiXs011hhslbtp", "9K0lNzbR5X2b0vS5", "Pt0EnZUFnGQLsNks8pQcEgn0FivkNzUh", "t6anbflpJj2CGicCnIMdWTRCydsD", "D9TL9YTSSd0lWzGeUvgWfvwaUF0YdAOx"};
    public float A00;
    public int A01;
    public int A02;
    public C0543Bh A03;
    public int[] A04;
    public final C1116Yn A05;
    public final C0881Pi A06;
    public final C0882Pj A07;

    public C0542Bg(C1116Yn c1116Yn, C0882Pj c0882Pj, C0881Pi c0881Pi) {
        super(c1116Yn);
        this.A02 = 0;
        this.A00 = 50.0f;
        this.A05 = c1116Yn;
        this.A07 = c0882Pj;
        this.A06 = c0881Pi;
        this.A01 = -1;
        this.A03 = new C0543Bh(this, c1116Yn);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03824o
    public final void A1J(C03894w c03894w, AnonymousClass53 anonymousClass53, int i, int widthMode) {
        int[] iArr;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(widthMode);
        if ((mode == 1073741824 && A26() == 1) || (mode2 == 1073741824 && A26() == 0)) {
            super.A1J(c03894w, anonymousClass53, i, widthMode);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(widthMode);
        if (this.A06.A01(this.A01)) {
            iArr = this.A06.A02(this.A01);
        } else {
            iArr = new int[]{0, 0};
            if (anonymousClass53.A03() >= 1) {
                int widthSize = A0W() > 0 ? 1 : A0W();
                for (int i5 = 0; i5 < widthSize; i5++) {
                    View A1m = A1m(i5);
                    if (A08[5].length() != 32) {
                        throw new RuntimeException();
                    }
                    A08[4] = "FajaHWp";
                    if (A1m == null) {
                        break;
                    }
                    this.A04 = this.A07.A00(A1m, View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    if (A26() == 0) {
                        int heightMode = iArr[0];
                        int[] iArr2 = this.A04;
                        iArr[0] = heightMode + iArr2[0];
                        if (i5 == 0) {
                            int A0g = iArr2[1] + A0g();
                            if (A08[6].length() != 1) {
                                A08[6] = "o1L5u";
                                iArr[1] = A0g + A0d();
                            } else {
                                throw new RuntimeException();
                            }
                        } else {
                            continue;
                        }
                    } else {
                        int i6 = iArr[1];
                        int[] iArr3 = this.A04;
                        if (A08[6].length() != 1) {
                            A08[5] = "6nCDHSOFLCCkeDdRDThHGlolS6KLs45E";
                            iArr[1] = i6 + iArr3[1];
                            if (i5 != 0) {
                            }
                            iArr[0] = iArr3[0] + A0e() + A0f();
                        } else {
                            A08[3] = "KFvpvLkhCjqU9hzA1pvFB";
                            iArr[1] = i6 + iArr3[1];
                            if (i5 != 0) {
                            }
                            iArr[0] = iArr3[0] + A0e() + A0f();
                        }
                    }
                }
                int widthMode2 = this.A01;
                if (widthMode2 != -1) {
                    this.A06.A00(widthMode2, iArr);
                }
            }
        }
        if (mode == 1073741824) {
            iArr[0] = size;
        }
        if (mode2 == 1073741824) {
            iArr[1] = size2;
        }
        A13(iArr[0], iArr[1]);
    }

    @Override // com.facebook.ads.redexgen.X.C1142Zo, com.facebook.ads.redexgen.X.AbstractC03824o
    public final void A1p(int i) {
        A2B(i, this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.C1142Zo, com.facebook.ads.redexgen.X.AbstractC03824o
    public final void A1x(C0599Eb c0599Eb, AnonymousClass53 anonymousClass53, int i) {
        this.A03.A0A(i);
        A1L(this.A03);
    }

    public final void A2G(double d2) {
        if (d2 <= 0.0d) {
            d2 = 1.0d;
        }
        this.A00 = (float) (50.0d / d2);
        this.A03 = new C0543Bh(this, this.A05);
    }

    public final void A2H(int i) {
        this.A01 = i;
    }

    public final void A2I(int i) {
        this.A02 = i;
    }
}

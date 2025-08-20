package com.facebook.ads.redexgen.X;

import androidx.core.app.NotificationCompat;
/* loaded from: assets/audience_network.dex */
public final class D3 {
    public static String[] A0D = {"l0mEWa9ddmOWtLNaP3Ecwy6mLHD8UZzg", "VNe96EWaki8yaza3W8GwHPPKa5bxe5tO", "kmpa3GxYxfo0cf1rhuvwNk5Qrb09HabI", "3sCg2iJ29nRFYuhJ2lcUotI7GRJn6pCh", "XWLZFeRzwTnh2BC9TcYHYW69tvufAeZE", "SYdDROIE4gUmdNh4g7xzRZbmvYLgdVRD", "81JQxwgiV49o5YJunDWqlnSFkCvUozpt", "BnyGWHqAIvsDVpphtdYgIF4MDirarxKL"};
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public final C4 A0C;

    public D3(C4 c4) {
        this.A0C = c4;
    }

    private void A00(int i) {
        boolean z2 = this.A0A;
        this.A0C.AFS(this.A04, z2 ? 1 : 0, (int) (this.A01 - this.A03), i, null);
    }

    public final void A01() {
        this.A07 = false;
        this.A06 = false;
        this.A05 = false;
        this.A09 = false;
        this.A0B = false;
    }

    public final void A02(long j2, int i) {
        if (this.A0B && this.A06) {
            this.A0A = this.A08;
            this.A0B = false;
        } else if (!this.A05 && !this.A06) {
        } else {
            if (this.A09) {
                A00(i + ((int) (j2 - this.A01)));
            }
            this.A03 = this.A01;
            this.A04 = this.A02;
            this.A09 = true;
            this.A0A = this.A08;
        }
    }

    public final void A03(long j2, int i, int i5, long j4) {
        boolean z2 = false;
        this.A06 = false;
        this.A05 = false;
        this.A02 = j4;
        this.A00 = 0;
        this.A01 = j2;
        if (i5 >= 32) {
            if (!this.A0B) {
                boolean z3 = this.A09;
                if (A0D[0].charAt(27) == 'I') {
                    throw new RuntimeException();
                }
                A0D[0] = "GPqbNVd0KmzIn8HN4fJcjlRtDRWTnntY";
                if (z3) {
                    A00(i);
                    this.A09 = false;
                }
            }
            if (i5 <= 34) {
                boolean z4 = this.A0B;
                if (A0D[0].charAt(27) == 'I') {
                    throw new RuntimeException();
                }
                A0D[0] = "R2DrglDmm00IZ4lcqpbVOyN2qQAQtCsT";
                this.A05 = !z4;
                this.A0B = true;
            }
        }
        boolean z5 = i5 >= 16 && i5 <= 21;
        this.A08 = z5;
        this.A07 = (z5 || i5 <= 9) ? true : true;
    }

    public final void A04(byte[] bArr, int i, int i5) {
        if (this.A07) {
            int i6 = this.A00;
            int i8 = (i + 2) - i6;
            String[] strArr = A0D;
            if (strArr[1].charAt(18) == strArr[5].charAt(18)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0D;
            strArr2[1] = "cpcrPWEOO8MA3KXYn8qEkHLDMe8DBK4E";
            strArr2[5] = "pATXmdvV1oW6zIeHBCJgs6zY3L0W3Kgl";
            if (i8 < i5) {
                int headerOffset = bArr[i8];
                this.A06 = (headerOffset & NotificationCompat.FLAG_HIGH_PRIORITY) != 0;
                String[] strArr3 = A0D;
                String str = strArr3[7];
                String str2 = strArr3[6];
                int charAt = str.charAt(30);
                int headerOffset2 = str2.charAt(30);
                if (charAt != headerOffset2) {
                    A0D[2] = "v11A3OgFTS0Ad6G9jNFN3q5DAJDiI5ZW";
                    this.A07 = false;
                    return;
                }
                String[] strArr4 = A0D;
                strArr4[7] = "OBH0KjA8v9aSSxK5wO8V3n95O2rRmiSd";
                strArr4[6] = "STELshWQ5K1o99AkGFf5hhAcCQunI3bN";
                this.A07 = false;
                return;
            }
            this.A00 = i6 + (i5 - i);
        }
    }
}

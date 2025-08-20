package com.facebook.ads.redexgen.X;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class X0 implements InterfaceC0580Cy {
    public static byte[] A0E;
    public static String[] A0F = {"NvpEV7R7ZS5uNQ5TFb57EvhjwIZCTQku", "DdUDSiCrGQUoEviiVingxcQFfwNbDa", "hetlnsRY2wqGSQpiRITV", "h6jp2Z", "H3YUjFwBN5I", "HDGGogJPAHFPfOUxVzLcmHcfpTDLo", "fvYnB4Gz7ZvwaQ8Y4EtF6ZMgsdzNJKEV", "DcduA0DmY9P8nwkm6XpLf73k0ckt"};
    public long A00;
    public long A01;
    public C4 A02;
    public D3 A03;
    public String A04;
    public boolean A05;
    public final D7 A0B;
    public final boolean[] A0D = new boolean[3];
    public final D4 A0A = new D4(32, NotificationCompat.FLAG_HIGH_PRIORITY);
    public final D4 A08 = new D4(33, NotificationCompat.FLAG_HIGH_PRIORITY);
    public final D4 A06 = new D4(34, NotificationCompat.FLAG_HIGH_PRIORITY);
    public final D4 A07 = new D4(39, NotificationCompat.FLAG_HIGH_PRIORITY);
    public final D4 A09 = new D4(40, NotificationCompat.FLAG_HIGH_PRIORITY);
    public final C0697Hz A0C = new C0697Hz();

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 41);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        String[] strArr = A0F;
        if (strArr[4].length() == strArr[2].length()) {
            throw new RuntimeException();
        }
        A0F[3] = "YNSDJ1";
        A0E = new byte[]{121, 3, 7, 4, 99, 84, 80, 85, 84, 67, 126, 69, 78, 83, 91, 78, 72, 95, 78, 79, 11, 74, 88, 91, 78, 72, 95, 116, 89, 74, 95, 66, 68, 116, 66, 79, 72, 11, 93, 74, 71, 94, 78, 17, 11, 78, 81, 92, 93, 87, 23, 80, 93, 78, 91};
    }

    static {
        A02();
    }

    public X0(D7 d7) {
        this.A0B = d7;
    }

    public static Format A00(String str, D4 d4, D4 d42, D4 d43) {
        byte[] bArr = new byte[d4.A00 + d42.A00 + d43.A00];
        System.arraycopy(d4.A01, 0, bArr, 0, d4.A00);
        System.arraycopy(d42.A01, 0, bArr, d4.A00, d42.A00);
        System.arraycopy(d43.A01, 0, bArr, d4.A00 + d42.A00, d43.A00);
        I0 i0 = new I0(d42.A01, 0, d42.A00);
        i0.A07(44);
        int maxSubLayersMinus1 = i0.A05(3);
        i0.A06();
        i0.A07(88);
        i0.A07(8);
        int i = 0;
        for (int i5 = 0; i5 < maxSubLayersMinus1; i5++) {
            if (i0.A0A()) {
                i += 89;
            }
            if (i0.A0A()) {
                i += 8;
            }
        }
        i0.A07(i);
        if (maxSubLayersMinus1 > 0) {
            i0.A07((8 - maxSubLayersMinus1) * 2);
        }
        i0.A04();
        int A04 = i0.A04();
        if (A04 == 3) {
            i0.A06();
        }
        int picHeightInLumaSamples = i0.A04();
        int confWinLeftOffset = i0.A04();
        if (A0F[1].length() != 12) {
            String[] strArr = A0F;
            strArr[4] = "a8PzOvYW3xW";
            strArr[2] = "i4yWj6LgSPQERWLdQfta";
            if (i0.A0A()) {
                int chromaFormatIdc = i0.A04();
                int A042 = i0.A04();
                int toSkip = i0.A04();
                int A043 = i0.A04();
                picHeightInLumaSamples -= (chromaFormatIdc + A042) * ((A04 == 1 || A04 == 2) ? 2 : 1);
                confWinLeftOffset -= (toSkip + A043) * (A04 == 1 ? 2 : 1);
            }
            i0.A04();
            i0.A04();
            int A044 = i0.A04();
            for (int i6 = i0.A0A() ? 0 : maxSubLayersMinus1; i6 <= maxSubLayersMinus1; i6++) {
                i0.A04();
                i0.A04();
                i0.A04();
            }
            i0.A04();
            i0.A04();
            i0.A04();
            i0.A04();
            i0.A04();
            i0.A04();
            if (i0.A0A() && i0.A0A()) {
                A05(i0);
            }
            i0.A07(2);
            if (i0.A0A()) {
                i0.A07(8);
                i0.A04();
                i0.A04();
                i0.A06();
            }
            A06(i0);
            if (i0.A0A()) {
                for (int i8 = 0; i8 < i0.A04(); i8++) {
                    i0.A07(A044 + 4 + 1);
                }
            }
            i0.A07(2);
            float f4 = 1.0f;
            if (i0.A0A() && i0.A0A()) {
                int picWidthInLumaSamples = i0.A05(8);
                if (picWidthInLumaSamples == 255) {
                    int A05 = i0.A05(16);
                    int A052 = i0.A05(16);
                    if (A05 != 0 && A052 != 0) {
                        f4 = A05 / A052;
                    }
                } else {
                    float[] fArr = AbstractC0693Hv.A04;
                    String[] strArr2 = A0F;
                    if (strArr2[4].length() == strArr2[2].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr3 = A0F;
                    strArr3[4] = "Mq8kmMTSiz0";
                    strArr3[2] = "TBAE07oWZ5Khy7farxDr";
                    if (picWidthInLumaSamples < fArr.length) {
                        f4 = AbstractC0693Hv.A04[picWidthInLumaSamples];
                    } else {
                        Log.w(A01(0, 10, 24), A01(10, 35, 2) + picWidthInLumaSamples);
                    }
                }
            }
            String A01 = A01(45, 10, 17);
            List singletonList = Collections.singletonList(bArr);
            if (A0F[3].length() != 6) {
                String[] strArr4 = A0F;
                strArr4[7] = "REKIidOCsv4ptzsgivtfnGOww6JG";
                strArr4[5] = "T94vPaWVm7jdMSWQElc8luWGTOlSo";
                return Format.A03(str, A01, null, -1, -1, picHeightInLumaSamples, confWinLeftOffset, -1.0f, singletonList, -1, f4, null);
            }
            String[] strArr5 = A0F;
            strArr5[7] = "W2GdBlThEFkhmpYhDIzNH9YY1BaI";
            strArr5[5] = "0yDCfDeoWht2juYgXJKTHBbNY9ana";
            return Format.A03(str, A01, null, -1, -1, picHeightInLumaSamples, confWinLeftOffset, -1.0f, singletonList, -1, f4, null);
        }
        throw new RuntimeException();
    }

    private void A03(long j2, int i, int i5, long j4) {
        if (this.A05) {
            this.A03.A02(j2, i);
        } else {
            this.A0A.A04(i5);
            this.A08.A04(i5);
            this.A06.A04(i5);
            if (this.A0A.A03() && this.A08.A03() && this.A06.A03()) {
                this.A02.A5n(A00(this.A04, this.A0A, this.A08, this.A06));
                this.A05 = true;
            }
        }
        if (this.A07.A04(i5)) {
            D4 d4 = this.A07;
            if (A0F[1].length() == 12) {
                throw new RuntimeException();
            }
            A0F[3] = "Yba7mj";
            this.A0C.A0b(this.A07.A01, AbstractC0693Hv.A02(d4.A01, this.A07.A00));
            this.A0C.A0Z(5);
            this.A0B.A02(j4, this.A0C);
        }
        if (this.A09.A04(i5)) {
            this.A0C.A0b(this.A09.A01, AbstractC0693Hv.A02(this.A09.A01, this.A09.A00));
            this.A0C.A0Z(5);
            this.A0B.A02(j4, this.A0C);
        }
    }

    private void A04(long j2, int i, int i5, long j4) {
        if (this.A05) {
            this.A03.A03(j2, i, i5, j4);
        } else {
            this.A0A.A01(i5);
            this.A08.A01(i5);
            this.A06.A01(i5);
        }
        this.A07.A01(i5);
        this.A09.A01(i5);
    }

    public static void A05(I0 i0) {
        for (int i = 0; i < 4; i++) {
            int i5 = 0;
            while (i5 < 6) {
                int matrixId = 1;
                if (!i0.A0A()) {
                    i0.A04();
                } else {
                    int sizeId = i << 1;
                    int min = Math.min(64, 1 << (sizeId + 4));
                    if (i > 1) {
                        i0.A03();
                    }
                    for (int sizeId2 = 0; sizeId2 < min; sizeId2++) {
                        i0.A03();
                    }
                }
                if (i == 3) {
                    matrixId = 3;
                }
                i5 += matrixId;
            }
        }
    }

    public static void A06(I0 i0) {
        int A04 = i0.A04();
        boolean z2 = false;
        int numNegativePics = 0;
        for (int stRpsIdx = 0; stRpsIdx < A04; stRpsIdx++) {
            if (stRpsIdx != 0) {
                z2 = i0.A0A();
            }
            if (z2) {
                i0.A06();
                i0.A04();
                for (int i = 0; i <= numNegativePics; i++) {
                    if (i0.A0A()) {
                        i0.A06();
                    }
                }
            } else {
                int previousNumDeltaPocs = i0.A04();
                int A042 = i0.A04();
                numNegativePics = previousNumDeltaPocs + A042;
                for (int numShortTermRefPicSets = 0; numShortTermRefPicSets < previousNumDeltaPocs; numShortTermRefPicSets++) {
                    i0.A04();
                    i0.A06();
                }
                for (int numShortTermRefPicSets2 = 0; numShortTermRefPicSets2 < A042; numShortTermRefPicSets2++) {
                    i0.A04();
                    i0.A06();
                }
            }
        }
    }

    private void A07(byte[] bArr, int i, int i5) {
        if (this.A05) {
            this.A03.A04(bArr, i, i5);
        } else {
            this.A0A.A02(bArr, i, i5);
            this.A08.A02(bArr, i, i5);
            this.A06.A02(bArr, i, i5);
        }
        this.A07.A02(bArr, i, i5);
        this.A09.A02(bArr, i, i5);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void A4R(C0697Hz c0697Hz) {
        while (true) {
            int A04 = c0697Hz.A04();
            if (A0F[1].length() == 12) {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[0] = "AvzYB124iDQiX3hdxqfkLksaQ25q0Ga1";
            strArr[6] = "Nv2bR4D3VQ28suo5ivBlL2099SuCEJEb";
            if (A04 > 0) {
                int limit = c0697Hz.A06();
                int A07 = c0697Hz.A07();
                byte[] bArr = c0697Hz.A00;
                long j2 = this.A01;
                int offset = c0697Hz.A04();
                this.A01 = j2 + offset;
                C4 c4 = this.A02;
                int offset2 = c0697Hz.A04();
                c4.AFR(c0697Hz, offset2);
                while (limit < A07) {
                    int A042 = AbstractC0693Hv.A04(bArr, limit, A07, this.A0D);
                    if (A042 == A07) {
                        A07(bArr, limit, A07);
                        return;
                    }
                    int bytesWrittenPastPosition = AbstractC0693Hv.A00(bArr, A042);
                    int i = A042 - limit;
                    if (i > 0) {
                        A07(bArr, limit, A042);
                    }
                    int i5 = A07 - A042;
                    long j4 = this.A01 - i5;
                    int offset3 = i < 0 ? -i : 0;
                    A03(j4, i5, offset3, this.A00);
                    long absolutePosition = this.A00;
                    A04(j4, i5, bytesWrittenPastPosition, absolutePosition);
                    limit = A042 + 3;
                }
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void A4p(InterfaceC0556Bu interfaceC0556Bu, DC dc) {
        dc.A05();
        this.A04 = dc.A04();
        C4 AGi = interfaceC0556Bu.AGi(dc.A03(), 2);
        this.A02 = AGi;
        this.A03 = new D3(AGi);
        this.A0B.A03(interfaceC0556Bu, dc);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void ADs() {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void ADt(long j2, boolean z2) {
        this.A00 = j2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void AFg() {
        AbstractC0693Hv.A0B(this.A0D);
        this.A0A.A00();
        this.A08.A00();
        this.A06.A00();
        this.A07.A00();
        this.A09.A00();
        this.A03.A01();
        this.A01 = 0L;
    }
}

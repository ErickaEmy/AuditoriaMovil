package com.facebook.ads.redexgen.X;

import androidx.core.app.NotificationCompat;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class X1 implements InterfaceC0580Cy {
    public static byte[] A0E;
    public static String[] A0F = {"FmtBUqGmzQvxm47AtoGl5GE", "5iXLyJPyDLcaPMUjk1v5bxBpoPhfo", "hif1Xiw3z0OLVixA8K1yUZiszA96", "VzETX2BwbL5Y", "rXQDE7FzOjIY2cTlxG1EbFIaNFkq3NBz", "hyxBaGmEw9nsGl9VO3HFyZpkQthqrgGl", "hfnp76HvDzKR", "cXQxcUyRSwddwq1B1B5vUbLw26Cn"};
    public long A00;
    public long A01;
    public C4 A02;
    public D2 A03;
    public String A04;
    public boolean A05;
    public final D7 A09;
    public final boolean A0B;
    public final boolean A0C;
    public final boolean[] A0D = new boolean[3];
    public final D4 A08 = new D4(7, NotificationCompat.FLAG_HIGH_PRIORITY);
    public final D4 A06 = new D4(8, NotificationCompat.FLAG_HIGH_PRIORITY);
    public final D4 A07 = new D4(6, NotificationCompat.FLAG_HIGH_PRIORITY);
    public final C0697Hz A0A = new C0697Hz();

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 73);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A0E = new byte[]{-47, -60, -65, -64, -54, -118, -68, -47, -66};
    }

    static {
        A01();
    }

    public X1(D7 d7, boolean z2, boolean z3) {
        this.A09 = d7;
        this.A0B = z2;
        this.A0C = z3;
    }

    private void A02(long j2, int i, int i5, long j4) {
        if (!this.A05 || this.A03.A07()) {
            this.A08.A04(i5);
            this.A06.A04(i5);
            if (!this.A05) {
                if (this.A08.A03() && this.A06.A03()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Arrays.copyOf(this.A08.A01, this.A08.A00));
                    arrayList.add(Arrays.copyOf(this.A06.A01, this.A06.A00));
                    C0692Hu spsData = AbstractC0693Hv.A06(this.A08.A01, 3, this.A08.A00);
                    C0691Ht A05 = AbstractC0693Hv.A05(this.A06.A01, 3, this.A06.A00);
                    this.A02.A5n(Format.A03(this.A04, A00(0, 9, 18), null, -1, -1, spsData.A06, spsData.A02, -1.0f, arrayList, -1, spsData.A00, null));
                    this.A05 = true;
                    this.A03.A05(spsData);
                    this.A03.A04(A05);
                    this.A08.A00();
                    this.A06.A00();
                }
            } else if (this.A08.A03()) {
                this.A03.A05(AbstractC0693Hv.A06(this.A08.A01, 3, this.A08.A00));
                this.A08.A00();
            } else if (this.A06.A03()) {
                this.A03.A04(AbstractC0693Hv.A05(this.A06.A01, 3, this.A06.A00));
                this.A06.A00();
            }
        }
        if (this.A07.A04(i5)) {
            D4 d4 = this.A07;
            String[] strArr = A0F;
            if (strArr[4].charAt(26) == strArr[5].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[4] = "MYiVFEqyRoVR8PpaQvBVtWO0d80axIUe";
            strArr2[5] = "WESehlM6UD3i8IXgr5ZdByrcv93bSxFf";
            int unescapedLength = AbstractC0693Hv.A02(d4.A01, this.A07.A00);
            this.A0A.A0b(this.A07.A01, unescapedLength);
            this.A0A.A0Y(4);
            this.A09.A02(j4, this.A0A);
        }
        this.A03.A02(j2, i);
    }

    private void A03(long j2, int i, long j4) {
        if (!this.A05 || this.A03.A07()) {
            this.A08.A01(i);
            this.A06.A01(i);
        }
        this.A07.A01(i);
        this.A03.A03(j2, i, j4);
    }

    private void A04(byte[] bArr, int i, int i5) {
        if (!this.A05 || this.A03.A07()) {
            this.A08.A02(bArr, i, i5);
            this.A06.A02(bArr, i, i5);
        }
        this.A07.A02(bArr, i, i5);
        this.A03.A06(bArr, i, i5);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void A4R(C0697Hz c0697Hz) {
        int offset;
        int A06 = c0697Hz.A06();
        int A07 = c0697Hz.A07();
        byte[] bArr = c0697Hz.A00;
        long j2 = this.A01;
        int offset2 = c0697Hz.A04();
        this.A01 = j2 + offset2;
        C4 c4 = this.A02;
        int offset3 = c0697Hz.A04();
        c4.AFR(c0697Hz, offset3);
        while (true) {
            int A04 = AbstractC0693Hv.A04(bArr, A06, A07, this.A0D);
            if (A04 == A07) {
                A04(bArr, A06, A07);
                return;
            }
            int lengthToNalUnit = AbstractC0693Hv.A01(bArr, A04);
            int i = A04 - A06;
            String[] strArr = A0F;
            if (strArr[3].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[3] = "lQl99M6qnQlq";
            strArr2[6] = "jJKIbaSVKHql";
            if (i > 0) {
                A04(bArr, A06, A04);
            }
            int i5 = A07 - A04;
            long j4 = this.A01 - i5;
            if (i < 0) {
                offset = -i;
                String[] strArr3 = A0F;
                if (strArr3[7].length() != strArr3[2].length()) {
                    String[] strArr4 = A0F;
                    strArr4[7] = "CFaupTF247UissJwn80OFqAOj9Vx";
                    strArr4[2] = "5OzpI30ijAeJlsq8Y1OyIdlDADpj";
                } else {
                    String[] strArr5 = A0F;
                    strArr5[1] = "eqTKDwhJaRXE4qM7uaf5ert1lQX8N";
                    strArr5[0] = "XXULpdZ36j09HmRAAM7fCX7";
                }
            } else {
                offset = 0;
            }
            A02(j4, i5, offset, this.A00);
            A03(j4, lengthToNalUnit, this.A00);
            A06 = A04 + 3;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void A4p(InterfaceC0556Bu interfaceC0556Bu, DC dc) {
        dc.A05();
        this.A04 = dc.A04();
        C4 AGi = interfaceC0556Bu.AGi(dc.A03(), 2);
        this.A02 = AGi;
        this.A03 = new D2(AGi, this.A0B, this.A0C);
        this.A09.A03(interfaceC0556Bu, dc);
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
        this.A08.A00();
        this.A06.A00();
        this.A07.A00();
        this.A03.A01();
        this.A01 = 0L;
    }
}

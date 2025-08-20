package com.facebook.ads.redexgen.X;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class XJ implements InterfaceC0570Cl {
    public static byte[] A0C;
    public static String[] A0D = {"qlUqm53dx2wRFYI19yFYkvkmPQFopPfK", "kfzPj4jiKhQrTstJ9wOtTomcMDMJFI2R", "tio4jxSpdKgrcMNksdh3F2ai0PxCizyi", "S5qskWqDqPkhPpuUuuvRcKySD9vc4n0H", "X67UodKHNvmZa3DnASt4fZlpL2cJMcNV", "01LnOYH7rGQp5f5o2UGBiyg7bnJQxBa8", "qDTiiMVukWANjWrPbJo4riKeblMOo1tu", "5dAWhKcmsHilqUXjq3PFXu2GkNxyPnDG"};
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public long A06;
    public long A07;
    public final long A08;
    public final long A09;
    public final C0569Ck A0A = new C0569Ck();
    public final AbstractC0573Co A0B;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private final long A01(long j2, InterfaceC0555Bt interfaceC0555Bt) throws IOException, InterruptedException {
        if (this.A04 == this.A01) {
            return -(this.A05 + 2);
        }
        long A7i = interfaceC0555Bt.A7i();
        if (!A0D(interfaceC0555Bt, this.A01)) {
            long j4 = this.A04;
            if (j4 != A7i) {
                return j4;
            }
            throw new IOException(A09(0, 25, 22));
        }
        this.A0A.A03(interfaceC0555Bt, false);
        interfaceC0555Bt.AFM();
        long j6 = j2 - this.A0A.A05;
        int i = this.A0A.A01 + this.A0A.A00;
        if (j6 >= 0 && j6 <= 72000) {
            interfaceC0555Bt.AGP(i);
            return -(this.A0A.A05 + 2);
        }
        if (j6 < 0) {
            this.A01 = A7i;
            this.A02 = this.A0A.A05;
        } else {
            this.A04 = interfaceC0555Bt.A7i() + i;
            this.A05 = this.A0A.A05;
            if ((this.A01 - this.A04) + i < 100000) {
                interfaceC0555Bt.AGP(i);
                return -(this.A05 + 2);
            }
        }
        long j7 = this.A01;
        long j8 = this.A04;
        String[] strArr = A0D;
        if (strArr[4].charAt(12) != strArr[0].charAt(12)) {
            A0D[3] = "zvKF8WQUI0SajHpo4Xv9v8DHT9e2MTPL";
            if (j7 - j8 < 100000) {
                this.A01 = j8;
                return j8;
            }
            long j9 = i;
            long j10 = j6 > 0 ? 1L : 2L;
            long A7i2 = interfaceC0555Bt.A7i();
            long j11 = this.A01;
            long j12 = this.A04;
            return Math.min(Math.max((A7i2 - (j9 * j10)) + (((j11 - j12) * j6) / (this.A02 - this.A05)), j12), this.A01 - 1);
        }
        throw new RuntimeException();
    }

    public static String A09(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 78);
        }
        return new String(copyOfRange);
    }

    public static void A0A() {
        A0C = new byte[]{22, 55, 120, 55, 63, 63, 120, 40, 57, 63, 61, 120, 59, 57, 54, 120, 58, 61, 120, 62, 55, 45, 54, 60, 118};
    }

    static {
        A0A();
    }

    public XJ(long j2, long j4, AbstractC0573Co abstractC0573Co, int i, long j6) {
        AbstractC0672Ha.A03(j2 >= 0 && j4 > j2);
        this.A0B = abstractC0573Co;
        this.A09 = j2;
        this.A08 = j4;
        if (i == j4 - j2) {
            this.A07 = j6;
            this.A00 = 3;
            return;
        }
        this.A00 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A00(long j2, long j4, long j6) {
        long j7 = this.A08;
        long j8 = this.A09;
        long j9 = j2 + ((((j7 - j8) * j4) / this.A07) - j6);
        if (j9 < j8) {
            j9 = this.A09;
        }
        if (j9 >= j7) {
            return j7 - 1;
        }
        return j9;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0051, code lost:
        return r5.A0A.A05;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long A02(com.facebook.ads.redexgen.X.InterfaceC0555Bt r6) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r5 = this;
            r5.A0C(r6)
            com.facebook.ads.redexgen.X.Ck r0 = r5.A0A
            r0.A02()
        L8:
            com.facebook.ads.redexgen.X.Ck r0 = r5.A0A
            int r3 = r0.A04
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.XJ.A0D
            r0 = 4
            r1 = r2[r0]
            r0 = 0
            r2 = r2[r0]
            r0 = 12
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L52
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.XJ.A0D
            java.lang.String r1 = "8L7HD1AI4we5ropKbStlQEIIPOmJrEUL"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "xLnKc6RM4Edpr9DSdPLSxPAMnW98GKHb"
            r0 = 2
            r2[r0] = r1
            r0 = 4
            r3 = r3 & r0
            if (r3 == r0) goto L4d
            long r3 = r6.A7i()
            long r1 = r5.A08
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto L4d
            com.facebook.ads.redexgen.X.Ck r1 = r5.A0A
            r0 = 0
            r1.A03(r6, r0)
            com.facebook.ads.redexgen.X.Ck r0 = r5.A0A
            int r1 = r0.A01
            com.facebook.ads.redexgen.X.Ck r0 = r5.A0A
            int r0 = r0.A00
            int r1 = r1 + r0
            r6.AGP(r1)
            goto L8
        L4d:
            com.facebook.ads.redexgen.X.Ck r0 = r5.A0A
            long r0 = r0.A05
            return r0
        L52:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.XJ.A02(com.facebook.ads.redexgen.X.Bt):long");
    }

    private final long A03(InterfaceC0555Bt interfaceC0555Bt, long j2, long j4) throws IOException, InterruptedException {
        this.A0A.A03(interfaceC0555Bt, false);
        while (this.A0A.A05 < j2) {
            interfaceC0555Bt.AGP(this.A0A.A01 + this.A0A.A00);
            j4 = this.A0A.A05;
            this.A0A.A03(interfaceC0555Bt, false);
        }
        interfaceC0555Bt.AFM();
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0570Cl
    /* renamed from: A07 */
    public final XK A4m() {
        if (this.A07 != 0) {
            return new XK(this);
        }
        return null;
    }

    private final void A0B() {
        this.A04 = this.A09;
        this.A01 = this.A08;
        this.A05 = 0L;
        this.A02 = this.A07;
    }

    private final void A0C(InterfaceC0555Bt interfaceC0555Bt) throws IOException, InterruptedException {
        if (A0D(interfaceC0555Bt, this.A08)) {
            return;
        }
        throw new EOFException();
    }

    private final boolean A0D(InterfaceC0555Bt interfaceC0555Bt, long j2) throws IOException, InterruptedException {
        long min = Math.min(3 + j2, this.A08);
        byte[] bArr = new byte[2048];
        int i = bArr.length;
        while (true) {
            if (interfaceC0555Bt.A7i() + i > min && (i = (int) (min - interfaceC0555Bt.A7i())) < 4) {
                return false;
            }
            interfaceC0555Bt.ADw(bArr, 0, i, false);
            for (int i5 = 0; i5 < i - 3; i5++) {
                int peekLength = bArr[i5];
                if (peekLength == 79 && bArr[i5 + 1] == 103 && bArr[i5 + 2] == 103) {
                    int peekLength2 = bArr[i5 + 3];
                    if (peekLength2 == 83) {
                        interfaceC0555Bt.AGP(i5);
                        return true;
                    }
                }
            }
            interfaceC0555Bt.AGP(i - 3);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007c, code lost:
        if (r1 > r3) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0091, code lost:
        if (r1 > r3) goto L24;
     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0570Cl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long AEI(com.facebook.ads.redexgen.X.InterfaceC0555Bt r14) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r13 = this;
            int r0 = r13.A00
            r5 = 3
            r8 = r14
            switch(r0) {
                case 0: goto L50;
                case 1: goto L94;
                case 2: goto L10;
                case 3: goto Ld;
                default: goto L7;
            }
        L7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        Ld:
            r0 = -1
            return r0
        L10:
            long r2 = r13.A06
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.XJ.A0D
            r0 = 3
            r1 = r1[r0]
            r0 = 18
            char r1 = r1.charAt(r0)
            r0 = 118(0x76, float:1.65E-43)
            if (r1 == r0) goto L27
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L27:
            java.lang.String[] r4 = com.facebook.ads.redexgen.X.XJ.A0D
            java.lang.String r1 = "5HAo5Th3dlJMt4bYi9vd99sok2AKRnDx"
            r0 = 3
            r4[r0] = r1
            r0 = 2
            r6 = 0
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 != 0) goto L3d
            r2 = 0
        L38:
            r13.A00 = r5
            long r0 = r0 + r2
            long r2 = -r0
            return r2
        L3d:
            long r2 = r13.A01(r2, r8)
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 < 0) goto L46
            return r2
        L46:
            long r9 = r13.A06
            long r2 = r2 + r0
            long r11 = -r2
            r7 = r13
            long r2 = r7.A03(r8, r9, r11)
            goto L38
        L50:
            long r3 = r8.A7i()
            r13.A03 = r3
            r0 = 1
            r13.A00 = r0
            long r1 = r13.A08
            java.lang.String[] r6 = com.facebook.ads.redexgen.X.XJ.A0D
            r0 = 5
            r6 = r6[r0]
            r0 = 14
            char r6 = r6.charAt(r0)
            r0 = 69
            if (r6 == r0) goto L7f
            java.lang.String[] r7 = com.facebook.ads.redexgen.X.XJ.A0D
            java.lang.String r6 = "y7O6pPdi4ZltSjD6KADDWtfh1EQ3ypYE"
            r0 = 1
            r7[r0] = r6
            java.lang.String r6 = "PCOWfrd56ab6qHMTUxzEVaAjhpd6ZxlM"
            r0 = 2
            r7[r0] = r6
            r6 = 65307(0xff1b, double:3.2266E-319)
            long r1 = r1 - r6
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 <= 0) goto L94
        L7e:
            return r1
        L7f:
            java.lang.String[] r7 = com.facebook.ads.redexgen.X.XJ.A0D
            java.lang.String r6 = "CYddPgWATLyxqxIaeTkpx7ccDiEA63Cn"
            r0 = 4
            r7[r0] = r6
            java.lang.String r6 = "yHXSkk2QTXaOjUGCO1LifWaF4YjGjaVe"
            r0 = 0
            r7[r0] = r6
            r6 = 65307(0xff1b, double:3.2266E-319)
            long r1 = r1 - r6
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 <= 0) goto L94
            goto L7e
        L94:
            long r0 = r13.A02(r8)
            r13.A07 = r0
            r13.A00 = r5
            long r0 = r13.A03
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.XJ.AEI(com.facebook.ads.redexgen.X.Bt):long");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0570Cl
    public final long AGX(long j2) {
        int i = this.A00;
        AbstractC0672Ha.A03(i == 3 || i == 2);
        long j4 = 0;
        if (j2 != 0) {
            j4 = this.A0B.A04(j2);
        }
        this.A06 = j4;
        this.A00 = 2;
        A0B();
        return this.A06;
    }
}

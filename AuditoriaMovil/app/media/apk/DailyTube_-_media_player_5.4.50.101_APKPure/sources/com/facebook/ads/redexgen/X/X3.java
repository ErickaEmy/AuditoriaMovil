package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class X3 implements InterfaceC0580Cy {
    public static byte[] A06;
    public static String[] A07 = {"c0KpkRjZorNQD76", "v", "0d4inMg3wDkuo1aYYl0ssqqGC", "DDXERfdvXnPt4luj6e7N9DVUtx6ZaQcR", "MB0SdpAzdDPGS5LRihVQgeZ9YJgSZ4OW", "1ftUnjVA0zWQWzcI2VyXZGsvfHTse3XE", "DWX3euW52jSmR8J8g1ui9PfHl", "CNcDYli8yhj93EfpNTcuq0KbKbZRyRug"};
    public int A00;
    public int A01;
    public long A02;
    public boolean A03;
    public final List<D9> A04;
    public final C4[] A05;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 85);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{52, 67, 67, 63, 60, 54, 52, 71, 60, 66, 65, 2, 55, 73, 53, 70, 72, 53, 70};
    }

    static {
        A01();
    }

    public X3(List<D9> list) {
        this.A04 = list;
        this.A05 = new C4[list.size()];
    }

    private boolean A02(C0697Hz c0697Hz, int i) {
        if (c0697Hz.A04() == 0) {
            return false;
        }
        if (c0697Hz.A0E() != i) {
            this.A03 = false;
        }
        this.A00--;
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void A4R(C0697Hz c0697Hz) {
        C4[] c4Arr;
        if (this.A03) {
            if (this.A00 == 2 && !A02(c0697Hz, 32)) {
                return;
            }
            if (this.A00 == 1 && !A02(c0697Hz, 0)) {
                return;
            }
            int A062 = c0697Hz.A06();
            if (A07[5].charAt(6) != 'V') {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[2] = "JHIe8W9CfwFDjJjaFpf1hCiFr";
            strArr[6] = "vBjglJY7hKXluELD1o7ad0wQv";
            int bytesAvailable = c0697Hz.A04();
            for (C4 c4 : this.A05) {
                c0697Hz.A0Y(A062);
                c4.AFR(c0697Hz, bytesAvailable);
            }
            int dataPosition = this.A01;
            this.A01 = dataPosition + bytesAvailable;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0004 */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A4p(com.facebook.ads.redexgen.X.InterfaceC0556Bu r15, com.facebook.ads.redexgen.X.DC r16) {
        /*
            r14 = this;
            r2 = 0
        L1:
            com.facebook.ads.redexgen.X.C4[] r0 = r14.A05
            int r0 = r0.length
            if (r2 >= r0) goto L41
            java.util.List<com.facebook.ads.redexgen.X.D9> r0 = r14.A04
            java.lang.Object r5 = r0.get(r2)
            com.facebook.ads.redexgen.X.D9 r5 = (com.facebook.ads.redexgen.X.D9) r5
            r16.A05()
            int r1 = r16.A03()
            r0 = 3
            com.facebook.ads.redexgen.X.C4 r1 = r15.AGi(r1, r0)
            java.lang.String r6 = r16.A04()
            r4 = 0
            r3 = 19
            r0 = 126(0x7e, float:1.77E-43)
            java.lang.String r7 = A00(r4, r3, r0)
            r8 = 0
            r9 = -1
            r10 = 0
            byte[] r0 = r5.A02
            java.util.List r11 = java.util.Collections.singletonList(r0)
            java.lang.String r12 = r5.A01
            r13 = 0
            com.facebook.ads.internal.exoplayer2.thirdparty.Format r0 = com.facebook.ads.internal.exoplayer2.thirdparty.Format.A0A(r6, r7, r8, r9, r10, r11, r12, r13)
            r1.A5n(r0)
            com.facebook.ads.redexgen.X.C4[] r0 = r14.A05
            r0[r2] = r1
            int r2 = r2 + 1
            goto L1
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.X3.A4p(com.facebook.ads.redexgen.X.Bu, com.facebook.ads.redexgen.X.DC):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void ADs() {
        if (this.A03) {
            for (C4 c4 : this.A05) {
                c4.AFS(this.A02, 1, this.A01, 0, null);
            }
            this.A03 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void ADt(long j2, boolean z2) {
        if (!z2) {
            return;
        }
        this.A03 = true;
        this.A02 = j2;
        this.A01 = 0;
        this.A00 = 2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0580Cy
    public final void AFg() {
        this.A03 = false;
    }
}

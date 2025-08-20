package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.util.Arrays;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class D7 {
    public static byte[] A02;
    public final List<Format> A00;
    public final C4[] A01;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 56);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-107, -70, -62, -83, -72, -75, -80, 108, -81, -72, -69, -65, -79, -80, 108, -81, -83, -68, -64, -75, -69, -70, 108, -71, -75, -71, -79, 108, -64, -59, -68, -79, 108, -68, -66, -69, -62, -75, -80, -79, -80, -122, 108, -17, -2, -2, -6, -9, -15, -17, 2, -9, -3, -4, -67, -15, -13, -17, -69, -60, -66, -58, -4, 11, 11, 7, 4, -2, -4, 15, 4, 10, 9, -54, -2, 0, -4, -56, -46, -53, -45};
    }

    public D7(List<Format> closedCaptionFormats) {
        this.A00 = closedCaptionFormats;
        this.A01 = new C4[closedCaptionFormats.size()];
    }

    public final void A02(long j2, C0697Hz c0697Hz) {
        AbstractC0646Fy.A03(j2, c0697Hz, this.A01);
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0004 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A03(com.facebook.ads.redexgen.X.InterfaceC0556Bu r16, com.facebook.ads.redexgen.X.DC r17) {
        /*
            r15 = this;
            r2 = 0
        L1:
            com.facebook.ads.redexgen.X.C4[] r0 = r15.A01
            int r0 = r0.length
            if (r2 >= r0) goto L80
            r17.A05()
            int r1 = r17.A03()
            r0 = 3
            r3 = r16
            com.facebook.ads.redexgen.X.C4 r1 = r3.AGi(r1, r0)
            java.util.List<com.facebook.ads.internal.exoplayer2.thirdparty.Format> r0 = r15.A00
            java.lang.Object r3 = r0.get(r2)
            com.facebook.ads.internal.exoplayer2.thirdparty.Format r3 = (com.facebook.ads.internal.exoplayer2.thirdparty.Format) r3
            java.lang.String r8 = r3.A0O
            r5 = 43
            r4 = 19
            r0 = 86
            java.lang.String r0 = A00(r5, r4, r0)
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L3e
            r5 = 62
            r4 = 19
            r0 = 99
            java.lang.String r0 = A00(r5, r4, r0)
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L7e
        L3e:
            r7 = 1
        L3f:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r5 = 0
            r4 = 43
            r0 = 20
            java.lang.String r0 = A00(r5, r4, r0)
            java.lang.StringBuilder r0 = r6.append(r0)
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.String r0 = r0.toString()
            com.facebook.ads.redexgen.X.AbstractC0672Ha.A05(r7, r0)
            java.lang.String r0 = r3.A0M
            if (r0 == 0) goto L79
            java.lang.String r7 = r3.A0M
        L62:
            r9 = 0
            r10 = -1
            int r11 = r3.A0D
            java.lang.String r12 = r3.A0N
            int r13 = r3.A03
            r14 = 0
            com.facebook.ads.internal.exoplayer2.thirdparty.Format r0 = com.facebook.ads.internal.exoplayer2.thirdparty.Format.A08(r7, r8, r9, r10, r11, r12, r13, r14)
            r1.A5n(r0)
            com.facebook.ads.redexgen.X.C4[] r0 = r15.A01
            r0[r2] = r1
            int r2 = r2 + 1
            goto L1
        L79:
            java.lang.String r7 = r17.A04()
            goto L62
        L7e:
            r7 = 0
            goto L3f
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.D7.A03(com.facebook.ads.redexgen.X.Bu, com.facebook.ads.redexgen.X.DC):void");
    }
}

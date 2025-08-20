package com.facebook.ads.redexgen.X;

import java.io.IOException;
/* loaded from: assets/audience_network.dex */
public final class WV implements FB {
    public static String[] A03 = {"2iJQWlRsUDoPLtxxhE0wL9Cx9C7nOBrU", "oJgjoNY6hjjHJmelHDlI5xZuIY2b67h", "lPiJTezOZt4yDoox6bX3l7R6F2XzCVNN", "wrWzKGBonHGMzL1uPVOM3eUURFaMzKwB", "aBcbXNoo2m3wtFqQFSiOk3RFoevM7GVG", "GcCP7ZOQcwM7LeXwSBQclRy3S6aYmmD", "JUPsbTU3PQNYOt9vjPoPUzbQPtEFF22Q", "21kt6KXNgOdDUktVBInrV9GyhB6eLfYq"};
    public boolean A00;
    public final FB A01;
    public final /* synthetic */ CI A02;

    public WV(CI ci, FB fb2) {
        this.A02 = ci;
        this.A01 = fb2;
    }

    public final void A00() {
        this.A00 = false;
    }

    @Override // com.facebook.ads.redexgen.X.FB
    public final boolean A9C() {
        return !this.A02.A03() && this.A01.A9C();
    }

    @Override // com.facebook.ads.redexgen.X.FB
    public final void AAM() throws IOException {
        this.A01.AAM();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
        if (r0 != 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
        if (r0 < 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
        if (r0 == 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
        r14.A07();
        r14.A02(4);
        r12.A00 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0073, code lost:
        return -4;
     */
    @Override // com.facebook.ads.redexgen.X.FB
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int AEK(com.facebook.ads.redexgen.X.C04999p r13, com.facebook.ads.redexgen.X.C1094Xr r14, boolean r15) {
        /*
            r12 = this;
            com.facebook.ads.redexgen.X.CI r0 = r12.A02
            boolean r0 = r0.A03()
            r8 = -3
            if (r0 == 0) goto La
            return r8
        La:
            boolean r0 = r12.A00
            r6 = 4
            r5 = -4
            if (r0 == 0) goto L14
            r14.A02(r6)
            return r5
        L14:
            com.facebook.ads.redexgen.X.FB r0 = r12.A01
            int r7 = r0.AEK(r13, r14, r15)
            r9 = -5
            r10 = -9223372036854775808
            if (r7 != r9) goto L4a
            com.facebook.ads.internal.exoplayer2.thirdparty.Format r7 = r13.A00
            int r0 = r7.A06
            if (r0 != 0) goto L29
            int r0 = r7.A07
            if (r0 == 0) goto L43
        L29:
            com.facebook.ads.redexgen.X.CI r0 = r12.A02
            long r1 = r0.A01
            r5 = 0
            r4 = 0
            int r0 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r0 == 0) goto L47
            r3 = 0
        L35:
            com.facebook.ads.redexgen.X.CI r0 = r12.A02
            long r1 = r0.A00
            int r0 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r0 == 0) goto L44
        L3d:
            com.facebook.ads.internal.exoplayer2.thirdparty.Format r0 = r7.A0G(r3, r4)
            r13.A00 = r0
        L43:
            return r9
        L44:
            int r4 = r7.A07
            goto L3d
        L47:
            int r3 = r7.A06
            goto L35
        L4a:
            com.facebook.ads.redexgen.X.CI r0 = r12.A02
            long r0 = r0.A00
            int r2 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r2 == 0) goto L74
            if (r7 != r5) goto L5e
            long r3 = r14.A00
            com.facebook.ads.redexgen.X.CI r0 = r12.A02
            long r1 = r0.A00
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto L6a
        L5e:
            if (r7 != r8) goto L74
            com.facebook.ads.redexgen.X.CI r0 = r12.A02
            long r1 = r0.A6D()
            int r0 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r0 != 0) goto L74
        L6a:
            r14.A07()
            r14.A02(r6)
            r0 = 1
            r12.A00 = r0
            return r5
        L74:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.WV.AEK(com.facebook.ads.redexgen.X.9p, com.facebook.ads.redexgen.X.Xr, boolean):int");
    }

    @Override // com.facebook.ads.redexgen.X.FB
    public final int AGO(long j2) {
        if (this.A02.A03()) {
            if (A03[7].charAt(6) != 'T') {
                A03[0] = "I7Vle9theSHJs2vfg5SYnPGKFT8j8RVM";
                return -3;
            }
            throw new RuntimeException();
        }
        return this.A01.AGO(j2);
    }
}

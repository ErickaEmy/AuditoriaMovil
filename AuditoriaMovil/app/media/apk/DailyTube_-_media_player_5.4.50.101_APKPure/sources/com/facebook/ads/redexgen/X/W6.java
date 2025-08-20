package com.facebook.ads.redexgen.X;

import android.util.Pair;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup;
/* loaded from: assets/audience_network.dex */
public abstract class W6 extends AbstractC0656Gj {
    public static String[] A01 = {"JXADnguvwbjBsYgslHoSHgr2xxMnawNn", "", "jNEAQ3UZ70aM1hHDYV2CS20ieNSkmYbb", "bnkACY5tQbsoiCdyBJgaOjSRI0w0kmrQ", "gVGuKveDeddXJzh5PaouiQlIwgfOoZnh", "qzMEUGGJ0FpDLYRljtzJ24rj8XT6rBKz", "LijUR", "ZVB7ZDT4TSe2rtQPBLBW6RwhtV59NTLq"};
    public C0651Ge A00;

    public abstract Pair<AB[], InterfaceC0653Gg[]> A0V(C0651Ge c0651Ge, int[][][] iArr, int[] iArr2) throws C04879c;

    /* JADX WARN: Incorrect condition in loop: B:4:0x0004 */
    /* JADX WARN: Incorrect condition in loop: B:7:0x000b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int A0Q(com.facebook.ads.redexgen.X.AA[] r6, com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup r7) throws com.facebook.ads.redexgen.X.C04879c {
        /*
            int r5 = r6.length
            r4 = 0
            r3 = 0
        L3:
            int r0 = r6.length
            if (r3 >= r0) goto L25
            r2 = r6[r3]
            r1 = 0
        L9:
            int r0 = r7.A01
            if (r1 >= r0) goto L22
            com.facebook.ads.internal.exoplayer2.thirdparty.Format r0 = r7.A01(r1)
            int r0 = r2.AGe(r0)
            r0 = r0 & 7
            if (r0 <= r4) goto L1f
            r5 = r3
            r4 = r0
            r0 = 4
            if (r4 != r0) goto L1f
            return r5
        L1f:
            int r1 = r1 + 1
            goto L9
        L22:
            int r3 = r3 + 1
            goto L3
        L25:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.W6.A0Q(com.facebook.ads.redexgen.X.AA[], com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup):int");
    }

    public static int[] A0R(AA aa, TrackGroup trackGroup) throws C04879c {
        int[] iArr = new int[trackGroup.A01];
        for (int i = 0; i < trackGroup.A01; i++) {
            iArr[i] = aa.AGe(trackGroup.A01(i));
        }
        return iArr;
    }

    public static int[] A0S(AA[] aaArr) throws C04879c {
        int[] iArr = new int[aaArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = aaArr[i].AGg();
        }
        return iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0065, code lost:
        if (r3 == r8) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0067, code lost:
        r2 = new int[r4.A01];
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008a, code lost:
        if (r3 == r8) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008d, code lost:
        r8 = r13[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009b, code lost:
        if (com.facebook.ads.redexgen.X.W6.A01[4].charAt(3) == 'u') goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009d, code lost:
        r2 = A0R(r8, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a2, code lost:
        com.facebook.ads.redexgen.X.W6.A01[1] = "";
        r2 = A0R(r8, r4);
     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0656Gj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.facebook.ads.redexgen.X.C0657Gk A0T(com.facebook.ads.redexgen.X.AA[] r13, com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray r14) throws com.facebook.ads.redexgen.X.C04879c {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.W6.A0T(com.facebook.ads.redexgen.X.AA[], com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray):com.facebook.ads.redexgen.X.Gk");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0656Gj
    public final void A0U(Object obj) {
        this.A00 = (C0651Ge) obj;
    }
}

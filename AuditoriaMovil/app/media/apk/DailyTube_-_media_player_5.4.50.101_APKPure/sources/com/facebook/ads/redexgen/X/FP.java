package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class FP {
    public static String[] A05 = {"uUgQSQgVsgHH0N1UsfY", "sl", "7AFLCGuL9JRzl", "SUkqvXm6rFeJNlyU4q2", "DM2QNBARzQjqq5KTyec", "OFwEtNlY3tfCjSjl1W0mAcBM0ytDkhEA", "Uou0zfuAqjYMYyC", "2ZbfYqEAzIBMf"};
    public static final FP A06 = new FP(new long[0]);
    public final int A00;
    public final long A01;
    public final long A02;
    public final long[] A03;
    public final FN[] A04;

    public FP(long... jArr) {
        int length = jArr.length;
        this.A00 = length;
        this.A03 = Arrays.copyOf(jArr, length);
        this.A04 = new FN[length];
        for (int i = 0; i < length; i++) {
            this.A04[i] = new FN();
        }
        this.A01 = 0L;
        this.A02 = -9223372036854775807L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
        r0 = r7.A03.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
        if (r3 >= r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int A00(long r8) {
        /*
            r7 = this;
            r3 = 0
        L1:
            long[] r1 = r7.A03
            int r0 = r1.length
            if (r3 >= r0) goto L3b
            r5 = r1[r3]
            r1 = -9223372036854775808
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 == 0) goto L3b
            int r4 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.FP.A05
            r0 = 5
            r1 = r1[r0]
            r0 = 14
            char r1 = r1.charAt(r0)
            r0 = 119(0x77, float:1.67E-43)
            if (r1 == r0) goto L35
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.FP.A05
            java.lang.String r1 = "JOT1DKN2kTxJVBU4QbvAyq2E38ICiTh6"
            r0 = 5
            r2[r0] = r1
            if (r4 >= 0) goto L32
            com.facebook.ads.redexgen.X.FN[] r0 = r7.A04
            r0 = r0[r3]
            boolean r0 = r0.A02()
            if (r0 != 0) goto L3b
        L32:
            int r3 = r3 + 1
            goto L1
        L35:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L3b:
            long[] r0 = r7.A03
            int r0 = r0.length
            if (r3 >= r0) goto L41
        L40:
            return r3
        L41:
            r3 = -1
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FP.A00(long):int");
    }

    public final int A01(long j2) {
        int length = this.A03.length - 1;
        while (length >= 0) {
            long j4 = this.A03[length];
            int index = (j4 > Long.MIN_VALUE ? 1 : (j4 == Long.MIN_VALUE ? 0 : -1));
            if (index != 0) {
                int index2 = (j4 > j2 ? 1 : (j4 == j2 ? 0 : -1));
                if (index2 <= 0) {
                    break;
                }
            }
            length--;
        }
        if (length < 0 || !this.A04[length].A02()) {
            return -1;
        }
        return length;
    }
}

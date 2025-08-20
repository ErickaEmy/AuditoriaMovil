package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class WN extends AH {
    public static final Object A09 = new Object();
    public final long A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final Object A06;
    public final boolean A07;
    public final boolean A08;

    public WN(long j2, long j4, long j6, long j7, long j8, long j9, boolean z2, boolean z3, Object obj) {
        this.A01 = j2;
        this.A05 = j4;
        this.A00 = j6;
        this.A03 = j7;
        this.A04 = j8;
        this.A02 = j9;
        this.A08 = z2;
        this.A07 = z3;
        this.A06 = obj;
    }

    public WN(long j2, long j4, long j6, long j7, boolean z2, boolean z3, Object obj) {
        this(-9223372036854775807L, -9223372036854775807L, j2, j4, j6, j7, z2, z3, obj);
    }

    public WN(long j2, boolean z2, boolean z3, Object obj) {
        this(j2, j2, 0L, 0L, z2, z3, obj);
    }

    @Override // com.facebook.ads.redexgen.X.AH
    public final int A00() {
        return 1;
    }

    @Override // com.facebook.ads.redexgen.X.AH
    public final int A01() {
        return 1;
    }

    @Override // com.facebook.ads.redexgen.X.AH
    public final int A04(Object obj) {
        return A09.equals(obj) ? 0 : -1;
    }

    @Override // com.facebook.ads.redexgen.X.AH
    public final AF A0A(int i, AF af2, boolean z2) {
        AbstractC0672Ha.A00(i, 0, 1);
        Object uid = z2 ? A09 : null;
        return af2.A0B(null, uid, 0, this.A00, -this.A04);
    }

    @Override // com.facebook.ads.redexgen.X.AH
    public final AG A0D(int i, AG ag, boolean z2, long j2) {
        Object obj;
        AbstractC0672Ha.A00(i, 0, 1);
        if (z2) {
            obj = this.A06;
        } else {
            obj = null;
        }
        long j4 = this.A02;
        boolean z3 = this.A07;
        if (z3 && j2 != 0) {
            long windowDefaultStartPositionUs = this.A03;
            if (windowDefaultStartPositionUs == -9223372036854775807L) {
                j4 = -9223372036854775807L;
            } else {
                j4 += j2;
                if (j4 > windowDefaultStartPositionUs) {
                    j4 = -9223372036854775807L;
                }
            }
        }
        return ag.A04(obj, this.A01, this.A05, this.A08, z3, j4, this.A03, 0, 0, this.A04);
    }
}

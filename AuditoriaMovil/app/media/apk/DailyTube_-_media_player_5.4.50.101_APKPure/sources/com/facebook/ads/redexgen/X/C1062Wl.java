package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Wl  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1062Wl implements C1 {
    public long A00;
    public long A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;

    public C1062Wl(int i, int i5, int i6, int i8, int i10, int i11) {
        this.A06 = i;
        this.A07 = i5;
        this.A02 = i6;
        this.A04 = i8;
        this.A03 = i10;
        this.A05 = i11;
    }

    public final int A00() {
        return this.A07 * this.A03 * this.A06;
    }

    public final int A01() {
        return this.A04;
    }

    public final int A02() {
        return this.A05;
    }

    public final int A03() {
        return this.A06;
    }

    public final int A04() {
        return this.A07;
    }

    public final long A05(long j2) {
        long positionOffset = Math.max(0L, j2 - this.A01);
        long j4 = 1000000 * positionOffset;
        long positionOffset2 = this.A02;
        return j4 / positionOffset2;
    }

    public final void A06(long j2, long j4) {
        this.A01 = j2;
        this.A00 = j4;
    }

    public final boolean A07() {
        return (this.A01 == 0 || this.A00 == 0) ? false : true;
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final long A6r() {
        long numFrames = this.A07;
        return (1000000 * (this.A00 / this.A04)) / numFrames;
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final C0 A7t(long j2) {
        int i = this.A04;
        long positionOffset = i;
        long j4 = ((this.A02 * j2) / 1000000) / positionOffset;
        long positionOffset2 = i;
        long A0E = IF.A0E(j4 * positionOffset2, 0L, this.A00 - i);
        long j6 = this.A01 + A0E;
        long A05 = A05(j6);
        C2 seekPoint = new C2(A05, j6);
        if (A05 < j2) {
            long j7 = this.A00;
            int i5 = this.A04;
            if (A0E != j7 - i5) {
                long seekTimeUs = i5 + j6;
                long seekPosition = A05(seekTimeUs);
                return new C0(seekPoint, new C2(seekPosition, seekTimeUs));
            }
        }
        return new C0(seekPoint);
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final boolean A9I() {
        return true;
    }
}

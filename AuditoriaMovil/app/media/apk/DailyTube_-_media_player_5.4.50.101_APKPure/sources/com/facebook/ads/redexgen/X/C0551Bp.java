package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup;
/* renamed from: com.facebook.ads.redexgen.X.Bp  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0551Bp extends W7 {
    public float A00;
    public int A01;
    public int A02;
    public long A03;
    public final float A04;
    public final float A05;
    public final long A06;
    public final long A07;
    public final long A08;
    public final long A09;
    public final InterfaceC0662Gp A0A;
    public final InterfaceC0675Hd A0B;

    public C0551Bp(TrackGroup trackGroup, int[] iArr, InterfaceC0662Gp interfaceC0662Gp, long j2, long j4, long j6, float f4, float f6, long j7, InterfaceC0675Hd interfaceC0675Hd) {
        super(trackGroup, iArr);
        this.A0A = interfaceC0662Gp;
        this.A07 = j2 * 1000;
        this.A06 = j4 * 1000;
        this.A08 = 1000 * j6;
        this.A04 = f4;
        this.A05 = f6;
        this.A09 = j7;
        this.A0B = interfaceC0675Hd;
        this.A00 = 1.0f;
        this.A01 = 1;
        this.A03 = -9223372036854775807L;
        this.A02 = A00(Long.MIN_VALUE);
    }

    private int A00(long j2) {
        long A67 = ((float) this.A0A.A67()) * this.A04;
        int i = 0;
        for (int i5 = 0; i5 < super.A03; i5++) {
            if (j2 == Long.MIN_VALUE || !A00(i5, j2)) {
                if (Math.round(A76(i5).A04 * this.A00) <= A67) {
                    return i5;
                }
                i = i5;
            }
        }
        return i;
    }

    @Override // com.facebook.ads.redexgen.X.W7, com.facebook.ads.redexgen.X.InterfaceC0653Gg
    public final void A5U() {
        this.A03 = -9223372036854775807L;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0653Gg
    public final int A7v() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.W7, com.facebook.ads.redexgen.X.InterfaceC0653Gg
    public final void ACc(float f4) {
        this.A00 = f4;
    }
}

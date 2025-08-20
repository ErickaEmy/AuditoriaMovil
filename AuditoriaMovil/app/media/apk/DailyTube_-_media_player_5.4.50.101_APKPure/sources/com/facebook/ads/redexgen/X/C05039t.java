package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.9t  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C05039t {
    public final long A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final C0612Eo A04;
    public final boolean A05;
    public final boolean A06;

    public C05039t(C0612Eo c0612Eo, long j2, long j4, long j6, long j7, boolean z2, boolean z3) {
        this.A04 = c0612Eo;
        this.A03 = j2;
        this.A02 = j4;
        this.A00 = j6;
        this.A01 = j7;
        this.A06 = z2;
        this.A05 = z3;
    }

    public final C05039t A00(int i) {
        return new C05039t(this.A04.A00(i), this.A03, this.A02, this.A00, this.A01, this.A06, this.A05);
    }

    public final C05039t A01(long j2) {
        return new C05039t(this.A04, j2, this.A02, this.A00, this.A01, this.A06, this.A05);
    }
}

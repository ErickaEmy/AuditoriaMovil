package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Xj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1086Xj implements C1 {
    public final long A00;
    public final C0 A01;

    public C1086Xj(long j2) {
        this(j2, 0L);
    }

    public C1086Xj(long j2, long j4) {
        this.A00 = j2;
        this.A01 = new C0(j4 == 0 ? C2.A03 : new C2(0L, j4));
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final long A6r() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final C0 A7t(long j2) {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final boolean A9I() {
        return false;
    }
}

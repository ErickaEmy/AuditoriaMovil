package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.6C  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C6C {
    public final long A00;
    public final C6B A01;
    public final String A02;
    public final boolean A03;

    public C6C(String str, boolean z2, C6B c6b) {
        this(str, z2, c6b, System.currentTimeMillis());
    }

    public C6C(String str, boolean z2, C6B c6b, long j2) {
        this.A02 = str;
        this.A03 = z2;
        this.A01 = c6b;
        this.A00 = j2;
    }

    public static C6C A00() {
        return new C6C("", true, C6B.A06, -1L);
    }

    public final long A01() {
        return this.A00;
    }

    public final C6B A02() {
        return this.A01;
    }

    public final String A03() {
        return this.A02;
    }

    public final boolean A04() {
        return this.A03;
    }
}

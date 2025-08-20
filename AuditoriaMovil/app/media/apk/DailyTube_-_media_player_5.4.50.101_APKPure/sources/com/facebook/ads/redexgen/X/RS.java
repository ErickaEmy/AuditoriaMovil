package com.facebook.ads.redexgen.X;

import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class RS {
    public int A00;
    public int A01;
    public int A02;
    public RI A03;
    public Map<String, String> A04;
    public final int A05;
    public final int A06;

    public RS(int i, int i5, int i6, int i8, int i10, Map<String, String> requestHeaders, RI ri) {
        this.A06 = i;
        this.A00 = i5;
        this.A02 = i6;
        this.A05 = i8;
        this.A01 = i10;
        this.A04 = requestHeaders;
        this.A03 = ri;
    }

    public final int A00() {
        return this.A00;
    }

    public final int A01() {
        return this.A01;
    }

    public final int A02() {
        return this.A02;
    }

    public final int A03() {
        return this.A05;
    }

    public final int A04() {
        return this.A06;
    }

    public final RI A05() {
        return this.A03;
    }

    public final Map<String, String> A06() {
        return this.A04;
    }
}

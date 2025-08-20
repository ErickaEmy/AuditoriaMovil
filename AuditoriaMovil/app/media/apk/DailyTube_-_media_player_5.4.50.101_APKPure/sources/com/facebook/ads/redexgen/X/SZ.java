package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: assets/audience_network.dex */
public final class SZ {
    public long A01;
    public long A02;
    public long A03;
    @Nullable
    public String A05;
    public final int A06 = 100;
    public long A00 = -1;
    public long A04 = -1;

    public SZ(@Nullable String str, long j2, long j4, long j6) {
        this.A05 = str;
        this.A03 = j2 * 100;
        this.A01 = j4 * 100;
        this.A02 = 100 * j6;
    }

    public final long A00() {
        return this.A00;
    }

    public final long A01() {
        return this.A01;
    }

    public final long A02() {
        return this.A02;
    }

    public final long A03() {
        return this.A03;
    }

    public final long A04() {
        return this.A04;
    }

    public final List<String> A05() {
        return Arrays.asList(Long.toString(this.A03), Long.toString(this.A01), Long.toString(this.A02));
    }

    public final void A06(long j2) {
        this.A00 = j2;
    }

    public final void A07(long j2) {
        this.A01 = j2;
    }

    public final void A08(long j2) {
        this.A02 = j2;
    }

    public final void A09(long j2) {
        this.A03 = j2;
    }

    public final void A0A(long j2) {
        this.A04 = 100 * j2;
    }
}

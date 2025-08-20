package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class AD {
    public static final AD A02;
    public static final AD A03;
    public static final AD A04;
    public static final AD A05;
    public static final AD A06;
    public final long A00;
    public final long A01;

    static {
        AD ad2 = new AD(0L, 0L);
        A04 = ad2;
        A02 = new AD(Long.MAX_VALUE, Long.MAX_VALUE);
        A06 = new AD(Long.MAX_VALUE, 0L);
        A05 = new AD(0L, Long.MAX_VALUE);
        A03 = ad2;
    }

    public AD(long j2, long j4) {
        AbstractC0672Ha.A03(j2 >= 0);
        AbstractC0672Ha.A03(j4 >= 0);
        this.A01 = j2;
        this.A00 = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AD ad2 = (AD) obj;
        return this.A01 == ad2.A01 && this.A00 == ad2.A00;
    }

    public final int hashCode() {
        return (((int) this.A01) * 31) + ((int) this.A00);
    }
}

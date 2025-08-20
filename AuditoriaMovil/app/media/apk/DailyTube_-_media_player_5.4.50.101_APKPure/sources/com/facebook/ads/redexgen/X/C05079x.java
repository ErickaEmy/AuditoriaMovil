package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.9x  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C05079x {
    public static final C05079x A04 = new C05079x(1.0f);
    public final float A00;
    public final float A01;
    public final boolean A02;
    public final int A03;

    public C05079x(float f4) {
        this(f4, 1.0f, false);
    }

    public C05079x(float f4, float f6, boolean z2) {
        AbstractC0672Ha.A03(f4 > 0.0f);
        AbstractC0672Ha.A03(f6 > 0.0f);
        this.A01 = f4;
        this.A00 = f6;
        this.A02 = z2;
        this.A03 = Math.round(1000.0f * f4);
    }

    public final long A00(long j2) {
        return this.A03 * j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C05079x c05079x = (C05079x) obj;
        return this.A01 == c05079x.A01 && this.A00 == c05079x.A00 && this.A02 == c05079x.A02;
    }

    public final int hashCode() {
        int result = Float.floatToRawIntBits(this.A01);
        int result2 = this.A02 ? 1 : 0;
        return (((((17 * 31) + result) * 31) + Float.floatToRawIntBits(this.A00)) * 31) + result2;
    }
}

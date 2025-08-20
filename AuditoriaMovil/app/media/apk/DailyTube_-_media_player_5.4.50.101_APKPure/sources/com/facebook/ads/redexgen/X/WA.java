package com.facebook.ads.redexgen.X;

import android.text.Layout;
/* loaded from: assets/audience_network.dex */
public final class WA extends C0635Fn {
    public final long A00;
    public final long A01;

    public WA(long j2, long j4, CharSequence charSequence) {
        this(j2, j4, charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public WA(long j2, long j4, CharSequence charSequence, Layout.Alignment alignment, float f4, int i, int i5, float f6, int i6, float f9) {
        super(charSequence, alignment, f4, i, i5, f6, i6, f9);
        this.A01 = j2;
        this.A00 = j4;
    }

    public WA(CharSequence charSequence) {
        this(0L, 0L, charSequence);
    }

    public final boolean A00() {
        return super.A01 == Float.MIN_VALUE && this.A02 == Float.MIN_VALUE;
    }
}

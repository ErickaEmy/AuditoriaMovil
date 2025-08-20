package com.facebook.ads.redexgen.X;

import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Br  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0553Br extends AbstractC1093Xq implements InterfaceC0636Fo {
    public long A00;
    public InterfaceC0636Fo A01;

    public abstract void A08();

    @Override // com.facebook.ads.redexgen.X.B7
    public final void A07() {
        super.A07();
        this.A01 = null;
    }

    public final void A09(long j2, InterfaceC0636Fo interfaceC0636Fo, long j4) {
        super.A01 = j2;
        this.A01 = interfaceC0636Fo;
        if (j4 == Long.MAX_VALUE) {
            j4 = super.A01;
        }
        this.A00 = j4;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0636Fo
    public final List<C0635Fn> A6Z(long j2) {
        return this.A01.A6Z(j2 - this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0636Fo
    public final long A70(int i) {
        return this.A01.A70(i) + this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0636Fo
    public final int A71() {
        return this.A01.A71();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0636Fo
    public final int A7T(long j2) {
        return this.A01.A7T(j2 - this.A00);
    }
}

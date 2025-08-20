package com.facebook.ads.redexgen.X;

import java.util.Collections;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class WC implements InterfaceC0636Fo {
    public static final WC A01 = new WC();
    public final List<C0635Fn> A00;

    public WC() {
        this.A00 = Collections.emptyList();
    }

    public WC(C0635Fn c0635Fn) {
        this.A00 = Collections.singletonList(c0635Fn);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0636Fo
    public final List<C0635Fn> A6Z(long j2) {
        return j2 >= 0 ? this.A00 : Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0636Fo
    public final long A70(int i) {
        AbstractC0672Ha.A03(i == 0);
        return 0L;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0636Fo
    public final int A71() {
        return 1;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0636Fo
    public final int A7T(long j2) {
        return j2 < 0 ? 0 : -1;
    }
}

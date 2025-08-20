package com.facebook.ads.redexgen.X;

import java.util.Collections;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class WE implements InterfaceC0636Fo {
    public final long[] A00;
    public final C0635Fn[] A01;

    public WE(C0635Fn[] c0635FnArr, long[] jArr) {
        this.A01 = c0635FnArr;
        this.A00 = jArr;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0636Fo
    public final List<C0635Fn> A6Z(long j2) {
        C0635Fn c0635Fn;
        int A0B = IF.A0B(this.A00, j2, true, false);
        if (A0B == -1 || (c0635Fn = this.A01[A0B]) == null) {
            return Collections.emptyList();
        }
        return Collections.singletonList(c0635Fn);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0636Fo
    public final long A70(int i) {
        boolean z2 = true;
        AbstractC0672Ha.A03(i >= 0);
        if (i >= this.A00.length) {
            z2 = false;
        }
        AbstractC0672Ha.A03(z2);
        return this.A00[i];
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0636Fo
    public final int A71() {
        return this.A00.length;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0636Fo
    public final int A7T(long j2) {
        int A0A = IF.A0A(this.A00, j2, false, false);
        int index = this.A00.length;
        if (A0A < index) {
            return A0A;
        }
        return -1;
    }
}

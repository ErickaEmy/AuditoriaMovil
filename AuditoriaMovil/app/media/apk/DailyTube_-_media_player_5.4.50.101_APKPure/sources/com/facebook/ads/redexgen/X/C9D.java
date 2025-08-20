package com.facebook.ads.redexgen.X;

import java.io.IOException;
/* renamed from: com.facebook.ads.redexgen.X.9D  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C9D {
    public final int A00;
    public final C9A A01;

    public C9D(int i, C9A c9a) {
        this.A00 = i;
        this.A01 = c9a;
    }

    public final int A00() {
        return this.A00;
    }

    public final int A01() throws IOException {
        return this.A01.A05();
    }

    public final AnonymousClass91 A02(int i, byte[] bArr, int i5, int[] iArr, int i6) throws IOException {
        return this.A01.A06(i, bArr, i5, iArr, i6);
    }

    public final void A03() throws IOException {
        this.A01.A07();
    }

    public final void A04() throws IOException {
        this.A01.A08();
    }

    public final boolean A05(byte[] bArr) throws IOException {
        return this.A01.A09(bArr);
    }
}

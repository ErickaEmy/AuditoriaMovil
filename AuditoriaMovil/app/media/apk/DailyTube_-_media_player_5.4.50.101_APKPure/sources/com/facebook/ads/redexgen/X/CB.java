package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.IOException;
/* loaded from: assets/audience_network.dex */
public final class CB extends WW implements InterfaceC0609El {
    public long A00;
    public boolean A01;
    public final int A02;
    public final int A03;
    public final Uri A04;
    public final InterfaceC0557Bv A05;
    public final InterfaceC0666Gt A06;
    public final Object A07;
    public final String A08;

    public CB(Uri uri, InterfaceC0666Gt interfaceC0666Gt, InterfaceC0557Bv interfaceC0557Bv, int i, String str, int i5, Object obj) {
        this.A04 = uri;
        this.A06 = interfaceC0666Gt;
        this.A05 = interfaceC0557Bv;
        this.A03 = i;
        this.A08 = str;
        this.A02 = i5;
        this.A00 = -9223372036854775807L;
        this.A07 = obj;
    }

    private void A00(long j2, boolean z2) {
        this.A00 = j2;
        this.A01 = z2;
        A01(new WN(this.A00, this.A01, false, this.A07), null);
    }

    @Override // com.facebook.ads.redexgen.X.WW
    public final void A02() {
    }

    @Override // com.facebook.ads.redexgen.X.WW
    public final void A03(Y6 y62, boolean z2) {
        A00(this.A00, false);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0614Eq
    public final WP A4k(C0612Eo c0612Eo, InterfaceC0659Gm interfaceC0659Gm) {
        AbstractC0672Ha.A03(c0612Eo.A02 == 0);
        return new CD(this.A04, this.A06.A4X(), this.A05.A4b(), this.A03, A00(c0612Eo), this, interfaceC0659Gm, this.A08, this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0614Eq
    public final void AAO() throws IOException {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0609El
    public final void AD9(long j2, boolean z2) {
        if (j2 == -9223372036854775807L) {
            j2 = this.A00;
        }
        if (this.A00 == j2 && this.A01 == z2) {
            return;
        }
        A00(j2, z2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0614Eq
    public final void AEa(WP wp) {
        ((CD) wp).A0R();
    }
}

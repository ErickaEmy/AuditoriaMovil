package com.facebook.ads.redexgen.X;

import android.os.Handler;
/* renamed from: com.facebook.ads.redexgen.X.Uj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1012Uj extends KT {
    public final /* synthetic */ L9 A00;

    public C1012Uj(L9 l92) {
        this.A00 = l92;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        Handler handler;
        long j2;
        if (this.A00.A05()) {
            this.A00.A02();
            handler = this.A00.A05;
            j2 = this.A00.A02;
            handler.postDelayed(this, j2);
        }
    }
}

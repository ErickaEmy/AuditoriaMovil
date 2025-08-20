package com.facebook.ads.redexgen.X;

import android.os.Handler;
/* renamed from: com.facebook.ads.redexgen.X.Tr  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0994Tr extends KT {
    public final /* synthetic */ C0827Ng A00;

    public C0994Tr(C0827Ng c0827Ng) {
        this.A00 = c0827Ng;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        boolean z2;
        Handler handler;
        Runnable runnable;
        this.A00.A03();
        z2 = this.A00.A08;
        if (z2) {
            handler = this.A00.A0D;
            runnable = this.A00.A0F;
            handler.postDelayed(runnable, 250L);
        }
    }
}

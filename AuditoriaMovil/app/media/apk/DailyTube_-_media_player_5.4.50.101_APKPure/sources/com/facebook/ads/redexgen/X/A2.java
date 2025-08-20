package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
/* loaded from: assets/audience_network.dex */
public class A2 extends AbstractC0891Ps {
    public final /* synthetic */ T4 A00;

    public A2(T4 t4) {
        this.A00 = t4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC04788s
    /* renamed from: A00 */
    public final void A03(C0892Pt c0892Pt) {
        new Handler(Looper.getMainLooper()).post(new PS(this));
    }
}

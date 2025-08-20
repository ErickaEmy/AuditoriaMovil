package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
/* renamed from: com.facebook.ads.redexgen.X.9R  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C9R extends AbstractC0891Ps {
    public final /* synthetic */ C9Q A00;

    public C9R(C9Q c9q) {
        this.A00 = c9q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC04788s
    /* renamed from: A00 */
    public final void A03(C0892Pt c0892Pt) {
        new Handler(Looper.getMainLooper()).post(new RunnableC0880Ph(this));
    }
}

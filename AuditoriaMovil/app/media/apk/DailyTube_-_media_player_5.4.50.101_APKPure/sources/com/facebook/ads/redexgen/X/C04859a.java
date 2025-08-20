package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
/* renamed from: com.facebook.ads.redexgen.X.9a  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C04859a extends AbstractC0891Ps {
    public final /* synthetic */ C0974Sx A00;

    public C04859a(C0974Sx c0974Sx) {
        this.A00 = c0974Sx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC04788s
    /* renamed from: A00 */
    public final void A03(C0892Pt c0892Pt) {
        new Handler(Looper.getMainLooper()).post(new RunnableC0873Pa(this));
    }
}

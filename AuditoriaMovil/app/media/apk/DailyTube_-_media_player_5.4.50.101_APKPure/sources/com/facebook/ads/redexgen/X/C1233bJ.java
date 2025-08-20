package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.bJ  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1233bJ implements C6U {
    public final /* synthetic */ FY A00;

    public C1233bJ(FY fy) {
        this.A00 = fy;
    }

    private void A00(boolean z2) {
        AnonymousClass18 anonymousClass18;
        AtomicBoolean atomicBoolean;
        AnonymousClass18 anonymousClass182;
        if (!z2) {
            anonymousClass18 = this.A00.A01;
            anonymousClass18.AD1(this.A00, AdError.CACHE_ERROR);
            return;
        }
        atomicBoolean = this.A00.A0C;
        atomicBoolean.set(true);
        anonymousClass182 = this.A00.A01;
        anonymousClass182.ACy(this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.C6U
    public final void AB2() {
        A00(false);
    }

    @Override // com.facebook.ads.redexgen.X.C6U
    public final void ABB() {
        A00(true);
    }
}

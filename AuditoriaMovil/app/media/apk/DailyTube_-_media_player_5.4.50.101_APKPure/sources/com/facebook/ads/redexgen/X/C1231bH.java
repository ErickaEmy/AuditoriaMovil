package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.bH  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1231bH implements AnonymousClass61 {
    public final /* synthetic */ FY A00;
    public final /* synthetic */ boolean A01;

    public C1231bH(FY fy, boolean z2) {
        this.A00 = fy;
        this.A01 = z2;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass61
    public final void AAl() {
        C1116Yn c1116Yn;
        AtomicBoolean atomicBoolean;
        AnonymousClass18 anonymousClass18;
        C1116Yn c1116Yn2;
        C1F c1f;
        c1116Yn = this.A00.A04;
        if (!C0705Ih.A1R(c1116Yn) || !this.A01) {
            atomicBoolean = this.A00.A0C;
            atomicBoolean.set(true);
            anonymousClass18 = this.A00.A01;
            anonymousClass18.ACy(this.A00);
            return;
        }
        FY fy = this.A00;
        c1116Yn2 = fy.A04;
        c1f = this.A00.A03;
        fy.A06 = PC.A01(c1116Yn2, (FS) c1f, 0, new C1232bI(this));
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass61
    public final void AAm() {
        AnonymousClass18 anonymousClass18;
        anonymousClass18 = this.A00.A01;
        anonymousClass18.AD1(this.A00, AdError.CACHE_ERROR);
    }
}

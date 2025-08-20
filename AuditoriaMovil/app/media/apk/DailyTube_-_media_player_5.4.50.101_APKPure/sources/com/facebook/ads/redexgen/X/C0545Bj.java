package com.facebook.ads.redexgen.X;

import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
/* renamed from: com.facebook.ads.redexgen.X.Bj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0545Bj implements V1 {
    public NativeAdBase A00;
    public NativeAdListener A01;

    public C0545Bj(NativeAdListener nativeAdListener, NativeAdBase nativeAdBase) {
        this.A01 = nativeAdListener;
        this.A00 = nativeAdBase;
    }

    @Override // com.facebook.ads.redexgen.X.JH
    public final void AAc() {
        KK.A00(new C1025Ux(this));
    }

    @Override // com.facebook.ads.redexgen.X.JH
    public final void AAg() {
        KK.A00(new C1026Uy(this));
    }

    @Override // com.facebook.ads.redexgen.X.JH
    public final void ABR(C0722Jb c0722Jb) {
        KK.A00(new V0(this, c0722Jb));
    }

    @Override // com.facebook.ads.redexgen.X.JH
    public final void ACA() {
        KK.A00(new C1024Uw(this));
    }

    @Override // com.facebook.ads.redexgen.X.V1
    public final void ACF() {
        KK.A00(new C1027Uz(this));
    }
}

package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
/* renamed from: com.facebook.ads.redexgen.X.bS  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1242bS implements AnonymousClass61 {
    public final /* synthetic */ int A00;
    public final /* synthetic */ C1237bN A01;
    public final /* synthetic */ C1237bN A02;
    public final /* synthetic */ C8T A03;

    public C1242bS(C1237bN c1237bN, int i, C8T c8t, C1237bN c1237bN2) {
        this.A01 = c1237bN;
        this.A00 = i;
        this.A03 = c8t;
        this.A02 = c1237bN2;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass61
    public final void AAl() {
        this.A01.A0C(this.A00, this.A03);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass61
    public final void AAm() {
        InterfaceC02880x interfaceC02880x;
        interfaceC02880x = this.A01.A00;
        interfaceC02880x.ABw(this.A02, C0722Jb.A00(AdErrorType.NO_FILL));
    }
}

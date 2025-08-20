package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.view.FullScreenAdToolbar;
/* renamed from: com.facebook.ads.redexgen.X.Sq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0967Sq implements InterfaceC0876Pd {
    public final /* synthetic */ int A00;
    public final /* synthetic */ C0965So A01;

    public C0967Sq(C0965So c0965So, int i) {
        this.A01 = c0965So;
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0876Pd
    public final void AAu() {
        this.A01.A0R(false, this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0876Pd
    public final void ABH(int i) {
        C0965So.A02(this.A01, i);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0876Pd
    public final void ABY(float f4) {
        boolean z2;
        z2 = this.A01.A08;
        if (!z2) {
            this.A01.A0G(f4);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0876Pd
    public final void AD7(boolean z2) {
        this.A01.A0Q(z2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0876Pd
    public final void ADX(String str) {
        C1116Yn c1116Yn;
        MC mc2;
        InterfaceC0804Mj interfaceC0804Mj;
        c1116Yn = this.A01.A0D;
        c1116Yn.A0E().A2z(str);
        mc2 = this.A01.A0H;
        interfaceC0804Mj = this.A01.A0J;
        mc2.A43(interfaceC0804Mj.A6y());
        this.A01.A0H(3);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0876Pd
    public final void AGq() {
        FullScreenAdToolbar fullScreenAdToolbar;
        FullScreenAdToolbar fullScreenAdToolbar2;
        this.A01.A09 = false;
        fullScreenAdToolbar = this.A01.A0I;
        fullScreenAdToolbar.setProgressImmediate(0.0f);
        fullScreenAdToolbar2 = this.A01.A0I;
        fullScreenAdToolbar2.setToolbarActionMode(2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0876Pd
    public final void AGr(float f4) {
        FullScreenAdToolbar fullScreenAdToolbar;
        fullScreenAdToolbar = this.A01.A0I;
        fullScreenAdToolbar.setProgress(100.0f * f4);
    }
}

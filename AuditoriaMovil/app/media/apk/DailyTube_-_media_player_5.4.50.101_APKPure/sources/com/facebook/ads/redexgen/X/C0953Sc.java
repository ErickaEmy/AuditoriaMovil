package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Sc  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0953Sc implements InterfaceC0865Os {
    public final /* synthetic */ C0952Sb A00;

    public C0953Sc(C0952Sb c0952Sb) {
        this.A00 = c0952Sb;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0865Os
    public final void ADb(View view) {
        if (this.A00.A09) {
            this.A00.A07 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0865Os
    public final void ADd(View view) {
        TS ts = (TS) view;
        ts.A16();
        if (this.A00.A09) {
            this.A00.A07 = true;
        }
        if (this.A00.A04.A0Z() && ((Integer) ts.getTag(-1593835536)).intValue() == 0) {
            this.A00.A04.A0U();
        }
    }
}

package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class T5 implements L8 {
    public final /* synthetic */ T4 A00;

    public T5(T4 t4) {
        this.A00 = t4;
    }

    @Override // com.facebook.ads.redexgen.X.L8
    public final void ABA() {
        InterfaceC0876Pd interfaceC0876Pd;
        int i;
        InterfaceC0876Pd interfaceC0876Pd2;
        interfaceC0876Pd = this.A00.A0F;
        i = this.A00.A0A;
        interfaceC0876Pd.ABH(i);
        interfaceC0876Pd2 = this.A00.A0F;
        interfaceC0876Pd2.AAu();
    }

    @Override // com.facebook.ads.redexgen.X.L8
    public final void ACm(float f4) {
        int i;
        boolean z2;
        SA sa;
        int duration;
        boolean z3;
        int i5;
        InterfaceC0876Pd interfaceC0876Pd;
        i = this.A00.A0A;
        float f6 = i - f4;
        z2 = this.A00.A0V;
        if (z2) {
            duration = 0;
        } else {
            sa = this.A00.A0I;
            duration = sa.getDuration();
        }
        float totalForce = f6 + duration;
        z3 = this.A00.A0V;
        if (z3) {
            i5 = this.A00.A0A;
        } else {
            i5 = this.A00.A09;
        }
        float seenTime = i5;
        float totalForce2 = totalForce / seenTime;
        interfaceC0876Pd = this.A00.A0F;
        interfaceC0876Pd.AGr(totalForce2);
    }
}

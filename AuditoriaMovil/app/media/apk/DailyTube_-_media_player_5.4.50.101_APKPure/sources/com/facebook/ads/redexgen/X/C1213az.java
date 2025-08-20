package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
import java.util.EnumSet;
/* renamed from: com.facebook.ads.redexgen.X.az  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1213az implements InterfaceC02981h {
    public final /* synthetic */ int A00;
    public final /* synthetic */ AbstractC1219b5 A01;
    public final /* synthetic */ C1217b3 A02;
    public final /* synthetic */ InterfaceC02981h A03;
    public final /* synthetic */ C02991i A04;
    public final /* synthetic */ C1116Yn A05;
    public final /* synthetic */ EnumSet A06;

    public C1213az(C02991i c02991i, C1116Yn c1116Yn, AbstractC1219b5 abstractC1219b5, C1217b3 c1217b3, int i, InterfaceC02981h interfaceC02981h, EnumSet enumSet) {
        this.A04 = c02991i;
        this.A05 = c1116Yn;
        this.A01 = abstractC1219b5;
        this.A02 = c1217b3;
        this.A00 = i;
        this.A03 = interfaceC02981h;
        this.A06 = enumSet;
    }

    private final void A00() {
        if (this.A00 + 1 >= this.A02.A0s()) {
            return;
        }
        C02991i c02991i = this.A04;
        C1116Yn c1116Yn = this.A05;
        EnumSet enumSet = this.A06;
        C1217b3 c1217b3 = this.A02;
        c02991i.A0A(c1116Yn, enumSet, c1217b3, c1217b3.A0v(this.A00 + 1), this.A00 + 1, this.A03);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC02981h
    public final void AAe(AdError adError) {
        if (this.A00 == 0) {
            this.A03.AAe(adError);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC02981h
    public final void AAf() {
        this.A05.A00().AFq(this.A01.A12(), this.A02.A0w());
        if (this.A00 == 0) {
            this.A03.AAf();
        }
        A00();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC02981h
    public final void AES() {
        if (this.A00 == 0) {
            this.A03.AES();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC02981h
    public final void AGm() {
        if (this.A00 == 0) {
            this.A03.AGm();
        }
    }
}

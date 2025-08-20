package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup;
/* loaded from: assets/audience_network.dex */
public final class W8 implements InterfaceC0652Gf {
    public final float A00;
    public final float A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final long A05;
    public final InterfaceC0662Gp A06;
    public final InterfaceC0675Hd A07;

    public W8(InterfaceC0662Gp interfaceC0662Gp) {
        this(interfaceC0662Gp, 10000, 25000, 25000, 0.75f, 0.75f, 2000L, InterfaceC0675Hd.A00);
    }

    public W8(InterfaceC0662Gp interfaceC0662Gp, int i, int i5, int i6, float f4, float f6, long j2, InterfaceC0675Hd interfaceC0675Hd) {
        this.A06 = interfaceC0662Gp;
        this.A03 = i;
        this.A02 = i5;
        this.A04 = i6;
        this.A00 = f4;
        this.A01 = f6;
        this.A05 = j2;
        this.A07 = interfaceC0675Hd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0652Gf
    /* renamed from: A00 */
    public final C0551Bp A4o(TrackGroup trackGroup, int... iArr) {
        return new C0551Bp(trackGroup, iArr, this.A06, this.A03, this.A02, this.A04, this.A00, this.A01, this.A05, this.A07);
    }
}

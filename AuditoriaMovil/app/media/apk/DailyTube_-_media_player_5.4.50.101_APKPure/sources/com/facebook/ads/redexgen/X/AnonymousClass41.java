package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.41  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass41 extends AbstractC0547Bl {
    public final int A00;
    public final int A01;
    public final HG<? super InterfaceC0667Gu> A02;
    public final String A03;
    public final boolean A04;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HG != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.thirdparty.upstream.DataSource> */
    public AnonymousClass41(String str, HG<? super InterfaceC0667Gu> hg) {
        this(str, hg, 8000, 8000, false);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HG != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.thirdparty.upstream.DataSource> */
    public AnonymousClass41(String str, HG<? super InterfaceC0667Gu> hg, int i, int i5, boolean z2) {
        this.A03 = str;
        this.A02 = hg;
        this.A00 = i;
        this.A01 = i5;
        this.A04 = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC0547Bl
    /* renamed from: A00 */
    public final C0548Bm A01(H5 h5) {
        return new C0548Bm(this.A03, null, this.A02, this.A00, this.A01, this.A04, h5);
    }
}

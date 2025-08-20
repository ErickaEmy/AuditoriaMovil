package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Vv  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1049Vv implements InterfaceC0666Gt {
    public final HG<? super C1050Vw> A00;

    public C1049Vv() {
        this(null);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HG != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.thirdparty.upstream.FileDataSource> */
    public C1049Vv(HG<? super C1050Vw> hg) {
        this.A00 = hg;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0666Gt
    public final InterfaceC0667Gu A4X() {
        return new C1050Vw(this.A00);
    }
}

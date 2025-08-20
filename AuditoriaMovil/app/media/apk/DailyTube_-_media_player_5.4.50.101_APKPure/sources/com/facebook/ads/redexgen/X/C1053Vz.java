package com.facebook.ads.redexgen.X;

import android.content.Context;
/* renamed from: com.facebook.ads.redexgen.X.Vz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1053Vz implements InterfaceC0666Gt {
    public final Context A00;
    public final InterfaceC0666Gt A01;
    public final HG<? super InterfaceC0667Gu> A02;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HG != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.thirdparty.upstream.DataSource> */
    public C1053Vz(Context context, HG<? super InterfaceC0667Gu> hg, InterfaceC0666Gt interfaceC0666Gt) {
        this.A00 = context.getApplicationContext();
        this.A02 = hg;
        this.A01 = interfaceC0666Gt;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HG != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.thirdparty.upstream.DataSource> */
    public C1053Vz(Context context, String str, HG<? super InterfaceC0667Gu> hg) {
        this(context, hg, new AnonymousClass41(str, hg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0666Gt
    /* renamed from: A00 */
    public final W0 A4X() {
        return new W0(this.A00, this.A02, this.A01.A4X());
    }
}

package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.io.EOFException;
import java.io.IOException;
/* renamed from: com.facebook.ads.redexgen.X.Xl  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1088Xl implements C4 {
    @Override // com.facebook.ads.redexgen.X.C4
    public final void A5n(Format format) {
    }

    @Override // com.facebook.ads.redexgen.X.C4
    public final int AFQ(InterfaceC0555Bt interfaceC0555Bt, int i, boolean z2) throws IOException, InterruptedException {
        int AGM = interfaceC0555Bt.AGM(i);
        if (AGM == -1) {
            if (z2) {
                return -1;
            }
            throw new EOFException();
        }
        return AGM;
    }

    @Override // com.facebook.ads.redexgen.X.C4
    public final void AFR(C0697Hz c0697Hz, int i) {
        c0697Hz.A0Z(i);
    }

    @Override // com.facebook.ads.redexgen.X.C4
    public final void AFS(long j2, int i, int i5, int i6, C3 c32) {
    }
}

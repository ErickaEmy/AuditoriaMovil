package com.facebook.ads.redexgen.X;

import android.media.MediaCodec;
/* loaded from: assets/audience_network.dex */
public final class B9 {
    public final MediaCodec.CryptoInfo.Pattern A00;
    public final MediaCodec.CryptoInfo A01;

    public B9(MediaCodec.CryptoInfo cryptoInfo) {
        this.A01 = cryptoInfo;
        this.A00 = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A00(int i, int i5) {
        this.A00.set(i, i5);
        this.A01.setPattern(this.A00);
    }
}

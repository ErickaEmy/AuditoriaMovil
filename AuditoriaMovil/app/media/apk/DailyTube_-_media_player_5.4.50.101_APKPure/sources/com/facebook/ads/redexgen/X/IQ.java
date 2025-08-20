package com.facebook.ads.redexgen.X;

import android.media.MediaCodec;
import android.os.Handler;
/* loaded from: assets/audience_network.dex */
public final class IQ implements MediaCodec.OnFrameRenderedListener {
    public final /* synthetic */ C3F A00;

    public IQ(C3F c3f, MediaCodec mediaCodec) {
        this.A00 = c3f;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j2, long j4) {
        if (this != this.A00.A00) {
            return;
        }
        this.A00.A1S();
    }
}

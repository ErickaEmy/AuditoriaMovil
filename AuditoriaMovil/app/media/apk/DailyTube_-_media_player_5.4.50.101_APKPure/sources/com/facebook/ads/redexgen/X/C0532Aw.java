package com.facebook.ads.redexgen.X;

import android.media.AudioTrack;
/* renamed from: com.facebook.ads.redexgen.X.Aw  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0532Aw extends Thread {
    public final /* synthetic */ AudioTrack A00;
    public final /* synthetic */ C1101Xy A01;

    public C0532Aw(C1101Xy c1101Xy, AudioTrack audioTrack) {
        this.A01 = c1101Xy;
        this.A00 = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.release();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

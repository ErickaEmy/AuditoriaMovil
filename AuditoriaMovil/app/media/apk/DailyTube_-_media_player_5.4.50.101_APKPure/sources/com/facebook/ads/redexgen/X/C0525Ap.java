package com.facebook.ads.redexgen.X;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
/* renamed from: com.facebook.ads.redexgen.X.Ap  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0525Ap {
    public long A00;
    public long A01;
    public long A02;
    public final AudioTimestamp A03 = new AudioTimestamp();
    public final AudioTrack A04;

    public C0525Ap(AudioTrack audioTrack) {
        this.A04 = audioTrack;
    }

    public final long A00() {
        return this.A00;
    }

    public final long A01() {
        return this.A03.nanoTime / 1000;
    }

    public final boolean A02() {
        boolean timestamp = this.A04.getTimestamp(this.A03);
        if (timestamp) {
            long j2 = this.A03.framePosition;
            long rawPositionFrames = this.A01;
            if (rawPositionFrames > j2) {
                this.A02++;
            }
            this.A01 = j2;
            long rawPositionFrames2 = this.A02;
            this.A00 = (rawPositionFrames2 << 32) + j2;
        }
        return timestamp;
    }
}

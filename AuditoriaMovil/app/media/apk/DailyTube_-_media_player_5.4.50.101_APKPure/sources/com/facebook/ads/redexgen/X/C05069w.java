package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray;
/* renamed from: com.facebook.ads.redexgen.X.9w  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C05069w {
    public final int A00;
    public final long A01;
    public final long A02;
    public final AH A03;
    public final C0612Eo A04;
    public final TrackGroupArray A05;
    public final C0657Gk A06;
    public final Object A07;
    public final boolean A08;
    public volatile long A09;
    public volatile long A0A;

    public C05069w(AH ah, long j2, TrackGroupArray trackGroupArray, C0657Gk c0657Gk) {
        this(ah, null, new C0612Eo(0), j2, -9223372036854775807L, 1, false, trackGroupArray, c0657Gk);
    }

    public C05069w(AH ah, Object obj, C0612Eo c0612Eo, long j2, long j4, int i, boolean z2, TrackGroupArray trackGroupArray, C0657Gk c0657Gk) {
        this.A03 = ah;
        this.A07 = obj;
        this.A04 = c0612Eo;
        this.A02 = j2;
        this.A01 = j4;
        this.A0A = j2;
        this.A09 = j2;
        this.A00 = i;
        this.A08 = z2;
        this.A05 = trackGroupArray;
        this.A06 = c0657Gk;
    }

    public static void A00(C05069w c05069w, C05069w c05069w2) {
        c05069w2.A0A = c05069w.A0A;
        c05069w2.A09 = c05069w.A09;
    }

    public final C05069w A01(int i) {
        C05069w c05069w = new C05069w(this.A03, this.A07, this.A04.A00(i), this.A02, this.A01, this.A00, this.A08, this.A05, this.A06);
        A00(this, c05069w);
        return c05069w;
    }

    public final C05069w A02(int i) {
        C05069w playbackInfo = new C05069w(this.A03, this.A07, this.A04, this.A02, this.A01, i, this.A08, this.A05, this.A06);
        A00(this, playbackInfo);
        return playbackInfo;
    }

    public final C05069w A03(AH ah, Object obj) {
        C05069w playbackInfo = new C05069w(ah, obj, this.A04, this.A02, this.A01, this.A00, this.A08, this.A05, this.A06);
        A00(this, playbackInfo);
        return playbackInfo;
    }

    public final C05069w A04(C0612Eo c0612Eo, long j2, long j4) {
        long j6 = j4;
        AH ah = this.A03;
        Object obj = this.A07;
        if (!c0612Eo.A01()) {
            j6 = -9223372036854775807L;
        }
        return new C05069w(ah, obj, c0612Eo, j2, j6, this.A00, this.A08, this.A05, this.A06);
    }

    public final C05069w A05(TrackGroupArray trackGroupArray, C0657Gk c0657Gk) {
        C05069w playbackInfo = new C05069w(this.A03, this.A07, this.A04, this.A02, this.A01, this.A00, this.A08, trackGroupArray, c0657Gk);
        A00(this, playbackInfo);
        return playbackInfo;
    }

    public final C05069w A06(boolean z2) {
        C05069w playbackInfo = new C05069w(this.A03, this.A07, this.A04, this.A02, this.A01, this.A00, z2, this.A05, this.A06);
        A00(this, playbackInfo);
        return playbackInfo;
    }
}

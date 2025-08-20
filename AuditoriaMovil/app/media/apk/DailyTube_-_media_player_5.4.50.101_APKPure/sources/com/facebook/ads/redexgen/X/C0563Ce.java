package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
/* renamed from: com.facebook.ads.redexgen.X.Ce  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0563Ce {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final Format A07;
    public final long[] A08;
    public final long[] A09;
    public final C0564Cf[] A0A;

    public C0563Ce(int i, int i5, long j2, long j4, long j6, Format format, int i6, C0564Cf[] c0564CfArr, int i8, long[] jArr, long[] jArr2) {
        this.A00 = i;
        this.A03 = i5;
        this.A06 = j2;
        this.A05 = j4;
        this.A04 = j6;
        this.A07 = format;
        this.A02 = i6;
        this.A0A = c0564CfArr;
        this.A01 = i8;
        this.A08 = jArr;
        this.A09 = jArr2;
    }

    public final C0564Cf A00(int i) {
        C0564Cf[] c0564CfArr = this.A0A;
        if (c0564CfArr == null) {
            return null;
        }
        return c0564CfArr[i];
    }
}

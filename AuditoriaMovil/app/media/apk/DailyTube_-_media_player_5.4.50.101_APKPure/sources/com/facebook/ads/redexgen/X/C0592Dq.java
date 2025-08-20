package com.facebook.ads.redexgen.X;

import android.os.Parcel;
/* renamed from: com.facebook.ads.redexgen.X.Dq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0592Dq {
    public final int A00;
    public final long A01;
    public final long A02;

    public C0592Dq(int i, long j2, long j4) {
        this.A00 = i;
        this.A02 = j2;
        this.A01 = j4;
    }

    public /* synthetic */ C0592Dq(int i, long j2, long j4, C0591Dp c0591Dp) {
        this(i, j2, j4);
    }

    public static C0592Dq A00(Parcel parcel) {
        return new C0592Dq(parcel.readInt(), parcel.readLong(), parcel.readLong());
    }

    public final void A01(Parcel parcel) {
        parcel.writeInt(this.A00);
        parcel.writeLong(this.A02);
        parcel.writeLong(this.A01);
    }
}

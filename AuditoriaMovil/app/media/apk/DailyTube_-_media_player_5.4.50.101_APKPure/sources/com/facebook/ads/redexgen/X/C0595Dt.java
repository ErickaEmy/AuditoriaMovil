package com.facebook.ads.redexgen.X;

import android.os.Parcel;
/* renamed from: com.facebook.ads.redexgen.X.Dt  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0595Dt {
    public final int A00;
    public final long A01;

    public C0595Dt(int i, long j2) {
        this.A00 = i;
        this.A01 = j2;
    }

    public /* synthetic */ C0595Dt(int i, long j2, C0594Ds c0594Ds) {
        this(i, j2);
    }

    public static C0595Dt A00(Parcel parcel) {
        return new C0595Dt(parcel.readInt(), parcel.readLong());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02(Parcel parcel) {
        parcel.writeInt(this.A00);
        parcel.writeLong(this.A01);
    }
}

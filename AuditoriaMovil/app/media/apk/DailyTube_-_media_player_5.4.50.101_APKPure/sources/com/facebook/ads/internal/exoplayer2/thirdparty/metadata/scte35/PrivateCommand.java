package com.facebook.ads.internal.exoplayer2.thirdparty.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.X.C0590Do;
import com.facebook.ads.redexgen.X.C0697Hz;
/* loaded from: assets/audience_network.dex */
public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new C0590Do();
    public final long A00;
    public final long A01;
    public final byte[] A02;

    public PrivateCommand(long j2, byte[] bArr, long j4) {
        this.A01 = j4;
        this.A00 = j2;
        this.A02 = bArr;
    }

    public PrivateCommand(Parcel parcel) {
        this.A01 = parcel.readLong();
        this.A00 = parcel.readLong();
        byte[] bArr = new byte[parcel.readInt()];
        this.A02 = bArr;
        parcel.readByteArray(bArr);
    }

    public /* synthetic */ PrivateCommand(Parcel parcel, C0590Do c0590Do) {
        this(parcel);
    }

    public static PrivateCommand A00(C0697Hz c0697Hz, int i, long j2) {
        long A0M = c0697Hz.A0M();
        byte[] bArr = new byte[i - 4];
        c0697Hz.A0c(bArr, 0, bArr.length);
        return new PrivateCommand(A0M, bArr, j2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.A01);
        parcel.writeLong(this.A00);
        parcel.writeInt(this.A02.length);
        parcel.writeByteArray(this.A02);
    }
}

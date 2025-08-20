package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import v5.j5;
import v5.rz;
/* loaded from: classes.dex */
public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new y();

    /* renamed from: fb  reason: collision with root package name */
    public final byte[] f4291fb;

    /* renamed from: v  reason: collision with root package name */
    public final long f4292v;
    public final long y;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<PrivateCommand> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public PrivateCommand[] newArray(int i) {
            return new PrivateCommand[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public PrivateCommand createFromParcel(Parcel parcel) {
            return new PrivateCommand(parcel, null);
        }
    }

    public /* synthetic */ PrivateCommand(Parcel parcel, y yVar) {
        this(parcel);
    }

    public static PrivateCommand y(rz rzVar, int i, long j2) {
        long a82 = rzVar.a8();
        int i5 = i - 4;
        byte[] bArr = new byte[i5];
        rzVar.t(bArr, 0, i5);
        return new PrivateCommand(a82, bArr, j2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.y);
        parcel.writeLong(this.f4292v);
        parcel.writeByteArray(this.f4291fb);
    }

    public PrivateCommand(long j2, byte[] bArr, long j4) {
        this.y = j4;
        this.f4292v = j2;
        this.f4291fb = bArr;
    }

    public PrivateCommand(Parcel parcel) {
        this.y = parcel.readLong();
        this.f4292v = parcel.readLong();
        this.f4291fb = (byte[]) j5.i9(parcel.createByteArray());
    }
}

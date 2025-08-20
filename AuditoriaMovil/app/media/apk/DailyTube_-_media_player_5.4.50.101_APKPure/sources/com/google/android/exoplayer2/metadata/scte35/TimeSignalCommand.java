package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import v5.k5;
import v5.rz;
/* loaded from: classes.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new y();

    /* renamed from: v  reason: collision with root package name */
    public final long f4318v;
    public final long y;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<TimeSignalCommand> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public TimeSignalCommand[] newArray(int i) {
            return new TimeSignalCommand[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public TimeSignalCommand createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong(), null);
        }
    }

    public /* synthetic */ TimeSignalCommand(long j2, long j4, y yVar) {
        this(j2, j4);
    }

    public static long n3(rz rzVar, long j2) {
        long ej2 = rzVar.ej();
        if ((128 & ej2) != 0) {
            return 8589934591L & ((((ej2 & 1) << 32) | rzVar.a8()) + j2);
        }
        return -9223372036854775807L;
    }

    public static TimeSignalCommand y(rz rzVar, long j2, k5 k5Var) {
        long n32 = n3(rzVar, j2);
        return new TimeSignalCommand(n32, k5Var.n3(n32));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.y);
        parcel.writeLong(this.f4318v);
    }

    public TimeSignalCommand(long j2, long j4) {
        this.y = j2;
        this.f4318v = j4;
    }
}

package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import v5.k5;
import v5.rz;
/* loaded from: classes.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new y();

    /* renamed from: co  reason: collision with root package name */
    public final boolean f4293co;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f4294f;

    /* renamed from: f3  reason: collision with root package name */
    public final int f4295f3;

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f4296fb;

    /* renamed from: n  reason: collision with root package name */
    public final int f4297n;

    /* renamed from: p  reason: collision with root package name */
    public final List<n3> f4298p;

    /* renamed from: r  reason: collision with root package name */
    public final int f4299r;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f4300s;

    /* renamed from: t  reason: collision with root package name */
    public final long f4301t;

    /* renamed from: v  reason: collision with root package name */
    public final boolean f4302v;

    /* renamed from: w  reason: collision with root package name */
    public final long f4303w;
    public final long y;

    /* renamed from: z  reason: collision with root package name */
    public final long f4304z;

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final long f4305n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final long f4306zn;

        public /* synthetic */ n3(int i, long j2, long j4, y yVar) {
            this(i, j2, j4);
        }

        public static n3 y(Parcel parcel) {
            return new n3(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void n3(Parcel parcel) {
            parcel.writeInt(this.y);
            parcel.writeLong(this.f4305n3);
            parcel.writeLong(this.f4306zn);
        }

        public n3(int i, long j2, long j4) {
            this.y = i;
            this.f4305n3 = j2;
            this.f4306zn = j4;
        }
    }

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<SpliceInsertCommand> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public SpliceInsertCommand[] newArray(int i) {
            return new SpliceInsertCommand[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel, null);
        }
    }

    public /* synthetic */ SpliceInsertCommand(Parcel parcel, y yVar) {
        this(parcel);
    }

    public static SpliceInsertCommand y(rz rzVar, long j2, k5 k5Var) {
        boolean z2;
        List list;
        boolean z3;
        boolean z4;
        long j4;
        boolean z5;
        long j6;
        int i;
        int i5;
        int i6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        long j7;
        boolean z12;
        long j8;
        boolean z13;
        long j9;
        long a82 = rzVar.a8();
        if ((rzVar.ej() & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        List emptyList = Collections.emptyList();
        if (!z2) {
            int ej2 = rzVar.ej();
            if ((ej2 & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            if ((ej2 & 64) != 0) {
                z9 = true;
            } else {
                z9 = false;
            }
            if ((ej2 & 32) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if ((ej2 & 16) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z9 && !z11) {
                j7 = TimeSignalCommand.n3(rzVar, j2);
            } else {
                j7 = -9223372036854775807L;
            }
            if (!z9) {
                int ej3 = rzVar.ej();
                ArrayList arrayList = new ArrayList(ej3);
                for (int i8 = 0; i8 < ej3; i8++) {
                    int ej4 = rzVar.ej();
                    if (!z11) {
                        j9 = TimeSignalCommand.n3(rzVar, j2);
                    } else {
                        j9 = -9223372036854775807L;
                    }
                    arrayList.add(new n3(ej4, j9, k5Var.n3(j9), null));
                }
                emptyList = arrayList;
            }
            if (z10) {
                long ej5 = rzVar.ej();
                if ((128 & ej5) != 0) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                j8 = ((((ej5 & 1) << 32) | rzVar.a8()) * 1000) / 90;
                z12 = z13;
            } else {
                z12 = false;
                j8 = -9223372036854775807L;
            }
            i = rzVar.yt();
            z7 = z9;
            i5 = rzVar.ej();
            i6 = rzVar.ej();
            list = emptyList;
            long j10 = j7;
            z5 = z12;
            j6 = j8;
            z4 = z11;
            z3 = z8;
            j4 = j10;
        } else {
            list = emptyList;
            z3 = false;
            z4 = false;
            j4 = -9223372036854775807L;
            z5 = false;
            j6 = -9223372036854775807L;
            i = 0;
            i5 = 0;
            i6 = 0;
            z7 = false;
        }
        return new SpliceInsertCommand(a82, z2, z3, z7, z4, j4, k5Var.n3(j4), list, z5, j6, i, i5, i6);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.y);
        parcel.writeByte(this.f4302v ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f4296fb ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f4300s ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f4294f ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f4301t);
        parcel.writeLong(this.f4303w);
        int size = this.f4298p.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            this.f4298p.get(i5).n3(parcel);
        }
        parcel.writeByte(this.f4293co ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f4304z);
        parcel.writeInt(this.f4299r);
        parcel.writeInt(this.f4295f3);
        parcel.writeInt(this.f4297n);
    }

    public SpliceInsertCommand(long j2, boolean z2, boolean z3, boolean z4, boolean z5, long j4, long j6, List<n3> list, boolean z7, long j7, int i, int i5, int i6) {
        this.y = j2;
        this.f4302v = z2;
        this.f4296fb = z3;
        this.f4300s = z4;
        this.f4294f = z5;
        this.f4301t = j4;
        this.f4303w = j6;
        this.f4298p = Collections.unmodifiableList(list);
        this.f4293co = z7;
        this.f4304z = j7;
        this.f4299r = i;
        this.f4295f3 = i5;
        this.f4297n = i6;
    }

    public SpliceInsertCommand(Parcel parcel) {
        this.y = parcel.readLong();
        this.f4302v = parcel.readByte() == 1;
        this.f4296fb = parcel.readByte() == 1;
        this.f4300s = parcel.readByte() == 1;
        this.f4294f = parcel.readByte() == 1;
        this.f4301t = parcel.readLong();
        this.f4303w = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(n3.y(parcel));
        }
        this.f4298p = Collections.unmodifiableList(arrayList);
        this.f4293co = parcel.readByte() == 1;
        this.f4304z = parcel.readLong();
        this.f4299r = parcel.readInt();
        this.f4295f3 = parcel.readInt();
        this.f4297n = parcel.readInt();
    }
}

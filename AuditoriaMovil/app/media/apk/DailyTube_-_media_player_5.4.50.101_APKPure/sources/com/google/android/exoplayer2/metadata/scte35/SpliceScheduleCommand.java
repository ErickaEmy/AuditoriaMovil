package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import v5.rz;
/* loaded from: classes.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new y();
    public final List<zn> y;

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final long f4307n3;
        public final int y;

        public /* synthetic */ n3(int i, long j2, y yVar) {
            this(i, j2);
        }

        public static n3 zn(Parcel parcel) {
            return new n3(parcel.readInt(), parcel.readLong());
        }

        public final void gv(Parcel parcel) {
            parcel.writeInt(this.y);
            parcel.writeLong(this.f4307n3);
        }

        public n3(int i, long j2) {
            this.y = i;
            this.f4307n3 = j2;
        }
    }

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<SpliceScheduleCommand> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public SpliceScheduleCommand[] newArray(int i) {
            return new SpliceScheduleCommand[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel, null);
        }
    }

    public /* synthetic */ SpliceScheduleCommand(Parcel parcel, y yVar) {
        this(parcel);
    }

    public static SpliceScheduleCommand y(rz rzVar) {
        int ej2 = rzVar.ej();
        ArrayList arrayList = new ArrayList(ej2);
        for (int i = 0; i < ej2; i++) {
            arrayList.add(zn.v(rzVar));
        }
        return new SpliceScheduleCommand(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int size = this.y.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            this.y.get(i5).a(parcel);
        }
    }

    public SpliceScheduleCommand(List<zn> list) {
        this.y = Collections.unmodifiableList(list);
    }

    public SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(zn.gv(parcel));
        }
        this.y = Collections.unmodifiableList(arrayList);
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: a  reason: collision with root package name */
        public final List<n3> f4308a;

        /* renamed from: c5  reason: collision with root package name */
        public final int f4309c5;

        /* renamed from: f  reason: collision with root package name */
        public final int f4310f;

        /* renamed from: fb  reason: collision with root package name */
        public final boolean f4311fb;

        /* renamed from: gv  reason: collision with root package name */
        public final boolean f4312gv;

        /* renamed from: i9  reason: collision with root package name */
        public final int f4313i9;

        /* renamed from: n3  reason: collision with root package name */
        public final boolean f4314n3;

        /* renamed from: s  reason: collision with root package name */
        public final long f4315s;

        /* renamed from: v  reason: collision with root package name */
        public final long f4316v;
        public final long y;

        /* renamed from: zn  reason: collision with root package name */
        public final boolean f4317zn;

        public zn(long j2, boolean z2, boolean z3, boolean z4, List<n3> list, long j4, boolean z5, long j6, int i, int i5, int i6) {
            this.y = j2;
            this.f4314n3 = z2;
            this.f4317zn = z3;
            this.f4312gv = z4;
            this.f4308a = Collections.unmodifiableList(list);
            this.f4316v = j4;
            this.f4311fb = z5;
            this.f4315s = j6;
            this.f4309c5 = i;
            this.f4313i9 = i5;
            this.f4310f = i6;
        }

        public static zn gv(Parcel parcel) {
            return new zn(parcel);
        }

        public static zn v(rz rzVar) {
            boolean z2;
            ArrayList arrayList;
            boolean z3;
            long j2;
            boolean z4;
            long j4;
            int i;
            int i5;
            int i6;
            boolean z5;
            boolean z7;
            boolean z8;
            boolean z9;
            long j6;
            boolean z10;
            long j7;
            boolean z11;
            long a82 = rzVar.a8();
            if ((rzVar.ej() & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            ArrayList arrayList2 = new ArrayList();
            if (!z2) {
                int ej2 = rzVar.ej();
                if ((ej2 & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if ((ej2 & 64) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if ((ej2 & 32) != 0) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (z8) {
                    j6 = rzVar.a8();
                } else {
                    j6 = -9223372036854775807L;
                }
                if (!z8) {
                    int ej3 = rzVar.ej();
                    ArrayList arrayList3 = new ArrayList(ej3);
                    for (int i8 = 0; i8 < ej3; i8++) {
                        arrayList3.add(new n3(rzVar.ej(), rzVar.a8(), null));
                    }
                    arrayList2 = arrayList3;
                }
                if (z9) {
                    long ej4 = rzVar.ej();
                    if ((128 & ej4) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    j7 = ((((ej4 & 1) << 32) | rzVar.a8()) * 1000) / 90;
                    z10 = z11;
                } else {
                    z10 = false;
                    j7 = -9223372036854775807L;
                }
                int yt2 = rzVar.yt();
                int ej5 = rzVar.ej();
                z5 = z8;
                i6 = rzVar.ej();
                j4 = j7;
                arrayList = arrayList2;
                long j8 = j6;
                i = yt2;
                i5 = ej5;
                j2 = j8;
                boolean z12 = z7;
                z4 = z10;
                z3 = z12;
            } else {
                arrayList = arrayList2;
                z3 = false;
                j2 = -9223372036854775807L;
                z4 = false;
                j4 = -9223372036854775807L;
                i = 0;
                i5 = 0;
                i6 = 0;
                z5 = false;
            }
            return new zn(a82, z2, z3, z5, arrayList, j2, z4, j4, i, i5, i6);
        }

        public final void a(Parcel parcel) {
            parcel.writeLong(this.y);
            parcel.writeByte(this.f4314n3 ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f4317zn ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f4312gv ? (byte) 1 : (byte) 0);
            int size = this.f4308a.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                this.f4308a.get(i).gv(parcel);
            }
            parcel.writeLong(this.f4316v);
            parcel.writeByte(this.f4311fb ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f4315s);
            parcel.writeInt(this.f4309c5);
            parcel.writeInt(this.f4313i9);
            parcel.writeInt(this.f4310f);
        }

        public zn(Parcel parcel) {
            this.y = parcel.readLong();
            this.f4314n3 = parcel.readByte() == 1;
            this.f4317zn = parcel.readByte() == 1;
            this.f4312gv = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i < readInt; i++) {
                arrayList.add(n3.zn(parcel));
            }
            this.f4308a = Collections.unmodifiableList(arrayList);
            this.f4316v = parcel.readLong();
            this.f4311fb = parcel.readByte() == 1;
            this.f4315s = parcel.readLong();
            this.f4309c5 = parcel.readInt();
            this.f4313i9 = parcel.readInt();
            this.f4310f = parcel.readInt();
        }
    }
}

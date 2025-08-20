package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import m1.m;
import m1.qk;
import v5.j5;
import w0.f;
import z0.wz;
/* loaded from: classes.dex */
public final class SlowMotionData implements Metadata.Entry {
    public static final Parcelable.Creator<SlowMotionData> CREATOR = new y();
    public final List<Segment> y;

    /* loaded from: classes.dex */
    public static final class Segment implements Parcelable {

        /* renamed from: fb  reason: collision with root package name */
        public final int f4288fb;

        /* renamed from: v  reason: collision with root package name */
        public final long f4289v;
        public final long y;

        /* renamed from: s  reason: collision with root package name */
        public static final Comparator<Segment> f4287s = new Comparator() { // from class: dj.y
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int n32;
                n32 = SlowMotionData.Segment.n3((SlowMotionData.Segment) obj, (SlowMotionData.Segment) obj2);
                return n32;
            }
        };
        public static final Parcelable.Creator<Segment> CREATOR = new y();

        /* loaded from: classes.dex */
        public class y implements Parcelable.Creator<Segment> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: n3 */
            public Segment[] newArray(int i) {
                return new Segment[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: y */
            public Segment createFromParcel(Parcel parcel) {
                return new Segment(parcel.readLong(), parcel.readLong(), parcel.readInt());
            }
        }

        public Segment(long j2, long j4, int i) {
            boolean z2;
            if (j2 < j4) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.y(z2);
            this.y = j2;
            this.f4289v = j4;
            this.f4288fb = i;
        }

        public static /* synthetic */ int n3(Segment segment, Segment segment2) {
            return wz.i9().v(segment.y, segment2.y).v(segment.f4289v, segment2.f4289v).gv(segment.f4288fb, segment2.f4288fb).c5();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Segment.class != obj.getClass()) {
                return false;
            }
            Segment segment = (Segment) obj;
            if (this.y == segment.y && this.f4289v == segment.f4289v && this.f4288fb == segment.f4288fb) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return f.n3(Long.valueOf(this.y), Long.valueOf(this.f4289v), Integer.valueOf(this.f4288fb));
        }

        public String toString() {
            return j5.rz("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.y), Long.valueOf(this.f4289v), Integer.valueOf(this.f4288fb));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.y);
            parcel.writeLong(this.f4289v);
            parcel.writeInt(this.f4288fb);
        }
    }

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<SlowMotionData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public SlowMotionData[] newArray(int i) {
            return new SlowMotionData[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public SlowMotionData createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, Segment.class.getClassLoader());
            return new SlowMotionData(arrayList);
        }
    }

    public SlowMotionData(List<Segment> list) {
        this.y = list;
        v5.y.y(!y(list));
    }

    public static boolean y(List<Segment> list) {
        if (list.isEmpty()) {
            return false;
        }
        long j2 = list.get(0).f4289v;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).y < j2) {
                return true;
            }
            j2 = list.get(i).f4289v;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ m co() {
        return hd.y.n3(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SlowMotionData.class == obj.getClass()) {
            return this.y.equals(((SlowMotionData) obj).y);
        }
        return false;
    }

    public int hashCode() {
        return this.y.hashCode();
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ void m(qk.n3 n3Var) {
        hd.y.zn(this, n3Var);
    }

    public String toString() {
        return "SlowMotion: segments=" + this.y;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] w2() {
        return hd.y.y(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.y);
    }
}

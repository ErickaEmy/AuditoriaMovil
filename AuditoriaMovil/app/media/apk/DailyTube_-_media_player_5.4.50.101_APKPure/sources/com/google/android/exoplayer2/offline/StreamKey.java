package com.google.android.exoplayer2.offline;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class StreamKey implements Comparable<StreamKey>, Parcelable {
    public static final Parcelable.Creator<StreamKey> CREATOR = new y();

    /* renamed from: fb  reason: collision with root package name */
    public final int f4330fb;
    @Deprecated

    /* renamed from: s  reason: collision with root package name */
    public final int f4331s;

    /* renamed from: v  reason: collision with root package name */
    public final int f4332v;
    public final int y;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<StreamKey> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public StreamKey[] newArray(int i) {
            return new StreamKey[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public StreamKey createFromParcel(Parcel parcel) {
            return new StreamKey(parcel);
        }
    }

    public StreamKey(int i, int i5, int i6) {
        this.y = i;
        this.f4332v = i5;
        this.f4330fb = i6;
        this.f4331s = i6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StreamKey.class != obj.getClass()) {
            return false;
        }
        StreamKey streamKey = (StreamKey) obj;
        if (this.y == streamKey.y && this.f4332v == streamKey.f4332v && this.f4330fb == streamKey.f4330fb) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.y * 31) + this.f4332v) * 31) + this.f4330fb;
    }

    public String toString() {
        return this.y + "." + this.f4332v + "." + this.f4330fb;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.y);
        parcel.writeInt(this.f4332v);
        parcel.writeInt(this.f4330fb);
    }

    @Override // java.lang.Comparable
    /* renamed from: y */
    public int compareTo(StreamKey streamKey) {
        int i = this.y - streamKey.y;
        if (i == 0) {
            int i5 = this.f4332v - streamKey.f4332v;
            if (i5 == 0) {
                return this.f4330fb - streamKey.f4330fb;
            }
            return i5;
        }
        return i;
    }

    public StreamKey(Parcel parcel) {
        this.y = parcel.readInt();
        this.f4332v = parcel.readInt();
        int readInt = parcel.readInt();
        this.f4330fb = readInt;
        this.f4331s = readInt;
    }
}

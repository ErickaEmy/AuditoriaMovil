package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import d1.s;
import java.util.Arrays;
import java.util.List;
import m1.m;
import m1.qk;
import v5.j5;
/* loaded from: classes.dex */
public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new y();

    /* renamed from: v  reason: collision with root package name */
    public final long f4218v;
    public final Entry[] y;

    /* loaded from: classes.dex */
    public interface Entry extends Parcelable {
        @Nullable
        m co();

        void m(qk.n3 n3Var);

        @Nullable
        byte[] w2();
    }

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<Metadata> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public Metadata[] newArray(int i) {
            return new Metadata[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public Metadata createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }
    }

    public Metadata(Entry... entryArr) {
        this(-9223372036854775807L, entryArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Metadata.class != obj.getClass()) {
            return false;
        }
        Metadata metadata = (Metadata) obj;
        if (Arrays.equals(this.y, metadata.y) && this.f4218v == metadata.f4218v) {
            return true;
        }
        return false;
    }

    public Entry gv(int i) {
        return this.y[i];
    }

    public int hashCode() {
        return (Arrays.hashCode(this.y) * 31) + s.zn(this.f4218v);
    }

    public Metadata n3(@Nullable Metadata metadata) {
        if (metadata == null) {
            return this;
        }
        return y(metadata.y);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("entries=");
        sb.append(Arrays.toString(this.y));
        if (this.f4218v == -9223372036854775807L) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + this.f4218v;
        }
        sb.append(str);
        return sb.toString();
    }

    public int v() {
        return this.y.length;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.y.length);
        for (Entry entry : this.y) {
            parcel.writeParcelable(entry, 0);
        }
        parcel.writeLong(this.f4218v);
    }

    public Metadata y(Entry... entryArr) {
        if (entryArr.length == 0) {
            return this;
        }
        return new Metadata(this.f4218v, (Entry[]) j5.qk(this.y, entryArr));
    }

    public Metadata zn(long j2) {
        if (this.f4218v == j2) {
            return this;
        }
        return new Metadata(j2, this.y);
    }

    public Metadata(long j2, Entry... entryArr) {
        this.f4218v = j2;
        this.y = entryArr;
    }

    public Metadata(List<? extends Entry> list) {
        this((Entry[]) list.toArray(new Entry[0]));
    }

    public Metadata(long j2, List<? extends Entry> list) {
        this(j2, (Entry[]) list.toArray(new Entry[0]));
    }

    public Metadata(Parcel parcel) {
        this.y = new Entry[parcel.readInt()];
        int i = 0;
        while (true) {
            Entry[] entryArr = this.y;
            if (i < entryArr.length) {
                entryArr[i] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
                i++;
            } else {
                this.f4218v = parcel.readLong();
                return;
            }
        }
    }
}

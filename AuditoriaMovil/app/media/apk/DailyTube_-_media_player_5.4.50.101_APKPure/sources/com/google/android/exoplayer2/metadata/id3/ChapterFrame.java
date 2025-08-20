package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import v5.j5;
/* loaded from: classes.dex */
public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new y();

    /* renamed from: f  reason: collision with root package name */
    public final long f4247f;

    /* renamed from: fb  reason: collision with root package name */
    public final int f4248fb;

    /* renamed from: s  reason: collision with root package name */
    public final int f4249s;

    /* renamed from: t  reason: collision with root package name */
    public final long f4250t;

    /* renamed from: v  reason: collision with root package name */
    public final String f4251v;

    /* renamed from: w  reason: collision with root package name */
    public final Id3Frame[] f4252w;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<ChapterFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public ChapterFrame[] newArray(int i) {
            return new ChapterFrame[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public ChapterFrame createFromParcel(Parcel parcel) {
            return new ChapterFrame(parcel);
        }
    }

    public ChapterFrame(String str, int i, int i5, long j2, long j4, Id3Frame[] id3FrameArr) {
        super("CHAP");
        this.f4251v = str;
        this.f4248fb = i;
        this.f4249s = i5;
        this.f4247f = j2;
        this.f4250t = j4;
        this.f4252w = id3FrameArr;
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterFrame.class != obj.getClass()) {
            return false;
        }
        ChapterFrame chapterFrame = (ChapterFrame) obj;
        if (this.f4248fb == chapterFrame.f4248fb && this.f4249s == chapterFrame.f4249s && this.f4247f == chapterFrame.f4247f && this.f4250t == chapterFrame.f4250t && j5.zn(this.f4251v, chapterFrame.f4251v) && Arrays.equals(this.f4252w, chapterFrame.f4252w)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i5 = (((((((527 + this.f4248fb) * 31) + this.f4249s) * 31) + ((int) this.f4247f)) * 31) + ((int) this.f4250t)) * 31;
        String str = this.f4251v;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return i5 + i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4251v);
        parcel.writeInt(this.f4248fb);
        parcel.writeInt(this.f4249s);
        parcel.writeLong(this.f4247f);
        parcel.writeLong(this.f4250t);
        parcel.writeInt(this.f4252w.length);
        for (Id3Frame id3Frame : this.f4252w) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }

    public ChapterFrame(Parcel parcel) {
        super("CHAP");
        this.f4251v = (String) j5.i9(parcel.readString());
        this.f4248fb = parcel.readInt();
        this.f4249s = parcel.readInt();
        this.f4247f = parcel.readLong();
        this.f4250t = parcel.readLong();
        int readInt = parcel.readInt();
        this.f4252w = new Id3Frame[readInt];
        for (int i = 0; i < readInt; i++) {
            this.f4252w[i] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}

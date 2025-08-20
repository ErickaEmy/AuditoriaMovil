package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import v5.j5;
/* loaded from: classes.dex */
public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new y();

    /* renamed from: f  reason: collision with root package name */
    public final String[] f4253f;

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f4254fb;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f4255s;

    /* renamed from: t  reason: collision with root package name */
    public final Id3Frame[] f4256t;

    /* renamed from: v  reason: collision with root package name */
    public final String f4257v;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<ChapterTocFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public ChapterTocFrame[] newArray(int i) {
            return new ChapterTocFrame[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public ChapterTocFrame createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }
    }

    public ChapterTocFrame(String str, boolean z2, boolean z3, String[] strArr, Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.f4257v = str;
        this.f4254fb = z2;
        this.f4255s = z3;
        this.f4253f = strArr;
        this.f4256t = id3FrameArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterTocFrame.class != obj.getClass()) {
            return false;
        }
        ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
        if (this.f4254fb == chapterTocFrame.f4254fb && this.f4255s == chapterTocFrame.f4255s && j5.zn(this.f4257v, chapterTocFrame.f4257v) && Arrays.equals(this.f4253f, chapterTocFrame.f4253f) && Arrays.equals(this.f4256t, chapterTocFrame.f4256t)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i5 = (((527 + (this.f4254fb ? 1 : 0)) * 31) + (this.f4255s ? 1 : 0)) * 31;
        String str = this.f4257v;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return i5 + i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4257v);
        parcel.writeByte(this.f4254fb ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f4255s ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f4253f);
        parcel.writeInt(this.f4256t.length);
        for (Id3Frame id3Frame : this.f4256t) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }

    public ChapterTocFrame(Parcel parcel) {
        super("CTOC");
        this.f4257v = (String) j5.i9(parcel.readString());
        this.f4254fb = parcel.readByte() != 0;
        this.f4255s = parcel.readByte() != 0;
        this.f4253f = (String[]) j5.i9(parcel.createStringArray());
        int readInt = parcel.readInt();
        this.f4256t = new Id3Frame[readInt];
        for (int i = 0; i < readInt; i++) {
            this.f4256t[i] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}

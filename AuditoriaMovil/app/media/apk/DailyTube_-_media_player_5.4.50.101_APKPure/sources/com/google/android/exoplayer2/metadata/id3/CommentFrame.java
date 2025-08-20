package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import v5.j5;
/* loaded from: classes.dex */
public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator<CommentFrame> CREATOR = new y();

    /* renamed from: fb  reason: collision with root package name */
    public final String f4258fb;

    /* renamed from: s  reason: collision with root package name */
    public final String f4259s;

    /* renamed from: v  reason: collision with root package name */
    public final String f4260v;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<CommentFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public CommentFrame[] newArray(int i) {
            return new CommentFrame[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public CommentFrame createFromParcel(Parcel parcel) {
            return new CommentFrame(parcel);
        }
    }

    public CommentFrame(String str, String str2, String str3) {
        super("COMM");
        this.f4260v = str;
        this.f4258fb = str2;
        this.f4259s = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CommentFrame.class != obj.getClass()) {
            return false;
        }
        CommentFrame commentFrame = (CommentFrame) obj;
        if (j5.zn(this.f4258fb, commentFrame.f4258fb) && j5.zn(this.f4260v, commentFrame.f4260v) && j5.zn(this.f4259s, commentFrame.f4259s)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i5;
        String str = this.f4260v;
        int i6 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i8 = (527 + i) * 31;
        String str2 = this.f4258fb;
        if (str2 != null) {
            i5 = str2.hashCode();
        } else {
            i5 = 0;
        }
        int i10 = (i8 + i5) * 31;
        String str3 = this.f4259s;
        if (str3 != null) {
            i6 = str3.hashCode();
        }
        return i10 + i6;
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        return this.y + ": language=" + this.f4260v + ", description=" + this.f4258fb;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.y);
        parcel.writeString(this.f4260v);
        parcel.writeString(this.f4259s);
    }

    public CommentFrame(Parcel parcel) {
        super("COMM");
        this.f4260v = (String) j5.i9(parcel.readString());
        this.f4258fb = (String) j5.i9(parcel.readString());
        this.f4259s = (String) j5.i9(parcel.readString());
    }
}

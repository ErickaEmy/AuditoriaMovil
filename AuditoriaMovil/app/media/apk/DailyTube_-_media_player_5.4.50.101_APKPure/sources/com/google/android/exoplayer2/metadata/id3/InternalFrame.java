package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import v5.j5;
/* loaded from: classes.dex */
public final class InternalFrame extends Id3Frame {
    public static final Parcelable.Creator<InternalFrame> CREATOR = new y();

    /* renamed from: fb  reason: collision with root package name */
    public final String f4265fb;

    /* renamed from: s  reason: collision with root package name */
    public final String f4266s;

    /* renamed from: v  reason: collision with root package name */
    public final String f4267v;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<InternalFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public InternalFrame[] newArray(int i) {
            return new InternalFrame[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public InternalFrame createFromParcel(Parcel parcel) {
            return new InternalFrame(parcel);
        }
    }

    public InternalFrame(String str, String str2, String str3) {
        super("----");
        this.f4267v = str;
        this.f4265fb = str2;
        this.f4266s = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || InternalFrame.class != obj.getClass()) {
            return false;
        }
        InternalFrame internalFrame = (InternalFrame) obj;
        if (j5.zn(this.f4265fb, internalFrame.f4265fb) && j5.zn(this.f4267v, internalFrame.f4267v) && j5.zn(this.f4266s, internalFrame.f4266s)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i5;
        String str = this.f4267v;
        int i6 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i8 = (527 + i) * 31;
        String str2 = this.f4265fb;
        if (str2 != null) {
            i5 = str2.hashCode();
        } else {
            i5 = 0;
        }
        int i10 = (i8 + i5) * 31;
        String str3 = this.f4266s;
        if (str3 != null) {
            i6 = str3.hashCode();
        }
        return i10 + i6;
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        return this.y + ": domain=" + this.f4267v + ", description=" + this.f4265fb;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.y);
        parcel.writeString(this.f4267v);
        parcel.writeString(this.f4266s);
    }

    public InternalFrame(Parcel parcel) {
        super("----");
        this.f4267v = (String) j5.i9(parcel.readString());
        this.f4265fb = (String) j5.i9(parcel.readString());
        this.f4266s = (String) j5.i9(parcel.readString());
    }
}

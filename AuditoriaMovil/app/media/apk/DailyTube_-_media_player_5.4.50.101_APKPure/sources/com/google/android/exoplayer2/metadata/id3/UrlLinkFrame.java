package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import v5.j5;
/* loaded from: classes.dex */
public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new y();

    /* renamed from: fb  reason: collision with root package name */
    public final String f4278fb;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final String f4279v;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<UrlLinkFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public UrlLinkFrame[] newArray(int i) {
            return new UrlLinkFrame[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public UrlLinkFrame createFromParcel(Parcel parcel) {
            return new UrlLinkFrame(parcel);
        }
    }

    public UrlLinkFrame(String str, @Nullable String str2, String str3) {
        super(str);
        this.f4279v = str2;
        this.f4278fb = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UrlLinkFrame.class != obj.getClass()) {
            return false;
        }
        UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
        if (this.y.equals(urlLinkFrame.y) && j5.zn(this.f4279v, urlLinkFrame.f4279v) && j5.zn(this.f4278fb, urlLinkFrame.f4278fb)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int hashCode = (527 + this.y.hashCode()) * 31;
        String str = this.f4279v;
        int i5 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i6 = (hashCode + i) * 31;
        String str2 = this.f4278fb;
        if (str2 != null) {
            i5 = str2.hashCode();
        }
        return i6 + i5;
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        return this.y + ": url=" + this.f4278fb;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.y);
        parcel.writeString(this.f4279v);
        parcel.writeString(this.f4278fb);
    }

    public UrlLinkFrame(Parcel parcel) {
        super((String) j5.i9(parcel.readString()));
        this.f4279v = parcel.readString();
        this.f4278fb = (String) j5.i9(parcel.readString());
    }
}

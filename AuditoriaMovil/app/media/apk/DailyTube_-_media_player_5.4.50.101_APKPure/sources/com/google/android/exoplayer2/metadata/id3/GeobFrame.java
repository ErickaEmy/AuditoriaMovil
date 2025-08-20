package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import v5.j5;
/* loaded from: classes.dex */
public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new y();

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f4261f;

    /* renamed from: fb  reason: collision with root package name */
    public final String f4262fb;

    /* renamed from: s  reason: collision with root package name */
    public final String f4263s;

    /* renamed from: v  reason: collision with root package name */
    public final String f4264v;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<GeobFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public GeobFrame[] newArray(int i) {
            return new GeobFrame[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public GeobFrame createFromParcel(Parcel parcel) {
            return new GeobFrame(parcel);
        }
    }

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f4264v = str;
        this.f4262fb = str2;
        this.f4263s = str3;
        this.f4261f = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GeobFrame.class != obj.getClass()) {
            return false;
        }
        GeobFrame geobFrame = (GeobFrame) obj;
        if (j5.zn(this.f4264v, geobFrame.f4264v) && j5.zn(this.f4262fb, geobFrame.f4262fb) && j5.zn(this.f4263s, geobFrame.f4263s) && Arrays.equals(this.f4261f, geobFrame.f4261f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i5;
        String str = this.f4264v;
        int i6 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i8 = (527 + i) * 31;
        String str2 = this.f4262fb;
        if (str2 != null) {
            i5 = str2.hashCode();
        } else {
            i5 = 0;
        }
        int i10 = (i8 + i5) * 31;
        String str3 = this.f4263s;
        if (str3 != null) {
            i6 = str3.hashCode();
        }
        return ((i10 + i6) * 31) + Arrays.hashCode(this.f4261f);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        return this.y + ": mimeType=" + this.f4264v + ", filename=" + this.f4262fb + ", description=" + this.f4263s;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4264v);
        parcel.writeString(this.f4262fb);
        parcel.writeString(this.f4263s);
        parcel.writeByteArray(this.f4261f);
    }

    public GeobFrame(Parcel parcel) {
        super("GEOB");
        this.f4264v = (String) j5.i9(parcel.readString());
        this.f4262fb = (String) j5.i9(parcel.readString());
        this.f4263s = (String) j5.i9(parcel.readString());
        this.f4261f = (byte[]) j5.i9(parcel.createByteArray());
    }
}

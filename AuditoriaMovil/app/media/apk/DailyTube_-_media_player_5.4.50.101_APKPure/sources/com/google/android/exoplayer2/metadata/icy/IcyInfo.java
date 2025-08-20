package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;
import m1.m;
import m1.qk;
/* loaded from: classes.dex */
public final class IcyInfo implements Metadata.Entry {
    public static final Parcelable.Creator<IcyInfo> CREATOR = new y();
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public final String f4240fb;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final String f4241v;
    public final byte[] y;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<IcyInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public IcyInfo[] newArray(int i) {
            return new IcyInfo[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public IcyInfo createFromParcel(Parcel parcel) {
            return new IcyInfo(parcel);
        }
    }

    public IcyInfo(byte[] bArr, @Nullable String str, @Nullable String str2) {
        this.y = bArr;
        this.f4241v = str;
        this.f4240fb = str2;
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
        if (obj != null && IcyInfo.class == obj.getClass()) {
            return Arrays.equals(this.y, ((IcyInfo) obj).y);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.y);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public void m(qk.n3 n3Var) {
        String str = this.f4241v;
        if (str != null) {
            n3Var.e(str);
        }
    }

    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", this.f4241v, this.f4240fb, Integer.valueOf(this.y.length));
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] w2() {
        return hd.y.y(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.y);
        parcel.writeString(this.f4241v);
        parcel.writeString(this.f4240fb);
    }

    public IcyInfo(Parcel parcel) {
        this.y = (byte[]) v5.y.v(parcel.createByteArray());
        this.f4241v = parcel.readString();
        this.f4240fb = parcel.readString();
    }
}

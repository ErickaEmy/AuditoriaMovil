package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import m1.m;
import m1.qk;
import v5.j5;
@Deprecated
/* loaded from: classes.dex */
public class VorbisComment implements Metadata.Entry {
    public static final Parcelable.Creator<VorbisComment> CREATOR = new y();

    /* renamed from: v  reason: collision with root package name */
    public final String f4234v;
    public final String y;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<VorbisComment> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public VorbisComment[] newArray(int i) {
            return new VorbisComment[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public VorbisComment createFromParcel(Parcel parcel) {
            return new VorbisComment(parcel);
        }
    }

    public VorbisComment(String str, String str2) {
        this.y = str;
        this.f4234v = str2;
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
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VorbisComment vorbisComment = (VorbisComment) obj;
        if (this.y.equals(vorbisComment.y) && this.f4234v.equals(vorbisComment.f4234v)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.y.hashCode()) * 31) + this.f4234v.hashCode();
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public void m(qk.n3 n3Var) {
        String str = this.y;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 62359119:
                if (str.equals("ALBUM")) {
                    c2 = 0;
                    break;
                }
                break;
            case 79833656:
                if (str.equals("TITLE")) {
                    c2 = 1;
                    break;
                }
                break;
            case 428414940:
                if (str.equals("DESCRIPTION")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1746739798:
                if (str.equals("ALBUMARTIST")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1939198791:
                if (str.equals("ARTIST")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                n3Var.yt(this.f4234v);
                return;
            case 1:
                n3Var.e(this.f4234v);
                return;
            case 2:
                n3Var.oz(this.f4234v);
                return;
            case 3:
                n3Var.k5(this.f4234v);
                return;
            case 4:
                n3Var.vl(this.f4234v);
                return;
            default:
                return;
        }
    }

    public String toString() {
        return "VC: " + this.y + "=" + this.f4234v;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] w2() {
        return hd.y.y(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.y);
        parcel.writeString(this.f4234v);
    }

    public VorbisComment(Parcel parcel) {
        this.y = (String) j5.i9(parcel.readString());
        this.f4234v = (String) j5.i9(parcel.readString());
    }
}

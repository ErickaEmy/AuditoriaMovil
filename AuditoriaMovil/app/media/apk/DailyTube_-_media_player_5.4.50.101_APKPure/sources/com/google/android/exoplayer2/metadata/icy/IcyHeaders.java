package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import m1.m;
import m1.qk;
import v5.j5;
/* loaded from: classes.dex */
public final class IcyHeaders implements Metadata.Entry {
    public static final Parcelable.Creator<IcyHeaders> CREATOR = new y();

    /* renamed from: f  reason: collision with root package name */
    public final boolean f4235f;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public final String f4236fb;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public final String f4237s;

    /* renamed from: t  reason: collision with root package name */
    public final int f4238t;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final String f4239v;
    public final int y;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<IcyHeaders> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public IcyHeaders[] newArray(int i) {
            return new IcyHeaders[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public IcyHeaders createFromParcel(Parcel parcel) {
            return new IcyHeaders(parcel);
        }
    }

    public IcyHeaders(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z2, int i5) {
        v5.y.y(i5 == -1 || i5 > 0);
        this.y = i;
        this.f4239v = str;
        this.f4236fb = str2;
        this.f4237s = str3;
        this.f4235f = z2;
        this.f4238t = i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.exoplayer2.metadata.icy.IcyHeaders y(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r13) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.icy.IcyHeaders.y(java.util.Map):com.google.android.exoplayer2.metadata.icy.IcyHeaders");
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
        if (obj == null || IcyHeaders.class != obj.getClass()) {
            return false;
        }
        IcyHeaders icyHeaders = (IcyHeaders) obj;
        if (this.y == icyHeaders.y && j5.zn(this.f4239v, icyHeaders.f4239v) && j5.zn(this.f4236fb, icyHeaders.f4236fb) && j5.zn(this.f4237s, icyHeaders.f4237s) && this.f4235f == icyHeaders.f4235f && this.f4238t == icyHeaders.f4238t) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i5;
        int i6 = (527 + this.y) * 31;
        String str = this.f4239v;
        int i8 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i10 = (i6 + i) * 31;
        String str2 = this.f4236fb;
        if (str2 != null) {
            i5 = str2.hashCode();
        } else {
            i5 = 0;
        }
        int i11 = (i10 + i5) * 31;
        String str3 = this.f4237s;
        if (str3 != null) {
            i8 = str3.hashCode();
        }
        return ((((i11 + i8) * 31) + (this.f4235f ? 1 : 0)) * 31) + this.f4238t;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public void m(qk.n3 n3Var) {
        String str = this.f4236fb;
        if (str != null) {
            n3Var.nf(str);
        }
        String str2 = this.f4239v;
        if (str2 != null) {
            n3Var.en(str2);
        }
    }

    public String toString() {
        return "IcyHeaders: name=\"" + this.f4236fb + "\", genre=\"" + this.f4239v + "\", bitrate=" + this.y + ", metadataInterval=" + this.f4238t;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] w2() {
        return hd.y.y(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.y);
        parcel.writeString(this.f4239v);
        parcel.writeString(this.f4236fb);
        parcel.writeString(this.f4237s);
        j5.bv(parcel, this.f4235f);
        parcel.writeInt(this.f4238t);
    }

    public IcyHeaders(Parcel parcel) {
        this.y = parcel.readInt();
        this.f4239v = parcel.readString();
        this.f4236fb = parcel.readString();
        this.f4237s = parcel.readString();
        this.f4235f = j5.w9(parcel);
        this.f4238t = parcel.readInt();
    }
}

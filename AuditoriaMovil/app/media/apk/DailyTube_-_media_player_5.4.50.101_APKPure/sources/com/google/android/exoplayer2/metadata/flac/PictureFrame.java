package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;
import m1.m;
import m1.qk;
import v5.j5;
import v5.rz;
import w0.v;
/* loaded from: classes.dex */
public final class PictureFrame implements Metadata.Entry {
    public static final Parcelable.Creator<PictureFrame> CREATOR = new y();

    /* renamed from: f  reason: collision with root package name */
    public final int f4227f;

    /* renamed from: fb  reason: collision with root package name */
    public final String f4228fb;

    /* renamed from: p  reason: collision with root package name */
    public final byte[] f4229p;

    /* renamed from: s  reason: collision with root package name */
    public final int f4230s;

    /* renamed from: t  reason: collision with root package name */
    public final int f4231t;

    /* renamed from: v  reason: collision with root package name */
    public final String f4232v;

    /* renamed from: w  reason: collision with root package name */
    public final int f4233w;
    public final int y;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<PictureFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public PictureFrame[] newArray(int i) {
            return new PictureFrame[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public PictureFrame createFromParcel(Parcel parcel) {
            return new PictureFrame(parcel);
        }
    }

    public PictureFrame(int i, String str, String str2, int i5, int i6, int i8, int i10, byte[] bArr) {
        this.y = i;
        this.f4232v = str;
        this.f4228fb = str2;
        this.f4230s = i5;
        this.f4227f = i6;
        this.f4231t = i8;
        this.f4233w = i10;
        this.f4229p = bArr;
    }

    public static PictureFrame y(rz rzVar) {
        int p2 = rzVar.p();
        String d2 = rzVar.d(rzVar.p(), v.y);
        String ta2 = rzVar.ta(rzVar.p());
        int p3 = rzVar.p();
        int p4 = rzVar.p();
        int p8 = rzVar.p();
        int p9 = rzVar.p();
        int p10 = rzVar.p();
        byte[] bArr = new byte[p10];
        rzVar.t(bArr, 0, p10);
        return new PictureFrame(p2, d2, ta2, p3, p4, p8, p9, bArr);
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
        if (obj == null || PictureFrame.class != obj.getClass()) {
            return false;
        }
        PictureFrame pictureFrame = (PictureFrame) obj;
        if (this.y == pictureFrame.y && this.f4232v.equals(pictureFrame.f4232v) && this.f4228fb.equals(pictureFrame.f4228fb) && this.f4230s == pictureFrame.f4230s && this.f4227f == pictureFrame.f4227f && this.f4231t == pictureFrame.f4231t && this.f4233w == pictureFrame.f4233w && Arrays.equals(this.f4229p, pictureFrame.f4229p)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((527 + this.y) * 31) + this.f4232v.hashCode()) * 31) + this.f4228fb.hashCode()) * 31) + this.f4230s) * 31) + this.f4227f) * 31) + this.f4231t) * 31) + this.f4233w) * 31) + Arrays.hashCode(this.f4229p);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public void m(qk.n3 n3Var) {
        n3Var.ud(this.f4229p, this.y);
    }

    public String toString() {
        return "Picture: mimeType=" + this.f4232v + ", description=" + this.f4228fb;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] w2() {
        return hd.y.y(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.y);
        parcel.writeString(this.f4232v);
        parcel.writeString(this.f4228fb);
        parcel.writeInt(this.f4230s);
        parcel.writeInt(this.f4227f);
        parcel.writeInt(this.f4231t);
        parcel.writeInt(this.f4233w);
        parcel.writeByteArray(this.f4229p);
    }

    public PictureFrame(Parcel parcel) {
        this.y = parcel.readInt();
        this.f4232v = (String) j5.i9(parcel.readString());
        this.f4228fb = (String) j5.i9(parcel.readString());
        this.f4230s = parcel.readInt();
        this.f4227f = parcel.readInt();
        this.f4231t = parcel.readInt();
        this.f4233w = parcel.readInt();
        this.f4229p = (byte[]) j5.i9(parcel.createByteArray());
    }
}

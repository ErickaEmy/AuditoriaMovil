package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import d1.s;
import m1.m;
import m1.qk;
/* loaded from: classes.dex */
public final class MotionPhotoMetadata implements Metadata.Entry {
    public static final Parcelable.Creator<MotionPhotoMetadata> CREATOR = new y();

    /* renamed from: f  reason: collision with root package name */
    public final long f4283f;

    /* renamed from: fb  reason: collision with root package name */
    public final long f4284fb;

    /* renamed from: s  reason: collision with root package name */
    public final long f4285s;

    /* renamed from: v  reason: collision with root package name */
    public final long f4286v;
    public final long y;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<MotionPhotoMetadata> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public MotionPhotoMetadata[] newArray(int i) {
            return new MotionPhotoMetadata[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public MotionPhotoMetadata createFromParcel(Parcel parcel) {
            return new MotionPhotoMetadata(parcel, null);
        }
    }

    public /* synthetic */ MotionPhotoMetadata(Parcel parcel, y yVar) {
        this(parcel);
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
        if (obj == null || MotionPhotoMetadata.class != obj.getClass()) {
            return false;
        }
        MotionPhotoMetadata motionPhotoMetadata = (MotionPhotoMetadata) obj;
        if (this.y == motionPhotoMetadata.y && this.f4286v == motionPhotoMetadata.f4286v && this.f4284fb == motionPhotoMetadata.f4284fb && this.f4285s == motionPhotoMetadata.f4285s && this.f4283f == motionPhotoMetadata.f4283f) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + s.zn(this.y)) * 31) + s.zn(this.f4286v)) * 31) + s.zn(this.f4284fb)) * 31) + s.zn(this.f4285s)) * 31) + s.zn(this.f4283f);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ void m(qk.n3 n3Var) {
        hd.y.zn(this, n3Var);
    }

    public String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.y + ", photoSize=" + this.f4286v + ", photoPresentationTimestampUs=" + this.f4284fb + ", videoStartPosition=" + this.f4285s + ", videoSize=" + this.f4283f;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] w2() {
        return hd.y.y(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.y);
        parcel.writeLong(this.f4286v);
        parcel.writeLong(this.f4284fb);
        parcel.writeLong(this.f4285s);
        parcel.writeLong(this.f4283f);
    }

    public MotionPhotoMetadata(long j2, long j4, long j6, long j7, long j8) {
        this.y = j2;
        this.f4286v = j4;
        this.f4284fb = j6;
        this.f4285s = j7;
        this.f4283f = j8;
    }

    public MotionPhotoMetadata(Parcel parcel) {
        this.y = parcel.readLong();
        this.f4286v = parcel.readLong();
        this.f4284fb = parcel.readLong();
        this.f4285s = parcel.readLong();
        this.f4283f = parcel.readLong();
    }
}

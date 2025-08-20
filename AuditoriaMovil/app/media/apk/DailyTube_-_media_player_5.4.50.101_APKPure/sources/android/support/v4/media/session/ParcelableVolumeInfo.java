package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new y();

    /* renamed from: f  reason: collision with root package name */
    public int f550f;

    /* renamed from: fb  reason: collision with root package name */
    public int f551fb;

    /* renamed from: s  reason: collision with root package name */
    public int f552s;

    /* renamed from: v  reason: collision with root package name */
    public int f553v;
    public int y;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<ParcelableVolumeInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public ParcelableVolumeInfo[] newArray(int i) {
            return new ParcelableVolumeInfo[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.y = parcel.readInt();
        this.f551fb = parcel.readInt();
        this.f552s = parcel.readInt();
        this.f550f = parcel.readInt();
        this.f553v = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.y);
        parcel.writeInt(this.f551fb);
        parcel.writeInt(this.f552s);
        parcel.writeInt(this.f550f);
        parcel.writeInt(this.f553v);
    }
}

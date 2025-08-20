package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import xb.gv;
import xb.zn;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new y();
    public final gv y;

    /* loaded from: classes.dex */
    public static class y implements Parcelable.Creator<ParcelImpl> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public ParcelImpl[] newArray(int i) {
            return new ParcelImpl[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }
    }

    public ParcelImpl(gv gvVar) {
        this.y = gvVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        new zn(parcel).b(this.y);
    }

    public <T extends gv> T y() {
        return (T) this.y;
    }

    public ParcelImpl(Parcel parcel) {
        this.y = new zn(parcel).r();
    }
}

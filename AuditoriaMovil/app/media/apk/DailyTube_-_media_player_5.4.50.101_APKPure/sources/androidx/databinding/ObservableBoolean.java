package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ObservableBoolean extends n3 implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableBoolean> CREATOR = new y();
    static final long serialVersionUID = 1;
    private boolean mValue;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<ObservableBoolean> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public ObservableBoolean[] newArray(int i) {
            return new ObservableBoolean[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public ObservableBoolean createFromParcel(Parcel parcel) {
            boolean z2 = true;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            return new ObservableBoolean(z2);
        }
    }

    public ObservableBoolean(boolean z2) {
        this.mValue = z2;
    }

    public void ct(boolean z2) {
        if (z2 != this.mValue) {
            this.mValue = z2;
            o();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean u() {
        return this.mValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mValue ? 1 : 0);
    }

    public ObservableBoolean() {
    }
}

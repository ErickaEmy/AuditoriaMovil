package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ObservableInt extends n3 implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableInt> CREATOR = new y();
    static final long serialVersionUID = 1;
    private int mValue;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<ObservableInt> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public ObservableInt[] newArray(int i) {
            return new ObservableInt[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public ObservableInt createFromParcel(Parcel parcel) {
            return new ObservableInt(parcel.readInt());
        }
    }

    public ObservableInt(int i) {
        this.mValue = i;
    }

    public void ct(int i) {
        if (i != this.mValue) {
            this.mValue = i;
            o();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int u() {
        return this.mValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mValue);
    }

    public ObservableInt() {
    }
}

package com.facebook.ads.internal.exoplayer2.thirdparty.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.X.DT;
import java.util.Arrays;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new DT();
    public final Entry[] A00;

    /* loaded from: assets/audience_network.dex */
    public interface Entry extends Parcelable {
    }

    public Metadata(Parcel parcel) {
        this.A00 = new Entry[parcel.readInt()];
        int i = 0;
        while (true) {
            Entry[] entryArr = this.A00;
            int i5 = entryArr.length;
            if (i < i5) {
                entryArr[i] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
                i++;
            } else {
                return;
            }
        }
    }

    public Metadata(List<? extends Entry> entries) {
        if (entries != null) {
            Entry[] entryArr = new Entry[entries.size()];
            this.A00 = entryArr;
            entries.toArray(entryArr);
            return;
        }
        this.A00 = new Entry[0];
    }

    public Metadata(Entry... entryArr) {
        this.A00 = entryArr == null ? new Entry[0] : entryArr;
    }

    public final int A00() {
        return this.A00.length;
    }

    public final Entry A01(int i) {
        return this.A00[i];
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.A00, ((Metadata) obj).A00);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.A00);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.A00.length);
        for (Entry entry : this.A00) {
            parcel.writeParcelable(entry, 0);
        }
    }
}

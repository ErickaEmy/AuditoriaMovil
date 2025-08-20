package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import v5.j5;
/* loaded from: classes.dex */
public final class PrivFrame extends Id3Frame {
    public static final Parcelable.Creator<PrivFrame> CREATOR = new y();

    /* renamed from: fb  reason: collision with root package name */
    public final byte[] f4273fb;

    /* renamed from: v  reason: collision with root package name */
    public final String f4274v;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<PrivFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public PrivFrame[] newArray(int i) {
            return new PrivFrame[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public PrivFrame createFromParcel(Parcel parcel) {
            return new PrivFrame(parcel);
        }
    }

    public PrivFrame(String str, byte[] bArr) {
        super("PRIV");
        this.f4274v = str;
        this.f4273fb = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PrivFrame.class != obj.getClass()) {
            return false;
        }
        PrivFrame privFrame = (PrivFrame) obj;
        if (j5.zn(this.f4274v, privFrame.f4274v) && Arrays.equals(this.f4273fb, privFrame.f4273fb)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        String str = this.f4274v;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return ((527 + i) * 31) + Arrays.hashCode(this.f4273fb);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        return this.y + ": owner=" + this.f4274v;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4274v);
        parcel.writeByteArray(this.f4273fb);
    }

    public PrivFrame(Parcel parcel) {
        super("PRIV");
        this.f4274v = (String) j5.i9(parcel.readString());
        this.f4273fb = (byte[]) j5.i9(parcel.createByteArray());
    }
}

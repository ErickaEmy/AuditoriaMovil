package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import v5.j5;
/* loaded from: classes.dex */
public final class BinaryFrame extends Id3Frame {
    public static final Parcelable.Creator<BinaryFrame> CREATOR = new y();

    /* renamed from: v  reason: collision with root package name */
    public final byte[] f4246v;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<BinaryFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public BinaryFrame[] newArray(int i) {
            return new BinaryFrame[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public BinaryFrame createFromParcel(Parcel parcel) {
            return new BinaryFrame(parcel);
        }
    }

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.f4246v = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BinaryFrame.class != obj.getClass()) {
            return false;
        }
        BinaryFrame binaryFrame = (BinaryFrame) obj;
        if (this.y.equals(binaryFrame.y) && Arrays.equals(this.f4246v, binaryFrame.f4246v)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.y.hashCode()) * 31) + Arrays.hashCode(this.f4246v);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.y);
        parcel.writeByteArray(this.f4246v);
    }

    public BinaryFrame(Parcel parcel) {
        super((String) j5.i9(parcel.readString()));
        this.f4246v = (byte[]) j5.i9(parcel.createByteArray());
    }
}

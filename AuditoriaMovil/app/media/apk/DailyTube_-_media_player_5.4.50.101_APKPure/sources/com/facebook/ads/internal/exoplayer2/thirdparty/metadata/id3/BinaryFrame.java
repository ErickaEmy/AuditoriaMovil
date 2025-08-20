package com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.X.C0583Dd;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class BinaryFrame extends Id3Frame {
    public static final Parcelable.Creator<BinaryFrame> CREATOR = new C0583Dd();
    public final byte[] A00;

    public BinaryFrame(Parcel parcel) {
        super(parcel.readString());
        this.A00 = parcel.createByteArray();
    }

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.A00 = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BinaryFrame binaryFrame = (BinaryFrame) obj;
        return super.A00.equals(((Id3Frame) binaryFrame).A00) && Arrays.equals(this.A00, binaryFrame.A00);
    }

    public final int hashCode() {
        int result = super.A00.hashCode();
        return (((17 * 31) + result) * 31) + Arrays.hashCode(this.A00);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(super.A00);
        parcel.writeByteArray(this.A00);
    }
}

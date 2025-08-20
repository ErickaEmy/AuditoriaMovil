package com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.X.C0582Dc;
import com.facebook.ads.redexgen.X.IF;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class ApicFrame extends Id3Frame {
    public static byte[] A04;
    public static final Parcelable.Creator<ApicFrame> CREATOR;
    public final int A00;
    public final String A01;
    public final String A02;
    public final byte[] A03;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 63);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-90, -102, -34, -33, -19, -35, -20, -29, -22, -18, -29, -23, -24, -73, -122, 108, -71, -75, -71, -79, -96, -59, -68, -79, -119, -110, -95, -102, -108};
    }

    static {
        A01();
        CREATOR = new C0582Dc();
    }

    public ApicFrame(Parcel parcel) {
        super(A00(25, 4, 18));
        this.A02 = parcel.readString();
        this.A01 = parcel.readString();
        this.A00 = parcel.readInt();
        this.A03 = parcel.createByteArray();
    }

    public ApicFrame(String str, String str2, int i, byte[] bArr) {
        super(A00(25, 4, 18));
        this.A02 = str;
        this.A01 = str2;
        this.A00 = i;
        this.A03 = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ApicFrame apicFrame = (ApicFrame) obj;
        if (this.A00 == apicFrame.A00 && IF.A0g(this.A02, apicFrame.A02) && IF.A0g(this.A01, apicFrame.A01) && Arrays.equals(this.A03, apicFrame.A03)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A00;
        int result2 = ((17 * 31) + result) * 31;
        String str = this.A02;
        int result3 = str != null ? str.hashCode() : 0;
        int result4 = (result2 + result3) * 31;
        String str2 = this.A01;
        return ((result4 + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.A03);
    }

    @Override // com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.Id3Frame
    public final String toString() {
        return super.A00 + A00(14, 11, 13) + this.A02 + A00(0, 14, 59) + this.A01;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.A02);
        parcel.writeString(this.A01);
        parcel.writeInt(this.A00);
        parcel.writeByteArray(this.A03);
    }
}

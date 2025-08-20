package com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.X.Dl;
import com.facebook.ads.redexgen.X.IF;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class PrivFrame extends Id3Frame {
    public static byte[] A02;
    public static String[] A03 = {"s4wDOvnpFtTniUoQ4GhIqP8Ne4", "AJqwakPXQvqepdK1gNDDhD6mrVpAL34m", "V76vDeGZY92hJDaysHZ14ikGt7CVCjX9", "glGdDCuNCQUsQVDW6nyFPunlA03FXbmg", "wpXZS4D20GrCSOW5cyUhQPlOoPwJyqHP", "tGVPfAPgqp4j8DCD9KRMUL5D4hkSeyl5", "I5JIy50ZUYvTOxZYdqGUEDVGNI5Zaius", "ySAm23csf2WE3i3c6wljhI8SxF81jPn9"};
    public static final Parcelable.Creator<PrivFrame> CREATOR;
    public final String A00;
    public final byte[] A01;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 89);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{85, 79, 0, 24, 1, 10, 29, 82, 125, Byte.MAX_VALUE, 100, 123};
    }

    static {
        A01();
        CREATOR = new Dl();
    }

    public PrivFrame(Parcel parcel) {
        super(A00(8, 4, 116));
        this.A00 = parcel.readString();
        this.A01 = parcel.createByteArray();
    }

    public PrivFrame(String str, byte[] bArr) {
        super(A00(8, 4, 116));
        this.A00 = str;
        this.A01 = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (A03[4].charAt(14) != 'i') {
            A03[4] = "1okhidAP9wAc33vvVzVjP9G0LtIW3Syr";
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            if (A03[0].length() != 32) {
                A03[0] = "0j0m39eTEMk7iJyX9qSbKIFaQIBATa";
                PrivFrame privFrame = (PrivFrame) obj;
                return IF.A0g(this.A00, privFrame.A00) && Arrays.equals(this.A01, privFrame.A01);
            }
            throw new RuntimeException();
        }
        throw new RuntimeException();
    }

    public final int hashCode() {
        int i = 17 * 31;
        String str = this.A00;
        int result = str != null ? str.hashCode() : 0;
        return ((i + result) * 31) + Arrays.hashCode(this.A01);
    }

    @Override // com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.Id3Frame
    public final String toString() {
        return super.A00 + A00(0, 8, 54) + this.A00;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.A00);
        parcel.writeByteArray(this.A01);
    }
}

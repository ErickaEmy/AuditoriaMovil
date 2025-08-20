package com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.X.Dh;
import com.facebook.ads.redexgen.X.IF;
import com.uv.v7.R;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class GeobFrame extends Id3Frame {
    public static byte[] A04;
    public static String[] A05 = {"e4PaALyL2Y3QZZdSZfQ6CfJUdrEEqEQe", "RqR9wxO6hY3xmK69ggVcYnfUvCrzt81i", "9ysv0lhhv3sQtyjJmjeyyfrD9LW0jAjf", "qe7g0EhjvtprumUGxu9Q3hunkrllML", "cHAfqJiH2uoGuXkKEfHL", "oA1TxZHacOOH7vhqS4WqnB8Ay7IrUK", "lRQ7UCDPccJkM0SYbKNMrnYBvqFrtWw5", "K66Zv7tM6ZI"};
    public static final Parcelable.Creator<GeobFrame> CREATOR;
    public final String A00;
    public final String A01;
    public final String A02;
    public final byte[] A03;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 81);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-104, -116, -48, -47, -33, -49, -34, -43, -36, -32, -43, -37, -38, -87, -39, -51, 19, 22, 25, 18, 27, 14, 26, 18, -22, -107, 123, -56, -60, -56, -64, -81, -44, -53, -64, -104, 7, 5, 15, 2};
    }

    static {
        A01();
        CREATOR = new Dh();
    }

    public GeobFrame(Parcel parcel) {
        super(A00(36, 4, R.styleable.AppCompatTheme_textColorSearchUrl));
        this.A02 = parcel.readString();
        this.A01 = parcel.readString();
        this.A00 = parcel.readString();
        this.A03 = parcel.createByteArray();
    }

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super(A00(36, 4, R.styleable.AppCompatTheme_textColorSearchUrl));
        this.A02 = str;
        this.A01 = str2;
        this.A00 = str3;
        this.A03 = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GeobFrame geobFrame = (GeobFrame) obj;
        if (IF.A0g(this.A02, geobFrame.A02) && IF.A0g(this.A01, geobFrame.A01)) {
            String str = this.A00;
            if (A05[4].length() == 21) {
                throw new RuntimeException();
            }
            A05[7] = "9rXxnJ3UHnS";
            if (IF.A0g(str, geobFrame.A00) && Arrays.equals(this.A03, geobFrame.A03)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17 * 31;
        String str = this.A02;
        int result = str != null ? str.hashCode() : 0;
        int i5 = i + result;
        String[] strArr = A05;
        String str2 = strArr[5];
        String str3 = strArr[3];
        int length = str2.length();
        int result2 = str3.length();
        if (length != result2) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[1] = "KZ3f77MoQLAjhr2eDWVRLycu7lCXtr5S";
        strArr2[6] = "ROtPOyGTuIgMnCvtlr43BLYFfYj8taPq";
        int result3 = i5 * 31;
        String str4 = this.A01;
        int result4 = str4 != null ? str4.hashCode() : 0;
        int result5 = (result3 + result4) * 31;
        String str5 = this.A00;
        return ((result5 + (str5 != null ? str5.hashCode() : 0)) * 31) + Arrays.hashCode(this.A03);
    }

    @Override // com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.Id3Frame
    public final String toString() {
        return super.A00 + A00(25, 11, 10) + this.A02 + A00(14, 11, 92) + this.A01 + A00(0, 14, 27) + this.A00;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.A02);
        parcel.writeString(this.A01);
        parcel.writeString(this.A00);
        parcel.writeByteArray(this.A03);
    }
}

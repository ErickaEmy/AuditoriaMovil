package com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.X.C0585Df;
import com.facebook.ads.redexgen.X.IF;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class ChapterTocFrame extends Id3Frame {
    public static byte[] A05;
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR;
    public final String A00;
    public final boolean A01;
    public final boolean A02;
    public final String[] A03;
    public final Id3Frame[] A04;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 54);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{-99, -82, -87, -99};
    }

    static {
        A01();
        CREATOR = new C0585Df();
    }

    public ChapterTocFrame(Parcel parcel) {
        super(A00(0, 4, 36));
        this.A00 = parcel.readString();
        this.A02 = parcel.readByte() != 0;
        this.A01 = parcel.readByte() != 0;
        this.A03 = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.A04 = new Id3Frame[readInt];
        for (int i = 0; i < readInt; i++) {
            this.A04[i] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public ChapterTocFrame(String str, boolean z2, boolean z3, String[] strArr, Id3Frame[] id3FrameArr) {
        super(A00(0, 4, 36));
        this.A00 = str;
        this.A02 = z2;
        this.A01 = z3;
        this.A03 = strArr;
        this.A04 = id3FrameArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
        if (this.A02 == chapterTocFrame.A02 && this.A01 == chapterTocFrame.A01 && IF.A0g(this.A00, chapterTocFrame.A00) && Arrays.equals(this.A03, chapterTocFrame.A03) && Arrays.equals(this.A04, chapterTocFrame.A04)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A02 ? 1 : 0;
        int result2 = ((((17 * 31) + result) * 31) + (this.A01 ? 1 : 0)) * 31;
        String str = this.A00;
        int result3 = str != null ? str.hashCode() : 0;
        return result2 + result3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.A00);
        parcel.writeByte(this.A02 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A01 ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.A03);
        parcel.writeInt(this.A04.length);
        for (Id3Frame id3Frame : this.A04) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }
}

package com.facebook.ads.internal.exoplayer2.thirdparty.source;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.redexgen.X.AbstractC0672Ha;
import com.facebook.ads.redexgen.X.FJ;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class TrackGroup implements Parcelable {
    public static String[] A03 = {"", "NMittKxTOqnCpR0XVNiGFQTgWBdVnSBQ", "6q2S2IWbxt3Au5KHDEjHre", "yesKExk412D9rxhfpJlSlvbFBwA7zIdr", "", "HTCNZO0GmLRgbnlHCzceXp", "rqCvvFRkFLctqovtMSwPdniKfX3FbXhx", "eUM"};
    public static final Parcelable.Creator<TrackGroup> CREATOR = new FJ();
    public int A00;
    public final int A01;
    public final Format[] A02;

    /* JADX WARN: Incorrect condition in loop: B:4:0x0010 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TrackGroup(android.os.Parcel r4) {
        /*
            r3 = this;
            r3.<init>()
            int r0 = r4.readInt()
            r3.A01 = r0
            com.facebook.ads.internal.exoplayer2.thirdparty.Format[] r0 = new com.facebook.ads.internal.exoplayer2.thirdparty.Format[r0]
            r3.A02 = r0
            r2 = 0
        Le:
            int r0 = r3.A01
            if (r2 >= r0) goto L25
            com.facebook.ads.internal.exoplayer2.thirdparty.Format[] r1 = r3.A02
            java.lang.Class<com.facebook.ads.internal.exoplayer2.thirdparty.Format> r0 = com.facebook.ads.internal.exoplayer2.thirdparty.Format.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r4.readParcelable(r0)
            com.facebook.ads.internal.exoplayer2.thirdparty.Format r0 = (com.facebook.ads.internal.exoplayer2.thirdparty.Format) r0
            r1[r2] = r0
            int r2 = r2 + 1
            goto Le
        L25:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup.<init>(android.os.Parcel):void");
    }

    public TrackGroup(Format... formatArr) {
        AbstractC0672Ha.A04(formatArr.length > 0);
        this.A02 = formatArr;
        this.A01 = formatArr.length;
    }

    public final int A00(Format format) {
        int i = 0;
        while (true) {
            Format[] formatArr = this.A02;
            int i5 = formatArr.length;
            if (i < i5) {
                if (format == formatArr[i]) {
                    return i;
                }
                i++;
            } else {
                return -1;
            }
        }
    }

    public final Format A01(int i) {
        return this.A02[i];
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
        TrackGroup trackGroup = (TrackGroup) obj;
        return this.A01 == trackGroup.A01 && Arrays.equals(this.A02, trackGroup.A02);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            if (A03[0].length() == 29) {
                throw new RuntimeException();
            }
            A03[6] = "7PEwa6COELc4k3zf5JXJInB5hEQAk2SR";
            int result = Arrays.hashCode(this.A02);
            this.A00 = (17 * 31) + result;
        }
        return this.A00;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.A01);
        int i5 = 0;
        while (true) {
            int i6 = this.A01;
            String[] strArr = A03;
            String str = strArr[2];
            String str2 = strArr[5];
            int length = str.length();
            int i8 = str2.length();
            if (length != i8) {
                throw new RuntimeException();
            }
            A03[6] = "BrTDzXvstLX2a3jCZEwFRrav1URrTsvk";
            if (i5 < i6) {
                parcel.writeParcelable(this.A02[i5], 0);
                i5++;
            } else {
                return;
            }
        }
    }
}

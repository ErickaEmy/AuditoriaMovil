package com.facebook.ads.internal.exoplayer2.thirdparty.source;

import android.os.Parcelable;
import com.facebook.ads.redexgen.X.FL;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class TrackGroupArray implements Parcelable {
    public static String[] A03 = {"CPEwG9kX5jD", "BuT4NFhECA4LIoxcibTyV2rTxW8D7NsJ", "VLvhUNyYrf820yvuRBkPHRPWgKLlpjnS", "oxeVMxvuq0fQP8O4UP99i7KUs83wljn7", "ullnJTMWkmSfBc1cpn0n9HDTgALaYzbW", "uWsPmZUlFuxS4B4B7078xNnndmjfetpu", "kBzYEJnvMy4hYPMlsmjxFp4F3Gjj42", "O4Dh4XK1VBS6gYYO8yxgdHKR7TJnBRof"};
    public static final TrackGroupArray A04 = new TrackGroupArray(new TrackGroup[0]);
    public static final Parcelable.Creator<TrackGroupArray> CREATOR = new FL();
    public int A00;
    public final int A01;
    public final TrackGroup[] A02;

    /* JADX WARN: Incorrect condition in loop: B:4:0x0010 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TrackGroupArray(android.os.Parcel r4) {
        /*
            r3 = this;
            r3.<init>()
            int r0 = r4.readInt()
            r3.A01 = r0
            com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup[] r0 = new com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup[r0]
            r3.A02 = r0
            r2 = 0
        Le:
            int r0 = r3.A01
            if (r2 >= r0) goto L25
            com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup[] r1 = r3.A02
            java.lang.Class<com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup> r0 = com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r4.readParcelable(r0)
            com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup r0 = (com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup) r0
            r1[r2] = r0
            int r2 = r2 + 1
            goto Le
        L25:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray.<init>(android.os.Parcel):void");
    }

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.A02 = trackGroupArr;
        this.A01 = trackGroupArr.length;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0003 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int A00(com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup r5) {
        /*
            r4 = this;
            r1 = 0
        L1:
            int r0 = r4.A01
            if (r1 >= r0) goto Lf
            com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup[] r0 = r4.A02
            r0 = r0[r1]
            if (r0 != r5) goto Lc
            return r1
        Lc:
            int r1 = r1 + 1
            goto L1
        Lf:
            r3 = -1
            java.lang.String[] r1 = com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray.A03
            r0 = 6
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 30
            if (r1 == r0) goto L23
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L23:
            java.lang.String[] r2 = com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray.A03
            java.lang.String r1 = "RV"
            r0 = 0
            r2[r0] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray.A00(com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup):int");
    }

    public final TrackGroup A01(int i) {
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
        TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
        return this.A01 == trackGroupArray.A01 && Arrays.equals(this.A02, trackGroupArray.A02);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            this.A00 = Arrays.hashCode(this.A02);
        }
        return this.A00;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0008 */
    @Override // android.os.Parcelable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void writeToParcel(android.os.Parcel r4, int r5) {
        /*
            r3 = this;
            int r0 = r3.A01
            r4.writeInt(r0)
            r2 = 0
        L6:
            int r0 = r3.A01
            if (r2 >= r0) goto L15
            com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup[] r0 = r3.A02
            r1 = r0[r2]
            r0 = 0
            r4.writeParcelable(r1, r0)
            int r2 = r2 + 1
            goto L6
        L15:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray.writeToParcel(android.os.Parcel, int):void");
    }
}

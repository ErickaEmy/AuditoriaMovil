package com.facebook.ads.internal.exoplayer2.thirdparty.trackselection;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray;
import com.facebook.ads.redexgen.X.GY;
import com.facebook.ads.redexgen.X.IF;
import java.util.HashMap;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class DefaultTrackSelector$Parameters implements Parcelable {
    public static String[] A0I = {"xspOKqpsuNSHsU6yQ2hmF9xUBvSadBKT", "riC8v0KGC6T6xbiWSXBaQkex98EmMIIC", "9xWod89i1gOfKdrnPe3DKCHyV8RTz8jG", "XViGCx7W3TmophXTcjUeDQCnuDQ44POI", "w1EdEHwQfo8X2adbO9aKaB1kW84D", "Di1edpBPlwoBYmfejQX2YYRqdQKgNm", "Px6EOsH51hKuaKZF9Dy11SJny8y4mC2Q", "lJLgMmMCf61ooNf0l2gCJ"};
    public static final DefaultTrackSelector$Parameters A0J = new DefaultTrackSelector$Parameters();
    public static final Parcelable.Creator<DefaultTrackSelector$Parameters> CREATOR = new GY();
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final String A07;
    public final String A08;
    public final boolean A09;
    public final boolean A0A;
    public final boolean A0B;
    public final boolean A0C;
    public final boolean A0D;
    public final boolean A0E;
    public final boolean A0F;
    public final SparseArray<Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride>> A0G;
    public final SparseBooleanArray A0H;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A01(Parcel parcel, SparseArray<Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride>> sparseArray) {
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i = 0; i < size; i++) {
            int keyAt = sparseArray.keyAt(i);
            Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride> valueAt = sparseArray.valueAt(i);
            int size2 = valueAt.size();
            parcel.writeInt(keyAt);
            parcel.writeInt(size2);
            for (Map.Entry<TrackGroupArray, DefaultTrackSelector$SelectionOverride> entry : valueAt.entrySet()) {
                parcel.writeParcelable(entry.getKey(), 0);
                parcel.writeParcelable(entry.getValue(), 0);
            }
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static boolean A02(SparseArray<Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride>> sparseArray, SparseArray<Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride>> sparseArray2) {
        int size = sparseArray.size();
        if (sparseArray2.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i));
            if (indexOfKey < 0 || !A04(sparseArray.valueAt(i), sparseArray2.valueAt(indexOfKey))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean A04(java.util.Map<com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray, com.facebook.ads.internal.exoplayer2.thirdparty.trackselection.DefaultTrackSelector$SelectionOverride> r5, java.util.Map<com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray, com.facebook.ads.internal.exoplayer2.thirdparty.trackselection.DefaultTrackSelector$SelectionOverride> r6) {
        /*
            int r1 = r5.size()
            int r0 = r6.size()
            r4 = 0
            if (r0 == r1) goto Lc
            return r4
        Lc:
            java.util.Set r0 = r5.entrySet()
            java.util.Iterator r3 = r0.iterator()
        L14:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L3b
            java.lang.Object r1 = r3.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray r2 = (com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray) r2
            boolean r0 = r6.containsKey(r2)
            if (r0 == 0) goto L3a
            java.lang.Object r1 = r1.getValue()
            java.lang.Object r0 = r6.get(r2)
            boolean r0 = com.facebook.ads.redexgen.X.IF.A0g(r1, r0)
            if (r0 != 0) goto L14
        L3a:
            return r4
        L3b:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.exoplayer2.thirdparty.trackselection.DefaultTrackSelector$Parameters.A04(java.util.Map, java.util.Map):boolean");
    }

    public DefaultTrackSelector$Parameters() {
        this(new SparseArray(), new SparseBooleanArray(), null, null, false, 0, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true, 0);
    }

    public DefaultTrackSelector$Parameters(Parcel parcel) {
        this.A0G = A00(parcel);
        this.A0H = parcel.readSparseBooleanArray();
        this.A07 = parcel.readString();
        this.A08 = parcel.readString();
        this.A0E = IF.A0f(parcel);
        this.A00 = parcel.readInt();
        this.A0D = IF.A0f(parcel);
        this.A09 = IF.A0f(parcel);
        this.A0A = IF.A0f(parcel);
        this.A03 = parcel.readInt();
        this.A02 = parcel.readInt();
        this.A01 = parcel.readInt();
        this.A0C = IF.A0f(parcel);
        this.A0B = IF.A0f(parcel);
        this.A06 = parcel.readInt();
        this.A05 = parcel.readInt();
        this.A0F = IF.A0f(parcel);
        this.A04 = parcel.readInt();
    }

    public DefaultTrackSelector$Parameters(SparseArray<Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride>> sparseArray, SparseBooleanArray sparseBooleanArray, String str, String str2, boolean z2, int i, boolean z3, boolean z4, boolean z5, int i5, int i6, int i8, boolean z7, boolean z8, int i10, int i11, boolean z9, int i12) {
        this.A0G = sparseArray;
        this.A0H = sparseBooleanArray;
        this.A07 = IF.A0L(str);
        this.A08 = IF.A0L(str2);
        this.A0E = z2;
        this.A00 = i;
        this.A0D = z3;
        this.A09 = z4;
        this.A0A = z5;
        this.A03 = i5;
        this.A02 = i6;
        this.A01 = i8;
        this.A0C = z7;
        this.A0B = z8;
        this.A06 = i10;
        this.A05 = i11;
        this.A0F = z9;
        this.A04 = i12;
    }

    public static SparseArray<Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride>> A00(Parcel parcel) {
        int readInt = parcel.readInt();
        SparseArray<Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride>> sparseArray = new SparseArray<>(readInt);
        for (int i = 0; i < readInt; i++) {
            int readInt2 = parcel.readInt();
            int overrideCount = parcel.readInt();
            HashMap hashMap = new HashMap(overrideCount);
            for (int i5 = 0; i5 < overrideCount; i5++) {
                hashMap.put((TrackGroupArray) parcel.readParcelable(TrackGroupArray.class.getClassLoader()), (DefaultTrackSelector$SelectionOverride) parcel.readParcelable(DefaultTrackSelector$SelectionOverride.class.getClassLoader()));
            }
            sparseArray.put(readInt2, hashMap);
        }
        return sparseArray;
    }

    public static boolean A03(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        int size = sparseBooleanArray.size();
        int firstSize = sparseBooleanArray2.size();
        if (firstSize != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            int firstSize2 = sparseBooleanArray.keyAt(i);
            int indexOfKey = sparseBooleanArray2.indexOfKey(firstSize2);
            String[] strArr = A0I;
            String str = strArr[1];
            String str2 = strArr[3];
            int indexInFirst = str.charAt(1);
            int firstSize3 = str2.charAt(1);
            if (indexInFirst == firstSize3) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0I;
            strArr2[4] = "TWCHslMtrSPWm8Xm1qbYb45ITo2f";
            strArr2[7] = "RLfCzsREQIu8GIT95ZyUn";
            if (indexOfKey < 0) {
                return false;
            }
        }
        String[] strArr3 = A0I;
        String str3 = strArr3[1];
        String str4 = strArr3[3];
        int charAt = str3.charAt(1);
        int firstSize4 = str4.charAt(1);
        if (charAt != firstSize4) {
            String[] strArr4 = A0I;
            strArr4[1] = "9OmP0pM4oeSW4vYjuQnZsj7ARVAlNm9Q";
            strArr4[3] = "5jAxY38VzlYYY7G3iwLfCwgXJRn7HwV7";
            return true;
        }
        return true;
    }

    public final DefaultTrackSelector$SelectionOverride A05(int i, TrackGroupArray trackGroupArray) {
        Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride> overrides = this.A0G.get(i);
        if (overrides != null) {
            return overrides.get(trackGroupArray);
        }
        return null;
    }

    public final boolean A06(int i) {
        return this.A0H.get(i);
    }

    public final boolean A07(int i, TrackGroupArray trackGroupArray) {
        Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride> overrides = this.A0G.get(i);
        if (overrides != null) {
            boolean containsKey = overrides.containsKey(trackGroupArray);
            if (A0I[5].length() == 4) {
                throw new RuntimeException();
            }
            A0I[0] = "lzejp6YakqFZkogBPOKTH5ufeqqszLCx";
            if (containsKey) {
                return true;
            }
        }
        return false;
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
        DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = (DefaultTrackSelector$Parameters) obj;
        if (this.A0E == defaultTrackSelector$Parameters.A0E && this.A00 == defaultTrackSelector$Parameters.A00 && this.A0D == defaultTrackSelector$Parameters.A0D && this.A09 == defaultTrackSelector$Parameters.A09 && this.A0A == defaultTrackSelector$Parameters.A0A && this.A03 == defaultTrackSelector$Parameters.A03 && this.A02 == defaultTrackSelector$Parameters.A02 && this.A0C == defaultTrackSelector$Parameters.A0C && this.A0B == defaultTrackSelector$Parameters.A0B) {
            boolean z2 = this.A0F;
            boolean z3 = defaultTrackSelector$Parameters.A0F;
            String[] strArr = A0I;
            if (strArr[1].charAt(1) != strArr[3].charAt(1)) {
                String[] strArr2 = A0I;
                strArr2[6] = "RsqquBPnZm6UmuAT62eIFIvrb8Rb5SvS";
                strArr2[2] = "EVCGEl3vM50CnHtU5PSWguXPf8LHPnJq";
                if (z2 == z3) {
                    int i = this.A06;
                    String[] strArr3 = A0I;
                    if (strArr3[4].length() != strArr3[7].length()) {
                        String[] strArr4 = A0I;
                        strArr4[4] = "cpo4I3FMY0KaSh3J5gQMPV4i0iDz";
                        strArr4[7] = "WmxBSRM06CbrVYU4lLmSD";
                        if (i == defaultTrackSelector$Parameters.A06 && this.A05 == defaultTrackSelector$Parameters.A05 && this.A01 == defaultTrackSelector$Parameters.A01 && this.A04 == defaultTrackSelector$Parameters.A04 && TextUtils.equals(this.A07, defaultTrackSelector$Parameters.A07) && TextUtils.equals(this.A08, defaultTrackSelector$Parameters.A08) && A03(this.A0H, defaultTrackSelector$Parameters.A0H) && A02(this.A0G, defaultTrackSelector$Parameters.A0G)) {
                            return true;
                        }
                    }
                }
            }
            throw new RuntimeException();
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A0E ? 1 : 0;
        int i = result * 31;
        int result2 = this.A00;
        int result3 = this.A09 ? 1 : 0;
        int result4 = this.A03;
        int result5 = this.A0C ? 1 : 0;
        int result6 = this.A0F ? 1 : 0;
        int result7 = this.A05;
        int result8 = this.A04;
        int i5 = (((((((((((((((((((((((((i + result2) * 31) + (this.A0D ? 1 : 0)) * 31) + result3) * 31) + (this.A0A ? 1 : 0)) * 31) + result4) * 31) + this.A02) * 31) + result5) * 31) + (this.A0B ? 1 : 0)) * 31) + result6) * 31) + this.A06) * 31) + result7) * 31) + this.A01) * 31) + result8) * 31;
        String str = this.A07;
        int hashCode = (i5 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.A08;
        int result9 = str2 != null ? str2.hashCode() : 0;
        int i6 = hashCode + result9;
        if (A0I[5].length() != 4) {
            String[] strArr = A0I;
            strArr[6] = "0d6m0jAEOh63kopddSVpv8GRX8aDyFMT";
            strArr[2] = "KnimCfQbzsddQD04DwcfcTRdj8ibyvkP";
            return i6;
        }
        throw new RuntimeException();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        A01(parcel, this.A0G);
        parcel.writeSparseBooleanArray(this.A0H);
        parcel.writeString(this.A07);
        parcel.writeString(this.A08);
        IF.A0V(parcel, this.A0E);
        parcel.writeInt(this.A00);
        IF.A0V(parcel, this.A0D);
        IF.A0V(parcel, this.A09);
        IF.A0V(parcel, this.A0A);
        parcel.writeInt(this.A03);
        parcel.writeInt(this.A02);
        parcel.writeInt(this.A01);
        IF.A0V(parcel, this.A0C);
        IF.A0V(parcel, this.A0B);
        parcel.writeInt(this.A06);
        parcel.writeInt(this.A05);
        IF.A0V(parcel, this.A0F);
        parcel.writeInt(this.A04);
    }
}

package com.facebook.ads.redexgen.X;

import java.io.File;
/* loaded from: assets/audience_network.dex */
public class HO implements Comparable<HO> {
    public static String[] A06 = {"tyIMHYj4E3EgW4mShNYTh30KqADxMnXY", "o4JUlXa2QWu1MieYLvsMRT696KEqR", "les1EbCUxP4xgOdfeUltBKAu87PDHxqp", "SxfWhIkSVBET5IPf", "bPkhSE8L0qTQU8qqVG5cBeS4akAeFCpX", "MYrQWqVSdZJmtqUt3HjVFVZZ1A2nkQzV", "YLTzIQmg1iEN7fTeYL0Ebb05kPDCmFqk", "L0nZjQMyNIt0WlCmUM7oX7gpc1lDkDOo"};
    public final long A00;
    public final long A01;
    public final long A02;
    public final File A03;
    public final String A04;
    public final boolean A05;

    public HO(String str, long j2, long j4, long j6, File file) {
        this.A04 = str;
        this.A02 = j2;
        this.A01 = j4;
        this.A05 = file != null;
        this.A03 = file;
        this.A00 = j6;
    }

    @Override // java.lang.Comparable
    /* renamed from: A00 */
    public final int compareTo(HO ho2) {
        if (!this.A04.equals(ho2.A04)) {
            return this.A04.compareTo(ho2.A04);
        }
        long j2 = this.A02 - ho2.A02;
        String[] strArr = A06;
        if (strArr[0].charAt(26) != strArr[6].charAt(26)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[0] = "iYRssdXy9CB99yO9PwMxA9WvOrDQskNV";
        strArr2[6] = "6rGRVoRQr925zwi8UOEHhi5JTPDCThCe";
        if (j2 == 0) {
            return 0;
        }
        return j2 < 0 ? -1 : 1;
    }

    public final boolean A01() {
        return !this.A05;
    }

    public final boolean A02() {
        return this.A01 == -1;
    }
}

package com.facebook.ads.redexgen.X;

import android.net.Uri;
/* loaded from: assets/audience_network.dex */
public final class FN {
    public final int A00;
    public final int[] A01;
    public final long[] A02;
    public final Uri[] A03;

    public FN() {
        this(-1, new int[0], new Uri[0], new long[0]);
    }

    public FN(int i, int[] iArr, Uri[] uriArr, long[] jArr) {
        AbstractC0672Ha.A03(iArr.length == uriArr.length);
        this.A00 = i;
        this.A01 = iArr;
        this.A03 = uriArr;
        this.A02 = jArr;
    }

    public final int A00() {
        return A01(-1);
    }

    public final int A01(int i) {
        int i5;
        int i6 = i + 1;
        while (true) {
            int[] iArr = this.A01;
            int nextAdIndexToPlay = iArr.length;
            if (i6 >= nextAdIndexToPlay || (i5 = iArr[i6]) == 0 || i5 == 1) {
                break;
            }
            i6++;
        }
        return i6;
    }

    public final boolean A02() {
        return this.A00 == -1 || A00() < this.A00;
    }
}

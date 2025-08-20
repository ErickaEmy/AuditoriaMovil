package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
/* renamed from: com.facebook.ads.redexgen.X.Pi  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0881Pi {
    public final SparseArray<int[]> A00 = new SparseArray<>();

    public final void A00(int i, int[] iArr) {
        this.A00.put(i, iArr);
    }

    public final boolean A01(int i) {
        return this.A00.indexOfKey(i) >= 0;
    }

    public final int[] A02(int i) {
        return this.A00.get(i);
    }
}

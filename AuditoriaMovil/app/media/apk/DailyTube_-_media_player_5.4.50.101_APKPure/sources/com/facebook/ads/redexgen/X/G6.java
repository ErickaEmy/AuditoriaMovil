package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
/* loaded from: assets/audience_network.dex */
public final class G6 {
    public G0 A00;
    public G2 A01;
    public final int A02;
    public final int A03;
    public final SparseArray<G4> A08 = new SparseArray<>();
    public final SparseArray<C0647Fz> A06 = new SparseArray<>();
    public final SparseArray<G1> A07 = new SparseArray<>();
    public final SparseArray<C0647Fz> A04 = new SparseArray<>();
    public final SparseArray<G1> A05 = new SparseArray<>();

    public G6(int i, int i5) {
        this.A03 = i;
        this.A02 = i5;
    }

    public final void A00() {
        this.A08.clear();
        this.A06.clear();
        this.A07.clear();
        this.A04.clear();
        this.A05.clear();
        this.A00 = null;
        this.A01 = null;
    }
}

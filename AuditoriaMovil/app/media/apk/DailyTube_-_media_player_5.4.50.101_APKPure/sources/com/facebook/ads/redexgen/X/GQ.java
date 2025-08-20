package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class GQ implements Comparable<GQ> {
    public final int A00;
    public final GM A01;

    public GQ(int i, GM gm) {
        this.A00 = i;
        this.A01 = gm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: A00 */
    public final int compareTo(GQ gq2) {
        return this.A00 - gq2.A00;
    }
}

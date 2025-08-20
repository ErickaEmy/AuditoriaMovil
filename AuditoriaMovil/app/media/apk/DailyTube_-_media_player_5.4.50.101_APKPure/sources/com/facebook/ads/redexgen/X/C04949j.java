package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.9j  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C04949j implements Comparable<C04949j> {
    public int A00;
    public long A01;
    public Object A02;
    public final A8 A03;

    public C04949j(A8 a82) {
        this.A03 = a82;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: A00 */
    public final int compareTo(C04949j c04949j) {
        Object obj = this.A02;
        if ((obj == null) != (c04949j.A02 == null)) {
            return obj != null ? -1 : 1;
        } else if (obj == null) {
            return 0;
        } else {
            int i = this.A00 - c04949j.A00;
            if (i != 0) {
                return i;
            }
            int comparePeriodIndex = IF.A07(this.A01, c04949j.A01);
            return comparePeriodIndex;
        }
    }

    public final void A01(int i, long j2, Object obj) {
        this.A00 = i;
        this.A01 = j2;
        this.A02 = obj;
    }
}

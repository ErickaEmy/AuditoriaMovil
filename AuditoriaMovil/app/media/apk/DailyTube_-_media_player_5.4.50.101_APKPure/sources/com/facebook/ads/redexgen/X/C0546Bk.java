package com.facebook.ads.redexgen.X;

import java.util.Comparator;
import java.util.TreeSet;
/* renamed from: com.facebook.ads.redexgen.X.Bk  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0546Bk implements InterfaceC1036Vi, Comparator<HO> {
    public long A00;
    public final long A01;
    public final TreeSet<HO> A02 = new TreeSet<>(this);

    public C0546Bk(long j2) {
        this.A01 = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Comparator
    /* renamed from: A00 */
    public final int compare(HO ho2, HO ho3) {
        if (ho2.A00 - ho3.A00 == 0) {
            return ho2.compareTo(ho3);
        }
        return ho2.A00 < ho3.A00 ? -1 : 1;
    }

    private void A01(HK hk, long j2) {
        while (this.A00 + j2 > this.A01 && !this.A02.isEmpty()) {
            try {
                hk.AF9(this.A02.first());
            } catch (HI unused) {
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.HJ
    public final void ADB(HK hk, HO ho2) {
        this.A02.add(ho2);
        this.A00 += ho2.A01;
        A01(hk, 0L);
    }

    @Override // com.facebook.ads.redexgen.X.HJ
    public final void ADC(HK hk, HO ho2) {
        this.A02.remove(ho2);
        this.A00 -= ho2.A01;
    }

    @Override // com.facebook.ads.redexgen.X.HJ
    public final void ADD(HK hk, HO ho2, HO ho3) {
        ADC(hk, ho2);
        ADB(hk, ho3);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1036Vi
    public final void ADE(HK hk, String str, long j2, long j4) {
        A01(hk, j4);
    }
}

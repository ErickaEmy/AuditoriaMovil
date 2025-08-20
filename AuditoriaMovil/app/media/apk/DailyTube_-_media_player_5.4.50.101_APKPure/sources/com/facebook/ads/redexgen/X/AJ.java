package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
/* loaded from: assets/audience_network.dex */
public final class AJ {
    public static String[] A06 = {"rmgpPCWB7BYHQ3azE8yCiRChgWLX4K1O", "ESYL8WQp59BjyyK9DI9xkUBJ1yOk4QLd", "YweXfGig2PVNilG2mJZlv3ovQAOkP8UY", "CAftEyLXQvcAYYqOnK17yfwScyM6Y9GQ", "5ZUx", "CHSAxwc6W9B6bhcUywJKjVUar2kzl0Sb", "G9dVYOs473", "8VVZpCzafohaQpJb3SOOvVZNRfYg5osa"};
    public AK A01;
    public AK A02;
    public boolean A03;
    public final ArrayList<AK> A05 = new ArrayList<>();
    public final AF A04 = new AF();
    public AH A00 = AH.A01;

    private AK A00(AK ak, AH ah) {
        if (ah.A0E() || this.A00.A0E()) {
            return ak;
        }
        AH ah2 = this.A00;
        int i = ak.A01.A02;
        if (A06[5].charAt(2) != 'm') {
            A06[3] = "6Z7kXvoTE0GMRlV8X7ahHWF28Ir1JA8U";
            Object uid = ah2.A0A(i, this.A04, true).A03;
            int newPeriodIndex = ah.A04(uid);
            if (newPeriodIndex == -1) {
                return ak;
            }
            int newWindowIndex = ah.A09(newPeriodIndex, this.A04).A00;
            return new AK(newWindowIndex, ak.A01.A00(newPeriodIndex));
        }
        throw new RuntimeException();
    }

    private void A02() {
        if (!this.A05.isEmpty()) {
            this.A01 = this.A05.get(0);
        }
    }

    public final AK A03() {
        return this.A01;
    }

    public final AK A04() {
        if (this.A05.isEmpty()) {
            return null;
        }
        ArrayList<AK> arrayList = this.A05;
        int size = arrayList.size() - 1;
        if (A06[3].charAt(28) != 'b') {
            String[] strArr = A06;
            strArr[6] = "IuVtQJyFuB";
            strArr[7] = "VEjGs0KHAo6Qkjlg0Fq6YAYYmbb9RMII";
            return arrayList.get(size);
        }
        throw new RuntimeException();
    }

    public final AK A05() {
        if (this.A05.isEmpty() || this.A00.A0E() || this.A03) {
            return null;
        }
        return this.A05.get(0);
    }

    public final AK A06() {
        return this.A02;
    }

    public final C0612Eo A07(int i) {
        C0612Eo c0612Eo = null;
        AH ah = this.A00;
        if (ah != null) {
            int A00 = ah.A00();
            for (int periodIndex = 0; periodIndex < this.A05.size(); periodIndex++) {
                AK mediaPeriod = this.A05.get(periodIndex);
                C0612Eo match = mediaPeriod.A01;
                int i5 = match.A02;
                if (i5 < A00 && this.A00.A09(i5, this.A04).A00 == i) {
                    if (c0612Eo != null) {
                        return null;
                    }
                    c0612Eo = mediaPeriod.A01;
                }
            }
        }
        return c0612Eo;
    }

    public final void A08() {
        this.A03 = false;
        A02();
    }

    public final void A09() {
        this.A03 = true;
    }

    public final void A0A(int i) {
        A02();
    }

    public final void A0B(int i, C0612Eo c0612Eo) {
        this.A05.add(new AK(i, c0612Eo));
        if (this.A05.size() == 1 && !this.A00.A0E()) {
            A02();
        }
    }

    public final void A0C(int i, C0612Eo c0612Eo) {
        AK mediaPeriod;
        AK ak = new AK(i, c0612Eo);
        this.A05.remove(ak);
        AK mediaPeriod2 = this.A02;
        if (ak.equals(mediaPeriod2)) {
            if (this.A05.isEmpty()) {
                mediaPeriod = null;
            } else {
                AK mediaPeriod3 = this.A05.get(0);
                mediaPeriod = mediaPeriod3;
            }
            this.A02 = mediaPeriod;
        }
    }

    public final void A0D(int i, C0612Eo c0612Eo) {
        this.A02 = new AK(i, c0612Eo);
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A0E(com.facebook.ads.redexgen.X.AH r4) {
        /*
            r3 = this;
            r2 = 0
        L1:
            java.util.ArrayList<com.facebook.ads.redexgen.X.AK> r0 = r3.A05
            int r0 = r0.size()
            if (r2 >= r0) goto L1b
            java.util.ArrayList<com.facebook.ads.redexgen.X.AK> r1 = r3.A05
            java.lang.Object r0 = r1.get(r2)
            com.facebook.ads.redexgen.X.AK r0 = (com.facebook.ads.redexgen.X.AK) r0
            com.facebook.ads.redexgen.X.AK r0 = r3.A00(r0, r4)
            r1.set(r2, r0)
            int r2 = r2 + 1
            goto L1
        L1b:
            com.facebook.ads.redexgen.X.AK r0 = r3.A02
            if (r0 == 0) goto L25
            com.facebook.ads.redexgen.X.AK r0 = r3.A00(r0, r4)
            r3.A02 = r0
        L25:
            r3.A00 = r4
            r3.A02()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AJ.A0E(com.facebook.ads.redexgen.X.AH):void");
    }

    public final boolean A0F() {
        return this.A03;
    }
}

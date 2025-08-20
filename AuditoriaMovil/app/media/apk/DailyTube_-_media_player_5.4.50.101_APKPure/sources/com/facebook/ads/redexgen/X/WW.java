package com.facebook.ads.redexgen.X;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: assets/audience_network.dex */
public abstract class WW implements InterfaceC0614Eq {
    public static String[] A05 = {"2", "A1R5XmGNdue", "Xf2fF", "2MZr802CwBgh98iwI2LX9r8AFH0stAP", "PWtCslqWMOhLlWMecFeGOSMcL", "Nab9jbcw8W2RSLeSFi8qaY40Uhnm56i", "UlYKNWRAV2IAyBS", "QHLbHyQnMMy3J3Z"};
    public Y6 A00;
    public AH A01;
    public Object A02;
    public final ArrayList<InterfaceC0613Ep> A04 = new ArrayList<>(1);
    public final F1 A03 = new F1();

    public abstract void A02();

    public abstract void A03(Y6 y62, boolean z2);

    public final F1 A00(C0612Eo c0612Eo) {
        return this.A03.A02(0, c0612Eo, 0L);
    }

    public final void A01(AH ah, Object obj) {
        this.A01 = ah;
        this.A02 = obj;
        Iterator<InterfaceC0613Ep> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().ADA(this, ah, obj);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0614Eq
    public final void A3O(Handler handler, F4 f4) {
        this.A03.A07(handler, f4);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0614Eq
    public final void AE7(Y6 y62, boolean z2, InterfaceC0613Ep interfaceC0613Ep) {
        Y6 y63 = this.A00;
        AbstractC0672Ha.A03(y63 == null || y63 == y62);
        this.A04.add(interfaceC0613Ep);
        if (this.A00 == null) {
            this.A00 = y62;
            A03(y62, z2);
            return;
        }
        AH ah = this.A01;
        if (ah == null) {
            return;
        }
        interfaceC0613Ep.ADA(this, ah, this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0614Eq
    public final void AEb(InterfaceC0613Ep interfaceC0613Ep) {
        this.A04.remove(interfaceC0613Ep);
        if (this.A04.isEmpty()) {
            this.A00 = null;
            this.A01 = null;
            if (A05[2].length() == 23) {
                throw new RuntimeException();
            }
            A05[2] = "TEgrTEJPhaeJK53iaQZF";
            this.A02 = null;
            A02();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0614Eq
    public final void AF7(F4 f4) {
        this.A03.A0D(f4);
    }
}

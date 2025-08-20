package com.facebook.ads.redexgen.X;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: assets/audience_network.dex */
public class VK implements QI {
    public static String[] A01 = {"T9VzL8fHxpfySiwwlXedeY7mX", "guyVlBlOMcVDAIfN1wPFopCO0r0Zk0gq", "ttKJ4peW2WPtu1OROjgTykJGR", "A5J8ePX4fIk14ZpUSfaCkLGHXqqMAYt6", "kQp8myZeu", "7L0NbJj9RoUIRUZ", "UhNplE17b8XX", "zMftdbZDucx4tcPG97oOAYZ8vQU5TBbw"};
    public final /* synthetic */ VE A00;

    public VK(VE ve) {
        this.A00 = ve;
    }

    @Override // com.facebook.ads.redexgen.X.QI
    public final void ADZ() {
        AtomicBoolean atomicBoolean;
        JK jk2;
        JK jk3;
        AtomicBoolean atomicBoolean2;
        atomicBoolean = this.A00.A0E;
        atomicBoolean.set(true);
        jk2 = this.A00.A02;
        if (jk2 != null) {
            jk3 = this.A00.A02;
            atomicBoolean2 = this.A00.A0D;
            boolean z2 = atomicBoolean2.get();
            if (A01[1].charAt(3) == 'h') {
                throw new RuntimeException();
            }
            A01[3] = "0cRb1Hjpfivo5OpVdykyl3dtou8RqpBl";
            jk3.ACX(z2);
        }
    }
}

package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class XF implements InterfaceC0554Bs {
    public static byte[] A03;
    public static final InterfaceC0557Bv A04;
    public InterfaceC0556Bu A00;
    public AbstractC0573Co A01;
    public boolean A02;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 37);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{108, -121, -113, -110, -117, -118, 70, -102, -107, 70, -118, -117, -102, -117, -104, -109, -113, -108, -117, 70, -120, -113, -102, -103, -102, -104, -117, -121, -109, 70, -102, -97, -106, -117};
    }

    static {
        A02();
        A04 = new XG();
    }

    public static C0697Hz A00(C0697Hz c0697Hz) {
        c0697Hz.A0Y(0);
        return c0697Hz;
    }

    private boolean A03(InterfaceC0555Bt interfaceC0555Bt) throws IOException, InterruptedException {
        C0569Ck c0569Ck = new C0569Ck();
        if (c0569Ck.A03(interfaceC0555Bt, true) && (c0569Ck.A04 & 2) == 2) {
            int length = Math.min(c0569Ck.A00, 8);
            C0697Hz c0697Hz = new C0697Hz(length);
            interfaceC0555Bt.ADv(c0697Hz.A00, 0, length);
            if (XH.A04(A00(c0697Hz))) {
                this.A01 = new XH();
            } else if (XC.A06(A00(c0697Hz))) {
                this.A01 = new XC();
            } else if (!XE.A04(A00(c0697Hz))) {
                return false;
            } else {
                this.A01 = new XE();
            }
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final void A8o(InterfaceC0556Bu interfaceC0556Bu) {
        this.A00 = interfaceC0556Bu;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final int AEH(InterfaceC0555Bt interfaceC0555Bt, C0559Bz c0559Bz) throws IOException, InterruptedException {
        if (this.A01 == null) {
            if (A03(interfaceC0555Bt)) {
                interfaceC0555Bt.AFM();
            } else {
                throw new C05059v(A01(0, 34, 1));
            }
        }
        if (!this.A02) {
            C4 AGi = this.A00.AGi(0, 1);
            this.A00.A5Y();
            this.A01.A06(this.A00, AGi);
            this.A02 = true;
        }
        return this.A01.A02(interfaceC0555Bt, c0559Bz);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final void AFh(long j2, long j4) {
        AbstractC0573Co abstractC0573Co = this.A01;
        if (abstractC0573Co != null) {
            abstractC0573Co.A05(j2, j4);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final boolean AGR(InterfaceC0555Bt interfaceC0555Bt) throws IOException, InterruptedException {
        try {
            return A03(interfaceC0555Bt);
        } catch (C05059v unused) {
            return false;
        }
    }
}

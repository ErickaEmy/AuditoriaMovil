package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class UP implements MA {
    public static String[] A02 = {"9zQQ", "ignw1BD", "Iwiu", "Rj9759ruFeEHfZFHtC0tN77N", "Yw9WW67qBp7nurOongm62UMTZpj72Daq", "XdprQx2", "zMrI2nkZvee1EVY6Hu3DKwgaLEX6aHI5", "7LD9TnQa5MzlVBDCJJS9JW3wW2x"};
    public final /* synthetic */ C5V A00;
    public final /* synthetic */ UL A01;

    public UP(UL ul, C5V c5v) {
        this.A01 = ul;
        this.A00 = c5v;
    }

    @Override // com.facebook.ads.redexgen.X.MA
    public final void AB6() {
        this.A01.A0D.A04(J9.A07, null);
        if (this.A01.A0a()) {
            return;
        }
        if (this.A01.A0X()) {
            this.A01.A0W(this.A00);
            return;
        }
        C5V c5v = this.A00;
        if (A02[7].length() != 27) {
            throw new RuntimeException();
        }
        A02[4] = "TQLH18Rv5MEOVOxcIrRMtSKcbgUrlpIS";
        c5v.finish(1);
    }
}

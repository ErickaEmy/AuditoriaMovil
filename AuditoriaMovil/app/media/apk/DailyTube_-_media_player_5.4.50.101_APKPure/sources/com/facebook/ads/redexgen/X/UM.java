package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class UM implements L8 {
    public static String[] A02 = {"loUGRX1wFwfO8pi8DgxPrGsPJe85sO42", "t9Fx4", "3oarn8HbUVUj6u6EULIVhfy23k9jn", "", "MOoTM", "MayuUyWiOMYLrKJeDUJbe9Zh46", "X9niQtR04keYRbnSLMpJZHmvyyUcrdIf", "5gFPyDfRsmHweMwy7A1yA2IFiPZ"};
    public final /* synthetic */ int A00;
    public final /* synthetic */ UL A01;

    public UM(UL ul, int i) {
        this.A01 = ul;
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.X.L8
    public final void ABA() {
        MC mc2;
        this.A01.A03 = false;
        this.A01.A0S();
        this.A01.A0E.setToolbarActionMode(this.A01.getCloseButtonStyle());
        if (this.A01.A07) {
            Q7 q7 = this.A01.A06;
            if (A02[2].length() == 15) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[7] = "KtnVXPQG8pyake3V1oVxr2XzOzf";
            strArr[3] = "";
            if (q7 != null) {
                this.A01.A06.A05();
                mc2 = this.A01.A09;
                mc2.A43(new U8().A5s());
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.L8
    public final void ACm(float f4) {
        this.A01.A0E.setProgress(100.0f * (1.0f - (f4 / this.A00)));
    }
}

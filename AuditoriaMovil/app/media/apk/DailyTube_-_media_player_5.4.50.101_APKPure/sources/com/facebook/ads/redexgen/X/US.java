package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class US extends AbstractC03874t {
    public static String[] A01 = {"8Yn2PgyedH1iX", "R67HljoZMbsPm0e6EtybvG", "", "R8Pp2uuVTku92bGxcvFWCvwfHASfPd1y", "2y5E80sPhAjkTDK", "Itturke", "abRBLy2wdT4xlnoMDCf2vtSzdY3x1mV2", "QG421Xj1ReSIzqeVHucrcoJTP843GzsJ"};
    public final /* synthetic */ C03603r A00;

    public US(C03603r c03603r) {
        this.A00 = c03603r;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03874t
    public final void A0L(C0599Eb c0599Eb, int i) {
        int scrollPosition;
        super.A0L(c0599Eb, i);
        C1142Zo linearLayoutManager = this.A00.getLayoutManager();
        if (linearLayoutManager == null || (scrollPosition = linearLayoutManager.A23()) < 0 || this.A00.getAdapter() == null || scrollPosition >= this.A00.getAdapter().A0E()) {
            return;
        }
        MJ mj = (MJ) c0599Eb.A1F(scrollPosition);
        if (A01[1].length() == 0) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[5] = "EBOsosi";
        strArr[2] = "";
        if (mj == null) {
            return;
        }
        mj.AFr();
    }
}

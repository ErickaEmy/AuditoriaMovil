package com.facebook.ads.redexgen.X;

import android.os.Handler;
/* loaded from: assets/audience_network.dex */
public class SD extends KT {
    public static String[] A04 = {"pUIboC8CwdUMtM1tPR8iEtPz8p", "ladzvmq", "gZiIZXhhpFNWaRiPv", "vQtAVDGFp8M", "7j30UYRlUEXcM4Kd2wK", "XchzO9Mtzl1GyvdPdWlZd1J0iwZmFx3H", "VTwPVxpRcW0", "YPnzN72MuP4y3lnuBhqZ0NoSyY"};
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ SA A02;
    public final /* synthetic */ RB A03;

    public SD(SA sa, RB rb2, int i, int i5) {
        this.A02 = sa;
        this.A03 = rb2;
        this.A00 = i;
        this.A01 = i5;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        C1116Yn c1116Yn;
        Handler handler;
        C04778r c04778r;
        C1116Yn c1116Yn2;
        C04778r c04778r2;
        C0795Ma c0795Ma;
        Handler handler2;
        C1116Yn c1116Yn3;
        C04778r c04778r3;
        Handler handler3;
        C1116Yn c1116Yn4;
        C1116Yn c1116Yn5;
        C04778r c04778r4;
        O8 o8;
        Handler handler4;
        C1116Yn c1116Yn6;
        C1116Yn c1116Yn7;
        Handler handler5;
        C04778r c04778r5;
        C04778r c04778r6;
        C0892Pt c0892Pt;
        C1116Yn c1116Yn8;
        C04778r c04778r7;
        if (this.A03 == RB.A07) {
            this.A02.A0L(J9.A0q);
            c1116Yn8 = this.A02.A0A;
            c1116Yn8.A0E().A38();
            c04778r7 = this.A02.A0B;
            c04778r7.A02(SA.A0C());
        } else if (this.A03 == RB.A03) {
            this.A02.A0L(J9.A0l);
            this.A02.A03 = true;
            c04778r6 = this.A02.A0B;
            c0892Pt = SA.A0G;
            c04778r6.A02(c0892Pt);
            this.A02.A0K(this.A00);
        } else {
            RB rb2 = this.A03;
            RB rb3 = RB.A06;
            String[] strArr = A04;
            if (strArr[0].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            A04[5] = "Wlqb3PCyph61UkVVxo7ng7VZa1hYfmo4";
            if (rb2 == rb3) {
                this.A02.A0L(J9.A0k);
                c1116Yn7 = this.A02.A0A;
                c1116Yn7.A0E().A30();
                this.A02.A03 = true;
                handler5 = this.A02.A07;
                handler5.removeCallbacksAndMessages(null);
                c04778r5 = this.A02.A0B;
                int i = this.A01;
                c04778r5.A02(new C9H(i, i));
                this.A02.A0K(this.A01);
            } else if (this.A03 == RB.A0A) {
                c1116Yn4 = this.A02.A0A;
                if (C0705Ih.A1W(c1116Yn4)) {
                    c1116Yn6 = this.A02.A0A;
                    c1116Yn6.A0A().ADg();
                }
                this.A02.A0L(J9.A0o);
                c1116Yn5 = this.A02.A0A;
                c1116Yn5.A0E().A3F();
                c04778r4 = this.A02.A0B;
                o8 = SA.A0H;
                c04778r4.A02(o8);
                handler4 = this.A02.A07;
                handler4.removeCallbacksAndMessages(null);
                this.A02.A0H();
            } else if (this.A03 == RB.A05) {
                this.A02.A0L(J9.A0n);
                c1116Yn3 = this.A02.A0A;
                c1116Yn3.A0E().A34();
                c04778r3 = this.A02.A0B;
                final int i5 = this.A00;
                c04778r3.A02(new AbstractC0894Pv(i5) { // from class: com.facebook.ads.redexgen.X.98
                });
                handler3 = this.A02.A07;
                handler3.removeCallbacksAndMessages(null);
                this.A02.A0K(this.A00);
            } else if (this.A03 == RB.A04) {
                this.A02.A0L(J9.A0m);
                c1116Yn2 = this.A02.A0A;
                c1116Yn2.A0E().A31();
                c04778r2 = this.A02.A0B;
                c0795Ma = SA.A0K;
                c04778r2.A02(c0795Ma);
                handler2 = this.A02.A07;
                handler2.removeCallbacksAndMessages(null);
            } else if (this.A03 == RB.A09) {
                this.A02.A0L(J9.A0k);
                c1116Yn = this.A02.A0A;
                c1116Yn.A0E().A3A();
                this.A02.A03 = true;
                handler = this.A02.A07;
                handler.removeCallbacksAndMessages(null);
                c04778r = this.A02.A0B;
                c04778r.A02(new C9H(this.A00, this.A01));
                this.A02.A0K(this.A00);
            }
        }
    }
}

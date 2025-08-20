package com.facebook.ads.redexgen.X;

import android.content.DialogInterface;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public class UZ extends KT {
    public static String[] A02 = {"r", "tRYI", "7UJuVMqBcP2QEoAe5I9ReZPElv0qEy55", "leQvAr8Bdm", "IrxDcEzjLLQBxw", "x58zC904VQqUCNnuzCjkyAfM", "58DZzAqOGTGaE", "1xO3"};
    public final /* synthetic */ DialogInterface A00;
    public final /* synthetic */ M1 A01;

    public UZ(M1 m12, DialogInterface dialogInterface) {
        this.A01 = m12;
        this.A00 = dialogInterface;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        RK rk;
        RK rk2;
        C1115Ym c1115Ym;
        Map<? extends String, ? extends String> A022;
        rk = this.A01.A01.A02;
        if (rk != null) {
            rk2 = this.A01.A01.A02;
            c1115Ym = this.A01.A01.A00;
            String A03 = K9.A03(c1115Ym);
            RY ry = new RY();
            A022 = this.A01.A01.A02(this.A01.A00.getText().toString());
            rk2.ADz(A03, ry.A05(A022).A08());
        }
        DialogInterface dialogInterface = this.A00;
        if (A02[6].length() != 13) {
            throw new RuntimeException();
        }
        A02[6] = "1hADnGgCLejuT";
        dialogInterface.cancel();
    }
}

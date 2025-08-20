package com.facebook.ads.redexgen.X;

import android.os.Handler;
/* loaded from: assets/audience_network.dex */
public final class FH extends AbstractC1004Ub<C1194ag> {
    public static String[] A00 = {"ByMq6MLqhjUJsdWB3RBIp", "zuOr3", "msyHKBX3wHVeYE5obxbctQprcgEzI02t", "I3sOgeRwcNYGF4oixOV5Q17", "dcB", "ibtCqc8qysdz0E5AMIDmPhuL1XZA", "mNtKCg4kzaH6sXUtb2oDuqx2", "ObFvkEusatMYzjWaq72f4FkWXHrQjerH"};

    public FH(C1194ag c1194ag) {
        super(c1194ag);
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        C1116Yn c1116Yn;
        Handler handler;
        Runnable runnable;
        C1194ag A07 = A07();
        if (A07 == null) {
            return;
        }
        c1116Yn = A07.A08;
        String[] strArr = A00;
        if (strArr[3].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        A00[5] = "SiVLKh";
        if (M5.A02(c1116Yn)) {
            A07.A07();
            return;
        }
        handler = A07.A05;
        runnable = A07.A0C;
        handler.postDelayed(runnable, 5000L);
    }
}

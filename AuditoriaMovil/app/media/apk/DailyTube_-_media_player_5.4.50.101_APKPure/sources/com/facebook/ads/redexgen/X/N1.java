package com.facebook.ads.redexgen.X;

import android.view.View;
/* loaded from: assets/audience_network.dex */
public class N1 implements View.OnClickListener {
    public static String[] A01 = {"KnJgliGO", "VwHKKtvbMk7FPKbBmIqapgeuC2T6fwds", "wENtEeepoPFkxQkEwI5qJp4A5OxzxToD", "COqx4q9kDUbjFrhSKPpHQyyB6JO5bBDL", "v63", "lzTgDb46XsVjhse8XoOOStoy8Mg7tCsc", "1yL2I4AIQTHR8fVHiYQ7c9e8uwPzvL3", "TX4RO1m5K"};
    public final /* synthetic */ U5 A00;

    public N1(U5 u5) {
        this.A00 = u5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A0B.A8P();
        } catch (Throwable th) {
            String[] strArr = A01;
            if (strArr[3].charAt(11) != strArr[5].charAt(11)) {
                throw new RuntimeException();
            }
            A01[0] = "zPAJp5EfhF2KrfBUqv";
            KL.A00(th, this);
        }
    }
}

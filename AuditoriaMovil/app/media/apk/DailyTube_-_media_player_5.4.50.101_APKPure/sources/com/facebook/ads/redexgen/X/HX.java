package com.facebook.ads.redexgen.X;

import android.os.ConditionVariable;
/* loaded from: assets/audience_network.dex */
public class HX extends Thread {
    public final /* synthetic */ ConditionVariable A00;
    public final /* synthetic */ C1034Vg A01;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HX(C1034Vg c1034Vg, String str, ConditionVariable conditionVariable) {
        super(str);
        this.A01 = c1034Vg;
        this.A00 = conditionVariable;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (KL.A02(this)) {
            return;
        }
        try {
            synchronized (this.A01) {
                this.A00.open();
                this.A01.A04();
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

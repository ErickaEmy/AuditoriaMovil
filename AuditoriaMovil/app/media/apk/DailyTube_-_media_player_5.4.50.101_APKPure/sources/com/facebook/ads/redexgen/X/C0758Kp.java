package com.facebook.ads.redexgen.X;

import android.app.Activity;
/* renamed from: com.facebook.ads.redexgen.X.Kp  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0758Kp {
    public static final C0758Kp A04 = new C0758Kp(new C1015Um(), new C1014Ul());
    public final InterfaceC0757Ko A02;
    public final InterfaceC0773Le A03;
    public boolean A01 = true;
    public long A00 = -1;

    public C0758Kp(InterfaceC0773Le interfaceC0773Le, InterfaceC0757Ko interfaceC0757Ko) {
        this.A03 = interfaceC0773Le;
        this.A02 = interfaceC0757Ko;
    }

    public static C0758Kp A00() {
        return A04;
    }

    public final synchronized void A01() {
        this.A01 = false;
        this.A00 = this.A03.A50();
    }

    public final synchronized void A02() {
        this.A00 = -1L;
    }

    public final boolean A03() {
        Activity lastResumedActivity = this.A02.A7G();
        boolean z2 = true;
        if (lastResumedActivity != null) {
            return true;
        }
        synchronized (C0758Kp.class) {
            if (this.A01) {
                return true;
            }
            if (this.A00 >= 0 && this.A03.A50() - this.A00 >= 1000) {
                z2 = false;
            }
            return z2;
        }
    }
}

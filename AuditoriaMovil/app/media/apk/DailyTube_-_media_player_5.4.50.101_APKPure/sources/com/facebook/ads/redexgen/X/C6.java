package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public abstract class C6 {
    public final C4 A00;

    public abstract void A0B(C0697Hz c0697Hz, long j2) throws C05059v;

    public abstract boolean A0C(C0697Hz c0697Hz) throws C05059v;

    public C6(C4 c4) {
        this.A00 = c4;
    }

    public final void A00(C0697Hz c0697Hz, long j2) throws C05059v {
        if (A0C(c0697Hz)) {
            A0B(c0697Hz, j2);
        }
    }
}

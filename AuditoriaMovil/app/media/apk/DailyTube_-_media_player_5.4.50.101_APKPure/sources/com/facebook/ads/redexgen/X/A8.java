package com.facebook.ads.redexgen.X;

import android.os.Handler;
/* loaded from: assets/audience_network.dex */
public final class A8 {
    public int A00;
    public int A01;
    public Handler A03;
    public Object A04;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public final A6 A0A;
    public final A7 A0B;
    public final AH A0C;
    public long A02 = -9223372036854775807L;
    public boolean A05 = true;

    public A8(A6 a6, A7 a72, AH ah, int i, Handler handler) {
        this.A0A = a6;
        this.A0B = a72;
        this.A0C = ah;
        this.A03 = handler;
        this.A01 = i;
    }

    public final int A00() {
        return this.A00;
    }

    public final int A01() {
        return this.A01;
    }

    public final long A02() {
        return this.A02;
    }

    public final Handler A03() {
        return this.A03;
    }

    public final A7 A04() {
        return this.A0B;
    }

    public final A8 A05() {
        AbstractC0672Ha.A04(!this.A09);
        if (this.A02 == -9223372036854775807L) {
            AbstractC0672Ha.A03(this.A05);
        }
        this.A09 = true;
        this.A0A.AFp(this);
        return this;
    }

    public final A8 A06(int i) {
        AbstractC0672Ha.A04(!this.A09);
        this.A00 = i;
        return this;
    }

    public final A8 A07(Object obj) {
        AbstractC0672Ha.A04(!this.A09);
        this.A04 = obj;
        return this;
    }

    public final AH A08() {
        return this.A0C;
    }

    public final Object A09() {
        return this.A04;
    }

    public final synchronized void A0A(boolean z2) {
        this.A07 |= z2;
        this.A08 = true;
        notifyAll();
    }

    public final boolean A0B() {
        return this.A05;
    }

    public final synchronized boolean A0C() throws InterruptedException {
        AbstractC0672Ha.A04(this.A09);
        AbstractC0672Ha.A04(this.A03.getLooper().getThread() != Thread.currentThread());
        while (!this.A08) {
            wait();
        }
        return this.A07;
    }

    public final synchronized boolean A0D() {
        return this.A06;
    }
}

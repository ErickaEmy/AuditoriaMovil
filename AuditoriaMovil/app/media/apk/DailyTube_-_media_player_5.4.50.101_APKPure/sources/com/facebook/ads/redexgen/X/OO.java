package com.facebook.ads.redexgen.X;

import android.view.View;
/* loaded from: assets/audience_network.dex */
public class OO {
    public boolean A00;
    public View A03;
    public V2 A04;
    public MB A05;
    public KP A06;
    public final View A07;
    public final AbstractC1219b5 A08;
    public final C1116Yn A09;
    public final J2 A0A;
    public final C0775Lg A0B;
    public final MC A0C;
    public final RE A0D;
    public int A02 = 0;
    public int A01 = 1;

    public OO(C1116Yn c1116Yn, J2 j2, MC mc2, AbstractC1219b5 abstractC1219b5, View view, RE re, C0775Lg c0775Lg) {
        this.A09 = c1116Yn;
        this.A0A = j2;
        this.A0C = mc2;
        this.A08 = abstractC1219b5;
        this.A07 = view;
        this.A0D = re;
        this.A0B = c0775Lg;
    }

    public final OO A0D(int i) {
        this.A01 = i;
        return this;
    }

    public final OO A0E(int i) {
        this.A02 = i;
        return this;
    }

    public final OO A0F(View view) {
        this.A03 = view;
        return this;
    }

    public final OO A0G(V2 v2) {
        this.A04 = v2;
        return this;
    }

    public final OO A0H(MB mb) {
        this.A05 = mb;
        return this;
    }

    public final OO A0I(KP kp2) {
        this.A06 = kp2;
        return this;
    }

    public final OO A0J(boolean z2) {
        this.A00 = z2;
        return this;
    }

    public final OP A0K() {
        return new OP(this);
    }
}

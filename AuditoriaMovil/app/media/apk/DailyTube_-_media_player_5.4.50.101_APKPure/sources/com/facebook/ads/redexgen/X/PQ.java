package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;
/* loaded from: assets/audience_network.dex */
public abstract class PQ extends RelativeLayout {
    public boolean A00;
    public final int A01;
    public final RD A02;
    public final boolean A03;
    public final boolean A04;
    public final AbstractC1219b5 A05;
    public final C1116Yn A06;
    public final J2 A07;
    public final C0775Lg A08;
    public final MC A09;
    public final InterfaceC0804Mj A0A;
    public final RE A0B;

    public abstract void A0z();

    public abstract void A10();

    public abstract void A11();

    public abstract void A12(boolean z2);

    public abstract void A13(boolean z2);

    public abstract boolean A14();

    public abstract boolean A15();

    public abstract C0875Pc getFullScreenAdStyle();

    public PQ(C1116Yn c1116Yn, InterfaceC0804Mj interfaceC0804Mj, J2 j2, AbstractC1219b5 abstractC1219b5, int i, boolean z2, boolean z3, MC mc2) {
        super(c1116Yn);
        this.A08 = new C0775Lg();
        this.A00 = false;
        TB tb = new TB(this);
        this.A02 = tb;
        this.A01 = i;
        this.A06 = c1116Yn;
        this.A04 = z2;
        this.A03 = z3;
        this.A09 = mc2;
        this.A0A = interfaceC0804Mj;
        this.A05 = abstractC1219b5;
        this.A07 = j2;
        RE re = new RE(this, 1, new WeakReference(tb), c1116Yn);
        this.A0B = re;
        re.A0W(abstractC1219b5.A0C());
        re.A0X(abstractC1219b5.A0D());
    }

    public final void A03() {
        if (!this.A00) {
            this.A0B.A0U();
            this.A00 = true;
        }
    }

    public AbstractC1219b5 getAdDataBundle() {
        return this.A05;
    }

    public RE getAdViewabilityChecker() {
        return this.A0B;
    }

    public C0775Lg getTouchDataRecorder() {
        return this.A08;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
}

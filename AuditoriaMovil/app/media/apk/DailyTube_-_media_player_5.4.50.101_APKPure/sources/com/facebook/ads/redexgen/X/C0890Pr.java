package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Pr  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0890Pr extends FrameLayout {
    public static final int A08 = (int) (LD.A02 * 16.0f);
    public BZ A00;
    public SF A01;
    public C9I A02;
    public C0765Kw A03;
    public C7R A04;
    public C7C A05;
    public final C1116Yn A06;
    public final JA A07;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final void A04(J2 j2, String str, Map<String, String> map) {
        A02();
        this.A02 = new C9I(this.A06, j2, this.A00, str, map);
        if (C0705Ih.A1X(this.A06)) {
            this.A01 = new SF(this.A06, j2, this.A00, str, this.A02, map);
        } else {
            this.A01 = null;
        }
    }

    public C0890Pr(C1116Yn c1116Yn, JA ja) {
        super(c1116Yn);
        this.A07 = ja;
        this.A06 = c1116Yn;
        setUpView(c1116Yn);
    }

    public final void A01() {
        this.A00.A0e(true, 10);
    }

    public final void A02() {
        SF sf = this.A01;
        if (sf != null) {
            sf.A0C();
            this.A01 = null;
        }
        C9I c9i = this.A02;
        if (c9i != null) {
            c9i.A0i();
            this.A02 = null;
        }
    }

    public final void A03(AbstractC04788s abstractC04788s) {
        this.A00.getEventBus().A05(abstractC04788s);
    }

    public final void A05(QM qm) {
        this.A00.A0b(qm, 13);
    }

    public final boolean A06() {
        return this.A00.A0k();
    }

    public SA getSimpleVideoView() {
        return this.A00;
    }

    public float getVolume() {
        return this.A00.getVolume();
    }

    public void setPlaceholderUrl(String str) {
        this.A04.setImage(str);
    }

    private void setUpPlugins(C1116Yn c1116Yn) {
        this.A00.A0X();
        C7R c7r = new C7R(c1116Yn);
        this.A04 = c7r;
        this.A00.A0c(c7r);
        this.A03 = new C0765Kw(c1116Yn, this.A07);
        this.A00.A0c(new AnonymousClass86(c1116Yn));
        this.A00.A0c(this.A03);
        C7C c7c = new C7C(c1116Yn, true, this.A07);
        this.A05 = c7c;
        this.A00.A0c(c7c);
        this.A00.A0c(new L7(this.A05, QZ.A03, true, true));
        if (!this.A00.A0g()) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        int i = A08;
        layoutParams.setMargins(i, i, i, i);
        this.A03.setLayoutParams(layoutParams);
        this.A00.addView(this.A03);
    }

    private void setUpVideo(C1116Yn c1116Yn) {
        BZ bz = new BZ(c1116Yn);
        this.A00 = bz;
        bz.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        AbstractC0783Lo.A0K(this.A00);
        addView(this.A00);
        setOnClickListener(new View$OnClickListenerC0889Pq(this));
    }

    private void setUpView(C1116Yn c1116Yn) {
        setUpVideo(c1116Yn);
        setUpPlugins(c1116Yn);
    }

    public void setVideoURI(String str) {
        this.A00.setVideoURI(str);
    }

    public void setVolume(float f4) {
        this.A00.setVolume(f4);
        this.A03.A09();
    }
}

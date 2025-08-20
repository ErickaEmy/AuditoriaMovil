package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.9Y  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C9Y extends AbstractC0969Ss {
    public OL A00;
    public final ImageView A01;
    public final C5T A02;
    public final AtomicBoolean A03;
    public final AtomicBoolean A04;
    public final AtomicBoolean A05;

    public C9Y(C1116Yn c1116Yn, InterfaceC0804Mj interfaceC0804Mj, J2 j2, AbstractC1219b5 abstractC1219b5, C04216c c04216c, MC mc2) {
        super(c1116Yn, interfaceC0804Mj, j2, abstractC1219b5, c04216c, mc2);
        this.A02 = new C0964Sn(this);
        this.A04 = new AtomicBoolean(false);
        this.A03 = new AtomicBoolean(false);
        this.A05 = new AtomicBoolean(false);
        ImageView imageView = new ImageView(getContext());
        this.A01 = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setAdjustViewBounds(true);
        new AsyncTaskC0993Tq(imageView, super.A03).A05(super.A01.A0x().A0D().A00(), super.A01.A0x().A0D().A01()).A06(new C0963Sm(this)).A07(super.A01.A0x().A0D().A07());
    }

    private OL A01(int i) {
        if (this.A01.getParent() != null) {
            AbstractC0783Lo.A0J(this.A01);
        }
        return OM.A00(new OO(super.A03, super.A04, this.A08, super.A01, this.A01, this.A0A, this.A06).A0E(this.A07.getToolbarHeight()).A0H(this.A07).A0D(i).A0K(), null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05() {
        if (this.A04.get() && this.A03.get()) {
            A0P();
        }
    }

    private void A06(int i) {
        AbstractC0783Lo.A0J(this.A00);
        OL A01 = A01(i);
        this.A00 = A01;
        C1P colors = A01.getColors();
        OL ol = this.A00;
        boolean z2 = true;
        AbstractC0783Lo.A0M(this, colors.A07(ol != null && (ol.A11() || (this.A00 instanceof AbstractC0983Tg))));
        this.A07.setFullscreen(this.A00.A11());
        this.A07.A06(colors, View$OnClickListenerC0988Tl.A08(super.A01));
        addView(this.A00, 0, AbstractC0969Ss.A0E);
        OL ol2 = this.A00;
        setUpFullscreenMode((ol2 == null || !ol2.A11()) ? false : false);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0969Ss
    public final void A0Q() {
        AbstractC0783Lo.A0L(this.A00);
        AbstractC0783Lo.A0L(this.A07);
        this.A03.set(true);
        A05();
        int A03 = super.A01.A0x().A0D().A03();
        if (A03 > 0) {
            OL ol = this.A00;
            if (ol != null) {
                ol.A0z();
            }
            A0R(A03, new C0962Sl(this));
            return;
        }
        this.A05.set(true);
        MB mb = this.A07;
        int unskippableSeconds = getCloseButtonStyle();
        mb.setToolbarActionMode(unskippableSeconds);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0969Ss
    public final void A0S(C5V c5v) {
        c5v.A0N(this.A02);
        int orientation = c5v.A0J().getResources().getConfiguration().orientation;
        A06(orientation);
        addView(this.A07, new FrameLayout.LayoutParams(-1, this.A07.getToolbarHeight()));
        AbstractC0783Lo.A0H(this.A00);
        AbstractC0783Lo.A0H(this.A07);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0969Ss
    public final boolean A0T() {
        OL ol = this.A00;
        return ol != null && ol.A12(false);
    }

    @Override // com.facebook.ads.redexgen.X.MD
    public final void ACW(boolean z2) {
    }

    @Override // com.facebook.ads.redexgen.X.MD
    public final void ACu(boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCloseButtonStyle() {
        OL ol = this.A00;
        if (ol != null) {
            return ol.getCloseButtonStyle();
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0969Ss, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!super.A01.A0x().A0N()) {
            A06(configuration.orientation);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0969Ss, com.facebook.ads.redexgen.X.MD
    public final void onDestroy() {
        if (C0705Ih.A1W(super.A03)) {
            super.A03.A0A().AGk(this.A01);
        }
        OL ol = this.A00;
        if (ol != null) {
            ol.A0v();
        }
        super.onDestroy();
    }
}

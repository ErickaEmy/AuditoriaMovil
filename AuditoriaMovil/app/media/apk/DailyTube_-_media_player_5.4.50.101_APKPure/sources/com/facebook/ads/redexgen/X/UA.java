package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class UA implements MD {
    public static byte[] A0D;
    public int A00;
    public SF A01;
    public C9I A02;
    public String A03;
    public final C1116Yn A04;
    public final J2 A05;
    public final MC A06;
    public final InterfaceC0799Me A07;
    public final SA A08;
    public final AbstractC0893Pu A09;
    public final AbstractC0891Ps A0A;
    public final AbstractC0860On A0B;
    public final O7 A0C;

    static {
        A03();
    }

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 38);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A0D = new byte[]{-49, -29, -30, -35, -34, -38, -49, -25, -17, -8, -11, -15, -6, 0, -32, -5, -9, -15, -6, -68, -70, -84, -107, -88, -69, -80, -67, -84, -118, -69, -88, -119, -68, -69, -69, -74, -75, -73, -86, -91, -90, -80, -118, -81, -75, -90, -77, -76, -75, -86, -75, -94, -83, -122, -73, -90, -81, -75, -99, -112, -117, -116, -106, 115, -106, -114, -114, -116, -103, -2, -15, -20, -19, -9, -43, -40, -52, 24, 11, 6, 7, 17, -11, 7, 7, 13, -10, 11, 15, 7, -66, -79, -84, -83, -73, -99, -102, -108};
    }

    public UA(C1116Yn c1116Yn, InterfaceC0799Me interfaceC0799Me, J2 j2, MC mc2) {
        BU bu = new BU(this);
        this.A0C = bu;
        BT bt = new BT(this);
        this.A0B = bt;
        BS bs = new BS(this);
        this.A09 = bs;
        BR br2 = new BR(this);
        this.A0A = br2;
        this.A04 = c1116Yn;
        this.A05 = j2;
        this.A07 = interfaceC0799Me;
        SA sa = new SA(c1116Yn);
        this.A08 = sa;
        sa.A0c(new AnonymousClass86(c1116Yn));
        sa.getEventBus().A03(bu, bt, bs, br2);
        this.A06 = mc2;
        sa.setIsFullScreen(true);
        sa.setVolume(1.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        mc2.A3U(sa, layoutParams);
        MK closeButton = new MK(c1116Yn);
        closeButton.setOnClickListener(new View$OnClickListenerC0797Mc(this));
        RelativeLayout.LayoutParams params = closeButton.getDefaultLayoutParams();
        mc2.A3U(closeButton, params);
    }

    public final void A04(int i) {
        this.A08.setVideoProgressReportIntervalMs(i);
    }

    public final void A05(View view) {
        this.A08.setControlsAnchorView(view);
    }

    @Override // com.facebook.ads.redexgen.X.MD
    public final void A9Q(Intent intent, Bundle bundle, C5V c5v) {
        String ctaText = A02(8, 11, 102);
        if (bundle == null) {
            this.A03 = intent.getStringExtra(ctaText);
        } else {
            this.A03 = bundle.getString(ctaText);
        }
        String stringExtra = intent.getStringExtra(A02(19, 18, 33));
        if (stringExtra != null && !stringExtra.isEmpty()) {
            C0886Pn c0886Pn = new C0886Pn(this.A04, stringExtra);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int i = (int) (16.0f * LD.A02);
            layoutParams.setMargins(i, i, i, i);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            c0886Pn.setOnClickListener(new View$OnClickListenerC0798Md(this));
            this.A06.A3U(c0886Pn, layoutParams);
        }
        this.A00 = intent.getIntExtra(A02(77, 13, 124), 0);
        this.A02 = new C9I(this.A04, this.A05, this.A08, this.A03, intent.getBundleExtra(A02(58, 11, 1)));
        if (C0705Ih.A1X(this.A04)) {
            this.A01 = new SF(this.A04, this.A05, this.A08, this.A03, this.A02, null);
        } else {
            this.A01 = null;
        }
        this.A08.setVideoMPD(intent.getStringExtra(A02(69, 8, 98)));
        this.A08.setVideoURI(intent.getStringExtra(A02(90, 8, 34)));
        int i5 = this.A00;
        if (i5 > 0) {
            this.A08.A0Y(i5);
        }
        if (intent.getBooleanExtra(A02(0, 8, 72), false)) {
            this.A08.A0b(QM.A04, 17);
        }
    }

    @Override // com.facebook.ads.redexgen.X.MD
    public final void ACW(boolean z2) {
        this.A06.A44(A02(37, 21, 27), new C0883Pk());
        this.A08.A0W();
    }

    @Override // com.facebook.ads.redexgen.X.MD
    public final void ACu(boolean z2) {
        this.A06.A44(A02(37, 21, 27), new P5());
        if (!this.A08.A0j()) {
            this.A08.A0b(QM.A04, 18);
        }
    }

    @Override // com.facebook.ads.redexgen.X.MD
    public final void AFT(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.X.MD
    public final String getCurrentClientToken() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.MD
    public final boolean onActivityResult(int i, int i5, Intent intent) {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.MD
    public final void onDestroy() {
        this.A06.A44(A02(37, 21, 27), new C0812Mr(this.A00, this.A08.getCurrentPositionInMillis()));
        this.A02.A0e(this.A08.getCurrentPositionInMillis());
        SF sf = this.A01;
        if (sf != null) {
            sf.A0D();
        }
        this.A08.A0Z(1);
        this.A08.A0V();
    }
}

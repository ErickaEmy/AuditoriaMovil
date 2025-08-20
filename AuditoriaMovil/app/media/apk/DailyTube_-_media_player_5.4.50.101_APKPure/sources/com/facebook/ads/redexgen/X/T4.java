package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class T4 extends PQ {
    public static byte[] A0W;
    public static String[] A0X = {"zF", "YuhgBsbCJ4GENG72FYuTSQ3UxVCmrs0t", "RSfzcHToFNO8jc1tX2m0S0AZ0vbf9kKl", "p", "lGjhRdALEILVIUsiuWCm6MXJK2R8L6Co", "wXQvDYR5huLQKlTsBS5mG0rN7ygrQvR2", "AYgBJnzxyMi9rrwHO3oB8yOhTSWVLxNu", "3k2Jytm7iEKA6X2jmmGhgFSNDYaf4AHR"};
    public static final int A0Y;
    public static final int A0Z;
    public static final int A0a;
    public static final int A0b;
    public static final int A0c;
    public static final int A0d;
    public static final int A0e;
    public static final int A0f;
    public static final int A0g;
    public static final int A0h;
    public C1P A00;
    public L9 A01;
    public QM A02;
    public KI A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public final int A08;
    public final int A09;
    public final int A0A;
    public final int A0B;
    public final C1116Yn A0C;
    public final AbstractC0835No A0D;
    public final View$OnClickListenerC0988Tl A0E;
    public final InterfaceC0876Pd A0F;
    public final Q5 A0G;
    public final SF A0H;
    public final SA A0I;
    public final C9I A0J;
    public final AbstractC0893Pu A0K;
    public final AbstractC0891Ps A0L;
    public final AbstractC0860On A0M;
    public final O7 A0N;
    public final NX A0O;
    public final NQ A0P;
    public final LX A0Q;
    public final C0765Kw A0R;
    public final KP A0S;
    public final KA A0T;
    public final boolean A0U;
    public final boolean A0V;

    public static String A08(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0W, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 44);
        }
        return new String(copyOfRange);
    }

    public static void A0D() {
        A0W = new byte[]{-55, -43, -45, -108, -52, -57, -55, -53, -56, -43, -43, -47, -108, -57, -54, -39, -108, -49, -44, -38, -53, -40, -39, -38, -49, -38, -49, -57, -46, -108, -55, -46, -49, -55, -47, -53, -54, 27, 14, 32, 10, 27, 13, 14, 13, 8, 31, 18, 13, 14, 24};
    }

    static {
        A0D();
        A0b = (int) (LD.A02 * 48.0f);
        int A01 = AbstractC03322p.A01(-1, 77);
        A0Z = A01;
        A0g = (int) (LD.A02 * 26.0f);
        A0h = (int) (LD.A02 * 12.0f);
        A0d = (int) (LD.A02 * 12.0f);
        A0e = (int) (LD.A02 * 44.0f);
        A0c = (int) (LD.A02 * 8.0f);
        A0f = (int) (LD.A02 * 16.0f);
        A0a = AbstractC03322p.A01(A01, 90);
        A0Y = (int) (LD.A02 * 4.0f);
    }

    public T4(C1116Yn c1116Yn, J2 j2, AbstractC1219b5 abstractC1219b5, C04216c c04216c, InterfaceC0804Mj interfaceC0804Mj, int i, MC mc2, JA ja, int i5, int i6, int i8, boolean z2, int i10, boolean z3, boolean z4, boolean z5, InterfaceC0876Pd interfaceC0876Pd) {
        super(c1116Yn, interfaceC0804Mj, j2, abstractC1219b5, i, z4, z5, mc2);
        C1P A00;
        this.A04 = false;
        this.A05 = false;
        this.A07 = false;
        AV av = new AV(this);
        this.A0O = av;
        AO ao2 = new AO(this);
        this.A0N = ao2;
        A9 a92 = new A9(this);
        this.A0M = a92;
        A4 a4 = new A4(this);
        this.A0P = a4;
        A3 a3 = new A3(this);
        this.A0K = a3;
        A2 a2 = new A2(this);
        this.A0L = a2;
        this.A0C = c1116Yn;
        this.A0R = new C0765Kw(c1116Yn, ja);
        this.A0S = new KP(c1116Yn);
        this.A0A = i10;
        this.A0V = z3;
        this.A09 = i5;
        this.A0B = i6;
        this.A0F = interfaceC0876Pd;
        this.A08 = i8;
        this.A0U = z2;
        this.A0G = new Q5(c1116Yn, j2, super.A05);
        if (i6 == 1) {
            A00 = super.A05.A0w().A01();
        } else {
            A00 = super.A05.A0w().A00();
        }
        this.A00 = A00;
        SA sa = new SA(c1116Yn);
        this.A0I = sa;
        sa.getEventBus().A03(av, ao2, a92, a4, a3, a2);
        C9I c9i = new C9I(c1116Yn, j2, sa, abstractC1219b5.A12());
        this.A0J = c9i;
        A0C();
        sa.setVideoURI(c04216c.A0S(super.A05.A0x().A0D().A08()));
        A0B();
        C0984Th A05 = A05();
        this.A0D = A05;
        KA ka = new KA(A05, 400, 100, 0);
        this.A0T = ka;
        ka.A3Y(true, false);
        this.A0Q = new LX(true);
        A0E();
        View$OnClickListenerC0988Tl cTAButton = A05.getCTAButton();
        this.A0E = cTAButton;
        AbstractC0783Lo.A0G(1001, cTAButton);
        A0A();
        A09();
        A05.bringToFront();
        if (C0705Ih.A1W(c1116Yn)) {
            c1116Yn.A0A().AGv(sa, super.A05.A12(), true);
        }
        if (C0705Ih.A1X(c1116Yn)) {
            this.A0H = new SF(c1116Yn, j2, sa, super.A05.A12(), c9i, null);
        } else {
            this.A0H = null;
        }
    }

    private C0984Th A05() {
        String A08;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (super.A05.A0P().equals(A08(37, 14, 125))) {
            A08 = QP.A04.A02();
        } else {
            A08 = A08(0, 37, 58);
        }
        C0984Th c0984Th = new C0984Th(this.A0C, A0b, super.A05.A0x().A0E().A00() == C1L.A05, getColors(), super.A05.A0x().A0F().A06(), A08, super.A07, super.A09, super.A0B, super.A08, super.A05.A0y());
        AbstractC0783Lo.A0G(1008, c0984Th);
        c0984Th.A0A(this.A0B);
        addView(c0984Th, layoutParams);
        c0984Th.setInfo(super.A05.A0x().A0E(), super.A05.A0x().A0F(), super.A05.A12(), super.A05.A10().A01(), null);
        return c0984Th;
    }

    private void A09() {
        this.A0S.A06(-1, A0Z);
        KP kp2 = this.A0S;
        int i = A0h;
        kp2.setPadding(i, i, i, i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, A0g);
        layoutParams.addRule(12);
        addView(this.A0S, layoutParams);
    }

    private void A0A() {
        C0765Kw c0765Kw = this.A0R;
        int i = A0d;
        c0765Kw.setPadding(i, i, i, i);
        int i5 = A0e;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i5);
        layoutParams.setMargins(0, MB.A00, A0c, 0);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        RelativeLayout.LayoutParams videoViewParams = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.A0I, videoViewParams);
        addView(this.A0R, layoutParams);
    }

    private void A0B() {
        postDelayed(new T7(this), C0705Ih.A0L(this.A0C));
    }

    private void A0C() {
        this.A0I.A0c(this.A0S);
        this.A0I.A0c(this.A0R);
        if (!TextUtils.isEmpty(super.A05.A0x().A0D().A07())) {
            C7R c7r = new C7R(this.A0C);
            this.A0I.A0c(c7r);
            c7r.setImage(super.A05.A0x().A0D().A07());
        }
        this.A0I.A0c(new C7H(this.A0C));
    }

    private final void A0E() {
        View expandableLayout = this.A0D.getExpandableLayout();
        if (expandableLayout != null) {
            KI ki = this.A03;
            if (ki != null) {
                this.A0Q.A0I(ki);
            }
            C1P A01 = super.A05.A0w().A01();
            this.A0Q.A0I(new KC(this.A0D.getCTAButton(), 300, -1, A01.A09(true)));
            int i = A0Z;
            int i5 = A0a;
            int i6 = A0Y;
            Drawable A08 = AbstractC0783Lo.A08(i, i5, i6);
            Drawable endDrawable = AbstractC0783Lo.A05(A01.A08(true), i6);
            this.A0Q.A0I(new KM(this.A0D.getCTAButton(), 300, A08, endDrawable));
            this.A0Q.A0I(new KF(expandableLayout, 150, false));
            this.A0Q.A9R(this.A0I);
            this.A0Q.A0H(2300);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0G(AnonymousClass93 anonymousClass93) {
        if (this.A0I.getState() == RB.A02 && C0705Ih.A1D(this.A0C)) {
            postDelayed(new T6(this, anonymousClass93), 5000L);
        }
    }

    @Override // com.facebook.ads.redexgen.X.PQ
    public final void A0z() {
        L9 l92 = this.A01;
        if (l92 != null) {
            l92.A06();
        }
        if (C0705Ih.A1W(this.A0C)) {
            this.A0C.A0A().AGk(this.A0I);
        }
        SF sf = this.A0H;
        if (sf != null) {
            sf.A0C();
        }
        SA sa = this.A0I;
        if (sa != null) {
            sa.getEventBus().A04(this.A0O, this.A0N, this.A0M, this.A0P, this.A0K, this.A0L);
            AbstractC0783Lo.A0H(this.A0I);
            this.A0I.A0V();
        }
        this.A0J.A0i();
        View[] viewArr = new View[3];
        viewArr[0] = this.A0I;
        KP kp2 = this.A0S;
        String[] strArr = A0X;
        if (strArr[0].length() == strArr[3].length()) {
            throw new RuntimeException();
        }
        A0X[2] = "4e1dr9g4n9kT22ZIdoKy0n8REVoGbgbF";
        viewArr[1] = kp2;
        viewArr[2] = this.A0R;
        AbstractC0783Lo.A0a(viewArr);
        super.A0B.A0V();
    }

    @Override // com.facebook.ads.redexgen.X.PQ
    public final void A10() {
        this.A0C.A0E().A4F();
        this.A04 = true;
        AbstractC0783Lo.A0T(this);
        AbstractC0783Lo.A0H(this.A0I);
        AbstractC0783Lo.A0a(this.A0I, this.A0S, this.A0R);
        Pair<Q4, View> A03 = this.A0G.A03(this.A0E);
        View view = (View) A03.second;
        AbstractC0783Lo.A0G(1101, view);
        switch (PR.A00[((Q4) A03.first).ordinal()]) {
            case 1:
                this.A0D.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.setMargins(0, MB.A00, 0, 0);
                layoutParams.addRule(2, this.A0D.getId());
                addView(view, layoutParams);
                break;
            case 2:
                AbstractC0783Lo.A0a(this.A0D);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                int i = A0f;
                layoutParams2.setMargins(i, i, i, i);
                addView(view, layoutParams2);
                break;
        }
        if (this.A08 == 0 && this.A0U) {
            if (this.A0V) {
                this.A0F.AGq();
            }
            L9 l92 = new L9(this.A0A, 100.0f, 100L, new Handler(Looper.getMainLooper()), new T5(this));
            this.A01 = l92;
            l92.A07();
            return;
        }
        this.A05 = true;
        this.A0F.AD7(true);
    }

    @Override // com.facebook.ads.redexgen.X.PQ
    public final void A11() {
        this.A0I.setVolume(super.A05.A0x().A0D().A09() ? 0.0f : 1.0f);
        this.A0I.A0b(QM.A02, 20);
    }

    @Override // com.facebook.ads.redexgen.X.PQ
    public final void A12(boolean z2) {
        L9 l92 = this.A01;
        if (l92 != null) {
            l92.A06();
        }
        if (this.A0I.A0i()) {
            return;
        }
        this.A02 = this.A0I.getVideoStartReason();
        this.A06 = z2;
        this.A0I.A0e(false, 13);
    }

    @Override // com.facebook.ads.redexgen.X.PQ
    public final void A13(boolean z2) {
        QM qm;
        L9 l92 = this.A01;
        if (l92 != null && !l92.A05()) {
            L9 l93 = this.A01;
            if (A0X[5].charAt(17) != 'S') {
                throw new RuntimeException();
            }
            String[] strArr = A0X;
            strArr[7] = "pObqmm4LdTsqTcUgL7kozPbufRCkwYZC";
            strArr[6] = "5szeP9lNqMFVM0rzjOQcuK8NUDwg7u3G";
            l93.A07();
        }
        if (this.A04 || this.A0I.getState() == RB.A06 || (qm = this.A02) == null) {
            return;
        }
        if (!this.A06 || z2) {
            this.A0I.A0b(qm, 19);
        }
    }

    @Override // com.facebook.ads.redexgen.X.PQ
    public final boolean A14() {
        if (this.A08 != 2 && super.A05.A0x().A0O() && !this.A04) {
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.PQ
    public final boolean A15() {
        return this.A04;
    }

    public C1P getColors() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.PQ
    public C0875Pc getFullScreenAdStyle() {
        return new C0875Pc(true, C0875Pc.A06, super.A05.A0w().A01(), View$OnClickListenerC0988Tl.A08(super.A05), super.A05.A0w().A01().A07(true), super.A05.A0x().A0D().A07());
    }

    @Override // com.facebook.ads.redexgen.X.PQ
    public C0775Lg getTouchDataRecorder() {
        return super.A08;
    }

    @Override // com.facebook.ads.redexgen.X.PQ, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        C1P A00;
        super.onConfigurationChanged(configuration);
        if (!this.A04) {
            if (configuration.orientation == 1) {
                A00 = super.A05.A0w().A01();
            } else {
                C1C A0w = super.A05.A0w();
                if (A0X[4].charAt(4) != 'R') {
                    throw new RuntimeException();
                }
                A0X[1] = "uYIsd2DhsQ91Wp0xmXJ9348eeMLtSRMf";
                A00 = A0w.A00();
            }
            this.A00 = A00;
            this.A0E.setViewShowsOverMedia(true);
            this.A0E.setUpButtonColors(this.A00);
            this.A0D.A0A(configuration.orientation);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        super.onLayout(z2, i, i5, i6, i8);
        View expandableLayout = this.A0D.getExpandableLayout();
        if (expandableLayout != null && z2 && this.A03 == null) {
            KI ki = new KI(expandableLayout, 300, expandableLayout.getHeight(), 0);
            this.A03 = ki;
            this.A0Q.A0I(ki);
            this.A0Q.A0G();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            A13(false);
        } else {
            A12(false);
        }
    }
}

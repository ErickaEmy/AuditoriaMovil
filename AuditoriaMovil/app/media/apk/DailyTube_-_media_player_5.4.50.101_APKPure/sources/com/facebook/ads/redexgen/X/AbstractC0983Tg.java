package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Tg  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0983Tg extends OL implements OE {
    public static byte[] A08;
    public static String[] A09 = {"1qM0UqBuKeNFs4931PZdKXfB5ZchECK5", "3ZSmcCEAG5Dz0dWrJNlp2MNszP7YT25A", "Vrvau7r1HMpQKQXhvyVkTfJZAsfHOW4A", "oVRoE2FdK0le1s2SfNIozg00Kc9sH4MP", "npYoVlwUwM4clRwIxvjz9nauDkw8jySV", "7Yuh663Y", "kkRlGGIMUj7iwn7pYEfT9Vq54HRzcbQk", "UynwTjbvMY6JmtelA"};
    public static final int A0A;
    public static final int A0B;
    public static final int A0C;
    public static final int A0D;
    public static final int A0E;
    public static final int A0F;
    public static final int A0G;
    public static final int A0H;
    public static final int A0I;
    public static final int A0J;
    public LX A00;
    public KI A01;
    public KA A02;
    public final AbstractC1219b5 A03;
    public final C1G A04;
    public final MC A05;
    public final AbstractC0835No A06;
    public final OG A07;

    public static String A0C(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 22);
        }
        return new String(copyOfRange);
    }

    public static void A0D() {
        A08 = new byte[]{9, 5, 7, 68, 12, 11, 9, 15, 8, 5, 5, 1, 68, 11, 14, 25, 68, 3, 4, 30, 15, 24, 25, 30, 3, 30, 3, 11, 6, 68, 9, 6, 3, 9, 1, 15, 14, 92, 75, 89, 79, 92, 74, 75, 74, 113, 88, 71, 74, 75, 65};
    }

    static {
        A0D();
        A0D = (int) (LD.A02 * 48.0f);
        A0H = (int) (LD.A02 * 16.0f);
        A0A = (int) (LD.A02 * 4.0f);
        A0G = (int) (LD.A02 * 44.0f);
        A0E = (int) (LD.A02 * 8.0f);
        A0F = (int) (LD.A02 * 12.0f);
        A0J = (int) (LD.A02 * 12.0f);
        A0I = (int) (LD.A02 * 26.0f);
        int A01 = AbstractC03322p.A01(-1, 77);
        A0B = A01;
        A0C = AbstractC03322p.A01(A01, 90);
    }

    public AbstractC0983Tg(OP op, boolean z2) {
        super(op, z2);
        AbstractC1219b5 A04 = op.A04();
        this.A03 = A04;
        this.A07 = OG.A01(op.A05(), A04, this);
        this.A04 = A04.A0x();
        this.A06 = A0B(op);
        MB A082 = op.A08();
        this.A05 = op.A09();
        if (A082 != null) {
            A082.setLayoutParams(new RelativeLayout.LayoutParams(-1, A082.getToolbarHeight()));
            A082.setPageDetailsVisible(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.facebook.ads.redexgen.X.C0984Th A0B(com.facebook.ads.redexgen.X.OP r19) {
        /*
            r18 = this;
            r3 = r18
            r1 = -1
            r0 = -2
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            r2.<init>(r1, r0)
            r0 = 12
            r2.addRule(r0)
            com.facebook.ads.redexgen.X.b5 r0 = r19.A04()
            java.lang.String r5 = r0.A0P()
            r4 = 37
            r1 = 14
            r0 = 56
            java.lang.String r0 = A0C(r4, r1, r0)
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lcc
            com.facebook.ads.redexgen.X.QP r5 = com.facebook.ads.redexgen.X.QP.A04
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.AbstractC0983Tg.A09
            r0 = 7
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 22
            if (r1 == r0) goto Lea
            java.lang.String[] r4 = com.facebook.ads.redexgen.X.AbstractC0983Tg.A09
            java.lang.String r1 = "Ca3psE1IPVUhCMreDaAATfbsplsRsoNT"
            r0 = 6
            r4[r0] = r1
            java.lang.String r1 = "q1VyT2b1NhDnFBLs9y9UP0y4iho0jP8D"
            r0 = 1
            r4[r0] = r1
            java.lang.String r12 = r5.A02()
        L45:
            com.facebook.ads.redexgen.X.Th r6 = new com.facebook.ads.redexgen.X.Th
            com.facebook.ads.redexgen.X.Yn r7 = r19.A05()
            int r8 = com.facebook.ads.redexgen.X.AbstractC0983Tg.A0D
            com.facebook.ads.redexgen.X.1G r0 = r3.A04
            com.facebook.ads.redexgen.X.1N r0 = r0.A0E()
            com.facebook.ads.redexgen.X.1L r4 = r0.A00()
            com.facebook.ads.redexgen.X.1L r0 = com.facebook.ads.redexgen.X.C1L.A05
            r1 = 0
            if (r4 != r0) goto Lca
            r9 = 1
        L5d:
            com.facebook.ads.redexgen.X.1P r10 = r18.getColors()
            com.facebook.ads.redexgen.X.1G r0 = r3.A04
            com.facebook.ads.redexgen.X.1Q r0 = r0.A0F()
            boolean r11 = r0.A06()
            com.facebook.ads.redexgen.X.J2 r13 = r19.A06()
            com.facebook.ads.redexgen.X.MC r14 = r19.A09()
            com.facebook.ads.redexgen.X.RE r15 = r19.A0B()
            com.facebook.ads.redexgen.X.Lg r16 = r19.A07()
            com.facebook.ads.redexgen.X.b5 r0 = r19.A04()
            com.facebook.ads.redexgen.X.1U r17 = r0.A0y()
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r5 = 400(0x190, float:5.6E-43)
            r4 = 100
            com.facebook.ads.redexgen.X.KA r0 = new com.facebook.ads.redexgen.X.KA
            r0.<init>(r6, r5, r4, r1)
            r3.A02 = r0
            com.facebook.ads.redexgen.X.AbstractC0783Lo.A0K(r6)
            int r0 = r19.A00()
            r6.A0A(r0)
            com.facebook.ads.redexgen.X.Yn r0 = r19.A05()
            boolean r0 = com.facebook.ads.redexgen.X.C0705Ih.A0y(r0)
            if (r0 == 0) goto Lb9
            r6.A09()
            com.facebook.ads.redexgen.X.MB r0 = r19.A08()
            if (r0 == 0) goto Lb9
            com.facebook.ads.redexgen.X.MB r1 = r19.A08()
            com.facebook.ads.redexgen.X.Tl r0 = r18.getCtaButton()
            r1.setCTAClickListener(r0)
        Lb9:
            r3.addView(r6, r2)
            com.facebook.ads.redexgen.X.Tl r2 = r6.getCTAButton()
            com.facebook.ads.redexgen.X.b5 r1 = r3.A03
            com.facebook.ads.redexgen.X.MB r0 = r19.A08()
            r2.A0A(r1, r0)
            return r6
        Lca:
            r9 = 0
            goto L5d
        Lcc:
            r7 = 0
            r6 = 37
            r5 = 124(0x7c, float:1.74E-43)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.AbstractC0983Tg.A09
            r0 = 5
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 7
            if (r1 == r0) goto Lea
            java.lang.String[] r4 = com.facebook.ads.redexgen.X.AbstractC0983Tg.A09
            java.lang.String r1 = "aLegEIjbGKC4WYI41vdDU1g9u"
            r0 = 7
            r4[r0] = r1
            java.lang.String r12 = A0C(r7, r6, r5)
            goto L45
        Lea:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0983Tg.A0B(com.facebook.ads.redexgen.X.OP):com.facebook.ads.redexgen.X.Th");
    }

    @Override // com.facebook.ads.redexgen.X.OL
    public void A0v() {
        super.A0v();
        this.A07.A0A();
    }

    @Override // com.facebook.ads.redexgen.X.OL
    public void A10(C1G c1g, String str, double d2, Bundle bundle) {
        super.A10(c1g, str, d2, bundle);
        this.A06.setInfo(c1g.A0E(), c1g.A0F(), str, this.A03.A10().A01(), null);
    }

    public final int A13(MB mb) {
        return mb == null ? MB.A00 : mb.getToolbarHeight();
    }

    public void A14() {
        View expandableLayout = getAdDetailsView().getExpandableLayout();
        if (expandableLayout != null) {
            LX lx = new LX(true);
            this.A00 = lx;
            KI ki = this.A01;
            if (ki != null) {
                lx.A0I(ki);
            }
            C1P A01 = this.A03.A0w().A01();
            this.A00.A0I(new KC(getAdDetailsView().getCTAButton(), 300, -1, A01.A09(true)));
            int i = A0B;
            int i5 = A0C;
            int i6 = A0A;
            Drawable A082 = AbstractC0783Lo.A08(i, i5, i6);
            Drawable startDrawable = AbstractC0783Lo.A05(A01.A08(true), i6);
            this.A00.A0I(new KM(getAdDetailsView().getCTAButton(), 300, A082, startDrawable));
            this.A00.A0I(new KF(expandableLayout, 150, false));
            this.A00.A0H(2300);
        }
    }

    @Override // com.facebook.ads.redexgen.X.OE
    public final void AC9() {
        this.A05.A43(getAdDataBundle().A0L());
    }

    public AbstractC1219b5 getAdDataBundle() {
        return this.A03;
    }

    public KA getAdDetailsAnimation() {
        return this.A02;
    }

    public AbstractC0835No getAdDetailsView() {
        return this.A06;
    }

    public C1G getAdInfo() {
        return this.A04;
    }

    public LX getAnimationPlugin() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.OL, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getAdDetailsView().A0A(configuration.orientation);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        super.onLayout(z2, i, i5, i6, i8);
        View expandableLayout = getAdDetailsView().getExpandableLayout();
        if (expandableLayout == null || !z2) {
            return;
        }
        KI ki = this.A01;
        if (A09[2].charAt(30) != '4') {
            throw new RuntimeException();
        }
        A09[0] = "AO2Vor543jhYYkt1oYijcT7buZTkR3eI";
        if (ki == null) {
            KI ki2 = new KI(expandableLayout, 300, expandableLayout.getHeight(), 0);
            this.A01 = ki2;
            this.A00.A0I(ki2);
            this.A00.A0G();
        }
    }
}

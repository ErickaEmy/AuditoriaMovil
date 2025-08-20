package com.facebook.ads.internal.view;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.redexgen.X.AbstractC0783Lo;
import com.facebook.ads.redexgen.X.C02911a;
import com.facebook.ads.redexgen.X.C02971g;
import com.facebook.ads.redexgen.X.C0796Mb;
import com.facebook.ads.redexgen.X.C0887Po;
import com.facebook.ads.redexgen.X.C1116Yn;
import com.facebook.ads.redexgen.X.C1P;
import com.facebook.ads.redexgen.X.EnumC0791Lw;
import com.facebook.ads.redexgen.X.JA;
import com.facebook.ads.redexgen.X.LD;
import com.facebook.ads.redexgen.X.M9;
import com.facebook.ads.redexgen.X.MA;
import com.facebook.ads.redexgen.X.MB;
import com.facebook.ads.redexgen.X.MC;
import com.facebook.ads.redexgen.X.ML;
import com.facebook.ads.redexgen.X.OI;
import com.facebook.ads.redexgen.X.View$OnClickListenerC0988Tl;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class FullScreenAdToolbar extends MB {
    public static byte[] A09;
    public static String[] A0A = {"elaUgpg", "xyZ5KhWZZkOCw26QnbyRE89VYXYHkT38", "j2Hg99bd5kkvFLrtwtqoGvtE7T", "FtK0h2Y990QReQxCoMrwn7Y", "09p430KvfvIa5D7TMMbG57be7BWhVuc0", "4K9Dg6G4rdQDm1ubILJxRl9GbBVTjarc", "MQsbPX4", "ODYsITK"};
    public static final int A0B;
    public static final int A0C;
    public static final int A0D;
    public static final int A0E;
    public static final int A0F;
    public M9 A00;
    public MA A01;
    public MA A02;
    public boolean A03;
    public final RelativeLayout A04;
    public final JA A05;
    public final MC A06;
    public final C0796Mb A07;
    public final C0887Po A08;

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A09, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 113);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A09 = new byte[]{-26, 15, 18, 22, 8, -61, -28, 7, 56, 75, 86, 85, 88, 90, 6, 39, 74, 77, 72, 72, 69, 59, 58, 75};
    }

    static {
        A03();
        int i = (int) (LD.A02 * 10.0f);
        A0B = i;
        int i5 = (int) (LD.A02 * 16.0f);
        A0F = i5;
        A0D = i5 - i;
        A0E = (i5 * 2) - i;
        A0C = (int) (LD.A02 * 4.0f);
    }

    public FullScreenAdToolbar(C1116Yn c1116Yn, MC mc2, JA ja, int i) {
        super(c1116Yn);
        this.A01 = null;
        this.A03 = true;
        this.A06 = mc2;
        this.A05 = ja;
        setGravity(16);
        C0796Mb c0796Mb = new C0796Mb(c1116Yn, i);
        this.A07 = c0796Mb;
        c0796Mb.setContentDescription(A02(0, 8, 50));
        c0796Mb.setActionClickListener(new ML(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i5 = A0D;
        layoutParams.setMargins(i5, i5, A0E, i5);
        addView(c0796Mb, layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(c1116Yn);
        this.A04 = relativeLayout;
        LinearLayout.LayoutParams containerParams = new LinearLayout.LayoutParams(0, -2);
        containerParams.weight = 1.0f;
        C0887Po c0887Po = new C0887Po(c1116Yn);
        this.A08 = c0887Po;
        AbstractC0783Lo.A0G(1006, c0887Po);
        LinearLayout.LayoutParams toolbarActionViewParams = new LinearLayout.LayoutParams(-2, -2);
        toolbarActionViewParams.gravity = 17;
        c0887Po.setLayoutParams(toolbarActionViewParams);
        relativeLayout.addView(c0887Po);
        addView(relativeLayout, containerParams);
    }

    public FullScreenAdToolbar(C1116Yn c1116Yn, MC mc2, JA ja, int i, int i5) {
        this(c1116Yn, mc2, ja, i);
        A09(c1116Yn, i5);
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public final void A04() {
        MA ma = this.A01;
        if (ma != null) {
            this.A02 = ma;
        }
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public final void A05() {
        this.A01 = getToolbarListener();
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public final void A06(C1P c1p, boolean z2) {
        boolean z3 = this.A03;
        int A04 = c1p.A04(z3);
        this.A08.A02(c1p.A0A(z3), A04);
        this.A00.setIconColors(A04);
        this.A00.setContentDescription(A02(8, 9, 117));
        this.A07.A02(c1p, z3, z2);
        if (z3) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1778384896, 0});
            gradientDrawable.setCornerRadius(0.0f);
            AbstractC0783Lo.A0S(this, gradientDrawable);
            AbstractC0783Lo.A0Q(this.A00, 0, -16777216, A0C);
            return;
        }
        AbstractC0783Lo.A0M(this, 0);
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public final boolean A07() {
        return this.A07.A03();
    }

    public final void A08(C02911a c02911a, String str, int i) {
        this.A07.setInitialUnskippableSeconds(i);
        M9 m9 = this.A00;
        if (m9 != null) {
            m9.setAdDetails(c02911a, str, this.A05, this.A06);
        }
    }

    public final void A09(C1116Yn c1116Yn, int i) {
        M9 m9 = this.A00;
        if (m9 != null) {
            AbstractC0783Lo.A0J(m9);
            this.A00.removeAllViews();
        }
        this.A00 = new M9(c1116Yn, i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int i5 = A0F;
        layoutParams.setMargins(0, i5 / 2, i5 / 2, i5 / 2);
        addView(this.A00, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public View getDetailsContainer() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public int getToolbarActionMode() {
        return this.A07.getToolbarActionMode();
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public int getToolbarHeight() {
        return MB.A00;
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public MA getToolbarListener() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public void setAdReportingVisible(boolean z2) {
        this.A00.setVisibility(z2 ? 0 : 8);
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public void setCTAClickListener(View.OnClickListener onClickListener) {
        this.A08.setOnClickListener(onClickListener);
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public void setCTAClickListener(View$OnClickListenerC0988Tl view$OnClickListenerC0988Tl) {
        this.A08.setOnClickListener(OI.A03(view$OnClickListenerC0988Tl, A02(17, 7, 104)));
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public void setFullscreen(boolean z2) {
        this.A03 = z2;
    }

    public void setOnlyPageDetails(C02911a c02911a) {
        if (c02911a != null) {
            this.A08.setPageDetails(c02911a);
        } else {
            this.A08.A01();
        }
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public void setPageDetails(C02911a c02911a, String str, int i, C02971g c02971g) {
        this.A07.setInitialUnskippableSeconds(i);
        this.A08.setPageDetails(c02911a);
        M9 m9 = this.A00;
        if (m9 != null) {
            m9.setAdDetails(c02911a, str, this.A05, this.A06);
        }
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public void setPageDetailsVisible(boolean z2) {
        this.A04.removeAllViews();
        if (z2) {
            RelativeLayout relativeLayout = this.A04;
            C0887Po c0887Po = this.A08;
            if (A0A[4].charAt(4) != '3') {
                throw new RuntimeException();
            }
            String[] strArr = A0A;
            strArr[2] = "uYrc95dj4mq6YR3RipRhNZPjST";
            strArr[3] = "ufyXPPKrvmASdIniU0CJIS9";
            relativeLayout.addView(c0887Po);
        }
        C0796Mb c0796Mb = this.A07;
        String[] strArr2 = A0A;
        if (strArr2[2].length() == strArr2[3].length()) {
            c0796Mb.setToolbarMessageEnabled(!z2);
            return;
        }
        A0A[1] = "RoBBOPMqmB8G6B1FErbRchWOJuWn3pgq";
        c0796Mb.setToolbarMessageEnabled(!z2);
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public void setProgress(float f4) {
        this.A07.setProgress(f4);
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public void setProgressClickListener(View.OnClickListener onClickListener) {
        this.A07.setProgressClickListener(onClickListener);
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public void setProgressImage(EnumC0791Lw enumC0791Lw) {
        this.A07.setProgressImage(enumC0791Lw);
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public void setProgressImmediate(float f4) {
        this.A07.setProgressImmediate(f4);
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public void setProgressSpinnerInvisible(boolean z2) {
        this.A07.setProgressSpinnerInvisible(z2);
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public void setToolbarActionMessage(String str) {
        this.A07.setToolbarMessage(str);
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public void setToolbarActionMode(int i) {
        this.A07.setToolbarActionMode(i);
    }

    @Override // com.facebook.ads.redexgen.X.MB
    public void setToolbarListener(MA ma) {
        this.A02 = ma;
    }
}

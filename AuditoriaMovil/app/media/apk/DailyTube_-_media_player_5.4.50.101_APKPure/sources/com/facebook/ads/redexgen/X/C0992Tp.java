package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
/* renamed from: com.facebook.ads.redexgen.X.Tp  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0992Tp extends AbstractC03212e {
    public static byte[] A07;
    public static final int A08;
    public static final int A09;
    public static final int A0A;
    public static final int A0B;
    public static final int A0C;
    public final LinearLayout A00;
    public final RelativeLayout A01;
    public final AbstractC1219b5 A02;
    public final C1116Yn A03;
    public final J2 A04;
    public final C0775Lg A05;
    public final MC A06;

    public static String A03(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 50);
        }
        return new String(copyOfRange);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 20 out of bounds for length 17
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:118)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:567)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:39)
     */
    private void A05() {
        RelativeLayout relativeLayout = new RelativeLayout(this.A03);
        O3 o3 = new O3(this.A03);
        AsyncTaskC0993Tq asyncTaskC0993Tq = new AsyncTaskC0993Tq(o3, this.A03);
        int i = A0C;
        asyncTaskC0993Tq.A05(i, i).A07(this.A02.A10().A01());
        o3.setFullCircleCorners(true);
        AbstractC0783Lo.A0M(o3, 0);
        AbstractC0783Lo.A0K(o3);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        int i5 = A0B;
        layoutParams.setMargins(i5, i5, i5, i5);
        layoutParams.addRule(14);
        relativeLayout.addView(o3, layoutParams);
        TextView textView = new TextView(this.A03);
        AbstractC0783Lo.A0K(textView);
        textView.setTextColor(this.A02.A0w().A01().A06(true));
        textView.setText(this.A02.A0x().A0E().A06());
        textView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, o3.getId());
        relativeLayout.addView(textView, layoutParams2);
        LinearLayout linearLayout = new LinearLayout(this.A03);
        AbstractC0783Lo.A0K(linearLayout);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(i5, 0, i5, i5);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, textView.getId());
        relativeLayout.addView(linearLayout, layoutParams3);
        O5 o5 = new O5(this.A03, A0A, 5, A09, -1);
        o5.setGravity(16);
        linearLayout.addView(o5, new LinearLayout.LayoutParams(-2, -1));
        TextView textView2 = new TextView(this.A03);
        textView2.setTextColor(this.A02.A0w().A01().A06(true));
        textView2.setGravity(16);
        textView2.setIncludeFontPadding(false);
        AbstractC0783Lo.A0X(textView2, false, 14);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams4.leftMargin = A08;
        linearLayout.addView(textView2, layoutParams4);
        if (TextUtils.isEmpty(this.A02.A0x().A0E().A03())) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
            o5.setRating(Float.parseFloat(this.A02.A0x().A0E().A03()));
            if (this.A02.A0x().A0E().A02() != null) {
                textView2.setText(A03(0, 1, 20) + NumberFormat.getNumberInstance().format(Integer.parseInt(this.A02.A0x().A0E().A02())) + A03(1, 1, 41));
            }
        }
        TextView textView3 = new TextView(this.A03);
        textView3.setTextColor(this.A02.A0w().A01().A06(true));
        textView3.setText(this.A02.A0x().A0E().A01());
        textView3.setGravity(17);
        textView3.setPadding(i5, i5, i5, i5);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(14);
        layoutParams5.addRule(3, linearLayout.getId());
        relativeLayout.addView(textView3, layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams6.gravity = 4;
        layoutParams6.weight = 0.8f;
        this.A00.addView(relativeLayout, layoutParams6);
    }

    public static void A06() {
        A07 = new byte[]{110, -124};
    }

    static {
        A06();
        A0B = (int) (AbstractC03212e.A08 * 12.0f);
        A0C = (int) (AbstractC03212e.A08 * 84.0f);
        A0A = (int) (AbstractC03212e.A08 * 14.0f);
        A08 = (int) (AbstractC03212e.A08 * 8.0f);
        A09 = AbstractC03322p.A01(-1, 77);
    }

    public C0992Tp(C1116Yn c1116Yn, AbstractC1219b5 abstractC1219b5, J2 j2, MC mc2) {
        super(c1116Yn);
        C0775Lg c0775Lg = new C0775Lg();
        this.A05 = c0775Lg;
        this.A03 = c1116Yn;
        this.A02 = abstractC1219b5;
        this.A04 = j2;
        this.A06 = mc2;
        c0775Lg.A05();
        setRadius(20.0f);
        setMaxCardElevation(75.0f);
        RelativeLayout relativeLayout = new RelativeLayout(c1116Yn);
        this.A01 = relativeLayout;
        OA.A00(c1116Yn, relativeLayout, abstractC1219b5.A0x().A0D().A07());
        LinearLayout linearLayout = new LinearLayout(c1116Yn);
        this.A00 = linearLayout;
        linearLayout.setOrientation(1);
        A05();
        A04();
        relativeLayout.addView(linearLayout, new RelativeLayout.LayoutParams(-1, -1));
        addView(relativeLayout, new FrameLayout.LayoutParams(-1, -1));
    }

    private void A04() {
        View$OnClickListenerC0988Tl view$OnClickListenerC0988Tl = new View$OnClickListenerC0988Tl(this.A03, QP.A04.A02(), this.A02.A0w().A01(), this.A02.A0x().A0F().A06(), this.A04, this.A06, null, this.A05, this.A02.A0y());
        view$OnClickListenerC0988Tl.setViewShowsOverMedia(true);
        AbstractC0783Lo.A0G(1001, view$OnClickListenerC0988Tl);
        view$OnClickListenerC0988Tl.setCta(this.A02.A0x().A0F(), this.A02.A12(), new HashMap(), null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i = A0B;
        view$OnClickListenerC0988Tl.setPadding(i, i, i, i);
        layoutParams.setMargins(i, i, i, i * 2);
        this.A00.addView(view$OnClickListenerC0988Tl, layoutParams);
    }
}

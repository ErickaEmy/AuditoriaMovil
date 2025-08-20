package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.RewardData;
/* loaded from: assets/audience_network.dex */
public final class O1 extends FrameLayout {
    public static String[] A07 = {"Lu0oG19N", "JNY", "Ev6F9eDhg42RHlCeRuJfEtiFO07AluFn", "qSbaO4FE34QcNqD1YWxCxyT8wr5s9kWw", "hZddA1hSD7Y", "v9TnLSaOxYneacolptRVdRHaZQ0ab06L", "iyW9tyIIQvF7WQz3LOxNHXxa074IcWbN", "vzh"};
    public MB A00;
    public final AbstractC1219b5 A01;
    public final C1116Yn A02;
    public final MC A03;
    public final O0 A04;
    public final SA A05;
    public final View[] A06;

    public O1(OP op, AbstractC1219b5 abstractC1219b5, SA sa, KP kp2, AbstractC0835No abstractC0835No, MC mc2, O0 o02) {
        this(op, abstractC1219b5, sa, mc2, o02, kp2, abstractC0835No);
    }

    public O1(OP op, AbstractC1219b5 abstractC1219b5, SA sa, MC mc2, O0 o02, View... viewArr) {
        this(op.A05(), op.A08(), abstractC1219b5, sa, mc2, o02, viewArr);
    }

    public O1(C1116Yn c1116Yn, MB mb, AbstractC1219b5 abstractC1219b5, SA sa, MC mc2, O0 o02, View... viewArr) {
        super(c1116Yn);
        this.A02 = c1116Yn;
        this.A00 = mb;
        this.A01 = abstractC1219b5;
        this.A06 = viewArr;
        this.A03 = mc2;
        this.A05 = sa;
        this.A04 = o02;
        A03();
    }

    private void A03() {
        String title;
        RewardData A0J = this.A01.A0J();
        if (A0J == null) {
            title = this.A01.A0z().A05();
        } else {
            title = this.A01.A0z().A06(A0J.getCurrency(), A0J.getQuantity());
        }
        MQ mq = new MQ(this.A02, -1, -16777216, title, null, this.A01.A0z().A04(), this.A01.A0z().A03(), AbstractC0792Lx.A01(EnumC0791Lw.REWARD_ICON));
        mq.A02.setOnClickListener(new View$OnClickListenerC0845Ny(this));
        mq.A01.setOnClickListener(new View$OnClickListenerC0846Nz(this));
        addView(mq, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        SA sa = this.A05;
        if (sa != null) {
            sa.A0a(QH.A07);
        }
        this.A04.AAh();
        if (!this.A01.A0x().A0O()) {
            this.A01.A15(this.A03);
        }
    }

    public final void A07(ViewGroup viewGroup) {
        View[] viewArr;
        SA sa = this.A05;
        if (sa != null && !sa.A0j()) {
            this.A05.A0f(false, false, 11);
            AbstractC0783Lo.A0N(this.A05, 4);
        }
        MB mb = this.A00;
        String[] strArr = A07;
        if (strArr[7].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        A07[0] = "vGH3jzSu";
        if (mb != null) {
            AbstractC0783Lo.A0H(mb);
        }
        for (View view : this.A06) {
            view.clearAnimation();
            AbstractC0783Lo.A0N(view, 4);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        viewGroup.addView(this, layoutParams);
        this.A04.ACC();
    }
}

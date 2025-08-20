package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: assets/audience_network.dex */
public abstract class MB extends LinearLayout {
    public static int A00 = (int) (LD.A02 * 56.0f);

    public abstract void A04();

    public abstract void A05();

    public abstract void A06(C1P c1p, boolean z2);

    public abstract boolean A07();

    public abstract View getDetailsContainer();

    public abstract int getToolbarActionMode();

    public abstract int getToolbarHeight();

    public abstract MA getToolbarListener();

    public abstract void setAdReportingVisible(boolean z2);

    public abstract void setCTAClickListener(View.OnClickListener onClickListener);

    public abstract void setCTAClickListener(View$OnClickListenerC0988Tl view$OnClickListenerC0988Tl);

    public abstract void setFullscreen(boolean z2);

    public abstract void setPageDetails(C02911a c02911a, String str, int i, C02971g c02971g);

    public abstract void setPageDetailsVisible(boolean z2);

    public abstract void setProgress(float f4);

    public abstract void setProgressClickListener(View.OnClickListener onClickListener);

    public abstract void setProgressImage(EnumC0791Lw enumC0791Lw);

    public abstract void setProgressImmediate(float f4);

    public abstract void setProgressSpinnerInvisible(boolean z2);

    public abstract void setToolbarActionMessage(String str);

    public abstract void setToolbarActionMode(int i);

    public abstract void setToolbarListener(MA ma);

    public MB(Context context) {
        super(context);
    }
}

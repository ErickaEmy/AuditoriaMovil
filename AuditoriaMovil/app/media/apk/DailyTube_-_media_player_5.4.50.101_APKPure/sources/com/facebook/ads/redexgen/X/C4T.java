package com.facebook.ads.redexgen.X;

import android.view.View;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.4T  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C4T {
    public int A00;
    public int A01;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public boolean A09;
    public boolean A0B = true;
    public int A02 = 0;
    public boolean A0A = false;
    public List<AnonymousClass56> A08 = null;

    private View A00() {
        int size = this.A08.size();
        for (int i = 0; i < size; i++) {
            View view = this.A08.get(i).A0H;
            C03834p c03834p = (C03834p) view.getLayoutParams();
            if (!c03834p.A02()) {
                int i5 = this.A01;
                int size2 = c03834p.A00();
                if (i5 == size2) {
                    A02(view);
                    return view;
                }
            }
        }
        return null;
    }

    private final View A01(View view) {
        int size = this.A08.size();
        View view2 = null;
        int i = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < size; i5++) {
            View view3 = this.A08.get(i5).A0H;
            C03834p c03834p = (C03834p) view3.getLayoutParams();
            if (view3 != view && !c03834p.A02()) {
                int A00 = c03834p.A00();
                int size2 = this.A01;
                int i6 = A00 - size2;
                int size3 = this.A03;
                int i8 = i6 * size3;
                if (i8 >= 0 && i8 < i) {
                    view2 = view3;
                    i = i8;
                    if (i8 == 0) {
                        break;
                    }
                }
            }
        }
        return view2;
    }

    private final void A02(View view) {
        View closest = A01(view);
        if (closest == null) {
            this.A01 = -1;
        } else {
            this.A01 = ((C03834p) closest.getLayoutParams()).A00();
        }
    }

    public final View A03(C03894w c03894w) {
        if (this.A08 != null) {
            return A00();
        }
        View A0G = c03894w.A0G(this.A01);
        this.A01 += this.A03;
        return A0G;
    }

    public final void A04() {
        A02(null);
    }

    public final boolean A05(AnonymousClass53 anonymousClass53) {
        int i = this.A01;
        return i >= 0 && i < anonymousClass53.A03();
    }
}

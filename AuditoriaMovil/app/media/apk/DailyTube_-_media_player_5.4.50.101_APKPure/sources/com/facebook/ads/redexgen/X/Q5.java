package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: assets/audience_network.dex */
public final class Q5 {
    public View$OnClickListenerC0988Tl A00;
    public final C1C A01;
    public final C1N A02;
    public final C1R A03;
    public final C02911a A04;
    public final C1116Yn A05;
    public final JA A06;
    public static String[] A07 = {"67PC1vS7qkP", "IjFo3BG6VwtzNtFBLMxB3hm7uxcMitzp", "CicRHWg02u8tYTVNboa", "Lc1HqPOOGgkkm0o4iF185HVfJQb2Oy4J", "rfUiy7qGv2cTTJD", "veTQu7RBhk0w6DuY7Y8JViB1PkIKs", "nFnk8VxBkehLa6QhTm5QccOE2IAl", "l0nPd7gOfqjUiTZVoVDHfvPfOU4VPF8e"};
    public static final int A0A = (int) (LD.A02 * 4.0f);
    public static final int A08 = (int) (LD.A02 * 72.0f);
    public static final int A09 = (int) (LD.A02 * 8.0f);

    public Q5(C1116Yn c1116Yn, J2 j2, AbstractC1219b5 abstractC1219b5) {
        this.A05 = c1116Yn;
        this.A06 = new JA(abstractC1219b5.A12(), j2);
        this.A01 = abstractC1219b5.A0w();
        this.A02 = abstractC1219b5.A0x().A0E();
        this.A04 = abstractC1219b5.A10();
        this.A03 = abstractC1219b5.A0x().A0G();
    }

    private View A00(View$OnClickListenerC0988Tl view$OnClickListenerC0988Tl) {
        O9 o9 = new O9(this.A05, this.A01.A01(), true, false, false);
        o9.A03(this.A02.A06(), this.A02.A01(), null, false, true);
        o9.setAlignment(17);
        O3 o3 = new O3(this.A05);
        AbstractC0783Lo.A0M(o3, 0);
        o3.setRadius(50);
        new AsyncTaskC0993Tq(o3, this.A05).A04().A07(this.A04.A01());
        LinearLayout linearLayout = new LinearLayout(this.A05);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        int i = A08;
        linearLayout.addView(o3, new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(-2, -2);
        int i5 = A09;
        imageParams.setMargins(0, i5, 0, i5);
        linearLayout.addView(o9, imageParams);
        if (view$OnClickListenerC0988Tl != null) {
            AbstractC0783Lo.A0J(view$OnClickListenerC0988Tl);
            linearLayout.addView(view$OnClickListenerC0988Tl, imageParams);
            if (TextUtils.isEmpty(view$OnClickListenerC0988Tl.getText())) {
                AbstractC0783Lo.A0H(view$OnClickListenerC0988Tl);
            }
        }
        return linearLayout;
    }

    private C0599Eb A01() {
        C0599Eb c0599Eb = new C0599Eb(this.A05);
        c0599Eb.setLayoutManager(new C1142Zo(this.A05, 0, false));
        c0599Eb.setAdapter(new SM(this.A05, this.A03.A01(), A0A, this.A00));
        return c0599Eb;
    }

    private final Q4 A02() {
        if (!this.A03.A01().isEmpty()) {
            return Q4.A04;
        }
        Q4 q4 = Q4.A03;
        String[] strArr = A07;
        if (strArr[3].charAt(8) != strArr[7].charAt(8)) {
            A07[4] = "qwlEjiYhEcV8j1J";
            return q4;
        }
        throw new RuntimeException();
    }

    public final Pair<Q4, View> A03(View$OnClickListenerC0988Tl view$OnClickListenerC0988Tl) {
        View A01;
        this.A00 = view$OnClickListenerC0988Tl;
        Q4 A02 = A02();
        switch (Q3.A00[A02.ordinal()]) {
            case 1:
                A01 = A01();
                break;
            default:
                View$OnClickListenerC0988Tl view$OnClickListenerC0988Tl2 = this.A00;
                if (A07[4].length() == 15) {
                    String[] strArr = A07;
                    strArr[3] = "Oe6IO8Uak3tx5GvHWoKp5mKUb4E2rtDt";
                    strArr[7] = "t7tx5cDm578ghKblxCWBuUm65hKnqcQl";
                    A01 = A00(view$OnClickListenerC0988Tl2);
                    break;
                } else {
                    throw new RuntimeException();
                }
        }
        JC.A04(A01, this.A06, J9.A0S);
        return new Pair<>(A02, A01);
    }
}

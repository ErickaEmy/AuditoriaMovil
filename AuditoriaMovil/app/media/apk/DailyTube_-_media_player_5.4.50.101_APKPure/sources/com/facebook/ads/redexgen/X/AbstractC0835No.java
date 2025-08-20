package com.facebook.ads.redexgen.X;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import java.util.Arrays;
import java.util.HashMap;
/* renamed from: com.facebook.ads.redexgen.X.No  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0835No extends LinearLayout {
    public static byte[] A06;
    public static String[] A07 = {"cmzsI0MqV", "rmZj6bXGr2Mc3k6GGfUNTI8ab", "Oqa2BQOYUIgPEQnUKqUaSgjmS1hAy2aw", "VbR8t651F3u5xAC0yd", "KwIIB1PdAD0xOvkamO3Meu", "6KEr", "QBka00Gf2XeExLF7IYa6e3", ""};
    public static final LinearLayout.LayoutParams A08;
    public final int A00;
    public final View.OnClickListener A01;
    public final RelativeLayout A02;
    public final C1116Yn A03;
    public final View$OnClickListenerC0988Tl A04;
    public final O3 A05;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 49);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {9, 12, 12, 13, 28, 9, 17, 20, 27};
        if (A07[1].length() != 25) {
            throw new RuntimeException();
        }
        A07[2] = "W8PIFEgMaUlhByfzvyeLgAFdtcDk8ZOz";
        A06 = bArr;
    }

    public abstract void A0A(int i);

    public abstract View getExpandableLayout();

    public abstract void setTitleMaxLines(int i);

    static {
        A01();
        A08 = new LinearLayout.LayoutParams(-2, -2);
    }

    public AbstractC0835No(C1116Yn c1116Yn, int i, C1P c1p, boolean z2, String str, J2 j2, MC mc2, RE re, C0775Lg c0775Lg, C1U c1u) {
        super(c1116Yn);
        AbstractC0783Lo.A0K(this);
        this.A03 = c1116Yn;
        this.A00 = i;
        O3 o3 = new O3(c1116Yn);
        this.A05 = o3;
        AbstractC0783Lo.A0M(o3, 0);
        AbstractC0783Lo.A0K(o3);
        View$OnClickListenerC0988Tl view$OnClickListenerC0988Tl = new View$OnClickListenerC0988Tl(c1116Yn, str, c1p, z2, j2, mc2, re, c0775Lg, c1u);
        this.A04 = view$OnClickListenerC0988Tl;
        AbstractC0783Lo.A0G(1001, view$OnClickListenerC0988Tl);
        this.A01 = OI.A03(view$OnClickListenerC0988Tl, A00(0, 9, 119));
        RelativeLayout relativeLayout = new RelativeLayout(c1116Yn);
        this.A02 = relativeLayout;
        relativeLayout.setLayoutParams(A08);
        AbstractC0783Lo.A0K(relativeLayout);
    }

    public void A09() {
        this.A05.setOnClickListener(this.A01);
    }

    public final View$OnClickListenerC0988Tl getCTAButton() {
        return this.A04;
    }

    public final ImageView getIconView() {
        return this.A05;
    }

    public void setInfo(C1N c1n, C1Q c1q, String str, String str2, InterfaceC0837Nq interfaceC0837Nq) {
        this.A04.setCta(c1q, str, new HashMap(), interfaceC0837Nq);
        AsyncTaskC0993Tq asyncTaskC0993Tq = new AsyncTaskC0993Tq(this.A05, this.A03);
        int i = this.A00;
        asyncTaskC0993Tq.A05(i, i).A07(str2);
    }
}

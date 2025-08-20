package com.facebook.ads.redexgen.X;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.internal.api.AdNativeComponentView;
import java.lang.ref.WeakReference;
/* loaded from: assets/audience_network.dex */
public class V6 extends RD {
    public static String[] A04 = {"oSoBkaWeyKsp", "KBeBF", "kSDces9j50gwfjS4QfNYnWgLw2iPkymV", "EJmszBWYtRUz1Vdq", "qn5qycmxyPd80aqzWiKeSrAoNfum3VnE", "21Cce2q6wYIDkABj", "e4Lw2G3U", "jRNkDTlKn5mABl6KQSYrYYCrXHx6B19g"};
    public final /* synthetic */ View A00;
    public final /* synthetic */ C1234bK A01;
    public final /* synthetic */ V2 A02;
    public final /* synthetic */ boolean A03;

    public V6(V2 v2, View view, boolean z2, C1234bK c1234bK) {
        this.A02 = v2;
        this.A00 = view;
        this.A03 = z2;
        this.A01 = c1234bK;
    }

    @Override // com.facebook.ads.redexgen.X.RD
    public final void A00() {
        JZ jz2;
        jz2 = this.A02.A0e;
        jz2.A06();
    }

    @Override // com.facebook.ads.redexgen.X.RD
    public final void A02() {
        JZ jz2;
        jz2 = this.A02.A0e;
        jz2.A0A();
    }

    @Override // com.facebook.ads.redexgen.X.RD
    public final void A03() {
        JZ jz2;
        JZ jz3;
        C1116Yn c1116Yn;
        RE re;
        WeakReference weakReference;
        C0775Lg c0775Lg;
        JZ jz4;
        C1224bA c1224bA;
        View view;
        View view2;
        C1224bA c1224bA2;
        View view3;
        C1224bA c1224bA3;
        View view4;
        C1224bA c1224bA4;
        JS js;
        C1224bA c1224bA5;
        boolean z2;
        C1224bA c1224bA6;
        boolean z3;
        C1224bA c1224bA7;
        boolean z4;
        C1224bA c1224bA8;
        boolean A0p;
        C1224bA c1224bA9;
        AnonymousClass12 anonymousClass12;
        C1224bA c1224bA10;
        boolean z5;
        C1224bA c1224bA11;
        NativeAdLayout nativeAdLayout;
        C1224bA c1224bA12;
        String str;
        C1224bA c1224bA13;
        C1224bA c1224bA14;
        WeakReference weakReference2;
        WeakReference weakReference3;
        RE re2;
        Drawable drawable;
        RE re3;
        JZ jz5;
        RE re4;
        JZ jz6;
        jz2 = this.A02.A0e;
        jz2.A0B();
        if (C0705Ih.A1o(this.A02.A11())) {
            AdNativeComponentView adNativeComponentView = this.A00;
            if (adNativeComponentView instanceof AdNativeComponentView) {
                View adContentsView = adNativeComponentView.getAdContentsView();
                if ((adContentsView instanceof QJ) && !((QJ) adContentsView).A02()) {
                    re4 = this.A02.A0R;
                    re4.A0T();
                    jz6 = this.A02.A0e;
                    jz6.A08();
                    return;
                }
            }
        }
        if (this.A03) {
            ImageView imageView = (ImageView) this.A00;
            if (A04[6].length() != 8) {
                throw new RuntimeException();
            }
            A04[4] = "kV1RqodiW8kqR1rQOQ4NCiAB35VpASKe";
            drawable = this.A02.A01;
            if (drawable == null) {
                re3 = this.A02.A0R;
                re3.A0T();
                jz5 = this.A02.A0e;
                jz5.A07();
                return;
            }
            V2.A0e(drawable, imageView);
        }
        jz3 = this.A02.A0e;
        c1116Yn = this.A02.A0c;
        jz3.A0C(c1116Yn, this.A01.A0G());
        re = this.A02.A0R;
        if (re != null) {
            re2 = this.A02.A0R;
            re2.A0V();
        }
        weakReference = this.A02.A0V;
        if (weakReference != null) {
            weakReference2 = this.A02.A0V;
            if (weakReference2.get() != null) {
                weakReference3 = this.A02.A0V;
                ((RD) weakReference3.get()).A03();
            }
        }
        c0775Lg = this.A02.A0f;
        if (c0775Lg.A07()) {
            jz4 = this.A02.A0e;
            jz4.A04();
            return;
        }
        this.A02.A0b();
        c1224bA = this.A02.A09;
        if (c1224bA != null) {
            view = this.A02.A04;
            if (view != null) {
                view2 = this.A02.A06;
                if (view2 != null) {
                    c1224bA2 = this.A02.A09;
                    view3 = this.A02.A04;
                    c1224bA2.A08(view3);
                    c1224bA3 = this.A02.A09;
                    view4 = this.A02.A06;
                    c1224bA3.A07(view4);
                    c1224bA4 = this.A02.A09;
                    js = this.A02.A0I;
                    c1224bA4.A0B(js);
                    c1224bA5 = this.A02.A09;
                    z2 = this.A02.A0W;
                    c1224bA5.A0E(z2);
                    c1224bA6 = this.A02.A09;
                    z3 = this.A02.A0Z;
                    c1224bA6.A0I(z3);
                    c1224bA7 = this.A02.A09;
                    z4 = this.A02.A0Y;
                    c1224bA7.A0H(z4);
                    c1224bA8 = this.A02.A09;
                    A0p = this.A02.A0p();
                    c1224bA8.A0F(A0p);
                    c1224bA9 = this.A02.A09;
                    anonymousClass12 = this.A02.A08;
                    c1224bA9.A09(anonymousClass12);
                    c1224bA10 = this.A02.A09;
                    z5 = this.A02.A0X;
                    c1224bA10.A0G(z5);
                    c1224bA11 = this.A02.A09;
                    nativeAdLayout = this.A02.A07;
                    c1224bA11.A0A(AbstractC0810Mp.A00(nativeAdLayout));
                    c1224bA12 = this.A02.A09;
                    str = this.A02.A0S;
                    c1224bA12.A0C(str);
                    c1224bA13 = this.A02.A09;
                    c1224bA13.A0J(this.A03);
                    c1224bA14 = this.A02.A09;
                    c1224bA14.A02();
                }
            }
        }
    }
}

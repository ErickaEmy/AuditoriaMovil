package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import java.lang.ref.WeakReference;
/* renamed from: com.facebook.ads.redexgen.X.Ss  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0969Ss extends FrameLayout implements MD {
    public static String[] A0D = {"2Xyaln6pEv", "U0a3JqFqqkDVhXbmlhDLXicSxteMexx", "xzpI97Jg3aS17fwtqg1jZWsfReheMZxV", "0HUxaz9ggnFIA", "Uunhkc3", "kqN9", "fWeU9xYsODnan54TmlbSL1hNy6Lef7fu", "qbKhPFfRzVPGu"};
    public static final RelativeLayout.LayoutParams A0E = new RelativeLayout.LayoutParams(-1, -1);
    public boolean A00;
    public final AbstractC1219b5 A01;
    public final C04216c A02;
    public final C1116Yn A03;
    public final J2 A04;
    public final JA A05;
    public final C0775Lg A06;
    public final MB A07;
    public final MC A08;
    public final InterfaceC0804Mj A09;
    public final RE A0A;
    public final View$OnSystemUiVisibilityChangeListenerC0770Lb A0B;
    public final RD A0C;

    public abstract void A0Q();

    public abstract void A0S(C5V c5v);

    public abstract boolean A0T();

    public AbstractC0969Ss(C1116Yn c1116Yn, InterfaceC0804Mj interfaceC0804Mj, J2 j2, AbstractC1219b5 abstractC1219b5, C04216c c04216c, MC mc2) {
        super(c1116Yn);
        C0973Sw c0973Sw = new C0973Sw(this);
        this.A0C = c0973Sw;
        this.A06 = new C0775Lg();
        this.A00 = false;
        this.A03 = c1116Yn;
        this.A09 = interfaceC0804Mj;
        this.A04 = j2;
        this.A01 = abstractC1219b5;
        this.A02 = c04216c;
        this.A08 = mc2;
        this.A05 = new JA(abstractC1219b5.A12(), j2);
        RE re = new RE(this, 1, new WeakReference(c0973Sw), c1116Yn);
        this.A0A = re;
        re.A0W(abstractC1219b5.A0C());
        re.A0X(abstractC1219b5.A0D());
        this.A07 = A0N();
        View$OnSystemUiVisibilityChangeListenerC0770Lb view$OnSystemUiVisibilityChangeListenerC0770Lb = new View$OnSystemUiVisibilityChangeListenerC0770Lb(this);
        this.A0B = view$OnSystemUiVisibilityChangeListenerC0770Lb;
        view$OnSystemUiVisibilityChangeListenerC0770Lb.A05(EnumC0769La.A03);
    }

    private FullScreenAdToolbar A0N() {
        FullScreenAdToolbar fullScreenAdToolbar = new FullScreenAdToolbar(this.A03, this.A08, this.A05, 1, this.A01.A0r());
        fullScreenAdToolbar.setFullscreen(true);
        int A03 = this.A01.A0x().A0D().A03();
        fullScreenAdToolbar.setPageDetails(this.A01.A10(), this.A01.A12(), A03, this.A01.A11());
        fullScreenAdToolbar.A06(this.A01.A0w().A01(), View$OnClickListenerC0988Tl.A08(this.A01));
        if (A03 < 0) {
            C1G A0x = this.A01.A0x();
            int unskippableSeconds = A0D[4].length();
            if (unskippableSeconds == 31) {
                throw new RuntimeException();
            }
            A0D[5] = "3phQ";
            if (A0x.A0M()) {
                fullScreenAdToolbar.setToolbarActionMode(4);
            }
        }
        fullScreenAdToolbar.setToolbarListener(new C0970St(this));
        return fullScreenAdToolbar;
    }

    private void A0O() {
        if (this.A01.A0x().A0P()) {
            C0879Pg A0B = new C0877Pe(this.A03, this.A01.A0x().A0E(), this.A01.A10()).A08(this.A01.A0w().A01()).A0B();
            JC.A04(A0B, this.A05, J9.A0U);
            addView(A0B, A0E);
            A0B.A04(new C0971Su(this));
            return;
        }
        A0Q();
    }

    public final void A0P() {
        if (!this.A00) {
            this.A0A.A0U();
            this.A00 = true;
        }
    }

    public final void A0R(int i, KT kt) {
        new L9(i, new C0972Sv(this, i, kt)).A07();
    }

    @Override // com.facebook.ads.redexgen.X.MD
    public final void A9Q(Intent intent, Bundle bundle, C5V c5v) {
        this.A08.A3U(this, A0E);
        A0S(c5v);
        A0O();
    }

    @Override // com.facebook.ads.redexgen.X.MD
    public final void AFT(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.X.MD
    public String getCurrentClientToken() {
        return this.A01.A12();
    }

    @Override // com.facebook.ads.redexgen.X.MD
    public final boolean onActivityResult(int i, int i5, Intent intent) {
        return false;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onDestroy() {
        this.A0B.A03();
        if (!TextUtils.isEmpty(this.A01.A12())) {
            this.A04.A9X(this.A01.A12(), new C0829Ni().A03(this.A0A).A02(this.A06).A05());
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A06.A06(this.A03, motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setListener(MC mc2) {
    }

    public void setUpFullscreenMode(boolean z2) {
        EnumC0769La enumC0769La;
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (z2) {
            enumC0769La = EnumC0769La.A04;
        } else {
            enumC0769La = EnumC0769La.A03;
        }
        this.A0B.A05(enumC0769La);
    }
}

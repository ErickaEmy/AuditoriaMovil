package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: assets/audience_network.dex */
public final class T8 extends PQ {
    public static String[] A07 = {"itiy11Wl5lP7QtpB3", "v6A5WW2CB", "SYp5FzxPKMl", "MKN0lN1Uug", "IQIXhYysWoH9a5YMZx5hFMUL6lEdxT5q", "FECz3BMfLn4pJfwLFVrIm2wrzlNMsWJ3", "RmVgcuWcoU56A5AXkQhrmgSRFj76ryom", "F5uv5dts8QHAu8Ovw"};
    public static final RelativeLayout.LayoutParams A08 = new RelativeLayout.LayoutParams(-1, -1);
    public L9 A00;
    public OL A01;
    public final int A02;
    public final ImageView A03;
    public final MB A04;
    public final InterfaceC0876Pd A05;
    public final AtomicBoolean A06;

    public T8(C1116Yn c1116Yn, InterfaceC0804Mj interfaceC0804Mj, int i, J2 j2, AbstractC1219b5 abstractC1219b5, MC mc2, FullScreenAdToolbar fullScreenAdToolbar, boolean z2, boolean z3, InterfaceC0876Pd interfaceC0876Pd, int i5) {
        super(c1116Yn, interfaceC0804Mj, j2, abstractC1219b5, i, z2, z3, mc2);
        this.A06 = new AtomicBoolean(false);
        this.A02 = i5;
        this.A05 = interfaceC0876Pd;
        ImageView imageView = new ImageView(getContext());
        this.A03 = imageView;
        this.A04 = fullScreenAdToolbar;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setAdjustViewBounds(true);
        new AsyncTaskC0993Tq(imageView, c1116Yn).A05(abstractC1219b5.A0x().A0D().A00(), abstractC1219b5.A0x().A0D().A01()).A06(new TA(this)).A07(abstractC1219b5.A0x().A0D().A07());
        A08(c1116Yn.getResources().getConfiguration().orientation);
    }

    private OL A04(int i) {
        if (this.A03.getParent() != null) {
            ImageView imageView = this.A03;
            if (A07[4].charAt(16) != 'Z') {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[3] = "PnJcnL34IR";
            strArr[1] = "4gIzhBkuZ";
            AbstractC0783Lo.A0J(imageView);
        }
        if (A07[4].charAt(16) != 'Z') {
            throw new RuntimeException();
        }
        A07[4] = "hUws06ULbo6w3OlBZNW9WYMgHjAED42u";
        OP params = new OO(super.A06, this.A07, this.A09, super.A05, this.A03, this.A0B, this.A08).A0E(this.A04.getToolbarHeight()).A0H(this.A04).A0D(i).A0J(i != 2).A0K();
        return OM.A00(params, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07() {
        if (this.A06.get()) {
            A03();
        }
    }

    private void A08(int i) {
        AbstractC0783Lo.A0J(this.A01);
        OL A04 = A04(i);
        this.A01 = A04;
        addView(A04, 0, A08);
    }

    @Override // com.facebook.ads.redexgen.X.PQ
    public final void A0z() {
        if (C0705Ih.A1W(super.A06)) {
            super.A06.A0A().AGk(this.A03);
        }
        OL ol = this.A01;
        if (ol != null) {
            ol.A0v();
        }
    }

    @Override // com.facebook.ads.redexgen.X.PQ
    public final void A10() {
    }

    @Override // com.facebook.ads.redexgen.X.PQ
    public final void A11() {
        int i = this.A02;
        if (i > 0) {
            L9 l92 = new L9(i, 100.0f, 100L, new Handler(Looper.getMainLooper()), new T9(this));
            this.A00 = l92;
            l92.A07();
            return;
        }
        this.A05.AD7(false);
    }

    @Override // com.facebook.ads.redexgen.X.PQ
    public final void A12(boolean z2) {
        L9 l92 = this.A00;
        if (l92 != null && l92.A05()) {
            this.A00.A06();
        }
    }

    @Override // com.facebook.ads.redexgen.X.PQ
    public final void A13(boolean z2) {
        L9 l92 = this.A00;
        if (l92 != null && !l92.A04()) {
            this.A00.A07();
        }
    }

    @Override // com.facebook.ads.redexgen.X.PQ
    public final boolean A14() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.PQ
    public final boolean A15() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.PQ
    public C0875Pc getFullScreenAdStyle() {
        C1P colors = this.A01.getColors();
        return new C0875Pc(this.A01.A11(), C0875Pc.A07, colors, View$OnClickListenerC0988Tl.A08(super.A05), colors.A07(this.A01.A11() || (this.A01 instanceof AbstractC0983Tg)), null);
    }

    @Override // com.facebook.ads.redexgen.X.PQ, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!super.A05.A0x().A0N()) {
            A08(configuration.orientation);
        }
    }
}

package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.View;
import com.uv.v7.R;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class ZQ extends AbstractC02810q {
    public static byte[] A03;
    public View A00;
    public final C5P A01;
    public final EQ A02;

    static {
        A03();
    }

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 53);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{-23, 7, 20, 20, 21, 26, -58, 22, 24, 11, 25, 11, 20, 26, -58, 20, 27, 18, 18, -58, 7, 10, -4, 15, 11, 29};
    }

    public ZQ(C5P c5p) {
        this.A02 = c5p.A09();
        this.A01 = c5p;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC02810q
    public final void A0C() {
        this.A02.A0E().A3o();
        KK.A00(new ZS(this));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC02810q
    public final void A0D() {
        this.A02.A0E().A3r();
        KK.A00(new ZR(this));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC02810q
    public final void A0E(View view) {
        if (view != null) {
            this.A02.A0E().A3q();
            this.A00 = view;
            this.A01.A07().removeAllViews();
            this.A01.A07().addView(this.A00);
            if (this.A00 instanceof C0995Ts) {
                AbstractC0728Ji.A01(this.A01.A05(), this.A00, this.A01.A0A());
            }
            FR controller = this.A01.A08();
            if (controller != null) {
                controller.A0I();
            }
            KK.A00(new ZT(this));
            C5P c5p = this.A01;
            c5p.A0B(c5p.A07(), this.A00);
            if (Build.VERSION.SDK_INT >= 18 && C0705Ih.A11(this.A01.A07().getContext())) {
                final C0827Ng c0827Ng = new C0827Ng();
                this.A01.A0D(c0827Ng);
                c0827Ng.A0C(this.A01.getPlacementId());
                c0827Ng.A0B(this.A01.A07().getContext().getPackageName());
                if (this.A01.A08() != null && this.A01.A08().A0H() != null) {
                    c0827Ng.A09(this.A01.A08().A0H().A0C());
                }
                View view2 = this.A00;
                if (view2 instanceof C0995Ts) {
                    c0827Ng.A0A(((C0995Ts) view2).getViewabilityChecker());
                }
                this.A00.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.facebook.ads.redexgen.X.5Z
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view3) {
                        View view4;
                        View view5;
                        View view6;
                        view4 = ZQ.this.A00;
                        if (view4 != null) {
                            C0827Ng c0827Ng2 = c0827Ng;
                            view5 = ZQ.this.A00;
                            int width = view5.getWidth();
                            view6 = ZQ.this.A00;
                            c0827Ng2.setBounds(0, 0, width, view6.getHeight());
                            C0827Ng c0827Ng3 = c0827Ng;
                            c0827Ng3.A0D(!c0827Ng3.A0E());
                        }
                        return true;
                    }
                });
                this.A00.getOverlay().add(c0827Ng);
                return;
            }
            return;
        }
        throw new IllegalStateException(A02(0, 26, R.styleable.AppCompatTheme_toolbarStyle));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC02810q
    public final void A0F(InterfaceC02800p interfaceC02800p) {
        this.A02.A0E().A3p(this.A01.A08() != null);
        if (this.A01.A08() != null) {
            this.A01.A08().A0J();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC02810q
    public final void A0G(C0722Jb c0722Jb) {
        this.A02.A0E().A2m(C0774Lf.A01(this.A01.A04()), c0722Jb.A03().getErrorCode(), c0722Jb.A04());
        KK.A00(new ZU(this, c0722Jb));
    }
}

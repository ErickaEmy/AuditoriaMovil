package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
/* loaded from: assets/audience_network.dex */
public final class SV extends AnonymousClass56 implements MJ {
    public C1U A00;
    public RD A01;
    public RE A02;
    public RE A03;
    public final int A04;
    public final SparseBooleanArray A05;
    public final C1116Yn A06;
    public final BK A07;

    public SV(BK bk2, SparseBooleanArray sparseBooleanArray, RE re, int i, C1116Yn c1116Yn, C1U c1u) {
        super(bk2);
        this.A06 = c1116Yn;
        this.A07 = bk2;
        this.A05 = sparseBooleanArray;
        this.A02 = re;
        this.A04 = i;
        this.A00 = c1u;
    }

    private void A0A(J2 j2, C0775Lg c0775Lg, String str, C0888Pp c0888Pp) {
        if (this.A05.get(c0888Pp.A02())) {
            return;
        }
        RE re = this.A03;
        if (re != null) {
            re.A0V();
            this.A03 = null;
        }
        this.A01 = new SX(this, str, c0888Pp, j2, c0888Pp.A04(), c0775Lg);
        RE re2 = new RE(this.A07, 10, new WeakReference(this.A01), this.A06);
        this.A03 = re2;
        re2.A0Y(false);
        this.A03.A0W(100);
        this.A03.A0X(100);
        this.A07.setOnAssetsLoadedListener(new SW(this, c0888Pp));
    }

    public final void A0j(C0888Pp c0888Pp, J2 j2, C04216c c04216c, C0775Lg c0775Lg, String str, int i, int i5, int i6) {
        int leftMargin = c0888Pp.A02();
        this.A07.setTag(-1593835536, Integer.valueOf(leftMargin));
        this.A07.setupNativeCtaExtension(c0888Pp);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i, -2);
        int i8 = leftMargin == 0 ? i6 : i5;
        if (leftMargin < this.A04 - 1) {
            i6 = i5;
        }
        marginLayoutParams.setMargins(i8, 0, i6, 0);
        String A07 = c0888Pp.A03().A0D().A07();
        String A08 = c0888Pp.A03().A0D().A08();
        this.A07.setIsVideo(!TextUtils.isEmpty(A08));
        if (this.A07.A18()) {
            this.A07.setVideoPlaceholderUrl(A07);
            this.A07.setVideoUrl(c04216c.A0S(A08));
        } else {
            this.A07.setImageUrl(A07);
        }
        this.A07.setLayoutParams(marginLayoutParams);
        this.A07.setCTAInfo(c0888Pp.A03().A0F(), c0888Pp.A04());
        this.A07.A19(c0888Pp.A04());
        A0A(j2, c0775Lg, str, c0888Pp);
    }

    public final void A0k(RE re) {
        this.A02 = re;
    }

    @Override // com.facebook.ads.redexgen.X.MJ
    public final void AFr() {
        this.A07.A13();
    }
}

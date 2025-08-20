package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.widget.FrameLayout;
import com.uv.v7.R;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public final class P3 extends FrameLayout {
    public static byte[] A0L;
    public static String[] A0M = {"tg98T7YqorVxljyy5rC9rRviyjZQ3PWt", "vfHBQfbeXMWpx0Lt9J2p4bolhXFdVoUD", "nuD8gLvjahybAxP4K7AI7EnQPexhi40p", "Mle9DIn2BhVQrDGkT0Ym6c4cXgC65WVc", "K7R1lop0AG70QQAdOPTNlaEDkQeUTiOI", "yRh0uKXr8zSd48KJrOgjFYKLFGGCRN1w", "QQOq4rDYvkiUVU0ErOwgNbjJJCuazTiH", "YmsKh0Z7MVbEzdUA2tq2qo4jdnYDOoVM"};
    public QM A00;
    public boolean A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public final AbstractC1219b5 A05;
    public final C04216c A06;
    public final C1116Yn A07;
    public final JA A08;
    public final MC A09;
    public final InterfaceC0804Mj A0A;
    public final P2 A0B;
    public final SF A0C;
    public final SA A0D;
    public final C9I A0E;
    public final AbstractC0893Pu A0F;
    public final AbstractC0891Ps A0G;
    public final AbstractC0860On A0H;
    public final O7 A0I;
    public final NX A0J;
    public final NQ A0K;

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0L, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 38);
        }
        return new String(copyOfRange);
    }

    public static void A0C() {
        A0L = new byte[]{5, 19, 20, 20, 3, 8, 18, 50, 15, 11, 3, 78, 95, 88, 75, 94, 67, 69, 68, 95, 71, 70, 87, 86, 98, 115, 103, 97, 119, 118, 80, 107, 71, 97, 119, 96, 38, 36, 57, 49, 36, 51, 37, 37};
    }

    static {
        A0C();
    }

    public P3(C1116Yn c1116Yn, J2 j2, AbstractC1219b5 abstractC1219b5, C04216c c04216c, JA ja, MC mc2, InterfaceC0804Mj interfaceC0804Mj, P2 p2) {
        super(c1116Yn);
        C0529At c0529At = new C0529At(this);
        this.A0J = c0529At;
        C0526Aq c0526Aq = new C0526Aq(this);
        this.A0I = c0526Aq;
        AZ az = new AZ(this);
        this.A0H = az;
        AY ay = new AY(this);
        this.A0K = ay;
        AX ax = new AX(this);
        this.A0F = ax;
        AW aw = new AW(this);
        this.A0G = aw;
        this.A03 = false;
        this.A04 = false;
        this.A02 = false;
        this.A01 = false;
        this.A07 = c1116Yn;
        this.A05 = abstractC1219b5;
        this.A06 = c04216c;
        this.A08 = ja;
        this.A09 = mc2;
        this.A0A = interfaceC0804Mj;
        SA sa = new SA(c1116Yn);
        this.A0D = sa;
        this.A0B = p2;
        sa.setFunnelLoggingHandler(ja);
        sa.getEventBus().A03(c0529At, c0526Aq, az, ay, ax, aw);
        C9I c9i = new C9I(c1116Yn, j2, sa, abstractC1219b5.A12());
        this.A0E = c9i;
        if (C0705Ih.A1X(c1116Yn)) {
            this.A0C = new SF(c1116Yn, j2, sa, abstractC1219b5.A12(), c9i, null);
        } else {
            this.A0C = null;
        }
        A0B();
        sa.setVideoURI(c04216c.A0S(abstractC1219b5.A0x().A0D().A08()));
        A09();
        AbstractC0783Lo.A0M(this, abstractC1219b5.A0w().A01().A07(true));
        String videoUrl = abstractC1219b5.A0x().A0D().A07();
        if (!TextUtils.isEmpty(videoUrl)) {
            OA.A00(c1116Yn, this, videoUrl);
        }
        addView(sa, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject A03() {
        return A04(this.A0D.getCurrentPositionInMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject A04(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A02(0, 11, 64), i);
            jSONObject.put(A02(11, 8, 12), this.A0D.getDuration());
            jSONObject.put(A02(19, 5, 20), this.A0D.A0h());
            jSONObject.put(A02(24, 12, 52), this.A0D.A0j());
            return jSONObject;
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07() {
        if (this.A02) {
            return;
        }
        if (A0M[4].charAt(2) == 'n') {
            throw new RuntimeException();
        }
        String[] strArr = A0M;
        strArr[2] = "wYD5NcGpzh0isOAoVzlYli3P4mnoyMgF";
        strArr[3] = "lJUNZHbcIhPOnD8CvxzjDicpi9xwJBJa";
        this.A02 = true;
    }

    private void A08() {
        this.A0D.postDelayed(new TH(this), C0705Ih.A0K(this.A07));
    }

    private void A09() {
        this.A0D.postDelayed(new TG(this), C0705Ih.A0L(this.A07));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A() {
        this.A0B.ADY(A02(36, 8, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle), A03());
    }

    private void A0B() {
        if (!TextUtils.isEmpty(this.A05.A0x().A0D().A07())) {
            C7R c7r = new C7R(this.A07);
            this.A0D.A0c(c7r);
            c7r.setImage(this.A05.A0x().A0D().A07());
        }
        C7C c7c = new C7C(this.A07, true, this.A08);
        this.A0D.A0c(c7c);
        this.A0D.A0c(new L7(c7c, QZ.A03, true));
        this.A0D.A0c(new C7H(this.A07));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0H(AnonymousClass93 anonymousClass93) {
        if (this.A0D.getState() == RB.A02 && C0705Ih.A1D(this.A07)) {
            this.A0D.postDelayed(new TF(this, anonymousClass93), 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0I(String str) {
        this.A07.A0E().A2z(str);
        if (C0705Ih.A1E(this.A07)) {
            A07();
            return;
        }
        MC mc2 = this.A09;
        InterfaceC0804Mj interfaceC0804Mj = this.A0A;
        String[] strArr = A0M;
        if (strArr[5].charAt(16) != strArr[6].charAt(16)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0M;
        strArr2[2] = "EBONCaOY6he3EVwrjSVJVgPSsddIWnnf";
        strArr2[3] = "quoo3J1Esh1kTLqYeLvwyhMYZuOues3Q";
        mc2.A43(interfaceC0804Mj.A6y());
        this.A09.A43(this.A0A.A6u());
    }

    public final void A0N() {
        this.A0D.setVolume(this.A05.A0x().A0D().A09() ? 0.0f : 1.0f);
        this.A0D.A0b(QM.A02, 26);
        A08();
    }

    public final void A0O() {
        SA sa = this.A0D;
        if (sa != null) {
            if (!this.A02) {
                sa.A0a(QH.A03);
            }
            this.A0D.getEventBus().A04(this.A0J, this.A0I, this.A0H, this.A0K, this.A0F, this.A0G);
            this.A0D.A0V();
        }
        SF sf = this.A0C;
        if (sf != null) {
            sf.A0C();
        }
        this.A0E.A0i();
    }

    public final void A0P() {
        this.A0D.A0Z(9);
        AbstractC0783Lo.A0T(this);
        AbstractC0783Lo.A0H(this.A0D);
        AbstractC0783Lo.A0a(this.A0D);
    }

    public final void A0Q() {
        this.A0D.A0a(QH.A04);
    }

    public final void A0R(boolean z2) {
        if (z2) {
            this.A0D.setVolume(0.0f);
        } else {
            this.A0D.setVolume(1.0f);
        }
        A0A();
        if (A0M[7].charAt(5) == 'u') {
            throw new RuntimeException();
        }
        A0M[4] = "yn69DofMHsLSVfdL7HK9OU5c1k1rZYJH";
    }

    public final void A0S(boolean z2) {
        if (this.A0D.A0i()) {
            return;
        }
        this.A00 = this.A0D.getVideoStartReason();
        this.A01 = z2;
        this.A0D.A0e(false, 19);
    }

    public final void A0T(boolean z2) {
        QM qm;
        if (this.A0D.A0j() || this.A02 || this.A0D.getState() == RB.A06 || (qm = this.A00) == null) {
            return;
        }
        boolean z3 = this.A01;
        if (A0M[7].charAt(5) == 'u') {
            throw new RuntimeException();
        }
        String[] strArr = A0M;
        strArr[1] = "icjW3n8vZZxsaCmttUmjcTI7CQu2m51p";
        strArr[0] = "kS3lp82K2YolC4kFtdcvtTBENFWE8ibh";
        if (!z3 || z2) {
            this.A0D.A0b(qm, 27);
        }
    }

    public final void A0U(boolean z2) {
        this.A0D.A0e(z2, 18);
    }

    public final void A0V(boolean z2) {
        this.A0D.A0b(QM.A04, 25);
    }
}

package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import com.uv.v7.R;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Zj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1137Zj implements C4B {
    public static byte[] A01;
    public static String[] A02 = {"m0v39bkLL0n2S0xNgN89hz2dGOcTpwho", "Je1TSnUfgjz87J45b10M9zAxXIUpZahJ", "5NPz60Ycb2xlrnlJbjQuqitLPDDjbzHA", "GN4TkK3T6zCNiBjoupvxTPY", "uEyRXI1LEgEguUOEBvXDLSZ", "uM6injuc1j2LJ4wHPsuMaMxVec9yzmkB", "WB5Y9xOLXhFok7BjZ8qu5ygjzkxXvdjS", "QTx8NC78KyDJtqbkFzNokRxLjqTFyIiz"};
    public final /* synthetic */ C0599Eb A00;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 37);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-39, -9, 2, 2, -5, -6, -74, -9, 10, 10, -9, -7, -2, -74, 5, 4, -74, -9, -74, -7, -2, -1, 2, -6, -74, 13, -2, -1, -7, -2, -74, -1, 9, -74, 4, 5, 10, -74, -6, -5, 10, -9, -7, -2, -5, -6, -48, -74, -75, -77, -66, -66, -73, -74, 114, -74, -73, -58, -77, -75, -70, 114, -63, -64, 114, -77, -64, 114, -77, -66, -60, -73, -77, -74, -53, 114, -74, -73, -58, -77, -75, -70, -73, -74, 114, -75, -70, -69, -66, -74, 114};
    }

    static {
        A01();
    }

    public C1137Zj(C0599Eb c0599Eb) {
        this.A00 = c0599Eb;
    }

    @Override // com.facebook.ads.redexgen.X.C4B
    public final void A3e(View view, int i, ViewGroup.LayoutParams layoutParams) {
        AnonymousClass56 A0F = C0599Eb.A0F(view);
        if (A0F != null) {
            if (A0F.A0c() || A0F.A0f()) {
                A0F.A0P();
            } else {
                throw new IllegalArgumentException(A00(0, 48, R.styleable.AppCompatTheme_toolbarStyle) + A0F + this.A00.A1H());
            }
        }
        this.A00.attachViewToParent(view, i, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.C4B
    public final void A57(int i) {
        AnonymousClass56 A0F;
        View view = A6M(i);
        if (view != null && (A0F = C0599Eb.A0F(view)) != null) {
            if (!A0F.A0c() || A0F.A0f()) {
                A0F.A0T(256);
            } else {
                throw new IllegalArgumentException(A00(48, 43, 45) + A0F + this.A00.A1H());
            }
        }
        this.A00.detachViewFromParent(i);
    }

    @Override // com.facebook.ads.redexgen.X.C4B
    public final View A6M(int i) {
        return this.A00.getChildAt(i);
    }

    @Override // com.facebook.ads.redexgen.X.C4B
    public final int A6N() {
        return this.A00.getChildCount();
    }

    @Override // com.facebook.ads.redexgen.X.C4B
    public final AnonymousClass56 A6Q(View view) {
        return C0599Eb.A0F(view);
    }

    @Override // com.facebook.ads.redexgen.X.C4B
    public final int A8n(View view) {
        return this.A00.indexOfChild(view);
    }

    @Override // com.facebook.ads.redexgen.X.C4B
    public final void ABQ(View view) {
        AnonymousClass56 A0F = C0599Eb.A0F(view);
        if (A0F != null) {
            A0F.A07(this.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C4B
    public final void ABx(View view) {
        AnonymousClass56 A0F = C0599Eb.A0F(view);
        if (A0F != null) {
            A0F.A08(this.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C4B
    public final void AF6() {
        int A6N = A6N();
        for (int i = 0; i < A6N; i++) {
            View A6M = A6M(i);
            this.A00.A1e(A6M);
            A6M.clearAnimation();
        }
        this.A00.removeAllViews();
        String[] strArr = A02;
        String str = strArr[3];
        String str2 = strArr[4];
        int length = str.length();
        int count = str2.length();
        if (length != count) {
            throw new RuntimeException();
        }
        A02[2] = "YVtNrV2twtC96zFGqk3M5li58NeZhLji";
    }

    @Override // com.facebook.ads.redexgen.X.C4B
    public final void AFA(int i) {
        View childAt = this.A00.getChildAt(i);
        if (childAt != null) {
            this.A00.A1e(childAt);
            childAt.clearAnimation();
        }
        C0599Eb c0599Eb = this.A00;
        if (A02[2].charAt(25) == 'R') {
            throw new RuntimeException();
        }
        A02[2] = "BurwQQkBxJzMJJK1acCycPqXpvrCcXzS";
        c0599Eb.removeViewAt(i);
    }

    @Override // com.facebook.ads.redexgen.X.C4B
    public final void addView(View view, int i) {
        this.A00.addView(view, i);
        this.A00.A1d(view);
    }
}

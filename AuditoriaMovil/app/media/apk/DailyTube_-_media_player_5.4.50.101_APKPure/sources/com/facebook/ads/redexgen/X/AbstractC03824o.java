package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.uv.v7.R;
import java.util.ArrayList;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.4o  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC03824o {
    public static byte[] A0I;
    public static String[] A0J = {"NGwI4w5wjKKwr8vIXUEBgcadgt82Mvhc", "UEWVJJvMFTFlt7hH7ERCIJOXwkHPD", "VrTEPZjwbsMyuvHOm", "2WwBzOWctlsBfaK16SO", "SN9IkStz5", "kDHla2kaeJhueA2usdy0jZceB2KGO", "Oz8ehwpCKAgd43CqPtwSSE9zN5", "pRsAYaXPUkY6EiG3qKZOmbtQ8"};
    public int A00;
    public C4C A01;
    public AnonymousClass51 A02;
    public C0599Eb A03;
    public C5B A04;
    public C5B A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public boolean A0E;
    public boolean A0F;
    public final AnonymousClass59 A0G;
    public final AnonymousClass59 A0H;

    public static String A07(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0I, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 75);
        }
        return new String(copyOfRange);
    }

    public static void A08() {
        byte[] bArr = {-2, 33, 33, 34, 33, -35, 19, 38, 34, 52, -35, 37, 30, 48, -35, 15, 34, 32, 54, 32, 41, 34, 47, 19, 38, 34, 52, -35, 30, 48, -35, 45, 30, 47, 34, 43, 49, -35, 31, 50, 49, -35, 51, 38, 34, 52, -35, 38, 48, -35, 43, 44, 49, -35, 30, -35, 47, 34, 30, 41, -35, 32, 37, 38, 41, 33, -21, -35, 18, 43, 35, 38, 41, 49, 34, 47, 34, 33, -35, 38, 43, 33, 34, 53, -9, -35, -5, 8, 8, 9, 14, -70, 7, 9, 16, -1, -70, -5, -70, -3, 2, 3, 6, -2, -70, 0, 12, 9, 7, -70, 8, 9, 8, -57, -1, 18, 3, 13, 14, 3, 8, 1, -70, 3, 8, -2, -1, 18, -44};
        String[] strArr = A0J;
        if (strArr[2].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        A0J[6] = "kyP20liVKsmkdJ";
        A0I = bArr;
    }

    public abstract int A1d(int i, C03894w c03894w, AnonymousClass53 anonymousClass53);

    public abstract int A1e(int i, C03894w c03894w, AnonymousClass53 anonymousClass53);

    public abstract int A1f(AnonymousClass53 anonymousClass53);

    public abstract int A1g(AnonymousClass53 anonymousClass53);

    public abstract int A1h(AnonymousClass53 anonymousClass53);

    public abstract int A1i(AnonymousClass53 anonymousClass53);

    public abstract int A1j(AnonymousClass53 anonymousClass53);

    public abstract int A1k(AnonymousClass53 anonymousClass53);

    public abstract Parcelable A1l();

    public abstract View A1n(View view, int i, C03894w c03894w, AnonymousClass53 anonymousClass53);

    public abstract C03834p A1o();

    public abstract void A1p(int i);

    public abstract void A1q(int i, int i5, AnonymousClass53 anonymousClass53, InterfaceC03804m interfaceC03804m);

    public abstract void A1r(int i, InterfaceC03804m interfaceC03804m);

    public abstract void A1s(Parcelable parcelable);

    public abstract void A1u(C03894w c03894w, AnonymousClass53 anonymousClass53);

    public abstract void A1x(C0599Eb c0599Eb, AnonymousClass53 anonymousClass53, int i);

    public abstract boolean A1z();

    public abstract boolean A20();

    public abstract boolean A21();

    public abstract boolean A22();

    static {
        A08();
    }

    public AbstractC03824o() {
        C1134Zg c1134Zg = new C1134Zg(this);
        this.A0G = c1134Zg;
        C1133Zf c1133Zf = new C1133Zf(this);
        this.A0H = c1133Zf;
        this.A04 = new C5B(c1134Zg);
        this.A05 = new C5B(c1133Zf);
        this.A09 = false;
        this.A07 = false;
        this.A06 = false;
        this.A0F = true;
        this.A0E = true;
    }

    public static int A00(int i, int i5, int i6) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                int mode2 = Math.max(i5, i6);
                return Math.min(size, mode2);
            case 1073741824:
                return size;
            default:
                int mode3 = Math.max(i5, i6);
                return mode3;
        }
    }

    public static int A01(int i, int i5, int i6, int i8, boolean z2) {
        int max = Math.max(0, i - i6);
        int i10 = 0;
        int resultMode = 0;
        if (z2) {
            if (i8 >= 0) {
                i10 = i8;
                String[] strArr = A0J;
                String str = strArr[5];
                String str2 = strArr[1];
                int resultSize = str.length();
                int size = str2.length();
                if (resultSize != size) {
                    throw new RuntimeException();
                }
                A0J[6] = "ru0BYCJI67FO4KgBABZqajada";
                resultMode = 1073741824;
            } else if (i8 == -1) {
                switch (i5) {
                    case Integer.MIN_VALUE:
                    case 1073741824:
                        i10 = max;
                        resultMode = i5;
                        break;
                    case 0:
                        i10 = 0;
                        int resultSize2 = A0J[3].length();
                        if (resultSize2 == 28) {
                            resultMode = 0;
                            break;
                        } else {
                            A0J[7] = "Nw";
                            resultMode = 0;
                            break;
                        }
                }
            } else if (i8 == -2) {
                i10 = 0;
                resultMode = 0;
            }
        } else if (i8 >= 0) {
            i10 = i8;
            resultMode = 1073741824;
        } else if (i8 == -1) {
            i10 = max;
            resultMode = i5;
        } else if (i8 == -2) {
            i10 = max;
            resultMode = (i5 == Integer.MIN_VALUE || i5 == 1073741824) ? Integer.MIN_VALUE : 0;
        }
        int size2 = View.MeasureSpec.makeMeasureSpec(i10, resultMode);
        return size2;
    }

    private final int A02(View view) {
        return ((C03834p) view.getLayoutParams()).A03.bottom;
    }

    private final int A03(View view) {
        return ((C03834p) view.getLayoutParams()).A03.left;
    }

    private final int A04(View view) {
        return ((C03834p) view.getLayoutParams()).A03.right;
    }

    private final int A05(View view) {
        return ((C03834p) view.getLayoutParams()).A03.top;
    }

    private final int A06(C03894w c03894w, AnonymousClass53 anonymousClass53) {
        return 0;
    }

    private final void A09(int i) {
        A0C(i, A0t(i));
    }

    private final void A0A(int i) {
        View child = A0t(i);
        if (child != null) {
            this.A01.A0D(i);
        }
    }

    private final void A0B(int i, int i5) {
        View view = A0t(i);
        if (view != null) {
            A09(i);
            A0E(view, i5);
            return;
        }
        throw new IllegalArgumentException(A07(85, 44, 79) + i + this.A03.toString());
    }

    private void A0C(int i, View view) {
        this.A01.A0C(i);
    }

    private final void A0D(View view) {
        this.A01.A0F(view);
    }

    private final void A0E(View view, int i) {
        A0F(view, i, (C03834p) view.getLayoutParams());
    }

    private final void A0F(View view, int i, C03834p c03834p) {
        AnonymousClass56 A0F = C0599Eb.A0F(view);
        if (A0F.A0a()) {
            this.A03.A0t.A09(A0F);
        } else {
            C5E c5e = this.A03.A0t;
            String[] strArr = A0J;
            if (strArr[5].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            A0J[0] = "mtQ3Ck4zhf6OC1ISSa3eadAcnNcPftbe";
            c5e.A0A(A0F);
        }
        this.A01.A0H(view, i, c03834p, A0F.A0a());
    }

    private void A0G(View view, int i, boolean z2) {
        AnonymousClass56 A0F = C0599Eb.A0F(view);
        if (z2 || A0F.A0a()) {
            this.A03.A0t.A09(A0F);
        } else {
            this.A03.A0t.A0A(A0F);
        }
        C03834p c03834p = (C03834p) view.getLayoutParams();
        if (A0F.A0g() || A0F.A0b()) {
            if (A0F.A0b()) {
                A0F.A0S();
            } else {
                A0F.A0O();
            }
            this.A01.A0H(view, i, view.getLayoutParams(), false);
        } else {
            ViewParent parent = view.getParent();
            C0599Eb c0599Eb = this.A03;
            String[] strArr = A0J;
            if (strArr[5].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            A0J[7] = "5ABI9jSeQ";
            if (parent == c0599Eb) {
                int currentIndex = this.A01.A07(view);
                if (i == -1) {
                    i = this.A01.A05();
                }
                if (currentIndex != -1) {
                    if (currentIndex != i) {
                        this.A03.A06.A0B(currentIndex, i);
                    }
                } else {
                    throw new IllegalStateException(A07(0, 85, R.styleable.AppCompatTheme_tooltipForegroundColor) + this.A03.indexOfChild(view) + this.A03.A1H());
                }
            } else {
                this.A01.A0I(view, i, false);
                c03834p.A01 = true;
                AnonymousClass51 anonymousClass51 = this.A02;
                if (anonymousClass51 != null && anonymousClass51.A0F()) {
                    this.A02.A0C(view);
                }
            }
        }
        if (c03834p.A02) {
            A0F.A0H.invalidate();
            c03834p.A02 = false;
        }
    }

    private final void A0H(View view, Rect rect) {
        C0599Eb.A0o(view, rect);
    }

    private void A0J(C03894w c03894w, int i, View view) {
        AnonymousClass56 A0F = C0599Eb.A0F(view);
        if (A0F.A0f()) {
            return;
        }
        if (A0F.A0Z() && !A0F.A0a() && !this.A03.A04.A0A()) {
            A0A(i);
            c03894w.A0X(A0F);
            return;
        }
        A09(i);
        c03894w.A0S(view);
        this.A03.A0t.A0C(A0F);
    }

    private final void A0K(C03894w c03894w, AnonymousClass53 anonymousClass53, AccessibilityEvent accessibilityEvent) {
        C0599Eb c0599Eb = this.A03;
        if (c0599Eb == null || accessibilityEvent == null) {
            return;
        }
        boolean z2 = true;
        if (A0J[6].length() == 1) {
            throw new RuntimeException();
        }
        String[] strArr = A0J;
        strArr[2] = "A1LbQwkKC8kdEmdjm";
        strArr[4] = "mpAFCzQjd";
        if (!c0599Eb.canScrollVertically(1) && !this.A03.canScrollVertically(-1) && !this.A03.canScrollHorizontally(-1) && !this.A03.canScrollHorizontally(1)) {
            z2 = false;
        }
        accessibilityEvent.setScrollable(z2);
        if (A0J[7].length() != 8) {
            A0J[0] = "LKoEdNrfwYhRE769hHSL4lsoF7TmWWKx";
            if (this.A03.A04 == null) {
                return;
            }
        } else if (this.A03.A04 == null) {
            return;
        }
        accessibilityEvent.setItemCount(this.A03.A04.A0E());
    }

    private final void A0L(C03894w c03894w, AnonymousClass53 anonymousClass53, C03613s c03613s) {
        if (this.A03.canScrollVertically(-1) || this.A03.canScrollHorizontally(-1)) {
            c03613s.A0N(8192);
            c03613s.A0R(true);
        }
        if (this.A03.canScrollVertically(1) || this.A03.canScrollHorizontally(1)) {
            c03613s.A0N(4096);
            String[] strArr = A0J;
            if (strArr[5].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0J;
            strArr2[2] = "WKK7ZU1nOyoZ4isR3";
            strArr2[4] = "S1xUaVTVF";
            c03613s.A0R(true);
        }
        C03583p collectionInfo = C03583p.A00(A0r(c03894w, anonymousClass53), A0q(c03894w, anonymousClass53), A0P(c03894w, anonymousClass53), A06(c03894w, anonymousClass53));
        c03613s.A0P(collectionInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0M(AnonymousClass51 anonymousClass51) {
        if (this.A02 == anonymousClass51) {
            this.A02 = null;
        }
    }

    private final boolean A0N() {
        AnonymousClass51 anonymousClass51 = this.A02;
        return anonymousClass51 != null && anonymousClass51.A0F();
    }

    public static boolean A0O(int i, int i5, int i6) {
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        if (i6 > 0 && i != i6) {
            return false;
        }
        switch (mode) {
            case Integer.MIN_VALUE:
                return size >= i;
            case 0:
                return true;
            case 1073741824:
                return size == i;
            default:
                return false;
        }
    }

    private final boolean A0P(C03894w c03894w, AnonymousClass53 anonymousClass53) {
        return false;
    }

    private final boolean A0Q(C03894w c03894w, AnonymousClass53 anonymousClass53, int i, Bundle bundle) {
        C0599Eb c0599Eb = this.A03;
        if (c0599Eb == null) {
            return false;
        }
        int i5 = 0;
        int i6 = 0;
        switch (i) {
            case 4096:
                if (c0599Eb.canScrollVertically(1)) {
                    i5 = (A0X() - A0g()) - A0d();
                }
                if (this.A03.canScrollHorizontally(1)) {
                    i6 = (A0h() - A0e()) - A0f();
                    break;
                }
                break;
            case 8192:
                if (c0599Eb.canScrollVertically(-1)) {
                    i5 = -((A0X() - A0g()) - A0d());
                }
                if (this.A03.canScrollHorizontally(-1)) {
                    i6 = -((A0h() - A0e()) - A0f());
                    break;
                }
                break;
        }
        if (i5 == 0 && i6 == 0) {
            return false;
        }
        C0599Eb c0599Eb2 = this.A03;
        if (A0J[7].length() != 8) {
            A0J[7] = "6TTpYbQ6a4";
            c0599Eb2.scrollBy(i6, i5);
            return true;
        }
        throw new RuntimeException();
    }

    private final boolean A0R(C03894w c03894w, AnonymousClass53 anonymousClass53, View view, int i, Bundle bundle) {
        return false;
    }

    private boolean A0S(C0599Eb c0599Eb, int i, int i5) {
        View focusedChild = c0599Eb.getFocusedChild();
        if (focusedChild == null) {
            return false;
        }
        int parentBottom = A0e();
        int parentRight = A0g();
        int parentTop = A0h();
        int parentTop2 = parentTop - A0f();
        int parentLeft = A0X();
        int parentLeft2 = parentLeft - A0d();
        Rect rect = this.A03.A0p;
        A0H(focusedChild, rect);
        if (rect.left - i >= parentTop2 || rect.right - i <= parentBottom || rect.top - i5 >= parentLeft2 || rect.bottom - i5 <= parentRight) {
            return false;
        }
        if (A0J[3].length() != 28) {
            A0J[0] = "D1nd79aIos3YYe4Hq7EzCaafqnQh2NEe";
            return true;
        }
        throw new RuntimeException();
    }

    @Deprecated
    private final boolean A0T(C0599Eb c0599Eb, View view, View view2) {
        return A0N() || c0599Eb.A1q();
    }

    private int[] A0U(View view, Rect rect) {
        int[] iArr = new int[2];
        int offScreenRight = A0e();
        int offScreenTop = A0g();
        int dy = A0h() - A0f();
        int offScreenLeft = A0X() - A0d();
        int childBottom = (view.getLeft() + rect.left) - view.getScrollX();
        int childRight = (view.getTop() + rect.top) - view.getScrollY();
        int childTop = rect.width() + childBottom;
        int parentLeft = rect.height();
        int childLeft = Math.min(0, childBottom - offScreenRight);
        int parentBottom = Math.min(0, childRight - offScreenTop);
        int parentTop = Math.max(0, childTop - dy);
        int parentLeft2 = Math.max(0, (parentLeft + childRight) - offScreenLeft);
        if (A0a() == 1) {
            if (parentTop == 0) {
                parentTop = Math.max(childLeft, childTop - dy);
            }
        } else {
            parentTop = childLeft != 0 ? childLeft : Math.min(childBottom - offScreenRight, parentTop);
        }
        if (parentBottom == 0) {
            parentBottom = Math.min(childRight - offScreenTop, parentLeft2);
        }
        iArr[0] = parentTop;
        iArr[1] = parentBottom;
        if (A0J[0].charAt(31) != 'p') {
            A0J[0] = "97vXAXgJ0WxvI5IvBZpOR2Ky1DZNuVnu";
            return iArr;
        }
        throw new RuntimeException();
    }

    public final int A0V() {
        return -1;
    }

    public final int A0W() {
        C4C c4c = this.A01;
        if (c4c != null) {
            return c4c.A05();
        }
        return 0;
    }

    public final int A0X() {
        return this.A0A;
    }

    public final int A0Y() {
        return this.A0B;
    }

    public final int A0Z() {
        C0599Eb c0599Eb = this.A03;
        AbstractC03704c a2 = c0599Eb != null ? c0599Eb.getAdapter() : null;
        if (a2 != null) {
            return a2.A0E();
        }
        return 0;
    }

    public final int A0a() {
        return C3T.A01(this.A03);
    }

    public final int A0b() {
        return C3T.A02(this.A03);
    }

    public final int A0c() {
        return C3T.A03(this.A03);
    }

    public final int A0d() {
        C0599Eb c0599Eb = this.A03;
        if (c0599Eb != null) {
            return c0599Eb.getPaddingBottom();
        }
        return 0;
    }

    public final int A0e() {
        C0599Eb c0599Eb = this.A03;
        if (c0599Eb != null) {
            return c0599Eb.getPaddingLeft();
        }
        return 0;
    }

    public final int A0f() {
        C0599Eb c0599Eb = this.A03;
        if (c0599Eb != null) {
            return c0599Eb.getPaddingRight();
        }
        return 0;
    }

    public final int A0g() {
        C0599Eb c0599Eb = this.A03;
        if (c0599Eb != null) {
            return c0599Eb.getPaddingTop();
        }
        return 0;
    }

    public final int A0h() {
        return this.A0C;
    }

    public final int A0i() {
        return this.A0D;
    }

    public final int A0j(View view) {
        return view.getBottom() + A02(view);
    }

    public final int A0k(View view) {
        return view.getLeft() - A03(view);
    }

    public final int A0l(View view) {
        Rect rect = ((C03834p) view.getLayoutParams()).A03;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public final int A0m(View view) {
        Rect rect = ((C03834p) view.getLayoutParams()).A03;
        return view.getMeasuredWidth() + rect.left + rect.right;
    }

    public final int A0n(View view) {
        return view.getRight() + A04(view);
    }

    public final int A0o(View view) {
        return view.getTop() - A05(view);
    }

    public final int A0p(View view) {
        return ((C03834p) view.getLayoutParams()).A00();
    }

    public int A0q(C03894w c03894w, AnonymousClass53 anonymousClass53) {
        C0599Eb c0599Eb = this.A03;
        if (c0599Eb == null || c0599Eb.A04 == null || !A20()) {
            return 1;
        }
        return this.A03.A04.A0E();
    }

    public int A0r(C03894w c03894w, AnonymousClass53 anonymousClass53) {
        C0599Eb c0599Eb = this.A03;
        if (c0599Eb == null || c0599Eb.A04 == null || !A21()) {
            return 1;
        }
        return this.A03.A04.A0E();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View A0s() {
        /*
            r6 = this;
            com.facebook.ads.redexgen.X.Eb r0 = r6.A03
            r5 = 0
            if (r0 != 0) goto L6
            return r5
        L6:
            android.view.View r3 = r0.getFocusedChild()
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AbstractC03824o.A0J
            r0 = 5
            r1 = r2[r0]
            r0 = 1
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L22
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L22:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AbstractC03824o.A0J
            java.lang.String r1 = "iiKud1wfkCloFGZ1U"
            r0 = 3
            r2[r0] = r1
            if (r3 == 0) goto L4c
            com.facebook.ads.redexgen.X.4C r4 = r6.A01
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AbstractC03824o.A0J
            r0 = 5
            r1 = r2[r0]
            r0 = 1
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L4d
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AbstractC03824o.A0J
            java.lang.String r1 = "7ET4ZuKdeEmot2qkcvXky1gJdqYIXUUX"
            r0 = 0
            r2[r0] = r1
            boolean r0 = r4.A0K(r3)
            if (r0 == 0) goto L5b
        L4c:
            return r5
        L4d:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AbstractC03824o.A0J
            java.lang.String r1 = "xPYIlKgRfeB9qWlMIQGlIgoODb"
            r0 = 7
            r2[r0] = r1
            boolean r0 = r4.A0K(r3)
            if (r0 == 0) goto L5b
            goto L4c
        L5b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC03824o.A0s():android.view.View");
    }

    public final View A0t(int i) {
        C4C c4c = this.A01;
        if (c4c != null) {
            return c4c.A09(i);
        }
        return null;
    }

    public final View A0u(View view, int i) {
        return null;
    }

    public C03834p A0v(Context context, AttributeSet attributeSet) {
        return new C03834p(context, attributeSet);
    }

    public C03834p A0w(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C03834p) {
            return new C03834p((C03834p) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C03834p((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C03834p(layoutParams);
    }

    public final void A0x() {
        AnonymousClass51 anonymousClass51 = this.A02;
        if (anonymousClass51 != null) {
            anonymousClass51.A09();
        }
    }

    public final void A0y() {
        C0599Eb c0599Eb = this.A03;
        if (c0599Eb != null) {
            c0599Eb.requestLayout();
        }
    }

    public final void A0z(int i) {
        C0599Eb c0599Eb = this.A03;
        if (c0599Eb != null) {
            c0599Eb.A1T(i);
        }
    }

    public final void A10(int i) {
        C0599Eb c0599Eb = this.A03;
        if (c0599Eb != null) {
            c0599Eb.A1U(i);
        }
    }

    public final void A11(int i, int i5) {
        this.A0C = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        this.A0D = mode;
        if (mode == 0 && !C0599Eb.A1B) {
            this.A0C = 0;
        }
        this.A0A = View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i5);
        this.A0B = mode2;
        if (mode2 == 0 && !C0599Eb.A1B) {
            this.A0A = 0;
        }
    }

    public final void A12(int i, int i5) {
        int A0W = A0W();
        if (A0W == 0) {
            this.A03.A1a(i, i5);
            return;
        }
        int i6 = Integer.MAX_VALUE;
        int i8 = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (int i10 = 0; i10 < A0W; i10++) {
            View A0t = A0t(i10);
            Rect rect = this.A03.A0p;
            A0H(A0t, rect);
            int count = rect.left;
            if (count < i6) {
                i6 = rect.left;
            }
            int count2 = rect.right;
            if (count2 > maxY) {
                maxY = rect.right;
            }
            int count3 = rect.top;
            if (count3 < i8) {
                i8 = rect.top;
            }
            int count4 = rect.bottom;
            if (count4 > maxX) {
                maxX = rect.bottom;
            }
        }
        this.A03.A0p.set(i6, i8, maxY, maxX);
        String[] strArr = A0J;
        String str = strArr[2];
        String str2 = strArr[4];
        int minX = str.length();
        int count5 = str2.length();
        if (minX == count5) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0J;
        strArr2[2] = "hT857kPIBtMq0qM94";
        strArr2[4] = "qfhhOTku3";
        A15(this.A03.A0p, i, i5);
    }

    public final void A13(int i, int i5) {
        this.A03.setMeasuredDimension(i, i5);
    }

    public final void A14(int i, C03894w c03894w) {
        View view = A0t(i);
        A0A(i);
        c03894w.A0T(view);
    }

    public void A15(Rect rect, int i, int i5) {
        int usedHeight = rect.width() + A0e() + A0f();
        int height = rect.height();
        int usedWidth = A0g();
        int i6 = height + usedWidth;
        int usedWidth2 = A0d();
        int width = i6 + usedWidth2;
        int usedWidth3 = A0c();
        int usedHeight2 = A00(i, usedHeight, usedWidth3);
        int usedWidth4 = A0b();
        A13(usedHeight2, A00(i5, width, usedWidth4));
    }

    public final void A16(View view) {
        A18(view, -1);
    }

    public final void A17(View view) {
        A19(view, -1);
    }

    public final void A18(View view, int i) {
        A0G(view, i, true);
    }

    public final void A19(View view, int i) {
        A0G(view, i, false);
    }

    public final void A1A(View view, int i, int i5) {
        C03834p c03834p = (C03834p) view.getLayoutParams();
        Rect A1D = this.A03.A1D(view);
        int i6 = i + A1D.left + A1D.right;
        int i8 = i5 + A1D.top + A1D.bottom;
        int A01 = A01(A0h(), A0i(), A0e() + A0f() + c03834p.leftMargin + c03834p.rightMargin + i6, c03834p.width, A20());
        int A0X = A0X();
        int A0Y = A0Y();
        int widthSpec = A0g();
        int A012 = A01(A0X, A0Y, widthSpec + A0d() + c03834p.topMargin + c03834p.bottomMargin + i8, c03834p.height, A21());
        if (A1W(view, A01, A012, c03834p)) {
            view.measure(A01, A012);
        }
    }

    public final void A1B(View view, int i, int i5, int i6, int i8) {
        C03834p c03834p = (C03834p) view.getLayoutParams();
        Rect rect = c03834p.A03;
        view.layout(rect.left + i + c03834p.leftMargin, rect.top + i5 + c03834p.topMargin, (i6 - rect.right) - c03834p.rightMargin, (i8 - rect.bottom) - c03834p.bottomMargin);
    }

    public final void A1C(View view, C03613s c03613s) {
        AnonymousClass56 A0F = C0599Eb.A0F(view);
        if (A0F != null && !A0F.A0a() && !this.A01.A0K(A0F.A0H)) {
            A1K(this.A03.A0r, this.A03.A0s, view, c03613s);
        }
    }

    public final void A1D(View view, C03894w c03894w) {
        A0D(view);
        c03894w.A0T(view);
    }

    public final void A1E(View view, boolean z2, Rect rect) {
        Matrix matrix;
        if (z2) {
            Rect rect2 = ((C03834p) view.getLayoutParams()).A03;
            rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        } else {
            rect.set(0, 0, view.getWidth(), view.getHeight());
        }
        if (this.A03 != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.A03.A0q;
            rectF.set(rect);
            matrix.mapRect(rectF);
            int floor = (int) Math.floor(rectF.left);
            int floor2 = (int) Math.floor(rectF.top);
            float f4 = rectF.right;
            String[] strArr = A0J;
            if (strArr[5].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            A0J[7] = "WbBFuKAltYM";
            rect.set(floor, floor2, (int) Math.ceil(f4), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public final void A1F(C03613s c03613s) {
        A0L(this.A03.A0r, this.A03.A0s, c03613s);
    }

    public final void A1G(C03894w c03894w) {
        int A0E = c03894w.A0E();
        for (int i = A0E - 1; i >= 0; i--) {
            View A0F = c03894w.A0F(i);
            AnonymousClass56 A0F2 = C0599Eb.A0F(A0F);
            if (!A0F2.A0f()) {
                A0F2.A0X(false);
                if (A0F2.A0c()) {
                    this.A03.removeDetachedView(A0F, false);
                }
                if (this.A03.A05 != null) {
                    this.A03.A05.A0K(A0F2);
                }
                A0F2.A0X(true);
                c03894w.A0R(A0F);
            }
        }
        c03894w.A0L();
        if (A0E > 0) {
            this.A03.invalidate();
        }
    }

    public final void A1H(C03894w c03894w) {
        int childCount = A0W();
        for (int i = childCount - 1; i >= 0; i--) {
            A0J(c03894w, i, A0t(i));
        }
    }

    public final void A1I(C03894w c03894w) {
        for (int A0W = A0W() - 1; A0W >= 0; A0W--) {
            if (!C0599Eb.A0F(A0t(A0W)).A0f()) {
                A14(A0W, c03894w);
            }
        }
    }

    public void A1J(C03894w c03894w, AnonymousClass53 anonymousClass53, int i, int i5) {
        this.A03.A1a(i, i5);
    }

    public void A1K(C03894w c03894w, AnonymousClass53 anonymousClass53, View view, C03613s c03613s) {
        int A0p = A21() ? A0p(view) : 0;
        int A0p2 = A20() ? A0p(view) : 0;
        String[] strArr = A0J;
        if (strArr[5].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        A0J[3] = "h476R5jl";
        C03593q itemInfo = C03593q.A00(A0p, 1, A0p2, 1, false, false);
        c03613s.A0Q(itemInfo);
    }

    public final void A1L(AnonymousClass51 anonymousClass51) {
        AnonymousClass51 anonymousClass512 = this.A02;
        if (anonymousClass512 != null && anonymousClass51 != anonymousClass512 && anonymousClass512.A0F()) {
            this.A02.A09();
        }
        this.A02 = anonymousClass51;
        anonymousClass51.A0D(this.A03, this);
    }

    public void A1M(C0599Eb c0599Eb) {
    }

    public final void A1N(C0599Eb c0599Eb) {
        this.A07 = true;
    }

    public final void A1O(C0599Eb c0599Eb) {
        A11(View.MeasureSpec.makeMeasureSpec(c0599Eb.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(c0599Eb.getHeight(), 1073741824));
    }

    public final void A1P(C0599Eb c0599Eb) {
        if (c0599Eb == null) {
            this.A03 = null;
            this.A01 = null;
            this.A0C = 0;
            this.A0A = 0;
        } else {
            this.A03 = c0599Eb;
            this.A01 = c0599Eb.A01;
            this.A0C = c0599Eb.getWidth();
            this.A0A = c0599Eb.getHeight();
        }
        this.A0D = 1073741824;
        this.A0B = 1073741824;
    }

    public final void A1Q(C0599Eb c0599Eb, C03894w c03894w) {
        this.A07 = false;
        A1w(c0599Eb, c03894w);
    }

    public final void A1R(boolean z2) {
        this.A06 = z2;
    }

    public final boolean A1S() {
        int A0W = A0W();
        for (int i = 0; i < A0W; i++) {
            ViewGroup.LayoutParams layoutParams = A0t(i).getLayoutParams();
            int childCount = layoutParams.width;
            if (childCount < 0) {
                int childCount2 = layoutParams.height;
                if (childCount2 < 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean A1T() {
        C0599Eb c0599Eb = this.A03;
        return c0599Eb != null && c0599Eb.A0B;
    }

    public final boolean A1U() {
        return this.A0E;
    }

    public final boolean A1V(int i, Bundle bundle) {
        return A0Q(this.A03.A0r, this.A03.A0s, i, bundle);
    }

    public final boolean A1W(View view, int i, int i5, C03834p c03834p) {
        return (!view.isLayoutRequested() && this.A0F && A0O(view.getWidth(), i, c03834p.width) && A0O(view.getHeight(), i5, c03834p.height)) ? false : true;
    }

    public final boolean A1X(View view, int i, Bundle bundle) {
        return A0R(this.A03.A0r, this.A03.A0s, view, i, bundle);
    }

    public boolean A1Y(C03834p c03834p) {
        return c03834p != null;
    }

    public final boolean A1Z(C0599Eb c0599Eb, View view, Rect rect, boolean z2) {
        return A1a(c0599Eb, view, rect, z2, false);
    }

    public final boolean A1a(C0599Eb c0599Eb, View view, Rect rect, boolean z2, boolean z3) {
        int[] scrollAmount = A0U(view, rect);
        int i = scrollAmount[0];
        int i5 = scrollAmount[1];
        if ((z3 && !A0S(c0599Eb, i, i5)) || (i == 0 && i5 == 0)) {
            return false;
        }
        if (z2) {
            c0599Eb.scrollBy(i, i5);
        } else {
            c0599Eb.A1c(i, i5);
        }
        return true;
    }

    public final boolean A1b(C0599Eb c0599Eb, AnonymousClass53 anonymousClass53, View view, View view2) {
        return A0T(c0599Eb, view, view2);
    }

    public final boolean A1c(C0599Eb c0599Eb, ArrayList<View> views, int i, int i5) {
        return false;
    }

    public View A1m(int i) {
        int A0W = A0W();
        for (int i5 = 0; i5 < A0W; i5++) {
            View child = A0t(i5);
            AnonymousClass56 A0F = C0599Eb.A0F(child);
            if (A0F != null) {
                int childCount = A0F.A0I();
                if (childCount == i && !A0F.A0f() && (this.A03.A0s.A07() || !A0F.A0a())) {
                    return child;
                }
            }
        }
        return null;
    }

    public void A1t(AccessibilityEvent accessibilityEvent) {
        A0K(this.A03.A0r, this.A03.A0s, accessibilityEvent);
    }

    public void A1v(AnonymousClass53 anonymousClass53) {
    }

    public void A1w(C0599Eb c0599Eb, C03894w c03894w) {
    }

    public void A1y(String str) {
        C0599Eb c0599Eb = this.A03;
        if (c0599Eb != null) {
            c0599Eb.A1l(str);
        }
    }
}

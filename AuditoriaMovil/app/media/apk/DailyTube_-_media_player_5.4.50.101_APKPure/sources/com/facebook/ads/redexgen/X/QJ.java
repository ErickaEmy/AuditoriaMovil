package com.facebook.ads.redexgen.X;

import android.view.View;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;
/* loaded from: assets/audience_network.dex */
public final class QJ extends RelativeLayout {
    public static String[] A03 = {"Z7YDROQZDOzGgLZ6JRzm0VB6SZj4zDor", "PEDxZ1hmcJv2HtokqPZuboN03zqPqfuu", "ZN3aiXgGzfL", "UoQOzdqMFdmvRVk6jZTbQbhJ01APWmUd", "BWydKlRDXGFiivyHlYlBLR13h8bygoZy", "calSGpe10AH6YV6oPZJsWkhcYoOFDSm8", "CqyCvSup05V", "6oqVw1T1HmkJfSZKyFG8rr7XXeYSScI0"};
    public C7R A00;
    public WeakReference<QI> A01;
    public final R9 A02;

    public QJ(C1116Yn c1116Yn, R9 r9) {
        super(c1116Yn);
        this.A02 = r9;
        AbstractC0783Lo.A0J((View) r9);
        addView(r9.getView(), new RelativeLayout.LayoutParams(-1, -1));
    }

    public final void A00(QQ qq) {
        addView(qq, new RelativeLayout.LayoutParams(-1, -1));
        this.A00 = (C7R) qq;
    }

    public final void A01(QQ qq) {
        AbstractC0783Lo.A0J(qq);
        this.A00 = null;
    }

    public final boolean A02() {
        return this.A02.A8c();
    }

    public int getCurrentPosition() {
        return this.A02.getCurrentPosition();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        ((View) this.A02).layout(0, 0, getWidth(), getHeight());
        C7R c7r = this.A00;
        if (c7r != null) {
            c7r.layout(0, 0, getWidth(), getHeight());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a4, code lost:
        if (r6 > r3) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a6, code lost:
        r5 = (r4 * r7) / r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00aa, code lost:
        if (r6 > r3) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e0, code lost:
        if (r6 == Integer.MIN_VALUE) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e2, code lost:
        if (r4 <= r3) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e4, code lost:
        r4 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e7, code lost:
        if (r6 == Integer.MIN_VALUE) goto L29;
     */
    @Override // android.widget.RelativeLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r12, int r13) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.QJ.onMeasure(int, int):void");
    }

    public void setViewImplInflationListener(QI qi) {
        this.A01 = new WeakReference<>(qi);
    }
}

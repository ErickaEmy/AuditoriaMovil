package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.5B  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C5B {
    public AnonymousClass58 A00 = new AnonymousClass58();
    public final AnonymousClass59 A01;

    public C5B(AnonymousClass59 anonymousClass59) {
        this.A01 = anonymousClass59;
    }

    public final View A00(int i, int i5, int i6, int i8) {
        int A7b = this.A01.A7b();
        int next = this.A01.A7a();
        int childEnd = i5 > i ? 1 : -1;
        View view = null;
        while (i != i5) {
            View A6M = this.A01.A6M(i);
            int A6P = this.A01.A6P(A6M);
            int i10 = this.A01.A6O(A6M);
            this.A00.A03(A7b, next, A6P, i10);
            if (i6 != 0) {
                this.A00.A01();
                this.A00.A02(i6);
                if (this.A00.A04()) {
                    return A6M;
                }
            }
            if (i8 != 0) {
                this.A00.A01();
                this.A00.A02(i8);
                if (this.A00.A04()) {
                    view = A6M;
                }
            }
            i += childEnd;
        }
        return view;
    }
}

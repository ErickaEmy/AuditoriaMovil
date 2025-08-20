package com.facebook.ads.redexgen.X;

import android.text.Layout;
/* loaded from: assets/audience_network.dex */
public final class WJ extends C0635Fn implements Comparable<WJ> {
    public final int A00;

    public WJ(CharSequence charSequence, Layout.Alignment alignment, float f4, int i, int i5, float f6, int i6, float f9, boolean z2, int i8, int i10) {
        super(charSequence, alignment, f4, i, i5, f6, i6, f9, z2, i8);
        this.A00 = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: A00 */
    public final int compareTo(WJ wj) {
        int i = wj.A00;
        int i5 = this.A00;
        if (i < i5) {
            return -1;
        }
        if (i > i5) {
            return 1;
        }
        return 0;
    }
}

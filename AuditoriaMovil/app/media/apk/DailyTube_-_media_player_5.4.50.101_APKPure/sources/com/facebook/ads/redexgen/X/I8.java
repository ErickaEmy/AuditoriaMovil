package com.facebook.ads.redexgen.X;

import java.util.Comparator;
/* loaded from: assets/audience_network.dex */
public class I8 implements Comparator<I9> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Comparator
    /* renamed from: A00 */
    public final int compare(I9 i92, I9 i93) {
        if (i92.A00 < i93.A00) {
            return -1;
        }
        return i93.A00 < i92.A00 ? 1 : 0;
    }
}

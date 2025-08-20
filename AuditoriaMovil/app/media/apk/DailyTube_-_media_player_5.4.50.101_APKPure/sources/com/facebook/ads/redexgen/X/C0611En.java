package com.facebook.ads.redexgen.X;

import android.view.accessibility.AccessibilityEvent;
/* renamed from: com.facebook.ads.redexgen.X.En  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0611En extends C1150Zw {
    @Override // com.facebook.ads.redexgen.X.C03543l
    public final int A00(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }

    @Override // com.facebook.ads.redexgen.X.C03543l
    public final void A01(AccessibilityEvent accessibilityEvent, int i) {
        accessibilityEvent.setContentChangeTypes(i);
    }
}

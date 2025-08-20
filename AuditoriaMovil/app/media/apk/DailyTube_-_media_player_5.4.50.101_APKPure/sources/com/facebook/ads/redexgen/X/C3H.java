package com.facebook.ads.redexgen.X;

import android.view.accessibility.AccessibilityNodeInfo;
/* renamed from: com.facebook.ads.redexgen.X.3H  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C3H extends C04286k {
    @Override // com.facebook.ads.redexgen.X.C03573o
    public Object A00(int i, int i5, int i6, int i8, boolean z2, boolean z3) {
        return AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i5, i6, i8, z2);
    }

    @Override // com.facebook.ads.redexgen.X.C03573o
    public Object A01(int i, int i5, boolean z2, int i6) {
        return AccessibilityNodeInfo.CollectionInfo.obtain(i, i5, z2);
    }

    @Override // com.facebook.ads.redexgen.X.C03573o
    public final void A03(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) obj);
    }

    @Override // com.facebook.ads.redexgen.X.C03573o
    public final void A04(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
        accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) obj);
    }
}

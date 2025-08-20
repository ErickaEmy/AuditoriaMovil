package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
/* renamed from: com.facebook.ads.redexgen.X.Zz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1152Zz extends AnonymousClass37 {
    public static String[] A01 = {"qdMAGnvFuVn0ea0M3RnyzUUMgxm0S2Dt", "2PeyHnmE0bX58Ffgk0gx7OXrgxltyZLW", "2int", "nVrienaBQfkWnV6qIsNJmuY2fGTgVaBy", "EIAfoPo9YRxYx4hqHxVbjlkHHJjThpFm", "", "SPMlRY4DBSEQqdOiv1Q7wDslDeTbAa0F", "kfFOHzhabps7JVIWzUifit9US33gkwJk"};
    public final /* synthetic */ C03503h A00;

    public C1152Zz(C03503h c03503h) {
        this.A00 = c03503h;
    }

    private boolean A00() {
        return this.A00.A01 != null && this.A00.A01.A01() > 1;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass37
    public final void A07(View view, AccessibilityEvent accessibilityEvent) {
        super.A07(view, accessibilityEvent);
        accessibilityEvent.setClassName(C03503h.class.getName());
        accessibilityEvent.setScrollable(A00());
        if (accessibilityEvent.getEventType() == 4096 && this.A00.A01 != null) {
            accessibilityEvent.setItemCount(this.A00.A01.A01());
            accessibilityEvent.setFromIndex(this.A00.A00);
            accessibilityEvent.setToIndex(this.A00.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass37
    public final void A08(View view, C03613s c03613s) {
        super.A08(view, c03613s);
        c03613s.A0O(C03503h.class.getName());
        c03613s.A0R(A00());
        if (this.A00.canScrollHorizontally(1)) {
            c03613s.A0N(4096);
        }
        if (this.A00.canScrollHorizontally(-1)) {
            c03613s.A0N(8192);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass37
    public final boolean A09(View view, int i, Bundle bundle) {
        if (super.A09(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case 4096:
                if (!this.A00.canScrollHorizontally(1)) {
                    return false;
                }
                C03503h c03503h = this.A00;
                int i5 = c03503h.A00;
                String[] strArr = A01;
                if (strArr[3].charAt(13) != strArr[7].charAt(13)) {
                    throw new RuntimeException();
                }
                A01[4] = "Vr8sNFSEZwclN9wLDYuYxTMloU2ohTqa";
                c03503h.setCurrentItem(i5 + 1);
                return true;
            case 8192:
                if (!this.A00.canScrollHorizontally(-1)) {
                    return false;
                }
                C03503h c03503h2 = this.A00;
                c03503h2.setCurrentItem(c03503h2.A00 - 1);
                return true;
            default:
                return false;
        }
    }
}

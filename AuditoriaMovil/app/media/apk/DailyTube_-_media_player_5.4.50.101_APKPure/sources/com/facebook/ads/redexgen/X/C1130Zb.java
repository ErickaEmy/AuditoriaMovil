package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
/* renamed from: com.facebook.ads.redexgen.X.Zb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1130Zb extends AnonymousClass37 {
    public static String[] A02 = {"kCJseLSqSIrXu4CFjUZgH7qP37OfZeHD", "xEAmwUG5TGVzyoKH1PTTnmgJSds6zi0t", "yfye5wiKddzXjwKpYSAHRZ10SdbOyGIS", "FmBYeFx3U0BhjOzbepjZtX", "pFd99JFbVQiCxR8NKRmLZvqZPwpJ8hMq", "9sA", "zOMSQIOQC2uzgyYA4i3GoXbtL5yC1N4Y", "6JUJmYz6"};
    public final AnonymousClass37 A00 = new C1131Zc(this);
    public final C0599Eb A01;

    public C1130Zb(C0599Eb c0599Eb) {
        this.A01 = c0599Eb;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass37
    public final void A07(View view, AccessibilityEvent accessibilityEvent) {
        super.A07(view, accessibilityEvent);
        accessibilityEvent.setClassName(C0599Eb.class.getName());
        if ((view instanceof C0599Eb) && !A0B()) {
            C0599Eb c0599Eb = (C0599Eb) view;
            if (c0599Eb.getLayoutManager() != null) {
                c0599Eb.getLayoutManager().A1t(accessibilityEvent);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass37
    public final void A08(View view, C03613s c03613s) {
        super.A08(view, c03613s);
        c03613s.A0O(C0599Eb.class.getName());
        if (!A0B() && this.A01.getLayoutManager() != null) {
            this.A01.getLayoutManager().A1F(c03613s);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass37
    public final boolean A09(View view, int i, Bundle bundle) {
        if (super.A09(view, i, bundle)) {
            String[] strArr = A02;
            if (strArr[2].charAt(11) != strArr[0].charAt(11)) {
                throw new RuntimeException();
            }
            A02[4] = "nByhcE3HAON4xHhAaRL71J2smf2uyoDS";
            return true;
        } else if (!A0B() && this.A01.getLayoutManager() != null) {
            AbstractC03824o layoutManager = this.A01.getLayoutManager();
            if (A02[5].length() != 3) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[7] = "ZdbAAVtg";
            strArr2[3] = "rBKlzqXoYmUf6BYv0O8fT1";
            return layoutManager.A1V(i, bundle);
        } else {
            return false;
        }
    }

    public final AnonymousClass37 A0A() {
        return this.A00;
    }

    public final boolean A0B() {
        return this.A01.A1p();
    }
}

package com.facebook.ads.redexgen.X;

import android.view.View;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Io  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0710Io {
    public final View A00;
    public final C1115Ym A01;
    public final J2 A02;
    public final String A03;
    public final HashMap<String, String> A04 = new HashMap<>();
    public final boolean A05;
    public final boolean A06;

    public C0710Io(C1115Ym c1115Ym, View view, String str, boolean z2, boolean z3) {
        this.A03 = str;
        this.A01 = c1115Ym;
        this.A02 = c1115Ym.A09();
        this.A00 = view;
        this.A05 = z3;
        this.A06 = z2;
    }

    public final View A00() {
        return this.A00;
    }

    public final C1115Ym A01() {
        return this.A01;
    }

    public final J2 A02() {
        return this.A02;
    }

    public final String A03() {
        return this.A03;
    }

    public final Map<String, String> A04() {
        return Collections.unmodifiableMap(this.A04);
    }

    public final boolean A05() {
        return this.A05;
    }

    public final boolean A06() {
        return this.A06;
    }
}

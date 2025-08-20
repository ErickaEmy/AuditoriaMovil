package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.os.Bundle;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.3u  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C03633u {
    public static final InterfaceC03623t A01;
    public final Object A00;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            A01 = new C0603Ef();
        } else if (Build.VERSION.SDK_INT >= 16) {
            A01 = new C0604Eg();
        } else {
            A01 = new C1146Zs();
        }
    }

    public C03633u() {
        this.A00 = A01.AAW(this);
    }

    public C03633u(Object obj) {
        this.A00 = obj;
    }

    public final C03613s A00(int i) {
        return null;
    }

    public final C03613s A01(int i) {
        return null;
    }

    public final Object A02() {
        return this.A00;
    }

    public final List<C03613s> A03(String str, int i) {
        return null;
    }

    public final boolean A04(int i, int i5, Bundle bundle) {
        return false;
    }
}

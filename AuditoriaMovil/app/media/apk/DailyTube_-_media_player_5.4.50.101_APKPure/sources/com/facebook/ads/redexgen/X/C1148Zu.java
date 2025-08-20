package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Zu  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1148Zu implements InterfaceC03653w {
    public final /* synthetic */ C0604Eg A00;
    public final /* synthetic */ C03633u A01;

    public C1148Zu(C0604Eg c0604Eg, C03633u c03633u) {
        this.A00 = c0604Eg;
        this.A01 = c03633u;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03653w
    public final Object A4W(int i) {
        C03613s compatInfo = this.A01.A00(i);
        if (compatInfo == null) {
            return null;
        }
        return compatInfo.A0M();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03653w
    public final List<Object> A5h(String str, int i) {
        List<C03613s> A03 = this.A01.A03(str, i);
        if (A03 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int infoCount = A03.size();
        for (int i5 = 0; i5 < infoCount; i5++) {
            arrayList.add(A03.get(i5).A0M());
        }
        return arrayList;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03653w
    public final boolean ADx(int i, int i5, Bundle bundle) {
        return this.A01.A04(i, i5, bundle);
    }
}

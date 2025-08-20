package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Zt  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1147Zt implements InterfaceC03673z {
    public final /* synthetic */ C0603Ef A00;
    public final /* synthetic */ C03633u A01;

    public C1147Zt(C0603Ef c0603Ef, C03633u c03633u) {
        this.A00 = c0603Ef;
        this.A01 = c03633u;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03673z
    public final Object A4W(int i) {
        C03613s compatInfo = this.A01.A00(i);
        if (compatInfo == null) {
            return null;
        }
        return compatInfo.A0M();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03673z
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

    @Override // com.facebook.ads.redexgen.X.InterfaceC03673z
    public final Object A5i(int i) {
        C03613s compatInfo = this.A01.A01(i);
        if (compatInfo == null) {
            return null;
        }
        return compatInfo.A0M();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03673z
    public final boolean ADx(int i, int i5, Bundle bundle) {
        return this.A01.A04(i, i5, bundle);
    }
}

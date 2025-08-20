package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
import java.util.ArrayList;
/* renamed from: com.facebook.ads.redexgen.X.ax  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1211ax implements AnonymousClass61 {
    public static String[] A05 = {"SGxBKOT0PnlxeQ2jGccieZy3bFeI", "1PQaT", "uVEahNbfwTxCxKVGO7p", "rVPhbhRBlKfAg8fviAhE", "2ov", "KrP87Bn8e271VzBAE5Wi", "4No2VIB7eIWgh7ub8hExBeYUcY", "mEjh"};
    public final /* synthetic */ AbstractC1219b5 A00;
    public final /* synthetic */ InterfaceC02981h A01;
    public final /* synthetic */ C02991i A02;
    public final /* synthetic */ C1116Yn A03;
    public final /* synthetic */ boolean A04;

    public C1211ax(C02991i c02991i, C1116Yn c1116Yn, boolean z2, AbstractC1219b5 abstractC1219b5, InterfaceC02981h interfaceC02981h) {
        this.A02 = c02991i;
        this.A03 = c1116Yn;
        this.A04 = z2;
        this.A00 = abstractC1219b5;
        this.A01 = interfaceC02981h;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass61
    public final void AAl() {
        ArrayList arrayList;
        if (C0705Ih.A1O(this.A03) && this.A04) {
            arrayList = this.A02.A02;
            arrayList.add(PC.A01(this.A03, this.A00, 1, new C1212ay(this)));
            return;
        }
        InterfaceC02981h interfaceC02981h = this.A01;
        if (A05[2].length() != 19) {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[5] = "X6BBoGIR5wPjpoFUlFYz";
        strArr[3] = "SlUPa0nBeexeGnx3tyWk";
        interfaceC02981h.AAf();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass61
    public final void AAm() {
        this.A01.AAe(AdError.CACHE_ERROR);
    }
}

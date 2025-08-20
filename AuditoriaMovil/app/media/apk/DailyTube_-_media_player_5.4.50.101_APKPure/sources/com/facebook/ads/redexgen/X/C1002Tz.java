package com.facebook.ads.redexgen.X;

import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Tz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1002Tz extends AbstractC03704c<SV> {
    public int A00;
    public int A01;
    public int A02;
    public MC A03;
    public RE A04;
    public String A05;
    public List<C0888Pp> A06;
    public final SparseBooleanArray A07 = new SparseBooleanArray();
    public final AbstractC1219b5 A08;
    public final C04216c A09;
    public final C1116Yn A0A;
    public final J2 A0B;
    public final V2 A0C;
    public final C0775Lg A0D;
    public final BQ A0E;
    public final KP A0F;

    public C1002Tz(C1116Yn c1116Yn, List<C0888Pp> list, AbstractC1219b5 abstractC1219b5, J2 j2, V2 v2, MC mc2, String str, BQ bq, KP kp2) {
        this.A0A = c1116Yn;
        this.A0B = j2;
        this.A0C = v2;
        this.A09 = v2.A10();
        this.A04 = v2.A1A();
        this.A0D = v2.A19();
        this.A03 = mc2;
        this.A08 = abstractC1219b5;
        this.A06 = list;
        this.A05 = str;
        this.A0E = bq;
        this.A0F = kp2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC03704c
    /* renamed from: A01 */
    public final SV A0C(ViewGroup viewGroup, int i) {
        return new SV(AbstractC0839Ns.A00(new OO(this.A0A, this.A0B, this.A03, this.A08, null, this.A04, this.A0D).A0I(this.A0F).A0G(this.A0C).A0K(), this.A0C, this.A05, this.A0E), this.A07, this.A04, this.A06.size(), this.A0A, this.A08.A0y());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC03704c
    /* renamed from: A02 */
    public final void A0D(SV sv, int i) {
        sv.A0k(this.A04);
        sv.A0j(this.A06.get(i), this.A0B, this.A09, this.A0D, this.A05, this.A00, this.A02, this.A01);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03704c
    public final int A0E() {
        return this.A06.size();
    }

    public final void A0F(int i, int i5, int i6) {
        boolean needsUpdate = i != this.A00;
        this.A00 = i;
        this.A02 = i5;
        this.A01 = i6;
        if (needsUpdate) {
            A06();
        }
    }

    public final void A0G(RE re) {
        this.A04 = re;
    }
}

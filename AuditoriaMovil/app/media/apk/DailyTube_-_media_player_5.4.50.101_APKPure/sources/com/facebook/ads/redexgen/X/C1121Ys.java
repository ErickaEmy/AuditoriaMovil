package com.facebook.ads.redexgen.X;

import android.os.Handler;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.Ys  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1121Ys extends KT {
    public final /* synthetic */ C6U A00;
    public final /* synthetic */ C6V A01;
    public final /* synthetic */ C04216c A02;
    public final /* synthetic */ ArrayList A03;
    public final /* synthetic */ ArrayList A04;

    public C1121Ys(C04216c c04216c, ArrayList arrayList, C6V c6v, C6U c6u, ArrayList arrayList2) {
        this.A02 = c04216c;
        this.A03 = arrayList;
        this.A01 = c6v;
        this.A00 = c6u;
        this.A04 = arrayList2;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        AtomicBoolean A0D;
        C04447f c04447f;
        Handler handler;
        C04447f c04447f2;
        long j2;
        long j4;
        long j6;
        long j7;
        A0D = C04216c.A0D(this.A03);
        c04447f = this.A02.A04;
        if (c04447f instanceof C1116Yn) {
            c04447f2 = this.A02.A04;
            C1116Yn c1116Yn = (C1116Yn) c04447f2;
            if (this.A01.A00 == -1) {
                if (A0D.get()) {
                    C0S A0E = c1116Yn.A0E();
                    j7 = this.A02.A00;
                    A0E.A48(C0774Lf.A01(j7));
                } else {
                    C0S A0E2 = c1116Yn.A0E();
                    j6 = this.A02.A00;
                    A0E2.A46(C0774Lf.A01(j6));
                }
            } else if (A0D.get()) {
                C0S A0E3 = c1116Yn.A0E();
                j4 = this.A02.A00;
                A0E3.A49(C0774Lf.A01(j4), this.A01.A00);
            } else {
                C0S A0E4 = c1116Yn.A0E();
                j2 = this.A02.A00;
                A0E4.A47(C0774Lf.A01(j2), this.A01.A00);
            }
        }
        handler = this.A02.A02;
        handler.post(new C1122Yt(this, A0D));
        C04216c.A0D(this.A04);
    }
}

package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.View;
/* loaded from: assets/audience_network.dex */
public class M8 implements View.OnClickListener {
    public final /* synthetic */ C02911a A00;
    public final /* synthetic */ JA A01;
    public final /* synthetic */ M9 A02;
    public final /* synthetic */ MC A03;
    public final /* synthetic */ String A04;

    public M8(M9 m9, JA ja, MC mc2, String str, C02911a c02911a) {
        this.A02 = m9;
        this.A01 = ja;
        this.A03 = mc2;
        this.A04 = str;
        this.A00 = c02911a;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C2S c2s;
        C1116Yn c1116Yn;
        C1116Yn c1116Yn2;
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.A04(J9.A0A, null);
            c2s = this.A02.A02;
            c1116Yn = this.A02.A03;
            if (c2s.A0O(c1116Yn.A01(), true)) {
                this.A03.A9M(this.A04, this.A00);
            } else if (!TextUtils.isEmpty(this.A00.A00())) {
                C0764Kv c0764Kv = new C0764Kv();
                c1116Yn2 = this.A02.A03;
                C0764Kv.A0M(c0764Kv, c1116Yn2, AbstractC0767Ky.A00(this.A00.A00()), this.A04);
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}

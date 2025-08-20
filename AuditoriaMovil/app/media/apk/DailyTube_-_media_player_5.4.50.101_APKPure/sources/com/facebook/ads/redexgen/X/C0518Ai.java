package com.facebook.ads.redexgen.X;

import android.os.Handler;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
/* renamed from: com.facebook.ads.redexgen.X.Ai  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0518Ai {
    public final Handler A00;
    public final InterfaceC0519Aj A01;

    public C0518Ai(Handler handler, InterfaceC0519Aj interfaceC0519Aj) {
        this.A00 = interfaceC0519Aj != null ? (Handler) AbstractC0672Ha.A01(handler) : null;
        this.A01 = interfaceC0519Aj;
    }

    public final void A01(int i) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC0517Ah(this, i));
        }
    }

    public final void A02(int i, long j2, long j4) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC0515Af(this, i, j2, j4));
        }
    }

    public final void A03(Format format) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC0514Ae(this, format));
        }
    }

    public final void A04(BC bc) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC0516Ag(this, bc));
        }
    }

    public final void A05(BC bc) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC0512Ac(this, bc));
        }
    }

    public final void A06(String str, long j2, long j4) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC0513Ad(this, str, j2, j4));
        }
    }
}

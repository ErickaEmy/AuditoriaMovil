package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.view.Surface;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
/* renamed from: com.facebook.ads.redexgen.X.Ic  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0700Ic {
    public final Handler A00;
    public final InterfaceC0701Id A01;

    public C0700Ic(Handler handler, InterfaceC0701Id interfaceC0701Id) {
        this.A00 = interfaceC0701Id != null ? (Handler) AbstractC0672Ha.A01(handler) : null;
        this.A01 = interfaceC0701Id;
    }

    public final void A01(int i, int i5, int i6, float f4) {
        if (this.A01 != null) {
            this.A00.post(new IZ(this, i, i5, i6, f4));
        }
    }

    public final void A02(int i, long j2) {
        if (this.A01 != null) {
            this.A00.post(new IY(this, i, j2));
        }
    }

    public final void A03(Surface surface) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC0698Ia(this, surface));
        }
    }

    public final void A04(Format format) {
        if (this.A01 != null) {
            this.A00.post(new IX(this, format));
        }
    }

    public final void A05(BC bc) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC0699Ib(this, bc));
        }
    }

    public final void A06(BC bc) {
        if (this.A01 != null) {
            this.A00.post(new IV(this, bc));
        }
    }

    public final void A07(String str, long j2, long j4) {
        if (this.A01 != null) {
            this.A00.post(new IW(this, str, j2, j4));
        }
    }
}

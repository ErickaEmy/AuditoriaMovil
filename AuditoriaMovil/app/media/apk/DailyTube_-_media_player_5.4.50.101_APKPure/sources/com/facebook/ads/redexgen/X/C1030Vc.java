package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* renamed from: com.facebook.ads.redexgen.X.Vc  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1030Vc implements InterfaceC0685Hn {
    public final Handler A00;

    public C1030Vc(Handler handler) {
        this.A00 = handler;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0685Hn
    public final Looper A7L() {
        return this.A00.getLooper();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0685Hn
    public final Message AAZ(int i, int i5, int i6) {
        return this.A00.obtainMessage(i, i5, i6);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0685Hn
    public final Message AAa(int i, int i5, int i6, Object obj) {
        return this.A00.obtainMessage(i, i5, i6, obj);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0685Hn
    public final Message AAb(int i, Object obj) {
        return this.A00.obtainMessage(i, obj);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0685Hn
    public final void AF8(int i) {
        this.A00.removeMessages(i);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0685Hn
    public final boolean AFn(int i) {
        return this.A00.sendEmptyMessage(i);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0685Hn
    public final boolean AFo(int i, long j2) {
        return this.A00.sendEmptyMessageAtTime(i, j2);
    }
}

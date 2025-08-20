package com.facebook.ads.redexgen.X;

import android.database.ContentObserver;
import android.os.Handler;
/* loaded from: assets/audience_network.dex */
public final class QL extends ContentObserver {
    public final QS A00;

    public QL(Handler handler, QS qs) {
        super(handler);
        this.A00 = qs;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return false;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z2) {
        this.A00.A0a();
    }
}

package com.facebook.ads.redexgen.X;

import android.hardware.display.DisplayManager;
/* loaded from: assets/audience_network.dex */
public final class IR implements DisplayManager.DisplayListener {
    public final DisplayManager A00;
    public final /* synthetic */ IT A01;

    public IR(IT it, DisplayManager displayManager) {
        this.A01 = it;
        this.A00 = displayManager;
    }

    public final void A00() {
        this.A00.registerDisplayListener(this, null);
    }

    public final void A01() {
        this.A00.unregisterDisplayListener(this);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i) {
        if (i != 0) {
            return;
        }
        this.A01.A03();
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i) {
    }
}

package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
/* renamed from: com.facebook.ads.redexgen.X.Lb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class View$OnSystemUiVisibilityChangeListenerC0770Lb implements View.OnSystemUiVisibilityChangeListener {
    public int A00;
    public Window A01;
    public final View A03;
    public EnumC0769La A02 = EnumC0769La.A03;
    public final Runnable A04 = new C1006Ud(this);

    public View$OnSystemUiVisibilityChangeListenerC0770Lb(View view) {
        this.A03 = view;
        view.setOnSystemUiVisibilityChangeListener(this);
    }

    private void A00(int i, boolean z2) {
        Window window = this.A01;
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z2) {
            attributes.flags |= i;
        } else {
            attributes.flags &= i ^ (-1);
        }
        this.A01.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02(boolean z2) {
        if (EnumC0769La.A03.equals(this.A02)) {
            return;
        }
        int i = 3840;
        if (!z2) {
            i = 3840 | 7;
        }
        Handler handler = this.A03.getHandler();
        if (handler != null && z2) {
            handler.removeCallbacks(this.A04);
            handler.postDelayed(this.A04, 2000L);
        }
        this.A03.setSystemUiVisibility(i);
    }

    public final void A03() {
        this.A01 = null;
    }

    public final void A04(Window window) {
        this.A01 = window;
    }

    public final void A05(EnumC0769La enumC0769La) {
        this.A02 = enumC0769La;
        switch (LZ.A00[this.A02.ordinal()]) {
            case 1:
                A00(67108864, true);
                A00(134217728, true);
                A02(false);
                return;
            default:
                A00(67108864, false);
                A00(134217728, false);
                this.A03.setSystemUiVisibility(0);
                return;
        }
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public final void onSystemUiVisibilityChange(int i) {
        int diff = this.A00 ^ i;
        this.A00 = i;
        if ((diff & 2) != 0) {
            int diff2 = i & 2;
            if (diff2 == 0) {
                A02(true);
            }
        }
    }
}

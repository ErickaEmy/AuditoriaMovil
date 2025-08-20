package com.facebook.ads.redexgen.X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.0y  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C02890y extends BroadcastReceiver {
    public static byte[] A04;
    public InterfaceC02880x A00;
    public C1237bN A01;
    public C1116Yn A02;
    public String A03;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 99);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{103, 80, 92, 94, 29, 85, 82, 80, 86, 81, 92, 92, 88, 29, 82, 87, 64, 29, 81, 82, 93, 93, 86, 65, 29, 80, 95, 90, 80, 88, 86, 87};
    }

    public C02890y(C1116Yn c1116Yn, String str, C1237bN c1237bN, InterfaceC02880x interfaceC02880x) {
        this.A02 = c1116Yn;
        this.A03 = str;
        this.A00 = interfaceC02880x;
        this.A01 = c1237bN;
    }

    public final void A02() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(A00(1, 31, 80) + A00(0, 1, 62) + this.A03);
        C03312o.A00(this.A02).A06(this, intentFilter);
    }

    public final void A03() {
        C03312o.A00(this.A02).A05(this);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        String intentAction = A00(0, 1, 62);
        String[] parts = action.split(intentAction);
        String str = parts[0];
        if (str == null) {
            return;
        }
        String intentAction2 = A00(1, 31, 80);
        if (intentAction2.equals(str)) {
            this.A00.AAx(this.A01);
        }
    }
}

package com.facebook.ads.redexgen.X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.16  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass16 extends BroadcastReceiver {
    public static byte[] A04;
    public static String[] A05 = {"Hx5cs3o1n94x4iz2ieiv19n0bC39jDLV", "DczTM9XTB6zYKPM5uSa4O9VpG4npCHE6", "H95xGrYXW6aetWm7g", "DnZlrnjHaFMDCSG8YghSBbb82bFkGLaI", "spAywSNSIB5utsB5KWAsjXDmt4Lk2xn0", "0OBhOGB87zrMsrOdMhmUEXBS8goXVv2S", "SvisU6DjgFnHMttCPMEeYze71kn4Qsz3", "Woiy3WnaDIJnBAS02u3srwOYvyvCf2jO"};
    public C1234bK A00;
    public AnonymousClass15 A01;
    public C1116Yn A02;
    public String A03;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            byte b2 = (byte) ((copyOfRange[i8] ^ i6) ^ 117);
            if (A05[2].length() == 6) {
                throw new RuntimeException();
            }
            A05[0] = "4fUr3b1za9qXspivNdeNxVAX4LvFC7L9";
            copyOfRange[i8] = b2;
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{44, 47, 35, 33, 98, 42, 45, 47, 41, 46, 35, 35, 39, 98, 45, 40, 63, 98, 34, 45, 56, 37, 58, 41, 98, 45, 40, 19, 47, 32, 37, 47, 39};
    }

    static {
        A01();
    }

    public AnonymousClass16(C1116Yn c1116Yn, String str, C1234bK c1234bK, AnonymousClass15 anonymousClass15) {
        this.A02 = c1116Yn;
        this.A03 = str;
        this.A01 = anonymousClass15;
        this.A00 = c1234bK;
    }

    public final void A02() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(A00(1, 32, 57) + A00(0, 1, 99) + this.A03);
        C03312o.A00(this.A02).A06(this, intentFilter);
    }

    public final void A03() {
        C03312o.A00(this.A02).A05(this);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String str;
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        String intentAction = A00(0, 1, 99);
        String[] split = action.split(intentAction);
        if (split.length < 1 || (str = split[0]) == null) {
            return;
        }
        String intentAction2 = A00(1, 32, 57);
        if (intentAction2.equals(str)) {
            this.A01.ACM(this.A00);
        }
    }
}

package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.6D  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C6D {
    public static byte[] A01;
    public SharedPreferences A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 78);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-41, -38, -20, -37, -24, -22, -33, -23, -33, -28, -35, -65, -38, -32, -13, -13, -15, -24, -31, -12, -13, -24, -18, -19, -56, -29, 1, -1, 1, 6, 3, -14, -15, -16, -4, -6, -69, -13, -18, -16, -14, -17, -4, -4, -8, -69, -18, -15, 0, -69, -10, -15, -13, -18, -39, -42, -38, -42, -31, -82, -47, -63, -33, -50, -48, -40, -42, -37, -44};
    }

    public C6D(C04447f c04447f) {
        this.A00 = c04447f.getSharedPreferences(ProcessUtils.getProcessSpecificName(A00(33, 21, 63), c04447f), 0);
    }

    public final C6C A02() {
        SharedPreferences sharedPreferences = this.A00;
        String A00 = A00(0, 13, 40);
        if (sharedPreferences.contains(A00)) {
            return new C6C(this.A00.getString(A00, A00(0, 0, 80)), this.A00.getBoolean(A00(54, 15, 31), false), C6B.A09, this.A00.getLong(A00(26, 7, 80), -1L));
        }
        return C6C.A00();
    }

    public final String A03() {
        return this.A00.getString(A00(13, 13, 49), A00(0, 0, 80));
    }

    public final void A04(C6C c6c) {
        SharedPreferences.Editor edit = this.A00.edit();
        edit.putString(A00(0, 13, 40), c6c.A03());
        edit.putBoolean(A00(54, 15, 31), c6c.A04());
        edit.putLong(A00(26, 7, 80), c6c.A01());
        edit.apply();
    }

    public final void A05(String str) {
        SharedPreferences.Editor edit = this.A00.edit();
        edit.putString(A00(13, 13, 49), str);
        edit.apply();
    }
}

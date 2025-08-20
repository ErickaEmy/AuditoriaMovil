package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.5n  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class AsyncTaskC04065n extends AsyncTask<C04085p, Void, Drawable> {
    public static byte[] A03;
    public static String[] A04 = {"1BJo9noXfKND6AuvSNdcB1V3GCwIAiOG", "Zj7TA2K", "dGMOiNue98uIHvh7voSV0LAZFWXYzfEv", "CcnxrNYo5kyWzKS3XGCDqe4PQiCtH", "knheqnusZFI0swerek9wKwEDBcdWqhKt", "XjDOSOe9Ixcmw73z7hfuGI1aFjWKj", "M2ugdIZCKbhB2vBaVocVLhBvD0BsDTY5", "metH7Y2aXkNKgtpuuGKiPWqQd6SU"};
    public final InterfaceC04075o A00;
    public final C1116Yn A01;
    public final boolean A02;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private final Drawable A00(C04085p... c04085pArr) {
        if (!KL.A02(this) && c04085pArr != null) {
            try {
                if (c04085pArr.length >= 1) {
                    String str = c04085pArr[0].A01;
                    String str2 = c04085pArr[0].A00;
                    Bitmap A0N = new C04216c(this.A01).A0N(str, -1, -1);
                    if (A0N != null) {
                        return V2.A05(this.A01, A0N, this.A02, str2);
                    }
                    return null;
                }
            } catch (Throwable th) {
                KL.A00(th, this);
                return null;
            }
        }
        return null;
    }

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 118);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{59, 57, 50, 57, 46, 53, 63};
    }

    static {
        A02();
    }

    public AsyncTaskC04065n(C1116Yn c1116Yn, InterfaceC04075o interfaceC04075o, boolean z2) {
        this.A01 = c1116Yn;
        this.A00 = interfaceC04075o;
        this.A02 = z2;
    }

    public /* synthetic */ AsyncTaskC04065n(C1116Yn c1116Yn, InterfaceC04075o interfaceC04075o, boolean z2, Z9 z9) {
        this(c1116Yn, interfaceC04075o, z2);
    }

    private final void A03(Drawable drawable) {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.ABi(drawable);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Drawable doInBackground(C04085p[] c04085pArr) {
        if (KL.A02(this)) {
            return null;
        }
        try {
            return A00(c04085pArr);
        } catch (Throwable th) {
            KL.A00(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Drawable drawable) {
        if (KL.A02(this)) {
            return;
        }
        try {
            A03(drawable);
        } catch (Throwable th) {
            KL.A00(th, this);
            String[] strArr = A04;
            if (strArr[0].charAt(5) != strArr[4].charAt(5)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[1] = "H4qVqfS";
            strArr2[7] = "3NPSPTmKkS9byZNXvPXu57LevjUG";
        }
    }
}

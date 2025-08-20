package com.facebook.ads.redexgen.X;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class VL implements JF {
    public static byte[] A01;
    public final C1116Yn A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 65);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{117, 20, 22, 1, 0, 20, 25, 42, 1, 28, 24, 16, 6, 1, 20, 24, 5, 52, 59, 62, 50, 57, 35, 8, 54, 39, 62, 8, 33, 50, 37, 36, 62, 56, 57, 30, 18, 19, 9, 24, 19, 9, 71, 82, 82, 8, 15, 18, 21, 0, 13, 13, 62, 19, 4, 7, 4, 19, 19, 4, 19, 4, 30, 50, 14, 25, 17, 0, 2, 10, 0, 6, 4, 62, 15, 0, 12, 4};
    }

    public VL(C1116Yn c1116Yn) {
        this.A00 = c1116Yn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A03(String str, boolean z2, String str2, String str3, String str4, long j2) {
        this.A00.A0E().A9k(str);
        PackageManager packageManager = this.A00.getPackageManager();
        if (packageManager == null) {
            this.A00.A0E().A9p(str);
            return false;
        }
        ContentResolver contentResolver = this.A00.getContentResolver();
        if (contentResolver == null) {
            this.A00.A0E().A9m(str);
            return false;
        } else if (packageManager.resolveContentProvider(str, 0) == null) {
            this.A00.A0E().A9l(str);
            return false;
        } else {
            Uri parse = Uri.parse(A00(35, 10, 60) + str + A00(0, 1, 27) + str2);
            ContentValues values = new ContentValues();
            values.put(A00(17, 18, 22), (Integer) 1);
            values.put(A00(61, 5, 44), Boolean.valueOf(z2));
            values.put(A00(45, 16, 32), str3);
            values.put(A00(66, 12, 32), str4);
            values.put(A00(1, 16, 52), Long.valueOf(j2));
            try {
                contentResolver.insert(parse, values);
                this.A00.A0E().A9r(str);
                return true;
            } catch (UnsupportedOperationException unused) {
                this.A00.A0E().A9o(str);
                return false;
            } catch (Exception unused2) {
                this.A00.A0E().A9n(str);
                return false;
            }
        }
    }

    public final void A04(boolean z2, String str, String str2, String str3, long j2, boolean z3) {
        this.A00.A0E().A9q();
        ExecutorC0788Lt.A06.execute(new VM(this, z2, str, str2, str3, j2, z3));
    }
}

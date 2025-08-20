package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class AU {
    public static byte[] A02;
    public static final AU A03;
    public final int A00;
    public final int[] A01;

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 1);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{95, 83, -90, -88, -93, -93, -94, -91, -89, -104, -105, 120, -95, -106, -94, -105, -100, -95, -102, -90, 112, 110, -94, -111, -106, -100, 112, -114, -99, -114, -113, -106, -103, -106, -95, -106, -110, -96, -120, -102, -114, -91, 112, -107, -114, -101, -101, -110, -103, 112, -100, -94, -101, -95, 106, -122, -116, -103, -113, -99, -102, -108, -113, 89, -104, -112, -113, -108, -116, 89, -116, -114, -97, -108, -102, -103, 89, 115, 111, 120, 116, -118, 108, Byte.MIN_VALUE, 111, 116, 122, -118, 123, 119, Byte.MIN_VALUE, 114, -93, -80, -90, -76, -79, -85, -90, 112, -81, -89, -90, -85, -93, 112, -89, -70, -74, -76, -93, 112, -125, -105, -122, -117, -111, -95, -110, -114, -105, -119, -95, -107, -106, -125, -106, -121, 126, -117, -127, -113, -116, -122, -127, 75, -118, -126, -127, -122, 126, 75, -126, -107, -111, -113, 126, 75, 98, 107, 96, 108, 97, 102, 107, 100, 112, Byte.MAX_VALUE, -116, -126, -112, -115, -121, -126, 76, -117, -125, -126, -121, Byte.MAX_VALUE, 76, -125, -106, -110, -112, Byte.MAX_VALUE, 76, 107, 95, 118, 125, 97, 102, 95, 108, 108, 99, 106, 125, 97, 109, 115, 108, 114};
    }

    static {
        A03();
        A03 = new AU(new int[]{2}, 2);
    }

    public AU(int[] iArr, int i) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.A01 = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.A01 = new int[0];
        }
        this.A00 = i;
    }

    public static AU A00(Context context) {
        return A01(AbstractC0766Kx.A00(context, null, new IntentFilter(A02(56, 36, 42))));
    }

    public static AU A01(Intent intent) {
        if (intent == null || intent.getIntExtra(A02(92, 36, 65), 0) == 0) {
            return A03;
        }
        return new AU(intent.getIntArrayExtra(A02(NotificationCompat.FLAG_HIGH_PRIORITY, 29, 28)), intent.getIntExtra(A02(157, 37, 29), 0));
    }

    public final boolean A04(int i) {
        return Arrays.binarySearch(this.A01, i) >= 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AU) {
            AU au = (AU) obj;
            return Arrays.equals(this.A01, au.A01) && this.A00 == au.A00;
        }
        return false;
    }

    public final int hashCode() {
        return this.A00 + (Arrays.hashCode(this.A01) * 31);
    }

    public final String toString() {
        return A02(21, 34, 44) + this.A00 + A02(0, 21, 50) + Arrays.toString(this.A01) + A02(55, 1, 40);
    }
}

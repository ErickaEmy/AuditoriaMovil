package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.uv.v7.R;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: assets/audience_network.dex */
public abstract class OM {
    public static byte[] A00;
    public static String[] A01 = {"zHQaRI8Z04iZfuq60cOZ3MtOUQtnyLXk", "Py81lTfXTPvOohagzwztlFMwKgIeaa04", "ZBx", "ff4Sljy7OS0rEQC0yVPpTgSrr8dBXGgO", "WJ7E7dTZMlxiqC9ofw7stZL7dYzOgEyn", "lEp0yqe8iFuZgqtiF5MEL7dQIxoaDf7o", "1LQBU", "K3MGC9Pem9CSlPJADsZARPOkTW1wXgVW"};

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 71);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{8, 97, 91, 8, 97, 70, 91, 92, 73, 70, 92, 8, 79, 73, 69, 77, 91, 8, 73, 68, 68, 71, 95, 77, 76, 18, 8, 64, 41, 19, 64, 41, 14, 19, 20, 1, 14, 20, 64, 7, 1, 13, 5, 19, 90, 64, 77, 10, 2, 2, 10, 1, 8, 77, 11, 12, 1, 1, 15, 12, 14, 6, 77, 24, 31, 1, 77, 12, 27, 12, 4, 1, 12, 15, 1, 8, 87, 77, 119, 62, 36, 4, 35, 56, 37, 50, 109, 119, 124, 108, 58, 37, 40, 41, 35, 108, 57, 62, 32, 108, 37, 63, 108, 34, 57, 32, 32, 118, 108, 94, 82, 80, 19, 91, 92, 94, 88, 95, 82, 82, 86, 19, 86, 92, 73, 92, 83, 92, 74, 77, 86, 75, 92, 120, Byte.MAX_VALUE, 100, 121, 110, 84, 126, 121, 103, 84, 124, 110, 105, 84, 109, 106, 103, 103, 105, 106, 104, 96, 69, 90, 87, 86, 92, 108, 70, 65, 95};
    }

    static {
        A02();
    }

    public static OL A00(OP op, Bundle bundle, boolean z2) {
        OL c0979Tc;
        op.A05().A0F().A00(false);
        C1G A0x = op.A04().A0x();
        double A002 = OI.A00(A0x);
        boolean A0N = op.A04().A0x().A0N();
        boolean A06 = OI.A06(op.A00(), op.A01(), A002);
        AbstractC02730h A003 = C02740i.A00(op.A05(), op.A06(), A01(0, 0, 67), AbstractC0767Ky.A00(op.A04().A0x().A0F().A05()), new HashMap(), op.A04().A0y());
        boolean z3 = !TextUtils.isEmpty(A0x.A0D().A08());
        if (C0705Ih.A1W(op.A05())) {
            op.A05().A0A().AGv(op.A02(), op.A04().A12(), z3);
        }
        boolean A03 = A03(op, z3);
        if ((A0N && (A003 instanceof C0628Fe)) || A03) {
            c0979Tc = new TT(op, A03);
        } else if (z3) {
            c0979Tc = new BI(op);
        } else if (!z3 && C0705Ih.A2A(op.A05())) {
            c0979Tc = new BJ(op, A06);
        } else if (!A06) {
            c0979Tc = new C0979Tc(op, OI.A04(A002));
        } else {
            int A004 = op.A00();
            if (A01[2].length() != 3) {
                throw new RuntimeException();
            }
            A01[6] = "JelR9";
            c0979Tc = new C0982Tf(op, A004 == 2);
        }
        if (z2) {
            c0979Tc.A10(A0x, op.A04().A12(), A002, bundle);
        }
        return c0979Tc;
    }

    public static boolean A03(OP op, boolean z2) {
        boolean z3 = false;
        if (op.A04().A0p() && z2) {
            Uri A002 = AbstractC0767Ky.A00(op.A04().A0x().A0F().A05());
            String authority = A002.getAuthority();
            if (TextUtils.isEmpty(authority)) {
                op.A05().A0E().AAF();
                return false;
            }
            boolean isInstantGames = authority.equals(A01(NotificationCompat.FLAG_HIGH_PRIORITY, 5, 126));
            boolean isStoreUrl = A002.getQueryParameter(A01(155, 9, 116)) == null;
            String queryParameter = A002.getQueryParameter(A01(133, 22, 76));
            boolean isGoogleFallBackUrlAvailable = !TextUtils.isEmpty(queryParameter) && queryParameter.contains(op.A04().A0Q());
            boolean equals = op.A05().getPackageName().equals(A01(109, 19, 122));
            boolean isVideoUrlNull = op.A04().A0q();
            if (isInstantGames && isStoreUrl && isGoogleFallBackUrlAvailable && (!equals || isVideoUrlNull)) {
                z3 = true;
            }
            if (!z3) {
                int i = Build.VERSION.SDK_INT;
                if (A01[2].length() != 3) {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[4] = "ixVJz4LKAvkUhWpfUwnrm68OXA5reQsq";
                strArr[1] = "n4hyezKFC81nHjNiPwRfUtRp762j8aVq";
                if (i >= 24) {
                    op.A05().A0E().AAE(A01(78, 11, 16) + isInstantGames + A01(89, 20, 11) + isStoreUrl + A01(46, 32, 42) + isGoogleFallBackUrlAvailable + A01(27, 19, 39) + equals + A01(0, 27, R.styleable.AppCompatTheme_textColorSearchUrl) + isVideoUrlNull);
                }
            }
            return z3;
        }
        return false;
    }
}

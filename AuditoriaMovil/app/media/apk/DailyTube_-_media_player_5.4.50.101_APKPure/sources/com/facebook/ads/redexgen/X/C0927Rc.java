package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.uv.v7.R;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.Rc  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0927Rc {
    public static RI A00;
    public static byte[] A01;
    public static String[] A02 = {"b", "jWWIi2TrnHAAyoG5itvaKpzBpE6rwsKb", "4piz2zd6PBPCOA5LKuru6huyc0Gk9hmI", "ThWxRwfxtMClt6xxWNEGrvPqHoOGiBgN", "VC0ltrZe3ujZ5yBmE9F34w5pTHRf8GMT", "g0Z7XyqsbnnTrD4DkPgr08gcmreNHhpx", "VVYGWntGozQ2sTcwE1XxLnyTeGzWkyyX", "XVqTwdXEkxL4UUDwn3dakWK60VTsxJd5"};
    public static final Set<String> A03;
    public static final Set<String> A04;
    public static final AtomicBoolean A05;

    public static String A05(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 56);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A01 = new byte[]{36, 101, 110, 8, 85, 68, 11, 77, 77, 2, Byte.MAX_VALUE, 10, 123, 99, 73, 104, 8, 85, 98, 15, 86, 84, 94, 81, 8, 82, 77, 74, 8, 111, 85, 73, 81, 7, 48, Byte.MAX_VALUE, 32, 7, 58, 38, 2, 63, 42, 33, 62, 34, 103, 27, 33, 42, 8, 36, 58, 62, 126, 37, 26, 36, 99, 53, 30, 63, 113, 70, 13, Byte.MAX_VALUE, 119, 30, 59, 10, 123, 54, 3, 12, 43, 35, 38, 123, 61, 63, 59, 54, 62, 14, 10, 44, 53, 23, 0, 42, 14, 114, 69, 107, 64, 81, 82, 74, 87, 78, 76, 75, 66, 5, 71, 64, 67, 74, 87, 64, 5, 76, 75, 76, 81, 4, 113, 115, 113, 96, 31, 72, 71, 115, 75, 77, 98, 79, 2, 93, 72, 124, 123, 77, 71, 80, 124, 97, 28, 64, 89, 78, 100, 20, 35, 54, 62, 37, 39, 59, 54, 57, 50, 8, 58, 56, 51, 50, 8, 56, 57, 7, 12, 29, 30, 6, 27, 2, 19, 8, 61, 85, 32, 53, 9, 53, 13, 36, 94, 55, 82, 49, 49, 50, 3, 36, 23, 40, 21, 33, 47, 95, 11, 1, 54, 90, 109};
    }

    static {
        A07();
        HashSet hashSet = new HashSet();
        A03 = hashSet;
        HashSet hashSet2 = new HashSet();
        A04 = hashSet2;
        hashSet.add(A05(6, 29, 2));
        hashSet2.add(A05(168, 29, 95));
        hashSet2.add(A05(35, 29, 116));
        hashSet2.add(A05(64, 29, 119));
        hashSet2.add(A05(116, 29, 17));
        A05 = new AtomicBoolean();
    }

    public static RK A00(C04447f c04447f) {
        return A03(true, c04447f);
    }

    public static RK A01(C04447f c04447f) {
        return A02(true, c04447f);
    }

    public static RK A02(boolean z2, C04447f c04447f) {
        RO ro2 = new RO();
        RR A042 = A04(c04447f);
        if (!A0B(c04447f)) {
            ro2.A02(A04);
            ro2.A01(A03);
        }
        if (L0.A04()) {
            Map<String, String> A022 = L0.A02();
            String[] strArr = A02;
            if (strArr[2].charAt(7) == strArr[1].charAt(7)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[5] = "6CjO7LbqJIONUadrRHmx0RuGBypxStir";
            strArr2[3] = "VKsjD9ddp6JrHwn0FL0Df9QGs7RhJ4JT";
            A042.A08(A022);
        }
        C0739Jt A002 = RM.A00();
        RO networkModuleConfigurationBuilder = ro2.A00(A042.A09());
        return A002.A00(networkModuleConfigurationBuilder.A03(z2).A04(c04447f.A04().A8z()).A05(), c04447f.A07(), ExecutorC0788Lt.A01());
    }

    public static RK A03(boolean z2, C04447f c04447f) {
        return RM.A00().A00(new RO().A03(z2).A00(A04(c04447f).A09()).A04(c04447f.A04().A8z()).A05(), c04447f.A07(), ExecutorC0788Lt.A01());
    }

    public static RR A04(C04447f c04447f) {
        A08(c04447f);
        RR rr = new RR();
        if (A0B(c04447f) || L0.A04()) {
            rr.A02(360000).A04(120000);
        } else {
            rr.A02(C0705Ih.A08(c04447f)).A04(C0705Ih.A0A(c04447f));
        }
        rr.A03(C0705Ih.A09(c04447f)).A05(C0705Ih.A0B(c04447f)).A06(C0705Ih.A0C(c04447f));
        synchronized (C0927Rc.class) {
            RI ri = A00;
            if (ri != null && (ri instanceof RI)) {
                rr.A07(ri);
            }
        }
        return rr;
    }

    public static void A06() {
        A05.set(true);
    }

    public static void A08(C04447f c04447f) {
        if (!A05.get()) {
            c04447f.A07().A9a(A05(161, 7, 81), C8A.A21, new C8B(A05(93, 23, 29)));
        }
    }

    public static synchronized void A09(RI ri) {
        synchronized (C0927Rc.class) {
            A00 = ri;
        }
    }

    public static boolean A0A(C04447f c04447f) {
        int i = Build.VERSION.SDK_INT;
        String A052 = A05(145, 16, R.styleable.AppCompatTheme_textColorSearchUrl);
        if (i < 17) {
            return Settings.System.getInt(c04447f.getContentResolver(), A052, 0) != 0;
        }
        int i5 = Settings.Global.getInt(c04447f.getContentResolver(), A052, 0);
        if (A02[0].length() != 1) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[2] = "6SlcDzdssqL5L6jmaJN4q0YtRJ9ZiIN0";
        strArr[1] = "IhCDgNyX5tEXKuNPsF1SGphg5lyX1n5g";
        return i5 != 0;
    }

    public static boolean A0B(C04447f c04447f) {
        String A8F = c04447f.A04().A8F();
        if (!TextUtils.isEmpty(A8F)) {
            String urlPrefix = A05(3, 3, 30);
            if (!A8F.endsWith(urlPrefix)) {
                String urlPrefix2 = A05(0, 3, 50);
                if (A8F.endsWith(urlPrefix2)) {
                }
            }
            return true;
        }
        return false;
    }
}

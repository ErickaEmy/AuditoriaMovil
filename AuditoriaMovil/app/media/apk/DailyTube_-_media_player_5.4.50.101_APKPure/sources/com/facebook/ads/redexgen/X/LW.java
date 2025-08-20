package com.facebook.ads.redexgen.X;

import android.content.Context;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: assets/audience_network.dex */
public abstract class LW {
    public static byte[] A00;
    public static final Pattern A01;

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 124);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{89, 45, 2, 90, 16, 5, 45, 2, 90, 42, 16, 92, 11, 95, 44, 90, 88, 42, 48, 92, 43, 44, 95, 91, 120, 78, 73, 73, 94, 85, 79, 27, 72, 79, 90, 88, 80, 27, 79, 73, 90, 88, 94, 33, 45, 47, 108, 36, 35, 33, 39, 32, 45, 45, 41, 108, 35, 38, 49};
    }

    static {
        A07();
        A01 = Pattern.compile(A02(0, 24, 13));
    }

    public static String A00() {
        return A06(new Exception(A02(24, 19, 71)), -1, -1, false);
    }

    public static String A01(int i) {
        if (i <= 0) {
            return null;
        }
        float rate = new Random().nextFloat();
        if (rate >= 1.0f / i) {
            return null;
        }
        return A00();
    }

    public static String A03(Context context, Throwable th) {
        int A0I = C0705Ih.A0I(context);
        int maxStacktraceLines = C0705Ih.A02(context);
        return A06(th, A0I, maxStacktraceLines, C0705Ih.A1G(context));
    }

    public static String A04(String str) {
        Matcher matcher = A01.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return str;
    }

    public static String A06(Throwable th, int i, int i5, boolean z2) {
        String A02 = A02(0, 0, 122);
        if (th == null) {
            return A02;
        }
        try {
            C1010Uh c1010Uh = new C1010Uh();
            LU lu = c1010Uh;
            if (i5 >= 0) {
                lu = new C1008Uf(lu, i5);
            }
            if (i >= 0) {
                lu = new C1007Ue(lu, i, i);
            }
            if (z2) {
                lu = new C1009Ug(lu);
            }
            C1011Ui c1011Ui = new C1011Ui(c1010Uh, 1, lu);
            th.printStackTrace(new PrintWriter(new LV(c1011Ui)));
            c1011Ui.flush();
            return c1010Uh.toString();
        } catch (Exception unused) {
            return A02;
        }
    }

    public static boolean A08(LT lt) {
        String middle = lt.A02();
        if (middle == null) {
            return false;
        }
        if (A0A(middle)) {
            return true;
        }
        for (String middle2 : lt.A01()) {
            if (A0A(middle2)) {
                return true;
            }
        }
        for (String middle3 : lt.A00()) {
            if (A0A(middle3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean A0A(String str) {
        return str.contains(A02(43, 16, 62));
    }
}

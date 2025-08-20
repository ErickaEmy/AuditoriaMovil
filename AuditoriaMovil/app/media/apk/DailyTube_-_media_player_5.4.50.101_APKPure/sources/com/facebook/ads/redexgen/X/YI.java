package com.facebook.ads.redexgen.X;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.uv.v7.R;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.zip.DeflaterOutputStream;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public final class YI implements InterfaceC04708k {
    public static PackageInfo A02;
    public static boolean A03;
    public static byte[] A04;
    public static String[] A05 = {"rjWu3o3XUIKJimpXtRLH", "N3hUjd9gC1zTrolrzHWDwio6K0KaeF7v", "V8BOZxTrBek9nlJry76rEN1tEiA1lgnf", "2kaCuDD1e44XjFqxj97oS3bW7Y4jUXps", "VcJxC1jbHxk7XwGyeCWvHwY9E4qRcx1x", "dO6RHNbAuKw0kDbwpnJR", "8jPNINbp0cYAxxIn", "ugIdyp1aSJPFHYCiUHctz2XPYC5YD6Ud"};
    public static final C0V[] A06;
    public final C6S A00;
    public final C04447f A01;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A05[6].length() == 9) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[1] = "AJGqtkftO03LFXDJsHlFXR4ujVWNfKsn";
            strArr[7] = "0weTThgY8dzMPuXGgH30KJvXs1017h9U";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 73);
            i8++;
        }
    }

    public static void A02() {
        A04 = new byte[]{40, 13, 21, 23, 23, 17, 7, 7, 29, 22, 29, 24, 29, 0, 13, 11, 17, 26, 21, 22, 24, 17, 16, 41, 38, 41, 36, 39, 47, 45, 60, 60, 51, 33, 37, 34, 51, 63, 40, 39, 51, 58, 41, 62, 63, 37, 35, 34, 98, 112, 107, 98, 112, 85, 71, 93, 80, 78, 91, 91, 93, 70, 77, 90, 91, 70, 64, 65, 80, 70, 75, 47, 36, 41, 41, 40, 63, 50, 57, 34, 38, 40, 35, 50, 40, 53, 57, 63, 44, 62, 85, 66, 89, 83, 91, 82, 107, 105, 120, 120, 109, 108, 119, 97, 108, 123, 63, 61, 46, 46, 53, 57, 46, 72, 77, 88, 77, 83, 92, 94, 67, 79, 73, 95, 95, 69, 66, 75, 83, 67, 92, 88, 69, 67, 66, 95, 18, 23, 2, 23, 9, 6, 4, 25, 21, 19, 5, 5, 31, 24, 17, 9, 25, 6, 2, 31, 25, 24, 5, 9, 21, 25, 3, 24, 2, 4, 15, 67, 70, 83, 70, 88, 87, 85, 72, 68, 66, 84, 84, 78, 73, 64, 88, 72, 87, 83, 78, 72, 73, 84, 88, 84, 83, 70, 83, 66, 92, 93, 86, 75, 81, 76, 65, 109, 126, 101, 101, 110, 103, 116, 104, 100, 121, 110, 116, 110, 125, 110, 101, Byte.MAX_VALUE, 120, 30, 13, 22, 22, 29, 20, 7, 20, 23, 31, 31, 29, 28, 13, 42, 34, 39, 46, 47, 107, 63, 36, 107, 41, 62, 34, 39, 47, 107, 62, 56, 46, 57, 107, 63, 36, 32, 46, 37, 62, 55, 37, 41, 51, 46, 57, 38, 58, 55, 47, 51, 36, 17, 28, 30, 25, 94, 83, 72, 84, 86, 84, 95, 82, 72, 67, 68, 72, 90, 68, 52, 57, 34, 46, 50, 40, 47, 62, 56, 48, 55, 42, 45, 56, 53, 53, 60, 43, 32, 35, 47, 45, 32, 41, 43, 39, 45, 35, 74, 66, 67, 78, 70, 83, 78, 72, 73, 88, 84, 66, 85, 81, 78, 68, 66, 110, 101, 116, 119, 111, 114, 107, Byte.MAX_VALUE, 116, 121, 112, 101, 7, 11, 29, 4, 29, 27, 23, 29, 27, 13, 26, 23, 1, 12, 84, 73, 73, 82, 67, 66, 93, 93, 80, 76, 67, 70, 74, 65, 91, 80, 92, 75, 68, 80, 89, 74, 93, 92, 70, 64, 65, 15, 15, 2, 24, 5, 9, 15, 28, 14, 96, 96, 109, 123, 97, 109, 116, 96, 125, Byte.MAX_VALUE, 109, 97, 119, 96, 100, 123, 113, 119, 96, 96, 109, 97, 119, 96, 100, 123, 113, 119, 109, 97, 118, 121, 109, 100, 119, 96, 97, 123, 125, 124, 62, 56, 42, 51, 42, 46, 51, 45, 60, 60, 51, 37, 34, 63, 56, 45, 32, 32, 41, 40, 126, 120, 106, 115, 106, 110, 115, 109, 124, 124, 115, 122, 105, 126, Byte.MAX_VALUE, 101, 99, 98, 53, 37, 52, 35, 35, 40, 57, 46, 35, 47, 33, 46, 50, 28, 12, 29, 10, 10, 1, 16, 24, 6, 11, 27, 7, 64, 87, 88, 76, 80, 82, 67, 82, 81, 90, 95, 90, 71, 74, 36, 50, 36, 36, 62, 56, 57, 40, 35, 62, 58, 50, 65, 90, 93, 64, 77, 77, 75, 93, 74, 71, 89, 95, 93, 86, 76, 13, 26, 23, 11, 26, 9, 26, 22, 8, Byte.MAX_VALUE, 100, 125, 125};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final String A04(InterfaceC04688i interfaceC04688i) {
        C04668g.A08(this.A01, true, null);
        ByteArrayOutputStream byteArrayOutputStream = null;
        Base64OutputStream base64OutputStream = null;
        DeflaterOutputStream deflaterOutputStream = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 0);
                deflaterOutputStream = new DeflaterOutputStream(base64OutputStream);
                Map A052 = A05();
                if (TextUtils.isEmpty(C6E.A00().A03())) {
                    C6E.A07(this.A01);
                }
                A052.put(A01(273, 4, 17), C6E.A00().A03());
                A052.put(A01(532, 10, 81), AbstractC04748o.A06(new C8K(this.A01), this.A01, false));
                if (C0705Ih.A1Y(this.A01)) {
                    A052.put(A01(96, 10, 97), C02870w.A01(this.A01).A0K());
                }
                Iterator it = A052.entrySet().iterator();
                while (it.hasNext()) {
                    if (!interfaceC04688i.A2a((String) ((Map.Entry) it.next()).getKey())) {
                        it.remove();
                    }
                }
                deflaterOutputStream.write(new JSONObject(A052).toString().getBytes());
                deflaterOutputStream.close();
                String replaceAll = byteArrayOutputStream.toString().replaceAll(A01(0, 1, 107), A01(0, 0, 37));
                try {
                    deflaterOutputStream.close();
                    base64OutputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
                return replaceAll;
            } catch (IOException e2) {
                throw new RuntimeException(A01(234, 26, 2), e2);
            }
        } catch (Throwable th) {
            if (deflaterOutputStream != null) {
                try {
                    deflaterOutputStream.close();
                } catch (IOException unused2) {
                    throw th;
                }
            }
            if (base64OutputStream != null) {
                base64OutputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th;
        }
    }

    public final /* synthetic */ Map A05() {
        return AbstractC04678h.A00(this);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC04708k
    public final Map<String, String> A6w(C8Z c8z) {
        String A74;
        String A6E = c8z != null ? c8z.A6E() : null;
        String packageName = A6E != null ? A6E : this.A01.getPackageName();
        C04668g.A08(this.A01, ProcessUtils.isRemoteRenderingProcess() ? true : C0705Ih.A0i(this.A01), A6E);
        C8J.A0B(this.A01);
        C8J.A08(this.A01);
        HashMap hashMap = new HashMap();
        C04638d.A03(this.A01, hashMap, A6E);
        hashMap.put(A01(309, 6, 37), Locale.getDefault().toString());
        float f4 = LD.A02;
        int i = this.A01.getResources().getDisplayMetrics().widthPixels;
        int i5 = this.A01.getResources().getDisplayMetrics().heightPixels;
        hashMap.put(A01(196, 7, 81), String.valueOf(f4));
        hashMap.put(A01(489, 12, 6), String.valueOf((int) (i / f4)));
        hashMap.put(A01(476, 13, 47), String.valueOf((int) (i5 / f4)));
        hashMap.put(A01(57, 14, 70), C6E.A03());
        hashMap.put(A01(291, 9, 52), C6E.A00().A02().name());
        hashMap.put(A01(277, 14, 94), String.valueOf(C6E.A00().A01()));
        C8K c8k = new C8K(this.A01, A6E);
        hashMap.put(A01(90, 6, 94), AbstractC04748o.A03(this.A01, c8k));
        hashMap.put(A01(R.styleable.AppCompatTheme_textAppearancePopupMenuHeader, 7, 53), c8k.A08());
        hashMap.put(A01(315, 4, 47), c8k.A09());
        hashMap.put(A01(362, 6, 79), String.valueOf(C04668g.A00(this.A01).A00));
        hashMap.put(A01(300, 9, 48), c8k.A0B());
        hashMap.put(A01(501, 14, 90), L2.A01());
        hashMap.put(A01(336, 12, 105), String.valueOf(AbstractC0772Ld.A00(this.A01).A00));
        hashMap.put(A01(515, 12, 62), C0774Lf.A02(this.A01.A08().A01()));
        C04668g.A06(this.A01, packageName, hashMap);
        String A032 = LB.A03(this.A01, packageName);
        if (A032 != null) {
            hashMap.put(A01(48, 5, R.styleable.AppCompatTheme_textAppearancePopupMenuHeader), A032);
        }
        String A01 = A01(527, 5, 93);
        if (c8z == null || c8z.A9J() == null) {
            boolean A052 = LE.A05(this.A01);
            String[] strArr = A05;
            if (strArr[4].charAt(13) != strArr[3].charAt(13)) {
                String[] strArr2 = A05;
                strArr2[0] = "QjWbpZqZ2FnOkDqqT2mF";
                strArr2[5] = "jLLt7Z5bJGK6A0Aog3pW";
                hashMap.put(A01, String.valueOf(A052));
            } else {
                A05[2] = "qediMiT4WavMJtrcq3vkVjRUgBtN4c7f";
                hashMap.put(A01, String.valueOf(A052));
            }
        } else {
            hashMap.put(A01, String.valueOf(c8z.A9J()));
        }
        String A7P = (c8z == null || c8z.A7Q() == null) ? this.A01.A04().A7P() : c8z.A7Q();
        if (A7P != null) {
            hashMap.put(A01(319, 17, 78), A7P);
        }
        hashMap.put(A01(2, 21, 29), String.valueOf(c8k.A0C()));
        if (c8k.A03() != -1) {
            hashMap.put(A01(29, 19, 37), String.valueOf(c8k.A03()));
        }
        hashMap.put(A01(542, 9, 18), C04608a.A05(this.A01, packageName));
        hashMap.put(A01(23, 6, 33), LJ.A01(C8J.A02()));
        if (AbstractC0704Ig.A05(this.A01) && (A74 = this.A01.A04().A74()) != null) {
            hashMap.put(A01(53, 4, 93), A74);
        }
        C7k A042 = this.A01.A04();
        if (A05[2].charAt(4) != '1') {
            A05[2] = "Wn31NZtM2oeCISpfWM8NBUgIFylswktz";
            String A7V = A042.A7V();
            if (!TextUtils.isEmpty(A7V)) {
                hashMap.put(A01(348, 14, 1), A7V);
            }
            C04547t c04547t = null;
            if (c8z != null) {
                C04447f c04447f = this.A01;
                if (A05[2].charAt(4) == '1') {
                    throw new RuntimeException();
                }
                A05[2] = "UkbZyMMn6UWteLCB6DOs48k1ItwI1bgo";
                c04547t = c8z.A6k(c04447f);
            }
            if (c04547t == null) {
                c04547t = this.A01.A06().A6i();
            }
            String A012 = A01(167, 29, 78);
            String A013 = A01(136, 31, 31);
            String A014 = A01(R.styleable.AppCompatTheme_toolbarStyle, 23, 69);
            if (c04547t != null) {
                hashMap.put(A014, c04547t.A08());
                hashMap.put(A013, String.valueOf(c04547t.A05()));
                hashMap.put(A012, String.valueOf(c04547t.A06()));
            } else {
                String A015 = A01(551, 4, 88);
                hashMap.put(A014, A015);
                hashMap.put(A013, A015);
                hashMap.put(A012, A015);
            }
            hashMap.put(A01(96, 10, 97), C02870w.A01(this.A01).A0K());
            String A033 = this.A00.A03(this.A01);
            if (A033 != null && !TextUtils.isEmpty(A033)) {
                hashMap.put(A01(71, 19, 36), A033);
            }
            hashMap.put(A01(260, 13, 63), String.valueOf(this.A01.A03().A8Y()));
            hashMap.put(A01(221, 13, 17), String.valueOf(AnonymousClass84.A0H(this.A01)));
            StringBuilder sb = new StringBuilder();
            C0V[] c0vArr = A06;
            int i6 = 0;
            while (true) {
                if (i6 >= c0vArr.length) {
                    break;
                }
                sb.append(c0vArr[i6].A02() + 4000);
                if (i6 != c0vArr.length - 1) {
                    sb.append(A01(1, 1, 104));
                }
                i6++;
            }
            hashMap.put(A01(203, 18, 98), sb.toString());
            PackageInfo A00 = A00(this.A01);
            hashMap.put(A01(438, 20, 37), String.valueOf(A00 != null));
            if (A00 != null) {
                String valueOf = String.valueOf(A00.versionCode);
                String[] strArr3 = A05;
                if (strArr3[4].charAt(13) != strArr3[3].charAt(13)) {
                    A05[6] = "xKGYwiP6FmOHB7jmGj6acD63E";
                    hashMap.put(A01(458, 18, 101), valueOf);
                } else {
                    hashMap.put(A01(458, 18, 101), valueOf);
                }
            }
            if (c8z != null && c8z.A9E()) {
                hashMap.put(A01(398, 18, 123), Boolean.TRUE.toString());
                if (c8z.A6S() != null) {
                    hashMap.put(A01(368, 21, 70), c8z.A6S());
                }
            }
            if (AbstractC0707Ik.A07(this.A01)) {
                String A022 = AbstractC04618b.A02(this.A01.A01());
                if (A022 != null) {
                    hashMap.put(A01(416, 22, 123), A022);
                }
                String A016 = AbstractC04618b.A01(this.A01.A01());
                if (A022 != null) {
                    hashMap.put(A01(389, 9, 20), A016);
                }
            }
            return hashMap;
        }
        throw new RuntimeException();
    }

    static {
        A02();
        A03 = false;
        A06 = new C0V[]{C0V.A16, C0V.A0k, C0V.A17, C0V.A1F, C0V.A11, C0V.A13, C0V.A2B, C0V.A2C, C0V.A2D};
    }

    public YI(C04447f c04447f, boolean z2, C6S c6s) {
        this.A01 = c04447f;
        this.A00 = c6s;
        C04668g.A08(c04447f, z2, null);
    }

    public static synchronized PackageInfo A00(C04447f c04447f) {
        PackageInfo packageInfo;
        synchronized (YI.class) {
            if (!A03) {
                A02 = LM.A00(c04447f);
                A03 = true;
            }
            packageInfo = A02;
        }
        return packageInfo;
    }

    public final String A03() {
        return A04(C04698j.A00());
    }
}

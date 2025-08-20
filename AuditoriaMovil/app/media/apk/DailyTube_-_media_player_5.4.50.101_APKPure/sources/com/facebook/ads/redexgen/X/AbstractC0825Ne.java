package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.Arrays;
import java.util.Locale;
/* renamed from: com.facebook.ads.redexgen.X.Ne  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0825Ne {
    public static byte[] A00;
    public static String[] A01 = {"y0bG", "5JZfgaaWSogkW6CLjfjWUpC4SZDBnyft", "n2Gy4uoDZ6R42oJOJFciNGvUDpuCFsrY", "5ngtkuzSlt3rkDwwAmiTxWGxDtSc3Osy", "THEbbJWzjj3eFDlXZnSzsYrmSmbq8w3u", "z1FkhoLSx5iYuLnsFM", "3teRnM8c4jgHocWnqrQSqB4Xqv7CtSGf", "kWJrKkGk49E8x2kcQZmrso6J6ECpLyYL"};

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A01;
            if (strArr[2].charAt(11) == strArr[3].charAt(11)) {
                throw new RuntimeException();
            }
            A01[0] = "y3Jx6HlNhV60F8H6sy5VNq1urpo6ww";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 46);
            i8++;
        }
    }

    public static void A02() {
        A00 = new byte[]{-4, -3, 10, 16, 15, -43, -3, 7, -4, 9, 6, -81, -69, -69, -73, -70, -127, 118, 118, -66, -66, -66, 117, 108, -70, 117, -83, -88, -86, -84, -87, -74, -74, -78, 117, -86, -74, -76, -70, -58, -58, -62, -59, -116, -127, -127, -55, -55, -55, Byte.MIN_VALUE, -72, -77, -75, -73, -76, -63, -63, -67, Byte.MIN_VALUE, -75, -63, -65, -127, -48, -62, -47, -86, -58, -43, -62, -63, -96, -52, -53, -47, -62, -53, -47, -86, -52, -63, -62};
    }

    static {
        A02();
    }

    public static String A01(String str) {
        return TextUtils.isEmpty(str) ? A00(38, 25, 36) : String.format(Locale.US, A00(11, 27, 25), str);
    }

    public static void A03(WebView webView) {
        webView.loadUrl(A00(0, 11, 109));
        webView.clearCache(true);
    }

    public static void A04(WebView webView) {
        WebSettings settings = webView.getSettings();
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
            return;
        }
        try {
            WebSettings.class.getMethod(A00(63, 19, 47), new Class[0]).invoke(settings, 0);
        } catch (Exception unused) {
        }
    }
}

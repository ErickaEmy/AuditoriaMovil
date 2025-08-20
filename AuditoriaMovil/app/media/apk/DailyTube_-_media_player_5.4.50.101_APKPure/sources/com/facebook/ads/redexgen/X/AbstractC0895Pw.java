package com.facebook.ads.redexgen.X;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.uv.v7.R;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Pw  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0895Pw {
    public static boolean A00;
    public static byte[] A01;
    public static String[] A02 = {"Y0rICHp14ARSNu9MlXOQlrQKpJ7V2hwf", "9bmfgm9m8nITbmWk0ICcMAG3MrS", "cwEc0HiI6y8ZhWJ4MUGuUSsWKgKIPOUb", "CeguwAwwe", "1UN8Pz5pD", "KG5kSs2s3o8nfvSCZiVMOrQyfdZTA2DP", "BO8EwxINC4bfwl9QwPIiUjcYWt5Jq71N", "VnsxrIf3KddrD6MinhDJfsdqz9CBs5tu"};

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A02[2].charAt(4) == 'h') {
                throw new RuntimeException();
            }
            A02[5] = "V4DWKv2CalsHghC0GoFw5ZQ5aRA0odCa";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 71);
            i8++;
        }
    }

    public static void A03() {
        A01 = new byte[]{-1, 36, 46, 43, 39, 28, 52, 8, 32, 47, 45, 36, 30, 46, -37, 36, 46, -37, 41, 48, 39, 39, -23, 9, 28, 42, 38, 44, 41, 26, 28, 42, -41, 32, 42, -41, 37, 44, 35, 35, -27, -65, -54, -43, -46, -51, -54, -35, -46, -40, -41, -119, -49, -54, -46, -43, -50, -51, -105, -34, -32, -35};
    }

    static {
        A03();
        A00 = true;
    }

    public static BitmapDrawable A00(C1116Yn c1116Yn, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            byte[] decode = Base64.decode(str, 0);
            Bitmap overlayBm = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            if (overlayBm != null && (!A00 || A05(c1116Yn, overlayBm))) {
                BitmapDrawable overlayRepeat = new BitmapDrawable(overlayBm);
                overlayRepeat.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                Resources resources = c1116Yn.getResources();
                if (resources != null) {
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    if (displayMetrics != null) {
                        overlayRepeat.setTargetDensity(displayMetrics.densityDpi);
                    } else {
                        A04(c1116Yn, A02(0, 23, 116));
                    }
                } else {
                    A04(c1116Yn, A02(23, 18, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle));
                }
                return overlayRepeat;
            }
            return null;
        } catch (Throwable th) {
            c1116Yn.A07().A9a(A02(59, 3, 42), C8A.A1u, new C8B(th));
            return null;
        }
    }

    public static C0896Px A01(C1116Yn c1116Yn, String str) {
        BitmapDrawable A002;
        try {
            if (TextUtils.isEmpty(str) || (A002 = A00(c1116Yn, str)) == null) {
                return null;
            }
            C0896Px overlayView = new C0896Px(c1116Yn);
            if (Build.VERSION.SDK_INT >= 16) {
                overlayView.setBackground(A002);
            } else {
                overlayView.setBackgroundDrawable(A002);
            }
            overlayView.setClickable(false);
            overlayView.setFocusable(false);
            return overlayView;
        } catch (Throwable th) {
            c1116Yn.A07().A9a(A02(59, 3, 42), C8A.A1u, new C8B(th));
            return null;
        }
    }

    public static void A04(C1116Yn c1116Yn, String str) {
        c1116Yn.A07().A9a(A02(59, 3, 42), C8A.A1u, new C8B(str));
    }

    /* JADX WARN: Incorrect condition in loop: B:9:0x0021 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean A05(com.facebook.ads.redexgen.X.C1116Yn r5, android.graphics.Bitmap r6) {
        /*
            r3 = 0
        L1:
            int r4 = r6.getWidth()
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.AbstractC0895Pw.A02
            r0 = 2
            r1 = r1[r0]
            r0 = 4
            char r1 = r1.charAt(r0)
            r0 = 104(0x68, float:1.46E-43)
            if (r1 == r0) goto L4d
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AbstractC0895Pw.A02
            java.lang.String r1 = "44dBdHmZhYYzc5DiIB6SXSnn6xfqMO61"
            r0 = 2
            r2[r0] = r1
            if (r3 >= r4) goto L4b
            r2 = 0
        L1d:
            int r0 = r6.getHeight()
            if (r2 >= r0) goto L48
            int r0 = r6.getPixel(r3, r2)
            int r0 = android.graphics.Color.alpha(r0)
            float r1 = (float) r0
            r0 = 1132396544(0x437f0000, float:255.0)
            float r1 = r1 / r0
            r0 = 1022739087(0x3cf5c28f, float:0.03)
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 <= 0) goto L45
            r2 = 41
            r1 = 18
            r0 = 34
            java.lang.String r0 = A02(r2, r1, r0)
            A04(r5, r0)
            r0 = 0
            return r0
        L45:
            int r2 = r2 + 1
            goto L1d
        L48:
            int r3 = r3 + 1
            goto L1
        L4b:
            r0 = 1
            return r0
        L4d:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0895Pw.A05(com.facebook.ads.redexgen.X.Yn, android.graphics.Bitmap):boolean");
    }
}

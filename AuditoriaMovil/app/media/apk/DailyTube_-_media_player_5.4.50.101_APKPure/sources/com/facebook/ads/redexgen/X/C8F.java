package com.facebook.ads.redexgen.X;

import com.uv.v7.R;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.8F  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C8F {
    public static byte[] A00;
    public static String[] A01 = {"a6IxlCkVmcf1QOD6ZYjDV7INHBfwC5pE", "pjHGmgbtiOqji60ouNqSwKm8iDwdL2il", "jT1wBn6CKnjHaXeX1", "64rNhN6ZFhDWGxpIQ", "ze8vByysvbBiliYVuotBM6Di85tpEUzv", "oRRmyqjSmqskFAvbDRZ10d57ZrKFDjEI", "44vbl6FfanMIMy7ytQNCDD1eXfOrnFTF", "rkbwsxy0OcV7GrP7ELmdkRDeQR2uGuGh"};

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            int i10 = copyOfRange[i8] - i6;
            if (A01[1].charAt(1) == 'a') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[4] = "1M2Y98BwTvEPUGLlCwxj254fliWahs1n";
            strArr[0] = "azYACSqPfJkxfvivKERNz1YXvsYHtm8K";
            copyOfRange[i8] = (byte) (i10 - 68);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-47, -12, -20, -20, -18, -13, -20, -91, -45, -22, -7, -4, -12, -9, -16, -91, -54, -5, -22, -13, -7, -52, -35, -38, -55, -36, -47, -41, -42, 28, 41, 41, 38, 41, -9, 3, 3, -1, -18, 2, 3, -16, 3, 4, 2, -18, -14, -2, -13, -12, 22, 13, 28, 31, 23, 26, 19, -38, -53, -29, -42, -39, -53, -50, -55, -35, -45, -28, -49, 15, 16, -3, 14, 16, -5, 16, 5, 9, 1, -40, -45, -49, -46, -60, -57, -62, -42, -52, -35, -56};
    }

    static {
        A02();
    }

    public static JSONObject A01(C04447f c04447f, long j2, long j4, long j6, long j7, int i, Exception exc) {
        String A002;
        double d2;
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                jSONObject.put(A00(69, 10, 88), j2);
                A002 = A00(21, 8, 36);
                d2 = j4;
            } catch (JSONException e2) {
                e = e2;
            }
        } catch (JSONException e3) {
            e = e3;
        }
        if (A01[1].charAt(1) != 'a') {
            String[] strArr = A01;
            strArr[5] = "jMg5lz9yrKYKrG7ow7Rg5ttUcJr1AiZd";
            strArr[6] = "pmFVBxkrFRXwpMq5qFraASgBsRnTrBpW";
            try {
                jSONObject.put(A002, d2 / 1000.0d);
                try {
                    jSONObject.put(A00(57, 12, 38), j6);
                    try {
                        jSONObject.put(A00(79, 11, 31), j7);
                        try {
                            jSONObject.put(A00(34, 16, 75), i);
                            if (exc != null) {
                                jSONObject.put(A00(29, 5, R.styleable.AppCompatTheme_tooltipFrameBackground), exc.getMessage());
                            }
                        } catch (JSONException e5) {
                            e = e5;
                            c04447f.A07().A3c(e);
                            return jSONObject;
                        }
                    } catch (JSONException e6) {
                        e = e6;
                    }
                } catch (JSONException e8) {
                    e = e8;
                }
            } catch (JSONException e9) {
                e = e9;
            }
            return jSONObject;
        }
        throw new RuntimeException();
    }

    public static void A03(C04447f c04447f, long j2, long j4, long j6, long j7, int i, Exception exc) {
        C8B c8b = new C8B(A00(0, 21, 65));
        c8b.A05(1);
        c8b.A07(A01(c04447f, j2, j4, j6, j7, i, exc));
        c04447f.A07().AAA(A00(50, 7, 100), C8A.A20, c8b);
    }
}

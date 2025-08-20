package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.uv.v7.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public final class JD {
    public static byte[] A00;
    public static String[] A01 = {"8rCQ87LDNJC1DhxZ6fCr2sl9z", "5Hodpo98FOR", "IALBcgKUANLjYRQ96HtZ7fzkbeR9jBcx", "zTQAh3vDqOojvZYlgAqVeqBvFcLoF4J3", "z7HIEgV6NC3", "WxYOl0mgWg7jzfrY8MiYRxzCEbOVsE5E", "Fx", "GTrmlcJrnfi84XLQulxC5fcTBIr6OicG"};
    public static final String A02;
    public static final Map<String, Integer> A03;
    public static final AtomicInteger A04;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 7);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{57, 43, 89, 112, -126, 43, -127, 108, 119, Byte.MIN_VALUE, 112, 69, 43, 96, 111, 87, 124, -122, -125, 116, -121, 118, 123, 124, -127, 122, 51, Byte.MAX_VALUE, -126, 118, 116, Byte.MAX_VALUE, 51, 118, -126, -120, -127, -121, 120, -123, -122, 77, 51, 122, -97, -108, -93, -106, -98, -106, -97, -91, -102, -97, -104, 81, -108, -96, -90, -97, -91, -106, -93, 107, 81, -56, -21, -33, -35, -24, -65, -21, -15, -22, -16, -31, -18, -17, 116, 119, 119, 124, -121, 124, -126, -127, 116, Byte.MAX_VALUE, 114, 124, -127, 121, -126, -43, -24, -24, -39, -31, -28, -24, -111, -113, -93, -107, -106, -94, -115, -109, -90, -111, -109, -98, -94, -105, -99, -100, -46, -34, -36, -99, -43, -48, -46, -44, -47, -34, -34, -38, -99, -48, -45, -30, -99, -69, -66, -78, -80, -69, -50, -78, -66, -60, -67, -61, -76, -63, -62, -103, -106, -87, -106, -42, -25, -42, -33, -27, -28, -49, -46, -58, -60, -49, -62, -58, -46, -40, -47, -41, -56, -43, -42, -121, 120, -112, -125, -122, 120, 123, -95, -94, -113, -111, -103, -94, -96, -113, -111, -109, -124, -122, 115, -123, -118, -127, 118, -37, -35, -54, -36, -31, -40, -51, -57, -53, -41, -52, -51};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A06(C04447f c04447f, RK rk, Map<String, ?> map) throws JSONException {
        HashMap hashMap = new HashMap();
        hashMap.put(A01(93, 7, 109), A01(13, 1, 41));
        A09(c04447f, hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(A01(188, 7, 10), A01(157, 14, 92));
        hashMap2.put(A01(195, 12, 97), String.valueOf(3501));
        hashMap2.put(A01(100, 16, 39), A01(14, 1, 55));
        hashMap2.put(A01(178, 10, 39), A01(65, 13, 117));
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        if (c04447f.A04().A8z()) {
            String str = A01(15, 28, 12) + jSONObject.toString(2);
        }
        hashMap2.put(A01(78, 15, 12), jSONObject.toString());
        A09(c04447f, hashMap2);
        C04628c A08 = c04447f.A08();
        JSONObject A05 = C8C.A05(new C8E(A08.A01(), A08.A02(), hashMap2));
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(A05);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(A01(147, 4, 46), new JSONObject(hashMap));
        jSONObject2.put(A01(151, 6, R.styleable.AppCompatTheme_textAppearancePopupMenuHeader), jSONArray);
        RY ry = new RY();
        ry.put(A01(171, 7, 16), jSONObject2.toString());
        rk.AE0(c04447f.A04().A73(), ry.A08(), new VN(c04447f));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A09(C04447f c04447f, Map<String, String> map) {
        map.putAll(c04447f.A03().A4n());
    }

    static {
        A04();
        A02 = JD.class.getSimpleName();
        A04 = new AtomicInteger(0);
        A03 = new HashMap();
    }

    public static /* synthetic */ String A00() {
        String str = A02;
        if (A01[0].length() != 25) {
            throw new RuntimeException();
        }
        A01[5] = "AE0Gj58Mw00GT5T1b1OvPEW6lBfcUrG3";
        return str;
    }

    public static /* synthetic */ Map A02() {
        Map<String, Integer> map = A03;
        if (A01[2].charAt(23) != '7') {
            String[] strArr = A01;
            strArr[1] = "kE3yWNDHHw7";
            strArr[4] = "pIXzG0En7nL";
            return map;
        }
        throw new RuntimeException();
    }

    public static void A05(C04447f c04447f) {
        if (A0B(c04447f)) {
            return;
        }
        synchronized (JD.class) {
            AtomicInteger atomicInteger = A04;
            if (atomicInteger.get() != 0) {
                return;
            }
            atomicInteger.set(1);
            ExecutorC0788Lt.A06.execute(new VO(c04447f));
        }
    }

    public static void A08(C04447f c04447f, String str) {
        int i;
        int i5;
        if (A0B(c04447f)) {
            return;
        }
        synchronized (JD.class) {
            if (A04.get() != 2) {
                Map<String, Integer> map = A03;
                if (map.containsKey(str)) {
                    i5 = map.get(str).intValue();
                } else {
                    i5 = 0;
                }
                i = i5 + 1;
                map.put(str, Integer.valueOf(i));
            } else {
                SharedPreferences sharedPreferences = c04447f.getApplicationContext().getSharedPreferences(ProcessUtils.getProcessSpecificName(A01(116, 31, 104), c04447f), 0);
                i = sharedPreferences.getInt(str, 0) + 1;
                sharedPreferences.edit().putInt(str, i).apply();
            }
            if (c04447f.A04().A8z()) {
                String str2 = A01(43, 22, 42) + str + A01(0, 13, 4) + i;
            }
        }
    }

    public static boolean A0A(double d2, int i) {
        return i <= 0 || d2 >= 1.0d / ((double) i);
    }

    public static boolean A0B(C04447f c04447f) {
        if (c04447f.A04().A8z()) {
            return false;
        }
        if (!Ij.A0U(c04447f)) {
            return true;
        }
        return A0A(c04447f.A08().A00(), Ij.A0C(c04447f));
    }
}

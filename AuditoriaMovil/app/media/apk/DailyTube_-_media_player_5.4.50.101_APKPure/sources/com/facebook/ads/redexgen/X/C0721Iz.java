package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Iz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0721Iz {
    public static byte[] A07;
    public static String[] A08 = {"LYvtYpjh3A8vQy5q2R4RxEae0rP", "jA7v2s", "LzEc2Zjd8NVDeWOm9tYj7O2gb", "Qr4hCar3IUJK7IjuLaxeJKR14jvwbtqN", "uluEIDHou1vA3RshZYJ1CVooXlj", "7Mv6zZGpvnHTc", "8W43Le7bwqTNh", "1W0jBamhj3r3Yg4zpKy5fnBuSdv5NYDW"};
    public final double A00;
    public final double A01 = System.currentTimeMillis() / 1000.0d;
    public final J4 A02;
    public final J5 A03;
    public final String A04;
    public final String A05;
    public final Map<String, String> A06;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A08;
            if (strArr[4].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[7] = "vmrJ4a9vgt2Kh5jnKLFXcgPaai5qbtv5";
            strArr2[3] = "Xi4zcaKQ0kTUusAVwfois8CGtwAhjWs7";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 63);
            i8++;
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Map<String, String> A01(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value != null) {
                hashMap.put(key, value);
            }
        }
        return hashMap;
    }

    public static void A02() {
        A07 = new byte[]{97, 110, 97, 108, 111, 103, 109, 112, 107, 101, 107, 108, 99, 110, 93, 97, 110, 107, 103, 108, 118, 93, 118, 109, 105, 103, 108, 110, 117, 114, 104, 113, 121, 66, 116, 115, 126, 113, 104, 121, 120, 66, 116, 115, 66, 123, 104, 115, 115, 120, 113};
    }

    static {
        A02();
    }

    public C0721Iz(C04447f c04447f, String str, double d2, String str2, Map<String, String> map, J4 j4, J5 j52, boolean z2) {
        this.A05 = str;
        this.A00 = d2;
        this.A04 = str2;
        this.A02 = j4;
        this.A03 = j52;
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        if (z2) {
            hashMap.put(A00(27, 24, 34), String.valueOf(z2));
        }
        String A01 = JC.A01(str);
        if (!TextUtils.isEmpty(A01) && (z2 || j52 == J5.A0C)) {
            hashMap.put(A00(6, 21, 61), A01);
        }
        if (A0B()) {
            Map<String, String> extraData = c04447f.A03().A61();
            hashMap.put(A00(0, 6, 63), LJ.A01(extraData));
        }
        Map<String, String> extraData2 = A01(hashMap);
        this.A06 = extraData2;
    }

    public final double A03() {
        return this.A00;
    }

    public final double A04() {
        return this.A01;
    }

    public final J4 A05() {
        return this.A02;
    }

    public final J5 A06() {
        return this.A03;
    }

    public final String A07() {
        return this.A04;
    }

    public final String A08() {
        return this.A05;
    }

    public final Map<String, String> A09() {
        return this.A06;
    }

    public final boolean A0A() {
        return !TextUtils.isEmpty(this.A05);
    }

    public final boolean A0B() {
        return this.A02 == J4.A05;
    }
}

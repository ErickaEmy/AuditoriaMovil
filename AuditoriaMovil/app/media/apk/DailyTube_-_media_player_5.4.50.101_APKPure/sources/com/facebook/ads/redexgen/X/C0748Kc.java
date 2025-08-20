package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.Kc  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0748Kc {
    public static byte[] A05;
    public static String[] A06 = {"urwRhK0CK5UGRnO4iaICZFZb7qAlGy", "mzilr1wfe", "SZ9FDPGAkZBACw9tkVUtj7pHN9rS5abx", "dtKk7mnbAbd37arB17jMrf2UHdnm8GOF", "aS5", "gZFI9Tloea", "2aa2EaIeNK", "B3GaWiA9eOHa"};
    public static final Object A07;
    public static final Map<String, String> A08;
    public static final AtomicBoolean A09;
    public final SharedPreferences A00;
    public final C04447f A01;
    public final C8K A02;
    public final String A03;
    public final String A04;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 40);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        String[] strArr = A06;
        if (strArr[3].length() == strArr[0].length()) {
            throw new RuntimeException();
        }
        A06[1] = "McQY2w52D3qLTV4IvOql";
        A05 = new byte[]{116, 114, 117, 99, 8, 92, 121, 119, 106, 121, 105, 80, 92, 94, 29, 82, 93, 87, 65, 92, 90, 87, 29, 69, 86, 93, 87, 90, 93, 84, 71, 87, 69, 84, 77, 82, 66, 93, 86, 82, 6, 4, 15, 4, 19, 8, 2};
    }

    static {
        A04();
        A08 = new HashMap();
        A07 = new Object();
        A09 = new AtomicBoolean();
    }

    public C0748Kc(C04447f c04447f, String str) {
        this.A01 = c04447f;
        this.A03 = str;
        C8K c8k = new C8K(c04447f, str);
        this.A02 = c8k;
        this.A00 = KE.A00(c04447f);
        this.A04 = A01(1, 4, 27) + str + A01(0, 1, 103) + c8k.A06();
    }

    private final String A00() {
        return this.A00.getString(this.A04, null);
    }

    public static String A02(C04447f c04447f, String str) {
        try {
            PackageManager packageManager = c04447f.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return LG.A03(packageManager.getApplicationInfo(str, 0).sourceDir);
        } catch (Exception e2) {
            if (A09.compareAndSet(false, true)) {
                c04447f.A07().A9a(A01(40, 7, 73), C8A.A1P, new C8B(e2));
            }
            return null;
        }
    }

    public static String A03(String str) {
        String str2;
        synchronized (A07) {
            str2 = A08.get(str);
        }
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (r1.equals(r0) != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A05() throws org.json.JSONException {
        /*
            r7 = this;
            r4 = 0
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 31
            if (r1 >= r0) goto L17
            r2 = 5
            r1 = 1
            r0 = 39
            java.lang.String r1 = A01(r2, r1, r0)
            java.lang.String r0 = android.os.Build.VERSION.CODENAME
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L3d
        L17:
            com.facebook.ads.redexgen.X.7f r0 = r7.A01
            boolean r0 = com.facebook.ads.redexgen.X.C0705Ih.A2G(r0)
            if (r0 == 0) goto L3d
            r2 = 11
            r1 = 19
            r0 = 27
            java.lang.String r1 = A01(r2, r1, r0)
            com.facebook.ads.redexgen.X.8K r0 = r7.A02
            java.lang.String r0 = r0.A0B()
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L3d
            com.facebook.ads.redexgen.X.7f r1 = r7.A01
            java.lang.String r0 = r7.A03
            java.lang.String r4 = com.facebook.ads.redexgen.X.LG.A01(r1, r0)
        L3d:
            if (r4 != 0) goto L4b
            com.facebook.ads.redexgen.X.7f r1 = r7.A01
            java.lang.String r0 = r7.A03
            java.lang.String r4 = A02(r1, r0)
        L47:
            java.lang.Object r2 = com.facebook.ads.redexgen.X.C0748Kc.A07
            monitor-enter(r2)
            goto La8
        L4b:
            com.facebook.ads.redexgen.X.7f r0 = r7.A01
            boolean r0 = com.facebook.ads.redexgen.X.C0705Ih.A1I(r0)
            if (r0 == 0) goto L47
            com.facebook.ads.redexgen.X.7f r1 = r7.A01
            java.lang.String r0 = r7.A03
            java.lang.String r6 = A02(r1, r0)
            r2 = 6
            r1 = 5
            r0 = 50
            java.lang.String r0 = A01(r2, r1, r0)
            com.facebook.ads.redexgen.X.8B r5 = new com.facebook.ads.redexgen.X.8B
            r5.<init>(r0)
            r0 = 1
            r5.A05(r0)
            r5.A06(r0)
            r0 = 0
            r5.A0A(r0)
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            r2 = 30
            r1 = 5
            r0 = 12
            java.lang.String r0 = A01(r2, r1, r0)
            r3.put(r0, r4)
            r2 = 35
            r1 = 5
            r0 = 25
            java.lang.String r0 = A01(r2, r1, r0)
            r3.put(r0, r6)
            r5.A07(r3)
            com.facebook.ads.redexgen.X.7f r0 = r7.A01
            com.facebook.ads.redexgen.X.89 r3 = r0.A07()
            r2 = 40
            r1 = 7
            r0 = 73
            java.lang.String r1 = A01(r2, r1, r0)
            int r0 = com.facebook.ads.redexgen.X.C8A.A1I
            r3.A9b(r1, r0, r5)
            goto L47
        La8:
            java.util.Map<java.lang.String, java.lang.String> r1 = com.facebook.ads.redexgen.X.C0748Kc.A08     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r0 = r7.A03     // Catch: java.lang.Throwable -> Lc0
            r1.put(r0, r4)     // Catch: java.lang.Throwable -> Lc0
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lc0
            android.content.SharedPreferences r0 = r7.A00
            android.content.SharedPreferences$Editor r1 = r0.edit()
            java.lang.String r0 = r7.A04
            android.content.SharedPreferences$Editor r0 = r1.putString(r0, r4)
            r0.apply()
            return
        Lc0:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lc0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0748Kc.A05():void");
    }

    public final void A06() {
        String A00 = A00();
        synchronized (A07) {
            Map<String, String> map = A08;
            String storedFingerprint = this.A03;
            map.put(storedFingerprint, A00);
        }
    }
}

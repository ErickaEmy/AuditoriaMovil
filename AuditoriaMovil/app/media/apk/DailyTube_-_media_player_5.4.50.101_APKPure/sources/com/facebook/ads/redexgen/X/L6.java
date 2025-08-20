package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: assets/audience_network.dex */
public abstract class L6 {
    public static int A00;
    public static byte[] A01;
    public static String[] A02 = {"W5GQ1A2ylrhjGcW6pMhO2KpBuuMbjdB5", "Zx6aawmOn04orHuEArp9Y", "DMoITyb3L57ZarlqFv80uTh", "nsJ3", "1RYBeERStpTg7BOn5NhEUzstvZKMnlwS", "VuYSQW8JaBTDlxPB8JxFHKy", "", "NX"};
    public static final AtomicReference<Boolean> A03;
    public static volatile L5 A04;

    public static String A06(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 58);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A01 = new byte[]{60, 19, 25, 15, 18, 20, 25, 48, 28, 19, 20, 27, 24, 14, 9, 83, 5, 16, 17, 123, 121, 110, 115, 108, 115, 110, 99, 22, 7, 7, 27, 30, 20, 22, 3, 30, 24, 25, 24, 26, 17, 26, 13, 22, 28, 77, 73, 78, 115, 68, 75, 118, 69, 82, 83, 73, 79, 78, 17, 6, 16, 10, 25, 6, 2, 1, 15, 6, 34, 0, 23, 10, 21, 10, 23, 26, 122, 124, 106, 124, 34, 124, 107, 100};
    }

    static {
        A07();
        A00 = -1;
        A04 = L5.A04;
        A03 = new AtomicReference<>(null);
    }

    public static int A01(Context context) {
        if (A04 == L5.A04) {
            A08(context);
        }
        return A00;
    }

    public static int A02(Context context) {
        try {
            XmlResourceParser parser = context.getAssets().openXmlResourceParser(A06(0, 19, 71));
            return A05(parser);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int A03(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).minSdkVersion;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:10:0x0027 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int A05(org.xmlpull.v1.XmlPullParser r5) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
        L0:
            int r1 = r5.next()
            r0 = 1
            if (r1 == r0) goto L49
            int r1 = r5.getEventType()
            r0 = 2
            if (r1 != r0) goto L0
            java.lang.String r3 = r5.getName()
            r2 = 76
            r1 = 8
            r0 = 53
            java.lang.String r0 = A06(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L0
            r4 = 0
        L23:
            int r0 = r5.getAttributeCount()
            if (r4 >= r0) goto L0
            java.lang.String r3 = r5.getAttributeName(r4)
            r2 = 45
            r1 = 13
            r0 = 26
            java.lang.String r0 = A06(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L46
            java.lang.String r0 = r5.getAttributeValue(r4)
            int r0 = java.lang.Integer.parseInt(r0)
            return r0
        L46:
            int r4 = r4 + 1
            goto L23
        L49:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.L6.A05(org.xmlpull.v1.XmlPullParser):int");
    }

    public static void A08(Context context) {
        if (A0B()) {
            return;
        }
        A09(context);
    }

    public static void A09(Context context) {
        if (A04 != L5.A04) {
            return;
        }
        A04 = L5.A03;
        Executors.newSingleThreadExecutor().execute(new C1013Uk(context));
    }

    public static void A0A(C04447f c04447f, Throwable th) {
        c04447f.A07().A9a(A06(38, 7, 69), C8A.A1c, new C8B(th));
    }

    public static boolean A0B() {
        return A04 == L5.A02;
    }

    public static boolean A0C(C04447f c04447f) {
        Boolean cachedValue = A03.get();
        if (cachedValue != null) {
            return cachedValue.booleanValue();
        }
        XmlResourceParser xmlResourceParser = null;
        boolean z2 = true;
        try {
            xmlResourceParser = c04447f.getAssets().openXmlResourceParser(A06(0, 19, 71));
            loop0: while (true) {
                if (xmlResourceParser.next() == 1) {
                    break;
                } else if (xmlResourceParser.getEventType() == 2 && (xmlResourceParser.getName().equals(A06(27, 11, 77)) || xmlResourceParser.getName().equals(A06(19, 8, 32)))) {
                    for (int i = 0; i < xmlResourceParser.getAttributeCount(); i++) {
                        if (xmlResourceParser.getAttributeName(i).equals(A06(58, 18, 89)) && !Boolean.parseBoolean(xmlResourceParser.getAttributeValue(i))) {
                            z2 = false;
                            break loop0;
                        }
                    }
                    continue;
                }
            }
        } catch (Throwable th) {
            A0A(c04447f, th);
            String[] strArr = A02;
            if (strArr[5].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            A02[0] = "eeMQW8Hjee4jIvBA7BhrF0CVQhVUWKRk";
            if (xmlResourceParser != null) {
                try {
                    xmlResourceParser.close();
                } catch (Exception e2) {
                    A0A(c04447f, e2);
                }
            }
        }
        A03.set(Boolean.valueOf(z2));
        return z2;
    }
}

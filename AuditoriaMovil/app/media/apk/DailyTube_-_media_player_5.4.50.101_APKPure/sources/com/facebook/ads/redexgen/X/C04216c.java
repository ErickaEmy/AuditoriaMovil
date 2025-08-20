package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.uv.v7.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.6c  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C04216c {
    public static AnonymousClass00 A0A;
    public static List<String> A0B;
    public static byte[] A0C;
    public static String[] A0D = {"8gkZjHnxCvZyg7TzwjjGeSdvls9L7Gam", "fcbSC3ja3K2jNylkxCBC51G6bXitMdQ0", "2foOCT", "ocB0m3", "KfMQJM794wt5IuG", "feDb68pnVWWOEqV45c", "KnEa0S3Tnigt4irEXno07XBXpnYxFsFq", "aK1UKkDbG3zR1xh0x3umKxUvmkPLseuR"};
    public static final String A0E;
    public static final Map<String, AnonymousClass06> A0F;
    public static final Map<String, C04236e> A0G;
    public long A00;
    public JA A01;
    public final C04226d A03;
    public final C04447f A04;
    public final boolean A08;
    public final boolean A09;
    public final Map<String, Bitmap> A07 = Collections.synchronizedMap(new HashMap());
    public final Handler A02 = new Handler(Looper.getMainLooper());
    public final List<Callable<Boolean>> A05 = new ArrayList();
    public final List<Callable<Boolean>> A06 = new ArrayList();

    public static String A08(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 10);
        }
        return new String(copyOfRange);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static AtomicBoolean A0D(ArrayList<Callable<Boolean>> arrayList) {
        ArrayList<Future> arrayList2 = new ArrayList(arrayList.size());
        Iterator<Callable<Boolean>> it = arrayList.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            String[] strArr = A0D;
            if (strArr[3].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            A0D[5] = "";
            if (!hasNext) {
                AtomicBoolean atomicBoolean = new AtomicBoolean(true);
                try {
                    for (Future future : arrayList2) {
                        Boolean bool = (Boolean) future.get();
                        atomicBoolean.set(atomicBoolean.get() && bool != null && bool.booleanValue());
                    }
                } catch (InterruptedException | ExecutionException e2) {
                    Log.e(A0E, A08(86, 42, 61), e2);
                    atomicBoolean.set(false);
                }
                return atomicBoolean;
            }
            arrayList2.add(ExecutorC0788Lt.A02().submit(it.next()));
        }
    }

    public static void A0F() {
        A0C = new byte[]{124, -81, 122, -81, -85, -126, 125, Byte.MAX_VALUE, 108, -101, 105, -105, 106, -103, -100, -104, 84, 81, 82, -125, 85, Byte.MIN_VALUE, -127, Byte.MIN_VALUE, -119, -89, -87, -82, -85, 102, -71, -70, -89, -72, -70, -85, -86, 116, -113, -83, -81, -76, -75, -70, -77, 108, -81, -69, -71, -68, -72, -79, -64, -79, Byte.MAX_VALUE, -99, -97, -92, -91, -86, -93, 92, -94, -99, -91, -88, -95, -96, 100, -126, -124, -119, -118, -113, -120, 65, -108, -107, -126, -109, -107, -122, -123, 79, 79, 79, -116, -65, -86, -84, -73, -69, -80, -74, -75, 103, -66, -81, -80, -77, -84, 103, -84, -65, -84, -86, -68, -69, -80, -75, -82, 103, -86, -88, -86, -81, -84, 103, -85, -74, -66, -75, -77, -74, -88, -85, -70, 117, -79, -81, -79, -74, -77, -111, -67, -69, -66, -70, -77, -62, -73, -67, -68, -106, -67, -67, -71, 120, 118, 120, 125, 122, 91, 118, 126, -127, -118, -121, 122, 93, -124, -124, Byte.MIN_VALUE, -120, -101, -120, -122, -104, -105, -120, -24, -21, -35, -32, -27, -24, -38, -35, -40, -19, -30, -26, -34, -40, -26, -20, -96, -107, -100, -92};
    }

    static {
        A0F();
        A0E = C04216c.class.getSimpleName();
        A0F = Collections.synchronizedMap(new HashMap());
        A0G = Collections.synchronizedMap(new HashMap());
    }

    public C04216c(C04447f c04447f) {
        this.A04 = c04447f;
        this.A03 = C04226d.A06(c04447f.A01());
        this.A08 = C0705Ih.A2I(c04447f);
        this.A09 = C0705Ih.A2Q(c04447f, C0921Qw.A03());
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.facebook.ads.redexgen.X.07] */
    public static synchronized AnonymousClass00 A03(C1115Ym c1115Ym) {
        AnonymousClass00 anonymousClass00;
        synchronized (C04216c.class) {
            if (A0A == null) {
                A0A = AnonymousClass01.A00(c1115Ym, new Object() { // from class: com.facebook.ads.redexgen.X.07
                    public int A00;
                    public int A01;
                    public boolean A02;
                    public boolean A03;
                    public boolean A04;

                    public final AnonymousClass07 A00(int i) {
                        this.A00 = i;
                        return this;
                    }

                    public final AnonymousClass07 A01(int i) {
                        this.A01 = i;
                        return this;
                    }

                    public final AnonymousClass07 A02(boolean z2) {
                        this.A02 = z2;
                        return this;
                    }

                    public final AnonymousClass07 A03(boolean z2) {
                        this.A03 = z2;
                        return this;
                    }

                    public final AnonymousClass07 A04(boolean z2) {
                        this.A04 = z2;
                        return this;
                    }

                    public final AnonymousClass08 A05() {
                        return new AnonymousClass08(this.A00, this.A02, this.A01, this.A03, this.A04);
                    }
                }.A00(C0705Ih.A05(c1115Ym)).A02(c1115Ym.A04().A8z()).A01(-1).A03(C0705Ih.A0k(c1115Ym)).A04(C0705Ih.A2P(c1115Ym)).A05(), A05(c1115Ym));
            }
            anonymousClass00 = A0A;
        }
        return anonymousClass00;
    }

    public static AnonymousClass06 A04(C04447f c04447f, String str) {
        AnonymousClass06 anonymousClass06 = A0F.get(str);
        if (C04246f.A06(c04447f) && anonymousClass06 != null) {
            AnonymousClass06 storedCacheData = new AnonymousClass06(anonymousClass06);
            return storedCacheData;
        }
        AnonymousClass06 storedCacheData2 = new AnonymousClass06(str);
        return storedCacheData2;
    }

    public static C1120Yr A05(C1115Ym c1115Ym) {
        return new C1120Yr(c1115Ym);
    }

    public static synchronized List<String> A09(C04447f c04447f) {
        List<String> list;
        synchronized (C04216c.class) {
            if (A0B == null) {
                ArrayList arrayList = new ArrayList();
                A0B = arrayList;
                A0J(arrayList, c04447f);
            }
            list = A0B;
        }
        return list;
    }

    public static void A0H(C04447f c04447f, String str) {
        C04236e c04236e;
        if (C04246f.A06(c04447f) && !TextUtils.isEmpty(str) && (c04236e = A0G.get(str)) != null) {
            c04236e.A00 = A08(186, 4, 35);
            C1115Ym A01 = c04447f.A01();
            R0 A05 = R0.A05(A01);
            String A08 = R0.A08(A01, AbstractC0767Ky.A00(str));
            if (A08 == null) {
                A08 = str;
            }
            C04246f.A04(c04447f, c04236e, A05.A0H(A08));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0I(J9 j9) {
        if (this.A01 == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(A08(174, 12, R.styleable.AppCompatTheme_textColorSearchUrl), C0774Lf.A04(this.A00));
        this.A01.A04(j9, hashMap);
    }

    public static void A0J(List<String> cacheDirs, C04447f c04447f) {
        A0K(cacheDirs, C1263bn.A01(c04447f));
        A0K(cacheDirs, C04226d.A07(c04447f));
    }

    public static void A0K(List<String> list, File file) {
        String path;
        if (file == null || (path = file.getPath()) == null) {
            return;
        }
        String[] strArr = A0D;
        String str = strArr[3];
        String path2 = strArr[2];
        if (str.length() != path2.length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0D;
        strArr2[3] = "Vghlgc";
        strArr2[2] = "qwUey9";
        String path3 = A08(0, 0, 127);
        if (path != path3) {
            String path4 = path.toLowerCase(Locale.getDefault());
            list.add(path4);
        }
    }

    public final Bitmap A0M(String str) {
        return this.A07.get(str);
    }

    public final Bitmap A0N(String str, int i, int i5) {
        if (this.A08) {
            AnonymousClass06 A04 = A04(this.A04, str);
            A04.A03 = A08(186, 4, 35);
            A04.A01 = i5;
            A04.A00 = i;
            return A03(this.A04.A01()).AFH(A04, true).A00();
        }
        return this.A03.A0E(this.A04, str, i, i5, A08(170, 4, R.styleable.AppCompatTheme_tooltipForegroundColor));
    }

    public final File A0O(String str) {
        AnonymousClass06 A04 = A04(this.A04, str);
        A04.A03 = A08(186, 4, 35);
        return A03(this.A04.A01()).AFI(A04);
    }

    public final File A0P(String str) {
        if (this.A08) {
            return A0O(str);
        }
        return this.A03.A0F(str);
    }

    public final String A0Q(String str) {
        if (this.A08) {
            return A0R(str);
        }
        return this.A03.A0G(str);
    }

    public final String A0R(String str) {
        AnonymousClass06 A04 = A04(this.A04, str);
        A04.A03 = A08(186, 4, 35);
        String AFK = A03(this.A04.A01()).AFK(A04);
        return AFK != null ? AFK : str;
    }

    public final String A0S(String str) {
        if (this.A09) {
            A0H(this.A04, str);
            return str;
        }
        return A0R(str);
    }

    public final void A0T() {
        AbstractC0735Jp.A05(A08(NotificationCompat.FLAG_HIGH_PRIORITY, 19, 68), A08(38, 16, 66), A08(16, 8, 19));
    }

    public final void A0U() {
        AbstractC0735Jp.A05(A08(147, 16, 11), A08(54, 14, 50), A08(0, 8, 64));
    }

    public final void A0V() {
        this.A07.clear();
    }

    public final void A0W(C6U c6u, C6V c6v) {
        AbstractC0735Jp.A05(A08(163, 7, 25), A08(68, 18, 23), A08(8, 8, 44));
        this.A00 = System.currentTimeMillis();
        C04246f.A02(this.A04, c6v, C04246f.A07, A08(24, 14, 60), -1L);
        ExecutorC0788Lt.A03().execute(new C1121Ys(this, new ArrayList(this.A05), c6v, c6u, new ArrayList(this.A06)));
        this.A05.clear();
        this.A06.clear();
    }

    public final void A0X(C6Y c6y) {
        this.A05.add(new C6Z(this, c6y));
    }

    public final void A0Y(C6Y c6y) {
        c6y.A05 = true;
        this.A06.add(new C6Z(this, c6y));
    }

    public final void A0Z(C6Y c6y) {
        c6y.A05 = true;
        if (this.A09) {
            this.A06.add(new C6X(this, c6y));
        } else {
            this.A06.add(new C6Z(this, c6y));
        }
    }

    public final void A0a(C6Y c6y) {
        if (this.A09) {
            this.A05.add(new C6X(this, c6y));
        } else {
            this.A05.add(new C6Z(this, c6y));
        }
    }

    public final void A0b(final C04196a c04196a) {
        Callable<Boolean> callable = new Callable<Boolean>(c04196a) { // from class: com.facebook.ads.redexgen.X.6b
            public static byte[] A02;
            public static String[] A03 = {"jwTNBF52XqMGgcVEiQTwvXvSBsl43Bcu", "zl9XISU", "9LwyCiCzMXmNgkxTRjX8XUqiNT4UlidW", "Jar4Zz8ck96tLH67JFbLbWmYESMeU49V", "Yd8bjyjazIom6Oxe2tnjIAJyfdSlHwWG", "VgUZ5KaBAYbzt3oMIew8EQ4BA2c", "hXTgBapwd4emagenALPcDOSBW5zmdf3H", "17k"};
            public final C04196a A00;

            public static String A01(int i, int i5, int i6) {
                byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
                int i8 = 0;
                while (true) {
                    int length = copyOfRange.length;
                    if (A03[1].length() == 32) {
                        throw new RuntimeException();
                    }
                    A03[3] = "";
                    if (i8 >= length) {
                        return new String(copyOfRange);
                    }
                    copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 48);
                    i8++;
                }
            }

            public static void A02() {
                A02 = new byte[]{-20, -16, -28, -22, -24};
            }

            static {
                A02();
            }

            {
                this.A00 = c04196a;
            }

            private final Boolean A00() {
                C04447f c04447f;
                boolean z2;
                C04447f c04447f2;
                AnonymousClass00 A032;
                boolean z3;
                boolean z4;
                C04226d c04226d;
                Map map;
                if (KL.A02(this)) {
                    return null;
                }
                try {
                    TrafficStats.setThreadStatsTag(61453);
                    AnonymousClass06 anonymousClass06 = new AnonymousClass06(this.A00.A07, this.A00.A06, this.A00.A05, A01(0, 5, 83), this.A00.A01, this.A00.A02);
                    anonymousClass06.A01 = this.A00.A04;
                    anonymousClass06.A00 = this.A00.A03;
                    c04447f = C04216c.this.A04;
                    if (C04246f.A06(c04447f)) {
                        map = C04216c.A0F;
                        map.put(this.A00.A07, anonymousClass06);
                    }
                    z2 = C04216c.this.A08;
                    boolean z5 = false;
                    if (A03[3].length() != 5) {
                        A03[4] = "CZcPy1KhLDdCOlGcBT5xxsnRB32IUDMD";
                        if (!z2) {
                            c04226d = C04216c.this.A03;
                            if (c04226d.A0D(this.A00) != null) {
                                z5 = true;
                            }
                        } else {
                            c04447f2 = C04216c.this.A04;
                            A032 = C04216c.A03(c04447f2.A01());
                            z5 = A032.AFH(anonymousClass06, false).A01();
                        }
                        C6i c6i = this.A00.A00;
                        if (c6i != null && c6i.A02()) {
                            int A00 = c6i.A00();
                            int A01 = c6i.A01();
                            if (A00 <= 0 || A01 <= 0) {
                                z3 = C04216c.this.A08;
                                if (z3) {
                                    A04(this.A00.A07, anonymousClass06);
                                } else {
                                    A03(this.A00.A03, this.A00.A04);
                                }
                            } else {
                                z4 = C04216c.this.A08;
                                if (z4) {
                                    anonymousClass06.A00 = A00;
                                    anonymousClass06.A01 = A01;
                                    A04(this.A00.A07, anonymousClass06);
                                } else {
                                    A03(A00, A01);
                                }
                            }
                        }
                        return Boolean.valueOf(z5);
                    }
                    throw new RuntimeException();
                } catch (Throwable th) {
                    KL.A00(th, this);
                    return null;
                }
            }

            private void A03(int i, int i5) {
                C04226d c04226d;
                C04447f c04447f;
                Map map;
                c04226d = C04216c.this.A03;
                c04447f = C04216c.this.A04;
                Bitmap A0E2 = c04226d.A0E(c04447f, this.A00.A07, i, i5, this.A00.A01);
                if (A0E2 == null) {
                    return;
                }
                map = C04216c.this.A07;
                map.put(this.A00.A07, A0E2);
            }

            private void A04(String str, AnonymousClass06 anonymousClass06) {
                C04447f c04447f;
                AnonymousClass00 A032;
                Map map;
                c04447f = C04216c.this.A04;
                A032 = C04216c.A03(c04447f.A01());
                Bitmap A00 = A032.AFH(anonymousClass06, true).A00();
                if (A00 == null) {
                    return;
                }
                map = C04216c.this.A07;
                map.put(str, A00);
            }

            @Override // java.util.concurrent.Callable
            public final /* bridge */ /* synthetic */ Boolean call() throws Exception {
                if (KL.A02(this)) {
                    return null;
                }
                try {
                    return A00();
                } catch (Throwable th) {
                    KL.A00(th, this);
                    return null;
                }
            }
        };
        if (!c04196a.A02) {
            this.A05.add(callable);
        } else {
            this.A06.add(callable);
        }
    }

    public final void A0c(C04196a c04196a) {
        c04196a.A02 = true;
        A0b(c04196a);
    }

    public final void A0d(JA ja) {
        this.A01 = ja;
    }
}

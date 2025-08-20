package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.uv.v7.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
/* renamed from: com.facebook.ads.redexgen.X.bn  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1263bn implements AnonymousClass00 {
    public static byte[] A09;
    public static String[] A0A = {"2hmAfzTadn", "1uDqsMr9wv4o5ZghfCOZg4FuDp7sllqp", "nT1KYDstdBBAZ5nN", "UVqk4rMzzgqbiyaJgpoGMOUy0jQCoEBq", "ewXxsmpHr", "rT44HeCpkJQ", "C3kiv90mrVS0BL1BSM5Dfu9lHf0n3Csl", "grgxNBq6hb"};
    public static final String A0B;
    public final int A00;
    public final int A01;
    public final AnonymousClass08 A02;
    public final C0L A04;
    public final C04447f A05;
    public final boolean A08;
    public final Map<String, File> A06 = Collections.synchronizedMap(new HashMap());
    public final Map<String, Semaphore> A07 = new HashMap();
    public final C0A A03 = new C0A();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 22 out of bounds for length 22
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:118)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:567)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:39)
     */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0106: INVOKE  
      (r9v1 ?? I:com.facebook.ads.redexgen.X.0L)
      (r10 I:java.lang.String)
      (r11 I:int)
      (r12 I:java.lang.String)
      (r13 I:java.lang.Long)
      (r14 I:java.lang.Long)
      (r15 I:com.facebook.ads.redexgen.X.06)
     type: INTERFACE call: com.facebook.ads.redexgen.X.0L.AEP(java.lang.String, int, java.lang.String, java.lang.Long, java.lang.Long, com.facebook.ads.redexgen.X.06):void, block:B:40:0x00fb */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0120: INVOKE  
      (r9v0 ?? I:com.facebook.ads.redexgen.X.0L)
      (r10 I:java.lang.String)
      (r11 I:int)
      (r12 I:java.lang.String)
      (r13 I:java.lang.Long)
      (r14 I:java.lang.Long)
      (r15 I:com.facebook.ads.redexgen.X.06)
     type: INTERFACE call: com.facebook.ads.redexgen.X.0L.AEP(java.lang.String, int, java.lang.String, java.lang.Long, java.lang.Long, com.facebook.ads.redexgen.X.06):void, block:B:46:0x0115 */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0105: MOVE  (r15 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:40:0x00fb */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x011f: MOVE  (r15 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:46:0x0115 */
    private File A02(AnonymousClass06 anonymousClass06, String str, String str2, int i, AnonymousClass09 anonymousClass09) {
        AnonymousClass06 anonymousClass062;
        String AEP;
        AnonymousClass06 anonymousClass063;
        String AEP2;
        C1259bj c1259bj;
        String A03 = A03(222, 22, 68);
        try {
            String str3 = str;
            long currentTimeMillis = System.currentTimeMillis();
            File file = new File(A01(this.A05), str2);
            C1259bj c1259bj2 = new C1259bj(file, new GG(C0705Ih.A0N(this.A05)));
            if (c1259bj2.A09()) {
                if (this.A08) {
                    String str4 = A03(49, 22, R.styleable.AppCompatTheme_textAppearancePopupMenuHeader) + c1259bj2.A00.getName();
                }
                this.A06.put(str3, file);
                c1259bj2.A06();
                this.A04.AEQ(str3, true, anonymousClass06);
                return file;
            }
            if (this.A08) {
                String str5 = A03(71, 26, 117) + c1259bj2.A00.getName();
            }
            if (anonymousClass09.A04()) {
                this.A04.AEQ(str3, false, anonymousClass06);
                int i5 = 0;
                while (true) {
                    if (i5 >= this.A00) {
                        c1259bj = c1259bj2;
                        break;
                    }
                    try {
                        str3 = str3;
                        c1259bj = c1259bj2;
                        try {
                            A05(this.A05, c1259bj2, str3, i, i5, currentTimeMillis);
                            break;
                        } catch (C0H e2) {
                            e = e2;
                            if (i5 == this.A00 - 1) {
                                A06(c1259bj);
                                if (e instanceof C1260bk) {
                                    throw ((C1260bk) e);
                                }
                                if (e instanceof C1257bh) {
                                    throw ((C1257bh) e);
                                }
                            }
                            i5++;
                            c1259bj2 = c1259bj;
                        }
                    } catch (C0H e3) {
                        e = e3;
                        c1259bj = c1259bj2;
                    }
                    i5++;
                    c1259bj2 = c1259bj;
                }
                int A032 = c1259bj.A03();
                c1259bj.A06();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                anonymousClass09.A00().A4U(file, this.A04);
                this.A06.put(str3, file);
                this.A04.AEP(str3, 2112, null, Long.valueOf(A032), Long.valueOf(currentTimeMillis2), anonymousClass06);
                return file;
            }
            return null;
        } catch (C1257bh e5) {
            this.A04.AEP(AEP2, 2113, e5.toString(), null, null, anonymousClass063);
            if (this.A08) {
                Log.e(A0B, A03, e5);
                return null;
            }
            return null;
        } catch (C1260bk e6) {
            this.A04.AEP(AEP, 2119, e6.toString(), null, null, anonymousClass062);
            if (this.A08) {
                Log.e(A0B, A03, e6);
                return null;
            }
            return null;
        }
    }

    public static String A03(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A09, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            int i10 = copyOfRange[i8] - i6;
            String[] strArr = A0A;
            if (strArr[5].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[5] = "m9U6X0moZlc";
            strArr2[7] = "IfCNkNm6kG";
            copyOfRange[i8] = (byte) (i10 - 76);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A09 = new byte[]{-105, -33, -40, -22, -105, -39, -36, -36, -27, -105, -32, -27, -21, -36, -23, -23, -20, -25, -21, -36, -37, -91, -63, -75, -5, -2, 1, -6, -75, -8, 1, -6, -10, 3, -6, -7, -49, -75, -125, 117, -106, -55, -55, -70, -62, -59, -55, -113, 117, -7, 23, 25, 30, 31, 36, 29, -42, 28, 31, 34, 27, -42, 25, 37, 35, 38, 34, 27, 42, 27, -42, 4, 34, 36, 41, 42, 47, 40, -31, 39, 42, 45, 38, -31, 47, 48, 53, -31, 36, 48, 46, 49, 45, 38, 53, 38, -31, -91, -61, -59, -54, -53, -48, -55, -126, -47, -56, -126, -32, -2, 11, -60, 17, -67, 0, 9, 12, 16, 2, -67, 0, -2, 0, 5, 2, -67, 3, 6, 9, 2, -53, -80, -50, -37, -108, -31, -115, -33, -46, -50, -47, -115, -50, -32, -32, -46, -31, -32, -101, -69, -39, -26, -97, -20, -104, -22, -35, -39, -36, -104, -28, -35, -26, -33, -20, -32, -104, -25, -34, -104, -72, -39, -32, -39, -24, -35, -30, -37, -108, -41, -43, -41, -36, -39, -108, -38, -35, -32, -39, -108, -43, -38, -24, -39, -26, -108, -39, -20, -41, -39, -39, -40, -35, -30, -37, -108, -26, -39, -24, -26, -19, -108, -43, -24, -24, -39, -31, -28, -24, -25, -82, -108, -43, 2, 2, -1, 2, -80, -13, -15, -13, -8, -7, -2, -9, -80, 4, -8, -11, -80, -10, -7, -4, -11, -54, -9, -9, -12, -9, -91, -24, -15, -22, -26, -13, -18, -13, -20, -91, -21, -18, -15, -22, -72, -27, -27, -30, -27, -109, -42, -33, -30, -26, -36, -31, -38, -109, -26, -30, -24, -27, -42, -40, -72, -35, -46, -34, -36, -33, -37, -44, -29, -44, -113, -31, -44, -30, -33, -34, -35, -30, -44, -99, -65, -35, -28, -44, -39, -46, -117, -33, -38, -117, -35, -48, -52, -49, -117, -73, -70, -60, -51, -125, -68, -65, -62, -69, -125, -71, -73, -71, -66, -69, -18, 0, 0, -14, 1, -57, -68, -68, -68, 5, 8, 11, 4, -39, -50, -50, -50, 0, 13, 3, 17, 14, 8, 3, -2, 0, 18, 18, 4, 19, -50};
        String[] strArr = A0A;
        if (strArr[1].charAt(5) == strArr[3].charAt(5)) {
            throw new RuntimeException();
        }
        A0A[6] = "1YrvosXM8zHw8wsMUb3ulJ8Xgx5scBHO";
    }

    static {
        A04();
        A0B = C1263bn.class.getSimpleName();
    }

    public C1263bn(C04447f c04447f, AnonymousClass08 anonymousClass08, C0L c0l) {
        this.A05 = c04447f;
        this.A08 = anonymousClass08.A02();
        this.A00 = anonymousClass08.A00();
        this.A04 = c0l;
        this.A01 = anonymousClass08.A01();
        this.A02 = anonymousClass08;
    }

    public static C1261bl A00(Context context, String str) throws C0H {
        try {
            InputStream open = context.getAssets().open(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr, 0, bArr.length);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    return new C1261bl(byteArrayOutputStream.toByteArray());
                }
            }
        } catch (IOException e2) {
            throw new C0H(A03(131, 18, 33), e2);
        }
    }

    public static File A01(Context context) {
        return new File(context.getCacheDir(), A03(318, 15, 10));
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0109 A[Catch: all -> 0x0124, 0H -> 0x016b, TRY_LEAVE, TryCatch #14 {0H -> 0x016b, all -> 0x0124, blocks: (B:12:0x007c, B:38:0x0109, B:44:0x011c, B:36:0x0103, B:28:0x00bd, B:30:0x00c5), top: B:115:0x007c }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010d A[Catch: all -> 0x0166, 0H -> 0x0169, TRY_ENTER, TryCatch #11 {0H -> 0x0169, all -> 0x0166, blocks: (B:9:0x0051, B:17:0x008c, B:42:0x0116, B:47:0x0127, B:39:0x010d, B:41:0x0113, B:33:0x00f5, B:34:0x00fc), top: B:121:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011c A[Catch: all -> 0x0124, 0H -> 0x016b, TRY_ENTER, TRY_LEAVE, TryCatch #14 {0H -> 0x016b, all -> 0x0124, blocks: (B:12:0x007c, B:38:0x0109, B:44:0x011c, B:36:0x0103, B:28:0x00bd, B:30:0x00c5), top: B:115:0x007c }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A05(android.content.Context r24, com.facebook.ads.redexgen.X.C1259bj r25, java.lang.String r26, int r27, int r28, long r29) throws com.facebook.ads.redexgen.X.C0H {
        /*
            Method dump skipped, instructions count: 578
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1263bn.A05(android.content.Context, com.facebook.ads.redexgen.X.bj, java.lang.String, int, int, long):void");
    }

    private void A06(C1259bj c1259bj) {
        try {
            File A04 = c1259bj.A04();
            if (A04.exists()) {
                c1259bj.A06();
                boolean delete = A04.delete();
                if (this.A08) {
                    Log.i(A0B, A03(170, 52, 40) + delete);
                }
            }
        } catch (Exception e2) {
            if (this.A08) {
                Log.e(A0B, A03(108, 23, 81), e2);
            }
        }
    }

    private boolean A07(C1259bj c1259bj) {
        try {
            c1259bj.A05();
            return true;
        } catch (C1257bh e2) {
            boolean z2 = this.A08;
            if (A0A[6].charAt(7) != 'U') {
                A0A[6] = "AEs2mSbxTVyMZvMH4XlDgcN9VznTkYzp";
                if (z2) {
                    Log.e(A0B, A03(244, 19, 57), e2);
                    return false;
                }
                return false;
            }
            throw new RuntimeException();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.09 != com.facebook.ads.cache.config.CacheRequestConfig<T> */
    public final <T> AnonymousClass02<T> A08(AnonymousClass06 anonymousClass06, AnonymousClass09<T> anonymousClass09) {
        Semaphore semaphore;
        if (anonymousClass09.A03()) {
            File file = this.A06.get(anonymousClass06.A09);
            if (file != null) {
                this.A04.AEQ(anonymousClass06.A09, true, anonymousClass06);
                return anonymousClass09.A00().A3M(file, this.A04);
            }
            this.A04.AEQ(anonymousClass06.A09, false, anonymousClass06);
            return new AnonymousClass02<>(false, null);
        }
        String str = anonymousClass06.A09;
        String str2 = anonymousClass06.A04;
        StringBuilder sb = new StringBuilder();
        String baseUrl = this.A03.A03(str);
        String extension = sb.append(baseUrl).append(str2).toString();
        synchronized (this.A07) {
            semaphore = this.A07.get(extension);
            if (semaphore == null) {
                semaphore = new Semaphore(1);
                this.A07.put(extension, semaphore);
            }
            try {
            } catch (Throwable th) {
                semaphore.release();
                synchronized (this.A07) {
                    this.A07.remove(extension);
                    throw th;
                }
            }
        }
        try {
            semaphore.acquire();
            File A02 = A02(anonymousClass06, str, extension, this.A01, anonymousClass09);
            if (A02 != null) {
                AnonymousClass02<T> A3M = anonymousClass09.A00().A3M(A02, this.A04);
                semaphore.release();
                synchronized (this.A07) {
                    this.A07.remove(extension);
                }
                return A3M;
            }
            AnonymousClass02<T> anonymousClass02 = new AnonymousClass02<>(false, null);
            semaphore.release();
            synchronized (this.A07) {
                this.A07.remove(extension);
            }
            return anonymousClass02;
        } catch (InterruptedException unused) {
            if (this.A08) {
                StringBuilder sb2 = new StringBuilder();
                String baseUrl2 = A03(97, 11, 22);
                StringBuilder append = sb2.append(baseUrl2).append(str);
                String baseUrl3 = A03(0, 22, 43);
                append.append(baseUrl3).toString();
            }
            AnonymousClass02<T> anonymousClass022 = new AnonymousClass02<>(false, null);
            semaphore.release();
            synchronized (this.A07) {
                this.A07.remove(extension);
                return anonymousClass022;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass00
    public final AnonymousClass02<Bitmap> AFH(AnonymousClass06 anonymousClass06, boolean z2) {
        return A08(anonymousClass06, new AnonymousClass09(new C1266bq(anonymousClass06.A01, anonymousClass06.A00, this.A02.A04(), this.A02.A03(), z2)));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.09 != com.facebook.ads.cache.config.CacheRequestConfig<java.io.File> */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass00
    public final File AFI(AnonymousClass06 anonymousClass06) {
        AnonymousClass09 anonymousClass09 = new AnonymousClass09(new C1265bp());
        anonymousClass09.A01(true);
        anonymousClass09.A02(false);
        return (File) A08(anonymousClass06, anonymousClass09).A00();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass00
    public final String AFJ(AnonymousClass06 anonymousClass06) {
        return (String) A08(anonymousClass06, new AnonymousClass09(new C1264bo())).A00();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.09 != com.facebook.ads.cache.config.CacheRequestConfig<java.lang.String> */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass00
    public final String AFK(AnonymousClass06 anonymousClass06) {
        AnonymousClass09 anonymousClass09 = new AnonymousClass09(new C1264bo());
        anonymousClass09.A01(true);
        anonymousClass09.A02(false);
        return (String) A08(anonymousClass06, anonymousClass09).A00();
    }
}

package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: assets/audience_network.dex */
public abstract class HQ {
    public static String[] A00 = {"QVkvGuTrNYCOXAoNAePTggpZ9p9y8rjH", "Ru98bprrD7b3UUfLrlKs", "", "dJgVNsDePsDRNqW", "8CeCwhAARX5BeZctdCHITAez339E1kKv", "TdcchyCe9I3Btqth6iKX4VQ7acLjRTHE", "dxVA2OdEqxN0v6bZFx4Cf7LzvY6ZoBAr", "aJerxmZYtdmBHI5cIDnwKt2ezc6XXR2j"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x009e: INVOKE  (r3 I:com.facebook.ads.redexgen.X.Gu) type: STATIC call: com.facebook.ads.redexgen.X.IF.A0W(com.facebook.ads.redexgen.X.Gu):void, block:B:37:0x009e */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00ae: INVOKE  (r3 I:com.facebook.ads.redexgen.X.Gu) type: STATIC call: com.facebook.ads.redexgen.X.IF.A0W(com.facebook.ads.redexgen.X.Gu):void, block:B:43:0x00ae */
    public static long A00(C0671Gy c0671Gy, long j2, long j4, InterfaceC0667Gu interfaceC0667Gu, byte[] bArr, I3 i32, int i, HP hp) throws IOException, InterruptedException {
        InterfaceC0667Gu interfaceC0667Gu2;
        while (true) {
            if (i32 != null) {
                i32.A01(i);
            }
            try {
                break;
            } catch (I2 unused) {
            } finally {
                IF.A0W(interfaceC0667Gu2);
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        C0671Gy c0671Gy2 = new C0671Gy(c0671Gy.A04, c0671Gy.A06, j2, (c0671Gy.A03 + j2) - c0671Gy.A01, -1L, c0671Gy.A05, c0671Gy.A00 | 2);
        long ADl = interfaceC0667Gu2.ADl(c0671Gy2);
        if (hp.A01 == -1 && ADl != -1) {
            hp.A01 = c0671Gy2.A01 + ADl;
        }
        long j6 = 0;
        while (true) {
            if (j6 == j4) {
                break;
            } else if (Thread.interrupted()) {
                throw new InterruptedException();
            } else {
                int read = interfaceC0667Gu2.read(bArr, 0, j4 != -1 ? (int) Math.min(bArr.length, j4 - j6) : bArr.length);
                if (A00[3].length() != 15) {
                    throw new RuntimeException();
                }
                A00[1] = "Mr4dmhY4u";
                if (read != -1) {
                    j6 += read;
                    hp.A02 += read;
                } else if (hp.A01 == -1) {
                    hp.A01 = c0671Gy2.A01 + j6;
                }
            }
        }
        return j6;
    }

    public static String A01(Uri uri) {
        return uri.toString();
    }

    public static String A02(C0671Gy c0671Gy) {
        if (c0671Gy.A05 != null) {
            return c0671Gy.A05;
        }
        Uri uri = c0671Gy.A04;
        if (A00[0].charAt(11) != 'O') {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[5] = "cu8QQJDviMrw4mI2sOy5Vu7yKrvbPHoQ";
        strArr[7] = "0ihZqD29ZbZOvC3sCo5KdBScvHoXIGQ7";
        return A01(uri);
    }

    public static void A03(C0671Gy c0671Gy, HK hk, C1038Vk c1038Vk, byte[] bArr, I3 i32, int i, HP hp, AtomicBoolean atomicBoolean, boolean z2) throws IOException, InterruptedException {
        long start;
        HP hp2 = hp;
        AbstractC0672Ha.A01(c1038Vk);
        AbstractC0672Ha.A01(bArr);
        if (hp2 != null) {
            A04(c0671Gy, hk, hp2);
        } else {
            hp2 = new HP();
        }
        String A02 = A02(c0671Gy);
        long j2 = c0671Gy.A01;
        long start2 = c0671Gy.A02;
        if (start2 != -1) {
            start = c0671Gy.A02;
        } else {
            start = hk.A6W(A02);
        }
        while (true) {
            long j4 = 0;
            if (start != 0) {
                if (atomicBoolean == null || !atomicBoolean.get()) {
                    long A6G = hk.A6G(A02, j2, start != -1 ? start : Long.MAX_VALUE);
                    if (A6G <= 0) {
                        long j6 = -A6G;
                        A6G = j6;
                        if (A00(c0671Gy, j2, j6, c1038Vk, bArr, i32, i, hp2) < A6G) {
                            if (!z2 || start == -1) {
                                return;
                            }
                            throw new EOFException();
                        }
                    }
                    j2 += A6G;
                    if (start != -1) {
                        j4 = A6G;
                    }
                    start -= j4;
                } else {
                    throw new InterruptedException();
                }
            } else {
                return;
            }
        }
    }

    public static void A04(C0671Gy c0671Gy, HK hk, HP hp) {
        long left;
        String A02 = A02(c0671Gy);
        long j2 = c0671Gy.A01;
        if (c0671Gy.A02 != -1) {
            left = c0671Gy.A02;
        } else {
            left = hk.A6W(A02);
        }
        hp.A01 = left;
        hp.A00 = 0L;
        hp.A02 = 0L;
        while (left != 0) {
            long A6G = hk.A6G(A02, j2, left != -1 ? left : Long.MAX_VALUE);
            if (A6G > 0) {
                hp.A00 += A6G;
            } else {
                A6G = -A6G;
                if (A6G == Long.MAX_VALUE) {
                    return;
                }
            }
            j2 += A6G;
            if (left == -1) {
                A6G = 0;
            }
            left -= A6G;
        }
    }

    public static void A05(HK hk, String str) {
        for (HO ho2 : hk.A6H(str)) {
            try {
                hk.AF9(ho2);
            } catch (HI unused) {
            }
        }
    }
}

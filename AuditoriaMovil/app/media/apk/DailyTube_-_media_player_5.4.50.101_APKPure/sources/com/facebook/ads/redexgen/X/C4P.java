package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
/* renamed from: com.facebook.ads.redexgen.X.4P  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C4P implements Runnable {
    public static Comparator<C4O> A04;
    public static byte[] A05;
    public static String[] A06 = {"C", "g", "thIgEQWd9nx", "UJ", "nKFIv9xSQBz", "WKzZJ6F0j2u08DpGCnjDR9E", "2Nt4JwZoKXCf4OpJNcF1oxTto7W5gJbD", "RW"};
    public static final ThreadLocal<C4P> A07;
    public long A00;
    public long A01;
    public ArrayList<C0599Eb> A02 = new ArrayList<>();
    public ArrayList<C4O> A03 = new ArrayList<>();

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 8);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{97, 101, 47, 93, 116, -126, -125, 116, 115, 47, 95, -127, 116, 117, 116, -125, 114, 119, 92, 96, 42, 90, 124, 111, 112, 111, 126, 109, 114};
    }

    static {
        A03();
        A07 = new ThreadLocal<>();
        A04 = new Comparator<C4O>() { // from class: com.facebook.ads.redexgen.X.4N
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.Comparator
            /* renamed from: A00 */
            public final int compare(C4O c4o, C4O c4o2) {
                if ((c4o.A03 == null) != (c4o2.A03 == null)) {
                    return c4o.A03 == null ? 1 : -1;
                } else if (c4o.A04 != c4o2.A04) {
                    return c4o.A04 ? -1 : 1;
                } else {
                    int i = c4o2.A02 - c4o.A02;
                    if (i != 0) {
                        return i;
                    }
                    int i5 = c4o.A00;
                    int deltaViewVelocity = c4o2.A00;
                    int i6 = i5 - deltaViewVelocity;
                    if (i6 != 0) {
                        return i6;
                    }
                    return 0;
                }
            }
        };
    }

    private AnonymousClass56 A00(C0599Eb c0599Eb, int i, long j2) {
        if (A08(c0599Eb, i)) {
            return null;
        }
        C03894w c03894w = c0599Eb.A0r;
        try {
            c0599Eb.A1K();
            AnonymousClass56 A0I = c03894w.A0I(i, false, j2);
            if (A0I != null) {
                if (A0I.A0Y() && !A0I.A0Z()) {
                    c03894w.A0T(A0I.A0H);
                } else {
                    c03894w.A0Z(A0I, false);
                }
            }
            return A0I;
        } finally {
            c0599Eb.A1m(false);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:20:0x0078 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A02() {
        /*
            r10 = this;
            java.util.ArrayList<com.facebook.ads.redexgen.X.Eb> r0 = r10.A02
            int r4 = r0.size()
            r5 = 0
            r3 = 0
        L8:
            r2 = 0
            if (r3 >= r4) goto L26
            java.util.ArrayList<com.facebook.ads.redexgen.X.Eb> r0 = r10.A02
            java.lang.Object r1 = r0.get(r3)
            com.facebook.ads.redexgen.X.Eb r1 = (com.facebook.ads.redexgen.X.C0599Eb) r1
            int r0 = r1.getWindowVisibility()
            if (r0 != 0) goto L23
            com.facebook.ads.redexgen.X.Zp r0 = r1.A02
            r0.A04(r1, r2)
            com.facebook.ads.redexgen.X.Zp r0 = r1.A02
            int r0 = r0.A00
            int r5 = r5 + r0
        L23:
            int r3 = r3 + 1
            goto L8
        L26:
            java.util.ArrayList<com.facebook.ads.redexgen.X.4O> r0 = r10.A03
            r0.ensureCapacity(r5)
            r3 = 0
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C4P.A06
            r0 = 3
            r1 = r2[r0]
            r0 = 7
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L44
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L44:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C4P.A06
            java.lang.String r1 = "OH"
            r0 = 3
            r2[r0] = r1
            java.lang.String r1 = "7S"
            r0 = 7
            r2[r0] = r1
            r8 = 0
        L51:
            if (r8 >= r4) goto Lb3
            java.util.ArrayList<com.facebook.ads.redexgen.X.Eb> r0 = r10.A02
            java.lang.Object r9 = r0.get(r8)
            com.facebook.ads.redexgen.X.Eb r9 = (com.facebook.ads.redexgen.X.C0599Eb) r9
            int r0 = r9.getWindowVisibility()
            if (r0 == 0) goto L64
        L61:
            int r8 = r8 + 1
            goto L51
        L64:
            com.facebook.ads.redexgen.X.Zp r7 = r9.A02
            int r0 = r7.A01
            int r6 = java.lang.Math.abs(r0)
            int r0 = r7.A02
            int r0 = java.lang.Math.abs(r0)
            int r6 = r6 + r0
            r5 = 0
        L74:
            int r0 = r7.A00
            int r0 = r0 * 2
            if (r5 >= r0) goto L61
            java.util.ArrayList<com.facebook.ads.redexgen.X.4O> r0 = r10.A03
            int r0 = r0.size()
            if (r3 < r0) goto Laa
            com.facebook.ads.redexgen.X.4O r0 = new com.facebook.ads.redexgen.X.4O
            r0.<init>()
            java.util.ArrayList<com.facebook.ads.redexgen.X.4O> r1 = r10.A03
            r1.add(r0)
        L8c:
            int[] r2 = r7.A03
            int r1 = r5 + 1
            r2 = r2[r1]
            if (r2 > r6) goto La8
            r1 = 1
        L95:
            r0.A04 = r1
            r0.A02 = r6
            r0.A00 = r2
            r0.A03 = r9
            int[] r1 = r7.A03
            r1 = r1[r5]
            r0.A01 = r1
            int r3 = r3 + 1
            int r5 = r5 + 2
            goto L74
        La8:
            r1 = 0
            goto L95
        Laa:
            java.util.ArrayList<com.facebook.ads.redexgen.X.4O> r0 = r10.A03
            java.lang.Object r0 = r0.get(r3)
            com.facebook.ads.redexgen.X.4O r0 = (com.facebook.ads.redexgen.X.C4O) r0
            goto L8c
        Lb3:
            java.util.ArrayList<com.facebook.ads.redexgen.X.4O> r1 = r10.A03
            java.util.Comparator<com.facebook.ads.redexgen.X.4O> r0 = com.facebook.ads.redexgen.X.C4P.A04
            java.util.Collections.sort(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4P.A02():void");
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A04(long r4) {
        /*
            r3 = this;
            r2 = 0
        L1:
            java.util.ArrayList<com.facebook.ads.redexgen.X.4O> r0 = r3.A03
            int r0 = r0.size()
            if (r2 >= r0) goto L15
            java.util.ArrayList<com.facebook.ads.redexgen.X.4O> r0 = r3.A03
            java.lang.Object r1 = r0.get(r2)
            com.facebook.ads.redexgen.X.4O r1 = (com.facebook.ads.redexgen.X.C4O) r1
            com.facebook.ads.redexgen.X.Eb r0 = r1.A03
            if (r0 != 0) goto L16
        L15:
            return
        L16:
            r3.A06(r1, r4)
            r1.A00()
            int r2 = r2 + 1
            goto L1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4P.A04(long):void");
    }

    private final void A05(long j2) {
        A02();
        A04(j2);
    }

    private void A06(C4O c4o, long j2) {
        AnonymousClass56 A00 = A00(c4o.A03, c4o.A01, c4o.A04 ? Long.MAX_VALUE : j2);
        if (A00 != null && A00.A09 != null && A00.A0Y() && !A00.A0Z()) {
            A07(A00.A09.get(), j2);
        }
    }

    private void A07(C0599Eb c0599Eb, long j2) {
        if (c0599Eb == null) {
            return;
        }
        if (c0599Eb.A0C) {
            C4C c4c = c0599Eb.A01;
            if (A06[5].length() != 17) {
                A06[6] = "t2x0aSlbBonOFe0N5m1ttILNz4IaYpUW";
                if (c4c.A06() != 0) {
                    c0599Eb.A1N();
                }
            }
            throw new RuntimeException();
        }
        C1143Zp c1143Zp = c0599Eb.A02;
        c1143Zp.A04(c0599Eb, true);
        if (c1143Zp.A00 != 0) {
            try {
                AbstractC03332q.A01(A01(0, 18, 7));
                c0599Eb.A0s.A05(c0599Eb.A04);
                int i = 0;
                while (true) {
                    int i5 = c1143Zp.A00 * 2;
                    int i6 = A06[6].charAt(8);
                    if (i6 == 73) {
                        break;
                    }
                    String[] strArr = A06;
                    strArr[3] = "nG";
                    strArr[7] = "TD";
                    if (i < i5) {
                        A00(c0599Eb, c1143Zp.A03[i], j2);
                        i += 2;
                    } else {
                        return;
                    }
                }
                throw new RuntimeException();
            } finally {
                AbstractC03332q.A00();
            }
        }
    }

    public static boolean A08(C0599Eb c0599Eb, int i) {
        int A062 = c0599Eb.A01.A06();
        for (int i5 = 0; i5 < A062; i5++) {
            AnonymousClass56 A0F = C0599Eb.A0F(c0599Eb.A01.A0A(i5));
            int childCount = A0F.A03;
            if (childCount == i && !A0F.A0Z()) {
                return true;
            }
        }
        return false;
    }

    public final void A09(C0599Eb c0599Eb) {
        this.A02.add(c0599Eb);
    }

    public final void A0A(C0599Eb c0599Eb) {
        this.A02.remove(c0599Eb);
    }

    public final void A0B(C0599Eb c0599Eb, int i, int i5) {
        if (c0599Eb.isAttachedToWindow() && this.A01 == 0) {
            this.A01 = c0599Eb.getNanoTime();
            c0599Eb.post(this);
        }
        c0599Eb.A02.A03(i, i5);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            AbstractC03332q.A01(A01(18, 11, 2));
            if (this.A02.isEmpty()) {
                return;
            }
            int size = this.A02.size();
            long j2 = 0;
            for (int i = 0; i < size; i++) {
                C0599Eb c0599Eb = this.A02.get(i);
                if (c0599Eb.getWindowVisibility() == 0) {
                    j2 = Math.max(c0599Eb.getDrawingTime(), j2);
                }
            }
            if (j2 == 0) {
                this.A01 = 0L;
                if (A06[5].length() == 17) {
                    throw new RuntimeException();
                }
                A06[5] = "H4nD1dOrFb1";
                AbstractC03332q.A00();
                return;
            }
            A05(TimeUnit.MILLISECONDS.toNanos(j2) + this.A00);
        } finally {
            this.A01 = 0L;
            AbstractC03332q.A00();
        }
    }
}

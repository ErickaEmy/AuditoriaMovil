package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.Metadata;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class XL implements InterfaceC0554Bs, C1 {
    public static byte[] A0J;
    public static String[] A0K = {"NMENm2VVY4CjFU7qkzTmTxviYk7AnS7Z", "JBVFfjWytxpjUnZZ6lInsU7tzfFzOPaX", "YaevPinMBRqhVFzNm59vwI8bFO4cI8AD", "52TqclTutshaaFkrwJ4nyJTeA2xWvRpu", "JGseDZtum4mqdbq3nSxMUnsGXrSMUYmk", "xuKwDkc3QqvJvTm3i1k9vAbPWWVSjov2", "2GdyUNwnHd6eSNq3THJOdF5Wjs3u7UdX", "VVA8bJ0ju0kVaqoWpNH4VPWsYewebzZE"};
    public static final InterfaceC0557Bv A0L;
    public static final int A0M;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public InterfaceC0556Bu A09;
    public C0697Hz A0A;
    public boolean A0B;
    public CY[] A0C;
    public long[][] A0D;
    public final int A0E;
    public final C0697Hz A0F;
    public final C0697Hz A0G;
    public final C0697Hz A0H;
    public final ArrayDeque<XT> A0I;

    public static String A04(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0J, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 32);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A0J = new byte[]{107, 94, 69, 71, 10, 89, 67, 80, 79, 10, 70, 79, 89, 89, 10, 94, 66, 75, 68, 10, 66, 79, 75, 78, 79, 88, 10, 70, 79, 68, 77, 94, 66, 10, 2, 95, 68, 89, 95, 90, 90, 69, 88, 94, 79, 78, 3, 4, 104, 109, 57, 57};
    }

    static {
        A07();
        A0L = new XM();
        A0M = IF.A08(A04(48, 4, 57));
    }

    public XL() {
        this(0);
    }

    public XL(int i) {
        this.A0E = i;
        this.A0F = new C0697Hz(16);
        this.A0I = new ArrayDeque<>();
        this.A0H = new C0697Hz(AbstractC0693Hv.A03);
        this.A0G = new C0697Hz(4);
        this.A06 = -1;
    }

    private int A00(long j2) {
        long sampleAccumulatedBytes = Long.MAX_VALUE;
        int i = 1;
        int i5 = -1;
        long j4 = Long.MAX_VALUE;
        long j6 = Long.MAX_VALUE;
        int trackIndex = 1;
        int minAccumulatedBytesTrackIndex = -1;
        int i6 = 0;
        while (true) {
            CY[] cyArr = this.A0C;
            if (i6 < cyArr.length) {
                CY cy2 = cyArr[i6];
                int i8 = cy2.A00;
                if (i8 != cy2.A03.A01) {
                    long j7 = cy2.A03.A06[i8];
                    String[] strArr = A0K;
                    if (strArr[2].charAt(0) == strArr[4].charAt(0)) {
                        throw new RuntimeException();
                    }
                    A0K[7] = "SNUxNBsUQVazn7VwiZNUPsjETt3vlrb9";
                    long j8 = this.A0D[i6][i8];
                    long j9 = j7 - j2;
                    int i10 = (j9 < 0 || j9 >= 262144) ? 1 : 0;
                    if ((i10 == 0 && i != 0) || (i10 == i && j9 < sampleAccumulatedBytes)) {
                        i = i10;
                        sampleAccumulatedBytes = j9;
                        i5 = i6;
                        j4 = j8;
                    }
                    if (j8 < j6) {
                        j6 = j8;
                        trackIndex = i10;
                        minAccumulatedBytesTrackIndex = i6;
                    }
                }
                i6++;
            } else if (j6 == Long.MAX_VALUE || trackIndex == 0) {
                return i5;
            } else {
                long preferredSkipAmount = 10485760 + j6;
                if (j4 < preferredSkipAmount) {
                    return i5;
                }
                return minAccumulatedBytesTrackIndex;
            }
        }
    }

    private int A01(InterfaceC0555Bt interfaceC0555Bt, C0559Bz c0559Bz) throws IOException, InterruptedException {
        int i;
        long A7i = interfaceC0555Bt.A7i();
        if (this.A06 == -1) {
            int A00 = A00(A7i);
            this.A06 = A00;
            if (A00 == -1) {
                return -1;
            }
        }
        CY cy2 = this.A0C[this.A06];
        C4 trackOutput = cy2.A01;
        int i5 = cy2.A00;
        long j2 = cy2.A03.A06[i5];
        int i6 = cy2.A03.A05[i5];
        long j4 = (j2 - A7i) + this.A04;
        if (j4 < 0 || j4 >= 262144) {
            c0559Bz.A00 = j2;
            return 1;
        }
        if (cy2.A02.A02 == 1) {
            j4 += 8;
            i6 -= 8;
        }
        interfaceC0555Bt.AGP((int) j4);
        int sampleSize = cy2.A02.A01;
        String[] strArr = A0K;
        if (strArr[5].charAt(6) != strArr[3].charAt(6)) {
            String[] strArr2 = A0K;
            strArr2[2] = "Kr0RNkXRcq3MKFcdyeDViEL730qvS1Or";
            strArr2[4] = "dsHpYadjIesMKkl8nKWo5Xy2zI1EHMvq";
            if (sampleSize != 0) {
                byte[] bArr = this.A0G.A00;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                int nalUnitLengthFieldLength = cy2.A02.A01;
                int i8 = 4 - cy2.A02.A01;
                while (this.A04 < i6) {
                    int i10 = this.A05;
                    if (i10 == 0) {
                        interfaceC0555Bt.readFully(this.A0G.A00, i8, nalUnitLengthFieldLength);
                        this.A0G.A0Y(0);
                        this.A05 = this.A0G.A0H();
                        this.A0H.A0Y(0);
                        trackOutput.AFR(this.A0H, 4);
                        this.A04 += 4;
                        i6 += i8;
                    } else {
                        int AFQ = trackOutput.AFQ(interfaceC0555Bt, i10, false);
                        this.A04 += AFQ;
                        this.A05 -= AFQ;
                    }
                }
                i = 0;
            } else {
                while (true) {
                    int i11 = this.A04;
                    if (i11 >= i6) {
                        break;
                    }
                    int AFQ2 = trackOutput.AFQ(interfaceC0555Bt, i6 - i11, false);
                    this.A04 += AFQ2;
                    this.A05 -= AFQ2;
                }
                i = 0;
            }
            long[] jArr = cy2.A03.A07;
            String[] strArr3 = A0K;
            if (strArr3[0].charAt(11) != strArr3[1].charAt(11)) {
                A0K[6] = "rOKgrdqhHdXOkXubOIefZGVtdh7cvyNY";
                trackOutput.AFS(jArr[i5], cy2.A03.A04[i5], i6, 0, null);
                cy2.A00 += 0;
                this.A06 = -1;
                this.A04 = i;
                this.A05 = i;
                return i;
            }
            A0K[6] = "wHchi0wLq1ErSeSpKTFcZRDvkUCQV0RS";
            trackOutput.AFS(jArr[i5], cy2.A03.A04[i5], i6, 0, null);
            cy2.A00++;
            this.A06 = -1;
            this.A04 = i;
            this.A05 = i;
            return i;
        }
        throw new RuntimeException();
    }

    public static int A02(C0566Ch c0566Ch, long j2) {
        int A00 = c0566Ch.A00(j2);
        if (A00 == -1) {
            return c0566Ch.A01(j2);
        }
        return A00;
    }

    public static long A03(C0566Ch c0566Ch, long j2, long j4) {
        int A02 = A02(c0566Ch, j2);
        if (A02 == -1) {
            return j4;
        }
        long min = Math.min(c0566Ch.A06[A02], j4);
        if (A0K[6].charAt(20) != 'b') {
            String[] strArr = A0K;
            strArr[5] = "p3vbyKglgBhvg6ga7RihuDYjPakbSwaT";
            strArr[3] = "aiiDKqFmbgCXZZv8uVJN0mXFbRvDRlE6";
            return min;
        }
        throw new RuntimeException();
    }

    private ArrayList<C0566Ch> A05(XT xt, C0558Bw c0558Bw, boolean z2) throws C05059v {
        C0563Ce A0C;
        ArrayList<C0566Ch> arrayList = new ArrayList<>();
        for (int i = 0; i < xt.A01.size(); i++) {
            XT xt2 = xt.A01.get(i);
            int i5 = ((CJ) xt2).A00;
            if (i5 == CJ.A1M && (A0C = CO.A0C(xt2, xt.A07(CJ.A0o), -9223372036854775807L, null, z2, this.A0B)) != null) {
                C0566Ch A0E = CO.A0E(A0C, xt2.A06(CJ.A0e).A06(CJ.A0i).A06(CJ.A17), c0558Bw);
                if (A0E.A01 != 0) {
                    arrayList.add(A0E);
                }
            }
        }
        return arrayList;
    }

    private void A06() {
        this.A03 = 0;
        this.A00 = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0061, code lost:
        if (r5.A03 == 2) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0063, code lost:
        A06();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A08(long r6) throws com.facebook.ads.redexgen.X.C05059v {
        /*
            r5 = this;
        L0:
            java.util.ArrayDeque<com.facebook.ads.redexgen.X.XT> r0 = r5.A0I
            boolean r4 = r0.isEmpty()
            r3 = 2
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.XL.A0K
            r0 = 7
            r1 = r1[r0]
            r0 = 14
            char r1 = r1.charAt(r0)
            r0 = 114(0x72, float:1.6E-43)
            if (r1 == r0) goto L67
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.XL.A0K
            java.lang.String r1 = "xKK31fned0mjTVppOAxzoNj9viNrlryO"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "3HkC7zoZl6jjTlZPcBHC3lXiUTtQlSXh"
            r0 = 1
            r2[r0] = r1
            if (r4 != 0) goto L5f
            java.util.ArrayDeque<com.facebook.ads.redexgen.X.XT> r0 = r5.A0I
            java.lang.Object r0 = r0.peek()
            com.facebook.ads.redexgen.X.XT r0 = (com.facebook.ads.redexgen.X.XT) r0
            long r1 = r0.A00
            int r0 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r0 != 0) goto L5f
            java.util.ArrayDeque<com.facebook.ads.redexgen.X.XT> r0 = r5.A0I
            java.lang.Object r2 = r0.pop()
            com.facebook.ads.redexgen.X.XT r2 = (com.facebook.ads.redexgen.X.XT) r2
            int r1 = r2.A00
            int r0 = com.facebook.ads.redexgen.X.CJ.A0k
            if (r1 != r0) goto L4b
            r5.A0A(r2)
            java.util.ArrayDeque<com.facebook.ads.redexgen.X.XT> r0 = r5.A0I
            r0.clear()
            r5.A03 = r3
            goto L0
        L4b:
            java.util.ArrayDeque<com.facebook.ads.redexgen.X.XT> r0 = r5.A0I
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L0
            java.util.ArrayDeque<com.facebook.ads.redexgen.X.XT> r0 = r5.A0I
            java.lang.Object r0 = r0.peek()
            com.facebook.ads.redexgen.X.XT r0 = (com.facebook.ads.redexgen.X.XT) r0
            r0.A08(r2)
            goto L0
        L5f:
            int r0 = r5.A03
            if (r0 == r3) goto L66
            r5.A06()
        L66:
            return
        L67:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.XL.A08(long):void");
    }

    private void A09(long j2) {
        CY[] cyArr;
        for (CY cy2 : this.A0C) {
            C0566Ch c0566Ch = cy2.A03;
            int A00 = c0566Ch.A00(j2);
            if (A00 == -1) {
                A00 = c0566Ch.A01(j2);
            }
            cy2.A00 = A00;
            if (A0K[6].charAt(20) == 'b') {
                throw new RuntimeException();
            }
            String[] strArr = A0K;
            strArr[5] = "MNnvCsSYuz9FkO9KQczdYnABN7zTLwyu";
            strArr[3] = "oflUn1lXrJVPIzwz3GYNJmaWxDOTuoWv";
        }
    }

    private void A0A(XT xt) throws C05059v {
        ArrayList<C0566Ch> A05;
        int trackCount = -1;
        long j2 = -9223372036854775807L;
        ArrayList arrayList = new ArrayList();
        Metadata metadata = null;
        C0558Bw c0558Bw = new C0558Bw();
        XS A07 = xt.A07(CJ.A1Q);
        if (A07 != null && (metadata = CO.A0F(A07, this.A0B)) != null) {
            c0558Bw.A05(metadata);
        }
        try {
            A05 = A05(xt, c0558Bw, (this.A0E & 1) != 0);
        } catch (XP unused) {
            c0558Bw = new C0558Bw();
            A05 = A05(xt, c0558Bw, true);
        }
        int size = A05.size();
        for (int i = 0; i < size; i++) {
            C0566Ch c0566Ch = A05.get(i);
            C0563Ce c0563Ce = c0566Ch.A03;
            CY cy2 = new CY(c0563Ce, c0566Ch, this.A09.AGi(i, c0563Ce.A03));
            Format A0F = c0563Ce.A07.A0F(c0566Ch.A00 + 30);
            if (c0563Ce.A03 == 1) {
                if (c0558Bw.A03()) {
                    A0F = A0F.A0G(c0558Bw.A00, c0558Bw.A01);
                }
                if (metadata != null) {
                    A0F = A0F.A0J(metadata);
                }
            }
            cy2.A01.A5n(A0F);
            j2 = Math.max(j2, c0563Ce.A04 != -9223372036854775807L ? c0563Ce.A04 : c0566Ch.A02);
            if (c0563Ce.A03 == 2 && trackCount == -1) {
                trackCount = arrayList.size();
            }
            arrayList.add(cy2);
        }
        this.A02 = trackCount;
        this.A08 = j2;
        CY[] cyArr = (CY[]) arrayList.toArray(new CY[arrayList.size()]);
        this.A0C = cyArr;
        this.A0D = A0G(cyArr);
        this.A09.A5Y();
        this.A09.AFi(this);
    }

    public static boolean A0B(int i) {
        return i == CJ.A0k || i == CJ.A1M || i == CJ.A0e || i == CJ.A0i || i == CJ.A17 || i == CJ.A0O;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
        if (r4 != r3) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
        if (r4 == com.facebook.ads.redexgen.X.CJ.A0P) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005c, code lost:
        if (r4 == com.facebook.ads.redexgen.X.CJ.A1A) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
        if (r4 == com.facebook.ads.redexgen.X.CJ.A1D) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0064, code lost:
        if (r4 == com.facebook.ads.redexgen.X.CJ.A1F) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0068, code lost:
        if (r4 == com.facebook.ads.redexgen.X.CJ.A18) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006c, code lost:
        if (r4 == com.facebook.ads.redexgen.X.CJ.A0C) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0070, code lost:
        if (r4 == com.facebook.ads.redexgen.X.CJ.A1K) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0074, code lost:
        if (r4 == com.facebook.ads.redexgen.X.CJ.A0V) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0078, code lost:
        if (r4 != com.facebook.ads.redexgen.X.CJ.A1Q) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007c, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0085, code lost:
        if (r4 != r3) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean A0C(int r4) {
        /*
            int r0 = com.facebook.ads.redexgen.X.CJ.A0d
            if (r4 == r0) goto L7a
            int r0 = com.facebook.ads.redexgen.X.CJ.A0o
            if (r4 == r0) goto L7a
            int r3 = com.facebook.ads.redexgen.X.CJ.A0W
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.XL.A0K
            r0 = 2
            r1 = r2[r0]
            r0 = 4
            r2 = r2[r0]
            r0 = 0
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L88
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.XL.A0K
            java.lang.String r1 = "Lbfp0NvNFR61AEm901fhAiQEZdUAojSN"
            r0 = 7
            r2[r0] = r1
            if (r4 == r3) goto L7a
            int r0 = com.facebook.ads.redexgen.X.CJ.A1B
            if (r4 == r0) goto L7a
            int r0 = com.facebook.ads.redexgen.X.CJ.A1E
            if (r4 == r0) goto L7a
            int r0 = com.facebook.ads.redexgen.X.CJ.A1C
            if (r4 == r0) goto L7a
            int r3 = com.facebook.ads.redexgen.X.CJ.A0D
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.XL.A0K
            r0 = 0
            r1 = r2[r0]
            r0 = 1
            r2 = r2[r0]
            r0 = 11
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L7e
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.XL.A0K
            java.lang.String r1 = "AcWpjtb96ZMDu8ZbPmw7y3S9ldwHNTMG"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "liNDCAzQcSMqwn5YpITrjlM20opaDBZf"
            r0 = 4
            r2[r0] = r1
            if (r4 == r3) goto L7a
        L56:
            int r0 = com.facebook.ads.redexgen.X.CJ.A0P
            if (r4 == r0) goto L7a
            int r0 = com.facebook.ads.redexgen.X.CJ.A1A
            if (r4 == r0) goto L7a
            int r0 = com.facebook.ads.redexgen.X.CJ.A1D
            if (r4 == r0) goto L7a
            int r0 = com.facebook.ads.redexgen.X.CJ.A1F
            if (r4 == r0) goto L7a
            int r0 = com.facebook.ads.redexgen.X.CJ.A18
            if (r4 == r0) goto L7a
            int r0 = com.facebook.ads.redexgen.X.CJ.A0C
            if (r4 == r0) goto L7a
            int r0 = com.facebook.ads.redexgen.X.CJ.A1K
            if (r4 == r0) goto L7a
            int r0 = com.facebook.ads.redexgen.X.CJ.A0V
            if (r4 == r0) goto L7a
            int r0 = com.facebook.ads.redexgen.X.CJ.A1Q
            if (r4 != r0) goto L7c
        L7a:
            r0 = 1
        L7b:
            return r0
        L7c:
            r0 = 0
            goto L7b
        L7e:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.XL.A0K
            java.lang.String r1 = "Et4fiiNPrE1ktHaAFcacRxoSMiMckR7G"
            r0 = 6
            r2[r0] = r1
            if (r4 == r3) goto L7a
            goto L56
        L88:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.XL.A0C(int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x012a, code lost:
        if (r8 != 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x012c, code lost:
        r11.A07 = (r2 - r12.A7i()) + r11.A00;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0145, code lost:
        if (r8 != 0) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean A0D(com.facebook.ads.redexgen.X.InterfaceC0555Bt r12) throws java.io.IOException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.XL.A0D(com.facebook.ads.redexgen.X.Bt):boolean");
    }

    private boolean A0E(InterfaceC0555Bt interfaceC0555Bt, C0559Bz c0559Bz) throws IOException, InterruptedException {
        long j2 = this.A07 - this.A00;
        long atomEndPosition = interfaceC0555Bt.A7i() + j2;
        boolean z2 = false;
        C0697Hz c0697Hz = this.A0A;
        if (c0697Hz != null) {
            interfaceC0555Bt.readFully(c0697Hz.A00, this.A00, (int) j2);
            if (this.A01 == CJ.A0V) {
                this.A0B = A0F(this.A0A);
            } else if (!this.A0I.isEmpty()) {
                this.A0I.peek().A09(new XS(this.A01, this.A0A));
            }
        } else if (j2 < 262144) {
            interfaceC0555Bt.AGP((int) j2);
        } else {
            long atomPayloadSize = interfaceC0555Bt.A7i();
            c0559Bz.A00 = atomPayloadSize + j2;
            z2 = true;
        }
        A08(atomEndPosition);
        return z2 && this.A03 != 2;
    }

    public static boolean A0F(C0697Hz c0697Hz) {
        int A08;
        int majorBrand;
        c0697Hz.A0Y(8);
        int A082 = c0697Hz.A08();
        int majorBrand2 = A0M;
        if (A082 == majorBrand2) {
            return true;
        }
        c0697Hz.A0Z(4);
        do {
            int A04 = c0697Hz.A04();
            String[] strArr = A0K;
            String str = strArr[0];
            String str2 = strArr[1];
            int charAt = str.charAt(11);
            int majorBrand3 = str2.charAt(11);
            if (charAt != majorBrand3) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0K;
            strArr2[5] = "HZNBHqeXKlwJLRyY4R1ZazClo3jLxgS8";
            strArr2[3] = "ULnGw1bPzwMM6OF7GcjqoSbIBNnkFp5Y";
            if (A04 > 0) {
                A08 = c0697Hz.A08();
                majorBrand = A0M;
            } else {
                return false;
            }
        } while (A08 != majorBrand);
        return true;
    }

    public static long[][] A0G(CY[] cyArr) {
        long[][] jArr = new long[cyArr.length];
        int[] iArr = new int[cyArr.length];
        long[] jArr2 = new long[cyArr.length];
        boolean[] zArr = new boolean[cyArr.length];
        for (int i = 0; i < cyArr.length; i++) {
            jArr[i] = new long[cyArr[i].A03.A01];
            jArr2[i] = cyArr[i].A03.A07[0];
        }
        long j2 = 0;
        int i5 = 0;
        while (true) {
            int length = cyArr.length;
            String[] strArr = A0K;
            if (strArr[0].charAt(11) != strArr[1].charAt(11)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0K;
            strArr2[5] = "yJ2jD62HfH2jQTY3DSfm8DixkPqWTM6R";
            strArr2[3] = "ERCQlGdy7dAXpXma9fK0CLCiAFSx2az3";
            if (i5 < length) {
                long j4 = Long.MAX_VALUE;
                int minTimeTrackIndex = -1;
                for (int i6 = 0; i6 < cyArr.length; i6++) {
                    if (!zArr[i6] && jArr2[i6] <= j4) {
                        minTimeTrackIndex = i6;
                        j4 = jArr2[i6];
                    }
                }
                int i8 = iArr[minTimeTrackIndex];
                jArr[minTimeTrackIndex][i8] = j2;
                j2 += cyArr[minTimeTrackIndex].A03.A05[i8];
                int i10 = i8 + 1;
                iArr[minTimeTrackIndex] = i10;
                if (i10 < jArr[minTimeTrackIndex].length) {
                    jArr2[minTimeTrackIndex] = cyArr[minTimeTrackIndex].A03.A07[i10];
                } else {
                    zArr[minTimeTrackIndex] = true;
                    i5++;
                }
            } else {
                return jArr;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final long A6r() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final C0 A7t(long j2) {
        long j4;
        long j6;
        int A01;
        CY[] cyArr = this.A0C;
        if (cyArr.length == 0) {
            return new C0(C2.A03);
        }
        long j7 = -9223372036854775807L;
        long j8 = -1;
        int i = this.A02;
        if (i != -1) {
            C0566Ch c0566Ch = cyArr[i].A03;
            int A02 = A02(c0566Ch, j2);
            if (A02 == -1) {
                return new C0(C2.A03);
            }
            j4 = c0566Ch.A07[A02];
            j6 = c0566Ch.A06[A02];
            if (j4 < j2 && A02 < c0566Ch.A01 - 1 && (A01 = c0566Ch.A01(j2)) != -1 && A01 != A02) {
                j7 = c0566Ch.A07[A01];
                j8 = c0566Ch.A06[A01];
            }
        } else {
            j4 = j2;
            j6 = Long.MAX_VALUE;
        }
        int secondSampleIndex = 0;
        while (true) {
            CY[] cyArr2 = this.A0C;
            if (secondSampleIndex >= cyArr2.length) {
                break;
            }
            if (secondSampleIndex != this.A02) {
                C0566Ch c0566Ch2 = cyArr2[secondSampleIndex].A03;
                j6 = A03(c0566Ch2, j4, j6);
                if (j7 != -9223372036854775807L) {
                    j8 = A03(c0566Ch2, j7, j8);
                }
            }
            secondSampleIndex++;
        }
        C2 c2 = new C2(j4, j6);
        if (j7 == -9223372036854775807L) {
            return new C0(c2);
        }
        return new C0(c2, new C2(j7, j8));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final void A8o(InterfaceC0556Bu interfaceC0556Bu) {
        this.A09 = interfaceC0556Bu;
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final boolean A9I() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final int AEH(InterfaceC0555Bt interfaceC0555Bt, C0559Bz c0559Bz) throws IOException, InterruptedException {
        while (true) {
            switch (this.A03) {
                case 0:
                    if (A0D(interfaceC0555Bt)) {
                        break;
                    } else {
                        return -1;
                    }
                case 1:
                    if (!A0E(interfaceC0555Bt, c0559Bz)) {
                        break;
                    } else {
                        return 1;
                    }
                case 2:
                    return A01(interfaceC0555Bt, c0559Bz);
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final void AFh(long j2, long j4) {
        this.A0I.clear();
        this.A00 = 0;
        this.A06 = -1;
        this.A04 = 0;
        this.A05 = 0;
        if (j2 == 0) {
            A06();
        } else if (this.A0C == null) {
        } else {
            A09(j4);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final boolean AGR(InterfaceC0555Bt interfaceC0555Bt) throws IOException, InterruptedException {
        return AbstractC0562Cc.A04(interfaceC0555Bt);
    }
}

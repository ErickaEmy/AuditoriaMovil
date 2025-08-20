package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Hv  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0693Hv {
    public static byte[] A00;
    public static int[] A01;
    public static String[] A02 = {"NtIRWyZV8H4fZGcEpCmcKf3IqD05aRmR", "GeJrrdqpTOChTmOZ0a7zD9rW5xWuwwPC", "fB9woPX", "60Ey3AJYIgulbHGVt5ok32wwr6OtRAhs", "ywmal8sml3QBlriqnsJwUXbJL0wOA6tO", "h15JbuXclRunjao1u8Y3u6XMQgnEqNxE", "VnL2Csv3rCYD2ISe0PbhclEmcnjJ2Dil", "pqWxkCx1Owc6AlIW11IRV9LZfrwFezHs"};
    public static final byte[] A03;
    public static final float[] A04;
    public static final Object A05;

    /* JADX WARN: Code restructure failed: missing block: B:23:0x007a, code lost:
        if (r7 != 118) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
        if (r7 == 128) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
        if (r7 != 138) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00bb, code lost:
        if (r7 != 118) goto L24;
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.facebook.ads.redexgen.X.C0692Hu A06(byte[] r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 521
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0693Hv.A06(byte[], int, int):com.facebook.ads.redexgen.X.Hu");
    }

    public static String A07(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 29);
        }
        return new String(copyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{117, 90, 87, 110, 85, 82, 79, 110, 79, 82, 87, 17, 42, 33, 60, 52, 33, 39, 48, 33, 32, 100, 37, 55, 52, 33, 39, 48, 27, 54, 37, 48, 45, 43, 27, 45, 32, 39, 100, 50, 37, 40, 49, 33, 126, 100, 30, 1, 12, 13, 7, 71, 9, 30, 11, 85, 74, 71, 70, 76, 12, 75, 70, 85, 64};
    }

    static {
        A08();
        A03 = new byte[]{0, 0, 0, 1};
        A04 = new float[]{1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
        A05 = new Object();
        A01 = new int[10];
    }

    public static int A00(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    public static int A01(byte[] bArr, int i) {
        return bArr[i + 3] & 31;
    }

    public static int A02(byte[] bArr, int i) {
        int i5;
        synchronized (A05) {
            int scratchEscapeCount = 0;
            int i6 = 0;
            while (scratchEscapeCount < i) {
                scratchEscapeCount = A03(bArr, scratchEscapeCount, i);
                if (scratchEscapeCount < i) {
                    int[] iArr = A01;
                    if (iArr.length <= i6) {
                        A01 = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    A01[i6] = scratchEscapeCount;
                    scratchEscapeCount += 3;
                    i6++;
                }
            }
            i5 = i - i6;
            int unescapedPosition = 0;
            int escapedPosition = 0;
            for (int unescapedLength = 0; unescapedLength < i6; unescapedLength++) {
                int scratchEscapeCount2 = A01[unescapedLength];
                int scratchEscapeCount3 = scratchEscapeCount2 - unescapedPosition;
                System.arraycopy(bArr, unescapedPosition, bArr, escapedPosition, scratchEscapeCount3);
                int escapedPosition2 = escapedPosition + scratchEscapeCount3;
                int position = escapedPosition2 + 1;
                bArr[escapedPosition2] = 0;
                escapedPosition = position + 1;
                bArr[position] = 0;
                unescapedPosition += scratchEscapeCount3 + 3;
            }
            System.arraycopy(bArr, unescapedPosition, bArr, escapedPosition, i5 - escapedPosition);
        }
        return i5;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0002 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int A03(byte[] r2, int r3, int r4) {
        /*
        L0:
            int r0 = r4 + (-2)
            if (r3 >= r0) goto L19
            r0 = r2[r3]
            if (r0 != 0) goto L16
            int r0 = r3 + 1
            r0 = r2[r0]
            if (r0 != 0) goto L16
            int r0 = r3 + 2
            r1 = r2[r0]
            r0 = 3
            if (r1 != r0) goto L16
            return r3
        L16:
            int r3 = r3 + 1
            goto L0
        L19:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0693Hv.A03(byte[], int, int):int");
    }

    public static int A04(byte[] bArr, int i, int i5, boolean[] zArr) {
        boolean z2;
        boolean z3;
        int i6 = i5 - i;
        AbstractC0672Ha.A04(i6 >= 0);
        if (i6 == 0) {
            return i5;
        }
        if (zArr != null) {
            if (zArr[0]) {
                A0B(zArr);
                int length = i - 3;
                return length;
            }
            if (i6 > 1 && zArr[1]) {
                int length2 = bArr[i];
                if (length2 == 1) {
                    A0B(zArr);
                    int length3 = i - 2;
                    return length3;
                }
            }
            if (i6 > 2 && zArr[2]) {
                int length4 = bArr[i];
                if (length4 == 0) {
                    int length5 = i + 1;
                    if (bArr[length5] == 1) {
                        A0B(zArr);
                        int length6 = i - 1;
                        return length6;
                    }
                }
            }
        }
        int i8 = i5 - 1;
        int i10 = i + 2;
        while (true) {
            if (i10 < i8) {
                int length7 = bArr[i10];
                if ((length7 & 254) == 0) {
                    int length8 = i10 - 2;
                    if (bArr[length8] == 0) {
                        int length9 = i10 - 1;
                        if (bArr[length9] == 0) {
                            int length10 = bArr[i10];
                            if (length10 == 1) {
                                if (zArr != null) {
                                    A0B(zArr);
                                }
                                int i11 = i10 - 2;
                                if (A02[2].length() != 30) {
                                    String[] strArr = A02;
                                    strArr[5] = "cwZIqZ1AW63JkQ3pIqo9DKAUVDIU8B2n";
                                    strArr[0] = "C4ULzJ2O8tT1dK0koFoE4t7X4OAunQC5";
                                    return i11;
                                }
                            }
                        }
                    }
                    i10 -= 2;
                }
                i10 += 3;
            } else {
                if (zArr != null) {
                    if (i6 > 2) {
                        int length11 = i5 - 3;
                        if (bArr[length11] == 0) {
                            int length12 = i5 - 2;
                            byte b2 = bArr[length12];
                            String[] strArr2 = A02;
                            String str = strArr2[6];
                            String str2 = strArr2[1];
                            int charAt = str.charAt(16);
                            int length13 = str2.charAt(16);
                            if (charAt == length13) {
                                String[] strArr3 = A02;
                                strArr3[5] = "3nijOMlfzKgjywxgx1aIEuQEOVvcrnGF";
                                strArr3[0] = "mhxYTAHU7iRAJ8bI14cg8xnokscJO5gc";
                                if (b2 == 0) {
                                    int length14 = i5 - 1;
                                    byte b3 = bArr[length14];
                                    String[] strArr4 = A02;
                                    String str3 = strArr4[5];
                                    String str4 = strArr4[0];
                                    int charAt2 = str3.charAt(21);
                                    int length15 = str4.charAt(21);
                                    if (charAt2 == length15) {
                                        throw new RuntimeException();
                                    }
                                    String[] strArr5 = A02;
                                    strArr5[3] = "9ZCFGjZIw1dXFFVp2oTHQfikOa97hWgs";
                                    strArr5[7] = "4W5bkIHCCYZDsaIH6FljQxOPKIhpSySs";
                                    if (b3 == 1) {
                                        z2 = true;
                                    }
                                }
                            }
                        }
                        z2 = false;
                    } else if (i6 == 2) {
                        if (zArr[2]) {
                            int length16 = i5 - 2;
                            if (bArr[length16] == 0) {
                                int length17 = i5 - 1;
                                if (bArr[length17] == 1) {
                                    z2 = true;
                                }
                            }
                        }
                        z2 = false;
                    } else {
                        if (zArr[1]) {
                            int length18 = i5 - 1;
                            if (bArr[length18] == 1) {
                                z2 = true;
                            }
                        }
                        z2 = false;
                    }
                    zArr[0] = z2;
                    if (i6 > 1) {
                        int length19 = i5 - 2;
                        if (bArr[length19] == 0) {
                            int length20 = i5 - 1;
                            if (bArr[length20] == 0) {
                                z3 = true;
                            }
                        }
                        z3 = false;
                    } else {
                        if (zArr[2]) {
                            int length21 = i5 - 1;
                            if (bArr[length21] == 0) {
                                z3 = true;
                            }
                        }
                        z3 = false;
                    }
                    zArr[1] = z3;
                    int length22 = i5 - 1;
                    zArr[2] = bArr[length22] == 0;
                }
                return i5;
            }
        }
        throw new RuntimeException();
    }

    public static C0691Ht A05(byte[] bArr, int i, int i5) {
        I0 i0 = new I0(bArr, i, i5);
        i0.A07(8);
        int A042 = i0.A04();
        int seqParameterSetId = i0.A04();
        i0.A06();
        return new C0691Ht(A042, seqParameterSetId, i0.A0A());
    }

    public static void A09(I0 i0, int i) {
        int i5 = 8;
        int deltaScale = 8;
        for (int i6 = 0; i6 < i; i6++) {
            if (deltaScale != 0) {
                int lastScale = i0.A03();
                deltaScale = ((lastScale + i5) + 256) % 256;
            }
            if (deltaScale != 0) {
                i5 = deltaScale;
            }
            String[] strArr = A02;
            String str = strArr[6];
            String str2 = strArr[1];
            int nextScale = str.charAt(16);
            int lastScale2 = str2.charAt(16);
            if (nextScale != lastScale2) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "KXMRoqtdhshm8G74asFo5uqDFob0Iegs";
            strArr2[7] = "VTZDrARlCd8p2vM8k7YrNOP12vylJmks";
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0008 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void A0A(java.nio.ByteBuffer r8) {
        /*
            int r4 = r8.position()
            r6 = 0
            r5 = 0
        L6:
            int r0 = r5 + 1
            if (r0 >= r4) goto L81
            byte r0 = r8.get(r5)
            r3 = r0 & 255(0xff, float:3.57E-43)
            r0 = 3
            if (r6 != r0) goto L6a
            r7 = 1
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.AbstractC0693Hv.A02
            r0 = 4
            r1 = r1[r0]
            r0 = 6
            char r1 = r1.charAt(r0)
            r0 = 115(0x73, float:1.61E-43)
            if (r1 == r0) goto L28
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L28:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AbstractC0693Hv.A02
            java.lang.String r1 = "cLm552F16buuPP9xMufxVHaN"
            r0 = 2
            r2[r0] = r1
            if (r3 != r7) goto L6e
            int r0 = r5 + 1
            byte r0 = r8.get(r0)
            r1 = r0 & 31
            r0 = 7
            if (r1 != r0) goto L6e
            java.nio.ByteBuffer r1 = r8.duplicate()
            int r0 = r5 + (-3)
            r1.position(r0)
            r1.limit(r4)
            r0 = 0
            r8.position(r0)
            r8.put(r1)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.AbstractC0693Hv.A02
            r0 = 4
            r1 = r1[r0]
            r0 = 6
            char r1 = r1.charAt(r0)
            r0 = 115(0x73, float:1.61E-43)
            if (r1 == r0) goto L74
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AbstractC0693Hv.A02
            java.lang.String r1 = "6nmXEFQWU8IXvuDOHtOk9CPNFswxHRRs"
            r0 = 3
            r2[r0] = r1
            java.lang.String r1 = "sRzFReGlCKeKmBP91kaLZyOllIcQLpOs"
            r0 = 7
            r2[r0] = r1
            return
        L6a:
            if (r3 != 0) goto L6e
            int r6 = r6 + 1
        L6e:
            if (r3 == 0) goto L71
            r6 = 0
        L71:
            int r5 = r5 + 1
            goto L6
        L74:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AbstractC0693Hv.A02
            java.lang.String r1 = "MM5ABksrrLy98KCtfJajpuklss5i1OmF"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "sCLzk23Fd4ag3qXWex39LdUh6FJSiknG"
            r0 = 0
            r2[r0] = r1
            return
        L81:
            r8.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0693Hv.A0A(java.nio.ByteBuffer):void");
    }

    public static void A0B(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static boolean A0C(String str, byte b2) {
        if (A07(46, 9, 117).equals(str) && (b2 & 31) == 6) {
            return true;
        }
        return A07(55, 10, 62).equals(str) && ((b2 & 126) >> 1) == 39;
    }
}

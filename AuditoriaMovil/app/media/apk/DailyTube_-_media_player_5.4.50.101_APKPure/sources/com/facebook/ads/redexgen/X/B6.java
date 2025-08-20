package com.facebook.ads.redexgen.X;

import java.nio.ShortBuffer;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class B6 {
    public static String[] A0M = {"OjKCpSHRaQgRVuqtUlgsb9O8", "00OaDgM7p4igg1vHbesCR74DVTlAeC7z", "TzmlGabo8AOjcKFjChfq2OdnE6jP", "eUJX5SGKEEZf9vIFl", "j2zFnhkJHUredpBjDjfUiogYLN6sD6KJ", "gWZYAfYL2BaqEY2VQTncveV2", "fwiYKc5SQMrWihGSp5I7vQU09P9mYkrS", "9p8sUcgEmhCbeCaZ4cFvJcsv2VoCKNVu"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public short[] A0A;
    public short[] A0B;
    public short[] A0C;
    public final float A0D;
    public final float A0E;
    public final float A0F;
    public final int A0G;
    public final int A0H;
    public final int A0I;
    public final int A0J;
    public final int A0K;
    public final short[] A0L;

    public B6(int i, int i5, float f4, float f6, int i6) {
        this.A0H = i;
        this.A0G = i5;
        this.A0F = f4;
        this.A0D = f6;
        this.A0E = i / i6;
        this.A0K = i / 400;
        int i8 = i / 65;
        this.A0I = i8;
        int i10 = i8 * 2;
        this.A0J = i10;
        this.A0L = new short[i10];
        this.A0A = new short[i10 * i5];
        this.A0B = new short[i10 * i5];
        this.A0C = new short[i10 * i5];
    }

    private int A00(int i) {
        int min = Math.min(this.A0J, this.A09);
        A0D(this.A0A, i, min);
        int frameCount = this.A09;
        this.A09 = frameCount - min;
        return min;
    }

    private int A01(short[] sArr, int i) {
        int minP;
        int period;
        int i5 = this.A0H;
        int i6 = i5 > 4000 ? i5 / 4000 : 1;
        int skip = this.A0G;
        if (skip == 1 && i6 == 1) {
            int i8 = this.A0K;
            int skip2 = this.A0I;
            minP = A04(sArr, i, i8, skip2);
        } else {
            A0E(sArr, i, i6);
            int skip3 = this.A0I;
            minP = A04(this.A0L, 0, this.A0K / i6, skip3 / i6);
            if (i6 != 1) {
                int minP2 = minP * i6;
                int skip4 = i6 * 4;
                int period2 = minP2 - skip4;
                int i10 = (i6 * 4) + minP2;
                int skip5 = this.A0K;
                if (period2 < skip5) {
                    period2 = this.A0K;
                }
                int skip6 = this.A0I;
                if (i10 > skip6) {
                    i10 = this.A0I;
                }
                int skip7 = this.A0G;
                if (skip7 == 1) {
                    minP = A04(sArr, i, period2, i10);
                } else {
                    A0E(sArr, i, 1);
                    minP = A04(this.A0L, 0, period2, i10);
                }
            }
        }
        int i11 = this.A02;
        int maxP = this.A01;
        String[] strArr = A0M;
        String str = strArr[5];
        String str2 = strArr[0];
        int period3 = str.length();
        int skip8 = str2.length();
        if (period3 != skip8) {
            throw new RuntimeException();
        }
        A0M[1] = "8bhQeTnLevaZP1Rdp3IHUAHszuXZY5fw";
        if (A0F(i11, maxP)) {
            period = this.A08;
        } else {
            period = minP;
        }
        int skip9 = this.A02;
        this.A07 = skip9;
        this.A08 = minP;
        return period;
    }

    private int A02(short[] sArr, int i, float f4, int i5) {
        int i6;
        if (f4 < 0.5f) {
            i6 = (int) ((i5 * f4) / (1.0f - f4));
        } else {
            i6 = i5;
            int newFrameCount = (int) ((i5 * ((2.0f * f4) - 1.0f)) / (1.0f - f4));
            this.A09 = newFrameCount;
        }
        int newFrameCount2 = i5 + i6;
        short[] A0G = A0G(this.A0B, this.A05, newFrameCount2);
        this.A0B = A0G;
        int i8 = this.A0G;
        int newFrameCount3 = this.A05;
        System.arraycopy(sArr, i * i8, A0G, newFrameCount3 * i8, i8 * i5);
        A0C(i6, this.A0G, this.A0B, this.A05 + i5, sArr, i + i5, sArr, i);
        int newFrameCount4 = this.A05;
        this.A05 = newFrameCount4 + i5 + i6;
        return i6;
    }

    private int A03(short[] sArr, int i, float f4, int i5) {
        int newFrameCount;
        if (f4 >= 2.0f) {
            newFrameCount = (int) (i5 / (f4 - 1.0f));
        } else {
            this.A09 = (int) ((i5 * (2.0f - f4)) / (f4 - 1.0f));
            newFrameCount = i5;
        }
        short[] sArr2 = this.A0B;
        int newFrameCount2 = this.A05;
        short[] A0G = A0G(sArr2, newFrameCount2, newFrameCount);
        this.A0B = A0G;
        A0C(newFrameCount, this.A0G, A0G, this.A05, sArr, i, sArr, i + i5);
        int newFrameCount3 = this.A05;
        this.A05 = newFrameCount3 + newFrameCount;
        return newFrameCount;
    }

    private int A04(short[] sArr, int i, int i5, int i6) {
        int i8 = 0;
        int i10 = 255;
        int period = 1;
        int maxDiff = 0;
        int bestPeriod = this.A0G;
        int i11 = i * bestPeriod;
        while (i5 <= i6) {
            int diff = 0;
            for (int minDiff = 0; minDiff < i5; minDiff++) {
                int bestPeriod2 = i11 + minDiff;
                short s2 = sArr[bestPeriod2];
                int bestPeriod3 = i11 + i5;
                int worstPeriod = s2 - sArr[bestPeriod3 + minDiff];
                int bestPeriod4 = Math.abs(worstPeriod);
                diff += bestPeriod4;
            }
            int worstPeriod2 = diff * i8;
            int bestPeriod5 = period * i5;
            if (worstPeriod2 < bestPeriod5) {
                period = diff;
                i8 = i5;
            }
            int worstPeriod3 = diff * i10;
            int bestPeriod6 = maxDiff * i5;
            if (worstPeriod3 > bestPeriod6) {
                maxDiff = diff;
                i10 = i5;
            }
            i5++;
        }
        this.A02 = period / i8;
        this.A01 = maxDiff / i10;
        return i8;
    }

    private short A05(short[] sArr, int i, int i5, int i6) {
        short s2 = sArr[i];
        short s3 = sArr[this.A0G + i];
        int rightPosition = this.A03 * i5;
        int i8 = this.A04;
        int i10 = i8 * i6;
        int position = (i8 + 1) * i6;
        int i11 = position - rightPosition;
        int position2 = position - i10;
        short left = (short) (((i11 * s2) + ((position2 - i11) * s3)) / position2);
        return left;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A06() {
        /*
            r8 = this;
            int r6 = r8.A05
            float r7 = r8.A0F
            float r0 = r8.A0D
            float r7 = r7 / r0
            float r5 = r8.A0E
            float r5 = r5 * r0
            double r3 = (double) r7
            r1 = 4607182463836013682(0x3ff0000a7c5ac472, double:1.00001)
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 > 0) goto L1e
            double r3 = (double) r7
            r1 = 4607182328728024861(0x3fefffeb074a771d, double:0.99999)
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto L2b
        L1e:
            r8.A07(r7)
        L21:
            r0 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 == 0) goto L2a
            r8.A08(r5, r6)
        L2a:
            return
        L2b:
            short[] r2 = r8.A0A
            int r1 = r8.A00
            r0 = 0
            r8.A0D(r2, r0, r1)
            r8.A00 = r0
            goto L21
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.B6.A06():void");
    }

    private void A07(float f4) {
        int frameCount;
        if (this.A00 < this.A0J) {
            return;
        }
        int i = this.A00;
        int i5 = 0;
        do {
            int frameCount2 = this.A09;
            if (frameCount2 > 0) {
                int frameCount3 = A00(i5);
                i5 += frameCount3;
            } else {
                int A01 = A01(this.A0A, i5);
                int frameCount4 = (f4 > 1.0d ? 1 : (f4 == 1.0d ? 0 : -1));
                if (frameCount4 > 0) {
                    int frameCount5 = A03(this.A0A, i5, f4, A01);
                    i5 += frameCount5 + A01;
                } else {
                    int frameCount6 = A02(this.A0A, i5, f4, A01);
                    i5 += frameCount6;
                }
            }
            frameCount = this.A0J;
        } while (frameCount + i5 <= i);
        A0B(i5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x009b, code lost:
        r0 = r8 + 1;
        r9.A04 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
        if (r0 != r5) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a1, code lost:
        r2 = com.facebook.ads.redexgen.X.B6.A0M;
        r1 = r2[5];
        r0 = r2[0];
        r1 = r1.length();
        r0 = r0.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b2, code lost:
        if (r1 == r0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b9, code lost:
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ba, code lost:
        com.facebook.ads.redexgen.X.B6.A0M[6] = "dm69MZtNxJx8v5BsJDIKlnc92CG6PQ3Q";
        r9.A04 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c3, code lost:
        if (r3 != r6) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c5, code lost:
        com.facebook.ads.redexgen.X.AbstractC0672Ha.A04(r4);
        r9.A03 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ce, code lost:
        r4 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A08(float r10, int r11) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.B6.A08(float, int):void");
    }

    private void A09(int i) {
        int i5 = this.A05 - i;
        short[] sArr = this.A0C;
        int frameCount = this.A06;
        short[] A0G = A0G(sArr, frameCount, i5);
        this.A0C = A0G;
        short[] sArr2 = this.A0B;
        int i6 = this.A0G;
        int frameCount2 = this.A06;
        System.arraycopy(sArr2, i * i6, A0G, frameCount2 * i6, i6 * i5);
        this.A05 = i;
        int frameCount3 = this.A06;
        this.A06 = frameCount3 + i5;
    }

    private void A0A(int i) {
        if (i == 0) {
            return;
        }
        short[] sArr = this.A0C;
        int i5 = this.A0G;
        System.arraycopy(sArr, i * i5, sArr, 0, (this.A06 - i) * i5);
        this.A06 -= i;
    }

    private void A0B(int i) {
        int i5 = this.A00 - i;
        short[] sArr = this.A0A;
        int i6 = this.A0G;
        System.arraycopy(sArr, i * i6, sArr, 0, i6 * i5);
        this.A00 = i5;
    }

    public static void A0C(int i, int i5, short[] sArr, int i6, short[] sArr2, int i8, short[] sArr3, int i10) {
        for (int i11 = 0; i11 < i5; i11++) {
            int i12 = (i6 * i5) + i11;
            int t2 = (i10 * i5) + i11;
            int d2 = (i8 * i5) + i11;
            for (int u2 = 0; u2 < i; u2++) {
                int i13 = i - u2;
                int o2 = sArr2[d2] * i13;
                int i14 = sArr3[t2] * u2;
                sArr[i12] = (short) ((o2 + i14) / i);
                i12 += i5;
                d2 += i5;
                t2 += i5;
            }
        }
    }

    private void A0D(short[] sArr, int i, int i5) {
        short[] A0G = A0G(this.A0B, this.A05, i5);
        this.A0B = A0G;
        int i6 = this.A0G;
        System.arraycopy(sArr, i * i6, A0G, this.A05 * i6, i6 * i5);
        this.A05 += i5;
    }

    private void A0E(short[] sArr, int i, int i5) {
        int i6 = this.A0J / i5;
        int frameCount = this.A0G;
        int j2 = frameCount * i5;
        int i8 = i * frameCount;
        for (int value = 0; value < i6; value++) {
            int samplesPerValue = 0;
            for (int i10 = 0; i10 < j2; i10++) {
                samplesPerValue += sArr[(value * j2) + i8 + i10];
            }
            this.A0L[value] = (short) (samplesPerValue / j2);
        }
    }

    private boolean A0F(int i, int i5) {
        if (i == 0 || this.A08 == 0 || i5 > i * 3 || i * 2 <= this.A07 * 3) {
            return false;
        }
        return true;
    }

    private short[] A0G(short[] sArr, int i, int i5) {
        int length = sArr.length;
        int i6 = this.A0G;
        int currentCapacityFrames = length / i6;
        if (i + i5 <= currentCapacityFrames) {
            return sArr;
        }
        return Arrays.copyOf(sArr, i6 * (((currentCapacityFrames * 3) / 2) + i5));
    }

    public final int A0H() {
        return this.A05;
    }

    public final void A0I() {
        this.A00 = 0;
        this.A05 = 0;
        this.A06 = 0;
        this.A04 = 0;
        this.A03 = 0;
        this.A09 = 0;
        this.A08 = 0;
        this.A07 = 0;
        this.A02 = 0;
        this.A01 = 0;
    }

    public final void A0J() {
        int i;
        int i5 = this.A00;
        float f4 = this.A0F;
        float f6 = this.A0D;
        float r2 = f4 / f6;
        float f9 = this.A0E * f6;
        int i6 = this.A05;
        float s2 = i5;
        int remainingFrameCount = this.A06;
        int i8 = i6 + ((int) ((((s2 / r2) + remainingFrameCount) / f9) + 0.5f));
        short[] sArr = this.A0A;
        int i10 = this.A00;
        int remainingFrameCount2 = this.A0J;
        this.A0A = A0G(sArr, i10, (remainingFrameCount2 * 2) + i5);
        int xSample = 0;
        while (true) {
            i = this.A0J;
            int remainingFrameCount3 = i * 2;
            int i11 = this.A0G;
            if (xSample >= remainingFrameCount3 * i11) {
                break;
            }
            this.A0A[(i11 * i5) + xSample] = 0;
            xSample++;
        }
        int remainingFrameCount4 = i * 2;
        this.A00 += remainingFrameCount4;
        A06();
        int remainingFrameCount5 = this.A05;
        if (remainingFrameCount5 > i8) {
            this.A05 = i8;
        }
        this.A00 = 0;
        this.A09 = 0;
        this.A06 = 0;
    }

    public final void A0K(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.A0G, this.A05);
        shortBuffer.put(this.A0B, 0, this.A0G * min);
        int i = this.A05 - min;
        this.A05 = i;
        short[] sArr = this.A0B;
        int framesToRead = this.A0G;
        System.arraycopy(sArr, min * framesToRead, sArr, 0, i * framesToRead);
    }

    public final void A0L(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int framesToWrite = this.A0G;
        int i = remaining / framesToWrite;
        short[] A0G = A0G(this.A0A, this.A00, i);
        this.A0A = A0G;
        int bytesToWrite = this.A00;
        shortBuffer.get(A0G, bytesToWrite * this.A0G, ((framesToWrite * i) * 2) / 2);
        this.A00 += i;
        A06();
    }
}

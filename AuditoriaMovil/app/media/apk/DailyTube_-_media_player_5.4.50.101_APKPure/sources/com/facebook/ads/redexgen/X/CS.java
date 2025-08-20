package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public abstract class CS {
    public static CR A00(int i, long[] jArr, int[] iArr, long j2) {
        int chunkSamplesRemaining = 8192 / i;
        int i5 = 0;
        for (int i6 : iArr) {
            i5 += IF.A04(i6, chunkSamplesRemaining);
        }
        long[] jArr2 = new long[i5];
        int[] iArr2 = new int[i5];
        int originalSampleIndex = 0;
        long[] timestamps = new long[i5];
        int[] flags = new int[i5];
        int i8 = 0;
        int bufferSampleCount = 0;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            int rechunkedSampleCount = iArr[i10];
            long j4 = jArr[i10];
            while (rechunkedSampleCount > 0) {
                int min = Math.min(chunkSamplesRemaining, rechunkedSampleCount);
                jArr2[bufferSampleCount] = j4;
                iArr2[bufferSampleCount] = i * min;
                originalSampleIndex = Math.max(originalSampleIndex, iArr2[bufferSampleCount]);
                timestamps[bufferSampleCount] = i8 * j2;
                flags[bufferSampleCount] = 1;
                j4 += iArr2[bufferSampleCount];
                i8 += min;
                rechunkedSampleCount -= min;
                bufferSampleCount++;
            }
        }
        return new CR(jArr2, iArr2, originalSampleIndex, timestamps, flags, j2 * i8);
    }
}

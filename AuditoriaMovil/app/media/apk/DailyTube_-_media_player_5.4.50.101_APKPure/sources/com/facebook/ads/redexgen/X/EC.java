package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.uv.v7.R;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class EC implements XV {
    public static byte[] A03;
    public final long A00;
    public final long[] A01;
    public final long[] A02;

    static {
        A02();
    }

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 1);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{71, 75, 29, 9, 25, 2, 107, 47, 42, 63, 42, 107, 56, 34, 49, 46, 107, 38, 34, 56, 38, 42, 63, 40, 35, 113, 107, 0, 52, 36, 63, 5, 51, 51, 61, 51, 36};
    }

    public EC(long[] jArr, long[] jArr2, long j2) {
        this.A02 = jArr;
        this.A01 = jArr2;
        this.A00 = j2;
    }

    public static EC A00(long j2, long j4, By by, C0697Hz c0697Hz) {
        int A0E;
        long j6 = j4;
        c0697Hz.A0Z(10);
        int numFrames = c0697Hz.A08();
        if (numFrames <= 0) {
            return null;
        }
        int sampleRate = by.A03;
        long A0F = IF.A0F(numFrames, (sampleRate >= 32000 ? 1152 : 576) * 1000000, sampleRate);
        int A0I = c0697Hz.A0I();
        int numFrames2 = c0697Hz.A0I();
        int A0I2 = c0697Hz.A0I();
        c0697Hz.A0Z(2);
        long j7 = j6 + by.A02;
        long[] jArr = new long[A0I];
        long[] jArr2 = new long[A0I];
        for (int scale = 0; scale < A0I; scale++) {
            jArr[scale] = (scale * A0F) / A0I;
            jArr2[scale] = Math.max(j6, j7);
            switch (A0I2) {
                case 1:
                    A0E = c0697Hz.A0E();
                    break;
                case 2:
                    A0E = c0697Hz.A0I();
                    break;
                case 3:
                    A0E = c0697Hz.A0G();
                    break;
                case 4:
                    A0E = c0697Hz.A0H();
                    break;
                default:
                    return null;
            }
            j6 += A0E * numFrames2;
        }
        if (j2 != -1 && j2 != j6) {
            Log.w(A01(27, 10, 87), A01(2, 25, 74) + j2 + A01(0, 2, R.styleable.AppCompatTheme_textAppearancePopupMenuHeader) + j6);
        }
        return new EC(jArr, jArr2, A0F);
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final long A6r() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final C0 A7t(long j2) {
        int A0B = IF.A0B(this.A02, j2, true, true);
        C2 c2 = new C2(this.A02[A0B], this.A01[A0B]);
        int tableIndex = (c2.A01 > j2 ? 1 : (c2.A01 == j2 ? 0 : -1));
        if (tableIndex < 0) {
            int tableIndex2 = this.A02.length;
            if (A0B != tableIndex2 - 1) {
                int tableIndex3 = A0B + 1;
                long j4 = this.A02[tableIndex3];
                int tableIndex4 = A0B + 1;
                C2 nextSeekPoint = new C2(j4, this.A01[tableIndex4]);
                return new C0(c2, nextSeekPoint);
            }
        }
        return new C0(c2);
    }

    @Override // com.facebook.ads.redexgen.X.XV
    public final long A88(long j2) {
        return this.A02[IF.A0B(this.A01, j2, true, true)];
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final boolean A9I() {
        return true;
    }
}

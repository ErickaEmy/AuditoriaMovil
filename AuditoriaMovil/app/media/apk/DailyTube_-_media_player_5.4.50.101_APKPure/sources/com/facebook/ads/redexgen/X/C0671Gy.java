package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Gy  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0671Gy {
    public static byte[] A07;
    public final int A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final Uri A04;
    public final String A05;
    public final byte[] A06;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 21);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{-125, 119, 105, -122, -103, -122, 120, -107, -118, -120, Byte.MIN_VALUE, -50};
    }

    public C0671Gy(Uri uri, long j2, long j4, long j6, String str, int i) {
        this(uri, null, j2, j4, j6, str, i);
    }

    public C0671Gy(Uri uri, long j2, long j4, String str) {
        this(uri, j2, j2, j4, str, 0);
    }

    public C0671Gy(Uri uri, long j2, long j4, String str, int i) {
        this(uri, j2, j2, j4, str, i);
    }

    public C0671Gy(Uri uri, byte[] bArr, long j2, long j4, long j6, String str, int i) {
        boolean z2 = true;
        AbstractC0672Ha.A03(j2 >= 0);
        AbstractC0672Ha.A03(j4 >= 0);
        if (j6 <= 0 && j6 != -1) {
            z2 = false;
        }
        AbstractC0672Ha.A03(z2);
        this.A04 = uri;
        this.A06 = bArr;
        this.A01 = j2;
        this.A03 = j4;
        this.A02 = j6;
        this.A05 = str;
        this.A00 = i;
    }

    public final boolean A02(int i) {
        return (this.A00 & i) == i;
    }

    public final String toString() {
        StringBuilder append = new StringBuilder().append(A00(2, 9, 16)).append(this.A04);
        String A00 = A00(0, 2, 66);
        return append.append(A00).append(Arrays.toString(this.A06)).append(A00).append(this.A01).append(A00).append(this.A03).append(A00).append(this.A02).append(A00).append(this.A05).append(A00).append(this.A00).append(A00(11, 1, 92)).toString();
    }
}

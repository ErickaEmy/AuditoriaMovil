package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.IOException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Vx  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1051Vx implements InterfaceC0667Gu {
    public static byte[] A00;
    public static final InterfaceC0666Gt A01;
    public static final C1051Vx A02;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 107);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{51, 2, 26, 26, 14, 87, 4, 24, 2, 5, 20, 18};
    }

    static {
        A01();
        A02 = new C1051Vx();
        A01 = new C1052Vy();
    }

    public C1051Vx() {
    }

    public /* synthetic */ C1051Vx(C1052Vy c1052Vy) {
        this();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final Uri A8E() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final long ADl(C0671Gy c0671Gy) throws IOException {
        throw new IOException(A00(0, 12, 28));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final void close() throws IOException {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final int read(byte[] bArr, int i, int i5) throws IOException {
        throw new UnsupportedOperationException();
    }
}

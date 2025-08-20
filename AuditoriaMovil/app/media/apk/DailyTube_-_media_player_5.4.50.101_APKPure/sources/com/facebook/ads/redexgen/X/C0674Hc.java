package com.facebook.ads.redexgen.X;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Hc  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0674Hc {
    public static byte[] A02;
    public final File A00;
    public final File A01;

    static {
        A02();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 96);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-63, 21, 16, -63, 3, 2, 4, 12, 22, 17, -63, 7, 10, 13, 6, -63, -72, -20, -21, -11, -31, 20, 15, 13, 9, 3, -26, 9, 12, 5, -20, 24, 30, 21, 13, 23, -48, 29, -55, 12, 27, 14, 10, 29, 14, -55, -79, -35, -29, -38, -46, -36, -107, -30, -114, -47, -32, -45, -49, -30, -45, -114, -46, -41, -32, -45, -47, -30, -35, -32, -25, -114, -1, 43, 49, 40, 32, 42, -29, 48, -36, 46, 33, 42, 29, 41, 33, -36, 34, 37, 40, 33, -36};
    }

    public C0674Hc(File file) {
        this.A01 = file;
        this.A00 = new File(file.getPath() + A00(16, 4, 42));
    }

    private void A01() {
        if (this.A00.exists()) {
            this.A01.delete();
            this.A00.renameTo(this.A01);
        }
    }

    public final C0673Hb A03() throws IOException {
        if (this.A01.exists()) {
            if (!this.A00.exists()) {
                if (!this.A01.renameTo(this.A00)) {
                    Log.w(A00(20, 10, 64), A00(72, 21, 92) + this.A01 + A00(0, 16, 65) + this.A00);
                }
            } else {
                this.A01.delete();
            }
        }
        try {
            return new C0673Hb(this.A01);
        } catch (FileNotFoundException e2) {
            if (this.A01.getParentFile().mkdirs()) {
                try {
                    File parent = this.A01;
                    return new C0673Hb(parent);
                } catch (FileNotFoundException e3) {
                    throw new IOException(A00(30, 16, 73) + this.A01, e3);
                }
            }
            throw new IOException(A00(46, 26, 14) + this.A01, e2);
        }
    }

    public final InputStream A04() throws FileNotFoundException {
        A01();
        return new FileInputStream(this.A01);
    }

    public final void A05() {
        this.A01.delete();
        this.A00.delete();
    }

    public final void A06(OutputStream outputStream) throws IOException {
        outputStream.close();
        this.A00.delete();
    }
}

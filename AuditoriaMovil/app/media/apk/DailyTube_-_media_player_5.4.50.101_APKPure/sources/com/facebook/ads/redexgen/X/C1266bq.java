package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.bq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1266bq implements AnonymousClass03<Bitmap> {
    public static byte[] A06;
    public static String[] A07 = {"O8BWLXPdzHA", "6sEzkrKiC7tSlAyzako7Jr1QeLTjq7r7", "buIAODYM5Oo034kKCIV4I7ZzRqvLqiIh", "ENOGp8Grp5cb6hByXNSQMpF2JyONyocp", "tnh", "2Zn0DxkDz4CuR43sN", "3j1ga9q4MlHQ2cRzMN", "NuleDR7CXAFlpWhCDunnHJWIhrQ2pSEs"};
    public final int A00;
    public final int A01;
    public final String A02 = C1266bq.class.getSimpleName();
    public final boolean A03;
    public final boolean A04;
    public final boolean A05;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            byte b2 = (byte) ((copyOfRange[i8] ^ i6) ^ 8);
            if (A07[7].charAt(0) == 'p') {
                throw new RuntimeException();
            }
            A07[6] = "rTtdlTA5qc3UePbll3p";
            copyOfRange[i8] = b2;
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        if (A07[4].length() != 3) {
            throw new RuntimeException();
        }
        A07[6] = "j2OKbozXXbIBudrsn6AX9zPsXXh";
        A06 = new byte[]{1, 91, 66, 95, 7, 44, 49, 40, 36, 53, 101, 44, 54, 101, 43, 48, 41, 41, 124, 65, 90, 92, 73, 77, 80, 86, 87, 25, 93, 76, 75, 80, 87, 94, 25, 95, 80, 85, 92, 25, 90, 86, 84, 73, 75, 92, 74, 74, 80, 86, 87};
    }

    static {
        A02();
    }

    public C1266bq(int i, int i5, boolean z2, boolean z3, boolean z4) {
        this.A01 = i;
        this.A00 = i5;
        this.A05 = z2;
        this.A03 = z3;
        this.A04 = z4;
    }

    public static AnonymousClass02<Bitmap> A00(Throwable th) {
        return new AnonymousClass02<>(false, null, th);
    }

    private void A03(File file, Bitmap bitmap) throws IOException {
        if (bitmap == null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            ByteArrayOutputStream compressedBitmapOS = new ByteArrayOutputStream();
            byteArrayOutputStream = compressedBitmapOS;
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            if (byteArrayOutputStream.size() >= 3145728) {
                return;
            }
            String str = file.getCanonicalPath() + A01(0, 4, 39);
            File file2 = new File(str);
            file2.createNewFile();
            fileOutputStream = new FileOutputStream(str);
            byteArrayOutputStream.writeTo(fileOutputStream);
            fileOutputStream.flush();
            fileInputStream = new FileInputStream(str);
            fileOutputStream2 = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream2.write(bArr, 0, read);
                } else {
                    file2.delete();
                    return;
                }
            }
        } finally {
            C0M.A07(byteArrayOutputStream);
            C0M.A07(fileOutputStream);
            C0M.A07(fileInputStream);
            C0M.A07(fileOutputStream2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass03
    public final AnonymousClass02<Bitmap> A3M(File file, C0L c0l) {
        if (!this.A04) {
            return new AnonymousClass02<>(true, null);
        }
        try {
            Bitmap A03 = C0M.A03(file.getCanonicalPath(), this.A01, this.A00, this.A05);
            if (A03 != null) {
                return new AnonymousClass02<>(true, A03);
            }
            c0l.A9U(new C1260bk(A01(4, 14, 77)));
            return A00(null);
        } catch (Throwable t2) {
            file.delete();
            c0l.A9U(t2);
            return A00(t2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass03
    public final void A4U(File file, C0L c0l) throws C1260bk {
        if (this.A03) {
            try {
                Bitmap bitmap = C0M.A03(file.getCanonicalPath(), this.A01, this.A00, this.A05);
                if (bitmap != null) {
                    A03(file, bitmap);
                } else {
                    file.delete();
                    throw new C1260bk(A01(4, 14, 77));
                }
            } catch (C1260bk e2) {
                c0l.A9f(e2);
                throw e2;
            } catch (Throwable th) {
                c0l.A9f(th);
                Throwable t2 = new C1260bk(A01(18, 33, 49), th);
                throw t2;
            }
        }
    }
}

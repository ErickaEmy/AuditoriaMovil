package com.facebook.ads.redexgen.X;

import com.uv.v7.R;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Locale;
/* renamed from: com.facebook.ads.redexgen.X.9A  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C9A {
    public static int A03;
    public static byte[] A04;
    public AnonymousClass99 A00;
    public boolean A01;
    public final File A02;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 93);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{27, 54, 62, 65, 58, 57, -11, 73, 68, -11, 57, 58, 65, 58, 73, 58, -11, 59, 62, 65, 58, -11, -4, -6, 72, -63, -28, -25, -32, -101, -94, -96, -18, -94, -101, -28, -18, -101, -23, -22, -17, -101, -36, -101, -19, -32, -36, -33, -36, -35, -25, -32, -101, -31, -28, -25, -32, 24, 61, 69, 48, 59, 56, 51, -17, 53, 52, 67, 50, 55, -17, 66, 67, 48, 65, 67, -17, 56, 61, 51, 52, 71, 9, -17, -12, 51, -66, -47, -49, -37, -34, -48, -116, -46, -43, -40, -47, -116, -51, -40, -34, -47, -51, -48, -27, -116, -48, -43, -33, -36, -37, -33, -47, -48};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized int A05() throws IOException {
        return A00().A00;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized AnonymousClass91 A06(int i, byte[] bArr, int i5, int[] iArr, int i6) throws IOException {
        AnonymousClass99 A00 = A00();
        int i8 = 1;
        if (i >= 0) {
            int i10 = i;
            int i11 = 0;
            long j2 = -1;
            boolean z2 = false;
            while (true) {
                if (i10 >= A00.A00) {
                    break;
                } else if ((i10 - i) + i6 >= iArr.length) {
                    z2 = true;
                    break;
                } else {
                    long j4 = A00.A03[i10];
                    long j6 = (i10 == A00.A00 - i8 ? A00.A01 : A00.A03[i10 + 1]) - j4;
                    if (j2 == -1) {
                        j2 = j4;
                    }
                    if (((int) j6) + i11 + i5 > bArr.length) {
                        z2 = true;
                        break;
                    }
                    i11 += (int) j6;
                    iArr[(i10 - i) + i6] = (int) j6;
                    i10++;
                    i8 = 1;
                }
            }
            if (i10 <= i) {
                return new AnonymousClass91(z2 ? AnonymousClass90.A03 : AnonymousClass90.A04, i, i, 0);
            }
            A00.A02.seek(j2);
            A00.A02.read(bArr, i5, i11);
            return new AnonymousClass91(AnonymousClass90.A02, i, i10, i11);
        }
        throw new IOException(String.format(Locale.US, A01(57, 29, R.styleable.AppCompatTheme_tooltipForegroundColor), Integer.valueOf(i)));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized boolean A09(byte[] bArr) throws IOException {
        AnonymousClass99 A00 = A00();
        if (A05() == A03) {
            return false;
        }
        A03(A00.A00, A00.A01);
        A04(A00.A01, bArr);
        A00.A02.getFD().sync();
        A00.A00++;
        A00.A01 += bArr.length;
        return true;
    }

    static {
        A02();
        A03 = 1000;
    }

    public C9A(File file) throws IOException {
        this.A02 = file;
        if (!file.exists()) {
            this.A00 = AnonymousClass99.A03(file);
        } else if (!file.isFile()) {
            throw new IOException(String.format(Locale.US, A01(25, 32, 30), file.getCanonicalPath()));
        }
    }

    private AnonymousClass99 A00() throws IOException {
        if (!this.A01) {
            if (this.A00 == null) {
                this.A00 = AnonymousClass99.A04(this.A02);
            }
            return this.A00;
        }
        throw new IOException(A01(86, 28, 15));
    }

    private void A03(int i, long j2) throws IOException {
        this.A00.A03[i] = j2;
        this.A00.A02.seek(AnonymousClass99.A02(i));
        this.A00.A02.writeLong(j2);
    }

    private void A04(long j2, byte[] bArr) throws IOException {
        this.A00.A02.seek(j2);
        this.A00.A02.write(bArr);
    }

    public final synchronized void A07() throws IOException {
        this.A01 = true;
        AnonymousClass99 anonymousClass99 = this.A00;
        if (anonymousClass99 == null) {
            return;
        }
        RandomAccessFile randomAccessFile = anonymousClass99.A02;
        this.A00 = null;
        randomAccessFile.close();
    }

    public final synchronized void A08() throws IOException {
        if (!this.A01) {
            A07();
            if (!this.A02.delete()) {
                throw new IOException(String.format(Locale.US, A01(0, 25, 120), this.A02.getCanonicalPath()));
            }
        } else {
            throw new IOException(A01(86, 28, 15));
        }
    }
}

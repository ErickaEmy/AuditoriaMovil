package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Vk  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1038Vk implements InterfaceC0667Gu {
    public static byte[] A0L;
    public static String[] A0M = {"BZiYu5nwNf87X3b9kN", "UgTeeMN2jxyMd9Kylf", "PJ", "CPqLt3pCFfCSwfi", "XN4Dvc1", "tWEaaCCiJhgiXtacO5se5vgeqa", "S002dfR", "J7ycXdK5d"};
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public Uri A05;
    public Uri A06;
    public InterfaceC0667Gu A07;
    public HO A08;
    public String A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public final InterfaceC0667Gu A0D;
    public final InterfaceC0667Gu A0E;
    public final InterfaceC0667Gu A0F;
    public final HK A0G;
    public final HM A0H;
    public final boolean A0I;
    public final boolean A0J;
    public final boolean A0K;

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0L, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 35);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A0L = new byte[]{-92, -93, 120, -106, -104, -99, -102, -103, 119, -82, -87, -102, -88, -121, -102, -106, -103};
    }

    static {
        A06();
    }

    public C1038Vk(HK hk, InterfaceC0667Gu interfaceC0667Gu, InterfaceC0667Gu interfaceC0667Gu2, InterfaceC0665Gs interfaceC0665Gs, int i, HM hm) {
        this.A0G = hk;
        this.A0D = interfaceC0667Gu2;
        this.A0I = (i & 1) != 0;
        this.A0K = (i & 2) != 0;
        this.A0J = (i & 4) != 0;
        this.A0F = interfaceC0667Gu;
        if (interfaceC0665Gs != null) {
            this.A0E = new C1041Vn(interfaceC0667Gu, interfaceC0665Gs);
        } else {
            this.A0E = null;
        }
        this.A0H = hm;
    }

    private int A00(C0671Gy c0671Gy) {
        if (this.A0K) {
            boolean z2 = this.A0C;
            String[] strArr = A0M;
            if (strArr[3].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0M;
            strArr2[3] = "r97zDVaaptRGknr";
            strArr2[6] = "AimjfMN";
            if (z2) {
                if (A0M[7].length() != 14) {
                    A0M[7] = "lgdHkpCnxjAeRqVRog4eGXXV3TVVS";
                    return 0;
                }
                A0M[4] = "GvTYan8nqvP";
                return 0;
            }
        }
        if (this.A0J && c0671Gy.A02 == -1) {
            return 1;
        }
        return -1;
    }

    public static Uri A01(HK hk, String str, Uri uri) {
        HU contentMetadata = hk.A6X(str);
        Uri A01 = HV.A01(contentMetadata);
        return A01 == null ? uri : A01;
    }

    private void A03() throws IOException {
        InterfaceC0667Gu interfaceC0667Gu = this.A07;
        if (interfaceC0667Gu == null) {
            return;
        }
        try {
            interfaceC0667Gu.close();
            this.A07 = null;
            this.A0A = false;
            HO ho2 = this.A08;
            if (A0M[5].length() != 26) {
                throw new RuntimeException();
            }
            String[] strArr = A0M;
            strArr[3] = "f78PdfdQFRIsoy9";
            strArr[6] = "Xl8bArW";
            if (ho2 != null) {
                this.A0G.AEZ(ho2);
                this.A08 = null;
            }
        } catch (Throwable th) {
            this.A07 = null;
            this.A0A = false;
            HO ho3 = this.A08;
            if (ho3 != null) {
                this.A0G.AEZ(ho3);
                this.A08 = null;
            }
            throw th;
        }
    }

    private void A04() {
        if (0 != 0 && this.A04 > 0) {
            this.A0G.A6F();
            throw new NullPointerException(A02(0, 17, 18));
        }
    }

    private void A05() throws IOException {
        this.A01 = 0L;
        if (A0C()) {
            this.A0G.AFx(this.A09, this.A03);
        }
    }

    private void A07(IOException iOException) {
        if (A0A() || (iOException instanceof HI)) {
            this.A0C = true;
        }
    }

    private void A08(boolean z2) throws IOException {
        HO AGV;
        long j2;
        C0671Gy c0671Gy;
        InterfaceC0667Gu nextDataSource;
        long j4;
        if (this.A0B) {
            AGV = null;
        } else if (this.A0I) {
            try {
                AGV = this.A0G.AGV(this.A09, this.A03);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            AGV = this.A0G.AGW(this.A09, this.A03);
        }
        if (AGV == null) {
            nextDataSource = this.A0F;
            c0671Gy = new C0671Gy(this.A06, this.A03, this.A01, this.A09, this.A00);
        } else if (AGV.A05) {
            Uri fromFile = Uri.fromFile(AGV.A03);
            long filePosition = this.A03 - AGV.A02;
            long length = AGV.A01 - filePosition;
            long j6 = this.A01;
            if (j6 != -1) {
                length = Math.min(length, j6);
            }
            c0671Gy = new C0671Gy(fromFile, this.A03, filePosition, length, this.A09, this.A00);
            nextDataSource = this.A0D;
        } else {
            if (AGV.A02()) {
                j2 = this.A01;
            } else {
                j2 = AGV.A01;
                long length2 = this.A01;
                if (length2 != -1) {
                    j2 = Math.min(j2, length2);
                }
            }
            c0671Gy = new C0671Gy(this.A06, this.A03, j2, this.A09, this.A00);
            if (this.A0E != null) {
                nextDataSource = this.A0E;
            } else {
                nextDataSource = this.A0F;
                this.A0G.AEZ(AGV);
                AGV = null;
            }
        }
        if (!this.A0B && nextDataSource == this.A0F) {
            j4 = this.A03 + 102400;
        } else {
            j4 = Long.MAX_VALUE;
        }
        this.A02 = j4;
        if (z2) {
            AbstractC0672Ha.A04(A09());
            if (nextDataSource == this.A0F) {
                return;
            }
            try {
                A03();
            } catch (Throwable th) {
                if (AGV.A01()) {
                    this.A0G.AEZ(AGV);
                }
                throw th;
            }
        }
        if (AGV != null && AGV.A01()) {
            this.A08 = AGV;
        }
        this.A07 = nextDataSource;
        this.A0A = c0671Gy.A02 == -1;
        long ADl = nextDataSource.ADl(c0671Gy);
        HW hw2 = new HW();
        if (this.A0A) {
            int i = (ADl > (-1L) ? 1 : (ADl == (-1L) ? 0 : -1));
            if (A0M[2].length() != 2) {
                throw new RuntimeException();
            }
            A0M[7] = "GQ8HbidAJ3";
            if (i != 0) {
                this.A01 = ADl;
                HV.A05(hw2, this.A03 + ADl);
            }
        }
        if (A0B()) {
            Uri A8E = this.A07.A8E();
            this.A05 = A8E;
            if (true ^ this.A06.equals(A8E)) {
                Uri uri = this.A05;
                if (A0M[5].length() != 26) {
                    HV.A06(hw2, uri);
                } else {
                    A0M[4] = "mDcPGOd9V6d2O";
                    HV.A06(hw2, uri);
                }
            } else {
                HV.A04(hw2);
            }
        }
        if (A0C()) {
            this.A0G.A3a(this.A09, hw2);
        }
    }

    private boolean A09() {
        return this.A07 == this.A0F;
    }

    private boolean A0A() {
        return this.A07 == this.A0D;
    }

    private boolean A0B() {
        return !A0A();
    }

    private boolean A0C() {
        return this.A07 == this.A0E;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r1 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean A0D(java.io.IOException r1) {
        /*
        L0:
            if (r1 == 0) goto L14
            boolean r0 = r1 instanceof com.facebook.ads.redexgen.X.C0668Gv
            if (r0 == 0) goto Lf
            r0 = r1
            com.facebook.ads.redexgen.X.Gv r0 = (com.facebook.ads.redexgen.X.C0668Gv) r0
            int r0 = r0.A00
            if (r0 != 0) goto Lf
            r0 = 1
            return r0
        Lf:
            java.lang.Throwable r1 = r1.getCause()
            goto L0
        L14:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1038Vk.A0D(java.io.IOException):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final Uri A8E() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final long ADl(C0671Gy c0671Gy) throws IOException {
        try {
            this.A09 = HQ.A02(c0671Gy);
            Uri uri = c0671Gy.A04;
            this.A06 = uri;
            this.A05 = A01(this.A0G, this.A09, uri);
            this.A00 = c0671Gy.A00;
            this.A03 = c0671Gy.A03;
            this.A0B = A00(c0671Gy) != -1;
            int reason = (c0671Gy.A02 > (-1L) ? 1 : (c0671Gy.A02 == (-1L) ? 0 : -1));
            if (reason != 0 || this.A0B) {
                this.A01 = c0671Gy.A02;
            } else {
                long A6W = this.A0G.A6W(this.A09);
                this.A01 = A6W;
                int reason2 = (A6W > (-1L) ? 1 : (A6W == (-1L) ? 0 : -1));
                if (reason2 != 0) {
                    long j2 = A6W - c0671Gy.A03;
                    this.A01 = j2;
                    int reason3 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                    if (reason3 <= 0) {
                        throw new C0668Gv(0);
                    }
                }
            }
            A08(false);
            return this.A01;
        } catch (IOException e2) {
            A07(e2);
            throw e2;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final void close() throws IOException {
        this.A06 = null;
        this.A05 = null;
        A04();
        try {
            A03();
        } catch (IOException e2) {
            A07(e2);
            throw e2;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0667Gu
    public final int read(byte[] bArr, int i, int i5) throws IOException {
        if (i5 == 0) {
            return 0;
        }
        if (this.A01 == 0) {
            return -1;
        }
        try {
            if (this.A03 >= this.A02) {
                A08(true);
            }
            int read = this.A07.read(bArr, i, i5);
            if (read != -1) {
                if (A0A()) {
                    this.A04 += read;
                }
                this.A03 += read;
                long j2 = this.A01;
                if (j2 != -1) {
                    this.A01 = j2 - read;
                }
            } else if (this.A0A) {
                A05();
            } else {
                long j4 = this.A01;
                if (j4 <= 0) {
                    if (j4 == -1) {
                    }
                }
                A03();
                A08(false);
                return read(bArr, i, i5);
            }
            return read;
        } catch (IOException e2) {
            if (this.A0A && A0D(e2)) {
                A05();
                return -1;
            }
            A07(e2);
            throw e2;
        }
    }
}

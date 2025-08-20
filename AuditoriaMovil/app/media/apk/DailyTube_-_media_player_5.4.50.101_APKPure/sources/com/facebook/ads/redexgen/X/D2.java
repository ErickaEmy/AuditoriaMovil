package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class D2 {
    public static String[] A0I = {"F0jWKjQTCy62z5RMZ8LXaJxAHVXVw03", "jefijzmMiLSAGWVfBYlCHQnNu7WiK65", "5NKy3uod9nHosUme2DvPYxtYVEy", "OBCuuRHFU9olC8zTnYpCIYDmocSOdWsL", "GchpYIdYbHeAJ5Ou", "h9yGOulo4c92iX", "0WO8HWLEfGPVrZyS", "YTVxkuYMC8IrkJuZM8HCcFhUbHlAsN8p"};
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public byte[] A0B;
    public final C4 A0E;
    public final I0 A0F;
    public final boolean A0G;
    public final boolean A0H;
    public final SparseArray<C0692Hu> A0D = new SparseArray<>();
    public final SparseArray<C0691Ht> A0C = new SparseArray<>();
    public D1 A06 = new D1();
    public D1 A07 = new D1();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final void A06(byte[] bArr, int i, int i5) {
        if (this.A08) {
            int i6 = i5 - i;
            byte[] bArr2 = this.A0B;
            int length = bArr2.length;
            int i8 = this.A00;
            if (length < i8 + i6) {
                int i10 = (i8 + i6) * 2;
                String[] strArr = A0I;
                if (strArr[0].length() == strArr[1].length()) {
                    String[] strArr2 = A0I;
                    strArr2[0] = "I85ez55UKF4vR6ktlfwpENhqyCssmG4";
                    strArr2[1] = "5okjmZY1XRxLGurOWaApunPnJUdAZAM";
                    this.A0B = Arrays.copyOf(bArr2, i10);
                }
                throw new RuntimeException();
            }
            System.arraycopy(bArr, i, this.A0B, this.A00, i6);
            int i11 = this.A00 + i6;
            this.A00 = i11;
            this.A0F.A08(this.A0B, 0, i11);
            if (this.A0F.A0B(8)) {
                this.A0F.A06();
                int A05 = this.A0F.A05(2);
                this.A0F.A07(5);
                if (this.A0F.A09()) {
                    this.A0F.A04();
                    if (this.A0F.A09()) {
                        int A04 = this.A0F.A04();
                        if (!this.A0H) {
                            this.A08 = false;
                            this.A07.A03(A04);
                        } else if (this.A0F.A09()) {
                            int A042 = this.A0F.A04();
                            if (this.A0C.indexOfKey(A042) < 0) {
                                this.A08 = false;
                                return;
                            }
                            C0691Ht c0691Ht = this.A0C.get(A042);
                            C0692Hu c0692Hu = this.A0D.get(c0691Ht.A01);
                            if (c0692Hu.A09) {
                                if (this.A0F.A0B(2)) {
                                    I0 i0 = this.A0F;
                                    if (A0I[2].length() != 18) {
                                        A0I[2] = "BDS58Myee4yHYxTG8mu";
                                        i0.A07(2);
                                    }
                                    throw new RuntimeException();
                                }
                                return;
                            }
                            if (this.A0F.A0B(c0692Hu.A01)) {
                                boolean z2 = false;
                                boolean z3 = false;
                                boolean z4 = false;
                                int A052 = this.A0F.A05(c0692Hu.A01);
                                if (c0692Hu.A08) {
                                    if (A0I[5].length() != 7) {
                                        String[] strArr3 = A0I;
                                        strArr3[6] = "E8pM94a91AlwBow9";
                                        strArr3[4] = "HP5p1w370WRNIPZM";
                                    } else {
                                        A0I[5] = "F8tLSSZzAzz";
                                    }
                                } else if (!this.A0F.A0B(1)) {
                                    return;
                                } else {
                                    z2 = this.A0F.A0A();
                                    if (z2) {
                                        if (!this.A0F.A0B(1)) {
                                            return;
                                        }
                                        z4 = this.A0F.A0A();
                                        z3 = true;
                                    }
                                }
                                boolean z5 = this.A01 == 5;
                                int i12 = 0;
                                if (z5) {
                                    if (!this.A0F.A09()) {
                                        return;
                                    }
                                    i12 = this.A0F.A04();
                                }
                                int i13 = 0;
                                int i14 = 0;
                                int i15 = 0;
                                int i16 = 0;
                                if (c0692Hu.A04 == 0) {
                                    if (!this.A0F.A0B(c0692Hu.A03)) {
                                        return;
                                    }
                                    i13 = this.A0F.A05(c0692Hu.A03);
                                    if (c0691Ht.A02 && !z2) {
                                        if (!this.A0F.A09()) {
                                            return;
                                        }
                                        i14 = this.A0F.A03();
                                    }
                                } else if (c0692Hu.A04 == 1 && !c0692Hu.A07) {
                                    if (!this.A0F.A09()) {
                                        return;
                                    }
                                    i15 = this.A0F.A03();
                                    if (c0691Ht.A02 && !z2) {
                                        if (!this.A0F.A09()) {
                                            return;
                                        }
                                        i16 = this.A0F.A03();
                                    }
                                }
                                this.A07.A04(c0692Hu, A05, A04, A052, A042, z2, z3, z4, z5, i12, i13, i14, i15, i16);
                                this.A08 = false;
                            }
                        }
                    }
                }
            }
        }
    }

    public D2(C4 c4, boolean z2, boolean z3) {
        this.A0E = c4;
        this.A0G = z2;
        this.A0H = z3;
        byte[] bArr = new byte[NotificationCompat.FLAG_HIGH_PRIORITY];
        this.A0B = bArr;
        this.A0F = new I0(bArr, 0, 0);
        A01();
    }

    private void A00(int i) {
        boolean z2 = this.A0A;
        this.A0E.AFS(this.A05, z2 ? 1 : 0, (int) (this.A02 - this.A04), i, null);
    }

    public final void A01() {
        this.A08 = false;
        this.A09 = false;
        this.A07.A02();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
        if (r0 != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A02(long r7, int r9) {
        /*
            r6 = this;
            int r1 = r6.A01
            r0 = 9
            r3 = 0
            r4 = 1
            if (r1 == r0) goto L16
            boolean r0 = r6.A0H
            if (r0 == 0) goto L4d
            com.facebook.ads.redexgen.X.D1 r1 = r6.A07
            com.facebook.ads.redexgen.X.D1 r0 = r6.A06
            boolean r0 = com.facebook.ads.redexgen.X.D1.A01(r1, r0)
            if (r0 == 0) goto L4d
        L16:
            boolean r5 = r6.A09
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.D2.A0I
            r0 = 0
            r1 = r2[r0]
            r0 = 1
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L30
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L30:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.D2.A0I
            java.lang.String r1 = "rg9RD6QhDdRr"
            r0 = 2
            r2[r0] = r1
            if (r5 == 0) goto L41
            long r0 = r6.A02
            long r7 = r7 - r0
            int r0 = (int) r7
            int r9 = r9 + r0
            r6.A00(r9)
        L41:
            long r0 = r6.A02
            r6.A04 = r0
            long r0 = r6.A03
            r6.A05 = r0
            r6.A0A = r3
            r6.A09 = r4
        L4d:
            boolean r2 = r6.A0A
            int r1 = r6.A01
            r0 = 5
            if (r1 == r0) goto L62
            boolean r0 = r6.A0G
            if (r0 == 0) goto L63
            if (r1 != r4) goto L63
            com.facebook.ads.redexgen.X.D1 r0 = r6.A07
            boolean r0 = r0.A05()
            if (r0 == 0) goto L63
        L62:
            r3 = 1
        L63:
            r2 = r2 | r3
            r6.A0A = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.D2.A02(long, int):void");
    }

    public final void A03(long j2, int i, long j4) {
        this.A01 = i;
        this.A03 = j4;
        this.A02 = j2;
        if (!this.A0G || i != 1) {
            if (!this.A0H) {
                return;
            }
            if (i != 5 && i != 1 && i != 2) {
                return;
            }
        }
        D1 d12 = this.A06;
        D1 newSliceHeader = this.A07;
        this.A06 = newSliceHeader;
        this.A07 = d12;
        d12.A02();
        this.A00 = 0;
        this.A08 = true;
    }

    public final void A04(C0691Ht c0691Ht) {
        this.A0C.append(c0691Ht.A00, c0691Ht);
    }

    public final void A05(C0692Hu c0692Hu) {
        this.A0D.append(c0692Hu.A05, c0692Hu);
    }

    public final boolean A07() {
        return this.A0H;
    }
}

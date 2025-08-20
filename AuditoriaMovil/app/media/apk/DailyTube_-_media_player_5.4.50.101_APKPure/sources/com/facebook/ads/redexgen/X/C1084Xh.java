package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.uv.v7.R;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Xh  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1084Xh implements InterfaceC0554Bs {
    public static byte[] A07;
    public static String[] A08 = {"ovn62aUcwqSIvWTqoELg4J4D8wHkUDmq", "Ycr5XQrqBi4bqXq", "xp8qJzBZ1bRZYruPJEcRAHgYPTR5RYjX", "i3q4o3QoTWkNmhcyfYOgrV6edePVNuRX", "3foLzBlJQPuSe9je9cnopJfCpNuQ", "jIofLs5qujimwrYxWQlB52zkZNTbvGhY", "Oin2hfMzoDcJa9P29jyigMxfd8hffyV", "DiUz7SyfwAQ"};
    public static final InterfaceC0557Bv A09;
    public static final int A0A;
    public static final byte[] A0B;
    public static final byte[] A0C;
    public static final int[] A0D;
    public static final int[] A0E;
    public int A00;
    public int A01;
    public long A02;
    public C4 A03;
    public boolean A04;
    public boolean A05;
    public final byte[] A06 = new byte[1];

    public static String A03(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            byte b2 = (byte) ((copyOfRange[i8] - i6) - 104);
            String[] strArr = A08;
            if (strArr[4].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            A08[7] = "o17bMTHd2bo";
            copyOfRange[i8] = b2;
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        byte[] bArr = {-89, -19, -7, -24, -12, -20, -89, -5, 0, -9, -20, -89, -65, -67, -35, -23, -18, -90, -17, -19, 13, 25, 30, -7, 35, 14, -42, 14, 58, 64, 55, 47, -21, 57, 58, 63, -21, 49, 52, 57, 47, -21, 12, 24, 29, -21, 51, 48, 44, 47, 48, 61, -7, 37, 72, 72, 65, 67, 61, 72, -4, 29, 41, 46, -4, 36, 73, 81, 60, 71, 68, 63, -5, 75, 60, 63, 63, 68, 73, 66, -5, 61, 68, 79, 78, -5, 65, 74, 77, -5, 65, 77, 60, 72, 64, -5, 67, 64, 60, 63, 64, 77, -5, -53, -65, -34, -55, 67, 87, 70, 75, 81, 17, 21, 73, 82, 82, -3, 17, 0, 5, 11, -53, -3, 9, 14, -55, 19, -2};
        if (A08[6].length() != 31) {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[0] = "iWdi7SFZoODeZbEJMl3L6ntPbKeDMNvO";
        strArr[2] = "0wFRuzGYIju4XbKNAoPYNxHAh615x32s";
        A07 = bArr;
    }

    static {
        A05();
        A09 = new C1085Xi();
        A0D = new int[]{13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        A0E = iArr;
        A0B = IF.A0i(A03(12, 6, 52));
        A0C = IF.A0i(A03(18, 9, 100));
        A0A = iArr[8];
    }

    private int A00(int i) throws C05059v {
        String A03;
        if (!A07(i)) {
            StringBuilder append = new StringBuilder().append(A03(53, 12, 116));
            if (!this.A05) {
                A03 = A03(103, 2, 21);
            } else if (A08[6].length() == 31) {
                A08[7] = "wEjTIiVmShi";
                A03 = A03(105, 2, 31);
            }
            throw new C05059v(append.append(A03).append(A03(0, 12, 31)).append(i).toString());
        } else if (this.A05) {
            return A0E[i];
        } else {
            int[] iArr = A0D;
            if (A08[6].length() == 31) {
                String[] strArr = A08;
                strArr[4] = "W5GqdpRCUv4UTAd2FZcqfYNQbOUH";
                strArr[1] = "vSYrWd8JkI4l23w";
                return iArr[i];
            }
        }
        throw new RuntimeException();
    }

    private int A01(InterfaceC0555Bt interfaceC0555Bt) throws IOException, InterruptedException {
        interfaceC0555Bt.AFM();
        interfaceC0555Bt.ADv(this.A06, 0, 1);
        byte b2 = this.A06[0];
        if ((b2 & 131) <= 0) {
            return A00((b2 >> 3) & 15);
        }
        throw new C05059v(A03(65, 38, R.styleable.AppCompatTheme_tooltipFrameBackground) + ((int) b2));
    }

    private int A02(InterfaceC0555Bt interfaceC0555Bt) throws IOException, InterruptedException {
        if (this.A00 == 0) {
            try {
                int A01 = A01(interfaceC0555Bt);
                this.A01 = A01;
                this.A00 = A01;
            } catch (EOFException unused) {
                return -1;
            }
        }
        int AFQ = this.A03.AFQ(interfaceC0555Bt, this.A00, true);
        if (AFQ == -1) {
            return -1;
        }
        int bytesAppended = this.A00 - AFQ;
        this.A00 = bytesAppended;
        if (bytesAppended > 0) {
            return 0;
        }
        this.A03.AFS(this.A02, 1, this.A01, 0, null);
        this.A02 += 20000;
        return 0;
    }

    private void A04() {
        if (!this.A04) {
            this.A04 = true;
            boolean z2 = this.A05;
            this.A03.A5n(Format.A06(null, z2 ? A03(117, 12, 52) : A03(107, 10, 122), null, -1, A0A, 1, z2 ? 16000 : 8000, -1, null, null, 0, null));
        }
    }

    private boolean A06(int i) {
        return !this.A05 && (i < 12 || i > 14);
    }

    private boolean A07(int i) {
        return i >= 0 && i <= 15 && (A08(i) || A06(i));
    }

    private boolean A08(int i) {
        if (this.A05) {
            if (i >= 10) {
                if (A08[6].length() != 31) {
                    throw new RuntimeException();
                }
                A08[5] = "qMGeUOCLNxoOBJxwE1u31s5i7NTepy4l";
                if (i > 13) {
                }
            }
            return true;
        }
        return false;
    }

    private boolean A09(InterfaceC0555Bt interfaceC0555Bt) throws IOException, InterruptedException {
        byte[] bArr = A0B;
        if (A0A(interfaceC0555Bt, bArr)) {
            this.A05 = false;
            interfaceC0555Bt.AGP(bArr.length);
            return true;
        }
        byte[] bArr2 = A0C;
        if (A0A(interfaceC0555Bt, bArr2)) {
            this.A05 = true;
            interfaceC0555Bt.AGP(bArr2.length);
            return true;
        }
        return false;
    }

    private boolean A0A(InterfaceC0555Bt interfaceC0555Bt, byte[] bArr) throws IOException, InterruptedException {
        interfaceC0555Bt.AFM();
        byte[] bArr2 = new byte[bArr.length];
        interfaceC0555Bt.ADv(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final void A8o(InterfaceC0556Bu interfaceC0556Bu) {
        interfaceC0556Bu.AFi(new C1086Xj(-9223372036854775807L));
        this.A03 = interfaceC0556Bu.AGi(0, 1);
        interfaceC0556Bu.A5Y();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final int AEH(InterfaceC0555Bt interfaceC0555Bt, C0559Bz c0559Bz) throws IOException, InterruptedException {
        if (interfaceC0555Bt.A7i() != 0 || A09(interfaceC0555Bt)) {
            A04();
            return A02(interfaceC0555Bt);
        }
        throw new C05059v(A03(27, 26, 99));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final void AFh(long j2, long j4) {
        this.A02 = 0L;
        this.A01 = 0;
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final boolean AGR(InterfaceC0555Bt interfaceC0555Bt) throws IOException, InterruptedException {
        return A09(interfaceC0555Bt);
    }
}

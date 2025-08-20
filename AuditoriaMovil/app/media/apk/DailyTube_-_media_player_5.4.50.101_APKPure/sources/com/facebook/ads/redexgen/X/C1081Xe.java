package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Xe  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1081Xe implements InterfaceC0554Bs {
    public static byte[] A0F;
    public static String[] A0G = {"QnLOeuXESrCaGCWmeMmr3ccgSJivirlh", "YhzsmTzzzxhtyY2gbPt9z7nrByNpJ8AG", "zwujZ5tU8kb2uxp5tp3MFQMZqwl6Xl8T", "kc6RUJmY0MGel4Ws9MlGHroinjQjp2AB", "ZiGWNZua4Zts1sNsjYBSU4OXsNo5k01z", "vZczIWNBPrLvTkXGahgR3lrPVHA61MAE", "WEnNwLMqAaXyN6vSaeVfRhJYgSEHaora", "u0NJWOpvT5UyzhfOPQB88kiisy6mVL7a"};
    public static final InterfaceC0557Bv A0H;
    public static final int A0I;
    public int A00;
    public int A02;
    public int A03;
    public long A05;
    public InterfaceC0556Bu A06;
    public C1083Xg A07;
    public C1078Xb A08;
    public boolean A09;
    public final C0697Hz A0C = new C0697Hz(4);
    public final C0697Hz A0B = new C0697Hz(9);
    public final C0697Hz A0E = new C0697Hz(11);
    public final C0697Hz A0D = new C0697Hz();
    public final C1080Xd A0A = new C1080Xd();
    public int A01 = 1;
    public long A04 = -9223372036854775807L;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0F, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 84);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A0F = new byte[]{-41, -35, -25};
    }

    static {
        A03();
        A0H = new C1082Xf();
        A0I = IF.A08(A01(0, 3, 61));
    }

    private C0697Hz A00(InterfaceC0555Bt interfaceC0555Bt) throws IOException, InterruptedException {
        if (this.A02 > this.A0D.A05()) {
            C0697Hz c0697Hz = this.A0D;
            c0697Hz.A0b(new byte[Math.max(c0697Hz.A05() * 2, this.A02)], 0);
        } else {
            this.A0D.A0Y(0);
        }
        this.A0D.A0X(this.A02);
        interfaceC0555Bt.readFully(this.A0D.A00, 0, this.A02);
        return this.A0D;
    }

    private void A02() {
        long j2;
        if (!this.A09) {
            this.A06.AFi(new C1086Xj(-9223372036854775807L));
            this.A09 = true;
        }
        if (this.A04 == -9223372036854775807L) {
            if (this.A0A.A0D() == -9223372036854775807L) {
                long j4 = this.A05;
                String[] strArr = A0G;
                if (strArr[5].charAt(20) != strArr[0].charAt(20)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0G;
                strArr2[7] = "L5UStG7DYoKpX710PXz3zQwSbfDogpGa";
                strArr2[6] = "NY6hXsIFzv8ItyXdU8z07IBZswL3MGXa";
                j2 = -j4;
            } else {
                j2 = 0;
            }
            this.A04 = j2;
        }
    }

    private void A04(InterfaceC0555Bt interfaceC0555Bt) throws IOException, InterruptedException {
        interfaceC0555Bt.AGP(this.A00);
        this.A00 = 0;
        this.A01 = 3;
    }

    private boolean A05(InterfaceC0555Bt interfaceC0555Bt) throws IOException, InterruptedException {
        if (interfaceC0555Bt.AEM(this.A0B.A00, 0, 9, true)) {
            this.A0B.A0Y(0);
            this.A0B.A0Z(4);
            int A0E = this.A0B.A0E();
            int flags = A0E & 4;
            boolean hasVideo = flags != 0;
            int flags2 = A0E & 1;
            boolean z2 = flags2 != 0;
            if (hasVideo && this.A07 == null) {
                this.A07 = new C1083Xg(this.A06.AGi(8, 1));
            }
            if (z2 && this.A08 == null) {
                this.A08 = new C1078Xb(this.A06.AGi(9, 2));
            }
            this.A06.A5Y();
            int flags3 = this.A0B.A08();
            this.A00 = (flags3 - 9) + 4;
            this.A01 = 2;
            return true;
        }
        return false;
    }

    private boolean A06(InterfaceC0555Bt interfaceC0555Bt) throws IOException, InterruptedException {
        boolean z2 = true;
        int i = this.A03;
        if (i == 8 && this.A07 != null) {
            A02();
            C1083Xg c1083Xg = this.A07;
            C0697Hz A00 = A00(interfaceC0555Bt);
            long j2 = this.A04;
            String[] strArr = A0G;
            if (strArr[2].charAt(9) == strArr[1].charAt(9)) {
                throw new RuntimeException();
            }
            A0G[4] = "14LyfFoDFqyov0bzU05kIxDiosYU9C09";
            c1083Xg.A00(A00, j2 + this.A05);
        } else if (i == 9 && this.A08 != null) {
            A02();
            this.A08.A00(A00(interfaceC0555Bt), this.A04 + this.A05);
        } else {
            if (i == 18) {
                boolean wasConsumed = this.A09;
                if (!wasConsumed) {
                    this.A0A.A00(A00(interfaceC0555Bt), this.A05);
                    long A0D = this.A0A.A0D();
                    if (A0D != -9223372036854775807L) {
                        this.A06.AFi(new C1086Xj(A0D));
                        this.A09 = true;
                    }
                }
            }
            interfaceC0555Bt.AGP(this.A02);
            z2 = false;
        }
        this.A00 = 4;
        this.A01 = 2;
        return z2;
    }

    private boolean A07(InterfaceC0555Bt interfaceC0555Bt) throws IOException, InterruptedException {
        if (interfaceC0555Bt.AEM(this.A0E.A00, 0, 11, true)) {
            this.A0E.A0Y(0);
            this.A03 = this.A0E.A0E();
            this.A02 = this.A0E.A0G();
            this.A05 = this.A0E.A0G();
            this.A05 = ((this.A0E.A0E() << 24) | this.A05) * 1000;
            this.A0E.A0Z(3);
            this.A01 = 4;
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final void A8o(InterfaceC0556Bu interfaceC0556Bu) {
        this.A06 = interfaceC0556Bu;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final int AEH(InterfaceC0555Bt interfaceC0555Bt, C0559Bz c0559Bz) throws IOException, InterruptedException {
        while (true) {
            switch (this.A01) {
                case 1:
                    if (A05(interfaceC0555Bt)) {
                        break;
                    } else {
                        return -1;
                    }
                case 2:
                    A04(interfaceC0555Bt);
                    break;
                case 3:
                    if (A07(interfaceC0555Bt)) {
                        break;
                    } else {
                        return -1;
                    }
                case 4:
                    if (!A06(interfaceC0555Bt)) {
                        break;
                    } else {
                        return 0;
                    }
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final void AFh(long j2, long j4) {
        this.A01 = 1;
        this.A04 = -9223372036854775807L;
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final boolean AGR(InterfaceC0555Bt interfaceC0555Bt) throws IOException, InterruptedException {
        interfaceC0555Bt.ADv(this.A0C.A00, 0, 3);
        this.A0C.A0Y(0);
        if (this.A0C.A0G() != A0I) {
            return false;
        }
        interfaceC0555Bt.ADv(this.A0C.A00, 0, 2);
        this.A0C.A0Y(0);
        if ((this.A0C.A0I() & 250) != 0) {
            return false;
        }
        interfaceC0555Bt.ADv(this.A0C.A00, 0, 4);
        this.A0C.A0Y(0);
        int dataOffset = this.A0C.A08();
        interfaceC0555Bt.AFM();
        interfaceC0555Bt.A3W(dataOffset);
        interfaceC0555Bt.ADv(this.A0C.A00, 0, 4);
        this.A0C.A0Y(0);
        int dataOffset2 = this.A0C.A08();
        return dataOffset2 == 0;
    }
}

package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class XA implements InterfaceC0554Bs {
    public static byte[] A04;
    public static String[] A05 = {"89ZAS4gKAvfsCOhGFLRndaPlzH5Jylu0", "WDj0w8iYShPhw5JkNLQVjMzFidij1YMB", "SZD8V9ebG6DMCxkEToUDQHseHkwYH45y", "flB69VC8Ebs69L5nDVZVAs6kLxLMfW9p", "Dc9Giep11FBAOEJK", "fiVRhSZcsaoyqUlEeIiHO4czNXpaN55t", "HHz5E2PDkz6p7na9zQig", "GASwop9kiLfFsL9tAHZWlbr16muWtU3x"};
    public static final InterfaceC0557Bv A06;
    public static final int A07;
    public boolean A00;
    public final long A01;
    public final X9 A02;
    public final C0697Hz A03;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 70);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-8, -13, -30};
        if (A05[3].charAt(6) != 'C') {
            throw new RuntimeException();
        }
        A05[6] = "Dcf";
    }

    static {
        A01();
        A06 = new XB();
        A07 = IF.A08(A00(0, 3, 105));
    }

    public XA() {
        this(0L);
    }

    public XA(long j2) {
        this.A01 = j2;
        this.A02 = new X9();
        this.A03 = new C0697Hz(2786);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final void A8o(InterfaceC0556Bu interfaceC0556Bu) {
        this.A02.A4p(interfaceC0556Bu, new DC(0, 1));
        interfaceC0556Bu.A5Y();
        interfaceC0556Bu.AFi(new C1086Xj(-9223372036854775807L));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final int AEH(InterfaceC0555Bt interfaceC0555Bt, C0559Bz c0559Bz) throws IOException, InterruptedException {
        int read = interfaceC0555Bt.read(this.A03.A00, 0, 2786);
        if (read == -1) {
            return -1;
        }
        this.A03.A0Y(0);
        this.A03.A0X(read);
        if (!this.A00) {
            this.A02.ADt(this.A01, true);
            this.A00 = true;
        }
        this.A02.A4R(this.A03);
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final void AFh(long j2, long j4) {
        this.A00 = false;
        this.A02.AFg();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final boolean AGR(InterfaceC0555Bt interfaceC0555Bt) throws IOException, InterruptedException {
        C0697Hz c0697Hz = new C0697Hz(10);
        int startPosition = 0;
        while (true) {
            interfaceC0555Bt.ADv(c0697Hz.A00, 0, 10);
            c0697Hz.A0Y(0);
            if (c0697Hz.A0G() != A07) {
                break;
            }
            c0697Hz.A0Z(3);
            int A0D = c0697Hz.A0D();
            startPosition += A0D + 10;
            interfaceC0555Bt.A3W(A0D);
        }
        interfaceC0555Bt.AFM();
        interfaceC0555Bt.A3W(startPosition);
        int syncBytes = startPosition;
        int i = 0;
        while (true) {
            interfaceC0555Bt.ADv(c0697Hz.A00, 0, 5);
            c0697Hz.A0Y(0);
            int headerPosition = c0697Hz.A0I();
            if (headerPosition != 2935) {
                i = 0;
                interfaceC0555Bt.AFM();
                syncBytes++;
                int headerPosition2 = syncBytes - startPosition;
                if (headerPosition2 >= 8192) {
                    return false;
                }
                interfaceC0555Bt.A3W(syncBytes);
            } else {
                i++;
                if (i >= 4) {
                    return true;
                }
                int headerPosition3 = AQ.A05(c0697Hz.A00);
                if (headerPosition3 == -1) {
                    return false;
                }
                interfaceC0555Bt.A3W(headerPosition3 - 5);
            }
        }
    }
}

package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class EL {
    public static byte[] A05;
    public static String[] A06 = {"ys79rflcZR", "JvXVVVa5NcPDQ", "Q89GAQFZPNwANkfCdiKH1gvUr6", "fZOyMOuChjfI9gOKYd90JCIRk18sz1rD", "OOW8UfRJew081BUdbBG5Pxzf0VO", "xPmLQSFy3SjaACTv6gu", "e8kFvK5VJCM4F", "4YvHW6"};
    public final InterfaceC0664Gr A00;
    public final InterfaceC0666Gt A01;
    public final InterfaceC0666Gt A02;
    public final HK A03;
    public final I3 A04;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            int i10 = (copyOfRange[i8] - i6) - 26;
            String[] strArr = A06;
            if (strArr[1].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            A06[5] = "z6hEl1VDyGriGJRg";
            copyOfRange[i8] = (byte) i10;
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{126, -115, Byte.MIN_VALUE, 124, -113, Byte.MIN_VALUE, 95, 124, -113, 124, 110, -124, -119, -122};
    }

    static {
        A01();
    }

    public EL(HK hk, InterfaceC0666Gt interfaceC0666Gt) {
        this(hk, interfaceC0666Gt, null, null, null);
    }

    public EL(HK hk, InterfaceC0666Gt interfaceC0666Gt, InterfaceC0666Gt interfaceC0666Gt2, InterfaceC0664Gr interfaceC0664Gr, I3 i32) {
        AbstractC0672Ha.A01(interfaceC0666Gt);
        this.A03 = hk;
        this.A02 = interfaceC0666Gt;
        this.A01 = interfaceC0666Gt2;
        this.A00 = interfaceC0664Gr;
        this.A04 = i32;
    }

    public final HK A02() {
        return this.A03;
    }

    public final C1038Vk A03(boolean z2) {
        InterfaceC0667Gu c1050Vw;
        InterfaceC0666Gt interfaceC0666Gt = this.A01;
        if (interfaceC0666Gt != null) {
            c1050Vw = interfaceC0666Gt.A4X();
        } else {
            c1050Vw = new C1050Vw();
        }
        if (z2) {
            return new C1038Vk(this.A03, C1051Vx.A02, c1050Vw, null, 1, null);
        }
        if (0 != 0) {
            throw new NullPointerException(A00(0, 14, 1));
        }
        C1039Vl c1039Vl = new C1039Vl(this.A03, 2097152L);
        InterfaceC0667Gu A4X = this.A02.A4X();
        I3 i32 = this.A04;
        if (i32 != null) {
            A4X = new C1043Vp(A4X, i32, -1000);
        }
        InterfaceC0667Gu upstream = c1050Vw;
        return new C1038Vk(this.A03, A4X, upstream, c1039Vl, 1, null);
    }

    public final I3 A04() {
        I3 i32 = this.A04;
        return i32 != null ? i32 : new I3();
    }
}

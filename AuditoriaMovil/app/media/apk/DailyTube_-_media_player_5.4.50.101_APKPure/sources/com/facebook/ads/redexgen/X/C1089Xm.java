package com.facebook.ads.redexgen.X;

import java.lang.reflect.Constructor;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Xm  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1089Xm implements InterfaceC0557Bv {
    public static byte[] A06;
    public static final Constructor<? extends InterfaceC0554Bs> A07;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05 = 1;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 120);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{38, 83, 83, 80, 83, 1, 74, 79, 84, 85, 66, 79, 85, 74, 66, 85, 74, 79, 72, 1, 39, 45, 34, 36, 1, 70, 89, 85, 70, 79, 84, 74, 80, 79, 42, 67, 58, 77, 69, 58, 56, 73, 58, 57, -11, 58, 71, 71, 68, 71, -11, 56, 71, 58, 54, 73, 62, 67, 60, -11, 27, 33, 22, 24, -11, 58, 77, 73, 71, 54, 56, 73, 68, 71, 24, 36, 34, -29, 27, 22, 24, 26, 23, 36, 36, 32, -29, 22, 25, 40, -29, 30, 35, 41, 26, 39, 35, 22, 33, -29, 26, 45, 36, 37, 33, 22, 46, 26, 39, -25, -29, 26, 45, 41, -29, 27, 33, 22, 24, -29, -5, 33, 22, 24, -6, 45, 41, 39, 22, 24, 41, 36, 39};
    }

    static {
        A01();
        Constructor<? extends InterfaceC0554Bs> constructor = null;
        try {
            constructor = Class.forName(A00(74, 59, 61)).asSubclass(InterfaceC0554Bs.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException unused) {
        } catch (Exception e2) {
            throw new RuntimeException(A00(0, 34, 105), e2);
        }
        A07 = constructor;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0557Bv
    public final synchronized InterfaceC0554Bs[] A4b() {
        InterfaceC0554Bs[] extractors;
        Constructor<? extends InterfaceC0554Bs> constructor = A07;
        extractors = new InterfaceC0554Bs[constructor == null ? 12 : 13];
        extractors[0] = new XX(this.A01);
        extractors[1] = new XN(this.A00);
        extractors[2] = new XL(this.A03);
        extractors[3] = new XU(this.A02);
        extractors[4] = new X7();
        extractors[5] = new XA();
        extractors[6] = new C1065Wo(this.A05, this.A04);
        extractors[7] = new C1081Xe();
        extractors[8] = new XF();
        extractors[9] = new C1071Wu();
        extractors[10] = new C1063Wm();
        extractors[11] = new C1084Xh();
        if (constructor != null) {
            try {
                extractors[12] = constructor.newInstance(new Object[0]);
            } catch (Exception e2) {
                throw new IllegalStateException(A00(34, 40, 93), e2);
            }
        }
        return extractors;
    }
}

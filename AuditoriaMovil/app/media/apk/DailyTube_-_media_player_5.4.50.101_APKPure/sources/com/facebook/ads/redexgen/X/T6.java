package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class T6 extends KT {
    public static byte[] A02;
    public static String[] A03 = {"4qrMQlq4f90xl1sy4BzZM", "TcWoGCf457Qot5JyT1l2C", "saLQkhnkoxI5nJaIrtjAxQtmEyR3", "z6v9quSHtiIGt9EK5mEYj706uJD6", "bFad0nk8xPS9ndShlqLlSujGxs36pdRI", "6trDbbUtZicDuXYkeWIP0roMCqYrQYo", "jn4cH53pZ3UPJni0h7BbN5PLusC2Bi2v", "yFv6h44bSGU1wJ6ZfOcWL3O4oMR1XmQT"};
    public final /* synthetic */ T4 A00;
    public final /* synthetic */ AnonymousClass93 A01;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            int i10 = (copyOfRange[i8] - i6) - 118;
            if (A03[5].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[0] = "MzDMZ7tTu5yBCDFfOWXXt";
            strArr[1] = "2jCL4DZ8aFTQz1DFqzIUv";
            copyOfRange[i8] = (byte) i10;
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-68, -17, -32, -32, -33, -20, -29, -24, -31, -102, -29, -24, -34, -33, -32, -29, -24, -29, -18, -33, -26, -13};
    }

    static {
        A02();
    }

    public T6(T4 t4, AnonymousClass93 anonymousClass93) {
        this.A00 = t4;
        this.A01 = anonymousClass93;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        SA sa;
        SA sa2;
        InterfaceC0876Pd interfaceC0876Pd;
        sa = this.A00.A0I;
        if (sa.getState() == RB.A02) {
            sa2 = this.A00.A0I;
            if (sa2.getCurrentPositionInMillis() == A00()) {
                interfaceC0876Pd = this.A00.A0F;
                interfaceC0876Pd.ADX(A00(0, 22, 4));
            }
        }
    }
}

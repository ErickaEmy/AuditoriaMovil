package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.view.View;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.4Y  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C4Y {
    public static byte[] A03;
    public int A00;
    public final Rect A01;
    public final AbstractC03824o A02;

    static {
        A04();
    }

    public static String A03(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 54);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A03 = new byte[]{84, 83, 75, 92, 81, 84, 89, 29, 82, 79, 84, 88, 83, 73, 92, 73, 84, 82, 83};
    }

    public abstract int A06();

    public abstract int A07();

    public abstract int A08();

    public abstract int A09();

    public abstract int A0A();

    public abstract int A0B();

    public abstract int A0C(View view);

    public abstract int A0D(View view);

    public abstract int A0E(View view);

    public abstract int A0F(View view);

    public abstract int A0G(View view);

    public abstract int A0H(View view);

    public abstract void A0J(int i);

    public C4Y(AbstractC03824o abstractC03824o) {
        this.A00 = Integer.MIN_VALUE;
        this.A01 = new Rect();
        this.A02 = abstractC03824o;
    }

    public /* synthetic */ C4Y(AbstractC03824o abstractC03824o, C1140Zm c1140Zm) {
        this(abstractC03824o);
    }

    public static C1140Zm A00(AbstractC03824o abstractC03824o) {
        return new C1140Zm(abstractC03824o);
    }

    public static C1139Zl A01(AbstractC03824o abstractC03824o) {
        return new C1139Zl(abstractC03824o);
    }

    public static C4Y A02(AbstractC03824o abstractC03824o, int i) {
        switch (i) {
            case 0:
                return A00(abstractC03824o);
            case 1:
                return A01(abstractC03824o);
            default:
                throw new IllegalArgumentException(A03(0, 19, 11));
        }
    }

    public final int A05() {
        if (Integer.MIN_VALUE == this.A00) {
            return 0;
        }
        return A0B() - this.A00;
    }

    public final void A0I() {
        this.A00 = A0B();
    }
}

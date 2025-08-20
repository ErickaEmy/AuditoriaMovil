package com.facebook.ads.redexgen.X;

import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public abstract class C8 extends AbstractC1092Xp<C5, AbstractC0553Br, C0637Fp> implements WL {
    public static byte[] A01;
    public final String A00;

    static {
        A0J();
    }

    public static String A0I(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 67);
        }
        return new String(copyOfRange);
    }

    public static void A0J() {
        A01 = new byte[]{-68, -43, -52, -33, -41, -52, -54, -37, -52, -53, -121, -53, -52, -54, -42, -53, -52, -121, -52, -39, -39, -42, -39};
    }

    public abstract InterfaceC0636Fo A0b(byte[] bArr, int i, boolean z2) throws C0637Fp;

    public C8(String str) {
        super(new C5[2], new AbstractC0553Br[2]);
        this.A00 = str;
        A0Y(1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.6Q] */
    @Override // com.facebook.ads.redexgen.X.AbstractC1092Xp
    /* renamed from: A0E */
    public final C6Q A0V() {
        return new AbstractC0553Br(this) { // from class: com.facebook.ads.redexgen.X.6Q
            public final C8 A00;

            {
                this.A00 = this;
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC0553Br
            public final void A08() {
                this.A00.A0c(this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC1092Xp
    /* renamed from: A0F */
    public final C0637Fp A0W(C5 c52, AbstractC0553Br abstractC0553Br, boolean z2) {
        try {
            ByteBuffer inputData = c52.A01;
            abstractC0553Br.A09(((C1094Xr) c52).A00, A0b(inputData.array(), inputData.limit(), z2), c52.A00);
            abstractC0553Br.A01(Integer.MIN_VALUE);
            return null;
        } catch (C0637Fp e2) {
            return e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC1092Xp
    /* renamed from: A0G */
    public final C0637Fp A0X(Throwable th) {
        return new C0637Fp(A0I(0, 23, 36), th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC1092Xp
    /* renamed from: A0H */
    public final C5 A0T() {
        return new C5();
    }

    public final void A0c(AbstractC0553Br abstractC0553Br) {
        super.A0a(abstractC0553Br);
    }

    @Override // com.facebook.ads.redexgen.X.WL
    public final void AGB(long j2) {
    }
}

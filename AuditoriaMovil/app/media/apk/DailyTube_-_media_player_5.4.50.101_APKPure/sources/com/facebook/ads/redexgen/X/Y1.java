package com.facebook.ads.redexgen.X;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class Y1 implements InterfaceC0511Ab {
    public boolean A04;
    public boolean A05;
    public int[] A06;
    public int[] A07;
    public ByteBuffer A02 = InterfaceC0511Ab.A00;
    public ByteBuffer A03 = InterfaceC0511Ab.A00;
    public int A00 = -1;
    public int A01 = -1;

    public final void A00(int[] iArr) {
        this.A07 = iArr;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final boolean A4Q(int i, int i5, int i6) throws C0510Aa {
        boolean z2 = !Arrays.equals(this.A07, this.A06);
        int[] iArr = this.A07;
        this.A06 = iArr;
        if (iArr == null) {
            this.A04 = false;
            return z2;
        } else if (i6 == 2) {
            if (!z2 && this.A01 == i && this.A00 == i5) {
                return false;
            }
            this.A01 = i;
            this.A00 = i5;
            boolean outputChannelsChanged = i5 != iArr.length;
            this.A04 = outputChannelsChanged;
            int i8 = 0;
            while (true) {
                int[] iArr2 = this.A06;
                if (i8 >= iArr2.length) {
                    return true;
                }
                int i10 = iArr2[i8];
                if (i10 < i5) {
                    boolean z3 = this.A04;
                    boolean outputChannelsChanged2 = i10 != i8;
                    this.A04 = z3 | outputChannelsChanged2;
                    i8++;
                } else {
                    throw new C0510Aa(i, i5, i6);
                }
            }
        } else {
            throw new C0510Aa(i, i5, i6);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final ByteBuffer A7W() {
        ByteBuffer byteBuffer = this.A03;
        ByteBuffer outputBuffer = InterfaceC0511Ab.A00;
        this.A03 = outputBuffer;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final int A7X() {
        int[] iArr = this.A06;
        return iArr == null ? this.A00 : iArr.length;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final int A7Y() {
        return 2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final int A7Z() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final boolean A8w() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final boolean A91() {
        return this.A05 && this.A03 == InterfaceC0511Ab.A00;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final void AEE() {
        this.A05 = true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final void AEF(ByteBuffer byteBuffer) {
        int[] iArr;
        AbstractC0672Ha.A04(this.A06 != null);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int position2 = this.A00;
        int i = (limit - position) / (position2 * 2);
        int position3 = this.A06.length;
        int i5 = position3 * i * 2;
        int position4 = this.A02.capacity();
        if (position4 < i5) {
            this.A02 = ByteBuffer.allocateDirect(i5).order(ByteOrder.nativeOrder());
        } else {
            this.A02.clear();
        }
        while (position < limit) {
            for (int position5 : this.A06) {
                this.A02.putShort(byteBuffer.getShort((position5 * 2) + position));
            }
            int position6 = this.A00;
            position += position6 * 2;
        }
        byteBuffer.position(limit);
        this.A02.flip();
        this.A03 = this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final void flush() {
        this.A03 = InterfaceC0511Ab.A00;
        this.A05 = false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final void reset() {
        flush();
        this.A02 = InterfaceC0511Ab.A00;
        this.A00 = -1;
        this.A01 = -1;
        this.A06 = null;
        this.A07 = null;
        this.A04 = false;
    }
}

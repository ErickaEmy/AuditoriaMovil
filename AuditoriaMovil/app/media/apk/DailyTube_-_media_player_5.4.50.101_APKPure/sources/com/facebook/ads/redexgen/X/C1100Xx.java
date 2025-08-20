package com.facebook.ads.redexgen.X;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* renamed from: com.facebook.ads.redexgen.X.Xx  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1100Xx implements InterfaceC0511Ab {
    public static String[] A06 = {"ah04u6Q1dWL1egRXsMbkKPPKVNg3n80Y", "1r3Xl", "QdGXgsTRn6hV21sTZ0R1NqLOMYSBKtb", "W5J07OSQmEt2BpZCmOH8LkruncIVNrBM", "eos", "Srtad58bv8C1EQlDg1Sg05LzKtWehsxy", "6l07m1yopJeFlxaeyKeGX2bioVISysWk", "EvvDtS6FF2cIgMDn1y2HucXqTtg4jIlT"};
    public static final int A07 = Float.floatToIntBits(Float.NaN);
    public boolean A05;
    public int A01 = -1;
    public int A00 = -1;
    public int A02 = 0;
    public ByteBuffer A03 = InterfaceC0511Ab.A00;
    public ByteBuffer A04 = InterfaceC0511Ab.A00;

    public static void A00(int i, ByteBuffer byteBuffer) {
        float pcm32BitFloat = (float) (i * 4.656612875245797E-10d);
        int floatBits = Float.floatToIntBits(pcm32BitFloat);
        if (floatBits == A07) {
            String[] strArr = A06;
            if (strArr[3].charAt(25) == strArr[0].charAt(25)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[3] = "4Wp1fSxBSz27MSPaqgAWdYVJBUm2UDMg";
            strArr2[0] = "ROimvzAXRxuGV4aswmxntShxO5JnpSBy";
            floatBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatBits);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final boolean A4Q(int i, int i5, int i6) throws C0510Aa {
        if (IF.A0b(i6)) {
            if (this.A01 == i && this.A00 == i5 && this.A02 == i6) {
                return false;
            }
            this.A01 = i;
            this.A00 = i5;
            this.A02 = i6;
            return true;
        }
        throw new C0510Aa(i, i5, i6);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final ByteBuffer A7W() {
        ByteBuffer byteBuffer = this.A04;
        ByteBuffer outputBuffer = InterfaceC0511Ab.A00;
        this.A04 = outputBuffer;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final int A7X() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final int A7Y() {
        return 4;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final int A7Z() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final boolean A8w() {
        return IF.A0b(this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final boolean A91() {
        if (this.A05) {
            ByteBuffer byteBuffer = this.A04;
            String[] strArr = A06;
            if (strArr[5].charAt(19) == strArr[7].charAt(19)) {
                throw new RuntimeException();
            }
            A06[6] = "qfZMyeN6d8pBtgFrDPBavvok2D4WqpK2";
            if (byteBuffer == InterfaceC0511Ab.A00) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final void AEE() {
        this.A05 = true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final void AEF(ByteBuffer byteBuffer) {
        int resampledSize = this.A02 == 1073741824 ? 1 : 0;
        int size = byteBuffer.position();
        int limit = byteBuffer.limit();
        int position = limit - size;
        if (resampledSize == 0) {
            position = (position / 3) * 4;
        }
        if (this.A03.capacity() < position) {
            this.A03 = ByteBuffer.allocateDirect(position).order(ByteOrder.nativeOrder());
        } else {
            this.A03.clear();
        }
        if (resampledSize != 0) {
            while (size < limit) {
                int position2 = byteBuffer.get(size) & 255;
                if (A06[6].charAt(28) == 102) {
                    throw new RuntimeException();
                }
                String[] strArr = A06;
                strArr[5] = "tg0osbUMfAK2L8b7LXggWdc0GJyIN6RO";
                strArr[7] = "LN5IASfbHFxc5GOwRpJRg3zlfXbH1jQ8";
                A00(position2 | ((byteBuffer.get(size + 1) & 255) << 8) | ((byteBuffer.get(size + 2) & 255) << 16) | ((byteBuffer.get(size + 3) & 255) << 24), this.A03);
                size += 4;
            }
        } else {
            while (size < limit) {
                A00(((byteBuffer.get(size) & 255) << 8) | ((byteBuffer.get(size + 1) & 255) << 16) | ((byteBuffer.get(size + 2) & 255) << 24), this.A03);
                size += 3;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        this.A03.flip();
        this.A04 = this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final void flush() {
        this.A04 = InterfaceC0511Ab.A00;
        this.A05 = false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0511Ab
    public final void reset() {
        flush();
        this.A01 = -1;
        this.A00 = -1;
        this.A02 = 0;
        this.A03 = InterfaceC0511Ab.A00;
    }
}

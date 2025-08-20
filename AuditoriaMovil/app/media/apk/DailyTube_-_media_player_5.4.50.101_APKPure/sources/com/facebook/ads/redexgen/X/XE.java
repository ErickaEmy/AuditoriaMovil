package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.uv.v7.R;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class XE extends AbstractC0573Co {
    public static byte[] A01;
    public static String[] A02 = {"sf1snlIsJ6W0T2FnClxHrZdECoWprGfm", "N", "", "r2HEyqcTBk5ynLpIwHNeKGT5pvsr0hUz", "VJBF4MChRorpvGWaO0TH3IkbIinT6ci", "gVX", "V2gxFGplaBAwDTpDKBzIrO8nmlXbG3Ru", "XRqJkaMKHgiwUJro7qWKl9bCL3sckU6K"};
    public static final int A03;
    public static final byte[] A04;
    public boolean A00;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 10);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{42, 21, 16, 22, 79, 91, 74, 71, 65, 1, 65, 94, 91, 93};
    }

    static {
        A02();
        A03 = IF.A08(A01(0, 4, R.styleable.AppCompatTheme_textColorSearchUrl));
        A04 = new byte[]{79, 112, 117, 115, 72, 101, 97, 100};
    }

    private long A00(byte[] bArr) {
        int i;
        int i5;
        int frames = bArr[0] & 255;
        int toc = frames & 3;
        switch (toc) {
            case 0:
                i = 1;
                break;
            case 1:
            case 2:
                i = 2;
                break;
            default:
                int toc2 = bArr[1];
                i = toc2 & 63;
                break;
        }
        int frames2 = frames >> 3;
        int i6 = frames2 & 3;
        if (frames2 >= 16) {
            if (A02[5].length() != 3) {
                throw new RuntimeException();
            }
            A02[5] = "Fg3";
            i5 = 2500 << i6;
        } else if (frames2 >= 12) {
            int toc3 = i6 & 1;
            i5 = 10000 << toc3;
        } else if (A02[2].length() == 12) {
            throw new RuntimeException();
        } else {
            A02[2] = "pnsJXiCpejNcXc3iNsNdzofu9hZ";
            if (i6 == 3) {
                i5 = 60000;
            } else {
                i5 = 10000 << i6;
            }
        }
        return i * i5;
    }

    private void A03(List<byte[]> initializationData, int i) {
        initializationData.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((i * 1000000000) / 48000).array());
    }

    public static boolean A04(C0697Hz c0697Hz) {
        int A042 = c0697Hz.A04();
        byte[] bArr = A04;
        if (A042 < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        c0697Hz.A0c(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0573Co
    public final long A07(C0697Hz c0697Hz) {
        return A04(A00(c0697Hz.A00));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0573Co
    public final void A09(boolean z2) {
        super.A09(z2);
        if (z2) {
            this.A00 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0573Co
    public final boolean A0A(C0697Hz c0697Hz, long j2, C0572Cn c0572Cn) throws IOException, InterruptedException {
        if (!this.A00) {
            byte[] copyOf = Arrays.copyOf(c0697Hz.A00, c0697Hz.A07());
            int i = copyOf[9] & 255;
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(copyOf);
            A03(arrayList, ((copyOf[11] & 255) << 8) | (copyOf[10] & 255));
            A03(arrayList, 3840);
            c0572Cn.A00 = Format.A07(null, A01(4, 10, 36), null, -1, -1, i, 48000, arrayList, null, 0, null);
            this.A00 = true;
            return true;
        }
        boolean z2 = c0697Hz.A08() == A03;
        c0697Hz.A0Y(0);
        return z2;
    }
}

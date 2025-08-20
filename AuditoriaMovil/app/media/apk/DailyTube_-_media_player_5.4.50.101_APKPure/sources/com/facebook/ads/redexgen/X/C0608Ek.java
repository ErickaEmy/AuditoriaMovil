package com.facebook.ads.redexgen.X;

import android.net.Uri;
import com.uv.v7.R;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Ek  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0608Ek {
    public static byte[] A03;
    public static String[] A04 = {"UShKNNFg87kJKFq9zZ4MXrM1TZqBqByP", "bNbNgwYs44UALuoZhh", "UOZFjFwmfZ6Uk9K0z0C", "pvrkJysKsIVU", "ICsDSmeasSqv6BvMkmxncpzNQ0k3b5KN", "yTEFvUo2j", "amPx4bchTjSSxZ8pJApIWlQt7YwmxhXF", "zL4iYMzloDmr1aHfk19k2KMtR5ocnLoy"};
    public InterfaceC0554Bs A00;
    public final InterfaceC0556Bu A01;
    public final InterfaceC0554Bs[] A02;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 47);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        String[] strArr = A04;
        if (strArr[6].charAt(23) != strArr[7].charAt(23)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[2] = "BFR1v4rNBeEaqGbowcf";
        strArr2[5] = "QYASgTnFJ";
        A03 = new byte[]{-52, -61, 6, 18, 24, 15, 7, -61, 21, 8, 4, 7, -61, 23, 11, 8, -61, 22, 23, 21, 8, 4, 16, -47, -17, 16, 15, 6, -63, 16, 7, -63, 21, 9, 6, -63, 2, 23, 2, 10, 13, 2, 3, 13, 6, -63, 6, 25, 21, 19, 2, 4, 21, 16, 19, 20, -63, -55};
    }

    static {
        A01();
    }

    public C0608Ek(InterfaceC0554Bs[] interfaceC0554BsArr, InterfaceC0556Bu interfaceC0556Bu) {
        this.A02 = interfaceC0554BsArr;
        this.A01 = interfaceC0556Bu;
    }

    public final InterfaceC0554Bs A02(InterfaceC0555Bt interfaceC0555Bt, Uri uri) throws IOException, InterruptedException {
        InterfaceC0554Bs interfaceC0554Bs = this.A00;
        if (interfaceC0554Bs != null) {
            return interfaceC0554Bs;
        }
        InterfaceC0554Bs[] interfaceC0554BsArr = this.A02;
        int length = interfaceC0554BsArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            InterfaceC0554Bs interfaceC0554Bs2 = interfaceC0554BsArr[i];
            try {
            } catch (EOFException unused) {
            } catch (Throwable th) {
                interfaceC0555Bt.AFM();
                throw th;
            }
            if (interfaceC0554Bs2.AGR(interfaceC0555Bt)) {
                this.A00 = interfaceC0554Bs2;
                interfaceC0555Bt.AFM();
                break;
            }
            continue;
            interfaceC0555Bt.AFM();
            i++;
        }
        InterfaceC0554Bs interfaceC0554Bs3 = this.A00;
        if (interfaceC0554Bs3 != null) {
            interfaceC0554Bs3.A8o(this.A01);
            return this.A00;
        }
        throw new WM(A00(24, 34, R.styleable.AppCompatTheme_tooltipForegroundColor) + IF.A0S(this.A02) + A00(0, 24, 116), uri);
    }

    public final void A03() {
        if (this.A00 != null) {
            this.A00 = null;
        }
    }
}
